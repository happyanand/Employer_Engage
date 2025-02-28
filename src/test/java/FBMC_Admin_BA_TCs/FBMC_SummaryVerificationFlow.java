package FBMC_Admin_BA_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
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
import Pages.SummaryVerification_Page;
import Pages.ViewCoverage_Page;
import Pages.Payment_Profile;

public class FBMC_SummaryVerificationFlow extends FBMC_Admin_BA_AllScenarios {

	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	SummaryVerification_Page viewSummary=new SummaryVerification_Page();
	Payment_Profile Payment_Profile = new Payment_Profile();


	public void ValidateSummaryVerification(String TestScenario, String GroupName,Map<Object, Object> testdata)throws InterruptedException, AWTException, IOException  {

		//Add and Enroll Employee
		Home_Page.SelectGroupname(GroupName);
		Group_Page.clickEmployeeAdministration();
		employeeAdministration.clickAddEmployee();
		employeePage.addPersonalInformation(testdata);
		employeePage.addDependent(testdata);
		if(testdata.get("BeneficiaryType").toString().equals("Person")){
			employeePage.addPersonBeneficiary(testdata);
		}
		else{
			employeePage.addTrustOrInstitutionBeneficiary(testdata);
		}
		employeePage.addTrustOrInstitutionBeneficiary(testdata); 
		employeePage.activateAndEnroll();
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
		//        viewSummary.clickCloseButton();     
		//Click on Close Button
		enrollmentSummaryPage.ClickOnClose_Button();
		//		viewSummary.clickViewSummary();
		ViewCoverage_Page.ClickOnViewSummary();

		Assert.assertTrue(isDownloadedFileExist());

	}

}
