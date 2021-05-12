package page.mentor;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;
import java.util.List;

public class ListOfMentorsPage extends BasePage {

    private static final String EMAIL_XPATH = "//tr/td[4]";
    private static final String CELL_XPATH = "//td";

    @FindBy(xpath = "//tbody//tr")
    private List<WebElement> tableContent;
    @FindBy(xpath = "//tr/th/span")
    private List<WebElement> sortMentors;
    WebDriver driver;

    public ListOfMentorsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getMentorsID(String email) {
        List<WebElement> row = getElementsOfMass(email);
        if (!row.isEmpty())
            return row.get(0).getText();

        return null;
    }
    public String getMentorsName(String email) {
        List<WebElement> row = getElementsOfMass(email);
        if (!row.isEmpty())
            return row.get(1).getText();

        return null;
    }

    public String getMentorsName(int number) {
        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            return row.get(1).getText();

        return null;
    }

    public String getMentorsSurname(String email) {
        List<WebElement> row = getElementsOfMass(email);
        if (!row.isEmpty())
            return row.get(2).getText();

        return null;
    }

    public String getMentorsSurname(int number) {


        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            return row.get(2).getText();

        return null;
    }

    public String getMentorsEmail(int number) {
        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            return row.get(3).getText();

        return null;
    }


    public boolean choseSortTypeEnabled(String unassignedUsers) {

        switch (unassignedUsers) {
            case Constants.UnassignedUsersSort.SYMBOL:
                return sortMentors.get(Integer.parseInt(Constants.UnassignedUsersSort.SYMBOL)).isEnabled();
            case Constants.UnassignedUsersSort.NAME:
                return sortMentors.get(Integer.parseInt(Constants.UnassignedUsersSort.NAME)).isEnabled();
            case Constants.UnassignedUsersSort.SURNAME:
                return sortMentors.get(Integer.parseInt(Constants.UnassignedUsersSort.SURNAME)).isEnabled();
            case Constants.UnassignedUsersSort.EMAIL:
                return sortMentors.get(Integer.parseInt(Constants.UnassignedUsersSort.EMAIL)).isEnabled();
        }
        return false;
    }

    public void choseSortType(String unassignedUsers) {

        switch (unassignedUsers) {
            case Constants.UnassignedUsersSort.SYMBOL:
                sortMentors.get(Integer.parseInt(Constants.UnassignedUsersSort.SYMBOL)).click();
                break;
            case Constants.UnassignedUsersSort.NAME:
                sortMentors.get(Integer.parseInt(Constants.UnassignedUsersSort.NAME)).click();
                break;
            case Constants.UnassignedUsersSort.SURNAME:
                sortMentors.get(Integer.parseInt(Constants.UnassignedUsersSort.SURNAME)).click();
                break;
            case Constants.UnassignedUsersSort.EMAIL:
                sortMentors.get(Integer.parseInt(Constants.UnassignedUsersSort.EMAIL)).click();
                break;
        }
    }
    private List<WebElement> getElementsOfMass(String emailOfRole) {
        for (WebElement webElement : tableContent) {
            if (webElement.findElement(By.xpath(EMAIL_XPATH)).getText().matches(emailOfRole)) {
                return webElement.findElements(By.xpath(CELL_XPATH));
            }
        }

        return null;
    }

    private List<WebElement> getElementsOfMass(int numberOfRow) {
        if (!tableContent.isEmpty())
            return tableContent.get(numberOfRow).findElements(By.xpath(CELL_XPATH));
        return null;
    }
}