package step.courses;

import org.openqa.selenium.WebDriver;
import page.courses.EditCourseDetailsPage;

public class EditCourseDetailsStep {
    private final EditCourseDetailsPage editCourseDetailsPage;

    public EditCourseDetailsStep(WebDriver driver) {
        editCourseDetailsPage = new EditCourseDetailsPage(driver);
    }

    public void clickOnCourseDetailsTab(){
        editCourseDetailsPage.getCourseDetailsTab().click();
    }

    public void fillEditCourseNameInput(String courseName){
        editCourseDetailsPage.getCourseNameInput().clear();
        editCourseDetailsPage.getCourseNameInput().sendKeys(courseName);
    }
    //TODO: fix disabled buttons problem (if there's even a problem).
    public void clickOnDeleteCourseBtn(){
        editCourseDetailsPage.getDeleteCourseBtn().click();
    }

    public void clickOnResetEditCourseNameInputBtn(){
        editCourseDetailsPage.getResetEditCourseNameInputBtn().click();
    }

    public void clickOnSubmitEditedCourseNameBtn(){
        editCourseDetailsPage.getSubmitEditedCourseNameBtn().click();
    }
}
