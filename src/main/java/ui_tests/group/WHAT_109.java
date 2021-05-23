package ui_tests.group;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import step.group.ListOfGroupsPageStep;
import ui_tests.BaseTest;

public class WHAT_109 extends BaseTest {
    String email = "admin.@gmail.com";
    String password = "admiN_12";

    ListOfGroupsPageStep listOfGroupsPageStep;

    @BeforeClass()
    public void setBeforeGroups() {
        listOfGroupsPageStep = signInPageStep
                .setEmail(email)
                .setPassword(password)
                .clickSignInBtn(ListOfGroupsPageStep.class, driver);
    }

    @DataProvider
    public static Object[][] existedGroupNames() {
        return new Object[][]{
                {"Slytherin"},
                {"Griffindor"},
                {"КП-89"}
        };
    }

    @Test(groups = "groups", dataProvider = "existedGroupNames")
    public void searchByGroupName(String name) {
        listOfGroupsPageStep
                .searchByGroupName(name)
                .verifySearchByGroupHasText(name)
                .verifyGroupExists(name)
                .clearInputGroupName();
    }
}
