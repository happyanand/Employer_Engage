package Pages;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
public class Cash_Ledger_Page extends Base_Class {

	//////////////////////Locator /////////////////////////
	public static By L_CustomerNumber = By.xpath("//*[@class='more-search']//*[@id='CustomerNumber']");
	public static By L_Amount = By.id("idDeposit");
	public static By L_TransactionType = By.id("idTransactionType_chzn");	
	public static By L_AdvanceSearch = By.xpath("//*[@class='btn-group']//button[@type='button']");
	public static By L_SearchButton = By.xpath("//*[@class='more-search']//*[@onclick='FilterCashResult()']");

	////////////////////////////// Method /////////////////////////////////////

	public void ClickOnAdvanceSearch() throws InterruptedException {
		if(ElementDisplayed(L_AdvanceSearch)) {
			Log.info("AdvanceSearch is displayed");
			click(L_AdvanceSearch);
			Log.info("Successfully Clicked on the AdvanceSearch ");
			ExtentSuccessMessage("Successfully Clicked on the AdvanceSearch ");
		} else {
			Log.error("AdvanceSearch not displayed");
			ExtentErrorMessage("AdvanceSearch not displayed");
		}
	}

	public void EnterCustomerNumber(String Value) throws InterruptedException {
		if(ElementDisplayed(L_CustomerNumber)) {
			Log.info("CustomerNumber is displayed");
			input(L_CustomerNumber,Value);
			Log.info("Successfully Enter the CustomerNumber = "+Value);
			ExtentSuccessMessage("Successfully Enter the CustomerNumber = "+Value);
		} else {
			Log.error("CustomerNumber not displayed");
			ExtentErrorMessage("CustomerNumber not displayed");
		}
	}

	public void EnterDeposit_Amount(String Value) throws InterruptedException {
		if(ElementDisplayed(L_Amount)) {
			Log.info("Deposit Amount is displayed");
			input(L_Amount,Value +Keys.TAB);
			Log.info("Successfully Enter the Deposit Amount = "+Value);
			ExtentSuccessMessage("Successfully Enter the Deposit Amount = "+Value);
		} else {
			Log.error("Deposit Amount not displayed");
			ExtentErrorMessage("Deposit Amount not displayed");
		}
	}
	

	public void clickOnSearchButton() throws InterruptedException {
		if(ElementDisplayed(L_SearchButton)) {
			Log.info("Search Button is displayed");
			click(L_SearchButton);
			Log.info("Clicked on Search Button");
			ExtentSuccessMessage("Clicked on Search Button");
		} else {
			Log.error("Search Button not displayed");
			ExtentErrorMessage("Search Button not displayed");
		}
	}
	
	public String SelectTransactionTypeDropdown(String Value) throws InterruptedException {
		String Selected_Value = null;
		if(ElementDisplayed(L_TransactionType)) {
			WaitForPageLoad();
			Log.info("TransactionType DropDown is displayed");
			click(L_TransactionType);
			Log.info("Clicked on TransactionType DropDown");
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
			Log.error("TransactionType dropdown not displayed");
			ExtentErrorMessage("TransactionType dropdown not displayed");
		}
		return Selected_Value;
	}


}