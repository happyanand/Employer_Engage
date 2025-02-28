package Speridian_Admin_BA_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.BasePackage.Base_Class;

import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.UpdateCoveredMembers_Page;
import Pages.ViewCoverage_Page;

public class Speridian_UpdateCoveredMembersMedicalFlow extends Speridian_Admin_BA_AllScenarios {

	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	UpdateCoveredMembers_Page updateCoveredMembers= new UpdateCoveredMembers_Page();

	public void ValidateUpdateCoveredMembersMedical(String TestScenario, String GroupName,Map<Object, Object> testdata)throws InterruptedException, AWTException, IOException {

		//Select Account name
		Home_Page.SelectGroupname(GroupName);
		// click Employee Administration
		Group_Page.clickEmployeeAdministration();
		//click Add Employee
		employeeAdministration.clickAddEmployee();
		//Add Personal Information
		employeePage.addPersonalInformation(testdata);
		employeePage.addDependent(testdata);
		//Add Notes
		employeePage.addNotes(testdata.get("NotesPrivate").toString());
		//Activate And Enroll
		employeePage.activateAndEnroll();
		System.out.println("effective Date ; "+testdata.get("EffectiveDate").toString());
		//Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		//Select Speridian Plans
		List<Map<String,String>> selectedPlanDetails=enrollmentPage.selectSperidianPlans(false);
		//Add Additional Insurance
		enrollmentPage.addAdditionalInsurance(false,testdata);
		// Submit Enrollment
		enrollmentPage.submitEnrollment();
		//Verify Enrolled Plan Info Displayed
		enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
		Thread.sleep(3000);
		String oldname= updateCoveredMembers.memberName("Medical");
		System.out.println("oldname : "+oldname);		
		enrollmentSummaryPage.ClickOnClose_Button();
		Thread.sleep(5000);


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
		ViewCoverage_Page.ClickOnPlanDropdown(testdata.get("planName").toString());
		//Select the Covered Member
		updateCoveredMembers.selectCoveredMember();
		//Submit Enrollment
		updateCoveredMembers.clickSubmit();
		String Newname= updateCoveredMembers.memberName("Medical");
		System.out.println("Newname : "+Newname);
		Assert.assertNotEquals(Newname,oldname,"Assertion Passed");	
		enrollmentSummaryPage.ClickOnClose_Button();

	}

}
