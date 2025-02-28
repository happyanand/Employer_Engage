package Pages;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.BasePackage.Base_Class;

public class TerminateEmployee_Page extends Base_Class {

	
	//private static By OK = By.id("no");
	
	private static By OK = By.xpath("//input[@id='no' and @value='OK']");
	private static By effectiveDate = By.id("Item1_EffectiveDate");

	private static By terminationDate = By.id("TerminationDate");

	private static By terminationReason = By.id("TerminationReason_chzn");

	private static By submit = By.id("BtnSubmitTermination");

	private static By ClickCloseButton = By.xpath("//a[@class='btn btn-primary closeBtn']");

	private static By clickManageCoverage = By.xpath("//*[@id='listView']/li[3]/a");

	private static By clickCarrierResponseUpdate = By.xpath("//span[normalize-space()='Carrier Response Update']");

	private static By clickActionDropdown = By.xpath("//*[@id='TransType_chzn']/a");

	private static By UpdateMemberID = By.xpath("//*[@id='TransType_chzn_o_1']");

	private static By UpdateSuccessResponse = By.xpath("//*[@id='TransType_chzn_o_2']");

	private static By searchDropdown = By.xpath("//*[@id=\"btnAdvancedToggle\"]/i");

	private static By searchSSN = By.xpath("//div[@id='SearchMore']//input[@id='SSN_mask']");

	private static By searchButton = By.xpath("//input[@id='btnSearchFor_MemberInfo_Advanced']");

	private static By typeMemberID = By.xpath("//input[@id='individualmemberid']");

	private static By clicksubmit = By.xpath("//input[@value='Submit']");

	private static By clickUpdateStatus = By.xpath("//a[@class='btn btn-sm btn-default btn_statusUpdate']");

	private static By clickok = By.xpath("//*[@id=\"btnPopUpSuccessResponseOk\"]");

	private static By statusActive = By.xpath("(//*[@id=\"PresentCont_1\"]/div/div/div/div[2]/div[2]/div/text())[1]");

	// private static By statusActive=
	// By.xpath("//*[@id=\"PresentCont_1\"]/div/div/div/div[2]/div[2]/div/label[5]");

	private static By clickViewCoverage = By.xpath("//span[normalize-space()='View Coverage']");

	private static By txtKeywordSearch = By.xpath("//input[@id='btnKeyWordSearch2']");

	private static By btnKeywordSearch = By.xpath("//button[@id='btnKeyWordSearch']");

	private static By clickName = By.xpath("//div[@id='div_ListView']/table/tbody/tr/td[2]/a");

	private static By successMessage = By.xpath("//*[text()='The employee has been terminated successfully.']");

	private static By cobraEnrollmentNo = By.xpath("//label[@class='btn btn-default btn_radio_program Yesnoclass']|");

	private static By clickContinue = By.xpath("//a[@id='a_continueSelection']");
	public static By L_cobraEnrollmentNo = By.xpath("//*[@id='no']|//label[@class='btn btn-default btn_radio_program Yesnoclass']");
	//public static By L_cobraEnrollmentNo = By.id("no");//*[@id='no']
	//public static By L_cobraEnrollmentNo = By.id("no");
	public static By L_NoEnrollment = By.id("rdb_noEnrol");//*[@id='no']

	public static By L_SuccessMessage = By.xpath("//*[text()='Terminated Successfully.Do you want to perform cobra Enrollment?']");

	//	//Click Close Button
	//	public void clickCloseButton() throws InterruptedException {
	//		click(ClickCloseButton);
	//	}
	//
	//	// Click ManageCoverage
	//	public void clickManageCoverage() throws InterruptedException {
	//		WaitForPageLoad();
	//		Thread.sleep(8000);
	//		click(clickManageCoverage);
	//		WaitForPageLoad();
	//	}
	//
	//	// Click CarrierResponseUpdate
	//	public void CarrierResponseUpdate() throws InterruptedException {
	//		WaitForPageLoad();
	//		click(clickCarrierResponseUpdate);
	//		WaitForPageLoad();
	//	}

