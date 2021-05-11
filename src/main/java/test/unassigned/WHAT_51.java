package test.unassigned;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.signin.SignInPage;
import step.unassigned.UnassignedUsersStep;
import test.BaseTest;

import static constants.Constants.UnassignedUsersSelectRole.*;
import static constants.Constants.UnassignedUsersSort.*;

public class WHAT_51 extends BaseTest {
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
    public void atc_WHAT_51(){
        String mailOfUser = "abbadabba@gmail.com";
        String expectedSurnameUser = "Dabba";


        coursesStep.verifySurnameUser(1, expectedSurnameUser)
                   .verifySurnameUser(mailOfUser, expectedSurnameUser)

                   .verifyAddRoleButtonEnabled(1, true)
                   .verifyChoseSortEnabled(SYMBOL, true)

                   .verifyChoseUserRole(1, CHOOSE, true)
                   .choseUserRole(1, CHOOSE);
        coursesStep.choseSortType(SYMBOL);
        coursesStep.verifyChoseSortEnabled(SYMBOL, true)
                   .verifyChoseUserRole(1, CHOOSE, true);

    }
}
