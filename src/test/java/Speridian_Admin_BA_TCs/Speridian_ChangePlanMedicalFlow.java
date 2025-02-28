package Speridian_Admin_BA_TCs;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

//import Pages.ChangePlanMedical_Page;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.QEEnrollment_ChangePlan_Page;
import Pages.ViewCoverage_Page;

public class Speridian_ChangePlanMedicalFlow extends Speridian_Admin_BA_AllScenarios {
	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	QEEnrollment_ChangePlan_Page qe_cp_Page = new QEEnrollment_ChangePlan_Page();
	
	//Validate Change Plan Medical
	public void ValidateChangePlanMedical(String TestScenario,String GroupName,Map<Object, Object> testdata) throws InterruptedException, AWTException
	{		
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
		//Click On Close Button
		enrollmentSummaryPage.ClickOnClose_Button();
		//Click on Medical Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(testdata.get("planName").toString());
		//Click on the Change Plan button
		ViewCoverage_Page.ChangeplanbuttonMedical();
		
		//Changes  Plan Steps
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		//Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		//Click on the Respective Plan
		qe_cp_Page.clickPlan();
		//Select the different sub plan
		qe_cp_Page.selectPlan();
		//Click on the Submit button
		qe_cp_Page.clickSubmit();
		//Verify the changes made
		Assert.assertNotEquals(enrollmentSummaryPage.VerifyoldPlanName(enrollmentSummaryPage.oldPlanname), enrollmentSummaryPage.VerifynewPlanName(enrollmentSummaryPage.newPlanname),"Assertion Passed");
		//Download the Summary document
		enrollmentSummaryPage.downloadSummaryDocument();
	}
}