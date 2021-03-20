package techproedturkish01.techproedturkish01api;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequest03 {
    /*
    When I send a get request to Rest Api Url
    "https://restful-booker.herokuapp.com/booking/1"
    And accept Type is "application/JSON"
    Then
    HTTP status code shulde be 200
    And response format sheuld be "application/JSON"
    And firstname should be "Susan"
    ANd lastname should be "Brown"
    And checkin date should be "2015-02-16"
    And checkout date sholud be "2017-06-20"
     */

    @Test

    public void get01(){
        Response response = given().
                                    accept("application/json").
                                    when().get("https://restful-booker.herokuapp.com/booking/5");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", Matchers.equalTo("Mary")).
                body("lastname",Matchers.equalTo("Jackson")).
                body("totalprice",Matchers.equalTo(994)).
                body("depositepaid",Matchers.equalTo(true)).
                body("bookingdates.checkin",Matchers.equalTo("2019-07-13")).
                body("bookingdates.checkout",Matchers.equalTo("2020-07-02"));

                // Tek body ile
        response.
        then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", Matchers.equalTo("Mary"),
                "lastname",Matchers.equalTo("Jackson"),
                "totalprice",Matchers.equalTo(994),
                "depositepaid",Matchers.equalTo(true),
                "bookingdates.checkin",Matchers.equalTo("2019-07-13"),
                "bookingdates.checkout",Matchers.equalTo("2020-07-02"));
        Assert.assertEquals(200,response.getStatusCode());




    }

}
