package Day11_040123;

import ReusableLibraries.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T1_GoogleSearchTestNG {

    //to make variable global, you must declare it outside the annotation methods
    WebDriver driver;

    //create before suite method to define your chrome driver
    @BeforeSuite
    public void setUpDriver() {
        driver = ReusableMethods.defineChromeDriver();
    }//end of before suite

    //@test is a replacement of the main method to execute your code
    @Test
    public void googleSearchNumber() {
        //navigate to google home page
        driver.navigate().to("https://www.google.com");
        //enter bmw on the  search field
        ReusableMethods.sendKeysMethod(driver, "//*[@name='q']", "BMW", "Search Field");
        //submit google search
        ReusableMethods.submitMethod(driver, "//*[@name='btnK']", "Google Search");
        //capture the text and print it out
        String result = ReusableMethods.getTextMethod(driver, "//*[@id='result-stats']", "Search Result");
        String[] arrayResult = result.split(" ");
        System.out.println("Search number for BMW is: " + arrayResult[1]);
    }//end of test 1

    //quit driver
    @AfterSuite
    public void quitDriver() {
        driver.quit();
    }//end of before suite

}//end of class
