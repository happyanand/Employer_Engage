package FBMC_BillingAndPayments;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import Pages.Home_Page;
import Pages.Pension_Authority_File_Generation;
import Pages.VendorACHFileGeneration;

public class BillPay_PensionAuthority_VendorACH_Reconciliation  extends FBMC_BillingAndPayments_AllScenarios  {

	Home_Page Home_Page = new Home_Page();
	Pension_Authority_File_Generation Pension_Authority_File_Generation = new Pension_Authority_File_Generation();
	VendorACHFileGeneration VendorACHFileGeneration = new VendorACHFileGeneration();


	public void ValidateBillPay_PensionAuthority_VendorACH_Reconciliation(String TestScenario,Map<Object, Object> testdata) throws InterruptedException {
		String PensionfilesList =testdata.get("Pension_files_List").toString();

		ExtentSuccessMessage("****Pension Authority File Generation****");
		String Vals[] =PensionfilesList.split(",");
		for(int i =0; i<Vals.length; i++) {
			Home_Page.NavigateToPension_Authority_File_GenerationTab();
			Pension_Authority_File_Generation.SelectDropwnAndDownloadFile(Vals[i]);
		}
		
		ExtentSuccessMessage("****Vendor ACH File Generation****");
		Home_Page.NavigateToVendorACHFileGenerationTab();
		String Date=VendorACHFileGeneration.LastMonthDate();
		System.out.println("Date:- "+Date);
		VendorACHFileGeneration.EnterSubmissionDate(Date);
		Thread.sleep(2000);
		VendorACHFileGeneration.EnterSettlementDate(Date);
		VendorACHFileGeneration.clickOnGenerateButton();
		Thread.sleep(8000);
		assertEquals(GetFilesCountInDownloadDirectory(), 1);
		DeleteFiles(Base_Class.DownloadDirectory);

		ExtentSuccessMessage("****Reconciliation Summary****");
		Home_Page.NavigateToReconciliation_SummaryTab();

	}
}