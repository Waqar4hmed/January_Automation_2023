package ReusableLibraries;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class ReusableMethodsLoggers {

    //set a static timeout variable, so it can cover all explicit methods
    static int timeout = 15;

    //create a return method to return your web driver you are going to use on your test classes
    //static command allows your method to be global
    public static WebDriver defineChromeDriver() {
        WebDriverManager.chromedriver().setup();

        //set up your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");
        //options.addArguments("incognito");
        //options.addArguments("headless");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        //set up option variable inside chrome driver for it to recognize your conditions
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }//end of web driver method
    //return method will execute your statement along with returning conditions/value
    //example of return methods are only WebDriver method and getText action

    //void method will only perform the action but won't return anything
    //the void actions are click, sendKeys, submit, clear, scroll, mouse hover

    //click method
    public static void clickMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            System.out.println("Successfully clicked on element " + elementName);
            logger.log(LogStatus.PASS, "Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable click on element " + elementName + ": " + e);
            getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of click method


    //click method by index
    public static void clickMethodByIndex(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            System.out.println("Successfully clicked by index on element " + elementName);
            logger.log(LogStatus.PASS, "Successfully clicked by index on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click by index on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to click ny index on element " + elementName + ": " + e);
            getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of click method by index


    //submit method
    public static void submitMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            System.out.println("Successfully clicked enter on element " + elementName);
            logger.log(LogStatus.PASS, "Successfully clicked enter on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click enter on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to click enter on element " + elementName + ": " + e);
            getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of submit method


    //sendKeys method
    public static void sendKeysMethod(WebDriver driver, String xpath, String userValue, ExtentTest logger, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully cleared and send value on element " + elementName);
            logger.log(LogStatus.PASS, "Successfully cleared and send value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to clear send value on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to clear and send value on element " + elementName + ": " + e);
            getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of sendKeys method


    //sendKeys by index method
    public static void sendKeysMethodByIndex(WebDriver driver, String xpath, String userValue, int index, ExtentTest logger, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully clear and send value on element " + elementName);
            logger.log(LogStatus.PASS, "Successfully cleared and send value by index on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to clear and send value on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to clear and send value by index on element " + elementName + ": " + e);
            getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of sendKeys method by index


    //getText method
    public static String getTextMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            System.out.println("Successfully captured text from element " + elementName);
            logger.log(LogStatus.PASS, "Successfully captured text from element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text from element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to capture text from element " + elementName + ": " + e);
            getScreenShot(driver, elementName, logger);
        }//end of exception

        return result;
    }//end of getText method


    //mouse hover method
    public static void hoverMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions hover = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            hover.moveToElement(element).perform();
            System.out.println("Successfully hovered over element " + elementName);
            logger.log(LogStatus.PASS, "Successfully hovered over element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover over element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to hover over element " + elementName + ": " + e);
            getScreenShot(driver, elementName, logger);
        }//end of exception e
    }//end of hover method


    //mouse hover method by index
    public static void hoverMethodByIndex(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions hover = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            hover.moveToElement(element).perform();
            System.out.println("Successfully hovered over element " + elementName);
            logger.log(LogStatus.PASS, "Successfully hovered over by index element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover over element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to hover over by index element " + elementName + ": " + e);
            getScreenShot(driver, elementName, logger);
        }//end of exception e
    }//end of hover method by index


    //select by visible text method
    public static void selectByVisibleText(WebDriver driver, String xpath, String userValue, ExtentTest logger, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userValue);
            System.out.println("Successfully selected the drop down by visible text " + elementName);
            logger.log(LogStatus.PASS, "Successfully selected the drop down by visible text " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select the drop down by visible text " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Successfully selected the drop down by visible text " + elementName + ": " + e);
            getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of select by visible text method


    //select by value method
    public static void selectByValue(WebDriver driver, String xpath, String userValue, ExtentTest logger, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByValue(userValue);
            System.out.println("Successfully selected the drop down by value " + elementName);
            logger.log(LogStatus.PASS, "Successfully selected the drop down by value " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select the drop down by value " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to select the drop down by value " + elementName + ": " + e);
            getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of select by visible text method


    public static void selectByIndex(WebDriver driver, String xpath, int userValue, ExtentTest logger, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByIndex(userValue);
            System.out.println("Successfully selected the drop down by index " + elementName);
            logger.log(LogStatus.PASS, "Successfully selected the drop down by index " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select the drop down by index " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to select the drop down by index " + elementName + ": " + e);
            getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of select by visible text method


    //scroll into view method
    public static void scrollIntoView(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
            System.out.println("Successfully scrolled into view " + elementName);
            logger.log(LogStatus.PASS, "Successfully scrolled into view " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll into view " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to scroll into view " + elementName + ": " + e);
            getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of scroll into view method


    //scroll by pixel 1 method
    public static void scrollByPixel(WebDriver driver, String scroll, ExtentTest logger, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            jse.executeScript(scroll);
            System.out.println("Successfully scrolled by pixel " + scroll);
            logger.log(LogStatus.PASS, "Successfully scrolled by pixel " + scroll);
        } catch (Exception e) {
            System.out.println("Unable to scroll by pixel " + scroll + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to scroll by pixel " + scroll + ": " + e);
            getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of scroll by pixel 1 method


    /*
    //scroll by pixel 1 method
    public static void scrollByPixel1(WebDriver driver, int x, int y) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            jse.executeScript("scroll(" + x + "," + y + ")");
            System.out.println("Successfully scrolled by pixel " + x + "," + y);
        } catch (Exception e) {
            System.out.println("Unable to scroll by pixel " + x + "," + y + ": " + e);
        }//end of exception
    }//end of scroll by pixel 1 method


    //scroll by pixel 2 method
    public static void scrollByPixel2(WebDriver driver, String x, String y) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            jse.executeScript("scroll(" + x + "," + y + ")");
            System.out.println("Successfully scrolled by pixel " + x + "," + y);
        } catch (Exception e) {
            System.out.println("Unable to scroll by pixel " + x + "," + y + ": " + e);
        }//end of exception
    }//end of scroll by pixel 2 method
    */


    //boolean method
    public static void booleanMethod(WebDriver driver, String xpath, boolean expected, ExtentTest logger, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            //store the xpath in a boolean statement
            boolean element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isSelected();
            System.out.println("Value: " + element);
            logger.log(LogStatus.INFO, "Value: " + element);
            if (element == expected) {
                System.out.println("Passed: Checkbox is " + expected);
                logger.log(LogStatus.INFO, "Passed: Checkbox is " + expected);
            } else {
                System.out.println("Failed: Checkbox is " + element);
                logger.log(LogStatus.INFO, "Failed: Checkbox is " + expected);
            }//end of conditional statement
        } catch (Exception e) {
            System.out.println("Unable to verify checkbox " + elementName + ": " + e);
            logger.log(LogStatus.INFO, "Unable to verify checkbox " + elementName + ": " + e);
        }//end of exception
    }//end of boolean method


    //switch to tabs
    public static void switchTabsByIndexMethod(WebDriver driver, int index, String elementName) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }//end of switch tabs by index method


    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occurred while taking SCREENSHOT!!! " + e);
        }//end of exception
    }//end of get screenshot method
//hi


}//end of class
