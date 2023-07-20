package Smoke;

import PageObjects.SimpleFormDemo;
import Utils.Globals;
import org.testng.annotations.Test;

import java.io.IOException;

//the class should extend Globals, so you can initialize the driver from there
public class SimpleFormDemoElements extends Globals {
    SimpleFormDemo simpleFormDemo;
    @Test(priority = 0)
    public void checkElements(){
        simpleFormDemo = new SimpleFormDemo(driver);
        simpleFormDemo.enterMessageText.isDisplayed();
        simpleFormDemo.getCheckedValueBtn.isDisplayed();
        simpleFormDemo.enterMessageTextbox.isDisplayed();
        simpleFormDemo.singleInputFieldText.isDisplayed();

    }

}
