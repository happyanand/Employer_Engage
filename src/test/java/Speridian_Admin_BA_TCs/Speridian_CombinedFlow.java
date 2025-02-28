package Speridian_Admin_BA_TCs;

import static org.testng.Assert.assertEquals;
import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import Pages.CascadingMembership_Page;
import Pages.ChangeCoverageAmount_PlanRate_Page;
import Pages.EditEmployee_Page;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.EmployeeReinstate_Page;
import Pages.Employee_Page;
import Pages.EnrollReHire_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.ManageCoverage_Page;
import Pages.QEEnrollment_ChangePlan_Page;
import Pages.ReHire_Page;
import Pages.SummaryVerification_Page;
import Pages.TerminateEmployee_Page;
import Pages.UpdateCoveredMembers_Page;
import Pages.ViewBenefits_Page;
import Pages.ViewCoverage_Page;

public class Speridian_CombinedFlow extends Speridian_Admin_BA_AllScenarios{

	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	ChangeCoverageAmount_PlanRate_Page change_CA_PR_Page = new ChangeCoverageAmount_PlanRate_Page();
	ManageCoverage_Page manageCoverage_Page = new ManageCoverage_Page();
	SummaryVerification_Page viewSummary=new SummaryVerification_Page();	
	QEEnrollment_ChangePlan_Page qe_cp_Page = new QEEnrollment_ChangePlan_Page();
	UpdateCoveredMembers_Page updateCoveredMembers= new UpdateCoveredMembers_Page();
	EditEmployee_Page editEmployee= new EditEmployee_Page();
	CascadingMembership_Page cascadeScenario = new CascadingMembership_Page();
	TerminateEmployee_Page terminateEmployeePage = new TerminateEmployee_Page();
	ReHire_Page reHirePage = new ReHire_Page();
	EnrollReHire_Page enrollNewHirePage = new EnrollReHire_Page();
	CascadingMembership_Page cascadescenario = new CascadingMembership_Page();
	EmployeeReinstate_Page employeeReinstatePage = new EmployeeReinstate_Page();
	ViewBenefits_Page viewBenefits = new ViewBenefits_Page();


