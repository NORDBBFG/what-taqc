package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SignInPage;

public class SignInPageTest extends BaseTest {

    SignInPage signInPage;

    @BeforeMethod
    public void prepare() {
        signInPage = new SignInPage(driver);
    }

    @Test
    public void authorizationValidTest() {
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
    }
}
