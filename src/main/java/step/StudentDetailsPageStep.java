package step;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.StudentDetailsPage;

public class StudentDetailsPageStep {

    private StudentDetailsPage studentDetailsPage;

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

    public StudentDetailsPageStep verifyEnabledGroups(boolean countGroup){
        Assert.assertEquals(studentDetailsPage.listGroupsIsEmpty(), countGroup);
        return this;
    }

    public StudentDetailsPageStep verifyEnabledLessons(boolean countLesson){
        Assert.assertEquals(studentDetailsPage.listLessonsIsEmpty(), countLesson);
        return this;
    }

}
