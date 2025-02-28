package IHA_Content_Management;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import Pages.Banner_Page;
import Pages.ContentManagement_Page;
import Pages.CorrespondenceLetters_Page;
import Pages.Document_ContentManagement_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Pages_ContentManagement;
import Pages.SectionTitles_Page;

public class IHA_ContentManagement_Documents_AddwordDoc_Flow extends IHA_ContentManagement_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	ContentManagement_Page contentManagementPage = new ContentManagement_Page();
	Pages_ContentManagement pages= new Pages_ContentManagement();
	CorrespondenceLetters_Page CCLetterVerification=new CorrespondenceLetters_Page();
	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	Banner_Page bannerPage= new Banner_Page();
	SectionTitles_Page sectionTitlesPage = new SectionTitles_Page();
	Document_ContentManagement_Page documentsPage = new Document_ContentManagement_Page();
	
	public void ValidateIHA_ContentManagement_Documents_AddwordDoc_Flow(String testScenario,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException {

		//Click on ContentManagementTab
		Home_Page.CheckContentManagementTabDispaly();
		//Click on Section Title
		contentManagementPage.ClickOnsectionTitle();
		//Add Section Title
		sectionTitlesPage.ClickOnaddsectionTitle();
		//Enter Section Title Name		
		sectionTitlesPage.sectionTitleName();
		String titlename = sectionTitlesPage.title;
		//Enter Section Title Description
		sectionTitlesPage.sectionTitleDescription();
		//Click on Create Section Title
		sectionTitlesPage.ClickOnCreatesectionTitle();
		//Click on OK button
		sectionTitlesPage.ClickonOK();
		//Click on Documents
		contentManagementPage.ClickOndocuments();
	
		ExtentSuccessMessage("******************Add Document***************");
		///////// Add Document ///////// 
		//Click on Add Document
		documentsPage.ClickOnaddDocument();
		//Enter Document Name
		String doc_name = documentsPage.Entername();
		//Enter Visibility Date
		String date = CCLetterVerification.getCurrentDate();
		documentsPage.enterVisibilityFromDate(date);	
		
		//Select Existing Section Titles from dropdown
		documentsPage.selectDropdownValues(titlename, "Section Titles");	
		//Select Audience - Business Segment or Account		
		if(testdata.get("Account")!= "")
			documentsPage.selectDropdownValues(testdata.get("Account").toString(), "Account");
		else if(testdata.get("BusinessSegment")!= "")
			documentsPage.selectDropdownValues(testdata.get("BusinessSegment").toString(), "Business Segment");	
		//Select Documents
		sectionTitlesPage.selectwordDocs();		
		//Click on Add Document
		documentsPage.ClickOnAddDocument();
		//Click on OK
		bannerPage.ClickOnOk();
		//Search with Name
		documentsPage.search_Name(doc_name);
		//Validate Submitted Status
		bannerPage.validateStatus("Draft");
		
		ExtentSuccessMessage("******************Edit Document and Submit and Review***************");
		///////// Edit Document and Submit and Review ///////// 
		//Click on Edit Icon
		contentManagementPage.ClickOnedit();	
		//Enter Document Name
		String doc_name2 = documentsPage.Entername();
		//Click on Save
		documentsPage.ClickOnsave();
		//Click on OK
		bannerPage.ClickOnOk();
		//Search with Name
		documentsPage.search_Name(doc_name2);
		//Click on Edit Icon
		contentManagementPage.ClickOnedit();
		//Click on Submit
		pages.ClickOnSubmit();
		//Click on Yes
		documentsPage.clickonyes();
		//Click on OK
		bannerPage.ClickOnOk();
		//Search with Name
		documentsPage.search_Name(doc_name2);
		//Validate Submitted Status
		bannerPage.validateStatus("Submitted");
		// Click on Review
		contentManagementPage.ClickOnreview();
		//Search with Name
		contentManagementPage.search_Name(doc_name2);

		ExtentSuccessMessage("******************Edit Document and  assign back***************");
		///////// Edit Document and  assign back ///////// 
		//Click on Edit Icon
		contentManagementPage.ClickOnedit();
		//Click on Assign Back
		bannerPage.ClickOnassignback();
		//Click on Yes
		documentsPage.clickonyes();
		//Click on Documents
		contentManagementPage.ClickOndocuments();
		//Search with Name
		documentsPage.search_Name(doc_name2);
		//Validate Rejected Status
		bannerPage.validateStatus("Rejected");
		
		ExtentSuccessMessage("******************Edit Document and  Publish***************");
		 ///////// Edit Document and  Publish ///////// 
		//Click on Edit Icon
		contentManagementPage.ClickOnedit();
		//Click on Submit
		pages.ClickOnSubmit();
		//Click on Yes
		documentsPage.clickonyes();
		//Click on OK
		bannerPage.ClickOnOk();		
		
		//Click on Edit Icon
		contentManagementPage.ClickOnedit();
		//Click on Publish
		pages.ClickOnPublish();
		//Click on Yes
		documentsPage.clickonyes();
		//Click on OK
		bannerPage.ClickOnOk();		
		//Click on Close
		documentsPage.ClickOnClose();
		//Search with Name
		documentsPage.search_Name(doc_name2);
		
		//Validate Published Status
		bannerPage.validateStatus("Published");
		
		ExtentSuccessMessage("******************Make copy of document***************");
		///////// Make copy of document ///////// 
		//Click on Copy
		contentManagementPage.ClickOncopy();
		
		ExtentSuccessMessage("******************Delete document***************");
		///////// Delete document ///////// 
		// Click on Delete Icon
		contentManagementPage.ClickOnDocDelete();
		// Click on Yes
	//	contentManagementPage.ClickOnyes();	
		//Filter Audience
		contentManagementPage.FilterAudienceIHA();
		//Search Drop Down Verification
		//contentManagementPage.SearchDrpdownverification();	
		
		ExtentSuccessMessage("******************Export***************");
		///////// Export ///////// 
		//Click on Export Icon
		sectionTitlesPage.clickonExport();
		Thread.sleep(3000);
		assertEquals(GetFilesCountInDownloadDirectory(), 1);
	}
}
