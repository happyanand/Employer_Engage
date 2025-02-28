package Pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.github.javafaker.Faker;

public class Agency_Page extends Base_Class{

	public static By L_AddAgencyButton = By.xpath("//div[contains(@data-target,'#myModal')]");
	public static By L_SFEntityid = By.xpath("//div[@class='modal-wrapper']//div[@class='col-md-4 col-sm-6 col-xs-12']/div[1]/input[@class='tb1']");
	public static By L_AgencyName = By.xpath("//div[@class='modal-wrapper']//div[@class='col-md-4 col-sm-6 col-xs-12']/div[1]/div[1]/input[@class='tb1']");
	public static By L_AgencyType = By.xpath("//select[@class='select']");
	public static By L_SaveButton = By.xpath("//input[@id='btnSave']");
	public static By L_OKButton = By.xpath("//a[contains(.,'Ok')]");
	public static By L_AgencyNameSearchBar = By.xpath("//input[@class='form-control']");
	public static By L_Searchicon = By.xpath("//span[@class='md-search-btn hr-theme-bg']/i[@class='material-icons']");
	public static By L_AgencyNameInGrid = By.xpath("//span[@class='btn-link']");
	public static By L_TerminateButton = By.xpath("//div[@id='btnGrpNotify']");
	public static By L_YesButton = By.xpath("//a[contains(.,'Yes')]");


