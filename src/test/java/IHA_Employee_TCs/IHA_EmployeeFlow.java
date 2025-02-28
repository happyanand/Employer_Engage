package IHA_Employee_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import IHA_Admin_BA_TCs.IHA_Admin_BA_AllScenarios;
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
import Pages.ManageCoverage_Page;
import Pages.MemberAdministration_Page;
import Pages.QEEnrollment_ChangePlan_Page;
import Pages.SummaryVerification_Page;
import Pages.UpdateCoveredMembers_Page;
import Pages.ViewCoverage_Page;

public class IHA_EmployeeFlow extends IHA_Employee_AllScenarios  {

	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	MemberAdministration_Page memberAdministration_Page = new MemberAdministration_Page();
	ManageCoverage_Page manageCoverage_Page = new ManageCoverage_Page();
	SummaryVerification_Page viewSummary=new SummaryVerification_Page();	
	QEEnrollment_ChangePlan_Page qe_cp_Page = new QEEnrollment_ChangePlan_Page();
	UpdateCoveredMembers_Page updateCoveredMembers= new UpdateCoveredMembers_Page();
	EmailLogs emaillog = new EmailLogs();
	CreateYourAccount CreateYourAccount = new CreateYourAccount();
	Login_Page Login_Page = new Login_Page();
	EditEmployee_Page editEmployee= new EditEmployee_Page();
	CascadingMembership_Page cascadeScenario = new CascadingMembership_Page();
	
