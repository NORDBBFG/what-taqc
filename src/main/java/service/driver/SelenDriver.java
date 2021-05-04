package service.driver;

import component.SelenElement;
import org.openqa.selenium.WebDriver;

public class SelenDriver implements Driver {

    private WebDriver webDriver;

    public SelenDriver(WebDriver driver) {
        webDriver = driver;
    }

    @Override
    public SelenElement findElement(String xPath) {
        return null;
    }
}
