package techproedturkish01.techproedturkish01api;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class GetRequest01 {

    @Test

    public void getMethod01(){
        given().
                when().
                    get("https://restful-booker.herokuapp.com/booking").
                then().
                    assertThat().
                    statusCode(200);
    }

    @Test
    public void getMethod02(){
        Response response=given().
                            when().
                            get("https://restful-booker.herokuapp.com/booking/3");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
        System.out.println("status line: " + response.getStatusLine());
        System.out.println(response.getContentType());
        System.out.println(response.getHeaders());
        System.out.println(response.getHeader("Server"));
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");
    }
}
