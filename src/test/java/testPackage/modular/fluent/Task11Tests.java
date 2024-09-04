package testPackage.modular.fluent;

import com.google.gson.JsonObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.fluent.LandingPage;

import java.util.List;

public class Task11Tests extends AbstractionTests{
    static JsonObject data;
    static List<List<String>> excelData ;
    String query;
    String indexStr;
    String expectedResult;

    @BeforeClass
    public void setUpClass (){
         data = readJsonFromFile("src/test/resources/testData/TestData.json");
         excelData = readExcelData(
                 "src/test/resources/testData/TestData2.xlsx",
                 "TestData2");}
    @Test(description = "verify the first search result link and read index, search query and expected result from excel file")
    public void verifyFirstSearchResultLinkExcel(){
        query = excelData.get(1).get(0);
        indexStr = excelData.get(1).get(1);
        expectedResult = excelData.get(1).get(2);
        double doubleValue = Double.parseDouble(indexStr);
        int index = (int) doubleValue;
        new LandingPage(driver)
                .navigate()
                .search(query)
                .checkSearchResultLink(index
                        ,expectedResult);
    }

    @Test(description = "verify the first search result link and read index, search query and expected result from json file")
    public void verifyFirstSearchResultLinkJson(){
        new LandingPage(driver)
                .navigate()
                .search(data.get("query").getAsString())
                .checkSearchResultLink(data.get("index").getAsInt(),data.get("expectedResult").getAsString());
    }
}
