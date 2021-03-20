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

public class PojoEx extends TestBase{

    /*Request Body
     *  { "firstname":"Ali",
     *  "lastname": "Ahmet",
     *  "totalprice": 500,
     *  "depositpaid": false,
     * "bookingdates": {
     *  "checkin": "2021-05-05",
     *  "checkout": "2021-05-08" },
     * "additionalneeds": "Breakfast" }

     */

    @Test
    public void ex01(){
        BookingDates bookingDates = new BookingDates("2021-05-05","2021-05-08");
        Booking booking = new Booking("Ali","Ahmet",500,false,bookingDates,"Breakfast");

        Response response = given().
                                contentType(ContentType.JSON).
                                spec(spec01).
                                auth().
                                basic("admin","password123").
                                body(booking).
                            when().
                                post("/booking");
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200);
        SoftAssert softAssert = new SoftAssert();
        JsonPath json = response.jsonPath();
        softAssert.assertEquals(json.getString("booking.firstname"),booking.getFirstname(),"firstname is not as expected");
        softAssert.assertEquals(json.getString("booking.lastname"),booking.getLastname(),"lastname is not as expected");
        softAssert.assertEquals(json.getString("booking.totalprice"),booking.getTotalprice().toString(),"total price is not as expected");
        softAssert.assertEquals(json.getString("booking.depositpaid"),booking.getDepositpaid().toString(),"deposit paid is not as expected");
        softAssert.assertEquals(json.getString("booking.bookingdates.checkin"),booking.getBookingdates().getCheckin(),"checkin is not as expected");
        softAssert.assertEquals(json.getString("booking.bookingdates.checkout"),booking.getBookingdates().getCheckout(),"checkout is not as expected");
        softAssert.assertEquals(json.getString("booking.additionalneeds"),booking.getAdditionalneeds(),"additional needs is not as expected");
        softAssert.assertAll();
    }
}
