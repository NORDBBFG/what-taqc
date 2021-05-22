package test.group.TestsAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Test_01 {
    @Test
    void test_01(){
        Response res = RestAssured.get("https://whatbackend.azurewebsites.net/api/student_groups");
        System.out.println(res.asString());
    }
}
