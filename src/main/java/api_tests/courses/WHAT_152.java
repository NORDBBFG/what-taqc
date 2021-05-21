package api_tests.courses;

import api_tests.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;

public class WHAT_152 extends BaseTest {

    @Test
    public void updateCourseName200Admin(){
        String courseID = "60";
        Map<String, String> courseMap = new HashMap<>();
        courseMap.put("name","New Epic Course");

        given().
                header("Authorization",getAdminToken()).
                contentType(ContentType.JSON).
                body(courseMap).
                when().put("https://whatbackend.azurewebsites.net/api/courses/" + courseID).
                then().assertThat().statusCode(200).
                and().assertThat().body("id",hasToString(courseID)).
                and().assertThat().body("name",hasToString(courseMap.get("name"))).
                and().log().body();
    }
}
