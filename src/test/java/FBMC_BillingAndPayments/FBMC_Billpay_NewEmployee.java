package FBMC_BillingAndPayments;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.testng.Assert;

import Pages.AccountSummary_Page;
import Pages.Accounts_Payable_Page;
import Pages.AccountsReceivable_Page;
import Pages.ChangeCoverageAmount_PlanRate_Page;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.EmployeeReinstate_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Make_Payment_Page;
import Pages.Payment_Profile;
import Pages.QEEnrollment_ChangePlan_Page;
import Pages.Refund_Center_Page;
import Pages.TerminateEmployee_Page;
import Pages.UpdateCoveredMembers_Page;
import Pages.ViewCoverage_Page;
import Pages.Cash_Ledger_Page;
import Pages.Refund_Center_Page;
import bsh.ParseException;

public class FBMC_Billpay_NewEmployee extends FBMC_BillingAndPayments_AllScenarios {

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
	Cash_Ledger_Page Cash_Ledger_Page = new Cash_Ledger_Page();	
	Refund_Center_Page Refund_Center_Page = new Refund_Center_Page();		
	Accounts_Payable_Page Accounts_Payable_Page = new Accounts_Payable_Page();	
	TerminateEmployee_Page terminateEmployeePage = new TerminateEmployee_Page();
	EmployeeReinstate_Page employeeReinstatePage=new EmployeeReinstate_Page();

