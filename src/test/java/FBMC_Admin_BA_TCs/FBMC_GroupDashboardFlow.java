package FBMC_Admin_BA_TCs;

import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Reports_Page;

public class FBMC_GroupDashboardFlow extends FBMC_Admin_BA_AllScenarios {
	Home_Page Home_Page = new Home_Page();
	GroupDashboard_Page Group_Page = new GroupDashboard_Page();
	Reports_Page reports = new Reports_Page();

	// Validates Group Dashboard page
	public void ValidateGroupDashboardpage(String TestScenario, String GroupName) throws InterruptedException {

		// Select Group
		Home_Page.SelectGroupname(GroupName);
		// Click on EmployeeAdministration tile
		Group_Page.clickEmployeeAdministration();
		// Navigate to GroupDashboard
		Group_Page.navigateToGroupDashboard();
		// Click on GroupInformation tile
		Group_Page.clickGroupInformation();
		Group_Page.navigateToGroupDashboard();
		// Click on ManageCoverage tile
		Group_Page.clickManageCoverage();
		Group_Page.navigateToGroupDashboard();
		if (loginuser_Type.equalsIgnoreCase("Admin")) {
			// Click on Reports tile
			Group_Page.clickReports();
		}
		if (loginuser_Type.equalsIgnoreCase("BA")) {
			// Click on Billingandpayment tile
			Group_Page.clickBillingandpayment();
			Group_Page.navigateToGroupDashboard();
		}
	}

}
