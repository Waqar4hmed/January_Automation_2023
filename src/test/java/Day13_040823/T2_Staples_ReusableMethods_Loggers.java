package Day13_040823;

import ReusableLibraries.ReusableAnnotations;
import ReusableLibraries.ReusableMethods;
import ReusableLibraries.ReusableMethodsLoggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class T2_Staples_ReusableMethods_Loggers extends ReusableAnnotations {

    @Test
    public void searchStaplesForKeyword() throws InterruptedException {
        //navigate to staples home page
        driver.navigate().to("https://www.staples.com");
        //type on search field by using the sendKeys method
        ReusableMethodsLoggers.sendKeysMethod(driver, "//*[@id='searchInput']", "iphone", logger, "Search Field");
        //click on the search icon
        ReusableMethodsLoggers.clickMethod(driver, "//*[@class='search-bar-input__searchIcon']", logger, "Search Icon");
        //click on the first image by index
        ReusableMethodsLoggers.clickMethodByIndex(driver, "//*[@class='standard-tile__image standard-tile__image_hover']", 0, logger, "iphone image");
        //add item to cart using the click method
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id='cta_button']", logger, "Add to Cart");
        Thread.sleep(3000);
        //capture the starting price and print it out
        String result = ReusableMethodsLoggers.getTextMethod(driver, "//*[contains(text(),'starting at')]", logger, "Starting Price");
        System.out.println("My price is " + result);
        logger.log(LogStatus.INFO, result);
    }//end of test 1

}//end of class
