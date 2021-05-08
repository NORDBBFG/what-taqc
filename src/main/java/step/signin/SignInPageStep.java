package step.signin;

import constants.Classes;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.signin.SignInPage;
import step.BaseStep;
import step.student.ListOfStudentsPageStep;

public class SignInPageStep {

    SignInPage signInPage;

    public SignInPageStep(WebDriver driver) {
        signInPage = new SignInPage(driver);
    }

    public SignInPageStep setEmail(String email){
        signInPage.fillEmail(email);
        return this;
    }

    public SignInPageStep setPassword(String password){
        signInPage.fillPassword(password);
        return this;
    }

    public SignInPageStep verifyEmail(String expected){
        Assert.assertEquals(signInPage.getEmail(),expected);
        return this;
    }

    public SignInPageStep verifyPassword(String expected){
        Assert.assertEquals(signInPage.getPassword(),expected);
        return this;
    }

    public void clickSignInBtn(){
        signInPage.clickSignInButton();
    }

    public <T extends BaseStep> T clickSignInBtn(Class<? extends BaseStep> context, WebDriver driver){
        signInPage.clickSignInButton();
        switch (context.getName()){
            case Classes.Steps.LIST_OF_STUDENTS_PAGE_STEP:
                return (T) new ListOfStudentsPageStep(driver);
            default:
                return null;
        }
    }

}
