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
public class Refund_Center_Page extends Base_Class {

	//////////////////////Locator /////////////////////////
	public static By L_CustomerNumber = By.xpath("//*[@id='refundSearch']//*[@name='CustomerNumber']");
	public static By L_Amount = By.id("idDeposit");
	public static By L_Addbutton = By.id("btnAddRefund");
	public static By L_Okbutton = By.id("btnWarningOk");
	public static By L_OkConfirmbutton = By.id("btnOkConfirm");
	public static By L_Yesbutton = By.id("btnapprove");
	public static By L_RefundStatus = By.id("ms-list-2");
	public static By L_SelectAllStatus = By.xpath("//a[@class='ms-selectall theme-text global selected']");
	public static By L_ApproveButton = By.id("btn_SavePayeeName");
	public static By L_AdvanceSearch = By.xpath("//*[@class='btn-group']//button[@type='button']");
	public static By L_SearchResultButton = By.xpath("//*[@onclick='FilterResult()']");
	public static By L_SearchButton = By.xpath("//*[@onclick=\"FilterResult('Advanced')\"]");
	public static By L_TickMarkIcon = By.xpath("(//*[@id='btnapproveSingle'])[1]");
	public static By L_SearchPayeeName = By.id("btnSearchPayeeName");
	public static By L_RefundAmount = By.id("RefundAmount");
	public static By L_SelectAll = By.xpath("//*[@class='ms-options-wrap ms-has-selections ms-active']//*[text()='Select all']");
	public static By L_SSN = By.xpath("//*[@id='PayeeFromSystem']//*[@id='Ssn']");//*[@id='PayeeFromSystem']//*[@id='Ssn_mask']//parent::");
	public static By L_CustomerNo = By.xpath("//*[@id='PayeeFromSystem']//*[@id='CustomerNumber']");
	public static By L_PayeeName = By.xpath("(//*[@data-th='Payee Name']//label)[1]");
	
	
	
	////////////////////////////// Method /////////////////////////////////////

	// Click On Advance Search
	public void ClickOnAdvanceSearch() throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
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

