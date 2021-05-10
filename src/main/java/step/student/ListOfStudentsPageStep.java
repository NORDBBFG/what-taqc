package step.student;

import org.openqa.selenium.WebDriver;
import page.student.ListOfStudentPage;
import step.BaseStep;

public class ListOfStudentsPageStep extends BaseStep {

    ListOfStudentPage listOfStudentPage;

    public ListOfStudentsPageStep(WebDriver driver){
        listOfStudentPage = new ListOfStudentPage(driver);
    }
}
