package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class GroupInformation_Page extends Base_Class {
	
	public static By L_BrokerTab = By.xpath("//a[@id='lnkBrokers']");
	public static By L_BrokerListTable = By.id("tableBrokerList");
	public static By groupInformationHeader= By.xpath("//h4[text()=' Group Information ']");
	
	
	
	public void ClickOnBrokerTab() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_BrokerTab)) {
				Log.info("Successfully Broker Tab is visible");
				click(L_BrokerTab);
				Log.info("Successfully Clicked On Broker Tab");
				ExtentSuccessMessage("Successfully Clicked On Broker Tab");
			}else {
				Log.error("UnSuccessfully not clicked On Broker Tab");
				ExtentErrorMessage("UnSuccessfully not clicked On Broker Tab");
			}
		} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
	
	/////Validate to check if the Name is present /////
	public void validateNameIsPresent(String nameToValidate) {
	    // Locate the table element
	    WebElement table = driver.findElement(By.id("tableBrokerList")); // Assuming the table has an ID

	    // Locate all rows in the table
	    java.util.List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

	    // Iterate through each row
	    for (WebElement row : rows) {
	        // Locate the 'Name' column in each row
	        WebElement nameColumn = row.findElement(By.xpath(".//td[3]")); // Assuming 'Name' is the third column (index 2)

	        // Get the text from the 'Name' column
	        String nameInTable = nameColumn.getText();

	        // Check if the name matches
	        if (nameInTable.equals(nameToValidate)) {
	            Log.info("Name found in the table!");
	            ExtentSuccessMessage("Successfully found the name in the Broker List");
	            return; // Name found, exit the method
	        }
	    }

	    Log.error("Name not found in the table!");
	    ExtentErrorMessage("Name not found in the Broker List");
	    // If you want to take some action when the name is not found, you can add it here
	}
	
	/////Validate to check if the name is not present/////
	public void validateNameIsNotPresent(String nameToValidate) {
	    // Locate the table element
	    WebElement table = driver.findElement(By.id("tableBrokerList")); // Assuming the table has an ID

	    // Locate all rows in the table
	    java.util.List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

	    // Iterate through each row
	    for (WebElement row : rows) {
	        // Locate the 'Name' column in each row
	        WebElement nameColumn = row.findElement(By.xpath(".//td[3]")); // Assuming 'Name' is the third column (index 2)

	        // Get the text from the 'Name' column
	        String nameInTable = nameColumn.getText();

	        // Check if the name matches
	        if (nameInTable.equals(nameToValidate)) {
	            Log.info("Name not found in the table!");
	            ExtentSuccessMessage("Name not found in the Broker List ");
	            return; // Name found, exit the method
	        }
	    }

	    Log.error("Name found in the table!");
	    ExtentErrorMessage("Name found in the table!");
	    // If you want to take some action when the name is not found, you can add it here
	}

    //Groups Information page displayed
    public Boolean isGroupsInformationPageDisplayed(){
        WaitForPageLoad();
        return ElementDisplayed(groupInformationHeader);
    }
}
