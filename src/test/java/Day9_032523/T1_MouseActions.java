package Day9_032523;

import ReusableLibraries.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class T1_MouseActions {
    public static void main(String[] args) throws InterruptedException {

        //on your test classes you still to declare the web driver command you want to see
        WebDriver driver = ReusableMethods.defineChromeDriver();

        //navigate to usps home page
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(1500);

        Actions mouseAction = new Actions(driver);

        //hover over send tab using mouse actions
        try {
            WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
            mouseAction.moveToElement(sendTab).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover over the send tab: " + e);
        }//end of hover send tab exception

        //click on tracking using mouse action
        try {
            WebElement trackingLick = driver.findElement(By.xpath("//*[text()='Tracking']"));
            mouseAction.moveToElement(trackingLick).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to click on tracking link: " + e);
        }//end of click on tracking link exception

        //type on tracking field using mouse action
        try {
            WebElement trackingField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
            mouseAction.moveToElement(trackingField).click().sendKeys("12345678").perform();
        } catch (Exception e) {
            System.out.println("Unable to send keys to tracking input field: " + e);
        }//end of tracking field using mouse click
        Thread.sleep(1500);

        driver.quit();

    }//end of main
}//end of class