	//IHA Employee Flow
	public void ValidateEmployeeFlow(String TestScenario,String GroupName,Map<Object, Object> testdata, String Password) throws InterruptedException, AWTException, IOException
	{

		//Select the Group Name
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
        String result = employeePage.addIHAPersonalInformation(testdata);
		String[] values = result.split(",");	
		String firstname = values[1];
		String lastname = values[2];
		String fullname = firstname+" "+lastname;
        // Add Dependent
        employeePage.addDependent(testdata);
        // Click on activateAndEnroll
        employeePage.activateAndEnroll();
        // Enter Effective Date
        enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
        //Select Plans
        enrollmentPage.selectPlans(false);
        // Click Submit Enrollment
        enrollmentPage.submitEnrollment();
        String oldCoveredMember=updateCoveredMembers.VerifyNewMemberNameAdd(updateCoveredMembers.newname);
        //Download the Summary Document
        enrollmentSummaryPage.downloadSummaryDocument();
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
		Thread.sleep(13000);
		WaitForLoadAnimationDisappear();
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
		CreateYourAccount.EnterIHACreateUserName(UserName);
		System.out.println("User Name"+UserName);
		//Enter the Password
		CreateYourAccount.EnterIHACreatePassword(Password);
		//Enter the Confirm Password
		CreateYourAccount.EnterIHACreateConfirmPassword(Password);
		//Click on the Policy And Terms CheckBox
		CreateYourAccount.ClickOnIHAPriPolicyAndTermsConCheckBox();
		//Click on the I Accept Button
		CreateYourAccount.ClickOnIHAIAcceptButton();
		//Click on the Create User Registration button
		CreateYourAccount.ClickOnCreateUserRegistrationButton();

		//Click on My Coverage
    	Group_Page.clickMyCoverage();
    	ExtentSuccessMessage("**********Summary Verification**********");
		viewSummary.clickViewSummary();
        Assert.assertTrue(isDownloadedFileExist()); 
		ExtentSuccessMessage("Successfully Verified Enrollment Summary"); 
	
		ExtentSuccessMessage("**********Update Covered Member - Start**********");
		//Add a Dependent/Beneficiary
		ViewCoverage_Page.ClickUpdateCoveredMembersMedical();
		//Select ActionTypeADD
		updateCoveredMembers.ActionTypeADD();
		//Select QualifyingEvent
		updateCoveredMembers.clickQualifyingEvent();
		//Enter EffectiveDate
		updateCoveredMembers.clickEffectiveDate(testdata);
		//Select the Covered Member
		updateCoveredMembers.selectCoveredMember();
		//Submit Enrollment
		updateCoveredMembers.clickSubmit();	
		String addedCoveredMember=updateCoveredMembers.VerifyNewMemberNameAdd(updateCoveredMembers.newname);
		Assert.assertNotEquals(oldCoveredMember,addedCoveredMember, "Assertion Passed");
		//Close Summary Document
		enrollmentSummaryPage.ClickOnClose_Button();	
		//Click UpdateCoveredMembers
		ViewCoverage_Page.ClickUpdateCoveredMembersMedical();
		//Select ActionTypeADD
		updateCoveredMembers.ActionTypeRemove();
		//Select QualifyingEvent
		updateCoveredMembers.clickQualifyingEvent();
		//Enter EffectiveDate
		updateCoveredMembers.clickEffectiveDate(testdata);
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
		
		ExtentSuccessMessage("**********Cascade Scenario**********");
		//click Employee Details
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
		Thread.sleep(5000);
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
		cascadeScenario.clickMedicalCascadeDropdown();
		//click Child
		cascadeScenario.clickChild();
		WaitForPageLoad();
		//Submit Enrollment
		enrollmentPage.submitEnrollment();
		Assert.assertNotEquals(cascadeScenario.fetchFullAddress(testdata),
				cascadeScenario.VerifyAddress(cascadeScenario.address), "Assertion Passed");
		purgeDownloadDirectory();
		//Click on Close button
		enrollmentSummaryPage.closeEnrollmentSummary();
		
		ExtentSuccessMessage("**********Change Plan - Start**********");
		//Click on Change Plan button
		ViewCoverage_Page.ChangeplanbuttonMedical();
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		//Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
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
        //Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("**********Change Plan - End**********");
		
		ExtentSuccessMessage("**********Terminate Plan - Start**********");
		//Click on Terminate Medical Button
		ViewCoverage_Page.ClickonTerminateMedicalButton();
		//Terminate the Plan
		ViewCoverage_Page.Terminateplan(testdata);
		//Verify the Termination Date
		Assert.assertEquals(
				enrollmentSummaryPage.checkTerminationDate(testdata), 
				enrollmentSummaryPage.VerifyTerminationDate(enrollmentSummaryPage.date),
				"Assertion Passed");	
		//Download Summary Document
		enrollmentSummaryPage.downloadSummaryDocument();
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("**********Terminate Plan - End**********");
		
		ExtentSuccessMessage("**********ReEnroll Plan - Start**********");
		//Click on Enroll button
		ViewCoverage_Page.clickEnrollMedicalinPlan();
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		// Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		//Select the Employee Status
		qe_cp_Page.employmentStatus();
		// Select the different sub plan
		qe_cp_Page.selectPlan();
		// Click on the Submit button
		qe_cp_Page.clickSubmit();
		// Verify the Enrollment Date
		Assert.assertEquals(
				enrollmentSummaryPage.checkEnrollmentDate(testdata),
				enrollmentSummaryPage.VerifyEnrollmentDate(enrollmentSummaryPage.date), 
				"Assertion Passed");
		// Download the Summary document
		enrollmentSummaryPage.downloadSummaryDocument();
		enrollmentSummaryPage.closeEnrollmentSummary();   
		ExtentSuccessMessage("**********ReEnroll Plan - End**********");
		
		//Terminate Medical Plan
      	//ViewCoverage_Page.ClickOnMedicalDropdown();
      	ViewCoverage_Page.ClickonTerminateMedicalButton();
      	ViewCoverage_Page.TerminateplanonQE(testdata);		   
		ExtentSuccessMessage("Successfully Terminated Medical Plan");
	
    	ExtentSuccessMessage("**********QE Enrollment - Start**********");
		//Click on the Medical Plan and Enroll button
		ViewCoverage_Page.ClickOnDeclinedPlanDropdownEnroll("Medical");
		//Select the Qualifying Event
		qe_cp_Page.selectQualifyingEvent();
		//Enter the Effective Date
		qe_cp_Page.enterEffectiveDate(testdata.get("NewEffectiveDate").toString());
		//Select the Employee Status
		qe_cp_Page.employmentStatus();
		//Select the different sub plan
		qe_cp_Page.selectPlan();
		//Click on the Submit button
		qe_cp_Page.clickSubmit();
		//Verify the changes made
      	Assert.assertEquals(
      			enrollmentSummaryPage.checkEnrollmentDate(testdata),
      			enrollmentSummaryPage.VerifyEnrollmentDate(enrollmentSummaryPage.date),
      			"Assertion Passed");
		//Download the Summary document
		enrollmentSummaryPage.downloadSummaryDocument();
		//Close Summary Document
		enrollmentSummaryPage.ClickOnClose_Button();
		ExtentSuccessMessage("**********QE Enrollment - End**********");
		
	}
}
