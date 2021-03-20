package techproedturkish01.techproedturkish01api;

import io.restassured.path.json.JsonPath;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.json.JSONObject;
import org.junit.Test;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.*;

public class PostRequest02 extends TestBase {

    /*
     * POST Scenario:
     * Accept type Json olsun When POST request yolladigimda
     * 1) https://restful-booker.herokuapp.com/booking
     *  2) Request Body
     *  { "firstname":"Suleyman",
     *  "lastname": "Alptekin",
     *  "totalprice": 123,
     *  "depositpaid": true,
     * "bookingdates": {
     *  "checkin": "2020-05-02",
     *  "checkout": "2020-05-05" },
     * "additionalneeds": "Wifi" }
     * Then
     * Status Code 200 olmali
     * Response Bodynin , Request Body ile ayni oldugunu verify ediniz.
     */

    @Test
    public void post01(){
        Response response = createRequestBodyByJsonObjectClass();
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200);
        JsonPath json = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(json.getString("booking.firstname"),jsonrequestBody.get("firstname"),"firstname is not as expected");
        softAssert.assertEquals(json.getString("booking.lastname"),jsonrequestBody.get("lastname"),"lastname is not as expected");
        softAssert.assertEquals(json.getString("booking.totalprice"),jsonrequestBody.get("totalprice").toString(),"total price is not as expected");
        softAssert.assertEquals(json.getString("booking.depositpaid"),jsonrequestBody.get("depositpaid").toString(),"deposit paid is not as expected");
        softAssert.assertEquals(json.getString("booking.bookingdates.checkin"),jsonBookingDateBody.get("checkin"),"checkin is not as expected");
        softAssert.assertEquals(json.getString("booking.bookingdates.checkout"),jsonBookingDateBody.get("checkout"),"checkaut is not as expected");
        softAssert.assertEquals(json.getString("booking.additionalneeds"),jsonrequestBody.get("additionalneeds"),"additional needs is not as expected");
        softAssert.assertAll();
    }

}
