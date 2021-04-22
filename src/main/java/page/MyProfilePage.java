package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

public class MyProfilePage extends AbstractPage {

//    @FindBy(xpath = "//div[@class='container pb-2']")
//    private WebElement block;

    @FindBy(xpath = "//h3[@class='pt-3']")
    private WebElement nameOfPage;
//    @FindAll(@FindBy( xpath = "//div[@class='row mt-3']"))
//    private List<WebElement> rows;

    private HashMap<String, WebElement> rowMap;

    @FindBy(xpath = "//button[@type='button']")
    private WebElement changePasswordBtn;

    public MyProfilePage(WebDriver driver) {
        super(driver);
        rowMap = new HashMap<>();
        getRows(driver);
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
        return getContentOfRow("First Name:");
    }

    public String getLastName() {
        return getContentOfRow("Last Name:");
    }

    public String getEmailAddress() {
        return getContentOfRow("Email address:");
    }

    private void getRows(WebDriver driver) {
        if (rowMap.isEmpty()) {
            List<WebElement> rows = driver.findElements(By.xpath("//div[@class='row mt-3']"));
            rows.forEach(
                    r -> rowMap.put(
                            r.findElement(By.xpath("//div[@class='col-sm-4 font-weight-bold pb-1']")).getText(),
                            r.findElement(By.xpath("//div[@class='col-sm-8']")))

            );

//            for (WebElement row : rows) {
//                System.out.println(row.findElement(By.xpath("//div[@class='col-sm-4 font-weight-bold pb-1']")).getText());
//                rowMap.put(row.findElement(By.xpath("//div[@class='col-sm-4 font-weight-bold pb-1']")).getText(),
//                        row.findElement(By.xpath("//div[@class='col-sm-8']")));
//            }
//            System.out.println(rows.size());
//            System.out.println(rowMap.size());
        }
    }

    private String getContentOfRow(String rowName) {
//        getRows();
        return rowMap.get(rowName).getText();
    }
}
