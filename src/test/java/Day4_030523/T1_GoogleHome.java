package Day4_030523;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_GoogleHome {
    public static void main(String[] args) throws InterruptedException {

        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //define the chrome driver that you will use for testing
        WebDriver driver = new ChromeDriver();

        //maximize driver
        driver.manage().window().maximize();

        //navigate to google home
        driver.navigate().to("https://www.google.com");

        Thread.sleep(2000);

        //locate element for search field and type keyword 'BMW'
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("BMW");

        //click google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //capture the search result using .getText();
        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();

        //we want to replace parenthesis with blank, you can use the following command
        String[] arrayResult = result.split(" ");
        //String newResult = arrayResult[3].replace("(", "");
        //String newResult2 = arrayResult[4].replace(")", " ");
        System.out.println("Search Number: " + arrayResult[1]); //" and the seconds it took: " + newResult + " " + newResult2);

        //waiting for 2 seconds
        //every 1000 millisecond is 1 second
        //whenever you go to a new page or navigate, always use 2-3 seconds wait to pause your script a bit
        Thread.sleep(2000);//right click_show context actions_add exception to method signature

        //quit driver
        driver.quit();

    }//end of main
}//end of class
