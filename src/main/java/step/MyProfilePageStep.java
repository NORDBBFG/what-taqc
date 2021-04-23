package step;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.MyProfilePage;
import test.Constants;

public class MyProfilePageStep {

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

    public void clickChangePasswordBtn(){
        myProfilePage.clickChangePasswordBtn();
    }


    public MyProfilePageStep getToMyProfilePage(){
       myProfilePage.clickArrowIcon();
       myProfilePage.clickDropdownItem(Constants.PageName.MY_PROFILE);
       return this;
    }

}
