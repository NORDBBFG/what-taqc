package step.courses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.courses.AddCoursePage;

public class AddCourseStep {
    private final AddCoursePage addCoursePage;

    public AddCourseStep(WebDriver driver) {
        addCoursePage = new AddCoursePage(driver);
    }

    public AddCourseStep verifyPageHeaderText(String expected){
        Assert.assertEquals(addCoursePage.getPageHeaderText(), expected);
      return this;
    }

    public AddCourseStep verifySubmitButtonEnabled(boolean expected){
        Assert.assertEquals(addCoursePage.isSubmitBtnEnabled(), expected);
      return this;
    }

    public AddCourseStep verifyInvalidCourseMessageText(String expected){
        Assert.assertEquals(addCoursePage.getInvalidCourseNameError(), expected);
      return this;
    }

    public AddCourseStep fillCourseNameInput(String courseName) throws InterruptedException {
        addCoursePage.fillCourseNameInput(courseName);
      return this;
    }

    public CoursesStep clickCancelCourseAddingBtn(WebDriver driver) {
        addCoursePage.clickCancelCourseAddingBtn();
      return new CoursesStep(driver);
    }

    public CoursesStep clickSubmitNewCourseBtn(WebDriver driver){
        addCoursePage.clickSubmitNewCourseBtn();
      return new CoursesStep(driver);
    }
}
