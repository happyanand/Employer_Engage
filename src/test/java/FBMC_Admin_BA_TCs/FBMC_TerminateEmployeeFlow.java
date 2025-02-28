package FBMC_Admin_BA_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import Pages.CorrespondenceLetters_Page;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Payment_Profile;
import Pages.TerminateEmployee_Page;
import Pages.ViewCoverage_Page;


public class FBMC_TerminateEmployeeFlow extends FBMC_Admin_BA_AllScenarios {
	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	TerminateEmployee_Page terminateEmployeePage = new TerminateEmployee_Page();
	ViewCoverage_Page viewCoveragePage = new ViewCoverage_Page();
	Payment_Profile Payment_Profile = new Payment_Profile();
	CorrespondenceLetters_Page CCLetterVerification=new CorrespondenceLetters_Page();

	//Terminate Employee
	public void ValidateTerminateEmployee(String TestScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException, IOException {
		//Select Group Name
		Home_Page.SelectGroupname(GroupName);
		//click Employee Administration
		Group_Page.clickEmployeeAdministration();
		//click Add Employee
		employeeAdministration.clickAddEmployee();
		//Add Personal Information
		String result = employeePage.addPersonalInformation(testdata);
		String[] values = result.split(",");	
		String ssn = values[0];
		String lastname = values[1];
		//Activate And Enroll Employee
		employeePage.activateAndEnroll();
		//Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		//Select Plans
		enrollmentPage.selectPlans(false);
		List<String> plans = enrollmentPage.getAllSelectedPlans();
		List<String> categories = enrollmentPage.getSelectedCategories();
		//Add Additional Insurance
		enrollmentPage.addAdditionalInsurance(false, testdata);
		//click Next
		enrollmentPage.clickNext();
		//Add Profile With PensionAuthority
		Payment_Profile.addProfileWithPensionAuthority(false);
		//Submit Enrollment
		enrollmentPage.submitEnrollment();
		// Customer Number Return
		String CustomerNo = enrollmentSummaryPage.CustomerNumberReturn();		
		//Navigate To Group Dashboard
		Group_Page.navigateToGroupDashboard();
		//click Employee Administration
		Group_Page.clickEmployeeAdministration();
		//Search And Navigate To EmployeeInfo
		//employeeAdministration.searchAndNavigateToEmployeeInfo(ssn);
		employeeAdministration.searchAndNavigateToEmployeeInfo(CustomerNo);
		//click Terminate
		employeeInformationPage.clickTerminate();
		//Terminate Employee
		terminateEmployeePage.terminateEmployee(testdata.get("TerminationDate").toString());
		//Employee Termination Message Displayed
		terminateEmployeePage.isEmployeeTerminationMessageDisplayed();
		//verify Coverage EndDate
		enrollmentSummaryPage.verifyCoverageEndDate(testdata.get("TerminationDate").toString(), plans);
		//close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		//verify Termination Date To AllPlans
		//viewCoveragePage.verifyTerminationDateToAllPlans(testdata.get("TerminationDate").toString(), categories);
		
		//Correspondence Letters
		//Click on the Employee Details
		if (loginuser_Type.equalsIgnoreCase("Admin")) {
		viewCoveragePage.ClickOnEmployeeDetails();
		//Click on Attachments Tab
		employeeInformationPage.clickAttachments();
		//Get the Letter Type of the Document
		String LetterType = employeeInformationPage.getLetterType();
		//Click on the document
		employeeInformationPage.clickDocument();
		//Click on Home Page button
		Home_Page.clickHomePage();
		//Click on the Communication Tab
		Home_Page.clickCommunicationTab();
		//Click on the Correspondence Letters
		Home_Page.clickCorrespondenceLetters();
		//Select the ALL status in Correspondence type
        CCLetterVerification.selectCTALLstatus();
        //Search for the employee in Advanced search
		CCLetterVerification.ASsearchemployee(ssn);
		//Validate the Document Name
		CCLetterVerification.validateDocumentName(CustomerNo,lastname,LetterType);
		//Click on the Document
		CCLetterVerification.clickDocument();
	  }	
   }
}
