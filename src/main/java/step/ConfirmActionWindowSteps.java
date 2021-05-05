package step;

import component.ConfirmActionWindow;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.AbstractPage;
import page.changePassworPage.ChangePasswordPage;

public class ConfirmActionWindowSteps {

    public ConfirmActionWindowSteps(WebDriver driver) {
        confirmActionWindow = new ConfirmActionWindow(driver);
    }
    ConfirmActionWindow confirmActionWindow;

    public ChangePasswordPageSteps clickConfirmButton(WebDriver driver){
        confirmActionWindow.clickConfirmButton();
        return new  ChangePasswordPageSteps(driver);
    }
    public ChangePasswordPageSteps clickCancelButton(WebDriver driver){
        confirmActionWindow.clickCancelButton();
        return new ChangePasswordPageSteps(driver);
    }
    public ConfirmActionWindowSteps verifyConfirmActionWindow(boolean expected) throws InterruptedException {
        boolean result = confirmActionWindow.verifyConfirmActionWindow();
        Assert.assertEquals(result,expected , "Do not equals expected: "+expected+" Result: "+ result);
        return this;
    }


}
