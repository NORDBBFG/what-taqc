package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends Page {

    private static final String SIGNUP_BUTTON ="//button[@type='submit']";
    @FindBy(xpath = "//h3")
    private WebElement pageName;
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@id='confirm-password']")
    private WebElement confirmPasswordInput;
    @FindBy (xpath = SIGNUP_BUTTON)
    private WebElement signUpButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public String getPageName() {
        return pageName.getText();
    }

    public void fillFirstName(String firstName) { fillField(firstNameInput, firstName); }

    public void fillLastName(String lastName) {
        fillField(lastNameInput, lastName);
    }

    public void fillEmail(String email) {
        fillField(emailInput, email);
    }

    public void fillPassword(String password) {
        fillField(passwordInput, password);
    }

    public void fillConfirmPassword(String confirmPassword) {
        fillField(confirmPasswordInput, confirmPassword);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    private String getField(WebElement element) {
        return element.getAttribute("value");
    }

    public String getFirstName() { return getField(firstNameInput); }

    public String getLastName() {
        return getField(lastNameInput);
    }

    public String getEmail() {
        return getField(emailInput);
    }

    public String getPassword() {
        return getField(passwordInput);
    }

    public String getConfirmPassword() {
        return getField(confirmPasswordInput);
    }
}
