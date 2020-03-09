package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WexincTest {

    private WebDriver driver;

    public WexincTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("disable-features=NetworkService");
        options.addArguments("--disable-gpu");
        options.addArguments("--log-level=3");
        options.addArguments("--silent");
        options.setProxy(null);

        driver = new ChromeDriver(options);
    }

    public void visitPage(String page) {
        driver.get(page);
    }

    public void selectSearchField(String search) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(search)));

        //Keep clicking until the Search Bar appears
        WebElement searchButton = driver.findElement(By.xpath("//*[contains(@class, 'button') and contains(@class, 'wex-search-group-button')]"));
        while (!searchButton.isDisplayed()) {
            button.click();
        }
    }

    public void writeTextOnElement(String element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
        textBox.sendKeys(text);
    }

    public void clickAtElement(String elementXPath) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXPath)));
        button.click();
    }

    public List<WebElement> selectAllResults(String resultsreturneds) {
        return driver.findElements(By.xpath(resultsreturneds));
    }
    public WebElement getElement(String element) {
        return driver.findElement(By.xpath(element));
    }

    public WebElement getCssSelector(String element) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public Boolean urlContains(){
        return driver.getPageSource().contains("total results");
    }

    public void driverQuit(){
        driver.quit();
    }

}
