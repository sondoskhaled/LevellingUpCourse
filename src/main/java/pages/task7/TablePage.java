package pages.task7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class TablePage {
    WebDriver driver;
    //By country = By.xpath("//table[@id='customers']//tr[contains(.,'Ernst Handel')]//td[3]");
    //td[text()='Ernst Handel']/following-sibling::td[2]

    By countryName = RelativeLocator
            .with(By.tagName("td"))
            .below(By.xpath("//th[text()='Country']"))
            .toRightOf(By.xpath("//td[text()='Ernst Handel']"));

    public TablePage (WebDriver driver){
        this.driver = driver;
    }

    public void navigate(){
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
    }

    public String getCountryValue(){
        return driver.findElement(countryName).getText();
    }
}
