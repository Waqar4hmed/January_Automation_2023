package Day6_031223;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_WebElement {
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
        Thread.sleep(2000);

        //clear auto populated data from purchase price
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
        pPrice.clear();
        pPrice.sendKeys("250000");

        //if you want to use findElements as a web element variable, you need to store it as an array list
        ArrayList<WebElement> paymentList = new ArrayList<>(driver.findElements(By.xpath("//*[@style='font-size: 32px']")));

        System.out.println("Monthly Payment: " + paymentList.get(0).getText());
        System.out.println("Total 360 Payment: " + paymentList.get(1).getText());

        //another way of writing this
        /*
        String mntPayment = paymentList.get(0).getText();
        System.out.println("Monthly payment: " + mntPayment);
        String 360Payment = paymentList.get(1).getText();
        System.out.println("Total 360 Payment: " 360Payment);
        */

        driver.quit();

    }//end of main
}//end of class
