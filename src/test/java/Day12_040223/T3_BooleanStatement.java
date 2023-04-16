package Day12_040223;

import ReusableLibraries.ReusableAnnotations;
import ReusableLibraries.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class T3_BooleanStatement extends ReusableAnnotations {

    @Test
    public void verifyCheckBoxIsChecked() {
        driver.navigate().to("https://www.yahoo.com");
        ReusableMethods.clickMethod(driver, "//*[@id='ybarAccountProfile']", "button");
        //store the xpath in a boolean statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='persistent']"))).isSelected();
        System.out.println("Value: " + elementState);
        if (elementState == true) {
            System.out.println("Passed: Checkbox is checked by default");
        } else {
            System.out.println("Failed: Checkbox is not checked by default");
        }//end of if condition
    }//end of test 1

    @Test(priority = 2)
    public void verifyCheckBoxIsNotChecked() {
        driver.navigate().to("https://www.yahoo.com");
        ReusableMethods.clickMethod(driver, "//*[@id='ybarAccountProfile']", "button");
        //store the xpath in a boolean statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='persistent']"))).isSelected();
        System.out.println("Value: " + elementState);
        if (elementState == false) {
            System.out.println("Passed: Checkbox is not selected by default");
        } else {
            System.out.println("Failed: Checkbox is selected by default");
        }//end of if condition
    }//end of test 2

    @Test(priority = 3)
    public void verifyCheckBoxISnotChecked() throws InterruptedException {
        //click on check box to uncheck it
        Thread.sleep(2000);
        ReusableMethods.clickMethod(driver,"//*[@class='stay-signed-in checkbox-container']","Checkbox");
        Thread.sleep(2000);
        ReusableMethods.booleanMethod(driver,"//*[@id='persistent']",false,"Checkbox");
    }//end of test 3

}//end of class
