package api_tests.group;

import api_tests.BaseTest;
import api_tests.utils.DateTimeMethods;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static api_tests.utils.Utils.*;
import static io.restassured.RestAssured.given;

public class StudentsGroupUpdateTest extends BaseTest {

    private String token;
    private final String endPoint = "student_groups";

    @BeforeClass
    public void configureRestAssured() {
        token = getAdminToken();
    }

    @DataProvider
    public Object[][] updateNegative() {
        return new Object[][]{
                {StudentGroup.builder()
                        .name(getRandomString())
                        .startDate(getCurrentDateTime())
                        .finishDate(getCurrentDateTime())
                        .studentIds(Arrays.asList(1, 2, 3))
                        .mentorIds(Arrays.asList(4, 5)).build(),
                        "CourseId does not exist", 400},
                {StudentGroup.builder()
                        .name(getRandomString())
                        .courseId(10)
                        .startDate(getCurrentDateTime())
                        .finishDate(getCalculateDateByMethod(DateTimeMethods.MINUS_DAYS, 10))
                        .studentIds(Arrays.asList(1, 2, 3))
                        .mentorIds(Arrays.asList(4, 5)).build(),
                        "Start date must be less than finish date", 400},
                {StudentGroup.builder()
                        .name(getRandomString())
                        .courseId(10)
                        .startDate(getCurrentDateTime())
                        .finishDate("2015-09-35")
                        .studentIds(Arrays.asList(1, 2, 3))
                        .mentorIds(Arrays.asList(4, 5)).build(),
                        "Could not convert string to DateTime", 400},
                {StudentGroup.builder()
                        .name(getRandomString())
                        .courseId(10)
                        .startDate(getCurrentDateTime())
                        .finishDate(getCurrentDateTime())
                        .mentorIds(Arrays.asList(4, 5)).build(),
                        "Internal error", 500},
                {StudentGroup.builder()
                        .name(getRandomString())
                        .courseId(10)
                        .startDate(getCurrentDateTime())
                        .finishDate(getCurrentDateTime())
                        .studentIds(Arrays.asList(1, 2, 3)).build(),
                        "Internal error", 500},
                {StudentGroup.builder()
                        .name(getRandomString())
                        .courseId(10)
                        .startDate(getCurrentDateTime())
                        .finishDate(getCurrentDateTime())
                        .studentIds(new ArrayList<>())
                        .mentorIds(Arrays.asList(4, 5)).build(),
                        "The StudentIds field is required", 400},
                {StudentGroup.builder()
                        .name(getRandomString())
                        .courseId(10)
                        .startDate(getCurrentDateTime())
                        .finishDate(getCurrentDateTime())
                        .studentIds(Arrays.asList(1, 2, 3))
                        .mentorIds(new ArrayList<>()).build(),
                        "The MentorIds field is required", 400},
                {StudentGroup.builder()
                        .name(getRandomString())
                        .courseId(10)
                        .startDate(getCurrentDateTime())
                        .finishDate(getCurrentDateTime())
                        .studentIds(Arrays.asList(1, 2, 3, 3))
                        .mentorIds(Arrays.asList(4, 5)).build(),
                        "Such student ids: 3 are not unique", 400},
                {StudentGroup.builder()
                        .name(getRandomString())
                        .courseId(10)
                        .startDate(getCurrentDateTime())
                        .finishDate(getCurrentDateTime())
                        .studentIds(Arrays.asList(1, 2, 3))
                        .mentorIds(Arrays.asList(4, 5, 5)).build(),
                        "Such mentor ids: 5 are not unique", 400}
        };
    }


    @Test(description = "Positive - Check students group updating")
    public void createStudentGroupPositive() {
        StudentGroup studentGroup = StudentGroup.builder()
                .name(getRandomString())
                .courseId(10)
                .startDate(getCurrentDateTime())
                .finishDate(getCurrentDateTime())
                .studentIds(Arrays.asList(1, 2, 3))
                .mentorIds(Arrays.asList(4, 5)).build();

        String id = given()
                .spec(requestSpecWithToken())
                .body(studentGroup)
                .post(endPoint)
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("id");


        studentGroup.setName(getRandomString() + "_updated");
        studentGroup.setCourseId(12);
        studentGroup.setStartDate(getCalculateDateByMethod(DateTimeMethods.MINUS_DAYS, 20));
        studentGroup.setFinishDate(getCalculateDateByMethod(DateTimeMethods.PLUS_YEARS, 1));
        studentGroup.setStudentIds(Arrays.asList(1, 2));
        studentGroup.setMentorIds(Arrays.asList(4, 5, 6));

        Response response = given()
                .spec(requestSpecWithToken())
                .body(studentGroup)
                .put(endPoint + "/" + id);


        Assert.assertEquals(response.getStatusCode(), 200, response.getBody().asString());
        Assert.assertEquals(response.as(StudentGroup.class), studentGroup);

        Response responseGetById = given()
                .spec(requestSpecWithToken())
                .get(endPoint + "/" + id);

        Assert.assertEquals(responseGetById.getStatusCode(), 200, responseGetById.getBody().asString());
        Assert.assertEquals(responseGetById.as(StudentGroup.class), studentGroup);
    }

    @Test(description = "Negative - Check students group updating with invalid data", dataProvider = "updateNegative")
    public void createStudentGroupNegative(StudentGroup studentGroup, String errorMessage, int statusCode, ITestContext context) {
        String id = given()
                .spec(requestSpecWithToken())
                .body(StudentGroup.builder()
                        .name(getRandomString())
                        .courseId(10)
                        .startDate(getCurrentDateTime())
                        .finishDate(getCurrentDateTime())
                        .studentIds(Arrays.asList(1, 2, 3))
                        .mentorIds(Arrays.asList(4, 5)).build())
                .post(endPoint)
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("id");

        Response response = given()
                .spec(requestSpecWithToken())
                .body(studentGroup)
                .put(endPoint + "/" + id);

        Assert.assertEquals(response.getStatusCode(), statusCode, response.getBody().asString());
        Assert.assertTrue(response.asString().contains(errorMessage), response.asString());
    }
}
