package Day6_031223;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T3_Scrolling {
    public static void main(String[] args) throws InterruptedException {

        //set up driver with web driver manager
        WebDriverManager.chromedriver().setup();

        //set up your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();

        //start maximized
        options.addArguments("start-maximized");

        //start incognito
        options.addArguments("incognito");

        //run driver as headless
        options.addArguments("headless");

        //define the chrome driver that you will use for automation test
        //option variable must be passed inside the ChromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calculator
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(1000);

        //scroll to the bottom to click on mortgage rates
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //scroll down using pixels
        jse.executeScript("scroll(0,3000)");
        Thread.sleep(1000);

        //scroll up using pixels
        jse.executeScript("scroll(0,-3000)");
        Thread.sleep(1000);

        //scroll down using pixels
        jse.executeScript("scroll(0,3000)");
        Thread.sleep(1000);

        //click on mortgage rates link
        driver.findElements(By.xpath("//*[text()='Mortgage Rates']")).get(1).click();
        Thread.sleep(1000);

        driver.quit();

    }//end of main
}//end of class
