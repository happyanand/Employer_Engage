package FBMC_Admin_BA_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import Pages.CorrespondenceLetters_Page;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollReHire_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.ReHire_Page;
import Pages.TerminateEmployee_Page;
import Pages.ViewCoverage_Page;


public class FBMC_EmployeeReHireEnrollFlow extends FBMC_Admin_BA_AllScenarios
{
	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	TerminateEmployee_Page terminateEmployeePage=new TerminateEmployee_Page();
	ViewCoverage_Page viewCoveragePage=new ViewCoverage_Page();
	ReHire_Page reHirePage=new ReHire_Page();
	EnrollReHire_Page enrollNewHirePage=new EnrollReHire_Page();
    CorrespondenceLetters_Page CCLetterVerification=new CorrespondenceLetters_Page();
    
    //Employee ReHire Enroll
	public void ValidateEmployeeReHireEnroll(String TestScenario,String GroupName,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException
	{
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
        List<String> planCategories=enrollmentPage.getSelectedCategories();
        //Add Additional Insurance
        enrollmentPage.addAdditionalInsurance(false,testdata);
        //click Next
        enrollmentPage.clickNext();
        //Add Profile With PensionAuthority
        enrollmentPage.addProfileWithPensionAuthority(false);
        //Submit Enrollment
        enrollmentPage.submitEnrollment();
        //Customer Number Return
      	String CustomerNo = enrollmentSummaryPage.CustomerNumberReturn();
        //Navigate To Group Dashboard
        Group_Page.navigateToGroupDashboard();
		//Click EmployeeAdministration
		Group_Page.clickEmployeeAdministration();
		//Search And Navigate To EmployeeInfo
		employeeAdministration.searchAndNavigateToEmployeeInfo(CustomerNo);
		//Click Terminate
		employeeInformationPage.clickTerminate();
        //Terminate Employee
        terminateEmployeePage.terminateEmployee(testdata.get("TerminationDate").toString());
        //Employee Termination Message Displayed
        terminateEmployeePage.isEmployeeTerminationMessageDisplayed();
        //Navigate To Group Dashboard
        Group_Page.navigateToGroupDashboard();
        //Click Employee Administration
        Group_Page.clickEmployeeAdministration();
        //Search And Navigate To EmployeeInfo
        employeeAdministration.searchAndNavigateToEmployeeInfo(CustomerNo);
        //click ReHire
        employeeInformationPage.clickReHire();
        //ReHire And Enroll
        reHirePage.reHireAndEnroll();
        //click Next
        enrollNewHirePage.clickNext();
        //Select Plan
        enrollNewHirePage.selectPlan("Vision");
        //Add Additional Insurance
        enrollmentPage.addAdditionalInsurance(false,testdata);
        //click Next
        enrollmentPage.clickNext();
        //Add Payment Profile
        enrollmentPage.addProfileWithPensionAuthority(false);
        //Submit Enrollment
        enrollmentPage.submitEnrollment();
        //enrollmentSummaryPage.verifyCoverageEndDateAfterReHire(planCategories,"Vision",testdata.get("TerminateDate").toString());	
        //Close Enrollment Summary
      	enrollmentSummaryPage.closeEnrollmentSummary();
      	
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