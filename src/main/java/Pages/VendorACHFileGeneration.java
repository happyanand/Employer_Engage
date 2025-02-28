package Pages;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
public class VendorACHFileGeneration extends Base_Class {

	//////////////////////Locator /////////////////////////
	public static By L_SubmissionDate = By.id("SubmissionDate");
	public static By L_SettlementDate = By.id("SettlementDate");
	public static By L_GenerateButton = By.id("btnGenerateACH");

	////////////////////////////// Method /////////////////////////////////////

	public void EnterSubmissionDate(String Value) throws InterruptedException {
		if(ElementDisplayed(L_SubmissionDate)) {
			Log.info("SubmissionDate is displayed");
			input(L_SubmissionDate,Value);
			Log.info("Successfully Enter the SubmissionDate = "+Value);
			ExtentSuccessMessage("Successfully Enter the SubmissionDate = "+Value);
		} else {
			Log.error("SubmissionDate not displayed");
			ExtentErrorMessage("SubmissionDate not displayed");
		}
	}

	public void EnterSettlementDate(String Value) throws InterruptedException {
		if(ElementDisplayed(L_SettlementDate)) {
			Log.info("SettlementDate is displayed");
			input(L_SettlementDate,Value);
			Thread.sleep(1000);
			Log.info("Successfully Enter the SettlementDate = "+Value);
			ExtentSuccessMessage("Successfully Enter the SettlementDate = "+Value);
		} else {
			Log.error("SettlementDate not displayed");
			ExtentErrorMessage("SettlementDate not displayed");
		}
	}

	public String LastMonthDate() {
		/*
		 * // Create object of SimpleDateFormat class and decide the format DateFormat
		 * dateFormat = new SimpleDateFormat("MM/dd/yyyy "); //get current date time
		 * with Date() Date date = new Date(); // Now format the date String
		 * CurrentDate= dateFormat.format(date); // Print the Current Date
		 * System.out.println("Current Date:- "+CurrentDate); String currentdate[]
		 * =CurrentDate.split("/"); String CurrentMonth =currentdate[0].toString(); int
		 * CurrentMonthCount =Integer.parseInt(CurrentMonth); String currentDay
		 * =currentdate[1].toString(); String currentYears
		 * =currentdate[2].toString().trim(); int LastYears=0; int
		 * LastmonthDay=Integer.parseInt(currentDay); int LastmonthMount=0;
		 * if(CurrentMonthCount==(1)) { LastYears =Integer. parseInt(currentYears)-1;
		 * LastmonthMount=12; }else { LastYears =Integer. parseInt(currentYears);
		 * LastmonthMount=CurrentMonthCount-1; }
		 * System.out.println("Last Month Date:- "+
		 * LastmonthMount+"/"+LastmonthDay+"/"+LastYears);
		 */
		// Get the current date
        LocalDate currentDate = LocalDate.now();

        // Define the output date format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // Convert to a different time zone if needed
        String targetTimeZoneId = "America/New_York";
        ZoneId targetZone = ZoneId.of(targetTimeZoneId);
        currentDate = currentDate.atStartOfDay(targetZone).toLocalDate().minusMonths(1);

        // Format the current date to the desired output format
        String outputDateStr = currentDate.format(outputFormatter);
		return outputDateStr;
	}

	public void clickOnGenerateButton() throws InterruptedException {
		if(ElementDisplayed(L_GenerateButton)) {
			Log.info("Generate Button is displayed");
			click(L_GenerateButton);
			Log.info("Clicked on Generate Button");
			ExtentSuccessMessage("Clicked on Generate Button");
		} else {
			Log.error("Generate Button not displayed");
			ExtentErrorMessage("Generate Button not displayed");
		}
	}


}