	//Click CarrierResponseUpdate
	public void CarrierResponseUpdate(String ssn) throws InterruptedException, AWTException {
		click(ClickCloseButton);
		ExtentSuccessMessage("Clicked on Close Button");
		WaitForPageLoad();
		Thread.sleep(8000);
		click(clickManageCoverage);
		ExtentSuccessMessage("Clicked on Manage Coverage");
		WaitForPageLoad();
		WaitForPageLoad();
		click(clickCarrierResponseUpdate);
		ExtentSuccessMessage("Clicked on Carrier Response Update");
		WaitForPageLoad();
		Thread.sleep(5000);
		click(clickActionDropdown);

		click(UpdateMemberID);
		click(searchDropdown);

		click(searchSSN); // input(searchSSN, ssn);

		// Ramya:input(searchSSN, ssn);

		StringSelection stringSelection = new StringSelection(ssn);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Thread.sleep(3000);
		Paste();
		ExtentSuccessMessage("Entered SSN");
		WaitForElementToBeVisible(searchButton);
		jsClick(searchButton);
		WaitForPageLoad();
		ExtentSuccessMessage("Successfully updated CarrierResponseUpdate");
	}
	//
	//	// Click ViewCoverage
	//	public void clickViewCoverage() throws InterruptedException {
	//		WaitForPageLoad();
	//		click(clickViewCoverage);
	//		WaitForPageLoad();
	//	}
	//
	//	// Search for the Employee
	//	public void searchemployee(String ssn) throws InterruptedException {
	//		WaitForPageLoad();
	//		click(txtKeywordSearch);
	//		input(txtKeywordSearch, ssn);
	//		click(btnKeywordSearch);
	//		WaitForPageLoad();
	//		Thread.sleep(8000);
	//		click(clickName);
	//		Thread.sleep(5000);
	//	}

	//	//Search for the Employee
	//	public void searchEmployee(String ssn) throws InterruptedException {
	//		try {
	//			WaitForPageLoad();
	//			Thread.sleep(8000);
	//			click(clickManageCoverage);
	//			WaitForPageLoad();
	//			WaitForPageLoad();
	//			click(clickViewCoverage);
	//			WaitForPageLoad();
	//			WaitForPageLoad();
	//			click(txtKeywordSearch);
	//			input(txtKeywordSearch, ssn);
	//			click(btnKeywordSearch);
	//			WaitForPageLoad();
	//			Thread.sleep(8000);
	//			click(clickName);
	//			Thread.sleep(5000);
	//			ExtentSuccessMessage("Successfully searched employee");
	//		} catch (Exception e) {
	//			ExtentErrorMessage("Unable to search employee with SSN");
	//		}
	//
	//	}
	//
	//	// Select Action Dropdown
	//	public void updateMemberID() throws InterruptedException {
	//		click(clickActionDropdown);
	//		click(UpdateMemberID);
	//	}
	//
	//	// Select Action Dropdown
	//	public void UpdateSuccessResponse() throws InterruptedException {
	//		click(clickActionDropdown);
	//		click(UpdateSuccessResponse);
	//	}
	//
	//	//UpdateSuccessResponse
	//	public void UpdateSuccessResponse(String ssn) throws InterruptedException {
	//		WaitForPageLoad();
	//		Thread.sleep(8000);
	//		click(clickManageCoverage);
	//		WaitForPageLoad();
	//		WaitForPageLoad();
	//		click(clickCarrierResponseUpdate);
	//		WaitForPageLoad();
	//		click(clickActionDropdown);
	//		click(UpdateSuccessResponse);
	//		click(searchDropdown);
	//		click(searchSSN);
	//		input(searchSSN, ssn);
	//		WaitForElementToBeVisible(searchButton);
	//		jsClick(searchButton);
	//		WaitForPageLoad();
	//		click(clickUpdateStatus);
	//		click(clickok);
	//	}
	//
	//	// Search SSN
	//	public void searchssn(String ssn) throws InterruptedException {
	//		click(searchDropdown);
	//		click(searchSSN);
	//		input(searchSSN, ssn);
	//		WaitForElementToBeVisible(searchButton);
	//		jsClick(searchButton);
	//		WaitForPageLoad();
	//	}
	//
	// Enter MemberID
	public void enterMemberID(Map<Object, Object> testdata) throws InterruptedException {
		try {
			WaitForPageLoad();
			WaitForAJAX_ToLoad();
			ExtentSuccessMessage("Entered in to enterMemberID Method");
			// Thread.sleep(8000);
			// WaitForElementToBeVisible(typeMemberID);
			waitForElementClickable(typeMemberID);
			new Actions(driver).click().build().perform();
			input(typeMemberID, randomNumber(5) + "" + randomNumber(6));
			ExtentSuccessMessage("Entered MemberID");
			Thread.sleep(5000);
			// Thread.sleep(8000);
			click(clicksubmit);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExtentErrorMessage("Failed to enter member id");
		}
	}
	//
	//	//Enter Effective Date
	//	public void enterEffectiveDate(String date) throws InterruptedException {
	//		WaitForPageLoad();
	//		input(effectiveDate, date);
	//		findElement(effectiveDate).sendKeys(Keys.TAB);
	//	}
	//
	//	// Random Number
	//	//  public String getRandomMemberID(){ 
	//	//  	String memberID=getRandomMemberID() + "";
	//	//  	this.MemberID=memberID;
	//	//		return memberID;    
	//	//  }
	//	//    
	//	// Update Status
	//	public void updatestatus() throws InterruptedException {
	//		click(clickUpdateStatus);
	//		jsClick(clickok);
	//	}

