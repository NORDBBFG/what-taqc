package step.courses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.courses.CoursesPage;
import step.BaseStep;

public class CoursesStep extends BaseStep {
    private final CoursesPage coursesPage;

    public CoursesStep(WebDriver driver) {
        coursesPage = new CoursesPage(driver);
    }

    public CoursesStep verifyPageHeaderName(String expected){
        Assert.assertEquals(coursesPage.getPageHeaderText(), expected);
      return this;
    }
    public CoursesStep verifyNumberOfCoursesDisplayed(Boolean expected){
        Assert.assertEquals(coursesPage.isNumberOfCoursesDisplayed(), expected);
      return this;
    }
    public CoursesStep verifySearchCourseInListInputDisplayed(Boolean expected){
        Assert.assertEquals(coursesPage.isSearchCourseInListInputDisplayed(), expected);
      return this;
    }
    public CoursesStep verifyCourseName(int courseID, String expected){
        Assert.assertEquals(coursesPage.getCourseNameText(courseID), expected);
      return this;
    }

    public AddCourseStep clickAddCourseToListBtn(){
        coursesPage.clickAddCourseToListBtn();
      return new AddCourseStep(coursesPage.getDriver());
    }
    public CourseDetailsStep clickCourseTableRow(String id){
        coursesPage.clickCourseTableRow(id);
        return new CourseDetailsStep(coursesPage.getDriver());
    }
    public EditCourseDetailsStep clickCourseTableEditIcon(String id){
        coursesPage.clickCourseTableEditIcon(id);
        return new EditCourseDetailsStep(coursesPage.getDriver());
    }
    public CoursesStep fillSearchCourseInListInput(String title){
        coursesPage.fillSearchCourseInListInput(title);
      return this;
    }
    public CoursesStep changeCourseListIDSortType(){
        coursesPage.changeCourseListIDSortType();
      return this;
    }
    public CoursesStep changeCourseListNameSortType(){
        coursesPage.changeCourseListNameSortType();
      return this;
    }
    public CoursesStep clickLeftNavigationArrowBtn(){
        coursesPage.clickLeftNavigationArrowBtn();
      return this;
    }
    public CoursesStep clickRightNavigationArrowBtn(){
        coursesPage.clickRightNavigationArrowBtn();
      return this;
    }

}
