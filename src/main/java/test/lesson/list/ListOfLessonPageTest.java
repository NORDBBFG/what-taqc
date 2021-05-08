package test.lesson.list;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.signin.SignInPage;
import step.lesson.ListOfLessonPageStep;
import test.BaseTest;
import constants.Constants;

public class ListOfLessonPageTest extends BaseTest {

    ListOfLessonPageStep listOfLessonPageStep;

    @BeforeMethod
    public void prepare() {
        SignInPage signInPage = new SignInPage(driver);
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
        signInPage.clickSignInButton();
        driver.findElement(By.xpath("//a[@data-id='3']")).click();

        listOfLessonPageStep = new ListOfLessonPageStep(driver);
    }

    @Test
    public void checkInfoAboutLessonTest() {
        String count = "19 lessons";
        String themeName = "Types";
        String date = "Sat Feb 01 2020";
        String time = "00:00:00";

        listOfLessonPageStep
                .verifyNamePage(Constants.PageName.LESSON_LIST)
                .verifyAddLessonBtnEnabled(true)
                .verifyButtonPageEnabled(1, true)
                .verifyButtonPageEnabled(2,true)
                .verifyCountOfLessons(count)
                .verifyRowCellText(1,1, themeName)
                .verifyRowCellText(1,2, date)
                .verifyRowCellText(1, 3, time)
                .clickLessonDetails(1, driver)
                .verifyNamePage(Constants.PageName.LESSON_DETAILS)
                .verifyTime(time)
                .verifyThemeName(themeName)
                .clickCancelButton(driver)
                .clickLessonEdit(1,driver)
                .verifyNamePage(Constants.PageName.LESSON_EDIT)
                .verifyThemeNameEnabled(true)
                .verifyThemeName(themeName)
                .clickCancelButton(driver)
                .clickSorting(1);

    }

}
