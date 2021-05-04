package step;



import org.openqa.selenium.WebDriver;
import page.UnassignedUsersPage;

public class UnassignedUsersStep {

    private final UnassignedUsersPage UnassignedPage;

    public UnassignedUsersStep(WebDriver driver) {
        UnassignedPage = new UnassignedUsersPage(driver);
        UnassignedPage.clickSidebarItem("Assigment");

    }


    public UnassignedUsersStep AddRoleButtonClick(int number) {
        UnassignedPage.addRoleButtonClick(number);
        return this;
    }

    public UnassignedUsersStep ChoseUserSort( String unassignedUsers) {

        UnassignedPage.ChoseSort( unassignedUsers);
        return this;
    }
    public UnassignedUsersStep ChoseUserChoseRole( int number, String unassignedUsers) {

        UnassignedPage.ChoseUserRole( number, unassignedUsers);
        return this;
    }
    public UnassignedUsersStep getIdUser(String email) {

        System.out.println(UnassignedPage.getIdUser(email));
        return this;

    }
    public UnassignedUsersStep getUnassignedUser(int number) {

        System.out.println(UnassignedPage.getUnassignedUser(number));
        return this;
    }

    public UnassignedUsersStep getUnassignedUser(String email) {

        System.out.println(UnassignedPage.getUnassignedUser(email));
        return this;
    }

    public UnassignedUsersStep getSurnameUser(int number) {

        System.out.println(UnassignedPage.getSurnameUser(number));
        return this;
    }

    public UnassignedUsersStep getSurnameUser(String email) {

        System.out.println(UnassignedPage.getSurnameUser(email));
        return this;
    }

    public UnassignedUsersStep getEmailUser(int number) {

        System.out.println(UnassignedPage.getEmailUser(number));
        return this;
    }





}