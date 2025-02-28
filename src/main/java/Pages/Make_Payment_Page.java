package Pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class Make_Payment_Page extends Base_Class {
	
	
	public static By L_submit = By.xpath("//input[@id='btnSavePayment']");
	public static By btn_ok = By.xpath("//input[@id='btnWarningOk']");
	public static By L_otherAmount = By.xpath("//input[@id='billTypeOther']");
	public static By txt_amount = By.xpath("//input[@id='otherDue']");
	public static By txt_comment = By.xpath("//input[@id='paymentComment']");
	
	
	//click on Submit
	public void clickonsubmit() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(L_submit);
			Log.info("Successfully clicked on Submit Payment");
			ExtentSuccessMessage("Successfully clicked on Submit Payment");
			jsClick(btn_ok);
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Submit Button" + e.getMessage());
		}
	}
	
	//Enter Other Amount
	public void enterOtherAmount(String amount) throws InterruptedException {
		try {
			WaitForPageLoad();
			jsClick(L_otherAmount);
			Log.info("Successfully clicked on Other Amount");
			ExtentSuccessMessage("Successfully clicked on Other Amount");
			jsClick(txt_amount);
			input(txt_amount,amount);
			Log.info("Successfully Entered Amount");
			ExtentSuccessMessage("Successfully Entered Amount");
			
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Other Amount" + e.getMessage());
		}
	}
	
	//Payment Comments
	public String paymentcomments() throws InterruptedException {
		String Paymentcomments = "Payment Successful";
		try {
			WaitForPageLoad();
			click(txt_comment);
			input(txt_comment,Paymentcomments);
			Log.info("Successfully Added Comments");
			ExtentSuccessMessage("Successfully Added Comments");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to Added Comments" + e.getMessage());
		}
		return Paymentcomments;
	}

}
