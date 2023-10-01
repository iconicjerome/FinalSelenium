package Utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.io.IOException;


public class Globals {
    //add Logs
    public static final Logger logger = LoggerFactory.getLogger(Globals.class);
    public static WebDriver driver;
    //create method to start browser
     @BeforeSuite
    public WebDriver StartBrowser(){
         try{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //log if browser started successfully
         logger.info("Browser started successfully");
        driver.get("https://www.lambdatest.com/selenium-playground/");
         logger.info("Navigated to the URL");
        return driver;
    }catch (Exception e){
             logger.error("Error starting the browser", e);
             throw e;
         }
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
            XSSFWorkbook workbook = new XSSFWorkbook(projectPath+"/Resource/data.xlsx");
            //create reference for the worksheet; remember to pass the name of your sheet from the workbook
            XSSFSheet sheet = workbook.getSheet("sheet1");
            //create variable to get data from sheet
            String getData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            return getData;

    }
   }
