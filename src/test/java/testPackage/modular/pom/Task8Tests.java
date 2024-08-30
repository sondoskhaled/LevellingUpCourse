package testPackage.modular.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.task8.FileUploadedPage;
import pages.task8.FileUploaderPage;

import java.time.Duration;

public class Task8Tests {
    WebDriver driver;
    Wait<WebDriver> wait;
    FileUploaderPage fileUploaderPage;
    FileUploadedPage fileUploadedPage;

    @BeforeMethod
    public void setUp (){
        driver= new ChromeDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1080 , 720));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class);

        fileUploadedPage = new FileUploadedPage(driver);
        fileUploaderPage = new FileUploaderPage(driver);

    }

    @Test
    public void verifyFileUploadedSuccessfully (){
        fileUploaderPage.navigate();
        wait.until(d-> {
            fileUploaderPage.selectFile();
            return true;
        });
        wait.until(d-> {
            fileUploaderPage.uploadFile();
            return true;
        });

        String fileName = wait.until(d-> fileUploadedPage.getFileName());
        Assert.assertEquals(fileName , "Aesthetic Profile Picture Cartoon Soft.jpeg");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