	public void ValidateCombinedFlow(String TestScenario,String GroupName,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException, ParseException{

		String TerminationDate = testdata.get("TerminationDate").toString();
		String NewEffectiveDate = testdata.get("NewEffectiveDate").toString();
		String EffectiveDate = testdata.get("EffectiveDate").toString();
		String verifyEffectiveDate = testdata.get("VerifyeffectiveDate").toString();
		String VerifyterminationDate = testdata.get("VerifyterminationDate").toString();


		// Select Account name
		Home_Page.SelectGroupname(GroupName);
		// click Employee Administration
		Group_Page.clickEmployeeAdministration();
		// click Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Personal Information
		String result = employeePage.addPersonalInformation(testdata);
		String[] values = result.split(",");	
		String firstname = values[1];
		String lastname = values[2];
		String fullname = firstname+" "+lastname;
		//Add Dependent
		employeePage.addDependent(testdata);
		// Activate And Enroll
		employeePage.activateAndEnroll();
		// Enter Effective Date
		enrollmentPage.enterEffectiveDate(EffectiveDate);
		// Select Plans
		List<Map<String, String>> selectedPlanDetails = enrollmentPage.selectfourSperidianPlans(false,
				testdata.get("planName1").toString(), testdata.get("planName2").toString(),
				testdata.get("planName3").toString(), testdata.get("planName4").toString());
		// Extracting individual plan names
		String Medical = testdata.get("planName1").toString();
		String Dental = testdata.get("planName2").toString();
		String FSA = testdata.get("planName3").toString();
		String VoluntaryTermLife = testdata.get("planName4").toString();
		String Vision = testdata.get("planName5").toString();
		// Add Additional Insurance
		enrollmentPage.addAdditionalInsurance(false, testdata);
		// Submit Enrollment
		//enrollmentPage.submitEnrollment();
		// Verify Enrolled Plan Info Displayed
		enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
		String oldCoveredMember=updateCoveredMembers.VerifyNewMemberNameAdd(updateCoveredMembers.newname);
		String CustomerNo = enrollmentSummaryPage.CustomerNumberReturn();
		System.out.println("Customer no :" + CustomerNo);
		// Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();

		ExtentSuccessMessage("**********Summary Verification**********");
		viewSummary.clickViewSummary();
		assertEquals(GetFilesCountInDownloadDirectory(), 1);
		ExtentSuccessMessage("Successfully Verified Enrollment Summary"); 

		ExtentSuccessMessage("**********View Benefits Informtion**********");
		//Click on the plan
		ViewCoverage_Page.ClickOnPlanDropdown(Medical);
		//viewBenefits.ViewBenefitsInformtion();
		viewBenefits.clickViewBenefits();
		//Click close button in View Benefits popup
		viewBenefits.clickClose();
		// Click On View SBC
		viewBenefits.clickViewSBC();

		ExtentSuccessMessage("**********Update Covered Member - Start**********");
		//Add a Dependent/Beneficiary
		ViewCoverage_Page.ClickUpdateCoveredMembersMedical();
		//Select ActionTypeADD
		updateCoveredMembers.ActionTypeADD();
		//Select QualifyingEvent
		updateCoveredMembers.clickQualifyingEvent();
		//Enter EffectiveDate
		updateCoveredMembers.clickEffectiveDate(testdata);
		// Click On Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(Medical);
		//Select the Covered Member
		updateCoveredMembers.selectCoveredMember();
		//Submit Enrollment
		updateCoveredMembers.clickSubmit();	
		String addedCoveredMember=updateCoveredMembers.VerifyNewMemberNameAdd(updateCoveredMembers.newname);
		Assert.assertNotEquals(oldCoveredMember,addedCoveredMember, "Assertion Passed");
		//Close Summary Document
		enrollmentSummaryPage.ClickOnClose_Button();	
		// Click On Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(Medical);
		//Click UpdateCoveredMembers
		ViewCoverage_Page.ClickUpdateCoveredMembersMedical();
		//Select ActionTypeADD
		updateCoveredMembers.ActionTypeRemove();
		//Select QualifyingEvent
		updateCoveredMembers.clickQualifyingEvent();
		//Enter EffectiveDate
		updateCoveredMembers.clickEffectiveDate(testdata);
		// Add Covered Member
		ViewCoverage_Page.ClickOnPlanDropdown(Medical);
		//Select the Covered Member
		updateCoveredMembers.selectCoveredMember();
		//Submit Enrollment
		updateCoveredMembers.clickSubmit();
		String removedCoveredMember=updateCoveredMembers.VerifyNewMemberNameRemove(updateCoveredMembers.newname);
		Assert.assertNotEquals(addedCoveredMember,removedCoveredMember, "Assertion Passed");
		//Download Summary Document
		enrollmentSummaryPage.downloadSummaryDocument();
		//Click on Close button
		enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("**********Update Covered Member - End**********");

		ExtentSuccessMessage("**********Cascade Scenario - Start**********");
		//click Employee Details
		ViewCoverage_Page.navigateToEmployeeInfo();
		//click Edit 
		employeeInformationPage.clickEdit();
		//Edit Employee Details
		editEmployee.enterNewAddress(testdata);
		editEmployee.scrollTillDependents();
		//Add Dependent
		editEmployee.scrollTillDependents();
		//Add Dependent
		editEmployee.addDependent(testdata);
		Thread.sleep(50000);
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		Thread.sleep(50000);
		//click Submit
		cascadeScenario.clickSubmit();
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		editEmployee.clickYesCoverageRates();
		//click Qualifying Type
		cascadeScenario.clickQualifyingType(testdata);
		//click Medical Cascade Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(Medical);
		//click Child
		cascadeScenario.clickChild();
		WaitForPageLoad();
		//click Cascade Next button
		cascadeScenario.clickNext();
		//Submit Enrollment
		enrollmentPage.submitEnrollment();
		Assert.assertNotEquals(cascadeScenario.fetchFullAddress(testdata),
				cascadeScenario.VerifyAddress(cascadeScenario.address), "Assertion Passed");
		enrollmentSummaryPage.downloadSummaryDocument();
		//Click on Close button
		enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("**********Cascade Scenario - End**********");

		ExtentSuccessMessage("**********Change Plan - Start**********");
		//Click on Medical Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(Medical);
		//Click on the Change Plan button
		ViewCoverage_Page.ChangeplanbuttonMedical();	
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		//Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(NewEffectiveDate);
		//Click on the Respective Plan
		qe_cp_Page.clickPlan();
		//Select the different sub plan
		qe_cp_Page.selectPlan();
		//Click on the Submit button
		qe_cp_Page.clickSubmit();
		//Verify the changes made
		Assert.assertNotEquals(
				enrollmentSummaryPage.VerifyoldPlanName(enrollmentSummaryPage.oldPlanname), 
				enrollmentSummaryPage.VerifynewPlanName(enrollmentSummaryPage.newPlanname),
				"Assertion Passed");
		//Download the Summary document
		enrollmentSummaryPage.downloadSummaryDocument();
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("**********Change Plan - End**********");

		ExtentSuccessMessage("**********Terminate Plan - Start**********");
		// Click on Dental Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(Dental);
		String TerminateDenatalPlanName = ViewCoverage_Page.fetchPlanName(Dental);
		// Click on Termination Date in Dental Plan
		ViewCoverage_Page.ClickonTerminateDentalButton();
		// Terminate Plan
		ViewCoverage_Page.Terminateplan(testdata);
		// Verify Terminate PlanName and Date
		enrollmentSummaryPage.CheckValuePresentUnderTableRow("Declined",TerminationDate);	
		// download Summary Document
		enrollmentSummaryPage.downloadSummaryDocument();
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("**********Terminate Plan - End**********");
		//		
		ExtentSuccessMessage("**********ReEnroll Plan - Start**********");
		ViewCoverage_Page.ClickOnPlanDropdown(Dental);
		// Click on Enroll Button
		//		ViewCoverage_Page.clickEnrollDentalinPlan();
		ViewCoverage_Page.ClickOnDeclinedPlanDropdownEnroll(Dental);
		// Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		Thread.sleep(5000);
		// Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(NewEffectiveDate);
		// Select the different sub plan
		qe_cp_Page.selectPlan();
		// fetch Plan Name
		String ReEnrollPlanName = ViewCoverage_Page.fetchPlanName(Dental);
		// Click on the Submit button
		qe_cp_Page.clickSubmit();
		// Verify the RE Enrollment Plane name and Date
		enrollmentSummaryPage.CheckValuePresentUnderTableRow(ReEnrollPlanName,NewEffectiveDate);
		// download Summary Document
		enrollmentSummaryPage.downloadSummaryDocument();
		//close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();   
		ExtentSuccessMessage("**********ReEnroll Plan - End**********");

		ExtentSuccessMessage("**********QE Enrollment - Start**********");
		//Click on the Medical Plan and Enroll button
		ViewCoverage_Page.ClickOnDeclinedPlanDropdownEnroll(Vision);
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		//Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(NewEffectiveDate);
		//Select the different sub plan
		qe_cp_Page.selectPlan();
		//Click on the Submit button
		qe_cp_Page.clickSubmit();
		//close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("**********QE Enrollment - End**********");

		ExtentSuccessMessage("**********Change Coverage Amount - Start**********");
		// Click On Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(VoluntaryTermLife);
		// Click on Change Coverage Amount button
		ViewCoverage_Page.clickChangeCoverageAmount();
		// Select the Qualifying Event
		change_CA_PR_Page.selectQualifyingEvent();
		Thread.sleep(5000);
		// Enter the effective date
		change_CA_PR_Page.enterEffectiveDate(NewEffectiveDate);
		// Click on the plan
		change_CA_PR_Page.clickPlan();
		//				String OLDChangeCoverageamount = ViewCoverage_Page.fetchPlanAmount(VoluntaryTermLife);
		// Change the Coverage Amount
		change_CA_PR_Page.ChangeCoverageAmount();
		String ChangeCoverageamount = ViewCoverage_Page.fetchPlanAmount(VoluntaryTermLife);
		String ChangeCoveragePlanName = ViewCoverage_Page.fetchPlanName(VoluntaryTermLife);
		// Click the Submit button
		change_CA_PR_Page.clickSubmit();
		// Verify the RE Enrollment Plane name and Date
		enrollmentSummaryPage.ValidateValuePresentUnderTableRow(ChangeCoveragePlanName,NewEffectiveDate,ChangeCoverageamount);
		//Download the Summary document
		enrollmentSummaryPage.downloadSummaryDocument();
		//Close Summary Document
		enrollmentSummaryPage.ClickOnClose_Button();
		ExtentSuccessMessage("**********Change Coverage Amount - End**********");

		ExtentSuccessMessage("**********Enroll and Maintainenece with Rate Edit Plan - Start**********");
		//Click on Fsa Dropdowns
		ViewCoverage_Page.ClickOnPlanDropdown(FSA);
		//Click Change Contribution Amount
		ViewCoverage_Page.ChangeContributionAmount();
		//Select the qualifying event
		change_CA_PR_Page.selectQualifyingEvent();
		//Enter the effective date
		change_CA_PR_Page.enterEffectiveDate(NewEffectiveDate);
		//Click on the plan
		change_CA_PR_Page.clickPlan();
		//Enter the new amount
		change_CA_PR_Page.changePlanYearlyRate(testdata.get("EditedMonthlyAmount").toString());
		String Changedamount = ViewCoverage_Page.fetchPlanAmount(FSA);
		String ChangedPlanName = ViewCoverage_Page.fetchPlanName(FSA);
		//Click on the Submit button
		change_CA_PR_Page.clickSubmit();
		// Verify the RE Enrollment Plane name and Date
		enrollmentSummaryPage.ValidateValuePresentUnderTableRow(ChangedPlanName,NewEffectiveDate,Changedamount);
		//Download the Summary document
		enrollmentSummaryPage.downloadSummaryDocument();
		//Close Summary Document
		enrollmentSummaryPage.ClickOnClose_Button();
		ExtentSuccessMessage("**********Enroll and Maintainenece with Rate Edit Plan - End**********");

		ExtentSuccessMessage("**********Terminate Employeee  - Start**********");
		// Click On Employee Details
		ViewCoverage_Page.ClickOnEmployeeDetails();
		// click Terminate
		employeeInformationPage.clickTerminate();
		// Terminate Employee
		terminateEmployeePage.TerminateEmployee(TerminationDate);
		// Click On Close_Button
		enrollmentSummaryPage.ClickOnClose_Button();
		ExtentSuccessMessage("**********Terminate Employeee  - End**********");

		ExtentSuccessMessage("**********Employee Re-Hire - Start**********");
		//Click on Employee Details
		ViewCoverage_Page.ClickOnEmployeeDetails();
		//Click on ReHire button
		employeeInformationPage.clickReHire();
		//Click on ReHire and Enroll button
		reHirePage.reHireAndEnroll();
		//Click on Next Button
		enrollNewHirePage.clickNext();
		Thread.sleep(8000);
		//Enroll the Plans
		enrollmentPage.selectfourSperidianPlans(false,Medical,Dental,Vision,VoluntaryTermLife);
		// add Additional Insurance
		enrollmentPage.addAdditionalInsurance(false, testdata);
		//Click on Submit button
		enrollmentPage.submitEnrollment();
		WaitForLoadAnimationDisappear();
		WaitForPageLoad();
		//Click on Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("**********Employee Re-Hire - End**********");

		ExtentSuccessMessage("**********Terminate Employeee For Reinstate**********");
		// Click On Employee Details
		ViewCoverage_Page.ClickOnEmployeeDetails();
		// click Terminate
		employeeInformationPage.clickTerminate();
		// Terminate Employee
		terminateEmployeePage.TerminateEmployee(NewEffectiveDate);
		// Click On Close_Button
		enrollmentSummaryPage.ClickOnClose_Button();

		ExtentSuccessMessage("**********Reinstate Employeee**********");
		// navigate To Group Dashboard
		Group_Page.navigateToGroupDashboard();
		// click Employee Administration
		Group_Page.clickEmployeeAdministration();
		// search And Navigate To Employee Info
		employeeAdministration.searchAndNavigateToEmployeeInfo(CustomerNo);
		// click Reinstate
		employeeInformationPage.clickReinstate();
		// Selected Plan Categories
		List<String> CurrentPlans = employeeReinstatePage.getSelectedPlanCategories();
		System.out.println("CurrentPlans: "+CurrentPlans);
		String CurrentPlans1 = String.join(", ", CurrentPlans);
		System.out.println("Combined String: " + CurrentPlans1);
		// restore
		employeeReinstatePage.restore();
		Assert.assertTrue(employeeReinstatePage.isRestoreSuccessfulMessageDisplayed());
		String status =employeeInformationPage.GetBenefitStatus();
		assertEquals(status, "Active");
	}
}
