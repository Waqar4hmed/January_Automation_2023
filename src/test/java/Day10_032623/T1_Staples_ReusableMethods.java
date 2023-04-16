package Day10_032623;

import ReusableLibraries.ReusableMethods;
import org.openqa.selenium.WebDriver;

public class T1_Staples_ReusableMethods {
    public static void main(String[] args) throws InterruptedException {

        //set up chrome driver
        WebDriver driver = ReusableMethods.defineChromeDriver();
        //navigate to staples home page
        driver.navigate().to("https://www.staples.com");
        //type on search field by using the sendKeys method
        ReusableMethods.sendKeysMethod(driver, "//*[@id='searchInput']", "iphone", "Search Field");
        //click on the search icon
        ReusableMethods.clickMethod(driver, "//*[@class='search-bar-input__searchIcon']", "Search Icon");
        //click on the first image by index
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='standard-tile__image standard-tile__image_hover']", 0, "iphone image");
        //add item to cart using the click method
        ReusableMethods.clickMethod(driver, "//*[@id='cta_button']", "Add to Cart");
        Thread.sleep(3000);
        //capture the starting price and print it out
        String result = ReusableMethods.getTextMethod(driver, "//*[contains(text(),'starting at')]", "Starting Price");
        System.out.println("My price is " + result);

        driver.quit();

    }//end of main
}//end of class
