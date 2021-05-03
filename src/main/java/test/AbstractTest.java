package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import service.DriverOption;

public class AbstractTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverOption.manage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
