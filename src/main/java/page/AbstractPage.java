package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

        private final WebDriver driver;

        public WebDriver getDriver(){
            return driver;
        }

        public AbstractPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(this.driver, this);
        }
}
