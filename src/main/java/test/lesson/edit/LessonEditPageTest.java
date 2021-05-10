package test.lesson.edit;

import constants.Constants;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import test.BaseTest;

public class LessonEditPageTest extends BaseTest {

    @Test
    public void exampleLessonTest() {
        String email = "admin.@gmail.com";
        String password = "admiN_12";
        String themeName = "Types";
        String groupName = "Griffindorrr";
        String fullName = "Pavel Kundenko";
        String mark = "11";
        int studentId = 1;

        signInPageStep
                .setEmail(email)
                .setPassword(password)
                .clickSignInBtn(ListOfStudentsPageStep.class,driver)
                .clickLessonSidebar(ListOfStudentPage.class,driver)
                .clickLessonEdit(1, driver)
                .verifyNamePage(Constants.PageName.LESSON_EDIT)
                .verifyThemeName(themeName)
                .verifyThemeNameEnabled(true)
                .verifyGroupName(groupName)
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
