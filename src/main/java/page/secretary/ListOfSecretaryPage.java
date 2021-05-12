package page.secretary;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;
import java.util.List;

public class ListOfSecretaryPage extends BasePage {

    private static final String EMAIL_XPATH = "//tr/td[4]";
    private static final String CELL_XPATH = "//td";

    @FindBy(xpath = "//tbody//tr")
    private List<WebElement> tableContent;
    @FindBy(xpath = "//tr/th/span")
    private List<WebElement> sortSecretary;
    WebDriver driver;

    public ListOfSecretaryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getSecretaryID(String email) {
        List<WebElement> row = getElementsOfMass(email);
        if (!row.isEmpty())
            return row.get(0).getText();

        return null;
    }
    public String getSecretaryName(String email) {
        List<WebElement> row = getElementsOfMass(email);
        if (!row.isEmpty())
            return row.get(1).getText();

        return null;
    }

    public String getSecretaryName(int number) {
        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            return row.get(1).getText();

        return null;
    }

    public String getSecretarySurname(String email) {
        List<WebElement> row = getElementsOfMass(email);
        if (!row.isEmpty())
            return row.get(2).getText();

        return null;
    }

    public String getSecretarySurname(int number) {


        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            return row.get(2).getText();

        return null;
    }

    public String getSecretaryEmail(int number) {
        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            return row.get(3).getText();

        return null;
    }

    public boolean choseSortTypeEnabled(String unassignedUsers) {

        switch (unassignedUsers) {
            case Constants.UnassignedUsersSort.SYMBOL:
                return sortSecretary.get(Integer.parseInt(Constants.UnassignedUsersSort.SYMBOL)).isEnabled();
            case Constants.UnassignedUsersSort.NAME:
                return sortSecretary.get(Integer.parseInt(Constants.UnassignedUsersSort.NAME)).isEnabled();
            case Constants.UnassignedUsersSort.SURNAME:
                return sortSecretary.get(Integer.parseInt(Constants.UnassignedUsersSort.SURNAME)).isEnabled();
            case Constants.UnassignedUsersSort.EMAIL:
                return sortSecretary.get(Integer.parseInt(Constants.UnassignedUsersSort.EMAIL)).isEnabled();
        }
        return false;
    }

    public void choseSortType(String unassignedUsers) {

        switch (unassignedUsers) {
            case Constants.UnassignedUsersSort.SYMBOL:
                sortSecretary.get(Integer.parseInt(Constants.UnassignedUsersSort.SYMBOL)).click();
                break;
            case Constants.UnassignedUsersSort.NAME:
                sortSecretary.get(Integer.parseInt(Constants.UnassignedUsersSort.NAME)).click();
                break;
            case Constants.UnassignedUsersSort.SURNAME:
                sortSecretary.get(Integer.parseInt(Constants.UnassignedUsersSort.SURNAME)).click();
                break;
            case Constants.UnassignedUsersSort.EMAIL:
                sortSecretary.get(Integer.parseInt(Constants.UnassignedUsersSort.EMAIL)).click();
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
