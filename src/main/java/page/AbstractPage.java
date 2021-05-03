package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public abstract class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
      //  PageFactory.initElements(this.driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver,10),this);
    }

    protected void fillField(WebElement element, String inputText) {
        element.clear();
        element.sendKeys(inputText);
    }

    protected  String getText(WebElement element){
        return element.getText();
    }

}

