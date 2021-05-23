package step.group;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.group.ListOfGroupsPage;
import step.BaseStep;

public class ListOfGroupsPageStep<logger> extends BaseStep {

    ListOfGroupsPage listOfGroupsPage;

    public ListOfGroupsPageStep(WebDriver driver){
        listOfGroupsPage = new ListOfGroupsPage(driver);
    }

    public ListOfGroupsPageStep clickNumberHeader(){
        listOfGroupsPage.clickNumberHeader();
        return this;
    }
    public ListOfGroupsPageStep clickGroupNameHeader(){
        listOfGroupsPage.clickGroupNameHeader();
        return this;
    }

    public ListOfGroupsPageStep clickQuantityOfStudentsHeader(){
        listOfGroupsPage.clickQuantityOfStudentsHeader();
        return this;
    }

    public ListOfGroupsPageStep clickDateOfStartHeader(){
        listOfGroupsPage.clickDateOfStartHeader();
        return this;
    }

    public ListOfGroupsPageStep clickDateOfFinishHeader(){
        listOfGroupsPage.clickDateOfFinishHeader();
        return this;
    }
    public ListOfGroupsPageStep searchByGroupName(String groupName){
        listOfGroupsPage.searchByGroupName(groupName);
        return this;
    }

    public ListOfGroupsPageStep verifySearchByDateInputVisible(boolean expected){
        boolean isVisible = listOfGroupsPage.isSearchByDateInputIsVisible();
        Assert.assertEquals(isVisible,expected );
        return this;
    }
        public ListOfGroupsPageStep verifySearchByNameInputVisible(boolean expected){
        boolean isVisible = listOfGroupsPage.isSearchByNameInputIsVisible();
        Assert.assertEquals(isVisible,expected );
        return this;
    }
    public ListOfGroupsPageStep verifyAddGroupButtonVisible(boolean expected){
        boolean isVisible = listOfGroupsPage.isAddGroupButtonVisible();
        Assert.assertEquals(isVisible,expected );
        return this;
    }
        public ListOfGroupsPageStep verifyUploadGroupButtonVisible(boolean expected){
        boolean isVisible = listOfGroupsPage.isUploadGroupButtonVisible();
        Assert.assertEquals(isVisible,expected );
        return this;
    }

    public ListOfGroupsPageStep verifyTableContentVisible(boolean expected){
        boolean isVisible = listOfGroupsPage.isTableContentVisible();
        Assert.assertEquals(isVisible,expected );
        return this;
    }
   public ListOfGroupsPageStep verifyNumberHeaderVisible(boolean expected){
        boolean isVisible = listOfGroupsPage.isNumberHeaderIsVisible();
        Assert.assertEquals(isVisible,expected );
        return this;
    }
  public ListOfGroupsPageStep verifyGroupNameHeaderVisible(boolean expected){
        boolean isVisible = listOfGroupsPage.isGroupNameHeaderIsVisible();
        Assert.assertEquals(isVisible,expected );
        return this;
    }
 public ListOfGroupsPageStep verifyQuantityOfStudentsHeaderVisible(boolean expected){
        boolean isVisible = listOfGroupsPage.isQuantityOfStudentsHeaderIsVisible();
        Assert.assertEquals(isVisible,expected );
        return this;
    }
 public ListOfGroupsPageStep verifyDateOfStartHeaderVisible(boolean expected){
        boolean isVisible = listOfGroupsPage.isDateOfStartHeaderIsVisible();
        Assert.assertEquals(isVisible,expected );
        return this;
    }
public ListOfGroupsPageStep verifyDateOfFinishHeaderVisible(boolean expected){
        boolean isVisible = listOfGroupsPage.isDateOfFinishHeaderIsVisible();
        Assert.assertEquals(isVisible,expected );
        return this;
    }
public ListOfGroupsPageStep verifyEditHeaderVisible(boolean expected){
        boolean isVisible = listOfGroupsPage.isEditHeaderIsVisible();
        Assert.assertEquals(isVisible,expected );
        return this;
    }

    public ListOfGroupsPageStep clickAddGroupButton(){
        listOfGroupsPage.clickAddGroupButton();
        return this;
    }
    public ListOfGroupsPageStep uploadGroupButton(){
        listOfGroupsPage.uploadGroupButton();
        return this;
    }
    public ListOfGroupsPageStep clickEditIconInRow(Integer rowNumber){
        listOfGroupsPage.clickEditIconInRow(rowNumber);
        return this;
    }
    public ListOfGroupsPageStep clickOnRow(Integer rowNumber){
        listOfGroupsPage.clickEditIconInRow(rowNumber);
        return this;
    }

     public ListOfGroupsPageStep clearInputGroupName(){
        listOfGroupsPage.clearInputGroupName();
        return this;
    }

    public ListOfGroupsPageStep verifyGroupExists(String expected){
        String groupName=listOfGroupsPage.getTableContent().get(0).findElement(By.xpath("td[2]")).getText();
        Assert.assertEquals(groupName,expected );
        return this;
    }

    public ListOfGroupsPageStep verifyGroupNotExists(){
        String msg=listOfGroupsPage.getTableContent().get(0).findElement(By.xpath("td[1]")).getText();
        Assert.assertEquals(msg, "Group is not found");
        return this;
    }

    public ListOfGroupsPageStep verifySearchByGroupHasText(String expected){
        Assert.assertEquals(listOfGroupsPage.getTextFromSearch(), expected);
        return this;
    }
}
