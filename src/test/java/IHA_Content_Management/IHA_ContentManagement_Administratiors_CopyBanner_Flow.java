package IHA_Content_Management;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;
import FBMC_Content_Management.FBMC_Content_Management_AllScenarios;
import Pages.Banner_Page;
import Pages.ContentManagement_Page;
import Pages.CorrespondenceLetters_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.SectionTitles_Page;



public class IHA_ContentManagement_Administratiors_CopyBanner_Flow extends IHA_ContentManagement_AllScenarios {


	Home_Page Home_Page = new Home_Page();
	ContentManagement_Page contentManagementPage = new ContentManagement_Page();
	SectionTitles_Page sectionTitlesPage = new SectionTitles_Page();
	CorrespondenceLetters_Page CCLetterVerification=new CorrespondenceLetters_Page();
	Banner_Page bannerPage= new Banner_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();


	public void ValidateIHA_ContentManagement_Administratiors_CopyBanner_Flow(String testScenario,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException {

		//Click on ContentManagementTab
		Home_Page.CheckContentManagementTabDispaly();

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
			sectionTitlesPage.selectAudienceAccount(testdata.get("Account").toString());
		else if(testdata.get("BusinessSegment")!= "")
			sectionTitlesPage.selectAudienceBusinessSegment(testdata.get("BusinessSegment").toString());
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

		///////// Review verification /////////
		// Click on Review
		contentManagementPage.ClickOnreview();
		//Search with Name
		contentManagementPage.search_Name(bannername);

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

		///////// Verification of Banner ///////// 
		//Login with Support User
		Group_Page.clickMore();
		Group_Page.supportUserLogin();
		//Search with Advance
		Group_Page.advancesearch(testdata);
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

		/////////  UnPublish Banner  ///////// 
		//Click on Edit Icon
		contentManagementPage.ClickOnedit();
		//Click on Unpublish
		contentManagementPage.ClickOnUnpublish();
		// Click on Yes
		contentManagementPage.ClickOnyes();
		//Click on close
		bannerPage.ClickOnClose();
		//Validate Unpublished Status
		bannerPage.validateStatus("UnPublished");

		///////// Copy Banner ///////// 
		//Click on Copy
		contentManagementPage.ClickOncopy();
		//Validate Draft Status
		bannerPage.validateStatus("Draft");
		//Click on Edit Icon
		contentManagementPage.ClickOnedit2();
		//Add Alert message
		String alrtmsg=bannerPage.addAlertmessage(" Dashbord page");
		//Click on Submit
		bannerPage.ClickOnSubmit();
		//Click on Ok
		bannerPage.ClickOnOk();
		//Click on Edit Icon
		contentManagementPage.ClickOnedit2();
		//Click on Publish
		bannerPage.ClickOnPublish();
		//Click on Published Yes
		bannerPage.ClickOnyes("Published");
		//Click on Ok
		bannerPage.ClickOnOk();

		///////// Preview Banner ///////// 
		//Click on Preview
		contentManagementPage.ClickOnPreview();

		///////// Verification of Banner ///////// 
		//Login with Support User
		Group_Page.clickMore();
		Group_Page.supportUserLogin();
		//Search with Advance
		Group_Page.advancesearch(testdata);
		//Validate Banner Alert
		Group_Page.validatealertmsg(altmsg+alrtmsg);
		//Logout User
		Group_Page.Logout1();

		///////// Delete Banner ///////// 
		//Click on ContentManagementTab
		Home_Page.CheckContentManagementTabDispaly();
		//Click on Banner
		contentManagementPage.ClickOnbanner();
		//Search with Name
		contentManagementPage.search_Name(bannername);
		// Click on Delete Icon
		contentManagementPage.ClickOnDelete();
		// Click on Yes
		contentManagementPage.ClickOnyes();

		///////// Export ///////// 
		//Click on Export Icon
		sectionTitlesPage.clickonExport();
		Thread.sleep(8000);
		assertEquals(GetFilesCountInDownloadDirectory(), 1);

		//Click on ContentManagementTab
		Home_Page.CheckContentManagementTabDispaly();
		//Click on Banner
		contentManagementPage.ClickOnbanner();
		//Search with Name
		contentManagementPage.search_Name(bannername);
		//Filter Audience
//		contentManagementPage.FilterAudienceIHA();
		bannerPage.FilterAudienceFBMC();
		//Search Drop Down Verification
		bannerPage.SearchDrpdownverification();		
	}

}

