package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class EnrollReHire_Page extends Base_Class {
	
	private static By submit = By.id("BtnSubmit");
	private static By additionalInsurance_No = By
			.xpath("//label[contains(text(),'No')]/input[@id='Item1_COB_HaveConcurrentCoverageInd']");
	private static By declineAllCoverage = By.id("btnDeclineAll");
	private static By declineReasonSave = By.id("declinedReasonSave");
	private static By txtallPlanCategories = By.xpath("//h4[@class='panel-title']");
	public static By L_Enroll_New_HireNext = By.id("BtnSubmit");

//Click Next
	public void clickNext() throws InterruptedException {
	try {
		ExtentSuccessMessage("Entered Click Next Method");
		WaitForPageLoad();
		scrollDown();
		click(submit);
		ExtentSuccessMessage("Click on Submit Button");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}
	public void EnrollNewHireNext() throws InterruptedException {
		WaitForPageLoad();
		ScrollUntilElementVisible(L_Enroll_New_HireNext);
		if(ElementDisplayed(L_Enroll_New_HireNext)) {
			Log.info("Successfully Visible Next Button");
			jsClick(L_Enroll_New_HireNext);
			Log.info("Successfully Clicked On Next Button");
			ExtentSuccessMessage("Successfully Clicked on Next Button");
			
		}else{
			Log.error("UnSuccessfully Not Clicked On Next Button");
			ExtentErrorMessage("UnSuccessfully Not Clicked on Next Button");
			
		}
	}

//Decline all coverage
	public void declineAllCoverage() {
	try {
		WaitForPageLoad();
		waitForElementClickable(declineAllCoverage);
		jsClick(declineAllCoverage);
		ExtentSuccessMessage("Successfully clicked on declineAllcoverage");
		WaitForPageLoad();
		// type(declineReason,"Testing purpose");
		jsClick(declineReasonSave);
		ExtentSuccessMessage("Successfully clicked on declineReasonSave");
		scrollDown();
		jsClick(additionalInsurance_No);
		ExtentSuccessMessage("Successfully clicked on additional Insurance No");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}

	//Select plan {categoryName}
	public void selectPlan(String categoryName) {
	try {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		waitForElementClickable(txtallPlanCategories);
		declineAllCoverage();
		WaitForLoadAnimationDisappear();
		WaitForLoadAnimationDisappear();
		List<WebElement> allPlanCategories = findElements(txtallPlanCategories);
		for (WebElement categoryEle : allPlanCategories) {
			String category = categoryEle.getText().trim();
			if (category.equalsIgnoreCase(categoryName)) {
				jsClick(By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@id,'IsDeclinedInd')]"));
				scrollUpVertically();
				categoryEle.click();
				jsClick(By.xpath("(//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')])[1]"));
				ExtentSuccessMessage("Successfully Selected Plan");
				break;
			}
		}
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}
}