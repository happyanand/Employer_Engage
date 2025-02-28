package Speridian_Admin_BA_TCs;

import Pages.TerminateEmployee_Page;

import java.awt.AWTException;
import java.text.ParseException;
import java.util.HashMap;
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

public class Speridian_RetroTerminationFlow extends Speridian_Admin_BA_AllScenarios {

	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	TerminateEmployee_Page terminateEmployeePage=new TerminateEmployee_Page();	
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();

	public void ValidateRetroTermination(String testScenario, String GroupName,Map<Object, Object> testdata)throws InterruptedException, AWTException, ParseException {

		//Select Account name
		Home_Page.SelectGroupname(GroupName);
		// click Employee Administration
		Group_Page.clickEmployeeAdministration();
		//click Add Employee
		employeeAdministration.clickAddEmployee();
		//Add Personal Information
		employeePage.addPersonalInformation(testdata);

		//Add Notes
		employeePage.addNotes(testdata.get("NotesPrivate").toString());
		//Activate And Enroll
		employeePage.activateAndEnroll();
		System.out.println("effective Date ; "+testdata.get("EffectiveDate").toString());
		//Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		//Select Speridian Plans
		List<Map<String,String>> selectedPlanDetails=enrollmentPage.selectSperidianPlans(false);
		// Add Additional Insurance
		enrollmentPage.addAdditionalInsurance(false, testdata);
		// Submit Enrollment
		enrollmentPage.submitEnrollment();
		//Verify Enrolled Plan Info Displayed
		enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
		Thread.sleep(5000);
		//Click On Close_Button
		enrollmentSummaryPage.ClickOnClose_Button();
		//Click On Dental Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(testdata.get("planName").toString());
		// Click on Terminate Dental Button
		ViewCoverage_Page.ClickonTerminateDentalButton();
		//Till now 
		ViewCoverage_Page.Terminateplan(testdata);
		String outputDateStr =ChangeDateformate(testdata.get("TerminationDate").toString());
		Assert.assertTrue(ValidationOnSummaryPage(outputDateStr));
		enrollmentSummaryPage.downloadSummaryDocument();
		Assert.assertTrue(isDownloadedFileExist());
				
	}

}
