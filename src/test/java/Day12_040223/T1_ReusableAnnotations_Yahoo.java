package Day12_040223;

import ReusableLibraries.ReusableAnnotations;
import ReusableLibraries.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class T1_ReusableAnnotations_Yahoo extends ReusableAnnotations {

    @Test
    public void navigate() {
        ArrayList<String> phones = new ArrayList<>();
        phones.add("iphone");
        phones.add("samsung");
        for (int i = 0; i < phones.size(); i++) {
            driver.navigate().to("https://www.yahoo.com");
            //enter iphone into the search field
            ReusableMethods.sendKeysMethod(driver, "//*[@name='p']", phones.get(i), "Search Field");
            //click on search icon
            ReusableMethods.clickMethod(driver, "//*[@id='ybar-search']", "Search Icon");
            String result = ReusableMethods.getTextMethod(driver, "//span[@class=' fz-14 lh-22']", "Search Result");
            String[] arrayResult = result.split(" ");
            System.out.println("Search number: " + arrayResult[1]);
        }//end of for loop
    }//end of test 1

    @Test(priority = 2)
    public void aboutPage() {
        //scroll to the bottom
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,4000)");
        ReusableMethods.clickMethod(driver, "//*[text()='About this page']", "About This page Link");
        String result = ReusableMethods.getTextMethod(driver, "//h1[contains(text(),'Filter and refine ')]", "Results");
        System.out.println("Result: " + result);
    }//end of test 2

}//end of class
