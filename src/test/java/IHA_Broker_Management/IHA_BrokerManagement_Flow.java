package IHA_Broker_Management;

import Pages.Home_Page;
import Pages.Login_Page;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import Pages.Agency_Page;
import Pages.CreateYourAccount;
import Pages.EmailLogs;
import Pages.GroupDashboard_Page;
import Pages.Agency_Details_Page;
import Pages.AssignAccount_Page;
import Pages.GroupInformation_Page;
import Pages.SendNotifications_Page;

public class IHA_BrokerManagement_Flow extends Broker_Management_AllScenarios{
	
	Home_Page Home_Page = new Home_Page();
	Agency_Page agency_Page = new Agency_Page();
	Agency_Details_Page agency_Details_Page = new Agency_Details_Page();
	EmailLogs EmailLogs = new EmailLogs();
	CreateYourAccount CreateYourAccount = new CreateYourAccount();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	Login_Page Login_Page = new Login_Page();
	AssignAccount_Page assignAccount_Page = new AssignAccount_Page();
	GroupInformation_Page groupInformation_Page = new GroupInformation_Page();
	SendNotifications_Page sendNotifications_Page = new SendNotifications_Page();

	public void ValidateIHA_Transactions_Flow(String testScenario, String Role, String Password,String AccountName,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException {
		
		//Click on More Tab
		Home_Page.ClickOnMoreTab();
		//Click On Broker Management
		Home_Page.ClickOnBrokerManagement();
		
		/////*****Add Agency*****/////
		//Click on Add Agency Button
		agency_Page.ClickOnAddAgencyButton();
		//Enter SF Entity ID
		agency_Page.EnterSFEntityId();
		//Enter the Agency Name
		String AgencyName = agency_Page.EnterAgencyName();
		//Select the Agency Type
		agency_Page.selectAgencyType(Role);
		//Click on Save Button
		agency_Page.ClickOnSaveButton();
		//Click on OK Button
		agency_Page.ClickOnOKButton();
		//Enter the Agency name in Search Bar
		agency_Page.EnterAgencyNameInSearchBar(AgencyName);
		//Click on the Search Icon
		agency_Page.ClickOnSearchIcon();
		//Validate the Agency name
		agency_Page.AgencyNameValidation(AgencyName);
		//Click on the Agency name in the Grid
		agency_Page.ClickOnAgencyNameInGrid();
		
		/////*****Edit Agency*****/////
		//Click on the Edit button
//		agency_Details_Page.ClickOnEditButton();
		//Modify the Agency Name
//		agency_Details_Page.EditAgencyName();
		//Click on Save Button
//		agency_Details_Page.ClickOnSaveButton();
		//Click on OK Button
//		agency_Details_Page.ClickOnOKButton();
		//Validate if the Agency Name is updated or not
//		agency_Details_Page.UpdatedAgencyNameValidation(AgencyName);
		
		/////*****Add Contact*****/////
		//Click on Add Contact button
		agency_Details_Page.ClickOnAddContactButton();
		//Enter the SF Entity ID
		agency_Details_Page.EnterSFEntityId();
		//Enter the Personal Details
		String Fullname = agency_Details_Page.EnterPersonalDetails();
		//Remove the space between the First Name and Last name
		String Fullname1 = Fullname.replace(" ","");
		//Click on Save Button
		agency_Details_Page.ClickOnSaveButton();
		//Click on OK Button
		agency_Details_Page.ClickOnOKButton();
		
		/////*****Request Online Access*****/////
		//Click on the Request Online Access
		agency_Details_Page.ClickOnRequestOnlineAccess();
		//Click on OK Button
		agency_Page.ClickOnOKButton();
		//Click on the Communication Tab
		Home_Page.clickCommunicationTab();
		//Click on the Email Log
		Home_Page.ClickOnEmailLog();
		Thread.sleep(20000);
		WaitForLoadAnimationDisappear();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		//Enter the First Name
		EmailLogs.EnterFirstNameEmailLogEnterSearchField(Fullname);
		//Click on the Email Log search button
		EmailLogs.ClickOnEmailLogSearchIcon();
		//Click on the View Icon
		EmailLogs.ClickOnViewIcon();
		//Validate if the HI <Full Name> is displayed
		EmailLogs.FullNameValidationinResendMail(Fullname);
		//Click on Registration Link
		EmailLogs.ClickOnRegistrationLink();
		
		/////*****Register Check*****/////
		//Enter the User Name
		String UserName = Fullname1+"_agent123";
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
		
		/////*****Add Account*****/////
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
		agency_Page.EnterAgencyNameInSearchBar(AgencyName);
		//Click on the Search Icon
		agency_Page.ClickOnSearchIcon();
		//Click on the Agency name in the Grid
		agency_Page.ClickOnAgencyNameInGrid();
		//Click on the Contact Name in the Contact List
		agency_Details_Page.ClickOnContactNameInGrid(Fullname);
		//Click on the Add Account Button
		agency_Details_Page.ClickOnAddAccountButton();
		//Search for the group in the Search Bar
		assignAccount_Page.SelectGroupname(AccountName);
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
		//Validate if the Account Name is displayed
		assignAccount_Page.AccountNameValidationUnderContactInfo(AccountName);
		//Click on the Account Name
		agency_Details_Page.ClickOnAccountName();
		//Click on the Close Button
		agency_Details_Page.ClickOnCloseButton();
		//Click on the Home Page Tab
		Home_Page.clickHomePage();
		//Search for the group in the Search Bar
		Home_Page.SelectGroupname(AccountName);
		//Click on the Group Information Tab
		Group_Page.clickGroupInformation();
		//Click on Broker Tab
		groupInformation_Page.ClickOnBrokerTab();
		//Validate if the Contact Name is displayed or not
		groupInformation_Page.validateNameIsPresent(Fullname);
		//Click on Home Button
		Home_Page.clickHomePage();
		//Click on the Communication Tab
		Home_Page.clickCommunicationTab();
		//Click on the Email Log
		Home_Page.ClickOnEmailLog();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		//Enter the First Name
		EmailLogs.EnterFirstNameEmailLogEnterSearchField(Fullname);
		//Click on the Email Log search button
		EmailLogs.ClickOnEmailLogSearchIcon();
		//Validate if the Contact Name is displayed
		EmailLogs.validatename(Fullname);
		//Click on the View Icon
		EmailLogs.ClickOnViewIcon();
		//Validate if View Email is displayed
		EmailLogs.ValidateViewEmail();
		
		/////*****Send Notification*****/////
		//Click on More Tab
		Home_Page.ClickOnMoreTab();
		//Click On Broker Management
		Home_Page.ClickOnBrokerManagement();
		//Enter the Agency name in Search Bar
		agency_Page.EnterAgencyNameInSearchBar(AgencyName);
		//Click on the Search Icon
		agency_Page.ClickOnSearchIcon();
		//Click on the Agency name in the Grid
		agency_Page.ClickOnAgencyNameInGrid();
		//Click on Checkbox Corresponding to the Contact Name
		agency_Details_Page.ClickOnCheckboxofContactName(Fullname);
		//Click on the Send Notification Button
		agency_Details_Page.ClickOnSendNotificationButton();
		//Enter the Subject
		sendNotifications_Page.EnterSubject(testdata);
		//Enter the Body
		sendNotifications_Page.EnterBody(testdata);
		//Click on Send Button
		sendNotifications_Page.ClickOnSendButton();
		//Click on OK button
		sendNotifications_Page.ClickOnOKButton();
		//Click on the Home Page Button
		Home_Page.clickHomePage();
		//Click on the Communication Tab
		Home_Page.clickCommunicationTab();
		//Click on the Email Log
		Home_Page.ClickOnEmailLog();
		RefreshPage();
		//WaitForLoadAnimationDisappear();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		//Validate entry for the Send Notification
		sendNotifications_Page.NameSubjectValidation(Fullname,testdata);
		/////*****Terminate Contact*****/////
		//Click on More Tab
		Home_Page.ClickOnMoreTab();
		//Click On Broker Management
		Home_Page.ClickOnBrokerManagement();
		//Enter the Agency name in Search Bar
		agency_Page.EnterAgencyNameInSearchBar(AgencyName);
		//Click on the Search Icon
		agency_Page.ClickOnSearchIcon();
		//Click on the Agency name in the Grid
		agency_Page.ClickOnAgencyNameInGrid();
		//Click on Checkbox Corresponding to the Contact Name
		agency_Details_Page.ClickOnCheckboxofContactName(Fullname);
		//Click on the Terminate Button
		agency_Details_Page.ClickOnTerminateButton();
		//Click on Yes Confirmation popup
		agency_Page.ClickOnYesButton();
		//Click on OK button
		agency_Details_Page.ClickOnOKButton();
		//Click on Home Page
		Home_Page.clickHomePage();
		//Search for the group in the Search Bar
		Home_Page.SelectGroupname(AccountName);
		//Click on the Group Information Tab
		Group_Page.clickGroupInformation();
		//Click on Broker Tab
		groupInformation_Page.ClickOnBrokerTab();
		//Validate if the Contact Name is displayed or not
		groupInformation_Page.validateNameIsNotPresent(Fullname);
		
		/////*****Terminate Agency*****/////
		//Click on Home Page Button
		Home_Page.clickHomePage();
		//Click on More Tab
		Home_Page.ClickOnMoreTab();
		//Click On Broker Management
		Home_Page.ClickOnBrokerManagement();
		//Enter the Agency name in Search Bar
		agency_Page.EnterAgencyNameInSearchBar(AgencyName);
		//Click on the Search Icon
		agency_Page.ClickOnSearchIcon();
		//Click on the Check box besides the Agency Name
		agency_Page.ClickOnCheckboxofAgencyName(AgencyName);
		//Click on the Terminate Button
		agency_Page.ClickOnTerminateButton();
		//Click on Yes Confirmation popup
		agency_Page.ClickOnYesButton();
		//Click on OK Button
		agency_Page.ClickOnOKButton();
		//Enter the Agency name in Search Bar
		agency_Page.EnterAgencyNameInSearchBar(AgencyName);
		//Click on the Search Icon
		agency_Page.ClickOnSearchIcon();
		//Validate if the Checkvbox is disabled
		agency_Page.CheckboxValidationForAgencyName(AgencyName);
		
	}

}
