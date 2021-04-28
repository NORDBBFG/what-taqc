package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

public class MyProfilePage extends BasePage {

    private final static String FIELD_NAME = "div[@class='col-sm-4 font-weight-bold pb-1']";
    private final static String ELEMENT_OF_FIELD = "div[@class='col-sm-8']";

    private final static String FIRST_NAME = "First Name:";
    private final static String LAST_NAME = "Last Name:";
    private final static String EMAIL_ADDRESS = "Email address:";

    private HashMap<String, WebElement> rowMap;

    @FindBy(xpath = "//h3[@class='pt-3']")
    private WebElement nameOfPage;
    @FindBy( xpath = "//div[@class='row mt-3']")
    private List<WebElement> rows;
    @FindBy(xpath = "//button[@type='button']")
    private WebElement changePasswordBtn;

    public MyProfilePage(WebDriver driver) {
        super(driver);
        rowMap = new HashMap<>();
    }

    public void clickChangePasswordBtn() {
        changePasswordBtn.click();
    }

    public boolean isChangePasswordEnable() {
        return changePasswordBtn.isEnabled();
    }

    public String getNameOfPage() {
        return nameOfPage.getText();
    }

    public String getFirstName() {
        return getContentOfRow(FIRST_NAME);
    }

    public String getLastName() {
        return getContentOfRow(LAST_NAME);
    }

    public String getEmailAddress() {
        return getContentOfRow(EMAIL_ADDRESS);
    }

    private void getRows() {
        if (rowMap.isEmpty()) {
            rows.forEach(r -> rowMap.put(
                    r.findElement(By.xpath(FIELD_NAME)).getText(),
                    r.findElement(By.xpath(ELEMENT_OF_FIELD)))
            );
        }
    }

    private String getContentOfRow(String rowName) {
        getRows();
        return rowMap.get(rowName).getText();
    }
}
