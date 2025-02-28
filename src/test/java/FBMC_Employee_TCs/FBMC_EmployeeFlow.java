package FBMC_Employee_TCs;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import Pages.CascadingMembership_Page;
import Pages.ChangeCoverageAmount_PlanRate_Page;
import Pages.CreateYourAccount;
import Pages.EditEmployee_Page;
import Pages.EmailLogs;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Login_Page;
import Pages.Payment_Profile;
import Pages.QEEnrollment_ChangePlan_Page;
import Pages.SummaryVerification_Page;
import Pages.UpdateCoveredMembers_Page;
import Pages.ViewCoverage_Page;

public class FBMC_EmployeeFlow extends FBMC_Employee_AllScenarios
{

	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
    SummaryVerification_Page viewSummary=new SummaryVerification_Page();
    UpdateCoveredMembers_Page updateCoveredMembers= new UpdateCoveredMembers_Page();
	CascadingMembership_Page cascadeScenario = new CascadingMembership_Page();
    EditEmployee_Page editEmployee= new EditEmployee_Page();
    ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
    QEEnrollment_ChangePlan_Page qe_cp_Page = new QEEnrollment_ChangePlan_Page();
    ChangeCoverageAmount_PlanRate_Page change_CA_PR_Page = new ChangeCoverageAmount_PlanRate_Page();
	Payment_Profile Payment_Profile = new Payment_Profile();
	EmailLogs emaillog = new EmailLogs();
	CreateYourAccount CreateYourAccount = new CreateYourAccount();
	Login_Page Login_Page = new Login_Page();
	
