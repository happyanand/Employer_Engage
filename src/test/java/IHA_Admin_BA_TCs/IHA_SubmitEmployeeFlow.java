package IHA_Admin_BA_TCs;

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

public class IHA_SubmitEmployeeFlow extends IHA_Admin_BA_AllScenarios 
{	
	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	Enrollment_Page enrollmentPage=new Enrollment_Page();
	EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();

	public void ValidateSubmitEmployee(String TestScenario,String GroupName,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException
	{
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
        String  result = employeePage.addIHAPersonalInformation(testdata);
        String[] values = result.split(",");	
		String ssn = values[0];
		String lastname = values[1];
        //Add Dependent 
	    employeePage.addDependent(testdata);
	    //Add Notes
        employeePage.addNotes(testdata.get("NotesPrivate").toString());
        //Click on Submit Button
        employeePage.submit();
        //Get the Employee Name
        String name=employeeInformationPage.getEmployeeName();
        //Navigate to the Group Dashboard
        Group_Page.navigateToGroupDashboard();
        //Click on Employee Administration Tile
        Group_Page.clickEmployeeAdministration();
        //Search for the Employee
        employeeAdministration.searchEmployee(ssn);
        //Verify if the Name is displayed or not
        Assert.assertTrue(name.toUpperCase().contains(employeeAdministration.getNameInGrid().toUpperCase()),"New Employee should be displayed in the grid");
	}
}
