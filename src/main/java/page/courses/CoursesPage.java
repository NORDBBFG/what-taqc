package page.courses;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

import java.util.List;

@Getter
public class CoursesPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class,'col-2 offset-5')]/button")
    private WebElement AddCourseToListBtn;
    @FindBy(xpath = "//input[contains(@class,'search')]")
    private WebElement SearchCourseInListInput;
    @FindBy(xpath = "//span[@data-sorting-param='id']")
    private WebElement CourseListIDSortType;
    @FindBy(xpath = "//span[@data-sorting-param='name']")
    private WebElement CourseListNameSortType;
    @FindBy(xpath = "//tr[contains(@class,'list-of-courses')]")
    private List <WebElement> ListOfCourseTableRows;
    @FindBy(xpath = "//td[@data-student-id]/*")
    private List <WebElement> ListOfCourseTableEditIcons;
    @FindBy(xpath = "//nav[contains(@class,'flex-row')]/ul[1]//button")
    private WebElement LeftNavigationArrowBtn;
    @FindBy(xpath = "//nav[contains(@class,'flex-row')]/ul[3]//button")
    private WebElement RightNavigationArrowBtn;

    public CoursesPage(WebDriver driver) {
        super(driver);
    }
}
