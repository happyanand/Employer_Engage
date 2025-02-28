package IHA_Content_Management;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import Pages.ContentManagement_Page;
import Pages.CorrespondenceLetters_Page;
import Pages.Document_ContentManagement_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Pages_ContentManagement;
import Pages.Review_Page;
import Pages.SectionTitles_Page;

public class IHA_ContentManagement_EmployeeLanding_Pages_Flow extends IHA_ContentManagement_AllScenarios{


	Home_Page Home_Page = new Home_Page();
	ContentManagement_Page contentManagementPage = new ContentManagement_Page();
	SectionTitles_Page sectionTitlesPage = new SectionTitles_Page();
	Review_Page reviewPage = new Review_Page();
	Pages_ContentManagement pages= new Pages_ContentManagement();
	CorrespondenceLetters_Page CCLetterVerification=new CorrespondenceLetters_Page();
	Document_ContentManagement_Page doc_page = new Document_ContentManagement_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();

	public void ValidateIHA_ContentManagement_EmployeeLanding_Pages_Flow(String testScenario,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException {
		//Click on ContentManagementTab
		Home_Page.CheckContentManagementTabDispaly();

		///////// Landing Page Verification ///////// 
		//Click on Review
		contentManagementPage.ClickOnreview();
		//Validate Review Page
		contentManagementPage.validateReview();
		//Click on Documents
		contentManagementPage.ClickOndocuments();
		//Validate Documents Page
		contentManagementPage.validateDocuments();
		//Click on Banner
		contentManagementPage.ClickOnbanner();
		//Validate Banner Page
		contentManagementPage.validateBanner();
		//Click on Images
		contentManagementPage.ClickOnImage();
		//Validate Images Page
		contentManagementPage.validateImages();
		//Click on Notifications
		contentManagementPage.ClickOnnotifications();
		//Validate Notifications Page
		contentManagementPage.validateNotifications();

		//Click on Section Title
		contentManagementPage.ClickOnsectionTitle();
		//Validate Section Titles Page
		ExtentSuccessMessage("********Add Section Title-New Document***Start*****");
		contentManagementPage.validateSectionTitles();
		//Add Section Title-Add Existing Document

		sectionTitlesPage.ClickOnaddsectionTitle();
		//Enter Section Title Name		
		sectionTitlesPage.sectionTitleName();
		String titlename = sectionTitlesPage.title;
		//Enter Section Title Description
		sectionTitlesPage.sectionTitleDescription();
		//Click on Document CheckBox
		//sectionTitlesPage.ClickOnDocCheckbox("2");
		//Click on Add New Document
		sectionTitlesPage.ClickOnaddnewdocument();
		//Enter Document Name
		sectionTitlesPage.enterDocName();
		//Enter Visibility From Date
		String date = CCLetterVerification.getCurrentDate();
		sectionTitlesPage.enterVisibilityFromDate(date);
		//Select Audience - Business Segment or Account		
		if(testdata.get("Account")!= "")
			sectionTitlesPage.selectAudienceAccount(testdata.get("Account").toString());
		else
			sectionTitlesPage.selectAudienceBusinessSegment(testdata.get("BusinessSegment").toString());

		//Select Documents
		sectionTitlesPage.selectwordDocs();
		WaitForLoadAnimationDisappear();
		Thread.sleep(2000);
		//Click on Update Section Title
		//Click on Create Section Title
		sectionTitlesPage.ClickOnCreatesectionTitle();
		WaitForLoadAnimationDisappear();
		Thread.sleep(2000);
		WaitForLoadAnimationDisappear();
		//Click on OK button
		sectionTitlesPage.ClickonOK();
		WaitForLoadAnimationDisappear();
		//Click on Documents
		contentManagementPage.ClickOndocuments();
		contentManagementPage.search_Name(titlename);
		contentManagementPage.ClickOnedit();
		Thread.sleep(1000);
		doc_page.ClickOnSubmitIcon();
		Thread.sleep(2000);
		doc_page.Confirmation(); 
		contentManagementPage.ClickOnedit();
		doc_page.Publish();
		WaitForLoadAnimationDisappear();
		doc_page.PublishConfirmation();
		ExtentSuccessMessage("********Add Section Title-New Document***End*****");

		//Click on Pages
		contentManagementPage.ClickOnpages();
		//Validate Pages
		contentManagementPage.validatePages();


		ExtentSuccessMessage("******************Adding Page***************");
		///////// Adding Page ///////// 	
		//Click on Add Page
		pages.ClickOnAddPage();
		//Enter Name
		pages.Entername();
		String date1 = CCLetterVerification.getCurrentDate();
		//Enter Visibility From Date
		pages.enterVisibilityFromDate(date1);
		//Select Page Type
		pages.selectpagetype(testdata.get("Pagetype").toString());
		//Select Audience - Business Segment or Account		
		if(testdata.get("Account")!= "")
			sectionTitlesPage.selectAudienceAccount(testdata.get("Account").toString());
		else if(testdata.get("BusinessSegment")!= "")
		sectionTitlesPage.selectAudienceBusinessSegment(testdata.get("BusinessSegment").toString());
		//Click on Select Template
		pages.selectTemplate();
		//Click on Create Page
		pages.ClickOnCreatePage();
		//Click on Save
		pages.ClickOnSave();
		//Click on Ok
		pages.ClickOnOk();
		//Enter Header Text
		pages.Addyourtext(1,"Header");
		String TilesNaemlist=pages.FetchTilesName();
		String TilesArray[] = TilesNaemlist.split(",");
		System.out.println("Lenght" +TilesArray.length);
		//Click on Add Content
		pages.ClickOnAddcontent();
		//Click on ADD
		pages.ClickOnAdd();
		//Enter Rich Text
		pages.Addyourtext(2,"Rich Text");
		//Click on Add Content
//		pages.ClickOnAddcontent();
		//Click on Image
		pages.ClickOnImage();
		//Click on ADD
//		pages.ClickOnAdd();
		//Click on Browse
		pages.ClickOnBrowse();
		// Searching Background Image
		pages.SearchingBackgroundImage(testdata.get("BackgroundImageName").toString());
		//Add Image
		//pages.Addimage();
//		pages.ClickOnUpload();
//		sectionTitlesPage.UploadImage();
//		sectionTitlesPage.UploadImageConfirmation();
		//Click on Ok
		pages.ClickOk();
		//Click on Add Content
		pages.ClickOnAddcontent();
		//Click on Document
		pages.ClickOndocument();
		//Click on ADD
		pages.ClickOnAdd();
		//Click on Browse
		pages.ClickOnBrowse();
		pages.search_Name(titlename);
		Thread.sleep(1000);
		//Add Document
		pages.Selectdocument();
		//Click on Ok
		pages.ClickOk();
		//Click on Close
		pages.ClickOnClose();
		//Click on Add Content
//		pages.ClickOnAddcontent();
//		//Click on Links
//		pages.ClickOnLinks();
//		//Click on ADD
//		pages.ClickOnAdd();
//		//Enter Title
//		pages.AddTitle("Content Management");
//		//Enter Text
//		pages.AddText("Pages");
//		//Enter URL
//		pages.Addurl(testdata.get("URL").toString());
		//Click on Save
		pages.ClickOnSave();
		//Click on Ok
		pages.ClickOnOk();
		//Click on Preview
		pages.ClickOnPreview();
		//Validate Preview Page
		pages.validatePreview();
		//Click on Submit
		pages.ClickOnSubmit();
		//Click on Ok
		pages.ClickOnOk();
		//Validate Pages
		contentManagementPage.validatePages();
		//Search with Name
		contentManagementPage.search_Name(pages.name);
		//Validate Page Name
		contentManagementPage.validatePageName(pages.name);
		//Click on Edit Icon
		contentManagementPage.ClickOnedit();
		//Click on Publish
		pages.ClickOnPublish();
		//Validate Published Status
		contentManagementPage.validatePublished(pages.name,"Published");
		//Validate Pages
		contentManagementPage.validatePages();
		
		ExtentSuccessMessage("******************Verification of Pages***************");
		///////// Verification of Pages ///////// 	
		//Login with Support User
		Group_Page.clickMore();
		Group_Page.supportUserLogin();
		//Search with Advance
		Group_Page.advancesearchIHA(testdata);
		//Validate Header Text
		Group_Page.validateHeader();
		pages.ValidateTilesName(TilesNaemlist,TilesArray.length);
		String Value =pages.ValidatingBackgroundimage();
		//Validate Rich Text
		Group_Page.validateRichtext();
		//Validate Link Title
		Group_Page.validateLinkTitle();
		//Verify the page changes
		Group_Page.verifypages();
		//Logout User
		Group_Page.Logout1();
		//Click on ContentManagementTab
		Home_Page.CheckContentManagementTabDispaly();
		//Validate Pages
		contentManagementPage.validatePages();
		//Search with Name
		contentManagementPage.search_Name(pages.name);
		//Click on Unpublish
		contentManagementPage.ClickOnUnpublish();
		//Click on Yes
		contentManagementPage.ClickOnyes();
		//Validate UnPublished Status
		contentManagementPage.validateUnPublished(pages.name,"UnPublished");
		//Click on Copy
		contentManagementPage.ClickOncopy();
		//Validate Draft Status
		contentManagementPage.validateDraft();

		///////// Export ///////// 
		//Click on Export Icon
		sectionTitlesPage.clickonExport();
		Thread.sleep(3000);
		assertEquals(GetFilesCountInDownloadDirectory(), 1);

	}

}
