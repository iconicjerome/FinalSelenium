package Regression;
import PageObjects.SimpleFormDemo;
import Utils.Globals;
import org.testng.annotations.Test;

//the class should extend Globals so you can initialize the driver from there
public class testSimpleFormDemo extends Globals{
    //initialize pageobject page
    SimpleFormDemo simpleFormDemo;
    @Test
    public void clickSimpleForm(){
        try{
            simpleFormDemo = new SimpleFormDemo(driver);
            simpleFormDemo.clickElement();
        }catch (NullPointerException e){
            System.out.println(e);
        }

    }
}
