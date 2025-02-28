package FBMC_User_Admin_Registration_TCs;

import java.awt.AWTException;

import Pages.CreateYourAccount;
import Pages.EmailLogs;
import Pages.GroupContactUser_Page;
import Pages.Home_Page;
import Pages.Login_Page;
import Pages.GroupDashboard_Page;

public class FBMC_ClientAdmin_RegistrationFlow extends FBMC_User_Admin_Registration_AllScenarios {
	Home_Page Home_Page = new Home_Page();
	GroupContactUser_Page GroupContactUser = new GroupContactUser_Page();
	EmailLogs EmailLogs = new EmailLogs();
	CreateYourAccount CreateYourAccount = new CreateYourAccount();
	Login_Page Login_Page = new Login_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	
	public void ValidateFBMC_ClientAdmin_RegistrationFlow(String TestScenario,String GroupName,String PhoneNo,String EmailId, String Group, String Group2,String Password,String SecurityQuestion1,String SecurityAnswer1,String SecurityQuestion2,String SecurityAnswer2,String SecurityQuestion3,String SecurityAnswer3) throws InterruptedException, AWTException {
		
		// Click On More Tab
		Home_Page.ClickOnMoreTab();
		// Click On User Administration
		Home_Page.ClickOnUserAdministration();
		// Click On Groupe Contact User
		GroupContactUser.ClickOnGroupContactUsersTab();
		// Click On Add Group Contact Button
		GroupContactUser.ClickOnAddGroupContactButton();
		// Enter First Name
		String FirstName =GroupContactUser.EnterFirstName();
		System.out.println("First Name"+FirstName);
		// Enter Last Name
		String LastName =GroupContactUser.EnterLastName();
		System.out.println("Last Name"+LastName);
		String FullName =FirstName+" "+LastName;
		String FullName1 =FirstName+LastName;
		System.out.println("Full Name"+FullName);
		// Enter Phone Number
		GroupContactUser.EnterPhoneNumber(PhoneNo);
		// Enter E-mail Id
		GroupContactUser.EnterEmailId(EmailId);
		// Select DropDown Value From Group
		GroupContactUser.SelectDropDownValueGroup(Group, Group2);
		// Click On Client Administration Button
		GroupContactUser.ClickOnClientAdministrationButton();
		// Click On Submit Button
		GroupContactUser.ClickOnSubmitButton();
		// Click On Confirmation Pop-up Ok Button
		GroupContactUser.ClickOnConfirmationPopupOkButton();
		// Enter First Name For Search Field
		GroupContactUser.EnterFirstNameForSearch(FullName);
		// Click On Search Icon
		GroupContactUser.ClickOnSearchIcon();
		// Click On Request Online Access
		GroupContactUser.ClickOnRequestOnlineAccess();
		// Click On Confirmation Register Online Ok Button
		GroupContactUser.ClickOnConfirmationRegisterOnlineOkButton();
		// Click On Communication Tab
		Home_Page.clickCommunicationTab();
		//Click On Email Log
		Home_Page.ClickOnEmailLog();
		Thread.sleep(3000);
		RefreshPage();
		Thread.sleep(3000);
		RefreshPage();
		EmailLogs.EnterFirstNameEmailLogEnterSearchField(FullName);
		EmailLogs.ClickOnEmailLogSearchIcon();
		EmailLogs.ClickOnViewIcon();
		EmailLogs.ClickOnRegistrationLink();
		String UserName = FullName1+"_UserClient123";
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
		Login_Page.EnterPasswordField(Password);
		Login_Page.ClickOnLoginButton();
		Home_Page.SelectGroupname(Group);
		// Click On Employee Administration
		Group_Page.clickEmployeeAdministration();
		// Navigate to GroupDashboard
		Group_Page.navigateToGroupDashboard();
		// Click On Group Information
		//h5[contains(text(),' Group Information ')]/ancestor::a
		Group_Page.clickGroupInformation();
		// Navigate to GroupDashboard
		Group_Page.navigateToGroupDashboard();
		// Click On Manage Coverage
		Group_Page.clickManageCoverage();
		// Navigate to GroupDashboard
		Group_Page.navigateToGroupDashboard();
		// Click On Renewal Center
		Group_Page.clickRenewalCenter();
		// Navigate to GroupDashboard
		Group_Page.navigateToGroupDashboard();
	}

}
