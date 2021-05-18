package ui_tests.registration;

import java.util.Random;
import org.testng.annotations.Test;
import ui_tests.BaseTest;

/**
 * This test case verifies that any @User can register in the system by entering the valid data:
 * First name, Last name, Email address, Password, Confirm Password, and by clicking the 'Sign up' button
 */

public class WHAT_73 extends BaseTest {

    String successMessage = "You have successfully registered. " +
            "Please, wait until your account is approved and your role is assigned";

    @Test
    public void atc_WHAT_73() {
        Random random = new Random();
        int n = random.nextInt(100) + 1;

        String firstName = "Abba";
        String lastName = "Dabba";
        String email = "abbadabba" + n + "@gmail.com";
        String password = "AbbaDabba" + n + "@";
        String confirmPassword = "AbbaDabba" + n + "@";

        // steps
        signInPageStep
                .clickRegistrationLink(driver)
                .setFirstName(firstName).verifyFirstName(firstName)     // step('1')
                .setLastName(lastName).verifyLastName(lastName)         // step('2')
                .setEmail(email).verifyEmail(email)                     // step('3')
                .setPassword(password).verifyPassword(password)         // step('4')
                .setConfirmPassword(confirmPassword)                    // step('5')
                .verifyConfirmPassword(confirmPassword)
                .verifySignUpBtnEnable()
                .clickSignUpBtn()                                       // step('6')
                .verifySuccessAlert(successMessage)                     // step('7')
                .verifySuccessRegistrationBtnEnable()
                .clickSuccessRegistrationBtn();
    }
}
