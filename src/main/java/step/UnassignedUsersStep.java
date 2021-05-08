package step;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.UnassignedUsersPage;

public class UnassignedUsersStep {

    private final UnassignedUsersPage UnassignedPage;

    public UnassignedUsersStep(WebDriver driver) {

        UnassignedPage = new UnassignedUsersPage(driver);
        UnassignedPage.clickSidebarItem("Assigment");

    }


    public UnassignedUsersStep verifyIdUser(String email, String expected) {

        Assert.assertEquals(UnassignedPage.getSurnameUser(email), expected);
//        System.out.println(UnassignedPage.getIdUser(email));
        return this;
    }


    public UnassignedUsersStep verifyUnassignedUser(int number, String expected) {

        Assert.assertEquals(UnassignedPage.getUnassignedUser(number), expected);
//        System.out.println(UnassignedPage.getUnassignedUser(number));
        return this;
    }

    public UnassignedUsersStep verifyUnassignedUser(String email, String expected) {

        Assert.assertEquals(UnassignedPage.getUnassignedUser(email), expected);
//        System.out.println(UnassignedPage.getUnassignedUser(email));
        return this;
    }


    public UnassignedUsersStep verifySurnameUser(int number, String expected) {

        Assert.assertEquals(UnassignedPage.getSurnameUser(number), expected);
//        System.out.println(UnassignedPage.getSurnameUser(number));
        return this;
    }

    public UnassignedUsersStep verifySurnameUser(String email, String expected) {

        Assert.assertEquals(UnassignedPage.getSurnameUser(email), expected);
//        System.out.println(UnassignedPage.getSurnameUser(email));
        return this;
    }


    public UnassignedUsersStep verifyEmailUser(int number, String expected) {

        Assert.assertEquals(UnassignedPage.getEmailUser(number), expected);
//        System.out.println(UnassignedPage.getEmailUser(number));
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
//        UnassignedPage.choseUserRole(number, unassignedUsers);
        return this;
    }



    public void addRoleButtonClick(int number) {

        UnassignedPage.addRoleButtonClick(number);
    }

    public void choseSortType(String unassignedUsers) {

        UnassignedPage.choseSortType(unassignedUsers);
    }

    public void choseUserRole(int number, String unassignedUsers) {
//        Assert.assertEquals(UnassignedPage.choseUserRole( number, unassignedUsers),expected);
        UnassignedPage.choseUserRole(number, unassignedUsers);
    }
}