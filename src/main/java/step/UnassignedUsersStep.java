package step;


import component.WebElements.UnassignedUsers;
//import component.WebElements.UnassignedUsers.RoleSelect;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.UnassignedUsersPage;

public class UnassignedUsersStep {

    private final UnassignedUsersPage UnassignedPage;

    public UnassignedUsersStep(WebDriver driver) {
        UnassignedPage = new UnassignedUsersPage(driver);
    }

    public UnassignedUsersStep AddRoleClick() {
        UnassignedPage.getAddRole().click();
        return this;
    }

    public void ChoseUserSort(String unassignedUsers) {

        WebElement addSort = UnassignedPage.ChoseSort(unassignedUsers);
        addSort.click();

    }
    public void ChoseUserRole(String roleSelect) {

        WebElement addRole = UnassignedPage.ChoseSort(roleSelect);
        addRole.click();
    }

}