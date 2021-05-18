package ui_tests.lesson.edit;

import constants.Constants;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

/**
 * Description of test
 */

public class WHAT_201 extends BaseTest {

    //TODO parametrized and randomized
    @Test
    public void atc_WHAT_201() {
        //admin, mentors
        String email = "admin.@gmail.com";
        String password = "admiN_12";
        int lessonId = 1;
        String oldName = "Types";
        String newName = "nameLessonNew";
        String dateTime = "080520212154";

        // step('preconditions')
        signInPageStep
                .setEmail(email)
                .setPassword(password)
                .clickSignInBtn(ListOfStudentsPageStep.class,driver)
                .clickLessonSidebar(ListOfStudentPage.class, driver)
                .verifyNamePage(Constants.PageName.LESSON_LIST)
                .verifyRowCellText(lessonId,1, oldName)
        // step('1')
                .clickLessonEdit(lessonId,driver)
                .setThemeName(newName)
                .setDateInput(dateTime);
        // step('2')
//                .clickSaveButton(new ListOfLessonPageStep(driver),driver)
//                .verifyRowCellText(lessonId,2, newName);
    }

}
