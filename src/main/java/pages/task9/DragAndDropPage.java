package pages.task9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
    WebDriver driver;
    Actions action;
    By source = By.xpath("//div[@id='draggable']");
    By destination = By.xpath("//div[@id='droppable']");


    public DragAndDropPage (WebDriver driver){
        this.driver = driver;
        this.action = new Actions(driver);
    }

    public void navigate (){
        driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
    }

    public String dragDropObj(){
        action.dragAndDrop(driver.findElement(source),driver.findElement(destination))
                .build().perform();
        return driver.findElement(destination).getText();
    }

}
