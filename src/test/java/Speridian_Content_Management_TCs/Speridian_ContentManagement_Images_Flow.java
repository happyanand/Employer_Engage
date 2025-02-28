package Speridian_Content_Management_TCs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import Pages.Banner_Page;
import Pages.ContentManagement_Page;
import Pages.Home_Page;
import Pages.Images_Page;
import Pages.Pages_ContentManagement;
import Pages.SectionTitles_Page;

public class Speridian_ContentManagement_Images_Flow extends Speridian_Content_Management_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	ContentManagement_Page contentManagementPage = new ContentManagement_Page();
	Images_Page imagesPage = new Images_Page();
	Banner_Page bannerPage= new Banner_Page();
	Pages_ContentManagement pages= new Pages_ContentManagement();
	SectionTitles_Page sectionTitlesPage = new SectionTitles_Page();
	
	public void ValidateSperidian_ContentManagement_Images_Flow(String testScenario,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException {
	
		//Click on ContentManagementTab
		Home_Page.CheckContentManagementTabDispaly();
		//Click on Images
		contentManagementPage.ClickOnImage();
		
		ExtentSuccessMessage("******************Upload Images***************");
		///////// upload Images /////////
		//Upload Image
		pages.ClickOnUpload();	
		sectionTitlesPage.UploadImage();
		sectionTitlesPage.UploadImageConfirmation();	
		String img = "UploadTest.jpg";
		//Search with Name
		imagesPage.search_Name(img);
		//Validate Image
		imagesPage.validateImage(img);
		
		ExtentSuccessMessage("******************Delete Images***************");
		///////// Delete Image /////////
		//Click on Delete
		imagesPage.clickondelete(img);
		//Click on Yes and Ok
		imagesPage.clickonyesok();
		//Validate Image
		bannerPage.validaterecord();
		
	}
}
