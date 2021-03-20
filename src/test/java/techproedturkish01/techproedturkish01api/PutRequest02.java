package techproedturkish01.techproedturkish01api;
import org.junit.Test;
import io.restassured.path.json.JsonPath;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.json.JSONObject;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

public class PutRequest02 extends TestBase {
    /*
     * 1) Spec01 kullanarak herhangi bir datayi update ediniz 2) Update edildigini
     * status code ve response body ile verify ediniz
     */
    @Test
    public void put01(){
        Response response = given().
                                spec(spec03).
                            when().
                                get("/1");
        response.prettyPrint();

        Map<Object,Object> body = new HashMap<>();
        body.put("userId",36);
        body.put("id", 36);
        body.put("title", "Karslilar geliyor");
        body.put("completed", true);

        Response responseAfterPut = given().
                                        contentType(ContentType.JSON).
                                        spec(spec03).
                                        body(body).
                                     when().
                                        put("/1");
        responseAfterPut.prettyPrint();

        responseAfterPut.
                then().
                assertThat().
                statusCode(200);
        SoftAssert softAssert = new SoftAssert();
        JsonPath json = responseAfterPut.jsonPath();
        softAssert.assertEquals(json.getBoolean("completed"),body.get("completed"));
        softAssert.assertEquals(json.get("title"), body.get("title"));
        softAssert.assertEquals(json.get("userId"), body.get("userId"));

        softAssert.assertAll();
    }

}
