package ui_tests.signin;

import org.testng.annotations.Test;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

public class SignInPageTest extends BaseTest {

    @Test
    public void authorizationValidTest() {
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        signInPageStep
                .setEmail(email)
                .setPassword(password)
                .clickSignInBtn(ListOfStudentsPageStep.class, driver);
    }
}
