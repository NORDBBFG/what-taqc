package test.courses;

import constants.Constants;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import test.BaseTest;

public class WHAT_21 extends BaseTest {

    @Test
    public void verifySearchFillingSymbols() {
        String email = "admin.@gmail.com";
        String password = "admiN_12";
        String invalidCourseName = "!@#$%^&*()";
        String errorMessageText = "Invalid course name";

        signInPageStep
                .setEmail(email)
                .setPassword(password)
                .clickSignInBtn(ListOfStudentsPageStep.class, driver)
                .clickCoursesSidebar(ListOfStudentPage.class, driver)
                .verifyPageHeaderName(Constants.PageName.COURSE_LIST)
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
