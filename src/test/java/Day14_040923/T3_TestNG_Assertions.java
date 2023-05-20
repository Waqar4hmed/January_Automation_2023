package Day14_040923;

import ReusableLibraries.ReusableAnnotations;
import ReusableLibraries.ReusableMethods;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class T3_TestNG_Assertions extends ReusableAnnotations {
    @Test
    public void TestNG_Assertions() {
        driver.navigate().to("https://www.google.com");

        //hard assert
        String actualTitle = driver.getTitle();
        //Assert.assertEquals(actualTitle,"google");

        //soft assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle,"google");

        //enter a keyword on the search field
        ReusableMethods.sendKeysMethod(driver,"//*[@name='q']","Cars","Search Field");

        //in order to see the failure from soft assert you must put .assertAll at the end of your test
        softAssert.assertAll();
    }//end of test
}//end of class
