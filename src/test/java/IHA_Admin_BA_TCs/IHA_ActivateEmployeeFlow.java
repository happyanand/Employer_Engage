package IHA_Admin_BA_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;

public class IHA_ActivateEmployeeFlow extends IHA_Admin_BA_AllScenarios 
{

	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
	Employee_Page employeePage=new Employee_Page();
	EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
	
	public void ValidateActivateEmployee(String TestScenario,String GroupName,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException
	{	
		//Select the Group Name
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Click on Add Employee
		employeeAdministration.clickAddEmployee();
		// Add Employee Personal Information
        String ssn = employeePage.addIHAPersonalInformation(testdata);
        //Add Dependent 
	    employeePage.addDependent(testdata);
	    //Add Notes
        employeePage.addNotes(testdata.get("NotesPrivate").toString());
        //Click on Activate Button
        employeePage.activate();
	}	
}