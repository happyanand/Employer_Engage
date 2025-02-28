package Pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class UserProfile_Page extends Base_Class {

	public static By L_clickUserProfile = By.xpath("//a[contains(.,'User Profile')]");
	public static By L_clickAddUser = By.xpath("//*[contains(text(),'Add User')]");
	public static By L_EditFirstName1 =By.xpath("//div[@class='row margin_bottom_10px']/div[1]//input[@class='tb1']");
	public static By L_EditLastName1 = By.xpath("//div[@class='row margin_bottom_10px']/div[2]//input[@class='tb1']");
	public static By L_EditFirstName =By.xpath("//div[@id='userprofile_editbox']//div[@class='row margin_bottom_10px']/div[1]//input[@class='tb1']");
	public static By L_EditLastName = By.xpath("//div[@id='userprofile_editbox']//div[@class='row margin_bottom_10px']/div[2]//input[@class='tb1']");
	public static By L_EmialID = By.xpath("//*[contains(text(),'Email ID')]/parent::div/div/input");
	public static By L_SubmitButtion = By.xpath("//*[text()='Submit']");
	public static By L_UserRole = By.xpath("//*[@class='select']");
	public static By L_UserRole1 = By.xpath("//*[@id='userprofile_editbox']//*[@class='select'][@data-val='true']");
	public static By L_UpdateButtion = By.xpath("//*[text()='Update']");
	public static By L_SearchfieldName = By.xpath("//input[@placeholder='Search']");	
	public static By L_SearchIcon = By.xpath("//*[@class='md-search-btn hr-theme-bg']");
	public static By L_RequestOnlineAccess = By.xpath("//*[@title='Request Online Access']");


	public void ClickOnUserProfile() throws InterruptedException{
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_clickUserProfile)) {
				Log.info("Successfully Visible User Profile Button");
				click(L_clickUserProfile);
				Log.info("Successfully Clicked On  User Profile Button");
				ExtentSuccessMessage("Successfully Clicked On User Profile Button");
			}else {
				Log.error("User Profile button is Unsuccessfully not visible ");
				ExtentErrorMessage("User Profile button is Unsuccessfully not visible");
			}
		}
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void ClickOnAddUser() throws InterruptedException{
		try {
			WaitForPageLoad();
			Thread.sleep(2000);
			if(ElementDisplayed(L_clickAddUser)) {
				waitForElementClickable(L_clickAddUser);
				click(L_clickAddUser);
				Log.info("Successfully Clicked On  User profile Button");
				ExtentSuccessMessage("Successfully Clicked On User profile Button");
			}else {
				Log.error("UnSuccessfully User profile Button is not Visible ");
				ExtentErrorMessage("UnSuccessfully User profile Button is not Visible ");
			}
		}
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void modifyFirstName(String Value) throws InterruptedException {
		if(ElementDisplayed(L_EditFirstName)) {
			Log.info("Successfully First name field is visible for Editing");
			jsClick(L_EditFirstName);
			Log.info("Successfully Clicked On First Name Field");
			clear(L_EditFirstName);
			input(L_EditFirstName, Value);
			ExtentSuccessMessage("Successfully enter modified First Name In user Name Field " + Value);
		}else {
			if(ElementDisplayed(L_EditFirstName1)) {
				Log.info("Successfully First name field is visible for Editing");
				jsClick(L_EditFirstName1);
				Log.info("Successfully Clicked On First Name Field");
				clear(L_EditFirstName1);
				input(L_EditFirstName1, Value);
				ExtentSuccessMessage("Successfully enter modified First Name In user Name Field " + Value);
			}else {
				Log.error("UnSuccessfully Not Visible User Name Field");
				ExtentErrorMessage("UnSuccessfully Not Visible User Name Field");
			}
		}

	}

	public void modifyLastName(String Value) throws InterruptedException {
		try {
			if(ElementDisplayed(L_EditLastName)) {
				Log.info("Successfully Last name field is visible for Editing");
				jsClick(L_EditLastName);
				Log.info("Successfully Clicked On Last Name Field");
				clear(L_EditLastName);
				input(L_EditLastName, Value);
				ExtentSuccessMessage("Successfully enter modified Last Name In user Name Field " + Value);
			}else {
				if(ElementDisplayed(L_EditLastName1)) {
				Log.info("Successfully Last name field is visible for Editing");
				jsClick(L_EditLastName1);
				Log.info("Successfully Clicked On Last Name Field");
				clear(L_EditLastName1);
				input(L_EditLastName1, Value);
				ExtentSuccessMessage("Successfully enter modified Last Name In user Name Field " + Value);
			}else {
				Log.error("Last Name Field is unsuccessfully not visible");
				ExtentErrorMessage("Last Name Field is unsuccessfully not visible");
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


	public void EnterEmailId(String Value) throws InterruptedException {
		try {
			if(ElementDisplayed(L_EmialID)) {
				Log.info("Successfully Last name field is visible for Editing");
				click(L_EmialID);
				Log.info("Successfully Clicked On Last Name Field");
				clear(L_EmialID);
				input(L_EmialID, Value);
				ExtentSuccessMessage("Successfully enter modified Last Name In user Name Field " + Value);
			}else {
				Log.error("Last Name Field is unsuccessfully not visible");
				ExtentErrorMessage("Last Name Field is unsuccessfully not visible");
			} 
		} catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}


	public void ClickOnSubmitButton() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(L_SubmitButtion)) {
				Log.info("Successfully Visible Submit Button");
				click(L_SubmitButtion);
				Log.info("Successfully Clicked On Submit Button");
				ExtentSuccessMessage("Successfully Clicked On Submit Button");
			}else {
				Log.error("UnSuccessfully Not Visible Submit Button");
				ExtentErrorMessage("UnSuccessfully Not Visible Submit Button");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public void SelectUserRole(String UserRole) throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(L_UserRole)) {
				Log.info("Successfully Visible User Role");
				SelectDropDownValues1(L_UserRole,UserRole);
				Log.info("Successfully Clicked On User Role dropdown & select :"+UserRole);
				ExtentSuccessMessage("Successfully Clicked On User Role dropdown");
			}else if(ElementDisplayed(L_UserRole1)) {
				Log.info("Successfully Visible User Role");
				SelectDropDownValues1(L_UserRole1,UserRole);
				Log.info("Successfully Clicked On User Role dropdown & select :"+UserRole);
				ExtentSuccessMessage("Successfully Clicked On User Role dropdown");
			}else {
				Log.error("UnSuccessfully Not Visible User Role Dropdown");
				ExtentErrorMessage("UnSuccessfully Not Visible User Role dropdown");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public void ClickOnUpdateButton() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(L_UpdateButtion)) {
				Log.info("Successfully Visible Update Button");
				click(L_UpdateButtion);
				Log.info("Successfully Clicked On Update Button");
				ExtentSuccessMessage("Successfully Clicked On Update Button");
			}else {
				Log.error("UnSuccessfully Not Visible Update Button");
				ExtentErrorMessage("UnSuccessfully Not Visible Update Button");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void EnterNameForSearch(String Value) throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(L_SearchfieldName)) {
				Log.info("Successfully Visible Search Field");
				click(L_SearchfieldName);
				Log.info("Successfully Clicked On  Search Field");
				//			ExtentSuccessMessage("Successfully Clicked On Add  Groupe Contact  Button");
				input(L_SearchfieldName,Value);
				ExtentSuccessMessage("Successfully Enter value in Search Field");
			}else {
				Log.error("UnSuccessfully Not Visible Search Field");
				ExtentErrorMessage("UnSuccessfully Not Visible Search Field");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void ClickOnSearchIcon() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(L_SearchIcon)) {
				Log.info("Successfully Visible Search Icon");
				click(L_SearchIcon);
				Log.info("Successfully Clicked On Search Icon");
				ExtentSuccessMessage("Successfully Clicked On Search Icon");
			}else {
				Log.error("UnSuccessfully Not Visible Search Icon");
				ExtentErrorMessage("UnSuccessfully Not Visible Search Icon");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	public void ClickOnRequestOnlineAccess() throws InterruptedException{
		WaitForPageLoad();
		try {
			if(ElementDisplayed(L_RequestOnlineAccess)) {
				Log.info("Successfully Visible Request Online Access");
				click(L_RequestOnlineAccess);
				Log.info("Successfully Clicked On Request Online Access Icon");
				ExtentSuccessMessage("Successfully Clicked On Request Online Access Icon");
			}else {
				Log.error("UnSuccessfully Not Visible Request Online Access Icon");
				ExtentErrorMessage("UnSuccessfully Not Visible Request Online Access Icon");
			}
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
