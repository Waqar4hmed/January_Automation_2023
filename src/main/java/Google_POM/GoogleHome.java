package Google_POM;

import ReusableLibraries.ReusableAnnotations;
import ReusableLibraries.ReusableMethodsLoggersPOM;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHome extends ReusableAnnotations {

    //must declare a local logger variable to be used for each POM class
    ExtentTest logger;

    //constructor method is a helper method which creates a bridge between
    //your POM class and test class. without the constructor method
    //you can't create a POM class
    public GoogleHome(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.logger = ReusableAnnotations.logger;
    }//end of constructor

    //declare all the web elements you need from the page
    @FindBy(xpath = "//*[@name='q']")
    WebElement searchField;
    @FindBy(xpath = "//*[@name='btnK']")
    WebElement searchButton;

    //create your user defined method for each web element
    public void enterKeywordOnSearchField(String userValue){
        ReusableMethodsLoggersPOM.sendKeysMethod(driver, searchField, userValue, logger, "Search Flied");
    }

    public void submitONGoogleSearchButton(){
        ReusableMethodsLoggersPOM.submitMethod(driver, searchButton, logger, "Search Button");
    }

}//end of class
