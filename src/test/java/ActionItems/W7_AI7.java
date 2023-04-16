package ActionItems;

import ReusableLibraries.ReusableAnnotations;
import ReusableLibraries.ReusableMethodsLoggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class W7_AI7 extends ReusableAnnotations {

    @Test(priority = 1)
    public void TC_01_NavigateToUnitedAirlines() {
        logger.log(LogStatus.INFO, "Here even though the elements by default have been selected, " +
                "I'm making sure they are selected in the system");
        //navigate to united airlines home page
        driver.navigate().to("https://www.united.com/en/us");
        //click on the bookings tab
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id='travelTab']", logger, "Book Tab");
        //click on flight tab
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id='bookFlightTab']", logger, "Flight Tab");
        //click on round trip radio button
        ReusableMethodsLoggers.clickMethod(driver, "(//*[@class='app-components-BookFlightForm-bookFlightForm__checkmark--2DHJD'][1])", logger, "RoundTrip Radio");
        //confirm the radio button is selected
        ReusableMethodsLoggers.booleanMethod(driver, "(//*[@type='radio'])[1]", true, logger, "Confirming Radio Button is Selected");
    }//end of TC_01_NavigateToUnitedAirlines

    @Test(priority = 2)
    public void TC_02_ConfirmElementsAreIntractable() {
        logger.log(LogStatus.INFO, "I'm Making sure that the visible elements on the home page are intractable");
        //confirm the starting location element in intractable
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id='bookFlightOriginInput']", logger, "Starting Destination");
        //confirm the desired location element in intractable
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id='bookFlightDestinationInput']", logger, "Desired Location");
        //confirm start date element is intractable
        ReusableMethodsLoggers.clickMethod(driver, "(//*[@class='DateInput DateInput_1'])[1]", logger, "Start Date");
        //confirm end date element is intractable
        ReusableMethodsLoggers.clickMethod(driver, "(//*[@class='DateInput DateInput_1'])[2]", logger, "End Date");
        //confirm passengers element is intractable
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id='passengerSelector']", logger, "Passengers");
        //confirm flight class in intractable
        ReusableMethodsLoggers.clickMethod(driver, "//*[text()='Economy']", logger, "Flight Class");
        //clicking search flights button
        //ReusableMethodsLoggers.clickMethod(driver, "//*[text()='Find flights']", logger, "Search Button");
    }//end of TC_02_ConfirmElementsAreIntractable

    @Test(priority = 3)
    public void TC_03_HotelsTab() {
        logger.log(LogStatus.INFO, "Here I will also confirming that the elements that are visual are intractable");
        //click on hotel tab
        ReusableMethodsLoggers.clickMethod(driver, "//span[text()='Hotel']", logger, "Hotel Tab");
        //where is your destination
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id='bookHotelInput']", logger, "Destination Hotel");
        //check in date
        ReusableMethodsLoggers.clickMethod(driver, "(//*[@class='DateInput DateInput_1'])[1]", logger, "Check In");
        //check out date
        ReusableMethodsLoggers.clickMethod(driver, "(//*[@class='DateInput DateInput_1'])[2]", logger, "Check Out");
        //number of rooms
        ReusableMethodsLoggers.clickMethod(driver, "//*[@name='roomsDropdown']", logger, "Number of Rooms");
        //number of people
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id='slidingInputFieldGroup']", logger, "People");
        //click on find hotels
        //ReusableMethodsLoggers.clickMethod(driver, "//span[text()='Find hotels']", logger, "Find Hotels Button");
    }//end of TC_03_HotelsTab

    @Test(priority = 4)
    public void TC_04_DropDowns() {
        logger.log(LogStatus.INFO, "Here I will be confirming that the dropdowns are workings after clicking the flight search button");
        driver.navigate().to("https://www.united.com/en/us/fsr/choose-flights?f=EWR&t=KHI&d=2023-04-13&r=2023-04-17&sc=7%2C7&px=1&taxng=1&newHP=True&clm=7&st=bestmatches&tqp=R");
        //sort by dropdown
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id='sortBy']", logger, "Sort By DropDown");
        //stop dropdown
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id='stops']", logger, "Flight Stops");
        //fare type
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id='fareType']", logger, "Fare Type");
        //flight duration
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id='selectedDuration']", logger, "Flight Duration");
        //flight connections
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id='selectedConnections']", logger, "Flight Connections");
        //refundable tickets
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id='refundable']", logger, "Refunds");
        //type of aircraft
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id='selectedAircrafts']", logger, "Aircraft");
    }//end of TC_04_DropDowns

    @Test(priority = 5)
    public void TC_05_FlightTickets() {
        logger.log(LogStatus.INFO, "Here I will just click on the first two flights that are there");
        //departure flight
        ReusableMethodsLoggers.clickMethod(driver, "(//*[@class='app-components-Shopping-PriceCard-styles__top--2IU8G'])[1]", logger, "Departure");
        //arrival flight
        ReusableMethodsLoggers.clickMethod(driver, "//*[@class='app-components-Shopping-PriceCard-styles__top--2IU8G']", logger, "Arrival");
    }//end of TC_05_FlightTickets

}//end of class
