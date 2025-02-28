package Pages;

import java.awt.AWTException;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.github.javafaker.Faker;

public class GroupContactUser_Page extends Base_Class {
	Base_Class Base_Class = new Base_Class();

	//////////////////////////////Locator///////////////////////////


	public static By L_AddGroupContactButton = By.xpath("//*[contains(text(),' Add Group Contact')]|//*[contains(text(),' Add Account Contact')]");
	public static By L_GroupContactUsersTab = By.xpath("//*[@class='selected']|//a[contains(.,'Group Contact Users')] | //a[contains(.,'Account Contact Users')]");
	public static By L_FirstName =By.xpath("//*[@class='margin_top_15px']//label[text()='First Name']//parent::div//input[@type='text']");
	public static By L_MiddleName = By.xpath("//*[@class='margin_top_15px']//label[text()='Middle Name']//parent::div//input[@type='text']");
	public static By L_LastName = By.xpath("//*[@class='margin_top_15px']//label[text()='Last Name']//parent::div//input[@type='text']");
	public static By L_PhoneNumber = By.xpath("//*[@class='margin_top_15px']//label[text()='Phone']//parent::div//input[@type='text']");
	public static By L_EmailId = By.xpath("//*[@class='margin_top_15px']//label[text()='Email ID']//parent::div//input[@type='text']");
	public static By L_Group = By.xpath("//*[@placeholder='SelectAccount']//parent::div");
	public static By L_SFEntityID =By.xpath("//*[@class='margin_top_15px']//label[text()='SF Entity ID']//parent::div//input[@type='text']");

	////////////////////////_Add Group Contact Button /////////////////

	public static By L_BenefitAdministration = By.xpath("//*[contains(text(),'Benefit Administrator')]");
	public static By L_BenefitAdministration1 = By.xpath("//*[@id='userprofile_editbox']//*[contains(text(),'Benefit Administrator')]");
	public static By L_ClientAdministration = By.xpath("//*[contains(text(),'Client Administrator')]");
	public static By L_EnrollmentSupport1 = By.xpath("//*[contains(text(),'Enrollment Support')]");
	public static By L_EnrollmentSupport = By.xpath("//*[@id='userprofile_editbox']//*[contains(text(),'Enrollment Support')]");
	public static By L_SubmitButtion = By.xpath("//*[@class='btn btn-primary']//*[text()='Submit']");
	public static By L_CancelButton = By.xpath("//*[@class='btn btn-default'][text()='Cancel']");
	public static By L_ResetButton = By.xpath("//*[@class='btn btn-default'][text()='Reset']");
	public static By L_ConfirmationPopupOkButton = By.xpath("//*[contains(@class,'adding-page btn  btn-primary no-margin')][contains(text(),'Ok')]");
	public static By L_SearchfieldFirstName = By.xpath("//*[@placeholder='Search']");
	public static By L_SearchIcon = By.xpath("//*[@class='md-search-btn hr-theme-bg']");
	public static By L_ReqOnlineAccGlobeIcon = By.xpath("//*[@class='items']//*[@class=\"fa fa-globe theme-color\"]");

	public static By L_ConfirmRegissLinkOk = By.xpath("//*[@class='modal-footer nomargin-btn']//*[contains(text(),'Ok')]//ancestor::a");
	public static By L_userprofileeditbutton=By.id("userprofile_editbutton");
	public static By L_ProfileDelete = By.xpath("//*[@title='Delete']");
	public static By L_ConfirmationPopupYesButton = By.xpath("(//*[@class='adding-page btn  btn-primary no-margin'])[1]");
	public static By L_NoRecords = By.xpath("//*[@class='no-record']");
	public static By L_selectUserRole = By.xpath("//select[@class='select']");	
	public static By L_updateInActiveAdministrator = By.xpath("//div[@id='userprofile_editbox']//label[@class='btn btn-default Yesnoclass']");
	public static By L_clickUpdateButton = By.xpath("//a[contains(.,'Update')]");
	public static By L_clickYesButton = By.xpath("//div[@class='tab-pane']//a[contains(.,'Yes')]");
	public static By L_clickOKButton = By.xpath("//a[contains(.,'Ok')]");
	public static By L_noRecordsFound = By.xpath("//td[contains(.,'No Records Found')]");
	public static By L_clickDeleteUserButton = By.xpath("//i[@class='fa fa-trash theme-color']");



