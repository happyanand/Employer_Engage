package IHA_Content_Management;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import Pages.ContentManagement_Page;
import Pages.CorrespondenceLetters_Page;
import Pages.CreateYourAccount;
import Pages.EmailLogs;
import Pages.GroupContactUser_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.LoginHistory_Page;
import Pages.Login_Page;
import Pages.Review_Page;
import Pages.SectionTitles_Page;

public class IHA_ContentManagement_SectionTitle_Edit_AddExcel_Pdf_Flow extends IHA_ContentManagement_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	ContentManagement_Page contentManagementPage = new ContentManagement_Page();
	SectionTitles_Page sectionTitlesPage = new SectionTitles_Page();
	CorrespondenceLetters_Page CCLetterVerification=new CorrespondenceLetters_Page();

	public void ValidateIHA_ContentManagement_SectionTitle_Edit_AddExcel_Pdf_Flow(String testScenario,Map<Object, Object> testdata) throws InterruptedException, AWTException {
		//Click on Content Management
		Home_Page.CheckContentManagementTabDispaly();
		//Click on Section titles
		contentManagementPage.ClickOnsectionTitle();
		//***********Add Section Title-Add Existing Document ***********		
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

		ExtentSuccessMessage("Edit Section Title by choosing Add New Document ");
		contentManagementPage.ClickOnedit();
		//Click on Add New Document
		sectionTitlesPage.ClickOnaddnewdocument();
		//Enter Document Name
		sectionTitlesPage.enterDocName();
		//Enter Visibility From Date
		String date = CCLetterVerification.getCurrentDate();
		sectionTitlesPage.enterVisibilityFromDate(date);
		//Select PDF
		sectionTitlesPage.select_PDF();	
		//Select Audience - Business Segment or Account		
		if(testdata.get("Account")!= "")
			sectionTitlesPage.selectAudienceAccount(testdata.get("Account").toString());
		else
			sectionTitlesPage.selectAudienceBusinessSegment(testdata.get("BusinessSegment").toString());	

		//Click on Update Section Title
		sectionTitlesPage.ClickonUpdateSectionTitle();
		//Click on Yes and OK button
		sectionTitlesPage.ClickonOK();
		//Validate Documents Assigned
		contentManagementPage.validatedocument("2");
		//Click on Document Assigned
		contentManagementPage.clickondocumentassigned();

		ExtentSuccessMessage("Relation will be removed from the Section title"); 
		sectionTitlesPage.clickonRemoveRelation();
		//Click on Yes and OK button
		sectionTitlesPage.clickonYes_OK();	
		/////////  Add Document Section Title /////////  
		//Click on Add Document
		sectionTitlesPage.ClickOnadddocument();
		//Click on Document CheckBox
		sectionTitlesPage.ClickOnDocCheckboxAsPerStatus("Published");
		//Click on Add Document Button
		sectionTitlesPage.ClickOnCreatesectionTitle();
		//Click on OK button
		sectionTitlesPage.ClickonOK();

		ExtentSuccessMessage(" Delete Section Title ");
		//Clicked on Back Button
		sectionTitlesPage.clickonBack();
		//Click on Delete
		contentManagementPage.ClickOnSecDelete();			
		//Click on Yes and OK button
//		sectionTitlesPage.clickonyes_OK();
		sectionTitlesPage.ClickonOK();
		ExtentSuccessMessage("Export ");
		//Click on Export Icon
		sectionTitlesPage.clickonExport();
		Thread.sleep(3000);
		assertEquals(GetFilesCountInDownloadDirectory(), 1);


	}

}
