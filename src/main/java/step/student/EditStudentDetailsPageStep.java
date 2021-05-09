package step.student;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.student.EditStudentsDetailsPage;
import step.BaseStep;

public class EditStudentDetailsPageStep extends BaseStep {

    EditStudentsDetailsPage editStudentsDetailsPage;

    public EditStudentDetailsPageStep(WebDriver driver){
        editStudentsDetailsPage = new EditStudentsDetailsPage(driver);
    }

    public EditStudentDetailsPageStep clickLabelStudentsDetails(){
        editStudentsDetailsPage.clickLabelStudentsDetails();
        return this;
    }

    public EditStudentDetailsPageStep verifyLabelStudentsDetails(String expected){
        Assert.assertEquals(editStudentsDetailsPage.getLabelStudentsDetails(), expected);
        return this;
    }

    public EditStudentDetailsPageStep verifyLabelEditStudentsDetails(String expected){
        Assert.assertEquals(editStudentsDetailsPage.getLabelEditStudentsDetails(), expected);
        return this;
    }

    public EditStudentDetailsPageStep verifyFirstName(String expected){
        Assert.assertEquals(editStudentsDetailsPage.getFirstName(), expected);
        return this;
    }

    public EditStudentDetailsPageStep verifyLastName(String expected){
        Assert.assertEquals(editStudentsDetailsPage.getLastName(), expected);
        return this;
    }

    public EditStudentDetailsPageStep verifyEmail(String expected){
        Assert.assertEquals(editStudentsDetailsPage.getEmail(), expected);
        return this;
    }

    public EditStudentDetailsPageStep verifyLabelOfGroupsExists(String expected){
        String actual = null;
        for (String labelOfGroups: editStudentsDetailsPage.getListLabelsOfGroups()) {
            if(labelOfGroups.equals(expected)) {
                actual = labelOfGroups;
                break;
            }
        }
        Assert.assertEquals(actual, expected);
        return this;
    }

    public EditStudentDetailsPageStep verifyListOfGroupsIsDisplayed() {
        Assert.assertTrue(editStudentsDetailsPage.getQuantityGroup() > 0, "List of groups is displayed");
        return this;
    }
}
