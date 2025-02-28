package FBMC_User_Admin_Registration_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import Pages.Home_Page;
import Pages.GroupContactUser_Page;
import Pages.GroupDashboard_Page;
import Pages.EmailLogs;
import Pages.CreateYourAccount;
import Pages.Login_Page;
import Pages.LoginHistory_Page;
import Pages.EmployeeAdministration_Page;

public class FBMC_EnrollmentSupport_Add_Edit_DeleteFlow  extends FBMC_User_Admin_Registration_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	GroupContactUser_Page GroupContactUser = new GroupContactUser_Page();
	EmailLogs EmailLogs = new EmailLogs();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	CreateYourAccount CreateYourAccount = new CreateYourAccount();
	Login_Page Login_Page = new Login_Page();
	LoginHistory_Page LoginHistory = new LoginHistory_Page();
	EmployeeAdministration_Page EmployeeAdministration_Page =new EmployeeAdministration_Page();

	public void ValidateFBMC_EnrollmentSupport_Add_Edit_DeleteFlow(String TestScenario,String GroupName,String PhoneNo,String EmailId, String Group, String Group2,String Password,String SecurityQuestion1,String SecurityAnswer1,String SecurityQuestion2,String SecurityAnswer2,String SecurityQuestion3,String SecurityAnswer3, String EmploySearch) throws InterruptedException, AWTException, IOException {
		String AdminUserName = configloader().getProperty("FBMCAdmin_UserName");
		String AdminUserPassword = configloader().getProperty("FBMCAdmin_Password");


		Home_Page.ClickOnMoreTab();
		Home_Page.ClickOnUserAdministration();
		GroupContactUser.ClickOnGroupContactUsersTab();
		GroupContactUser.ClickOnAddGroupContactButton();
		String FirstName =GroupContactUser.EnterFirstName();
		System.out.println("First Name"+FirstName);
		// Enter Last Name
		String LastName =GroupContactUser.EnterLastName();
		System.out.println("Last Name"+LastName);
		String FullName =FirstName+" "+LastName;
		String FullName1 =FirstName+LastName;
		System.out.println("Full Name"+FullName);
		GroupContactUser.EnterPhoneNumber(PhoneNo);
		GroupContactUser.EnterEmailId(EmailId);
		GroupContactUser.SelectDropDownValueGroup(Group, Group2);
		GroupContactUser.ClickOnEnrollmentSupportButton();					
		GroupContactUser.ClickOnSubmitButton();
		GroupContactUser.ClickOnConfirmationPopupOkButton();
		//		Thread.sleep(3000);
		//		RefreshPage();
		//		Thread.sleep(3000);
		//		RefreshPage();
		GroupContactUser.EnterFirstNameForSearch(FirstName);//FullName
		GroupContactUser.ClickOnSearchIcon();
		GroupContactUser.ClickOnRequestOnlineAccess();
		GroupContactUser.ClickOnConfirmationRegisterOnlineOkButton();
		Home_Page.clickCommunicationTab();
		Home_Page.ClickOnEmailLog();
		Thread.sleep(3000);
		RefreshPage();
		Thread.sleep(3000);
		RefreshPage();
		EmailLogs.EnterFirstNameEmailLogEnterSearchField(FirstName);//FullName
		EmailLogs.ClickOnEmailLogSearchIcon();
		EmailLogs.ClickOnViewIcon();
		EmailLogs.ClickOnRegistrationLink();
		//	String UserName = FullName1+"_UserBA123";
		String UserName = FullName1+"_UserEnrollSupp123";
		CreateYourAccount.EnterCreateUserName(UserName);
		System.out.println("User Name"+UserName);
		CreateYourAccount.EnterCreatePassworde(Password);
		CreateYourAccount.EnterCreateConfirmPassworde(Password);
		CreateYourAccount.EnterSecurityQuestion1(SecurityQuestion1);
		CreateYourAccount.EnterSecurityAnswer1(SecurityAnswer1);
		CreateYourAccount.EnterSecurityQuestion2(SecurityQuestion2);
		CreateYourAccount.EnterSecurityAnswer2(SecurityAnswer2);
		CreateYourAccount.EnterSecurityQuestion3(SecurityQuestion3);
		CreateYourAccount.EnterSecurityAnswer3(SecurityAnswer3);
		CreateYourAccount.ClickOnPriPolicyAndTermsConCheckBox();
		CreateYourAccount.ClickOnIAcceptButton();
		CreateYourAccount.ClickOnCreateUserRegistrationButton();
		CreateYourAccount.ClickOnClickHereToLoginLink();
		Login_Page.EnterUserNameField(UserName);
		System.out.println("Enter User Name" + UserName);
		Login_Page.EnterPasswordField(Password);
		System.out.println("Enter Password Name" + Password);
		Login_Page.ClickOnLoginButton();
		Home_Page.SelectGroupname(Group);
		// Click On Group Information 
		Group_Page.clickGroupInformation();
		// Navigate to GroupDashboard
		Group_Page.navigateToGroupDashboard();
		// Click on ManageCoverage tile
		Group_Page.clickManageCoverage();
		// Navigate to GroupDashboard
		Group_Page.navigateToGroupDashboard();
		// Click Renewal Center
		Group_Page.clickRenewalCenter();
		// Click on Billingandpayment tile
		Group_Page.clickBillingandpayment();
		// Navigate to GroupDashboard
		Group_Page.navigateToGroupDashboard();
		// Click On Employee Administration
		Group_Page.clickEmployeeAdministration();
		//Select Any employee or Search any Employee
		EmployeeAdministration_Page.searchAndNavigateToEmployeeInfo(EmploySearch);
		Logout1();

		//////VAlidating Login HIstory //////

		Login_Page.EnterUserNameField(AdminUserName);
		Login_Page.EnterPasswordField(AdminUserPassword);
		Login_Page.ClickOnLoginButton();
		Home_Page.ClickOnMoreTab();
		Home_Page.ClickOnUserAdministration();
		LoginHistory.ClickOnLoginHistory();
		LoginHistory.ClickOnSearchbar(FullName1);
		LoginHistory.ClickOnSearchIcon();
		//Validate if the Records are present in the Login History Tab
		LoginHistory.validateUsernamerecords(UserName);
		Home_Page.ClickOnGroupeContactUser();
		LoginHistory.ClickOnSearchbar(FullName1);
		LoginHistory.ClickOnSearchIcon();
		GroupContactUser.ClickUserProfileEditButton();
		//Select the Client Administrator
		GroupContactUser.ClickOnBenefitAdministrationButton();
		//Click the Update Button
		GroupContactUser.clickUpdateButton();
		//Click on the OK button
		GroupContactUser.clickOKButton();
		Logout1();
		Login_Page.EnterUserNameField(UserName);
		//Login_Page.EnterUserNameField(AdminUserName);
		Login_Page.EnterPasswordField(Password);
		Login_Page.ClickOnLoginButton();
		Home_Page.SelectGroupname(Group);
		// Click On Employee Administration
		Group_Page.clickEmployeeAdministration();
		//Select Any employee or Search any Employee
		EmployeeAdministration_Page.searchAndNavigateToEmployeeInfo(EmploySearch);
		Logout1();

		///Edit Flow ///

		Login_Page.EnterUserNameField(AdminUserName);
		Login_Page.EnterPasswordField(AdminUserPassword);
		Login_Page.ClickOnLoginButton();
		Home_Page.ClickOnMoreTab();
		Home_Page.ClickOnUserAdministration();
		Home_Page.ClickOnGroupeContactUser();
		LoginHistory.ClickOnSearchbar(FullName1);
		LoginHistory.ClickOnSearchIcon();
		GroupContactUser.ClickUserProfileDeleteButton();
		GroupContactUser.ClickOnConfirmationPopupYesButton();
		GroupContactUser.ClickOnConfirmationPopupOkButton();
		String Msg =GroupContactUser.GetNoRecordsMsg();
		System.out.println("Debug messag Gu :"+Msg);
		Assert.assertTrue(Msg.contains("No Records Found"));





	}
}
