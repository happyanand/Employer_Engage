package Speridian_Content_Management_TCs;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.util.Map;

import Pages.ContentManagement_Page;
import Pages.CorrespondenceLetters_Page;
import Pages.Home_Page;
import Pages.SectionTitles_Page;

public class Speridian_ContentManagement_SectionTitle_Edit_AddExcel_Pdf_Flow extends Speridian_Content_Management_AllScenarios {
	
	Home_Page Home_Page = new Home_Page();
	ContentManagement_Page contentManagementPage = new ContentManagement_Page();
	SectionTitles_Page sectionTitlesPage = new SectionTitles_Page();
	CorrespondenceLetters_Page CCLetterVerification=new CorrespondenceLetters_Page();
	//Add Section Title with Excel doc, Assign Section Title, Edit, add pdf doc and Delete Section Title
	public void ValidateSperidian_ContentManagement_SectionTitle_Edit_AddExcel_Pdf_Flow(String testScenario,Map<Object, Object> testdata) throws InterruptedException, AWTException {
		
		//Click on ContentManagementTab
		Home_Page.CheckContentManagementTabDispaly();
		//Click on Section Title
		contentManagementPage.ClickOnsectionTitle();
		//Add Section Title-Add Existing Document
		ExtentSuccessMessage("********Add Section Title-Add Existing Document********");
		sectionTitlesPage.ClickOnaddsectionTitle();
		//Enter Section Title Name	
		Thread.sleep(1000);
		sectionTitlesPage.sectionTitleName();
		String titlename = sectionTitlesPage.title;
		//Enter Section Title Description
		sectionTitlesPage.sectionTitleDescription();
		//Click on Document CheckBox
		//sectionTitlesPage.ClickOnDocCheckbox("2");
		sectionTitlesPage.ClickOnaddnewdocument();
		//Enter Document Name
		sectionTitlesPage.enterDocName();
		//Enter Visibility From Date
		String Fdate = CCLetterVerification.getCurrentDate();
		sectionTitlesPage.enterVisibilityFromDate(Fdate);
		//Select Audience - Business Segment or Account		
		if(testdata.get("Account")!= "")
			sectionTitlesPage.selectDropdownValues(testdata.get("Account").toString(), "Account");
		else
		sectionTitlesPage.selectDropdownValues(testdata.get("BusinessSegment").toString(), "Business Segment");
		
		//Select Documents
		sectionTitlesPage.select_Excel();
		//Click on Create Section Title
		sectionTitlesPage.ClickOnCreatesectionTitle();
		//WaitForLoadAnimationDisappear();
		Thread.sleep(2000);
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
			sectionTitlesPage.selectDropdownValues(testdata.get("Account").toString(), "Account");
		else
		sectionTitlesPage.selectDropdownValues(testdata.get("BusinessSegment").toString(), "Business Segment");
		
		//Select Documents
		sectionTitlesPage.select_PDF();
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
		sectionTitlesPage.ClickOnDocCheckbox("6");
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
		Thread.sleep(3000);
		assertEquals(GetFilesCountInDownloadDirectory(), 1);
	}
}
