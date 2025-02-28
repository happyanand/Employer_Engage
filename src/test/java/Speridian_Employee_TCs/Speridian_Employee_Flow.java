package Speridian_Employee_TCs;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import Pages.CascadingMembership_Page;
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
import Pages.QEEnrollment_ChangePlan_Page;
import Pages.SummaryVerification_Page;
import Pages.UpdateCoveredMembers_Page;
import Pages.ViewCoverage_Page;

public class Speridian_Employee_Flow extends Speridian_Employee_AllScenarios
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
	Login_Page Login_Page = new Login_Page();
	EmailLogs emaillog = new EmailLogs();
	CreateYourAccount CreateYourAccount = new CreateYourAccount();
	
    //Speridian Employee Flow
    public void Speridian_Employee_flows(String TestScenario,String GroupName,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException
	{       
  	
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
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		// Select Speridian Plans
		enrollmentPage.selectSperidianPlans(false);
		// Add Additional Insurance
		enrollmentPage.addAdditionalInsurance(false, testdata);
		// Submit Enrollment
		enrollmentPage.submitEnrollment();
		String oldCoveredMember=updateCoveredMembers.VerifyNewMemberNameAdd(updateCoveredMembers.newname);
		// Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		// Click on Employee Details
		ViewCoverage_Page.ClickOnEmployeeDetails();
		
		//Click on Edit
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
		WaitForLoadAnimationDisappear();
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
		String UserName = firstname+"_Emp";
		CreateYourAccount.EnterCreateUserName(UserName);
		System.out.println("User Name"+UserName);
		//Enter the Password
		CreateYourAccount.EnterCreatePassworde(testdata.get("Password").toString());
		//Enter the Confirm Password
		CreateYourAccount.EnterCreateConfirmPassworde(testdata.get("Password").toString());
		//Click on the Policy And Terms CheckBox
		CreateYourAccount.ClickOnPriPolicyAndTermsConCheckBox();
		//Click on the I Accept Button
		CreateYourAccount.ClickOnIAcceptButton();
		//Click on the Create User Registration button
		CreateYourAccount.ClickOnCreateUserRegistrationButton();
		//Click on Login Link
		CreateYourAccount.ClickOnClickHereToLoginLink();
		//Enter User name
		Login_Page.EnterUserNameField(UserName);
		System.out.println("Enter User Name" + UserName);
		//Enter Password
		Login_Page.EnterPasswordField(testdata.get("Password").toString());
		System.out.println("Enter Password Name" + testdata.get("Password").toString());
		//Click on Login Button
		Login_Page.ClickOnLoginButton();
    	     
		ExtentSuccessMessage("**********Summary Verification**********");
    	// Click on My Coverage
    	Group_Page.clickMyCoverage();
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
		//click Submit
		cascadeScenario.clickSubmit();
		WaitForPageLoad();
		//click Demographics Yes 
		editEmployee.clickDemographicsYes();
		//click Yes CoverageRates
		editEmployee.clickYesCoverageRates();
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
		ViewCoverage_Page.ClickOnPlanDropdown("Medical");
		//click Child
		cascadeScenario.clickChild();
		WaitForPageLoad();
		//click Cascade Next button
		cascadeScenario.clickNext();
		//Submit Enrollment
		enrollmentPage.submitEnrollment();
		enrollmentSummaryPage.downloadSummaryDocument();	
		ExtentSuccessMessage("Successfully Added Cascade Scenario");
		
		//Logout Employee User
		Group_Page.Logout1();
		//Enter the BA Username
		Login_Page.EnterUserNameField(configloader().getProperty("SperidianBA_UserName"));
		//Enter the BA Password
		Login_Page.EnterPasswordField(configloader().getProperty("SperidianBA_Password"));
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.ReviewEmployeeTransactions(fullname);
		Group_Page.Logout1();
		//Enter the Employee Username
		Login_Page.EnterUserNameField(UserName);
		//Enter the Employee Password
		Login_Page.EnterPasswordField(testdata.get("Password").toString());
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.clickMyCoverage();
		
		ExtentSuccessMessage("**********Update Covered Member - Start**********");
      	//Update Covered Member Medical Add a Dependent
		//Click Medical Plan
		ViewCoverage_Page.ClickOnPlanDropdown("Medical");
		//Click UpdateCoveredMembers
		ViewCoverage_Page.ClickUpdateCoveredMembersMedical();
		//Select ActionTypeADD
		updateCoveredMembers.ActionTypeADD();
		//Select QualifyingEvent
		updateCoveredMembers.clickQualifyingEvent();
		//Enter EffectiveDate
		updateCoveredMembers.clickEffectiveDate(testdata);
		//Add Covered Member
		ViewCoverage_Page.ClickOnPlanDropdown("Medical");
		//Select the Covered Member
		updateCoveredMembers.selectCoveredMember();
		//Submit Enrollment
		updateCoveredMembers.clickSubmit();
		String addedCoveredMember=updateCoveredMembers.VerifyNewMemberNameAdd(updateCoveredMembers.newname);
		Assert.assertNotEquals(oldCoveredMember,addedCoveredMember, "Assertion Passed");
		enrollmentSummaryPage.downloadSummaryDocument();
		ExtentSuccessMessage("Successfully updated the CoveredMember Medical (Added Child Dependant)");
		
		Group_Page.Logout1();
		//Enter the BA Username
		Login_Page.EnterUserNameField(configloader().getProperty("SperidianBA_UserName"));
		//Enter the BA Password
		Login_Page.EnterPasswordField(configloader().getProperty("SperidianBA_Password"));
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.ReviewEmployeeTransactions(fullname);
		Group_Page.Logout1();
		//Enter the Employee Username
		Login_Page.EnterUserNameField(UserName);
		//Enter the Employee Password
		Login_Page.EnterPasswordField(testdata.get("Password").toString());
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.clickMyCoverage();
        
        //Update Covered Member Medical Remove a Dependent	
		//Click Medical Plan
		ViewCoverage_Page.ClickOnPlanDropdown("Medical");
		//Click UpdateCoveredMembers
		ViewCoverage_Page.ClickUpdateCoveredMembersMedical();
		//Select ActionTypeRemove
		updateCoveredMembers.ActionTypeRemove();
		//Select QualifyingEvent
		updateCoveredMembers.clickQualifyingEvent();
		//Enter TerminationDate
		updateCoveredMembers.clickTerminationDate(testdata);
		//Remove Covered Member
		ViewCoverage_Page.ClickOnPlanDropdown("Medical");
		//Select the Covered Member
		updateCoveredMembers.selectCoveredMember();
		//Click Confirmation OK
		updateCoveredMembers.clickConfirmationOK();
		//Submit Enrollment
		updateCoveredMembers.clickSubmit();
		String removedCoveredMember=updateCoveredMembers.VerifyNewMemberNameRemove(updateCoveredMembers.newname);
		Assert.assertNotEquals(addedCoveredMember,removedCoveredMember, "Assertion Passed");
		enrollmentSummaryPage.downloadSummaryDocument();
		ExtentSuccessMessage("Successfully updated the CoveredMember Medical (Removed Child Dependant)");      
        
		Group_Page.Logout1();
		//Enter the BA Username
		Login_Page.EnterUserNameField(configloader().getProperty("SperidianBA_UserName"));
		//Enter the BA Password
		Login_Page.EnterPasswordField(configloader().getProperty("SperidianBA_Password"));
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.ReviewEmployeeTransactions(fullname);
		Group_Page.Logout1();
		//Enter the Employee Username
		Login_Page.EnterUserNameField(UserName);
		//Enter the Employee Password
		Login_Page.EnterPasswordField(testdata.get("Password").toString());
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.clickMyCoverage();
		
        //Update Covered Member Ancillary Add a Dependent
		//Click Dental Plan
		ViewCoverage_Page.ClickOnPlanDropdown("Dental");
		//Click UpdateCoveredMembers
		ViewCoverage_Page.ClickDentalUpdateCoveredMembers();
		//Select ActionTypeADD
		updateCoveredMembers.ActionTypeADD();
		//Select QualifyingEvent
		updateCoveredMembers.clickQualifyingEvent();
		//Enter EffectiveDate
		updateCoveredMembers.clickEffectiveDate(testdata);
		//Add Covered Member
		ViewCoverage_Page.ClickOnPlanDropdown("Dental");
		//Select the Covered Member
		updateCoveredMembers.selectCoveredMember();
		//Submit Enrollment
		updateCoveredMembers.clickSubmit();
		enrollmentSummaryPage.downloadSummaryDocument();
		ExtentSuccessMessage("Successfully updated the CoveredMember Ancillary (Added Child Dependant)"); 
		
		Group_Page.Logout1();
		//Enter the BA Username
		Login_Page.EnterUserNameField(configloader().getProperty("SperidianBA_UserName"));
		//Enter the BA Password
		Login_Page.EnterPasswordField(configloader().getProperty("SperidianBA_Password"));
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.ReviewEmployeeTransactions(fullname);
		Group_Page.Logout1();
		//Enter the Employee Username
		Login_Page.EnterUserNameField(UserName);
		//Enter the Employee Password
		Login_Page.EnterPasswordField(testdata.get("Password").toString());
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.clickMyCoverage();
		
        //Update Covered Member Ancillary Remove a Dependent
		//Click Dental Plan
		ViewCoverage_Page.ClickOnPlanDropdown("Dental");
		//Click UpdateCoveredMembers
		ViewCoverage_Page.ClickDentalUpdateCoveredMembers();
		//Select ActionTypeRemove
		updateCoveredMembers.ActionTypeRemove();
		//Select QualifyingEvent
		updateCoveredMembers.clickQualifyingEvent();
		//Enter TerminationDate
		updateCoveredMembers.clickTerminationDate(testdata);
		//Remove Covered Member
		ViewCoverage_Page.ClickOnPlanDropdown("Dental");
		//Select the Covered Member
		updateCoveredMembers.selectCoveredMember();
		//Click Confirmation OK
		updateCoveredMembers.clickConfirmationOK();
		//Submit Enrollment
		updateCoveredMembers.clickSubmit();
		enrollmentSummaryPage.downloadSummaryDocument();
		ExtentSuccessMessage("Successfully updated the CoveredMember Ancillary (Removed Child Dependant)");      
				
		Group_Page.Logout1();
		//Enter the BA Username
		Login_Page.EnterUserNameField(configloader().getProperty("SperidianBA_UserName"));
		//Enter the BA Password
		Login_Page.EnterPasswordField(configloader().getProperty("SperidianBA_Password"));
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.ReviewEmployeeTransactions(fullname);
		Group_Page.Logout1();
		//Enter the Employee Username
		Login_Page.EnterUserNameField(UserName);
		//Enter the Employee Password
		Login_Page.EnterPasswordField(testdata.get("Password").toString());
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.clickMyCoverage();
		ExtentSuccessMessage("**********Update Covered Member - End**********");
		
		ExtentSuccessMessage("**********Change Plan - Start**********");
        //Click on  Medical Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown("Medical");
		//Click on the Change Plan button
		ViewCoverage_Page.ChangeplanbuttonMedical();
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
		Assert.assertNotEquals(
				enrollmentSummaryPage.VerifyoldPlanName(enrollmentSummaryPage.oldPlanname), 
				enrollmentSummaryPage.VerifynewPlanName(enrollmentSummaryPage.newPlanname),
				"Assertion Passed");
        enrollmentSummaryPage.downloadSummaryDocument();
        ExtentSuccessMessage("Successfully Changed Medical Plan");
        
		Group_Page.Logout1();
		//Enter the BA Username
		Login_Page.EnterUserNameField(configloader().getProperty("SperidianBA_UserName"));
		//Enter the BA Password
		Login_Page.EnterPasswordField(configloader().getProperty("SperidianBA_Password"));
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.ReviewEmployeeTransactions(fullname);
		Group_Page.Logout1();
		//Enter the Employee Username
		Login_Page.EnterUserNameField(UserName);
		//Enter the Employee Password
		Login_Page.EnterPasswordField(testdata.get("Password").toString());
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.clickMyCoverage();

        //Change Plan Ancillary
		//Click on the Dental Plan
		ViewCoverage_Page.ClickOnPlanDropdown("Dental");
		//Click on the Change Plan button
		ViewCoverage_Page.ChangePlanbuttonDental();
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
      	//Assert.assertNotEquals(changePlanAncillary.VerifyoldPlanName(changePlanAncillary.oldname), changePlanAncillary.VerifynewPlanName(changePlanAncillary.newname),"Assertion Passed");
      	enrollmentSummaryPage.downloadSummaryDocument();	
      	ExtentSuccessMessage("Successfully Changed Ancillary Plan");
		
		Group_Page.Logout1();
		//Enter the BA Username
		Login_Page.EnterUserNameField(configloader().getProperty("SperidianBA_UserName"));
		//Enter the BA Password
		Login_Page.EnterPasswordField(configloader().getProperty("SperidianBA_Password"));
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.ReviewEmployeeTransactions(fullname);
		Group_Page.Logout1();
		//Enter the Employee Username
		Login_Page.EnterUserNameField(UserName);
		//Enter the Employee Password
		Login_Page.EnterPasswordField(testdata.get("Password").toString());
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.clickMyCoverage();
		ExtentSuccessMessage("**********Change Plan - End**********");
		
		ExtentSuccessMessage("**********Terminate Plan - Start**********");
		//Terminate Medical Plan   
		//click Medical Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown("Medical");
		// Click OnTerminate Medical
		ViewCoverage_Page.ClickonTerminateMedicalButton();
		//Click OnTerminate Plan
		ViewCoverage_Page.Terminateplan(testdata);
		Assert.assertEquals(
				enrollmentSummaryPage.checkTerminationDate(testdata), 
				enrollmentSummaryPage.VerifyTerminationDate(enrollmentSummaryPage.date),
				"Assertion Passed");	
		enrollmentSummaryPage.downloadSummaryDocument();	
    	enrollmentSummaryPage.ClickOnClose_Button();
		ExtentSuccessMessage("Successfully Terminated Medical Plan");    
    	
		//Terminate Ancillary Plan
		//Click On Dental Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown("Dental");
		//Click on Terminate Dental Button
		ViewCoverage_Page.ClickonTerminateDentalButton();
		//Terminate Dental plan
		ViewCoverage_Page.Terminateplan(testdata);
        enrollmentSummaryPage.downloadSummaryDocument();
        enrollmentSummaryPage.ClickOnClose_Button();
        ExtentSuccessMessage("Successfully Terminated Ancillary Plan");
        ExtentSuccessMessage("**********Terminate Plan - End**********");
        
        ExtentSuccessMessage("**********ReEnroll Plan - Start**********");
        //ReEnroll Medical PLan
		//Click on Medical Dropdown
        ViewCoverage_Page.ClickOnPlanDropdown("Medical");
		//Clcik on Enroll button
		ViewCoverage_Page.clickEnrollMedicalinPlan();
		qe_cp_Page.selectQualifyingEvent();
		// Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		// Select the different sub plan
		qe_cp_Page.selectPlan();
		// Click on the Submit button
		qe_cp_Page.clickSubmit();
		Assert.assertEquals(
				enrollmentSummaryPage.checkEnrollmentDate(testdata),
				enrollmentSummaryPage.VerifyEnrollmentDate(enrollmentSummaryPage.date), 
				"Assertion Passed");
		enrollmentSummaryPage.downloadSummaryDocument();
		ExtentSuccessMessage("Successfully ReEnrolled Medical PLan");
		
		Group_Page.Logout1();
		//Enter the BA Username
		Login_Page.EnterUserNameField(configloader().getProperty("SperidianBA_UserName"));
		//Enter the BA Password
		Login_Page.EnterPasswordField(configloader().getProperty("SperidianBA_Password"));
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.ReviewEmployeeTransactions(fullname);
		Group_Page.Logout1();
		//Enter the Employee Username
		Login_Page.EnterUserNameField(UserName);
		//Enter the Employee Password
		Login_Page.EnterPasswordField(testdata.get("Password").toString());
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.clickMyCoverage();
		
		//ReEnroll Ancillary Plan
		//Click on Dental Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown("Dental");
		//Click on the Enroll button
		ViewCoverage_Page.clickEnrollDentalinPlan();
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		//Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		//Select the different sub plan
		qe_cp_Page.selectPlan();
		//Click on the Submit button
		qe_cp_Page.clickSubmit();
		enrollmentSummaryPage.downloadSummaryDocument();	
		ExtentSuccessMessage("Successfully ReEnrolled Ancillary Plan");
        
		Group_Page.Logout1();
		//Enter the BA Username
		Login_Page.EnterUserNameField(configloader().getProperty("SperidianBA_UserName"));
		//Enter the BA Password
		Login_Page.EnterPasswordField(configloader().getProperty("SperidianBA_Password"));
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.ReviewEmployeeTransactions(fullname);
		Group_Page.Logout1();
		//Enter the Employee Username
		Login_Page.EnterUserNameField(UserName);
		//Enter the Employee Password
		Login_Page.EnterPasswordField(testdata.get("Password").toString());
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.clickMyCoverage();
		ExtentSuccessMessage("**********ReEnroll Plan - End**********");
		
		//Terminate Medical Plan
		//click Medical Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown("Medical");
		// Click OnTerminate Medical
		ViewCoverage_Page.ClickonTerminateMedicalButton();
		//Click OnTerminate Plan
		ViewCoverage_Page.TerminateplanonQE(testdata);
		enrollmentSummaryPage.downloadSummaryDocument();	
		enrollmentSummaryPage.ClickOnClose_Button();
		ExtentSuccessMessage("Successfully Terminated Medical Plan");     
		
		ExtentSuccessMessage("**********QE Enrollment - Start**********");
		//QE Medical Plan
		//Click on the Medical Plan and Enroll button
		ViewCoverage_Page.ClickOnDeclinedPlanDropdownEnroll("Medical");		
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		//Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		//Select the different sub plan
		qe_cp_Page.selectPlan();
		//Click on the Submit button
		qe_cp_Page.clickSubmit();
      	enrollmentSummaryPage.downloadSummaryDocument();		
      	ExtentSuccessMessage("Successfully Enrolled QE on Medical");
		
		Group_Page.Logout1();
		//Enter the BA Username
		Login_Page.EnterUserNameField(configloader().getProperty("SperidianBA_UserName"));
		//Enter the BA Password
		Login_Page.EnterPasswordField(configloader().getProperty("SperidianBA_Password"));
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.ReviewEmployeeTransactions(fullname);
		Group_Page.Logout1();
		//Enter the Employee Username
		Login_Page.EnterUserNameField(UserName);
		//Enter the Employee Password
		Login_Page.EnterPasswordField(testdata.get("Password").toString());
		//Click on the Login Button
        Login_Page.ClickOnLoginButton();
		Group_Page.clickMyCoverage();
      	
		//Terminate Ancillary Plan
		//Click On Dental Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown("Dental");
		//Click on Terminate Dental Button
		ViewCoverage_Page.ClickonTerminateDentalButton();
		//Terminate Dental plan
		ViewCoverage_Page.TerminateplanonQE(testdata);
		enrollmentSummaryPage.downloadSummaryDocument();
		enrollmentSummaryPage.ClickOnClose_Button();
		ExtentSuccessMessage("Successfully Terminated Ancillary Plan");
		
		
		//QE Ancillary Plan
		//Click on the Dental dropdown and Enroll button
		ViewCoverage_Page.ClickOnDeclinedPlanDropdownEnroll("Dental");
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		//Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		//Select the different sub plan
		qe_cp_Page.selectPlan();
		//Click on the Submit button
		qe_cp_Page.clickSubmit();
		//Download Summary
		enrollmentSummaryPage.downloadSummaryDocument();	
		ExtentSuccessMessage("Successfully Enrolled QE on Ancillary");
		ExtentSuccessMessage("**********QE Enrollment - End**********");
	}       
}
