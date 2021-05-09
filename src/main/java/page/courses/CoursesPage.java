package page.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import java.util.List;

public class CoursesPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class,'col-2 offset-5')]/button")
    private WebElement addCourseToListBtn;
    @FindBy(xpath = "//input[contains(@class,'search')]")
    private WebElement searchCourseInListInput;
    @FindBy(xpath = "//span[@data-sorting-param='id']")
    private WebElement courseListIDSortType;
    @FindBy(xpath = "//span[@data-sorting-param='name']")
    private WebElement courseListNameSortType;
    @FindBy(xpath = "//tr[contains(@class,'list-of-courses')]")
    private List <WebElement> listOfCourseTableRows;
    @FindBy(xpath = "//td[@data-student-id]/*")
    private List <WebElement> listOfCourseTableEditIcons;
    @FindBy(xpath = "//nav[contains(@class,'flex-row')]/ul[1]//button")
    private WebElement leftNavigationArrowBtn;
    @FindBy(xpath = "//nav[contains(@class,'flex-row')]/ul[3]//button")
    private WebElement rightNavigationArrowBtn;
    @FindBy(xpath = "//h2")
    private WebElement pageHeader;
    @FindBy(xpath = "//span[contains(@class,'col-2')]")
    private WebElement numberOfCourses;

    public String getPageHeaderText(){
        return pageHeader.getText();
    }

    public Boolean isNumberOfCoursesDisplayed(){
        return numberOfCourses.isDisplayed();
    }

    public Boolean isSearchCourseInListInputDisplayed(){
        return searchCourseInListInput.isDisplayed();
    }

    public Boolean isAddCourseToListBtnDisplayed(){
        return addCourseToListBtn.isDisplayed();
    }

    public String getCourseNameText(Integer courseID){
        String courseIDXpath = "//tr[@data-student-id='"+courseID+"']/td[1]";
        String courseNameXpath = "//tr[@data-student-id='"+courseID+"']/td[2]";
        if (!listOfCourseTableRows.isEmpty()) {
            for (WebElement webElement : listOfCourseTableRows) {
                if (webElement.findElement(By.xpath(courseIDXpath)).getText().equals(courseID.toString())) {
                    return webElement.findElement(By.xpath(courseNameXpath)).getText();
                }
            }
        }
        return null;
    }

    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddCourseToListBtn(){
        addCourseToListBtn.click();
    }

    public void fillSearchCourseInListInput(String title){
        searchCourseInListInput.clear();
        searchCourseInListInput.sendKeys(title);
    }

    public void changeCourseListIDSortType(){
        courseListIDSortType.click();
    }

    public void changeCourseListNameSortType(){
        courseListNameSortType.click();
    }

    public void clickCourseTableRow(String id){
        try { listOfCourseTableRows.get(Integer.parseInt(id)).click(); }
        catch (NumberFormatException | IndexOutOfBoundsException e) { System.out.println("Exception"); }
    }

    public void clickCourseTableEditIcon(String id){
        try { listOfCourseTableEditIcons.get(Integer.parseInt(id)).click(); }
        catch (NumberFormatException | IndexOutOfBoundsException e) { System.out.println("Exception"); }
    }

    public void clickLeftNavigationArrowBtn(){
        leftNavigationArrowBtn.click();
    }

    public void clickRightNavigationArrowBtn(){
        rightNavigationArrowBtn.click();
    }
}
