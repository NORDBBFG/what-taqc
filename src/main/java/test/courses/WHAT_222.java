package test.courses;

import constants.Constants;
import org.testng.annotations.Test;
import page.support.SupportPage;
import step.support.SupportPageStep;
import test.BaseTest;

public class WHAT_222 extends BaseTest {

    @Test
    public void DisplayForStudent(){
        String email = "mashalarykova@gmailexample.com";
        String password = "User1_qwerty1!";
        String courseNameBefSort = "fantasy111";
        int courseIDBefSort = 7;

        //preconditions
        signInPageStep
                .setEmail(email)
                .setPassword(password)
                .clickSignInBtn(SupportPageStep.class, driver)
                .verifySidebarItemSupport(SupportPageStep.class, SupportPage.class, true, driver)
        //step('1')
                .clickCoursesSidebar(SupportPage.class, driver)
                .verifyPageHeaderName(Constants.PageName.COURSE_LIST)
        //step('2')
                .verifyNumberOfCoursesDisplayed(true)
                .verifySearchCourseInListInputDisplayed(true)
                .verifyCourseName(courseIDBefSort, courseNameBefSort);
    }
}
