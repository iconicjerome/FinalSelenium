package Utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;


public class Globals {
    public static WebDriver driver;
    //create method to start browser
    @BeforeSuite
    public static WebDriver StartBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        return driver;
    }
    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    //create references for workbook ie create class for the Excel file; remember to pass the
    //location of the Excel file

    //throw IOException to handle exception instead of using try catch, so you can return a value
    public static String getWorkbook(int rowNum, int colNum)throws IOException{
            //in case the location of the file is changed, use the relative path.
            //In the file path, you can use single / instead of double // so the program can run
            //in other OS
            String projectPath = System.getProperty("user.dir");
            XSSFWorkbook workbook = new XSSFWorkbook(projectPath+"/Excel/data.xlsx");
            //create reference for the worksheet; remember to pass the name of your sheet from the workbook
            XSSFSheet sheet = workbook.getSheet("sheet1");
            //create variable to get data from sheet
            String getData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            return getData;

    }
   }
