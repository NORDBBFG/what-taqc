package step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.LessonDetailsPage;
import page.listPage.CoursesListPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoursesListPageStep {
    CoursesListPage coursesListPage;

    public CoursesListPageStep(WebDriver driver){
        coursesListPage = new CoursesListPage(driver);
    }

    public CoursesListPageStep clickNumberHeader(){
        coursesListPage.clickNumberHeader();
        return this;
    }
    public CoursesListPageStep clickGroupNameHeader(){
        coursesListPage.clickGroupNameHeader();
        return this;
    }

    public CoursesListPageStep clickQuantityOfStudentsHeader(){
        coursesListPage.clickQuantityOfStudentsHeader();
        return this;
    }

    public CoursesListPageStep clickDateOfStartHeader(){
        coursesListPage.clickDateOfStartHeader();
        return this;
    }

    public CoursesListPageStep clickDateOfFinishHeader(){
        coursesListPage.clickDateOfFinishHeader();
        return this;
    }
    public CoursesListPageStep searchByGroupName(String groupName){
        coursesListPage.searchByGroupName(groupName);
        return this;
    }
    public CoursesListPageStep clickAddGroupButton(){
        coursesListPage.clickAddGroupButton();
        return this;
    }
    public CoursesListPageStep uploadGroupButton(){
        coursesListPage.uploadGroupButton();
        return this;
    }
    public CoursesListPageStep clickEditIconInRow(Integer rowNumber){
        coursesListPage.clickEditIconInRow(rowNumber);
        return this;
    }
    public CoursesListPageStep clickOnRow(Integer rowNumber){
        coursesListPage.clickEditIconInRow(rowNumber);
        return this;
    }

    public CoursesListPageStep assertSortedByRowNumber() throws InterruptedException {
        List<WebElement> tableContent= coursesListPage.getTableContent();
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
        coursesListPage.clickGroupNameHeader();
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
