package Utils;

import PageObjects.SimpleFormDemo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;


public class Globals {
    public static WebDriver driver;
    SimpleFormDemo simpleFormDemo;

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
   }
