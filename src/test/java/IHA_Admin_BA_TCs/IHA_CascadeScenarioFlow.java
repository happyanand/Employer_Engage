package IHA_Admin_BA_TCs;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import Pages.CascadingMembership_Page;
import Pages.EditEmployee_Page;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.QEEnrollment_ChangePlan_Page;
import Pages.TerminateEmployee_Page;
import Pages.ViewCoverage_Page;

public class IHA_CascadeScenarioFlow extends IHA_Admin_BA_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	CascadingMembership_Page cascadeScenario = new CascadingMembership_Page();
	TerminateEmployee_Page terminateEmployeePage = new TerminateEmployee_Page();
	ViewCoverage_Page viewCoveragePage = new ViewCoverage_Page();
	EditEmployee_Page editEmployee= new EditEmployee_Page();
	QEEnrollment_ChangePlan_Page qe_cp_Page = new QEEnrollment_ChangePlan_Page();
	
	public void ValidateCascadeScenario(String TestScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException, IOException {
		purgeDownloadDirectory();
		
		//Select Group
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
        String ssn = employeePage.addIHAPersonalInformation(testdata);
        //Add Dependent
//        employeePage.addDependent(testdata);
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
        Thread.sleep(5000);
//		String CustomerNo = enrollmentSummaryPage.CustomerNumberReturn();
        String SSN_No[] =ssn.split(",");
		System.out.println("ssn no :" + SSN_No[1]);
		Group_Page.navigateToGroupDashboard();
		Group_Page.clickEmployeeAdministration();
		employeeAdministration.searchAndNavigateToEmployeeInfo(SSN_No[1]);
        //Close Enrollment Summary
//		enrollmentSummaryPage.closeEnrollmentSummary();
		
		//Update Member Id steps
		//Navigate and click on the Carrier Response Update Button
//		Group_Page.navigateToCarrierResponseUpdateOnHeader();
		//Update Member Id
//		memberAdministration_Page.updateMemberId(ssn);
		//Search the Employee
//		manageCoverage_Page.searchEmployee(ssn);
		
		// Cascade Scenario
		//click Employee Details
//		viewCoveragePage.navigateToEmployeeInfo();
		//click Edit 
		employeeInformationPage.clickEdit();
		//Edit Employee Details
		editEmployee.enterNewAddress(testdata);
		editEmployee.scrollTillDependents();
		//Add Dependent
		editEmployee.addDependent(testdata);
		//click Submit
		cascadeScenario.clickSubmit();
		Thread.sleep(5000);
//		//Click on the Manage Coverage
//		employeeInformationPage.clickManageCoverage();
//		viewCoveragePage.ChangeplanbuttonMedical();
		//click Yes CoverageRates
		editEmployee.clickYesCoverageRates();
//		WaitForPageLoad();
//		Boolean Flag =editEmployee.MessageErrorChangevisible();
//		if(Flag = true) {
//			editEmployee.ErrorOkButton();
//			WaitForPageLoad();
//			editEmployee.clickAddDependentToCoverage();
//		}
		qe_cp_Page.selectQualifyingEvent();
		//Select the Employee Status
//		qe_cp_Page.employmentStatus();//Asif Because Employment Status dropdown is Disable.
		//Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		
		cascadeScenario.clickChild();
		WaitForPageLoad();
		//Select the different sub plan
		qe_cp_Page.selectPlan();
				
		//Submit Enrollment
		qe_cp_Page.clickSubmit();
		Assert.assertNotEquals(cascadeScenario.fetchFullAddress(testdata),
				cascadeScenario.VerifyAddress(cascadeScenario.address), "Assertion Passed");
		// enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
		purgeDownloadDirectory();
		
		//Update Success Response Steps
		//Navigate and click on the Carrier Response Update Button
//		Group_Page.navigateToCarrierResponseUpdateOnHeader();
		//Update Success Response
//		memberAdministration_Page.UpdateSuccessResponse(ssn);
		//Search the Employee
//		manageCoverage_Page.searchEmployee(ssn); 
	}

}
