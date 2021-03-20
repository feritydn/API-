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

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GetRequest11 extends TestBase {

    @Test
    public void get01(){
        Response response = given().
                spec(spec03).
                when().
                get("/2");
        response.prettyPrint();
        HashMap <String,String> map = response.as(HashMap.class);
        System.out.println(map);
        map.keySet();
        System.out.println(map.keySet());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(map.get("completed"),false);
        softAssert.assertTrue(map.containsKey("userId"));
        softAssert.assertTrue(map.containsKey("id"));
        softAssert.assertTrue(map.containsKey("title"));
        softAssert.assertEquals(map.get("userId"),1);
        softAssert.assertEquals(map.get("id"),2);
        softAssert.assertEquals(map.get("title"),"quis ut nam facilis et officia qui");
        Gson gson = new Gson();

        softAssert.assertAll();
        gson.toJson(map);

    }
}
