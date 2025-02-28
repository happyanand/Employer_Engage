package Pages;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;

public class GroupDashboard_Page extends Base_Class {
	private static By employeeAdministrationXpath = By.xpath(
			"//h5[contains(text(),' Employee Administration ')]/ancestor::a|//h5[normalize-space()='Employee Administration']");
	private static By groupInformationXpath = By.xpath("//h5[contains(text(),' Group Information ')]/ancestor::a | //*[contains(text(),'Group Administration')]/ancestor::a");
	private static By L_groupInformationXpathBA = By
			.xpath("//h5[contains(text(),'Group Administration')]//parent::div");
	private static By manageCoverageXpath = By.xpath("//h5[contains(text(),'Manage Coverage')]/ancestor::a");
	private static By L_manageCoverageXpathBA = By.xpath("//h5[contains(text(),'Manage Coverage')]//parent::div");
	private static By renewalCenterXpath = By.xpath("//h5[contains(text(),'Renewal Center')]/ancestor::a");
	private static By reportsXpath = By.xpath("//h5[contains(text(),'Reports ')]/ancestor::a|//span[normalize-space()='Reports']");
	private static By benefitsInformationDDXpath = By.xpath("//span[text()=' Benefits Information ']/parent::a");
	private static By administrationXpath = By.xpath("//a[text()='Administration ']");
	public static By L_MemberSearchInPutfield1 = By.id("btnKeyWordSearch1");
	public static By L_MemberSearchInPutfield = By.id("divMemberSearch");

	public static By L_SearchIcon = By.xpath("(//*[text()='search'])[3]");
	private static By employeeAdministrationDDXpath = By.xpath("//span[text()=' Employee Administration ']/parent::a");
	private static By L_employeeAdministrationBA = By
			.xpath("//h5[contains(text(),'Employee Administration')]//parent::div");
	private static By groupInformationDDXpath = By.xpath("//span[text()=' Group Information ']/parent::a");
	private static By manageCoverageHeader = By.xpath("//a[text()='Manage Coverage ']");
	private static By viewCoverageDDXpath = By.xpath("//span[text()=' View Coverage ']/parent::a");
	private static By renewalDDXpath = By.xpath("//span[text()=' Renewal ']/parent::a");
	private static By reportsHeaderXpath = By.xpath("//span[text()=' Reports ']/parent::a");
	private static By commentsRoasterHeaderXpath = By.xpath("//span[text()=' Comments Roster ']/parent::a");
	private static By reviewEmployeeTransactions = By
			.xpath("//h5[contains(text(),'Review Employee Transactions')]/ancestor::a");
	private static By carrierResponseUpdate = By.xpath("//h5[contains(text(),'Carrier Response Update')]/ancestor::a");
	private static By review = By.xpath("//span[text()=' Review ']/parent::a");
	private static By carrierResponseUpdateDD = By.xpath("//span[text()=' Carrier Response Update ']/parent::a");

	private static By groupLink = By.xpath("//a[@class='divRedirect breadcrumbLink']");
	private static By reporting = By.xpath("//h5[contains(text(),'Report')]");
	private static By billingandpayment = By.xpath("//h5[normalize-space()='Billing & Payment']");

	// Support User Login
	public static By click_More = By.xpath("//a[normalize-space()='More']");
	public static By support_user = By.xpath("//span[normalize-space()='Support User']");
	public static By txt_search = By.xpath("//input[@id='txtSearch']");
	public static By btn_search = By
			.xpath("//span[@id='btnSearch']//i[@class='material-icons'][normalize-space()='search']");
	public static By lnk_login = By.xpath("//a[@aria-label='Login']");
	public static By icon_Home = By.xpath("//ul[@id='listView']//i[@class='fa fa-home']");
	private static By clickMyCoverage = By.xpath("//h5[normalize-space()='My Coverage']|//span[normalize-space()='My Coverage']");
	private static By L_clickAdvancesearch = By.xpath("//a[@type='button']//i[@class='fa fa-angle-down']");
	private static By L_firstname = By.xpath("//*[@id='collapse002']/div/div[1]/div[1]/div/input");
	private static By L_selectrole = By.xpath("//select[@class='select']");
	private static By L_groupname = By.xpath("//*[@id='collapse002']/div/div[2]/div[3]/div/input");
	private static By L_search_icon = By.xpath("//input[@id='idSearch']");
	private static By L_navigation = By.xpath("//a[@id='Navigation']");		
	private static By L_header = By.xpath("//p[normalize-space()='Header']");		
	private static By L_richtext = By.xpath("//p[normalize-space()='Rich Text']");		
	private static By L_contentmanagement = By.xpath("//div[normalize-space()='Content Management']");		



