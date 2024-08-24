package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class ApplyWFMOnTasks34 {
    /**
     * #3
     * ________________ Basic ________________
     * Open Mozilla Firefox
     * Navigate to [https://duckduckgo.com/]
     * Search for [Selenium WebDriver]
     * Assert that the link of the first result is [https://www.selenium.dev/documentation/webdriver/]
     * Close Mozilla Firefox
     *
     * #4
     * ________________ Moderate ________________
     * Open Mozilla Firefox
     * Navigate to [https://duckduckgo.com/]
     * Search for [TestNG]
     * Assert that the text of the fourth result is [TestNG Tutorial]
     * Close Mozilla Firefox
     */
    WebDriver driver;
    Wait<WebDriver> wait=
            new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(2))
                    .pollingEvery(Duration.ofMillis(300))
                    .ignoring(NotFoundException.class)
                    .ignoring(StaleElementReferenceException.class);
    By searchField = By.xpath("//input[@id = 'searchbox_input']");

    @BeforeMethod
    public void setUp (){
        this.driver = new FirefoxDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1080,720)); // 1920 , 1083
        driver.navigate().to("https://duckduckgo.com/");

    }
    @Test
    public void task3 () {
        driver.findElement(searchField).sendKeys("Selenium WebDriver" , Keys.ENTER);
        String firstLink = wait.until(d-> driver.findElement(By.xpath
                ("(//article)[1]//h2//a")).getAttribute("href"));
        Assert.assertEquals(firstLink , "https://www.selenium.dev/documentation/webdriver/");

    }
    @Test
    public void task4 () {
        driver.findElement(searchField).sendKeys("TestNG" , Keys.ENTER);
        String forthResult = wait.until(d-> driver.findElement(By.xpath
                ("(//article)[4]//h2")).getText());
        Assert.assertEquals(forthResult , "TestNG Tutorial");

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
