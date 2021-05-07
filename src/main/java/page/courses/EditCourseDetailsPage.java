package page.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

public class EditCourseDetailsPage extends BasePage {
        //TODO: this elements repeat in the EditCourseDetailsPage, can be moved.
    @FindBy(xpath = "//input")
    private WebElement courseNameInput;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitEditedCourseNameBtn;

    @FindBy(xpath = "//div[contains(@class,'nav-tabs')]/a[1]")
    private WebElement courseDetailsTab;
    @FindBy(xpath = "//button[contains(@class,'remove-button')]")
    private WebElement deleteCourseBtn;
    @FindBy(xpath = "//button[@type='reset']")
    private WebElement resetEditCourseNameInputBtn;
    @FindBy(xpath = "//div[@role='alert' and contains(text(),'not found') or contains(text(),'active')]")
    private WebElement failedCourseDeletionAlert;
    @FindBy(xpath = "//div[@role='alert' and contains(text(),'Inactive') or contains(text(),'included')]")
    private WebElement failedEditCourseSubmitAlert;
    @FindBy(xpath = "//button[contains(@class,'btn-danger')]")
    private WebElement confirmCourseDeleteBtn;
    @FindBy(xpath = "//h3")
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
