package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class StudentDetailsPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class, 'tab__active')]")
    private WebElement labelStudentsDetails;

    @FindBy(xpath = "//div[@class='col-12 col-md-6']")
    private WebElement firstName;

    @FindBy(xpath = "//div[@class='col-12 col-md-6 ']/span[not(contains(text(), '@'))]")
    private WebElement lastName;

    @FindBy(xpath = "//span[contains(text(), '@')]")
    private WebElement email;

    @FindBy(xpath = "//a[contains(@href, '/groups/')]")
    private List<WebElement> listOfGroups;

    @FindBy(xpath = "//a[contains(@href, '/lessons/')]")
    private List<WebElement> listOfLessons;

    public StudentDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getLabel(){
        return labelStudentsDetails.getText();
    }

    public String getFirstName(){
        return firstName.getText();
    }

    public String getLastName(){
        return lastName.getText();
    }

    public String getEmail(){
        return email.getText();
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

    public List<WebElement> getListOfLessons(){
        return listOfLessons;
    }

    public List<String> getListLabelsOfLessons(){
        List<String> listLabelsOfLessons = new ArrayList<>();

        for (WebElement element: listOfLessons) {
            listLabelsOfLessons.add(element.getText());
        }
        return listLabelsOfLessons;
    }

    public int getQuantityLessons(){
        return listOfLessons.size();
    }
}
