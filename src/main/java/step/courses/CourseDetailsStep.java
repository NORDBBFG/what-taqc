package step.courses;

import org.openqa.selenium.WebDriver;
import page.courses.CourseDetailsPage;

public class CourseDetailsStep {
    private final CourseDetailsPage courseDetailsPage;

    public CourseDetailsStep(WebDriver driver){
        courseDetailsPage = new CourseDetailsPage(driver);
    }

    public CourseDetailsStep clickOnEditCourseDetailsTab(){
        courseDetailsPage.getEditCourseDetailsTab().click();
      return this;
    }
}
