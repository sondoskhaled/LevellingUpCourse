package pages.task6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxesPages {
    WebDriver driver;
    By checkbox1 = By.xpath("//input[1]");
    By checkbox2 = By.xpath("//input[2]");
    public CheckboxesPages (WebDriver driver){
        this.driver = driver;
    }

    public void navigate(){
        driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
    }

    public void clickOnCheckbox1 (){
        driver.findElement(checkbox1).click();
    }

    public boolean checkSelectionOfCheckbox1(){
        return driver.findElement(checkbox1).isSelected();
    }

    public boolean checkSelectionOfCheckbox2(){
        return driver.findElement(checkbox2).isSelected();
    }
}
