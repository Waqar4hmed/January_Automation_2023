package Day13_040823;

import ReusableLibraries.ReusableMethodsLoggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T1_GoogleSearch_Loggers {

    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void defineDriver() {
        driver = ReusableMethodsLoggers.defineChromeDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/AutomationReportGoogle.html", true);
    }//end of before suite

    @Test(priority = 1)
    public void SearchForCricket() {
        //define logger by giving a name to the test
        logger = reports.startTest("Search for Cricket");
        //navigate to google home page
        driver.navigate().to("https://www.google.com");
        //type the word cricket on the search field
        logger.log(LogStatus.INFO, "Send values to the Search Field");
        ReusableMethodsLoggers.sendKeysMethod(driver, "//*[@name='q']", "Cricket", logger, "Search Field");
        //hit the submit button
        logger.log(LogStatus.INFO, "Hit the submit button");
        ReusableMethodsLoggers.submitMethod(driver, "//*[@name='btnK']", logger, "Google Search Button");
        //end the logger for test 1
        reports.endTest(logger);
        reports.flush();
    }//end of test 1

    @Test(priority = 2)
    public void printOutSearchNumber() {
        logger = reports.startTest("Print Search Number for Cricket");
        String result = ReusableMethodsLoggers.getTextMethod(driver, "//*[@id='result-stats']", logger, "Capturing Text");
        System.out.println(result);
        logger.log(LogStatus.INFO, result);
        String[] arrayResult = result.split(" ");
        System.out.println("Search Number for Cricket " + arrayResult[1]);
        logger.log(LogStatus.INFO, "Search Number for Cricket " + arrayResult[1]);
        reports.endTest(logger);
    }//end of test 2

    @AfterSuite
    public void writeBackToReport() {
        reports.flush();
        driver.quit();
    }//end of after suite

}//end of class
