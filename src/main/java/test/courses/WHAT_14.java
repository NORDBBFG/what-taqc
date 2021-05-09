package test.courses;

import constants.Constants;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import test.BaseTest;

public class WHAT_14 extends BaseTest {

    @Test
    public void verifyValuesReturn() throws InterruptedException{
        String email = "admin.@gmail.com";
        String password = "admiN_12";
        String courseID = "0";
        String newCourseName = "Basic Course";
        String initialCourseName = "Курс для демо";

        //preconditions
        signInPageStep
                .setEmail(email)
                .setPassword(password)
                .clickSignInBtn(ListOfStudentsPageStep.class, driver)
                .clickCoursesSidebar(ListOfStudentPage.class,driver)
                .verifyPageHeaderName(Constants.PageName.COURSE_LIST)
                .clickCourseTableEditIcon(courseID, driver)
                .verifyPageHeaderName(Constants.PageName.COURSE_EDIT)
        //step('1')
                .clearEditCourseNameInput()
                //.verifyEditCourseNameInput("")
                .fillEditCourseNameInput(newCourseName)
                .verifyEditCourseNameInput(newCourseName)
                .clickOnResetEditCourseNameInputBtn()
                .verifyEditCourseNameInput(initialCourseName);
    }
}
