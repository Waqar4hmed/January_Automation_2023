package Practice;

import ReusableLibraries.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class UCTest_1_2_3 {

    WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        driver = ReusableMethods.defineChromeDriver();
    }


    //test 1
    @Test
    public void adidas() throws InterruptedException {
        driver.navigate().to("https://www.adidas.com/us");
        Thread.sleep(1500);
        //ReusableMethods.clickMethod(driver, "//*[@class='_input_1f3oz_13']", "Search Bar");
        ReusableMethods.sendKeysMethod(driver, "//*[@class='_input_1f3oz_13']", "Running Shoes", "Entering Search Field");
        ReusableMethods.clickMethod(driver, "//*[@class='_imageWrapper_6y6vb_26']", "Shoe");
        Thread.sleep(4000);
        ReusableMethods.clickMethodByIndex(driver, "//*[@data-testid='close']", 0, "Close Pop Up");
        //ReusableMethods.clickMethodByIndex(driver, "//*[@class='variation___u2aRL']", 8, "Shoe Color");
        ReusableMethods.clickMethod(driver, "//*[@alt='Product color: Core Black / Cloud White / Core Black']", "Shoe Color");
        ReusableMethods.clickMethod(driver, "//*[text()='10']", "Shoe Size");
        ReusableMethods.clickMethod(driver, "//*[text()='Add To Bag']", "Add to Bag");
        Thread.sleep(1000);
        String bagError = ReusableMethods.getTextMethod(driver, "//*[@class='gl-callout__wrapper']", "Error Message");
        System.out.println("Item couldn't be added to check bag because " + bagError);
    }//end of test 1


    //test 2
    @Test(priority = 2)
    public void amazon() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(1500);
        ReusableMethods.clickMethod(driver, "//*[@id='twotabsearchtextbox']", "Click Search Bar");
        ReusableMethods.sendKeysMethod(driver, "//*[@id='twotabsearchtextbox']", "iPhone Case", "Search Bar");
        //ReusableMethods.clickMethod(driver, "//*[@id='nav-search-submit-button']", "Click Enter");
        ReusableMethods.submitMethod(driver, "//*[@id='twotabsearchtextbox']", "Click Search Bar");
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='a-section aok-relative s-image-fixed-height']", 0, "First Image");
        ReusableMethods.clickMethod(driver, "//*[@id='add-to-cart-button']", "Add to Cart");
        ReusableMethods.clickMethod(driver, "//*[@class='a-button a-button-span11 a-button-base a-button-small']", "Go to Cart");
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='a-button-text a-declarative']", 0, "Select Drop Down");
        ReusableMethods.clickMethod(driver, "//*[@aria-labelledby='quantity_4']", "Choosing Quantity");
        ReusableMethods.clickMethod(driver, "//*[@name='proceedToRetailCheckout']", "Proceed to CheckOut");
    }//end of test 2


    //test 3
    @Test(priority = 3)
    public void facebook() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com/login/");
        Thread.sleep(1500);
        ReusableMethods.clickMethodByIndex(driver, "//a[@role='button']", 1, "Create New Account Button");
        ReusableMethods.sendKeysMethod(driver, "//*[@name='firstname']", "Thomas", "FirstName");
        ReusableMethods.sendKeysMethod(driver, "//*[@name='lastname']", "Shelby", "LastName");
        ReusableMethods.sendKeysMethod(driver, "//*[@name='reg_email__']", "ThomasShelby@gmail.com", "Email");
        ReusableMethods.sendKeysMethod(driver, "//*[@name='reg_passwd__']", "Northwich", "Password");
        ReusableMethods.selectByVisibleText(driver, "//*[@id='month']", "Jan", "Month");
        ReusableMethods.selectByVisibleText(driver, "//*[@id='day']", "19", "Day");
        ReusableMethods.selectByVisibleText(driver, "//*[@id='year']", "1919", "Year");
        ReusableMethods.clickMethod(driver, "//*[text()='Male']", "Gender");
        Thread.sleep(1500);
    }//end of test 3


    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

}//end of class
