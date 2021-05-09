package test.courses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.SignInPage;
import step.courses.AddCourseStep;
import step.courses.CoursesStep;
import step.courses.EditCourseDetailsStep;
import test.BaseTest;
import test.Constants;

public class WHAT_21 extends BaseTest {
    CoursesStep coursesStep;

    @BeforeClass
    public void preCond(){
        SignInPage signInPage = new SignInPage(driver);
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
        signInPage.clickSignInButton();
        signInPage.clickSidebarItem(Constants.PageName.COURSE_LIST);

        coursesStep = new CoursesStep(driver);
        coursesStep.verifyPageHeaderName(Constants.PageName.COURSE_LIST);
    }

    @Test
    public void verifySearchFillingSymbols() throws InterruptedException {
        String invalidCourseName = "!@#$%^&*()";
        String errorMessageText = "Invalid course name";

        coursesStep
                // (step'1')
                // Click on the 'Add a course' button, verify the 'Add a course' page opened.
                .clickAddCourseToListBtn(driver)
                .verifyPageHeaderText(Constants.PageName.COURSE_ADD)
                // (step'2')
                // Fill the 'Course name' input with an invalid name, verify error message 'Invalid course name'
                // appeared and verify that 'Save' button disabled.
                .fillCourseNameInput(invalidCourseName)
                .verifyInvalidCourseMessageText(errorMessageText)
                .verifySubmitButtonEnabled(false);
    }
}
