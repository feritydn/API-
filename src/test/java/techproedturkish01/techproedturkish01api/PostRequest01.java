package techproedturkish01.techproedturkish01api;
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
public class PostRequest01 extends TestBase {

    /*
     * Post Request olusturmak icin gerekenler 1) End point sart 2) Request body
     * sart 3) Authorization sart 4) Accept Type istege bagli 5) Content Type istege
     * bagli
     *
     * Get ile Post requestlerin farki nedir? 1) get requesti data cekmek icin
     * kullaniriz. SQL deki select gibidir auto gerekir ve sadece endpoint ile is
     * yapilabilir
     *
     * 2) Post data olusturmak icin olusturmak icin kullanir. Endpoit ve data lazim
     * Bunun disinda auto ve benzeri durumla da istenilebilir.
     *
     * FARKLAR 1) Get icin sadece EndPoint yeterlidir ama Post icin endPoint in
     * yaninda request body de sarttir.
     *
     * NOTE: API developer lar olusturuacak datanin bazi bolumlerinin bos
     * birakilmamasina gerektigini karar vermislerse post request olusturulurken
     * kesinlikle o kisimlara deger verilerek POST REQUEST olusturulmalidir. Eger
     * buna dikkat etmezsek 400 bad request status code alirsiniz
     *
     *
     * NOTE: API developer lar olusturuacak datanin bazi bolumlerinin tekrarli
     * olmamasina karar vermislerse post request olusturulurken kesinlikle o
     * kisimlara tekrarli deger verilmeyerek POST REQUEST olusturulmalidir. Eger
     * buna dikkat etmezsek 400 bad request status code alirsiniz
     */

    @Test

    public void post (){

        /*
         * POST Scenario:
         * Accept type Json olsun When POST request yolladigimda
         * 1) https://restful-booker.herokuapp.com/booking
         *  2) Request Body
         *  { "firstname":"Suleyman",
         *  "lastname": "Alptekin",
         *  "totalprice": 123,
         *  "depositpaid": true,
         * "bookingdates": {
         *  "checkin": "2020-05-02",
         *  "checkout": "2020-05-05" },
         * "additionalneeds": "Wifi" }
         * Then
         * Status Code 200 olmali
         * Response Bodynin , Request Body ile ayni oldugunu verify ediniz.
         */

        // 1. Yol

        String jsonReqBody =
                            "{ \"firstname\":\"Suleyman\",\n" +
                            "\"lastname\": \"Alptekin\",\n" +
                            "\"totalprice\": 123,\n" +
                            "\"depositpaid\": true,\n" +
                            "\"bookingdates\": {\n" +
                            "\"checkin\": \"2020-05-02\",\n" +
                            "\"checkout\": \"2020-05-05\" },\n" +
                            "\"additionalneeds\": \"Wifi\" }";

        Response response = given().
                                contentType(ContentType.JSON).
                                spec(spec01).
                                auth().
                                basic("admin","password123").
                                body(jsonReqBody).
                                when().
                                post("/booking");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200);

        JsonPath json = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(json.getString("booking.firstname"),"Suleyman","firstname is not as expected");
        softAssert.assertEquals(json.getString("booking.lastname"),"Alptekin","lastname is not as expected");
        softAssert.assertEquals(json.getString("booking.totalprice"),"123","total price is not as expected");
        softAssert.assertEquals(json.getString("booking.depositpaid"),"true","deposit paid is not as expected");
        softAssert.assertEquals(json.getString("booking.bookingdates.checkin"),"2020-05-02","checkin is not as expected");
        softAssert.assertEquals(json.getString("booking.bookingdates.checkout"),"2020-05-05","checkaut is not as expected");
        softAssert.assertEquals(json.getString("booking.additionalneeds"),"Wifi","additional needs is not as expected");

        softAssert.assertAll();

    }
    
}
