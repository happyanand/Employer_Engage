package FBMC_Content_Management;

import static org.testng.Assert.assertEquals;
import java.awt.AWTException;
import java.util.Map;

import Pages.Home_Page;
import Pages.ContentManagement_Page;
import Pages.CorrespondenceLetters_Page;
import Pages.SectionTitles_Page;

public class FBMC_ContentManagement_SectionTitle_Edit_AddWorddoc_Flow extends FBMC_Content_Management_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	ContentManagement_Page contentManagementPage = new ContentManagement_Page();
	SectionTitles_Page sectionTitlesPage = new SectionTitles_Page();
	CorrespondenceLetters_Page CCLetterVerification=new CorrespondenceLetters_Page();
	
	//Add Section Title, Assign Section Title, Edit, add Worddoc and Delete Section Title
	public void ValidateFBMC_ContentManagement_SectionTitle_Edit_AddWorddoc_Flow(String testScenario,Map<Object, Object> testdata) throws InterruptedException, AWTException {
		
		//Click on ContentManagementTab
		Home_Page.CheckContentManagementTabDispaly();
		//Click on Section Title
		contentManagementPage.ClickOnsectionTitle();
		//Add Section Title-Add Existing Document
		ExtentSuccessMessage("********Add Section Title-Add Existing Document********");
		sectionTitlesPage.ClickOnaddsectionTitle();
		//Enter Section Title Name		
		sectionTitlesPage.sectionTitleName();
		String titlename = sectionTitlesPage.title;
		//Enter Section Title Description
		sectionTitlesPage.sectionTitleDescription();
		//Click on Document CheckBox
		sectionTitlesPage.ClickOnDocCheckboxAsPerStatus("Published");
		//Click on Create Section Title
		sectionTitlesPage.ClickOnCreatesectionTitle();
		//Click on OK button
		sectionTitlesPage.ClickonOK();
		//Search with Name
		contentManagementPage.search_Name(titlename);
		//Validate Documents Assigned
		contentManagementPage.validatedocument("1");
		
		///////// Edit Section Title by choosing Add New Document /////////
		ExtentSuccessMessage("********Edit Section Title by choosing Add New Document ********");
		contentManagementPage.ClickOnedit();
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
		//Click on Update Section Title
		sectionTitlesPage.ClickonUpdateSectionTitle();
		//Click on Yes and OK button
		sectionTitlesPage.ClickonOK();
		//Validate Documents Assigned
		contentManagementPage.validatedocument("2");
		//Click on Document Assigned
		contentManagementPage.clickondocumentassigned();
		
		
		/////////  Relation will be removed from the Section title ///////// 
		ExtentSuccessMessage("********Relation will be removed from the Section title********");
		sectionTitlesPage.clickonRemoveRelation();
		//Click on Yes and OK button
		sectionTitlesPage.clickonYes_OK();
		
		/////////  Add Document Section Title /////////
		ExtentSuccessMessage("********Add Document Section Title********");
		//Click on Add Document
		sectionTitlesPage.ClickOnadddocument();
		//Click on Document CheckBox
		sectionTitlesPage.ClickOnDocCheckboxAsPerStatus("Published");
		//Click on Add Document Button
		sectionTitlesPage.ClickOnCreatesectionTitle();
		//Click on OK button
		sectionTitlesPage.ClickonOK();
		
		/////////  Delete Section Title /////////  
		ExtentSuccessMessage("********Delete Section Title********");
		//Clicked on Back Button
		sectionTitlesPage.clickonBack();
		//Click on Delete
		contentManagementPage.ClickOnDelete();		
		//Click on Yes and OK button
		sectionTitlesPage.clickonyes_OK();
		///////// Export ///////// 
		ExtentSuccessMessage("********Export********");
		//Click on Export Icon
		sectionTitlesPage.clickonExport();
		Thread.sleep(5000);
		assertEquals(GetFilesCountInDownloadDirectory(), 1);
	}
}
