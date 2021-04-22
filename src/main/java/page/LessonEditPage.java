package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LessonEditPage extends AbstractPage{

    @FindBy(xpath = "//h3")
    private WebElement namePage;
//    @FindBy(xpath = "//form[@id='form']")
//    private WebElement form;
//    @FindBy(xpath = "//div[ends-with(@class,'form-group row')]")
//    @FindBy(xpath = "//div[substring(@class,string-length(@class)-string-length('form-group row')+1)='form-group row']")
//    private List<WebElement> rows;

    @FindBy(xpath = "//input[@name='themeName']")
    private WebElement themeNameInput;
    @FindBy(xpath = "//input[@name='groupName']")
    private WebElement groupNameInput;
    @FindBy(xpath = "//button[@type='lessonD']")
    private WebElement dateInput;

//    @FindBy(xpath = "//table")
//    private WebElement table;
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

    public String getPageName(){
        return namePage.getText();
    }
    public String getThemeName(){
        return themeNameInput.getText();
    }
    public String getGroupName(){
        return groupNameInput.getText();
    }

    public boolean checkPresenceByNumber(int number) {
        if (tableContent.size() > number) {
            return tableContent.get(number - 1)
                    .findElement(By.xpath("//input[@type='checkbox']")).isSelected();
        }
        return false;
    }
    public String getFullStudentNameByNumber(int number){
        if(tableContent.size()>number) {
            return tableContent.get(number - 1).findElement(By.xpath("//p")).getText();
        }
        return null;
    }
    public String getMarkByNumber(int number) {
        if (tableContent.size() > number) {
            return tableContent.get(number - 1).findElement(By.xpath("//input[@type='number']")).getAttribute("value");
        }
        return null;
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

    public void clickPresenceByNumber(int number){
        if (tableContent.size() > number) {
            tableContent.get(number - 1)
                    .findElement(By.xpath("//input[@type='checkbox']")).click();
        }
    }

    public void setMarkByNumber(int number, int input){
        if (tableContent.size() > number) {
            tableContent.get(number - 1)
                    .findElement(By.xpath("//input[@type='number']")).sendKeys(""+input);
        }
    }

    public void clickCancelButton(){
        cancelButton.click();
    }
    public void clickSaveButton(){
        saveButton.click();
    }

}
