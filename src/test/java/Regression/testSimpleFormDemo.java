package Regression;
import PageObjects.SimpleFormDemo;
import Utils.Globals;
import org.testng.annotations.Test;

import java.io.IOException;

//the class should extend Globals, so you can initialize the driver from there
public class testSimpleFormDemo extends Globals{
    //initialize page object page
    SimpleFormDemo simpleFormDemo;
    @Test(priority = 0)
    public void clickSimpleForm(){
        try{
            simpleFormDemo = new SimpleFormDemo(driver);
            simpleFormDemo.clickElement();
        }catch (NullPointerException e){
            System.out.println(e);
        }

    }

    @Test(priority = 1)
    public void populateSheet() throws IOException {
        simpleFormDemo = new SimpleFormDemo(driver);
        simpleFormDemo.enterMessageTextbox.sendKeys(getWorkbook(1,1));
    }
}
