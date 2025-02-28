package IHA_Content_Management;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import com.BasePackage.Base_Class;

import FBMC_Content_Management.FBMC_Content_Management_AllScenarios;
import Pages.Agency_Page;
import Pages.AssignAccount_Page;
import Pages.Agency_Details_Page;
import Pages.ContentManagement_Page;
import Pages.CreateYourAccount;
import Pages.EmailLogs;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Login_Page;
import Pages.Notifications_Page;
import Pages.Payment_Profile;
import Pages.ViewCoverage_Page;

public class IHA_ContentManagement_AddAgencyContact_Register_Notifications_Flow extends IHA_ContentManagement_AllScenarios {
	Home_Page Home_Page = new Home_Page();
	ContentManagement_Page contentManagementPage = new ContentManagement_Page();
	Notifications_Page notifications_Page = new Notifications_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	Base_Class Base_Class =new Base_Class();
	Payment_Profile Payment_Profile = new Payment_Profile();
	CreateYourAccount CreateYourAccount = new CreateYourAccount();
	EmailLogs EmailLogs = new EmailLogs();
	Agency_Page Agency_Page=new Agency_Page();
	Login_Page Login_Page = new Login_Page();
	AssignAccount_Page assignAccount_Page = new AssignAccount_Page();
	Agency_Details_Page Agency_Details_Page=new Agency_Details_Page();

