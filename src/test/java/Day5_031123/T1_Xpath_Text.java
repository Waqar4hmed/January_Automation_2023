package Day5_031123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Xpath_Text {
    public static void main(String[] args) throws InterruptedException {

        //set up driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //define chrome driver that you will use for automation test
        WebDriver driver = new ChromeDriver();

        //maximize window
        driver.manage().window().maximize();

        //navigate to google home page
        driver.navigate().to("https://www.google.com");

        //wait for 2 seconds
        Thread.sleep(2000);

        //click on about link using xpath text()
        driver.findElement(By.xpath("//*[text()='About']")).click();

        //wait for 2 seconds
        Thread.sleep(2000);

        //quit driver
        driver.quit();

    }//end of main
}//end of class
