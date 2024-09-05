package testPackage.modular.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;

public class Task2Tests {
    LandingPage landingPage;
    WebDriver driver;
    @BeforeMethod
    public void setUp (){
        this.driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1080 , 720));
        landingPage = new LandingPage(driver);
        landingPage.navigate();
    }

    @Test(description = "verify that the logo is displayed")
    public void verifyLogoIsDisplayed(){
            landingPage.logoIsDisplayed();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
