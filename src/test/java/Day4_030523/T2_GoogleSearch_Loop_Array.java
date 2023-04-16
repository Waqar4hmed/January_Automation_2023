package Day4_030523;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class T2_GoogleSearch_Loop_Array {

    public static void main(String[] args) throws InterruptedException {

        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //define your chrome driver that you will use for testing
        WebDriver driver = new ChromeDriver();

        //set an array list of cars
        ArrayList<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Audi");
        cars.add("Mercedes");
        cars.add("Porsche");

        //iterate through the list of cars and print out the search number for each car
        for (int i = 0; i < cars.size(); i++) {

            //maximize driver
            driver.manage().window().maximize();

            //navigate to google home
            driver.navigate().to("https://www.google.com");

            //Thread.sleep(2000);

            //locate element for search field and type keyword 'BMW'
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cars.get(i));

            //click google search button
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();

            //capture the search result using .getText();
            String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();

            //we want to replace parenthesis with blank, you can use the following command
            String[] arrayResult = result.split(" ");
            System.out.println("For " + cars.get(i) + " the search Number: " + arrayResult[1]);

            //waiting for 2 seconds
            //every 1000 millisecond is 1 second
            //whenever you go to a new page or navigate, always use 2-3 seconds wait to pause your script a bit
            //Thread.sleep(2000);//right click_show context actions_add exception to method signature
        }//end of for loop

        //quit driver outside the for loop
        driver.quit();

    }//end of main

}//end of class
