package FBMC_Admin_BA_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;
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
import Pages.Payment_Profile;
import Pages.ViewCoverage_Page;

public class FBMC_RetroTerminationFlow extends FBMC_Admin_BA_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	Payment_Profile Payment_Profile = new Payment_Profile();

	public void ValidateRetroTermination(String testScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException, IOException, ParseException {

		// Add and Enroll Employee
		Home_Page.SelectGroupname(GroupName);
		Group_Page.clickEmployeeAdministration();
		employeeAdministration.clickAddEmployee();
		employeePage.addPersonalInformation(testdata);
		employeePage.addDependent(testdata);
		if (testdata.get("BeneficiaryType").toString().equals("Person")) {
			employeePage.addPersonBeneficiary(testdata);
		} else {
			employeePage.addTrustOrInstitutionBeneficiary(testdata);
		}
		employeePage.activateAndEnroll();
		System.out.println("EffectiveDate:"+testdata.get("EffectiveDate").toString());
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		List<Map<String, String>> selectedPlanDetails = enrollmentPage.selectPlans(false);
		enrollmentPage.addAdditionalInsurance(false, testdata);
		enrollmentPage.clickNext();
		if (testdata.get("PaymentMethod").toString().equalsIgnoreCase("ACH")) {
			Payment_Profile.addProfileWithACH(true, "Chase", "021300077", false);
		} else {
			Payment_Profile.addProfileWithPensionAuthority(true);
		}
		enrollmentPage.submitEnrollment();
		enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
		String outputDateStr = ChangeDateformate(testdata.get("EffectiveDate").toString());
		Assert.assertTrue(ValidationOnSummaryPage(outputDateStr));
		enrollmentSummaryPage.downloadSummaryDocument();
		Assert.assertTrue(isDownloadedFileExist());
		enrollmentSummaryPage.closeEnrollmentSummary();

		ViewCoverage_Page.ClickOnPlanDropdown(testdata.get("planName").toString());
		ViewCoverage_Page.ClickonTerminateMedicalButton();
		ViewCoverage_Page.Terminateplan(testdata);
		String outputDateStr1 = ChangeDateformate(testdata.get("TerminationDate").toString());
		Assert.assertTrue(ValidationOnSummaryPage(outputDateStr1)); 
		enrollmentSummaryPage.downloadSummaryDocument();
		Assert.assertTrue(isDownloadedFileExist());

	}
}
