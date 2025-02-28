package FBMC_Admin_BA_TCs;

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
import Pages.Payment_Profile;
import Pages.QEEnrollment_ChangePlan_Page;
import Pages.ViewCoverage_Page;

public class FBMC_ChangePlanAncillaryFlow extends FBMC_Admin_BA_AllScenarios {
	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	QEEnrollment_ChangePlan_Page qe_cp_Page = new QEEnrollment_ChangePlan_Page();
	Payment_Profile Payment_Profile = new Payment_Profile();
	
	//Validate Change Plan Ancillary
	public void ValidateChangePlanAncillary(String TestScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException, IOException {
		//Select Group
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
		List<Map<String, String>> selectedPlanDetails = enrollmentPage.selectPlans(false);
		// addAdditionalInsurance
		enrollmentPage.addAdditionalInsurance(false, testdata);
		// Click Next btn
		enrollmentPage.clickNext();
		// Add Payment Profile
		 if(testdata.get("PaymentMethod").toString().equalsIgnoreCase("ACH")) {
	        	Payment_Profile.addProfileWithACH(true, "Chase", "021300077", false);
	        }
	        else {
	        	Payment_Profile.addProfileWithPensionAuthority(true);
	        }
		// submit Enrollment
		enrollmentPage.submitEnrollment();
		enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
		// Ramya- Assert.assertTrue(isDownloadedFileExist());
		// delete download summary file if exists
		purgeDownloadDirectory();
		// download summary
		enrollmentSummaryPage.downloadSummaryDocument();
		assertEquals(GetFilesCountInDownloadDirectory(), 1);
		//Close Enrollment Summary Page
		enrollmentSummaryPage.closeEnrollmentSummary();
		//Click on the Dental Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(testdata.get("planName").toString());
		//Click on Change Plan button
		ViewCoverage_Page.ChangePlanbuttonDental();
		
		//Changes  Plan Steps
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		//Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		//Click on the Respective Plan
		qe_cp_Page.clickPlan();
		//Select the different sub plan
		qe_cp_Page.selectPlan();
		//Click on the Next button
		qe_cp_Page.clickNext();
		//Click on the Submit button
		qe_cp_Page.clickSubmit();
		//Verify the changes made
		Assert.assertNotEquals(enrollmentSummaryPage.VerifyoldPlanName(enrollmentSummaryPage.oldPlanname), enrollmentSummaryPage.VerifynewPlanName(enrollmentSummaryPage.newPlanname),"Assertion Passed");
		//Download the Summary document
		enrollmentSummaryPage.downloadSummaryDocument();
	}
}