	/////Click on Add Agency Button/////
	public void ClickOnAddAgencyButton() throws InterruptedException{
		try {	
			WaitForPageLoad();
			Thread.sleep(2000);
			if(ElementDisplayed(L_AddAgencyButton)) {
				Log.info("Successfully Add Agency is visible");
				click(L_AddAgencyButton);
				Log.info("Successfully Clicked On Add Agency Button");
				ExtentSuccessMessage("Successfully Clicked On Add Agency Button");
			}else {
				Log.error("UnSuccessfully not clicked On Add Agency Button");
				ExtentErrorMessage("UnSuccessfully not clicked On Add Agency Button");
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
			if(ElementDisplayed(L_SFEntityid)) {
				Log.info("Successfully SF Entity Id field is visible");
				click(L_SFEntityid);
				input(L_SFEntityid, randomNumber(6)+"");
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

	/////Enter the Agency Name/////
	public String EnterAgencyName() throws InterruptedException {
		Faker faker = new Faker();
		String strAgencyname = faker.name().firstName() + "'s Agency";
		Log.info("Agency Name: "+strAgencyname);
		input(L_AgencyName, strAgencyname);
		ExtentSuccessMessage("Agency Name: " + strAgencyname);
		return strAgencyname;
	}

	/////Select Agency Type/////
	public void selectAgencyType(String Value) throws InterruptedException, AWTException{
		try {
			if(ElementDisplayed(L_AgencyType)) {
				selectDropdownByVisibleText(L_AgencyType, Value);
				ExtentSuccessMessage("Successfully clicked and selected a value from the Agency Type dropdown.");
			}else {
				Log.error("UnSuccessfully not clicked and selected a value from the Agency Type dropdown.");
				ExtentErrorMessage("UnSuccessfully not clicked and selected a value from the Agency Type dropdown.");
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
				jsClick(L_SaveButton);
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

	/////Click On OK Button
	public void ClickOnOKButton() throws InterruptedException{
		try {	
			Thread.sleep(5000);
			WaitForPageLoad();
			Thread.sleep(2000);
			if(ElementDisplayed(L_OKButton)) {
				Log.info("Successfully OK button is visible");
				waitForElementClickable(L_AddAgencyButton, 30);
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

	/////Enter Agency Name in Search Bar/////
	public void EnterAgencyNameInSearchBar(String AgencyName) throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_AgencyNameSearchBar)) {
				Log.info("Successfully Agency Name Search Bar is visible");
				waitForElementClickable(L_AgencyNameSearchBar, 30);
				click(L_AgencyNameSearchBar);
				clear(L_AgencyNameSearchBar);
				input(L_AgencyNameSearchBar,AgencyName);
				Log.info("Successfully Agency Name value is entered");
				ExtentSuccessMessage("Successfully Agency Name value is entered");
			}else {
				Log.error("UnSuccessfully Agency Name value is not entered");
				ExtentErrorMessage("UnSuccessfully Agency Name value is not entered");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Click on Search Icon/////
	public void ClickOnSearchIcon() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_Searchicon)) {
				Log.info("Successfully Search Icon is visible");
				waitForElementClickable(L_Searchicon,50);
				click(L_Searchicon);
				Log.info("Successfully Clicked On Search Icon");
				ExtentSuccessMessage("Successfully Clicked On Search Icon");
			}else {
				Log.error("UnSuccessfully not clicked On Search Icon");
				ExtentErrorMessage("UnSuccessfully not clicked On Search Icon");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Click on Agency Nmae in Grid/////
	public void ClickOnAgencyNameInGrid() throws InterruptedException{
		try {	
			WaitForLoadAnimationDisappear();
			if(ElementDisplayed(L_AgencyNameInGrid)) {
				Log.info("Successfully Agency name in grid is visible");
				waitForElementClickable(L_AgencyNameInGrid, 30);
				click(L_AgencyNameInGrid);
				Log.info("Successfully Clicked On Agency name in grid");
				ExtentSuccessMessage("Successfully Clicked On Agency name in grid");
			}else {
				Log.error("UnSuccessfully not clicked On Agency name in grid");
				ExtentErrorMessage("UnSuccessfully not clicked On Agency name in grid");
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
			if(ElementDisplayed(L_TerminateButton)) {
				Log.info("Successfully Terminate Button is visible");
				click(L_TerminateButton);
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

	/////Click on the Check box besides the Agency Name/////
	public void ClickOnCheckboxofAgencyName(String ContactName) throws InterruptedException {
		try {
			WaitForPageLoad();
			String targetUsername = ContactName;
			String xpathExpression = "//td[contains(., \"" + targetUsername + "\")]/preceding-sibling::td[@class='text-center']//div[@class='md-checkbox no-label']";

			// Find the first matching element
			WebElement contactNameElement = driver.findElement(By.xpath(xpathExpression));
			// Click the element
			contactNameElement.click();
			Log.info("Successfully Clicked On Checkbox of Agency name in grid");
			ExtentSuccessMessage("Successfully Clicked On Checkbox ofAgency name in grid");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Click on Yes Button/////
	public void ClickOnYesButton() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_YesButton)) {
				Log.info("Successfully Yes button is visible");
				waitForElementClickable(L_YesButton, 30);
				click(L_YesButton);
				Log.info("Successfully Clicked On Yes Button");
				ExtentSuccessMessage("Successfully Clicked On Yes Button");
			}else {
				Log.error("UnSuccessfully not clicked On Yes Button");
				ExtentErrorMessage("UnSuccessfully not clicked On Yes Button");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Validate the Agency Name/////
	public void AgencyNameValidation (String expectedAgencyName) {
		try {	
			WaitForPageLoad();
			// Find the table row containing the agency information
			WebElement tableRow = driver.findElement(By.xpath("//tbody/tr[@class='agentheadrow']"));
			// Find the cell containing the agency name in the row
			WebElement agencyNameCell = tableRow.findElement(By.xpath(".//td[2]"));
			// Get the text content of the agency name cell
			String actualAgencyName = agencyNameCell.getText().trim();
			// Validate if the actual agency name matches the expected agency name
			if (actualAgencyName.equals(expectedAgencyName)) {
				Log.info("Validation Passed! Agency name is displayed correctly: " + actualAgencyName);
				ExtentSuccessMessage("Validation Passed! Agency name is displayed correctly: " + actualAgencyName);
			} else {
				Log.error("Validation Failed! Expected: " + expectedAgencyName + ", Actual: " + actualAgencyName);
				ExtentErrorMessage("Validation Failed! Expected: " + expectedAgencyName + ", Actual: " + actualAgencyName);
			}
		} catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}	
	}

	/////Validte if the Checkbox is disabled or not/////
	public void CheckboxValidationForAgencyName(String agencyName) {
		try {
			// Find the checkbox element using the agency name
			WebElement checkbox = driver.findElement(By.xpath("//td[contains(text(), '" + agencyName + "')]//preceding-sibling::td//input"));
			// Check if the checkbox is disabled
			if (checkbox.getAttribute("disabled") != null) {
				Log.info("Checkbox for '" + agencyName + "' is disabled.");
				ExtentSuccessMessage("Checkbox for '" + agencyName + "' is disabled.");
			} else {
				Log.error("Checkbox for '" + agencyName + "' is enabled.");
				ExtentErrorMessage("Checkbox for '" + agencyName + "' is enabled.");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

}