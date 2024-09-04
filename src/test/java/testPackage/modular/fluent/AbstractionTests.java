package testPackage.modular.fluent;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileReader;
import java.io.IOException;

public class AbstractionTests {
    WebDriver driver;
    @BeforeClass
    public void setUp ()
    {
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1080 , 720));
    }

    @AfterClass
    public void tearDown (){
        driver.quit();
    }

    public static JsonObject readJsonFromFile(String filePath) {
        Gson gson = new Gson();
        JsonObject jsonObject = null;

        try (FileReader reader = new FileReader(filePath)) {
            jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

}
