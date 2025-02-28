package Speridian_User_Admin_Registration_TCs;

import java.awt.AWTException;
import java.io.IOException;

import Pages.CreateYourAccount;
import Pages.EmailLogs;
import Pages.GroupContactUser_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Login_Page;
import Pages.LoginHistory_Page;

public class Speridian_BAAdmin_Add_Edit_Delete_Flow extends Speridian_User_Admin_Registration_AllScenarios{
	
	Home_Page Home_Page = new Home_Page();
	GroupContactUser_Page GroupContactUser = new GroupContactUser_Page();
	EmailLogs EmailLogs = new EmailLogs();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	CreateYourAccount CreateYourAccount = new CreateYourAccount();
	Login_Page Login_Page = new Login_Page();
	LoginHistory_Page LoginHistory_Page = new LoginHistory_Page();
	
	public void ValidateSperidian_BAAdmin_Add_Edit_Delete_Flow(String TestScenario,String GroupName,String PhoneNo,
			String EmailId, String Group, String Password) throws InterruptedException, AWTException, IOException 
	{
		//Click on User Administration Tab
		Home_Page.ClickOnUserAdministration();
		//Click on Group Contact User
		GroupContactUser.ClickOnGroupContactUsersTab();
		//Click on Add Group Contact Button
		GroupContactUser.ClickOnAddGroupContactButton();
		//Enter the First Name
		String FirstName =GroupContactUser.EnterFirstName();
		//Print the First Name
		System.out.println("First Name"+FirstName);
		//Enter Last Name
		String LastName =GroupContactUser.EnterLastName();
		//Print the Last Name
		System.out.println("Last Name"+LastName);
		//Concate the First Name and Last Name
		String FullName =FirstName+" "+LastName;
		String FullName1 =FirstName+LastName;
		//Print the Full Name
		System.out.println("Full Name"+FullName);
		//Enter the Phone Number
		GroupContactUser.EnterPhoneNumber(PhoneNo);
		//Enter the Email Id
		GroupContactUser.EnterEmailId(EmailId);
		//Select the Group from the dropdown
		GroupContactUser.SelectSperidianGroupDropDownValue(Group);
		//Click on the Benefits Administration
		GroupContactUser.ClickOnBenefitAdministrationButton();
		//Click on the Submit button
		GroupContactUser.ClickOnSubmitButton();
		//Click on the Confirmation Pop up
		GroupContactUser.ClickOnConfirmationPopupOkButton();
		//Enter the First Name 
		GroupContactUser.EnterFirstNameForSearch(FullName);
		//Click on the Search button
		GroupContactUser.ClickOnSearchIcon();
		//Click on the Request Online Access
		GroupContactUser.ClickOnRequestOnlineAccess();
		//Click on Confirmation Register Online Ok Button
		GroupContactUser.ClickOnConfirmationRegisterOnlineOkButton();
		//Click on the Communication Tab
		Home_Page.clickCommunicationTab();
		//Click on the Email Log
		Home_Page.ClickOnEmailLog();
		Thread.sleep(3000);
		RefreshPage();
		Thread.sleep(3000);
		RefreshPage();
		//Enter the First Name
		EmailLogs.EnterFirstNameEmailLogEnterSearchField(FullName);
		//Click on the Email Log search button
		EmailLogs.ClickOnEmailLogSearchIcon();
		//Click on the View Icon
		EmailLogs.ClickOnViewIcon();
		//Click on Registration Link
		EmailLogs.ClickOnRegistrationLink();
		
		/////*****Register Check*****/////
		//Enter the User Name
		String UserName = FullName1+"_UserBA123";
		CreateYourAccount.EnterCreateUserName(UserName);
		System.out.println("User Name"+UserName);
		//Enter the Password
		CreateYourAccount.EnterCreatePassworde(Password);
		//Enter the Confirm Password
		CreateYourAccount.EnterCreateConfirmPassworde(Password);
		//Click on the Policy And Terms CheckBox
		CreateYourAccount.ClickOnPriPolicyAndTermsConCheckBox();
		//Click on the I Accept Button
		CreateYourAccount.ClickOnIAcceptButton();
		//Click on the Create User Registration button
		CreateYourAccount.ClickOnCreateUserRegistrationButton();
		//Click on the Click Here to Login Link
		CreateYourAccount.ClickOnClickHereToLoginLink();
		//Enter the Username
		Login_Page.EnterUserNameField(UserName);
		//Enter the Passwrod
		Login_Page.EnterPasswordField(Password);
		//Click on the Login Button
		Login_Page.ClickOnLoginButton();
		//Click Employee Administration Tile
		Group_Page.clickEmployeeAdministration();
		//Navigate to GroupDashboard
		Group_Page.navigateToGroupDashboard();
		//Click Group Information Tile
		Group_Page.clickGroupInformation();
		//Navigate to GroupDashboard
		Group_Page.navigateToGroupDashboard();
		//Click on ManageCoverage tile
		Group_Page.clickManageCoverage();
		//Navigate to Dashboard
		Group_Page.navigateToGroupDashboard();
		// Click Renewal Center
		Group_Page.clickRenewalCenter();
		//Navigate to GroupDashboard
		Group_Page.navigateToGroupDashboard();
		//Click Review Employee Transactions Tile
		Group_Page.navigateToReviewEmployeeTransactions();
		//Navigate to GroupDashboard
		Group_Page.navigateToGroupDashboard();
		//Click Reporting Tile
		Group_Page.clickReporting();
		//Navigate to GroupDashboard
		Group_Page.navigateToGroupDashboard();
		//Logout from Admin
		Group_Page.Logout1();
		WaitForPageLoad();
		
		/////*****History Check*****/////
		//Enter the Admin Username
		Login_Page.EnterUserNameField("tpaadmin@Speridian.com");
		//Enter the Password
		Login_Page.EnterPasswordField("Speri@dm1n$2015");
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		//Click on User Administration Tab
		Home_Page.ClickOnUserAdministration();
		//CLick Login History Tab
		LoginHistory_Page.ClickOnLoginHistory();
		//Search the username
		GroupContactUser.EnterFirstNameForSearch(FirstName);
		//Click onn the Search Icon
		GroupContactUser.ClickOnSearchIcon();
		//Validate if the Records are present in the Login History Tab
		LoginHistory_Page.validateUsernamerecords(UserName);
		//Click on the Group Contact Users
		GroupContactUser.ClickOnGroupContactUsersTab();
		//Search the username
		GroupContactUser.EnterFirstNameForSearch(FirstName);
		//Click onn the Search Icon
		GroupContactUser.ClickOnSearchIcon();
		
		/////*****Edit Check*****/////
		//Click on the User
		GroupContactUser.ClickUserProfileEditButton();
		//Select the Client Administrator
		GroupContactUser.updateInActiveAdministrator();
		//Click the Update Button
		GroupContactUser.clickUpdateButton();
		//Click on the OK button
		GroupContactUser.clickOKButton();
		//Logout from the Admin
		Group_Page.Logout1();
		//Enter the Username
		Login_Page.EnterUserNameField(UserName);
		//Enter the Passwrod
		Login_Page.EnterPasswordField(Password);
		//Click on the Login Button
		Login_Page.ClickOnLoginButton();
		//Click Employee Administration Tile
		Group_Page.clickEmployeeAdministration();
		//Navigate to GroupDashboard
		Group_Page.navigateToGroupDashboard();
		//Logout from Admin
		Group_Page.Logout1();
		
		/////*****Delete Check*****/////
		//Enter the Admin Username
		Login_Page.EnterUserNameField("tpaadmin@Speridian.com");
		//Enter the Password
		Login_Page.EnterPasswordField("Speri@dm1n$2015");
		//Click on the Login Button
		Login_Page.ClickOnLoginButton();
		//Click on User Administration Tab
		Home_Page.ClickOnUserAdministration();
		//Click on the Group Contact Users
		GroupContactUser.ClickOnGroupContactUsersTab();
		//Search the username
		GroupContactUser.EnterFirstNameForSearch(FirstName);
		//Click onn the Search Icon
		GroupContactUser.ClickOnSearchIcon();
		//Click on the Delete button
		GroupContactUser.clickDeleteButton();
		//Click on Yes button
		GroupContactUser.clickYesButton();
		//Click on OK button
		GroupContactUser.clickOKButton();
		//Validate if No Records Found text is displayed or not
		GroupContactUser.validateNoRecordsFound();
	}
}
