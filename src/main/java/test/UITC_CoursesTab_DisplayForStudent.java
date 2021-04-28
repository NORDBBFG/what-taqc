package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.SignInPage;
import step.courses.CoursesStep;

public class UITC_CoursesTab_DisplayForStudent extends BaseTest {
    CoursesStep coursesStep;

    @BeforeTest
    public void preCond(){
        SignInPage signInPage = new SignInPage(driver);
        String email = "mashalarykova@gmailexample.com";
        String password = "User1_qwerty1!";
        String sidebarItemCourses = "Courses";
        String sidebarItemSupport = "Support";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
        signInPage.clickSignInButton();

        Assert.assertEquals(signInPage.findSidebarItem("Support").getText(), sidebarItemSupport);
        signInPage.clickSidebarItem(sidebarItemCourses);
        coursesStep = new CoursesStep(driver);
    }

    @Test
    public void DisplayForStudent(){
        String pageName = "Courses";
        String courseName = "fantasy111";
        int courseID = 7;

        coursesStep
                .verifyPageHeaderName(pageName)
                .verifyNumberOfCoursesDisplayed(true)
                .verifySearchCourseInListInputDisplayed(true)
                .verifyCourseName(courseID, courseName);
    }
}
