package step.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.student.StudentDetailsPage;
import step.BaseStep;

public class StudentDetailsPageStep extends BaseStep {

    StudentDetailsPage studentDetailsPage;

    public StudentDetailsPageStep(WebDriver driver){
        studentDetailsPage = new StudentDetailsPage(driver);
    }

    public StudentDetailsPageStep verifyLabel(String expected){
        Assert.assertEquals(studentDetailsPage.getLabel(), expected);
        return this;
    }

    public StudentDetailsPageStep verifyFirstName(String expected){
        Assert.assertEquals(studentDetailsPage.getFirstName(), expected);
        return this;
    }

    public StudentDetailsPageStep verifyLastName(String expected){
        Assert.assertEquals(studentDetailsPage.getLastName(), expected);
        return this;
    }

    public StudentDetailsPageStep verifyEmail(String expected){
        Assert.assertEquals(studentDetailsPage.getEmail(), expected);
        return this;
    }

    // TODO return GroupDetailsPage
    public void clickOnLabelOfGroup(String labelOfGroup) {
        for (WebElement elementOfGroup: studentDetailsPage.getListOfGroups()) {
            if(elementOfGroup.getText().equals(labelOfGroup)){
                elementOfGroup.click();
                break;
            }
        }
    }

    public StudentDetailsPageStep verifyLabelOfGroupsExists(String expected){
        String actual = null;
        for (String labelOfGroups: studentDetailsPage.getListLabelsOfGroups()) {
            if(labelOfGroups.equals(expected)) {
                actual = labelOfGroups;
                break;
            }
        }
        Assert.assertEquals(actual, expected);
        return this;
    }

    public StudentDetailsPageStep verifyListOfGroupsIsDisplayed() {
        Assert.assertTrue(studentDetailsPage.getQuantityGroup() > 0, "List of groups is displayed");
        return this;
    }

    // TODO return LessonDetailsPage
    public void clickOnLabelOfLesson(String labelOfLesson) {
        for (WebElement elementOfLesson: studentDetailsPage.getListOfLessons()) {
            if(elementOfLesson.getText().equals(labelOfLesson)){
                elementOfLesson.click();
                break;
            }
        }
    }

    public StudentDetailsPageStep verifyLabelOfLessonExists(String expected){
        String actual = null;
        for (String labelOfLessons: studentDetailsPage.getListLabelsOfLessons()) {
            if(labelOfLessons.equals(expected)) {
                actual = labelOfLessons;
                break;
            }
        }
        Assert.assertEquals(actual, expected);
        return this;
    }

    public StudentDetailsPageStep verifyListOfLessonsIsDisplayed() {
        Assert.assertTrue(studentDetailsPage.getQuantityLessons() > 0, "List of lessons is displayed");
        return this;
    }
}
