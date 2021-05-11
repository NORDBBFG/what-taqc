package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import service.DriverOption;
import step.signin.SignInPageStep;

public abstract class BaseTest {

    protected WebDriver driver;
    protected SignInPageStep signInPageStep;


    @BeforeClass
    public void setUp() {
        driver = DriverOption.manage();
        signInPageStep = new SignInPageStep(driver);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
