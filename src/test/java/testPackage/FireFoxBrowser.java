package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class FireFoxBrowser {
    WebDriver driver;
    FirefoxOptions options;
    @BeforeClass
    public void setUp(){
        this.options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        this.driver = new FirefoxDriver(options);
    }
    @Test
    public void verifySearchResult(){
        driver.manage().window().maximize();
        driver.get("https://www.google.com/ncr");
        WebElement searchField = driver.findElement(By.id("APjFqb"));
        searchField.sendKeys("TestNG");
        searchField.sendKeys(Keys.ENTER);
        // Wait until the page is fully loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement dynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='yuRUbf']//a//h3[not(ancestor::div[contains(@class,'Wt5Tfe')])]")));

        List<WebElement> searchResult =driver.findElements(By.xpath("//div[@class='yuRUbf']//a//h3[not(ancestor::div[contains(@class,'Wt5Tfe')])]"));
        String firstResult = searchResult.get(3).getText();
        Assert.assertEquals(firstResult , "TestNG Tutorial");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
