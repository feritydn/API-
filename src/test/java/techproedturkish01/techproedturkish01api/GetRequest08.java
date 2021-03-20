package techproedturkish01.techproedturkish01api;

import io.restassured.path.json.JsonPath;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.junit.Test;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequest08 extends TestBase {

    /*
     * When I send a GET request to REST API URL
     * https://restful-booker.herokuapp.com/booking/5
     * Then HTTP Status Code should be 200
     * And response content type is “application/JSON”
     * And response body should be like;
     * {“firstname”: “Sally”, “lastname”: “Ericsson”, “totalprice”: 111,
     * “depositpaid”: false, “bookingdates”: { “checkin”: “2017-05-23",
     *  “checkout”:“2019-07-02" }
     */

    @Test
    public void get01(){
        spec01.pathParam("bookingid",1);
        Response response = given().
                                spec(spec01).
                            when().
                                get("/booking/{bookingid}");
        response.prettyPrint();
        JsonPath json = response.jsonPath();
        Assert.assertEquals("Firstname is not as expected","Eric",json.getString("firstname"));
        Assert.assertEquals("Lastname is not as expected","Smith",json.getString("lastname"));
        Assert.assertEquals("Total price is not as expected ",333, json.getInt("totalprice"));
        Assert.assertEquals("deposit paid is not as expected",true, json.getBoolean("depositpaid"));
        Assert.assertEquals("checkin date is not as expected", "2018-04-30",json.getString("bookingdates.checkin"));
        Assert.assertEquals("checkout date is not as expected", "2021-02-24",json.getString("bookingdates.checkout"));
        Assert.assertEquals("additonal needs is not as expected","Breakfast",json.getString("additionalneeds"));


    }

}
