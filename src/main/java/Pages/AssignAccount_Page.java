package Pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class AssignAccount_Page extends Base_Class{

	private static By txtSearchId = By.xpath("//input[@type='text' and @placeholder='Search' and @class='form-control']");
	private static By searchButton = By.xpath("//span[@class='md-search-btn hr-theme-bg']");
	public static By L_AddPersonButton = By.xpath("(//a[@data-toggle='collapse' and @data-target='#02' and normalize-space(.//i[@class='material-icons theme-text'])='person_add'])[1]");
	public static By L_BORStartDate = By.xpath("//input[@placeholder='MM/DD/YYYY' and following::input[@id='BorEndDate'] and not(contains(@id, 'DateOfBirth'))][1]");
	public static By L_BOREndDate = By.xpath("//input[@id='BorEndDate']");
	public static By L_AccountPrimaryContact = By.id("primaryCheck");
	public static By L_SaveButton = By.xpath("//input[@id='btnSave']");
	public static By L_OKButton = By.xpath("//a[contains(.,'Ok')]");
	public static By L_BackButton = By.xpath("//span[@class='btn  btn-primary no-margin']");
	public static By L_BrokerTPAOfficeStaff = By.xpath("//select[@class='select md-select no-margin']");


	/////Select the Account Name/////L
	public void SelectGroupname(String GroupName) throws InterruptedException {
		try {
			//Thread.sleep(1000);
			if (ElementsDisplayed(txtSearchId)) {
				input(txtSearchId, GroupName);
				Log.info("Successfully Entered the Group Name");
				jsClick(searchButton);
				Log.info("Succseefully Clicked on the Search Icon");
				ExtentSuccessMessage("Successfully Searched the Group Name");
			}
		} catch (Exception e) {
			ExtentErrorMessage("Unable to select group name " + e.getMessage());
		}
	}
	/////Click on the Add Person Button/////
	public void ClickOnAddPersonButton() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_AddPersonButton)) {
				Log.info("Successfully Add Person is visible");
				waitForElementClickable(L_AddPersonButton);
				jsClick(L_AddPersonButton);
				Log.info("Successfully Clicked On Add Person Button");
				ExtentSuccessMessage("Successfully Clicked On Add Person Button");
			}else {
				Log.error("UnSuccessfully not clicked On Add Person Button");
				ExtentErrorMessage("UnSuccessfully not clicked On Add Person Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Enter the BOR Start Date/////
	public void EnterBORStartDate() throws InterruptedException{
		try {	
			WaitForPageLoad();
			Thread.sleep(5000);
			if(ElementDisplayed(L_BORStartDate)) {
				Log.info("Successfully BOR Start Date is visible");
				// Get the current date
				LocalDate currentDate = LocalDate.now();
				Log.info("Successfully fetched the Current Local Date");
				// Format the date as per your requirements
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				String formattedDate = currentDate.format(formatter);
				Log.info("Successfully the Current Local Date is formatted");
				// Enter the current date into the input field
				Thread.sleep(5000);
				click(L_BORStartDate);
				RobotKeyOperation("BACKSPACE");
				RobotKeyOperation("BACKSPACE");
				RobotKeyOperation("BACKSPACE");
				RobotKeyOperation("BACKSPACE");
				RobotKeyOperation("BACKSPACE");
				RobotKeyOperation("BACKSPACE");
				RobotKeyOperation("BACKSPACE");
				RobotKeyOperation("BACKSPACE");
				input(L_BORStartDate, formattedDate);
				Log.info("Successfully Entered the BOR Start Date: "+formattedDate);
				ExtentSuccessMessage("Successfully Entered the BOR Start Date: "+formattedDate);
			}else {
				Log.error("UnSuccessfully not Entered the BOR Start Date");
				ExtentErrorMessage("UnSuccessfully not entered BOR Start Date");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Enter the BOR End Date/////
	public void EnterBOREndDate(Map<Object, Object> testdata) throws InterruptedException{
		try {	
			WaitForPageLoad();
			Thread.sleep(5000);
			if(ElementDisplayed(L_BOREndDate)) {
				Log.info("Successfully BOR End Date is visible");
				click(L_BOREndDate);
				Thread.sleep(5000);
				input(L_BOREndDate, testdata.get("BOREndDate").toString());
				Log.info("Successfully clicked and entered the BOR End Date");
				ExtentSuccessMessage("Successfully Entered the BOR End Date: "+testdata.get("BOREndDate").toString());
			}else {
				Log.error("UnSuccessfully not clicked On BOR End Date");
				ExtentErrorMessage("UnSuccessfully not entered BOR End Date");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Click on the Account Primary Contact/////
	public void ClickOnAccountPrimaryContactCheckBox() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_AccountPrimaryContact)) {
				Log.info("Successfully Account Primary Contact is visible");
				//waitForElementClickable(L_AccountPrimaryContact, 30);
				jsClick(L_AccountPrimaryContact);
				Log.info("Successfully Clicked On Account Primary Contact Button");
				ExtentSuccessMessage("Successfully Clicked On Account Primary Contact");
			}else {
				Log.error("UnSuccessfully not clicked On Account Primary Contact");
				ExtentErrorMessage("UnSuccessfully not clicked On Account Primary Contact");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
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

	/////Click on OK Button/////
	public void ClickOnOKButton() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_OKButton)) {
				Log.info("Successfully OK button is visible");
				click(L_OKButton);
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

	/////Click on the Back Button/////
	public void ClickOnBackButton() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_BackButton)) {
				Log.info("Successfully Back button is visible");
				click(L_BackButton);
				Log.info("Successfully Clicked On Back Button");
				ExtentSuccessMessage("Successfully Clicked On Back Button");
			}else {
				Log.error("UnSuccessfully not clicked On Back Button");
				ExtentErrorMessage("UnSuccessfully not clicked On Back Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Validate if the Added Contact is displayed/////
	public void ContactValidationUnderAccountName (String expectedFullName) {
		try {
			// Find the element containing the full name
			WebElement fullNameElement = driver.findElement(By.cssSelector("b.name"));
			// Get the text content of the element
			String actualFullName = fullNameElement.getText();
			// Compare the actual and expected full names
			if (actualFullName.equals(expectedFullName)) {
				Log.info("Full name validation under Account Name passed!");
				ExtentSuccessMessage("Full name validation under Account Name passed!");
			} else {
				Log.error("Full name validation under Account Name failed!");
				ExtentErrorMessage("Full name validation under Account Name failed!");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Validate if the Account Name is displayed Under the Contact Information/////
	public void AccountNameValidationUnderContactInfo (String accountNameToValidate) {
		try {
			// Find the Account Name element
			WebElement accountNameElement = driver.findElement(By.xpath("//td[@class='btn-link Name']//span[text()='" + accountNameToValidate + "']"));
			// Validate if the Account Name is displayed
			if (accountNameElement.isDisplayed()) {
				Log.info("Account Name is displayed: " + accountNameToValidate);
				ExtentSuccessMessage("Account Name is displayed: " + accountNameToValidate);
			} else {
				Log.error("Account Name is NOT displayed: " + accountNameToValidate);
				ExtentErrorMessage("Account Name is NOT displayed: " + accountNameToValidate);
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}	
	}

	/////Type of the Contact Broker/TPA/OfficeStaff
	public void SelectContactType(String ContactType) throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		if(ElementDisplayed(L_BrokerTPAOfficeStaff)) {
			Log.info("Successfully Visible User Role");
			SelectDropDownValues(L_BrokerTPAOfficeStaff,ContactType);
			Log.info("Successfully Clicked On Broker/TPA/OfficeStaff dropdown & selected: "+ContactType);
			ExtentSuccessMessage("Successfully Clicked On Broker/TPA/OfficeStaff dropdown & selected: "+ContactType);
		}else {
			Log.error("UnSuccessfully Not Visible User Role Dropdown");
			ExtentErrorMessage("UnSuccessfully Not Visible User Role dropdown");
		}

	}
}
