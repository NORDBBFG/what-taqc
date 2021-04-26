package step;

import org.testng.Assert;
import page.RegistrationPage;
import org.openqa.selenium.WebDriver;
import test.Constants;

public class RegistrationPageStep {

    private RegistrationPage registrationPage;

    public RegistrationPageStep(WebDriver driver) {
        registrationPage = new RegistrationPage(driver);
    }

    public RegistrationPageStep verifyPageName (String expected){
        Assert.assertEquals(registrationPage.getPageName(), expected);
        return this;}

    public RegistrationPageStep verifyFirstName (String expected){
        registrationPage.fillFirstName(expected);
        return this;}

    public RegistrationPageStep verifyLastName (String expected){
        registrationPage.fillLastName(expected);
        return this;}

    public RegistrationPageStep verifyEmail (String expected){
        registrationPage.fillEmail(expected);
        return this;}

    public RegistrationPageStep verifyPassword (String expected){
        registrationPage.fillPassword(expected);
        return this;}

    public RegistrationPageStep verifyConfirmPassword (String expected){
        registrationPage.fillConfirmPassword(expected);
        return this;}

    public boolean verifySignUpButtonEnable (boolean expected){
        registrationPage.clickSignUpButton();
        return true;}

    public void clickSignUpButton() {registrationPage.clickSignUpButton();}

    public RegistrationPageStep verifySignUpButtonEnable() {
        return null;
    }

    public RegistrationPageStep getRegistrationPage(){
        registrationPage.clickRegistrationLink();
        return this;
    }
}
