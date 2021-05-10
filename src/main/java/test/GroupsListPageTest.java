package test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SignInPage;
import step.CoursesListPageStep;

public class GroupsListPageTest extends AbstractTest{
    CoursesListPageStep coursesListPageStep;

    @BeforeMethod
    public void prepare() {
        SignInPage signInPage = new SignInPage(driver);
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
        signInPage.clickSignInButton();
        driver.findElement(By.xpath("//a[@data-id='4']")).click();

        coursesListPageStep = new CoursesListPageStep(driver);
    }

    @Test
    public void checkIfTableSortedByRowNumber() throws InterruptedException {

        coursesListPageStep
                .assertSortedByRowNumber();
    }

}
