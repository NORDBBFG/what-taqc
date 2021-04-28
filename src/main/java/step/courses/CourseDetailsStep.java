package step.courses;

import org.openqa.selenium.WebDriver;
import page.courses.CourseDetailsPage;

public class CourseDetailsStep {
    private final CourseDetailsPage courseDetailsPage;

    public CourseDetailsStep(WebDriver driver){
        courseDetailsPage = new CourseDetailsPage(driver);
    }

        //TODO: make verify methods list for expected conditions.

    public EditCourseDetailsStep clickEditCourseDetailsTab(){
        courseDetailsPage.clickEditCourseDetailsTab();
      return new EditCourseDetailsStep(courseDetailsPage.getDriver());
    }
}
