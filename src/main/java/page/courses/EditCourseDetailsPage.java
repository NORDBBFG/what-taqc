package page.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

public class EditCourseDetailsPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class,'nav-tabs')]/a[1]")
    private WebElement CourseDetailsTab;
    @FindBy(xpath = "//input[@id='name']")
    private WebElement CourseNameInput;     //TODO: an element with such xpath repeats in the AddCoursePage, so it needs to be moved.
    @FindBy(xpath = "//button[contains(@class,'remove-button')]")
    private WebElement DeleteCourseBtn;
    @FindBy(xpath = "//button[@type='reset']")
    private WebElement ResetEditCourseNameInputBtn;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement SubmitEditedCourseNameBtn;

    public EditCourseDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCourseDetailsTab(){
        CourseDetailsTab.click();
    }

    public void fillEditCourseNameInput(String courseName){
        CourseNameInput.clear();
        CourseNameInput.sendKeys(courseName);
    }
        //TODO: fix disabled buttons problem (if there's even a problem).
    public void clickOnDeleteCourseBtn(){
        DeleteCourseBtn.click();
    }

    public void clickOnResetEditCourseNameInputBtn(){
        ResetEditCourseNameInputBtn.click();
    }

    public void clickOnSubmitEditedCourseNameBtn(){
        SubmitEditedCourseNameBtn.click();
    }
}
