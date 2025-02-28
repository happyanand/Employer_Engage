package Pages;


import java.sql.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class AccountsReceivable_Page  extends Base_Class {
	
	public static By clickAdvacnedSearchDropdown = By.xpath("//*[@id=\"accountReceivableContainer\"]/div/div[2]/div/div/div[4]/ul/li/div/button");
	public static By transactionType = By.xpath("//*[@id=\"paymentTransactionTypeIds_chzn\"]");
	public static By searchButton = By.xpath("//input[@type='button' and @value='Search' and contains(@class, 'btn-primary') and @onclick=\"GetPaymentBatchListAdvanceFilter()\"]");
	public static By SSNSearch = By.xpath("//input[@class='ssn tb1' and @id='SSN']");
	public static By AccountReceivableDetailsearchButton = By.xpath("//button[@id='div_Submit']");

	
	//Click on the Advanced Search Dropdown
	public void ClickOnAdvancedSearchDropdown() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(clickAdvacnedSearchDropdown)) {
				Log.info("Successfully Advacned Search Dropdown is visible");
				click(clickAdvacnedSearchDropdown);
				Log.info("Successfully Clicked On Advanced Search Dropdown");
				ExtentSuccessMessage("Successfully Clicked On Advanced Search Dropdown");
			}else {
				Log.error("UnSuccessfully not clicked On Advanced Search Dropdown");
				ExtentErrorMessage("UnSuccessfully not clicked On Advanced Search Dropdown");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Select Void Transaction Type from the Dropdown
	public void selectTransactionFromDropdown(String value) throws InterruptedException{
		try {	
			WaitForLoadAnimationDisappear();
			if(ElementDisplayed(transactionType)) {
				Log.info("Successfully Transaction Type Dropdown is visible");
				selectDropdownByVisibleText(transactionType, value);
				click(searchButton);
				Log.info("Successfully selected the Void type from Transaction Type Dropdown and clicked on Search button");
				ExtentSuccessMessage("Successfully selected the Void type from Transaction Type Dropdown and clicked on Search button");
			}else {
				Log.error("UnSuccessfully not selected the type ");
				ExtentErrorMessage("UnSuccessfully not selected the type ");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Click on the latest Void Payment Record
	public void ClickLatestRecord() {
		
		// Find all rows in the table
        WebElement table = driver.findElement(By.className("Result-grid"));
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        // Initialize variables to store the latest date and the corresponding row index
        String latestDate = "";
        String latestReceivableId = "";
        int latestRowIndex = -1;

        // Iterate through each row to find the latest date and Receivable ID
        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);

            // Extract the Payment Imported Date and Receivable ID from the current row
            String paymentImportedDate = row.findElement(By.xpath(".//td[3]")).getText();
            String receivableId = row.findElement(By.xpath(".//td[2]/a")).getText();

            // Compare date strings and Receivable IDs to find the latest one
            if (latestDate.isEmpty() || paymentImportedDate.compareTo(latestDate) > 0 || (paymentImportedDate.equals(latestDate) && receivableId.compareTo(latestReceivableId) > 0)) {
                latestDate = paymentImportedDate;
                latestReceivableId = receivableId;
                latestRowIndex = i;
            }
        }

        // Click on the link in the Receivable ID column for the latest row
        if (latestRowIndex != -1) {
            WebElement receivableIdLink = rows.get(latestRowIndex).findElement(By.xpath(".//td[2]/a"));
            receivableIdLink.click();
        }
	}
	
	//Search with the SSN.
	public void enterSSN(String ssn) throws InterruptedException {
		try {
			WaitForPageLoad();
			waitForElementClickable(SSNSearch);
			click(SSNSearch);
			input(SSNSearch,ssn);
			click(AccountReceivableDetailsearchButton);
			Log.info("Successfully Entered SSN "+ssn);
			ExtentSuccessMessage("Successfully Entered SSN "+ssn);
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Amount Button" + e.getMessage());
		}
	}
	
	//Validation for the Void payment Record
	public void voidValidation(String FullName, String SSN) {

	    // Specify the Participant Name and SSN to validate (replace with your actual values)
	    String expectedParticipantName = FullName;
	    String expectedSSN = SSN;

	    // Locate the table row containing the data
	    String xpathForRow = "//table//tbody//tr[.//td[5][contains(text(), '" + expectedParticipantName + "')]]";
	    WebElement tableRow = driver.findElement(By.xpath(xpathForRow));

	    // Extract values from the table row
	    String actualParticipantName = tableRow.findElement(By.xpath(".//td[5]")).getText();
	    String actualSSN = tableRow.findElement(By.xpath(".//td[3]")).getText();

	    // Log expected and actual values
	    Log.info("Expected Participant Name: " + expectedParticipantName);
	    Log.info("Actual Participant Name: " + actualParticipantName);
	    Log.info("Expected SSN: " + expectedSSN);
	    Log.info("Actual SSN: " + actualSSN);

	    // Validate Participant Name
	    if (expectedParticipantName.equals(actualParticipantName)) {
	        System.out.println("Participant Name is correct.");
	        Log.info("Participant Name is correct.");
	        ExtentSuccessMessage("Participant Name is correct. Expected: " + expectedParticipantName + ", Actual: " + actualParticipantName);
	    } else {
	        System.out.println("Participant Name is incorrect.");
	        Log.error("Participant Name is incorrect.");
	        ExtentErrorMessage("Participant Name is incorrect. Expected: " + expectedParticipantName + ", Actual: " + actualParticipantName);
	    }

	    // Validate SSN (handling the masked SSN)
	    String actualLast4SSN = actualSSN.substring(actualSSN.length() - 4);
	    Log.info("Last 4 digits of Actual SSN: " + actualLast4SSN);

	    if (expectedSSN.endsWith(actualLast4SSN)) {
	        System.out.println("SSN is correct.");
	        Log.info("SSN is correct.");
	        ExtentSuccessMessage("SSN is correct. Expected: " + expectedSSN + ", Actual: " + actualSSN);
	    } else {
	        System.out.println("SSN is incorrect.");
	        Log.error("SSN is incorrect.");
	        ExtentErrorMessage("SSN is incorrect. Expected: " + expectedSSN + ", Actual: " + actualSSN);
	    }
	}
}
