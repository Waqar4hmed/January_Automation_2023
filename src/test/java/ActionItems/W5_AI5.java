package ActionItems;

import ReusableLibraries.ReusableMethods;
import org.openqa.selenium.WebDriver;

public class W5_AI5 {
    public static void main(String[] args) throws InterruptedException {

        //set up chrome driver
        WebDriver driver = ReusableMethods.defineChromeDriver();
        //navigate to best buy home page
        driver.navigate().to("https://www.bestbuy.com");
        //click on search bar
        ReusableMethods.clickMethod(driver, "//*[@class='search-bar input-field']", "Search Bar");
        //enter value in the search bar
        ReusableMethods.sendKeysMethod(driver, "//*[@class='search-input']", "iPhone", "Value Name");
        //click on the search icon
        ReusableMethods.clickMethod(driver, "//*[@class='header-search-button']", "Search Button");
        //select the dropdown
        ReusableMethods.selectByVisibleText(driver, "//*[@class='tb-select']", "Best Selling", "Drop Down");
        Thread.sleep(1500);
        //click on the first image using click method by index
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='product-image ']", 0, "First Image");
        //using the scroll into view method
        ReusableMethods.scrollIntoView(driver, "//*[@class='deals-image-wrapper']", "Scroll");
        ReusableMethods.scrollIntoView(driver, "//*[text()='Learn About Totaltech']", "Scroll");
        //click on add to cart
        ReusableMethods.clickMethod(driver, "//*[text()='Add to Cart']", "Add to Cart");
        //capture text using the get text method
        String result = ReusableMethods.getTextMethod(driver, "//*[@class='shop-cart-subtotal']", "Total Amount");
        String[] amount = result.split(":");
        System.out.println("The price for this item is " + amount[1]);
        //hover over to continue shopping using the mouse hover method
        ReusableMethods.hoverMethod(driver, "//*[text()='Continue shopping']", "Continue Shopping Hover");
        //click on continue shopping by using the click method
        ReusableMethods.clickMethod(driver,"//*[text()='Continue shopping']", "Click on Continue Shopping");

        driver.quit();

    }//end of main
}//end of class
