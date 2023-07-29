package United_POM_Scenarios;

import Airlines_POM.Base_Class;
import ReusableLibraries.ReusableAnnotations;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UnitedAirlines_POM extends ReusableAnnotations {

    @Test(priority = 1)
    public void verifyingLinks() throws InterruptedException {
        driver.navigate().to("https://www.united.com");
        Thread.sleep(5000);
        Base_Class.unitedAirlines_homePage().verifyingBookTab();
        Base_Class.unitedAirlines_homePage().verifyingTravelInfoTab();
        Base_Class.unitedAirlines_homePage().verifyingMileagePlusTab();
        Base_Class.unitedAirlines_homePage().verifyingDealsTab();
        Base_Class.unitedAirlines_homePage().verifyingHelpTab();
        Base_Class.unitedAirlines_homePage().verifyingHomePageLink();
    }//end of test to verify links

    @Test(priority = 2)
    public void dataDrivenTestingFor50States() throws BiffException, IOException, WriteException, InterruptedException {
        //read the data from the read Excel file
        Workbook readFile = Workbook.getWorkbook(new File("src/main/resources/united_DataDriven.xls"));
        //create a copy of the read file, so I can later write back the result to it
        WritableWorkbook writeFile = Workbook.createWorkbook(new File("src/main/resources/united_DataDriven_WriteFile.xls"), readFile);
        //we also need to get access to the sheet from the writable file
        WritableSheet writeSheet = writeFile.getSheet(0);
        //get the physical count from the writable sheet
        int rowCount = writeSheet.getRows();

        //now you can create for loop to iterate through the rows in your Excel sheet
        for (int i = 1; i < rowCount; i++) {

            //columns are hard coded and rows are dynamic(passing as i)
            //get the value from purchase price column
            String starting = writeSheet.getCell(0, i).getContents();
            //get the value from down payment column
            String arrival = writeSheet.getCell(1, i).getContents();

            Base_Class.unitedAirlines_homePage().startingDestination(starting);
            Thread.sleep(1000);
            Base_Class.unitedAirlines_homePage().arrivalDestination(arrival);
            Thread.sleep(1000);

            Base_Class.unitedAirlines_homePage().submitButton();
            driver.navigate().to("https://www.united.com");
            Thread.sleep(1000);
        }//end of loop

        //close the read file
        readFile.close();
        //write back to the writable file
        writeFile.write();
        writeFile.close();

    }//end of test
}//end of class

