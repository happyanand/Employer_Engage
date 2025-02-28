package Speridian_Admin_BA_TCs;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import Pages.ChangeCoverageAmount_PlanRate_Page;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.ViewCoverage_Page;

public class Speridian_ChangeCoverageAmountFlow extends Speridian_Admin_BA_AllScenarios {
	
	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	ChangeCoverageAmount_PlanRate_Page change_CA_PR_Page = new ChangeCoverageAmount_PlanRate_Page();


	public void ValidateChangeCoverageAmount(String TestScenario, String GroupName,Map<Object, Object> testdata)throws InterruptedException, AWTException {

		//Select Account name
		Home_Page.SelectGroupname(GroupName);
		// click Employee Administration
		Group_Page.clickEmployeeAdministration();
		//click Add Employee
		employeeAdministration.clickAddEmployee();
		//Add Personal Information
		employeePage.addPersonalInformation(testdata);
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
		
		//System.out.println("OldAmuount : "+testdata.get("OldAmuount").toString());
		//changeCoverageAmount.VerifyOldCoverageAmount(testdata.get("OldAmuount").toString());
		enrollmentSummaryPage.closeEnrollmentSummary();

		//Click on Term Life
		ViewCoverage_Page.ClickOnPlanDropdown(testdata.get("planName").toString());
		//CLick on the Change Coverage Amount button
		ViewCoverage_Page.clickChangeCoverageAmount();	
		
		change_CA_PR_Page.selectQualifyingEvent();
        //Enter the effective date
        change_CA_PR_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
        WaitForLoadAnimationDisappear();
        //Click on the plan
        change_CA_PR_Page.clickPlan();
        //Change Coverage Amount
        change_CA_PR_Page.ChangeCoverageAmount();	
        //Click Submit button
		change_CA_PR_Page.clickSubmit();
		//Assert.assertNotEquals(changeCoverageAmount.oldCoverageAmount,changeCoverageAmount.VerifyNewCoverageAmount(changeCoverageAmount.newCoverageAmount));
		enrollmentSummaryPage.downloadSummaryDocument();


	}

}
