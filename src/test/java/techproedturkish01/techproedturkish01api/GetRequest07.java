package techproedturkish01.techproedturkish01api;

import org.junit.Test;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequest07 extends TestBase{

    @Test
    public void get01(){
        spec01.queryParams("firstname","Eric",
                       "depositpaid",true);

        Response response =
                          given().
                              spec(spec01).
                              when().
                              get("/booking");
            response.prettyPrint();
            Assert.assertTrue(response.asString().contains("bookingid"));
        }

    @Test
    public void get02(){
        Response response =
                given().
                        spec(spec01).
                        when().
                        get("/booking?firstname=Eric");
        response.prettyPrint();
        Assert.assertTrue(response.
                          getBody().
                          asString().
                          contains("bookingid"));
    }
}
