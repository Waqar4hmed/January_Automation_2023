package Google_POM_Scenarios;

import Google_POM.Base_Class;
import ReusableLibraries.ReusableAnnotations;
import org.testng.annotations.Test;

public class GoogleSearch_POM extends ReusableAnnotations {

    @Test
    public void captureResultForBMW() {
        driver.navigate().to("https://www.google.com");
        Base_Class.googleHome().enterKeywordOnSearchField("BMW");
        Base_Class.googleHome().submitONGoogleSearchButton();
        Base_Class.googleSearchResult().captureSearchResults("BMW");
        Base_Class.googleSearchResult().getCountOfTheLinks();
        Base_Class.googleSearchResult().clickOnNewsLink();
    }//end of test captureResultForBMW

}//end of class