	public void ValidateIHA_ContentManagement_AddAgencyContact_Register_Notifications_Flow(String testScenario,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException {

		//Click on ContentManagement Tab
		Home_Page.CheckContentManagementTabDispaly();
		//Click on the Notifications
		contentManagementPage.ClickOnnotifications();
		//Search for Employee Registration in the Search bar.
		notifications_Page.search_Notification_Name(testdata);
		//Turn off Status button.L̥
		notifications_Page.TurnOnNotification();
		//******************ADD Agency******************

		// Click on More
		Home_Page.ClickOnMoreTab();
		// CliCK OnBroker Management
		Home_Page.ClickOnBrokerManagement();
		//Click on Add Agency btn
		Agency_Page.ClickOnAddAgencyButton();
		// Provide SF Entity ID
		Agency_Page.EnterSFEntityId();
		// Agency Name
		String agencyName=Agency_Page.EnterAgencyName();
		// Click on Agency Type
		Agency_Page.selectAgencyType("Broker Firm");
		// Click on Save btn.
		Agency_Page.ClickOnSaveButton();
		// Click on Ok on Confirmation popup
		Agency_Page.ClickOnOKButton();
		//  Click Ok on Provide above created Agency name 
		Agency_Page.EnterAgencyNameInSearchBar(agencyName);
		// Click Ok onSearch bar and click on Search icon.
		Agency_Page.ClickOnSearchIcon();
		// Click on 
		Agency_Page.AgencyNameValidation(agencyName);
		// Click on the Agency name.
		Agency_Page.ClickOnAgencyNameInGrid();

		//*******************Add Agency contact****************

		// Click on Add Contact btn.
		Agency_Details_Page.ClickOnAddContactButton();
		// Click on Provide SF Entity ID
		Agency_Details_Page.EnterSFEntityId();
		// Click on Agency_Details_Page
		String AgencyContacts=Agency_Details_Page.EnterPersonalDetails();
		// Click on Save btn.
		Agency_Details_Page.ClickOnSaveButton();
		// Click on Ok on Confirmation popup
		Agency_Page.ClickOnOKButton();

		//**************Request Online Access Agency contact******************

		Agency_Page.EnterAgencyNameInSearchBar(AgencyContacts);
		// Agency Primary contact check box 
		Agency_Page.ClickOnCheckboxofAgencyName(AgencyContacts);
		// Click on Globe Icon or Terminate btn.

		Agency_Details_Page.ClickOnRequestOnlineAccess();
		// Click on OK Button
		Agency_Details_Page.ClickOnOKButton();


		//***********Email verification**********

		Home_Page.clickCommunicationTab();
		//Click on Email Log
		Home_Page.ClickOnEmailLog();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		//WaitForLoadAnimationDisappear();
		WaitForLoadAnimationDisappear();
		//Enter the First Name
		EmailLogs.EnterFirstNameEmailLogEnterSearchField(AgencyContacts);
		//Click on the Email Log search button
		EmailLogs.ClickOnEmailLogSearchIcon();
		//WaitForLoadAnimationDisappear();
		WaitForLoadAnimationDisappear();
		EmailLogs.ClickOnViewIcon();

		EmailLogs.ClickOnRegistrationLink();

		WaitForLoadAnimationDisappear();
		String[] values = AgencyContacts.split(" ");	
		String lastname = values[1];
		//Enter the User Name
		String UserName = lastname+"_Username123";
		CreateYourAccount.EnterIHACreateUserName(UserName);
		System.out.println("User Name"+UserName);
		//Enter the Password
		CreateYourAccount.EnterIHACreatePassword(testdata.get("Password").toString());
		//Enter the Confirm Password
		CreateYourAccount.EnterIHACreateConfirmPassword(testdata.get("Password").toString());
		//Click on the Policy And Terms CheckBox
		CreateYourAccount.ClickOnIHAPriPolicyAndTermsConCheckBox();
		//Click on the I Accept Button
		CreateYourAccount.ClickOnIHAIAcceptButton();
		//Click on the Create User Registration button
		CreateYourAccount.ClickOnCreateUserRegistrationButton();

		Group_Page.Logout1();
		//Enter the Admin Username
		Login_Page.EnterUserNameField("sa");
		//Enter the Password
		Login_Page.EnterPasswordField("password$123");
		//Click on the Login Button
		Login_Page.ClickOnLoginButton();
		// Click on More
		Home_Page.ClickOnMoreTab();
		// CliCK OnBroker Management
		Home_Page.ClickOnBrokerManagement();
		// Enter Agency Name In Search Bar
		Agency_Page.EnterAgencyNameInSearchBar(AgencyContacts);
		// Click Ok onSearch bar and click on Search icon.
		Agency_Page.ClickOnSearchIcon();
		// Click on 
		Agency_Page.AgencyNameValidation(agencyName);
		// Click on the Agency name.
		Agency_Page.ClickOnAgencyNameInGrid();
		// ClL̥ick On Contact Name
		Agency_Details_Page.ClickOnContactName();
		//Click On Add Account Button
		Agency_Details_Page.ClickOnAddAccountButton();

		////////
		//Search for the group in the Search Bar
		assignAccount_Page.SelectGroupname(testdata.get("Account").toString());
		WaitForLoadAnimationDisappear();
		//Click on the Add Person Button
		assignAccount_Page.ClickOnAddPersonButton();
		//Select the Contact Type
		assignAccount_Page.SelectContactType("TPA");
		//Enter the Start Date
		assignAccount_Page.EnterBORStartDate();
		//Enter the End Date
		assignAccount_Page.EnterBOREndDate(testdata);
		//Click on the Account Primary Contact
		assignAccount_Page.ClickOnAccountPrimaryContactCheckBox();
		//Click on Save Button
		assignAccount_Page.ClickOnSaveButton();
		//Click on OK Button
		assignAccount_Page.ClickOnOKButton();
		//Click on the Back Button
		assignAccount_Page.ClickOnBackButton();
		// Click On Communication Tab
		Home_Page.clickCommunicationTab();
		//Click on Email Log
		Home_Page.ClickOnEmailLog();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		//WaitForLoadAnimationDisappear();
		WaitForLoadAnimationDisappear();
		//Enter the First Name
		EmailLogs.EnterFirstNameEmailLogEnterSearchField(AgencyContacts);
		//Click on the Email Log search button
		EmailLogs.ClickOnEmailLogSearchIcon();
		//WaitForLoadAnimationDisappear();
		WaitForLoadAnimationDisappear();
		EmailLogs.ClickOnViewIcon();

		//************Turn off and verify**************			
		Home_Page.CheckContentManagementTabDispaly();
		//Click on the Notifications
		contentManagementPage.ClickOnnotifications();
		//Search for Employee Registration in the Search bar.
		notifications_Page.search_Notification_Name(testdata);
		//Turn off Status button.
		notifications_Page.TurnOffNotification();

		//******************ADD Agency******************

		// Click on More
		Home_Page.ClickOnMoreTab();
		// CliCK OnBroker Management
		Home_Page.ClickOnBrokerManagement();
		//Click on Add Agency btn
		Agency_Page.ClickOnAddAgencyButton();
		// Provide SF Entity ID
		Agency_Page.EnterSFEntityId();
		// Agency Name
		String agencyName1=Agency_Page.EnterAgencyName();
		// Click on Agency Type
		Agency_Page.selectAgencyType("Broker Firm");
		// Click on Save btn.
		Agency_Page.ClickOnSaveButton();
		// Click on Ok on Confirmation popup
		Agency_Page.ClickOnOKButton();
		//  Click Ok on Provide above created Agency name 
		Agency_Page.EnterAgencyNameInSearchBar(agencyName1);
		// Click Ok onSearch bar and click on Search icon.
		Agency_Page.ClickOnSearchIcon();
		// Click on 
		Agency_Page.AgencyNameValidation(agencyName1);
		// Click on the Agency name.
		Agency_Page.ClickOnAgencyNameInGrid();
		//*******************Add Agency contact****************

		// Click on Add Contact btn.
		Agency_Details_Page.ClickOnAddContactButton();
		// Click on Provide SF Entity ID
		Agency_Details_Page.EnterSFEntityId();
		// Click on Agency_Details_Page
		String AgencyContacts1=Agency_Details_Page.EnterPersonalDetails();
		// Click on Save btn.
		Agency_Details_Page.ClickOnSaveButton();
		// Click on Ok on Confirmation popup
		Agency_Page.ClickOnOKButton();

		//**************Request Online Access Agency contact******************

		Agency_Page.EnterAgencyNameInSearchBar(AgencyContacts1);
		// Agency Primary contact check box 
		Agency_Page.ClickOnCheckboxofAgencyName(AgencyContacts1);
		// Click on Globe Icon or Terminate btn.

		Agency_Details_Page.ClickOnRequestOnlineAccess();
		// Click on OK Button
		Agency_Details_Page.ClickOnOKButton();


		//***********Email verification**********

		Home_Page.clickCommunicationTab();
		//Click on Email Log
		Home_Page.ClickOnEmailLog();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		//WaitForLoadAnimationDisappear();
		WaitForLoadAnimationDisappear();
		//Enter the First Name
		EmailLogs.EnterFirstNameEmailLogEnterSearchField(AgencyContacts1);
		//Click on the Email Log search button
		EmailLogs.ClickOnEmailLogSearchIcon();
		//WaitForLoadAnimationDisappear();
		WaitForLoadAnimationDisappear();
		EmailLogs.ClickOnViewIcon();

		EmailLogs.ClickOnRegistrationLink();

		WaitForLoadAnimationDisappear();
		String[] values1 = AgencyContacts1.split(" ");	
		String lastname1 = values1[1];
		//Enter the User Name
		String UserName1 = lastname1+"1_Username123";
		CreateYourAccount.EnterIHACreateUserName(UserName1);
		System.out.println("User Name"+UserName1);
		//Enter the Password
		CreateYourAccount.EnterIHACreatePassword(testdata.get("Password").toString());
		//Enter the Confirm Password
		CreateYourAccount.EnterIHACreateConfirmPassword(testdata.get("Password").toString());
		//Click on the Policy And Terms CheckBox
		CreateYourAccount.ClickOnIHAPriPolicyAndTermsConCheckBox();
		//Click on the I Accept Button
		CreateYourAccount.ClickOnIHAIAcceptButton();
		//Click on the Create User Registration button
		CreateYourAccount.ClickOnCreateUserRegistrationButton();

		Group_Page.Logout1();
		//Enter the Admin Username
		Login_Page.EnterUserNameField("sa");
		//Enter the Password
		Login_Page.EnterPasswordField("password$123");
		//Click on the Login Button
		Login_Page.ClickOnLoginButton();
		// Click on More
		Home_Page.ClickOnMoreTab();
		// CliCK OnBroker Management
		Home_Page.ClickOnBrokerManagement();
		// Enter Agency Name In Search Bar
		Agency_Page.EnterAgencyNameInSearchBar(AgencyContacts1);
		// Click Ok onSearch bar and click on Search icon.
		Agency_Page.ClickOnSearchIcon();
		// Click on 
		Agency_Page.AgencyNameValidation(agencyName1);
		// Click on the Agency name.
		Agency_Page.ClickOnAgencyNameInGrid();
		// ClL̥ick On Contact Name
		Agency_Details_Page.ClickOnContactName();
		//Click On Add Account Button
		Agency_Details_Page.ClickOnAddAccountButton();

		////////
		//Search for the group in the Search Bar
		assignAccount_Page.SelectGroupname(testdata.get("Account").toString());
		WaitForLoadAnimationDisappear();
		//Click on the Add Person Button
		assignAccount_Page.ClickOnAddPersonButton();
		//Select the Contact Type
		assignAccount_Page.SelectContactType("TPA");
		//Enter the Start Date
		assignAccount_Page.EnterBORStartDate();
		//Enter the End Date
		assignAccount_Page.EnterBOREndDate(testdata);
		//Click on the Account Primary Contact
		assignAccount_Page.ClickOnAccountPrimaryContactCheckBox();
		//Click on Save Button
		assignAccount_Page.ClickOnSaveButton();
		//Click on OK Button
		assignAccount_Page.ClickOnOKButton();
		//Click on the Back Button
		assignAccount_Page.ClickOnBackButton();
		// Click On Communication Tab
		Home_Page.clickCommunicationTab();
		//Click on Email Log
		Home_Page.ClickOnEmailLog();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		//WaitForLoadAnimationDisappear();
		WaitForLoadAnimationDisappear();
		//Enter the First Name
		EmailLogs.EnterFirstNameEmailLogEnterSearchField(AgencyContacts1);
		//Click on the Email Log search button
		EmailLogs.ClickOnEmailLogSearchIcon();
		//WaitForLoadAnimationDisappear();
		WaitForLoadAnimationDisappear();
		//		EmailLogs.ClickOnViewIcon();
		//		EmailLogs.validateNoRecordsFound()
	}

}