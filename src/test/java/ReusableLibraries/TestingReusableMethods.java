package ReusableLibraries;

import ReusableLibraries.ReusableAnnotations;
import ReusableLibraries.ReusableMethods;
import org.testng.annotations.Test;

public class TestingReusableMethods extends ReusableAnnotations {

    @Test
    public void mortgage() throws InterruptedException {
        driver.navigate().to("https://www.mortgagecalculator.org");
        ReusableMethods.booleanMethod(driver, "//*[@value='money']",true, "radio");
        ReusableMethods.scrollByPixel(driver, "0, 4000");
        Thread.sleep(2000);

    }
}
