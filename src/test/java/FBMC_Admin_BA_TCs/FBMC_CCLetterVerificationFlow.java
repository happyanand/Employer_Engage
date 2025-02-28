package FBMC_Admin_BA_TCs;

import org.testng.Assert;

import com.Utility.Log;

import FBMC_Admin_BA_TCs.FBMC_Admin_BA_AllScenarios;
import Pages.CorrespondenceLetters_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;

public class FBMC_CCLetterVerificationFlow extends FBMC_Admin_BA_AllScenarios {
	
	Home_Page Home_Page=new Home_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	CorrespondenceLetters_Page CCLetterVerification=new CorrespondenceLetters_Page();
	
	//Validate CC Letters
	public void ValidateCCLetterVerification(String TestScenario, String GroupName) throws InterruptedException {
		if (!loginuser_Type.equalsIgnoreCase("BA")) {
		//Click on the Communication Tab
		Home_Page.clickCommunicationTab();
		//Click on the Correspondence Letters
		Home_Page.clickCorrespondenceLetters();
        //Select the Correspondence type
        CCLetterVerification.selectCTALLstatus();
        // Select the Status
        CCLetterVerification.selectASALLstatus();
        //Click on the document corresponding to an employee
        CCLetterVerification.clickDocument();
        //Verify if the file is downloaded
        //Assert.assertTrue(isDownloadedFileExist());
        }
		else {
			Log.info("Communication Tab is not applicable for Logged in User");
			ExtentSuccessMessage("Communication Tab is not applicable for Logged in User");
		}
	}
}
