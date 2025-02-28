package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class LoginHistory_Page  extends Base_Class  {
	
	public static By L_LoginHistory = By.xpath("( //*[text()='Login History '])");
	public static By L_Searchbar = By.xpath("//*[@class='form-control']");
	public static By L_SearchIcon = By.xpath("(//*[text()='search'])[3]");
	
                    /////////////////////////////Method ///////////////////////////////
	
	public void ClickOnLoginHistory() throws InterruptedException{
		
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_LoginHistory)) {
				Log.info("Successfully Visible LoginHistory");
				click(L_LoginHistory);
				Log.info("Successfully Clicked On LoginHistory");
				ExtentSuccessMessage("Successfully Clicked On LoginHistory");
			}else {
				Log.error("UnSuccessfully Not Visible LoginHistory");
				ExtentErrorMessage("UnSuccessfully Not Visible LoginHistory");
				}
		} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
	
	public void ClickOnSearchbar(String Value) throws InterruptedException{
		
		try {
			if(ElementDisplayed(L_Searchbar)) { 
				Log.info("Successfully Visible User Name Field");
				click(L_Searchbar);
				Log.info("Successfully Clicked On  Searchbar");
				clear(L_Searchbar);
				input(L_Searchbar,Value);
				Log.info("Successfully Enter value in  Searchbar");
				ExtentSuccessMessage("Successfully Enter value in Searchbar");
			}else{
				Log.error("UnSuccessfully Not Visible Searchbar");
				ExtentErrorMessage("UnSuccessfully Not Visible  Searchbar");
			}
		} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
		
	}
	
	public void ClickOnSearchIcon() throws InterruptedException{
		try {
			WaitForPageLoad();
			if(ElementDisplayed(L_SearchIcon)) {
				Log.info("Successfully Visible Search Icon");
				click(L_SearchIcon);
				Log.info("Successfully Clicked On Search Icon");
				ExtentSuccessMessage("Successfully Clicked On Search Icon");
			}else {
				Log.error("UnSuccessfully Not Visible Search Icon");
				ExtentErrorMessage("UnSuccessfully Not Visible Search Icon");
			}
		} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
		
	
	public void validateUsernamerecords(String UserName) throws InterruptedException 
	{	String targetUsername = UserName;
	
		String xpathExpression = "//table[@class='table table-condensed table-bordered table-striped table-small']/tbody/tr" +
		            "[td/span[contains(., '" + targetUsername + "')]]";
	
		// Find all matching rows
	    List<WebElement> matchingRows = driver.findElements(By.xpath(xpathExpression));

	    // Iterate through the matching rows and check the "Login Type" column
	    for (WebElement row : matchingRows) {
	        WebElement loginTypeCell = row.findElement(By.xpath("./td[4]/span"));
	        String loginType = loginTypeCell.getText();
	    }
	    ExtentSuccessMessage("Successfully validated the Login and Logout records in the Login History for: " +UserName);
	 }
                 
}
