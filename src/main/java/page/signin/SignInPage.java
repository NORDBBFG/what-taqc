package page.signin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.Page;
import static constants.XPath.SignInPage.*;

public class SignInPage extends Page {

    @FindBy(xpath = SIGNIN_HEADER)
    private WebElement labelSignIn;
    @FindBy(xpath = EMAIL_FIELD)
    private WebElement emailInput;
    @FindBy(xpath = PASSWORD_FIELD)
    private WebElement passwordInput;
    @FindBy(xpath = SIGNIN_BUTTON)
    private WebElement signInButton;
    @FindBy(xpath = FORGOT_PASSWORD_LINK)
    private WebElement ForgotPasswordLink;
    @FindBy(xpath = REGISTRATION_LINK)
    private WebElement registrationLink;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void fillEmail(String email) {
        fillField(emailInput, email);
    }

    public void fillPassword(String password) {
        fillField(passwordInput, password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickRegistrationLink() {
        registrationLink.click();
    }

    public String getEmail(){
        return emailInput.getAttribute("value");
    }

    public String getPassword(){
        return passwordInput.getAttribute("value");
    }

}
