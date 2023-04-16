package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class W3_AI3 {
    public static void main(String[] args) throws InterruptedException {

        //set up driver with chrome driver manager
        WebDriverManager.chromedriver().setup();

        //set up your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();

        //add options arguments for maximize windows, incognito,
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //options.addArguments("headless");

        //get rid of the message, 'chrome is being controlled by automated test software
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        //define the chrome driver that you will use for automation test
        //option variable must be passed inside the ChromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        //create string array list for zipCode
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11704");
        zipCode.add("11367");
        zipCode.add("11368");

        //create for loop
        for (int i = 0; i < zipCode.size(); i++) {

            //navigate to weight watchers find a workshop page
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            Thread.sleep(2000);

            //click on in person button
            driver.findElement(By.xpath("//span[text()='In-Person']")).click();

            //click on search field, clear it and automate zipCode array list
            WebElement searchField = driver.findElement(By.xpath("//*[@id='location-search']"));
            searchField.clear();
            searchField.sendKeys(zipCode.get(i));
            Thread.sleep(2000);

            //click on search button
            driver.findElement(By.xpath("//*[contains(@class,'rightArrow')]")).submit();
            Thread.sleep(2000);

            //create array list for web elements because there are multiple elements with the same variable and value
            ArrayList<WebElement> location = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'linkUnderline')]")));

            //create conditional statements
            if (i == 0) {
                location.get(1).click();
            }
            if (i == 1) {
                location.get(2).click();
            }
            if (i == 2) {
                location.get(0).click();
            }//end of conditional statements
            Thread.sleep(2000);

            //capture address
            String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
            System.out.println(address);

            //using javascript commands scroll workshop schedule into view
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            //scroll down
            //jse.executeScript("scroll(0,800)");
            //WebElement scroll = driver.findElement(By.xpath("//*[text()='Upcoming In-Person Workshops schedule']"));
            WebElement scroll = driver.findElement(By.xpath("//*[@class='title-bEfSM']"));
            jse.executeScript("arguments[0].scrollIntoView(true)", scroll);
            Thread.sleep(3000);

            //capture table of days and hours
            String schedule = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
            //print out schedule
            System.out.println(schedule);

        }//end of for loop

        //quit browser
        driver.quit();

    }//end of main
}//end of class
