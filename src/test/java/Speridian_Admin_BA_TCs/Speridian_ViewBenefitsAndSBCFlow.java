package Speridian_Admin_BA_TCs;

import java.awt.AWTException;
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
import Pages.ViewBenefits_Page;
import Pages.ViewCoverage_Page;

public class Speridian_ViewBenefitsAndSBCFlow extends Speridian_Admin_BA_AllScenarios {
	
	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
//	ReEnrollMedical reEnrollMedical=new ReEnrollMedical();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	ViewBenefits_Page viewBenefits = new ViewBenefits_Page();

	public void ValidateViewBenefitsAndSBCFlow(String TestScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException {

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
		enrollmentPage.addAdditionalInsurance(false, testdata);
		// Submit Enrollment
		enrollmentPage.submitEnrollment();
		// Verify Enrolled Plan Info Displayed
		enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
		// Click On Close_Button
		enrollmentSummaryPage.ClickOnClose_Button();
		//enrollmentSummaryPage.ClickOnClose_Button();
		WaitForPageLoad();
		// View Benefits Informtion
		//Click on the plan
		ViewCoverage_Page.ClickOnPlanDropdown(testdata.get("planName").toString());
		//viewBenefits.ViewBenefitsInformtion();
		viewBenefits.clickViewBenefits();
		//Click close button in View Benefits popup
        viewBenefits.clickClose();
		// Click On View SBC
		viewBenefits.clickViewSBC();
		// Navigate To Group Dashboard
		Group_Page.navigateToGroupDashboard();
	}
}
