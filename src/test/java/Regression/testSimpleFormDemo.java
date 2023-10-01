package Regression;
import PageObjects.SimpleFormDemo;
import Utils.Globals;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
            logger.info("SimpleForm btn clicked successfully");
        }catch (NullPointerException e){
            System.out.println(e);
        }

    }

    @Test(priority = 1)
    public void validateInputFieldText() throws IOException {
        String inputMessage = getWorkbook(1,1);
        simpleFormDemo = new SimpleFormDemo(driver);
        simpleFormDemo.enterMessageTextbox.sendKeys(inputMessage);
        simpleFormDemo.getCheckedValueBtn.click();
        //assert that data from sheet = text displayed.
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inputMessage, simpleFormDemo.displayMessage);
    }
}
