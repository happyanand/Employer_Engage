package IHA_User_Admin_Registration_TCs;

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

public class IHA_Employee_Edit_registrationFlow extends IHA_User_Admin_Registration_AllScenarios {
	
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
	public void ValidateIHA_Employee_Edit_registrationFlow(String TestScenario,String Group,Map<Object, Object> testdata,String Password) throws InterruptedException {       	
	
		//Select the Group Name
		Home_Page.SelectGroupname(Group);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
        String result = employeePage.addIHAPersonalInformation(testdata);
		String[] values = result.split(",");	
		String firstname = values[1];
		String lastname = values[2];
		String fullname = firstname+" "+lastname;
	    //Add Notes
        employeePage.addNotes(testdata.get("NotesPrivate").toString());
        //Click on Activate Button
        employeePage.activate();
		employeeInformationPage.clickEditbtn();
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
		WaitForLoadAnimationDisappear();
		employeeAdministration.checkbox();
		//Request Online Access
		employeeAdministration.requestOnlineAccess();
		//Click Home Icon
		Home_Page.clickHomePage();
		//Click Communication Tab
		Home_Page.clickCommunicationTab();
		//Click on EmailLog
		Home_Page.ClickOnEmailLog();
		WaitForLoadAnimationDisappear();
		Thread.sleep(10000);
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
		WaitForLoadAnimationDisappear();
		Thread.sleep(10000);
		//Search with Name
		emaillog.EnterFirstNameEmailLogEnterSearchField(fullname);
		//Click on Search Icon
		emaillog.ClickOnEmailLogSearchIcon();
		WaitForLoadAnimationDisappear();
		Thread.sleep(5000);
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
		//validate Login Page
		System.out.println("fn" +fullname);
		Assert.assertEquals(fullname, Home_Page.getLoggedInUserName());
	
	}
	
}
