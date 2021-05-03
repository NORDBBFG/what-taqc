package test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SignInPage;
import step.LessonDetailsPageStep;

public class LessonDetailsPageTest extends AbstractTest{
    LessonDetailsPageStep lessonDetailsPageStep;

    @BeforeMethod
    public void prepare() {
        SignInPage signInPage = new SignInPage(driver);
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
        signInPage.clickSignInButton();
        driver.findElement(By.xpath("//a[@data-id='3']")).click();
        driver.findElement(By.xpath("//tr[@id='1']")).click();

        lessonDetailsPageStep = new LessonDetailsPageStep(driver);
    }

    @Test
    public void checkInfoAboutLessonTest() {
        String themeName = "Types";
        String groupName = "Griffindorrr";
        String mentorName = "Леголас New";
        String lessonDate = "2020-02-01";
        String lessonTime = "00:00:00";

        lessonDetailsPageStep
                .verifyNamePage(Constants.PageName.LESSON_DETAILS)
                .verifyThemeName(themeName)
                .verifyGroupName(groupName)
                .verifyMentorName(mentorName)
                .verifyDate(lessonDate)
                .verifyTime(lessonTime)
                .clickCancelButton(driver);
    }

    @Test
    public void checkInfoAboutStudentTest() {
        String fullName = "Pavel Kundenko";
        String mark = "11";
        int studentId = 1;

        lessonDetailsPageStep
                .verifyCancelButtonEnabled(true)
                .verifyFullStudentName(studentId,fullName)
                .verifyMark(studentId, mark)
                .verifyPresence(studentId,true)
                .getToMentorDetailsPage();
//                .getToGroupDetailsPage();
//                .getToStudentDetailsPage(studentId);

    }
}
