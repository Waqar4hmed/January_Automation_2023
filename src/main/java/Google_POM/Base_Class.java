package Google_POM;

import ReusableLibraries.ReusableAnnotations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base_Class extends ReusableAnnotations {

    //constructor method is a helper method which creates a bridge between
    //your POM class and test class. without the constructor method
    //you can't create a POM class
    public Base_Class(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }//end of constructor

    //for each page object class we must create a static reference to make each class static for the test class

    //create static reference for Google home page
    public static GoogleHome googleHome() {
        GoogleHome googleHome = new GoogleHome(driver);
        return googleHome;
    }//end of static reference for GoogleHome class

    public static GoogleSearchResult googleSearchResult() {
        GoogleSearchResult googleSearchResult = new GoogleSearchResult(driver);
        return googleSearchResult;
    }//end of static reference for GoogleSearchResult class

}//end of class
