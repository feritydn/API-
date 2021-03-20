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

public class GetRequest13 extends TestBase{

    @Test
    public void get01() {

        Response response = given().
                spec(spec02).
                when().
                get();
        response.prettyPrint();
        //1.Yol
        JsonPath json= response.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(json.getString("data[0].employee_name"),"Tiger Nixon");
        softAssert.assertEquals(json.getString("data[1].employee_name"),"Garrett Winters");
        softAssert.assertEquals(json.getString("data[2].employee_name"),"Ashton Cox");
        softAssert.assertEquals(json.getString("data[3].employee_name"),"Cedric Kelly");
        softAssert.assertEquals(json.getString("data[4].employee_name"),"Airi Satou");
        // 2. Yol
        List <String> nameList = new ArrayList<>();
        nameList.add("Tiger Nixon");
        nameList.add("Garrett Winters");
        nameList.add("Ashton Cox");
        nameList.add("Cedric Kelly");
        nameList.add("Airi Satou");

        for(int i=0; i<nameList.size(); i++){
            softAssert.assertEquals(json.getString("data[" + i + "].employee_name"),nameList.get(i));
        }

        // 3. Yol
        List<Map> actualList = json.getList("data");
        Map<Integer,String> ecpectedMap = new HashMap<>();
        ecpectedMap.put(0,"Tiger Nixon");
        ecpectedMap.put(1,"Garrett Winters");
        ecpectedMap.put(2,"Ashton Cox");
        ecpectedMap.put(3,"Cedric Kelly");
        ecpectedMap.put(4,"Airi Satou");

        for (int i=0; i<ecpectedMap.size(); i++){
            softAssert.assertEquals(actualList.get(i).get("employee_name"),ecpectedMap.get(i));
        }

        softAssert.assertAll();

    }
}
