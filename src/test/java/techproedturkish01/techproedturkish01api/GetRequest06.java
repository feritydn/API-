package techproedturkish01.techproedturkish01api;

import org.junit.Test;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequest06 extends TestBase {
    /*
	 When I send a GET request to REST API URL
		https://restful-booker.herokuapp.com/booking/5
	    Then HTTP Status Code should be 200
	    And response content type is “application/JSON”
	    And response body should be like;
	    {
		    “firstname”: “Ricky”,
		    “lastname”: “Jones”,
		    “totalprice”: 249,
		    “depositpaid”: false,
		    “bookingdates”: {
		        “checkin”: “2016-04-18",
		        “checkout”: “2016-11-15"
		     }
	 */

         @Test
    public void get01(){
        Response response = given().
                             spec(spec01).
                             when().
                             get("/booking/5");
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("Eric"),
                        "lastname",equalTo("Brown"),
                        "totalprice",equalTo(552),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin", equalTo("2019-04-23"),
                        "bookingdates.checkout", equalTo("2019-09-03"));


    }

}
