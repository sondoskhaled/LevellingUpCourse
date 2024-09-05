package testPackage.modular.fluent;

import com.google.gson.JsonObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import pages.fluent.LandingPage;

import java.util.List;

public class Task11Tests extends AbstractionTests{
    static JsonObject data;
    static List<List<String>> excelData ;
    static NodeList nodeList;
    String query;
    String indexStr;
    String expectedResult;

    @BeforeClass
    public void setUpClass (){
         data = readJsonFromFile("src/test/resources/testData/TestData.json");
         excelData = readExcelData(
                 "src/test/resources/testData/TestData2.xlsx",
                 "TestData2");
         nodeList = readXMLData("src/test/resources/testData/TestData.xml" , "data");

    }

    @Test(description = "verify the first search result link and read index, search query and expected result from excel file")
    public void verifyFirstSearchResultLinkXml(){
        // Loop through each 'user' node
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element userElement = (Element) node;
                // Extract data from the user element
                query= userElement.getElementsByTagName("query").item(0).getTextContent();
                indexStr = userElement.getElementsByTagName("index").item(0).getTextContent();
                expectedResult = userElement.getElementsByTagName("expectedResult").item(0).getTextContent();
            }
        }
        double doubleValue = Double.parseDouble(indexStr);
        int index = (int) doubleValue;
        new LandingPage(driver)
                .navigate()
                .search(query)
                .checkSearchResultLink(index ,expectedResult);
    }
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
