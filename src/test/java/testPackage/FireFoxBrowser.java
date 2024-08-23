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
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1920,1083)); // or 1080 , 720
//        another way to control screen size
//        driver.manage().window().maximize();
    }
    @Test
    public void verifySearchResult(){
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
