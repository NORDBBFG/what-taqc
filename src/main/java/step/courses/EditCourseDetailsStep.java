package step.courses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.courses.EditCourseDetailsPage;
import step.BaseStep;

public class EditCourseDetailsStep extends BaseStep {
    private final EditCourseDetailsPage editCourseDetailsPage;

    public EditCourseDetailsStep(WebDriver driver) {
        editCourseDetailsPage = new EditCourseDetailsPage(driver);
    }

        //TODO: make verify methods list for expected conditions.

    public EditCourseDetailsStep verifySubmitBtnEnabled(boolean expected){
        Assert.assertEquals(editCourseDetailsPage.isSubmitBtnEnabled(), expected);
      return this;
    }
    public EditCourseDetailsStep verifyResetEditCourseNameInputBtnEnabled(boolean expected){
        Assert.assertEquals(editCourseDetailsPage.isResetEditCourseNameInputBtnEnabled(), expected);
      return this;
    }
    public EditCourseDetailsStep verifyDeleteCourseBtnEnabled(boolean expected){
        Assert.assertEquals(editCourseDetailsPage.isDeleteCourseBtnEnabled(), expected);
      return this;
    }

    public CourseDetailsStep clickOnCourseDetailsTab(){
        editCourseDetailsPage.clickCourseDetailsTab();
      return new CourseDetailsStep(editCourseDetailsPage.getDriver());
    }
    public EditCourseDetailsStep fillEditCourseNameInput(String courseName){
        editCourseDetailsPage.fillEditCourseNameInput(courseName);
      return this;
    }

        //TODO: make sure that it's a valid solution.
    public BaseStep clickOnDeleteCourseBtn(){
        editCourseDetailsPage.clickDeleteCourseBtn();
        editCourseDetailsPage.clickConfirmDeleteCourseBtn();
        if (editCourseDetailsPage.isCourseDeletionFailed()) return this;
        else return new CoursesStep(editCourseDetailsPage.getDriver());
    }

    public EditCourseDetailsStep clickOnResetEditCourseNameInputBtn(){
        editCourseDetailsPage.clickResetEditCourseNameInputBtn();
      return this;
    }

        //TODO: make sure that it's a valid solution.
    public BaseStep clickOnSubmitEditedCourseNameBtn(){
        editCourseDetailsPage.clickSubmitEditedCourseNameBtn();
      if (editCourseDetailsPage.isEditCourseSubmitFailed()) return this;
      else return new CoursesStep(editCourseDetailsPage.getDriver());
    }
}
