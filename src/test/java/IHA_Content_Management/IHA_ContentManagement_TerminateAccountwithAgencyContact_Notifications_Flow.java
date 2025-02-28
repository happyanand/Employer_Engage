package IHA_Content_Management;
import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import Pages.Agency_Details_Page;
import Pages.Agency_Page;
import Pages.AssignAccount_Page;
import Pages.ContentManagement_Page;
import Pages.CreateYourAccount;
import Pages.EmailLogs;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Login_Page;
import Pages.Notifications_Page;

public class IHA_ContentManagement_TerminateAccountwithAgencyContact_Notifications_Flow extends IHA_ContentManagement_AllScenarios {
	
	Home_Page Home_Page = new Home_Page();
	ContentManagement_Page contentManagementPage = new ContentManagement_Page();
	Notifications_Page notifications_Page = new Notifications_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	CreateYourAccount CreateYourAccount = new CreateYourAccount();
	EmailLogs EmailLogs = new EmailLogs();
	Agency_Page Agency_Page=new Agency_Page();
	Login_Page Login_Page = new Login_Page();
	Agency_Details_Page Agency_Details_Page=new Agency_Details_Page();
	AssignAccount_Page assignAccount_Page = new AssignAccount_Page();

	public void ValidateIHA_ContentManagement_TerminateAccountwithAgencyContact_Notifications_Flow(String testScenario,String Password,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException {

			//Click on ContentManagement Tab
			Home_Page.CheckContentManagementTabDispaly();
			//Click on the Notifications
			contentManagementPage.ClickOnnotifications();
			//Search for Employee Registration in the Search bar.
			notifications_Page.search_Notification_Name(testdata);
			//Turn ON Status button.
			notifications_Page.TurnOnNotification();

			ExtentSuccessMessage("******************ADD Agency***************");
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
			
			ExtentSuccessMessage("******************Add Agency contact***************");
			// Click on Add Contact btn.
			WaitForLoadAnimationDisappear();
			Agency_Details_Page.ClickOnAddContactButton();
			// Click on Provide SF Entity ID
			WaitForLoadAnimationDisappear();
			Agency_Details_Page.EnterSFEntityId();
			// Click on Agency_Details_Page
			String AgencyContact=Agency_Details_Page.EnterPersonalDetails();
			String AgencyContacts = AgencyContact.replace(" ","");
			// Click on Save btn.
			Agency_Details_Page.ClickOnSaveButton();
			// Click on Ok on Confirmation popup
			Agency_Page.ClickOnOKButton();

			ExtentSuccessMessage("******************Request Online Access Agency contact***************");
			// Click on Provide above created Agency name in the Search bar and click on Search icon.
			Agency_Page.EnterAgencyNameInSearchBar(AgencyContact);
			// Agency Primary contact check box 
			Agency_Page.ClickOnCheckboxofAgencyName(AgencyContact);
			//Click on the Request Online Access
			Agency_Details_Page.ClickOnRequestOnlineAccess();
			//Click on OK Button
			Agency_Details_Page.ClickOnOKButton();
		
			ExtentSuccessMessage("******************Email verification***************");
			Home_Page.clickCommunicationTab();
			//Click on Email Log
			Home_Page.ClickOnEmailLog();
			WaitForLoadAnimationDisappear();
			RefreshPage();
			WaitForLoadAnimationDisappear();
			//Enter the First Name
			EmailLogs.EnterFirstNameEmailLogEnterSearchField(AgencyContact);
			//Click on the Email Log search button
			EmailLogs.ClickOnEmailLogSearchIcon();
			WaitForLoadAnimationDisappear();
			//Click on the View Icon
			EmailLogs.ClickOnViewIconIHA(AgencyContacts);
			WaitForLoadAnimationDisappear();
			//Click on Registration Link
			EmailLogs.ClickOnRegistrationLink();
			/////*****Register Check*****/////
			//Enter the User Name
			String UserName = AgencyContacts+"_agent123";
			CreateYourAccount.EnterIHACreateUserName(UserName);
			System.out.println("User Name: "+UserName);
			//Enter the Password
			CreateYourAccount.EnterIHACreatePassword(Password);
			//Enter the Confirm Password
			CreateYourAccount.EnterIHACreateConfirmPassword(Password);
			//Click on the Policy And Terms CheckBox
			CreateYourAccount.ClickOnIHAPriPolicyAndTermsConCheckBox();
			//Click on the I Accept Button
			CreateYourAccount.ClickOnIHAIAcceptButton();
			//Click on the Create User Registration button
			CreateYourAccount.ClickOnCreateUserRegistrationButton();
			//Logout from Admin
			Group_Page.Logout1();
			WaitForPageLoad();
					
			ExtentSuccessMessage("******************Add Account***************");
			//Enter the Username
			Login_Page.EnterUserNameField("SA");
			//Enter the Password
			Login_Page.EnterPasswordField("password$123");
			//Click on the Login Button
	        Login_Page.ClickOnLoginButton();
			//Click on the More Tab
			Home_Page.ClickOnMoreTab();
			//Click on the Broker Management
			Home_Page.ClickOnBrokerManagement();
			//Enter the Agency name in Search Bar
			Agency_Page.EnterAgencyNameInSearchBar(agencyName);
			//Click on the Search Icon
			Agency_Page.ClickOnSearchIcon();
			//Click on the Agency name in the Grid
			Agency_Page.ClickOnAgencyNameInGrid();
			//Click on the Contact Name in the Contact List
			Agency_Details_Page.ClickOnContactNameInGrid(AgencyContact);
			//Click on the Add Account Button
			Agency_Details_Page.ClickOnAddAccountButton();
			//Search for the group in the Search Bar
			assignAccount_Page.SelectGroupname(testdata.get("Account").toString());
			WaitForLoadAnimationDisappear();
			//Click on the Add Person Button
			assignAccount_Page.ClickOnAddPersonButton();
			Thread.sleep(1000);
			//Select the Contact Type
			assignAccount_Page.SelectContactType("TPA");
			Thread.sleep(1000);	
			//Enter the Start Date
			assignAccount_Page.EnterBORStartDate();
			Thread.sleep(1000);
			//Enter the End Date
			assignAccount_Page.EnterBOREndDate(testdata);
			//Click on the Account Primary Contact
			assignAccount_Page.ClickOnAccountPrimaryContactCheckBox();
			//Click on Save Button
			assignAccount_Page.ClickOnSaveButton();
			Thread.sleep(1000);
			//Click on OK Button
			assignAccount_Page.ClickOnOKButton();
			Thread.sleep(1000);
			//Click on the Back Button
			assignAccount_Page.ClickOnBackButton();

			ExtentSuccessMessage("******************Terminate Account***************");
			//Click on Checkbox
			Agency_Details_Page.ClickOnCheckbox();	
			//Click on the Terminate Button
			Agency_Details_Page.ClickOnTerminate();
			//Click on Yes Confirmation popup
			Agency_Details_Page.ClickOnYesButton();
			//Click on OK button
			Agency_Details_Page.ClickOnOKButton();
						
			Home_Page.clickCommunicationTab();
			//Click on Email Log
			Home_Page.ClickOnEmailLog();
			WaitForLoadAnimationDisappear();
			RefreshPage();
			WaitForLoadAnimationDisappear();
			//Enter the First Name
			EmailLogs.EnterFirstNameEmailLogEnterSearchField(AgencyContact);
			//Click on the Email Log search button
			EmailLogs.ClickOnEmailLogSearchIcon();
			WaitForLoadAnimationDisappear();
			//Validate Name
			EmailLogs.validatename(AgencyContact);
			//Click on the View Icon
			EmailLogs.ClickOnViewIconIHA(AgencyContact);
			WaitForLoadAnimationDisappear();
			//validateNotificationId
			EmailLogs.validateNotificationId();

			ExtentSuccessMessage("******************Turn off and verify***************");
			Home_Page.CheckContentManagementTabDispaly();
			//Click on the Notifications
			contentManagementPage.ClickOnnotifications();
			//Search for Employee Registration in the Search bar.
			notifications_Page.search_Notification_Name(testdata);
			//Turn off Status button.
			notifications_Page.TurnOffNotification();

			ExtentSuccessMessage("******************ADD Agency***************");
			Home_Page.ClickOnMoreTab();
			Home_Page.ClickOnBrokerManagement();
			Agency_Page.ClickOnAddAgencyButton();
			Agency_Page.EnterSFEntityId();
			String agencyName1=Agency_Page.EnterAgencyName();
			Agency_Page.selectAgencyType("Broker Firm");
			Agency_Page.ClickOnSaveButton();
			Agency_Page.ClickOnOKButton();
			Agency_Page.EnterAgencyNameInSearchBar(agencyName1);
			Agency_Page.ClickOnSearchIcon();
			Agency_Page.AgencyNameValidation(agencyName1);
			Agency_Page.ClickOnAgencyNameInGrid();

			ExtentSuccessMessage("******************Add Agency contact***************");
			Agency_Details_Page.ClickOnAddContactButton();
			Agency_Details_Page.EnterSFEntityId();
			String AgencyContacts1=Agency_Details_Page.EnterPersonalDetails();
			Agency_Details_Page.ClickOnSaveButton();
			Agency_Page.ClickOnOKButton();

			ExtentSuccessMessage("******************Request Online Access Agency contact***************");
			Agency_Page.EnterAgencyNameInSearchBar(AgencyContacts1);
			// Agency Primary contact check box 
			Agency_Page.ClickOnCheckboxofAgencyName(AgencyContacts1);
			// Click on Globe Icon or Terminate btn.
			Agency_Details_Page.ClickOnRequestOnlineAccess();
			// Click on OK Button
			Agency_Details_Page.ClickOnOKButton();

			ExtentSuccessMessage("******************Email verification***************");
			Home_Page.clickCommunicationTab();
			//Click on Email Log
			Home_Page.ClickOnEmailLog();
			WaitForLoadAnimationDisappear();
			RefreshPage();
			//WaitForLoadAnimationDisappear();
			WaitForLoadAnimationDisappear();
			//Enter the First Name
			EmailLogs.EnterFirstNameEmailLogEnterSearchField(AgencyContacts1);
			//Click on the Email Log search button
			EmailLogs.ClickOnEmailLogSearchIcon();
			WaitForLoadAnimationDisappear();
			//Click on the View Icon
			EmailLogs.ClickOnViewIconIHA(AgencyContacts);
			WaitForLoadAnimationDisappear();
			//Click on Registration Link
			EmailLogs.ClickOnRegistrationLink();
			/////*****Register Check*****/////
			//Enter the User Name
			String UserName1 = AgencyContacts+"_agent";
			CreateYourAccount.EnterIHACreateUserName(UserName1);
			System.out.println("User Name: "+UserName1);
			//Enter the Password
			CreateYourAccount.EnterIHACreatePassword(Password);
			//Enter the Confirm Password
			CreateYourAccount.EnterIHACreateConfirmPassword(Password);
			//Click on the Policy And Terms CheckBox
			CreateYourAccount.ClickOnIHAPriPolicyAndTermsConCheckBox();
			//Click on the I Accept Button
			CreateYourAccount.ClickOnIHAIAcceptButton();
			//Click on the Create User Registration button
			CreateYourAccount.ClickOnCreateUserRegistrationButton();
			//Logout from Admin
			Group_Page.Logout1();
			WaitForPageLoad();

			ExtentSuccessMessage("******************Add Account***************");
			//Enter the Username
			Login_Page.EnterUserNameField("SA");
			//Enter the Password
			Login_Page.EnterPasswordField("password$123");
			//Click on the Login Button
	        Login_Page.ClickOnLoginButton();
			//Click on the More Tab
			Home_Page.ClickOnMoreTab();
			//Click on the Broker Management
			Home_Page.ClickOnBrokerManagement();
			//Enter the Agency name in Search Bar
			Agency_Page.EnterAgencyNameInSearchBar(agencyName1);
			//Click on the Search Icon
			Agency_Page.ClickOnSearchIcon();
			//Click on the Agency name in the Grid
			Agency_Page.ClickOnAgencyNameInGrid();
			//Click on the Contact Name in the Contact List
			Agency_Details_Page.ClickOnContactNameInGrid(AgencyContacts1);
			//Click on the Add Account Button
			Agency_Details_Page.ClickOnAddAccountButton();
			//Search for the group in the Search Bar
			assignAccount_Page.SelectGroupname(testdata.get("Account").toString());
			WaitForLoadAnimationDisappear();
			//Click on the Add Person Button
			assignAccount_Page.ClickOnAddPersonButton();
			Thread.sleep(1000);
			//Select the Contact Type
			assignAccount_Page.SelectContactType("TPA");
			Thread.sleep(1000);	
			//Enter the Start Date
			assignAccount_Page.EnterBORStartDate();
			Thread.sleep(1000);
			//Enter the End Date
			assignAccount_Page.EnterBOREndDate(testdata);
			//Click on the Account Primary Contact
			assignAccount_Page.ClickOnAccountPrimaryContactCheckBox();
			//Click on Save Button
			assignAccount_Page.ClickOnSaveButton();
			Thread.sleep(1000);
			//Click on OK Button
			assignAccount_Page.ClickOnOKButton();
			Thread.sleep(1000);
			//Click on the Back Button
			assignAccount_Page.ClickOnBackButton();
							
			ExtentSuccessMessage("******************Terminate Account***************");
			//Click on Checkbox
			Agency_Details_Page.ClickOnCheckbox();	
			//Click on the Terminate Button
			Agency_Details_Page.ClickOnTerminate();
			//Click on Yes Confirmation popup
			Agency_Details_Page.ClickOnYesButton();
			//Click on OK button
			Agency_Details_Page.ClickOnOKButton();
			WaitForLoadAnimationDisappear();
			
			ExtentSuccessMessage("******************Email verification***************");
			Home_Page.clickCommunicationTab();
			//Click on Email Log
			Home_Page.ClickOnEmailLog();
			WaitForLoadAnimationDisappear();
			RefreshPage();
			WaitForLoadAnimationDisappear();
			//Enter the First Name
			EmailLogs.EnterFirstNameEmailLogEnterSearchField(AgencyContacts1);
			//Click on the Email Log search button
			EmailLogs.ClickOnEmailLogSearchIcon();		
			WaitForLoadAnimationDisappear();
			//Validate Name
			EmailLogs.validatename(AgencyContacts1);
			//Click on the View Icon
			EmailLogs.ClickOnViewIconIHA(AgencyContacts1);
			//validateNotificationId
			EmailLogs.validateNotificationId();
			
		}

}

