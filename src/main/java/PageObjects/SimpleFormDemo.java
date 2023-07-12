package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormDemo {
    //initialize webdriver
    public WebDriver driver;
    //initialize object with constructor

    public SimpleFormDemo(WebDriver driver){
        this.driver = driver;
        //use the line below to remove the nullpointer exception;
        //I don't know why, but it works lol
        PageFactory.initElements(driver, this);
    }

    //rollout pageobjects i.e the page elements
    @FindBy(xpath = "//*[@id=\"__next\"]/div/section[2]/div/ul/li[1]/a")
    public WebElement simpleFormDemo;

    //method to interact with elements
    public void clickElement(){
        simpleFormDemo.click();
    }
}
