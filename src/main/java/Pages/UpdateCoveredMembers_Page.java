package Pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class UpdateCoveredMembers_Page extends Base_Class{

	private static By ClickActionType = By.id("Item1_DependentActionType_chzn");
	private static By ClickActionTypeTextbox = By.xpath("//div[@id='Item1_DependentActionType_chzn']//input");
	private static By ClickQualifyingEvent = By.id("Item1_QualifyingEvent_QualifyingEventName_chzn");
	private static By EffectiveDate = By.xpath("//*[@id='Item1_EffectiveDate']");
	private static By TerminationDate = By.xpath("//*[@id='Item1_EffectiveDate']");
	private static By Clickplan = By.xpath("//h4[@class='panel-title']");
	private static By ClickSpouse = By.xpath("//*[@class='na_me'][contains(text(),' Spouse')]//parent::li//*[@class='customCheckbox cb1']/input|//*[@class='na_me'][contains(text(),' Spouse')]//parent::li//*[@class='customCheckbox cb2']/input|//span[@class='customCheckbox cb1']/input[@class='cb']|//div[@class='cvr_memb']//li[2]//input[@class='cb']");
	private static By ClickConfirmationOk = By.xpath("//*[@id='btnPopDeselectOk']");
	private static By ClickNext = By.id("BtnGotoProfile");
	private static By ClickSubmit = By.xpath("//*[@id='BtnSubmitChangePlan']");
	private static By AddoldMembername = By.xpath("//*[@id='printArea']/div[2]/div/div[1]/table/tbody/tr[3]/td[2]/span");
	private static By AddnewMembername = By.xpath("//*[@id='printArea']/div[2]/div/div[1]/table/tbody/tr[2]/td[2]/span");
	private static By RemoveoldMembername = By.xpath("//*[@id='printArea']/div[2]/div/div[1]/table/tbody/tr[3]/td[2]/span");
	private static By RemovenewMembername = By.xpath("//*[@id='printArea']/div[2]/div/div[1]/table/tbody/tr[2]/td[2]/span");
	public String oldname;
	public String newname;
	private static By clickDental = By.xpath("//h4[normalize-space()='Dental']");
	private static By clickok = By.id("btnPopDeselectOk");
	
//Select Action Type Add
	public void ActionTypeADD() throws InterruptedException {
	try {
		WaitForPageLoad();
		click(ClickActionType);
		input(ClickActionTypeTextbox, "Add" + Keys.ENTER);
		ExtentSuccessMessage("Successfully Added in Action Type screen");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}
	
//Select Action Type Remove
	public void ActionTypeRemove() throws InterruptedException {
	try {
		WaitForPageLoad();
		click(ClickActionType);
		input(ClickActionTypeTextbox, "Remove" + Keys.ENTER);
		ExtentSuccessMessage("Successfully Removed in Action Type screen");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}
	
//Select Qualifying Event
	public void clickQualifyingEvent() throws InterruptedException {
	try {
		WaitForPageLoad();
		selectByRandom(ClickQualifyingEvent);
		ExtentSuccessMessage("Successfully Selected Qualifying Event");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}

//Click Effective Date
	public void clickEffectiveDate(Map<Object, Object> testdata) throws InterruptedException {
	try {
		WaitForPageLoad();
		click(EffectiveDate);
		input(EffectiveDate, testdata.get("EffectiveDate").toString() + Keys.TAB); 
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Selected Effective Date");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}	
	
//Click Termination Date
	public void clickTerminationDate(Map<Object, Object> testdata) throws InterruptedException {
	try {
		WaitForPageLoad();
		click(TerminationDate);
		input(TerminationDate, testdata.get("TerminationDate").toString() + Keys.TAB);
		ExtentSuccessMessage("Successfully Selected Termination Date");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}	
	
//Click Plan Dropdown
	public void clickPlanDropdown() throws InterruptedException {
	try {
		WaitForPageLoad();
		click(Clickplan);
		ExtentSuccessMessage("Successfully Clicked Plan dropdown");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}

	//Select Covered Member
		public void selectCoveredMember() throws InterruptedException {
		try {
			WaitForPageLoad();
			waitForElementsVisible(ClickSpouse);
			jsClick(ClickSpouse);
			WaitForPageLoad();
			if(ElementDisplayed(clickok)) {
				jsClick(clickok);
				ExtentSuccessMessage("Successfully clicked on OK popup");
				WaitForPageLoad();
			}
			ExtentSuccessMessage("Successfully Selected Spouse");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

//Click OK in the Confirmation
	public void clickConfirmationOK() throws InterruptedException {
	try {
		WaitForPageLoad();
		jsClick(ClickConfirmationOk);
		WaitForPageLoad();
		ExtentSuccessMessage("Successfully Clicked Confirmation OK");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}

//Click Next Button
	public void clickNext() throws InterruptedException {
	try {
		WaitForPageLoad();
		scrollDown();
		WaitForPageLoad();
		jsClick(ClickNext);
		ExtentSuccessMessage("Successfully clicked on NextButton");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}

//Click Submit Button
	public void clickSubmit() throws InterruptedException {
	try {
		WaitForPageLoad();
		scrollDown();
		WaitForPageLoad();
		waitForElementClickable(ClickSubmit);
		jsClick(ClickSubmit);
		WaitForPageLoad();
		ExtentSuccessMessage("Successfully Clicked on Submit Button");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}	
	
//Verify Old Name Add
	public String VerifyOldMemberNameAdd(String oldname) {
		WaitForPageLoad();
		String ele = findElement(AddoldMembername).getText();
		this.oldname = ele;
		return ele;
	}

//Verify New Name Add
	public String VerifyNewMemberNameAdd(String newname) {
		WaitForPageLoad();
		String ele = findElement(AddnewMembername).getText();
		this.newname = ele;
		return ele;
	}

//Verify Old Name Remove
	public String VerifyOldMemberNameRemove(String oldname) {
		WaitForPageLoad();
		String ele = findElement(RemoveoldMembername).getText();
		this.oldname = ele;
		return ele;
	}

//Verify New Name Remove
	public String VerifyNewMemberNameRemove(String newname) {
		WaitForPageLoad();
		String ele = findElement(RemovenewMembername).getText();
		this.newname = ele;
		return ele;
	}

//click Update Covered Members Ancillary(Dental)
	public void clickDentalDropdown() throws InterruptedException
	{
	try {
		WaitForPageLoad();
		WaitForElementToBeVisible(clickDental);
		click(clickDental);
		Log.info("Successfully Clicked On Dental DropDown");
		ExtentSuccessMessage("Successfully Clicked On Dental DropDown");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}
//Validation MemberName
	public String memberName(String Value) {
		
		//By Name = By.xpath("//*[contains(text(),'"+Value+"')]//ancestor::tbody//tr[2]//i[contains(text(),'Subscriber')]//ancestor::span");
		By Name = By.xpath("//*[contains(text(),'"+Value+"')]//ancestor::tr/following-sibling::tr/td[2]//i[contains(text(),'Subscriber')]//ancestor::span|//*[contains(text(),'iDirect Gold Copay Option 2')]//ancestor::tr/following-sibling::tr/td[2]//i[contains(text(),'Single')]//ancestor::span");
		WebElement t = driver.findElement(Name);
		String texty= null;
		if (ElementDisplayed(Name)) {
			
			texty =t.getText();
		} else {

		}
		System.out.println("Text : "+texty);
		ExtentSuccessMessage("Element found by Text :" + texty);
		return texty;
	}	

}
