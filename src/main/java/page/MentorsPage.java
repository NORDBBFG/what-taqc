package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MentorsPage extends AbstractPage {

    final static  String SPAN_DATA_SORTING_PARAM = "//span[@data-sorting-param=";
    private final static By INDEX_OF_NUMBER_TABLE = By.xpath(SPAN_DATA_SORTING_PARAM + "'index']");
    private final static By INDEX_OF_NAME_TABLE = By.xpath(SPAN_DATA_SORTING_PARAM + "'firstName']");
    private final static By INDEX_OF_SURNAME_TABLE = By.xpath(SPAN_DATA_SORTING_PARAM + "'lastName']']");
    private final static By INDEX_OF_EMAIL_TABLE = By.xpath(SPAN_DATA_SORTING_PARAM + "'email']");

    @FindBy(xpath = "//input[@type='text']")
    private WebElement mentorNameInput;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement disabledMentorsControl;
    @FindBy(className = "list-of-mentors__table-head___34QSQ")
    private List<WebElement> listOfMentors;
    @FindBy(xpath = "//button[@type='button']/span")
    private WebElement addMentorButton;
    @FindBy(xpath = "//td/*[name()='svg']")
    private WebElement editButton;


    public MentorsPage(WebDriver driver) {
        super(driver);
    }

    public void fillMentorName(String mentorNameInput){
       fillField(this.mentorNameInput, mentorNameInput);
    }

    public void enableMentors(WebElement controlMentor){
        if (!controlMentor.isSelected()){
            disabledMentorsControl.click();
        }
    }

    public void sortListOfMentors(WebElement element){
        switch (element.getText()){
            case "#":
                element.findElement(INDEX_OF_NUMBER_TABLE).click();
            case "Name":
                element.findElement(INDEX_OF_NAME_TABLE).click();
            case "Surname":
                element.findElement(INDEX_OF_SURNAME_TABLE).click();
            case "Email":
                element.findElement(INDEX_OF_EMAIL_TABLE).click();
        }
    }

    public void clickAddMentorButton(){addMentorButton.click();}

    public void clickEditButton(){editButton.click();}
}
