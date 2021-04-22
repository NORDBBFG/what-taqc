package page.courses;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

@Getter
public class CourseDetailsPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class,'nav-tabs')]/a[contains(text(),'Edit')]")
    private WebElement EditCourseDetailsTab;

    public CourseDetailsPage(WebDriver driver) {
        super(driver);
    }
}
