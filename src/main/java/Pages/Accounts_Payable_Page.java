package Pages;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
public class Accounts_Payable_Page extends Base_Class {

	//////////////////////Locator /////////////////////////
	public static By L_PayeeName = By.id("PayeeName");
	public static By L_TransactionType = By.id("ms-list-4");	
	public static By L_AdvanceSearch = By.xpath("//*[@class='btn-group']//button[@type='button']");
	public static By L_SearchButton = By.xpath("(//*[@onclick='GetPaymentBatchList()'])[2]");

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

	public void EnterPayeeName(String Value) throws InterruptedException {
		if(ElementDisplayed(L_PayeeName)) {
			Log.info("PayeeName is displayed");
			input(L_PayeeName,Value);
			Log.info("Successfully Enter the PayeeName = "+Value);
			ExtentSuccessMessage("Successfully Enter the PayeeName = "+Value);
		} else {
			Log.error("PayeeName not displayed");
			ExtentErrorMessage("PayeeName not displayed");
		}
	}

	// Select Transaction Type
	public void SelectTransactionType(String Status) throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		if(ElementDisplayed(L_TransactionType)) {
			Log.info("TransactionType is displayed");
			click(L_TransactionType);	
			Log.info("Successfully Clicked on the TransactionType Dropdown");
			ExtentSuccessMessage("Successfully Clicked on the TransactionType DropDown  ");
			By xpths =By.xpath("//*[@data-search-term='"+Status+"']//label");
			click(xpths);
			Log.info("Successfully Clicked on the "+Status+" ");
			ExtentSuccessMessage("Successfully Clicked on the "+Status+" ");
		} else {
			Log.error("TransactionType not displayed");
			ExtentErrorMessage("TransactionType not displayed");
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

	public Boolean ValidateAmount(String Value) throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		By xpaths =By.xpath("(//td[normalize-space()='"+Value+"'])[1]");
		return ElementDisplayed(xpaths);
	}


}