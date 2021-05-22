package api_tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseTest {

    private final String url = "https://whatbackend.azurewebsites.net/api";

    protected RequestSpecification requestSpecWithToken() {
        return requestSpec().header("Authorization", getAdminToken());
    }

    protected RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public String getAdminToken() {
        return getToken("admin.@gmail.com", "admiN_12");
    }

    public String getToken(String email, String password) {
        Map<String, String> credMap = new HashMap<>();
        credMap.put("email", email);
        credMap.put("password", password);

        return given()
                .spec(requestSpec())
                .body(credMap)
                .post("/accounts/auth")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .header("Authorization");
    }
}
