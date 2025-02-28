package FBMC_Admin_BA_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;

public class FBMC_SubmitEmployeeFlow extends FBMC_Admin_BA_AllScenarios {
	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();

//Validates Submit Employee
	public void ValidateSubmitEmployee(String TestScenario, String GroupName, Map<Object, Object> testdata)
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
		// Add Notes
		employeePage.addNotes(testdata.get("NotesPrivate").toString());
		employeePage.submit();
		String name = employeeInformationPage.getEmployeeName();
		// Customer Number Return
		String CustomerNo = enrollmentSummaryPage.CustomerNumberReturn();
		Group_Page.navigateToGroupDashboard();
		Group_Page.clickEmployeeAdministration();
		// search Employee By Customer No.
		employeeAdministration.searchEmployee(CustomerNo);
		Assert.assertTrue(name.toUpperCase().contains(employeeAdministration.getNameInGrid().toUpperCase()),
				"New Employee should be displayed in the grid");
	}
}
