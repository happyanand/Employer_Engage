package IHA_User_Admin_Registration_TCs;

import java.awt.AWTException;
import java.io.IOException;

import Pages.CreateYourAccount;
import Pages.EmailLogs;
import Pages.GroupContactUser_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.LoginHistory_Page;
import Pages.Login_Page;
import Pages.UserProfile_Page;
//Add User Profile user with IHA_Admin_VIP role.
public class IHA_Userprofile_Add_Edit_Delete_IHA_Admin_VIP_Flow extends IHA_User_Admin_Registration_AllScenarios{
	
	Home_Page Home_Page = new Home_Page();
	GroupContactUser_Page GroupContactUser = new GroupContactUser_Page();
	EmailLogs EmailLogs = new EmailLogs();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	CreateYourAccount CreateYourAccount = new CreateYourAccount();
	Login_Page Login_Page = new Login_Page();
	LoginHistory_Page LoginHistory_Page = new LoginHistory_Page();
	UserProfile_Page UP_Page = new UserProfile_Page();
	public void ValidateIHA_Userprofile_Add_Edit_Delete_IHA_Admin_VIP_Flow(String TestScenario,String GroupName,String PhoneNo,
			String EmailId,String Role, String Password) throws InterruptedException, AWTException, IOException 
	{			
				//Click on More Tab
				Home_Page.ClickOnMoreTab();
				//Click on User Administration Tab
				Home_Page.ClickOnUserAdministration();
				//Click on Add User
				UP_Page.ClickOnAddUser();
				//Enter the First Name
				String FirstName =GroupContactUser.EnterFirstName();
				//Enter Last Name
				String LastName =GroupContactUser.EnterLastName();
				//Concate the First Name and Last Name
				String FullName =FirstName+" "+LastName;
				String FullName1 =FirstName+LastName;
				//Print the Full Name
				System.out.println("Full Name: "+FullName);
				//Select the User Role
				GroupContactUser.selectUserRole(Role);
				//Enter the Email Id
				GroupContactUser.EnterEmailId(EmailId);
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
				Thread.sleep(20000);
				WaitForLoadAnimationDisappear();
				RefreshPage();
				Thread.sleep(20000);
				WaitForLoadAnimationDisappear();
				Thread.sleep(20000);
				RefreshPage();
				WaitForLoadAnimationDisappear();
				Thread.sleep(20000);
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
				String UserName = FullName1+"_UserAdmin123";
				CreateYourAccount.EnterIHACreateUserName(UserName);
				System.out.println("User Name"+UserName);
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
				
				/////*****History Check*****/////
				//Enter the Admin Username
				Login_Page.EnterUserNameField("sa");
				//Enter the Password
				Login_Page.EnterPasswordField("password$123");
				//Click on the Login Button
		        Login_Page.ClickOnLoginButton();
		        Home_Page.ClickOnMoreTab();
				//Click on User Administration Tab
				Home_Page.ClickOnUserAdministration();
				//CLick Login History Tab
				LoginHistory_Page.ClickOnLoginHistory();
				//Search the First name
				GroupContactUser.EnterFirstNameForSearch(FirstName);
				//Click onn the Search Icon
				GroupContactUser.ClickOnSearchIcon();
				//Validate if the Records are present in the Login History Tab
				LoginHistory_Page.validateUsernamerecords(UserName);
				//Click on the User Profile Tab
				UP_Page.ClickOnUserProfile();
				//Search the First name in the User Profile Tab
				//Search the First name
				GroupContactUser.EnterFirstNameForSearch(FirstName);
				//Click onn the Search Icon
				GroupContactUser.ClickOnSearchIcon();
				
				/////*****Edit Check*****/////
				//Click on the Edit button
				GroupContactUser.ClickUserProfileEditButton();
				//Modify the First Name
				String FirstName1 = FirstName + "123";
				//Enter the First Name
				UP_Page.modifyFirstName(FirstName1);
				//Modify the Last Name
				String LastName1 = LastName+"123";
				//Enter the First Name
				UP_Page.modifyLastName(LastName1);
				//Concate the First Name and Last Name
				//String FullName2 =FirstName1+" "+LastName1;
				//Click the Update Button
				GroupContactUser.clickUpdateButton();
				//Click on the OK button
				Thread.sleep(1000);
				GroupContactUser.clickOKButton();
				
				/////*****Delete Check*****/////
				//Search the Full name in the Group Contact Users Tab
				//UA_Page.searchUser(FullName2);
				//Click on the Delete button
				GroupContactUser.clickDeleteButton();
				//Click on Yes button
				GroupContactUser.clickYesButton();
				Thread.sleep(1000);
				//Click on OK button
				GroupContactUser.clickOKButton();
				//Validate if No Records Found text is displayed or not
				GroupContactUser.validateNoRecordsFound();
	}
}
