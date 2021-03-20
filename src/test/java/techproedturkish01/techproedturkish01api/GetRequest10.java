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

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GetRequest10 extends TestBase{
    /*
     When I send GET Request to URL
     http://dummy.restapiexample.com/api/v1/employees
     Then
       Status code is 200
       1)10'dan buyuk tum id'leri console'a yazdir
       10'dan buyuk 14 tane id oldugunu verify et
       2)30'dan kucuk tum yaslari console'a yazdir
       30 dan kucuk en buyuk yasin 23 oldugunu verify et
       3)Maasi 350000'den cok olan iscilerin isimlerini console'a yazdir
       Charde Marshall'in maasinin 350000'den buyuk oldugunu verify et
     */
    @Test
    public void get01(){
        Response response = given().
                                spec(spec02).
                            when().
                                get();
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200);
        JsonPath json = response.jsonPath();
        List<String> idList = json.getList("data.findAll{Integer.valueOf(it.id)>10}.id");
        System.out.println(idList);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(idList.size(),14,"There is no 14 id");
        List<String> ageList =
                json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
        Collections.sort(ageList);
        System.out.println(ageList);
        softAssert.assertEquals(ageList.get(ageList.size()-1),"23", "Yas istenen gibi degil");
        List <String> emloyeeName = json.getList("data.findAll{Integer.valueOf(it.employee_salary)>350000}.employee_name");
        System.out.println(emloyeeName);
        softAssert.assertTrue(emloyeeName.contains("Charde Marshall"));

        softAssert.assertAll();
    }
}
