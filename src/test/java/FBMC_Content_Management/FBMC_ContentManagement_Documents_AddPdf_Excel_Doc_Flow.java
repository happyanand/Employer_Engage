package FBMC_Content_Management;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import Pages.Banner_Page;
import Pages.ContentManagement_Page;
import Pages.CorrespondenceLetters_Page;
import Pages.Document_ContentManagement_Page;
import Pages.Home_Page;
import Pages.Pages_ContentManagement;
import Pages.SectionTitles_Page;

public class FBMC_ContentManagement_Documents_AddPdf_Excel_Doc_Flow extends FBMC_Content_Management_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	ContentManagement_Page contentManagementPage = new ContentManagement_Page();
	SectionTitles_Page sectionTitlesPage = new SectionTitles_Page();
	CorrespondenceLetters_Page CCLetterVerification=new CorrespondenceLetters_Page();
	Document_ContentManagement_Page documentsPage = new Document_ContentManagement_Page();
	Pages_ContentManagement pages= new Pages_ContentManagement();
	Banner_Page bannerPage= new Banner_Page();
	
	public void ValidateFBMC_ContentManagement_Documents_AddPdf_Excel_Doc_Flow(String testScenario,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException {

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
		sectionTitlesPage.select_PDF();	
		//Click on Add Document
		documentsPage.ClickOnAddDocument();
		//Click on OK
		bannerPage.ClickOnOk();
		//Search with Name
		documentsPage.search_Name(doc_name);
		//Validate Submitted Status
		bannerPage.validateStatus("Draft");
		
		ExtentSuccessMessage("******************Edit Document and Submit***************");
		///////// Edit Document and Submit///////// 
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

		ExtentSuccessMessage("******************Edit Document and  Publish***************");
		 ///////// Edit Document and  Publish ///////// 
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
		//Click on Edit Icon
		contentManagementPage.ClickOnedit2();
		//Enter Document Name
		String doc_name3 = documentsPage.Entername();
		//Click on Delete Icon
		documentsPage.ClickOnDelete();
		//Select Documents
		sectionTitlesPage.select_Excel();	
		//Click on Submit
		pages.ClickOnSubmit();
		//Click on Yes
		documentsPage.clickonyes();
		//Click on OK
		bannerPage.ClickOnOk();
		//Search with Name
		documentsPage.search_Name(doc_name3);
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
	}
}
