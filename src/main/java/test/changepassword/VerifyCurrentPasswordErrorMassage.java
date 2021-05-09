package test.changepassword;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.signin.SignInPage;
import step.changepassword.ChangePasswordPageSteps;
import test.BaseTest;

public class VerifyCurrentPasswordErrorMassage extends BaseTest {

    ChangePasswordPageSteps changePasswordPageSteps;

    @BeforeMethod
    public void prepare() {
        SignInPage signInPage = new SignInPage(driver);
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
        signInPage.clickSignInButton();
        driver.findElement(By.xpath("//*[@id=\"root\"]/nav[1]/div/div[2]/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[4]/div/button/span")).click();
        changePasswordPageSteps = new ChangePasswordPageSteps(driver);
    }

    @Test
    public void verifyCurrentPasswordFieldError() {
        String errorMassage = "This field is required";

        changePasswordPageSteps
                .verifyCurrentPasswordFieldErrorMessage(errorMassage, true);
    }
}
