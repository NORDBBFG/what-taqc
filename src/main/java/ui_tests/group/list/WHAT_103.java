package test.group.list;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import step.group.ListOfGroupsPageStep;
import test.BaseTest;

public class WHAT_103 extends BaseTest {


    ListOfGroupsPageStep listOfGroupsPageStep;

    @BeforeClass()
    public void setBeforeGroups() {
        listOfGroupsPageStep = signInPageStep
                .setEmail("admin.@gmail.com")
                .setPassword("admiN_12")
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
