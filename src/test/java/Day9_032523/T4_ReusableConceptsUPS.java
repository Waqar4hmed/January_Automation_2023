package Day9_032523;

import ReusableLibraries.ReusableMethods;
import org.openqa.selenium.WebDriver;

public class T4_ReusableConceptsUPS {
    public static void main(String[] args) throws InterruptedException {

        //on your test classes you still to declare the web driver command you want to see
        WebDriver driver = ReusableMethods.defineChromeDriver();

        //navigate to usps home page
        driver.navigate().to("https://www.ups.com/us");

        //click on shipping tab
        ReusableMethods.clickMethod(driver, "//*[text()='Shipping']", "Shipping Tab");
        Thread.sleep(1500);

        //click on schedule a pickup
        ReusableMethods.clickMethod(driver, "//*[text()='Schedule a Pickup']", "Schedule a Pickup Tab");

        //click on freight tab
        ReusableMethods.clickMethod(driver, "//*[text()='Freight']", "Freight");

        driver.quit();

    }//end of main
}//end of class
