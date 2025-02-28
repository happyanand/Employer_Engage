package FBMC_User_Admin_Registration_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import Pages.*;

public class FBMC_userprofile_Add_Edit_Delete_CorrespondenceAdmin_Flow  extends FBMC_User_Admin_Registration_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	GroupContactUser_Page GroupContactUser = new GroupContactUser_Page();
	EmailLogs EmailLogs = new EmailLogs();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	CreateYourAccount CreateYourAccount = new CreateYourAccount();
	Login_Page Login_Page = new Login_Page();
	LoginHistory_Page LoginHistory = new LoginHistory_Page();
	EmployeeAdministration_Page EmployeeAdministration_Page =new EmployeeAdministration_Page();
	UserProfile_Page UserProfile_Page=new UserProfile_Page();
	
	
	public void ValidateFBMC_userprofile_Add_Edit_Delete_CorrespondenceAdmin_Flow(String TestScenario,String GroupName,String PhoneNo,String EmailId, String Group, String Group2,String Password,String SecurityQuestion1,String SecurityAnswer1,String SecurityQuestion2,String SecurityAnswer2,String SecurityQuestion3,String SecurityAnswer3, String EmploySearch) throws InterruptedException, AWTException, IOException {
		String AdminUserName = configloader().getProperty("FBMCAdmin_UserName");
		String AdminUserPassword = configloader().getProperty("FBMCAdmin_Password");
		Home_Page.ClickOnMoreTab();
		Home_Page.ClickOnUserAdministration();
		UserProfile_Page.ClickOnAddUser();
		String FirstName=RandomName();
		String LastName=RandomName();
		String EmailID1=RandomEmail();
		UserProfile_Page.modifyFirstName(FirstName);
		UserProfile_Page.modifyLastName(LastName);
		//UserProfile_Page.EnterEmailId(EmailId);
		UserProfile_Page.EnterEmailId(EmailID1);
		UserProfile_Page.SelectUserRole("Correspondence Admin");
//		UserProfile_Page.SelectUserRole("Finance+Correspondence Admin");Correspondence Admin
		UserProfile_Page.ClickOnSubmitButton();
		GroupContactUser.ClickOnConfirmationPopupOkButton();
		String FullName1 =FirstName+LastName;
		UserProfile_Page.EnterNameForSearch(FullName1);
		UserProfile_Page.ClickOnSearchIcon();
		UserProfile_Page.ClickOnRequestOnlineAccess();
		GroupContactUser.ClickOnConfirmationPopupOkButton();
		WaitForPageLoad();
		Home_Page.clickCommunicationTab();
		Home_Page.ClickOnEmailLog();
		Thread.sleep(3000);
		RefreshPage();
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		Thread.sleep(3000);
		RefreshPage();
		Thread.sleep(3000);
		RefreshPage();
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
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
//		Home_Page.SelectGroupname(Group);
		Home_Page.checkCommunicationTabExist();
		Home_Page.CheckBillingPaymentTabNotDispaly();
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
		///Edit Flow ///
		UserProfile_Page.ClickOnUserProfile();
		UserProfile_Page.EnterNameForSearch(FirstName);
		UserProfile_Page.ClickOnSearchIcon();
		GroupContactUser.ClickUserProfileEditButton();
		UserProfile_Page.SelectUserRole("Finance Admin");
		//Select the Client Administrator
		//GroupContactUser.ClickOnEnrollmentSupportButton();
		//Click the Update Button
		UserProfile_Page.ClickOnUpdateButton();
		//Click on the OK button
		GroupContactUser.clickOKButton();
		Logout1();
		Login_Page.EnterUserNameField(UserName);
		//Login_Page.EnterUserNameField(AdminUserName);
		Login_Page.EnterPasswordField(Password);
		Login_Page.ClickOnLoginButton();
		Home_Page.CheckCommunicationTabNotDispaly();
		Home_Page.CheckBillingPaymentTab();
		Home_Page.SelectGroupname(Group);
		// Click On Employee Administration
		Group_Page.clickEmployeeAdministration();
		//Select Any employee or Search any Employee
		EmployeeAdministration_Page.searchAndNavigateToEmployeeInfo(EmploySearch);
		Logout1();	
		///Delete Flow ///	
		Login_Page.EnterUserNameField(AdminUserName);
		Login_Page.EnterPasswordField(AdminUserPassword);
		Login_Page.ClickOnLoginButton();
		Home_Page.ClickOnMoreTab();
		Home_Page.ClickOnUserAdministration();
		UserProfile_Page.EnterNameForSearch(FirstName);
		UserProfile_Page.ClickOnSearchIcon();
		GroupContactUser.ClickUserProfileDeleteButton();
		GroupContactUser.ClickOnConfirmationPopupYesButton();
		GroupContactUser.ClickOnConfirmationPopupOkButton();
		String Msg =GroupContactUser.GetNoRecordsMsg();
		System.out.println("Debug messag Gu :"+Msg);
		Assert.assertTrue(Msg.contains("No Records Found"));


	}
}
