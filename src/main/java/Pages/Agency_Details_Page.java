package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.github.javafaker.Faker;

public class Agency_Details_Page extends Base_Class {

	public static By L_AgencyName = By.xpath("//div[@class='modal-wrapper']//div[@class='col-md-4 col-sm-6 col-xs-12']/div[1]/div[1]/input[@class='tb1']");
	public static By L_clickEditButton = By.xpath("//i[@class='material-icons theme-text font-md']");
	public static By L_SaveButton = By.xpath("//input[@id='btnSave']");
	public static By L_OKButton = By.xpath("//a[contains(.,'Ok')]");
	//	public static By L_clickAddContact = By.xpath("//div[@class='col-md-9 col-sm-9 col-xs-12 text-right']//li[3]/div[@class='btn btn-primary noti-btn  no-margin']");
	public static By L_clickAddContact = By.xpath("//*[contains(text(),' Add Contact')]");
	public static By L_SFEntityId = By.xpath("//div[@class='modal-container large']//div[@class='row']/div[1]/div[1]/input[@class='tb1']");
	public static By L_FirstName = By.xpath("//div[@class='modal-container large']//div[@class='row']/div[2]//input[@class='tb1']");
	public static By L_PrimaryContact = By.xpath("//*[@id=\"primaryCheckContact\"]");
	public static By L_LastName = By.xpath("//div[@class='modal-container large']//div[3]//input[@class='tb1']");
	public static By L_PhoneNumber = By.xpath("//div[@class='modal-container large']//div[4]//input[@class='tb1']");
	public static By L_Email = By.xpath("//div[@class='row-height']//input[@class='tb1']");
	public static By L_RequestOnlineAccess = By.xpath("//*[@id='btnRQA']");
	public static By L_SendNotification = By.xpath("//div[@class='col-md-9 col-sm-9 col-xs-12 text-right']//li[4]/div[@class='btn btn-primary noti-btn  no-margin']");
	public static By L_AddAccountButton = By.xpath("//div[@class='btn btn-primary no-margin']");
	public static By L_AccountName = By.xpath("//span[contains(@data-tooltip,'ADCDivision')]");
	public static By L_CloseButton = By.xpath("//ul[@class='controls']//i[@class='material-icons']");
	public static By btn_Terminate = By.xpath("//button[@class='btn btn-primary no-margin']");
	public static By L_checkbox = By.xpath("(//input[@type='checkbox'])[2]");
	public static By L_TerminateButton = By.xpath("//*[@id='btnContactTerminate'] | //*[contains(text(),'Terminate')]");
	public static By L_YesButton = By.xpath("(//a[contains(.,'Yes')])[2]");
	public static By L_YesButton1 = By.xpath("(//a[contains(.,'Yes')])[1]");
	public static By L_ContactName = By.xpath("//*[contains(@href,'#/ContactDetails/')]");

