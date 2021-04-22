package page.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

public class CourseDetailsPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class,'nav-tabs')]/a[contains(text(),'Edit')]")
    private WebElement EditCourseDetailsTab;

    public CourseDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnEditCourseDetailsTab(){
        EditCourseDetailsTab.click();
    }
}