	// Terminate Employee {terminationDate}
	public void terminateEmployee(String txtterminationDate) throws InterruptedException {
		try {	
			ExtentSuccessMessage("Entered into Terminate Employee method");
			WaitForPageLoad();
			WaitForAJAX_ToLoad();
			clickAndInput(terminationDate, txtterminationDate);
			//Thread.sleep(1000);
			//WaitForPageLoad();
			ExtentSuccessMessage("Entered terminationDate");
			selectByRandom(terminationReason);
			Thread.sleep(1000);
			ExtentSuccessMessage("Entered termination Reason");
			click(submit);
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

		// Ramya: Below code is not required for TC:28
		/*
		 * WaitForElementToBeVisible(cobraEnrollmentNo); click(cobraEnrollmentNo);
		 * click(clickContinue);
		 */
	}
	public void TerminateEmployee(String txtterminationDate) throws InterruptedException
	{
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		clickAndInput(terminationDate, txtterminationDate);
		Thread.sleep(1000);
		WaitForPageLoad();
		ExtentSuccessMessage("Entered terminationDate");
		selectByRandom(terminationReason);
		Thread.sleep(1000);
		ExtentSuccessMessage("Entered termination Reason");
		jsClick(submit);
		Thread.sleep(2000);
//		Boolean state=ElementDisplayed(L_SuccessMessage);
		WaitForElementToBeVisible(L_cobraEnrollmentNo);
		jsClick(L_cobraEnrollmentNo);
		if(ElementDisplayed(clickContinue)) {
			click(clickContinue);
		}else {
			
		}
		 //Popup is not availble now
		//return state
	}

	public boolean isEmployeeTerminationMessageDisplayed() throws InterruptedException {
		WaitForLoadAnimationDisappear();
		WaitForElementToBeVisible(successMessage);
		Boolean state = ElementDisplayed(successMessage);
		jsClick(OK);
		return state;
	}

	// Cobra Enrollment NO
	public void cobraEnrollmentNO() throws InterruptedException {
		try {
			WaitForElementToBeVisible(cobraEnrollmentNo);
			click(cobraEnrollmentNo);
			click(clickContinue);
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}