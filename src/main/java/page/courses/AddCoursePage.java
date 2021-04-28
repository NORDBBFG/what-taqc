package page.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

public class AddCoursePage extends BasePage {
        //TODO: this elements repeat in the EditCourseDetailsPage, can be moved.
    @FindBy(xpath = "//input[@id='name']")
    private WebElement courseNameInput;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitNewCourseBtn;

    @FindBy(xpath = "//div[contains(@class,'d-flex')]/a[.='Cancel']")
    private WebElement CancelCourseAddingBtn;

    public AddCoursePage(WebDriver driver) {
        super(driver);
    }

    public void fillCourseNameInput(String courseName){
        courseNameInput.clear();
        courseNameInput.sendKeys(courseName);
    }
    public void clickCancelCourseAddingBtn() {
        CancelCourseAddingBtn.click();
    }
    public void clickSubmitNewCourseBtn(){
        submitNewCourseBtn.click();
    }
    public boolean isSubmitBtnEnabled() {
        return submitNewCourseBtn.isEnabled();
    }
}
