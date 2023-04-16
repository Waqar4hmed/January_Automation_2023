package Day5_031123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_Xpath_Contains {
    public static void main(String[] args) throws InterruptedException {

        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //define your chrome driver that you will use to automate
        WebDriver driver = new ChromeDriver();

        //maximize window
        driver.manage().window().maximize();

        //navigate to yahoo home page
        driver.navigate().to("https://www.yahoo.com");

        //wait for 2 seconds
        Thread.sleep(1000);

        //using xpath contains, click on the mail link by ignoring the white space on the text property for that element
        driver.findElement(By.xpath("//a[contains(text(),'Mail')]")).click();

        //wait for 2 seconds
        Thread.sleep(1000);

        //quit browser
        driver.quit();

    }//end of main
}//end of class
