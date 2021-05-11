package test.registration;

import org.testng.annotations.Test;
import page.signin.SignInPage;
import step.registration.RegistrationPageStep;
import test.BaseTest;

/**
 * This test case verifies that any @User can't register in the system with invalid values
 * in the First name, Last name, Email address, Password, Confirm Password, after clicking the 'Sign up' button
 */

public class WHAT_85 extends BaseTest {

    SignInPage signInPage;
    RegistrationPageStep registrationPageStep;

    @Test
    public void atc_WHAT_73() {
        String firstName = "11111";
        String lastName = "22222";
        String email = "abbadabba";
        String password = "Abba";
        String confirmPassword = "Dabba";
        String errorFirstName = "Invalid first name";
        String errorLastName = "Invalid last name";
        String errorEmail = "Invalid email address";
        String errorPassword = "Password must contain at least 8 characters";
        String errorConfirmPassword = "You should confirm your password";

        // steps
        signInPageStep
                .clickRegistrationLink(driver)
                .setFirstName(firstName)                            // step('1')
                .setLastName(lastName)                              // step('2')
                .setEmail(email)                                    // step('3')
                .setPassword(password)                              // step('4')
                .setConfirmPassword(confirmPassword)                // step('5')
                .setConfirmPassword(confirmPassword)
                .verifyErrorFirstName(errorFirstName)
                .verifyErrorLastName(errorLastName)
                .verifyErrorEmail(errorEmail)
                .verifyErrorPassword(errorPassword)
                .verifyErrorConfirmPassword(errorConfirmPassword)
                .verifySignUpBtnEnable()
                .clickSignUpBtn();                                  // step('6')
    }
}
