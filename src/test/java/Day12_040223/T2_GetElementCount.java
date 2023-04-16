package Day12_040223;

import ReusableLibraries.ReusableAnnotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class T2_GetElementCount extends ReusableAnnotations {

    @Test
    public void navListCount(){
        driver.navigate().to("https://www.usps.com");
        //store element list in an array list with common property
        WebDriverWait wait= new WebDriverWait(driver, 7);
        ArrayList<WebElement> tablist = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]"))));
        System.out.println("Count: " + tablist.size());
    }//end of test 1

}//end of class
