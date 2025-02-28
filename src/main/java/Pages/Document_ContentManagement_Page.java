package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class Document_ContentManagement_Page extends Base_Class {

	private static By L_adddocument = By.xpath("//a[@class='adding-page btn btn-primary no-margin']");
	
	private static By L_docName = By.xpath("//div[@class='wrap']//div[@id='first-name']//input[@type='text']");
	
	private static By L_date = By.xpath("(//input[@class='tb1 hasDatepicker'])[3]");	
	
	private static By btn_adddocument = By.xpath("//a[@id='DocumentAdd']");
	
	private static By L_save = By.xpath("//i[normalize-space()='save']");
	
	private static By txt_search = By.xpath("//input[@placeholder='Search']");
	
	private static By search_icon = By.xpath("//span[@class='md-search-btn hr-theme-bg ']//i[@class='material-icons'][normalize-space()='search']");

	private static By L_yes = By.xpath("(//a[normalize-space()='Yes'])[2]");
	
	private String L_drpdownLabel = "//span[text()='Document']/../following-sibling::div//label[text()='%s']/../following-sibling::div//span[contains(text(),'Select')]/../..|//span[text()='Document']/../following-sibling::div//label[text()='%s']/following-sibling::div//span[contains(text(),'Select')]/../..";
	private static By btn_submit = By.xpath("//a[@title='Submit']");
	private static By btn_Yes = By.xpath("//div[contains(text(), 'The changes will be saved and submitted for review. Do you wish to continue?')]/following-sibling::div//a[contains(text(),'Yes')]");
	private static By L_Ok = By.xpath("//a[normalize-space()='Ok']");
	private static By L_Publish = By.xpath("//a[@title='Publish']");
	private static By btn_PublishYes = By.xpath("//div[contains(text(), 'The document will be published. Do you wish to continue?')]/following-sibling::div//a[contains(text(),'Yes')]");
	private static By L_close = By.xpath("//div[@docstatus='Draft']//div[@class='pop-header']//i[@class='material-icons'][normalize-space()='close']|//div[contains(@docstatus,'Submitted')]//div[contains(@class,'pop-header')]//i[contains(@class,'material-icons')][normalize-space()='close']");
	private static By delete_icon = By.xpath("//i[normalize-space()='delete']");
	
	public String name= null;
	
	//Click on Add Document
	public void ClickOnaddDocument() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			jsClick(L_adddocument);
			ExtentSuccessMessage("Successfully Clicked ON Add Document");
		} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
		}
	}
	
	//Enter Document Name
	public String Entername() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(5000);
		String name = "Document_"+ randomNumber(4);
		try {
			jsClick(L_docName);
			clear(L_docName);
			input(L_docName, name);
			System.out.println("Entered Name --> "+name);
			ExtentSuccessMessage("Successfully Entered Name");
		} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
		}
		return name;
	}
	
	//Enter Visibility Date
	public void enterVisibilityFromDate(String Date) throws InterruptedException{
		WaitForPageLoad();
		try {
			click(L_date);
			input(L_date,Date);
			Thread.sleep(3000);
			ExtentSuccessMessage("Successfully Entered Date");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Click on Add Document
	public void ClickOnAddDocument() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			jsClick(btn_adddocument);
			ExtentSuccessMessage("Successfully Added Document");
		} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
		}
	}
	
	//Click on Save
	public void ClickOnsave() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			jsClick(L_save);
			ExtentSuccessMessage("Successfully Clicked ON Save");
		} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
		}
	}
	
	//Search with Name
	public void search_Name(String name) throws InterruptedException {
		WaitForPageLoad();
		Thread.sleep(5000);
		if (ElementDisplayed(txt_search)) {
			Log.info("Successfully Visible Text Search");
			jsClick(txt_search);
			clear(txt_search);
			input(txt_search, name);
			Log.info("Successfully Clicked On Text Search");
			click(search_icon);
			ExtentSuccessMessage("Successfully Search with Name");
		} else {
			Log.error("UnSuccessfully Not Visible Text Search");
			ExtentErrorMessage("UnSuccessfully Not Search with Name");
		}
	}
	
	//Click on Yes
	public void clickonyes() throws InterruptedException{
		try {
			WaitForPageLoad();
			Thread.sleep(3000);
			jsClick(L_yes);
			Thread.sleep(3000);
			ExtentSuccessMessage("Successfully Clicked On Yes");
		} catch (Exception e) {
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
				   builder.moveToElement(driver.findElement(By.xpath(String.format(L_drpdownLabel, Fieldname,Fieldname)))).release().perform();
					ExtentSuccessMessage("Successfully Clicked ON " + Fieldname);
					input(By.xpath(String.format(L_drpdownLabel, Fieldname,Fieldname)), Accountname+Keys.ENTER);
					ExtentSuccessMessage("Successfully Selected "+Accountname);
					Thread.sleep(3000);
				} catch (Exception e) {
					// Handle the exception
					System.out.println("An exception occurred: " + e.getMessage());
					e.printStackTrace();
				}
			}
			
				//Click on Add Page
				public void ClickOnSubmitIcon() throws InterruptedException{
					WaitForPageLoad();
					Thread.sleep(2000);
					try {
						jsClick(btn_submit);
						ExtentSuccessMessage("Successfully Clicked ON Submit Icon");
						
						
					} catch (Exception e) {
					// Handle the exception
					System.out.println("An exception occurred: " + e.getMessage());
					e.printStackTrace();
					}
				}
				//Click on Yes and Ok on confirmation popups
					public void Confirmation() throws InterruptedException{
						
						WaitForPageLoad();
						try {
							jsClick(btn_Yes);
							ExtentSuccessMessage("Successfully Clicked ON Yes Icon");
							jsClick(L_Ok);
							ExtentSuccessMessage("Successfully Clicked ON OK Icon");
						} catch (Exception e) {
						// Handle the exception
						System.out.println("An exception occurred: " + e.getMessage());
						e.printStackTrace();
						}
					}
					
					//Click on Yes and Ok on confirmation popups
							public void PublishConfirmation() throws InterruptedException{
								WaitForPageLoad();
								try {
									jsClick(btn_PublishYes);
									ExtentSuccessMessage("Successfully Clicked ON Publish yes");
									
								} catch (Exception e) {
								// Handle the exception
								System.out.println("An exception occurred: " + e.getMessage());
								e.printStackTrace();
								}
							}
					//Click on Publish
					public void Publish() throws InterruptedException{
						WaitForPageLoad();
						try {
							jsClick(L_Publish);
							ExtentSuccessMessage("Successfully Clicked ON Publish Icon");				
							
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

					// Click on Delete Icon
					public void ClickOnDelete() throws InterruptedException {
						WaitForPageLoad();
						try {
							scrollDown();
							jsClick(delete_icon);
							ExtentSuccessMessage("Successfully Clicked On Delete Icon");
						} catch (Exception e) {
							// Handle the exception
							System.out.println("An exception occurred: " + e.getMessage());
							e.printStackTrace();
							}
						}

}
