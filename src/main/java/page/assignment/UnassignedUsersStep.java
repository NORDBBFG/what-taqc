package page.assignment;

import org.openqa.selenium.WebDriver;

public class UnassignedUsersStep {

    private final UnassignedUsersPage UnassignedPage;

    public UnassignedUsersStep(WebDriver driver) {
        UnassignedPage = new UnassignedUsersPage(driver);
    }

    public UnassignedUsersStep AddRoleClick() {
        UnassignedPage.getAddRole().click();
        return this;
    }

    public UnassignedUsersStep ChoseSort(SortButton sortButton) {

        switch (sortButton) {
            case SYMBOL:
                UnassignedPage.getSort().get(Integer.parseInt(String.valueOf(SortButton.SYMBOL))).click();
                break;
            case NAME:
                UnassignedPage.getSort().get(Integer.parseInt(String.valueOf(SortButton.NAME))).click();
                break;
            case SURNAME:
                UnassignedPage.getSort().get(Integer.parseInt(String.valueOf(SortButton.SURNAME))).click();
                break;
            case EMAIL:
                UnassignedPage.getSort().get(Integer.parseInt(String.valueOf(SortButton.EMAIL))).click();
                break;
        }
        return this;

    }

    public UnassignedUsersStep ChoseSelect(RoleSelect roleSelect) {

        switch (roleSelect) {
            case CHOOSE:
                UnassignedPage.getSelect().selectByVisibleText(String.valueOf(RoleSelect.CHOOSE));
                break;
            case STUDENT:
                UnassignedPage.getSelect().selectByVisibleText(String.valueOf(RoleSelect.STUDENT));
                break;
            case MENTOR:
                UnassignedPage.getSelect().selectByVisibleText(String.valueOf(RoleSelect.MENTOR));
                break;
            case SECRETARY:
                UnassignedPage.getSelect().selectByVisibleText(String.valueOf(RoleSelect.SECRETARY));
                break;
        }
        return this;
    }
}