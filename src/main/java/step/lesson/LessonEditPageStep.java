package step.lesson;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.lesson.LessonEditPage;
import step.BaseStep;

public class LessonEditPageStep extends BaseStep {

    LessonEditPage lessonEditPage;

    public LessonEditPageStep(WebDriver driver) {
        lessonEditPage = new LessonEditPage(driver);
    }

    public LessonEditPageStep verifyNamePage(String expected) {
        Assert.assertEquals(lessonEditPage.getPageName(), expected);
        return this;
    }

    public LessonEditPageStep verifyThemeName(String expected) {
        Assert.assertEquals(lessonEditPage.getThemeName(), expected);
        return this;
    }

    public LessonEditPageStep verifyGroupName(String expected) {
        Assert.assertEquals(lessonEditPage.getGroupName(), expected);
        return this;
    }

    public LessonEditPageStep verifyFullStudentName(int studentId, String expected) {
        Assert.assertEquals(lessonEditPage.getFullStudentName(studentId), expected);
        return this;
    }

    public LessonEditPageStep verifyMark(String studentName, String expected) {
        Assert.assertEquals(lessonEditPage.getMark(studentName), expected);
        return this;
    }

    public LessonEditPageStep verifyMark(int studentId, String expected) {
        Assert.assertEquals(lessonEditPage.getMark(studentId), expected);
        return this;
    }

    public LessonEditPageStep verifyPresence(String studentName, boolean expected) {
        Assert.assertEquals(lessonEditPage.getPresence(studentName), expected);
        return this;
    }

    public LessonEditPageStep verifyPresence(int studentId, boolean expected) {
        Assert.assertEquals(lessonEditPage.getPresence(studentId), expected);
        return this;
    }

    public LessonEditPageStep verifyGroupNameEnabled(boolean expected) {
        Assert.assertEquals(lessonEditPage.isGroupNameEnabled(), expected);
        return this;
    }

    public LessonEditPageStep verifyThemeNameEnabled(boolean expected) {
        Assert.assertEquals(lessonEditPage.isThemeNameInputEnabled(), expected);
        return this;
    }

    public LessonEditPageStep verifyDateInputEnabled(boolean expected) {
        Assert.assertEquals(lessonEditPage.isDateInputEnabled(), expected);
        return this;
    }

    public LessonEditPageStep verifyCancelButtonEnabled(boolean expected) {
        Assert.assertEquals(lessonEditPage.isCancelButtonEnabled(), expected);
        return this;
    }

    public LessonEditPageStep verifySaveButtonEnabled(boolean expected) {
        Assert.assertEquals(lessonEditPage.isSaveButtonEnabled(), expected);
        return this;
    }

    public LessonEditPageStep setThemeName(String name) {
        lessonEditPage.setThemeName(name);
        return this;
    }

    public LessonEditPageStep setDateInput(String dateInput) {
        lessonEditPage.setDateInput(dateInput);
        return this;
    }

    public LessonEditPageStep clickPresenceOfStudent(int number) {
        lessonEditPage.clickPresence(number);
        return this;
    }

    public LessonEditPageStep clickPresenceOfStudent(String name) {
        lessonEditPage.clickPresence(name);
        return this;
    }

    public LessonEditPageStep setMarkOfStudent(int number, int input) {
        lessonEditPage.setMark(number, input);
        return this;
    }

    public LessonEditPageStep setMarkOfStudent(String name, int input) {
        lessonEditPage.setMark(name, input);
        return this;
    }

    public ListOfLessonPageStep clickCancelButton(WebDriver driver) {
        lessonEditPage.clickCancelButton();
        return new ListOfLessonPageStep(driver);
    }

    public ListOfLessonPageStep clickSaveButton(ListOfLessonPageStep context, WebDriver driver) {
        lessonEditPage.clickSaveButton();
        return context;
    }

    public LessonEditPageStep clickSaveButton(LessonEditPageStep  context, WebDriver driver) {
        lessonEditPage.clickSaveButton();
        return context;
    }

    public void getToStudentDetailsPage(int number) {
        lessonEditPage.clickStudent(number);
    }

    public void getToStudentDetailsPage(String name) {
        lessonEditPage.clickStudent(name);
    }

}
