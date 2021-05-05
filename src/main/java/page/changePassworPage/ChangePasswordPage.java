package page.changePassworPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

public class ChangePasswordPage extends AbstractPage {

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

/** Try to identify page using this text*/

@FindBy(xpath = "//h3[@class='pt-3']")
private WebElement pagesLabel;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@name='currentPassword']")
    private WebElement currentPasswordField;
    @FindBy(xpath = "//input[@name='newPassword']")
    private WebElement newPasswordField;
    @FindBy(xpath = "//input[@name='confirmNewPassword']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;
    @FindBy(xpath = "//button[contains(@Class, 'cancel-button')]")
    private WebElement cancelButton;

/** ERRORS
    @FindBy(xpath = "//div[@class='col-md-8 px-0']//input[@name='currentPassword']//div[@class='text-danger mt-3']")
    private WebElement FieldIsRequiredMassageCurrentPassword;

    @FindBy(xpath = "//div[@class='col-md-8 px-0']//input[@name='currentPassword']//div[@class='text-danger mt-3']")
    private WebElement FieldIsRequiredMassageCurrentPassword;
    @FindBy(xpath = "//div[@class='col-md-8 px-0']//input[@name='currentPassword']//div[@class='text-danger mt-3']")
    private WebElement FieldIsRequiredMassageCurrentPassword;
    @FindBy(xpath = "//div[@class='col-md-8 px-0']//input[@name='currentPassword']//div[@class='text-danger mt-3']")
    private WebElement FieldIsRequiredMassageCurrentPassword;

    @FindBy(xpath = "//div[@class='col-md-8 px-0']//input[@name='currentPassword']//div[@class='text-danger mt-3']")
    private WebElement FieldIsRequiredMassageCurrentPassword;
    @FindBy(xpath = "//div[@class='col-md-8 px-0']//input[@name='currentPassword']//div[@class='text-danger mt-3']")
    private WebElement FieldIsRequiredMassageCurrentPassword; */

    public void fillCurrentPasswordField(String currentPassword){
        fillField(currentPasswordField, currentPassword);
    }
    public void fillNewPasswordField(String newPassword){
        fillField(newPasswordField, newPassword);
    }
    public void fillConfirmPasswordField(String confirmPassword){
        fillField(confirmPasswordField, confirmPassword);
}

    public void clickSaveButton(){
        saveButton.click();
    }
    /** we need to return 'User profile' page */
    public void clickCancelButton(){
        cancelButton.click();
    }

    public boolean emailAddressIsFieldCorrectly(String email){
        String currentEmail = emailField.getAttribute("value");
        return currentEmail.equals(email);
    }
    public boolean currentPasswordFieldIsEmpty(){
        return currentPasswordField.getText().equals("");
    }
    public boolean newPasswordFieldIsEmpty(){
        return newPasswordField.getText().equals("");
    }
    public boolean confirmPasswordFieldIsEmpty(){
        return confirmPasswordField.getText().equals("");
    }
    public boolean confirmSaveButtonIsDisable(){
        return saveButton.isDisplayed();
    }

   /* public boolean verifyFieldIsRequiredMassageIsAppeared(){
        return FieldIsRequiredMassageCurrentPassword.getText().equals("This field is required");
    }*/

    public void clickOnPagesLabel(){
        pagesLabel.click();
    }

    public boolean confirmSaveButtonIsEnabled(){
        return saveButton.isEnabled();
    }

    public boolean emailAddressFieldIsDisabled(){
        return emailField.isDisplayed();
    }
}
