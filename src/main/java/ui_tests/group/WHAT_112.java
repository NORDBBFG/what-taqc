package ui_tests.group;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import step.group.ListOfGroupsPageStep;
import ui_tests.BaseTest;

public class WHAT_112 extends BaseTest {
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
    @Test(groups = "groups")
    public void atc_WHAT_112() {
        listOfGroupsPageStep
                .verifySearchByDateInputVisible(true)
                .verifySearchByNameInputVisible(true)
                .verifyAddGroupButtonVisible(true)
                .verifyTableContentVisible(true)
                .verifyNumberHeaderVisible(true)
                .verifyGroupNameHeaderVisible(true)
                .verifyQuantityOfStudentsHeaderVisible(true)
                .verifyDateOfStartHeaderVisible(true)
                .verifyDateOfFinishHeaderVisible(true)
                .verifyEditHeaderVisible(true);
    }
}
