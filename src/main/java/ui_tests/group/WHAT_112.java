package ui_tests.group;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import step.group.ListOfGroupsPageStep;
import ui_tests.BaseTest;

public class WHAT_112 extends BaseTest {

    ListOfGroupsPageStep listOfGroupsPageStep;

    @BeforeClass()
    public void setBeforeGroups() {
        listOfGroupsPageStep = signInPageStep
                .setEmail("admin.@gmail.com")
                .setPassword("admiN_12")
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