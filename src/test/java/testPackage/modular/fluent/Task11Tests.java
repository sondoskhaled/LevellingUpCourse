package testPackage.modular.fluent;

import com.google.gson.JsonObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.fluent.LandingPage;

public class Task11Tests extends AbstractionTests{
    JsonObject data;
    @BeforeClass
    public void setUpClass (){
         data = readJsonFromFile("src/test/resources/testData/TestData.json");
    }
    @Test
    public void verifyFirstSearchResultLink (){
        new LandingPage(driver)
                .navigate()
                .search(data.get("query").getAsString())
                .checkSearchResultLink(data.get("index").getAsInt(),data.get("expectedResult").getAsString());
    }
}
