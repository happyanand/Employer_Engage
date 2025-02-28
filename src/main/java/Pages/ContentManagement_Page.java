package Pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

//import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class ContentManagement_Page extends Base_Class {

	private static By L_sectionTitles = By.xpath("//i[normalize-space()='local_offer']");

	private static By L_documents = By.xpath("//i[normalize-space()='card_travel']");

	private static By L_review = By.xpath("//i[normalize-space()='rate_review']");

	private static By txt_review = By.xpath("//h4[normalize-space()='Pending for Review']");

	private static By txt_pages = By.xpath("//h4[normalize-space()='Pages']");

	private static By txt_documents = By.xpath("//h4[normalize-space()='Documents']");

	private static By txt_banner = By.xpath("//h4[normalize-space()='Banner']");

	private static By txt_images = By.xpath("//h4[normalize-space()='Images']");

	private static By txt_notifications = By.xpath("//h4[normalize-space()='Notifications']");

	private static By txt_sectiontitle = By.xpath("//h4[normalize-space()='Section Titles']");

	private static By L_banner = By.xpath("//i[@class='fa fa-flag']");

	private static By L_pages = By.xpath("//i[normalize-space()='book']");

	private static By L_notifications = By.xpath("//i[normalize-space()='contact_mail']");

	private static By txt_search = By.xpath("//div[contains(@class,'md-search-box md-search-box-block')]//input[contains(@placeholder,'Search')]");

	private static By search_icon = By.xpath("//span[@class='md-search-btn hr-theme-bg ']//i[@class='material-icons'][normalize-space()='search']|//*[@id='page-content-wrapper']/div/div/div[1]/div[1]/div/div[2]/ul/li[1]/div/div/span/i");

	private static By edit_icon = By.xpath("//i[contains(@title,'Edit')]|//*[text()='open_in_new']");

	private static By edit_icon2 = By.xpath("(//i[contains(@title,'Edit')])[2]");

	private static By delete_icon = By.xpath("//i[contains(@title,'Delete')]|(//i[normalize-space()='delete_forever'])[1]");

	private static By unpublish = By.xpath("//i[normalize-space()='phonelink_off']");

	private static By L_published = By.xpath("//td[normalize-space()='Published']");

	private static By L_unpublished = By.xpath("//td[normalize-space()='UnPublished']|//*[text()='Unpublish']");

	private static By L_draft = By.xpath("//td[normalize-space()='Draft']");

	private static By yes = By.xpath("//*[@role='dialog'][@style='display: block;']//a[normalize-space()='Yes']");
	private static By docyes = By.xpath("(//a[normalize-space()='Yes'])[3]");
	private static By secyes = By.xpath("//a[@class='adding-page btn  btn-primary no-margin']");


	private static By copy = By.xpath("//*[@id='copyContent']/i");

	private static By L_preview = By.xpath("//i[normalize-space()='visibility']");

	private static By L_images = By.xpath("//i[normalize-space()='image']");
	private static By SearchDropdownlist = By.xpath("//*[contains(@class,'dropdown custom-ddl')]/ul/li");
	private static By SearchDropdown = By.xpath("//*[contains(@class,'dropdown custom-ddl')]/a");
	private static By L_ShowAllRecords = By
			.xpath("//table[@class='table cms-grid table-striped table-fixer']//td[6][text()]");

	private static String L_ExceptselectedRecords = "//table[@class='table cms-grid table-striped table-fixer']//td[6][not(text()='%s')]";
	private static String L_SelectedRecords = "//table[@class='table cms-grid table-striped table-fixer']//td[6][text()='%s']";
	private static By L_Gloablcheckbox = By.xpath("//label[@for='page-global']");
	private static By L_BusinessSegmentcheckbox = By.xpath("//label[@for='page-Segment']");
	private static By L_AccountSpecificcheckbox = By.xpath("//label[@for='page-group']");
	private static String L_FilteredAudienceRecords = "//table[@class='table cms-grid table-striped table-fixer']//td[4]/span[text()='%s']";
	private static String L_FilteredAudienceRecordFBMC = "//table[@class='table cms-grid table-striped table-fixer']//td[4]/span[@title='%s']";

	private static By L_WebtableColums =By.xpath("//table[@class='table cms-grid table-striped table-fixer']/tr[1]/th");


	String title;

	// Click on Section Title
	public void ClickOnsectionTitle() throws InterruptedException {
		WaitForPageLoad();
		Thread.sleep(3000);	
		try {
			if (ElementDisplayed(L_sectionTitles)) {
				Log.info("Successfully Visible Section Titles");
				click(L_sectionTitles);
				Log.info("Successfully Clicked On Section Titles");
				ExtentSuccessMessage("Successfully Clicked On Section Titles");
			} else {
				Log.error("UnSuccessfully Not Visible Section Titles");
				ExtentErrorMessage("UnSuccessfully Not Visible Section Titles");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on Review
	public void ClickOnreview() throws InterruptedException {
		WaitForPageLoad();
		Thread.sleep(3000);
		try {
			if (ElementDisplayed(L_review)) {
				WaitForPageLoad();
				Log.info("Successfully Visible Review");
				jsClick(L_review);
				Log.info("Successfully Clicked On Review");
				ExtentSuccessMessage("Successfully Clicked On Review");
			} else {
				Log.error("UnSuccessfully Not Visible Review");
				ExtentErrorMessage("UnSuccessfully Not Visible Review");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on Banner
	public void ClickOnbanner() throws InterruptedException {
		WaitForPageLoad();
		try {
			Thread.sleep(2000);
			if (ElementDisplayed(L_banner)) {
				Log.info("Successfully Visible Banner");
				jsClick(L_banner);
				Log.info("Successfully Clicked On Banner");
				ExtentSuccessMessage("Successfully Clicked On Banner");
			} else {
				Log.error("UnSuccessfully Not Visible Banner");
				ExtentErrorMessage("UnSuccessfully Not Visible Banner");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on Images
	public void ClickOnImage() throws InterruptedException {
		WaitForPageLoad();
		try {
			Thread.sleep(2000);
			if (ElementDisplayed(L_images)) {
				Log.info("Successfully Visible Images");
				jsClick(L_images);
				Log.info("Successfully Clicked On Images");
				ExtentSuccessMessage("Successfully Clicked On Images");
			} else {
				Log.error("UnSuccessfully Not Visible Images");
				ExtentErrorMessage("UnSuccessfully Not Visible Images");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on Documents
	public void ClickOndocuments() throws InterruptedException {
		WaitForPageLoad();
		try {
			Thread.sleep(2000);
			if (ElementDisplayed(L_documents)) {
				Log.info("Successfully Visible Documents");
				jsClick(L_documents);
				Log.info("Successfully Clicked On Documents");
				ExtentSuccessMessage("Successfully Clicked On Documents");
			} else {
				Log.error("UnSuccessfully Not Visible Documents");
				ExtentErrorMessage("UnSuccessfully Not Visible Documents");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on Pages
	public void ClickOnpages() throws InterruptedException {
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			if (ElementDisplayed(L_pages)) {
				Log.info("Successfully Visible Pages");
				click(L_pages);
				Log.info("Successfully Clicked On Pages");
				ExtentSuccessMessage("Successfully Clicked On Pages");
			} else {
				Log.error("UnSuccessfully Not Visible Pages");
				ExtentErrorMessage("UnSuccessfully Not Visible Pages");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on Notifications
	public void ClickOnnotifications() throws InterruptedException {
		WaitForPageLoad();
		try {
			Thread.sleep(5000);
			if (ElementDisplayed(L_notifications)) {
				Log.info("Successfully Visible Notifications");
				Thread.sleep(5000);
				//				click(L_notifications);
				Log.info("Successfully Clicked On Notifications");
				ExtentSuccessMessage("Successfully Clicked On Notifications");
			} else {
				Log.error("UnSuccessfully Not Visible Notifications");
				ExtentErrorMessage("UnSuccessfully Not Visible Notifications");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Search with Name
	public void search_Name(String name) throws InterruptedException {
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			if (ElementDisplayed(txt_search)) {
				Log.info("Successfully Visible Text Search");
				jsClick(txt_search);
				input(txt_search, name);
				Log.info("Successfully Clicked On Text Search");
				click(search_icon);
				ExtentSuccessMessage("Successfully Search with Name" +name);
			} else {
				Log.error("UnSuccessfully Not Visible Text Search");
				ExtentErrorMessage("UnSuccessfully Not Search with Name");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Validate Documents
	public void validatedocument(String value) throws InterruptedException {
		WaitForPageLoad();
		By documentassigned = By.xpath("(//a[@class='btn-link'][normalize-space()=" + value + "])[1]");
		//		System.out.println(documentassigned);
		try {
			if (ElementDisplayed(documentassigned)) {
				ExtentSuccessMessage("Successfully Visible Document Assigned");
			} else {
				Log.error("UnSuccessfully Not Visible Document Assigned");
				ExtentErrorMessage("UnSuccessfully Not Visible Document Assigned");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Validate and Click Documents
	public void validateandclickdocument(String value) throws InterruptedException {
		WaitForPageLoad();
		By documentassigned = By.xpath("(//a[@class='btn-link'][normalize-space()=" + value + "])[1]");
		try {
			if (ElementDisplayed(documentassigned)) {
				ExtentSuccessMessage("Successfully Visible Document Assigned");
				jsClick(documentassigned);
			} else {
				Log.error("UnSuccessfully Not Visible Document Assigned");
				ExtentErrorMessage("UnSuccessfully Not Visible Document Assigned");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Document Assigned
	public void clickondocumentassigned() throws InterruptedException {
		WaitForPageLoad();
		By documentassigned = By.xpath("//a[@class='btn-link'][normalize-space()='2']");
		try {
			if (ElementDisplayed(documentassigned)) {
				ExtentSuccessMessage("Successfully Visible Document Assigned");
				jsClick(documentassigned);
			} else {
				Log.error("UnSuccessfully Not Visible Document Assigned");
				ExtentErrorMessage("UnSuccessfully Not Visible Document Assigned");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on Edit Icon
	public void ClickOnedit() throws InterruptedException {
		WaitForPageLoad();
		try {
			Thread.sleep(2000);
			if (ElementDisplayed(edit_icon)) {
				Log.info("Successfully Visible Edit Icon");
				click(edit_icon);
				Log.info("Successfully Clicked On Edit Icon");
				ExtentSuccessMessage("Successfully Clicked On Edit Icon");
			} else {
				Log.error("UnSuccessfully Not Visible Edit Icon");
				ExtentErrorMessage("UnSuccessfully Not Visible Edit Icon");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on Edit Icon
	public void ClickOnedit2() throws InterruptedException {
		WaitForPageLoad();
		if (ElementDisplayed(edit_icon2)) {
			Log.info("Successfully Visible Edit Icon");
			click(edit_icon2);
			Log.info("Successfully Clicked On Edit Icon");
			ExtentSuccessMessage("Successfully Clicked On Edit Icon");
		} else {
			Log.error("UnSuccessfully Not Visible Edit Icon");
			ExtentErrorMessage("UnSuccessfully Not Visible Edit Icon");
		}
	}

	// Click on Delete Icon
	public void ClickOnDelete() throws InterruptedException {
		WaitForPageLoad();
		try {
			if (ElementDisplayed(delete_icon)) {
				Log.info("Successfully Visible Delete Icon");
				jsClick(delete_icon);
				Log.info("Successfully Clicked On Delete Icon");
				ExtentSuccessMessage("Successfully Clicked On Delete Icon");
				//				if(ElementDisplayed(yes)) {
				//					Log.info("Successfully Visible yes Button");
				//					jsClick(yes);
				//					Log.info("Successfully Clicked On yes Button");
				//					ExtentSuccessMessage("Successfully Clicked On yes Button");
				//				} else {
				//					Log.error("UnSuccessfully Not Visible yes Button");
				//					ExtentErrorMessage("UnSuccessfully Not Visible yes Button");
				//				}

			} else {
				Log.error("UnSuccessfully Not Visible Delete Icon");
				ExtentErrorMessage("UnSuccessfully Not Visible Delete Icon");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}	

	// Click on Yes
	public void ClickOnyes() throws InterruptedException {
		WaitForPageLoad();
		Thread.sleep(5000);
		if (ElementDisplayed(yes)) {
			Log.info("Successfully Visible Popup Yes");
			jsClick(yes);
			Log.info("Successfully Clicked On Popup Yes");
			ExtentSuccessMessage("Successfully Clicked On Popup Yes");
		} else {
			Log.error("UnSuccessfully Not Visible Popup Yes");
			ExtentErrorMessage("UnSuccessfully Not Visible Popup Yes");
		}
	}	


	//Click on Unpublish
	public void ClickOnUnpublish() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(unpublish)) {
				jsClick(unpublish);
				ExtentSuccessMessage("Successfully Clicked ON Unpublish");
				if(ElementDisplayed(yes)) {
					click(yes);
				}
			}else {
				Log.error("UnSuccessfully Not Visible unpublish button");
				ExtentErrorMessage("UnSuccessfully Not Visible unpublish button");
			}

		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on Copy
	public void ClickOncopy() throws InterruptedException{
		WaitForPageLoad();
		try {
			jsClick(copy);
			ExtentSuccessMessage("Successfully Clicked ON Copy");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Validate Review Page
	public void validateReview() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(txt_review)) {
				ExtentSuccessMessage("Successfully displayed Review Page");
			}} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	//Validate Pages
	public void validatePages() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(txt_pages)) {
				ExtentSuccessMessage("Successfully displayed Pages");
			}} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	//Validate Documents Page
	public void validateDocuments() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(txt_documents)) {
				ExtentSuccessMessage("Successfully displayed Documents Page");
			}} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	//Validate Banner Page
	public void validateBanner() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(txt_banner)) {
				ExtentSuccessMessage("Successfully displayed Banner Page");
			}} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	//Validate Images Page
	public void validateImages() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(txt_images)) {
				ExtentSuccessMessage("Successfully displayed Images Page");
			}} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	//Validate Notifications Page
	public void validateNotifications() throws InterruptedException{
		//		WaitForPageLoad();
		//		try {
		//			if(ElementDisplayed(txt_notifications)) {
		//				ExtentSuccessMessage("Successfully displayed Notifications Page");
		//			}} catch (Exception e) {
		//				// Handle the exception
		//				System.out.println("An exception occurred: " + e.getMessage());
		//				e.printStackTrace();
		//			}
	}

	//Validate Section Titles Page
	public void validateSectionTitles() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			if(ElementDisplayed(txt_sectiontitle)) {
				ExtentSuccessMessage("Successfully displayed Section Titles Page");
			}} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	//Validate Published Status
	public void validatePublished(String Value,String status) throws InterruptedException{
		WaitForPageLoad();
		try {
			By Validatetion = By.xpath("//*[contains(text(),'"+Value+"')]//parent::td//parent::tr//td[6]");
			String Status =GetElementText(Validatetion);
			Assert.assertEquals(Status,status);
			//			if(!Status.equalsIgnoreCase(Status)){
			//				ExtentSuccessMessage("Successfully displayed Published Status Expected Status"+"["+status+"]"+"Actuall status is"+"["+Status+"]");
			//			}else{
			//				ExtentErrorMessage("Unsuccessfully status not matched Expected Status"+"["+status+"]"+ "but found Actuall status is"+"["+Status+"]");
			//			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Validate UnPublished Status
	public void validateUnPublished(String Value ,String status) throws InterruptedException{
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		Thread.sleep(10000);
		try {
			By Validatetion = By.xpath("//*[contains(text(),'"+Value+"')]//parent::td//parent::tr//td[6]");
			String Status =GetElementText(Validatetion);
			Assert.assertEquals(Status,status);
			ExtentSuccessMessage("Successfully displayed UnPublished Status");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Validate Draft Status
	public void validateDraft() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(L_draft)) {
				ExtentSuccessMessage("Successfully displayed Draft Status");
			}} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	//Validate Page Name
	public void validatePageName(String name) throws InterruptedException{
		WaitForPageLoad();
		try {
			By pagename = By.xpath("//span[normalize-space()='"+name+"']");
			if(ElementDisplayed(pagename)) {
				ExtentSuccessMessage("Successfully displayed PageName");
			}} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	//Click on Preview
	public void ClickOnPreview() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(L_preview)) {
				ExtentSuccessMessage("Successfully displayed Preview");
				jsClick(L_preview);
				ExtentSuccessMessage("Successfully Clicked ON Preview");
				SwitchBetweenTab(0);
			} }catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	// search based on dropdown value selected
	public void DocumentsSearchDrpdownverification() throws InterruptedException {
		WaitForPageLoad();
		Log.info("Successfully Visible drpdown");
		click(SearchDropdown);
		List<WebElement> drpdownList = driver.findElements(SearchDropdownlist);
		List<String> drpdownListText = new ArrayList<>();
		for (int i = 0; i < drpdownList.size(); i++) {
			drpdownListText.add(drpdownList.get(i).getText());
		}
		click(SearchDropdown);
		for (String dropdown : drpdownListText) {
			click(SearchDropdown);
			driver.findElement(
					By.xpath("//*[contains(@class,'dropdown custom-ddl')]/ul/li[contains(text(),'" + dropdown + "')]|//*[contains(@class,'dropdown custom-ddl')]/ul/li//label"))
			.click();
			if (!ElementDisplayed(By.cssSelector(".no-record"))) {
				if (dropdown.equalsIgnoreCase("Show All") || dropdown.equalsIgnoreCase("Include Deleted")) {

					assertTrue(driver.findElements(L_ShowAllRecords).size() > 0, "Showed all Records");
				} else {
					if(dropdown.equals("Unpublished"))
					{
						dropdown = "UnPublished";
					}
					ExtentSuccessMessage("showed" +dropdown +"Records Successfully");
					assertTrue(
							driver.findElements(By.xpath(String.format(L_ExceptselectedRecords, dropdown))).size() == 0,
							"Didnt Showed except" + dropdown+" Records");
					assertTrue(driver.findElements(By.xpath(String.format(L_SelectedRecords, dropdown))).size() > 0,
							"Showed " + dropdown+" Records");
				}
			}
		}
	}

	//Filter Audience based on checkbox selected
	public void FilterAudience() throws InterruptedException
	{
		click(L_BusinessSegmentcheckbox);
		WaitForLoadAnimationDisappear();
		click(L_AccountSpecificcheckbox);
		WaitForLoadAnimationDisappear();
		if (ElementDisplayed(By.cssSelector(".no-record")))
		{
			ExtentSuccessMessage("No Global Records Found");
		}
		else
		{	
			assertTrue(driver.findElements(By.xpath(String.format(L_FilteredAudienceRecords, "Global"))).size() > 0,
					"Showed Global Records");
			ExtentSuccessMessage("Global Records Found");
		}
		click(L_Gloablcheckbox);
		WaitForLoadAnimationDisappear();

		click(L_BusinessSegmentcheckbox);
		WaitForLoadAnimationDisappear();
		if (ElementDisplayed(By.cssSelector(".no-record")))
		{
			ExtentSuccessMessage("No Business Segment Records Found");
		}
		else
		{
			assertTrue(driver.findElements(By.xpath(String.format(L_FilteredAudienceRecords, "Small Group"))).size() > 0,
					"Showed Business Segment Records");
			ExtentSuccessMessage("Business Segment Records Found");
		}
		click(L_BusinessSegmentcheckbox);
		WaitForLoadAnimationDisappear();

		click(L_AccountSpecificcheckbox);
		WaitForLoadAnimationDisappear();
		if (ElementDisplayed(By.cssSelector(".no-record")))
		{
			ExtentSuccessMessage("No Account Specific Records Found");
		}
		else
		{
			assertTrue(driver.findElements(By.xpath(String.format(L_FilteredAudienceRecords, "Speridian"))).size() > 0,
					"Showed Account Specific Records");
			ExtentSuccessMessage("Account Specific Records Found");
		}
	}

	//Filter FBMC Audience
	public void FilterAudienceFBMC() throws InterruptedException
	{
		click(L_BusinessSegmentcheckbox);
		WaitForLoadAnimationDisappear();
		click(L_AccountSpecificcheckbox);
		WaitForLoadAnimationDisappear();
		if (ElementDisplayed(By.cssSelector(".no-record")))
		{
			ExtentSuccessMessage("No Global Records Found");
		}
		else
		{	
			assertTrue(driver.findElements(By.xpath(String.format(L_FilteredAudienceRecords, "Global"))).size() > 0,
					"Showed Global Records");
			ExtentSuccessMessage("Global Records Found");
		}
		click(L_Gloablcheckbox);
		WaitForLoadAnimationDisappear();

		click(L_BusinessSegmentcheckbox);
		WaitForLoadAnimationDisappear();
		if (ElementDisplayed(By.cssSelector(".no-record")))
		{
			ExtentSuccessMessage("No Business Segment Records Found");
		}
		else
		{
			assertTrue(driver.findElements(By.xpath(String.format(L_FilteredAudienceRecords, "Small Group"))).size() > 0,
					"Showed Business Segment Records");
			ExtentSuccessMessage("Business Segment Records Found");
		}
		click(L_BusinessSegmentcheckbox);
		WaitForLoadAnimationDisappear();

		click(L_AccountSpecificcheckbox);
		WaitForLoadAnimationDisappear();
		if (ElementDisplayed(By.cssSelector(".no-record")))
		{
			ExtentSuccessMessage("No Account Specific Records Found");
		}
		else
		{
			assertTrue(driver.findElements(By.xpath(String.format(L_FilteredAudienceRecordFBMC, "St. Lucie Public Schools"))).size() > 0,
					"Showed Account Specific Records");
			ExtentSuccessMessage("Account Specific Records Found");
		}
	}

	//Filter IHA Audience
	public void FilterAudienceIHA() throws InterruptedException
	{
		//			int colummnNumber=findWebTableColumnIndexValue(L_WebtableColums,"Audience");
		//			System.out.println("Table index value "+colummnNumber);
		//			String L_FilteredAudienceRecords1 = "//table[@class='table cms-grid table-striped table-fixer']//td["+colummnNumber+"]/span[text()='%s']";
		click(L_BusinessSegmentcheckbox);
		WaitForLoadAnimationDisappear();
		click(L_AccountSpecificcheckbox);


		WaitForLoadAnimationDisappear();
		if (ElementDisplayed(By.cssSelector(".no-record")))
		{
			ExtentSuccessMessage("No Global Records Found");
		}
		else
		{	
			assertTrue(driver.findElements(By.xpath(String.format(L_FilteredAudienceRecords, "Global"))).size() > 0,
					"Showed Global Records");
			ExtentSuccessMessage("Global Records Found");
		}
		click(L_Gloablcheckbox);
		WaitForLoadAnimationDisappear();

		click(L_BusinessSegmentcheckbox);
		WaitForLoadAnimationDisappear();
		if (ElementDisplayed(By.cssSelector(".no-record")))
		{
			ExtentSuccessMessage("No Business Segment Records Found");
		}
		else
		{
			assertTrue(driver.findElements(By.xpath(String.format(L_FilteredAudienceRecords, "Commercial"))).size() > 0,
					"Showed Business Segment Records");
			ExtentSuccessMessage("Business Segment Records Found");
		}
		click(L_BusinessSegmentcheckbox);
		WaitForLoadAnimationDisappear();

		click(L_AccountSpecificcheckbox);
		WaitForLoadAnimationDisappear();
		if (ElementDisplayed(By.cssSelector(".no-record")))
		{
			ExtentSuccessMessage("No Account Specific Records Found");
		}
		else
		{
			assertTrue(driver.findElements(By.xpath(String.format(L_FilteredAudienceRecords, "ADCDivision"))).size() > 0,
					"Showed Account Specific Records");
			ExtentSuccessMessage("Account Specific Records Found");
		}
	}
	// Click on Delete Icon
	public void ClickOnDocDelete() throws InterruptedException {
		WaitForPageLoad();
		try {
			if (ElementDisplayed(delete_icon)) {
				Log.info("Successfully Visible Delete Icon");
				jsClick(delete_icon);
				Log.info("Successfully Clicked On Delete Icon");
				ExtentSuccessMessage("Successfully Clicked On Delete Icon");
				if(ElementDisplayed(docyes)) {
					Log.info("Successfully Visible yes Button");
					jsClick(docyes);
					Thread.sleep(1000);
					WaitForLoadAnimationDisappear();
					Log.info("Successfully Clicked On yes Button");
					ExtentSuccessMessage("Successfully Clicked On yes Button");
				} else {
					Log.error("UnSuccessfully Not Visible yes Button");
					ExtentErrorMessage("UnSuccessfully Not Visible yes Button");
				}

			} else {
				Log.error("UnSuccessfully Not Visible Delete Icon");
				ExtentErrorMessage("UnSuccessfully Not Visible Delete Icon");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}	
	// Click on Delete Icon
	public void ClickOnSecDelete() throws InterruptedException {
		WaitForPageLoad();
		try {
			if (ElementDisplayed(delete_icon)) {
				Log.info("Successfully Visible Delete Icon");
				jsClick(delete_icon);
				Log.info("Successfully Clicked On Delete Icon");
				ExtentSuccessMessage("Successfully Clicked On Delete Icon");
				if(ElementDisplayed(secyes)) {
					Log.info("Successfully Visible yes Button");
					jsClick(secyes);
					Thread.sleep(1000);
					WaitForLoadAnimationDisappear();
					Log.info("Successfully Clicked On yes Button");
					ExtentSuccessMessage("Successfully Clicked On yes Button");
				} else {
					Log.error("UnSuccessfully Not Visible yes Button");
					ExtentErrorMessage("UnSuccessfully Not Visible yes Button");
				}

			} else {
				Log.error("UnSuccessfully Not Visible Delete Icon");
				ExtentErrorMessage("UnSuccessfully Not Visible Delete Icon");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
