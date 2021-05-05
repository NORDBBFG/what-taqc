package step;

import component.ConfirmActionWindow;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.AbstractPage;
import page.changePassworPage.ChangePasswordPage;

public class ChangePasswordPageSteps {

    public ChangePasswordPageSteps(WebDriver driver) {
        changePasswordPage = new ChangePasswordPage(driver);
    }
    ChangePasswordPage changePasswordPage;

    public ChangePasswordPageSteps verifiedElementsInitialStateStep(String email){
            Assert.assertTrue(
                    changePasswordPage.emailAddressIsFieldCorrectly(email)
                    && changePasswordPage.newPasswordFieldIsEmpty()
                    && changePasswordPage.currentPasswordFieldIsEmpty()
                    && changePasswordPage.confirmPasswordFieldIsEmpty()
                    && changePasswordPage.confirmSaveButtonIsDisable()
                    && changePasswordPage.emailAddressFieldIsDisabled());
        return this;
    }

public ChangePasswordPageSteps fillChangePasswordPageStep(String currentPassword, String newPassword, String confirmPassword){
    changePasswordPage.fillCurrentPasswordField(currentPassword);
    changePasswordPage.fillNewPasswordField(newPassword);
    changePasswordPage.fillConfirmPasswordField(confirmPassword);
        return this;
}

public ChangePasswordPageSteps fillCurrentPasswordFieldStep(String currentPassword){
    changePasswordPage.fillCurrentPasswordField(currentPassword);
    return this;
}

    public ChangePasswordPageSteps fillNewPasswordFieldStep(String newPassword){
        changePasswordPage.fillNewPasswordField(newPassword);
        return this;
    }

    public ChangePasswordPageSteps fillConfirmPasswordFieldStep(String confirmPassword){
        changePasswordPage.fillConfirmPasswordField(confirmPassword);
        return this;
    }

public ConfirmActionWindowSteps clickSaveButtonStep(WebDriver driver){
    changePasswordPage.clickSaveButton();
    return new ConfirmActionWindowSteps(driver);
}
//TODO add return to method
    public void clickCancelButtonStep(WebDriver driver){
        changePasswordPage.clickCancelButton();
    }
}
