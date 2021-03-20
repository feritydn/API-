package techproedturkish01.techproedturkish01api;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequest05 {
    /*
            When I send a get request to Rest Api Url
           "https://restful-booker.herokuapp.com/booking/5"
            And accept Type is "application/JSON"
            Then
           HTTP status code shulde be 200
           And response format sheuld be "application/JSON"
           And firstname should be "Jim"
           And "totalprice" sholud be 602
           And "checkin" should be "2015-06-12"
     */

    @Test
    public void get01(){
        Response response = given().
                                when().
                                get("https://restful-booker.herokuapp.com/booking/5");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",Matchers.equalTo("Eric"),
                        "totalprice",Matchers.equalTo(550),
                       "bookingdates.checkin" ,Matchers.equalTo("2016-10-30"));
    }
}
