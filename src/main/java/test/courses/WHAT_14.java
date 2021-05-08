package test.courses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.SignInPage;
import step.courses.CoursesStep;
import step.courses.EditCourseDetailsStep;
import test.BaseTest;
import test.Constants;

public class WHAT_14 extends BaseTest {
    EditCourseDetailsStep editCourseDetailsStep;

    @BeforeClass
    public void preCond(){

        SignInPage signInPage = new SignInPage(driver);
        String email = "admin.@gmail.com";
        String password = "admiN_12";
        String courseID = "0";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
        signInPage.clickSignInButton();
        signInPage.clickSidebarItem(Constants.PageName.COURSE_LIST);

        CoursesStep coursesStep = new CoursesStep(driver);
        coursesStep
                .verifyPageHeaderName(Constants.PageName.COURSE_LIST)
                .clickCourseTableEditIcon(courseID, driver);

        editCourseDetailsStep = new EditCourseDetailsStep(driver);
        editCourseDetailsStep
                .verifyPageHeaderName(Constants.PageName.COURSE_EDIT);
    }

    @Test
    public void verifyValuesReturn() throws InterruptedException{
        String newCourseName = "Basic Course";
        String initialCourseName = "Курс для демо";

        editCourseDetailsStep
                // (step'1')
                // Clean the 'Course Name' field, verify it's cleaned.
                .fillEditCourseNameInput("")
                .verifyEditCourseNameInput("")
                // (step'2')
                // Fill the empty 'Course Name' field with 'Basic Course', verify it's filled.
                .fillEditCourseNameInput(newCourseName)
                .verifyEditCourseNameInput(newCourseName)
                // (step'3')
                // Click on the 'Clear' button, verify that the 'Course Name' in it's initial state.
                .clickOnResetEditCourseNameInputBtn()
                .verifyEditCourseNameInput(initialCourseName);
    }
}
