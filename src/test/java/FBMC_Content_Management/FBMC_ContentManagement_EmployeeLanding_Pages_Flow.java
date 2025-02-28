package FBMC_Content_Management;

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

public class FBMC_ContentManagement_EmployeeLanding_Pages_Flow extends FBMC_Content_Management_AllScenarios {
	
	Home_Page Home_Page = new Home_Page();
	ContentManagement_Page contentManagementPage = new ContentManagement_Page();
	SectionTitles_Page sectionTitlesPage = new SectionTitles_Page();
	Review_Page reviewPage = new Review_Page();
	Pages_ContentManagement pages= new Pages_ContentManagement();
	CorrespondenceLetters_Page CCLetterVerification=new CorrespondenceLetters_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	Document_ContentManagement_Page doc_page = new Document_ContentManagement_Page();
	
	public void ValidateFBMC_ContentManagement_EmployeeLanding_Pages_Flow(String testScenario,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException {

		//Click on ContentManagementTab
		Home_Page.CheckContentManagementTabDispaly();
		
		ExtentSuccessMessage("******************Landing Page Verification***************");
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
//		//Validate Notifications Page
		contentManagementPage.validateNotifications();
		//Click on Section Title
		contentManagementPage.ClickOnsectionTitle();
		//Validate Section Titles Page
		contentManagementPage.validateSectionTitles();
		
		ExtentSuccessMessage("********Add Section Title-New Document***Start*****");
		//Add Section Title-Add Existing Document	
		sectionTitlesPage.ClickOnaddsectionTitle();
		//Enter Section Title Name		
		sectionTitlesPage.sectionTitleName();
		String titlename = sectionTitlesPage.title;
		//Enter Section Title Description
		sectionTitlesPage.sectionTitleDescription();
		//Click on Add New Document
		sectionTitlesPage.ClickOnaddnewdocument();
		//Enter Document Name
		String doc_name = sectionTitlesPage.enterDocName();
		//Enter Visibility From Date
		String date = CCLetterVerification.getCurrentDate();
		sectionTitlesPage.enterVisibilityFromDate(date);
		//Select Audience - Business Segment or Account		
		if(testdata.get("Account")!= "")
			sectionTitlesPage.selectDropdownValues(testdata.get("Account").toString(), "Account");
		else if(testdata.get("BusinessSegment")!= "")
			sectionTitlesPage.selectDropdownValues(testdata.get("BusinessSegment").toString(), "Business Segment");	
		//Select Documents
		sectionTitlesPage.selectwordDocs();
		Thread.sleep(8000);		
		//Click on Create Section Title
		sectionTitlesPage.ClickOnCreatesectionTitle();
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		Thread.sleep(15000);
		//Click on OK button
		sectionTitlesPage.ClickonOK();
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		//Click on Documents
		contentManagementPage.ClickOndocuments();
		//Search Document Name
		contentManagementPage.search_Name(doc_name);
		//Click on Edit
		contentManagementPage.ClickOnedit();
		//Click on Submit
		doc_page.ClickOnSubmitIcon();
		//Click on Confirmation
		doc_page.Confirmation();
		//Click on Edit
		contentManagementPage.ClickOnedit();
		//Click on Publish
		doc_page.Publish();
		//Click on Confirmation
		doc_page.PublishConfirmation();
		//Click on OK button
		//sectionTitlesPage.ClickonOK();
		//Click on Close
		doc_page.ClickOnClose();
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
    	Group_Page.advancesearch(testdata);
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
		//Click on Preview
		contentManagementPage.ClickOnPreview();
		//Click on Delete
		contentManagementPage.ClickOnDelete();
		//Click on Yes
		contentManagementPage.ClickOnyes();
		///////// Export ///////// 
		//Click on Export Icon
		sectionTitlesPage.clickonExport();
		Thread.sleep(5000);
		assertEquals(GetFilesCountInDownloadDirectory(), 1);
		
		//Click on ContentManagementTab
		Home_Page.CheckContentManagementTabDispaly();
		ExtentSuccessMessage("******************Filter Audience***************");
		//Filter Audience
		contentManagementPage.FilterAudienceFBMC();
		//Search Drop Down Verification
		contentManagementPage.DocumentsSearchDrpdownverification();
	}
}