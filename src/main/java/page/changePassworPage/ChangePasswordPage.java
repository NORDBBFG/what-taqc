package page.changePassworPage;
import component.ConfirmActionWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

public class ChangePasswordPage extends AbstractPage {


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
    @FindBy(xpath = "//button[@class='btn button__default___3hOmG button__button___24ZfP change-password__cancel-button___1neIS w-100']")
    private WebElement cancelButton;

/** ERRORS  */
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement thisFieldIsRequiredCurrentPassword;




    public void fillCurrentPasswordField(String currentPassword){
        fillField(currentPasswordField, currentPassword);
    }
    public void fillNewPasswordField(String newPassword){
        fillField(currentPasswordField, newPassword);
    }
    public void fillConfirmPasswordField(String confirmPassword){
        fillField(currentPasswordField, confirmPassword);

}


    public ConfirmActionWindow clickSaveButton(){
        saveButton.click();
        return new ConfirmActionWindow(driver);
    }
    /** we need to return 'User profile' page */
    public void clickCancelButton(){
        cancelButton.click();
    }



    public boolean emailAddressIsFieldCorrectly(String email){
        return emailField.getText().equals(email);
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
    public boolean saveButtonIsDisable(){
        return saveButton.isDisplayed();
    }
    public boolean saveButtonIsEnabled(){
        return saveButton.isEnabled();
    }

    public boolean emailAddressFieldIsDisabled(){
        return emailField.isSelected();
    }






    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }
}
