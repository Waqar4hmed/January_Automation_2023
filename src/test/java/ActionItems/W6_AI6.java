package ActionItems;

import ReusableLibraries.ReusableAnnotations;
import ReusableLibraries.ReusableMethods;
import org.testng.annotations.Test;

public class W6_AI6 extends ReusableAnnotations {

    @Test
    public void TC1() throws InterruptedException {
        driver.manage().deleteAllCookies();
        //navigate to fidelis care
        driver.navigate().to("https://www.fideliscare.org");
        Thread.sleep(1500);
        //click on search element
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='fal fa-search']", 0, "Click on Search Element");
        //type characters into the search field
        ReusableMethods.sendKeysMethod(driver, "//*[@class='form-control search-input']", "get dental coverage", "Enter Characters into Search Field");
        //enter and search
        ReusableMethods.clickMethod(driver, "//*[@class='btn btn-primary btn-search']", "Click on Search Button");
        //capture search results
        String result = ReusableMethods.getTextMethod(driver, "//*[@class='gsc-result-info']", "Capture Search Results");
        //split search results and print only the number
        String[] searchResult = result.split(" ");
        System.out.println(searchResult[1]);
        Thread.sleep(1500);
        //link on the first link
        ReusableMethods.clickMethod(driver, "//a[@class='gs-title']", "Dental Coverage");
        Thread.sleep(1500);
    }//end of TC1

    @Test(dependsOnMethods = "TC1")
    public void TC2() throws InterruptedException {
        //using reusable methods, declare an array list for the amount of tabs there are and call it
        ReusableMethods.switchTabsByIndexMethod(driver, 1, "Second Tab");
        Thread.sleep(1500);
        //enter your first name
        ReusableMethods.sendKeysMethod(driver, "//*[@id='firstName']", "Thomas", "First Name");
        //enter your last name
        ReusableMethods.sendKeysMethod(driver, "//*[@id='lastName']", "Shelby", "Last Name");
        //enter your zip code
        ReusableMethods.sendKeysMethod(driver, "//*[@id='zipCode']", "11367", "Zip Code");
        //enter country
        ReusableMethods.selectByVisibleText(driver, "//*[@id='county']", "New York", "Country");
        //enter fake phone number
        ReusableMethods.sendKeysMethod(driver, "//*[@id='phoneNumber']", "1234567890", "Phone Number");
        //enter fake email
        ReusableMethods.sendKeysMethod(driver, "//*[@id='email']", "thomasshelby123@gmail.com", "Email");
        //click on checkbox
        ReusableMethods.clickMethod(driver, "//*[@for='contactMe']", "Checkbox");
        Thread.sleep(1500);
        //click on contact me button
        ReusableMethods.clickMethodByIndex(driver, "//*[text()='Contact Me']", 2,"Contact me Button");
        //capture text, split it and print it
        String result = ReusableMethods.getTextMethod(driver, "//*[@class='alert alert-success']", "Capturing Text");
        String[] captureResult = result.split("A");
        System.out.println(captureResult[0]);
        //close tab
        driver.close();
    }//end of TC2

    @Test(dependsOnMethods = {"TC1", "TC2"})
    public void TC3() throws InterruptedException {
        //using reusable methods, declare an array list for the amount of tabs there are and call it
        ReusableMethods.switchTabsByIndexMethod(driver, 0, "First Tab");
        //click on login button
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='tool dropdown login']", 0,"Login Button");
        Thread.sleep(1500);
        //click on the first link
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='link-external']", 0, "Member Online Portal");
        //using reusable methods, declare an array list for the amount of tabs there are and call it
        ReusableMethods.switchTabsByIndexMethod(driver, 1, "Second Tab pt 2");
        Thread.sleep(1500);
        //capture text and print it
        String result= ReusableMethods.getTextMethod(driver, "//*[text()='Helpful Hints']", "Capturing Text");
        System.out.println(result);
        //close tab
        driver.close();
    }//end of TC3

}//end of class
