package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
    WebDriver driver ;
    By firstResultLink = By.xpath("(//article)[1]//h2//a");
    By forthResultText = By.xpath("(//article)[4]//h2");

    public SearchResultPage (WebDriver driver){
        this.driver = driver ;
    }
    public String getFirstResultLink(){
        return driver.findElement(firstResultLink).getAttribute("href");
    }
    public String getForthResultText(){
        return driver.findElement(forthResultText).getText();
    }
}
