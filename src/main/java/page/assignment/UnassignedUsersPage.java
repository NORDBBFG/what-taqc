package page.assignment;


import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import page.AbstractPage;

import java.util.List;

@Getter
public class UnassignedUsersPage extends AbstractPage{
        @FindBy(xpath = "//input[contains(@class,'searchInput')]")
    private WebElement person;
        @FindBy(xpath = "//tr/th/span")
    private List<WebElement> sort;
        @FindBy(xpath = "//button[text()='Add role']")
    private WebElement addRole;
        @FindBy(xpath = "//select")
    private Select select;
//        @FindBy(xpath = "//th/span[text()='#']")
//    private WebElement sortSymbol;
//        @FindBy(xpath = "//th/span[text()='Name']")
//    private WebElement sortName;
//        @FindBy(xpath = "//th/span[text()='Surname']")
//    private WebElement sortSurname;
//        @FindBy(xpath = "//th/span[text()='Email']")
//    private WebElement sortEmail;
//    @FindBy(xpath = "//td[@class='xh-highlight']")
//    private List<WebElement> info;



//    public String getPerson(){
//        return person.getAttribute("value");
//    }

    public UnassignedUsersPage(WebDriver driver) {
        super(driver);
    }
}
