package step.courses;

import org.openqa.selenium.WebDriver;
import page.courses.CourseDetailsPage;

public class CourseDetailsStep {
    private final CourseDetailsPage courseDetailsPage;

    public CourseDetailsStep(WebDriver driver){
        courseDetailsPage = new CourseDetailsPage(driver);
    }

    public void clickOnEditCourseDetailsTab(){
        courseDetailsPage.getEditCourseDetailsTab().click();
    }
}
