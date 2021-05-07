package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuit;
import org.testng.annotations.BeforeSuit;
import service.DriverOption;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = DriverOption.manage();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
