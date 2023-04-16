package Day6_031223;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_FindElements {
    public static void main(String[] args) throws InterruptedException {

        //set up driver with web driver manager
        WebDriverManager.chromedriver().setup();

        //set up your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();

        //get rid of the message, 'chrome is being controlled by automated test software
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        //start maximized
        options.addArguments("start-maximized");

        //start incognito
        options.addArguments("incognito");

        //run driver as headless
        //options.addArguments("headless");

        //define the chrome driver that you will use for automation test
        //option variable must be passed inside the ChromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calculator
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2000);

        //clear auto populated data from purchase price
        driver.findElement(By.xpath("//*[@name='ma']")).clear();

        //enter new purchase price
        driver.findElement(By.xpath("//*[@name='ma']")).sendKeys("250000");

        //click on calculate
        driver.findElement(By.xpath("//*[@value='Calculate']")).click();
        Thread.sleep(2000);

        //capture the monthly payment using findElements with index of 0
        String result = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(0).getText();
        System.out.println("Monthly Payment: " + result);

        //capture the total 360 payment using findElements with index of 1
        String result2 = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(1).getText();
        System.out.println("Total 360 Payment: " + result2);

        driver.quit();

    }//end of main
}//end of class
