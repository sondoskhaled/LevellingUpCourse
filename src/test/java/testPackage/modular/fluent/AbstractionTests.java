package testPackage.modular.fluent;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class AbstractionTests {
    WebDriver driver;
    @BeforeClass
    public void setUp ()
    {
        // Load the properties file
        Properties properties = new Properties();
        try (FileInputStream fileInput = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Get the TargetBrowser from the properties file
        String targetBrowser = properties.getProperty("TargetBrowser");

        // Set up WebDriver based on the TargetBrowser value
        if (targetBrowser.equalsIgnoreCase("Chrome")) {
            this.driver = new ChromeDriver();
        } else if (targetBrowser.equalsIgnoreCase("Firefox")) {
            this.driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + targetBrowser);
        }
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1080 , 720));
    }

    @AfterClass
    public void tearDown (){
        driver.quit();
    }

    // Method to read the text file and process each line
    public static String readTextFile(String filePath) {
        String line = null;
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static NodeList readXMLData(String filePath , String nodeTagName) {
        NodeList nodeList = null;
        try {
            // Create a DocumentBuilderFactory and DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file into a Document object
            Document document = builder.parse(new File(filePath));
            document.getDocumentElement().normalize(); // Normalize the XML structure

            // Get all 'user' nodes
            nodeList = document.getElementsByTagName(nodeTagName);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return nodeList;
    }

    public static List<List<String>> readExcelData(String filePath, String sheetName) {
        List<List<String>> excelData = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            for (Row row : sheet) {
                List<String> rowData = new ArrayList<>();
                for (Cell cell : row) {
                    rowData.add(cell.toString());}
                excelData.add(rowData);}
        } catch (IOException e) {
            e.printStackTrace();}
        return excelData;
    }

    public static JsonObject readJsonFromFile(String filePath) {
        JsonObject jsonObject = null;

        try (FileReader reader = new FileReader(filePath)) {
            jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

}
