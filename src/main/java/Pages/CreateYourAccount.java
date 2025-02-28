package Pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class CreateYourAccount extends Base_Class {
	Base_Class Base_Class =new Base_Class();

	//////////////////////////////Locator Create Your Account/////////////////////////////////


	public static  By L_UserName = By.xpath("//input[@id='CreateUser_UserName']");

	public static By L_Password = By.xpath("//input[@id='CreateUser_Password']");

	public static By L_ConfirmPasswordFBMCUserCreatAcc = By.xpath("//input[@id='CreateUser_ConfirmPassword']");

	public static By L_FirstSecurityQuest1 = By.xpath("//*[@id='CreateUser_SecurityQuestionId1_chzn']//*[@class='chzn-single chzn-default']");

	public static By L_SecurityQuest1Search = By.xpath("(//*[@class='chzn-search']//*[@type='text'])[1]");

	public static By L_FirstSecurityAnswer1 = By.id("CreateUser_SecurityAnswer1");

	public static By L_SceondSecurityQuest2 = By.xpath("//*[@id='CreateUser_SecurityQuestionId2_chzn']//*[@class='chzn-single chzn-default']");

	public static By L_SecurityQuest2Search = By.xpath("(//*[@class='chzn-search']//*[@type='text'])[2]");

	public static By L_SceondSecurityAnswer2 = By.id("CreateUser_SecurityAnswer2");

	public static By L_ThirdSecurityQuest3 = By.id("CreateUser_SecurityQuestionId3_chzn");

	//	public static By L_ThirdSecurityQuest3 = By.xpath("//*[@id='CreateUser_SecurityQuestionId3_chzn']//*[@class='chzn-single chzn-default']");

	public static By L_SecurityQuest3Search = By.xpath("(//*[@class='chzn-search']//*[@type='text'])[3]");

	public static By L_ThirdSecuritAnswer3 = By.id("CreateUser_SecurityAnswer3"); 

	//	public static By L_PriPoliAndTerConCheckBox = By.id("lichkBox");
	public static By L_PriPoliAndTerConCheckBox = By.xpath("//a[@id='showEulaPopups']|//*[@class='md-checkbox no-label']");

	public static By L_CheckBoxIAccept = By.id("btaccepttest");

	public static By L_CheckBoxPrint = By.xpath("//*[@class='btn btn-default btn-lg printelu'][@value='Print'][1]");


	public static By L_CreateUserRegistrationButton = By.xpath("//*[contains(text(),'REGISTER')] | //*[@id='RegisterBtn']|//input[@value='Submit']");

	public static By L_ClickLoginLink = By.xpath("//*[text()='Click here to Login']");

	public static  By L_IHAUserName = By.id("UserName");

	public static By L_IHAPassword = By.id("Password");
	public static By L_IHAConfirmPasswordFBMCUserCreatAcc = By.id("ReTypePassword");
	public static By L_IAccept = By.xpath("//div[@class='modal-footer nomargin-btn text-center']//input[@value='I Accept']");
	public static By L_IHAPriPoliAndTerConCheckBox = By.xpath("//a[@id='showEulaPopups']");

	public static By L_successmessage = By.xpath("//h4[normalize-space()='Successfully Registered !']");

	////////////////////////////////////Create Your Account Methods //////////////////////////////////////


	public void EnterCreateUserName(String Value) throws InterruptedException {
		if(ElementDisplayed(L_UserName)) {
			Log.info("Successfully Visible User Name Field");
			click(L_UserName);
			Log.info("Successfully Clicked On User Name Field");
			clear(L_UserName);
			input(L_UserName, Value);
			ExtentSuccessMessage("Successfully Enter User Name In User Name Field " + Value);
		}else {
			Log.error("UnSuccessfully Not Visible User Name Field");
			ExtentErrorMessage("UnSuccessfully Not Visible User Name Field");
		}

	}


	public void EnterCreatePassworde(String Value) throws InterruptedException {
		if(ElementDisplayed(L_Password)) {
			Log.info("Successfully Visible Password Field");
			click(L_Password);
			Log.info("Successfully Clicked On Password Field");
			clear(L_Password);
			input(L_Password, Value);
			ExtentSuccessMessage("Successfully Enter Password In Password Field " + Value);
		}else {
			Log.error("UnSuccessfully Not Visible Password Field");
			ExtentErrorMessage("UnSuccessfully Not Visible Password Field");
		}

	}

	public void EnterCreateConfirmPassworde(String Value) throws InterruptedException {
		if(ElementDisplayed(L_ConfirmPasswordFBMCUserCreatAcc)) {
			Log.info("Successfully Visible Confirm Password Field");
			click(L_ConfirmPasswordFBMCUserCreatAcc);
			Log.info("Successfully Clicked On Confirm Password Field");
			clear(L_ConfirmPasswordFBMCUserCreatAcc);
			input(L_ConfirmPasswordFBMCUserCreatAcc, Value);
			ExtentSuccessMessage("Successfully Enter Confirm Password In Confirm Password Field" + Value);
		}else {
			Log.error("UnSuccessfully Not Visible Password Field");
			ExtentErrorMessage("UnSuccessfully Not Visible Password Field");
		}

	}

	//	public void SelectDropDownValueSecurityQue1(String Value) throws InterruptedException{
	//		SelectDropDownOption(L_FirstSecurityQuest1,Value);
	//		ExtentSuccessMessage("Successfully clicked and selected a value from the Security Question 1 dropdown : " + Value);
	//
	//	}

	public void EnterSecurityQuestion1(String Value) throws InterruptedException, AWTException {
		if(ElementDisplayed(L_FirstSecurityQuest1)) { 
			Log.info("Successfully Visible First Security Question Dropdown");
			MouseHoverOnElement(L_FirstSecurityQuest1);
			click(L_FirstSecurityQuest1);
			Log.info("Successfully Clicked On First First Security Question Dropdown");
			click(L_SecurityQuest1Search);
			Log.info("Successfully Clicked On First First Security Question Field");
			input(L_SecurityQuest1Search,Value);
			RobotKeyOperation("ENTER");
			KeyOperation("TAB");
			Log.info("Successfully Enter value in Security Question Field");
			ExtentSuccessMessage("Successfully Enter value in First Security Question Field");
		}else{
			Log.error("UnSuccessfully Not Visible First Security Question Dropdown");
			ExtentErrorMessage("UnSuccessfully Not Visible First Security Question Dropdown");
		}
	}

	public void EnterSecurityQuestion2(String Value) throws InterruptedException, AWTException {
		Thread.sleep(3000);
		if(ElementDisplayed(L_SceondSecurityQuest2)) { 
			Log.info("Successfully Visible Second Security Question Dropdown");
			MouseHoverOnElement(L_SceondSecurityQuest2);
			click(L_SceondSecurityQuest2);
			Log.info("Successfully Clicked On Second Security Question Dropdown");
			click(L_SecurityQuest2Search);
			Log.info("Successfully Clicked On Second Security Question Dropdown");
			input(L_SecurityQuest2Search,Value);
			RobotKeyOperation("ENTER");
			KeyOperation("TAB");
			Log.info("Successfully Enter value in Second Security Question Field");
			ExtentSuccessMessage("Successfully Enter value in Second Security Question Field");
		}else{
			Log.error("UnSuccessfully Not Visible Second Security Question Field");
			ExtentErrorMessage("UnSuccessfully Not Visible Second Security Question Field");
		}
	}

	public void EnterSecurityQuestion3(String Value) throws InterruptedException, AWTException {
		Thread.sleep(3000);
		if(ElementDisplayed(L_ThirdSecurityQuest3)) { 
			Log.info("Successfully Visible Third Security Question Dropdown");
			ScrolltillElementOnmiddlepage(L_ThirdSecurityQuest3);
			MouseHoverOnElement(L_ThirdSecurityQuest3);
			click(L_ThirdSecurityQuest3);
			Log.info("Successfully Clicked On Third Security Question Field");
			click(L_SecurityQuest3Search);
			input(L_SecurityQuest3Search,Value);
			RobotKeyOperation("ENTER");
			KeyOperation("TAB");
			Log.info("Successfully Enter value in Third Security Question Field");
			ExtentSuccessMessage("Successfully Enter value in Third Security Question Field");
		}else{
			Log.error("UnSuccessfully Not Visible Third Security Question Field");
			ExtentErrorMessage("UnSuccessfully Not Visible Third Security Question Field");
		}
	}

	//	public void SelectDropDownValueSecurityQue2(String Value) throws InterruptedException{
	//		SelectDropDownOption(L_SceondSecurityQuest2,Value);
	//		//By i = By.xpath("//*[text()='" + Value + "']//ancestor::td[1]");
	//		ExtentSuccessMessage("Successfully clicked and selected a value from the Security Question 2 dropdown : " + Value);
	//
	//	}
	//
	//	public void SelectDropDownValueSecurityQue3(String Value) throws InterruptedException{
	//		SelectDropDownOption(L_ThirdSecurityQuest3,Value);
	//		ExtentSuccessMessage("Successfully clicked and selected a value from the Security Question 3 dropdown : " + Value);
	//
	//	}

	public void EnterSecurityAnswer1(String Value) throws InterruptedException {
		if(ElementDisplayed(L_FirstSecurityAnswer1)) { 
			Log.info("Successfully Visible Security Answer 1 Field");
			click(L_FirstSecurityAnswer1);
			Log.info("Successfully Clicked On Security Answer 1 Field");
			input(L_FirstSecurityAnswer1,Value);
			Log.info("Successfully Enter value in Security Answer 1 Field");
			ExtentSuccessMessage("Successfully Enter value in Security Answer 1 Field");
		}else{
			Log.error("UnSuccessfully Not Visible Security Answer 1 Field");
			ExtentErrorMessage("UnSuccessfully Not Visible Security Answer 1 Field");
		}


	}


	public void EnterSecurityAnswer2(String Value) throws InterruptedException {
		if(ElementDisplayed(L_SceondSecurityAnswer2)) { 
			Log.info("Successfully Visible Security Answer 2 Field");
			click(L_SceondSecurityAnswer2);
			Log.info("Successfully Clicked On Security Answer 2 Field");
			input(L_SceondSecurityAnswer2,Value);
			Log.info("Successfully Enter value in Security Answer 2 Field");
			ExtentSuccessMessage("Successfully Enter value in Security Answer 1 Field");
		}else{
			Log.error("UnSuccessfully Not Visible Security Answer 2 Field");
			ExtentErrorMessage("UnSuccessfully Not Visible Security Answer 2 Field");
		}


	}

	public void EnterSecurityAnswer3(String Value) throws InterruptedException {
		if(ElementDisplayed(L_ThirdSecuritAnswer3)) { 
			Log.info("Successfully Visible Security Answer 3 Field");
			click(L_ThirdSecuritAnswer3);
			Log.info("Successfully Clicked On Security Answer 3 Field");
			input(L_ThirdSecuritAnswer3,Value);
			Log.info("Successfully Enter value in Security Answer 3 Field");
			ExtentSuccessMessage("Successfully Enter value in Security Answer 3 Field");
		}else{
			Log.error("UnSuccessfully Not Visible Security Answer 3 Field");
			ExtentErrorMessage("UnSuccessfully Not Visible Security Answer 3 Field");
		}


	}



	public void ClickOnPriPolicyAndTermsConCheckBox() throws InterruptedException{
		if(ElementDisplayed(L_PriPoliAndTerConCheckBox)) {
			Log.info("Successfully Visible Privacy Policy And Terms Of Service CheckBox");
			click(L_PriPoliAndTerConCheckBox);
			Log.info("Successfully Clicked On Privacy Policy And Terms Of Service CheckBox");
			ExtentSuccessMessage("Successfully Clicked On Privacy Policy And Terms Of Service CheckBox");
		}else {
			Log.error("UnSuccessfully Not Visible  Privacy Policy And Terms Of Service CheckBox");
			ExtentErrorMessage("UnSuccessfully Not Visible  Privacy Policy And Terms Of Service CheckBox");
		}
	}

	public void ClickOnIAcceptButton() throws InterruptedException{
		WaitForPageLoad();
		do {
			ScrolltillElementOnmiddlepage(L_CheckBoxIAccept);
			Thread.sleep(1000);
		} while (!ElementDisplayed(L_CheckBoxIAccept));

		if(ElementDisplayed(L_CheckBoxIAccept)) {
			Log.info("Successfully Visible I Accept Button");
			click(L_CheckBoxIAccept);
			Log.info("Successfully Clicked On I Accept Button");
			ExtentSuccessMessage("Successfully Clicked On I Accept Button");
		}else {
			Log.error("UnSuccessfully Not Visible I Accept Button");
			ExtentErrorMessage("UnSuccessfully Not Visible I Accept Button");
		}
	}


	public void ClickOnCreateUserRegistrationButton() throws InterruptedException{ 
		ScrolltillElementOnmiddlepage(L_CreateUserRegistrationButton);
		Thread.sleep(3000);
		if(ElementDisplayed(L_CreateUserRegistrationButton)) {
			Log.info("Successfully Visible Registration Button");
			click(L_CreateUserRegistrationButton);
			Log.info("Successfully Clicked On Privacy Registration Button");
			ExtentSuccessMessage("Successfully Clicked On Registration Button");
		}else {
			Log.error("UnSuccessfully Not Visible Registration Button");
			ExtentErrorMessage("UnSuccessfully Not Visible Registration Button");
		}
	}

	public void ClickOnClickHereToLoginLink() throws InterruptedException{
		if(ElementDisplayed(L_ClickLoginLink)) {
			Log.info("Successfully Visible Click Her Login Link");
			click(L_ClickLoginLink);
			Log.info("Successfully Clicked On Click Here Login Link");
			ExtentSuccessMessage("Successfully Clicked On Click Here Login Link");
		}else {
			Log.error("UnSuccessfully Not Visible Click Here Login Link");
			ExtentErrorMessage("UnSuccessfully Not Visible Click Here Login Link");
		}
	}

	public void EnterIHACreateUserName(String Value) throws InterruptedException {
		if(Value.contains("'")) {
			String Value1 =Value.replace("'", "_");
			if(ElementDisplayed(L_IHAUserName)) {
				Log.info("Successfully Visible User Name Field");
				click(L_IHAUserName);
				Log.info("Successfully Clicked On User Name Field");
				clear(L_IHAUserName);
				input(L_IHAUserName, Value1);
				ExtentSuccessMessage("Successfully Enter User Name In User Name Field " + Value1);
			}else {
				Log.error("UnSuccessfully Not Visible User Name Field");
				ExtentErrorMessage("UnSuccessfully Not Visible User Name Field");
			}
		}else {
			if(ElementDisplayed(L_IHAUserName)) {
				Log.info("Successfully Visible User Name Field");
				click(L_IHAUserName);
				Log.info("Successfully Clicked On User Name Field");
				clear(L_IHAUserName);
				input(L_IHAUserName, Value);
				ExtentSuccessMessage("Successfully Enter User Name In User Name Field " + Value);
			}else {
				Log.error("UnSuccessfully Not Visible User Name Field");
				ExtentErrorMessage("UnSuccessfully Not Visible User Name Field");
			}
		}

	}


	public void EnterIHACreatePassword(String Value) throws InterruptedException {
		if(ElementDisplayed(L_IHAPassword)) {
			Log.info("Successfully Visible Password Field");
			click(L_IHAPassword);
			Log.info("Successfully Clicked On Password Field");
			clear(L_IHAPassword);
			input(L_IHAPassword, Value);
			ExtentSuccessMessage("Successfully Enter Password In Password Field " + Value);
		}else {
			Log.error("UnSuccessfully Not Visible Password Field");
			ExtentErrorMessage("UnSuccessfully Not Visible Password Field");
		}

	}

	public void EnterIHACreateConfirmPassword(String Value) throws InterruptedException {
		if(ElementDisplayed(L_IHAConfirmPasswordFBMCUserCreatAcc)) {
			Log.info("Successfully Visible Confirm Password Field");
			click(L_IHAConfirmPasswordFBMCUserCreatAcc);
			Log.info("Successfully Clicked On Confirm Password Field");
			clear(L_IHAConfirmPasswordFBMCUserCreatAcc);
			input(L_IHAConfirmPasswordFBMCUserCreatAcc, Value);
			ExtentSuccessMessage("Successfully Enter Confirm Password In Confirm Password Field" + Value);
		}else {
			Log.error("UnSuccessfully Not Visible Password Field");
			ExtentErrorMessage("UnSuccessfully Not Visible Password Field");
		}

	}

	public void ClickOnIHAIAcceptButton() throws InterruptedException{
		WaitForPageLoad();
		do {
			ScrolltillElementOnmiddlepage(L_IAccept);
			Thread.sleep(1000);
		} while (!ElementDisplayed(L_IAccept));

		if(ElementDisplayed(L_IAccept)) {
			Log.info("Successfully Visible I Accept Button");
			click(L_IAccept);
			Log.info("Successfully Clicked On I Accept Button");
			ExtentSuccessMessage("Successfully Clicked On I Accept Button");
		}else {
			Log.error("UnSuccessfully Not Visible I Accept Button");
			ExtentErrorMessage("UnSuccessfully Not Visible I Accept Button");
		}
	}
	public void ClickOnIHAPriPolicyAndTermsConCheckBox() throws InterruptedException{
		if(ElementDisplayed(L_IHAPriPoliAndTerConCheckBox)) {
			Log.info("Successfully Visible Privacy Policy And Terms Of Service CheckBox");
			click(L_IHAPriPoliAndTerConCheckBox);
			Log.info("Successfully Clicked On Privacy Policy And Terms Of Service CheckBox");
			ExtentSuccessMessage("Successfully Clicked On Privacy Policy And Terms Of Service CheckBox");
		}else {
			Log.error("UnSuccessfully Not Visible  Privacy Policy And Terms Of Service CheckBox");
			ExtentErrorMessage("UnSuccessfully Not Visible  Privacy Policy And Terms Of Service CheckBox");
		}
	}

	public void ValidateSuccessMessage() throws InterruptedException{
		WaitForLoadAnimationDisappear();
		if(ElementDisplayed(L_successmessage)) {
			String SuccessMessage = findElement(L_successmessage).getText();
			System.out.println(SuccessMessage);
			ExtentSuccessMessage("Successfully Displayed Success Message: "+SuccessMessage );
		}else {
			ExtentErrorMessage("UnSuccessfully Not Displayed Success Message");
		}
	}


}
