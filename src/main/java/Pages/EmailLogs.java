package Pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class EmailLogs extends Base_Class {
	Base_Class Base_Class =new Base_Class();
	Home_Page Home_Page = new Home_Page();
	Agency_Page Agency_Page=new Agency_Page();
	Agency_Details_Page Agency_Details_Page=new Agency_Details_Page();

	/////////////////////////////////Locator/////////////////////////////////////////////

	////////////////////////////////////Email Log Locator//////////////////////////////
	public static By L_EmailLogEnterSearchField = By.id("txtSearch");
	public static By L_EmailLogEnterSearchButton = By.xpath("//*[@id='btnSearch']//*[text()='search']");
	public static By L_ViewIcon = By.xpath("//*[@title='View']//*[text()='visibility']");
	public static By CloseIcon = By.xpath("//a[@class='router-link-active']//i[@class='material-icons'][normalize-space()='close']");
	public static By L_ResendIcon = By.xpath("//i[normalize-space()='send']");
	public static By txt_mail = By.xpath("//div[@class='container view_port']//div[2]//div[2]//input[1]");
	public static By btn_send = By.xpath("//button[@class='btn btn-primary no-margin']");
	public static By btn_ok = By.xpath("//a[contains(@class,'btn-primary no-margin')]");
	public static By txt_viewEmail = By.xpath("//p[normalize-space()='View Email']");
	public static By txt_resendEmail = By.xpath("//p[normalize-space()='Resend Email']");
	public static By notificationId = By.xpath("//p[contains(@style,'font-weight:bold; color:#999999;font-size:12px;font-family:Arial,sans-serif;')]");
	public static By L_noRecordsFound = By.xpath("//td[contains(.,'No Records Found')]");
	////////////////////////////// View Mail///////////////////////////////
	public static By L_RegistrationLink = By.xpath("//*[text()='Register']|//*[normalize-space()='Register']");
    public static int i=0;

	/////////////////////////////////////////////////////////
	/////////////////////////// Email Log Methods////////////////////////////

	public void EnterFirstNameEmailLogEnterSearchField(String Value) throws InterruptedException{
		WaitForLoadAnimationDisappear();
		Thread.sleep(5000);
		if(ElementDisplayed(L_EmailLogEnterSearchField)) {
			Log.info("Successfully Visible Search Field");
			click(L_EmailLogEnterSearchField);
			input(L_EmailLogEnterSearchField,Value);
			Log.info("Successfully Enter value in Search Field");
			ExtentSuccessMessage("Successfully Enter value in Search Field");
		}else {
			Log.error("UnSuccessfully Not Visible Search Field");
			ExtentErrorMessage("UnSuccessfully Not Visible Search Field");
		}
	}

	//Click on EmailLog Search Icon
	public void ClickOnEmailLogSearchIcon() throws InterruptedException{
		WaitForPageLoad();
		if(ElementDisplayed(L_EmailLogEnterSearchButton)) {
			Log.info("Successfully Visible Search Icon");
			click(L_EmailLogEnterSearchButton);
			WaitForLoadAnimationDisappear();
			Log.info("Successfully Clicked On Search Icon");
			ExtentSuccessMessage("Successfully Clicked On Search Icon");
		}else {
			Log.error("UnSuccessfully Not Visible Search Icon");
			ExtentErrorMessage("UnSuccessfully Not Visible Search Icon");
		}
	}

	//Click on View Icon
	public void ClickOnViewIcon() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(5000);
		if(ElementDisplayed(L_ViewIcon)) {
			Log.info("Successfully Visible View Icon");
			Thread.sleep(5000);
			click(L_ViewIcon);
			Log.info("Successfully Clicked On View Icon");
			ExtentSuccessMessage("Successfully Clicked On View Icon");
		}else {
			Log.error("UnSuccessfully Not Visible View Icon");
			ExtentErrorMessage("UnSuccessfully Not Visible View Icon");
		}
	}

	//Click on View Icon
	public void ClickOnViewIconIHA(String agencyName1) throws InterruptedException{
		WaitForPageLoad();
		if(ElementDisplayed(L_ViewIcon)) {
			Log.info("Successfully Visible View Icon");
			click(L_ViewIcon);
			Log.info("Successfully Clicked On View Icon");
			ExtentSuccessMessage("Successfully Clicked On View Icon");
		}else {
			Log.info("UnSuccessfully Not Visible View Icon");
			ExtentSuccessMessage("UnSuccessfully Not Visible View Icon");
			Home_Page.ClickOnMoreTab();

			Home_Page.ClickOnBrokerManagement();
			Agency_Page.EnterAgencyNameInSearchBar(agencyName1);

			Agency_Page.ClickOnSearchIcon();

			Agency_Page.AgencyNameValidation(agencyName1);

			Agency_Page.ClickOnAgencyNameInGrid();
			Agency_Details_Page.ClickOnSendNotificationButton();
			Agency_Page.ClickOnOKButton();
			WaitForPageLoad();
			Home_Page.clickCommunicationTab();
			//Click on Email Log
			Home_Page.ClickOnEmailLog();
			WaitForLoadAnimationDisappear();
			RefreshPage();
			WaitForLoadAnimationDisappear();
			//Enter the First Name
			EnterFirstNameEmailLogEnterSearchField(agencyName1);
			//Click on the Email Log search button
			ClickOnEmailLogSearchIcon();
			WaitForLoadAnimationDisappear();
			if(ElementDisplayed(L_ViewIcon)) {
				Log.info("Successfully Visible View Icon");
				click(L_ViewIcon);
				Log.info("Successfully Clicked On View Icon");
				ExtentSuccessMessage("Successfully Clicked On View Icon");
			}else {
				Log.error("UnSuccessfully Not Visible View Icon");
				ExtentErrorMessage("UnSuccessfully Not Visible View Icon");
			}
		}
	}

	//Click on Resend Icon
	public void ClickOnResendIcon() throws InterruptedException{
		WaitForPageLoad();
		if(ElementDisplayed(L_ResendIcon)) {
			Log.info("Successfully Visible Resend Icon");
			click(L_ResendIcon);
			Log.info("Successfully Clicked On Resend Icon");
			ExtentSuccessMessage("Successfully Clicked On Resend Icon");
		}else {
			Log.error("UnSuccessfully Not Visible Resend Icon");
			ExtentErrorMessage("UnSuccessfully Not Visible Resend Icon");
		}
	}
	
	//Edit Mail Address
	public void EditMailAddress(Map<Object, Object> testdata) throws InterruptedException{
		WaitForPageLoad();
		if(ElementDisplayed(txt_mail)) {
			Log.info("Successfully Visible Mail Text");
			click(txt_mail);
			clear(txt_mail);
			input(txt_mail, testdata.get("NewEmailID").toString());
			ExtentSuccessMessage("Succesfully Edited Email Text");
			Log.info("Successfully Edited Email Text");
			ExtentSuccessMessage("Successfully Edited Email Text");
		}else {
			Log.error("UnSuccessfully Not Edited Email Text");
			ExtentErrorMessage("UnSuccessfully Not Edited Email Text");
		}
	}
	
	//Click on Close Icon
	public void ClickOnCloseIcon() throws InterruptedException{
		WaitForPageLoad();
		if(ElementDisplayed(CloseIcon)) {
			Log.info("Successfully Visible Close Icon");
			click(CloseIcon);
			Log.info("Successfully Clicked On Close Icon");
			ExtentSuccessMessage("Successfully Clicked On Close Icon");
		}else {
			Log.error("UnSuccessfully Not Visible Close Icon");
			ExtentErrorMessage("UnSuccessfully Not Visible Close Icon");
		}
	}

	//Click on Registration Link
	public void ClickOnRegistrationLink() throws InterruptedException{
		WaitForPageLoad();
		if(ElementDisplayed(L_RegistrationLink)) {
			Log.info("Successfully Visible Registration Link Text");
			click(L_RegistrationLink);
			Log.info("Successfully Clicked On Registration Link Text");
			ExtentSuccessMessage("Successfully Clicked On Registration Link Text");
		}else {
			Log.error("UnSuccessfully Not Visible  Registration Link Text");
			ExtentErrorMessage("UnSuccessfully Not Visible  Registration Link Text");
		}
	}

	//Click on Send Button
	public void ClickOnSendButton() throws InterruptedException{
		WaitForPageLoad();
		scrollDown();
		if(ElementDisplayed(btn_send)) {
			Log.info("Successfully Visible Send Button");
			click(btn_send);
			WaitForLoadAnimationDisappear();
			Thread.sleep(5000);
			click(btn_ok);
			WaitForLoadAnimationDisappear();
			Thread.sleep(10000);
			Log.info("Successfully Clicked On Send Button");
			ExtentSuccessMessage("Successfully Clicked On Send Button");
		}else {
			Log.error("UnSuccessfully Not Visible Send Button");
			ExtentErrorMessage("UnSuccessfully Not Visible Send Button");
		}
	}

	//Validate Name
	public void validatename(String value) throws InterruptedException{
		
		WaitForPageLoad();
		try {
			i++;
			if(i>10)
			{
				return;
				
			}
			By name = By.xpath("//span[@title='"+value+"']");
			if(ElementDisplayed(name))
			{
				ExtentSuccessMessage("Successfully Displayed Name");
				return;
			}else {
				
				Base_Class.RefreshPage();
				validatename(value);
			}
			
			
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Validate Email
	public void validatemail(String value) throws InterruptedException{
		try {
			By email = By.xpath("//span[@title='"+value+"']");
			if(ElementDisplayed(email))
			{
				ExtentSuccessMessage("Successfully Displayed Email");
			}else {
				Base_Class.RefreshPage();
				validatemail(value);
			}
			
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Validate Date
	public void validatedate(String value) throws InterruptedException{
		try {
			By date = By.xpath("(//*[contains(text(),'"+value+"')])[2]");
			System.out.println(date);
			if(ElementDisplayed(date))
			{
				ExtentSuccessMessage("Successfully Displayed Current date");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Validate View Email
	public void ValidateViewEmail() throws InterruptedException{
		WaitForPageLoad();
		if(ElementDisplayed(txt_viewEmail)) {
			String SuccessMessage = findElement(txt_viewEmail).getText();
			System.out.println(SuccessMessage);
			ExtentSuccessMessage("Successfully Landed on the page: "+SuccessMessage );
		}else {
			ExtentErrorMessage("UnSuccessfully not Landed on the page ");
		}
	}
	
	//Validate Resend Email
	public void ValidateResendEmail() throws InterruptedException{
		WaitForPageLoad();
		if(ElementDisplayed(txt_resendEmail)) {
			String SuccessMessage = findElement(txt_resendEmail).getText();
			System.out.println(SuccessMessage);
			ExtentSuccessMessage("Successfully Landed on the page: "+SuccessMessage );
		}else {
			ExtentErrorMessage("UnSuccessfully not Landed on the page");
		}
	}
	
	//Validate Email Subject
	public void validatesubject(String value) throws InterruptedException{
		WaitForPageLoad();
		try {
			WaitForPageLoad();
			By subject = By.xpath("//span[@title='Complete your enrollment "+value+"']");
			String emailsubject = findElement(subject).getText();
			System.out.println(emailsubject);
			if(ElementDisplayed(subject))
			{
				ExtentSuccessMessage("Successfully Displayed Email Subject");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/////Validate if HI <Full Name> is displayed/////
	public void FullNameValidationinResendMail (String fullNameToCheck) {
		try {
			// Find the element containing the greeting message
	        WebElement greetingElement = driver.findElement(By.xpath("//td[@class='title']"));

	        // Get the text of the greeting element
	        String greetingText = greetingElement.getText();

	        // Check if the greeting contains the expected full name
	        if (greetingText.contains("Hi " + fullNameToCheck)) {
	            Log.info("Validation Passed: Hi " + fullNameToCheck + " is displayed.");
	            ExtentSuccessMessage("Validation Passed: Hi " + fullNameToCheck + " is displayed.");
	        } else {
	            Log.error("Validation Failed: Hi " + fullNameToCheck + " is not displayed.");
	            ExtentErrorMessage("Validation Failed: Hi " + fullNameToCheck + " is not displayed.");
	        }

		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}	
	}
	
	// Validate for No Record found
	public void validateNoRecordsFound() throws InterruptedException	{	
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(L_noRecordsFound))
			  { 
				Log.info("Successfully No Record Found");
				ExtentSuccessMessage("Successfully NO Record found");
			  } 
			} 
		catch (Exception e) 
	 		{
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
	
	
	
	public void validateNotificationId() {
		WebElement notificationElement = driver.findElement(By.xpath("//p[contains(@style,'font-weight:bold; color:#999999;font-size:12px;font-family:Arial,sans-serif;')]"));
        // Check if the notification ID is present
        if (notificationElement.isDisplayed()) {
            // Capture the notification ID value
            String notificationIdText = notificationElement.getText().replace("NOTIFICATION ID:", "").trim();
            // Print or use the notification ID as needed
            System.out.println("Notification ID is present: " + notificationIdText);
        } else {
            System.out.println("Notification ID is not present.");
        }	
	}
	
}
