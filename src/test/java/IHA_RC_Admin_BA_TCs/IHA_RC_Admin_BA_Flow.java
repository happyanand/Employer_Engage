package IHA_RC_Admin_BA_TCs;

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

public class IHA_RC_Admin_BA_Flow extends IHA_RC_Admin_BA_AllScenarios
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
	public  void ValidateRenewalCenter(String TestScenario, String GroupName,Map<Object, Object> testdata)throws InterruptedException, AWTException, IOException  {

		// Select Group
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
		employeePage.addIHAPersonalInformation(testdata);
		// Add Dependent
		employeePage.addDependent(testdata);
		// Click on activateAndEnroll
		employeePage.activateAndEnroll();
		// Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		// Select Plans
		enrollmentPage.selectPlans(false);
		// addAdditionalInsurance
		enrollmentPage.addAdditionalInsurance(false, testdata);
		// Submit Enrollment
		enrollmentPage.submitEnrollment();
		// Close Enrollment Summary
        enrollmentSummaryPage.closeEnrollmentSummary();
				            
        ExtentSuccessMessage("**********Summary Verification - Start**********");
        viewSummary.clickViewSummary();
        Assert.assertTrue(isDownloadedFileExist());
        ExtentSuccessMessage("**********Summary Verification - End**********");
        
        ExtentSuccessMessage("**********Renewal Center - Start**********");
		viewCoveragePage.clickRenewalCenter();
        //New Enrollment
        viewCoveragePage.newEnrollment();
        //Click Submit
        cascadeScenario.clickSubmit();
        ExtentSuccessMessage("**********Renewal Center - End**********");
        
        ExtentSuccessMessage("**********Decline All Coverage - Start**********");
        enrollmentPage.declineAllCoverage();
        //Add AddtionalInsurance 
		enrollmentPage.addAdditionalInsurance(false,testdata);
		//Submit Enrollment
		enrollmentPage.submitEnrollment();	
		//Edit Enrollment
		viewCoveragePage.editEnrollment();
		//Click Submit
		cascadeScenario.clickSubmit();		  	
		ExtentSuccessMessage("**********Decline All Coverage - End**********");
		
		ExtentSuccessMessage("**********Update Covered Member - Start**********");		
		//Click Medical Decline checkbox
		renewalCenter.declinecheckbox("Medical");
		//Add Spouse
		renewalCenter.dependentcheckbox("Spouse", "Medical");	
		//Select Medical Plan
		renewalCenter.SelectRCPlan("Medical","0");
		//Click on Medical Dropdown
//		viewCoveragePage.ClickOnMedicalDropdown();	//Commented out line no 104. Ramya created the generic method.
		viewCoveragePage.ClickOnPlanDropdown(testdata.get("PlanNames").toString());
		//Add additional Insurance
		enrollmentPage.addAdditionalInsurance(false,testdata);
		//Submit Enrollment
		enrollmentPage.submitEnrollment();
		String oldPlanName=enrollmentSummaryPage.VerifynewPlanName(enrollmentSummaryPage.newPlanname);
		String addedCoveredMember=updateCoveredMembers.VerifyNewMemberNameAdd(updateCoveredMembers.newname);
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("**********Update Covered Member - End**********");
		
		ExtentSuccessMessage("**********Cascade Scenario - Start**********");	
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
		//Remove Spouse
		renewalCenter.dependentcheckbox("Spouse", "Medical");
		//Add Child Dependent
		renewalCenter.dependentcheckbox("Child", "Medical");
		//Select Medical Plan
		renewalCenter.SelectRCPlan("Medical","2"); 
		//Click on Medical Dropdown
//		viewCoveragePage.ClickOnMedicalDropdown();	//Commented out line no 104. Ramya created the generic method.
		viewCoveragePage.ClickOnPlanDropdown(testdata.get("PlanNames").toString());
		ExtentSuccessMessage("**********Change Plan - End**********");	
		//Add additional Insurance
		enrollmentPage.addAdditionalInsurance(false,testdata);
		//Submit Enrollment
		enrollmentPage.submitEnrollment();
		//Validate Changed Plan Name
		String newPlanName=enrollmentSummaryPage.VerifynewPlanName(enrollmentSummaryPage.newPlanname);
//		Assert.assertNotEquals(oldPlanName,newPlanName,"Assertion Passed");	
		//Validate spouse is Removed for Medical plan or not? 
		String removedCoveredMember=updateCoveredMembers.VerifyNewMemberNameRemove(updateCoveredMembers.newname);
//		Assert.assertNotEquals(addedCoveredMember,removedCoveredMember,	"Assertion Passed");
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
	}
}

