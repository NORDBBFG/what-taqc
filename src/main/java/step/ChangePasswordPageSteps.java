package step;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.AbstractPage;
import page.changePassworPage.ChangePasswordPage;

public class ChangePasswordPageSteps extends AbstractPage {
    ChangePasswordPage page = new ChangePasswordPage(driver);


    public boolean VerifiedElementsInitialStateStep(String email){
        return page.emailAddressIsFieldCorrectly(email)
                && page.newPasswordFieldIsEmpty()
                && page.currentPasswordFieldIsEmpty()
                && page.confirmPasswordFieldIsEmpty()
                && page.saveButtonIsDisable()
                && page.emailAddressFieldIsDisabled();
    }

public void fillChangePasswordPageStep(String currentPassword, String newPassword, String confirmPassword){
    page.fillCurrentPasswordField(currentPassword);
    page.fillNewPasswordField(newPassword);
        page.fillConfirmPasswordField(confirmPassword);
}


public void fillCurrentPasswordFieldStep(String currentPassword){
        page.fillCurrentPasswordField(currentPassword);
}
    public void fillNewPasswordFieldStep(String newtPassword){
        page.fillNewPasswordField(newtPassword);
    }
    public void fillConfirmPasswordFieldStep(String confirmPassword){
        page.fillConfirmPasswordField(confirmPassword);
    }


    public ChangePasswordPageSteps(WebDriver driver) {
        super(driver);
    }
}
