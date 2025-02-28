package IHA_Admin_BA_TCs;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.SummaryVerification_Page;
import Pages.ViewCoverage_Page;

public class IHA_SummaryVerificationFlow extends IHA_Admin_BA_AllScenarios 
{
	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	ViewCoverage_Page viewCoveragePage=new ViewCoverage_Page();
	SummaryVerification_Page viewSummary=new SummaryVerification_Page();	

	public void ValidateSummaryVerification(String TestScenario,String GroupName,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException
	{
		purgeDownloadDirectory();
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
        String ssn = employeePage.addIHAPersonalInformation(testdata);
        //Click on Activate and Enroll Button
        employeePage.activateAndEnroll();
        // Enter Effective Date
        enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
        //Select Plans
        List<Map<String,String>> selectedPlanDetails=enrollmentPage.selectPlans(false);
        // Click Submit Enrollment
        enrollmentPage.submitEnrollment();
        //Verfiy the Enrolled Plans
        enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
        purgeDownloadDirectory(); //ramya
        //Download the Summary Document
        enrollmentSummaryPage.downloadSummaryDocument();
        // Assert.assertTrue(isDownloadedFileExist());//ramya
        assertEquals(GetFilesCountInDownloadDirectory(), 1);
        //Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		//Click on View Summary Button
    	viewCoveragePage.ClickOnViewSummary();
    	//Assert.assertTrue(isDownloadedFileExist());
    	//Assert.assertEquals(GetFilesCountInDownloadDirectory(), 1);
	}	
}