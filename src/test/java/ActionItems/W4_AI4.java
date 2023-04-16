package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class W4_AI4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        //set up chrome options
        ChromeOptions options = new ChromeOptions();
        //add option arguments
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //options.addArguments("headless");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //set up option variable inside chrome driver for it to recognize your conditions
        WebDriver driver = new ChromeDriver(options);

        //set up an array list for states
        ArrayList<String> state = new ArrayList<>();
        state.add("Las Vegas");
        state.add("California");
        state.add("Chicago");

        //make a for loop for states
        for (int i = 0; i < state.size(); i++) {
            //navigate to hotels.com
            driver.navigate().to("https://www.hotels.com");
            Thread.sleep(1500);

            //exception for clicking on search field
            try {
                WebElement location = driver.findElement(By.xpath("//*[@aria-label='Going to']"));
                location.click();
                System.out.println("Successfully clicked on the search field");
            } catch (Exception e) {
                System.out.println("Unable to click on the search field " + e);
            }//end of clicking on search field
            Thread.sleep(1000);

            //exception for pop up search field
            try {
                WebElement searchField = driver.findElement(By.xpath("//*[@id='destination_form_field']"));
                searchField.sendKeys(state.get(i));
                System.out.println("Successfully input the array list of states in the pop up search field");
            } catch (Exception e) {
                System.out.println("Unable to click on search field pop up " + e);
            }//end of pop up search field
            Thread.sleep(1500);

            //click on the suggestion
            try {
                WebElement suggestion = driver.findElement(By.xpath("//*[@class='uitk-action-list-item-content']"));
                suggestion.click();
                System.out.println("Successfully clicked on the suggestion after inputting data of states");
            } catch (Exception e) {
                System.out.println("Unable to click on suggested location " + e);
            }//end of suggestion
            Thread.sleep(1500);

            //click on travelers
            try {
                WebElement people = driver.findElement(By.xpath("//*[@data-stid='open-room-picker']"));
                people.click();
            } catch (Exception e) {
                System.out.println("Unable to click on number of travelers " + e);
            }//end of exception for clicking on travelers
            Thread.sleep(1500);

            //make an array list for travelers
            ArrayList<Integer> adults = new ArrayList<>();
            adults.add(1);
            adults.add(2);
            adults.add(3);

            //for loop to reset adult travelers back to 1
            try {
                WebElement button = driver.findElement(By.xpath("//*[@class='uitk-step-input-button']"));
                button.click();

                for (int j = 0; j < adults.get(i); j++) {
                    driver.findElements(By.xpath("//*[@class='uitk-step-input-button']")).get(1).click();
                }//end of for loop
            } catch (Exception e) {
                System.out.println("Unable to interact with adult traveler button " + e);
            }//end of exception to reset adult travelers back to 1
            Thread.sleep(1500);

            //click on the done button when you choose the number of travelers
            try {
                WebElement done = driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']"));
                done.click();
            } catch (Exception e) {
                System.out.println("Unable to press the done button after choosing the number of travelers " + e);
            }//clicked on done
            Thread.sleep(1500);

            //click on the done button to search the input data
            try {
                WebElement search = driver.findElement(By.xpath("//*[@id='search_button']"));
                search.click();
            } catch (Exception e) {
                System.out.println("Unable to click on search button" + e);
            }//end of exception for search button
            Thread.sleep(1500);

            //create a try,catch block and make an array list for find elements because all the hotels have the same locator
            try {
                ArrayList<WebElement> hotels = new ArrayList<>(driver.findElements(By.xpath("//*[@data-stid='open-hotel-information']")));
                if (i == 0) {
                    hotels.get(0).click();
                }
                if (i == 1) {
                    hotels.get(2).click();
                }
                if (i == 2) {
                    hotels.get(1).click();
                }
            } catch (Exception e) {
                System.out.println("Unable to click on the hotels " + e);
            }//end of exception for hotels
            Thread.sleep(2000);

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(2000);

            //capture the name of the hotel
            try {
                String name = driver.findElement(By.xpath("//*[@data-stid='content-hotel-title']")).getText();
                System.out.println(name);
            } catch (Exception e) {
                System.out.println("Unable to print hotel's name " + e);
            }//end of exception for capturing hotel name
            Thread.sleep(4000);

            //scroll into view
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //jse.executeScript("scroll(0,800)");
            WebElement scroll = driver.findElement(By.xpath("//*[text()='Choose your room']"));
            jse.executeScript("arguments[0].scrollIntoView(true)", scroll);


            //capture the price of the first hotel room
            try {
                String price = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();
                System.out.println(price);
                System.out.println("Successfully captured the price of the hotel room per night");
            } catch (Exception e) {
                System.out.println("Unable to capture the price of the hotel room " + e);
            }//end of exception for capturing room price
            Thread.sleep(6000);

            //click on the button reserve
            try {
                driver.findElements(By.xpath("//*[text()='Reserve']")).get(0).click();
                System.out.println("Successfully clicked on the reserve button for the first room available");
            } catch (Exception e) {
                System.out.println("Unable to click on the reserve button " + e);
            }//end of exception for reserve button
            Thread.sleep(4000);

            //click on pay now
            try {
                driver.findElements(By.xpath("//*[text()='Pay now']")).get(1).click();
            } catch (Exception e) {
                System.out.println("This element is dynamic and doesn't pop up sometimes, move on to the next feature " + e);
            }//end of exception for pay now button
            Thread.sleep(4000);

            //capture check-in and check-out dates
            try {
                String time = driver.findElement(By.xpath("//*[@class='booking-details-travel-details-wrapper fs-base clear bg-white mb-none--xs bd-all bdra-big mt-mouse']")).getText();
                System.out.println(time);
                System.out.println("Successfully captured the check-in and check-out dates");
            }catch (Exception e){
                System.out.println("Unable to capture dates " + e);
            }//end of exception for check-in and check-out dates
            Thread.sleep(3000);

            //close tab
            driver.close();

            //switch to the 1st tab
            driver.switchTo().window(tabs.get(0));

        }//end of for loop

        //quit driver
        driver.quit();

    }//end of main
}//end of class
