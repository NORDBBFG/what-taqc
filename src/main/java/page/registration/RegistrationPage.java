package page.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.Page;
import static constants.XPath.RegistrationPage.*;
import static constants.XPath.RegistrationPage.SIGNUP_HEADER;

public class RegistrationPage extends Page {
    // 'Sign up' page`s header
    @FindBy(xpath = SIGNUP_HEADER)
    private WebElement signUpHeader;
    // 'First name' field
    @FindBy(xpath = FIRST_NAME_FIELD)
    private WebElement firstNameInput;
    @FindBy(xpath = FIRST_NAME_ERROR_FIELD)
    private WebElement invalidFirstNameInput;
    // 'Last name' field
    @FindBy(xpath = LAST_NAME_FIELD)
    private WebElement lastNameInput;
    @FindBy(xpath = LAST_NAME_ERROR_FIELD)
    private WebElement invalidLastNameInput;
    // 'Email address' field
    @FindBy(xpath = EMAIL_FIELD)
    private WebElement emailInput;
    @FindBy(xpath = EMAIL_ERROR_FIELD)
    private WebElement invalidEmailInput;
    // 'Password' field
    @FindBy(xpath = PASSWORD_FIELD)
    private WebElement passwordInput;
    @FindBy(xpath = PASSWORD_INVALID_FIELD)
    private WebElement invalidPasswordInput;
    // 'Confirm Password' field
    @FindBy(xpath = CONFIRM_PASSWORD_FIELD)
    private WebElement confirmPasswordInput;
    @FindBy(xpath = CONFIRM_PASSWORD_INVALID_FIELD)
    private WebElement invalidConfirmPasswordInput;
    // 'Sign up' button field
    @FindBy (xpath = SIGNUP_BUTTON)
    private WebElement signUpBtn;
    // 'Log in' ('Sign in') link
    @FindBy (xpath = SIGNIN_LINK)
    private WebElement signInLink;
    // Sign up result field
    @FindBy (xpath = SUCCESSFUL_REGISTRATION_ALERT)
    private WebElement successRegistrationAlert;
    @FindBy (xpath = SUCCESSFUL_REGISTRATION_BUTTON)
    private WebElement successRegistrationBtn;
    @FindBy (xpath = ERROR_SIGNUP)
    private WebElement failedSignUp;
    // findElement

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public String getPageName() {
        return signUpHeader.getText();
    }

//    public boolean isPageName(String name){
//        return findPageName(name) != null;
//    }


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

    public void clickSignUpBtn() {
        signUpBtn.click();
    }

    public void clickSuccessRegistrationBtn() {
        successRegistrationBtn.click();
    }

    public String getSuccessAlert() {
        try {
            return driver.findElement(By.xpath(SUCCESSFUL_REGISTRATION_ALERT)).getText();
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }
    // todo
    public String getErrorFirstName() {
        try {
            return driver.findElement(By.xpath(FIRST_NAME_ERROR_FIELD)).getText();
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

    public String getErrorLastName() {
        try {
            return driver.findElement(By.xpath(LAST_NAME_ERROR_FIELD)).getText();
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

    public String getErrorEmail() {
        try {
            return driver.findElement(By.xpath(EMAIL_ERROR_FIELD)).getText();
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

    public String getErrorPassword() {
        try {
            return driver.findElement(By.xpath(PASSWORD_INVALID_FIELD)).getText();
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

    public String getErrorConfirmPassword() {
        try {
            return driver.findElement(By.xpath(CONFIRM_PASSWORD_INVALID_FIELD)).getText();
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

    public String getFailedSignUp() {
        try {
            return driver.findElement(By.xpath(ERROR_SIGNUP)).getText();
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

    private String getField(WebElement element) {
        return element.getAttribute("value");
    }

//    public String getPageName() { return getField(signUpHeader); }

    public String getFirstName() { return getField(firstNameInput); }

//    public String getFailedFirstName() { return getField(firstNameInput); }

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
