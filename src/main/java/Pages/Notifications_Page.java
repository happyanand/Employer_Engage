package Pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class Notifications_Page extends Base_Class {

	private static By L_searchBar = By.xpath("//input[@placeholder='Search']");
	private static By search_icon = By.xpath("//span[@class='md-search-btn hr-theme-bg']/i[@class='material-icons']");
	private static By statusButton = By.xpath("//div[@class='v-switch-core']/div[@class='v-switch-button']");
	private static By toggleONOFF = By.xpath("//label[@class='vue-js-switch toggled']");
	private static By L_NotificationStatusButton = By.xpath("(//input[@class='v-switch-input'])[1]");
	private static By L_NotificationStatusButton1 = By.xpath("//*[contains(@class,'vue-js-switch')]");

	/////Search the Notification Name/////
	public void search_Notification_Name(Map<Object, Object> testdata) throws InterruptedException {
		WaitForPageLoad();
		try {
		if (ElementDisplayed(L_searchBar)) {
			Log.info("Successfully Visible Text Search");
			jsClick(L_searchBar);
			input(L_searchBar, testdata.get("NotificationName").toString());
			Log.info("Successfully Clicked On Text Search"+ testdata.get("NotificationName").toString());
			jsClick(search_icon);
			ExtentSuccessMessage("Successfully Searched with Notification Name");
			WaitForLoadAnimationDisappear();
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
	
	public static boolean isToggleOn(WebElement toggleElement) {
        // Check the class of the toggle to determine its state
        String classAttributeValue = toggleElement.getAttribute("class");

        // Assuming that the "toggled" class indicates that the toggle is ON
        return classAttributeValue.contains("toggled");
    }
	
	/////Validate if the Status button is ON/////
	public void StatusButtonONOFFValidation() {
		try {
			WaitForPageLoad();
		// Assuming you want to check the status button in the first row
        //WebElement toggleElement  = driver.findElement(By.xpath("//label[@class='vue-js-switch toggled']"));
        if (ElementDisplayed(toggleONOFF)) {
        	Log.info("The Status button is ON");
        	ExtentSuccessMessage("The Status button is ON");
        } else {
        	Log.info("The Status button is OFF");
        	ExtentSuccessMessage("The Status button is OFF");
        } 
		} catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	
}	

	/////Validate if the Status button is ON/////
	public boolean StatusButtonONValidation() {
		boolean isStatusButtonOn =true;
		try {			
			// Assuming you want to check the status button in the first row
			WebElement statusCheckbox = driver.findElement(By.xpath("(//input[@class='v-switch-input'])[1]"));
			// Check if the checkbox is selected (ON)
			isStatusButtonOn = statusCheckbox.isSelected();
			// Print the result
			Log.info("Is Status button ON? " + isStatusButtonOn);
			ExtentSuccessMessage("Is Status button ON? " + isStatusButtonOn);
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

		return isStatusButtonOn;
	}

	public void TurnOnNotification() throws InterruptedException {
		try {
			if (ElementDisplayed(L_NotificationStatusButton1)) {
				Log.info("Notification StatusButton display");
				ExtentSuccessMessage("Notification Status Button display");
				boolean isStatusButtonOn=StatusButtonONValidation();
				if(isStatusButtonOn) {
					ExtentSuccessMessage("Notification Status is already On");
					Log.info("Notification Status is already On");
				}else {
					Log.info("Notification status is off :"+isStatusButtonOn);
					jsClick(L_NotificationStatusButton1);
					Log.info("Successfully clicked ON notification button");
					ExtentSuccessMessage("Successfully turn On notification");
				}

			} else {
				Log.error("Notification Status Button don't displayed");
				ExtentErrorMessage("Notification Status Button don't displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public void  TurnOffNotification() throws InterruptedException {
		try {
			WaitForPageLoad();
			Thread.sleep(2000);
			if (ElementDisplayed(L_NotificationStatusButton1)) {
				Log.info("Notification StatusButton display");
				ExtentSuccessMessage("Notification Status Button display");
				boolean isStatusButtonOn=StatusButtonONValidation();
				if(!isStatusButtonOn) {
					ExtentErrorMessage("Notification Status is already OFF");
					Log.info("Notification Status is already OFF");
				}else {
					Log.info("Notification status is ON :"+isStatusButtonOn);
					jsClick(L_NotificationStatusButton1);
					Log.info("Successfully clicked OFF notification button");
					ExtentSuccessMessage("Successfully turn OFF notification");
				}

			} else {
				Log.error("Notification Status Button don't displayed");
				ExtentErrorMessage("Notification Status Button don't displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/////Click on the Status button/////
	public void ClickOnStatusButton() throws InterruptedException{
		WaitForPageLoad();
		if(ElementDisplayed(statusButton)) {
			Log.info("Successfully Visible Status Button");
			click(statusButton);
			Log.info("Successfully Clicked On Status Button");
			ExtentSuccessMessage("Successfully Clicked On Status Button");
		}else {
			Log.error("UnSuccessfully Not Visible Status Button");
			ExtentErrorMessage("UnSuccessfully Not Visible Status Button");
		}
	}

	/////Validate if the Status button is OFF/////
	public void StatusButtonOFFValidation() {
		try {
			// Assuming you want to check the status button in the first row
			WebElement statusCheckbox = driver.findElement(By.xpath("(//input[@class='v-switch-input'])[1]"));
			// Check if the checkbox is selected (ON)
			boolean isStatusButtonOn = !statusCheckbox.isSelected();
			// Print the result
			Log.info("Is Status button ON? " + isStatusButtonOn);
			ExtentSuccessMessage("Is Status button ON? " + isStatusButtonOn);
		}catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
