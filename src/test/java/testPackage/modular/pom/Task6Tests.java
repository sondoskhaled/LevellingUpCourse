package testPackage.modular.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.task6.CheckboxesPages;

import java.time.Duration;

public class Task6Tests {
    WebDriver driver;
    Wait<WebDriver> wait;
    CheckboxesPages checkboxesPages;
    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1080 , 720));

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class);

        checkboxesPages = new CheckboxesPages(driver);
    }

    @Test(description = "verify that the 2 checkboxes are selected")
    public void verifySelectionOf2Checkboxes(){
        checkboxesPages.navigate();
        wait.until(d-> {
            checkboxesPages.clickOnCheckbox1();
            return true;
        });
        boolean isSelectCheckbox1 = wait.until(d-> checkboxesPages.checkSelectionOfCheckbox1());
        boolean isSelectCheckbox2 = wait.until(d-> checkboxesPages.checkSelectionOfCheckbox2());

        Assert.assertTrue(isSelectCheckbox1);
        Assert.assertTrue(isSelectCheckbox2);
    }

    @AfterMethod
    public void tearDown ()
    {
        driver.quit();
    }

}
