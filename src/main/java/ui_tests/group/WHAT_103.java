package ui_tests.group;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import step.group.ListOfGroupsPageStep;
import ui_tests.BaseTest;

public class WHAT_103 extends BaseTest {
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
    public static Object[][] notExistedGroupNames() {
        return new Object[][]{
                {"AAA"},
                {"hjHH"},
                {"1111"}
        };
    }


    @Test(groups = "groups", dataProvider = "notExistedGroupNames")
    public void searchByInvalidGroupName(String name) {
        listOfGroupsPageStep
                .searchByGroupName(name)
                .verifySearchByGroupHasText(name)
                .verifyGroupNotExists()
                .clearInputGroupName();
    }
}
