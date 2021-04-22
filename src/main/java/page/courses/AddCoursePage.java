package page.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

public class AddCoursePage extends AbstractPage {
    @FindBy(xpath = "//input[@id='name']")      //TODO: repeats in the EditCourseDetailsPage, can be moved.
    private WebElement CourseNameInput;
    @FindBy(xpath = "//div[contains(@class,'d-flex')]/a[.='Cancel']")
    private WebElement CancelCourseAddingBtn;
    @FindBy(xpath = "//button[@type='submit']")     //TODO: repeats in the EditCourseDetailsPage, can be moved.
    private WebElement SubmitNewCourseBtn;

    public AddCoursePage(WebDriver driver) {
        super(driver);
    }

    public void fillCourseNameInput(String courseName){
        CourseNameInput.clear();
        CourseNameInput.sendKeys(courseName);
    }

        //TODO: fix disabled buttons problem (if there's even a problem).
    public void clickOnCancelCourseAddingBtn() {
        CancelCourseAddingBtn.click();
    }

    public void clickOnSubmitNewCourseBtn(){
        SubmitNewCourseBtn.click();
    }
}
