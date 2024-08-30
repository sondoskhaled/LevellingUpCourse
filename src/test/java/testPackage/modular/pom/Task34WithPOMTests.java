package testPackage.modular.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.SearchResultPage;

import java.time.Duration;
/**
 *
 * #3
 * ________________ Basic ________________
 * Open Mozilla Firefox
 * Navigate to [<a href="https://duckduckgo.com/">...</a>]
 * Search for [Selenium WebDriver]
 * Assert that the link of the first result is [<a href="https://www.selenium.dev/documentation/webdriver/">...</a>]
 * Close Mozilla Firefox
 * #4
 * ________________ Moderate ________________
 * Open Mozilla Firefox
 * Navigate to [<a href="https://duckduckgo.com/">...</a>]
 * Search for [TestNG]
 * Assert that the text of the fourth result is [TestNG Tutorial]
 * Close Mozilla Firefox
 *  ApplyPageObjectModel
 */
public class Task34WithPOMTests {


    WebDriver driver;
    Wait<WebDriver> wait;
    LandingPage landingPage;
    SearchResultPage searchResultPage;
    @BeforeMethod
    public void setUp (){
        this.driver = new FirefoxDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1080 , 720));
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class);
        landingPage = new LandingPage(driver);
        searchResultPage = new SearchResultPage(driver);
        landingPage.navigate();

    }
    @Test(description = "verify that when user search with 'Selenium WebDriver' the first result link is https://www.selenium.dev/documentation/webdriver/ ")
    public void verifyFirstSearchResultLink(){
        landingPage.search("Selenium WebDriver");
        String firstResultLink = wait.until(d-> searchResultPage.getFirstResultLink());
        Assert.assertEquals(firstResultLink , "https://www.selenium.dev/documentation/webdriver/");
    }

    @Test(description = "verify that when user search with 'TestNG' the forth result text is TestNG Tutorial")
    public void verifyForthSearchResultText(){
        landingPage.search("TestNG");
        String forthResultText = wait.until(d-> searchResultPage.getForthResultText());
        Assert.assertEquals(forthResultText , "TestNG Tutorial");
    }


    @AfterMethod
    public void tearDown (){
        driver.quit();
    }
}
