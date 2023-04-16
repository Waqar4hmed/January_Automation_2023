package Day7_031823;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T3_HandlingTabs {
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
        driver.navigate().to("https://fideliscare.org");
        Thread.sleep(1500);

        //click on shop for a plan
        driver.findElement(By.xpath("//*[text()='Shop For a Plan']")).click();
        Thread.sleep(1500);
        //click on medicaid managed care
        driver.findElement(By.xpath("//*[text()='Medicaid Managed Care']")).click();
        Thread.sleep(1500);
        //click on search button for find a doctor
        driver.findElement(By.xpath("//*[@href='/Find-A-Doctor']")).click();
        Thread.sleep(1500);
        //make an arraylist for tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1500);
        //enter zipcode in the location field
        WebElement searchField = driver.findElement(By.xpath("//*[@id='searchLocation']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys("11218");
        searchField.submit();
        Thread.sleep(1500);
        //close tab
        driver.close();
        //switch to the first tab, it'll be an index of 0
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(1500);
        //quit driver
        driver.quit();

    }//end of main
}//end of class
