package step.courses;

import org.openqa.selenium.WebDriver;
import page.courses.EditCourseDetailsPage;

public class EditCourseDetailsStep {
    private final EditCourseDetailsPage editCourseDetailsPage;

    public EditCourseDetailsStep(WebDriver driver) {
        editCourseDetailsPage = new EditCourseDetailsPage(driver);
    }

    public EditCourseDetailsStep clickOnCourseDetailsTab(){
        editCourseDetailsPage.getCourseDetailsTab().click();
      return this;
    }

    public EditCourseDetailsStep fillEditCourseNameInput(String courseName){
        editCourseDetailsPage.getCourseNameInput().clear();
        editCourseDetailsPage.getCourseNameInput().sendKeys(courseName);
      return this;
    }

    //TODO: fix disabled buttons problem (if there's even a problem).
    public EditCourseDetailsStep clickOnDeleteCourseBtn(){
        editCourseDetailsPage.getDeleteCourseBtn().click();
      return this;
    }

    public EditCourseDetailsStep clickOnResetEditCourseNameInputBtn(){
        editCourseDetailsPage.getResetEditCourseNameInputBtn().click();
      return this;
    }

    public EditCourseDetailsStep clickOnSubmitEditedCourseNameBtn(){
        editCourseDetailsPage.getSubmitEditedCourseNameBtn().click();
      return this;
    }
}
