package test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SignInPage;
import step.StudentDetailsPageStep;

public class StudentDetailsTest extends AbstractTest {

    StudentDetailsPageStep studentDetailsPageStep;

    @BeforeMethod
    public void preconditions() {
        SignInPage signInPage = new SignInPage(driver);
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
        signInPage.clickSignInButton();

        studentDetailsPageStep = new StudentDetailsPageStep(driver);

        // click on current student in the list of students
        driver.findElement(By.xpath("//tr[@data-student-id='5']")).click();
    }

    @Test
    public void checkListOfLessonsNotDisplayed_tc198(){

        studentDetailsPageStep
                .verifyListOfLessonsIsDisplayed();
    }
}
