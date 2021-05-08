package page.lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOfLessonPage extends BasePage {

    private static final String ROW_COL_XPATH = "td";
    private static final String HEADLINE_TEXT = "/span[@class = 'font-weight-bolder']";

    @FindBy(xpath = "//h2")
    private WebElement namePage;
    @FindBy(xpath = "//button[@class='btn btn-outline-secondary']")
    private WebElement blockViewBtn;
    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    private WebElement listViewBtn;

    @FindBy(xpath = "//button[contains(@class,'button-sort')]")
    private List<WebElement> tableSortingHeadlines;
    @FindBy(xpath = "//tbody//tr")
    private List<WebElement> tableContent;

    @FindBy(xpath = "//tbody/tr/td[2]")
    private List<WebElement> allThemeName;
    @FindBy(xpath = "//tbody/tr/td[3]")
    private List<WebElement> allDate;
    @FindBy(xpath = "//tbody/tr/td[4]")
    private List<WebElement> allTime;

    @FindBy(xpath = "//div[@class = 'col-2 text-right']")
    private WebElement countOfLessons;
    @FindBy(xpath = "//input[@type = 'text']")
    private WebElement searchByTheme;
    @FindBy(xpath = "//input[@type = 'date']")
    private WebElement searchByDate;

    @FindBy(xpath = "//button[contains(@class , 'page-link')]")
    private List<WebElement> buttonPages;
    @FindBy(xpath = "//button[@class = 'btn button__default___3hOmG button__button___24ZfP']")
    private WebElement addLessonBtn;

    public ListOfLessonPage(WebDriver driver) {
        super(driver);
    }

    public String getPageName() {
        return namePage.getText();
    }

    public String getCountOfLessons() {
        return countOfLessons.getText();
    }

    public String getRowCellText(int numberRow, int numberCol) {
        WebElement result = getRowContentCell(numberRow, numberCol);
        if (result != null) return result.getText();
        return null;
    }

    public String getSortingColText(int numberCol) {
        WebElement result = getCol(numberCol);
        if (result != null) return result.findElement(By.xpath(HEADLINE_TEXT)).getText();
        return null;
    }

    public List<String> getAllThemeName() {
        List<String> themes = new ArrayList<>();
        allThemeName.forEach(t -> themes.add(t.getText()));
        return themes;
    }

    public List<String> getAllDate() {
        List<String> date = new ArrayList<>();
        allDate.forEach(t -> date.add(t.getText()));
        return date;
    }

    public List<String> getAllTime() {
        List<String> time = new ArrayList<>();
        allTime.forEach(t -> time.add(t.getText()));
        return time;
    }

    public boolean isBlockViewBtnEnabled() {
        return blockViewBtn.isEnabled();
    }

    public boolean isListViewBtnEnabled() {
        return listViewBtn.isEnabled();
    }

    public boolean isAddLessonBtnEnabled() {
        return addLessonBtn.isEnabled();
    }

    public boolean isButtonPageEnabled(int number) {
        return buttonPages.get(number).isEnabled();
    }

    public boolean isLessonEditEnabled(int numberRow) {
        WebElement row = getRowContentCell(numberRow, 4);
        if (row != null) {
            return row.isEnabled();
        }
        return false;
    }

    public void setThemeSearchText(String input) {
        searchByTheme.sendKeys(input);
    }

    public void setDateSearch(String input) {
        searchByDate.sendKeys(input);
    }

    public void clickBlockViewBtn() {
        blockViewBtn.click();
    }

    public void clickListViewBtn() {
        listViewBtn.click();
    }

    public void clickAddLessonBtn() {
        addLessonBtn.click();
    }

    public void clickButtonPage(int number) {
        buttonPages.get(number).click();
    }

    public void clickLessonDetails(int numberCol) {
        WebElement row = getRow(numberCol);
        if (row != null) {
            row.click();
        }
    }

    public void clickLessonEdit(int numberRow) {
        WebElement row = getRowContentCell(numberRow, 4);
        if (row != null) {
            row.click();
        }
    }

    public void clickSorting(int numberCol) {
        WebElement col = getCol(numberCol);
        if (col != null) {
            col.click();
        }
    }

    private WebElement getRowContentCell(int numberRow, int numberCol) {
        List<WebElement> row = getRowContent(numberRow);
        if (!row.isEmpty()) {
            return row.get(numberCol);
        }
        return null;
    }

    private List<WebElement> getRowContent(int numberRow) {
        WebElement row = getRow(numberRow);
        if (row != null) {
            return row.findElements(By.xpath(ROW_COL_XPATH));
        }
        return Collections.emptyList();
    }

    private WebElement getRow(int number) {
        for (WebElement webElement : tableContent) {
            if (webElement.getAttribute("id").matches("" + number)) {
                return webElement;
            }
        }
        return null;
    }

    private WebElement getCol(int number) {
        if (!tableSortingHeadlines.isEmpty()) {
            return tableSortingHeadlines.get(number);
        }
        return null;
    }
}
