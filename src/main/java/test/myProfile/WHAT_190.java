package test.myProfile;

import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import test.BaseTest;
import constants.Constants;

/**
 * Description
 */

public class WHAT_190 extends BaseTest {

    @Test
    public void atc_WHAT_190() {
        String firstName="admin";
        String lastName="admin";
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        // step('preconditions')
        signInPageStep
                .setEmail(email)
                .setPassword(password)
                .clickSignInBtn(ListOfStudentsPageStep.class,driver)
                .clickMyProfile(ListOfStudentPage.class,driver)
        // step('1')
                .verifyPageName(Constants.PageName.MY_PROFILE)
                .verifyFirstName(firstName)
                .verifyLastName(lastName)
                .verifyEmailAddress(email)
                .verifyChangePasswordBtnEnabled();
    }
}
