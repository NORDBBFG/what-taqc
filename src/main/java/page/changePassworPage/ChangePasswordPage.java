package page.changePassworPage;
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

    public void fillCurrentPasswordField(String currentPassword){
        fillField(currentPasswordField, currentPassword);
    }
    public void fillNewPasswordField(String newPassword){
        fillField(currentPasswordField, newPassword);
    }
    public void fillConfirmPasswordField(String confirmPassword){
        fillField(currentPasswordField, confirmPassword);
    }


/** need to return  ‘Confirm action’ window */
    public void clickSaveButton(){
        saveButton.click();
    }
    /** we need to return 'User profile' page */
    public void clickCancelButton(){
        cancelButton.click();
    }






    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }
}
