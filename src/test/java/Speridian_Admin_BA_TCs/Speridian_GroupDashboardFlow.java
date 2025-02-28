package Speridian_Admin_BA_TCs;

import Pages.GroupDashboard_Page;
import Pages.Home_Page;

public class Speridian_GroupDashboardFlow extends Speridian_Admin_BA_AllScenarios {
	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();

	public void ValidateAccountDashboardpage(String TestScenario, String GroupName) throws InterruptedException {
		// Select Group Name
		Home_Page.SelectGroupname(GroupName);
		// Click Employee Administration
		Group_Page.clickEmployeeAdministration();
		// Navigate To Group Dashboard
		Group_Page.navigateToGroupDashboard();
		// Click Group Information
		Group_Page.clickGroupInformation();
		// Navigate To Group Dashboard
		Group_Page.navigateToGroupDashboard();
		// Click Manage Coverage
		Group_Page.clickManageCoverage();
		// Navigate To Group Dashboard
		Group_Page.navigateToGroupDashboard();
		// Click Renewal Center
		Group_Page.clickRenewalCenter();
		// Navigate To Group Dashboard
		Group_Page.navigateToGroupDashboard();
		if (loginuser_Type.equalsIgnoreCase("Admin")) {
			// Click Reports
			Group_Page.clickReports();
			// Navigate To Group Dashboard
			Group_Page.navigateToGroupDashboard();
		}
		if (loginuser_Type.equalsIgnoreCase("BA")) {
			Group_Page.navigateToReviewEmployeeTransactions();
			Group_Page.navigateToGroupDashboard();
			Group_Page.ClickonReorting();
			Group_Page.navigateToGroupDashboard();
		}

	}
}
