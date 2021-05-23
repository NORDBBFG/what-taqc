package step.group;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.group.ListOfGroupsPage;

import java.util.ArrayList;
import java.util.List;


public class ListOfGroupsPageStep {

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



    public ListOfGroupsPageStep assertSortedByRowNumber() throws InterruptedException {
        List<WebElement> tableContent= listOfGroupsPage.getTableContent();
        ArrayList<Integer>  rowInitialNumbers=new ArrayList<>();
        int min=0;
        for (WebElement e:
                tableContent) {
           int number = Integer.parseInt(e.findElement(By.xpath("td[1]")).getText());
            rowInitialNumbers.add(number);
            if(number<min){
                min=number;
            }
        }
//        if(min<1){ todo
//            throw  new Exception();
//        }

        for(int i=0; i<rowInitialNumbers.size(); i++){

        }


       Thread.sleep(10000);
        listOfGroupsPage.clickGroupNameHeader();
        System.out.println("After");
//        List<WebElement> afterSortByName= coursesListPage.getTableContent();
//        String[] sortedNames=new String[beforeSortByName.size()];
//        String[] beforeSortNames=new String[beforeSortByName.size()];
//        for(int i=0; i<beforeSortByName.size();i++){
//            int RowNum=i+1;
//            beforeSortNames[i]=beforeSortByName.get(i).findElement(By.xpath("["+RowNum+"]//td[2]")).getText();
//        }
//        for(int i=0; i<afterSortByName.size();i++){
//            int RowNum=i+1;
//            sortedNames[i]=(afterSortByName.get(i).findElement(By.xpath("["+RowNum+"]//td[2]")).getText());
//        }
//        System.out.println(Arrays.toString(beforeSortNames));
//        System.out.println(Arrays.toString(sortedNames));
        return this;
    }


}
