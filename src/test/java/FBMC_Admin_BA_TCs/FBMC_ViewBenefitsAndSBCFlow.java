			package FBMC_Admin_BA_TCs;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Payment_Profile;
import Pages.ViewBenefits_Page;
import Pages.ViewCoverage_Page;

public class FBMC_ViewBenefitsAndSBCFlow extends FBMC_Admin_BA_AllScenarios {

	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	ViewBenefits_Page viewBenefits=new ViewBenefits_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	Payment_Profile Payment_Profile = new Payment_Profile();

	//Validate View Benefits
	public void ValidateViewBenefits(String TestScenario, String GroupName,Map<Object, Object> testdata)throws InterruptedException, AWTException, IOException {

		// Add and Enroll Employee
		Home_Page.SelectGroupname(GroupName);
		Group_Page.clickEmployeeAdministration();
		employeeAdministration.clickAddEmployee();
		employeePage.addPersonalInformation(testdata);
		employeePage.activateAndEnroll();
		//Enter the Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		List<Map<String,String>> selectedPlanDetails=enrollmentPage.selectPlans(false);
		enrollmentPage.addAdditionalInsurance(false,testdata);
		enrollmentPage.clickNext();
		if(testdata.get("PaymentMethod").toString().equalsIgnoreCase("ACH")) {
			Payment_Profile.addProfileWithACH(true, "Chase", "021300077", false);
		}
		else {
			Payment_Profile.addProfileWithPensionAuthority(true);
		}
		enrollmentPage.submitEnrollment();
		enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
		
		// Ramya- Assert.assertTrue(isDownloadedFileExist());
		// delete download summary file if exists
		purgeDownloadDirectory();
		// download summary
		enrollmentSummaryPage.downloadSummaryDocument();
		assertEquals(GetFilesCountInDownloadDirectory(), 1);
		//Close Button
        enrollmentSummaryPage.closeEnrollmentSummary();
        //Click on the plan
        ViewCoverage_Page.ClickOnPlanDropdown(testdata.get("planName").toString());
        //Click View Benefits button
        viewBenefits.clickViewBenefits();
        //Click close button in View Benefits popup
        viewBenefits.clickClose();
	}

}
