package test.student;

import constants.Constants;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.signin.SignInPage;
import step.student.EditStudentDetailsPageStep;
import step.student.StudentDetailsPageStep;
import test.BaseTest;

public class StudentDetailsTest extends BaseTest {

    StudentDetailsPageStep studentDetailsPageStep;
    EditStudentDetailsPageStep editStudentDetailsPageStep;

    @BeforeMethod
    public void preconditions() {
        SignInPage signInPage = new SignInPage(driver);
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
        signInPage.clickSignInButton();

        studentDetailsPageStep = new StudentDetailsPageStep(driver);
        editStudentDetailsPageStep = new EditStudentDetailsPageStep(driver);
    }

    @Test
    public void studentDetailsLessonsDisplayed_WHAT_197(){

        //step('1')
        // click on current student in the list of students
        driver.findElement(By.xpath("//tr[@data-student-id='5']")).click();

        studentDetailsPageStep
                .verifyListOfLessonsIsDisplayed();
    }

    @Test
    public void studentsPageSwitchBetweenTabs_WHAT_123(){

        //step('1')
        // click "Edit" on a Student
        driver.findElement(By.xpath("(//td/*[name()='svg'])[1]")).click();

        editStudentDetailsPageStep
                .verifyLabelEditStudentsDetails(Constants.PageName.STUDENT_EDIT_DETAILS)
                .verifyFirstName("Голлумм")
                .verifyLastName("Смеагол")
                .verifyEmail("ILoveRings@gmail.com")
                .verifyListOfGroupsIsDisplayed()
        //step('2')
                .clickLabelStudentsDetails()
                .verifyLabelStudentsDetails(Constants.PageName.STUDENT_DETAILS);
        studentDetailsPageStep
                .verifyFirstName("Голлумм")
                .verifyLastName("Смеагол")
                .verifyEmail("ILoveRings@gmail.com")
                .verifyListOfGroupsIsDisplayed();
    }
}
