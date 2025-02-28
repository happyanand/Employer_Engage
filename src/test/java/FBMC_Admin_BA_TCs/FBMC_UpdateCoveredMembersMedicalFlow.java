package FBMC_Admin_BA_TCs;

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
import Pages.UpdateCoveredMembers_Page;
import Pages.ViewCoverage_Page;

public class FBMC_UpdateCoveredMembersMedicalFlow extends FBMC_Admin_BA_AllScenarios {
	
	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	UpdateCoveredMembers_Page updateCoveredMembers= new UpdateCoveredMembers_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	Payment_Profile Payment_Profile= new Payment_Profile();
	
	//Update Covered Member Medical
	public void ValidateUpdateCoveredMembersMedical(String TestScenario, String GroupName,Map<Object, Object> testdata)
			throws InterruptedException, AWTException, IOException {
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
		//Click Next
		updateCoveredMembers.clickNext();     
		//Add Payment Profile
		if(testdata.get("PaymentMethod").toString().equalsIgnoreCase("ACH")) {
			Payment_Profile.addProfileWithACH(true, "Chase", "021300077", false);
		}
		else {
			Payment_Profile.addProfileWithPensionAuthority(true);
		}
		//Submit Enrollment
		enrollmentPage.submitEnrollment();
		String oldname = updateCoveredMembers.memberName("Medical");
		System.out.println("oldname : " + oldname);
		//verify Enrolled Plan Info Displayed
		enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		
		//Add a Dependent/Beneficiary
		//Click Medical Plan
		ViewCoverage_Page.ClickOnPlanDropdown(testdata.get("planName").toString());
		//Click UpdateCoveredMembers
		ViewCoverage_Page.ClickUpdateCoveredMembersMedical();
		//Select ActionTypeADD
		updateCoveredMembers.ActionTypeADD();
		//Select QualifyingEvent
		updateCoveredMembers.clickQualifyingEvent();
		//Enter EffectiveDate
		updateCoveredMembers.clickEffectiveDate(testdata);
		//Add Covered Member
		updateCoveredMembers.clickPlanDropdown();
		//Select the Covered Member
		updateCoveredMembers.selectCoveredMember();
		//Click Next
		updateCoveredMembers.clickNext();
		//Add Profile With PensionAuthority
		enrollmentPage.addProfileWithPensionAuthority(false);
		//Submit Enrollment
		updateCoveredMembers.clickSubmit();
		String Newname= updateCoveredMembers.memberName("Medical");
		System.out.println("Newname : "+Newname);
		Assert.assertNotEquals(Newname,oldname,"Assertion Passed");	
//		Assert.assertNotEquals(updateCoveredMembers.VerifyOldMemberNameAdd(updateCoveredMembers.oldname),
//				updateCoveredMembers.VerifyNewMemberNameAdd(updateCoveredMembers.newname),
//				"Assertion Passed");
		enrollmentSummaryPage.downloadSummaryDocument();
		enrollmentSummaryPage.closeEnrollmentSummary();
		
		//Remove a Dependent/Beneficiary
		//Click Medical Plan
		ViewCoverage_Page.ClickOnPlanDropdown(testdata.get("planName").toString());
		//Click UpdateCoveredMembers
		ViewCoverage_Page.ClickUpdateCoveredMembersMedical();
		//Select ActionTypeRemove
		updateCoveredMembers.ActionTypeRemove();
		//Select QualifyingEvent
		updateCoveredMembers.clickQualifyingEvent();
		//Enter TerminationDate
		updateCoveredMembers.clickTerminationDate(testdata);
		//Remove Covered Member
		updateCoveredMembers.clickPlanDropdown();
		//Select the Covered Member
		updateCoveredMembers.selectCoveredMember();
		//Click Confirmation OK
		updateCoveredMembers.clickConfirmationOK();
		//Click Next
		updateCoveredMembers.clickNext();
		//Add Profile With PensionAuthority
		enrollmentPage.addProfileWithPensionAuthority(false);
		//Submit Enrollment
		updateCoveredMembers.clickSubmit();
		Assert.assertNotEquals(
				updateCoveredMembers.VerifyOldMemberNameRemove(updateCoveredMembers.oldname),
				updateCoveredMembers.VerifyNewMemberNameRemove(updateCoveredMembers.newname),
				"Assertion Passed");
		enrollmentSummaryPage.downloadSummaryDocument();
	}

}
