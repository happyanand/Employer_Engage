package FBMC_User_Admin_Registration_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import Pages.CascadingMembership_Page;
import Pages.CorrespondenceLetters_Page;
import Pages.CreateYourAccount;
import Pages.EditEmployee_Page;
import Pages.EmailLogs;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Login_Page;

public class FBMC_Employee_Edit_registrationFlow extends FBMC_User_Admin_Registration_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	EditEmployee_Page editEmployee= new EditEmployee_Page();
	CascadingMembership_Page cascadeScenario = new CascadingMembership_Page();
	EmailLogs emaillog = new EmailLogs();
	CreateYourAccount CreateYourAccount = new CreateYourAccount();
	Login_Page Login_Page = new Login_Page();
	CorrespondenceLetters_Page CCLetterVerification=new CorrespondenceLetters_Page();
	
	//Employee Registration through EmailLogs
    public void ValidateFBMC_Employee_Edit_registrationFlow(String TestScenario,String Group,Map<Object, Object> testdata,String Password,String SecurityQuestion1,String SecurityAnswer1,String SecurityQuestion2,String SecurityAnswer2,String SecurityQuestion3,String SecurityAnswer3) throws InterruptedException, AWTException, IOException {     	
		
    	// Select Group
		Home_Page.SelectGroupname(Group);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
		String result = employeePage.addPersonalInformation(testdata);
		String[] values = result.split(",");	
		String firstname = values[1];
		String lastname = values[2];
		String fullname = firstname+" "+lastname;
		// Activate Employee
		employeePage.activate();
		//click Edit button
		employeeInformationPage.clickEdit();
    	//Enter Email
		editEmployee.editMail(testdata);
		//click Submit Button
		cascadeScenario.clickSubmit();
	    //Navigate To Group Dashboard
		WaitForLoadAnimationDisappear();
        Group_Page.navigateToGroupDashboard();
		//Click EmployeeAdministration
		Group_Page.clickEmployeeAdministration();
		//Search And Navigate To EmployeeInfo
		employeeAdministration.searchEmployee(fullname);
		//Click CheckBox
		employeeAdministration.checkbox();
		//Request Online Access
		employeeAdministration.requestOnlineAccess();
		//Click Home Icon
		Home_Page.clickHomePage();
		//Click Communication Tab
		Home_Page.clickCommunicationTab();
		//Click on EmailLog
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
		//Search with Name
		emaillog.EnterFirstNameEmailLogEnterSearchField(fullname);
		//Click on Search Icon
		emaillog.ClickOnEmailLogSearchIcon();
		//Validate Name
		emaillog.validatename(fullname);
		//Validate Date
		String dateFormat = CCLetterVerification.getCurrentDate();
		emaillog.validatedate(dateFormat);
		//Click on View Icon
		emaillog.ClickOnViewIcon();
		//Click on Close Icon
		emaillog.ClickOnCloseIcon();
		//Click on Resend Icon
		emaillog.ClickOnResendIcon();
		//validate if Landed on Resend Email Page
		emaillog.ValidateResendEmail();
		//Edit To Mail Address 
		emaillog.EditMailAddress(testdata);
		//Click on Send Button
		emaillog.ClickOnSendButton();
		//Search with Name
		emaillog.EnterFirstNameEmailLogEnterSearchField(fullname);
		//Click on Search Icon
		emaillog.ClickOnEmailLogSearchIcon();
		//Validate Name
		emaillog.validatename(fullname);
		//Validate Email
		emaillog.validatemail(testdata.get("NewEmailID").toString());
		//Validate Date
		emaillog.validatedate(dateFormat);
		//Click on View Icon
		emaillog.ClickOnViewIcon();
		//validate if landed on view email page
		emaillog.ValidateViewEmail();
		//Click on Registration Link
		emaillog.ClickOnRegistrationLink();
		
		/////*****Register Check*****/////
		//Enter the User Name
		String UserName = firstname+"_UserEmp";
		CreateYourAccount.EnterCreateUserName(UserName);
		System.out.println("User Name"+UserName);
		//Enter the Password
		CreateYourAccount.EnterCreatePassworde(Password);
		//Enter the Confirm Password
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
		CreateYourAccount.ValidateSuccessMessage();
		CreateYourAccount.ClickOnClickHereToLoginLink();
		Login_Page.EnterUserNameField(UserName);
		System.out.println("Enter User Name" + UserName);
		Login_Page.EnterPasswordField(Password);
		System.out.println("Enter Password Name" + Password);
		Login_Page.ClickOnLoginButton();
		//validate Login Page
		Assert.assertEquals(fullname, Home_Page.getLoggedInUserName());
		
	}
}
