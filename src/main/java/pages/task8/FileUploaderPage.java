package pages.task8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class FileUploaderPage {
    WebDriver driver;
    By chooseFileField = By.xpath("//input[@id = 'file-upload']");
    By uploadButton = By.xpath("//input[@id='file-submit']");
    File uploadFile = new File("src/main/resources/photos/Aesthetic Profile Picture Cartoon Soft.jpeg");

    public FileUploaderPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigate (){
        driver.navigate().to("http://the-internet.herokuapp.com/upload");
    }

    public void selectFile (){
        driver.findElement(chooseFileField).sendKeys(uploadFile.getAbsolutePath());
    }

    public void uploadFile(){
        driver.findElement(uploadButton).click();
    }


}
