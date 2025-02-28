package FBMC_Business_Automation_Rules;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import Pages.EmployeeAdministration_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Payment_Profile;
import Pages.ViewCoverage_Page;

public class FBMC_Daytona_Coverageamt_ChangeLifeBenefitReduction_turns_70or75 extends FBMC_Business_Automation_Rules_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	Payment_Profile Payment_Profile = new Payment_Profile();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	
	
	public void ValidateFBMC_Daytona_Coverageamt_ChangeLifeBenefitReduction_turns_70or75(String TestScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException, IOException {

		// Select Group
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
		employeePage.addPersonalInformation(testdata);
		// Click on activateAndEnroll
		employeePage.activateAndEnroll();
		// Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		// Select Plans
		List<Map<String, String>> selectedPlanDetails = enrollmentPage.selectPlans(false, testdata.get("planName").toString());
		// addAdditionalInsurance
		enrollmentPage.addAdditionalInsurance(false, testdata);
		// Click Next btn
		enrollmentPage.clickNext();
		// Add Payment Profile
		Payment_Profile.ClickOnPaymentProfileNo();
		// submit Enrollment
		enrollmentPage.submitEnrollment();
		enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
		// delete download summary file if exists
		purgeDownloadDirectory();
		// Click on download summary
		enrollmentSummaryPage.downloadSummaryDocument();
		Thread.sleep(1000);
		assertEquals(GetFilesCountInDownloadDirectory(), 1);
		//Close the Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		//Click on Plans Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(testdata.get("planName").toString());
		//Check the Termination Date.
		ViewCoverage_Page.verifyTerminationDateToAllPlans(testdata.get("TerminationDate").toString());
	
	}
}
