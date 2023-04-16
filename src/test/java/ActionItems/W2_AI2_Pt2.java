package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class W2_AI2_Pt2 {

    public static void main(String[] args) throws InterruptedException {
        //set up you web driver manager
        WebDriverManager.chromedriver().setup();

        //define your driver to chrome driver
        WebDriver driver = new ChromeDriver();

        ArrayList<String> sports = new ArrayList<>();
        sports.add("Basketball");
        sports.add("Football");
        sports.add("Handball");
        sports.add("Racquetball");

        int i = 0;
        while (i < sports.size()) {

            //maximize window
            driver.manage().window().maximize();

            //navigate to Bing website
            driver.navigate().to("https://www.bing.com");

            //wait a second
            Thread.sleep(1000);

            //type in keyword in the search bar
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sports.get(i));

            //click on submit
            driver.findElement(By.xpath("//*[@id='search_icon']")).submit();

            //wait a second
            Thread.sleep(1000);

            //capture search result
            String result = driver.findElement(By.xpath("//*[@id='b_tween']")).getText();

            //split search result and only print the number
            String[] searchResult = result.split(" ");
            System.out.println("Some of my favorite sports are " + sports.get(i) + " and their results are " + searchResult[1]);

            /*
            if (searchResult[0] == "About") {
                System.out.println("Some of my favorite spots are " + sports.get(i) + " and their search results are " + searchResult[1]);
            } else {
                System.out.println("Some of my favorite spots are " + sports.get(i) + " and their search results are " + searchResult[0]);
            }//end of conditional statement
            */

            i++;

        }//end of while loop
        driver.quit();

    }//end of main

}//end of class
