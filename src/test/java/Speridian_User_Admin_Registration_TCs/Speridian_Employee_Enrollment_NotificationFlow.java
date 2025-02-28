package Speridian_User_Admin_Registration_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import Pages.EmailLogs;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.ManageCoverage_Page;
import Pages.Payment_Profile;
import Pages.ViewCoverage_Page;

public class Speridian_Employee_Enrollment_NotificationFlow extends Speridian_User_Admin_Registration_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	Payment_Profile Payment_Profile = new Payment_Profile();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	ManageCoverage_Page manageCoverage_Page = new ManageCoverage_Page();
	EmailLogs emaillog = new EmailLogs();
	
	//Enrollment Notification
    public void ValidateSperidian_Employee_Enrollment_NotificationFlow(String TestScenario,String Group,Map<Object, Object> testdata,String Password) throws InterruptedException, AWTException, IOException {  
    	
		// Select Account name
		Home_Page.SelectGroupname(Group);
		// click Employee Administration
		Group_Page.clickEmployeeAdministration();
		// click Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Personal Information
		String result = employeePage.addPersonalInformation(testdata);
		String[] values = result.split(",");	
		String firstname = values[1];
		String lastname = values[2];
		String fullname = firstname+" "+lastname;
		// Activate And Enroll
		employeePage.activateAndEnroll();
		// Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		// Select Speridian Plans
		enrollmentPage.selectSperidianPlans(false);
		// Add Additional Insurance
		enrollmentPage.addAdditionalInsurance(true, testdata);
		// Submit Enrollment
		enrollmentPage.submitEnrollment();
		String CustomerNo = enrollmentSummaryPage.CustomerNumberReturn();
		//Close the Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		// Click on the View Coverage from menu
		Group_Page.clickViewCoverageOnHeader();
		//Search for the Employee
		manageCoverage_Page.searchemployee(CustomerNo);
		//Click CheckBox
		employeeAdministration.checkbox();
		//Click on Enrollment Notification
		manageCoverage_Page.enrollmentnotification();
		//Send Notification
		manageCoverage_Page.sendNotification(testdata.get("EffectiveDate").toString());
		//Click Home Icon
		Home_Page.clickHomePage();
		//Click Communication Tab
		Home_Page.clickCommunicationTab();
		//Click on EmailLog
		Home_Page.ClickOnEmailLog();
		//Search with Name
		emaillog.EnterFirstNameEmailLogEnterSearchField(fullname);
		//Click on Search Icon
		emaillog.ClickOnEmailLogSearchIcon();
		//Validate Name
		emaillog.validatename(fullname);
		//Validate Email Subject
		emaillog.validatesubject(fullname);
    	
	}
	
}
