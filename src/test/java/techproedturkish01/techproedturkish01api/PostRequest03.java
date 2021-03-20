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

public class PostRequest03 extends TestBase {

    @Test
    public void post01(){
        Response response = createRequestBodyByMap();
        response.
                then().
                assertThat().
                statusCode(200);
        JsonPath json = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(json.getString("booking.firstname"),requestBodyMap.get("firstname"),"firstname is not as expected");
        softAssert.assertEquals(json.getString("booking.lastname"), requestBodyMap.get("lastname"), "lastname is not as expected");
        softAssert.assertEquals(json.getString("booking.totalprice"),requestBodyMap.get("totalprice").toString(),"total price is not as expected");
        softAssert.assertEquals(json.getString("booking.depositpaid"),requestBodyMap.get("depositpaid").toString(),"deposit paid is not as expected");
        softAssert.assertEquals(json.getString("booking.bookingdates.checkin"),bookingDatesMap.get("checkin"),"checkin is not as expected");
        softAssert.assertEquals(json.getString("booking.bookingdates.checkout"),bookingDatesMap.get("checkout"),"checkaut is not as expected");
        softAssert.assertEquals(json.getString("booking.additionalneeds"),requestBodyMap.get("additionalneeds"),"additional needs is not as expected");
        softAssert.assertAll();

    }
}
