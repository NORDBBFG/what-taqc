package test.signin;

import org.testng.annotations.Test;
import test.BaseTest;

public class SignInPageTest extends BaseTest {

    @Test
    public void authorizationValidTest() {
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        signInPageStep.setEmail(email)
                .setPassword(password)
                .clickSignInBtn();
    }
}