	//Click On First Tick Mark Icon
	public void ClickOnFirstTickMarkIcon() throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		if(ElementDisplayed(L_TickMarkIcon)) {
			Log.info("TickMarkIcon is displayed");
			Thread.sleep(8000);
			click(L_TickMarkIcon);
			Log.info("Successfully Clicked on the TickMarkIcon ");
			ExtentSuccessMessage("Successfully Clicked on the TickMarkIcon ");
		} else {
			Log.error("TickMarkIcon not displayed");
			ExtentErrorMessage("TickMarkIcon not displayed");
		}
	}

	// Select Refund Status
	public void SelectAllRefundStatus() throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		if(ElementDisplayed(L_RefundStatus)) {
			Log.info("RefundStatus is displayed");
			click(L_RefundStatus);	
			Log.info("Successfully Clicked on the RefundStatus Dropdown");
			ExtentSuccessMessage("Successfully Clicked on the RefundStatus DropDown  ");
			click(L_SelectAll);
			Log.info("Successfully Clicked on the SelectAll ");
			ExtentSuccessMessage("Successfully Clicked on the SelectAll ");
		} else {
			Log.error("RefundStatus not displayed");
			ExtentErrorMessage("RefundStatus not displayed");
		}
	}
	
	// Select Refund Status
		public void SelectRefundStatus(String Status) throws InterruptedException {
			WaitForPageLoad();
			WaitForLoadAnimationDisappear();
			if(ElementDisplayed(L_RefundStatus)) {
				Log.info("RefundStatus is displayed");
				click(L_RefundStatus);	
				click(L_SelectAllStatus);
				WaitForLoadAnimationDisappear();
				Log.info("Successfully Clicked on the RefundStatus Dropdown");
				ExtentSuccessMessage("Successfully Clicked on the RefundStatus DropDown  ");
				By xpths =By.xpath("//*[@data-search-term='"+Status+"']//label");
				click(L_SelectAllStatus);
				click(xpths);
				Log.info("Successfully Clicked on the "+Status+" ");
				ExtentSuccessMessage("Successfully Clicked on the "+Status+" ");
			} else {
				Log.error("RefundStatus not displayed");
				ExtentErrorMessage("RefundStatus not displayed");
			}
		}

	// Enter Customer Number
	public void EnterCustomerNumber(String Value) throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
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

	// Enter Deposit_Amount
	public void EnterDeposit_Amount(String Value) throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		if(ElementDisplayed(L_Amount)) {
			Log.info("Deposit Amount is displayed");
			input(L_Amount,Value);
			Log.info("Successfully Enter the Deposit Amount = "+Value);
			ExtentSuccessMessage("Successfully Enter the Deposit Amount = "+Value);
		} else {
			Log.error("Deposit Amount not displayed");
			ExtentErrorMessage("Deposit Amount not displayed");
		}
	}

	// click On Search Button
		public void clickOnSearchButton() throws InterruptedException {
			WaitForPageLoad();
			WaitForLoadAnimationDisappear();
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
		// click On Search Button
		public void clickOnSearchResultButton() throws InterruptedException {
			WaitForPageLoad();
			WaitForLoadAnimationDisappear();
			if(ElementDisplayed(L_SearchResultButton)) {
				Log.info("Search Result Button is displayed");
				click(L_SearchResultButton);
				Log.info("Clicked on Search Result Button");
				ExtentSuccessMessage("Clicked on Search Result Button");
			} else {
				Log.error("Search Result Button not displayed");
				ExtentErrorMessage("Search Result Button not displayed");
			}
		}
	
	


	// click On Yes Button
	public void clickOnYesButton() throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		if(ElementDisplayed(L_Yesbutton)) {
			Log.info("Yes Button is displayed");
			click(L_Yesbutton);
			Log.info("Clicked on Yes Button");
			ExtentSuccessMessage("Clicked on Yes Button");
		} else {
			Log.error("Yes Button not displayed");
			ExtentErrorMessage("Yes Button not displayed");
		}
	}

	// click On Approve Button
	public void clickOnApproveButton() throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		if(ElementDisplayed(L_ApproveButton)) {
			Log.info("Approve Button is displayed");
			click(L_ApproveButton);
			Log.info("Clicked on Approve Button");
			ExtentSuccessMessage("Clicked on Approve Button");
		} else {
			Log.error("Approve Button not displayed");
			ExtentErrorMessage("Approve Button not displayed");
		}
	}


	// click On OK Button
	public void clickOnOkButton() throws InterruptedException {
		Thread.sleep(8000);
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		if(ElementDisplayed(L_Okbutton)) {
			Log.info("OK Button is displayed");
			click(L_Okbutton);
			Log.info("Clicked on OK Button");
			ExtentSuccessMessage("Clicked on OK Button");
		} else {
			Log.error("OK Button not displayed");
			ExtentErrorMessage("OK Button not displayed");
		}
	}
	
	// click On OK Button
	public void clickOnOkConfirmButton() throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		if(ElementDisplayed(L_OkConfirmbutton)) {
			Log.info("OK Button is displayed");
			click(L_OkConfirmbutton);
			Log.info("Clicked on OK Button");
			ExtentSuccessMessage("Clicked on OK Button");
		} else {
			Log.error("OK Button not displayed");
			ExtentErrorMessage("OK Button not displayed");
		}
	}


	// click On Add Button
	public void clickOnAddButton() throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		if(ElementDisplayed(L_Addbutton)) {
			Log.info("Add Button is displayed");
			click(L_Addbutton);
			Log.info("Clicked on Add Button");
			ExtentSuccessMessage("Clicked on Add Button");
		} else {
			Log.error("Add Button not displayed");
			ExtentErrorMessage("Add Button not displayed");
		}
	}

	// Enter SSN No
	public void EnterSSN_No(String Value) throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		if(ElementDisplayed(L_SSN)) {
			Log.info("SSN No is displayed");
			Thread.sleep(5000);
			input(L_SSN,Value);
			Log.info("Successfully Enter the SSN No = "+Value);
			ExtentSuccessMessage("Successfully Enter the SSN No = "+Value);
		} else {
			Log.error("SSN No not displayed");
			ExtentErrorMessage("SSN No not displayed");
		}
	}

	// Enter Customer No
	public void EnterCustomerNo(String Value) throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		if(ElementDisplayed(L_CustomerNo)) {
			Log.info("CustomerNo is displayed");
			Thread.sleep(5000);
			input(L_CustomerNo,Value);
			Log.info("Successfully Enter the CustomerNo = "+Value);
			ExtentSuccessMessage("Successfully Enter the CustomerNo = "+Value);
		} else {
			Log.error("CustomerNo not displayed");
			ExtentErrorMessage("CustomerNo not displayed");
		}
	}


	// Enter Refund Amount
	public void EnterRefundAmount(String Value) throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		if(ElementDisplayed(L_RefundAmount)) {
			Log.info("Refund Amount is displayed");
			Thread.sleep(5000);
			input(L_RefundAmount,Value);
			Log.info("Successfully Enter the Refund Amount = "+Value);
			ExtentSuccessMessage("Successfully Enter the Refund Amount = "+Value);
		} else {
			Log.error("Refund Amount not displayed");
			ExtentErrorMessage("Refund Amount not displayed");
		}
	}
	// click On Search PayeeName Button
	public void clickOnSearchPayeeNameButton() throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		if(ElementDisplayed(L_SearchPayeeName)) {
			Log.info("Search PayeeName Button is displayed");
			click(L_SearchPayeeName);
			Log.info("Clicked on Search PayeeName Button");
			ExtentSuccessMessage("Clicked on Search PayeeName Button");
		} else {
			Log.error("Search PayeeName Button not displayed");
			ExtentErrorMessage("Search PayeeName Button not displayed");
		}
	}

	public void SelectEmployeeRadioButton(String CustomerNo) throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		By xpath = By.xpath("//*[@data-customernumber='"+CustomerNo+"']");
		if(ElementDisplayed(xpath)) {
			Log.info("Select Employee Radio Button is displayed");
			click(xpath);
			Log.info("Clicked on Select Employee Radio Button");
			ExtentSuccessMessage("Clicked on Select Employee Radio Button");
		} else {
			Log.error("Select Employee Radio Button not displayed");
			ExtentErrorMessage("Select Employee Radio Button not displayed");
		}

	}
	
	//Validate Refund Amount
	public Boolean ValidateRefundAmount(String Value) throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		By xpaths =By.xpath("(//td[@data-th='Refunding Amount'][normalize-space()='"+Value+"'])[1]");
		return ElementDisplayed(xpaths);
	}
	
	//Validate Refund Status
	public Boolean ValidateRefundStatus(String Value) throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		By xpaths =By.xpath("(//td[@data-th='Refund Status'][normalize-space()='"+Value+"'])[1]");
		return ElementDisplayed(xpaths);
	}
	
	public String GetPayeeName() throws InterruptedException {
		String PayeeName =GetElementText(L_PayeeName);
		return PayeeName;
	}


	//	public String SelectTransactionTypeDropdown(String Value) throws InterruptedException {
	//		String Selected_Value = null;
	//		if(ElementDisplayed(L_TransactionType)) {
	//			Log.info("TransactionType DropDown is displayed");
	//			click(L_TransactionType);
	//			Log.info("Clicked on TransactionType DropDown");
	//			By xpath =By.xpath("//*[text()='"+Value+"']//parent::li[@class='active-result']");
	//			if(ElementDisplayed(xpath)) {
	//				Log.info(Value+" Is Successfully Visible");
	//				click(xpath);
	//				Log.info(Value+" Is Successfully Clicked ");
	//				ExtentSuccessMessage(Value+" Is Successfully Clicked ");
	//			} else {
	//				Log.error(Value+" Is Unsuccessfully Not displayed");
	//				ExtentErrorMessage(Value+" Is Unsuccessfully Not displayed");
	//			}
	//			WaitForLoadAnimationDisappear();
	//			By selectedResult =By.xpath("//*[@class='chzn-single selected']//span");
	//			if(ElementDisplayed(selectedResult)) {
	//				WebElement Result = driver.findElement(selectedResult);
	//				Selected_Value=Result.getText();
	//			}
	//		}else {
	//			Log.error("TransactionType dropdown not displayed");
	//			ExtentErrorMessage("TransactionType dropdown not displayed");
	//		}
	//		return Selected_Value;
	//	}


}