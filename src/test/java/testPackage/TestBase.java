package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;

public class TestBase {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        this.driver = new ChromeDriver();
    }
    @Test
    public void goToGoogle()
    {
        driver.get("https://www.google.com/");
    }
    @Test
    public void verifyTabTitle()
    {
        driver.get("https://www.google.com/");
        String tabTitle = driver.getTitle();
        Assert.assertEquals(tabTitle,"Google");
    }
    @Test
    public void verifyGoogleLogo()
    {
        driver.get("https://www.google.com/");
        boolean isLogoVisible = driver.findElement(By.className("lnXdpd")).isDisplayed();
        assertTrue(isLogoVisible);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
