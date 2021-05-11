package test.unassigned;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.signin.SignInPage;
import step.unassigned.UnassignedUsersStep;
import test.BaseTest;

import static constants.Constants.UnassignedUsersSelectRole.*;
import static constants.Constants.UnassignedUsersSort.*;

public class WHAT_54 extends BaseTest {
    UnassignedUsersStep coursesStep;
    SignInPage signInPage;
    @BeforeClass
    public void preCond(){
        signInPage = new SignInPage(driver);
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
        signInPage.clickSignInButton();
        coursesStep = new UnassignedUsersStep(driver);
    }

    @Test
    public void atc_WHAT_54(){
        String mailOfUser = "abbadabba@gmail.com";
        String expectedSurnameUser = "Dabba";


        coursesStep.verifySurnameUser(1, expectedSurnameUser)
                   .verifySurnameUser(mailOfUser, expectedSurnameUser)

                   .verifyAddRoleButtonEnabled(1, true)
                   .verifyChoseSortEnabled(EMAIL, true)

                   .verifyChoseUserRole(1, SECRETARY, true)
                   .choseUserRole(1, SECRETARY);
        coursesStep.choseSortType(EMAIL);
        coursesStep.verifyChoseSortEnabled(EMAIL, true)
                   .verifyChoseUserRole(1, SECRETARY, true);

    }
}
