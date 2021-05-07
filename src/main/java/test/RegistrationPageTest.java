package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SignInPage;
import step.RegistrationPageStep;

import java.util.Random;

public class RegistrationPageTest extends AbstractTest {

    SignInPage signInPage;
    RegistrationPageStep registrationPageStep;

    @BeforeMethod
    public void prepare() {
        signInPage = new SignInPage(driver);
        registrationPageStep = new RegistrationPageStep(driver);
//        registrationPageStep.getRegistrationPage();
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