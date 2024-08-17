package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class TestBase {
    @Test
    public void goToGoogle()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.quit();
    }
    @Test
    public void verifyGoogleLogo()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        boolean isLogoVisible = driver.findElement(By.className("lnXdpd")).isDisplayed();
        assertTrue(isLogoVisible);
        driver.quit();

    }
}
