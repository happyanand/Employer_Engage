package FBMC_Admin_BA_TCs;

import java.io.IOException;
import java.util.Map;

import Pages.Home_Page;

public class FBMC_TenantDashboardFlow extends FBMC_Admin_BA_AllScenarios {
	Home_Page Home_Page = new Home_Page();

//Validates Tenant Dashboard
	public void ValidateTenantDashboard(String TestScenario, Map<Object, Object> testdata) throws InterruptedException, IOException {
		Home_Page.ValidateTenantDashboard(testdata.get("GroupName").toString());
	}
}