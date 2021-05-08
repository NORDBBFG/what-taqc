package step;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.BasePage;
import step.courses.CoursesStep;
import step.lesson.ListOfLessonPageStep;
import step.myprofile.MyProfilePageStep;
import step.student.ListOfStudentsPageStep;

import java.lang.reflect.InvocationTargetException;

public abstract class BaseStep {

    public ListOfStudentsPageStep clickStudentSidebar(Class<? extends BasePage> context, WebDriver driver) {
        try {
            Thread.sleep(5000); //due to load list
            BasePage basePage = context.getConstructor(WebDriver.class).newInstance(driver);
            basePage.clickSidebarItem(Constants.PageName.STUDENT_LIST);
            return new ListOfStudentsPageStep(driver);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ListOfLessonPageStep clickLessonSidebar(Class<? extends BasePage> context, WebDriver driver) {
        try {
            Thread.sleep(5000); //due to load list
            BasePage basePage = context.getConstructor(WebDriver.class).newInstance(driver);
            basePage.clickSidebarItem(Constants.PageName.LESSON_LIST);
            return new ListOfLessonPageStep(driver);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public CoursesStep clickCoursesSidebar(Class<? extends BasePage> context, WebDriver driver) {
        try {
            Thread.sleep(5000); //due to load list
            BasePage basePage = context.getConstructor(WebDriver.class).newInstance(driver);
            basePage.clickSidebarItem(Constants.PageName.GROUP_LIST);
            return new CoursesStep(driver);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }


    public MyProfilePageStep clickMyProfile(Class<? extends BasePage> context, WebDriver driver) {
        try {
            BasePage basePage = context.getConstructor(WebDriver.class).newInstance(driver);
            basePage.clickArrowIcon();
            basePage.clickDropdownItem(Constants.PageName.MY_PROFILE);
            return new MyProfilePageStep(driver);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            return null;
        }
    }


    public <T extends BaseStep> T verifySidebarItemLessons(Class<? extends BaseStep> stepContext,
                                             Class<? extends BasePage> pageContext,
                                             boolean expected, WebDriver driver) {
        try {
            BasePage basePage = pageContext.getConstructor(WebDriver.class).newInstance(driver);
            Assert.assertEquals(basePage.dropdownItemExist(Constants.PageName.LESSON_LIST), expected);
            return (T) stepContext.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            return null;
        }
    }

    public <T extends BaseStep> T verifySidebarItemStudents(Class<? extends BaseStep> stepContext,
                                              Class<? extends BasePage> pageContext,
                                              boolean expected, WebDriver driver) {
        try {
            BasePage basePage = pageContext.getConstructor(WebDriver.class).newInstance(driver);
            Assert.assertEquals(basePage.dropdownItemExist(Constants.PageName.STUDENT_LIST), expected);
            return (T) stepContext.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            return null;
        }
    }

}
