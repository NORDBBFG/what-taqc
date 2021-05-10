package step.registration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.registration.RegistrationPage;
import step.BaseStep;

public class RegistrationPageStep extends BaseStep {

    private RegistrationPage registrationPage;

    public RegistrationPageStep(WebDriver driver) {
        registrationPage = new RegistrationPage(driver);
    }

    public RegistrationPageStep verifyPageName(String expected) {
        Assert.assertEquals(registrationPage.getPageName(), expected);
        return this;
    }

    public RegistrationPageStep setFirstName(String expected) {
        registrationPage.fillFirstName(expected);
        return this;
    }

    public RegistrationPageStep verifyFirstName(String expected) {
        Assert.assertEquals(registrationPage.getFirstName(), expected);
        return this;
    }

    public RegistrationPageStep setLastName(String expected) {
        registrationPage.fillLastName(expected);
        return this;
    }

    public RegistrationPageStep verifyLastName(String expected) {
        Assert.assertEquals(registrationPage.getLastName(), expected);
        return this;
    }

    public RegistrationPageStep setEmail(String expected) {
        registrationPage.fillEmail(expected);
        return this;
    }

    public RegistrationPageStep verifyEmail(String expected) {
        Assert.assertEquals(registrationPage.getEmail(), expected);
        return this;
    }

    public RegistrationPageStep setPassword(String expected) {
        registrationPage.fillPassword(expected);
        return this;
    }

    public RegistrationPageStep verifyPassword(String expected) {
        Assert.assertEquals(registrationPage.getPassword(), expected);
        return this;
    }

    public RegistrationPageStep setConfirmPassword(String expected) {
        registrationPage.fillConfirmPassword(expected);
        return this;
    }
    
    public RegistrationPageStep verifyConfirmPassword(String expected) {
        Assert.assertEquals(registrationPage.getConfirmPassword(), expected);
        return this;
    }

    // TODO: 06.05.2021 verify SignUoButton  
    public boolean verifySignUpButtonEnable(boolean expected) {
        registrationPage.clickSignUpButton();
        return true;
    }

    public void clickSignUpButton() {
        registrationPage.clickSignUpButton();
    }

    public RegistrationPageStep verifySignUpButtonEnable() {
        return this;
    }
}
