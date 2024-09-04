package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
    private final WebDriver driver ;
    private final By firstResultLink = By.xpath("(//article)[1]//h2//a");
    private final By forthResultText = By.xpath("(//article)[4]//h2");
    private final By secondResultLink = By.xpath("(//article)[2]//h2//a");
    public SearchResultPage (WebDriver driver){
        this.driver = driver ;
    }
    public String getFirstResultLink(){
        return driver.findElement(firstResultLink).getAttribute("href");
    }
    public String getForthResultText(){
        return driver.findElement(forthResultText).getText();
    }
    public String getSecondResultLink(){
        return driver.findElement(secondResultLink).getAttribute("href");
    }
}
