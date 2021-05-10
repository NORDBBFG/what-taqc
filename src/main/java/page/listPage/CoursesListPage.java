package page.listPage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import page.BasePage;

import java.util.ArrayList;
import java.util.List;

public class CoursesListPage extends BasePage {

//    public final static String GROUP_PAGE_NAME_XPATH= "//h2";
//    public final static String UPLOAD_GROUPS_BUTTON= "//button[text()=\"Upload Group('s)\"]";
//    public final static String ADD_A_GROUP_BUTTON= "//button[text()='Add a group']";
//
//    public final static String ROW_NUMBER_HEADER= "//thead//span[text()='#']";
//    public final static String GROUP_NAME_HEADER= "//thead//span[text()='Group Name']";
//
//    public final static String QUANTITY_OF_STUDENTS_HEADER= "//thead//span[text()='Quantity of students']";
//    public final static String DATE_OF_START_HEADER= "//thead//span[text()='Date of start']";
//    public final static String DATE_OF_FINISH_HEADER= "//thead//span[text()='Date of finish']";
//    public final static String EDIT_HEADER= "//thead//th[text()='Edit']";
//    public final static String GROUPS_NAME_SEARCH ="//input[@placeholder=\"Group's name\"]";

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

//    @FindBy( xpath = "//tbody//tr")
//    private List<WebElement> tableContent;
    @FindBy( xpath = "//tr[@class='list-of-groups__table-item___30tx6']")
    private List<WebElement> tableContent;


    public CoursesListPage(WebDriver driver) {
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

    public List<WebElement> searchByGroupName(String groupName){
        groupsSearchByName.sendKeys(groupName);
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


}
