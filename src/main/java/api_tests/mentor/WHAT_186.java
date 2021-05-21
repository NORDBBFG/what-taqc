package api_tests.mentor;


import api_tests.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;

public class WHAT_186 extends BaseTest {

    @Test
    public void createMentor200Admin(){
        int id_notAssigned = 119;
        Map <String, String> courseMap = new HashMap<>();
        courseMap.put("newUserRole","2");

        given().
                header("Authorization",getAdminToken()).
                contentType(ContentType.JSON).
                body(courseMap).
                when().post("https://whatbackend.azurewebsites.net/api/mentors/" + id_notAssigned).
                then().assertThat().statusCode(200).

                and().body("role", hasToString(courseMap.get("newUserRole"))).

                and().log().body();
    }
}