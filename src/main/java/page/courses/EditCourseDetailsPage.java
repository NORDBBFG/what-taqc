package page.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import static constants.XPath.Common.*;
import static constants.XPath.EditCourseDetailsPage.*;

public class EditCourseDetailsPage extends BasePage {

    @FindBy(xpath = COURSE_NAME_INPUT)
    private WebElement courseNameInput;
    @FindBy(xpath = SAVE_BUTTON)
    private WebElement submitEditedCourseNameBtn;
    @FindBy(xpath = COURSE_DETAILS_TAB)
    private WebElement courseDetailsTab;
    @FindBy(xpath = DELETE_COURSE_BTN)
    private WebElement deleteCourseBtn;
    @FindBy(xpath = RESET_BUTTON)
    private WebElement resetEditCourseNameInputBtn;
    @FindBy(xpath = FAILED_COURSE_DELETION_ALERT)
    private WebElement failedCourseDeletionAlert;
    @FindBy(xpath = FAILED_EDIT_COURSE_SUBMIT_ALERT)
    private WebElement failedEditCourseSubmitAlert;
    @FindBy(xpath = CONFIRM_COURSE_DELETE_BTN)
    private WebElement confirmCourseDeleteBtn;
    @FindBy(xpath = H3)
    private WebElement pageHeader;

    public EditCourseDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickCourseDetailsTab(){
        courseDetailsTab.click();
    }

    public void fillEditCourseNameInput(String courseName){
        courseNameInput.clear();
        // Problem is here.
        courseNameInput.sendKeys(courseName);
    }

    public void clearEditCourseNameInput(){
        courseNameInput.clear();
    }

    public void clickDeleteCourseBtn(){
        deleteCourseBtn.click();
    }

    public void clickConfirmDeleteCourseBtn(){
        confirmCourseDeleteBtn.click();
    }

    public void clickResetEditCourseNameInputBtn(){
        resetEditCourseNameInputBtn.click();
    }

    public void clickSubmitEditedCourseNameBtn(){
        submitEditedCourseNameBtn.click();
    }

    public boolean isCourseDeletionFailed(){
        return failedCourseDeletionAlert.isDisplayed();
    }

    public boolean isEditCourseSubmitFailed(){
        return failedCourseDeletionAlert.isDisplayed();
    }

    public boolean isSubmitBtnEnabled(){
        return submitEditedCourseNameBtn.isEnabled();
    }

    public boolean isResetEditCourseNameInputBtnEnabled(){
        return resetEditCourseNameInputBtn.isEnabled();
    }

    public boolean isDeleteCourseBtnEnabled(){
        return deleteCourseBtn.isEnabled();
    }

    public String getPageHeaderNameText(){
        return pageHeader.getText();
    }

    public String getEditCourseInputValue() throws InterruptedException{
        Thread.sleep(1000);
        return courseNameInput.getAttribute("value");
    }
}