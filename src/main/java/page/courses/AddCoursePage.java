package page.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import static constants.XPath.AddCoursePage.*;
import static constants.XPath.Common.*;

public class AddCoursePage extends BasePage {

    @FindBy(xpath = H3)
    private WebElement pagesLabel;
    @FindBy(xpath = COURSE_NAME_INPUT)
    private WebElement courseNameInput;
    @FindBy(xpath = SAVE_BUTTON)
    private WebElement submitNewCourseBtn;
    @FindBy(xpath = CANCEL_COURSE_ADDING_BTN)
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

    public String getPagesLabel() {
        return pagesLabel.getText();
    }
}
