package testPackage.modular.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.task9.DragAndDropPage;

import java.time.Duration;

public class Task9Tests {
    WebDriver driver;
    Wait<WebDriver> wait;
    DragAndDropPage dragAndDropPage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1080,720));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class);

        dragAndDropPage = new DragAndDropPage(driver);
    }
    @Test
    public void verifyDragAndDrop()
    {
        dragAndDropPage.navigate();
        String text = wait.until(d -> dragAndDropPage.dragDropObj());
        Assert.assertEquals(text , "Dropped!");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
