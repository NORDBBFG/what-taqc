package test.courses;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class WHAT_141{
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
    public void getCourses200Admin(){
        String id = "16";
        String name = "You know WHAT to do";

        given().
                header("Authorization",getAdminToken()).
                when().get("https://whatbackend.azurewebsites.net/api/courses/isActive").
                then().assertThat().statusCode(200).
                log().body().
                and().
                assertThat().body("[15].id",hasToString(id)).
                and().
                assertThat().body("[15].name", hasToString(name));
    }
}
