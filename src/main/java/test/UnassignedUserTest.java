package test;

        import component.WebElements;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.Test;
        import page.SignInPage;
        import step.UnassignedUsersStep;

        import component.WebElements.UnassignedUsersRole;

public class UnassignedUserTest extends AbstractTest {
    UnassignedUsersStep coursesStep;
    SignInPage signInPage;
    @BeforeTest
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
                   .choseUserChoseRole(1, UnassignedUsersRole.STUDENT )
                   .choseUserSort(WebElements.UnassignedUsersSort.SYMBOL);


    }
}
