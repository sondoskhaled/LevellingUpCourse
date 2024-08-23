package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class TestBase {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        this.driver = new ChromeDriver();
    }
    @Test
    public void goToGoogle()
    {
        driver.manage().window().maximize();
//        another way to control screen size
//        driver.manage().window().setPosition(new Point(0,0));
//        driver.manage().window().setSize(new Dimension(1920,1083)); // or 1080 , 720
        driver.get("https://www.google.com/ncr");
    }
    @Test
    public void verifyTabTitle()
    {
        driver.manage().window().maximize();
        driver.get("https://www.google.com/ncr");
        String tabTitle = driver.getTitle();
        Assert.assertEquals(tabTitle,"Google");
    }
    @Test
    public void verifyGoogleLogo()
    {
        driver.manage().window().maximize();
        driver.get("https://www.google.com/ncr");
        boolean isLogoVisible = driver.findElement(By.className("lnXdpd")).isDisplayed();
        assertTrue(isLogoVisible);
    }

    @Test
    public void verifySearchResult(){
        driver.manage().window().maximize();
        driver.get("https://www.google.com/ncr");
        WebElement searchField = driver.findElement(By.id("APjFqb"));
        searchField.sendKeys("Selenium WebDriver");
        searchField.sendKeys(Keys.ENTER);
        // Wait until the page is fully loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        });
        List<WebElement> searchResult =driver.findElements(By.xpath("//div[@id='search']//div[last()]//h3"));
        String firstResult = searchResult.getFirst().getText();
        Assert.assertEquals(firstResult , "WebDriver - Selenium");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
