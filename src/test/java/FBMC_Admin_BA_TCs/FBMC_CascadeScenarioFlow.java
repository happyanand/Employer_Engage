package FBMC_Admin_BA_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import Pages.CascadingMembership_Page;
import Pages.EditEmployee_Page;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Payment_Profile;
import Pages.ViewCoverage_Page;

public class FBMC_CascadeScenarioFlow extends FBMC_Admin_BA_AllScenarios  {
	
	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	CascadingMembership_Page cascadeScenario = new CascadingMembership_Page();
	ViewCoverage_Page viewCoverage_page= new ViewCoverage_Page();
	EditEmployee_Page editEmployee= new EditEmployee_Page();
	Payment_Profile Payment_Profile= new Payment_Profile();
	
	//CasecadeScenario
	public void ValidateCascadeScenario(String TestScenario, String GroupName,Map<Object, Object> testdata)throws InterruptedException, AWTException, IOException
	{	
		//Select Group Name
		Home_Page.SelectGroupname(GroupName);
		//click Employee Administration
		Group_Page.clickEmployeeAdministration();
		//click Add Employee
		employeeAdministration.clickAddEmployee();
		//Add Personal Information
		employeePage.addPersonalInformation(testdata);
		//Add Dependent
		employeePage.addDependent(testdata);
		//Activate And Enroll Employee
		employeePage.activateAndEnroll();
		//Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		//Select Plans
		List<Map<String,String>> selectedPlanDetails=enrollmentPage.selectPlans(false);
		//Add Additional Insurance
		enrollmentPage.addAdditionalInsurance(false,testdata);
		//click Next
		enrollmentPage.clickNext();    
		//Add Payment Profile
		if(testdata.get("PaymentMethod").toString().equalsIgnoreCase("ACH")) {
			Payment_Profile.addProfileWithACH(true, "Chase", "021300077", false);
		} else {
			Payment_Profile.addProfileWithPensionAuthority(true);
		}
		//Submit Enrollment
		enrollmentPage.submitEnrollment();
		// Customer Number Return
		String CustomerNo = enrollmentSummaryPage.CustomerNumberReturn();	
//		enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);	
		Group_Page.navigateToGroupDashboard();
	    //Click EmployeeAdminstration
	    Group_Page.clickEmployeeAdministration();
	    //Search And Navigate To EmployeeInfo
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
		Thread.sleep(5000);
		//click Yes CoverageRates
		editEmployee.clickYesCoverageRates();
		WaitForPageLoad();
		Boolean Flag =editEmployee.MessageErrorChangevisible();
		if(Flag = true) {
			editEmployee.ErrorOkButton();
			WaitForPageLoad();
			editEmployee.clickAddDependentToCoverage();
		}
		//click Qualifying Type
		cascadeScenario.clickQualifyingType(testdata);
		//click Medical Cascade Dropdown
		cascadeScenario.clickMedicalCascadeDropdown();
		//click Child
		cascadeScenario.clickChild();
		WaitForPageLoad();
		//click Cascade Next button
		cascadeScenario.clickNext();
		//Submit Enrollment
		enrollmentPage.submitEnrollment();
		//Assert.assertNotEquals(cascadeScenario.fetchFullAddress(testdata), cascadeScenario.VerifyAddress(cascadeScenario.address),"Assertion Passed");
		enrollmentSummaryPage.downloadSummaryDocument();
		//Assert.assertTrue(isDownloadedFileExist());	
	}
}