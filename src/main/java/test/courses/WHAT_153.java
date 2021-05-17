package test.courses;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class WHAT_153 {
    public String getAdminToken() {
        Map<String, String> credMap = new HashMap<>();

        credMap.put("email", "admin.@gmail.com");
        credMap.put("password", "admiN_12");
        Response response = given().
                body(credMap).
                contentType(ContentType.JSON).
                when().
                post("https://whatbackend.azurewebsites.net/api/accounts/auth");
        System.out.println(response.getHeader("authorization"));
        return response.getHeader("authorization");
    }

    @Test
    public void createCourse200Admin() {
        Map <String, String> courseMap = new HashMap<>();
        courseMap.put("name","uniqueTest4");
        String newCourseID = "43";

        given().
                header("Authorization",getAdminToken()).
                contentType(ContentType.JSON).
                body(courseMap).
                when().post("https://whatbackend.azurewebsites.net/api/courses").
                then().assertThat().statusCode(200).
                and().
                body("id",hasToString(newCourseID)).
                and().
                body("name",hasToString(courseMap.get("name"))).
                log().body();
    }
}
