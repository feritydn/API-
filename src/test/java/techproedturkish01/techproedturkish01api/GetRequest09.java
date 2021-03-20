package techproedturkish01.techproedturkish01api;

import io.restassured.path.json.JsonPath;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.junit.Test;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

public class GetRequest09 extends TestBase {
    @Test
    public void get01(){
        Response response = given().
                            spec(spec02).
                            when().
                            get();
        response.prettyPrint();
        JsonPath json = response.jsonPath();
        System.out.println(json.getList("data.employee_name"));
        //Assert.assertEquals("firstname is not as expected","Garrett Winters",json.getString("data[1].employee_name"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(json.getString("data[1].employee_name"),
                                            "Garrett Winters",
                                            "firstname is not as expected");
        // Iscilerin arasinda Harrod Chandler var oldugunu varify ediniz
        softAssert.assertTrue(json.getList("data.employee_name").contains("Herrod Chandler"),
                                        "There is no Herrod Chandler");
        softAssert.assertTrue(json.getList("data").size()==24,
                                       "there is no 24 employees");
        softAssert.assertEquals(json.getInt("data[6].employee_salary"),
                                        137500,
                                        "salary is not true");

        softAssert.assertAll();


    }

}
