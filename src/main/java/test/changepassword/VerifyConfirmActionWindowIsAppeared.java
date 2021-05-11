package test.changepassword;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.signin.SignInPage;
import page.student.ListOfStudentPage;
import step.changepassword.ChangePasswordPageSteps;
import step.student.ListOfStudentsPageStep;
import test.BaseTest;

public class VerifyConfirmActionWindowIsAppeared extends BaseTest {

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
    public void changePasswordVerifyFields() throws InterruptedException {

        String mail = "admin.@gmail.com";
        String currentPassword = "admiN_12";
        String newPassword = "123456789qQ";
        String alertMessage = "The password has been successfully changed";

        changePasswordPageSteps
                .verifiedElementsInitialStateStep(mail)
                .fillCurrentPasswordFieldStep(currentPassword)
                .fillNewPasswordFieldStep(newPassword)
                .fillConfirmPasswordFieldStep(newPassword)
                .clickSaveButtonStep(driver)
                .verifyConfirmActionWindow(true)
                .clickConfirmButton(driver)
                .verifyFollowingAlertMessage(alertMessage, true);
    }
}