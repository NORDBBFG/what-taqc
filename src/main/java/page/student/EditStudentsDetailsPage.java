package page.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import java.util.ArrayList;
import java.util.List;

public class EditStudentsDetailsPage extends BasePage {

    @FindBy(xpath = "//div[@class='nav nav-tabs']//a[not(contains(@class, 'tab__active'))]")
    private WebElement labelStudentsDetails;
    @FindBy(xpath = "//a[contains(@class, 'tab__active')]")
    private WebElement labelEditStudentsDetails;
    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;
    @FindBy(xpath = "//li[@data-groupid]")
    private List<WebElement> listOfGroups;
    @FindBy(xpath = "//button[contains(@class, 'exclude-btn')]")
    private WebElement buttonExclude;
    @FindBy(xpath = "//button[@type='reset']")
    private WebElement buttonClear;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSave;

    public EditStudentsDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getLabelStudentsDetails(){
        return labelEditStudentsDetails.getText();
    }

    public void clickLabelStudentsDetails(){
        labelStudentsDetails.click();
    }

    public String getLabelEditStudentsDetails(){
        return labelEditStudentsDetails.getText();
    }

    public String getFirstName(){
        return firstName.getAttribute("value");
    }

    public String getLastName(){
        return lastName.getAttribute("value");
    }

    public String getEmail(){
        return email.getAttribute("value");
    }

    public List<WebElement> getListOfGroups(){
        return listOfGroups;
    }

    public List<String> getListLabelsOfGroups(){
        List<String> listLabelsOfGroups = new ArrayList<>();

        for (WebElement element: listOfGroups) {
            listLabelsOfGroups.add(element.getText());
        }
        return listLabelsOfGroups;
    }

    public int getQuantityGroup(){
        return listOfGroups.size();
    }
}
