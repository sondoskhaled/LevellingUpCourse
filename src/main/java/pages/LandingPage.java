package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LandingPage {
    private final WebDriver driver;
    Wait<WebDriver> wait;
    private final By searchField = By.xpath("//input[@id = 'searchbox_input']");
    private final By logo = By.xpath("(//a/img)[1]");
    public LandingPage (WebDriver driver){
        this.driver=driver;
        this.wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(60))
                        .pollingEvery(Duration.ofMillis(100))
                        .ignoring(NotFoundException.class)
                        .ignoring(StaleElementReferenceException.class)
                        .ignoring(AssertionError.class);    }

    public void navigate(){
        driver.navigate().to("https://duckduckgo.com/");
    }

    public void logoIsDisplayed(){
        wait.until(d-> {
        Assert.assertTrue(driver.findElement(logo).isDisplayed());
        return true;});
    }

    public void search (String query){
        driver.findElement(searchField).sendKeys(query , Keys.ENTER);
    }



}
