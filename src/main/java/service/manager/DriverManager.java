package service.manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import service.driver.Driver;
import service.driver.SelenDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    public enum DriverType {
        SELENIUM
    }

    public Driver getDriver(DriverManagerOptions options, DriverType driverType) {
        switch (driverType) {
            case SELENIUM:
                return setBrowserType(options);
            default:
                throw new RuntimeException("No such driver type");
        }
    }

    private SelenDriver setBrowserType(DriverManagerOptions options) {
        WebDriver selenDriver = null;
        switch (options.getBrowserType()) {
            case CHROME:
                selenDriver = new ChromeDriver();
                break;
            case FIREFOX:
                selenDriver = new FirefoxDriver();
                break;
            case OPERA:
                selenDriver = new OperaDriver();
                break;
            case YANDEX:
                throw new RuntimeException("Not support such browser");
            case EDGE:
                selenDriver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("No such browser");
        }

        selenDriver.manage().window().setSize(new Dimension(options.getWidthScreen(), options.getHeightScreen()));
        selenDriver.manage().timeouts().implicitlyWait(options.getImplicitWait(), TimeUnit.SECONDS);
        //TODO quietModeOn, incognitoModeOn
        return new SelenDriver(selenDriver);
    }

}
