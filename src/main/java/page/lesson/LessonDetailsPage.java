package page.lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;
import constants.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static constants.XPath.Common.*;
import static constants.XPath.LessonDetailsPage.*;

public class LessonDetailsPage extends BasePage {

    @FindBy(xpath = H3)
    private WebElement namePage;
    @FindBy(xpath = TABLE_HEADLINES)
    private List<WebElement> tableHeadlines;
    @FindBy(xpath = TABLE_CONTENT)
    private List<WebElement> tableContent;
    @FindBy(xpath = ROW_ON_DETAILS_PAGE)
    private List<WebElement> rows;
    @FindBy(xpath = CANCEL_BTN)
    private WebElement cancelButton;

    public LessonDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageName() {
        return namePage.getText();
    }

    public String getThemeName() {
        WebElement webElement = getValueOfFieldByNameOfField(Constants.LessonDetails.LESSON_NAME);
        if(webElement!=null){
            return webElement.findElement(By.xpath(SPAN_WITHOUT_SLASH)).getText();
        }
        return null;
    }

    public String getMentorName() {
        WebElement webElement = getValueOfFieldByNameOfField(Constants.LessonDetails.MENTOR_NAME);
        if(webElement!=null){
            return webElement.findElement(By.xpath(SPAN_WITHOUT_SLASH + A)).getText();
        }
        return null;
    }

    public String getGroupName() {
        WebElement webElement = getValueOfFieldByNameOfField(Constants.LessonDetails.GROUP_NAME);
        if(webElement!=null){
            return webElement.findElement(By.xpath(SPAN_WITHOUT_SLASH + A)).getText();
        }
        return null;
    }

    public String getDate() {
        WebElement webElement = getValueOfFieldByNameOfField(Constants.LessonDetails.LESSON_DATE);
        if(webElement!=null){
            return webElement.getText();
        }
        return null;
    }

    public String getTime() {
        WebElement webElement = getValueOfFieldByNameOfField(Constants.LessonDetails.LESSON_TIME);
        if(webElement!=null){
            return webElement.getText();
        }
        return null;
    }

    public String getFullStudentName(int number) {
        if (!tableContent.isEmpty()) {
            for (WebElement webElement : tableContent) {
                if (webElement.findElement(By.xpath(ID_XPATH)).getText().equalsIgnoreCase(""+number)) {
                    return webElement.findElement(By.xpath(P)).getText();
                }
            }
        }
        return null;
    }

    public String getMark(int number) {
        return getPresentStudentsNumberAndMark().get(""+number);
    }

    public boolean getPresence(int number) {
        return getPresentStudentsNumberAndMark().get(""+number)!=null;
    }

    public HashMap<String, String> getPresentStudentsNumberAndMark() {
        HashMap<String, String> presentStudents = new HashMap<>();
        if (!tableContent.isEmpty()) {
            for (WebElement webElement : tableContent) {
                if (webElement.findElement(By.xpath(PRESENT_ICON_XPATH)) != null) {
                   presentStudents.put(webElement.findElement(By.xpath(ID_XPATH)).getText(),
                           webElement.findElement(By.xpath(MARK_XPATH)).getText());
                }
            }
        }
        return presentStudents;
    }

    public List<String> getAbsentStudentsName() {
        List<String> absentStudents = new ArrayList<>();
        if (!tableContent.isEmpty()) {
            for (WebElement webElement : tableContent) {
                if (webElement.findElement(By.xpath(PRESENT_ICON_XPATH)) == null) {
                    absentStudents.add(webElement.findElement(By.xpath(P)).getText());
                }
            }
        }
        return absentStudents;
    }

    public boolean isCancelButtonEnabled() {
        return cancelButton.isEnabled();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public void clickStudent(String name){
        WebElement student = getStudent(name);
        if(student!=null) student.click();
    }

    public void clickStudent(int number){
        WebElement student = getStudent(number);
        if(student!=null) student.click();
    }

    public void clickMentor() {
        WebElement mentor = getValueOfFieldByNameOfField(Constants.LessonDetails.MENTOR_NAME);
        if(mentor!=null) mentor.click();
    }

    public void clickGroup() {
        WebElement group = getValueOfFieldByNameOfField(Constants.LessonDetails.GROUP_NAME);
        if(group!=null) group.click();
    }

    private WebElement getValueOfFieldByNameOfField(String name) {
        if (!rows.isEmpty()) {
            for (WebElement webElement : rows) {
                if (webElement.findElement(By.xpath(NAME_FIELD_INFO_LESSON_XPATH)).getText().equalsIgnoreCase(name)) {
                    return webElement.findElement(By.xpath(VALUE_FIELD_INFO_LESSON_XPATH));
                }
            }
        }
        return null;
    }

    private WebElement getStudent(int number) {
        if (!tableContent.isEmpty()) {
            for (WebElement webElement : tableContent) {
                if (webElement.findElement(By.xpath(ID_XPATH)).getText().equalsIgnoreCase(""+number)) {
                    return webElement.findElement(By.xpath(P));
                }
            }
        }
        return null;
    }

    private WebElement getStudent(String name) {
        if (!tableContent.isEmpty()) {
            for (WebElement webElement : tableContent) {
                if (webElement.findElement(By.xpath(P)).getText().equalsIgnoreCase(name)) {
                    return webElement.findElement(By.xpath(P));
                }
            }
        }
        return null;
    }
}
