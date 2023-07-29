package Practice;

import ReusableLibraries.ReusableAnnotations;
import ReusableLibraries.ReusableMethodsLoggers;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class mlcalc_DataDriven_Test extends ReusableAnnotations {

    @Test
    public void GetMonthlyPaymentTest() throws BiffException, IOException, WriteException {
        //read the data from the read Excel file
        Workbook readFile = Workbook.getWorkbook(new File("src/main/resources/mlcalc_DataDriven.xls"));
        //create a copy of the read file so i can later write back the result to it
        WritableWorkbook writeFile = Workbook.createWorkbook(new File("src/main/resources/mlcalc_DataDriven_WriteFile.xls"), readFile);
        //we also need to get access to the sheet from the writable file
        WritableSheet writeSheet = writeFile.getSheet(0);
        //get the physical count from the writable sheet
        int rowCount = writeSheet.getRows();

        //now you can create for loop to iterate through the rows in your Excel sheet
        for (int i = 1; i < rowCount; i++){

            //columns are hard coded and rows are dynamic(passing as i)
            //get the value from purchase price column
            String pPrice = writeSheet.getCell(0,i).getContents();
            //get the value from down payment column
            String dPayment = writeSheet.getCell(1,i).getContents();
            //get the value from mortgage term column
            String mTerm = writeSheet.getCell(2,i).getContents();
            //get the value from interest rate column
            String intRate = writeSheet.getCell(3,i).getContents();
            //get the value from start month column
            String strMonth = writeSheet.getCell(4,i).getContents();
            //get the value from start year column
            String stryear = writeSheet.getCell(5,i).getContents();

            //start your test steps
            //navigate to mlcalc
            driver.navigate().to("https://www.mlcalc.com");
            //clear and enter the value for purchase price
            ReusableMethodsLoggers.sendKeysMethod(driver,"//*[@id='ma']",pPrice,logger,"Purchase Price");
            //clear and enter the value for down payment
            ReusableMethodsLoggers.sendKeysMethod(driver,"//*[@id='dp']",dPayment,logger,"Down Payment");
            //clear and enter the value for Mortgage Term
            ReusableMethodsLoggers.sendKeysMethod(driver,"//*[@id='mt']",mTerm,logger,"Mortgage Term");
            //clear and enter the value for Interest Rate
            ReusableMethodsLoggers.sendKeysMethod(driver,"//*[@id='ir']",intRate,logger,"Interest Rate");
            //click on Show advanced options
            ReusableMethodsLoggers.clickMethod(driver,"//*[text()='Show advanced options']",logger,"Show advanced options");
            //select the value for Start Month
            ReusableMethodsLoggers.selectByVisibleText(driver,"//*[@name='sm']",strMonth,logger,"Start Month");
            //select the value for Start year
            ReusableMethodsLoggers.selectByVisibleText(driver,"//*[@name='sy']",stryear,logger,"Start Year");
            //click on calculate
            ReusableMethodsLoggers.clickMethod(driver,"//*[@value='Calculate']",logger,"Calculate");
            //capture the monthly payment
            String mntPayment = ReusableMethodsLoggers.getTextMethod(driver,"(//*[@style='font-size: 32px'])[1]",logger,"Monthly Payment");
            //create a Label to store the result to later add it to the empty column in the writable sheet
            Label label = new Label(6,i,mntPayment);
            writeSheet.addCell(label);

        }//end of loop
        //close the read file
        readFile.close();
        //write back to the writable file
        writeFile.write();
        writeFile.close();

        //open the writable Excel file
        File file = new File("src/main/resources/mlcalc_DataDriven_WriteFile.xls");
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);

    }//end of test
}//end of class
