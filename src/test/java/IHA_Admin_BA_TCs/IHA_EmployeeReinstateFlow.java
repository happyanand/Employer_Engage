package IHA_Admin_BA_TCs;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import Pages.CascadingMembership_Page;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.EmployeeReinstate_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.TerminateEmployee_Page;
import Pages.ViewCoverage_Page;

public class IHA_EmployeeReinstateFlow extends IHA_Admin_BA_AllScenarios {
	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	EmployeeReinstate_Page employeeReinstatePage = new EmployeeReinstate_Page();
	TerminateEmployee_Page terminateEmployeePage = new TerminateEmployee_Page();
	ViewCoverage_Page viewCoveragePage = new ViewCoverage_Page();
	CascadingMembership_Page cascadescenario = new CascadingMembership_Page();

	public void ValidateEmployeeReinstate(String TestScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException, IOException 
	{	
		//Select the Group Name
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
        String ssn = employeePage.addIHAPersonalInformation(testdata);
        //Click on Activate and Enroll Button
        employeePage.activateAndEnroll();
        // Enter Effective Date
        enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
        //Select Plans
        List<Map<String,String>> selectedPlanDetails=enrollmentPage.selectPlans(false);
        // Click Submit Enrollment
        enrollmentPage.submitEnrollment();
        //Verfiy the Enrolled Plans
        enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
        purgeDownloadDirectory(); //ramya
        //Download the Summary Document
        enrollmentSummaryPage.downloadSummaryDocument();
        // Assert.assertTrue(isDownloadedFileExist());//ramya
        assertEquals(GetFilesCountInDownloadDirectory(), 1);
        //Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		
		//Update Member Id steps
		//Navigate and click on the Carrier Response Update Button
//		Group_Page.navigateToCarrierResponseUpdateOnHeader();
		//Update Member Id
//		memberAdministration_Page.updateMemberId(ssn);
		//Search the Employee
//		manageCoverage_Page.searchEmployee(ssn); 
		
		//Terminate Employee Steps
		//Click on Employee Details
		viewCoveragePage.ClickOnEmployeeDetails();
		//Click on Terminate Button
		employeeInformationPage.clickTerminate();
		//Terminate Employee
		terminateEmployeePage.TerminateEmployee(testdata.get("TerminationDate").toString());
		//Click on Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		
		//Update Success Response Steps
		//Navigate and click on the Carrier Response Update Button
//		Group_Page.navigateToCarrierResponseUpdateOnHeader();
		//Update Success Response
//		memberAdministration_Page.UpdateSuccessResponse(ssn);
		//Search the Employee
//		manageCoverage_Page.searchEmployee(ssn);
		
		//Employee Reinstate Steps
		//Click on Employee Details
		viewCoveragePage.ClickOnEmployeeDetails();
		//Click on Reinstate Steps
		employeeInformationPage.clickReinstate();
		//Restore 
		employeeReinstatePage.restore();
		//Verify if the Restore Successful Message is Displayed
		Assert.assertTrue(employeeReinstatePage.isRestoreSuccessfulMessageDisplayed());
		//Click on the Manage Coverage
		employeeInformationPage.clickManageCoverage();
	}
}