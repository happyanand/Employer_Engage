package Pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class Banner_Page extends Base_Class {

	private static By L_addBanner = By.xpath("//a[@class='adding-page btn btn-primary no-margin']");

	private static By txt_name = By.xpath("//*[@id='page-content-wrapper']/div/div/div[5]/div/div[2]/div/div[1]/div[1]/input");

	private static By txt_description = By.xpath("//div[@class='col-md-6']//div[@id='first-name']//input[@type='text']");

	private static By L_startdate = By.xpath("(//input[@class='tb1 hasDatepicker'])[5]");

	private static By L_role = By.xpath("//label[text()='Role']/following-sibling::div/div/div[2]");
	private static String L_roleValue = "//label[text()='Role']/following-sibling::div//ul/li//span[text()='%s']";

	private static By L_pages = By.xpath("//div[@placeholder='Select Page']//select[@class='select']");

	private static By txt_alertmsg = By.xpath("//p[normalize-space()]");

	private static By btn_preview = By.xpath("//a[normalize-space()='Preview']");

	private static By btn_submit = By.xpath("//a[normalize-space()='Submit']");

	private static By L_Ok = By.xpath("//a[normalize-space()='Ok']");

	private static By L_close = By.xpath("//*[@id='page-content-wrapper']/div/div/div[5]/div/div[1]/ul/li[2]/a/i");

	private static By L_edit = By.xpath("//i[contains(@title,'Edit')]");

	private static By L_assignback = By.xpath("//a[normalize-space()='Assign Back']|//i[normalize-space()='undo']");

	private static By btn_publish = By.xpath("//a[normalize-space()='Publish']");

	private static By btn_unpublish = By.xpath("//a[normalize-space()='Unpublish']");

	private static By L_Gloablcheckbox = By.xpath("//label[@for='page-global']");
	private static By L_BusinessSegmentcheckbox = By.xpath("//label[@for='page-Segment']");
	private static By L_AccountSpecificcheckbox = By.xpath("//label[@for='page-group']");
	private static String L_FilteredAudienceRecords = "//table[@class='table cms-grid table-striped table-fixer']//td[6]/span[text()='%s']";
	private static String L_FilteredAudienceRecordFBMC = "//table[@class='table cms-grid table-striped table-fixer']//td[6]/span[@title='%s']";
	private static By SearchDropdownlist = By.xpath("//*[contains(@class,'dropdown custom-ddl')]/ul/li");
	private static By SearchDropdown = By.xpath("//*[contains(@class,'dropdown custom-ddl')]/a");
	private static By L_ShowAllRecords = By
			.xpath("//table[@class='table cms-grid table-striped table-fixer']//td[8][text()]");

	private static String L_ExceptselectedRecords = "//table[@class='table cms-grid table-striped table-fixer']//td[8][not(text()='%s')]";
	private static String L_UnpublishselectedRecords = "//table[@class='table cms-grid table-striped table-fixer']//td[8][not(text()='Unpublished' or text()='UnPublished' )]";
	private static String L_SelectedRecords = "//table[@class='table cms-grid table-striped table-fixer']//td[8][text()='%s']";
	private String L_drpdownLabel = "//*[text()='Create Banner ']/../following-sibling::div//label[text()='%s']/following-sibling::div//span[contains(text(),'Select')]/../..";

	//Click on Add Banner
	public void ClickOnaddBanner() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			WaitForPageLoad();
			jsClick(L_addBanner);
			ExtentSuccessMessage("Successfully Clicked ON Add Banner");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Enter Banner Name
	public String Entername() throws InterruptedException{
		WaitForPageLoad();
		String name = "Banner_"+ randomNumber(4);
		try {
			jsClick(txt_name);
			input(txt_name, name);
			System.out.println("Entered Name --> "+name);
			ExtentSuccessMessage("Successfully Entered Name");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
		return name;
	}

	//Enter Banner Description
	public void addDescription() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			click(txt_description);
			input(txt_description, "Banner added in Dashborad Pages");
			ExtentSuccessMessage("Successfully Added Description");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Enter Visibility Start Date
	public void enterVisibilityFromDate(String Date) throws InterruptedException{
		WaitForPageLoad();
		try {
			click(L_startdate);
			input(L_startdate,Date);
			Thread.sleep(3000);
			ExtentSuccessMessage("Successfully Entered Date");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Select Role
	public void selectrole(String Role) throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			click(L_role);
			ExtentSuccessMessage("Successfully Selected Role");
			System.out.println(L_role+" "+Role);
			click(By.xpath(String.format(L_roleValue, Role)));
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Select Page 
	public void selectpage(String page) throws InterruptedException{
		WaitForPageLoad();		
		try {
			WaitForPageLoad();
			SelectDropDownValues(L_pages, page);
			ExtentSuccessMessage("Successfully Selected Page");
			click(By.xpath("//label[text()='Pages']"));
			Thread.sleep(3000);
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

	//Add Alert message
	public String addAlertmessage(String msg) throws InterruptedException{
		WaitForPageLoad();
		try {	
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			jsClick(txt_alertmsg);
			Thread.sleep(2000);
			input(txt_alertmsg, msg);
			ExtentSuccessMessage("Successfully Added Alert message");
			SwitchToDefaultF();
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
		return msg;
	}

	//Click on Preview
	public void ClickOnPreview() throws InterruptedException{
		WaitForPageLoad();
		try {
			jsClick(btn_preview);
			ExtentSuccessMessage("Successfully Clicked ON Preview");
		}catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on Submit
	public void ClickOnSubmit() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			if(ElementDisplayed(btn_submit)) {
				ExtentSuccessMessage("Successfully displayed Submit");
				jsClick(btn_submit);
				ExtentSuccessMessage("Successfully Clicked ON Submit");
			}} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	//Click on OK
	public void ClickOnOk() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			jsClick(L_Ok);
			ExtentSuccessMessage("Successfully Clicked ON OK");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}	

	//Click on Close
	public void ClickOnClose() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			jsClick(L_close);
			ExtentSuccessMessage("Successfully Clicked ON Close");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Switch Tab
	public void switchTab() throws InterruptedException{
		WaitForPageLoad();
		try {
			SwitchBetweenTab(0);
			ExtentSuccessMessage("Successfully Clicked ON Close");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on Edit Icon
	public void ClickOnedit() throws InterruptedException {
		WaitForPageLoad();
		try {
			click(L_edit);
			Log.info("Successfully Clicked On Edit Icon");
			ExtentSuccessMessage("Successfully Clicked On Edit Icon");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on Assign Back
	public void ClickOnassignback() throws InterruptedException {
		WaitForPageLoad();
		Thread.sleep(5000);
		try {
			click(L_assignback);
			Log.info("Successfully Clicked On Assign Back");
			ExtentSuccessMessage("Successfully Clicked On Assign Back");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on Publish
	public void ClickOnPublish() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			jsClick(btn_publish);
			//RefreshPage();
			ExtentSuccessMessage("Successfully Clicked ON Publish");
		}catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on Yes
	public void ClickOnyes(String value) throws InterruptedException{
		WaitForPageLoad();
		try {
			By yes = By.xpath("//div[contains(@bannerstatus, '"+ value +"')]//a[contains(@class,'btn-primary no-margin')][normalize-space()='Yes']");
			jsClick(yes);
			ExtentSuccessMessage("Successfully Clicked ON "+ value +" Yes");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on Unpublish
	public void ClickOnUnpublish() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			jsClick(btn_unpublish);
			RefreshPage();
			ExtentSuccessMessage("Successfully Clicked ON UnPublish");
		}catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Validate Status
	public void validateStatus(String status) throws InterruptedException{
		WaitForPageLoad();
		try {
			By Status = By.xpath("//td[normalize-space()='"+ status +"']");
			if(ElementDisplayed(Status)) {
				assertTrue(ElementDisplayed(Status), "Assertion Passed");
				ExtentSuccessMessage("Successfully displayed "+ status +" Status");
			}} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
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
		WaitForPageLoad();
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
		click(L_BusinessSegmentcheckbox);
		WaitForLoadAnimationDisappear();
		click(L_Gloablcheckbox);
	}

	//Filter Speridian Audience
	public void FilterAudienceSperidian() throws InterruptedException
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

	// search
	// Click on Pages
	public void SearchDrpdownverification() throws InterruptedException {
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
					By.xpath("//*[contains(@class,'dropdown custom-ddl')]/ul/li[contains(text(),'" + dropdown + "')]"))
			.click();
			if (!ElementDisplayed(By.cssSelector(".no-record"))) {
				if (dropdown.equalsIgnoreCase("Show All")) {

					assertTrue(driver.findElements(L_ShowAllRecords).size() > 0, "Showed all Records");
				} else {
					if(dropdown.equals("Unpublished"))
					{
						ExtentSuccessMessage("showed" +dropdown +"Records Successfully");
						assertTrue(
								driver.findElements(By.xpath(String.format(L_UnpublishselectedRecords, dropdown))).size() == 0,
								"Didnt Showed except" + dropdown+" Records");
						assertTrue(driver.findElements(By.xpath(String.format(L_SelectedRecords, dropdown))).size() > 0,
								"Showed " + dropdown+" Records");
					}
					else
					{
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
	}

	//Validate Banner
	public void validaterecord() throws InterruptedException
	{
		By banner=By.xpath("//h6[@class='no-record']");
		try {
			if(ElementDisplayed(banner))
			{
				assertTrue(ElementDisplayed(banner), "Assertion Passed");
				ExtentSuccessMessage("Successfully displayed No Record Found");		
			}} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}
	// Select Value from Section Titles or Business Segment or Account
	public void selectDropdownValues(String Accountname, String Fieldname) throws InterruptedException {
		WaitForPageLoad();
		try {
			WaitForPageLoad();
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(By.xpath(String.format(L_drpdownLabel ,Fieldname)))).release().perform();
			ExtentSuccessMessage("Successfully Clicked ON Account");
			input(By.xpath(String.format(L_drpdownLabel, Fieldname)), Accountname+Keys.ENTER);
			ExtentSuccessMessage("Successfully Selected AccountName");
			Thread.sleep(3000);
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
