package Pages;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
public class Pension_Authority_File_Generation extends Base_Class {

	//////////////////////Locator /////////////////////////
	public static By L_SelectDropdown = By.id("FileValues_chzn");
	public static By L_GenerateAndDownload = By.id("btnDownload");

	////////////////////////////// Method /////////////////////////////////////



	public void SelectDropwnAndDownloadFile(String DropdownValue) throws InterruptedException {
		String Value =SelectDropdown(DropdownValue);
		assertEquals(Value,DropdownValue);
		clickOnDownloadFile();
		Thread.sleep(10000);
		assertEquals(GetFilesCountInDownloadDirectory(), 1);
		DeleteFiles(Base_Class.DownloadDirectory);
	}

	public String SelectDropdown(String Value) throws InterruptedException {
		String Selected_Value = null;
		if(ElementDisplayed(L_SelectDropdown)) {
			Log.info("Select DropDown is displayed");
			click(L_SelectDropdown);
			Log.info("Clicked on Select DropDown");
			By xpath =By.xpath("//*[text()='"+Value+"']//parent::li[@class='active-result']");
			if(ElementDisplayed(xpath)) {
				Log.info(Value+" Is Successfully Visible");
				click(xpath);
				Log.info(Value+" Is Successfully Clicked ");
				ExtentSuccessMessage(Value+" Is Successfully Clicked ");
			} else {
				Log.error(Value+" Is Unsuccessfully Not displayed");
				ExtentErrorMessage(Value+" Is Unsuccessfully Not displayed");
			}
			WaitForLoadAnimationDisappear();
			By selectedResult =By.xpath("//*[@class='chzn-single selected']//span");
			if(ElementDisplayed(selectedResult)) {
				WebElement Result = driver.findElement(selectedResult);
				Selected_Value=Result.getText();
			}
		}else {
			Log.error("Select dropdown not displayed");
			ExtentErrorMessage("Select dropdown not displayed");
		}
		return Selected_Value;
	}

	public void clickOnDownloadFile() throws InterruptedException {
		if(ElementDisplayed(L_GenerateAndDownload)) {
			Log.info("Generate & Download Button is displayed");
			click(L_GenerateAndDownload);
			Log.info("Clicked on Generate & Download Button");
			ExtentSuccessMessage("Clicked on Generate & Download Button");
		} else {
			Log.error("Generate & Download Button not displayed");
			ExtentErrorMessage("Generate & Download Button not displayed");
		}
	}
}
