package techproedturkish01.techproedturkish01api;
import Utilities.JsonUtil;
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

public class ObjectMapperTestMap extends TestBase {

    @Test
    public void javaToJson(){
        HashMap<Integer,String> map = new HashMap<>();
        map.put(101,"Ali");
        map.put(102,"Can");
        map.put(103,"Remziye");
        String jsonFromMap = JsonUtil.convertjavaToJson(map);
        System.out.println(jsonFromMap);
    }
    @Test
    public void jsonToJava (){
        Response response = given().
                                spec(spec01).
                            when().
                                get("booking/3");
        response.prettyPrint();

        Map<String,Object> jsonToMap = JsonUtil.convertJsonTojava(response.asString(), Map.class);
        System.out.println(jsonToMap);
    }

}
