package step.myprofile;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.myprofile.MyProfilePage;
import step.BaseStep;
import step.changepassword.ChangePasswordPageSteps;

public class MyProfilePageStep extends BaseStep {

    private MyProfilePage myProfilePage;

    public MyProfilePageStep(WebDriver driver){
        myProfilePage = new MyProfilePage(driver);
    }

    public MyProfilePageStep verifyPageName(String expected){
        Assert.assertEquals(myProfilePage.getNameOfPage(), expected);
        return this;
    }

    public MyProfilePageStep verifyFirstName(String expected){
        Assert.assertEquals(myProfilePage.getFirstName(), expected);
        return this;
    }

    public MyProfilePageStep verifyLastName(String expected){
        Assert.assertEquals(myProfilePage.getLastName(), expected);
        return this;
    }

    public MyProfilePageStep verifyEmailAddress(String expected){
        Assert.assertEquals(myProfilePage.getEmailAddress(), expected);
        return this;
    }

    public MyProfilePageStep verifyChangePasswordBtnEnabled(boolean expected){
        Assert.assertEquals(myProfilePage.isChangePasswordEnable(), expected);
        return this;
    }

    public MyProfilePageStep verifyChangePasswordBtnEnabled(){
        Assert.assertTrue(myProfilePage.isChangePasswordEnable());
        return this;
    }

    public ChangePasswordPageSteps clickChangePasswordBtn(WebDriver driver){
        myProfilePage.clickChangePasswordBtn();
        return new ChangePasswordPageSteps(driver);
    }

}
