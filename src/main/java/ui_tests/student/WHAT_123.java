package ui_tests.student;

import constants.Constants;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

public class WHAT_123 extends BaseTest {

    String email = "admin.@gmail.com";
    String password = "admiN_12";
    String firstName = "student";
    String lastName = "student";
    String emailStudent = "student@gmail.com";

    @Test
    public void verifyStudentsPageSwitchBetweenTabs(){

        // step('preconditions')
        signInPageStep
                .setEmail(email)
                .setPassword(password)
                .clickSignInBtn(ListOfStudentsPageStep.class, driver)
                .clickStudentsSidebar(ListOfStudentPage.class, driver)
        // step('1')
                .clickEditStudent(driver)
                .verifyLabelEditStudentsDetails(Constants.PageName.STUDENT_EDIT_DETAILS)
                .verifyFirstName(firstName)
                .verifyLastName(lastName)
                .verifyEmail(emailStudent)
                .verifyListOfGroupsIsDisplayed()
        // step('2')
                .clickLabelStudentsDetails(driver)
                .verifyLabel(Constants.PageName.STUDENT_DETAILS)
                .verifyFirstName(firstName)
                .verifyLastName(lastName)
                .verifyEmail(emailStudent)
                .verifyListOfGroupsIsDisplayed();
    }
}
