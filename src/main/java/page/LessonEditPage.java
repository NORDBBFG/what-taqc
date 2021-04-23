package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LessonEditPage extends AbstractPage {
//    @FindBy(xpath = "//form[@id='form']")
//    private WebElement form;
//    @FindBy(xpath = "//div[ends-with(@class,'form-group row')]")
//    @FindBy(xpath = "//div[substring(@class,string-length(@class)-string-length('form-group row')+1)='form-group row']")
//    private List<WebElement> rows;
//    @FindBy(xpath = "//table")
//    private WebElement table;

    private static final String MARK_XPATH = "//input[@type='number']";
    private static final String PRESENCE_XPATH = "//input[@type='checkbox']";
    private static final String NAME_XPATH = "//p";
    private static final String ID_XPATH = "th[@scope='row']";

    @FindBy(xpath = "//h3")
    private WebElement namePage;

    @FindBy(xpath = "//input[@name='themeName']")
    private WebElement themeNameInput;
    @FindBy(xpath = "//input[@name='groupName']")
    private WebElement groupNameInput;
    @FindBy(xpath = "//input[@name='lessonD']")
    private WebElement dateInput;

    @FindBy(xpath = "//thead//th")
    private List<WebElement> tableHeadlines;
    @FindBy(xpath = "//tbody//tr")
    private List<WebElement> tableContent;

    @FindBy(xpath = "//button[@form='form']")
    private WebElement cancelButton;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    public LessonEditPage(WebDriver driver) {
        super(driver);
    }

    public String getPageName() {
        return namePage.getText();
    }
    public String getThemeName() {
        return themeNameInput.getAttribute("value");
    }
    public String getGroupName() {
        return groupNameInput.getAttribute("value");
    }
    public String getFullStudentName(int number) {
        if (!tableContent.isEmpty()) {
            for (WebElement webElement : tableContent) {
                if (webElement.findElement(By.xpath(ID_XPATH)).getText().equalsIgnoreCase(""+number)) {
                    return webElement.findElement(By.xpath(NAME_XPATH)).getText();
                }
            }
        }
        return null;
    }
    public String getMark(int number) {
        if (!tableContent.isEmpty()) {
            for (WebElement webElement : tableContent) {
                if (webElement.findElement(By.xpath(ID_XPATH)).getText().equalsIgnoreCase(""+number)) {
                    return webElement.findElement(By.xpath(MARK_XPATH)).getAttribute("value");
                }
            }
        }
        return null;
    }
    public String getMark(String name) {
        if (!tableContent.isEmpty()) {
            for (WebElement webElement : tableContent) {
                if (webElement.findElement(By.xpath(NAME_XPATH)).getText().equalsIgnoreCase(name)) {
                    return webElement.findElement(By.xpath(MARK_XPATH)).getAttribute("value");
                }
            }
        }
        return null;
    }
    public boolean getPresence(int number) {
        if (!tableContent.isEmpty()) {
            for (WebElement webElement : tableContent) {
                if (webElement.findElement(By.xpath(ID_XPATH)).getText().equalsIgnoreCase(""+number)) {
                    return webElement.findElement(By.xpath(PRESENCE_XPATH)).isSelected();
                }
            }
        }
        return false;
    }
    public boolean getPresence(String name) {
        if (!tableContent.isEmpty()) {
            for (WebElement webElement : tableContent) {
                if (webElement.findElement(By.xpath(NAME_XPATH)).getText().equalsIgnoreCase(name)) {
                    return webElement.findElement(By.xpath(PRESENCE_XPATH)).isSelected();
                }
            }
        }
        return false;
    }

    public boolean isGroupNameEnabled() {
        return groupNameInput.isEnabled();
    }
    public boolean isThemeNameInputEnabled() {
        return themeNameInput.isEnabled();
    }
    public boolean isDateInputEnabled() {
        return dateInput.isEnabled();
    }
    public boolean isCancelButtonEnabled() {
        return cancelButton.isEnabled();
    }
    public boolean isSaveButtonEnabled() {
        return saveButton.isEnabled();
    }

    public void setMark(int number, int input) {
        if (tableContent.size() > number) {
            tableContent.get(number - 1)
                    .findElement(By.xpath(MARK_XPATH)).sendKeys("" + input);
        }
    }
    public void setMark(String name, int input) {
        if (!tableContent.isEmpty()) {
            tableContent.forEach(
                    t -> {
                        if (t.findElement(By.xpath(NAME_XPATH)).getText().equalsIgnoreCase(name)) {
                            t.findElement(By.xpath(MARK_XPATH)).sendKeys("" + input);
                        }
                    }
            );
        }
    }
    public void setThemeName(String name) {
        themeNameInput.sendKeys(name);
    }
    public void setDateInput(String dateInput) {
        this.dateInput.sendKeys(dateInput);
    }
    public void clickPresence(int number) {
        if (!tableContent.isEmpty()) {
            for (WebElement webElement : tableContent) {
                if (webElement.findElement(By.xpath(ID_XPATH)).getText().equalsIgnoreCase(""+number)) {
                    webElement.findElement(By.xpath(PRESENCE_XPATH)).click();
                }
            }
        }
    }
    public void clickPresence(String name) {
        if (!tableContent.isEmpty()) {
            for (WebElement webElement : tableContent) {
                if (webElement.findElement(By.xpath(NAME_XPATH)).getText().equalsIgnoreCase(name)) {
                    webElement.findElement(By.xpath(PRESENCE_XPATH)).click();
                }
            }
        }
    }
    public void clickCancelButton() {
        cancelButton.click();
    }
    public void clickSaveButton() {
        saveButton.click();
    }
    public void clickStudent(String name){
        WebElement student = getStudent(name);
        if(student!=null) student.click();
    }
    public void clickStudent(int number){
        WebElement student = getStudent(number);
        if(student!=null) student.click();
    }

    private WebElement getStudent(int number) {
        if (!tableContent.isEmpty()) {
            for (WebElement webElement : tableContent) {
                if (webElement.findElement(By.xpath(ID_XPATH)).getText().equalsIgnoreCase(""+number)) {
                    return webElement.findElement(By.xpath(NAME_XPATH));
                }
            }
        }
        return null;
    }
    private WebElement getStudent(String name) {
        if (!tableContent.isEmpty()) {
            for (WebElement webElement : tableContent) {
                if (webElement.findElement(By.xpath(NAME_XPATH)).getText().equalsIgnoreCase(name)) {
                    return webElement.findElement(By.xpath(NAME_XPATH));
                }
            }
        }
        return null;
    }
}
