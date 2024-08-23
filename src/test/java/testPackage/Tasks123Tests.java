package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.testng.Assert.assertTrue;

public class Tasks123Tests {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp(){
          this.driver = new ChromeDriver();
          driver.manage().window().setPosition(new Point(0,0));
          driver.manage().window().setSize(new Dimension(1920,1083)); // or 1080 , 720
//        another way to control screen size
//        driver.manage().window().maximize();
          this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }
    @Test
    public void goToGoogle()
    {
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
        driver.get("https://www.google.com/ncr");
        boolean isLogoVisible = driver.findElement(By.className("lnXdpd")).isDisplayed();
        assertTrue(isLogoVisible);
    }

    @Test
    public void verifySearchResult(){
        driver.get("https://www.google.com/ncr");
        WebElement searchField = driver.findElement(By.id("APjFqb"));
        searchField.sendKeys("Selenium WebDriver");
        searchField.sendKeys(Keys.ENTER);
        // Wait until the element is displayed using explicit wait
        String firstResult = wait.until(d-> driver.findElement(By.xpath("(//div[@class='yuRUbf']//a//h3)[1]")).getText());
        Assert.assertEquals(firstResult , "Selenium - Web Browser Automation");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
