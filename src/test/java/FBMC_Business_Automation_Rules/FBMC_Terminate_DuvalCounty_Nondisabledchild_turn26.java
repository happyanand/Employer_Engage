package FBMC_Business_Automation_Rules;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import Pages.CorrespondenceLetters_Page;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Payment_Profile;
import Pages.ViewCoverage_Page;

public class FBMC_Terminate_DuvalCounty_Nondisabledchild_turn26 extends FBMC_Business_Automation_Rules_AllScenarios {
	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	Payment_Profile Payment_Profile = new Payment_Profile();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	CorrespondenceLetters_Page CCLetterVerification=new CorrespondenceLetters_Page();
	// Add and Enroll Employee
	public void ValidateFBMC_Terminate_DuvalCounty_Nondisabledchild_turn26(String TestScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException, IOException {


		// Select Group
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
		employeePage.addPersonalInformation(testdata);
		// Add Dependent
		employeePage.addDependent(testdata);
		// Fill Beneficiary Details based on the type
		if (testdata.get("BeneficiaryType").equals("Person")) {
			employeePage.addPersonBeneficiary(testdata);
		} else {
			employeePage.addTrustOrInstitutionBeneficiary(testdata);
		}
		// Click on activateAndEnroll
		employeePage.activateAndEnroll();
		// Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		String PlansNames =testdata.get("planName").toString();
		String planNames[]=PlansNames.split(",");
		String PlanNames1 =planNames[0].trim();
		String PlanNames2 =planNames[1].trim();
		String PlanNames3 =planNames[2].trim();
		enrollmentPage.select3PlansBynames(PlanNames1,PlanNames2,PlanNames3);
		// addAdditionalInsurance
		enrollmentPage.addAdditionalInsurance(false, testdata);
		// Click Next btn
		enrollmentPage.clickNext();
		// Add Payment Profile
		if (testdata.get("PaymentMethod").toString().equalsIgnoreCase("ACH")) {
			Payment_Profile.addProfileWithACH(true, "Chase", "021300077", false);
		} else {
			Payment_Profile.addProfileWithPensionAuthority(true);
		}
		// submit Enrollment
		enrollmentPage.submitEnrollment();
		ValidationOnSummaryPage(PlanNames3);
		enrollmentSummaryPage.CustomerNumberReturn();
		// delete download summary file if exists
		purgeDownloadDirectory();
		// Click on download summary
		enrollmentSummaryPage.downloadSummaryDocument();
		Thread.sleep(1000);
		assertEquals(GetFilesCountInDownloadDirectory(), 1);
		//Close the Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		//Click on Plans Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(PlanNames1);
		//Click on Plans Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(PlanNames2);
		//Check the Termination Date.
		//Click on Plans Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(PlanNames3);
		//Check the Termination Date.
		ViewCoverage_Page.verifyTerminationDateToAllPlans(testdata.get("TerminationDate").toString());
	}
}

