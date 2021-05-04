package step.courses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.courses.AddCoursePage;

public class AddCourseStep {
    private final AddCoursePage addCoursePage;

    public AddCourseStep(WebDriver driver) {
        addCoursePage = new AddCoursePage(driver);
    }

        //TODO: make verify methods list for expected conditions.

    public AddCourseStep verifySubmitButtonEnabled(boolean expected){
        Assert.assertEquals(addCoursePage.isSubmitBtnEnabled(), expected);
      return this;
    }
    public AddCourseStep fillCourseNameInput(String courseName){
        addCoursePage.fillCourseNameInput(courseName);
      return this;
    }
    public CoursesStep clickCancelCourseAddingBtn() {
        addCoursePage.clickCancelCourseAddingBtn();
      return new CoursesStep(addCoursePage.getDriver());
    }
    public CoursesStep clickSubmitNewCourseBtn(){
        addCoursePage.clickSubmitNewCourseBtn();
      return new CoursesStep(addCoursePage.getDriver());
    }
}
