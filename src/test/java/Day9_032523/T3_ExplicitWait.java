package Day9_032523;

import ReusableLibraries.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T3_ExplicitWait {
    public static void main(String[] args) throws InterruptedException {

        //on your test classes you still to declare the web driver command you want to see
        WebDriver driver = ReusableMethods.defineChromeDriver();

        //navigate to usps home page
        driver.navigate().to("https://www.ups.com/us");

        //declare the explicit command
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //your explicit wait condition replaces your driver.findElement()
        //.presenceOfElementLocated = .visibilityOfElementLocated
        //click on shipping tab
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Shipping']"))).click();
        } catch (Exception e) {
            System.out.println("Unable to hover over the shipping tab: " + e);
        }//end of clicking on shipping tab exception

        //click on schedule a pickup
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Schedule a Pickup']"))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on schedule a pickup link: " + e);
        }//end of click on schedule a pickup exception

        //enter a tracking number on the box
        try {
            WebElement trackingField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='tracknumlist']")));
            trackingField.sendKeys("1234455555");
        } catch (Exception e) {
            System.out.println("Unable to send keys to tracking input field: " + e);
        }//end of entering a tracking number in the field exception

        driver.quit();

    }//end of main
}//end of class
