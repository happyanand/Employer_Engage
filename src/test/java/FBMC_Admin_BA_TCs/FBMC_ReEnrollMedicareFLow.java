package FBMC_Admin_BA_TCs;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import Pages.CorrespondenceLetters_Page;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Payment_Profile;
import Pages.QEEnrollment_ChangePlan_Page;
import Pages.ViewCoverage_Page;

public class FBMC_ReEnrollMedicareFLow extends FBMC_Admin_BA_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
	QEEnrollment_ChangePlan_Page qe_cp_Page = new QEEnrollment_ChangePlan_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	Payment_Profile Payment_Profile = new Payment_Profile();
	CorrespondenceLetters_Page CCLetterVerification=new CorrespondenceLetters_Page();

	public void ValidateReEnrollMedicare(String TestScenario, String GroupName,Map<Object, Object> testdata)throws InterruptedException, AWTException, IOException {
		
		//Add and Enroll Employee
		//Search and Select Group name
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
		String result = employeePage.addPersonalInformation(testdata);
		String[] values = result.split(",");	
		String ssn = values[0];
		String lastname = values[1];
		// Click on activateAndEnroll
		employeePage.activateAndEnroll();
		// Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		// Select Plans
		List<Map<String, String>> selectedPlanDetails = enrollmentPage.selectPlans(false);
		// addAdditionalInsurance
		enrollmentPage.addAdditionalInsurance(false, testdata);
		// Click Next btn
		enrollmentPage.clickNext();
		// Add Payment Profile
		if(testdata.get("PaymentMethod").toString().equalsIgnoreCase("ACH")) {
        	Payment_Profile.addProfileWithACH(true, "Chase", "021300077", false);
        }
        else {
        	Payment_Profile.addProfileWithPensionAuthority(true);
        }
		// submit Enrollment
		enrollmentPage.submitEnrollment();
		//
		enrollmentSummaryPage.verifyEnrolledPlanInfoDisplayed(selectedPlanDetails);
		String CustomerNo = enrollmentSummaryPage.CustomerNumberReturn();
		//Store the Plan Name
		String firstPlan = enrollmentSummaryPage.selectedPlan();
		// Ramya- Assert.assertTrue(isDownloadedFileExist());
		// delete download summary file if exists
		purgeDownloadDirectory();
		// download summary
		enrollmentSummaryPage.downloadSummaryDocument();
		assertEquals(GetFilesCountInDownloadDirectory(), 1);
		//Close Enrollment Summary Page
		enrollmentSummaryPage.closeEnrollmentSummary();
        
        //Terminate Medicare
		//Click on the Medicare Advantage & Part D Plan
		ViewCoverage_Page.ClickOnPlanDropdown(testdata.get("planName").toString());
		//Click on the Terminate Medicare Advantage & Part D button
		ViewCoverage_Page.clickTerminateMedicare();
		//Enter the Termination Date and Select the Qualifying Event
		ViewCoverage_Page.Terminateplan(testdata);
		//Download the Summary Document
		enrollmentSummaryPage.downloadSummaryDocument();
		//Click on the Close button
		enrollmentSummaryPage.ClickOnClose_Button();						
		
		//ReEnroll Medicare
		//Click on the Medicare Advantage & Part D Plan
		ViewCoverage_Page.ClickOnPlanDropdown(testdata.get("planName").toString());
		//Click on the Enroll button
		ViewCoverage_Page.clickEnrollMedicareinPlan();
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
		//Verify the changes made
		String reEnroll = enrollmentSummaryPage.selectedPlan();
		enrollmentSummaryPage.verifyPlanName(reEnroll, firstPlan);
		//Download the Document
		enrollmentSummaryPage.downloadSummaryDocument();
		//Close Enrollment Summary
		enrollmentSummaryPage.closeEnrollmentSummary();
		
		//Correspondence Letters
		//Click on the Employee Details
		if (loginuser_Type.equalsIgnoreCase("Admin")) {
		ViewCoverage_Page.ClickOnEmployeeDetails();
		//Click on Attachments Tab
		employeeInformationPage.clickAttachments();
		//Get the Letter Type of the Document
		String LetterType = employeeInformationPage.getLetterType();
		//Click on the document
		employeeInformationPage.clickDocument();
		//Click on Home Page button
		Home_Page.clickHomePage();
		//Click on the Communication Tab
		Home_Page.clickCommunicationTab();
		//Click on the Correspondence Letters
		Home_Page.clickCorrespondenceLetters();
		//Select the ALL status in Correspondence type
        CCLetterVerification.selectCTALLstatus();
        //Search for the employee in Advanced search
		CCLetterVerification.ASsearchemployee(ssn);
		//Validate the Document Name
		CCLetterVerification.validateDocumentName(CustomerNo,lastname,LetterType);
		//Click on the Document
		CCLetterVerification.clickDocument();
	  }
   }
}
