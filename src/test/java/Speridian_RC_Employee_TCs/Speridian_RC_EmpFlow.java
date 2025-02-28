package Speridian_RC_Employee_TCs;
import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

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
import Pages.QEEnrollment_ChangePlan_Page;
import Pages.RenewalCenter_Page;
import Pages.SummaryVerification_Page;
import Pages.UpdateCoveredMembers_Page;
import Pages.ViewBenefits_Page;
import Pages.ViewCoverage_Page;

public class Speridian_RC_EmpFlow extends Speridian_RC_Emp_AllScenarios 
{
	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	ViewCoverage_Page viewCoveragePage=new ViewCoverage_Page();
	CascadingMembership_Page cascadeScenario = new CascadingMembership_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	RenewalCenter_Page renewalCenter=new RenewalCenter_Page();
	SummaryVerification_Page viewSummary=new SummaryVerification_Page();
	UpdateCoveredMembers_Page updateCoveredMembers= new UpdateCoveredMembers_Page();
	EditEmployee_Page editEmployee= new EditEmployee_Page();
	QEEnrollment_ChangePlan_Page qe_cp_Page = new QEEnrollment_ChangePlan_Page();
	Payment_Profile Payment_Profile= new Payment_Profile();
	ViewBenefits_Page viewBenefits=new ViewBenefits_Page();
	
	//Renewal Center
	public  void ValidatedRenewalCenter(String TestScenario, String GroupName,Map<Object, Object> testdata)throws InterruptedException, AWTException, IOException  {

    	//Login with Support User
        Group_Page.SupportUserLogin(configloader().getProperty("SperidianRCEmployee"));		
        ExtentSuccessMessage("Successfully Enrolled Support User");
        Group_Page.clicknewEnrollment();
        //Click Submit
        cascadeScenario.clickSubmit();
		//Click Dental Decline checkbox
		renewalCenter.declinecheckbox("Dental");
		//Click on Dental Dropdown
		viewCoveragePage.ClickOnDentalDropdown();
		
		ExtentSuccessMessage("**********Update Covered Member - Start**********");
		//Add Spouse
		renewalCenter.dependentcheckbox("Spouse", "Dental");	
		//Select Dental Plan
		renewalCenter.SelectRCPlan("Dental","1");
		//Click on Dental Dropdown
		viewCoveragePage.ClickOnDentalDropdown();
		//Click Vision Decline checkbox
		renewalCenter.declinecheckbox("Vision");
		//Click on Vision Dropdown
		viewCoveragePage.ClickOnVisionDropdown();
		//Select Vision Plan
		renewalCenter.SelectRCPlan("Vision","1");
		//Click on Vision Dropdown
		viewCoveragePage.ClickOnVisionDropdown();	
		//Add additional Insurance
		enrollmentPage.addAdditionalInsurance(false,testdata);
		//Submit Enrollment
		enrollmentPage.submitEnrollment();
		String oldname= updateCoveredMembers.memberName("Dental");
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("**********Update Covered Member - End**********");

		ExtentSuccessMessage("**********View Benefits - Start**********");
		//Click on Dental Dropdown
		viewCoveragePage.ClickOnDentalDropdown();		
		//View Benefits Information
		viewCoveragePage.ViewBenefitsInformtion();
		ExtentSuccessMessage("**********View Benefits - End**********");
		
		ExtentSuccessMessage("**********Cascade Scenario - Start**********");
		//Click on Dental Dropdown
		viewCoveragePage.ClickOnDentalDropdown();			
		//Click Home
		Group_Page.click_Home();
		//New Enrollment
		Group_Page.clicknewEnrollment();
        //Edit Employee Details
        editEmployee.enterNewAddress(testdata);
		editEmployee.scrollTillDependents();
		//Add Dependent
		editEmployee.addDependent(testdata);
		//click Submit
		cascadeScenario.clickSubmit();
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("**********Cascade Scenario - End**********");

		ExtentSuccessMessage("**********Change Plan - Start**********");
		//Click on Dental Dropdown
		viewCoveragePage.ClickOnDentalDropdown();		
		//Remove Spouse
		renewalCenter.dependentcheckbox("Spouse", "Dental");
		//Add Child Dependent
		renewalCenter.dependentcheckbox("Child /Dependent", "Dental");
		//Select Dental Plan
		renewalCenter.SelectRCPlan("Dental","2"); 
		//Click on Dental Dropdown
		viewCoveragePage.ClickOnDentalDropdown();	
		ExtentSuccessMessage("**********Change Plan - End**********");
		
		ExtentSuccessMessage("**********QE Enrollment - Start**********");
		//Enroll Declined Plan
		renewalCenter.declinecheckbox("Medical");
		//Click on Medical Dropdown
		viewCoveragePage.ClickOnMedicalDropdown();
		//Select Legal Plan
		renewalCenter.SelectRCPlan("Medical","1");
		//Click on Medical Dropdown
		viewCoveragePage.ClickOnMedicalDropdown();
		//Add additional Insurance
		enrollmentPage.addAdditionalInsurance(false,testdata);
		//Submit Enrollment
		enrollmentPage.submitEnrollment();
		String Newname= updateCoveredMembers.memberName("Dental");
		Assert.assertNotEquals(Newname,oldname,"Assertion Passed");	
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("**********QE Enrollment - End**********");
		
		ExtentSuccessMessage("**********Summary Verification - Start**********");
        viewSummary.clickViewSummary();
        //Assert.assertTrue(isDownloadedFileExist()); 		
        ExtentSuccessMessage("**********Summary Verification - End**********");
    }
}