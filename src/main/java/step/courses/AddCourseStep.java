package step.courses;

import org.openqa.selenium.WebDriver;
import page.courses.AddCoursePage;

public class AddCourseStep {
    private final AddCoursePage addCoursePage;

    public AddCourseStep(WebDriver driver) {
        addCoursePage = new AddCoursePage(driver);
    }

    public AddCourseStep fillCourseNameInput(String courseName){
        addCoursePage.getCourseNameInput().clear();
        addCoursePage.getCourseNameInput().sendKeys(courseName);
      return this;
    }

    //TODO: fix disabled buttons problem (if there's even a problem).
    public AddCourseStep clickOnCancelCourseAddingBtn() {
        addCoursePage.getCancelCourseAddingBtn().click();
      return this;
    }

    public AddCourseStep clickOnSubmitNewCourseBtn(){
        addCoursePage.getSubmitNewCourseBtn().click();
      return this;
    }
}