	/////Click on Edit Button/////
	public void ClickOnEditButton() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_clickEditButton)) {
				Log.info("Successfully Edit Button is visible");
				click(L_clickEditButton);
				Log.info("Successfully Clicked On Edit Button");
				ExtentSuccessMessage("Successfully Clicked On Edit Button");
			}else {
				Log.error("UnSuccessfully not clicked On Edit Button");
				ExtentErrorMessage("UnSuccessfully not clicked On Edit Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Edit the Agency Name/////
	public String EditAgencyName() throws InterruptedException {
		Faker faker = new Faker();
		String strAgencyname = faker.name().firstName() + "'s Agency";
		Log.info("First Name"+strAgencyname);
		clear(L_AgencyName);
		input(L_AgencyName, strAgencyname);
		ExtentSuccessMessage("First Name: " + strAgencyname);
		return strAgencyname;
	}

	/////Click on Save Button/////
	public void ClickOnSaveButton() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_SaveButton)) {
				Log.info("Successfully Save button is visible");
				click(L_SaveButton);
				Log.info("Successfully Clicked On Save Button");
				ExtentSuccessMessage("Successfully Clicked On Save Button");
			}else {
				Log.error("UnSuccessfully not clicked On Save Button");
				ExtentErrorMessage("UnSuccessfully not clicked On Save Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Click On OK Button/////
	public void ClickOnOKButton() throws InterruptedException{
		try {	
			Thread.sleep(5000);
			WaitForPageLoad();
			if(ElementDisplayed(L_OKButton)) {
				Log.info("Successfully OK button is visible");
				jsClick(L_OKButton);
				Log.info("Successfully Clicked On OK Button");
				ExtentSuccessMessage("Successfully Clicked On OK Button");
			}else {
				Log.error("UnSuccessfully not clicked On OK Button");
				ExtentErrorMessage("UnSuccessfully not clicked On OK Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Click on Add Contact Name/////
	public void ClickOnAddContactButton() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_clickAddContact)) {
				Log.info("Successfully Add Contact Button is visible");
				click(L_clickAddContact);
				Log.info("Successfully Clicked On Add Contact Button");
				ExtentSuccessMessage("Successfully Clicked On Add Contact Button");
			}else {
				Log.error("UnSuccessfully not clicked On Add Contact Button");
				ExtentErrorMessage("UnSuccessfully not clicked On Add Contact Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Enter SF Entity Id/////
	public void EnterSFEntityId() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_SFEntityId)) {
				Log.info("Successfully SF Entity Id field is visible");
				click(L_SFEntityId);
				input(L_SFEntityId, randomNumber(6)+"");
				Log.info("Successfully SF Entity Id field value is entered");
				ExtentSuccessMessage("Successfully SF Entity Id field value is entered");
			}else {
				Log.error("UnSuccessfully SF Entity Id field value is not entered");
				ExtentErrorMessage("UnSuccessfully SF Entity Id field value is not entered");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Enter Personal Details/////
	public String EnterPersonalDetails() throws InterruptedException {
		Faker faker = new Faker();
		String strFirstname = faker.name().firstName();
		System.out.println("First Name: "+strFirstname);
		input(L_FirstName, strFirstname);
		ExtentSuccessMessage("Successfully entered the First Name: "+ strFirstname);
		String strLastname = faker.name().lastName();
		System.out.println("Last Name: "+strLastname);
		input(L_LastName, strLastname);
		ExtentSuccessMessage("Last Name: " + strLastname);
		ExtentSuccessMessage("Successfully entered the Last Name: "+ strLastname);
		jsClick(L_PrimaryContact);
		Log.info("Successfully Clicked On Primary Contact Checkbox");
		ExtentSuccessMessage("Successfully Clicked On Primary Contact Checkbox");
		click(L_PhoneNumber);
		input(L_PhoneNumber, getRandomPhoneNumber());
		Log.info("Successfully Phone Number value is entered");
		ExtentSuccessMessage("Successfully Phone Number value is entered");
		click(L_Email);
		input(L_Email, strFirstname + "_" + strLastname + "@gmail.com");
		Log.info("Successfully Email value is entered");
		ExtentSuccessMessage("Successfully Email value is entered");
		return strFirstname +" "+strLastname;
	}

	/////Click on Request Online Access/////
	public void ClickOnRequestOnlineAccess() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_RequestOnlineAccess)) {
				Log.info("Successfully Request Online Access is visible");
				click(L_RequestOnlineAccess);
				Log.info("Successfully Clicked On Request Online Access");
				ExtentSuccessMessage("Successfully Clicked On Request Online Access");
			}else {
				Log.error("UnSuccessfully not clicked On Request Online Access");
				ExtentErrorMessage("UnSuccessfully not clicked On Request Online Access");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Click on Agency Contact/////
	public void ClickOnContactNameInGrid(String ContactName) throws InterruptedException {
		try {
			WaitForPageLoad();
			String targetUsername = ContactName;
			String xpathExpression = "//a[contains(@href, 'ContactDetails') and normalize-space(.//span[@class='btn-link'])='"+targetUsername+"']";

			// Find the first matching element
			WebElement contactNameElement = driver.findElement(By.xpath(xpathExpression));
			// Click the element
			contactNameElement.click();
			Log.info("Successfully Clicked On Contact name in grid");
			ExtentSuccessMessage("Successfully Clicked On Contact name in grid");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Click on Add Account Button/////
	public void ClickOnAddAccountButton() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_AddAccountButton)) {
				Log.info("Successfully Add Account is visible");
				click(L_AddAccountButton);
				Log.info("Successfully Clicked On Add Account Button");
				ExtentSuccessMessage("Successfully Clicked On Add Account Button");
			}else {
				Log.error("UnSuccessfully not clicked On Add Account Button");
				ExtentErrorMessage("UnSuccessfully not clicked On Add Account Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Click on the Account Name/////
	public void ClickOnAccountName() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_AccountName)) {
				Log.info("Successfully Account Name is visible");
				click(L_AccountName);
				Log.info("Successfully Clicked On Account Name");
				ExtentSuccessMessage("Successfully Clicked On  Account Name");
			}else {
				Log.error("UnSuccessfully not clicked On  Account Name");
				ExtentErrorMessage("UnSuccessfully not clicked On Account Name");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Click on Close Button/////
	public void ClickOnCloseButton() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_CloseButton)) {
				Log.info("Successfully Close Button is visible");
				click(L_CloseButton);
				Log.info("Successfully Clicked On Close Button");
				ExtentSuccessMessage("Successfully Clicked On Close Button");
			}else {
				Log.error("UnSuccessfully not clicked On Close Button");
				ExtentErrorMessage("UnSuccessfully not clicked On Close Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Click on Checkbox Corresponding to the Contact Name/////
	public void ClickOnCheckboxofContactName(String ContactName) throws InterruptedException {
		try {
			WaitForPageLoad();
			String targetUsername = ContactName;
			//			String xpathExpression = "//td[div/a/span[contains(text(),'"+targetUsername+"')]]/preceding-sibling::td[@class='text-center']//div[@class='md-checkbox no-label']";    //Did some changes
			String xpathExpression = "//*[contains(text(),'"+targetUsername+"')]//ancestor::tr//*[@class='text-center']//div[@class='md-checkbox no-label']";

			// Find the first matching element
			WebElement contactNameElement = driver.findElement(By.xpath(xpathExpression));
			// Click the element
			contactNameElement.click();
			Log.info("Successfully Clicked On the Checkbox of Contact name in grid");
			ExtentSuccessMessage("Successfully Clicked On Checkbox of Contact name in grid");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Click on the Send Notifications/////
	public void ClickOnSendNotificationButton() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_SendNotification)) {
				Log.info("Successfully Send Notification Button is visible");
				click(L_SendNotification);
				Log.info("Successfully Clicked On Send Notification Button");
				ExtentSuccessMessage("Successfully Clicked On Send Notification Button");
			}else {
				Log.error("UnSuccessfully not clicked On Send Notification Button");
				ExtentErrorMessage("UnSuccessfully not clicked On Send Notification Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Click on Terminate Button/////
	public void ClickOnTerminateButton() throws InterruptedException{
		try {	
			WaitForPageLoad();
			Thread.sleep(5000);
			if(ElementDisplayed(L_TerminateButton)) {
				Log.info("Successfully Terminate Button is visible");
				click(L_TerminateButton);
				Log.info("Successfully Clicked On Terminate Button");
				ExtentSuccessMessage("Successfully Clicked On Terminate Button");
				WaitForPageLoad();
			}else {
				Log.error("UnSuccessfully not clicked On Terminate Button");
				ExtentErrorMessage("UnSuccessfully not clicked On Terminate Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	/////Click on Terminate/////
	public void ClickOnTerminate() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(btn_Terminate)) {
				Log.info("Successfully Terminate Button is visible");
				click(btn_Terminate);
				Log.info("Successfully Clicked On Terminate Button");
				ExtentSuccessMessage("Successfully Clicked On Terminate Button");
			}else {
				Log.error("UnSuccessfully not clicked On Terminate Button");
				ExtentErrorMessage("UnSuccessfully not clicked On Terminate Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Click on Checkbox/////
	public void ClickOnCheckbox() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_checkbox)) {
				Log.info("Successfully Checkbox is visible");
				jsClick(L_checkbox);
				Log.info("Successfully Clicked On Checkbox");
				ExtentSuccessMessage("Successfully Clicked On Checkbox");
			}else {
				Log.error("UnSuccessfully not clicked On Checkbox");
				ExtentErrorMessage("UnSuccessfully not clicked On Checkbox");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	/////Click on Yes Button/////
	public void ClickOnYesButton() throws InterruptedException{
		try {	
			Thread.sleep(5000);
			WaitForPageLoad();
			if(ElementDisplayed(L_YesButton)) {
				Log.info("Successfully Yes button is visible");
				click(L_YesButton);
				Log.info("Successfully Clicked On Yes Button");
				ExtentSuccessMessage("Successfully Clicked On Yes Button");
			}else {
				Log.info("UnSuccessfully not clicked On Yes Button");
				ExtentSuccessMessage("UnSuccessfully not clicked On Yes Button");
				if(ElementDisplayed(L_YesButton1)) {
					Log.info("Successfully Yes button is visible");
					click(L_YesButton1);
					Log.info("Successfully Clicked On Yes Button");
					ExtentSuccessMessage("Successfully Clicked On Yes Button");
				}else {
					Log.error("UnSuccessfully not clicked On Yes Button");
					ExtentErrorMessage("UnSuccessfully not clicked On Yes Button");
				}
			}
		}
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Validate the updated Agency Name/////
	public void UpdatedAgencyNameValidation(String expectedAgencyName) {
		try {
			// Use XPath to locate the specific label with text "Agency Name" and then navigate to the corresponding td element
			WebElement agencyNameElement = driver.findElement(By.xpath("//label[text()='Agency Name']/following-sibling::td"));
			String actualAgencyName = agencyNameElement.getText().trim();
			if (actualAgencyName.equals(expectedAgencyName)) {
				Log.info("Agency name is valid: " + actualAgencyName);
				ExtentSuccessMessage("Agency name is valid: " + actualAgencyName);
			} else {
				Log.error("Agency name is not valid. Expected: " + expectedAgencyName + ", Actual: " + actualAgencyName);
				ExtentErrorMessage("Agency name is not valid. Expected: " + expectedAgencyName + ", Actual: " + actualAgencyName);
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void ClickOnContactName() {
		try {	
			Thread.sleep(5000);
			WaitForPageLoad();
			if(ElementDisplayed(L_ContactName)) {
				Log.info("Successfully Contact Name button is visible");
				click(L_ContactName);
				Log.info("Successfully Clicked On Contact Name Button");
				ExtentSuccessMessage("Successfully Clicked On Contact Name Button");
			}else {
				Log.error("UnSuccessfully not clicked On Contact Name Button");
				ExtentErrorMessage("UnSuccessfully not clicked On Contact Name Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
