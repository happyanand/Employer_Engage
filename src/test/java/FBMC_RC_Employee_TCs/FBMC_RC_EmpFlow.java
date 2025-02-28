package FBMC_RC_Employee_TCs;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
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
import Pages.Payment_Profile;
import Pages.QEEnrollment_ChangePlan_Page;
import Pages.RenewalCenter_Page;
import Pages.SummaryVerification_Page;
import Pages.UpdateCoveredMembers_Page;
import Pages.ViewBenefits_Page;
import Pages.ViewCoverage_Page;

public class FBMC_RC_EmpFlow extends FBMC_RC_Emp_AllScenarios
{
	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	ViewCoverage_Page viewCoveragePage=new ViewCoverage_Page();
	CascadingMembership_Page cascadeScenario = new CascadingMembership_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	RenewalCenter_Page renewalCenter=new RenewalCenter_Page();
	SummaryVerification_Page viewSummary=new SummaryVerification_Page();
	UpdateCoveredMembers_Page updateCoveredMembers= new UpdateCoveredMembers_Page();
	EditEmployee_Page editEmployee= new EditEmployee_Page();
	QEEnrollment_ChangePlan_Page qe_cp_Page = new QEEnrollment_ChangePlan_Page();
	Payment_Profile Payment_Profile= new Payment_Profile();
	ViewBenefits_Page viewBenefits=new ViewBenefits_Page();
	EmailLogs emaillog = new EmailLogs();
	CreateYourAccount CreateYourAccount = new CreateYourAccount();
	Login_Page Login_Page = new Login_Page();
	
	
	//Renewal Center
	public  void ValidatedRenewalCenterEmp(String TestScenario, String GroupName,Map<Object, Object> testdata,String EmailId,String Password,String SecurityQuestion1,String SecurityAnswer1,String SecurityQuestion2,String SecurityAnswer2,String SecurityQuestion3,String SecurityAnswer3)throws InterruptedException, AWTException, IOException  {
		
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
		WaitForLoadAnimationDisappear();
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
		viewCoveragePage.ClickOnEmployeeDetails();
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
		
    	//Login with Support User
//    	Group_Page.clickMore();
//      Group_Page.SupportUserLogin(firstname);		
//      ExtentSuccessMessage("Successfully Enrolled Support User");
		//Click On Renewal Center
		viewCoveragePage.clickRenewalCenter();
		//CLick New Enrollment
        Group_Page.clicknewEnrollment();
        //Click Submit
        cascadeScenario.clickSubmit();
        
    	ExtentSuccessMessage("**********Update Covered Member - Start**********");
		//Click Dental Decline checkbox
		renewalCenter.declinecheckbox("Dental");
		//Click on Dental Dropdown
		viewCoveragePage.ClickOnDentalDropdown();
		//Add Spouse
		renewalCenter.dependentcheckbox("Spouse", "Dental");		
		//Select Dental Plan
		renewalCenter.SelectRCPlan("Dental","1");
		//Click on Dental Dropdown
		viewCoveragePage.ClickOnDentalDropdown();
		//Click Vision Decline checkbox
		renewalCenter.declinecheckbox("Vision");
		//Click on Vision Dropdown
		viewCoveragePage.ClickOnVisionDropdown();
		//Select Vision Plan
		renewalCenter.SelectRCPlan("Vision","1");
		//Click on Vision Dropdown
		viewCoveragePage.ClickOnVisionDropdown();	
		//Add additional Insurance
		enrollmentPage.addAdditionalInsurance(false,testdata);
		//Click Next
		enrollmentPage.clickNext();		
		//Submit Enrollment
		enrollmentPage.submitEnrollment();
		String oldPlanName=enrollmentSummaryPage.VerifynewPlanName(enrollmentSummaryPage.newPlanname);
		String oldname= updateCoveredMembers.memberName("Dental");
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		//Click on Dental Dropdown
		viewCoveragePage.ClickOnDentalDropdown();
		ExtentSuccessMessage("**********Update Covered Member - End**********");
		
		ExtentSuccessMessage("**********View Benefits - Start**********");
		//View Benefits Information
		viewCoveragePage.ViewBenefitsInformtion();
		//Click on Dental Dropdown
		viewCoveragePage.ClickOnDentalDropdown();				
		//Click Home
		Group_Page.click_Home();
		//New Enrollment
		Group_Page.clicknewEnrollment();
		ExtentSuccessMessage("**********View Benefits - End**********");
		
		ExtentSuccessMessage("**********Cascade Scenario - Start**********");
        //Edit Employee Details
        editEmployee.enterNewAddress(testdata);
		editEmployee.scrollTillDependents();
		//Add Dependent
		editEmployee.addDependent(testdata);
		//click Submit
		cascadeScenario.clickSubmit();
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("**********Cascade Scenario - End**********");

		ExtentSuccessMessage("**********Change Plan - Start**********");
		//Click on Dental Dropdown
		viewCoveragePage.ClickOnDentalDropdown();
		//Update Covered Member
		//Remove Spouse
		renewalCenter.dependentcheckbox("Spouse", "Dental");
		//Add Child Dependent
		renewalCenter.dependentcheckbox("Child /Dependent", "Dental");
		//Select Dental Plan
		renewalCenter.SelectRCPlan("Dental","2"); 
		//Click on Dental Dropdown
		viewCoveragePage.ClickOnDentalDropdown();	
		ExtentSuccessMessage("**********Change Plan - End**********");
		
		ExtentSuccessMessage("**********QE Enrollment - Start**********");
		//Enroll Declined Plan 
		renewalCenter.declinecheckbox("Legal");
		//Click on Legal Dropdown
		renewalCenter.clickLegalplan();
		//Select Legal Plan
		renewalCenter.SelectRCPlan("Legal","1");
		//Click on Legal Dropdown
		renewalCenter.clickLegalplan();
		//Add additional Insurance
		enrollmentPage.addAdditionalInsurance(false,testdata);
		//Click Next
		enrollmentPage.clickNext();
		//Submit Enrollment
		enrollmentPage.submitEnrollment();
		//Validate Changed Plan Name
		String newPlanName=enrollmentSummaryPage.VerifynewPlanName(enrollmentSummaryPage.newPlanname);
		Assert.assertNotEquals(oldPlanName,newPlanName,"Assertion Passed");
		//***validate spouse(checkbox) is selected for dental plan or not? 
		String Newname= updateCoveredMembers.memberName("Dental");
		Assert.assertNotEquals(Newname,oldname,"Assertion Passed");	
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		ExtentSuccessMessage("**********QE Enrollment - End**********");
		
		ExtentSuccessMessage("**********Summary Verification - Start**********");
        viewSummary.clickViewSummary();
        //Assert.assertTrue(isDownloadedFileExist()); 
        ExtentSuccessMessage("**********Summary Verification - End**********");
	
	}
}
