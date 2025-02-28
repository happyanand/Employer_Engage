package IHA_Admin_BA_TCs;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.QEEnrollment_ChangePlan_Page;
import Pages.ViewCoverage_Page;

public class IHA_ReEnrollMedicalFlow extends IHA_Admin_BA_AllScenarios {
	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	QEEnrollment_ChangePlan_Page qe_cp_Page = new QEEnrollment_ChangePlan_Page();
	
	public void ValidateReEnrollMedical(String TestScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException, IOException 
	{	
		//Select Group Name
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
		
		//Terminate Medical
		//Click on Terminate button
		ViewCoverage_Page.ClickonTerminateMedicalButton();
		//Click OnTerminate Plan
		ViewCoverage_Page.Terminateplan(testdata);
		//Close the Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		
		//Update Success Response Steps
		//Navigate and click on the Carrier Response Update Button
//		Group_Page.navigateToCarrierResponseUpdateOnHeader();
		//Update Success Response
//		memberAdministration_Page.UpdateSuccessResponse(ssn);
		//Search the Employee
//		manageCoverage_Page.searchEmployee(ssn);
		
		//ReEnroll Steps
		//Click on Medical Dropdown
//		ViewCoverage_Page.ClickOnMedicalDropdown();//Commented out line no 86. Ramya created the generic method.
//		ViewCoverage_Page.ClickOnPlanDropdown(testdata.get("planName").toString());
		//Click on Enroll button
		ViewCoverage_Page.clickEnrollMedicalinPlan();
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		//Select the Employee Status
		qe_cp_Page.employmentStatus();
		// Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		// Select the different sub plan
		qe_cp_Page.selectPlan();
		// Click on the Submit button
		qe_cp_Page.clickSubmit();
		// Verify the changes made
		Assert.assertEquals(enrollmentSummaryPage.checkEnrollmentDate(testdata),
				enrollmentSummaryPage.VerifyEnrollmentDate(enrollmentSummaryPage.date), "Assertion Passed");
		// Download the Summary document
		enrollmentSummaryPage.downloadSummaryDocument();
		
		//Update Member Id steps
		//Navigate and click on the Carrier Response Update Button
//		Group_Page.navigateToCarrierResponseUpdateOnHeader();
		//Update Member Id
//		memberAdministration_Page.updateMemberId(ssn);
		//Search the Employee
//		manageCoverage_Page.searchEmployee(ssn);
		
	}
}