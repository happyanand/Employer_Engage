package Speridian_Content_Management_TCs;

import java.awt.AWTException;
import java.util.Map;

import com.BasePackage.Base_Class;

import Pages.ContentManagement_Page;
import Pages.EmailLogs;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Notifications_Page;
import Pages.Payment_Profile;
import Pages.ViewCoverage_Page;

public class Speridian_ContentManagement_Employee_Registration_Notifications_Flow extends Speridian_Content_Management_AllScenarios{
	
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
	EmailLogs EmailLogs = new EmailLogs();
	
public void ValidateSperidian_ContentManagement_Employee_Registration_Notifications_Flow(String testScenario,String AccountName,Map<Object, Object> testdata) throws InterruptedException, AWTException {
		
		//Click on ContentManagement Tab
		Home_Page.CheckContentManagementTabDispaly();
		//Click on the Notifications
		contentManagementPage.ClickOnnotifications();
		//Search for Employee Registration in the Search bar.
		notifications_Page.search_Notification_Name(testdata);
		//Validate if the Status in ON.
		notifications_Page.StatusButtonONOFFValidation();
		//Click on Home Page.
		Home_Page.clickHomePage();
		// Add and Enroll Employee
		//Search and Select Group name
		Home_Page.SelectGroupname(AccountName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
		String result = employeePage.addPersonalInformation(testdata);
		String[] values = result.split(",");	
		String ssn = values[0];
		String firstname = values[1];
		// Click on activateAndEnroll
		employeePage.activateAndEnroll();
		// Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		// Select Plans
		enrollmentPage.selectSperidianPlans(false);
		// addAdditionalInsurance
		enrollmentPage.addAdditionalInsurance(false, testdata);
		// submit Enrollment
		enrollmentPage.submitEnrollment();
		String CustomerNo = enrollmentSummaryPage.CustomerNumberReturn();
		//Click on the Home Page
		Home_Page.clickHomePage();
		// Add and Enroll Employee
		//Search and Select Group name
		Home_Page.SelectGroupname(AccountName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		//Search for the Employee
		employeeAdministration.searchEmployee(CustomerNo);
		//Click on the Checkbox corresponding to the Employee
		employeeAdministration.checkbox();
		//Click on Request Online Access
		employeeAdministration.requestOnlineAccess();
		//Click on the Home Page
		Home_Page.clickHomePage();
		//Click on Communication Tab
		Home_Page.clickCommunicationTab();
		//Click on Email Log
		Home_Page.ClickOnEmailLog();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		//Enter the First Name
		EmailLogs.EnterFirstNameEmailLogEnterSearchField(firstname);
		WaitForLoadAnimationDisappear();
		//Click on the Email Log search button
		EmailLogs.ClickOnEmailLogSearchIcon();
		//Click on the View Icon
		EmailLogs.ClickOnViewIcon();
		//Check for the Notification ID
		EmailLogs.validateNotificationId();
		//Click on the Close Icon
		EmailLogs.ClickOnCloseIcon();
		
		/////*****Turn off Status Button and Verify*****/////
		//Click on ContentManagement Tab
		WaitForLoadAnimationDisappear();
		WaitForLoadAnimationDisappear();
		Home_Page.CheckContentManagementTabDispaly();
		//Click on the Notifications
		contentManagementPage.ClickOnnotifications();
		//Search for Employee Registration in the Search bar.
		notifications_Page.search_Notification_Name(testdata);
		//Click on the Status
		notifications_Page.ClickOnStatusButton();
		WaitForLoadAnimationDisappear();
		//Validate if the Status button is OFF
		notifications_Page.StatusButtonONOFFValidation();
		//Click on Home Page
		Home_Page.clickHomePage();
		// Add and Enroll Employee
		//Search and Select Group name
		Home_Page.SelectGroupname(AccountName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
		String result1 = employeePage.addPersonalInformation(testdata);
		String[] values1 = result1.split(",");	
		String ssn1 = values1[0];
		String firstname1 = values1[1];
		// Click on activateAndEnroll
		employeePage.activateAndEnroll();
		// Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		// Select Plans
		enrollmentPage.selectSperidianPlans(false);
		// addAdditionalInsurance
		enrollmentPage.addAdditionalInsurance(false, testdata);
		// submit Enrollment
		enrollmentPage.submitEnrollment();
		String NewCustomerNo = enrollmentSummaryPage.CustomerNumberReturn();
		//Click on the Home Page
		Home_Page.clickHomePage();
		// Add and Enroll Employee
		//Search and Select Group name
		Home_Page.SelectGroupname(AccountName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		//Search for the Employee
		employeeAdministration.searchEmployee(NewCustomerNo);
		//Click on the Checkbox corresponding to the Employee
		employeeAdministration.checkbox();
		//Click on Request Online Access
		employeeAdministration.requestOnlineAccess();
		//Click on the Home Page
		Home_Page.clickHomePage();
		//Click on Communication Tab
		Home_Page.clickCommunicationTab();
		//Click on Email Log
		Home_Page.ClickOnEmailLog();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		RefreshPage();
		WaitForLoadAnimationDisappear();
		//Enter the First Name
		EmailLogs.EnterFirstNameEmailLogEnterSearchField(firstname1);
		//Click on the Email Log search button
		EmailLogs.ClickOnEmailLogSearchIcon();
		//Validate if No Records Found is Displayed
		EmailLogs.validateNoRecordsFound();
		
 	}

}
