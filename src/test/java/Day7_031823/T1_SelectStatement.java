package Day7_031823;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_SelectStatement {
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
        WebElement strMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //call select function to store the dropdown locator
        Select startMonthDropDown = new Select(strMonth);
        //select by visible text
        //startMonthDropDown.selectByVisibleText("Apr");
        //Thread.sleep(2000);
        //select by value
        //startMonthDropDown.selectByValue("4");
        //Thread.sleep(2000);
        //select by index
        startMonthDropDown.selectByIndex(3);
        Thread.sleep(2000);
        //quit driver
        driver.quit();
    }//end of main
}//end of class
