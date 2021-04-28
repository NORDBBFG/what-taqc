package test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SignInPage;
import step.LessonEditPageStep;

public class LessonEditPageTest extends BaseTest {
    LessonEditPageStep lessonEditPageStep;

    @BeforeMethod
    public void prepare() {
        SignInPage signInPage = new SignInPage(driver);
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
        signInPage.clickSignInButton();
        driver.findElement(By.xpath("//a[@data-id='3']")).click();
        driver.findElement(By.xpath("//tr[@id='1']//*[name()='svg']")).click();

        lessonEditPageStep = new LessonEditPageStep(driver);
    }

    @Test
    public void checkInfoAboutLessonTest() {
        String themeName = "Types";
        String groupName = "Griffindorrr";

        lessonEditPageStep
                .verifyNamePage(Constants.PageName.LESSON_EDIT)
                .verifyThemeName(themeName)
                .verifyGroupName(groupName);
    }

    @Test
    public void checkInfoAboutStudentTest() {
        String fullName = "Pavel Kundenko";
        String mark = "11";
        int studentId = 1;

        lessonEditPageStep
                .verifyThemeNameEnabled(true)
                .verifyGroupNameEnabled(false)
                .verifyDateInputEnabled(true)
                .verifyCancelButtonEnabled(true)
                .verifySaveButtonEnabled(true)
                .verifyFullStudentName(studentId,fullName)
                .verifyMark(studentId, mark)
                .verifyPresence(studentId,true)
                .getToStudentDetailsPage(studentId);

    }

}
