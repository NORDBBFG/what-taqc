package ui_tests.myProfile;

import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;
import constants.Constants;

/**
 * This test case verifies that any @User from UsersDifferentRoleRegisteredInSystem.csv
 * (Secretary, Mentor, Student) has access to his personal data and can get
 * correct data about his profile.
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
