package IHA_Admin_BA_TCs;

import java.io.IOException;
import java.util.Map;

import Pages.Home_Page;

public class IHA_TenantDashboardFlow extends IHA_Admin_BA_AllScenarios 
{
	Home_Page Home_Page=new Home_Page();

	public void ValidateTenantDashboardpage(String TestScenario,Map<Object, Object> testdata) throws InterruptedException, IOException
	{
	  //Validate the Tenant Dashboard Page
	  Home_Page.ValidateTenantDashboard(testdata.get("AccountName").toString());
    }
}
