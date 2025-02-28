package Speridian_Admin_BA_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

public class Speridian_EmployeeReHireEnrollFlow extends Speridian_Admin_BA_AllScenarios {
	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	TerminateEmployee_Page terminateEmployeePage = new TerminateEmployee_Page();
	ViewCoverage_Page viewCoveragePage = new ViewCoverage_Page();
	ReHire_Page reHirePage = new ReHire_Page();
    EnrollReHire_Page enrollNewHirePage=new EnrollReHire_Page();

	public void ValidateEmployeeReHireEnroll(String TestScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException, IOException {
		// Select Account name
		Home_Page.SelectGroupname(GroupName);
		// click Employee Administration
		Group_Page.clickEmployeeAdministration();
		// click Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Personal Information
		employeePage.addPersonalInformation(testdata);
		// Add Notes
		employeePage.addNotes(testdata.get("NotesPrivate").toString());
		// Activate And Enroll
		employeePage.activateAndEnroll();
		System.out.println("effective Date ; " + testdata.get("EffectiveDate").toString());
		// Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		// Select Speridian Plans
		List<Map<String, String>> selectedPlanDetails = enrollmentPage.selectSperidianPlans(false);
		// Add Additional Insurance
		enrollmentPage.addAdditionalInsurance(false,testdata);
		// Submit Enrollment
		enrollmentPage.submitEnrollment();
		// Verify Enrolled Plan Info Displayed
		enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
		Thread.sleep(5000);
		String CustomerNo = enrollmentSummaryPage.CustomerNumberReturn();
		System.out.println("Customer no :" + CustomerNo);
		Group_Page.navigateToGroupDashboard();
		Group_Page.clickEmployeeAdministration();
		employeeAdministration.searchAndNavigateToEmployeeInfo(CustomerNo);
		
		employeeInformationPage.clickTerminate();
		terminateEmployeePage.TerminateEmployee(testdata.get("TerminationDATE").toString());
		Group_Page.navigateToGroupDashboard();
		Group_Page.clickEmployeeAdministration();
		employeeAdministration.searchAndNavigateToEmployeeInfo(CustomerNo);
		//click ReHire
        employeeInformationPage.clickReHire();
        Thread.sleep(3000);
        //ReHire And Enroll
        reHirePage.reHireAndEnroll();
        WaitForLoadAnimationDisappear();
        //click Next
		enrollNewHirePage.EnrollNewHireNext();
		WaitForLoadAnimationDisappear();
		Thread.sleep(20000);
		// Select Speridian Plans
		enrollmentPage.selectSperidianPlans(false);
		// Add Additional Insurance
		enrollmentPage.addAdditionalInsurance(false,testdata);
		// Submit Enrollment
		enrollmentPage.submitEnrollment();
		enrollmentSummaryPage.downloadSummaryDocument();
		// enrollmentSummaryPage.verifyCoverageEndDateAfterReHire(selectedPlanDetails,"Vision",testdata.get("TerminateDate").toString());
	}
}
