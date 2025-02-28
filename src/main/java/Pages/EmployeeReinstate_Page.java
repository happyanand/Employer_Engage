package Pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class EmployeeReinstate_Page extends Base_Class {
	public static By listOfCategories = By.xpath("//h4[@class='panel-title']");
	public static By restore = By.id("BtnSubmitReinstate");
	public static By yes = By.xpath("//button[text()='Yes']");
	public static By restoreSuccess = By.xpath("//div[text()='The selected employee has been restored successfully']");
	public static By ok = By.id("btnOk");
	public static By Message = By.id("modalBody");

	//"Verify Plan categories"
	public List<String> getSelectedPlanCategories() {
		List<WebElement> allCategories = findElements(listOfCategories);
		List<String> categories = new ArrayList<>();
		for (WebElement element : allCategories) {
			categories.add(element.getText());
		}
		return categories;
	}

	//"Restore"
	public void restore() throws InterruptedException {
		try {
			ExtentSuccessMessage("Successfully Entered restore");
			WaitForPageLoad();
			click(restore);
			Log.info("Successfully clicked on restore");
			ExtentSuccessMessage("Successfully clicked on restore");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(yes));
			click(yes);
			Log.info("Successfully clicked on Yes button");
			ExtentSuccessMessage("Successfully clicked on Yes button");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//"Restore successful message displayed"
	public boolean isRestoreSuccessfulMessageDisplayed() throws InterruptedException {
		WaitForPageLoad();
		waitForElementClickable(restoreSuccess, 40);
		Boolean flag = ElementDisplayed(restoreSuccess);
		jsClick(ok);
		Log.info("Employee ReInstate is Successful and Employee is Restored.");
		ExtentSuccessMessage("Employee ReInstate is Successful and Employee is Restored.");
		return flag;
	}
}
