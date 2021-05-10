package test.unassigned;

import constants.Constants;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.signin.SignInPage;
import step.unassigned.UnassignedUsersStep;
import test.BaseTest;

public class UnassignedUserTest extends BaseTest {

    UnassignedUsersStep coursesStep;
    SignInPage signInPage;

    @BeforeTest
    public void preCond() {
        signInPage = new SignInPage(driver);
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
        signInPage.clickSignInButton();
        coursesStep = new UnassignedUsersStep(driver);
    }

    @Test
    public void ChoseUserRole() {
        String mailOfUser = "abbadabba@gmail.com";
        String expectedSurnameUser = "Dabba";

        coursesStep.verifySurnameUser(1, expectedSurnameUser)
                .verifySurnameUser(mailOfUser, expectedSurnameUser)
                .choseUserChoseRole(1, Constants.UnassignedUsersSelectRole.STUDENT)
                .choseUserSort(Constants.UnassignedUsersSort.SYMBOL);
    }
}
