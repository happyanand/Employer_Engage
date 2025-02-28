package IHA_Admin_BA_TCs;

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

public class IHA_ChangePlanMedicalFlow extends IHA_Admin_BA_AllScenarios {
	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	QEEnrollment_ChangePlan_Page qe_cp_Page = new QEEnrollment_ChangePlan_Page();

	public void ValidateChangePlanMedical(String TestScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException, IOException {
		
		//Select Account name
		Home_Page.SelectGroupname(GroupName);
		// click Employee Administration
		Group_Page.clickEmployeeAdministration();
		//click Add Employee
		employeeAdministration.clickAddEmployee();
		//Add Personal Information
		String ssn = employeePage.addIHAPersonalInformation(testdata);
		//Click Activate And Enroll
		employeePage.activateAndEnroll();
		// Ramya
		///Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		//Select the Plans
		List<Map<String, String>> selectedPlanDetails = enrollmentPage.selectPlans(false);
		//Click on Submit button
		enrollmentPage.submitEnrollment();
		//Verify the plans
		enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
		//Click on Close button
		enrollmentSummaryPage.closeEnrollmentSummary();

		//Update Member Id steps
		//Navigate and click on the Carrier Response Update Button
//		Group_Page.navigateToCarrierResponseUpdateOnHeader();
		//Update Member Id
//		memberAdministration_Page.updateMemberId(ssn);
		//Search the Employee
//		manageCoverage_Page.searchEmployee(ssn);
		
		//Click on Change Plan button
		ViewCoverage_Page.ChangeplanbuttonMedical();
		
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		//Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		//Select the different sub plan
		qe_cp_Page.selectPlan();
		//Click on the Submit button
		qe_cp_Page.clickSubmit();
		//Verify the changes made
		Assert.assertNotEquals(enrollmentSummaryPage.VerifyoldPlanName(enrollmentSummaryPage.oldPlanname), enrollmentSummaryPage.VerifynewPlanName(enrollmentSummaryPage.newPlanname),"Assertion Passed");
		//Download the Summary document
		enrollmentSummaryPage.downloadSummaryDocument();
		
		//Update Success Response Steps
		//Navigate and click on the Carrier Response Update Button
//		Group_Page.navigateToCarrierResponseUpdateOnHeader();
		//Update Success Response
//		memberAdministration_Page.UpdateSuccessResponse(ssn);
		//Search the Employee
//		manageCoverage_Page.searchEmployee(ssn);

	}
}