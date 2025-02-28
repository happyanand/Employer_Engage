package Pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;

public class RenewalCenter_Page extends Base_Class {
		
	private static By click_legal=By.xpath("//h4[normalize-space()='Legal']");
	private static By renewalDDXpath = By.xpath("//span[text()=' Renewal ']/parent::a");
		
	//Click Legal Plan
	public void clickLegalplan() throws InterruptedException{
	try {
		click(click_legal);
		ExtentSuccessMessage("Successfully clicked on Legal Plan");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}
	
	//Decline CheckBox
	public void declinecheckbox(String value) throws InterruptedException{
	try {
	//	WaitForLoadAnimationDisappear();
		By xpath = By.xpath("(//*[contains(@class,'Enroll-Decline')]//*[@data-categoryvalue='"+value+"'])");
	   	jsClick(xpath);
	  // 	WaitForLoadAnimationDisappear();
	    ExtentSuccessMessage("Successfully Checked Declined checkbox" + value);
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}
	
	//Select Plan
	public void SelectRCPlan(String value, String index) throws InterruptedException{
	try {
		//WaitForLoadAnimationDisappear();
	   	By xpath = By.xpath("(//label[contains(@class,'btn btn-default addtoselect Yesnoclass')]//*[@data-categoryvalue='"+value+"'])[@data-index='"+index+"']//parent::label|//label[contains(@class,'btn btn-default addtoselect Yesnoclass')]//*[@data-categoryvalue='"+value+"']");
	   
	   	if(ElementDisplayed(xpath)) {
	   		jsClick(xpath);
	   	}else {
	   		By xpaths = By.xpath("//*[text()='Select Plan']//ancestor::label//*[@data-index='1']");
	   		ScrolltillElementOnmiddlepage(xpaths);
	   		System.out.println("Testing");
	   		jsClick(xpaths);
	   		System.out.println("Testing");
	   	}
	   	//WaitForLoadAnimationDisappear();
	 	WaitForPageLoad();
	   	WaitForAJAX_ToLoad();
	   	scrollUpVertically();
	   	ExtentSuccessMessage("Successfully Selected Plan" + value + index );
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
	}
	
	//Ramya Oct 5th 
	//Selects Dependent CheckBox
	public void dependentcheckbox(String value, String plan) {
		try {
			WaitForLoadAnimationDisappear();
			By xpath =By.xpath("//div[@data-categoryvalue='"+plan+"']//*[contains(text(),'"+value+"')]/preceding-sibling::span/span/input");
		   	jsClick(xpath);
		   	WaitForLoadAnimationDisappear();
		    ExtentSuccessMessage("Successfully Checked Dependent checkbox" + value);
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Renewal page displayed
	public Boolean isRenewalPageDisplayed() throws InterruptedException{
		WaitForPageLoad();
	    return ElementDisplayed(renewalDDXpath);
	}
}
