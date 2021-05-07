package test.courses;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.SignInPage;
import step.courses.CoursesStep;
import test.BaseTest;
import test.Constants;

public class WHAT_222 extends BaseTest {
    CoursesStep coursesStep;

    @BeforeClass
    public void preCond(){
        SignInPage signInPage = new SignInPage(driver);
        String email = "mashalarykova@gmailexample.com";
        String password = "User1_qwerty1!";
        String sidebarItemSupport = "Support";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
        signInPage.clickSignInButton();

        Assert.assertEquals(signInPage.findSidebarItem("Support").getText(), sidebarItemSupport);
        signInPage.clickSidebarItem(Constants.PageName.COURSE_LIST);
        coursesStep = new CoursesStep(driver);
    }

    @Test
    public void DisplayForStudent(){
        String courseNameBefSort = "fantasy111";
        int courseIDBefSort = 7;

        coursesStep
                .verifyPageHeaderName(Constants.PageName.COURSE_LIST)
                .verifyNumberOfCoursesDisplayed(true)
                .verifySearchCourseInListInputDisplayed(true)
                .verifyCourseName(courseIDBefSort, courseNameBefSort);
    }
}
