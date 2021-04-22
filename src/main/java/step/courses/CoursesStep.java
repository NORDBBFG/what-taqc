package step.courses;

import org.openqa.selenium.WebDriver;
import page.courses.AddCoursePage;
import page.courses.CoursesPage;

public class CoursesStep {
    private final CoursesPage coursesPage;

    public CoursesStep(WebDriver driver) {
        coursesPage = new CoursesPage(driver);
    }

    public CoursesStep clickAddCourseToListBtn(){
        coursesPage.getAddCourseToListBtn().click();
      return this;
    }

    public CoursesStep fillSearchCourseInListInput(String title){
        coursesPage.getSearchCourseInListInput().clear();
        coursesPage.getSearchCourseInListInput().sendKeys(title);
      return this;
    }

    public CoursesStep changeCourseListIDSortType(){
        coursesPage.getCourseListIDSortType().click();
      return this;
    }

    public void changeCourseListNameSortType(){
        coursesPage.getCourseListNameSortType().click();
    }

    //TODO: Find out how to log and do this stuff correctly.
    public CoursesStep clickOnCourseTableRow(String id){
        try { coursesPage.getListOfCourseTableRows().get(Integer.parseInt(id)).click(); }
        catch (NumberFormatException | IndexOutOfBoundsException e) { System.out.println("Exception"); }
      return this;
    }

    //TODO: Find out how to log and do this stuff correctly.
    public CoursesStep clickOnCourseTableEditIcon(String id){
        try { coursesPage.getListOfCourseTableEditIcons().get(Integer.parseInt(id)).click(); }
        catch (NumberFormatException | IndexOutOfBoundsException e) { System.out.println("Exception"); }
      return this;
    }

    public CoursesStep clickOnLeftNavigationArrowBtn(){
        coursesPage.getLeftNavigationArrowBtn().click();
      return this;
    }

    public CoursesStep clickOnRightNavigationArrowBtn(){
        coursesPage.getRightNavigationArrowBtn().click();
      return this;
    }
}
