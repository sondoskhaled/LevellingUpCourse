package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    WebDriver driver;
    By searchField = By.xpath("//input[@id = 'searchbox_input']");
    public LandingPage (WebDriver driver){
        this.driver=driver;
    }

    public void navigate(){
        driver.navigate().to("https://duckduckgo.com/");
    }

    public void search (String query){
        driver.findElement(searchField).sendKeys(query , Keys.ENTER);
    }



}
