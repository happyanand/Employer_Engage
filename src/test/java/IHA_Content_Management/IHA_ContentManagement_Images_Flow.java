package IHA_Content_Management;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import Pages.Banner_Page;
import Pages.ContentManagement_Page;
import Pages.Home_Page;
import Pages.Images_Page;
import Pages.Pages_ContentManagement;
import Pages.SectionTitles_Page;

public class IHA_ContentManagement_Images_Flow extends IHA_ContentManagement_AllScenarios {

	Home_Page Home_Page = new Home_Page();
	ContentManagement_Page contentManagementPage = new ContentManagement_Page();
	Images_Page imagesPage = new Images_Page();
	Banner_Page bannerPage= new Banner_Page();
	Pages_ContentManagement pages= new Pages_ContentManagement();
	SectionTitles_Page sectionTitlesPage = new SectionTitles_Page();
	
	public void ValidateIHA_ContentManagement_Images_Flow(String testScenario,Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException {
	
		//Click on ContentManagementTab
		Home_Page.CheckContentManagementTabDispaly();
		//Click on Images
		contentManagementPage.ClickOnImage();
		///////// upload Images /////////
		//Upload Image
		String img = "UploadTest.jpg";
//		imagesPage.Delete_if_SameImageNameAlreadyUploadeAndExist(img);
		pages.ClickOnUpload();	
		sectionTitlesPage.UploadImage();
		sectionTitlesPage.UploadImageConfirmation();	
		//Search with Name
		imagesPage.search_Name(img);
		//Validate Image
		imagesPage.validateImage(img);
		///////// Delete Image /////////
		//Click on Delete
		imagesPage.clickondelete(img);
		//Click on Yes and Ok
		imagesPage.clickonyesok();
		//Validate Image
		bannerPage.validaterecord();
	
	}
}
