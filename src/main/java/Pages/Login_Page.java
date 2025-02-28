package Pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
public class Login_Page extends Base_Class {
	
	//////////////////////Locator /////////////////////////
	public static By L_UserName = By.id("UserName");
	public static By L_Password = By.id("Password");
	public static By L_Login = By.xpath("//*[@class='btn btn-block btn-lg btn-primary'][contains(text(),'Login')]|//button[contains(text(),'Sign In')]");
	private static By L_Logout = By.xpath("//li/a/span[@class='user']");
	
	////////////////////////////// Method /////////////////////////////////////
	public void EnterUserNameField(String Value) throws InterruptedException{
	if(ElementDisplayed(L_UserName)) { 
		Log.info("Successfully Visible User Name Field");
		click(L_UserName);
		Log.info("Successfully Clicked On  User Name Field");
		clear(L_UserName);
		input(L_UserName,Value);
		Log.info("Successfully Enter value in  User Name Field");
		ExtentSuccessMessage("Successfully Enter value in  User Name Field");
	}else{
		Log.error("UnSuccessfully Not Visible  User Name Field");
		ExtentErrorMessage("UnSuccessfully Not Visible  User Name Field");
	}
	
	}
	
	public void EnterPasswordField(String Value) throws InterruptedException{
		if(ElementDisplayed(L_Password)) { 
			Log.info("Successfully Visible Password Field");
			click(L_Password);
			Log.info("Successfully Clicked On Password Field");
			clear(L_Password);
			input(L_Password,Value);
			Log.info("Successfully Enter value in Password Field");
			ExtentSuccessMessage("Successfully Enter value in Password Field");
		}else{
			Log.error("UnSuccessfully Not Visible  Password Field");
			ExtentErrorMessage("UnSuccessfully Not Visible  Password Field");
		}
		
		}
	public void ClickOnLoginButton() throws InterruptedException{
		if(ElementDisplayed(L_Login)) {
			Log.info("Successfully Visible Login Button");
			click(L_Login);
			Log.info("Successfully Clicked On Login Button");
			ExtentSuccessMessage("Successfully Clicked On Login Button");
			WaitForPageLoad();
		}else {
			Log.error("UnSuccessfully Not Visible Login Button");
			ExtentErrorMessage("UnSuccessfully Not Visible Login Button");
		}
	}
	
	
	public void Logout(){
		try {
			Thread.sleep(10000);
			MouseHoverOnElement(L_username);
			if (ElementDisplayed(L_Logout)) {
				Thread.sleep(10000);
				MouseHoverOnElement(L_Logout);
				click(L_Logout);
				driver.quit();
				ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
				ExtentSuccessMessage("Logout is done");
			} else {
				ExtentErrorMessage("Logout Not Visiable");
			}
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

    public boolean isLoginPageDisplayed(){
    	WaitForPageLoad();
        return  ElementDisplayed(L_username);
     }
	
	
	
}
