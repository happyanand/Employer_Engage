package Speridian_Admin_BA_TCs;

import java.awt.AWTException;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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


public class Speridian_TerminateMedicalFlow extends Speridian_Admin_BA_AllScenarios 
{
	Home_Page Home_Page=new Home_Page();
	Base_Class Base_Class = new Base_Class();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();

	public void ValidateTerminateMedical(String TestScenario,String GroupName,Map<Object, Object> testdata) throws InterruptedException, AWTException, ParseException
	{		

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
		//Add Additional Insurance
		enrollmentPage.addAdditionalInsurance(false,testdata);
		// Submit Enrollment
		enrollmentPage.submitEnrollment();
		Thread.sleep(3000);
		String CustomerNo =enrollmentSummaryPage.CustomerNumberReturn();
		System.out.println("Customer no :"+CustomerNo);
		//Verify Enrolled Plan Info Displayed
		enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
		enrollmentSummaryPage.downloadSummaryDocument();
		//Click On Close_Button
		enrollmentSummaryPage.ClickOnClose_Button();
		
		//click Medical Dropdown
		ViewCoverage_Page.ClickOnPlanDropdown(testdata.get("planName").toString());
		// Click OnTerminate Medical
//		terminateMedical.ClickonTerminateMedical();
		ViewCoverage_Page.ClickonTerminateMedicalButton();
		//Click OnTerminate Plan
		ViewCoverage_Page.Terminateplan(testdata);
		String outputDateStr =ChangeDateformate(testdata.get("TerminationDate").toString());
		//Assert.assertTrue(terminateMedical.DateWalidationByXpath(outputDateStr)); 
		enrollmentSummaryPage.downloadSummaryDocument();
		Assert.assertTrue(isDownloadedFileExist());

	}	
}
