package Pages;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class SendNotifications_Page extends Base_Class{
	
	public static By L_Subject = By.xpath("//div[@class='card']//input[@class='tb1']");
	public static By L_Body = By.xpath("/html/body/p");
	public static By L_SendButton = By.xpath("//button[@class='btn btn-primary no-margin']");
	public static By L_OKButton = By.xpath("//a[contains(.,'Ok')]");
	
	/////Enter the Subject of the Mail/////
	public void EnterSubject(Map<Object, Object> testdata) throws InterruptedException{
		try {	
			
			WaitForPageLoad();
			if(ElementDisplayed(L_Subject)) {
				Log.info("Successfully Subject visible");
				click(L_Subject);
				input(L_Subject, testdata.get("Subject").toString());
				Log.info("Successfully Clicked On Subject");
				ExtentSuccessMessage("Successfully Entered the Subject");
			}else {
				Log.error("UnSuccessfully not clicked On Subject");
				ExtentErrorMessage("UnSuccessfully not entered Subject");
			}
		} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	public void EnterBody(Map<Object, Object> testdata) throws InterruptedException {
	    try {
	        WaitForPageLoad();

	        // Wait for the iframe to be available and switch to it
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));

	        if (ElementDisplayed(L_Body)) {
	            Log.info("Successfully Body is visible");

	            // Click on the Body element to activate CKEditor
	            click(L_Body);

	            // Find and interact with CKEditor's editable area
	            WebElement ckEditor = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
	            ckEditor.clear(); // Clear existing content if any
	            ckEditor.sendKeys(testdata.get("Body").toString());

	            // Switch back to the default content
	            driver.switchTo().defaultContent();

	            Log.info("Successfully entered text in CKEditor Body");
	            ExtentSuccessMessage("Successfully entered text in CKEditor Body");
	        } else {
	            Log.error("Unsuccessfully not clicked On Body");
	            ExtentErrorMessage("Unsuccessfully not clicked and not entered the Body");
	        }
	    } catch (Exception e) {
	        // Handle the exception
	        System.out.println("An exception occurred: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	/////Click on the Send Button/////
	public void ClickOnSendButton() throws InterruptedException{
		try {	
			WaitForPageLoad();
			if(ElementDisplayed(L_SendButton)) {
				Log.info("Successfully Send button is visible");
				click(L_SendButton);
				Log.info("Successfully Clicked On Send Button");
				ExtentSuccessMessage("Successfully Clicked On Send Button");
			}else {
				Log.error("UnSuccessfully not clicked On OK Button");
				ExtentErrorMessage("UnSuccessfully not clicked On Send Button");
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
				waitForElementClickable(L_OKButton, 30);
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
	
	/////Validate the name and Email Subject/////
	public void NameSubjectValidation (String FullName,Map<Object, Object> testdata) {
		try {
			String emailSubject = testdata.get("Subject").toString();
			// Locate the table
	        WebElement table = driver.findElement(By.className("cms-grid"));
	        // Form the XPath to locate the row based on Full Name and Email Subject
	        String xpathExpression = String.format("//tbody/tr[td/span[@title='%s'] and td/span[@title='%s']]", FullName, emailSubject);
	        // Find the row using XPath
	        WebElement row = table.findElement(By.xpath(xpathExpression));
	        // Perform validation based on whether the row is found
	        if (row != null) {
	            System.out.println("Record found!");
	            // Further actions you want to take if the record is found
	        } else {
	            System.out.println("Record not found!");
	            // Further actions you want to take if the record is not found
	        }
		}catch (Exception e) {
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}

}
