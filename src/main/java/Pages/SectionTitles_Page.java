package Pages;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class SectionTitles_Page extends Base_Class {

	private static By btn_AddsectionTitle = By.xpath("//a[@class='btn btn-primary cd-btn js-cd-panel-trigger dummy2']");
	
	private static By txt_Name = By.xpath("//div[@class='col-md-6']//div//input[@type='text']");
	
	private static By txt_Description = By.xpath("//*[@id='AddSectionTitle']/div[1]/div[1]/div[1]/div[2]/input");
	
	private static By btn_createSectionTitle = By.xpath("//a[@class='btn btn-primary js-cd-close']//parent::li");
	
	private static By addNewDocument = By.xpath("//input[@id='New']");
	
	private static By addDocument = By.xpath("//a[@class='btn btn-primary cd-btn js-cd-panel-trigger']");
	
	private static By close_icon = By.xpath("//a[@class='cd-panel__close js-cd-close']");
	
	private static By btn_ok = By.xpath("(//a[normalize-space()='Ok'])[1]");
	
	private static By txt_Docname = By.xpath("//div[@id='first-name']//input[contains(@type,'text')]");
	
	private static By date = By.xpath("(//input[@class='tb1 hasDatepicker'])[1]");
	
	private static By selectdocument = By.xpath("//span[normalize-space()='Select a Document']");
	
	private static By btn_updateSectionTitle = By.xpath("//a[@class='btn btn-primary js-cd-close']");
	
	private static By L_removeRelation = By.xpath("//i[@class='material-icons theme-color']");
	
	private static By L_Yes = By.xpath("(//a[normalize-space()='Yes'])[2]");
	
	private static By L_yes = By.xpath("(//a[normalize-space()='Yes'])[1]");
	
	private static By L_Ok = By.xpath("//a[normalize-space()='Ok']|(//a[normalize-space()='Ok'])[1]");
	
	private static By btn_back = By.xpath("//span[contains(@class,'btn-primary')]");
	
	private static By L_Account = By.xpath("(//*[@class='multiselect'])[2]");
	private static By L_Account1 = By.xpath("(//*[@class='multiselect'])[4]");

	private static By L_BusinessSegment = By.xpath("(//*[@class='multiselect'])[1]");
	
	private static By delete_icon = By.xpath("//i[contains(@title,'Delete')]|(//i[normalize-space()='delete_forever'])[1]");
	private static By L_export = By.xpath("//i[normalize-space()='file_download']");
	private static By L_UploadOk = By.xpath("//div[contains(text(),'The image has been uploaded successfully.')]/following-sibling::div//a");
	private String L_drpdownLabel = "//*[contains(text(),'Section Title')]/../following-sibling::div//label[text()='%s']/following-sibling::div//span[contains(text(),'Select')]/../..";
	public String title= null;
	
	//Click on Add Section Title
	public void ClickOnaddsectionTitle() throws InterruptedException{
		try{
		WaitForPageLoad();
		Thread.sleep(2000);
		if(ElementDisplayed(btn_AddsectionTitle)) {
			Log.info("Successfully Visible AddsectionTitle");
			click(btn_AddsectionTitle);
			Log.info("Successfully Clicked On AddsectionTitle");
			ExtentSuccessMessage("Successfully Clicked On AddsectionTitle");
			WaitForLoadAnimationDisappear();
		}else {
			Log.error("UnSuccessfully Not Visible AddsectionTitle");
			ExtentErrorMessage("UnSuccessfully Not Visible AddsectionTitle");
		}
	}catch (Exception e) 
			{
		  // Handle the exception
		  System.out.println("An exception occurred: " + e.getMessage());
		  e.printStackTrace();
			}
	}
	
	//Enter Section Title Name
	public void sectionTitleName() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
		if(ElementDisplayed(txt_Name)) {
			Log.info("Successfully Visible SectionTitle Name");
			Thread.sleep(1000);
			jsClick(txt_Name);
			Thread.sleep(1000);
			String title = "SectionTitle_"+ randomNumber(4);
			input(txt_Name, title);
			this.title=title;
			System.out.println("Section Title --> "+title);
			Log.info("Successfully Clicked On SectionTitle Name");
			ExtentSuccessMessage("Successfully Clicked On SectionTitle Name");
		}else {
			Log.error("UnSuccessfully Not Visible SectionTitle Name");
			ExtentErrorMessage("UnSuccessfully Not Visible SectionTitle Name");
		}
		}catch (Exception e) 
 			{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
 			}
	}
	
	//Enter Section Title Description
	public void sectionTitleDescription() throws InterruptedException{
		Thread.sleep(2000);
		try {
		if(ElementDisplayed(txt_Description)) {
			Log.info("Successfully Visible SectionTitle Description");
			click(txt_Description);
			input(txt_Description, "A document explained use portal");
			Log.info("Successfully Clicked On SectionTitle Description");
			ExtentSuccessMessage("Successfully Clicked On SectionTitle Description");
		}else {
			Log.error("UnSuccessfully Not Visible SectionTitle Description");
			ExtentErrorMessage("UnSuccessfully Not Visible SectionTitle Description");
		}
		}catch (Exception e) 
			{
		  // Handle the exception
		  System.out.println("An exception occurred: " + e.getMessage());
		  e.printStackTrace();
			}
	}
	
	//Click on Document CheckBox
	public void ClickOnDocCheckbox(String value) throws InterruptedException{
		WaitForPageLoad();
		try {
		Thread.sleep(5000);
	   	By checkbox = By.xpath("(//input[@type='checkbox'])["+value+"]");
		if(ElementDisplayed(checkbox)) {
			Log.info("Successfully Visible Checkbox");
			jsClick(checkbox);
			Log.info("Successfully Clicked On Checkbox");
			ExtentSuccessMessage("Successfully Clicked On Checkbox");
		}else {
			Log.error("UnSuccessfully Not Visible Checkbox");
			ExtentErrorMessage("UnSuccessfully Not Visible Checkbox");
		}
		}catch (Exception e) 
			{
		  // Handle the exception
		  System.out.println("An exception occurred: " + e.getMessage());
		  e.printStackTrace();
			}
	}
	//Click on Document checkbox as per Status
	
		public void ClickOnDocCheckboxAsPerStatus(String value) throws InterruptedException{
			try {
		   	//By checkbox = By.xpath("(//input[@type='checkbox'])["+value+"]");
			By checkbox = By.xpath("(//tr/td[@title='"+value+"']/preceding-sibling::td[5])[1]//input[@type='checkbox']");
			if(ElementDisplayed(checkbox)) {
				Log.info("Successfully Visible Checkbox");
				jsClick(checkbox);
				Log.info("Successfully Clicked On Checkbox");
				ExtentSuccessMessage("Successfully Clicked On Checkbox");
			}else {
				Log.error("UnSuccessfully Not Visible Checkbox");
				ExtentErrorMessage("UnSuccessfully Not Visible Checkbox");
			}
			}catch (Exception e) 
 			{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
 			}
		}
		

	//Click on Create Section Title
	public void ClickOnCreatesectionTitle() throws InterruptedException{
//		WaitForPageLoad();
		try {
		scrollDown();
		if(ElementDisplayed(btn_createSectionTitle)) {
			Log.info("Successfully Visible CreatesectionTitle");
			Thread.sleep(5000);
			click(btn_createSectionTitle);
			Thread.sleep(1000);
			Log.info("Successfully Clicked On CreatesectionTitle");
			ExtentSuccessMessage("Successfully Clicked On CreatesectionTitle");
			WaitForLoadAnimationDisappear();
		}else {
			Log.error("UnSuccessfully Not Visible CreatesectionTitle");
			ExtentErrorMessage("UnSuccessfully Not Visible CreatesectionTitle");
		}
		}catch (Exception e) 
			{
		  // Handle the exception
		  System.out.println("An exception occurred: " + e.getMessage());
		  e.printStackTrace();
			}
	}
	
	//Click on Add New Document
	public void ClickOnaddnewdocument() throws InterruptedException{
		Thread.sleep(2000);
		try {
		if(ElementDisplayed(addNewDocument)) {
			Log.info("Successfully Visible Addnewdocument");
			jsClick(addNewDocument);
			Log.info("Successfully Clicked On Addnewdocument");
			ExtentSuccessMessage("Successfully Clicked On Addnewdocument");
		}else {
			Log.error("UnSuccessfully Not Visible Addnewdocument");
			ExtentErrorMessage("UnSuccessfully Not Visible Addnewdocument");
		}
		}catch (Exception e) 
			{
		  // Handle the exception
		  System.out.println("An exception occurred: " + e.getMessage());
		  e.printStackTrace();
			}
	}
	
	//Click on Close Icon
	public void ClickOnClose() throws InterruptedException{
		WaitForPageLoad();
		try {
		if(ElementDisplayed(close_icon)) {
			Log.info("Successfully Visible Close Icon");
			click(close_icon);
			Log.info("Successfully Clicked On Close Icon");
			ExtentSuccessMessage("Successfully Clicked On Close Icon");
		}else {
			Log.error("UnSuccessfully Not Visible Close Icon");
			ExtentErrorMessage("UnSuccessfully Not Visible Close Icon");
		}
		}catch (Exception e) 
			{
		  // Handle the exception
		  System.out.println("An exception occurred: " + e.getMessage());
		  e.printStackTrace();
			}
	}
	
	//Click on OK button
	public void ClickonOK() throws InterruptedException{
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		Thread.sleep(8000);
		try {
		Thread.sleep(8000);
		waitForElementClickable(btn_ok);
		if(ElementDisplayed(btn_ok)) {
			Log.info("Successfully Visible OK");
			jsClick(btn_ok);
			Thread.sleep(2000);
			Log.info("Successfully Clicked On OK");
			ExtentSuccessMessage("Successfully Clicked OK");
			Thread.sleep(10000);
			WaitForLoadAnimationDisappear();
			WaitForPageLoad();
		}else {
			Log.error("UnSuccessfully Not Visible OK");
			ExtentErrorMessage("UnSuccessfully Not Visible OK");
		}
		WaitForLoadAnimationDisappear();
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		Thread.sleep(8000);
		}catch (Exception e) 
			{
		  // Handle the exception
		  System.out.println("An exception occurred: " + e.getMessage());
		  e.printStackTrace();
			}
	}
	
	//Enter Document Name
	public String enterDocName() throws InterruptedException{
		WaitForPageLoad();
		String doc_name="Document_"+ randomNumber(4);
		try {
		if(ElementDisplayed(txt_Docname)) {
			Log.info("Successfully Visible Document Name");
			jsClick(txt_Docname);
			Log.info("Successfully Clicked On Document Name");
			input(txt_Docname,doc_name);
			ExtentSuccessMessage("Successfully Entered Document Name");
		}else {
			Log.error("UnSuccessfully Not Visible Document Name");
			ExtentErrorMessage("UnSuccessfully Not Visible Document Name");
		}}catch (Exception e) 
			{
		  // Handle the exception
		  System.out.println("An exception occurred: " + e.getMessage());
		  e.printStackTrace();
			}
		return doc_name;
	}
	
		//Enter Visibility From Date
		public void enterVisibilityFromDate(String Date) throws InterruptedException{
			WaitForPageLoad();
			try {
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
			}catch (Exception e) 
 			{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
 			}
		}
		
		//Select Documents
		public void selectwordDocs() throws InterruptedException, AWTException{
			scrollDown();
			WaitForPageLoad();
			try {
			if(ElementDisplayed(selectdocument)) {
				Log.info("Successfully Visible select document");
				click(selectdocument);
				ExtentSuccessMessage("Successfully Clicked on Select document btn");
				UploadDocument_Word();
				Log.info("Successfully Clicked On selectdocument");
				ExtentSuccessMessage("Successfully Uploaded word document");
			}else {
				Log.error("UnSuccessfully Not Visible selectdocument");
				ExtentErrorMessage("UnSuccessfully Not Visible selectdocument");
			}
			}catch (Exception e) 
 			{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
 			}
		}
		