    //FBMC Enrolled Employee
    public void FBMC_Employee_flows(String TestScenario,String GroupName,Map<Object, Object> testdata,String EmailId,String Password,String SecurityQuestion1,String SecurityAnswer1,String SecurityQuestion2,String SecurityAnswer2,String SecurityQuestion3,String SecurityAnswer3) throws InterruptedException, AWTException, IOException
	{  
    	    	
    	// Select Group
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
		String result = employeePage.addPersonalInformation(testdata);
		String[] values = result.split(",");	
		String firstname = values[1];
		String lastname = values[2];
		String fullname = firstname+" "+lastname;
		// Add Dependent
		employeePage.addDependent(testdata);
		// Activate And Enroll
		employeePage.activateAndEnroll();
		// Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		Thread.sleep(15000);
		// Select Plans
		enrollmentPage.selectPlans(false);
		// addAdditionalInsurance
		enrollmentPage.addAdditionalInsurance(false, testdata);
		// Click Next btn
		enrollmentPage.clickNext();
		// Add Payment Profile
		if (testdata.get("PaymentMethod").toString().equalsIgnoreCase("ACH")) {
			Payment_Profile.addProfileWithACH(true, "Chase", "021300077", false);
		} else {
			Payment_Profile.addProfileWithPensionAuthority(true);
		}
		// submit Enrollment
		enrollmentPage.submitEnrollment();
        String oldCoveredMember=updateCoveredMembers.VerifyNewMemberNameAdd(updateCoveredMembers.newname);
		//Close the Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		// Click on Employee Details
		ViewCoverage_Page.ClickOnEmployeeDetails();
		//click Edit button
		employeeInformationPage.clickEdit();
    	//Enter Email
		editEmployee.editMail(testdata);
		//click Submit Button
		cascadeScenario.clickSubmit();
	    //Navigate To Group Dashboard
		WaitForLoadAnimationDisappear();
        Group_Page.navigateToGroupDashboard();
		//Click EmployeeAdministration
		Group_Page.clickEmployeeAdministration();
		//Search And Navigate To EmployeeInfo
		employeeAdministration.searchEmployee(fullname);
		//Click CheckBox
		employeeAdministration.checkbox();
		//Request Online Access
		employeeAdministration.requestOnlineAccess();
		//Click Home Icon
		Home_Page.clickHomePage();
		//Click Communication Tab
		Home_Page.clickCommunicationTab();
		//Click on EmailLog
		Home_Page.ClickOnEmailLog();
		Thread.sleep(8000);
		RefreshPage();
		Thread.sleep(13000);
		WaitForPageLoad();
		//Search with Name
		emaillog.EnterFirstNameEmailLogEnterSearchField(fullname);
		//Click on Search Icon
		emaillog.ClickOnEmailLogSearchIcon();
		//Click on View Icon
		emaillog.ClickOnViewIcon();
		//Click on Registration Link
		emaillog.ClickOnRegistrationLink();
		/////*****Register Check*****/////
		//Enter the User Name
		String UserName = firstname+"_UserEmp";
		CreateYourAccount.EnterCreateUserName(UserName);
		System.out.println("User Name"+UserName);
		//Enter the Password
		CreateYourAccount.EnterCreatePassworde(Password);
		//Enter the Confirm Password
		CreateYourAccount.EnterCreateConfirmPassworde(Password);
		CreateYourAccount.EnterSecurityQuestion1(SecurityQuestion1);
		CreateYourAccount.EnterSecurityAnswer1(SecurityAnswer1);
		CreateYourAccount.EnterSecurityQuestion2(SecurityQuestion2);
		CreateYourAccount.EnterSecurityAnswer2(SecurityAnswer2);
		CreateYourAccount.EnterSecurityQuestion3(SecurityQuestion3);
		CreateYourAccount.EnterSecurityAnswer3(SecurityAnswer3);
		CreateYourAccount.ClickOnPriPolicyAndTermsConCheckBox();
		CreateYourAccount.ClickOnIAcceptButton();
		CreateYourAccount.ClickOnCreateUserRegistrationButton();
		CreateYourAccount.ValidateSuccessMessage();
		CreateYourAccount.ClickOnClickHereToLoginLink();
		Login_Page.EnterUserNameField(UserName);
		System.out.println("Enter User Name" + UserName);
		Login_Page.EnterPasswordField(Password);
		System.out.println("Enter Password Name" + Password);
		Login_Page.ClickOnLoginButton();
		  	
		// Click on My Coverage
        Group_Page.clickMyCoverage();;
        ExtentSuccessMessage("**********Summary Verification**********");
        //Enrollment Summary Verification
		viewSummary.clickViewSummary();
		assertEquals(GetFilesCountInDownloadDirectory(), 1);
		ExtentSuccessMessage("Successfully Verified Enrollment Summary"); 
		
		ExtentSuccessMessage("**********Cascade Scenario**********");
		//click profile
		ViewCoverage_Page.click_profile();
		//click Edit 
		employeeInformationPage.clickEdit();
		//Edit Employee Details
		editEmployee.enterNewAddress(testdata);
		editEmployee.scrollTillDependents();
		//Add Dependent
		editEmployee.addDependent(testdata);
		Thread.sleep(8000);
		//click Submit
		cascadeScenario.clickSubmit();
		Thread.sleep(5000);
		//click Yes CoverageRates
		editEmployee.clickYesCoverageRates();
		Thread.sleep(8000);
		WaitForPageLoad();
//		Boolean Flag =editEmployee.MessageErrorChangevisible();
//		if(Flag = true) {
//			editEmployee.ErrorOkButton();
//			WaitForPageLoad();
//			editEmployee.clickAddDependentToCoverage();	
//		}
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
		enrollmentSummaryPage.downloadSummaryDocument();	
		enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("Successfully Added Cascade Scenario");
      	
		ExtentSuccessMessage("**********Update Covered Member - Start**********");
		//Update Covered Member Medical Add a Dependent
		//Click Medical Plan
		ViewCoverage_Page.ClickOnMedicalDropdown();
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
		String addedCoveredMember=updateCoveredMembers.VerifyNewMemberNameAdd(updateCoveredMembers.newname);
		Assert.assertNotEquals(oldCoveredMember,addedCoveredMember, "Assertion Passed");
		enrollmentSummaryPage.downloadSummaryDocument();
		enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("Successfully updated the CoveredMember Medical (Added Child Dependant)");
		
		//Update Covered Member Medical Remove a Dependent	
		//Click Medical Plan
		ViewCoverage_Page.ClickOnMedicalDropdown();
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
		//Submit Enrollment
		updateCoveredMembers.clickSubmit();	
		String removedCoveredMember=updateCoveredMembers.VerifyNewMemberNameRemove(updateCoveredMembers.newname);
		Assert.assertNotEquals(addedCoveredMember,removedCoveredMember, "Assertion Passed");
		enrollmentSummaryPage.downloadSummaryDocument();
		enrollmentSummaryPage.closeEnrollmentSummary();     
		ExtentSuccessMessage("Successfully updated the CoveredMember Medical (Removed Child Dependant)");
		
		//Update Covered Member Ancillary Add a Dependent
		//Click Dental Plan
		ViewCoverage_Page.ClickOnDentalDropdown();;
		//Click UpdateCoveredMembers
		ViewCoverage_Page.ClickDentalUpdateCoveredMembers();
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
		//Submit Enrollment
		updateCoveredMembers.clickSubmit();
		enrollmentSummaryPage.downloadSummaryDocument();
		enrollmentSummaryPage.closeEnrollmentSummary();        
		ExtentSuccessMessage("Successfully updated the CoveredMember Ancillary (Added Child Dependant)");
		
		//Update Covered Member Ancillary Remove a Dependent
		//Click Dental Plan
		ViewCoverage_Page.ClickOnDentalDropdown();;
		//Click UpdateCoveredMembers
		ViewCoverage_Page.ClickDentalUpdateCoveredMembers();
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
		//Submit Enrollment
		updateCoveredMembers.clickSubmit();
		enrollmentSummaryPage.downloadSummaryDocument();
		enrollmentSummaryPage.closeEnrollmentSummary();      
		ExtentSuccessMessage("Successfully updated the CoveredMember Ancillary (Removed Child Dependant)");		
		ExtentSuccessMessage("**********Update Covered Member - End**********");
		
		ExtentSuccessMessage("**********Change Plan - Start**********");
        //Change Plan Medical
		ViewCoverage_Page.ClickOnMedicalDropdown();
		//Click on the Change Plan Button
		ViewCoverage_Page.ChangeplanbuttonMedical();
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		//Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		//Click on the Respective Plan
		qe_cp_Page.clickPlan();
		//Select the different sub plan
		qe_cp_Page.selectPlan();
		//Click on the Next button
		qe_cp_Page.clickNext();
		//Click on the Submit button
		qe_cp_Page.clickSubmit();
		//Verify the changes made
		Assert.assertNotEquals(
				enrollmentSummaryPage.VerifyoldPlanName(enrollmentSummaryPage.oldPlanname), 
				enrollmentSummaryPage.VerifynewPlanName(enrollmentSummaryPage.newPlanname),
				"Assertion Passed");
		enrollmentSummaryPage.downloadSummaryDocument();
		enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("Successfully Changed Medical Plan");
         
        //Change Plan Ancillary
		//Click on the Dental Dropdown
		ViewCoverage_Page.ClickOnDentalDropdown();
		//Click on Change Plan button
		ViewCoverage_Page.ChangePlanbuttonDental();
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		//Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		//Click on the Respective Plan
		qe_cp_Page.clickPlan();
		//Select the different sub plan
		qe_cp_Page.selectPlan();
		//Click on the Next button
		qe_cp_Page.clickNext();
		//Click on the Submit button
		qe_cp_Page.clickSubmit();
      	enrollmentSummaryPage.downloadSummaryDocument();	
        enrollmentSummaryPage.closeEnrollmentSummary();      
        ExtentSuccessMessage("Successfully Changed Ancillary Plan");
        ExtentSuccessMessage("**********Change Plan - End**********");
        
        ExtentSuccessMessage("**********Terminate Plan - Start**********");
		//Terminate Medical Plan
      	ViewCoverage_Page.ClickOnMedicalDropdown();
      	ViewCoverage_Page.ClickonTerminateMedicalButton();
      	ViewCoverage_Page.Terminateplan(testdata);		
		//Verify the Termination Date
		Assert.assertEquals(
				enrollmentSummaryPage.checkTerminationDate(testdata), 
				enrollmentSummaryPage.VerifyTerminationDate(enrollmentSummaryPage.date),
				"Assertion Passed");	
      	enrollmentSummaryPage.downloadSummaryDocument();	
		enrollmentSummaryPage.closeEnrollmentSummary();        
		ExtentSuccessMessage("Successfully Terminated Medical Plan");
		
		//Terminate Ancillary Plan
		ViewCoverage_Page.ClickOnDentalDropdown();
		//Click on Terminate Dental Button
		ViewCoverage_Page.ClickonTerminateDentalButton();
		ViewCoverage_Page.Terminateplan(testdata);
		enrollmentSummaryPage.downloadSummaryDocument();
		enrollmentSummaryPage.closeEnrollmentSummary();        
		ExtentSuccessMessage("Successfully Terminated Ancillary Plan");
		ExtentSuccessMessage("**********Terminate Plan - End**********");
			
		ExtentSuccessMessage("**********ReEnroll Plan - Start**********");
        //ReEnroll Medical PLan
		ViewCoverage_Page.ClickOnMedicalDropdown();
		// reEnrollMedical.EnrollMedicalPlan();
		ViewCoverage_Page.clickEnrollMedicalinPlan();
		qe_cp_Page.selectQualifyingEvent();
		// Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		// Select the different sub plan
		qe_cp_Page.selectPlan();
		// Click on the Next button
		qe_cp_Page.clickNext();
		// Click on the Submit button
		qe_cp_Page.clickSubmit();
		// Verify the Enrollment Date
		Assert.assertEquals(
				enrollmentSummaryPage.checkEnrollmentDate(testdata),
				enrollmentSummaryPage.VerifyEnrollmentDate(enrollmentSummaryPage.date), 
				"Assertion Passed");
		enrollmentSummaryPage.downloadSummaryDocument();
		enrollmentSummaryPage.closeEnrollmentSummary();   
		ExtentSuccessMessage("Successfully ReEnrolled Medical PLan");
		
		//ReEnroll Ancillary Plan
		//Click on Dental Dropdown
		ViewCoverage_Page.ClickOnDentalDropdown();
		//Click on the Enroll button
		ViewCoverage_Page.clickEnrollDentalinPlan();
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		//Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		//Select the different sub plan
		qe_cp_Page.selectPlan();
		//Click on the Next button
		qe_cp_Page.clickNext();
		//Click on the Submit button
		qe_cp_Page.clickSubmit();
		enrollmentSummaryPage.downloadSummaryDocument();	
		enrollmentSummaryPage.closeEnrollmentSummary(); 
		ExtentSuccessMessage("Successfully ReEnrolled Ancillary Plan");
		ExtentSuccessMessage("**********ReEnroll Plan - End**********");
		
		ExtentSuccessMessage("**********QE Enrollment - Start**********");
		//Terminate Medical Plan
		ViewCoverage_Page.ClickOnMedicalDropdown();
		ViewCoverage_Page.ClickonTerminateMedicalButton();
		ViewCoverage_Page.TerminateplanonQE(testdata);		
		enrollmentSummaryPage.downloadSummaryDocument();	
		enrollmentSummaryPage.closeEnrollmentSummary();        
		ExtentSuccessMessage("Successfully Terminated Medical Plan");
		
		//QE Medical Plan
		//Click on the Medical Dropdown and Enroll Button
		ViewCoverage_Page.ClickOnDeclinedPlanDropdownEnroll("Medical");
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		//Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		//Select the different sub plan
		qe_cp_Page.selectPlan();
		//Click on the Next button
		qe_cp_Page.clickNext();
		//Click on the Submit button
		qe_cp_Page.clickSubmit();
		enrollmentSummaryPage.downloadSummaryDocument();		
		enrollmentSummaryPage.closeEnrollmentSummary();   
		ExtentSuccessMessage("Successfully Enrolled QE on Medical");
		
		//Terminate Ancillary Plan
		ViewCoverage_Page.ClickOnDentalDropdown();
		//Click on Terminate Dental Button
		ViewCoverage_Page.ClickonTerminateDentalButton();
		ViewCoverage_Page.TerminateplanonQE(testdata);
		enrollmentSummaryPage.downloadSummaryDocument();
		enrollmentSummaryPage.closeEnrollmentSummary();        
		ExtentSuccessMessage("Successfully Terminated Ancillary Plan");
		
		//QE Ancillary Plan
		//Click on the Medical Dropdown and Enroll Button
		ViewCoverage_Page.ClickOnDeclinedPlanDropdownEnroll("Dental");
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		//Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		//Select the different sub plan
		qe_cp_Page.selectPlan();
		//Click on the Next button
		qe_cp_Page.clickNext();
		//Click on the Submit button
		qe_cp_Page.clickSubmit();
		enrollmentSummaryPage.downloadSummaryDocument();
		enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("Successfully Enrolled QE on Ancillay");
		ExtentSuccessMessage("**********QE Enrollment - End**********");

	}
}