	public void ValidateFBMC_Billpay_NewEmployee(String TestScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException, IOException, ParseException, java.text.ParseException {
		String effectivDate = testdata.get("EffectiveDate").toString();
		String NewEffectiveDate = testdata.get("NewEffectiveDate").toString();
		String TerminatePlanDate = testdata.get("TerminationDate").toString();
		String ChangePlanRateEffectiveDate = testdata.get("ChangePlanRateEffectiveDate").toString();
		String QEEffectiveDate = testdata.get("QEEffectiveDate").toString();
		String ReEnrollEffectiveDate = testdata.get("ReEnrollEffectiveDate").toString();
		String EmployeeTerminationDate = testdata.get("EmployeeTerminationDate").toString();
		String amountString = testdata.get("Amount").toString();
		int amount = Integer.parseInt(amountString);

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
		System.out.println("ssn:- = "+ssn);
		String firstname = values[1];
		String lastname = values[2];
		String FullName = firstname + " " + lastname;
		// Add Dependent
		employeePage.addDependent(testdata);
		// Click on activateAndEnroll
		employeePage.activateAndEnroll();
		// Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
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
		String Vision = testdata.get("planName5").toString();
		// addAdditionalInsurance
		enrollmentPage.addAdditionalInsurance(false, testdata);
		// Click Next btn
		enrollmentPage.clickNext();
		// Add Payment Profile
		Payment_Profile.ClickOnPaymentProfileNo();
		// submit Enrollment
		enrollmentPage.submitEnrollment();
		enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
		String CustomerNo =enrollmentSummaryPage.CustomerNumberReturn();
		System.out.println("CustomerNo:- "+CustomerNo);
		//Close the Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		// Click on Medical Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(Medical);
		// Fetch the Plan Amount
		String MedicalAmount = ViewCoverage_Page.fetchPlanAmount(Medical);
		// Click on Medical Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(Medical);
		Thread.sleep(1000);
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
		// Click on the  Search Dropdown 
		accountSummary_Page.ClickOnAdvancedSearchDropdown(); 
		//Select the plan
		accountSummary_Page.selectPlanFromPlanDropdown(Dental); 
		// Verify the Dental Plan
		accountSummary_Page.planVerification(Dental,DentalAmount, effectivDate);
		// Select the plan
		accountSummary_Page.selectPlanFromPlanDropdown(Medical);
		// Verify the DentalPlan 
		accountSummary_Page.planVerification(Medical, MedicalAmount,effectivDate);

//		ExtentSuccessMessage("**********(Update Covered Members)*****Add Spouse, Verification**********");
//		//Click Close button
//		accountSummary_Page.clickClosebutton();
//		// Click on Manage Coverage
//		accountSummary_Page.clickManageCoveragebutton();
//		//Click on Plan Dropdown
//		ViewCoverage_Page.ClickOnPlanDropdown(Medical);
//		// Click UpdateCoveredMembers
//		ViewCoverage_Page.ClickUpdateCoveredMembersMedical();
//		// Select ActionTypeADD
//		updateCoveredMembers.ActionTypeADD();
//		// Select QualifyingEvent
//		updateCoveredMembers.clickQualifyingEvent();
//		// Enter EffectiveDate
//		enrollmentPage.enterEffectiveDate(effectivDate);
//		// Add Covered Member
//		ViewCoverage_Page.ClickOnPlanDropdown(Medical);// (testdata.get("planName").toString());
//		// Select the Covered Member
//		updateCoveredMembers.selectCoveredMember();
//		// Fetch the Plan Amount
//		String UCMMedicalAmount = ViewCoverage_Page.fetchPlanAmount(Medical);
//		System.out.println("UCMMedicalAmount :- " + UCMMedicalAmount);
//		// Click Next
//		updateCoveredMembers.clickNext();
//		// Add Profile With PensionAuthority
//		enrollmentPage.addProfileWithPensionAuthority(false);
//		// Submit Enrollment
//		updateCoveredMembers.clickSubmit();
//
//		ExtentSuccessMessage("***********Account Summary Verification**********");
//		// Close the Enrollment Summary
//		enrollmentSummaryPage.closeEnrollmentSummary();
//		// Click on the Employee Details
//		ViewCoverage_Page.ClickOnEmployeeDetails();
//		// Click on Account Summary
//		employeeInformationPage.clickAccountSummary();
//		// Click on View Transactions
//		accountSummary_Page.ClickOnViewTransactions();
//		// Click on the Search Dropdown
//		accountSummary_Page.ClickOnAdvancedSearchDropdown();
//		// Select the plan
//		accountSummary_Page.selectPlanFromPlanDropdown(Medical);
//		// Check Value Present Under Table Row
//		accountSummary_Page.validateEntries(Medical,effectivDate,"Credit", "Change Dependent",MedicalAmount);
//		// Check Value Present Under Table Row
//		accountSummary_Page.validateEntries(Medical,effectivDate,"Charge", "Change Dependent",UCMMedicalAmount);
//
//		ExtentSuccessMessage("**********Terminate Dental**********");
//		// Click on close
//		accountSummary_Page.clickClosebutton();
//		// Click on Manage Coverage
//		accountSummary_Page.clickManageCoveragebutton();
//		// Click on Dental Plan Dropdown
//		ViewCoverage_Page.ClickOnPlanDropdown(Dental);
//		// Click on Termination Date in Dental Plan
//		ViewCoverage_Page.ClickonTerminateDentalButton();
//		// Terminate Plan
//		ViewCoverage_Page.Terminateplan(testdata);
//		// Close the Enrollment Summary
//		enrollmentSummaryPage.closeEnrollmentSummary();
//		String TerminationDentalAmount = null;
//		try {	
//			// Click on Plan Dropdown
//			ViewCoverage_Page.ClickOnPlanDropdown(Dental);
//			// Fetch the Plan Amount
//			TerminationDentalAmount = ViewCoverage_Page.fetchPlanAmount(Dental);
//		} catch (Exception e) {
//			// Handle the exception (e.g., log it)
//			System.out.println("Unable to click on Plan Dropdown. Continuing with Employee Details.");
//		} finally {
//			// Click on Employee Details (whether or not an exception occurred)
//			ViewCoverage_Page.ClickOnEmployeeDetails();
//		}
//		//Click on Account Summary
//		employeeInformationPage.clickAccountSummary();
//		//Click on View Transactions
//		accountSummary_Page.ClickOnViewTransactions();
//		//Click on Advacned Search Dropdown
//		accountSummary_Page.ClickOnAdvancedSearchDropdown();
//		//Select the Plan from Plan Dropdown
//		accountSummary_Page.selectPlanFromPlanDropdown(Dental);
//		//Select Transaction Type
//		accountSummary_Page.transactiontype("Credit");	
//		System.out.println(TerminationDentalAmount);
//		WaitForLoadAnimationDisappear();
//		//		// Verify the Dental Plan
//		//		if (TerminationDentalAmount != null) {
//		//			// Use TerminationDentalAmount for verification. 
//		//			accountSummary_Page.terminatePlanVerification(Dental, TerminationDentalAmount, TerminatePlanDate);
//		//		} else {
//		//			// Use DentalAmount for verification.
//		//			accountSummary_Page.terminatePlanVerification(Dental, DentalAmount, TerminatePlanDate);
//		//		}
//
//		ExtentSuccessMessage("*****QE Enrollment*****");
//		// Click on close
//		accountSummary_Page.clickClosebutton();
//		// Click on Manage Coverage
//		accountSummary_Page.clickManageCoveragebutton();
//		// Click on the Vision Dropdown and Enroll Button
//		ViewCoverage_Page.ClickOnDeclinedPlanDropdownEnroll(Vision);
//		// Select the Qualifying Event
//		qe_cp_Page.selectQualifyingEvent();
//		// Enter the Effective Date
//		qe_cp_Page.enterEffectiveDate(testdata.get("EffectiveDate").toString());
//		// Select the different sub plan
//		qe_cp_Page.selectPlan();
//		// Click on the Next button
//		qe_cp_Page.clickNext();
//		// Click On Payment Profile No
//		Payment_Profile.ClickOnPaymentProfileNo();
//		// Click on the Submit button
//		qe_cp_Page.clickSubmit();
//		// Close the Enrollment Summary
//		enrollmentSummaryPage.closeEnrollmentSummary();
//		// Click on Vision Dropdown
//		ViewCoverage_Page.ClickOnPlanDropdown(Vision);
//		// Fetch the Plan Amount
//		String VisionAmount = ViewCoverage_Page.fetchPlanAmount(Vision);
//		// Click on Employee Details
//		ViewCoverage_Page.ClickOnEmployeeDetails();
//		// Click on Account Summary
//		employeeInformationPage.clickAccountSummary();
//		// Click on View Transactions
//		accountSummary_Page.ClickOnViewTransactions();
//		// Click on the Search Dropdown
//		accountSummary_Page.ClickOnAdvancedSearchDropdown();
//		// Select the plan
//		accountSummary_Page.selectPlanFromPlanDropdown(Vision);
//		// Verify the Dental Plan
//		accountSummary_Page.QeValidation(Vision, VisionAmount, QEEffectiveDate);
//
//		ExtentSuccessMessage("*****ReEnrollDental*****");
//		// Click on close
//		accountSummary_Page.clickClosebutton();
//		// Click on Manage Coverage
//		accountSummary_Page.clickManageCoveragebutton();
//		// Click on Dental Plan Dropdown
//		ViewCoverage_Page.ClickOnPlanDropdown(Dental);
//		// Click on Enroll Button
//		ViewCoverage_Page.clickEnrollDentalinPlan();
//		// Select the Qualifying Event
//		qe_cp_Page.selectQualifyingEvent();
//		Thread.sleep(5000);
//		// Enter the Effective Date
//		qe_cp_Page.enterEffectiveDate(ReEnrollEffectiveDate);
//		// Select the different sub plan
//		qe_cp_Page.selectPlan();
//		// Click on the Next button
//		qe_cp_Page.clickNext();
//		// Click On Payment Profile No
//		Payment_Profile.ClickOnPaymentProfileNo();
//		Thread.sleep(1000);
//		// Click on the Submit button
//		qe_cp_Page.clickSubmit();
//		// Close the Enrollment Summary
//		enrollmentSummaryPage.closeEnrollmentSummary();
//		// Click on Vision Dropdown
//		ViewCoverage_Page.ClickOnPlanDropdown(Dental);
//		// Fetch the Plan Amount
//		String ReEnrollDentalAmount = ViewCoverage_Page.fetchPlanAmount(Dental);
//		ViewCoverage_Page.ClickOnPlanDropdown(Dental);
//		// Click on Employee Details
//		ViewCoverage_Page.ClickOnEmployeeDetails();
//		// Click on Account Summary
//		employeeInformationPage.clickAccountSummary();
//		// Click on View Transactions
//		accountSummary_Page.ClickOnViewTransactions();
//		// Click on the Search Dropdown
//		accountSummary_Page.ClickOnAdvancedSearchDropdown();
//		// Select the plan
//		accountSummary_Page.selectCategoryFromDropdown(Dental);
//		// Verify the Dental Plan
//		accountSummary_Page.ReEnrollValidation(Dental, ReEnrollDentalAmount, ReEnrollEffectiveDate);
//
//		ExtentSuccessMessage("************Change coverage amt*****************");
//		// Click On Transaction_Details_CloseButton
//		accountSummary_Page.clickClosebutton();
//		// Click Manage Coverage
//		employeeInformationPage.clickManageCoverage();
//		// Click On Plan Dropdown
//		ViewCoverage_Page.ClickOnPlanDropdown(TermLife);
//		// Click on Change Coverage Amount button
//		ViewCoverage_Page.clickChangeCoverageAmount();
//		// Select the Qualifying Event
//		change_CA_PR_Page.selectQualifyingEvent();
//		Thread.sleep(5000);
//		// Enter the effective date
//		change_CA_PR_Page.enterEffectiveDate(NewEffectiveDate);
//		WaitForLoadAnimationDisappear();
//		// Click on the plan
//		change_CA_PR_Page.clickPlan();
//		String OLDChangeCoverageamount = ViewCoverage_Page.fetchPlanAmount(TermLife);
//		// Change the Coverage Amount
//		change_CA_PR_Page.ChangeCoverageAmount();
//		String ChangeCoverageamount = ViewCoverage_Page.fetchPlanAmount(TermLife);
//		String ChangeCoveragePlanName = ViewCoverage_Page.fetchPlanName(TermLife);
//		// Click the Next button
//		change_CA_PR_Page.clickNext();
//		// Click On Payment Profile No
//		Payment_Profile.ClickOnPaymentProfileNo();
//		// Click the Submit button
//		change_CA_PR_Page.clickSubmit();
//
//		ExtentSuccessMessage("************Account Summary Verification**********");
//		// Close the Enrollment Summary
//		enrollmentSummaryPage.closeEnrollmentSummary();
//		// Click on the Employee Details
//		ViewCoverage_Page.ClickOnEmployeeDetails();
//		// Click on Account Summary
//		employeeInformationPage.clickAccountSummary();
//		// Click on View Transactions
//		accountSummary_Page.ClickOnViewTransactions();
//		// Click on the Search Dropdown
//		accountSummary_Page.ClickOnAdvancedSearchDropdown();
//		// Select the plan
//		accountSummary_Page.selectPlanFromPlanDropdown(ChangeCoveragePlanName);
//		// Verify the Plan
//		//accountSummary_Page.planVerification(ChangeCoveragePlanName, ChangeCoverageamount, NewEffectiveDate);
//		// Check Value Present Under Table Row
//		accountSummary_Page.CheckValuePresentUnderTableRow(TermLife,NewEffectiveDate,"Credit","Change Plan",OLDChangeCoverageamount);
//		// Check Value Present Under Table Row
//		accountSummary_Page.CheckValuePresentUnderTableRow(TermLife,NewEffectiveDate,"Charge","Change Plan",ChangeCoverageamount);
//
//		ExtentSuccessMessage("************Change Plan/Rate*****************");		
//		//Click on close
//		accountSummary_Page.clickClosebutton();
//		//Click on Manage Coverage
//		accountSummary_Page.clickManageCoveragebutton();
//		//Click on Medical Bridge Plan Dropdown
//		ViewCoverage_Page.ClickOnPlanDropdown(MedicalBridge);
//		//Fetch the Plan Amount
//		String oldMedicalBridgeAmount = ViewCoverage_Page.fetchPlanAmount(MedicalBridge);
//		String oldMedicalBridgeAmount1 = oldMedicalBridgeAmount.replace("$","");
//		System.out.println(oldMedicalBridgeAmount1);
//		//Click on the Change Plan button
//		ViewCoverage_Page.ChangeplanbuttonMedicalbridge();
//		//Select the qualifying event
//		change_CA_PR_Page.selectQualifyingEvent();
//		//Enter the effective date
//		change_CA_PR_Page.enterEffectiveDate(ChangePlanRateEffectiveDate);
//		//Click on the plan
//		change_CA_PR_Page.clickPlan();
//		//Enter the new amount
//		change_CA_PR_Page.changePlanMonthlyRate(testdata.get("EditedMonthlyAmount").toString());
//		System.out.println(testdata.get("EditedMonthlyAmount").toString());
//		//Fetch the Plan Amount
//		String NewMedicalBridgeAmount = ViewCoverage_Page.fetchPlanAmount(MedicalBridge);
//		System.out.println("NewMedicalBridgeAmount:- "+NewMedicalBridgeAmount);
//		//Click on the Next button
//		change_CA_PR_Page.clickNext();
//		// Add Payment Profile
//		Payment_Profile.ClickOnPaymentProfileNo();
//		//Click on the Submit button
//		qe_cp_Page.clickSubmit();
//		//Close the Enrollment Summary
//		enrollmentSummaryPage.closeEnrollmentSummary();
//		//Click on Vision Dropdown
//		ViewCoverage_Page.ClickOnPlanDropdown(MedicalBridge);
//		//Fetch the Plan Amount
//		String MedicalBridgeAmount = ViewCoverage_Page.fetchPlanAmount(MedicalBridge);
//		System.out.println("MedicalBridgeAmount:- "+MedicalBridgeAmount);
//		System.out.println(MedicalBridgeAmount);
//		//		 String MedicalBridgeAmount1 = MedicalBridgeAmount.replace("$","");
//		//Click on Employee Details
//		ViewCoverage_Page.ClickOnEmployeeDetails();
//		//Click on Account Summary 
//		employeeInformationPage.clickAccountSummary();
//		//Click on View Transactions
//		accountSummary_Page.ClickOnViewTransactions();
//		//Click on the Search Dropdown
//		accountSummary_Page.ClickOnAdvancedSearchDropdown();
//		//Select the plan 
//		accountSummary_Page.selectPlanFromPlanDropdown(MedicalBridge);	
//		//Plan Verification Credit
//		accountSummary_Page.validateEntries(MedicalBridge, ChangePlanRateEffectiveDate, "Credit",  "Change Plan",  oldMedicalBridgeAmount);
//		//Verify the MedicalBridge Plan
//		accountSummary_Page.validateEntries(MedicalBridge, ChangePlanRateEffectiveDate, "Charge", "Change Plan", NewMedicalBridgeAmount);
//
//		ExtentSuccessMessage("************Change Plan*****************");
//		// Click On Transaction_Details_CloseButton
//		accountSummary_Page.clickClosebutton();
//		// Click Manage Coverage
//		employeeInformationPage.clickManageCoverage();
//		// Click On Plan Dropdown
//		ViewCoverage_Page.ClickOnPlanDropdown(Dental);
//		// Click on Change Plan button Dental
//		ViewCoverage_Page.ChangePlanbuttonDental();
//		// Changes Plan Steps
//		// Select the Qualifying Event
//		change_CA_PR_Page.selectQualifyingEvent();
//		Thread.sleep(5000);
//		// Enter the effective date
//		change_CA_PR_Page.enterEffectiveDate(NewEffectiveDate);
//		// Click on the plan
//		change_CA_PR_Page.clickPlan();
//		// Select the different sub plan
//		qe_cp_Page.selectPlan();
////		String ChangePlanNameamount = ViewCoverage_Page.fetchPlanAmount(Dental);
////		System.out.println("ChangePlanNameamount:= "+ChangePlanNameamount);
//		String ChangedPlanName = ViewCoverage_Page.fetchPlanName(Dental);
//		// Click the Next button
//		change_CA_PR_Page.clickNext();
//		// Click On Payment Profile No
//		Payment_Profile.ClickOnPaymentProfileNo();
//		// Click the Submit button
//		change_CA_PR_Page.clickSubmit();
//
//		ExtentSuccessMessage("************Account Summary Verification**********");
//		// Close the Enrollment Summary
//		enrollmentSummaryPage.closeEnrollmentSummary();
//		// Click On Plan Dropdown
//		ViewCoverage_Page.ClickOnPlanDropdown(Dental);
//		String ChangePlanNameamount = ViewCoverage_Page.fetchPlanAmount(Dental);
//		System.out.println("ChangePlanNameamount:= "+ChangePlanNameamount);
//		// Click On Plan Dropdown
//		ViewCoverage_Page.ClickOnPlanDropdown(Dental);
//		// Click on the Employee Details
//		ViewCoverage_Page.ClickOnEmployeeDetails();
//		// Click on Account Summary
//		employeeInformationPage.clickAccountSummary();
//		// Click on View Transactions
//		accountSummary_Page.ClickOnViewTransactions();
//		// Click on the Search Dropdown
//		accountSummary_Page.ClickOnAdvancedSearchDropdown();
//		// Select the plan
//		accountSummary_Page.selectPlanFromPlanDropdown(ChangedPlanName);
//		// Check Value Present Under Table Row
//		accountSummary_Page.validateEntries(Dental,NewEffectiveDate,"Charge", "Change Plan",ChangePlanNameamount);
//		//		 accountSummary_Page.CheckValuePresentUnderTableRow(Dental,NewEffectiveDate,"Charge","Change Plan",ChangePlanNameamount);

		ExtentSuccessMessage("************Make Current Balance Payment*****************");
		//Click On Transaction_Details_CloseButton
		accountSummary_Page.clickClosebutton();
		//Make Payment
		accountSummary_Page.makepayment();
		// Add Payment Profile
		if (testdata.get("PaymentMethod").toString().equalsIgnoreCase("ACH")) {
			Payment_Profile.addPaymentProfileWithACH(true, "Chase", "021300077", false);
		}
		String Currentbal = accountSummary_Page.getACurrentBalanceBeforePay();
		makePayment.clickonsubmit();
		String cbal="$0.00";
		assertEquals(cbal,accountSummary_Page.getCurrentBalanceAfterPay(),"Current balance is Zero now");
		ExtentSuccessMessage("Current balance is Zero now");
		//Click on View Transactions
		accountSummary_Page.ClickOnViewTransactions();
		// Click on the Search Dropdown
		accountSummary_Page.ClickOnAdvancedSearchDropdown();
		//Select Transaction Type
		accountSummary_Page.transactiontype("Premium Receipts");	
		assertTrue(accountSummary_Page.istypepaymentDisplayed());

		ExtentSuccessMessage("************Payment History*****************");
		//Click On Transaction_Details_CloseButton
		accountSummary_Page.clickClosebutton();
		accountSummary_Page.clickOnPaymentHistory();
		assertEquals(Currentbal,accountSummary_Page.getDepositBalance(),"Current balance and paid amount is same");
		assertTrue(accountSummary_Page.isTransactionTypeDisplayed());
		//click on Vendor Account
		employeeInformationPage.clickonvendoraccount();
		//Check Status displayed
		//accountSummary_Page.checkStatus("Ready to Remit");
		// Click on Account Summary
		employeeInformationPage.clickAccountSummary();

		ExtentSuccessMessage("******************QE Enrollment****************");
		// Click on Manage Coverage
		accountSummary_Page.clickManageCoveragebutton();
		// Click on Dental Plan Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown("Medicare Advantage & Part D");
		// Click on Enroll Button
		ViewCoverage_Page.clickonEnrollBtnUnderDeclinedplans();
		// Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		Thread.sleep(5000);
		// Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(effectivDate);
		// Select the different sub plan
		qe_cp_Page.selectPlan();
		//Fetch Plan Amount
		String MedicarePartDPlanNameamount = ViewCoverage_Page.fetchPlanAmount("Medicare Advantage & Part D");
		//Fetch Plan Name
		String MedicarePartDPlanName = ViewCoverage_Page.fetchPlanName("Medicare Advantage & Part D");
		// Click on the Next button
		qe_cp_Page.clickNext();
		// Click On Payment Profile No
		Payment_Profile.ClickOnPaymentProfileNo();
		// Click on the Submit button
		qe_cp_Page.clickSubmit();

		ExtentSuccessMessage("************Account Summary Verification**********");
		// Close the Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		// Click on the Employee Details
		ViewCoverage_Page.ClickOnEmployeeDetails();
		// Click on Account Summary
		employeeInformationPage.clickAccountSummary();
		// Click on View Transactions
		accountSummary_Page.ClickOnViewTransactions();
		// Click on the Search Dropdown
		accountSummary_Page.ClickOnAdvancedSearchDropdown();
		// Select the plan
		accountSummary_Page.selectPlanFromPlanDropdown(MedicarePartDPlanName);		
		// Validate Entries
		accountSummary_Page.validateEntries("Medicare Advantage & Part D",effectivDate,"Charge", "Group Enrollment",MedicarePartDPlanNameamount);

		ExtentSuccessMessage("************Make Other Amount Payment**********");
		// Click on close
		accountSummary_Page.clickClosebutton();
		//Make Payment
		accountSummary_Page.makepayment();	
		String newbal="$1,000.00";
		//Enter Other Amount
		makePayment.enterOtherAmount(amountString);
		//Payment Comments
		String Paymentcomments = makePayment.paymentcomments();
		//click on Submit
		makePayment.clickonsubmit();
		// Click on View Transactions
		accountSummary_Page.ClickOnViewTransactions();
		// Click on the Search Dropdown
		accountSummary_Page.ClickOnAdvancedSearchDropdown();
		//Select Transaction Type
		accountSummary_Page.transactiontype("Premium Receipts");	
		//Validate Transaction Type
		assertTrue(accountSummary_Page.isTransactionTypeDisplayed());
		//Validate Payment Displayed 
		assertTrue(accountSummary_Page.istypepaymentDisplayed());

		ExtentSuccessMessage("************Payment History*****************");
		//Click On Transaction_Details_CloseButton
		accountSummary_Page.clickClosebutton();
		//Click on Payment History
		accountSummary_Page.clickOnPaymentHistory();
		assertTrue(accountSummary_Page.validateDepositamount(newbal));
		String CBafterpay = accountSummary_Page.getCurrentBalanceAfterPay();
		CBafterpay = CBafterpay.replace("(", "");
		CBafterpay = CBafterpay.replace(")", "");
		assertNotEquals(CBafterpay,newbal,"Current balance and paid amount is not same");
		//Validate Transaction Type
		assertTrue(accountSummary_Page.isTransactionTypeDisplayed());
		//Validate Payment Comments
		accountSummary_Page.iscommentsDisplayed(Paymentcomments);

		ExtentSuccessMessage("************Make Over paid Amount**********");
		String Currentbalanceamount = accountSummary_Page.getCurrentBalanceAfterPay();
		Currentbalanceamount = Currentbalanceamount.replaceAll("[()$,]", "");
		Double cbamount = Double.parseDouble(Currentbalanceamount);
		Double paidamount = cbamount +  amount;
		int opamount = (int) Math.round(paidamount);
		String Overpaidamount = String.valueOf(opamount);
		System.out.println("Overpaidamount:- "+Overpaidamount);
		//Make Payment
		accountSummary_Page.makepayment();	
		//Enter Other Amount
		makePayment.enterOtherAmount(Overpaidamount);
		//Payment Comments
		makePayment.paymentcomments();
		//click on Submit
		makePayment.clickonsubmit();
		accountSummary_Page.currentBalanceValidation();
		// Click on View Transactions
		accountSummary_Page.ClickOnViewTransactions();
		// Click on the Search Dropdown
		accountSummary_Page.ClickOnAdvancedSearchDropdown();
		//Select Transaction Type
		accountSummary_Page.transactiontype("Premium Receipts");	
		//Validate Transaction Type
		assertTrue(accountSummary_Page.isTransactionTypeDisplayed());
		//Validate Payment Displayed 
		assertTrue(accountSummary_Page.istypepaymentDisplayed());

		ExtentSuccessMessage("************Payment History*****************");
		//Click On Transaction_Details_CloseButton
		accountSummary_Page.clickClosebutton();
		//Click on Payment History
		accountSummary_Page.clickOnPaymentHistory();
		NumberFormat obj = NumberFormat.getCurrencyInstance(Locale.US);
		String currency=obj.format(opamount);
		assertTrue(accountSummary_Page.validateDepositamount(currency));
		System.out.println("opamount:- "+opamount);
		System.out.println("currency:- "+currency);
		//Validate Transaction Type
		assertTrue(accountSummary_Page.isTransactionTypeDisplayed());
		//Validate Payment Comments
		accountSummary_Page.iscommentsDisplayed(Paymentcomments);
		System.out.println("Paymentcomments:- "+Paymentcomments);

		ExtentSuccessMessage("********Cash Ledger check**********");
		//click Home Page	
		Home_Page.clickHomePage();
		// Navigate To Cash_Ledger Tab
		Home_Page.NavigateToCash_LedgerTab();
		// Click On Advance Search
		Cash_Ledger_Page.ClickOnAdvanceSearch();
		// Select Transaction Type Dropdown
		Cash_Ledger_Page.SelectTransactionTypeDropdown("Premium Receipts");
		// Enter Customer Number
		Cash_Ledger_Page.EnterCustomerNumber(CustomerNo);
		// Enter Deposit_Amount
		Cash_Ledger_Page.EnterDeposit_Amount(Overpaidamount);
		//Click On Search Button
		Cash_Ledger_Page.clickOnSearchButton();
		//Validate Transaction Type
		assertTrue(accountSummary_Page.isTransactionTypeDisplayed());
		//Validate Payment Comments
		assertTrue(	accountSummary_Page.iscommentsDisplayed(Paymentcomments));
		// validate Deposit amount
		assertTrue(accountSummary_Page.validateDepositamount(currency));

		ExtentSuccessMessage("******Refund Center********");
		//click Home Page
		Home_Page.clickHomePage();
		//Navigate To Refund_Center Tab
		Home_Page.NavigateToRefund_CenterTab();
		//Select All Refund Status
		Refund_Center_Page.SelectAllRefundStatus();
		// Enter Customer Number
		Refund_Center_Page.EnterCustomerNumber(CustomerNo);
		//Click On Advance Search
		Refund_Center_Page.ClickOnAdvanceSearch();
		// click On Search Button
		Refund_Center_Page.clickOnSearchButton();
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		Thread.sleep(8000);
		//Click On First Tick Mark Icon
		Refund_Center_Page.ClickOnFirstTickMarkIcon();
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		// click On Yes Button
		Refund_Center_Page.clickOnYesButton();
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		// click On Ok Button
		Refund_Center_Page.clickOnOkButton();


		ExtentSuccessMessage("******Refund Center--Manual Approval Process******** ");
		// click On Add Button
		Refund_Center_Page.clickOnAddButton();
		// Enter Customer No
		Refund_Center_Page.EnterCustomerNo(CustomerNo);
		// Click On Search Payee Name Button
		Refund_Center_Page.clickOnSearchPayeeNameButton();
		WaitForLoadAnimationDisappear();
		// Select Employee Radio Button
		Refund_Center_Page.SelectEmployeeRadioButton(CustomerNo);
		WaitForLoadAnimationDisappear();
		String ManualRefundAmount ="50.00";
		// Enter Refund Amount
		Refund_Center_Page.EnterRefundAmount(ManualRefundAmount);
		WaitForLoadAnimationDisappear();
		// click On Approve Button
		Refund_Center_Page.clickOnApproveButton();
		WaitForLoadAnimationDisappear();
		// click On Ok Confirm Button
		Refund_Center_Page.clickOnOkConfirmButton();
		WaitForLoadAnimationDisappear();
		// click On Ok Button
		Refund_Center_Page.clickOnOkButton();
		RefreshPage();
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		// Select Refund Status
		Refund_Center_Page.SelectRefundStatus("approved");
		// Enter Customer Number
		Refund_Center_Page.EnterCustomerNumber(CustomerNo);
		// click On Search Button
		Refund_Center_Page.clickOnSearchResultButton();
		WaitForLoadAnimationDisappear();
		//		NumberFormat obj1 = NumberFormat.getCurrencyInstance(Locale.US);
		//		String ManualRefundAmounts=obj1.format(ManualRefundAmount);
		// Validate Refund Amount
		assertTrue(Refund_Center_Page.ValidateRefundAmount("$"+ManualRefundAmount));
		// Validate Refund Status
		assertTrue(Refund_Center_Page.ValidateRefundStatus("Approved"));
		String PayeeName= Refund_Center_Page.GetPayeeName();


		ExtentSuccessMessage("*****Accounts Payable*******");
		//click Home Page
		Home_Page.clickHomePage();
		// Navigate To Accounts_Payable Tab
		Home_Page.NavigateToAccounts_PayableTab();
		WaitForLoadAnimationDisappear();
		// Click On Advance Search
		Accounts_Payable_Page.ClickOnAdvanceSearch();
		WaitForLoadAnimationDisappear();
		// Enter Payee Name
		Accounts_Payable_Page.EnterPayeeName(PayeeName);
		WaitForLoadAnimationDisappear();
		// Select Transaction Type
		Accounts_Payable_Page.SelectTransactionType("refund");
		WaitForLoadAnimationDisappear();
		// click On Search Button
		Accounts_Payable_Page.clickOnSearchButton();
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		// Validate Refund Amount
		assertTrue(Accounts_Payable_Page.ValidateAmount("$"+ManualRefundAmount));
		//click Home Page
		Home_Page.clickHomePage();
		// Select Group
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// search And Navigate To Employee Info
		employeeAdministration.searchAndNavigateToEmployeeInfo(CustomerNo);
		// Click on Account Summary
		employeeInformationPage.clickAccountSummary();
		// Click on View Transactions
		accountSummary_Page.ClickOnViewTransactions();

		ExtentSuccessMessage("************Void Payment**********");
		accountSummary_Page.clickClosebutton();
		//Click on Payment Profiles
		accountSummary_Page.clickOnPaymentHistory();
		//Get the Current Balance
		//String CheckNumber = accountSummary_Page.getCheckNumber();
		//Click on Void under Action
		accountSummary_Page.clickVoid();
		//Click on OK in Confirmation Popup
		accountSummary_Page.clickOKConfirmation();
		Thread.sleep(1000);
		//Click on OK in Success Popup
		accountSummary_Page.clickOKSuccess();
		
		//Click on Home Button
		Home_Page.clickHomePage();
		//Click on BillingPayment Tab
		Home_Page.ClickOnBillingAndPayments();
		//Click on Accounts Receivable
		Home_Page.clickAccountsReceivable();
		//Click on the Advanced Search Dropdown
		accountsReceivable_Page.ClickOnAdvancedSearchDropdown();
		//Select the Void Transaction Type
		accountsReceivable_Page.selectTransactionFromDropdown("Void");
		RefreshPage();
		RefreshPage();
		//Click on the latest Void payment Record
		accountsReceivable_Page.ClickLatestRecord();
		//Validate if record with Void and Ready to Post is displayed or not. 
		accountsReceivable_Page.voidValidation(FullName, ssn);


		ExtentSuccessMessage("************Terminate Employee**********");
		// Click on Home Button
		Home_Page.clickHomePage();
		// Search for the group.
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Search for the employee
		employeeAdministration.searchAndNavigateToEmployeeInfo(CustomerNo);
		// Click Terminate
		employeeInformationPage.clickTerminate();
		// Terminate Employee
		terminateEmployeePage.terminateEmployee(EmployeeTerminationDate);
		// Employee Termination Message Displayed
		terminateEmployeePage.isEmployeeTerminationMessageDisplayed();
		// close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		// Click Employee Details
		ViewCoverage_Page.ClickOnEmployeeDetails();
		// Click on Account Summary
		employeeInformationPage.clickAccountSummary();
		// Click on View Transactions
		accountSummary_Page.ClickOnViewTransactions();
		// Click on the Search Dropdown
		accountSummary_Page.ClickOnAdvancedSearchDropdown();
		// Select the plan
		accountSummary_Page.selectCategoryFromDropdown(Dental);
		//Select Transaction Type
		accountSummary_Page.transactiontype("Charge");	
		// Verify the Dental Plan
		ExtentSuccessMessage("---Dental Credits--");
		accountSummary_Page.EmployeeTerminationVerification(Dental, EmployeeTerminationDate);
		// Select the Medical Plan
		accountSummary_Page.selectCategoryFromDropdown(Medical);
		// Verify the Dental Plan
		ExtentSuccessMessage("---Medical Credits--");
		accountSummary_Page.EmployeeTerminationVerification(Medical, EmployeeTerminationDate);
		// Select the Medical Plan
		accountSummary_Page.selectCategoryFromDropdown(MedicalBridge);
		// Verify the Dental Plan
		ExtentSuccessMessage("---MedicalBridge Credits--");
		accountSummary_Page.EmployeeTerminationVerification(MedicalBridge, EmployeeTerminationDate);
		// Select the Medical Plan
		accountSummary_Page.selectCategoryFromDropdown(TermLife);
		// Verify the Dental Plan
		ExtentSuccessMessage("---Term Life Credits--");
		accountSummary_Page.EmployeeTerminationVerification(TermLife, EmployeeTerminationDate);
		// Click on Close
		accountSummary_Page.clickClosebutton();
		// Click on Employee Details
		accountSummary_Page.clickEmployeeDetailsbutton();

		ExtentSuccessMessage("************ReInstate Employee**********");
		employeeInformationPage.clickReinstate();
		// click Restore
		//click Restore
		employeeReinstatePage.restore();
	//	employeeReinstatePage.isRestoreSuccessfulMessageDisplayed();
		Assert.assertTrue(employeeReinstatePage.isRestoreSuccessfulMessageDisplayed());
		// Click Employee Details
		//	ViewCoverage_Page.ClickOnEmployeeDetails();
		// Click on Account Summary
		employeeInformationPage.clickAccountSummary();
		// Click on View Transactions
		accountSummary_Page.ClickOnViewTransactions();
		// Click on the Search Dropdown
		accountSummary_Page.ClickOnAdvancedSearchDropdown();
		// Select the Dental plan
		accountSummary_Page.selectCategoryFromDropdown(Dental);
		// Verify the Dental Plan
		ExtentSuccessMessage("---Dental Charges--");
		accountSummary_Page.EmployeeReinstateVerification(Dental, EmployeeTerminationDate);
		// Select the Medical Plan
		accountSummary_Page.selectCategoryFromDropdown(Medical);
		// Verify the Dental Plan
		ExtentSuccessMessage("---Medical Charges--");
		accountSummary_Page.EmployeeReinstateVerification(Medical, EmployeeTerminationDate);
		// Select the Medical Plan
		accountSummary_Page.selectCategoryFromDropdown(MedicalBridge);
		// Verify the Dental Plan
		ExtentSuccessMessage("---MedicalBridge Charges--");
		accountSummary_Page.EmployeeReinstateVerification(MedicalBridge, EmployeeTerminationDate);
		// Select the MedicalBridge Plan
		accountSummary_Page.selectCategoryFromDropdown(TermLife);
		// Verify the Term Life Plan
		ExtentSuccessMessage("---Term Life Charges--");
		accountSummary_Page.EmployeeReinstateVerification(TermLife, EmployeeTerminationDate);
	}
}
