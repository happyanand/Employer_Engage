package FBMC_Admin_BA_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
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
import Pages.Payment_Profile;
import Pages.ViewCoverage_Page;

public class FBMC_DeclineAllCoveragesFlow extends FBMC_Admin_BA_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	Payment_Profile Payment_Profile = new Payment_Profile();
	ViewCoverage_Page viewCoveragePage = new ViewCoverage_Page();

	// Add and Decline all coverages for Employee
	public void ValidateDeclineAllCoverages(String TestScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException, IOException {

		// Select Group
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
		employeePage.addPersonalInformation(testdata);
		// Add Dependent
		employeePage.addDependent(testdata);
		// Click on activateAndEnroll
		employeePage.activateAndEnroll();
		// Enter Effective Date
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		List<String> allPlans = enrollmentPage.getAllThePlans();
		enrollmentPage.declineAllCoverage();
		enrollmentPage.clickNext();
//		if (!testdata.get("Url").toString().contains("speridian")) {
//			enrollmentPage.clickNext();
//			Payment_Profile.addProfileWithPensionAuthority(false);
//		}
		if(testdata.get("PaymentMethod").toString().equalsIgnoreCase("ACH")) {
			Payment_Profile.addProfileWithACH(true, "Chase", "021300077", false);
		}
		else {
			Payment_Profile.addProfileWithPensionAuthority(true);
		}

		
		enrollmentPage.submitEnrollment();
		List<String> declinedPlans = viewCoveragePage.getAllDeclinedPlans();
		Assert.assertTrue(declinedPlans.size() >= ((ArrayList) allPlans).size() - 1);
	}
}
