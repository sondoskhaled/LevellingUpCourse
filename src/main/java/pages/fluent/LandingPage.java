package pages.fluent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LandingPage extends AbstractionClass{
    private final By searchField = By.xpath("//input[@id = 'searchbox_input']");
    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public pages.fluent.LandingPage navigate (){
        driver.navigate().to("https://duckduckgo.com/");
        return this;
    }

    public pages.fluent.ResultsPage search (String query){
        driver.findElement(searchField).sendKeys(query , Keys.ENTER);
        return new ResultsPage(driver);
    }
}
