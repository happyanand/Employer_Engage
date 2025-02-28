package Pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class CascadingMembership_Page extends Base_Class {
	//ExcelReader objExcel=new ExcelReader();
	Base_Class Base_Class = new Base_Class();

	//Add New Dependent Details	
	private static By ClickQualifyingEvent = By.id("Item1_QualifyingEvent_QualifyingEventName_chzn");
	private static By EffectiveDate = By.xpath("//*[@id='Item1_EffectiveDate']");
	
	private static By ClickMedicalUCM = By.xpath("//*[@id='accordion_1']/div/div[1]/a/i");
	//private static By ClickChild = By.xpath("//*[@id='Item1_ProductLst_0__Employee_Dependents_1__MemberSelectedInd']");
	private static By ClickChild = By.xpath("(//*[contains(text(),'Child')]//ancestor::li//*[@class='customCheckbox cb1'])[1]/input|//*[@id=\"Item1_ProductLst_0__Employee_Dependents_1__MemberSelectedInd\"]");
	//private static By clickNextCascade = By.xpath("//*[@id=\"BtnCascadingGotoProfile\"]");

	private static By OldDependentList = By.xpath("//*[@id='divDependentList']");
	private static By NewDependentList = By.xpath("//*[@id='Dependents']/div[1]");

	// Verification and Download
	private static By NewAddress = By.xpath("//*[@id='divContactDet']/table/tbody/tr[3]/td[2]");	
	private static By clickNext = By.xpath("//*[@id='BtnCascadingGotoProfile']");
	private static By clickSubmit = By.xpath("//*[@id='BtnSubmit']");

	public static String oldname;
	public static String newname;
	public static String address;

	
//Verify Old Name
	public String VerifyOldDependent(String oldname) {
		WaitForPageLoad();
		String ele = findElement(OldDependentList).getText();
		this.oldname = ele;
		return ele;
	}

//Verify New Name
	public String VerifyNewDependent(String newname) {
		WaitForPageLoad();
		String ele = findElement(NewDependentList).getText();
		this.newname = ele;
		return ele;
}

//click Qualifying Type
	public void clickQualifyingType(Map<Object, Object> testdata) throws InterruptedException {
	try {
		WaitForPageLoad();
		selectByRandom(ClickQualifyingEvent);
		click(EffectiveDate);
		input(EffectiveDate, testdata.get("EffectiveDate").toString());
		findElement(EffectiveDate).sendKeys(Keys.TAB);
		ExtentSuccessMessage("Successfully Selected Date");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}
	
//click Medical Plan UCM Dropdown
	public void clickMedicalCascadeDropdown() throws InterruptedException {
	try {
		WaitForPageLoad();
		click(ClickMedicalUCM);
		ExtentSuccessMessage("Successfully clicked on Medical Plan");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}

//click Child Name
	public void clickChild() throws InterruptedException {
	try {
		WaitForPageLoad();
		Thread.sleep(2000);
		waitForElementsVisible(ClickChild);
		jsClick(ClickChild);
		Thread.sleep(3000);
		WaitForPageLoad();
		ExtentSuccessMessage("Successfully clicked on Child");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}

//Fetch Address From Excel
	public String fetchFullAddress(Map<Object, Object> testdata) {
	try {
		WaitForPageLoad();	
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
	return testdata.get("FullAddress").toString();
}

//Fetch Address from Summary Page
	public String VerifyAddress(String date) {
		WaitForPageLoad();
		String ele = findElement(NewAddress).getText();
		this.address = ele;
		return ele;
}
//click Next button
	public void clickNext() throws InterruptedException {
	try {
		WaitForPageLoad();
		scrollDown();
		WaitForPageLoad();
		jsClick(clickNext);
		WaitForPageLoad();
		ExtentSuccessMessage("Successfully clicked on Next Button");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}	
	

	
//click Submit button
	public void clickSubmit() throws InterruptedException {
	try {
		//WaitForPageLoad();
		scrollDown();
		click(clickSubmit);
		Log.info("Successfully clicked on Submit Button");
		ExtentSuccessMessage("Successfully clicked on Submit Button");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}

}
