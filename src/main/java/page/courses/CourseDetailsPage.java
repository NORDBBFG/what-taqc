package page.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

public class CourseDetailsPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class,'nav-tabs')]/a[contains(text(),'Edit')]")
    private WebElement editCourseDetailsTab;

    public CourseDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickEditCourseDetailsTab(){
        editCourseDetailsTab.click();
    }
}
