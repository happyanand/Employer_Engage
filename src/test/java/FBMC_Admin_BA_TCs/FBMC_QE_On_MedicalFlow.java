package FBMC_Admin_BA_TCs;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

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

public class FBMC_QE_On_MedicalFlow extends FBMC_Admin_BA_AllScenarios {
	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	QEEnrollment_ChangePlan_Page qe_cp_Page = new QEEnrollment_ChangePlan_Page();
	Payment_Profile Payment_Profile= new Payment_Profile();
	
	//Validate QE on Medical
	public void ValidateQEonMedical(String TestScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException, IOException {
		//Select Group
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
		employeePage.addPersonalInformation(testdata);
		// Click on activateAndEnroll
		employeePage.activateAndEnroll();
		// Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		//Get all the plan info
		enrollmentPage.getAllThePlans();		
		//Decline all the Coverages
		enrollmentPage.declineAllCoverage();
		//Add Additional Insurance
		enrollmentPage.addAdditionalInsurance(false,testdata);
		//Click on Next Button
		enrollmentPage.clickNext();
		//Add Payment profile in the Payment section
        if(testdata.get("PaymentMethod").toString().equalsIgnoreCase("ACH")) {
        	Payment_Profile.addProfileWithACH(true, "Chase", "021300077", false);
        }
        else {
        	Payment_Profile.addProfileWithPensionAuthority(true);
        }
        //Click on the Submit button
        enrollmentPage.submitEnrollment();
        Thread.sleep(5000);
        //Click on the Medical Dropdown and Enroll Button
        ViewCoverage_Page.ClickOnDeclinedPlanDropdownEnroll("Medical");
		
		//Changes  Plan Steps
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
      	Assert.assertEquals(enrollmentSummaryPage.checkEnrollmentDate(testdata), enrollmentSummaryPage.VerifyEnrollmentDate(enrollmentSummaryPage.date),"Assertion Passed");
		//Download the Summary document
		enrollmentSummaryPage.downloadSummaryDocument();
	}
}
