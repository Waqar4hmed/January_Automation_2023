package Day5_031123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T3_ChromeOptions {
    public static void main(String[] args) throws InterruptedException {

        //set up your driver with web driver manager
        WebDriverManager.chromedriver().setup();

        //set up your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();

        //start driver maximized, incognito, headless
        //options.addArguments("start-maximized","incognito","headless");

        //another way of write code line 18
        options.addArguments("start-maximized");
        //add --kiosk for option arguments for mac
        //options.addArguments("--kiosk");
        options.addArguments("incognito");
        //add options to run your driver in the background
        options.addArguments("headless");

        //get rid of the message, 'chrome is being controlled by automated test software
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        //define the chrome driver that you will use for automation test
        //option variable must be passed inside the ChromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo home page
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);

        //click of mail link
        driver.findElement(By.xpath("//*[text()='Sign in']")).click();
        Thread.sleep(2000);

        String result = driver.findElement(By.xpath("//*[contains(text(),'Sign')]")).getText();
        System.out.println("Results: " + result);

        //quit driver
        driver.quit();

    }//end of main
}//end of class