//		public void selectExcel_PDF_Docs() throws InterruptedException, AWTException{

		public void select_Excel() throws InterruptedException, AWTException{

			scrollDown();
			WaitForPageLoad();
			try {
			if(ElementDisplayed(selectdocument)) {
				Log.info("Successfully Visible select document");
				click(selectdocument);
				ExtentSuccessMessage("Successfully Clicked on Select document btn");
				UploadDocument_Excel();
				Log.info("Successfully Clicked On selectdocument");
				ExtentSuccessMessage("Successfully Uploaded Excel file");
			}else {
				Log.error("UnSuccessfully Not Visible selectdocument");
				ExtentErrorMessage("UnSuccessfully Not Visible selectdocument");
			}
			}catch (Exception e) 
 			{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
 			}
		}
		public void select_PDF() throws InterruptedException, AWTException{
			scrollDown();
			WaitForPageLoad();
			try {
			if(ElementDisplayed(selectdocument)) {
				Log.info("Successfully Visible select document");
				click(selectdocument);
				ExtentSuccessMessage("Successfully Clicked on Select document btn");
				UploadDocument_Pdf();
				Log.info("Successfully Clicked On selectdocument");
				ExtentSuccessMessage("Successfully Uploaded PDF document");
			}else {
				Log.error("UnSuccessfully Not Visible selectdocument");
				ExtentErrorMessage("UnSuccessfully Not Visible selectdocument");
			}
			}catch (Exception e) 
 			{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
 			}
		}

		//Press Enter
		public void Enter() throws InterruptedException, AWTException {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		
		//Upload Document
		public void UploadDocument_Word() throws InterruptedException, AWTException {
			Thread.sleep(1000);
			try {
			StringSelection stringSelection = new StringSelection(
					System.getProperty("user.dir") + "\\Upload\\Testworddoc.docx");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			Thread.sleep(3000);
			Paste();
			Thread.sleep(2000);
			Enter();
			}catch (Exception e) 
 			{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
 			}
		}

		//
		public void UploadDocument_Excel() throws InterruptedException, AWTException {
			Thread.sleep(1000);
			try {
			StringSelection stringSelection = new StringSelection(
					System.getProperty("user.dir") + "\\Upload\\TestExcelFile.xlsx"); 
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			Thread.sleep(3000);
			Paste();
			Thread.sleep(2000);
			Enter();
			}catch (Exception e) 
 			{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
 			}
		}
		public void UploadDocument_Pdf() throws InterruptedException, AWTException {
			Thread.sleep(1000);
			try {
			StringSelection stringSelection = new StringSelection(
					System.getProperty("user.dir") + "\\Upload\\TestPdfFile.pdf"); 
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			Thread.sleep(3000);
			Paste();
			Thread.sleep(2000);
			Enter();
			}catch (Exception e) 
 			{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
 			}
		}

		//Click on Update Section Title
		public void ClickonUpdateSectionTitle() throws InterruptedException{
			Thread.sleep(5000);
			try {
			if(ElementDisplayed(btn_updateSectionTitle)) {
				Log.info("Successfully Visible select Update Section Title");
				Thread.sleep(5000);
				jsClick(btn_updateSectionTitle);
				Thread.sleep(1000);
				ExtentSuccessMessage("Successfully Clicked On Update Section Title");
			}else {
				Log.error("UnSuccessfully Not Visible Update Section Title");
				ExtentErrorMessage("UnSuccessfully Not Clicked On Update Section Title");
			}
			}catch (Exception e) 
 			{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
 			}
		}
		
		//Click on Remove Relation
		public void clickonRemoveRelation() throws InterruptedException{
			WaitForPageLoad();
			try {
			if(ElementDisplayed(L_removeRelation)) {
				Log.info("Successfully Visible Remove Relation");
				jsClick(L_removeRelation);
				ExtentSuccessMessage("Successfully Clicked On Remove Relation");
			}else {
				Log.error("UnSuccessfully Not Visible Remove Relation");
				ExtentErrorMessage("UnSuccessfully Not Clicked On Remove Relation");
			}
			}catch (Exception e) 
 			{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
 			}
		}
		
		//Click on Yes
		public void clickonYes_OK() throws InterruptedException{
			WaitForPageLoad();
			Thread.sleep(2000);
			try {
			if(ElementDisplayed(L_Yes)) {
				Log.info("Successfully Visible Confirmation Popup");
				jsClick(L_Yes);
				ExtentSuccessMessage("Successfully Clicked On Yes");
				WaitForPageLoad();
				jsClick(L_Ok);
				ExtentSuccessMessage("Successfully Clicked On OK");
			}else {
				Log.error("UnSuccessfully Not Visible Confirmation Popup");
				ExtentErrorMessage("UnSuccessfully Not Clicked On Yes");
				ExtentErrorMessage("UnSuccessfully Not Clicked On OK");
			}
			}catch (Exception e) 
 			{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
 			}
		}
		
		//Click on Yes
		public void clickonyes_OK() throws InterruptedException{
			WaitForPageLoad();
			Thread.sleep(2000);
			try {
			if(ElementDisplayed(L_yes)) {
				Log.info("Successfully Visible Confirmation Popup");
				jsClick(L_yes);
				ExtentSuccessMessage("Successfully Clicked On Yes");
				WaitForPageLoad();
				jsClick(L_Ok);
				ExtentSuccessMessage("Successfully Clicked On OK");
			}else {
				Log.error("UnSuccessfully Not Visible Confirmation Popup");
				ExtentErrorMessage("UnSuccessfully Not Clicked On Yes");
				ExtentErrorMessage("UnSuccessfully Not Clicked On OK");
			}
			}catch (Exception e) 
 			{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
 			}
		}
		//Click on Yes
		public void clickonyes() throws InterruptedException{
			WaitForPageLoad();
			Thread.sleep(2000);
			try {
			if(ElementDisplayed(L_yes)) {
				Log.info("Successfully Visible Confirmation Popup");
				jsClick(L_yes);
				ExtentSuccessMessage("Successfully Clicked On Yes");
			}else {
				ExtentErrorMessage("UnSuccessfully Not Clicked On Yes");
				
			}
			}catch (Exception e) 
 			{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
 			}
		}
		
		//Click on Back Button
		public void clickonBack() throws InterruptedException{
			WaitForPageLoad();
			try {
			if(ElementDisplayed(btn_back)) {
				Log.info("Successfully Visible Back Button");
				jsClick(btn_back);
				ExtentSuccessMessage("Successfully Clicked On Back Button");
			}else {
				Log.error("UnSuccessfully Not Visible Back Button");
				ExtentErrorMessage("UnSuccessfully Not Clicked On Back Button");
			}
			}catch (Exception e) 
 			{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
 			}
		}
		
		
		//Click on Add Document
		public void ClickOnadddocument() throws InterruptedException{
			WaitForPageLoad();
			try{
			if(ElementDisplayed(addDocument)) {
				Log.info("Successfully Visible AddDocument");
				jsClick(addDocument);
				Log.info("Successfully Clicked On AddDocument");
				ExtentSuccessMessage("Successfully Clicked On AddDocument");
			}else {
				Log.error("UnSuccessfully Not Visible AddDocument");
				ExtentErrorMessage("UnSuccessfully Not Visible AddDocument");
			}
			}catch (Exception e) 
 			{
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
				if(ElementEnabled(L_Account)) {
					Actions builder = new Actions(driver);
				      builder.moveToElement(driver.findElement(L_Account)).release().perform();
					ExtentSuccessMessage("Successfully Clicked ON Account");
					input(L_Account, Accountname+Keys.ENTER);
					ExtentSuccessMessage("Successfully Selected AccountName");
					Thread.sleep(3000);
				}else if(ElementEnabled(L_Account1)) {
					Actions builder = new Actions(driver);
				      builder.moveToElement(driver.findElement(L_Account1)).release().perform();
					ExtentSuccessMessage("Successfully Clicked ON Account");
					input(L_Account, Accountname+Keys.ENTER);
					ExtentSuccessMessage("Successfully Selected AccountName");
					Thread.sleep(3000);
				}
				
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
			
			//Click on Export Icon
			public void clickonExport() throws InterruptedException{
				WaitForPageLoad();
				try {
				if(ElementDisplayed(L_export)) {
					Log.info("Successfully Visible Export Icon");
					jsClick(L_export);
					ExtentSuccessMessage("Successfully Clicked On Export Icon");
				}else {
					Log.error("UnSuccessfully Not Visible Export Icon");
					ExtentErrorMessage("UnSuccessfully Not Clicked On Export Icon");
				}
				}catch (Exception e) 
	 			{
				  // Handle the exception
				  System.out.println("An exception occurred: " + e.getMessage());
				  e.printStackTrace();
	 			}
			}
			//Upload Document
			public void UploadImage() throws InterruptedException, AWTException {
				
				Thread.sleep(1000);
				try {
				StringSelection stringSelection = new StringSelection(
						System.getProperty("user.dir") + "\\Upload\\UploadTest.jpg");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
				Thread.sleep(3000);
				Paste();
				Thread.sleep(2000);
				Enter();
				}catch (Exception e) 
	 			{
				  // Handle the exception
				  System.out.println("An exception occurred: " + e.getMessage());
				  e.printStackTrace();
	 			}
			}
			
			
			//Upload Document
			public void UploadImageConfirmation() throws InterruptedException, AWTException {
				try {
					WaitForPageLoad();
					WaitForLoadAnimationDisappear();
				if(ElementDisplayed(L_UploadOk)) {
					Log.info("Successfully Visible Export Icon");
					jsClick(L_UploadOk);
					ExtentSuccessMessage("Successfully Clicked On OK popup");
				}else {
					Log.error("UnSuccessfully Not Visible OK ");
					ExtentErrorMessage("UnSuccessfully Not Clicked On OK popup");
				}
				}catch (Exception e) 
	 			{
				  // Handle the exception
				  System.out.println("An exception occurred: " + e.getMessage());
				  e.printStackTrace();
	 			}
		}
			//Select Audience - Business Segment or Account
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
