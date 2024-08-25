package testPackage.linear;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class Task4Tests {
    WebDriver driver;
    Wait<WebDriver> wait;
    @BeforeClass

    public void setUp(){

        this.driver = new FirefoxDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1920,1083)); // or 1080 , 720
        this.wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(2))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(NotFoundException.class)
                        .ignoring(StaleElementReferenceException.class);
    }
    @Test
    public void verifySearchResult(){
        driver.navigate().to("https://www.google.com/ncr");
        WebElement searchField = driver.findElement(By.id("APjFqb"));
        searchField.sendKeys("TestNG");
        searchField.sendKeys(Keys.ENTER);

        // Wait until the element is displayed using fluent wait
        String forthResult = wait.until(d-> driver.findElement(By.xpath("(//div[contains(@class,'yuRUbf')]//h3[not(ancestor::div[contains(@class,'Wt5Tfe')])])[4]")).getText());
        Assert.assertEquals(forthResult , "TestNG Tutorial");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
