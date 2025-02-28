package Pages;

import com.BasePackage.Base_Class;
import com.Utility.Log;


import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
//import java.sql.Date;
import java.util.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import com.BasePackage.Base_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class AccountSummary_Page extends Base_Class {

	public static By paymentProfiles = By.xpath("//a[contains(text(),'Payment Profiles')]");
	public static By ACHform = By.xpath("//a[.='ACH Authorization Form']");
	public static By FRSform = By.xpath("//a[.='FRS Authorization Form']");
	public static By clickOK = By.xpath("//*[@id=\"btnWarningOk\"]");
	public static By L_AccountSummary = By.xpath("//a[normalize-space()='Account Summary']");
	public static By L_DelinquentHistory = By.xpath("//a[contains(text(),'Delinquent History')]");
	public static By L_PaymentProfiles = By.xpath("//a[contains(text(),'Payment Profiles')]");
	public static By L_PaymentHistory = By.xpath("//a[contains(text(),'Payment History')]");
	public static By L_RemittanceHistory = By.xpath("//a[contains(text(),'Remittance History')]");
	public static By L_PaidThroughDate = By.xpath("//a[contains(text(),'Paid Through Date')]");
	public static By L_EmployeeBenefits = By.xpath("//a[contains(text(),'EmployeeBenefits')]");
	public static By L_RefundDetails = By.xpath("//a[contains(text(),'Refund Details')]");
	public static By clickViewTransactions = By.xpath("//a[contains(.,'View Transactions')]");
	public static By clickAdvacnedSearchDropdown = By.xpath("//button[contains(.,'keyboard_arrow_down')]");
	public static By planNameSelection = By.id("planName");

	public static By searchButton = By.xpath("//*[@id=\"viewtransactionsearch\"]");
	public static By clickClose = By.xpath("//div[@class='float-right']/a[@title='Close']/i[@class='material-icons dp48']");
	public static By clickManageCoverage = By.xpath("//a[normalize-space()='Manage Coverage']");
	public static By L_Amount = By.xpath("//input[@id='idPayment']");
	public static By L_transactiontype = By.xpath("//select[@id='transType']");
	public static By L_makepayment = By.xpath("//a[@class='btn btn-default btnMakePayment']");
	public static By L_clickVoid = By.xpath("//a[contains(@class, 'grid-ico-btn') and contains(@onclick, 'VoidPayable')]");
	public static By L_clickOKConfirmation = By.xpath("//*[@id=\"btn_VoidOnApproval\"]");
	public static By L_clickOKSuccess = By.xpath("//*[@id=\"btnOk\"]");
	public static By clickEmployeeDetails = By.xpath("//a[normalize-space()='Employee Details']");
	public static By categorySelection = By.id("category");
	public static By currentBalance= By.id("InvoiceCurrent");
	public static By L_CustomerNo = By.xpath("//*[text()='Customer #:']//parent::li");
	

	// Click on the Payment Profiles tab
	public void clickPaymentProfiles() throws InterruptedException {
		try {
			WaitForPageLoad();
			waitForElementClickable(paymentProfiles);
			click(paymentProfiles);
			ExtentSuccessMessage("Successfully clicked Payment Profiles");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Payment Profiles" + e.getMessage());
		}
	}

	// Click on ACH Authorization Form
	public void clickACHForm() throws InterruptedException {
		try {
			WaitForPageLoad();
			waitForElementClickable(ACHform);
			click(ACHform);
			ExtentSuccessMessage("Successfully clicked ACH Authirization Form");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on ACH Authirization Form" + e.getMessage());
		}
	}

	// Click on FRS Authorization Form
	public void clickFRSForm() throws InterruptedException {
		try {
			WaitForPageLoad();
			waitForElementClickable(FRSform);
			click(FRSform);
			ExtentSuccessMessage("Successfully clicked FRS Authirization Form");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on FRS Authirization Form" + e.getMessage());
		}
	}

	// Get ACH Authorization Form text
	public String getACHLetterType() throws InterruptedException {
		String letterType = ""; // Initialize the variable to store the LetterType

		try {
			WaitForPageLoad();
			ScrollUntilElementVisible(ACHform);
			findElements(ACHform);
			ExtentSuccessMessage("Successfully found the element");
			// Text from the element
			String elementText = GetElementText(ACHform);
			// Remove spaces from the text
			String textWithoutSpaces = elementText.replaceAll("\\s+", "");
			// Assign the extracted text without spaces to the variable
			letterType = textWithoutSpaces;
			ExtentSuccessMessage("Successfully Extracted the text: " + textWithoutSpaces);

		} catch (Exception e) {
			ExtentErrorMessage("Unable to find element or click on it: " + e.getMessage());
		}

		return letterType; // Return the extracted LetterType
	}

	// Get FRS Authorization Form text
	public String getFRSLetterType() throws InterruptedException {
		String letterType = ""; // Initialize the variable to store the LetterType

		try {
			WaitForPageLoad();
			ScrollUntilElementVisible(FRSform);
			findElements(FRSform);
			ExtentSuccessMessage("Successfully found the element");
			// Text from the element
			String elementText = GetElementText(FRSform);
			// Remove spaces from the text
			String textWithoutSpaces = elementText.replaceAll("\\s+", "");
			// Assign the extracted text without spaces to the variable
			letterType = textWithoutSpaces;
			ExtentSuccessMessage("Successfully Extracted the text: " + textWithoutSpaces);

		} catch (Exception e) {
			ExtentErrorMessage("Unable to find element or click on it: " + e.getMessage());
		}

		return letterType; // Return the extracted LetterType
	}

	// Click on the OK Button
	public void clickOKbutton() throws InterruptedException {
		try {
			WaitForPageLoad();
			waitForElementClickable(clickOK);
			click(clickOK);
			ExtentSuccessMessage("Successfully clicked on OK Button");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Ok Button" + e.getMessage());
		}
	}


	//Click on the View Transactions
	public void ClickOnViewTransactions() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(clickViewTransactions)) {
				Log.info("Successfully View Transactions is visible");
				click(clickViewTransactions);
				Log.info("Successfully Clicked On View Transactions");
				ExtentSuccessMessage("Successfully Clicked On View Transactions");
			}else {
				Log.error("UnSuccessfully not clicked On View Transactions");
				ExtentErrorMessage("UnSuccessfully not clicked On View Transactions");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

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
			Thread.sleep(2000);
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Select the Plan from the dropdown
	public void selectPlanFromPlanDropdown(String value) throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(planNameSelection)) {
				Log.info("Successfully Plan Dropdown is visible");
				selectDropdownByPartialText(planNameSelection, value );
				click(searchButton);
				Log.info("Successfully selected the plan from Plan Dropdown and clicked on Search button");
				ExtentSuccessMessage("Successfully selected the plan from Plan Dropdown and clicked on Search button");
			}else {
				Log.error("UnSuccessfully not selected the Plan ");
				ExtentErrorMessage("UnSuccessfully not selected the Plan ");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	//Select the Category from the Catrgory dropdown
	public void selectCategoryFromDropdown(String value) throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(categorySelection)) {
				Log.info("Successfully Category Dropdown is visible");
				selectDropdownByVisibleText(categorySelection, value);
				click(searchButton);
				Log.info("Successfully selected the Category from Category Dropdown and clicked on Search button");
				ExtentSuccessMessage("Successfully selected the Category from Category Dropdown and clicked on Search button");
			}else {
				Log.error("UnSuccessfully not selected the Category ");
				ExtentErrorMessage("UnSuccessfully not selected the Category ");
			}
			Thread.sleep(2000);
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on Account Summary
	public void clickOnAccountSummary() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(L_AccountSummary);
			ExtentSuccessMessage("Successfully clicked on AccountSummary ");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Edit" + e.getMessage());
		}
	}

	// Click on DelinquentHistory
	public void clickOnDelinquentHistory() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(L_DelinquentHistory);
			ExtentSuccessMessage("Successfully clicked on DelinquentHistory ");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Edit" + e.getMessage());
		}
	}

	// Click on Payment Profiles
	public void clickOnPaymentProfiles() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(L_PaymentProfiles);
			ExtentSuccessMessage("Successfully clicked on Payment Profiles ");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Edit" + e.getMessage());
		}
	}

	//Click on Payment History
	public void clickOnPaymentHistory() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(L_PaymentHistory);
			ExtentSuccessMessage("Successfully clicked on Payment History ");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Edit" + e.getMessage());
		}
	}

	// Click on Remittance History
	public void clickOnRemittanceHistory() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(L_RemittanceHistory);
			ExtentSuccessMessage("Successfully clicked on Remittance History ");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Edit" + e.getMessage());
		}
	}

	//Click on Paid Through Date
	public void clickOnPaidThroughDate() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(L_PaidThroughDate);
			ExtentSuccessMessage("Successfully clicked on Paid Through Date ");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Edit" + e.getMessage());
		}
	}

	//Click on EmployeeBenefits
	public void clickOnEmployeeBenefits() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(L_EmployeeBenefits);
			ExtentSuccessMessage("Successfully clicked on EmployeeBenefits ");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Edit" + e.getMessage());
		}
	}

	//Click on Refund Details
	public void clickOnRefundDetails() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(L_RefundDetails);
			ExtentSuccessMessage("Successfully clicked on Refund Details ");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Edit" + e.getMessage());
		}
	}


	// All the Account Summary Page related fields are displayed
	public Boolean isAllfieldsDisplayed() throws InterruptedException {
		WaitForPageLoad();
		return ElementDisplayed(L_AccountSummary) && ElementDisplayed(L_DelinquentHistory)
				&& ElementDisplayed(L_PaymentProfiles) && ElementDisplayed(L_PaymentHistory)
				&& ElementDisplayed(L_RemittanceHistory) && ElementDisplayed(L_PaidThroughDate) 
				&& ElementDisplayed(L_EmployeeBenefits) && ElementDisplayed(L_RefundDetails);
	}

	//Plan Verification
	public void planVerification(String plan, String amount, String effectiveDate) throws InterruptedException {
		scrollDown();
		WaitForLoadAnimationDisappear();
		int count = 0;
		// Define dynamic values
		String dynamicPlanCategory = plan;
		String dynamicAmount = amount;
		ZoneId zoneId = ZoneId.of("America/Montreal");
		LocalDate today = LocalDate.now(zoneId);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/d/yyyy");
		long monthsBetween = ChronoUnit.MONTHS.between(YearMonth.from(LocalDate.parse(effectiveDate, formatters)),
				YearMonth.from(today));
		// Find all rows in the table
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='viewTransactionList']//tbody/tr"));

		// Loop through each row
		for (WebElement row : rows) {
			// Get values for Plan Category, Amount, and Coverage From
			String planCategory = row.findElement(By.xpath("td[2]")).getText().trim();
			String amountValue = row.findElement(By.xpath("td[9]")).getText().trim();
			String coverageFrom = row.findElement(By.xpath("td[4]")).getText();
			String coverageTo = row.findElement(By.xpath("td[5]")).getText();
			String transactionType = row.findElement(By.xpath("td[7]")).getText().trim();

			// Validate Plan Category and Amount using case-insensitive comparison and
			// trim()
			if (planCategory.equalsIgnoreCase(dynamicPlanCategory) && amountValue.equals(dynamicAmount)) {
				Log.info("Plan Category and Amount are correct.");
				Log.info("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue+""
						+ ",Coverage From: " + coverageFrom + ", Coverage To: " + coverageTo);
				ExtentSuccessMessage("Plan Category and Amount are correct.");
				ExtentSuccessMessage("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue+""
						+ ",Coverage From: " + coverageFrom + ", Coverage To: " + coverageTo);

			} else {
				if (amountValue.contains("(")) {
					String amountValue1 = amountValue.replace("(", "");
					String amountValues = amountValue1.replace(")", "");
					System.out.println("Amount print after contains '(' :- " + amountValues);
					// Validate Plan Category and Amount using case-insensitive comparison and
					// trim()
					if (planCategory.equalsIgnoreCase(dynamicPlanCategory) && amountValues.equals(dynamicAmount)) {
						Log.info("Plan Category and Amount are correct.");
						Log.info("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue+""
								+ ",Coverage From: " + coverageFrom + ", Coverage To: " + coverageTo);
						ExtentSuccessMessage("Plan Category and Amount are correct.");
						ExtentSuccessMessage("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue+""
								+ ",Coverage From: " + coverageFrom + ", Coverage To: " + coverageTo);
					} else {
						Log.error("Plan Category or Amount is incorrect.");
						Log.error("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValues);
						ExtentErrorMessage("Plan Category or Amount is incorrect.");
						ExtentErrorMessage(
								"Row Details: Plan Category - " + planCategory + ", Amount - " + amountValues);
					}
				} else {
					Log.error("Plan Category or Amount is incorrect.");
					Log.error("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue);
					ExtentErrorMessage("Plan Category or Amount is incorrect.");
					ExtentErrorMessage("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue);
				}
			}

			if (count == 0) {
				assertEquals(LocalDate.parse(coverageFrom, formatters),
						LocalDate.now(zoneId).plusMonths(1).withDayOfMonth(1));
				ExtentSuccessMessage("Actual and Expected dates are same for planCategory:: "+planCategory + " " +LocalDate.parse(coverageFrom, formatters) +" and " +LocalDate.now(zoneId).plusMonths(1).withDayOfMonth(1));
				count++;
				continue;
			} else if (count == 1) {
				assertEquals(LocalDate.parse(coverageFrom, formatters), LocalDate.now(zoneId).withDayOfMonth(1));
				ExtentSuccessMessage("Actual and Expected dates are same for planCategory:: "+planCategory + " " +LocalDate.parse(coverageFrom, formatters) +" and " +LocalDate.now(zoneId).withDayOfMonth(1));
				count++;
				continue;
			} else {
				assertEquals(LocalDate.parse(coverageFrom, formatters),
						LocalDate.now(zoneId).minusMonths(monthsBetween).withDayOfMonth(1));
				ExtentSuccessMessage("Actual and Expected dates are same for planCategory:: "+planCategory + " " +LocalDate.parse(coverageFrom, formatters) +" and " +LocalDate.now(zoneId).minusMonths(monthsBetween).withDayOfMonth(1));
				monthsBetween = monthsBetween-1;
			}
		}
	}


	//Click on Close 
	public void clickClosebutton() throws InterruptedException {
		try {
			WaitForPageLoad();
			scrollUpVertically();
			WaitForPageLoad();
			waitForElementClickable(clickClose);
			click(clickClose);
			Log.info("Successfully clicked on Close Button");
			ExtentSuccessMessage("Successfully clicked on Close Button");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Close Button" + e.getMessage());
		}
	}

	//Click on Manage Coverage
	public void clickManageCoveragebutton() throws InterruptedException {
		try {
			WaitForPageLoad();
			waitForElementClickable(clickManageCoverage);
			click(clickManageCoverage);
			Log.info("Successfully clicked on Manage Coverage Button");
			ExtentSuccessMessage("Successfully clicked on Manage Coverage Button");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Ok Button" + e.getMessage());
		}
	}

	public static String ChangesInsideTheDates(String Date) throws ParseException, java.text.ParseException {
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		//get current date time with Date()
		Date date = new Date();
		// Now format the date
		String CurrentDate= dateFormat.format(date);
		// Print the Date
		String currentdate[] =CurrentDate.split("/");
		String CurrentMonth =currentdate[0].toString();
		int CurrentMonthCount =Integer. parseInt(CurrentMonth);
		int EffectiveMonthCount=0;
		String RestEffectiveMonth=null;
		if(Date.contains("/")) {
			String EffectiveDate[] =Date.split("/");
			String EffectiveMonth =EffectiveDate[0].toString();
			RestEffectiveMonth =EffectiveDate[1].toString()+"/"+EffectiveDate[2].toString();
			EffectiveMonthCount =Integer. parseInt(EffectiveMonth);
		}else {
			String b= ChangeDateformate(Date);
			String EffectiveDate[] =b.split("/");
			String EffectiveMonth =EffectiveDate[0].toString();
			RestEffectiveMonth =EffectiveDate[1].toString()+"/"+EffectiveDate[2].toString();
			EffectiveMonthCount =Integer. parseInt(EffectiveMonth);
		}
		int DiffBtwEMCandCMC =EffectiveMonthCount-CurrentMonthCount;
		String Count =String.valueOf(DiffBtwEMCandCMC);


		return DiffBtwEMCandCMC+","+CurrentMonthCount+","+EffectiveMonthCount+","+RestEffectiveMonth;
	}

	public void validateEntries(String PlanCategory,String effectivDate,String TransactionType,String Description,String Amount) throws ParseException, InterruptedException, java.text.ParseException {
		String ReturnValue =ChangesInsideTheDates(effectivDate);
		System.out.println("ReturnValue value :- "+ReturnValue);
		String returnvalues[]=ReturnValue.split(",");
		String DiffBtwEMCandCMC =returnvalues[0].toString();
		String CurrentMonthCount =returnvalues[1];
		String RestEffectiveMonth =returnvalues[3].toString();
		int Currentmonth =Integer.parseInt(CurrentMonthCount);
		int DiffBtwmonths =Integer.parseInt(DiffBtwEMCandCMC);
		int i=1;
		int CurrentMonthPlusone=Currentmonth+i;
		if(DiffBtwmonths==0){
			CheckValuePresentUnderTableRow(PlanCategory,CurrentMonthPlusone+"/"+RestEffectiveMonth,TransactionType, Description,Amount);
			CheckValuePresentUnderTableRow(PlanCategory,CurrentMonthCount+"/"+RestEffectiveMonth,TransactionType, Description,Amount);
		}else if(DiffBtwmonths==1){
			CheckValuePresentUnderTableRow(PlanCategory,CurrentMonthPlusone+"/"+RestEffectiveMonth,TransactionType, Description,Amount);
		}if(DiffBtwmonths>1){
			ExtentErrorMessage("Effective date is Future date"+effectivDate);
			System.out.println("Effective date is Future date"+effectivDate);
		}
	}

	public static int CheckValuePresentUnderTableRow(String PlanCategory,String Date,String TransactionType,String Description,String Amount) throws InterruptedException, ParseException {
		String Amonuts = null;
		if(Amount.contains("$")) {
			String Amounting=Amount.replace("$", "");
			double d = Double.parseDouble(Amounting);
			NumberFormat nf	= NumberFormat.getInstance(Locale.US);
			 Amonuts = nf.format(d);
			System.out.println("US  " + Amonuts);
			}else {
				double d = Double.parseDouble(Amount);
				NumberFormat nf	= NumberFormat.getInstance(Locale.US);
				 Amonuts = nf.format(d);
				System.out.println("US  " + Amonuts);
			}
		System.out.println("Amounts:- "+Amonuts);
		String Dates=null;
		if(Date.contains("/")) {
			 Dates=Date;
		}else {
			Dates= ChangeDateformate(Date);
		}
		System.out.println("Dates:- "+Dates);
		WaitForLoadAnimationDisappear();
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table cms-grid  table-fixer remove-margin']/tbody/tr"));
		int count = 0;
		boolean flag=false;
		for (WebElement row : rows) {
			count = count + 1;
			String getText = row.getText().replace("\n", " ");
			System.out.println("Debug Table row no "+count+" Value :" + getText);
			if (getText.contains(PlanCategory) && getText.contains(Dates) && getText.contains(TransactionType) && getText.contains(Description) && getText.contains(Amonuts) ) {
				Log.info("Row Details: Plan Category :- " + PlanCategory  + ", Date :- " + Dates+ ", transactionType :- "+TransactionType+", Description :- " + Description+", Amount :- " + Amonuts+" , Row Number :- "+count);
				ExtentSuccessMessage("Row Details: Plan Category :- " + PlanCategory  + ", Date :- " + Dates+ ", transactionType :- "+TransactionType+", Description :- " + Description+", Amount :- " + Amonuts+" , Row Number :- "+count);
				flag= true;
				break;
				
			} else {
				Log.error("Value not found under the Row ");
				
			}
		}
		if(!flag) {
			ExtentErrorMessage("Unsuccessfully not able to find the record :- Plan Category :- " + PlanCategory  + ", Date :- " + Dates+ ", transactionType :- "+TransactionType+", Description :- " + Description+", Amount :- " + Amonuts);			
		}
		
		return count;
	}

	//Enter an Amount
	public void enterAmount(String amount) throws InterruptedException {
		try {
			WaitForPageLoad();
			waitForElementClickable(L_Amount);
			click(L_Amount);
			clear(L_Amount);
			input(L_Amount,amount);
			click(searchButton);
			Log.info("Successfully Entered Amount "+amount);
			ExtentSuccessMessage("Successfully Entered Amount "+amount);
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Amount Button" + e.getMessage());
		}
	}

	//Transaction Type
	public void transactiontype(String type) throws InterruptedException {
		try {
			WaitForPageLoad();
			SelectDropDown_Only_Value(L_transactiontype, type);
			click(searchButton);
			Log.info("Successfully Selected type "+type);
			ExtentSuccessMessage("Successfully Selected type "+type);
		} catch (Exception e) {
			ExtentErrorMessage("Unable to Selected type " + e.getMessage());
		}
	}

	//Make Payment
	public void makepayment() throws InterruptedException {
		try {
			WaitForPageLoad();
			jsClick(L_makepayment);
			Log.info("Successfully clicked on Make Payment");
			ExtentSuccessMessage("Successfully clicked on Make Payment");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Make Payment Button" + e.getMessage());
		}
	}

	//type Payment displayed
	public Boolean istypepaymentDisplayed() throws InterruptedException{
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		By type_payment = By.xpath("//td[normalize-space()='Payment']");
		scrollDown();
		waitForElementVisible(type_payment);
		return ElementDisplayed(type_payment);
	}

	//Get Current Balance After Pay
	public String getCurrentBalanceAfterPay() throws InterruptedException {

		WebElement currentBalanceElement = driver.findElement(By.xpath("//*[@id='currentBalance']/h1"));
		String  currentBalanceText=currentBalanceElement.getText().trim(); 
		System.out.println("Current Balance Text: " + currentBalanceText);	 
		return currentBalanceText;
	}

	//Current Balance Validation
	public void currentBalanceValidation () {
		// Locate the element with the specified XPath
		WebElement currentBalanceElement = driver.findElement(By.xpath("//div[@id='currentBalance']/h1"));

		// Get the text content of the element
		String currentBalanceText = currentBalanceElement.getText();

		// Check if the amount is present in parentheses
		if (currentBalanceText.contains("(") && currentBalanceText.contains(")")) {
			System.out.println("Amount is negative: " + currentBalanceText);
			Log.info("Amount is negative: " + currentBalanceText);
			ExtentSuccessMessage("Amount is negative: " + currentBalanceText);

		} else {
			System.out.println("Amount is positive: " + currentBalanceText);
			Log.error("Amount is negative: " + currentBalanceText);
			ExtentErrorMessage("Amount is negative: " + currentBalanceText);
		}
	}

	//Click on Void 
	public void clickVoid() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(L_clickVoid);
			
			Log.info("Successfully clicked on Void");
			ExtentSuccessMessage("Successfully clicked on Void");
		} catch (Exception e) {
			Log.error("Unable to click on Void Button" + e.getMessage());
			ExtentErrorMessage("Unable to click on Void Button" + e.getMessage());
		}
	}

	//Click OK on Confirmation Popup
	public void clickOKConfirmation() throws InterruptedException {
		try {
			WaitForLoadAnimationDisappear();
			click(L_clickOKConfirmation);
			Log.info("Successfully clicked on OK in Confirmation Popup");
			ExtentSuccessMessage("Successfully clicked on OK in Confirmation Popup");
		} catch (Exception e) {
			Log.error("Unable to click OK in Confirmation Popup" + e.getMessage());
			ExtentErrorMessage("Unable to click OK in Confirmation Popup" + e.getMessage());
		}
	}

	//Click OK on Success Popup
	public void clickOKSuccess() throws InterruptedException {
		try {
			WaitForLoadAnimationDisappear();
			click(L_clickOKSuccess);
			Log.info("Successfully clicked on OK in Success Popup");
			ExtentSuccessMessage("Successfully clicked on OK in Success Popup");
		} catch (Exception e) {
			Log.error("Unable to click on OK in Success Popup" + e.getMessage());
			ExtentErrorMessage("Unable to click on OK in Success Popup" + e.getMessage());
		}
	}

	public void clickEmployeeDetailsbutton() throws InterruptedException {
		try {
			WaitForPageLoad();
			waitForElementClickable(clickEmployeeDetails);
			click(clickEmployeeDetails);
			Log.info("Successfully clicked on Employee Details Button");
			ExtentSuccessMessage("Successfully clicked on Employee Details Button");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Ok Button" + e.getMessage());
		}
	}


	//Transaction Type displayed
	public Boolean isTransactionTypeDisplayed() throws InterruptedException{
		By type_payment = By.xpath("//td[normalize-space()='Premium Receipts']");
		WaitForPageLoad();
		scrollDown();
		waitForElementVisible(type_payment);
		return ElementDisplayed(type_payment);
	}

	//Validate Payment Comments
	public Boolean iscommentsDisplayed(String comments) throws InterruptedException{
		By notes = By.xpath("//td[normalize-space()='"+ comments +"']");
		WaitForPageLoad();
		waitForElementVisible(notes);
		return ElementDisplayed(notes);
	}
	
	//Validate Payment Amount
		public Boolean isAmountDisplayed(String Amount) throws InterruptedException{
			By notes = By.xpath("//td[normalize-space()='"+ Amount +"']");
			WaitForPageLoad();
			return ElementDisplayed(notes);
		}

	//Check Status displayed
	public void checkStatus(String status) throws InterruptedException{		
		List<WebElement> rows = driver.findElements(By.xpath("//td[normalize-space()="+status+"]"));
		int count = 0;
		for (WebElement row : rows) {
			count = count + 1;
			String getText = row.getText().replace("\n", " ");
			System.out.println("Debug Table row Value :" + getText);
			if (getText.contains(status)) {
				ExtentSuccessMessage("Successfully found value :" + status + " for row number :" + count);
			} else {
				Log.error("Value not found under the table ");
			}
		}
	}

	//Validate the Change Plan Rate
	public void validateChangePlanRate(String PlanCategory,String effectivDate,String TransactionType,String Description,String Amount) throws ParseException, InterruptedException, java.text.ParseException {
		String ReturnValue =ChangesInsideTheDates(effectivDate);
		System.out.println("ReturnValue value :- "+ReturnValue);
		String returnvalues[]=ReturnValue.split(",");
		String DiffBtwEMCandCMC =returnvalues[0].toString();
		String CurrentMonthCount =returnvalues[1];
		String RestEffectiveMonth =returnvalues[3].toString();
		int Currentmonth =Integer.parseInt(CurrentMonthCount);
		int DiffBtwmonths =Integer.parseInt(DiffBtwEMCandCMC);
		int i=1;
		int CurrentMonthPlusone=Currentmonth+i;
		if(DiffBtwmonths==0){
			CheckValuePresentUnderTableRow(PlanCategory,CurrentMonthPlusone+"/"+RestEffectiveMonth,TransactionType, Description,Amount);
			CheckValuePresentUnderTableRow(PlanCategory,CurrentMonthCount+"/"+RestEffectiveMonth,TransactionType, Description,Amount);
		}else if(DiffBtwmonths==1){
			CheckValuePresentUnderTableRow(PlanCategory,CurrentMonthPlusone+"/"+RestEffectiveMonth,TransactionType, Description,Amount);
		}if(DiffBtwmonths>1){
			ExtentErrorMessage("Effective date is Future date"+effectivDate);
			System.out.println("Effective date is Future date"+effectivDate);
		}
	}

	//Get Current Balance Before Pay
	public String getACurrentBalanceBeforePay()
	{
		return driver.findElement(currentBalance).getAttribute("value").replace(",", "");
	}

	//Get Deposit Balance After Pay
	public String getDepositBalance()
	{
		return driver.findElement(By.xpath("//div[@id='paymentDetailHistory']//p")).getText().split(":")[1].trim();

	}

	//Validation for Terminate Plan Records
	public void terminatePlanVerification(String plan, String amount, String terminationDate) throws InterruptedException {
	    scrollDown();
	    WaitForLoadAnimationDisappear();
	    int count = 0;
 
	    // Define dynamic values
	    String dynamicPlanCategory = plan;
	    String dynamicAmount = amount;
 
	    ZoneId zoneId = ZoneId.of("America/Montreal");
	    LocalDate today = LocalDate.now(zoneId);
	    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/d/yyyy");
 
	    // Parse termination date based on length
	    LocalDate terminationLocalDate;
	    if (terminationDate.length() == 10) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	        terminationLocalDate = LocalDate.parse(terminationDate, formatter);
	    } else {
	        throw new IllegalArgumentException("Invalid termination date format: " + terminationDate);
	    }
 
	    // Calculate the end date for validation
	    LocalDate endDate = terminationLocalDate.plusMonths(3); // Adjust this value as needed
 
	    // List to store months to validate
	    List<String> monthsToValidate = new ArrayList<>();
 
	    // Add months for validation
	    LocalDate currentDate = terminationLocalDate;
	    while (!currentDate.isAfter(endDate)) {
	        monthsToValidate.add(currentDate.format(DateTimeFormatter.ofPattern("MM/yyyy")));
	        currentDate = currentDate.plusMonths(1);
	    }
 
	    // Find all rows in the table
	    List<WebElement> rows = driver.findElements(By.xpath("//div[@id='viewTransactionList']//tbody/tr"));
 
	    // Loop through each row
	    for (WebElement row : rows) {
	        // Get values for Plan Category, Amount, and Coverage From
	        String planCategory = row.findElement(By.xpath("td[2]")).getText().trim();
	        String amountValue = row.findElement(By.xpath("td[9]")).getText().trim();
	        String coverageTo = row.findElement(By.xpath("td[5]")).getText();
	        String transactionType = row.findElement(By.xpath("td[7]")).getText().trim();
	        String coverageFrom = row.findElement(By.xpath("td[4]")).getText();
 
	     // Validate Plan Category and Amount using case-insensitive comparison and trim()
	        if (planCategory.equalsIgnoreCase(dynamicPlanCategory) && amountValue.equals(dynamicAmount)) {
	            Log.info("Plan Category and Amount are correct.");
	            ExtentSuccessMessage("Plan Category and Amount are correct.");
	        } else if (planCategory.equalsIgnoreCase(dynamicPlanCategory)) {
	            // Handle amount enclosed in brackets
	            String amountWithoutBrackets = amountValue.replaceAll("[()]", "");
	            if (amountWithoutBrackets.equals(dynamicAmount)) {
	                Log.info("Plan Category and Amount are correct.");
	                ExtentSuccessMessage("Plan Category and Amount are correct.");
	            } else {
	                Log.error("Plan Category or Amount is incorrect.");
	                Log.error("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue);
	                ExtentErrorMessage("Plan Category or Amount is incorrect.");
	                ExtentErrorMessage("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue);
	            }
	        } else {
	            Log.error("Plan Category or Amount is incorrect.");
	            Log.error("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue);
	            ExtentErrorMessage("Plan Category or Amount is incorrect.");
	            ExtentErrorMessage("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue);
	        }
 
	        // Check coverage dates and display credit transaction records accordingly
	        LocalDate coverageFromDate = LocalDate.parse(coverageFrom, formatters);
	        LocalDate coverageToDate = LocalDate.parse(coverageTo, formatters);
	        String monthYear = coverageFromDate.format(DateTimeFormatter.ofPattern("MM/yyyy"));
 
	        // Validate if the record is within the months to validate
	        if (monthsToValidate.contains(monthYear)) {
	            if ("Credit".equalsIgnoreCase(transactionType)) {
	                Log.info("Credit transaction found within the coverage period. "
	                        + "Coverage From: " + coverageFrom + ", Coverage To: " + coverageTo + ", Credit Amount: "
	                        + dynamicAmount);
	                ExtentSuccessMessage("Credit transaction found within the coverage period. "
	                        + "Coverage From: " + coverageFrom + ", Coverage To: " + coverageTo + ", Credit Amount: "
	                        + dynamicAmount);
	                count++;
	            } else {
	                Log.error("No Credit transaction found within the coverage period.");
	                ExtentErrorMessage("No Credit transaction found within the coverage period.");
	            }
	        }
	    }
	}

	//Validate Credit Records for Change Plan Rate Flow
	public void validateChangePlanRateCredit(String plan, String oldAmount, String newEffectiveDate) throws InterruptedException {
		scrollDown();
		WaitForLoadAnimationDisappear();
		int count = 0;

		ZoneId zoneId = ZoneId.of("America/Montreal");
		LocalDate today = LocalDate.now(zoneId);
		LocalDate newEffectiveLocalDate = LocalDate.parse(newEffectiveDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		// Declare the dateOutputFormatter variable
		DateTimeFormatter dateOutputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		// Find all rows in the table
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='viewTransactionList']//tbody/tr"));

		// Loop through each row
		for (WebElement row : rows) {
			// Get values for Plan Category, Amount, and Coverage From
			String planCategory = row.findElement(By.xpath("td[2]")).getText().trim();
			String amountValue = row.findElement(By.xpath("td[9]")).getText().trim();
			String coverageTo = row.findElement(By.xpath("td[5]")).getText();
			String transactionType = row.findElement(By.xpath("td[7]")).getText().trim();
			String coverageFrom = row.findElement(By.xpath("td[4]")).getText();

			// Handle amount with parentheses
			String amountValues = amountValue.contains("(") ? amountValue.replace("(", "").replace(")", "") : amountValue;


		}
	}
	//Get Current Balance
	public String getcurrentbalance() throws InterruptedException{
		String current_balance = findElement(By.xpath("//*[@id='currentBalance']/h1")).getText().trim();
		WaitForPageLoad();
		return current_balance;
	}

	//	public void VerificationPart(String plan, String amount, String effectiveDate,String ExpectedTransactionType) throws InterruptedException {
	//		scrollDown();
	//		WaitForLoadAnimationDisappear();
	//		int count = 0;
	//		// Define dynamic values
	//		String dynamicPlanCategory = plan;
	//		String dynamicAmount = amount;
	//		String dynamictransactionType = ExpectedTransactionType;
	//		ZoneId zoneId = ZoneId.of("America/Montreal");
	//		LocalDate today = LocalDate.now(zoneId);
	//		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/d/yyyy");
	//		long monthsBetween = ChronoUnit.MONTHS.between(YearMonth.from(LocalDate.parse(effectiveDate, formatters)),
	//				YearMonth.from(today));
	//		// Find all rows in the table
	//		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='viewTransactionList']//tbody/tr"));
	//
	//		// Loop through each row
	//		for (WebElement row : rows) {
	//			// Get values for Plan Category, Amount, and Coverage From
	//			String planCategory = row.findElement(By.xpath("td[2]")).getText().trim();
	//			String amountValue = row.findElement(By.xpath("td[9]")).getText().trim();
	//			String transactionType = row.findElement(By.xpath("td[7]")).getText().trim();
	//			String coverageFrom = row.findElement(By.xpath("td[4]")).getText();
	//
	//			// Validate Plan Category and Amount using case-insensitive comparison and
	//			// trim()
	//			if (planCategory.equalsIgnoreCase(dynamicPlanCategory) && amountValue.equals(dynamicAmount) && transactionType.equals(dynamictransactionType)) {
	//				Log.info("Plan Category, Amount and transaction Type are correct.");
	//				ExtentSuccessMessage("Plan Category, Amount and transaction Type are correct.");
	//
	//			} else {
	//				if (amountValue.contains("(")) {
	//					String amountValue1 = amountValue.replace("(", "");
	//					String amountValues = amountValue1.replace(")", "");
	//					System.out.println("Amount print after contains '(' :- " + amountValues);
	//					// Validate Plan Category and Amount using case-insensitive comparison and
	//					// trim()
	//					if (planCategory.equalsIgnoreCase(dynamicPlanCategory) && amountValue.equals(dynamicAmount) && transactionType.equals(dynamictransactionType)) {
	//						Log.info("Plan Category, Amount and transaction Type are correct.");
	//						ExtentSuccessMessage("Plan Category, Amount and transaction Type are correct.");
	//					} else {
	//						Log.error("Plan Category or Amount is incorrect.");
	//						Log.error("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValues);
	//						ExtentErrorMessage("Plan Category or Amount is incorrect.");
	//						ExtentErrorMessage(
	//								"Row Details: Plan Category - " + planCategory + ", Amount - " + amountValues+", transactionType - "+transactionType);
	//
	//					}
	//				} else {
	//					Log.error("Plan Category or Amount is incorrect.");
	//					Log.error("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue);
	//					ExtentErrorMessage("Plan Category or Amount is incorrect.");
	//					ExtentErrorMessage("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue);
	//				}
	//
	//				/*
	//				 * // Validate the presence of records for January if
	//				 * (coverageFrom.equals("01/01/2024")) {
	//				 * System.out.println("Record for January found.");
	//				 * Log.info("Record for January found.");
	//				 * ExtentSuccessMessage("Record for January found."); }
	//				 * 
	//				 * // Validate the presence of records for February if
	//				 * (coverageFrom.equals("02/01/2024")) {
	//				 * System.out.println("Record for February found.");
	//				 * Log.info("Record for February found.");
	//				 * ExtentSuccessMessage("Record for February found."); }
	//				 */
	//			}
	//
	//			if (count == 0) {
	//				assertEquals(LocalDate.parse(coverageFrom, formatters),
	//						LocalDate.now(zoneId).plusMonths(1).withDayOfMonth(1));
	//				count++;
	//				continue;
	//			} else if (count == 1) {
	//				assertEquals(LocalDate.parse(coverageFrom, formatters), LocalDate.now(zoneId).withDayOfMonth(1));
	//				count++;
	//				continue;
	//			} else {
	//				assertEquals(LocalDate.parse(coverageFrom, formatters),
	//						LocalDate.now(zoneId).plusMonths(monthsBetween--).withDayOfMonth(1));
	//			}
	//		}
	//	
	//
	//
	//			// Validate Plan Category and Amount using case-insensitive comparison and trim()
	//			if (planCategory.equalsIgnoreCase(plan) && amountValues.equals(oldAmount)) {
	//				Log.info("Plan Category and Amount are correct.");
	//				ExtentSuccessMessage("Plan Category and Amount are correct.");
	//			} else {
	//				Log.error("Plan Category or Amount is incorrect.");
	//				Log.error("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValues);
	//				ExtentErrorMessage("Plan Category or Amount is incorrect.");
	//				ExtentErrorMessage("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValues);
	//			}
	//
	//	// Check effective date and display credit transaction records accordingly
	//	if ((newEffectiveLocalDate.getMonth() == today.getMonth() || newEffectiveLocalDate.getMonthValue() == today.getMonthValue() + 1)
	//			&& "Credit".equalsIgnoreCase(transactionType) && amountValues.equals(oldAmount)) {
	//		// Display credit transactions for the current and next months
	//		String coverageFromDate = LocalDate.parse(coverageFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy")).format(dateOutputFormatter);
	//		String coverageToDate = LocalDate.parse(coverageTo, DateTimeFormatter.ofPattern("MM/dd/yyyy")).format(dateOutputFormatter);
	//
	//		Log.info("Effective date is in the current or next month, and a Credit transaction is expected. "
	//				+ "Coverage From: " + coverageFromDate + ", Coverage To: " + coverageToDate + ", Credit Amount: "
	//				+ oldAmount);
	//
	//		ExtentSuccessMessage("Effective date is in the current or next month, and a Credit transaction is expected. "
	//				+ "Coverage From: " + coverageFromDate + ", Coverage To: " + coverageToDate + ", Credit Amount: "
	//				+ oldAmount);
	//		count++;
	//	}
	//}
	//
	//// Validation outside the loop
	//if (count == 0) {
	//	// No credit conditions are met
	//	Log.error("No credit conditions are met.");
	//	ExtentErrorMessage("No credit conditions are met.");
	//}
	//}
	//
	//Validate Charge Records for Change Plan Rate Flow 
	public void validateChangePlanRateCharge(String plan, String newAmount, String newEffectiveDate) throws InterruptedException {
		scrollDown();
		WaitForLoadAnimationDisappear();
		int count = 0;

		ZoneId zoneId = ZoneId.of("America/Montreal");
		LocalDate today = LocalDate.now(zoneId);
		LocalDate newEffectiveLocalDate = LocalDate.parse(newEffectiveDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		// Declare the dateOutputFormatter variable
		DateTimeFormatter dateOutputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		// Find all rows in the table
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='viewTransactionList']//tbody/tr"));

		// Loop through each row
		for (WebElement row : rows) {
			// Get values for Plan Category, Amount, and Coverage From
			String planCategory = row.findElement(By.xpath("td[2]")).getText().trim();
			String amountValue = row.findElement(By.xpath("td[9]")).getText().trim();
			String coverageTo = row.findElement(By.xpath("td[5]")).getText();
			String transactionType = row.findElement(By.xpath("td[7]")).getText().trim();
			String coverageFrom = row.findElement(By.xpath("td[4]")).getText();

			// Validate Plan Category and Amount using case-insensitive comparison and trim()
			if (planCategory.equalsIgnoreCase(plan) && amountValue.equals(newAmount)) {
				Log.info("Plan Category and Amount are correct.");
				ExtentSuccessMessage("Plan Category and Amount are correct.");

				// Check effective date and display charge transaction records accordingly
				if ((newEffectiveLocalDate.getMonth() == today.getMonth() || newEffectiveLocalDate.getMonthValue() == today.getMonthValue() + 1)
						&& "Charge".equalsIgnoreCase(transactionType) && amountValue.equals(newAmount)) {
					// Display charge transactions for the current and next months
					String coverageFromDate = LocalDate.parse(coverageFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy")).format(dateOutputFormatter);
					String coverageToDate = LocalDate.parse(coverageTo, DateTimeFormatter.ofPattern("MM/dd/yyyy")).format(dateOutputFormatter);

					Log.info("Effective date is in the current or next month, and a Charge transaction is expected. "
							+ "Coverage From: " + coverageFromDate + ", Coverage To: " + coverageToDate + ", Charge Amount: "
							+ newAmount);

					ExtentSuccessMessage("Effective date is in the current or next month, and a Charge transaction is expected. "
							+ "Coverage From: " + coverageFromDate + ", Coverage To: " + coverageToDate + ", Charge Amount: "
							+ newAmount);
					count++;
				}
			}
		}

		// Validation outside the loop
		if (count == 0) {
			// No charge conditions are met
			Log.error("No charge conditions are met.");
			ExtentErrorMessage("No charge conditions are met.");
		}
	}

	//
	public void QeValidation(String plan, String Amount, String newEffectiveDate) throws InterruptedException {
	    scrollDown();
	    WaitForLoadAnimationDisappear();
	    int count = 0;
 
	    ZoneId zoneId = ZoneId.of("America/Montreal");
	    LocalDate today = LocalDate.now(zoneId);
	    LocalDate newEffectiveLocalDate = LocalDate.parse(newEffectiveDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
 
	    // Declare the dateOutputFormatter variable
	    DateTimeFormatter dateOutputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
 
	    // Find all rows in the table
	    List<WebElement> rows = driver.findElements(By.xpath("//div[@id='viewTransactionList']//tbody/tr"));

	    // Loop through each row
	    for (LocalDate date = newEffectiveLocalDate; !date.isAfter(today.plusMonths(1)); date = date.plusMonths(1)) {
	        // Check if the month of the current date is equal to the month of the coverage to date
	        for (WebElement row : rows) {
	            String planCategory = row.findElement(By.xpath("td[2]")).getText().trim();
	            String amountValue = row.findElement(By.xpath("td[9]")).getText().trim();
	            String coverageTo = row.findElement(By.xpath("td[5]")).getText().trim();
	            String coverageFrom = row.findElement(By.xpath("td[4]")).getText().trim();
 
	            // Validate Plan Category and Amount using case-insensitive comparison and trim()
	            if (planCategory.equalsIgnoreCase(plan) && amountValue.equals(Amount)) {
	                LocalDate coverageToDate = LocalDate.parse(coverageTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
 
	                if (coverageToDate.getMonth() == date.getMonth() && coverageToDate.getYear() == date.getYear()) {
	                    String formattedFromDate = LocalDate.parse(coverageFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy")).format(dateOutputFormatter);
	                    String formattedToDate = coverageToDate.format(dateOutputFormatter);

	                    Log.info("Effective date is in the required range. Coverage From: " + formattedFromDate + ", Coverage To: " + formattedToDate + ", Charge Amount: " + Amount);
	                    ExtentSuccessMessage("Effective date is in the required range. Coverage From: " + formattedFromDate + ", Coverage To: " + formattedToDate + ", Charge Amount: " + Amount);
	                    count++;
	                }
	            }
	        }
	    }
	    
	    // Validation outside the loop
	    if (count == 0) {
	        // No charge conditions are met
	        Log.error("No charge conditions are met.");
	        ExtentErrorMessage("No charge conditions are met.");
	    }
	}
	
	//
	public void ReEnrollValidation(String plan, String Amount, String newEffectiveDate) throws InterruptedException {
	    scrollDown();
	    WaitForLoadAnimationDisappear();
	    int count = 0;
 
	    ZoneId zoneId = ZoneId.of("America/Montreal");
	    LocalDate today = LocalDate.now(zoneId);
	    LocalDate newEffectiveLocalDate = LocalDate.parse(newEffectiveDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
 
	    // Find the start of the month for newEffectiveDate
	    LocalDate startOfMonth = newEffectiveLocalDate.withDayOfMonth(1);
 
	    // Find all rows in the table
	    List<WebElement> rows = driver.findElements(By.xpath("//div[@id='viewTransactionList']//tbody/tr"));
 
	    // Find the latest charge record within the range of months
	    LocalDate latestChargeDate = null;
	    WebElement latestChargeRecord = null;
 
	    // Loop through each row
	    for (WebElement row : rows) {
	        String transactionType = row.findElement(By.xpath("td[7]")).getText().trim();
	        String coverageFrom = row.findElement(By.xpath("td[4]")).getText();
	        if ("Charge".equalsIgnoreCase(transactionType)) {
	            LocalDate chargeDate = LocalDate.parse(coverageFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	            // Check if chargeDate is within the range of months
	            if (!chargeDate.isBefore(startOfMonth)) {
	                if (latestChargeDate == null || chargeDate.isAfter(latestChargeDate)) {
	                    latestChargeDate = chargeDate;
	                    latestChargeRecord = row;
	                }
	            }
	        }
	    }

	    if (latestChargeRecord != null) {
	        // Get values for Plan Category, Amount, and Coverage From from the latest charge record
	        String planCategory = latestChargeRecord.findElement(By.xpath("td[2]")).getText().trim();
	        String amountValue = latestChargeRecord.findElement(By.xpath("td[9]")).getText().trim();
	        String coverageTo = latestChargeRecord.findElement(By.xpath("td[5]")).getText();

	        // Validate Plan Category and Amount using case-insensitive comparison and trim()
	        if (planCategory.equalsIgnoreCase(plan) && amountValue.equals(Amount)) {
	            Log.info("Plan Category and Amount are correct.");
	            ExtentSuccessMessage("Plan Category and Amount are correct.");

	            // Check if the chargeDate month is within the range of months
	            if (!latestChargeDate.isBefore(startOfMonth)) {
	                String coverageFromDate = latestChargeDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	                String coverageToDate = LocalDate.parse(coverageTo, DateTimeFormatter.ofPattern("MM/dd/yyyy")).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	                Log.info("Effective date matches the latest charge record within the range of months. "
	                        + "Coverage From: " + coverageFromDate + ", Coverage To: " + coverageToDate + ", Charge Amount: "
	                        + Amount);

	                ExtentSuccessMessage("Effective date matches the latest charge record within the range of months. "
	                        + "Coverage From: " + coverageFromDate + ", Coverage To: " + coverageToDate + ", Charge Amount: "
	                        + Amount);
	                count++;
	            } else {
	                Log.error("Effective date does not match the latest charge record within the range of months.");
	                ExtentErrorMessage("Effective date does not match the latest charge record within the range of months.");
	            }
	        }
	    } else {
	        // No charge record found
	        Log.error("No charge record found within the range of months.");
	        ExtentErrorMessage("No charge record found within the range of months.");
	    }
	    
	    // Validation outside the loop
	    if (count == 0) {
	        // No charge conditions are met
	        Log.error("No charge conditions are met within the range of months.");
	        ExtentErrorMessage("No charge conditions are met within the range of months.");
	    }
	}

	// Employee Termination Validation
	public void EmployeeTerminationVerification(String plan, String terminationDate) throws InterruptedException {
		scrollDown();
		// WaitForLoadAnimationDisappear();
		int count = 0;

		// Define dynamic values
		String dynamicPlanCategory = plan;

		ZoneId zoneId = ZoneId.of("America/Montreal");
		LocalDate today = LocalDate.now(zoneId);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/d/yyyy");

		// Parse termination date based on length
		LocalDate terminationLocalDate;
		if (terminationDate.length() == 8) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
			terminationLocalDate = LocalDate.parse(terminationDate, formatter);
		} else if (terminationDate.length() == 10) {
			terminationLocalDate = LocalDate.parse(terminationDate, formatters);
		} else {
			throw new IllegalArgumentException("Invalid termination date format: " + terminationDate);
		}

		// Declare the dateOutputFormatter variable
		DateTimeFormatter dateOutputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		// Get values for Plan Category, Amount, and Coverage From
		String planCategory = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[1]/td[2]")).getText().trim();
		String amountValue = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[1]/td[9]")).getText().trim();
		String coverageTo = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[1]/td[5]")).getText();
		String transactionType = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[1]/td[7]")).getText().trim();
		String coverageFrom = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[1]/td[4]")).getText();
		String description = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[1]/td[8]")).getText().trim();

		if (ChronoUnit.MONTHS.between(YearMonth.from(terminationLocalDate),YearMonth.from(today)) == 0)
		{
			String planCategory2 = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[2]/td[2]")).getText().trim();
			String amountValue2 = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[2]/td[9]")).getText().trim();
			String coverageTo2 = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[2]/td[5]")).getText();
			String transactionType2 = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[2]/td[7]")).getText().trim();
			String coverageFrom2 = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[2]/td[4]")).getText();
			String description2 = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[2]/td[8]")).getText().trim();

			// Validate Plan Category using case-insensitive comparison and trim()
			if (planCategory.equalsIgnoreCase(dynamicPlanCategory)
					&& planCategory2.equalsIgnoreCase(dynamicPlanCategory)) {
				Log.info("Plan Category is correct.");
				ExtentSuccessMessage("Plan Category is correct.");
			} else {
				Log.error("Plan Category is incorrect.");
				Log.error("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue
						+ ", Description - " + description);
				ExtentErrorMessage("Plan Category is incorrect.");
				ExtentErrorMessage("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue
						+ ", Description - " + description);
			}

			if ("Credit".equalsIgnoreCase(transactionType) && "Employment Termination".equalsIgnoreCase(description)) {
				// Log and Extent messages with Transaction Type and Description
				String coverageFromDate = LocalDate.parse(coverageFrom, formatters).format(dateOutputFormatter);
				String coverageToDate = LocalDate.parse(coverageTo, formatters).format(dateOutputFormatter);
				String coverageFromDate2 = LocalDate.parse(coverageFrom2, formatters).format(dateOutputFormatter);
				String coverageToDate2 = LocalDate.parse(coverageTo2, formatters).format(dateOutputFormatter);

				Log.info(
						"Termination date is in the current and next month, and a Credit transaction with Employment Termination is expected. "
								+ "Coverage From: " + coverageFromDate + ", Coverage To: " + coverageToDate
								+ ", Transaction Type: " + transactionType + ", Description: " + description);

				ExtentSuccessMessage(
						"Termination date is in the current month, and a Credit transaction with Employment Termination is expected. "
								+ "Coverage From: " + coverageFromDate + ", Coverage To: " + coverageToDate
								+ ", Transaction Type: " + transactionType + ", Description: " + description);

				ExtentSuccessMessage(
						"Termination date is in the Next month, and a Credit transaction with Employment Termination is expected. "
								+ "Coverage From2: " + coverageFromDate2 + ", Coverage To: " + coverageToDate2
								+ ", Transaction Type: " + transactionType2 + ", Description: " + description2);

			} }else if (ChronoUnit.MONTHS.between(YearMonth.from(terminationLocalDate),YearMonth.from(today)) == 1) {

				// Validate Plan Category using case-insensitive comparison and trim()
				if (planCategory.equalsIgnoreCase(dynamicPlanCategory)) {
					Log.info("Plan Category is correct.");
					ExtentSuccessMessage("Plan Category is correct.");
				} else {
					Log.error("Plan Category is incorrect. Expected: " + dynamicPlanCategory +" Actual: " +planCategory);
					Log.error("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue
							+ ", Description - " + description);
					ExtentErrorMessage("Plan Category is incorrect.");
					ExtentErrorMessage("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue
							+ ", Description - " + description);
				}

				if ("Credit".equalsIgnoreCase(transactionType)
						&& "Employment Termination".equalsIgnoreCase(description)) {
					// Log and Extent messages with Transaction Type and Description
					String coverageFromDate = LocalDate.parse(coverageFrom, formatters).format(dateOutputFormatter);
					String coverageToDate = LocalDate.parse(coverageTo, formatters).format(dateOutputFormatter);

					Log.info(
							"Termination date is in the Next month, and a Credit transaction with Employment Termination is expected. "
									+ "Coverage From: " + coverageFromDate + ", Coverage To: " + coverageToDate
									+ ", Transaction Type: " + transactionType + ", Description: " + description);

					ExtentSuccessMessage(
							"Termination date is in the Next month, and a Credit transaction with Employment Termination is expected. "
									+ "Coverage From: " + coverageFromDate + ", Coverage To: " + coverageToDate
									+ ", Transaction Type: " + transactionType + ", Description: " + description);

				}

				else {
					Log.error(
							"Termination date is in the current month, but no Credit transaction with Employment Termination found.");
					ExtentErrorMessage(
							"Termination date is in the current month, but no Credit transaction with Employment Termination found.");
				}
			}
		}

	// Employee Reinstate Validation
		public void EmployeeReinstateVerification(String plan, String terminationDate) throws InterruptedException {
			scrollDown();
			// WaitForLoadAnimationDisappear();
			int count = 0;

			// Define dynamic values
			String dynamicPlanCategory = plan;

			ZoneId zoneId = ZoneId.of("America/Montreal");
			LocalDate today = LocalDate.now(zoneId);
			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/d/yyyy");

			// Parse termination date based on length
			LocalDate terminationLocalDate;
			if (terminationDate.length() == 8) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
				terminationLocalDate = LocalDate.parse(terminationDate, formatter);
			} else if (terminationDate.length() == 10) {
				terminationLocalDate = LocalDate.parse(terminationDate, formatters);
			} else {
				throw new IllegalArgumentException("Invalid termination date format: " + terminationDate);
			}

			// Declare the dateOutputFormatter variable
			DateTimeFormatter dateOutputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

			// Find all rows in the table
			String planCategory = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr/td[2]")).getText().trim();
			String amountValue = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr/td[9]")).getText().trim();
			String coverageTo = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr/td[5]")).getText();
			String transactionType = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr/td[7]")).getText().trim();
			String coverageFrom = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr/td[4]")).getText();
			String description = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr/td[8]")).getText().trim();

			if (ChronoUnit.MONTHS.between(YearMonth.from(today), YearMonth.from(terminationLocalDate)) == 0)
			{
				String planCategory2 = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[2]/td[2]")).getText().trim();
				String amountValue2 = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[2]/td[9]")).getText().trim();
				String coverageTo2 = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[2]/td[5]")).getText();
				String transactionType2 = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[2]/td[7]")).getText().trim();
				String coverageFrom2 = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[2]/td[4]")).getText();
				String description2 = driver.findElement(By.xpath("//div[@id='viewTransactionList']//tbody/tr[2]/td[8]")).getText().trim();

				// Validate Plan Category using case-insensitive comparison and trim()
				if (planCategory.equalsIgnoreCase(dynamicPlanCategory)
						&& planCategory2.equalsIgnoreCase(dynamicPlanCategory)) {
					Log.info("Plan Category is correct.");
					ExtentSuccessMessage("Plan Category is correct.");
				} else {
					Log.error("Plan Category is incorrect.");
					Log.error("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue
							+ ", Description - " + description);
					ExtentErrorMessage("Plan Category is incorrect.");
					ExtentErrorMessage("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue
							+ ", Description - " + description);
				}

				if ("Charge".equalsIgnoreCase(transactionType) && description.contains("Enrollment")) {
					// Log and Extent messages with Transaction Type and Description
					String coverageFromDate = LocalDate.parse(coverageFrom, formatters).format(dateOutputFormatter);
					String coverageToDate = LocalDate.parse(coverageTo, formatters).format(dateOutputFormatter);
					String coverageFromDate2 = LocalDate.parse(coverageFrom2, formatters).format(dateOutputFormatter);
					String coverageToDate2 = LocalDate.parse(coverageTo2, formatters).format(dateOutputFormatter);

					Log.info(
							"Termination date is in the current and next month, and a Charge transaction with Employment Termination is expected. "
									+ "Coverage From: " + coverageFromDate + ", Coverage To: " + coverageToDate
									+ ", Transaction Type: " + transactionType + ", Description: " + description);

					ExtentSuccessMessage(
							"Termination date is in the current month, and a Charge transaction with Employment Termination is expected. "
									+ "Coverage From: " + coverageFromDate + ", Coverage To: " + coverageToDate
									+ ", Transaction Type: " + transactionType + ", Description: " + description);

					ExtentSuccessMessage(
							"Termination date is in the Next month, and a Charge transaction with Employment Termination is expected. "
									+ "Coverage From2: " + coverageFromDate2 + ", Coverage To: " + coverageToDate2
									+ ", Transaction Type: " + transactionType2 + ", Description: " + description2);

				} }else if (ChronoUnit.MONTHS.between(YearMonth.from(today),YearMonth.from(terminationLocalDate)) == 1) {

					// Validate Plan Category using case-insensitive comparison and trim()
					if (planCategory.equalsIgnoreCase(dynamicPlanCategory)) {
						Log.info("Plan Category is correct.");
						ExtentSuccessMessage("Plan Category is correct.");
					} else {
						Log.error("Plan Category is incorrect.");
						Log.error("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue
								+ ", Description - " + description);
						ExtentErrorMessage("Plan Category is incorrect.");
						ExtentErrorMessage("Row Details: Plan Category - " + planCategory + ", Amount - " + amountValue
								+ ", Description - " + description);
					}

					if ("Charge".equalsIgnoreCase(transactionType)
							&& description.contains("Enrollment")) {
						// Log and Extent messages with Transaction Type and Description
						String coverageFromDate = LocalDate.parse(coverageFrom, formatters).format(dateOutputFormatter);
						String coverageToDate = LocalDate.parse(coverageTo, formatters).format(dateOutputFormatter);

						Log.info(
								"Termination date is in the Next month, and a Charge transaction with Employment Termination is expected. "
										+ "Coverage From: " + coverageFromDate + ", Coverage To: " + coverageToDate
										+ ", Transaction Type: " + transactionType + ", Description: " + description);

						ExtentSuccessMessage(
								"Termination date is in the Next month, and a Charge transaction with Employment Termination is expected. "
										+ "Coverage From: " + coverageFromDate + ", Coverage To: " + coverageToDate
										+ ", Transaction Type: " + transactionType + ", Description: " + description);

					}

					else {
						Log.error(
								"Termination date is in the current month, but no Charge transaction with Employment Termination found.");
						ExtentErrorMessage(
								"Termination date is in the current month, but no Charge transaction with Employment Termination found.");
					}
				}
			}
	// Validate Deposit Amount
	public Boolean validateDepositamount(String amount) {
		By dpamount = By.xpath("//td[normalize-space()='" + amount + "']");
		return ElementDisplayed(dpamount);
	}
	public String GetCustomerNo() throws InterruptedException {
		String CustomerNo = GetElementText(L_CustomerNo);
		System.out.println("GetCustomerNo:- "+CustomerNo);
		return CustomerNo;
	}
}
