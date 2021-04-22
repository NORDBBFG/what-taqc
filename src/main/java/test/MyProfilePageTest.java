package test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.SignInPage;
import step.MyProfilePageStep;

public class MyProfilePageTest extends AbstractTest{

    MyProfilePageStep myProfilePageStep;

    @BeforeMethod
    public void prepare() {
        SignInPage signInPage = new SignInPage(driver);
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
        signInPage.clickSignInButton();

        driver.findElement(By.xpath("//a[@class='header__header__account-user--icon___1k48U']")).click();
        myProfilePageStep = new MyProfilePageStep(driver);
    }

    @Test
    public void dataMyProfileOfCurrentUserTest() {
        String firstName="admin";
        String lastName="admin";
        String email = "admin.@gmail.com";

        myProfilePageStep
                .verifyPageName(Constants.PageName.MY_PROFILE)
                .verifyFirstName(firstName)
                .verifyLastName(lastName)
                .verifyEmailAddress(email);
    }

    @Test
    public void clickChangeButtonTest() {
        myProfilePageStep
                .verifyChangePasswordBtnEnabled()
                .clickChangePasswordBtn();
    }

}
