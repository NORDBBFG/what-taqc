package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public abstract class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    protected void fillField(WebElement element, String inputText) {
        element.clear();
        element.sendKeys(inputText);
    }

    protected  String getText(WebElement element){
        return element.getText();
    }

}
//*[@id="root"]/div/div/div/div/form/div/div[2]
//*[@id="root"]/div/div/div/div/form/div/div[3]

//*[@id="root"]/div/div/div/div/form/div/div[2]/div[2]/div
//*[@id="root"]/div/div/div/div/form/div/div[3]/div[2]/div
