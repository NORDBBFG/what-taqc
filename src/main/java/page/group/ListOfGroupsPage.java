package page.group;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import java.util.List;
import java.util.NoSuchElementException;

public class ListOfGroupsPage extends BasePage {

    private final Logger logger = LogManager.getLogger(ListOfGroupsPage.class);

    @FindBy(xpath = "//h2[text()='Groups']")
    private WebElement groupsPageName;
    @FindBy(xpath = "//button[text()=\"Upload Group('s)\"]")
    private WebElement uploadGroupButton;
    @FindBy(xpath = "//button[text()='Add a group']")
    private WebElement addGroupButton;
    @FindBy(xpath = "//thead//span[text()='#']")
    private WebElement rowNumberHeader;
    @FindBy(xpath = "//thead//span[text()='Group Name']")
    private WebElement groupNameHeader;
    @FindBy(xpath = "//thead//span[text()='Quantity of students']")
    private WebElement quantityOfStudentsHeader;
    @FindBy(xpath = "//thead//span[text()='Date of start']")
    private WebElement dateOfStartHeader;
    @FindBy(xpath = "//thead//span[text()='Date of finish']")
    private WebElement dateOfFinishHeader;
    @FindBy(xpath = "//thead//th[text()='Edit']")
    private WebElement editHeader;
    @FindBy(xpath = "//input[@placeholder=\"Group's name\"]")
    private WebElement groupsSearchByName;
    @FindBy( xpath = "//tbody//tr")
    private List<WebElement> tableContent;

    public ListOfGroupsPage(WebDriver driver) {
        super(driver);
    }

    public void clickNumberHeader(){
        rowNumberHeader.click();
    }
    public void clickGroupNameHeader(){
        groupNameHeader.click();
    }
    public void clickQuantityOfStudentsHeader(){
        quantityOfStudentsHeader.click();
    }
    public void clickDateOfStartHeader(){
        dateOfStartHeader.click();
    }
    public void clickDateOfFinishHeader(){
        dateOfFinishHeader.click();
    }

    public List<WebElement> getTableContent(){
        return tableContent;
    }
    public WebElement getGroupsSearchByName(){
        return groupsSearchByName;
    }

    public List<WebElement> searchByGroupName(String groupName){
        if (waitVisibility(tableContent.get(0), 5)) {
            groupsSearchByName.sendKeys(groupName);
        } else {
            logger.error("Tables isn't loaded");
            throw new NoSuchElementException();
        }
        return tableContent;
    }

    public void clickAddGroupButton(){
        addGroupButton.click();
    }
    public void uploadGroupButton(){
        addGroupButton.click();
    }

    public void clickEditIconInRow(Integer rowNumber){
        tableContent.get(rowNumber-1).findElement(By.xpath("/td[last]")).click();
    }

    public void clickOnRow(Integer rowNumber){
        tableContent.get(rowNumber-1).click();
    }

    public String getTextByJavaScript (WebElement element){
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",element);
    }


    public String getTextFromSearch (){
        return getTextByJavaScript(getGroupsSearchByName());
    }


}
