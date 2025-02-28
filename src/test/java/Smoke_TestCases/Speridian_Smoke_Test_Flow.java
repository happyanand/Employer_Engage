package Smoke_TestCases;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import Pages.CascadingMembership_Page;
import Pages.CommentsRoaster_Page;
import Pages.CreateYourAccount;
import Pages.EditEmployee_Page;
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
import Pages.QEEnrollment_ChangePlan_Page;
import Pages.Reports_Page;
import Pages.SummaryVerification_Page;
import Pages.UpdateCoveredMembers_Page;
import Pages.ViewCoverage_Page;

public class Speridian_Smoke_Test_Flow extends Smoke_Test_AllScenarios {

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
	
    //Smoke Test
    public void ValidateSperidian_SmokeTest(String TestScenario,String GroupName,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException {       
   
    	//Validate Login Page
        assertTrue(Login_Page.isLoginPageDisplayed());
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
		// Click on the Reports from Header
		Group_Page.clickReportsOnHeader();
		//Reports page displayed
		Reports.isReportsPageDisplayed();
	
    }
}
