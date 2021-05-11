package test.registration;

import org.testng.annotations.Test;
import test.BaseTest;

/**
 * This test case verifies that users can't register into the system with empty 'First Name', 'Last Name',
 * 'Email address', 'Password', 'Confirm password' fields after clicking the 'Sign up' button.
 */

public class WHAT_78 extends BaseTest {

    @Test
    public void atc_WHAT_78() {
        String emptyField = "This field is required";

        // steps
        signInPageStep
                .clickRegistrationLink(driver)
                .clickSignUpBtn()
                .verifyErrorFirstName(emptyField)
                .verifyErrorLastName(emptyField)
                .verifyErrorEmail(emptyField)
                .verifyErrorPassword(emptyField)
                .verifyErrorConfirmPassword(emptyField)
                .verifySignUpBtnEnable();
    }
}
