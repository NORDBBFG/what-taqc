package ui_tests.courses;

import constants.Constants;
import org.testng.annotations.Test;
import page.support.SupportPage;
import step.support.SupportPageStep;
import ui_tests.BaseTest;

public class WHAT_221 extends BaseTest {

    @Test
    public void displayForStudent(){
        String email = "student@gmail.com";
        String password = "What_123";
        String courseNameBefSort = "Kulllll course";
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
