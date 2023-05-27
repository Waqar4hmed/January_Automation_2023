package Google_POM;

import ReusableLibraries.ReusableAnnotations;
import ReusableLibraries.ReusableMethodsLoggersPOM;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResult extends ReusableAnnotations {

    //must declare a local logger variable to be used for each POM class
    ExtentTest logger;

    //constructor method is a helper method which creates a bridge between
    //your POM class and test class. without the constructor method
    //you can't create a POM class
    public GoogleSearchResult(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.logger = ReusableAnnotations.logger;
    }//end of constructor

    //declare all the web elements here
    @FindBy(xpath = "//*[@id='result-stats']")
    WebElement searchResultsText;

    public void captureSearchResults(String userValue) {
        String result = ReusableMethodsLoggersPOM.getTextMethod(driver, searchResultsText, logger, "Search Results");
        String[] arrayResult = result.split(" ");
        System.out.println("Search result for " + userValue + " is " + arrayResult[1]);
        logger.log(LogStatus.INFO, "Search result for " + userValue + " is " + arrayResult[1]);
    }

}//end of class
