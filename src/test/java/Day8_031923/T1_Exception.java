package Day8_031923;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_Exception {
    public static void main(String[] args) throws InterruptedException {

        //set up web driver by using web driver manager
        WebDriverManager.chromedriver().setup();
        //set up chrome options
        ChromeOptions options = new ChromeOptions();
        //add option arguments
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.addArguments("headless");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //set up option variable inside chrome driver for it to recognize your conditions
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calculator
        driver. navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(1500);

        //clear and enter home value
        try{
            WebElement homeValue = driver.findElement(By.xpath("//*[@name='param[homevalue]']"));
            homeValue.clear();
            homeValue.sendKeys("450000");
            System.out.println("Successfully cleared and entered the home value");
        }catch (Exception e){
            System.out.println("Unable to interact with the element " + e);
        }//end of clear and enter home value exception

        //clear and enter interest rates
        try{
            WebElement interest = driver.findElement(By.xpath("//*[@name='param[interest_rate]']"));
            interest.clear();
            interest.sendKeys("2.5");
            System.out.println("Successfully cleared and entered interest value");
        }catch (Exception e){
            System.out.println("Unable to interact with the element " + e);
        }//end of exception for interest rates

        //select start month
        try{
            WebElement strMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
            Select dropDown = new Select(strMonth);
            dropDown.selectByVisibleText("Apr");
            System.out.println("Successfully selected month from the dropdown");
        }catch (Exception e) {
            System.out.println("Unable to select a value Start Month drop down " + e);
        }//end of exception for start month

        //quit driver
        driver.quit();

    }//end of main
}//end of class
