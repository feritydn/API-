package techproedturkish01.techproedturkish01api;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequest04 {

    /*
    Positive Scenario
        When I send a Get request to REST API URL
        "http://dummy.restapiexample.com/api/v1/employees"
        And Accept type is "application/json"
        then
        HTTP status code shuld be 200
        And response format should be "application/json"
        And there should be 24 employees
        And "Ashton Cox" should be one of teh employees
        And 21, 61 and 23 should be among the employees ages
     */

    @Test
    public void get01(){
        Response response = given().
                                accept(ContentType.JSON).
                when().
                    get("http://dummy.restapiexample.com/api/v1/employees");
        response.prettyPrint();

       response.
               then().
               assertThat().
               statusCode(200).
               contentType(ContentType.JSON).
               body("data.id",Matchers.hasSize(24),
                       "data.employee_name",Matchers.hasItem("Ashton Cox"),
                       "data.employee_age",Matchers.hasItems("21","61","23"));


    }


}
