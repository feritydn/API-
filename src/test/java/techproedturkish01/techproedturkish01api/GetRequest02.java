package techproedturkish01.techproedturkish01api;

import org.junit.Assert;
import org.junit.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class GetRequest02 {
    /*
    ==> positife scenario
    when() Bir get request endpointe yollanir.
           "https://restful-booker.herokuapp.com/booking
     and Accept Type "application/json"
     then status cede 200
     and content type "application/json"
     */

    @Test
    public void get01(){
        given().
                accept("application/json").
                when().
                get("https://restful-booker.herokuapp.com/booking").
        then().
                assertThat().
                statusCode(200).
                contentType("application/json");

            }
    /*
    ==> negative scenario
    when() Bir get request endpointe yollanir.
           "https://restful-booker.herokuapp.com/booking/47
     and Accept Type "application/json"
     then status cede 404
     */

    @Test
    public void get02(){
        Response response=given().
                            accept("application/json").
                            when().
                            get("https://restful-booker.herokuapp.com/booking/47");
       response.prettyPrint();
        response.
                then().
                statusCode(404);
    }

    /*
    ==> negative scenario
    when() Bir get request endpointe yollanir.
           "https://restful-booker.herokuapp.com/booking/47
     and Accept Type "application/json"
     then status cede 404
     response body de "Fot Found" var
     response body de "Suleyman" yok
     */

    @Test
    public void get03(){
        Response response = given().
                                when().
                                get("https://restful-booker.herokuapp.com/booking/1");
        response.prettyPrint();
        assertEquals(200,response.getStatusCode());
        Assert.assertTrue(response.asString().contains("Not Found"));
        Assert.assertFalse(response.asString().contains("Suleyman"));

    }
}
