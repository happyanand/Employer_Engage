package FBMC_Content_Management;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import Pages.Banner_Page;
import Pages.ContentManagement_Page;
import Pages.CorrespondenceLetters_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.SectionTitles_Page;
import Pages.ViewCoverage_Page;

public class FBMC_ContentManagement_Employee_Banner_Flow extends FBMC_Content_Management_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	ContentManagement_Page contentManagementPage = new ContentManagement_Page();
	CorrespondenceLetters_Page CCLetterVerification=new CorrespondenceLetters_Page();
	SectionTitles_Page sectionTitlesPage = new SectionTitles_Page();
	Banner_Page bannerPage= new Banner_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
	
	//	Banner- addBanner, Edit Banner,Publish, unPublish, Preview, Export and Delete
	public void ValidateFBMC_ContentManagement_Employee_Banner_Flow(String testScenario,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException {

		
		//Click on ContentManagementTab
		Home_Page.CheckContentManagementTabDispaly();
	
		ExtentSuccessMessage("******************Add Banner***************");
		///////// Add Banner /////////
		//Click on Banner
		contentManagementPage.ClickOnbanner();
		//Click on Add Banner
		bannerPage.ClickOnaddBanner();
		//Enter Banner Name
		String bannername = bannerPage.Entername();
		//Enter Banner Description
		bannerPage.addDescription();
		//Enter Visibility Start Date
		String date = CCLetterVerification.getCurrentDate();
		bannerPage.enterVisibilityFromDate(date);	
		//Select Audience - Business Segment or Account		
		if(testdata.get("Account")!= "")
			sectionTitlesPage.selectDropdownValues(testdata.get("Account").toString(), "Account");
		else if(testdata.get("BusinessSegment")!= "")
			sectionTitlesPage.selectDropdownValues(testdata.get("BusinessSegment").toString(), "Business Segment");	
		//Select Role
		bannerPage.selectrole(testdata.get("Role").toString());
		//Select Page 
		bannerPage.selectpage(testdata.get("Pages").toString());
		//Add Alert message
		String altmsg=bannerPage.addAlertmessage("Banner Alert");
		//Click on Preview
		bannerPage.ClickOnPreview();
		//Switch Tab
		bannerPage.switchTab();
		//Click on Submit
		bannerPage.ClickOnSubmit();
		//Click on Ok
		bannerPage.ClickOnOk();
		//Validate Submitted Status
		bannerPage.validateStatus("Submitted");
		
		ExtentSuccessMessage("******************Review verification***************");		
		///////// Review verification /////////
		// Click on Review
		contentManagementPage.ClickOnreview();
		//Search with Name
		contentManagementPage.search_Name(bannername);
		
		ExtentSuccessMessage("******************Assign back***************");
		///////// Assign back /////////
		//Click on Edit Icon
		contentManagementPage.ClickOnedit();
		//Click on Assign Back
		bannerPage.ClickOnassignback();
		//Click on Rejected Yes
		bannerPage.ClickOnyes("Rejected");
		//Click on Ok
		bannerPage.ClickOnOk();
		//Click on Banner
		contentManagementPage.ClickOnbanner();
		//Search with Name
		contentManagementPage.search_Name(bannername);
		//Validate Rejected Status
		bannerPage.validateStatus("Rejected");
		//Click on Edit Icon
		contentManagementPage.ClickOnedit();
		//Click on Submit
		bannerPage.ClickOnSubmit();
		//Click on Ok
		bannerPage.ClickOnOk();
		//Click on Edit Icon
		contentManagementPage.ClickOnedit();
		//Click on Publish
		bannerPage.ClickOnPublish();
		//Click on Published Yes
		bannerPage.ClickOnyes("Published");
		//Click on Ok
		bannerPage.ClickOnOk();
		//Validate Published Status
		bannerPage.validateStatus("Published");
		
		ExtentSuccessMessage("******************Verification of Banner***************");
		///////// Verification of Banner ///////// 
    	//Login with Support User
    	Group_Page.clickMore();
    	Group_Page.supportUserLogin();
    	//Search with Advance
    	Group_Page.advancesearch(testdata);
		//click profile
		ViewCoverage_Page.click_profile();    	
    	//Validate Banner Alert
    	Group_Page.validatealertmsg(altmsg);
    	//Logout User
		Group_Page.Logout1();
		//Click on ContentManagementTab
		Home_Page.CheckContentManagementTabDispaly();
		//Click on Banner
		contentManagementPage.ClickOnbanner();
		//Search with Name
		contentManagementPage.search_Name(bannername);
		
		ExtentSuccessMessage("******************UnPublish Banner***************");
		 /////////  UnPublish Banner ///////// 
		//Click on Edit Icon
		contentManagementPage.ClickOnedit();
		//Click on Unpublish
		contentManagementPage.ClickOnUnpublish();
		//Click on Yes
		//contentManagementPage.ClickOnyes();
		//Click on close
		bannerPage.ClickOnClose();
		//Validate Unpublished Status
		bannerPage.validateStatus("UnPublished");
		//Click on ContentManagementTab
		Home_Page.CheckContentManagementTabDispaly();
		//Click on Banner
		contentManagementPage.ClickOnbanner();
		//Click on Add Banner
		//Search with Name
		contentManagementPage.search_Name(bannername);
		//Click on Delete
		contentManagementPage.ClickOnDelete();
		//Click on Yes
		contentManagementPage.ClickOnyes();
		//Validate Banner
		bannerPage.validaterecord();
	}
}
