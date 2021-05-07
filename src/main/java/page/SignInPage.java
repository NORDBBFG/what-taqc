package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends Page {
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;
    @FindBy(className = "//a[@class='auth__form-link___3Q9Ou']")
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

    public void fillField(WebElement element, String inputText) {
        element.clear();
        element.sendKeys(inputText);
    }
}

