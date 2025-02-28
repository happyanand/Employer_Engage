package FBMC_Admin_BA_TCs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import Pages.AccountSummary_Page;
import Pages.AccountsReceivable_Page;
import Pages.CascadingMembership_Page;
import Pages.ChangeCoverageAmount_PlanRate_Page;
import Pages.CorrespondenceLetters_Page;
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
import Pages.Make_Payment_Page;
import Pages.Payment_Profile;
import Pages.QEEnrollment_ChangePlan_Page;
import Pages.ReHire_Page;
import Pages.TerminateEmployee_Page;
import Pages.UpdateCoveredMembers_Page;
import Pages.ViewCoverage_Page;
import bsh.ParseException;

public class FBMC_CombinedFlow extends FBMC_Admin_BA_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	Payment_Profile Payment_Profile = new Payment_Profile();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	AccountSummary_Page accountSummary_Page = new AccountSummary_Page();
	QEEnrollment_ChangePlan_Page qe_cp_Page = new QEEnrollment_ChangePlan_Page();
	UpdateCoveredMembers_Page updateCoveredMembers = new UpdateCoveredMembers_Page();
	ChangeCoverageAmount_PlanRate_Page change_CA_PR_Page = new ChangeCoverageAmount_PlanRate_Page();
	Make_Payment_Page makePayment = new Make_Payment_Page();
	AccountsReceivable_Page accountsReceivable_Page = new AccountsReceivable_Page();
	TerminateEmployee_Page terminateEmployeePage = new TerminateEmployee_Page();
	EmployeeReinstate_Page employeeReinstatePage=new EmployeeReinstate_Page();
	CascadingMembership_Page cascadeScenario = new CascadingMembership_Page();
	EditEmployee_Page editEmployee= new EditEmployee_Page();
	CorrespondenceLetters_Page CCLetterVerification=new CorrespondenceLetters_Page();
	ReHire_Page reHirePage=new ReHire_Page();
	EnrollReHire_Page enrollNewHirePage=new EnrollReHire_Page();
	
	public void ValidateFBMC_CombinedFlow(String TestScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException, IOException, ParseException, java.text.ParseException {
		String EffectiveDate = testdata.get("EffectiveDate").toString();
		String NewEffectiveDate = testdata.get("NewEffectiveDate").toString();
		String TerminatePlanDate = testdata.get("TerminationDate").toString();
		String EmployeeTerminationDate = testdata.get("TerminationDate").toString();
		
		// Select Group
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
		String result = employeePage.addPersonalInformation(testdata);
		String[] values = result.split(",");
		String ssn = values[0];
		String firstname = values[1];
		String lastname = values[2];
		// Add Dependent
		employeePage.addDependent(testdata);
		// Click on activateAndEnroll
		employeePage.activateAndEnroll();
		// Enter Effective Date
		enrollmentPage.enterEffectiveDate(EffectiveDate);
		enrollmentPage.ClickonWarningOkButton();
		WaitForLoadAnimationDisappear();
		// Select Plans
		List<Map<String, String>> selectedPlanDetails = enrollmentPage.selectfourPlans(false,
				testdata.get("planName1").toString(), testdata.get("planName2").toString(),
				testdata.get("planName3").toString(), testdata.get("planName4").toString());
		// Extracting individual plan names
		String Medical = testdata.get("planName1").toString();
		String Dental = testdata.get("planName2").toString();
		String TermLife = testdata.get("planName3").toString();
		String MedicalBridge = testdata.get("planName4").toString();
		String Medicare = testdata.get("planName5").toString();
		//List<String> plans = enrollmentPage.getAllSelectedPlans();
		// Add Additional Insurance
		enrollmentPage.addAdditionalInsurance(false, testdata);
		// Click Next btn
		enrollmentPage.clickNext();
		// Add Payment Profile
		if(testdata.get("PaymentMethod").toString().equalsIgnoreCase("ACH")) {
			Payment_Profile.addProfileWithACH(true, "Chase", "021300077", false);
		} else {
			Payment_Profile.addProfileWithPensionAuthority(true);
		}
		// submit Enrollment
		enrollmentPage.submitEnrollment();
		//Verify if the Enrolled plans info is displayed or not. 
	    enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
	    String CustomerNo = enrollmentSummaryPage.CustomerNumberReturn();
	    //Fetch the Address Details
	    String OldAddress = enrollmentSummaryPage.getAddress();
//	//Fetch the Member Details
//	String oldname = enrollmentSummaryPage.fetchMemberName();
		//Close the Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		// Click on Medical Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(Medical);
		// Fetch the Plan Amount
		String MedicalAmount = ViewCoverage_Page.fetchPlanAmount(Medical);
		// Click on Medical Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(Medical);
		Thread.sleep(5000);
		// Click on Dental Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(Dental);
		// Fetch the Plan Amount
		String DentalAmount = ViewCoverage_Page.fetchPlanAmount(Dental);
		// Click on Dental Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(Dental);
		// Click on the Employee Details
		ViewCoverage_Page.ClickOnEmployeeDetails();
		// Click on Account Summary
		employeeInformationPage.clickAccountSummary();
		// Click on View Transactions
		accountSummary_Page.ClickOnViewTransactions();
		// Click on the Search Dropdown
		accountSummary_Page.ClickOnAdvancedSearchDropdown();
		// Select the plan
		accountSummary_Page.selectPlanFromPlanDropdown(Dental);
		// Verify the Dental Plan
		accountSummary_Page.planVerification(Dental, DentalAmount, EffectiveDate);
		// Select the plan
		accountSummary_Page.selectPlanFromPlanDropdown(Medical);
		// Verify the Dental Plan
		accountSummary_Page.planVerification(Medical, MedicalAmount, EffectiveDate);
		//Click Close button
		accountSummary_Page.clickClosebutton();
		
		ExtentSuccessMessage("**********Correspondence Letters (New Enrollment)**********");
		//Logic for the Admin and BA User.
		if (loginuser_Type.equalsIgnoreCase("Admin")) {
		//Click on the Employee Details
		ViewCoverage_Page.ClickOnEmployeeDetails();
		//Click on Attachments Tab
		employeeInformationPage.clickAttachments();
		//Get the Letter Type of the Document
		String LetterType = employeeInformationPage.getLetterType();
		//Click on the document
		employeeInformationPage.clickDocument();
		//Click on Home Page button
		Home_Page.clickHomePage();
		//Click on the Communication Tab
		Home_Page.clickCommunicationTab();
		//Click on the Correspondence Letters
		Home_Page.clickCorrespondenceLetters();
		//Select the ALL status in Correspondence type
        CCLetterVerification.selectCTALLstatus();
        //Search for the employee in Advanced search
		CCLetterVerification.ASsearchemployee(ssn);
		//Validate the Document Name
		CCLetterVerification.validateDocumentName(CustomerNo,lastname,LetterType);
		//Click on the Document
		CCLetterVerification.clickDocument();
 }
				
		ExtentSuccessMessage("**********Cascade Scenario**********");
		//Click Close button
		Home_Page.clickHomePage();
		//Select Group
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		//Search for the Employee and Navigate to the Employee
		employeeAdministration.searchAndNavigateToEmployeeInfo(ssn);
//		//Click Manage Coverage (Only use when Cascade Scenario is not Working)
//		employeeInformationPage.clickManageCoverage();
		//Click on Edit button
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
		//Fetch the Address details in the Enrollment Summary Page
		String NewAddress = enrollmentSummaryPage.getAddress();
		//Validate the Covered Members with the Old Covered Members
		enrollmentSummaryPage.ValidateAddress(NewAddress,OldAddress);
		//Fetch the Member Details
		String oldname = enrollmentSummaryPage.fetchMemberName();
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		
		ExtentSuccessMessage("**********(Update Covered Members - Medical)*****Add Spouse, Verification**********");
		//Click on Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(Medical);
		// Click UpdateCoveredMembers
		ViewCoverage_Page.ClickUpdateCoveredMembersMedical();
		// Select ActionTypeADD
		updateCoveredMembers.ActionTypeADD();
		// Select QualifyingEvent
		updateCoveredMembers.clickQualifyingEvent();
		// Enter EffectiveDate
		enrollmentPage.enterEffectiveDate(EffectiveDate);
		// Add Covered Member
		ViewCoverage_Page.ClickOnPlanDropdown(Medical);
		// Select the Covered Member
		updateCoveredMembers.selectCoveredMember();
		// Click Next
		updateCoveredMembers.clickNext();
		// Add Profile With PensionAuthority
		enrollmentPage.addProfileWithPensionAuthority(false);
		// Submit Enrollment
		updateCoveredMembers.clickSubmit();
		//Fetch the New name after Update Covered Members
		String newname = enrollmentSummaryPage.fetchMemberName();
		// Verify in the Enrollment Summary Page
		enrollmentSummaryPage.ValidateMemberNames(newname, oldname);
		//Download the Summary Document.
		enrollmentSummaryPage.downloadSummaryDocument();
		//Fetch the Plan Name
		String OldPlanName = enrollmentSummaryPage.fetchPlanName();
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		
		ExtentSuccessMessage("**********Change Plan Medical**********");
		//Click on Medical Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(Medical);
		// Click on Change Plan button Dental
		ViewCoverage_Page.ChangeplanbuttonMedical();
		// Changes Plan Steps
		// Select the Qualifying Event
		change_CA_PR_Page.selectQualifyingEvent();
		//Thread.sleep(5000);
		// Enter the effective date
		change_CA_PR_Page.enterEffectiveDate(EffectiveDate);
		// Click on the plan
		change_CA_PR_Page.clickPlan();
		// Select the different sub plan
		qe_cp_Page.selectPlan();
		// Click the Next button
		change_CA_PR_Page.clickNext();
		// Add Profile With PensionAuthority
		enrollmentPage.addProfileWithPensionAuthority(false);
		// Click the Submit button
		change_CA_PR_Page.clickSubmit();
		//Fetch the Plan Name
		String NewPlanName = enrollmentSummaryPage.fetchPlanName();
		//Verify in the Enrollment Summary Page
		enrollmentSummaryPage.ValidatePlanNames(NewPlanName, OldPlanName);
	    //Fetch the Old Termination Date for Dental
	    String oldDate = enrollmentSummaryPage.fetchDentalTerminationDate();
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
	   
		ExtentSuccessMessage("*****QE Enroll Medicare*****");
		//Click on the Medicare Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(Medicare);
		// Click on Enroll Button
		ViewCoverage_Page.clickonEnrollBtnUnderDeclinedplans();
		// Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		// Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(EffectiveDate);
		// Select the different sub plan
		qe_cp_Page.selectPlan();
		// Click on the Next button
		qe_cp_Page.clickNext();
		// Add Profile With PensionAuthority
		enrollmentPage.addProfileWithPensionAuthority(false);
		// Click on the Submit button
		qe_cp_Page.clickSubmit();
		List<String> plans = enrollmentPage.getAllSelectedPlans();
		//Fetch the QE Plan
		String QEPlanName = enrollmentSummaryPage.fetchQEPlanDetails();
		//Verify in the Enrollment Summary Page
		enrollmentSummaryPage.ValidateQEPlanDetails(QEPlanName, Medicare);
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary(); 
		
		ExtentSuccessMessage("**********Terminate Dental**********");
		// Click on Dental Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(Dental);
		// Click on Termination Date in Dental Plan
		ViewCoverage_Page.ClickonTerminateDentalButton();
		// Terminate Plan
		ViewCoverage_Page.Terminateplan(testdata);
		//Fetch the Old Termination Date for Dental
	    String newDate = enrollmentSummaryPage.fetchDentalTerminationDate();
		//Verify in the Enrollment Summary Page
	    enrollmentSummaryPage.ValidateEndDates(newDate,oldDate);
	    //Fetch the Start Date before ReEnroll
	    String oldStartDate = enrollmentSummaryPage.fetchDentalReEnrollDate();
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		
		ExtentSuccessMessage("*****ReEnroll Dental*****");
		// Click on Dental Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(Dental);
		// Click on Enroll Button
		ViewCoverage_Page.clickEnrollDentalinPlan();
		// Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		// Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(NewEffectiveDate);
		// Select the different sub plan
		qe_cp_Page.selectPlan();
		// Click on the Next button
		qe_cp_Page.clickNext();
		// Add Profile With PensionAuthority
		enrollmentPage.addProfileWithPensionAuthority(false);
		// Click on the Submit button
		qe_cp_Page.clickSubmit();
		//Fetch the new ReEnroll Date
		String newReEnrollDate = enrollmentSummaryPage.fetchDentalReEnrollDate();
		//Verify in the Enrollment Summary Page
		enrollmentSummaryPage.ValidateReEnrollDates(newReEnrollDate, oldStartDate);
	    //Fetch the Subscriber Amount
	    String oldAmount = enrollmentSummaryPage.fetchChangeCoverageAmount();
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
	    
		ExtentSuccessMessage("*****Change Coverage Amount*****");
		ViewCoverage_Page.ClickOnPlanDropdown(TermLife);
		// Click on Change Coverage Amount button
		ViewCoverage_Page.clickChangeCoverageAmount();
		// Select the Qualifying Event
		change_CA_PR_Page.selectQualifyingEvent();
		// Enter the effective date
		change_CA_PR_Page.enterEffectiveDate(EffectiveDate);
		//Click on the plan
        change_CA_PR_Page.clickPlan();
		//Change the Coverage Amount
		change_CA_PR_Page.ChangeCoverageAmount();
		//Click on the Next Button
		change_CA_PR_Page.clickNext();
		// Add Profile With PensionAuthority
		enrollmentPage.addProfileWithPensionAuthority(false);
		// Click the Submit button
		change_CA_PR_Page.clickSubmit();
		//Fetch the Subscriber Amount
	    String newAmount = enrollmentSummaryPage.fetchChangeCoverageAmount();
		//Verify in the Enrollment Summary Page
	    enrollmentSummaryPage.ValidateChangeCoverageAmount(newAmount, oldAmount);
		//Fetch the Medical Bridge Amount
		String oldRate = enrollmentSummaryPage.fetchChangePlanRate();
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		
		ExtentSuccessMessage("*****Change Plan Rate*****");
		//Click on Medical Bridge Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(MedicalBridge);
		//Click on Change Plan Rate button
		ViewCoverage_Page.ChangeplanbuttonMedicalbridge();
		//Select the qualifying event
		change_CA_PR_Page.selectQualifyingEvent();
		//Enter the effective date
		change_CA_PR_Page.enterEffectiveDate(EffectiveDate);
		//Click on the plan
		change_CA_PR_Page.clickPlan();
		//Enter the new amount
		change_CA_PR_Page.changePlanMonthlyRate(testdata.get("EditedMonthlyAmount").toString());
		//Click on the Next button
		change_CA_PR_Page.clickNext();
		// Add Profile With PensionAuthority
		enrollmentPage.addProfileWithPensionAuthority(false);
		//Click on the Submit button
		qe_cp_Page.clickSubmit();
		//Fetch the New Medical Bridge Amount
		String newRate = enrollmentSummaryPage.fetchChangePlanRate();
		//Verify in the Enrollment Summary Page
		enrollmentSummaryPage.ValidateChangePlanRate(newRate,oldRate );
		//Close the Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		
		ExtentSuccessMessage("*****Terminate Employee Flow*****");
		//Click on Employee Details
		ViewCoverage_Page.ClickOnEmployeeDetails();
		//Click Terminate
		employeeInformationPage.clickTerminate();
		//Terminate Employee
		terminateEmployeePage.terminateEmployee(EmployeeTerminationDate);
		//Employee Termination Message Displayed
		terminateEmployeePage.isEmployeeTerminationMessageDisplayed();
		//close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		
		ExtentSuccessMessage("*****Terminate Employee Flow*****");
		//Click On Employee Details
		ViewCoverage_Page.ClickOnEmployeeDetails();
		//click Reinstate
		employeeInformationPage.clickReinstate();
      //click Restore
      employeeReinstatePage.restore();
      //Validate if the Restore Message is displayed or not. 
      Assert.assertTrue(employeeReinstatePage.isRestoreSuccessfulMessageDisplayed());
        
        ExtentSuccessMessage("*****Terminate Employee Flow*****");
		//Click Terminate
		employeeInformationPage.clickTerminate();
		//Terminate Employee
		terminateEmployeePage.terminateEmployee(EmployeeTerminationDate);
		//Employee Termination Message Displayed
		terminateEmployeePage.isEmployeeTerminationMessageDisplayed();
		//close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		
		ExtentSuccessMessage("*****Re-Hire and Re-Enroll*****");
		//Click on Employee Details
		ViewCoverage_Page.ClickOnEmployeeDetails();
		//click ReHire
        employeeInformationPage.clickReHire();
        //ReHire And Enroll
        reHirePage.reHireAndEnroll();
        //click Next
        enrollNewHirePage.clickNext();
        //Select Plan
        enrollNewHirePage.selectPlan("Vision");
        //Add Additional Insurance
        enrollmentPage.addAdditionalInsurance(false,testdata);
        //click Next
        enrollmentPage.clickNext();
        //Add Payment Profile
        enrollmentPage.addProfileWithPensionAuthority(false);
        //Submit Enrollment
        enrollmentPage.submitEnrollment();
        //Verify if the Enrolled plans info is displayed or not. 
	    enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
	    //Click on Download Summary Document
	    enrollmentSummaryPage.downloadSummaryDocument();
        //Close Enrollment Summary
      	enrollmentSummaryPage.closeEnrollmentSummary();
		
	}
	
}
