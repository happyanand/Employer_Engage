package Speridian_RC_Admin_BA_TCs;
import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
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

public class Speridian_RC_Admin_BA_Flow extends Speridian_RC_Admin_BA_AllScenarios 
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
		// Click on activateAndEnroll
		employeePage.activateAndEnroll();
		// Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		// Select Plans
		enrollmentPage.selectSperidianPlans(false);
		// addAdditionalInsurance
		enrollmentPage.addAdditionalInsurance(false, testdata);
		// Submit Enrollment
		enrollmentPage.submitEnrollment();
		// Close Enrollment Summary
        enrollmentSummaryPage.closeEnrollmentSummary();
				            
        ExtentSuccessMessage("**********Summary Verification - Start**********");
        viewSummary.clickViewSummary();
        //Assert.assertTrue(isDownloadedFileExist());
        ExtentSuccessMessage("**********Summary Verification - End**********");
        
        ExtentSuccessMessage("**********Renewal Center - Start**********");
		viewCoveragePage.clickRenewalCenter();
        //New Enrollment
        viewCoveragePage.newEnrollment();
        //Click Submit
        cascadeScenario.clickSubmit();
        WaitForLoadAnimationDisappear();
        ExtentSuccessMessage("**********Renewal Center - End**********");
        
        ExtentSuccessMessage("**********Decline All Coverage - Start**********");
        enrollmentPage.declineAllCoverage();
        //Add AddtionalInsurance 
		enrollmentPage.addAdditionalInsurance(false,testdata);
		//Submit Enrollment
		enrollmentPage.submitEnrollment();	
		// Close Enrollment Summary
        enrollmentSummaryPage.closeEnrollmentSummary();
        ExtentSuccessMessage("**********Decline All Coverage - End**********");
		
		ExtentSuccessMessage("**********Update Covered Member - Start**********");
		//Edit Enrollment
		viewCoveragePage.editEnrollment();
		//Click Submit
		cascadeScenario.clickSubmit();		  
		//WaitForLoadAnimationDisappear();
		Thread.sleep(2000);
		//Click Dental Decline checkbox
		renewalCenter.declinecheckbox("Dental");
		//Click on Dental Dropdown
		viewCoveragePage.ClickOnDentalDropdown();
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
		//Edit Enrollment
		viewCoveragePage.editEnrollment();	
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
		renewalCenter.dependentcheckbox("Spouse","Dental");
		//Add Child Dependent
		renewalCenter.dependentcheckbox("Child /Dependent","Dental");
		//Select Dental Plan
		renewalCenter.SelectRCPlan("Dental","2"); 
		//Click on Dental Dropdown
		viewCoveragePage.ClickOnDentalDropdown();	
		ExtentSuccessMessage("**********Change Plan - End**********");
		
		ExtentSuccessMessage("**********QE Enrollment - Start**********");
		//Enroll Declined Plan
		renewalCenter.declinecheckbox("FSA");
		//Click on FSA Dropdown
		viewCoveragePage.ClickonFsaDropdowns();
		
		renewalCenter.SelectRCPlan("FSA","0");	
		//Click on Input FSA 
		enrollmentPage.InputFsa_Deposite();
		viewCoveragePage.ClickonFsaDropdowns();
		//Add additional Insurance
		enrollmentPage.addAdditionalInsurance(false,testdata);
		//Submit Enrollment
		enrollmentPage.submitEnrollment();
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		//***validate spouse(checkbox) is selected for dental plan or not? 
	//	String Newname= updateCoveredMembers.memberName("Dental");
	//	Assert.assertNotEquals(Newname,oldname,"Assertion Passed");	
		ExtentSuccessMessage("*********QE Enrollment - End*********");
		
		ExtentSuccessMessage("**********Terminate Dental - Start**********");
		//Edit Enrollment
		viewCoveragePage.editEnrollment();
		//Click Submit
		cascadeScenario.clickSubmit();		  
		WaitForLoadAnimationDisappear();
		//Click Dental Decline checkbox
		renewalCenter.declinecheckbox("Dental");
		 //Add AddtionalInsurance 
		enrollmentPage.addAdditionalInsurance(false,testdata);
		//Submit Enrollment
		enrollmentPage.submitEnrollment();	
		// Close Enrollment Summary
        enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("**********Terminate Dental - End**********");
		
		//Close Enrollment Summary
    }
}
