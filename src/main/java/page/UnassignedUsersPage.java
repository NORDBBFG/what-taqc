package page;


import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import component.WebElements.UnassignedUsers;
import java.util.List;

@Getter
public class UnassignedUsersPage extends BasePage {
    @FindBy(xpath = "//input[contains(@class,'searchInput')]")
    private WebElement person;
    @FindBy(xpath = "//tr/th/span")
    private List<WebElement> sortUnassignedUsers;
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






    public WebElement ChoseSort(String unassignedUsers) {

        switch (unassignedUsers) {

            case UnassignedUsers.SYMBOL:
                return getSortUnassignedUsers().get(Integer.parseInt(UnassignedUsers.SYMBOL));
//                        UnassignedPage.getSort().get(Integer.parseInt(String.valueOf(SortButton.SYMBOL))).click();
            case UnassignedUsers.NAME:
                return getSortUnassignedUsers().get(Integer.parseInt(UnassignedUsers.NAME));
            case UnassignedUsers.SURNAME:
                return getSortUnassignedUsers().get(Integer.parseInt(UnassignedUsers.SURNAME));
            case UnassignedUsers.EMAIL:
                return getSortUnassignedUsers().get(Integer.parseInt(UnassignedUsers.EMAIL));
        }


        return null;
    }

    public WebElement ChoseRole(String unassignedUsers) {

        switch (unassignedUsers) {

            case UnassignedUsers.CHOOSE:
                return getSortUnassignedUsers().get(Integer.parseInt(UnassignedUsers.CHOOSE));
//                        UnassignedPage.getSort().get(Integer.parseInt(String.valueOf(SortButton.SYMBOL))).click();
            case UnassignedUsers.STUDENT:
                return getSortUnassignedUsers().get(Integer.parseInt(UnassignedUsers.STUDENT));
            case UnassignedUsers.MENTOR:
                return getSortUnassignedUsers().get(Integer.parseInt(UnassignedUsers.MENTOR));
            case UnassignedUsers.SECRETARY  :
                return getSortUnassignedUsers().get(Integer.parseInt(UnassignedUsers.SECRETARY));
        }


        return null;
    }


    public UnassignedUsersPage(WebDriver driver) {
        super(driver);
    }
}
