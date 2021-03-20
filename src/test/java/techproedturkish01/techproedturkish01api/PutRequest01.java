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

public class PutRequest01 extends TestBase{

    @Test

    public void put01(){

        Response response = given().
                                spec(spec03).
                            when().
                                get("/1");
        response.prettyPrint();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", "Ferit");
        jsonObject.put("userID",36);
        jsonObject.put("id",36);
        jsonObject.put("completed",false);

        Response responseAfterPut = given().
                                        contentType(ContentType.JSON).
                                        spec(spec03).
                                        body(jsonObject.toString()).
                                    when().
                                        put("/1");
        responseAfterPut.prettyPrint();




    }
}
