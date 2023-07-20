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
    @FindBy(xpath = "//*[@id=\"__next\"]/div/section[2]/div/div/div/div[1]/div[1]")
    public WebElement singleInputFieldText;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/section[2]/div/div/div/div[1]/div[2]/div/div[1]/p")
    public WebElement enterMessageText;
    @FindBy(xpath="//*[@id=\"user-message\"]")
    public WebElement enterMessageTextbox;
    @FindBy(xpath = "//*[@id=\"showInput\"]")
    public WebElement getCheckedValueBtn;
    @FindBy(xpath = "//*[@id=\"message\"]")
    public WebElement displayMessage;
    //method to interact with elements
    public void clickElement(){

        simpleFormDemo.click();
    }
}
