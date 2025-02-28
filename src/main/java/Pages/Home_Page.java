package Pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class Home_Page extends Base_Class {
	Base_Class Base_Class = new Base_Class();
	////////////////// Home_Page//////////////////////
	private static By userNameXpath = By.xpath("//span[@class='user']");
	private static By account_groupNameTH = By
			.xpath("//th[contains(text(),'Account Name')]|//th[contains(text(),'Group Name')]");
	private static By account_groupNumberTH = By
			.xpath("//th[contains(text(),'Account Number')]|//th[contains(text(),'Group Number')]");
	private static By txtSearchId = By.id("txtSearch");
	private static By searchButtonId = By.id("btnSearch");
	private static By statusTH = By.xpath("//th[contains(text(),'Status')]");
	private static By parentGroupNameTH = By.xpath("//th[contains(text(),'Parent Group Name')]");
	private static By groupNumberTH = By.xpath("//th[contains(text(),'Group Number')]");
	private static By TINTH = By.xpath("//th[contains(text(),'TIN')]");
	private static By phoneTH = By.xpath("//th[contains(text(),'Phone')]");
	private static By sFEntityIdTH = By.xpath("//th[contains(text(),'SF Entity ID')]");
	private static By HomePageButton = By.xpath("//ul[@id='listView']//i[@class='fa fa-home']");

	//////////////////// Communication Tab////////////////////
	//	private static By CommunicationTab = By.xpath("//*[@id=\"listView\"]/li[4]/a");
	public static By L_CommunicationTab = By.xpath("//*[text()='Communication ']");
	// CL - Correspondence Letters
	private static By clickCL = By.xpath("//span[normalize-space()='Correspondence Letters']");

	//////////////////////////// More Tab//////////////////////////////////
	public static By L_MoreTab = By.xpath("//*[contains(text(),'More')]");
	public static By L_UserAdministration = By.xpath("//*[@class='divRedirect' and @data-redirecturl='/ih/UserManagement']|//*[@class='divRedirect']//*[contains(text(),'User Administration')]|//a[contains(.,'User Administration')]");
	//public static By L_IHAUserAdministration = By.xpath("//*[@class='divRedirect' and @data-redirecturl='/ih/UserManagement']");
	public static By L_BrokerManagement = By.xpath("//*[@class='divRedirect' and @data-redirecturl='/ih/BrokerManagement/AgencyContactList']");

	///////////////////////////User Administration Under More Tab/////////////////////////////////////
	public static By L_GroupeContactUser = By.xpath("//*[contains(text(),'Group Contact Users')]");

	//	public static By L_ConfirmRegissLinkOk = By.xpath("(//*[contains(text(),'Ok')])[2]");
	public static By L_EmailLog = By.xpath("//*[contains(text(),'Email Log')]");

	////////////////////Transactions////////////////////
	public static By L_TransactionsTab = By.xpath("//span[contains(.,'Transactions')]");
	public static By L_ContentManagement = By.xpath("//*[contains(text(),' Content Management')]");
	public static By L_Pension_Authority_File_GenerationTab = By.xpath("//*[contains(text(),'Pension Authority File Generation ')]");
	public static By L_VendorACHFileGeneration = By.xpath("//*[contains(text(),' Vendor ACH File Generation')]");
	public static By L_Cash_Ledger = By.xpath("//*[contains(text(),' Cash Ledger')]");  
	public static By L_Refund_Center = By.xpath("//*[contains(text(),' Refund Center')]");
	public static By L_Accounts_Payable = By.xpath("//*[contains(text(),' Accounts Payable')]"); 
	
	public static By L_Reconciliation_Summary = By.xpath("//*[contains(text(),' Reconciliation Summary')]");  
	
	///////////////////Billing and Payments///////////////////
	public static By L_BillingPaymentTab = By.xpath("//*[contains(text(),'Billing & Payment')]");
	public static By L_AccountsReceivable = By.xpath("//span[normalize-space()='Accounts Receivable']");


	////////////////////////////////////////////////////////////////

	/// Method to validate the tenant dashboard page///
	public void ValidateTenantDashboard(String GroupName) throws InterruptedException, IOException {
		try {
			if (!URL.equalsIgnoreCase("FBMC_URL")) {
				if (!loginuser_Type.equalsIgnoreCase("BA")) {

					WaitForLoadAnimationDisappear();
					waitForElementVisible(account_groupNameTH);
					if (isaccountnameDispayed() == true) {
						Log.info("Successfully Account/Group name Visible");
						ExtentSuccessMessage("Successfully Account/Group name Visible");
					} else {
						Log.error("Account/Group name not Visible");
						ExtentErrorMessage("Account/Group name not Visible");
					}
					waitForElementVisible(statusTH);
					if (isStatusDisplayed() == true) {
						Log.info("Successfully Status Visible");
						ExtentSuccessMessage("Successfully Status Visible");
					} else {
						Log.error("Status not Visible");
						ExtentErrorMessage("Status not Visible");
					}

					if (isPhoneDisplayed() == true) {
						Log.info("Successfully Phonenumber Visible");
						ExtentSuccessMessage("Successfully Phonenumber Visible");
					} else {
						Log.error("Phonenumber number not Visible");
						ExtentErrorMessage("Phonenumber number not Visible");
					}
					if (isTINDisplayed() == true) {
						Log.info("Successfully TIN Visible");
						ExtentSuccessMessage("Successfully TIN Visible");
					} else {
						Log.error("TIN not Visible");
						ExtentErrorMessage("TIN not Visible");
					}
					if (isAccountNumberDisplayed() == true) {
						Log.info("Successfully Account/Group Number Visible");
						ExtentSuccessMessage("Successfully Account/Group Number Visible");
					} else {
						Log.error("Account/Group number not Visible");
						ExtentErrorMessage("Account/Group number not Visible");
					}
				} else {
					Log.info("Tenant Dashboard is not applicable for Logged in User");
					ExtentSuccessMessage("Tenant Dashboard is not applicable for Logged in User");
				}
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

//	public static String getLoggedInUserName() throws InterruptedException {
//		return GetElementText(userNameXpath).trim();
//	}

	public static String getLoggedInUserName() throws InterruptedException 
	{
		String rawUsername = GetElementText(userNameXpath).trim();  
		System.out.println("rawUsername::" +rawUsername);
		//String modifiedUsername = rawUsername.replaceAll("\\s", "").toLowerCase();  
		return rawUsername; 
	}
	
	
	public static boolean isaccountnameDispayed() throws InterruptedException {
		return ElementDisplayed(account_groupNameTH);
	}

	public static boolean isStatusDisplayed() throws InterruptedException {
		return ElementDisplayed(statusTH);
	}

	public static boolean isGroupNameDisplayed() throws InterruptedException {
		return ElementDisplayed(groupNumberTH);
	}

	public static boolean isParentGroupNameDisplayed() throws InterruptedException {
		return ElementDisplayed(parentGroupNameTH);
	}

	public static boolean isGroupNumberDisplayed() throws InterruptedException {
		return ElementDisplayed(groupNumberTH);
	}

	public static boolean isPhoneDisplayed() throws InterruptedException {
		return ElementDisplayed(phoneTH);
	}

	public static boolean isTINDisplayed() throws InterruptedException {
		return ElementDisplayed(TINTH);
	}

	public static boolean isSFEntityIDDisplayed() throws InterruptedException {
		return ElementDisplayed(sFEntityIdTH);
	}

	public static boolean isAccountNumberDisplayed() throws InterruptedException {
		return ElementDisplayed(account_groupNumberTH);
	}

	/// This method will select Groupname from Homepage///
	public void SelectGroupname(String GroupName) throws InterruptedException {
		try {
			Thread.sleep(8000);
			// Condition to pick the flow as per user
			if (!loginuser_Type.equalsIgnoreCase("BA")) {
				input(txtSearchId, GroupName);
				WaitForLoadAnimationDisappear();
				WaitForPageLoad();
				click(searchButtonId);
				Log.info("Successfully Searched the Group Name");
				ExtentSuccessMessage("Successfully Searched the Group Name");
				WaitForLoadAnimationDisappear();
				By groupGridXpath = By.xpath("//span[text()='" + GroupName + "']/ancestor::a");
				WaitForPageLoad();
				click(groupGridXpath);
				Log.info("Successfully clicked on the Group Name");
				ExtentSuccessMessage("Successfully clicked on the Group Name");
			}
		} catch (Exception e) {
			ExtentErrorMessage("Unable to select group name " + e.getMessage());
		}
	}

	/// "Check Communication Tab Exist"///
	public void checkCommunicationTabExist() throws InterruptedException {
		try {
			WaitForPageLoad();
			if (!ElementDisplayed(L_CommunicationTab)) {
				Log.error("Communication Tab don't display");
				ExtentErrorMessage("Communication Tab don't display");
			} else {
				Log.info("Communication tab displayed");
				ExtentSuccessMessage("Communication tab displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}




	/// "Click on Communication Tab in Tenant Dashboard page"///
	public void clickCommunicationTab() throws InterruptedException {
		try {
			Thread.sleep(3000);
			WaitForPageLoad();
			if (ElementDisplayed(L_CommunicationTab)) {
				Log.info("Communication Header is displayed");
				waitForElementClickable(L_CommunicationTab);
				click(L_CommunicationTab);
				Log.info("Successfully clicked the Communication Tab");
				ExtentSuccessMessage("Successfully clicked the Communication Tab");
			} else {
				Log.error("Communication Header is not displayed");
				ExtentErrorMessage("Communication Header is not displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public void  CheckBillingPaymentTab() throws InterruptedException {
		try {
			WaitForPageLoad();
			if (ElementDisplayed(L_BillingPaymentTab)) {
				Log.info("BillingPaymentTab Tab display");
				ExtentSuccessMessage("BillingPaymentTab Tab display");
			} else {
				Log.error("BillingPaymentTab tab don't displayed");
				ExtentErrorMessage("BillingPaymentTab tab don't displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void  CheckBillingPaymentTabNotDispaly() throws InterruptedException {
		try {
			WaitForPageLoad();
			if (!ElementDisplayed(L_BillingPaymentTab)) {
				Log.info("BillingPaymentTab Tab don't display");
				ExtentSuccessMessage("BillingPaymentTab Tab don't display");
			} else {
				Log.error("BillingPaymentTab tab should not displayed");
				ExtentErrorMessage("BillingPaymentTab should not displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	public void CheckCommunicationTabNotDispaly() throws InterruptedException {
		try {
			WaitForPageLoad();
			if (!ElementDisplayed(L_CommunicationTab)) {
				Log.info("CommunicationTab don't display");
				ExtentSuccessMessage("CommunicationTab  don't display");
			} else {
				Log.error("CommunicationTab  should not displayed");
				ExtentErrorMessage("CommunicationTab should not displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	/// ("Click Correspondence Letters under Communication Tab")///
	public void clickCorrespondenceLetters() throws InterruptedException {
		try {
			WaitForPageLoad();
			if (ElementDisplayed(clickCL)) {
				Log.info("Correspondance Letters is displayed");
				Thread.sleep(8000);
				MouseHoverOnElement(clickCL);
				WaitForElementToBeVisible(clickCL);
				jsClick(clickCL);
				ExtentSuccessMessage("Successfully clicked the CC Letters button ");
			} else {
				Log.error("Correspondance Letters is not displayed");
				ExtentErrorMessage("Correspondance Letters is not displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickHomePage() throws InterruptedException {
		try {
			WaitForPageLoad();
			if (ElementDisplayed(HomePageButton)) {
				Log.info("Home Page is displayed");
				WaitForPageLoad();
				MouseHoverOnElement(HomePageButton);
				jsClick(HomePageButton);
				ExtentSuccessMessage("Successfully clicked the Home Page button ");
				WaitForLoadAnimationDisappear();
			} else {
				Log.error("Home Page is not displayed");
				ExtentErrorMessage("Home Page is not displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public void ClickOnMoreTab() throws InterruptedException{
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_MoreTab)) {
				Log.info("Successfully Visible More Tab");
				Thread.sleep(3000);
				click(L_MoreTab);
				Log.info("Successfully Clicked On  More Tab");
				ExtentSuccessMessage("Successfully Clicked On  More Tab");


			}else {
				Log.error("UnSuccessfully Not Visible More Tab");
				ExtentErrorMessage("UnSuccessfully Not Visible More Tab");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void ClickOnUserAdministration() throws InterruptedException {
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_UserAdministration)) {
				Log.info("Successfully Visible Under  More Tab User Administration");
				Thread.sleep(2000);
				click(L_UserAdministration);
				Log.info("Successfully Clicked Under  More Tab User Administration ");
				ExtentSuccessMessage("Successfully Clicked Under  More Tab User Administration ");
			}else {
				Log.error("UnSuccessfully Not Visible Under  More Tab User Administration ");
				ExtentErrorMessage("UnSuccessfully Not Visible Under  More Tab User Administration ");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	/*
	 * public void ClickOnIHAUserAdministration() throws InterruptedException {
	 * WaitForPageLoad(); if(ElementDisplayed(L_IHAUserAdministration)) {
	 * Log.info("Successfully Visible Under  More Tab User Administration");
	 * Thread.sleep(2000); click(L_UserAdministration);
	 * Log.info("Successfully Clicked Under  More Tab User Administration ");
	 * ExtentSuccessMessage("Successfully Clicked Under  More Tab User Administration "
	 * ); }else {
	 * Log.error("UnSuccessfully Not Visible Under  More Tab User Administration ");
	 * ExtentErrorMessage("UnSuccessfully Not Visible Under  More Tab User Administration "
	 * ); } }
	 */
	public void ClickOnGroupeContactUser() throws InterruptedException{
		WaitForPageLoad();
		if(ElementDisplayed(L_GroupeContactUser)) {
			Log.info("Successfully Visible Groupe Contact User Button");
			click(L_GroupeContactUser);
			Log.info("Successfully Clicked On  Groupe Contact User Button");
			ExtentSuccessMessage("Successfully Clicked On Groupe Contact User Button");
		}else {
			Log.error("UnSuccessfully Not Visible Groupe Contact User Button");
			ExtentErrorMessage("UnSuccessfully Not Visible Groupe Contact User Button");
		}
	}


	public void ClickOnEmailLog() throws InterruptedException{
		WaitForLoadAnimationDisappear();
		if(ElementDisplayed(L_EmailLog)) {
			Log.info("Successfully Visible Email Log");
			//Thread.sleep(2000);
			MouseHoverOnElement(L_EmailLog);
			click(L_EmailLog);
			WaitForLoadAnimationDisappear();
			Log.info("Successfully Clicked On Email Log");
			ExtentSuccessMessage("Successfully Clicked On Email Log");
			RefreshPage();
			WaitForPageLoad();
		}else {
			Log.error("UnSuccessfully Not Visible Email Log");
			ExtentErrorMessage("UnSuccessfully Not Visible Email Log");
		}
	}

	/////Transactions Tab/////
	public void clickTransactionsTab() throws InterruptedException 
	{	
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_TransactionsTab))
			{ 
				Log.info("Transactions Tab is displayed");
				WaitForPageLoad();
				waitForElementClickable(L_TransactionsTab);
				jsClick(L_TransactionsTab);
				ExtentSuccessMessage("Successfully clicked the Transactions Tab");
			} 
			else 
			{
				Log.error("Transactions Tab is not displayed");
				ExtentErrorMessage("Transactions Tab is not displayed");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void ClickOnBrokerManagement() throws InterruptedException {
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_BrokerManagement)) {
				Log.info("Broker Management is successfully visible Under  More Tab");
				Thread.sleep(2000);
				click(L_BrokerManagement);
				Log.info("Broker Management is successfully clicked Under  More Tab");
				ExtentSuccessMessage("Broker Management is successfully clicked Under  More Tab");
				Thread.sleep(4000);
			}else {
				Log.error("Broker Management is ussuccessfully not clicked Under  More Tab");
				ExtentErrorMessage("Broker Management is ussuccessfully not clicked Under  More Tab");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void  CheckContentManagementTabDispaly() throws InterruptedException {
		try {
			WaitForPageLoad();
			Thread.sleep(8000);
			if (ElementDisplayed(L_ContentManagement)) {
				Log.info("Content Management Tab is displayed");
				click(L_ContentManagement);
				Log.info("Clicked on Content Management Tab");
				ExtentSuccessMessage("Clicked on Content Management Tab");
			} else {
				Log.error("Content Management tab should not displayed");
				ExtentErrorMessage("Content Management should not displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Click on Billing and Payments
	public void ClickOnBillingAndPayments() throws InterruptedException{
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_BillingPaymentTab)) {
				Log.info("Successfully Visible More Tab");
				Thread.sleep(3000);
				click(L_BillingPaymentTab);
				Log.info("Successfully Clicked On  More Tab");
				ExtentSuccessMessage("Successfully Clicked On  More Tab");
	
	
			}else {
				Log.error("UnSuccessfully Not Visible More Tab");
				ExtentErrorMessage("UnSuccessfully Not Visible More Tab");
			}
		} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
	
	//Click ON Accounts Receivable
	public void clickAccountsReceivable() throws InterruptedException {
	try {
		WaitForPageLoad();
		if (ElementDisplayed(L_AccountsReceivable)) {
			Log.info("Accounts Receivable is displayed");
			Thread.sleep(8000);
			MouseHoverOnElement(L_AccountsReceivable);
			WaitForElementToBeVisible(L_AccountsReceivable);
			jsClick(L_AccountsReceivable);
			ExtentSuccessMessage("Successfully clicked the Accounts Receivable ");
		} else {
			Log.error("Accounts Receivable is not displayed");
			ExtentErrorMessage("Accounts Receivable is not displayed");
		}
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
  }

	public void ClickOnBillingPaymentTab() throws InterruptedException {
		if(ElementDisplayed(L_BillingPaymentTab)) {
			Log.info("Billing Payment Tab is displayed");
			click(L_BillingPaymentTab);
			Log.info("Clicked on Billing Payment Tab");
			ExtentSuccessMessage("Clicked on Billing Payment Tab");
		} else {
			Log.error("Billing Payment tab not displayed");
			ExtentErrorMessage("Billing Payment Tab not displayed");
		}
	}
	public void ClickOnPension_Authority_File_GenerationTab() throws InterruptedException {

		if(ElementDisplayed(L_Pension_Authority_File_GenerationTab)) {
			Log.info("Pension_Authority_File_Generation Tab is displayed");
			click(L_Pension_Authority_File_GenerationTab);
			Log.info("Clicked on Pension_Authority_File_Generation Tab");
			ExtentSuccessMessage("Clicked on Pension_Authority_File_Generation Tab");
		} else {
			Log.error("Pension_Authority_File_Generation tab not displayed");
			ExtentErrorMessage("Pension_Authority_File_Generation Tab not displayed");
		}
	}

	public void ClickOnVendorACHFileGenerationTab() throws InterruptedException {
		if(ElementDisplayed(L_VendorACHFileGeneration)) {
			Log.info(" Vendor ACH File Generation  Tab is displayed");
			click(L_VendorACHFileGeneration);
			Log.info("Clicked on  Vendor ACH File Generation  Tab");
			ExtentSuccessMessage("Clicked on  Vendor ACH File Generation  Tab");
			By xpath = By.xpath("//*[@class='title_area']//h4");
			if(ElementDisplayed(xpath)) {
				WebElement TitleElement =driver.findElement(xpath);
				String Title = TitleElement.getText();
				System.out.println("Title:- "+Title);
				assertEquals(Title,"Vendor ACH File Generation");
				Log.info("Successfully landed on  Vendor ACH File Generation Tab");
				ExtentSuccessMessage("Successfully landed on  Vendor ACH File Generation Tab");
			}
		} else {
			Log.error(" Vendor ACH File Generation  tab not displayed");
			ExtentErrorMessage(" Vendor ACH File Generation  Tab not displayed");
		}
	}
	public void ClickOnReconciliation_SummaryTab() throws InterruptedException {
		if(ElementDisplayed(L_Reconciliation_Summary)) {
			Log.info("Reconciliation_Summary Tab is displayed");
			click(L_Reconciliation_Summary);
			Log.info("Clicked on Reconciliation_Summary  Tab");
			ExtentSuccessMessage("Clicked on Reconciliation_Summary  Tab");
			By xpath = By.xpath("//*[@class='title_area']//h4");
			if(ElementDisplayed(xpath)) {
				WebElement TitleElement =driver.findElement(xpath);
				String Title = TitleElement.getText();
				assertEquals(Title,"Billing & Payment - Reconciliation Summary");
				Log.info("Successfully landed on Reconciliation_Summary Tab");
				ExtentSuccessMessage("Successfully landed on Reconciliation_Summary Tab");
			}
		} else {
			Log.error(" Reconciliation_Summary  tab not displayed");
			ExtentErrorMessage(" Reconciliation_Summary  Tab not displayed");
		}
	}
	
	public void ClickOnCash_LedgerTab() throws InterruptedException {
		if(ElementDisplayed(L_Cash_Ledger)) {
			Log.info(" Billing & Payment - Cash Ledger Tab is displayed");
			click(L_Cash_Ledger);
			Log.info("Clicked on  Billing & Payment - Cash Ledger  Tab");
			ExtentSuccessMessage("Clicked on  Billing & Payment - Cash Ledger  Tab");
			By xpath = By.xpath("//*[@class='title_area']//h4");
			if(ElementDisplayed(xpath)) {
				WebElement TitleElement =driver.findElement(xpath);
				String Title = TitleElement.getText();
				assertEquals(Title,"Billing & Payment - Cash Ledger");
				Log.info("Successfully landed on  Billing & Payment - Cash Ledger Tab");
				ExtentSuccessMessage("Successfully landed on  Billing & Payment - Cash Ledger Tab");
			}
		} else {
			Log.error("  Billing & Payment - Cash Ledger  tab not displayed");
			ExtentErrorMessage("  Billing & Payment - Cash Ledger  Tab not displayed");
		}
	}
	
	public void ClickOnRefund_CenterTab() throws InterruptedException {
		if(ElementDisplayed(L_Refund_Center)) {
			Log.info(" Refund_Center Tab is displayed");
			click(L_Refund_Center);
			Log.info("Clicked on  Refund_Center  Tab");
			ExtentSuccessMessage("Clicked on  Refund_Center Tab");
		} else {
			Log.error(" Refund_Center tab not displayed");
			ExtentErrorMessage(" Refund_Center Tab not displayed");
		}
	}

	public void ClickOnAccounts_PayableTab() throws InterruptedException {
		if(ElementDisplayed(L_Accounts_Payable)) {
			Log.info(" Accounts_Payable Tab is displayed");
			click(L_Accounts_Payable);
			Log.info("Clicked on  Accounts_Payable  Tab");
			ExtentSuccessMessage("Clicked on  Accounts_Payable Tab");
			By xpath = By.xpath("//*[@class='title_area']//h4");
			if(ElementDisplayed(xpath)) {
				WebElement TitleElement =driver.findElement(xpath);
				String Title = TitleElement.getText();
				assertEquals(Title,"Accounts Payable");
				Log.info("Successfully landed on Accounts Payable  Tab");
				ExtentSuccessMessage("Successfully landed on Accounts Payable  Tab");
			}
		} else {
			Log.error(" Accounts_Payable tab not displayed");
			ExtentErrorMessage(" Accounts_Payable Tab not displayed");
		}
	}
	
	
	public void NavigateToPension_Authority_File_GenerationTab() throws InterruptedException {
		ClickOnBillingPaymentTab();
		ClickOnPension_Authority_File_GenerationTab();

	}
	public void NavigateToVendorACHFileGenerationTab() throws InterruptedException {
		ClickOnBillingPaymentTab();
		ClickOnVendorACHFileGenerationTab();

	}
	public void NavigateToReconciliation_SummaryTab() throws InterruptedException {
		ClickOnBillingPaymentTab();
		ClickOnReconciliation_SummaryTab();

	}
	
	public void NavigateToRefund_CenterTab() throws InterruptedException {
		ClickOnBillingPaymentTab();
		ClickOnRefund_CenterTab();

	}

	public void NavigateToCash_LedgerTab() throws InterruptedException {
		ClickOnBillingPaymentTab();
		ClickOnCash_LedgerTab();

	}
	
	public void NavigateToAccounts_PayableTab() throws InterruptedException {
		ClickOnBillingPaymentTab();
		ClickOnAccounts_PayableTab();

	}

}


