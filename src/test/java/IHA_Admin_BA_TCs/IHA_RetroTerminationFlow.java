package IHA_Admin_BA_TCs;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.BasePackage.Base_Class;

import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.ViewCoverage_Page;

public class IHA_RetroTerminationFlow extends IHA_Admin_BA_AllScenarios  {
	
	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	
	public void ValidateRetroTermination(String TestScenario, String GroupName,Map<Object, Object> testdata)throws 
	InterruptedException, AWTException, IOException, ParseException 
	{	
		//Select the Group Name
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
		
		//Update Member Id steps
		//Navigate and click on the Carrier Response Update Button
//		Group_Page.navigateToCarrierResponseUpdateOnHeader();
		//Update Member Id
//		memberAdministration_Page.updateMemberId(ssn);
		//Search the Employee
//		manageCoverage_Page.searchEmployee(ssn);
		
		//Retro Termination
		// Click on Terminate Dental Button
		ViewCoverage_Page.ClickonTerminateMedicalButton();
		//Terminate the Plan
		ViewCoverage_Page.Terminateplan(testdata);
		//Verify the Termination Date
		String outputDateStr =ChangeDateformate(testdata.get("TerminationDate").toString());
		Assert.assertTrue(ValidationOnSummaryPage(outputDateStr));
		//Download Summary Document
		enrollmentSummaryPage.downloadSummaryDocument();
		Assert.assertTrue(isDownloadedFileExist());
		
		//Update Success Response
		//Navigate and click on the Carrier Response Update Button
//		Group_Page.navigateToCarrierResponseUpdateOnHeader();
		//Update Success Response
//		memberAdministration_Page.UpdateSuccessResponse(ssn);
		//Search the Employee
//		manageCoverage_Page.searchEmployee(ssn);  
		
	}
}
