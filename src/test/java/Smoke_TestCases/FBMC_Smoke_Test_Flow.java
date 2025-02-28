package Smoke_TestCases;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import Pages.AccountSummary_Page;
import Pages.CommentsRoaster_Page;
import Pages.EmailLogs;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.GroupInformation_Page;
import Pages.Home_Page;
import Pages.Login_Page;
import Pages.ManageCoverage_Page;
import Pages.Payment_Profile;
import Pages.RenewalCenter_Page;
import Pages.Reports_Page;
import Pages.ViewCoverage_Page;

public class FBMC_Smoke_Test_Flow extends Smoke_Test_AllScenarios {

	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
    ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	Login_Page Login_Page = new Login_Page();
	EmailLogs emaillog = new EmailLogs();
	ManageCoverage_Page manageCoverage= new ManageCoverage_Page();
	GroupInformation_Page GroupInfo = new GroupInformation_Page();
	Reports_Page Reports = new Reports_Page();
	CommentsRoaster_Page CommentsRoaster = new CommentsRoaster_Page();
	RenewalCenter_Page RenewalCenter = new RenewalCenter_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	Payment_Profile Payment_Profile = new Payment_Profile();
	AccountSummary_Page accountSummary = new AccountSummary_Page();
	
	
    //Smoke Test
    public void ValidateFBMC_SmokeTest(String TestScenario,String GroupName,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException {       
 
    	//Validate Login Page
        assertTrue(Login_Page.isLoginPageDisplayed());
        String userName=Home_Page.getLoggedInUserName().replaceAll(" ", "");
        String expUserName=configloader().getProperty("FBMCAdmin_UserName");
        assertTrue(userName.equalsIgnoreCase(expUserName));
		// Select Group name
		Home_Page.SelectGroupname(GroupName);	
		// All the links related Group are displayed
		assertTrue(Group_Page.isAllGroupLinksDisplayed());
		// click Employee Administration
		Group_Page.clickEmployeeAdministration();
		//Employee Administration page displayed
		employeeAdministration.isEmployeeAdministrationPageDisplayed();
		// Navigate to the Group Dashboard
		Group_Page.navigateToGroupDashboard();
		// Click on the Manage Coverage
		Group_Page.clickManageCoverage();
		//Manage Coverage page displayed
		manageCoverage.isManageCoveragePageDisplayed();
		// Navigate to the Group Dashboard
		Group_Page.navigateToGroupDashboard();
		// Click on the Group Information
		Group_Page.clickGroupInformation();
		//Group Information page displayed
		GroupInfo.isGroupsInformationPageDisplayed();
		// Navigate to the Group Dashboard
		Group_Page.navigateToGroupDashboard();
		// Click on the Renewal Center
		Group_Page.clickRenewalCenter();
		// Navigate to the Group Dashboard
		Group_Page.navigateToGroupDashboard();
		// Click on the Reports
		Group_Page.clickReports();
		//Reports page displayed
		Reports.isReportsPageDisplayed();
		// Navigate to the Group Dashboard
		Group_Page.navigateToGroupDashboard();
        //Navigation from the Top Employee Administration Header
		Group_Page.clickEmployeeAdministrationOnHeader();
		//Employee Administration page displayed
		employeeAdministration.isEmployeeAdministrationPageDisplayed();
		//Navigation from the Top Employee Administration Header
		Group_Page.clickGroupInformationOnHeader();
		//Group Information page displayed
		GroupInfo.isGroupsInformationPageDisplayed();
		//Navigation from the Top Benefits Information Header
		Group_Page.clickBenefitsInformationOnHeader();
		// Click on the View Coverage from menu
		Group_Page.clickViewCoverageOnHeader();
		//Manage Coverage page displayed
		manageCoverage.isManageCoveragePageDisplayed();
		// Click on the Renewal from menu
		Group_Page.clickRenewalOnHeader();
		//Renewal page displayed
		RenewalCenter.isRenewalPageDisplayed();
		// Click on the Reports from Header
		Group_Page.clickReportsOnHeader();
		//Reports page displayed
		Reports.isReportsPageDisplayed();
		// Click on the Comment Roaster from Header
		Group_Page.clickCommentRoaster();
		//Comments Roaster page displayed
		CommentsRoaster.isCommentsRoasterPageDisplayed();
		// Navigate to the Group Dashboard
		Group_Page.navigateToGroupDashboard();
		
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
		String result = employeePage.addPersonalInformation(testdata);
		String[] values = result.split(",");	
		String firstname = values[1];
		String lastname = values[2];
		// Activate And Enroll
		employeePage.activateAndEnroll();
		// Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		// Select Plans
		enrollmentPage.selectfourPlans(false,testdata.get("planName1").toString(),
				testdata.get("planName2").toString(),testdata.get("planName3").toString(),testdata.get("planName4").toString());
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
		//Close the Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		// Click on Employee Details
		ViewCoverage_Page.ClickOnEmployeeDetails();
		
		//************Account Summary Verification**********
		//Click on Account Summary
		employeeInformationPage.clickAccountSummary();
		// Validate All the Account Summary Page related fields are displayed
		assertTrue(accountSummary.isAllfieldsDisplayed());
		//Click on DelinquentHistory
		accountSummary.clickOnDelinquentHistory();
		//Click on Payment Profiles
		accountSummary.clickOnPaymentProfiles();
		//Click on Payment History
		accountSummary.clickOnPaymentHistory();
		//Click on Remittance History
		accountSummary.clickOnRemittanceHistory();
		//Click on Paid Through Date
		accountSummary.clickOnPaidThroughDate();
		//Click on EmployeeBenefits
		accountSummary.clickOnEmployeeBenefits();
		//Click on Refund Details
		accountSummary.clickOnRefundDetails();
		
    }
}
