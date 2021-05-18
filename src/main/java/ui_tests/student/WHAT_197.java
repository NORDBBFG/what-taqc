package ui_tests.student;

import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

public class WHAT_197 extends BaseTest {

    String email = "admin.@gmail.com";
    String password = "admiN_12";

    @Test
    public void verifyStudentDetailsLessonsDisplayed(){

        // step('preconditions')
        signInPageStep
                .setEmail(email)
                .setPassword(password)
                .clickSignInBtn(ListOfStudentsPageStep.class, driver)
                .clickStudentsSidebar(ListOfStudentPage.class, driver)
        // step('1')
                .clickCurrentStudent(driver)
                .verifyListOfLessonsIsDisplayed();
    }
}