	// Review Employee Transactions
	public static By btn_ReviewEmployee = By.xpath("//h5[normalize-space()='Review Employee Transactions']");
	private static By Reporting = By.xpath("//h5[contains(text(),'Reporting')]/ancestor::a");
	public static By txt_searchSSN=By.xpath("//form[@id='form0']//input[@id='KeyWordSearch']");
	public static By icon_search=By.xpath("//i[@class='fa fa-search']");
	public static By click_Name=By.xpath("//li[@class='name theme-text']");
	//    public static By btn_submit=By.xpath("//input[@id='ancillarySubmit']");
	//	public static By click_Name = By.xpath("//a[1]//div[1]//div[1]//div[1]//ul[1]//li[1]");
	public static By btn_submit = By
			.xpath("//input[@id='maintananceSubmit']|//input[@id='ancillarySubmit']|//input[@id='medicalSubmit']");
	public static By btn_ok = By.xpath("//input[@id='btnWarningOk']|//input[@id='abtnWarningOk']");

	public static By btn_newEnrollment = By.xpath("//h5[contains(text(),'Open Enrollment -')]");

	// Logout
	public static By L_user = By.xpath("//li/a/span[@class='user']");
	public static By L_Logout = By.xpath("//*[@class='divRedirect'][contains(@data-redirecturl,'Logout')]");
	private static By L_Logout1 = By.xpath("//*[text()=' Logout']/i");

	private static By accountAdministrationXpath = By.xpath(
			"//h5[contains(text(), 'Account Administration')]");

	// All the links related Group are displayed
	public Boolean isAllGroupLinksDisplayed() throws InterruptedException {
		WaitForPageLoad();
		return ElementDisplayed(employeeAdministrationXpath) && ElementDisplayed(manageCoverageXpath)
				&& ElementDisplayed(groupInformationXpath) && ElementDisplayed(renewalCenterXpath)
				&& ElementDisplayed(reportsXpath);
	}

