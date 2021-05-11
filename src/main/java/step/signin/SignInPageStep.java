package step.signin;

import constants.Classes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.signin.SignInPage;
import step.BaseStep;
import step.Step;
import step.group.ListOfGroupsPageStep;
import step.student.ListOfStudentsPageStep;
import step.support.SupportPageStep;

public class SignInPageStep extends Step {

    SignInPage signInPage;

    public SignInPageStep(WebDriver driver) {
        signInPage = new SignInPage(driver);
    }

    public SignInPageStep setEmail(String email) {
        signInPage.fillEmail(email);
        return this;
    }

    public SignInPageStep setPassword(String password) {
        signInPage.fillPassword(password);
        return this;
    }

    public SignInPageStep verifyEmail(String expected) {
        Assert.assertEquals(signInPage.getEmail(), expected);
        return this;
    }

    public SignInPageStep verifyPassword(String expected) {
        Assert.assertEquals(signInPage.getPassword(), expected);
        return this;
    }

    public <T extends BaseStep> T clickSignInBtn(Class<? extends BaseStep> context, WebDriver driver) {
        signInPage.clickSignInButton();
        switch (context.getName()) {
            case Classes.Steps.LIST_OF_STUDENTS_PAGE_STEP:
                return (T) new ListOfStudentsPageStep(driver);
            case Classes.Steps.SUPPORT_PAGE_STEP:
                return (T) new SupportPageStep(driver);
            case Classes.Steps.LIST_OF_GROUPS_PAGE_STEP:
                driver.findElement(By.xpath("//a[@href='/groups']")).click();
                return (T) new ListOfGroupsPageStep(driver);
            default:
                throw new RuntimeException("SignInPage not redirecting to this context");
        }
    }

    public SignInPageStep clickSignInBtnNotSuccessful() {
        signInPage.clickSignInButton();
        return this;
    }

}
