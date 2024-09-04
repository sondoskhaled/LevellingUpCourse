package pages.fluent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ResultsPage extends AbstractionClass {
    By searchResult ;
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public void checkSearchResultLink (int index , String expectedLink){
        searchResult = By.xpath("(//article)["+index+"]//h2//a");
        wait.until(d->{
            String actualLink = driver.findElement(searchResult).getAttribute("href");
            Assert.assertEquals(actualLink , expectedLink);
            return true;
        });
    }
}
