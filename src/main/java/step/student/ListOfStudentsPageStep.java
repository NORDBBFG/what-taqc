package step.student;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.student.ListOfStudentPage;
import step.BaseStep;

public class ListOfStudentsPageStep extends BaseStep {

    ListOfStudentPage listOfStudentPage;

    public ListOfStudentsPageStep(WebDriver driver){
        listOfStudentPage = new ListOfStudentPage(driver);
    }

    @FindBy(xpath = "(//td/*[name()='svg'])[1]")
    private WebElement editCurrentStudent;
    @FindBy(xpath = "//tr[@data-student-id='5']")
    private WebElement currentStudent;

    public StudentDetailsPageStep clickCurrentStudent(WebDriver driver){

//        currentStudent.click();
        driver.findElement(By.xpath("//tr[@data-student-id='5']")).click();
        return new StudentDetailsPageStep(driver);
    }

    public EditStudentDetailsPageStep clickEditStudent(WebDriver driver){

//        editCurrentStudent.click();
        driver.findElement(By.xpath("(//td/*[name()='svg'])[1]")).click();
        return new EditStudentDetailsPageStep(driver);
    }
}
