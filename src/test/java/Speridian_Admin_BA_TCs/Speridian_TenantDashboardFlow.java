package Speridian_Admin_BA_TCs;
import java.io.IOException;

import Pages.Home_Page;

public class Speridian_TenantDashboardFlow extends Speridian_Admin_BA_AllScenarios 
{

	Home_Page Home_Page=new Home_Page();
	
	public void ValidateTenantDashboardpage(String TestScenario, String Groupname) throws InterruptedException, IOException
	{
		// Validate Tenant Dashboard
	  Home_Page.ValidateTenantDashboard(Groupname);
    }
}