	// Click on the Employee Administration
	public void clickEmployeeAdministration() throws InterruptedException {
		try {
			WaitForPageLoad();
			if (loginuser_Type.equalsIgnoreCase("Admin")) {
				jsClick(employeeAdministrationXpath);
				WaitForPageLoad();
				Log.info("Successfully Clicked on 'Employee_Administration'");
				ExtentSuccessMessage("Successfully Clicked on 'Employee_Administration' ");
			}
			if (loginuser_Type.equalsIgnoreCase("BA")) {
				MouseHoverOnElement(L_employeeAdministrationBA);
				click(L_employeeAdministrationBA);
				Log.info("Successfully Clicked on 'Employee_Administration'BA Role ");
				ExtentSuccessMessage("Successfully Clicked on 'Employee_Administration'BA Role ");
				Thread.sleep(5000);


			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

	// Click on the Manage Coverage
	public void clickManageCoverage() throws InterruptedException {
		try {
			WaitForPageLoad();
			if (loginuser_Type.equalsIgnoreCase("Admin")) {
				click(manageCoverageXpath);
				ExtentSuccessMessage("Successfully Clicked on 'Manage Coverage' ");
			}
			if (loginuser_Type.equalsIgnoreCase("BA")) {
				MouseHoverOnElement(L_manageCoverageXpathBA);
				click(L_manageCoverageXpathBA);
				Log.info("Successfully Clicked on 'Manage Coverage BA Role ");
				ExtentSuccessMessage("Successfully Clicked on 'Manage Coverage BA Role ");
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on the Group Information
	public void clickGroupInformation() throws InterruptedException {
		try {
			WaitForPageLoad();
			if (loginuser_Type.equalsIgnoreCase("Admin")) {
				click(groupInformationXpath);
				ExtentSuccessMessage("Successfully Clicked on 'group Information' ");
			}
			if (loginuser_Type.equalsIgnoreCase("BA")) {
				MouseHoverOnElement(L_groupInformationXpathBA);
				click(L_groupInformationXpathBA);
				Log.info("Successfully Clicked on 'group Information BA Role ");
				ExtentSuccessMessage("Successfully Clicked on 'group Information BA Role ");
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			ExtentErrorMessage("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on the Renewal Center
	public void clickRenewalCenter() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(renewalCenterXpath);
			ExtentSuccessMessage("Successfully Clicked on 'renewal Center ' ");

		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on the Reports
	public void clickReports() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(reportsXpath);
			ExtentSuccessMessage("Successfully clicked on reports");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void ClickonReorting() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(Reporting);
			ExtentSuccessMessage("Successfully Clicked on 'Reporting ' ");

		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void EnterEmployeeNameMemberSearchInPutfield(String Value) throws InterruptedException {
		WaitForPageLoad();
		Thread.sleep(3000);
		if(ElementDisplayed(L_MemberSearchInPutfield)) {
			Log.info("Successfully Visible Search Field");
			click(L_MemberSearchInPutfield);
			input(L_MemberSearchInPutfield1,Value);
			Log.info("Successfully Enter value in Search Field");
			ExtentSuccessMessage("Successfully Enter value in Search Field");
		}else {
			Log.error("UnSuccessfully Not Visible Search Field");
			ExtentErrorMessage("UnSuccessfully Not Visible Search Field");
		}
	}




	public void ClickOnSearchIcon() throws InterruptedException{
		WaitForPageLoad();
		if(ElementDisplayed(L_SearchIcon)) {
			Log.info("Successfully Visible Search Icon");
			click(L_SearchIcon);
			Log.info("Successfully Clicked On Search Icon");
			ExtentSuccessMessage("Successfully Clicked On Search Icon");
		}else {
			Log.error("UnSuccessfully Not Visible Search Icon");
			ExtentErrorMessage("UnSuccessfully Not Visible Search Icon");
		}
	}

	// Click on the Employee Administration from menu
	public void clickEmployeeAdministrationOnHeader() throws InterruptedException {
		try {
			WaitForPageLoad();
			MouseHoverOnElement(administrationXpath);
			click(employeeAdministrationDDXpath);
			ExtentSuccessMessage("Successfully clicked on employeeAdministration from Menu");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on the Group Information from menu
	public void clickGroupInformationOnHeader() throws InterruptedException {
		try {
			WaitForPageLoad();
			MouseHoverOnElement(administrationXpath);
			click(groupInformationDDXpath);
			ExtentSuccessMessage("Successfully clicked on groupInformation from Menu");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on the Benefits Information from menu
	public void clickBenefitsInformationOnHeader() throws InterruptedException {
		try {
			WaitForPageLoad();
			MouseHoverOnElement(administrationXpath);
			jsClick(benefitsInformationDDXpath);
			ExtentSuccessMessage("Successfully clicked on benefitsInformation from Menu");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on the View Coverage from menu
	public void clickViewCoverageOnHeader() throws InterruptedException {
		try {
			WaitForPageLoad();
			MouseHoverOnElement(manageCoverageHeader);
			click(viewCoverageDDXpath);
			ExtentSuccessMessage("Successfully clicked on benefitsInformation from Menu");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on the Renewal from menu
	public void clickRenewalOnHeader() throws InterruptedException {
		try {
			WaitForPageLoad();
			MouseHoverOnElement(manageCoverageXpath);
			jsClick(renewalDDXpath);
			ExtentSuccessMessage("Successfully clicked on renewel from Menu");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on the Reports from Header
	public void clickReportsOnHeader() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(reportsHeaderXpath);
			ExtentSuccessMessage("Successfully clicked on reports from Menu");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on the Comment Roaster from Header
	public void clickCommentRoaster() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(commentsRoasterHeaderXpath);
			ExtentSuccessMessage("Successfully clicked on commentsRoaster from Menu");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Navigate to the Group Dashboard//
	public void navigateToGroupDashboard() {
		try {
			WaitForPageLoad();
			waitForElementClickable(groupLink);
			jsClick(groupLink);
			ExtentSuccessMessage("Successfully navigated to Group Dashboard");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to navigate to Group dashboard " + e.getMessage());
		}
	}

	// Navigate to the Review Employee Transactions
	public void navigateToReviewEmployeeTransactions() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(reviewEmployeeTransactions);
			ExtentSuccessMessage("Successfully clicked on reviewEmployeeTransactions");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Navigate to the Review Employee Transactions
	public void navigateToReviewOnHeader() throws InterruptedException {
		try {
			WaitForPageLoad();
			MouseHoverOnElement(manageCoverageHeader);
			click(review);
			ExtentSuccessMessage("Successfully clicked on review from Menu");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Navigate to the Carrier Response Update
	public void navigateToCarrierResponseUpdate() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(carrierResponseUpdate);
			ExtentSuccessMessage("Successfully clicked on carrierResponseUpdate");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Navigate to the Carrier Response Update on Header
	public void navigateToCarrierResponseUpdateOnHeader() throws InterruptedException {
		try {
			WaitForPageLoad();
			MouseHoverOnElement(manageCoverageHeader);
			click(carrierResponseUpdateDD);
			ExtentSuccessMessage("Successfully clicked on carrierResponseUpdate from Menu");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Navigate to the Reporting
	public void clickReporting() throws InterruptedException {
		try {
			click(reporting);
			ExtentSuccessMessage("Successfully clicked on carrierResponseUpdate from Menu");

		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click Home
	public void click_Home() throws InterruptedException {
		try {
			click(icon_Home);
			ExtentSuccessMessage("Successfully clicked on carrierResponseUpdate from Menu");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click More
	public void clickMore() throws InterruptedException {
		try {
			MouseHoverOnElement(click_More);
			click(click_More);
			ExtentSuccessMessage("Successfully clicked on More");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Support User Login
	public void supportUserLogin() throws InterruptedException {
		try {
			WaitForPageLoad();
			MouseHoverOnElement(support_user);
			jsClick(support_user);
			ExtentSuccessMessage("Successfully clicked on SupportUser");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}	

	//Search with Advance
	public void advancesearch(Map<Object, Object> testdata) throws InterruptedException {
		WaitForPageLoad();
		try {
			click(L_clickAdvancesearch);
			click(L_firstname);
			input(L_firstname,testdata.get("Name").toString());
			ExtentSuccessMessage("Successfully Clicked on Advance Search");
			SelectDropDownValue(L_selectrole, testdata.get("ExternalRole").toString()); //made changes here as it was hardcoded
			ExtentSuccessMessage("Successfully Selected External Role");
			if(testdata.get("Account")!= "") {
				click(L_groupname);
				input(L_groupname,testdata.get("Account").toString());
				ExtentSuccessMessage("Successfully Entered Group Name");
			}
			click(L_search_icon);	
			WaitForPageLoad();
			click(lnk_login);
			WaitForPageLoad();
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}	
	//Search with Advance IHA
	public void advancesearchIHA(Map<Object, Object> testdata) throws InterruptedException {
		WaitForPageLoad();
		try {
			click(L_clickAdvancesearch);
//			click(L_firstname);
//			input(L_firstname,testdata.get("Name").toString());
			ExtentSuccessMessage("Successfully Clicked on Advance Search");
			SelectDropDownValue(L_selectrole, testdata.get("ExternalRole").toString()); //made changes here as it was hardcoded
			ExtentSuccessMessage("Successfully Selected External Role");
			if(testdata.get("Account")!= "") {
				click(L_groupname);
				input(L_groupname,testdata.get("Account").toString());
				ExtentSuccessMessage("Successfully Entered Group Name");
			}
			click(L_search_icon);	
			WaitForPageLoad();
			click(lnk_login);
			WaitForPageLoad();
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}	
	//Verify the page changes
	public void verifypages() throws InterruptedException {
		try {
			scrollDown();
			if(ElementDisplayed(L_navigation)) {
				ExtentSuccessMessage("Successfully Verifyed Page Changes");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Validate Header Text
	public void validateHeader() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(L_header)) {
				ExtentSuccessMessage("Successfully displayed Header Text");
			}} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	//Validate Rich Text
	public void validateRichtext() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(L_richtext)) {
				ExtentSuccessMessage("Successfully displayed Rich Text");
			}} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	//Validate Link Title
	public void validateLinkTitle() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(L_contentmanagement)) {
				ExtentSuccessMessage("Successfully displayed Link Titlte");
			}} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}


	//Support User Login
	public void SupportUserLogin(String name) throws InterruptedException {
		try {
			WaitForLoadAnimationDisappear();
			MouseHoverOnElement(support_user);
			click(support_user);
			ExtentSuccessMessage("Successfully clicked on SupportUser");
			click(txt_search);
			input(txt_search, name);
			click(btn_search);
			click(lnk_login);
			// RefreshPage();
			ExtentSuccessMessage("Successfully clicked on Login");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Review Employee Transactions
	public void ReviewEmployeeTransactions(String name) throws InterruptedException {
		try {
			click(btn_ReviewEmployee);
			click(txt_searchSSN);
			input(txt_searchSSN,name);
			Thread.sleep(2000);
			click(icon_search);
			//Thread.sleep(15000);
			WaitForLoadAnimationDisappear();
			waitForElementsVisible(click_Name);
			click(click_Name);
			Thread.sleep(5000);
			click(btn_submit);
			Thread.sleep(3000);
			click(btn_ok);
			Thread.sleep(3000);
			ExtentSuccessMessage("Successfully Submited Transactions");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Validate Banner Alert Message
	public void validatealertmsg(String altmsg) throws InterruptedException{
		WaitForPageLoad();
		By L_Banneralert = By.xpath("//p[normalize-space()='"+ altmsg +"']");
		try {
			if(ElementDisplayed(L_Banneralert)) {
				assertTrue(ElementDisplayed(L_Banneralert), "Assertion Passed");
				ExtentSuccessMessage("Successfully displayed Alert Message");
			}} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}


	public void clickMyCoverage() throws InterruptedException {
		try {
			WaitForLoadAnimationDisappear();
			MouseHoverOnElement(clickMyCoverage);
			click(clickMyCoverage);
			ExtentSuccessMessage("Successfully clicked on MyCoverage ");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Logout() throws InterruptedException {
		try {
			WaitForLoadAnimationDisappear();
			MouseHoverOnElement(L_user);
			if (ElementDisplayed(L_Logout)) {				
				MouseHoverOnElement(L_Logout);
				jsClick(L_Logout);
				driver.quit();
				// ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
				ExtentSuccessMessage("Logout is done");
			} else {
				ExtentErrorMessage("Logout Not Visiable");
			}
			driver.quit();
			killExcel();
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Logout1() throws AWTException, IOException {
		try {
			Thread.sleep(3000);
			MouseHoverOnElement(L_username);
			if (ElementDisplayed(L_Logout1)) {
				MouseHoverOnElement(L_Logout1);
				jsClick(L_Logout1);
				System.out.println("Successfully log out page");
				Thread.sleep(5000);
				ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
				ExtentSuccessMessage("Logout is done");
			} else {
				if (ElementDisplayed(L_Logout)) {
					MouseHoverOnElement(L_Logout);
					jsClick(L_Logout);
					System.out.println("Successfully log out page");
					Thread.sleep(5000);
					ExtentSuccessMessage("Logout is done");
				}else {

					ExtentErrorMessage("Logout Not Visiable");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//Navigate to the Billing and Payment
	public void clickBillingandpayment() throws InterruptedException {
		try {
			if (ElementDisplayed(billingandpayment)) 
			{
				click(billingandpayment);
				Log.info("Successfully clicked on billing and payment");
				ExtentSuccessMessage("Successfully clicked on billing and payment");
			} else {
				Log.error("Billing and payment tile is not displayed");
				ExtentErrorMessage("Billing and payment tile is not displayed");
			}
		} catch (

				Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//New Enrollment
	public void clicknewEnrollment() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(btn_newEnrollment);
			ExtentSuccessMessage("Successfully clicked on New Enrollment");
		} catch (

				Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on the Account Administration
	public void clickAccountAdministration() throws InterruptedException {
		try {
			WaitForPageLoad();
			//	if (loginuser_Type.equalsIgnoreCase("Admin")) {
			click(accountAdministrationXpath);
			ExtentSuccessMessage("Successfully Clicked on 'Employee_Administration' ");
			//				}
			//				if (loginuser_Type.equalsIgnoreCase("BA")) {
			//					MouseHoverOnElement(L_employeeAdministrationBA);
			//					click(L_employeeAdministrationBA);
			//					Log.info("Successfully Clicked on 'Employee_Administration'BA Role ");
			//					ExtentSuccessMessage("Successfully Clicked on 'Employee_Administration'BA Role ");
			//					Thread.sleep(5000);
			//					

			//}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	//Search with Advance
	public void Speridianadvancesearch(Map<Object, Object> testdata) throws InterruptedException {
		WaitForPageLoad();
		try {
			click(L_clickAdvancesearch);
			click(L_firstname);
			input(L_firstname,testdata.get("Name").toString());
			ExtentSuccessMessage("Successfully Clicked on Advance Search");
			SelectDropDownValue(L_selectrole, testdata.get("ExternalRole").toString());
			ExtentSuccessMessage("Successfully Selected External Role");
			click(L_search_icon);	
			click(lnk_login);
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}			
}
