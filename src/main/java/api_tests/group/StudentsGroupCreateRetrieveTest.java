package api_tests.group;


import api_tests.BaseTest;
import api_tests.utils.DateTimeMethods;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static api_tests.utils.Utils.*;
import static io.restassured.RestAssured.given;

public class StudentsGroupCreateRetrieveTest extends BaseTest {

    private String token;
    private final String endPoint = "student_groups";

    @BeforeClass
    public void configureRestAssured() {
        token = getAdminToken();
    }


    @DataProvider
    public Object[][] createPositive() {
        return new Object[][]{
                {StudentGroup.builder()
                        .name(getRandomString())
                        .courseId(10)
                        .startDate(getCurrentDateTime())
                        .finishDate(getCurrentDateTime())
                        .studentIds(Arrays.asList(1, 2, 3))
                        .mentorIds(Arrays.asList(4, 5)).build()},
                {StudentGroup.builder()
                        .name(getRandomString())
                        .courseId(15)
                        .startDate(getCalculateDateByMethod(DateTimeMethods.MINUS_DAYS, 10))
                        .finishDate(getCurrentDateTime())
                        .studentIds(Collections.singletonList(11))
                        .mentorIds(Collections.singletonList(14)).build()}
        };
    }

    @DataProvider
    public Object[][] createNegative() {
        return new Object[][]{
                {StudentGroup.builder()
                        .name(getExistingStudentGroup())
                        .courseId(10)
                        .startDate(getCurrentDateTime())
                        .finishDate(getCurrentDateTime())
                        .studentIds(Arrays.asList(1, 2, 3))
                        .mentorIds(Arrays.asList(4, 5)).build(),
                        "Group name already exists", 422},
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
                        "The StudentIds field is required", 400},
                {StudentGroup.builder()
                        .name(getRandomString())
                        .courseId(10)
                        .startDate(getCurrentDateTime())
                        .finishDate(getCurrentDateTime())
                        .studentIds(Arrays.asList(1, 2, 3)).build(),
                        "The MentorIds field is required", 400},
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


    @Test(description = "Positive - Check students group creation and retrieving", dataProvider = "createPositive")
    public void createRetrieveStudentGroupPositive(StudentGroup studentGroup) {
        Response response = given()
                .spec(requestSpecWithToken())
                .body(studentGroup)
                .post(endPoint);

        String id = response.jsonPath().getString("id");

        Assert.assertEquals(response.getStatusCode(), 200, response.getBody().asString());
        Assert.assertEquals(response.as(StudentGroup.class), studentGroup);

        Response responseGetAll = given()
                .spec(requestSpecWithToken())
                .get(endPoint);

        Response responseGetById = given()
                .spec(requestSpecWithToken())
                .get(endPoint + "/" + id);

        Assert.assertEquals(responseGetAll.getStatusCode(), 200, responseGetAll.getBody().asString());
        Assert.assertEquals(responseGetAll.jsonPath().getList(".", StudentGroup.class)
                .stream()
                .filter(group -> group.getId() == Long.parseLong(id))
                .findFirst()
                .orElse(null), studentGroup);

        Assert.assertEquals(responseGetById.getStatusCode(), 200, responseGetById.getBody().asString());
        Assert.assertEquals(responseGetById.as(StudentGroup.class), studentGroup);
    }

    @Test(description = "Negative - Check students group creation with invalid data", dataProvider = "createNegative")
    public void createStudentGroupNegative(StudentGroup studentGroup, String errorMessage, int statusCode) {
        Response response = given()
                .spec(requestSpecWithToken())
                .body(studentGroup)
                .post(endPoint);
        Assert.assertEquals(response.getStatusCode(), statusCode, response.getBody().asString());
        Assert.assertTrue(response.asString().contains(errorMessage), response.asString());
    }

    private String getExistingStudentGroup() {
        return String.valueOf(given()
                .spec(requestSpecWithToken())
                .get(endPoint)
                .jsonPath()
                .getList("name")
                .get(0));
    }
}