	/////////////////////////////Method ///////////////////////////////

	public void ClickOnGroupContactUsersTab() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_GroupContactUsersTab)) {
				Log.info("Successfully Visible Add Groupe Contact Tab");
				click(L_GroupContactUsersTab);
				Log.info("Successfully Clicked On Add  Group Contact  Tab");
				ExtentSuccessMessage("Successfully Clicked On Add  Group Contact  Tab");
			}else {
				Log.error("UnSuccessfully Not Visible Add Group Contact Tab");
				ExtentErrorMessage("UnSuccessfully Not Visible Add Group Contact Tab");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public void ClickUserProfileEditButton() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_userprofileeditbutton)) {
				Log.info("Successfully Visible User profile Edit button");
				click(L_userprofileeditbutton);
				Log.info("Successfully Clicked On User profile edit button");
				ExtentSuccessMessage("Successfully Clicked On user profile edit button");
			}else {
				Log.error("UnSuccessfully Not Visible user profile edit button");
				ExtentErrorMessage("UnSuccessfully Not Visible user profile edit button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void ClickUserProfileDeleteButton() throws InterruptedException{
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_ProfileDelete)) {
				Log.info("Successfully Visible User profile Delete button");
				click(L_ProfileDelete);
				Log.info("Successfully Clicked On User profile Delete button");
				ExtentSuccessMessage("Successfully Clicked On user profile Delete button");
			}else {
				Log.error("UnSuccessfully Not Visible user profile Delete button");
				ExtentErrorMessage("UnSuccessfully Not Visible user profile Delete button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}	

	public void ClickOnAddGroupContactButton() throws InterruptedException{
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_AddGroupContactButton)) {
				Log.info("Successfully Visible Add Groupe Contact Button");
				click(L_AddGroupContactButton);
				Log.info("Successfully Clicked On Add  Groupe Contact  Button");
				ExtentSuccessMessage("Successfully Clicked On Add  Groupe Contact  Button");
			}else {
				Log.error("UnSuccessfully Not Visible Add Groupe Contact Button");
				ExtentErrorMessage("UnSuccessfully Not Visible Add Groupe Contact Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public String EnterFirstName() throws InterruptedException {
		Faker faker = new Faker();
		String strFirstname = faker.name().firstName().replaceAll("[^A-Za-z0-9]", "");
		System.out.println("First Name"+strFirstname);
		input(L_FirstName, strFirstname);
		ExtentSuccessMessage("First Name: " + strFirstname);
		return strFirstname;
	}

	public String EnterLastName() throws InterruptedException {
		Faker faker = new Faker();
		String strLastName = faker.name().lastName().replaceAll("[^A-Za-z0-9]", "");
		System.out.println("Last Name"+strLastName);
		input(L_LastName, strLastName);
		ExtentSuccessMessage("Last Name: " + strLastName);
		return strLastName;

	}

	public void EnterPhoneNumber(String Value) throws InterruptedException{
		try {
			if(ElementDisplayed(L_PhoneNumber)) {
				Log.info("Successfully Visible Phone Number Field");
				click(L_PhoneNumber);
				Log.info("Successfully Clicked On  Phone Number Field");
				//			ExtentSuccessMessage("Successfully Clicked On Add  Groupe Contact  Button");
				clear(L_PhoneNumber);
				input(L_PhoneNumber,Value);
				ExtentSuccessMessage("Successfully Enter value in Phone Number Field");
			}else {
				Log.error("UnSuccessfully Not Visible  Phone Number Field");
				ExtentErrorMessage("UnSuccessfully Not  Phone Number Field");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void EnterEmailId(String Value) throws InterruptedException{
		try {	
			if(ElementDisplayed(L_EmailId)) {
				Log.info("Successfully Visible Email Field");
				click(L_EmailId);
				Log.info("Successfully Clicked On  Email Field");
				//			ExtentSuccessMessage("Successfully Clicked On Add  Groupe Contact  Button");
				clear(L_EmailId);
				input(L_EmailId,Value);
				ExtentSuccessMessage("Successfully Enter value in Email Id Field");
			}else {
				Log.error("UnSuccessfully Not Visible Email Field");
				ExtentErrorMessage("UnSuccessfully Not Visible Email Field");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void SelectDropDownValueGroup(String Value,String Value2) throws InterruptedException, AWTException{
		SelectDropDownValue(L_Group,Value);
		ExtentSuccessMessage("Successfully clicked and selected a value from the Select Account Dropdown : " + Value);
		RobotKeyOperation("ENTER");
		SelectDropDownValue(L_Group,Value2);
	}
	//	L_BenefitAdministration

	public void SelectSperidianGroupDropDownValue(String Value) throws InterruptedException, AWTException{
		SelectDropDownValue(L_Group,Value);
		Thread.sleep(1000);
		ExtentSuccessMessage("Successfully clicked and selected a value from the Select Account Dropdown : " + Value);

		RobotKeyOperation("ENTER");
	}

	public void ClickOnBenefitAdministrationButton() throws InterruptedException{
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_BenefitAdministration)) {
				Log.info("Successfully Visible Benefit Administration Button");
				click(L_BenefitAdministration);
				Log.info("Successfully Clicked On Benefit Administration Button");
				ExtentSuccessMessage("Successfully Clicked On Benefit Administration Button");
			}else if(ElementDisplayed(L_BenefitAdministration1)) {
				Log.info("Successfully Visible Benefit Administration Button");
				click(L_BenefitAdministration1);
				Log.info("Successfully Clicked On Benefit Administration Button");
				ExtentSuccessMessage("Successfully Clicked On Benefit Administration Button");
			}else {
				Log.error("UnSuccessfully Not Visible Benefit Administration Button");
				ExtentErrorMessage("UnSuccessfully Not Visible Benefit Administration Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void ClickOnClientAdministrationButton() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_ClientAdministration)) {
				Log.info("Successfully Visible Client Administration Button");
				click(L_ClientAdministration);
				Log.info("Successfully Clicked On Client Administration Button");
				ExtentSuccessMessage("Successfully Clicked On Client Administration Button");
			}else {
				Log.error("UnSuccessfully Not Visible Client Administration Button");
				ExtentErrorMessage("UnSuccessfully Not Visible Client Administration Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void ClickOnEnrollmentSupportButton() throws InterruptedException{
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_EnrollmentSupport1)) {
				Log.info("Successfully Visible Enrollment Support Button");
				click(L_EnrollmentSupport);
				Log.info("Successfully Clicked On Enrollment Support Button");
				ExtentSuccessMessage("Successfully Clicked On Enrollment Support Button");
			}else if(ElementDisplayed(L_EnrollmentSupport)) {
				Log.info("Successfully Visible Enrollment Support Button");
				click(L_EnrollmentSupport);
				Log.info("Successfully Clicked On Enrollment Support Button");
				ExtentSuccessMessage("Successfully Clicked On Enrollment Support Button");
			}else {
				Log.error("UnSuccessfully Not Visible Enrollment Support Button");
				ExtentErrorMessage("UnSuccessfully Not Visible Enrollment Support Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void ClickOnSubmitButton() throws InterruptedException{
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_SubmitButtion)) {
				Log.info("Successfully Visible Submit Button");
				click(L_SubmitButtion);
				WaitForLoadAnimationDisappear();
				Log.info("Successfully Clicked On Submit Button");
				ExtentSuccessMessage("Successfully Clicked On Submit Button");
			}else {
				Log.error("UnSuccessfully Not Visible Submit Button");
				ExtentErrorMessage("UnSuccessfully Not Visible Submit Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	//	*[@class='adding-page btn  btn-primary no-margin'][contains(text(),'Ok')]


	public void ClickOnConfirmationPopupOkButton() throws InterruptedException{
		try {	
			Thread.sleep(1000);
			if(ElementDisplayed(L_ConfirmationPopupOkButton)) {
				Log.info("Successfully Visible Confirmation Popup Ok Button");
				waitForElementClickable(L_ConfirmationPopupOkButton);
				click(L_ConfirmationPopupOkButton);
				WaitForLoadAnimationDisappear();
				Log.info("Successfully Clicked On Confirmation Popup Ok Button");
				ExtentSuccessMessage("Successfully Clicked On Confirmation Popup Ok Button");
			}else {
				Log.error("UnSuccessfully Not Visible Confirmation Popup Ok Button");
				ExtentErrorMessage("UnSuccessfully Not Visible Confirmation Popup Ok Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void ClickOnConfirmationPopupYesButton() throws InterruptedException{
		try {
			Thread.sleep(5000);
			if(ElementDisplayed(L_ConfirmationPopupYesButton)) {
				Log.info("Successfully Visible Confirmation Popup Yes Button");
				waitForElementClickable(L_ConfirmationPopupYesButton);
				click(L_ConfirmationPopupYesButton);
				Log.info("Successfully Clicked On Confirmation Popup Yes Button");
				ExtentSuccessMessage("Successfully Clicked On Confirmation Popup Yes Button");
			}else {
				Log.error("UnSuccessfully Not Visible Confirmation Popup Yes Button");
				ExtentErrorMessage("UnSuccessfully Not Visible Confirmation Popup Yes Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void EnterFirstNameForSearch(String Value) throws InterruptedException{
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_SearchfieldFirstName)) {
				Log.info("Successfully Visible Search Field");
				click(L_SearchfieldFirstName);
				Log.info("Successfully Clicked On  Search Field");
				//			ExtentSuccessMessage("Successfully Clicked On Add  Groupe Contact  Button");
				input(L_SearchfieldFirstName,Value);
				ExtentSuccessMessage("Successfully Enter value in Search Field");
			}else {
				Log.error("UnSuccessfully Not Visible Search Field");
				ExtentErrorMessage("UnSuccessfully Not Visible Search Field");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public void ClickOnSearchIcon() throws InterruptedException{
		try {	
			//WaitForPageLoad();
			//WaitForLoadAnimationDisappear();
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
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public void ClickOnRequestOnlineAccess() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_ReqOnlineAccGlobeIcon)) {
				Log.info("Successfully Visible Globe Icon");
				click(L_ReqOnlineAccGlobeIcon);
				Log.info("Successfully Clicked On Globe Icon");
				ExtentSuccessMessage("Successfully Clicked On Globe Icon");
			}else {
				Log.error("UnSuccessfully Not Visible Globe Icon");
				ExtentErrorMessage("UnSuccessfully Not Visible Globe Icon");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}



	public void ClickOnConfirmationRegisterOnlineOkButton() throws InterruptedException{
		try {
			Thread.sleep(5000);
			WaitForPageLoad();
			if(ElementDisplayed(L_ConfirmRegissLinkOk)) {
				Log.info("Successfully Visible Ok Button");
				Thread.sleep(4000);
				//waitForElementClickable(L_ConfirmRegissLinkOk);
				click(L_ConfirmRegissLinkOk);
				Log.info("Successfully Clicked On Ok Button");
				ExtentSuccessMessage("Successfully Clicked On Ok Button");
			}else {
				Log.error("UnSuccessfully Not Visible Ok Button");
				ExtentErrorMessage("UnSuccessfully Not Visible Ok Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public static String GetNoRecordsMsg() throws InterruptedException {
		WaitForPageLoad();
		Thread.sleep(5000);
		String strx=GetElementText(L_NoRecords);
		return strx;
	}

	//To Provide SF Entity ID
	public void EnterSFEntityID(String Value) throws InterruptedException{
		try {
			if(ElementDisplayed(L_SFEntityID)) {
				Log.info("Successfully Visible SFEntityID Field");
				click(L_SFEntityID);
				Log.info("Successfully Clicked On SFEntityID Field");
				//			ExtentSuccessMessage("Successfully Clicked On Add  Groupe Contact  Button");
				clear(L_SFEntityID);
				input(L_SFEntityID,Value);
				ExtentSuccessMessage("Successfully Enter value in SFEntityID Field");
			}else {
				Log.error("UnSuccessfully Not Visible SFEntityID Field");
				ExtentErrorMessage("UnSuccessfully Not Visible SFEntityID Field");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public void updateInActiveAdministrator() throws InterruptedException 
	{	
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_updateInActiveAdministrator)) {
				click(L_updateInActiveAdministrator);
				Log.info("Successfully Clicked On Client/BA Administrator button");
				ExtentSuccessMessage("Successfully Clicked On Client/BA Administrator button");
			}else {
				Log.error("UnSuccessfully Not Clicked On Client/BA Administrator button");
				ExtentErrorMessage("UnSuccessfully Not Clicked On Client/BA Administrator button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickUpdateButton() throws InterruptedException 
	{	
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_clickUpdateButton))
			{ 
				Log.info("Update Button is displayed");
				waitForElementClickable(L_clickUpdateButton);
				click(L_clickUpdateButton);
				ExtentSuccessMessage("Successfully clicked the Update Button");
			} 
			else 
			{
				Log.error("Update Button is not displayed");
				ExtentErrorMessage("Update Button is not displayed");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickOKButton() throws InterruptedException 
	{	
		try {
			WaitForPageLoad();
			waitForElementVisible(L_clickOKButton);
			if(ElementDisplayed(L_clickOKButton))
			{ 
				Log.info("OK Button is displayed");
				waitForElementClickable(L_clickOKButton);
				click(L_clickOKButton);
				ExtentSuccessMessage("Successfully clicked the OK Button");
			} 
			else 
			{
				Log.error("OK Button is not displayed");
				ExtentErrorMessage("OK Button is not displayed");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickDeleteButton() throws InterruptedException 
	{	
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_clickDeleteUserButton))
			{ 
				Log.info("Delete Button is displayed");
				waitForElementClickable(L_clickDeleteUserButton);
				click(L_clickDeleteUserButton);
				ExtentSuccessMessage("Successfully clicked the Delete Button");
			} 
			else 
			{
				Log.error("Delete Button is not displayed");
				ExtentErrorMessage("Delete Button is not displayed");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickYesButton() throws InterruptedException 
	{	
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_clickYesButton))
			{ 
				Log.info("Yes Button is displayed");
				waitForElementClickable(L_clickYesButton);
				click(L_clickYesButton);
				ExtentSuccessMessage("Successfully clicked the Yes Button");
			} 
			else 
			{
				Log.error("Yes Button is not displayed");
				ExtentErrorMessage("Yes Button is not displayed");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void validateNoRecordsFound() throws InterruptedException	{	
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_noRecordsFound))
			{ 
				Log.info("Successfully Record has been deleted.");
				ExtentSuccessMessage("Successfully Record has been deleted.");
			} 
			else 
			{
				Log.error("Record has not been deleted.");
				ExtentErrorMessage("Record has not been deleted.");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Select user role
	public void selectUserRole(String Value) throws InterruptedException, AWTException{
		try {
			if(ElementDisplayed(L_selectUserRole)) {
				selectDropdownByVisibleText(L_selectUserRole, Value);
				ExtentSuccessMessage("Successfully clicked and selected a value from the Select Account Dropdown.");
			}else {
				Log.error("UnSuccessfully not clicked and selected a value from the Select Account Dropdown");
				ExtentErrorMessage("UnSuccessfully not clicked and selected a value from the Select Account Dropdown");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
