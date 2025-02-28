package Speridian_Admin_BA_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import Pages.CascadingMembership_Page;
import Pages.EditEmployee_Page;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.EmployeeReinstate_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.ViewCoverage_Page;

public class Speridian_CascadeScenarioFlow extends Speridian_Admin_BA_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	CascadingMembership_Page cascadeScenario = new CascadingMembership_Page();
	EmployeeReinstate_Page employeeReinstatePage = new EmployeeReinstate_Page();
	EditEmployee_Page editEmployee= new EditEmployee_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();

	public void ValidateCascadeScenario(String testScenario, String GroupName, Map<Object, Object> testdata)
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
		enrollmentPage.addAdditionalInsurance(false, testdata);
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
		//click Edit 
		employeeInformationPage.clickEdit();
		//Edit Employee Details
		editEmployee.enterNewAddress(testdata);
		editEmployee.scrollTillDependents();
		//Add Dependent
		editEmployee.addDependent(testdata);
		//click Submit
		cascadeScenario.clickSubmit();
		WaitForPageLoad();
		//click Demographics Yes 
		editEmployee.clickDemographicsYes();
		//click Yes CoverageRates
		editEmployee.clickYesCoverageRates();
		WaitForPageLoad();
		//				Boolean Flag =editEmployee.MessageErrorChangevisible();
		//				if(Flag = true) {
		//					editEmployee.ErrorOkButton();
		//					WaitForPageLoad();
		//					editEmployee.clickAddDependentToCoverage();
		//				}
		//click Qualifying Type
		cascadeScenario.clickQualifyingType(testdata);
		//click Medical Cascade Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(testdata.get("planName").toString());
		//click Child
		cascadeScenario.clickChild();
		WaitForPageLoad();
		//click Cascade Next button
		cascadeScenario.clickNext();
		//Submit Enrollment
		enrollmentPage.submitEnrollment();
		Assert.assertNotEquals(cascadeScenario.fetchFullAddress(testdata),
				cascadeScenario.VerifyAddress(cascadeScenario.address), "Assertion Passed");
		enrollmentSummaryPage.downloadSummaryDocument();
	}
}