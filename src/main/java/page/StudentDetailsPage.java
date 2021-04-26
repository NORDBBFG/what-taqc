package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StudentDetailsPage extends AbstractPage{

    @FindBy(xpath = "//div[@class='nav nav-tabs']/a[contains(text(), 'Student details')]")
    private WebElement label;

    @FindBy(xpath = "//div[@class='col-12 col-md-6']")
    private WebElement firstName;

    @FindBy(xpath = "(//div[@class='col-12 col-md-6 '])[1]")
    private WebElement lastName;

    @FindBy(xpath = "(//div[@class='col-12 col-md-6 '])[2]")
    private WebElement email;

    @FindBy(xpath = "(//div[@class='col-12 col-md-6 d-flex flex-wrap lead'])[1]")
    private List<WebElement> groups;

    @FindBy(xpath = "(//div[@class='col-12 col-md-6 d-flex flex-wrap lead'])[2]")
    private List<WebElement> lessons;

    public StudentDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getLabel(){
        return label.getText();
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

    public int getCountGroup(){
        return groups.size();
    }

    public int getCountLessons(){
        return lessons.size();
    }

    // Refactor
    public boolean labelIsExists(){
        return label.getText().contains("Student details");
    }

    public boolean firstNameIsExists(String first_name){
        return firstName.getText().contains(first_name);
    }

    public boolean lastNameIsExists(String last_name){
        return lastName.getText().contains(last_name);
    }

    public boolean emailIsExists(String email_address){
        return email.getText().contains(email_address);
    }

    public boolean listGroupsIsEmpty(){
        return groups.isEmpty();
    }

    public boolean listLessonsIsEmpty(){
        return lessons.isEmpty();
    }
}
