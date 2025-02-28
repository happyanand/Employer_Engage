package Speridian_Admin_BA_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import com.Utility.Log;

import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;

public class Speridian_SubmitEmployeeFlow {

	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration = new EmployeeAdministration_Page();
	Employee_Page employeePage = new Employee_Page();
	EmployeeInformation_Page employeeInformationPage = new EmployeeInformation_Page();
	GroupDashboard_Page groupPage = new GroupDashboard_Page();
	Enrollment_Page enrollmentPage = new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage = new EnrollmentSummary_Page();
	EmployeeInformation_Page empInfoPage = new EmployeeInformation_Page();

	public void ValidateSubmitEmployee(String TestScenario, String GroupName, Map<Object, Object> testdata)
			throws InterruptedException, AWTException, IOException {

		// Select Account name
		Home_Page.SelectGroupname(GroupName);
		// click Employee Administration
		Group_Page.clickEmployeeAdministration();
		// click Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Personal Information
		employeePage.addPersonalInformation(testdata);
		// Add Dependent
		employeePage.addDependent(testdata);

		if (testdata.get("BeneficiaryType").toString().equals("Person")) {
			// Add Person Beneficiary
			employeePage.addPersonBeneficiary(testdata);
		} else {
			// Add Trust Or Institution Beneficiary
			employeePage.addTrustOrInstitutionBeneficiary(testdata);
		}
		// employeePage.addAttachment(data.get("AttachmentPrivate"));
		// Add Notes
		employeePage.addNotes(testdata.get("NotesPrivate").toString());
		// Click On Submit
		employeePage.submit();
		String name = empInfoPage.getEmployeeName();
		Log.info("Employee name : " + name);
		// Customer Number Return
		String CustomerNo = enrollmentSummaryPage.CustomerNumberReturn();
		System.out.println("Customer no :" + CustomerNo);
		// Navigate To Group Dashboard
		groupPage.navigateToGroupDashboard();
		// click Employee Administration
		groupPage.clickEmployeeAdministration();
		// search Employee By Customer No.
		employeeAdministration.searchEmployee(CustomerNo);
		Thread.sleep(5000);
		Assert.assertTrue(name.toUpperCase().contains(employeeAdministration.getNameInGrid().toUpperCase()),"New Employee should be displayed in the grid");
		// Click On First Employee From Grid
		employeePage.ClickOnFirstEmployeeFromGrid();
		// Click On Edit
		employeePage.ClickonEdit();
		// activate
		employeePage.activate();
		// Button Found
		employeePage.ButtonFound();
	}
}
