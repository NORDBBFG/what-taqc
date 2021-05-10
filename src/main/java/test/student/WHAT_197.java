package test.student;

import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import test.BaseTest;

public class WHAT_197 extends BaseTest {

    @Test
    public void verifyStudentDetailsLessonsDisplayed(){

        String email = "admin.@gmail.com";
        String password = "admiN_12";

        // step('preconditions')
        signInPageStep
                .setEmail(email)
                .setPassword(password)
                .clickSignInBtn(ListOfStudentsPageStep.class, driver)
                .clickStudentsSidebar(ListOfStudentPage.class, driver)
        // step('1')
                .clickCurrentStudent(driver)
                .verifyListOfGroupsIsDisplayed();
    }
}
