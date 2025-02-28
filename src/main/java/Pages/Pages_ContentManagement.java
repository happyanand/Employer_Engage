package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class Pages_ContentManagement extends Base_Class {


	GroupDashboard_Page Group_Page=new GroupDashboard_Page();
	private static By groupLink = By.xpath("//a[@class='divRedirect breadcrumbLink']");
	private static By btn_Addpage = By.xpath("//a[@class='adding-page btn btn-primary no-margin']");

	private static By txt_Name = By.xpath("(//*[contains(text(),'Name')]/following-sibling::div/input[@class='tb1'])[1]");        //("(//input[@class='tb1'])[5]");

	private static By date = By.xpath("(//input[@class='tb1 hasDatepicker'])[1]");

	private static By page_type = By.xpath("(//select[@class='select'])[1]");

	private static By template = By.xpath("//li[1]//a[1]//img[1]");

	private static By btn_createpage = By.xpath("//a[normalize-space()='Create Page']");

	private static By L_Account = By.xpath("(//*[@class='multiselect'])[2]");

	private static By L_BusinessSegment = By.xpath("(//*[@class='multiselect'])[1]");

	private static By L_Save = By.xpath("//i[normalize-space()='save']");

	private static By L_Ok = By.xpath("//a[normalize-space()='Ok']");

	private static By btn_Ok = By.xpath("//button[normalize-space()='Ok']");

	private static By Addcontent = By.xpath("(//a[contains(@class,'content-pick-btn')])[1]");

	private static By btn_add = By.xpath("//button[@id='btnAdd']");

	private static By SearchBackgroundImage = By.id("txtSearch");

	private static By BackgroundImageSearchIcon = By.xpath("//a[@id='btnSearch']");


	private static By L_image = By.xpath("//*[contains(@class,'TileMenu index ')]");

	private static By L_document = By.xpath("//div[@id='pages']//li[3]//a[1]//i[1]");

	private static By L_links = By.xpath("//*[@id='componentTools']/ul/li[4]/a/i");

	private static By L_notifications = By.xpath("//i[normalize-space()='notifications']");

	private static By L_browse = By.xpath("//button[normalize-space()='Browse']");

	private static By img = By.xpath("//img[@alt='MDCPS_Office_Updated.jpg']|//img[contains(@alt,'MicrosoftTeams-image')]");

	private static By document = By.xpath("//li[9]//div[1]//ul[1]//li[1]//a[1]//i[1]");

	private static By L_close = By.xpath("//a[@id='btnCancel']//i[@class='material-icons'][normalize-space()='close']");

	private static By txt_title = By.xpath("//input[@placeholder='Title']");

	private static By text = By.xpath("//input[@placeholder='Text']");

	private static By url = By.xpath("//input[@placeholder='Url']");

	private static By btn_preview = By.xpath("//i[normalize-space()='remove_red_eye']");

	private static By L_preview = By.xpath("//a[@id='Id_Preview']");

	private static By yes = By.xpath("//a[normalize-space()='Yes']");

	private static By btn_submit = By.xpath("//i[normalize-space()='file_upload']");

	private static By publish = By.xpath("//i[normalize-space()='public']");

	private static By L_header = By.xpath("//p[normalize-space()='Header']");	
	public String name= null;

	private static By txt_search = By.xpath("//input[@placeholder='Search']");
	private static By BackgroundImage = By.xpath("//*[@class='temp-banner']");
	private static By FullScreanbackgroundImage = By.xpath("//*[@class='bg-image']");

	private static By L_SearchIcon= By.xpath("//input[@placeholder='Search']/../span/i[@class='material-icons']");
	private static By L_doc = By.xpath("//li[@class='list-strip']| //ul[@class='inline-list tag-ctrl']");

	//Click on Add Page
	public void ClickOnAddPage() throws InterruptedException{
		WaitForPageLoad();
		try {
			jsClick(btn_Addpage);
			ExtentSuccessMessage("Successfully Clicked ON Add Page");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	//Enter Name
	public void Entername() throws InterruptedException{
		WaitForPageLoad();
		try {
			jsClick(txt_Name);
			String name = "Page_"+ randomNumber(4);
			input(txt_Name, name);
			this.name=name;
			System.out.println("Entered Name --> "+name);
			ExtentSuccessMessage("Successfully Entered Name");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Enter Visibility From Date
	public void enterVisibilityFromDate(String Date) throws InterruptedException{
		WaitForPageLoad();
		if(ElementDisplayed(date)) {
			Log.info("Successfully Visible Date");
			click(date);
			input(date,Date);
			Thread.sleep(3000);
			Log.info("Successfully Clicked On Date");
			ExtentSuccessMessage("Successfully Entered Date");
		}else {
			Log.error("UnSuccessfully Not Visible Date");
			ExtentErrorMessage("UnSuccessfully Not Visible Date");
		}
	}

	//Select Page Type
	public void selectpagetype(String pagetype) throws InterruptedException{
		WaitForPageLoad();		
		try {
			WaitForPageLoad();
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(page_type)).release().perform();
			ExtentSuccessMessage("Successfully Clicked ON Page Type");
			SelectDropDownValues(page_type, pagetype);
			ExtentSuccessMessage("Successfully Selected Page Type");
			Thread.sleep(3000);
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

	// Select Audience
	public void selectAudienceAccount(String Accountname) throws InterruptedException {
		WaitForPageLoad();
		try {
			WaitForPageLoad();
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(L_Account)).release().perform();
			ExtentSuccessMessage("Successfully Clicked ON Account");
			input(L_Account, Accountname+Keys.ENTER);
			ExtentSuccessMessage("Successfully Selected AccountName");
			Thread.sleep(3000);
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Select Business segment
	public void selectAudienceBusinessSegment(String BusinessSegment) throws InterruptedException {
		WaitForPageLoad();
		try {
			WaitForPageLoad();
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(L_BusinessSegment)).release().perform();
			ExtentSuccessMessage("Successfully Clicked ON BusinessSegment");
			input(L_BusinessSegment, BusinessSegment+Keys.ENTER);
			ExtentSuccessMessage("Successfully Selected BusinessSegment");
			Thread.sleep(3000);
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on Select Template
	public void selectTemplate() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(template)) {
				ExtentSuccessMessage("Successfully displayed Template");
				jsClick(template);
				ExtentSuccessMessage("Successfully Selected Template");
			}} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	//Click on Create Page
	public void ClickOnCreatePage() throws InterruptedException{
		WaitForPageLoad();
		try {
			jsClick(btn_createpage);
			ExtentSuccessMessage("Successfully Clicked ON Create Page");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on Save
	public void ClickOnSave() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(3000);
		try {
			if(ElementDisplayed(L_Save)) {
				ExtentSuccessMessage("Successfully displayed Save");
				jsClick(L_Save);
				Thread.sleep(2000);
				ExtentSuccessMessage("Successfully Clicked ON Save");
			} }catch (Exception e) {
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

	//Click on Add your Text
	public void Addyourtext(int num,String Text) throws InterruptedException{
		WaitForPageLoad();
		try {				
			String  name = "(//*[@id='richtext']/div/div/div)"+"["+num+"]";
			By Addyourtext1 = By.xpath(name);
			jsClick(Addyourtext1);
			clear(Addyourtext1);
			input(Addyourtext1, Text);
			ExtentSuccessMessage("Successfully Clicked ON Add your Text");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}	

	//Click on OK
	public void ClickOk() throws InterruptedException{
		WaitForPageLoad();
		try {
			click(btn_Ok);
			ExtentSuccessMessage("Successfully Clicked ON OK");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}	

	//Click on Add Content
	public void ClickOnAddcontent() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(5000);
		try {
			ScrolltillElementOnmiddlepage(Addcontent);
			jsClick(Addcontent);
			ExtentSuccessMessage("Successfully Clicked ON Add Content");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on ADD
	public void ClickOnAdd() throws InterruptedException{
		WaitForPageLoad();
		try {
			jsClick(btn_add);
			ExtentSuccessMessage("Successfully Clicked ON ADD");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Searching Exesting Background Image
	public void SearchingBackgroundImage(String Value) throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(SearchBackgroundImage)) {
				ExtentSuccessMessage("Successfully Visible Search Background Image");
				click(SearchBackgroundImage);
				ExtentSuccessMessage("Successfully Clicked ON Search Background Image");
				input(SearchBackgroundImage,Value);
				ExtentSuccessMessage("Successfully Enter Background Image Name");
				click(BackgroundImageSearchIcon);
				ExtentSuccessMessage("Successfully Clicked ON Search Icon");
				WaitForPageLoad();
				By xpath = By.xpath("(//*[@alt='"+Value+".jpg'])[1]");
				click(xpath);
			}else {
				ExtentErrorMessage("Unsuccessfully Not Visible Search Background Image");
				Log.error("Unsuccessfully Not Visible Search Background Image");
			}

		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	//Click on Image
	public void ClickOnImage() throws InterruptedException{
		WaitForPageLoad();
		try {
			jsClick(L_image);
			ExtentSuccessMessage("Successfully Clicked ON Image");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on Document
	public void ClickOndocument() throws InterruptedException{
		WaitForPageLoad();
		try {
			jsClick(L_document);
			ExtentSuccessMessage("Successfully Clicked ON Document");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on Links
	public void ClickOnLinks() throws InterruptedException{
		WaitForPageLoad();
		try {
			jsClick(L_links);
			ExtentSuccessMessage("Successfully Clicked ON Links");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on Notifications
	public void ClickOnnotifications() throws InterruptedException{
		WaitForPageLoad();
		try {
			jsClick(L_notifications);
			ExtentSuccessMessage("Successfully Clicked ON N");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on Browse
	public void ClickOnBrowse() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(5000);
		try {
			jsClick(L_browse);
			ExtentSuccessMessage("Successfully Clicked ON Browse");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Add Image
	public void Addimage() throws InterruptedException{
		WaitForPageLoad();
		try {
			jsClick(img);
			ExtentSuccessMessage("Successfully Added Image");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Add Document
	public void Adddocument() throws InterruptedException{
		WaitForPageLoad();
		try {
			jsClick(document);
			ExtentSuccessMessage("Successfully Added Document");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on Close
	public void ClickOnClose() throws InterruptedException{
		WaitForPageLoad();
		try {
			jsClick(L_close);
			ExtentSuccessMessage("Successfully Clicked ON Close");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Enter Title
	public void AddTitle(String titlename) throws InterruptedException{
		WaitForPageLoad();
		try {
			jsClick(txt_title);
			input(txt_title, titlename);
			ExtentSuccessMessage("Successfully Entered Title");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Enter Text
	public void AddText(String Text) throws InterruptedException{
		WaitForPageLoad();
		try {
			jsClick(text);
			input(text, Text);
			ExtentSuccessMessage("Successfully Entered Text");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Enter URL
	public void Addurl(String URL) throws InterruptedException{
		WaitForPageLoad();
		try {
			jsClick(url);
			input(url, URL);
			ExtentSuccessMessage("Successfully Entered URL");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Click on Preview
	public void ClickOnPreview() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(btn_preview)) {
				ExtentSuccessMessage("Successfully displayed Preview");
				jsClick(btn_preview);
				ExtentSuccessMessage("Successfully Clicked ON Preview");
			} }catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	//Validate Preview Page
	public void validatePreview() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(L_header)) {	
				ExtentSuccessMessage("Successfully displayed Preview");
				SwitchBetweenTab(0);
			}} catch (Exception e) {
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

	//Click on Publish
	public void ClickOnPublish() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			if(ElementDisplayed(publish)) {
				ExtentSuccessMessage("Successfully displayed Publish");
				jsClick(publish);
				//RefreshPage();
				ExtentSuccessMessage("Successfully Clicked ON Publish");
				Thread.sleep(5000);
			} }catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	//Click on Image
	public void ClickOnUpload() throws InterruptedException{
		WaitForPageLoad();
		try {
			WebElement element = driver.findElement(By.cssSelector(".input-file"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).click().perform();
			ExtentSuccessMessage("Successfully Clicked ON Upload btn");

		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void search_Name(String titlename) throws InterruptedException {
		WaitForPageLoad();
		Thread.sleep(2000);
		if (ElementDisplayed(txt_search)) {
			Log.info("Successfully Visible Text Search");
			Thread.sleep(1000);
			jsClick(txt_search);
			input(txt_search, titlename);
			Log.info("Successfully Clicked On Text Search");
			click(L_SearchIcon);
			ExtentSuccessMessage("Successfully Search with Name");
		} else {
			Log.error("UnSuccessfully Not Visible Text Search");
			ExtentErrorMessage("UnSuccessfully Not Search with Name");
		}
	}
	//Add Document
	public void Selectdocument() throws InterruptedException{
		WaitForPageLoad();
		try {
			click(L_doc);
			ExtentSuccessMessage("Successfully Selected Document");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	//Fetch tiles Name
	public String FetchTilesName() {
		List<WebElement> element = driver.findElements(By.xpath("//ul//h5[@class='theme-text']"));
		String Value ="";
		for(WebElement elements: element) {
			Value =Value+","+elements.getText();

		}
		System.out.println("print values 1 "+Value);
		return Value;

	}

	//validate tiles
	public String ValidateTilesName(String tilesName,int Lenght) throws InterruptedException {
		List<WebElement> element = driver.findElements(By.xpath("//ul//h5[@class='theme-text']"));
		String Value ="";			
		for(WebElement elements:element) {
			Thread.sleep(10000);
			Value =elements.getText();
			if(tilesName.contains(Value)) {
				Log.info("Tiles name founded at landing page = "+Value);
				ExtentSuccessMessage("Tiles name founded at landing page = "+Value);				
			}else {
				Log.error("Tiles name not found at landing page = "+Value);
				ExtentErrorMessage("Tiles name not found at landing page = "+Value);
			}
		}
		//		ClickOnTiles();
		return Value;
	}
	//validate tiles
	public void ClickOnTiles() throws InterruptedException {
		List<WebElement> element = driver.findElements(By.xpath("//ul//h5[@class='theme-text']"));			
		for(WebElement elements:element) {
			String TilesName = elements.getText();
			System.out.println("Tiles Name = "+TilesName);
			if(elements.isDisplayed()) {	
				Thread.sleep(10000);
				elements.click();
				Thread.sleep(8000);
				WaitForPageLoad();
				WaitForLoadAnimationDisappear();
				Group_Page.navigateToGroupDashboard();
				PageRefresh();
				WaitForPageLoad();
				WaitForLoadAnimationDisappear();	
				Thread.sleep(10000);
			}else {
				Log.error("Tiles not visiable = "+TilesName);
				ExtentErrorMessage("Tiles not visiable = "+TilesName);
			}

		}

	}

	public String ValidatingBackgroundimage() {
		String Finalvalue =null;
		if(ElementDisplayed(BackgroundImage)) {
			ScrolltillElementOnmiddlepage(BackgroundImage);
			WebElement Element =driver.findElement(BackgroundImage);
			String styles =Element.getAttribute("style");
			String styleValue[] =styles.split("fileid=");
			String styleValues =styleValue[1];
			String value[] = styleValues.split("&fileType");
			Finalvalue = value[0];
			if(Finalvalue.length()>2) {
				ExtentSuccessMessage("Background Image is visible");
				if(ElementDisplayed(FullScreanbackgroundImage)) {
					ExtentSuccessMessage("Full Screen Background Image is visible");
				}else {
					ExtentErrorMessage("Full Screan Background Image is not visible");
				}
			}else {
				ExtentErrorMessage("Background Image is not visible");
			}
		}
		return Finalvalue;
	}
}
