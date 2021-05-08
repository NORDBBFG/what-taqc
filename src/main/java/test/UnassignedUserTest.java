package test;

        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;
        import page.SignInPage;
        import step.UnassignedUsersStep;

        import component.WebElements.UnassignedUsersRole;
        import component.WebElements.UnassignedUsersSort;

public class UnassignedUserTest extends AbstractTest {
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
    public void ChoseUserRole(){
        String mailOfUser = "abbadabba@gmail.com";
        String expectedSurnameUser = "Dabba";


        coursesStep.verifySurnameUser(1, expectedSurnameUser)
                   .verifySurnameUser(mailOfUser, expectedSurnameUser)

                   .verifyAddRoleButtonEnabled(1, true)
                   .verifyChoseSortEnabled(UnassignedUsersSort.NAME, true)
                   .verifyChoseUserRole(1, UnassignedUsersRole.STUDENT, true)
                   .choseUserRole(1, UnassignedUsersRole.STUDENT);
        coursesStep.choseSortType(UnassignedUsersSort.NAME);


    }
}
