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


public class PostRequest04 extends TestBase{

     /*Request Body
         *  { "firstname":"Suleyman",
         *  "lastname": "Alptekin",
         *  "totalprice": 123,
         *  "depositpaid": true,
         * "bookingdates": {
         *  "checkin": "2020-05-02",
         *  "checkout": "2020-05-05" },
         * "additionalneeds": "Wifi" }

      */
    @Test
    public void post01(){
        BookingDates bookingDates = new BookingDates("2020-05-02", "2020-05-05");
        Booking booking = new Booking
                ("Suleyman","Alptekin",123,true,bookingDates,"Wifi");
        Response response = given().
                                contentType(ContentType.JSON).
                                spec(spec01).
                                auth().
                                basic("admin","password123").
                                body(booking).
                            when().
                                post("/booking");
        response.
                then().
                assertThat().
                statusCode(200);
        JsonPath json = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(json.getString("booking.firstname"),booking.getFirstname(),"firstname is not as expected");
        softAssert.assertEquals(json.getString("booking.lastname"),booking.getLastname(),"lastname is not as expected");
        softAssert.assertEquals(json.getString("booking.totalprice"),booking.getTotalprice().toString(),"total price is not as expected");
        softAssert.assertEquals(json.getString("booking.depositpaid"),booking.getDepositpaid().toString(),"deposit paid is not as expected");
        softAssert.assertEquals(json.getString("booking.bookingdates.checkin"),bookingDates.getCheckin(),"checkin is not as expected");
        softAssert.assertEquals(json.getString("booking.bookingdates.checkout"),bookingDates.getCheckout(),"checkaut is not as expected");
        softAssert.assertEquals(json.getString("booking.additionalneeds"),booking.getAdditionalneeds(),"additional needs is not as expected");
        softAssert.assertAll();
    }

}
