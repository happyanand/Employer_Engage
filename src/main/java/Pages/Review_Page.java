package Pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;

public class Review_Page extends Base_Class {
	
	private static By L_global = By.xpath("//label[@for='page-global']");
	
	private static By L_segment = By.xpath("//label[@for='page-Segment']");
	
	private static By L_account = By.xpath("//label[@for='page-group']");
	
	
	//Click on Global
	public void ClickOnglobal() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			WaitForPageLoad();
			jsClick(L_global);
			ExtentSuccessMessage("Successfully Clicked ON Global");
		} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}

	//Click on Business Segment
	public void ClickOnsegment() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			WaitForPageLoad();
			jsClick(L_segment);
			ExtentSuccessMessage("Successfully Clicked ON Business Segment");
		} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}

	//Click on Account Specific
	public void ClickOnaccount() throws InterruptedException{
		WaitForPageLoad();
		Thread.sleep(2000);
		try {
			WaitForPageLoad();
			jsClick(L_account);
			ExtentSuccessMessage("Successfully Clicked ON Account Specific");
		} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}
	
	
	//Validate Global Audience
	public void validateglobal(String value) throws InterruptedException{
		WaitForPageLoad();
		try {
			By audience_txt = By.xpath("(//span[normalize-space()='"+value+"'])[1]");
			if(ElementDisplayed(audience_txt))
			{
				ExtentSuccessMessage("Successfully Displayed "+value+" Audience");
			}else {
				ExtentErrorMessage("UnSuccessfully Not Displayed "+value+" Audience");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Validate Business Segment
	public void validatesegment(String value) throws InterruptedException{
		WaitForPageLoad();
		try {
			By audience_txt = By.xpath("(//table[@class='table cms-grid table-striped table-fixer']//span[contains(text(),'"+value+"')])[1]");
			if(ElementDisplayed(audience_txt))
			{
				ExtentSuccessMessage("Successfully Displayed "+value+" Audience");
			}else {
				ExtentErrorMessage("UnSuccessfully Not Displayed "+value+" Audience");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Validate Account Specific
	public void validateAccount(String value) throws InterruptedException{
		WaitForPageLoad();
		try {
			By audience_txt = By.xpath("(//span[@title='"+value+"'])[1]");
			if(ElementDisplayed(audience_txt))
			{
				ExtentSuccessMessage("Successfully Displayed "+value+" Audience");
			}else {
				ExtentErrorMessage("UnSuccessfully Not Displayed "+value+" Audience");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}	
	
}
