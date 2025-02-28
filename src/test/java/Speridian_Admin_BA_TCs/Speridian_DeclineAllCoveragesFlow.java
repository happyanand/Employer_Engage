package Speridian_Admin_BA_TCs;

import java.awt.AWTException;
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
import Pages.ViewCoverage_Page;

public class Speridian_DeclineAllCoveragesFlow {

	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	ViewCoverage_Page viewCoveragePage = new ViewCoverage_Page();

	public void ValidateDeclineAllCoverages(String TestScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException {

		// Add and Decline All Coverages
		Home_Page.SelectGroupname(GroupName);
		Group_Page.clickEmployeeAdministration();
		employeeAdministration.clickAddEmployee();
		employeePage.addPersonalInformation(testdata);
		employeePage.activateAndEnroll();
		System.out.println("Effective date : " + testdata.get("EffectiveDate").toString());
		enrollmentPage.enterEffectiveDate(testdata.get("EffectiveDate").toString());
		List<String> allPlans = enrollmentPage.getAllThePlans();
		enrollmentPage.declineAllCoverage();
		// if(!testdata.get("Url").toString().contains("speridian")) {
		// enrollmentPage.clickNext();
		// enrollmentPage.addProfileWithPensionAuthority(false);
		// }
		enrollmentPage.submitEnrollment();
		List<String> declinedPlans = viewCoveragePage.getAllDeclinedPlans();
		Assert.assertTrue(declinedPlans.size() >= allPlans.size() - 1);
		
	}
}
