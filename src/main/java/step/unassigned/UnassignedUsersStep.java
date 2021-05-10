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


    public UnassignedUsersStep verifyIdUser(String email, String expected) {

        Assert.assertEquals(UnassignedPage.getSurnameUser(email), expected);
        return this;
    }


    public UnassignedUsersStep verifyUnassignedUser(int number, String expected) {

        Assert.assertEquals(UnassignedPage.getUnassignedUser(number), expected);
        return this;
    }

    public UnassignedUsersStep verifyUnassignedUser(String email, String expected) {

        Assert.assertEquals(UnassignedPage.getUnassignedUser(email), expected);
        return this;
    }


    public UnassignedUsersStep verifySurnameUser(int number, String expected) {

        Assert.assertEquals(UnassignedPage.getSurnameUser(number), expected);
        return this;
    }

    public UnassignedUsersStep verifySurnameUser(String email, String expected) {

        Assert.assertEquals(UnassignedPage.getSurnameUser(email), expected);
        return this;
    }


    public UnassignedUsersStep verifyEmailUser(int number, String expected) {

        Assert.assertEquals(UnassignedPage.getEmailUser(number), expected);
        return this;
    }


    public UnassignedUsersStep verifyAddRoleButtonEnabled(int number, boolean expected) {

        Assert.assertEquals(UnassignedPage.addRoleButtonEnabled(number), expected);
        return this;
    }

    public UnassignedUsersStep verifyChoseSortEnabled(String unassignedUsers, boolean expected) {

        Assert.assertEquals(UnassignedPage.choseSortEnabled(unassignedUsers),expected);
        return this;
    }

    public UnassignedUsersStep verifyChoseUserRole(int number, String unassignedUsers, boolean expected) {

        Assert.assertEquals(UnassignedPage.choseUserRoleEnabled( number, unassignedUsers),expected);
        return this;
    }



    public void addRoleButtonClick(int number) {

        UnassignedPage.addRoleButtonClick(number);
    }

    public void choseSortType(String unassignedUsers) {

        UnassignedPage.choseSortType(unassignedUsers);
    }

    public void choseUserRole(int number, String unassignedUsers) {
        UnassignedPage.choseUserRole(number, unassignedUsers);
    }
}