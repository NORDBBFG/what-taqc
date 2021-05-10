package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import service.DriverOption;
import step.signin.SignInPageStep;

public abstract class BaseTest {

    protected WebDriver driver;
    protected SignInPageStep signInPageStep;

    @BeforeSuite
    public void setUp() {
        driver = DriverOption.manage();
        signInPageStep = new SignInPageStep(driver);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
