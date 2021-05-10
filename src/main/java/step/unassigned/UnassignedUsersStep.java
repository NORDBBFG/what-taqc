package step.unassigned;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.unassigned.UnassignedUsersPage;
import step.BaseStep;

public class UnassignedUsersStep extends BaseStep {

    private final UnassignedUsersPage UnassignedPage;

    public UnassignedUsersStep(WebDriver driver) {
        UnassignedPage = new UnassignedUsersPage(driver);
        UnassignedPage.clickSidebarItem("Assigment");
    }

    public UnassignedUsersStep addRoleButtonClick(int number) {
        UnassignedPage.addRoleButtonClick(number);
        return this;
    }

    public UnassignedUsersStep choseUserSort(String unassignedUsers) {

        UnassignedPage.choseSort( unassignedUsers);
        return this;
    }

    public UnassignedUsersStep choseUserChoseRole(int number, String unassignedUsers) {
//        Assert.assertEquals(UnassignedPage.choseUserRole( number, unassignedUsers),expected);
        UnassignedPage.choseUserRole( number, unassignedUsers);
        return this;
    }

    public UnassignedUsersStep verifyIdUser(String email, String expected) {
        Assert.assertEquals(UnassignedPage.getSurnameUser(email),expected);
        return this;
    }

    public UnassignedUsersStep verifyUnassignedUser(int number, String expected) {
        Assert.assertEquals(UnassignedPage.getUnassignedUser(number),expected);
        return this;
    }

    public UnassignedUsersStep verifyUnassignedUser(String email, String expected) {
        Assert.assertEquals(UnassignedPage.getUnassignedUser(email),expected);
        return this;
    }

    public UnassignedUsersStep verifySurnameUser(int number, String expected) {
        Assert.assertEquals(UnassignedPage.getSurnameUser(number),expected);
        return this;
    }

    public UnassignedUsersStep verifySurnameUser(String email, String expected) {
        Assert.assertEquals(UnassignedPage.getSurnameUser(email),expected);
        return this;
    }

    public UnassignedUsersStep verifyEmailUser(int number, String expected) {
        Assert.assertEquals(UnassignedPage.getEmailUser(number),expected);
        return this;
    }





}