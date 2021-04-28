package step.courses;

import org.openqa.selenium.WebDriver;
import page.courses.CoursesPage;
import step.BaseStep;

public class CoursesStep extends BaseStep {
    private final CoursesPage coursesPage;

    public CoursesStep(WebDriver driver) {
        coursesPage = new CoursesPage(driver);
    }

        //TODO: make verify methods list for expected conditions.

    public AddCourseStep clickAddCourseToListBtn(){
        coursesPage.clickAddCourseToListBtn();
      return new AddCourseStep(coursesPage.getDriver());
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
    public CourseDetailsStep clickCourseTableRow(String id){
        coursesPage.clickCourseTableRow(id);
      return new CourseDetailsStep(coursesPage.getDriver());
    }
    public EditCourseDetailsStep clickCourseTableEditIcon(String id){
        coursesPage.clickCourseTableEditIcon(id);
      return new EditCourseDetailsStep(coursesPage.getDriver());
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
