package pages;

import org.openqa.selenium.WebElement;
import tests.WexincTest;

import java.util.List;

public class WexPage {

    private WexincTest test;

    public WexPage(){
        test = new WexincTest();
    }

    public void NavigateToWex(String page) {
        test.visitPage(page);
    }

    public void getSearchField(String searchElement) {
        test.selectSearchField(searchElement);
    }

    public void fillSearchField(String element, String text){
        test.writeTextOnElement(element, text);
    }

    public void clickSearchField(String elementXPath){
        test.clickAtElement(elementXPath);
    }

    public List<WebElement> selectResults(String results) {
        return test.selectAllResults(results);
    }

    public String getPageUrl(){
        return test.getUrl();
    }

    public WebElement getElement(String element) {
       return test.getElement(element);
    }

    public WebElement getCssSelector(String element) {
        return test.getCssSelector(element);
    }

    public Boolean containsUrl(){
        return test.urlConstains();
    }
    public void testQuit(){
        test.driverQuite();
    }


}
