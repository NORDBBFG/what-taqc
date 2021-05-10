package test.courses;

import constants.Constants;
import org.testng.annotations.Test;
import page.support.SupportPage;
import step.support.SupportPageStep;
import test.BaseTest;

public class WHAT_221 extends BaseTest {

    @Test
    public void displayForStudent() throws InterruptedException {
        String email = "mashalarykova@gmailexample.com";
        String password = "User1_qwerty1!";
        String courseNameBefSort = "fantasy111";
        int courseIDBefSort = 7;

        signInPageStep
                // Preconditions.
                .setEmail(email)
                .setPassword(password)
                .clickSignInBtn(SupportPageStep.class, driver)
                .verifySidebarItemSupport(SupportPageStep.class, SupportPage.class, true, driver)
                // Steps.
                .clickCoursesSidebar(SupportPage.class, driver)
                .verifyPageHeaderName(Constants.PageName.COURSE_LIST)
                .verifyNumberOfCoursesDisplayed(true)
                .verifySearchCourseInListInputDisplayed(true)
                .verifyCourseName(courseIDBefSort, courseNameBefSort);
    }
}
