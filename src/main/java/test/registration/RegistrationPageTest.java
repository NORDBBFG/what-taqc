package test.registration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.signin.SignInPage;
import step.registration.RegistrationPageStep;
import test.BaseTest;

import java.util.Random;

public class RegistrationPageTest extends BaseTest {

    SignInPage signInPage;
    RegistrationPageStep registrationPageStep;

    @BeforeMethod
    public void prepare() {
        signInPage = new SignInPage(driver);
        signInPage.clickRegistrationLink();
        registrationPageStep = new RegistrationPageStep(driver);
    }

    @Test
    public void validRegistrationTest() {

        Random random = new Random();
        int n = random.nextInt(100) + 1;

        String firstName = "Abba";
        String lastName = "Dabba";
        String email = "abbadabba" + n + "@gmail.com";
        String password = "AbbaDabba" + n + "@";
        String confirmPassword = "AbbaDabba" + n + "@";
        String expected = "You have successfully registered";

        registrationPageStep.setFirstName(firstName).verifyFirstName(firstName)
                .setLastName(lastName).verifyLastName(lastName)
                .setEmail(email).verifyEmail(email)
                .setPassword(password).verifyPassword(password)
                .setConfirmPassword(confirmPassword).verifyConfirmPassword(confirmPassword);
        registrationPageStep
                .verifySignUpButtonEnable()
                .clickSignUpButton();
    }
}
