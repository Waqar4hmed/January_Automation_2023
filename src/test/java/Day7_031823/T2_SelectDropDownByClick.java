package Day7_031823;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_SelectDropDownByClick {
    public static void main(String[] args) throws InterruptedException {

        //define web driver by using web driver manager
        WebDriverManager.chromedriver().setup();
        //set up your chrome option arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        //add option argument for maximized, incognito, headless
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //options.addArguments("headless");

        //get rid of the message, 'chrome is being controlled by automated test software
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //define the chrome driver that you will use for automation test
        //option variable must be passed inside the ChromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        //navigate to site
        driver.navigate().to("https://mortgagecalculator.org");
        Thread.sleep(2000);
        //select start month as april from the dropdown using select function
        //store the start month locator as a web element
        driver.findElement(By.xpath("//*[@name='param[start_month]']")).click();
        Thread.sleep(2000);
        //click on the dropdown value by using xpath text
        driver.findElement(By.xpath("//*[text()='Apr']")).click();
        Thread.sleep(2000);
        //click on empty area to close dropdown
        driver.findElement(By.xpath("//*[@class='content-area']")).click();
        Thread.sleep(2000);
        //quit driver
        driver.quit();

    }//end of main
}//end of class
