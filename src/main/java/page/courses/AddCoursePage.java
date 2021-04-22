package page.courses;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

@Getter
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
}
