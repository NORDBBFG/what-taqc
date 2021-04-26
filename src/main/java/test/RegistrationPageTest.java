package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.RegistrationPage;
import page.SignInPage;
import step.RegistrationPageStep;

import java.util.Random;

public class RegistrationPageTest extends AbstractTest {

    SignInPage signInPage;
    RegistrationPageStep registrationPageStep = new RegistrationPageStep(driver);

    @BeforeMethod
    public void prepare() {
        signInPage = new SignInPage(driver);
    }

    @Test
    public void validRegistrationTest() {

        Random random = new Random();
        int n = random.nextInt(100) + 1;

        String firstName = "Abba" + n;
        String lastName = "Dabba" + n;
        String email = "abbadabba" + n + "@gmail.com";
        String password = "AbbaDabba" + n + "@";
        String confirmPassword = "AbbaDabba" + n + "@";
        String expected = "You have successfully registered";

        registrationPageStep.verifyFirstName(firstName);
        registrationPageStep.verifyLastName(lastName);
        registrationPageStep.verifyEmail(email);
        registrationPageStep.verifyPassword(password);
        registrationPageStep.verifyConfirmPassword(confirmPassword);

        registrationPageStep
                .verifyPageName(Constants.LogIn.SIGN_IN)
                .verifyFirstName(firstName)
                .verifyLastName(lastName)
                .verifyEmail(email)
                .verifyPassword(password)
                .verifyConfirmPassword(confirmPassword);
    }

    @Test
    public void clickSignUpButtonTest() {
        registrationPageStep
                .verifySignUpButtonEnable()
                .clickSignUpButton();
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(5000);
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
