package testPackage.modular.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.task7.TablePage;

import java.time.Duration;

public class Task7Tests {
    WebDriver driver;
    Wait<WebDriver> wait;
    TablePage tablePage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1080 , 720));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class);
        tablePage = new TablePage(driver);
    }

    @Test(description = "verify that the country is 'Austria' if company value is 'Ernst Handel' ")
    public void verifyCountryValue(){
        tablePage.navigate();
        String country = wait.until(d-> tablePage.getCountryValue() );
        Assert.assertEquals(country ,"Austria");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
