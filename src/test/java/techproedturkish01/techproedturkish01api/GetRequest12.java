package techproedturkish01.techproedturkish01api;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.junit.Test;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.*;

import org.junit.Test;

public class GetRequest12 extends TestBase {

    @Test
    public void get01(){

        Response response = given().
                                spec(spec03).
                            when().
                                get();
        response.prettyPrint();
        List <HashMap<Object,Object>> listOfMaps =response.as(ArrayList.class);
        System.out.println(listOfMaps.get(1));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(listOfMaps.size()==200, "id number is not as expected");
        softAssert.assertEquals(listOfMaps.get(120).get("completed"),true,"Is not as expected");
        softAssert.assertEquals(listOfMaps.get(listOfMaps.size()-2).get("title"),"numquam repellendus a magnam", "title is not as expected");
        softAssert.assertAll();

        Gson gson = new Gson();
        gson.toJson(listOfMaps);


    }
}
