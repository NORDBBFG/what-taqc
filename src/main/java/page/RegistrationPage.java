package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractPage {

    private static final String REGISTRATION_LINK ="//a[contains(text(),'Registration')]";

    @FindBy(xpath = "//h3[contains(text(),'Sign in to WHAT')]")
    private WebElement pageName;
    @FindBy(xpath = REGISTRATION_LINK)
    private WebElement registrationLink;
    @FindBy(name = "firstName")
    private WebElement firstNameInput;
    @FindBy(name = "lastName")
    private WebElement lastNameInput;
    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy (xpath = "//button[contains(text(),'Sign up')]")
    private WebElement signUpButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private WebElement findRegistrationItem(String name){

        if(registrationLink.findElement(By.xpath(REGISTRATION_LINK)).getText().equalsIgnoreCase(name)) {
            return registrationLink;
        }
        return null;
    }

    public void clickRegistrationLink() {
        registrationLink.click();
    }

    public void clickRegistrationItem(String name){
        WebElement resultItem = findRegistrationItem(name);
        if(resultItem!=null){
            resultItem.click();
        }
    }

    public boolean isRegistrationLinkEnable() { return true;}
    public String getPageName() {
        return pageName.getText();
    }

    public void fillFirstName(String firstName) {
        fillField(firstNameInput, firstName);
    }

    public void fillLastName(String lastName) {
        fillField(lastNameInput, lastName);
    }

    public void fillEmail(String email) {
        fillField(emailInput, email);
    }

    public void fillPassword(String password) {
        fillField(passwordInput, password);
    }

    public void fillConfirmPassword(String confirmPassword) {
        fillField(confirmPasswordInput, confirmPassword);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    private void fillField(WebElement element, String inputText) {
        element.clear();
        element.sendKeys(inputText);
    }
}
