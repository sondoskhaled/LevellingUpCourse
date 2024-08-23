package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class FireFoxBrowser {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass

    public void setUp(){

        this.driver = new FirefoxDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1920,1083)); // or 1080 , 720
//        another way to control screen size
//        driver.manage().window().maximize();
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    @Test
    public void verifySearchResult(){
        driver.get("https://www.google.com/ncr");
        WebElement searchField = driver.findElement(By.id("APjFqb"));
        searchField.sendKeys("TestNG");
        searchField.sendKeys(Keys.ENTER);

        // Wait until the element is displayed
        String forthResult = wait.until(d-> {
            return driver.findElement(By.xpath("(//div[@class='yuRUbf']//a//h3[not(ancestor::div[contains(@class,'Wt5Tfe')])])[4]")).getText();
        });
        Assert.assertEquals(forthResult , "TestNG Tutorial");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
