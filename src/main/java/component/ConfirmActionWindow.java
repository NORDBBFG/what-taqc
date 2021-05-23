package component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;
import page.changepassword.ChangePasswordPage;

public class ConfirmActionWindow extends BasePage {

    @FindBy(xpath = "//h4")
    private WebElement confirmActionLabel;
    @FindBy(xpath = "//div[contains(@class, 'modal-body')]")
    private WebElement confirmActionMessage;
    @FindBy(xpath = "//button[contains(@class, 'btn-secondary')]")
    private WebElement cancelButton;
    @FindBy(xpath = "//button[contains(@class, 'btn-success')]")
    private WebElement confirmButton;
    @FindBy(xpath = "//button[@class='close']")
    private WebElement closeButton;

    public ConfirmActionWindow(WebDriver driver) {
        super(driver);
    }

    public ChangePasswordPage clickCancelButton(){
        cancelButton.click();
        return new ChangePasswordPage(driver);
    }

    public void clickConfirmButton(){
        confirmButton.click();
    }

    public boolean verifyConfirmActionWindow() throws InterruptedException {
        Thread.sleep(500);
        String expect = confirmActionLabel.getText();
        return expect.equals("Confirm action");
    }
}
