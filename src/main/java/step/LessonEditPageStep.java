package step;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.LessonEditPage;

public class LessonEditPageStep {

    LessonEditPage lessonEditPage;

    public LessonEditPageStep(WebDriver driver){
        lessonEditPage = new LessonEditPage(driver);
    }

    public LessonEditPageStep verifyNamePage(String expected){
        Assert.assertEquals(lessonEditPage.getPageName(),expected);
        return this;
    }
    public LessonEditPageStep verifyThemeName(String expected){
        Assert.assertEquals(lessonEditPage.getThemeName(),expected);
        return this;
    }
    public LessonEditPageStep verifyGroupName(String expected){
        Assert.assertEquals(lessonEditPage.getGroupName(),expected);
        return this;
    }

    public LessonEditPageStep verifyGroupNameEnabled(boolean expected){
        Assert.assertEquals(lessonEditPage.isGroupNameEnabled(),expected);
        return this;
    }
    public LessonEditPageStep verifyThemeNameEnabled(boolean expected){
        Assert.assertEquals(lessonEditPage.isThemeNameInputEnabled(),expected);
        return this;
    }
    public LessonEditPageStep verifyDateInputEnabled(boolean expected){
        Assert.assertEquals(lessonEditPage.isDateInputEnabled(),expected);
        return this;
    }
    public LessonEditPageStep verifyCancelButtonEnabled(boolean expected){
        Assert.assertEquals(lessonEditPage.isCancelButtonEnabled(),expected);
        return this;
    }
    public LessonEditPageStep verifySaveButtonEnabled(boolean expected){
        Assert.assertEquals(lessonEditPage.isSaveButtonEnabled(),expected);
        return this;
    }

    public LessonEditPageStep clickPresenceOfStudentByNumber(int number){
        lessonEditPage.clickPresenceByNumber(number);
        return this;
    }
    public LessonEditPageStep inputMarkOfStudentByNumber(int number, int input){
        lessonEditPage.setMarkByNumber(number,input);
        return this;
    }

    public void clickCancelButton(){
        lessonEditPage.clickCancelButton();
    }
    public void clickSaveButton(){
        lessonEditPage.clickSaveButton();
    }

}
