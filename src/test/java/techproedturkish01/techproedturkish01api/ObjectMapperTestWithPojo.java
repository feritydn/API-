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

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
public class ObjectMapperTestWithPojo {

    @Test
    public void javaToJson (){
        BookingDates bookingDates = new BookingDates("2021-11-05","2021-11-08");
        String jsonFromPojo = JsonUtil.convertjavaToJson(bookingDates);
        System.out.println(jsonFromPojo);
    }


}
