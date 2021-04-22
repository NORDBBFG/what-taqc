package step.courses;

import org.openqa.selenium.WebDriver;
import page.courses.CoursesPage;

public class CoursesStep {
    private final CoursesPage coursesPage;

    public CoursesStep(WebDriver driver) {
        coursesPage = new CoursesPage(driver);
    }

    public void clickAddCourseToListBtn(){
        coursesPage.getAddCourseToListBtn().click();
    }

    public void fillSearchCourseInListInput(String title){
        coursesPage.getSearchCourseInListInput().clear();
        coursesPage.getSearchCourseInListInput().sendKeys(title);
    }

    public void changeCourseListIDSortType(){
        coursesPage.getCourseListIDSortType().click();
    }

    public void changeCourseListNameSortType(){
        coursesPage.getCourseListNameSortType().click();
    }

    //TODO: Find out how to log and do this stuff correctly.
    public void clickOnCourseTableRow(String id){
        try { coursesPage.getListOfCourseTableRows().get(Integer.parseInt(id)).click(); }
        catch (NumberFormatException | IndexOutOfBoundsException e) { System.out.println("Exception"); }
    }
    //TODO: Find out how to log and do this stuff correctly.
    public void clickOnCourseTableEditIcon(String id){
        try { coursesPage.getListOfCourseTableEditIcons().get(Integer.parseInt(id)).click(); }
        catch (NumberFormatException | IndexOutOfBoundsException e) { System.out.println("Exception"); }
    }

    public void clickOnLeftNavigationArrowBtn(){
        coursesPage.getLeftNavigationArrowBtn().click();
    }

    public void clickOnRightNavigationArrowBtn(){
        coursesPage.getRightNavigationArrowBtn().click();
    }
}
