package page.courses;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

@Getter
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
}
