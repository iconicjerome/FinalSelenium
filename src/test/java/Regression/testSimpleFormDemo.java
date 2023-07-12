package Regression;


import PageObjects.SimpleFormDemo;
import Utils.Globals;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testSimpleFormDemo {
    //initialize webdriver
    WebDriver driver;
    //initialize pageobject page
    SimpleFormDemo simpleFormDemo;

    //use beforeTest annotation to launch browser before each testcase is run
    @BeforeTest
    public void launchBrowser(){
        driver = Globals.StartBrowser("https://www.lambdatest.com/selenium-playground/");
        simpleFormDemo = new SimpleFormDemo(driver);

    }
    @Test
    public void clickSimpleForm(){
        try{
            simpleFormDemo.clickElement();
        }catch (NullPointerException e){
            System.out.println(e);
        }

    }
    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
