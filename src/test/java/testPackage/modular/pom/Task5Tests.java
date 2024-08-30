package testPackage.modular.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LandingPage;
import pages.SearchResultPage;

import java.time.Duration;

public class Task5Tests {
    WebDriver driver;
    Wait<WebDriver> wait;
    LandingPage landingPage;
    SearchResultPage searchResultPage;
    @BeforeMethod
    public void setUp (){
        this.driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1080 , 720));
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class);
        landingPage = new LandingPage(driver);
        searchResultPage = new SearchResultPage(driver);
        landingPage.navigate();
    }

    @Test(description = "verify that when user search with 'Cucumber IO' the second result link is ")
    public void verifySecondSearchResultLink(){
        landingPage.search("Cucumber IO");
        String secondResultLink = wait.until(d->searchResultPage.getSecondResultLink());
        Assert.assertEquals(secondResultLink , "https://www.linkedin.com");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
