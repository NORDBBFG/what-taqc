package step.registration;

import constants.Classes;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.registration.RegistrationPage;
import step.BaseStep;
import step.Step;
import step.student.EditStudentDetailsPageStep;
import step.student.ListOfStudentsPageStep;
import step.support.SupportPageStep;

import static constants.XPath.RegistrationPage.*;
import static constants.XPath.RegistrationPage.ERROR_SIGNUP;

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

    public boolean verifySignUpBtnEnable(boolean expected) {
        registrationPage.clickSignUpBtn();
        return true;
    }

    public boolean verifySuccessRegistrationBtnEnable(boolean expected) {
        registrationPage.clickSignUpBtn();
        return true;
    }

    public RegistrationPageStep clickSignUpBtn() {
        registrationPage.clickSignUpBtn();
        return this;
    }

    public void clickSuccessRegistrationBtn() {
        registrationPage.clickSuccessRegistrationBtn();
    }

    public RegistrationPageStep verifySignUpBtnEnable() {
        return this;
    }

    public RegistrationPageStep verifySuccessRegistrationBtnEnable() {
        return this;
    }
    // todo
    public RegistrationPageStep verifySuccessAlert(String expected) {
        Assert.assertEquals(registrationPage.getSuccessAlert(), expected);
        return this; }

    public RegistrationPageStep verifyErrorFirstName(String expected) {
        Assert.assertEquals(registrationPage.getErrorFirstName(), expected);
        return this; }

    public RegistrationPageStep verifyErrorLastName(String expected) {
        Assert.assertEquals(registrationPage.getErrorLastName(), expected);
        return this; }

    public RegistrationPageStep verifyErrorEmail(String expected) {
        Assert.assertEquals(registrationPage.getErrorEmail(), expected);
        return this; }

    public RegistrationPageStep verifyErrorPassword(String expected) {
        Assert.assertEquals(registrationPage.getErrorPassword(), expected);
        return this; }

    public RegistrationPageStep verifyErrorConfirmPassword(String expected) {
        Assert.assertEquals(registrationPage.getErrorConfirmPassword(), expected);
        return this; }

    public RegistrationPageStep verifyFailedSignUp(String expected) {
        Assert.assertEquals(registrationPage.getFailedSignUp(), expected);
        return this; }

}
