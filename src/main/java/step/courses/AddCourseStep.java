package step.courses;

import org.openqa.selenium.WebDriver;
import page.courses.AddCoursePage;

public class AddCourseStep {
    private final AddCoursePage addCoursePage;

    public AddCourseStep(WebDriver driver) {
        addCoursePage = new AddCoursePage(driver);
    }

    public void fillCourseNameInput(String courseName){
        addCoursePage.getCourseNameInput().clear();
        addCoursePage.getCourseNameInput().sendKeys(courseName);
    }

    //TODO: fix disabled buttons problem (if there's even a problem).
    public void clickOnCancelCourseAddingBtn() {
        addCoursePage.getCancelCourseAddingBtn().click();
    }

    public void clickOnSubmitNewCourseBtn(){
        addCoursePage.getSubmitNewCourseBtn().click();
    }
}
