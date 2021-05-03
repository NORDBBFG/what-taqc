package component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;
import page.changePassworPage.ChangePasswordPage;

public class ConfirmActionWindow extends AbstractPage {


@FindBy(xpath = "//h4")
    private WebElement confirmActionLabel;
    @FindBy(xpath = "//div[@class='modal-window__modal-body___3v1gd modal-body']")
    private WebElement confirmActionMessage;
    @FindBy(xpath = "//button[@class='btn btn-secondary modal-window__modal-btn___bRf5m']")
    private WebElement cancelButton;
    @FindBy(xpath = "//button[@class='btn btn-success modal-window__modal-btn___bRf5m']")
    private WebElement confirmButton;
    @FindBy(xpath = "//button[@class='close']")
    private WebElement closeButton;

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


    public ConfirmActionWindow(WebDriver driver) {
        super(driver);
    }
}
