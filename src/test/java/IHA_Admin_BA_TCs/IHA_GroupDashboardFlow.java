package IHA_Admin_BA_TCs;

import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Reports_Page;

public class IHA_GroupDashboardFlow extends IHA_Admin_BA_AllScenarios 
{
	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	Reports_Page reports=new Reports_Page();
	
	public void ValidateAccountDashboardpage(String TestScenario,String GroupName) throws InterruptedException
	{	
		//Select the group name from the list
		Home_Page.SelectGroupname(GroupName);
		//Click the Employee Administration Tab
		Group_Page.clickEmployeeAdministration();
		//Navigate to the Group Dashboard page
        Group_Page.navigateToGroupDashboard();
        //Click on the Group information Page
        Group_Page.clickGroupInformation();
        //Navigate to the Group Dashboard page
        Group_Page.navigateToGroupDashboard();
        //Click on the Manage Coverage
        Group_Page.clickManageCoverage();
        //Navigate to the Group Dashboard page
        Group_Page.navigateToGroupDashboard();
        //Click on the Reporting
        Group_Page.navigateToCarrierResponseUpdate();
        Group_Page.navigateToGroupDashboard();
        Group_Page.clickReporting();
        //Check if the reports are getting displayed or not.
        reports.isReportsPageDisplayed();
	}	
}