package pages.task8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadedPage {
    WebDriver driver;
    By fileName = By.xpath("//div[@id='uploaded-files']");

    public FileUploadedPage (WebDriver driver){
        this.driver = driver;
    }

    public String getFileName(){
        return driver.findElement(fileName).getText();
    }
}
