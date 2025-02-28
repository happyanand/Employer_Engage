package IHA_Content_Management;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.util.Map;

import Pages.ContentManagement_Page;
import Pages.Home_Page;
import Pages.Review_Page;
import Pages.SectionTitles_Page;

public class IHA_ContentManagement_Review_Flow extends IHA_ContentManagement_AllScenarios {


	Home_Page Home_Page = new Home_Page();
	ContentManagement_Page contentManagementPage = new ContentManagement_Page();
	SectionTitles_Page sectionTitlesPage = new SectionTitles_Page();
	Review_Page reviewPage = new Review_Page();

	public void ValidateIHA_ContentManagement_Review_Flow(String testScenario,Map<Object, Object> testdata) throws InterruptedException, AWTException {

		//Click on ContentManagementTab
		Home_Page.CheckContentManagementTabDispaly();
		//Click on Review
		contentManagementPage.ClickOnreview();
		// Select checkbox uncheck others
		contentManagementPage.FilterAudienceIHA();
		///////// Export ///////// 
		//Click on Export Icon
		sectionTitlesPage.clickonExport();
		Thread.sleep(2000);
		assertEquals(GetFilesCountInDownloadDirectory(), 1);

	}
}
