package Airlines_POM;

import ReusableLibraries.ReusableAnnotations;
import ReusableLibraries.ReusableMethodsLoggersPOM;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnitedAirlines_HomePage extends ReusableAnnotations {

    //must declare a local logger variable to be used for each POM class
    ExtentTest logger;

    //constructor method is a helper method which creates a bridge between
    //your POM class and test class. without the constructor method
    //you can't create a POM class
    public UnitedAirlines_HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.logger = ReusableAnnotations.logger;
    }//end of constructor

    //declare all the web elements you need from the page
    @FindBy(xpath = "//*[text()='BOOK']")
    WebElement bookTabWithDropDown;
    @FindBy(xpath = "//*[text()='MY TRIPS']")
    WebElement myTripsWithDropDown;
    @FindBy(xpath = "//*[text()='TRAVEL INFO']")
    WebElement travelInfoWithDropDown;
    @FindBy(xpath = "(//*[contains(text(),'MILEAGEPLUS')])[1]")
    WebElement mileageplusDropDown;
    @FindBy(xpath = "//*[text()='DEALS']")
    WebElement dealsDropDown;
    @FindBy(xpath = "//*[text()='Help']")
    WebElement helpTab;
    @FindBy(xpath = "//*[@alt='United logo link to homepage']")
    WebElement unitedHomePage;
    @FindBy(xpath = "//*[@id='bookFlightOriginInput']")
    WebElement startDestination;
    @FindBy(xpath = "//*[@id='bookFlightDestinationInput']")
    WebElement arrivalDestination;
    @FindBy(xpath = "//*[text()='Find flights']")
    WebElement findFlights;

    public void verifyingBookTab() {
        ReusableMethodsLoggersPOM.clickMethod(driver, bookTabWithDropDown, logger, "Book Tab, Top Row");
    }

    public void verifyingTravelInfoTab() {
        ReusableMethodsLoggersPOM.clickMethod(driver, myTripsWithDropDown, logger, "My Trips Tab, Top Row");
    }

    public void verifyingMileagePlusTab() {
        ReusableMethodsLoggersPOM.clickMethod(driver, mileageplusDropDown, logger, "My MileagePlus Tab, Top Row");
    }

    public void verifyingDealsTab() {
        ReusableMethodsLoggersPOM.clickMethod(driver, dealsDropDown, logger, "My Deals Tab, Top Row");
    }

    public void verifyingHelpTab() {
        ReusableMethodsLoggersPOM.clickMethod(driver, helpTab, logger, "My Help Tab, Top Row");
    }

    public void verifyingHomePageLink() {
        ReusableMethodsLoggersPOM.clickMethod(driver, unitedHomePage, logger, "Redirected to HomePage");
    }

    public void startingDestination(String UserValue) {
        ReusableMethodsLoggersPOM.sendKeysMethod(driver, startDestination, UserValue, logger, "DDTesting");
    }

    public void arrivalDestination(String UserValue) {
        ReusableMethodsLoggersPOM.sendKeysMethod(driver, arrivalDestination, UserValue, logger, "DDTesting");
    }

    public void submitButton() {
        ReusableMethodsLoggersPOM.submitMethod(driver, findFlights, logger, "Find Flights Button");
    }
}//end of class
