package test.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
                .clickCourseTableEditIcon(courseID);

        editCourseDetailsStep = new EditCourseDetailsStep(driver);
        editCourseDetailsStep
                .verifyPageHeaderName(Constants.PageName.COURSE_EDIT);
    }

    @Test
    public void verifyValuesReturn() throws InterruptedException{
        String newCourseName = "Basic Course";
        String initialCourseName = "Курс для демо";

        editCourseDetailsStep
                .clearEditCourseNameInput()
                //.verifyEditCourseNameInput("")
                .fillEditCourseNameInput(newCourseName)
                .verifyEditCourseNameInput(newCourseName)
                .clickOnResetEditCourseNameInputBtn()
                .verifyEditCourseNameInput(initialCourseName);
    }
}
