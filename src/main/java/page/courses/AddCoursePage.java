package page.courses;

import org.openqa.selenium.JavascriptExecutor;
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
    private WebElement cancelCourseAddingBtn;
    @FindBy(xpath = "//h3")
    private WebElement pageHeader;
    @FindBy(xpath = "//p[contains(text(),Invalid)]")
    private WebElement invalidCourseNameError;

    public AddCoursePage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeaderText(){
        return pageHeader.getText();
    }

    public String getInvalidCourseNameError(){
        return invalidCourseNameError.getText();
    }

    public void fillCourseNameInput(String courseName) throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.evaluate('//input', document, null, 9, null).singleNodeValue.value = ''");
        courseNameInput.sendKeys(courseName);
    }

    public void clickCancelCourseAddingBtn() {
        cancelCourseAddingBtn.click();
    }

    public void clickSubmitNewCourseBtn(){
        submitNewCourseBtn.click();
    }

    public boolean isSubmitBtnEnabled() {
        return submitNewCourseBtn.isEnabled();
    }
}
