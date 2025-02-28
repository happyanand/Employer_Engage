package Pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class Payment_Profile  extends Base_Class {

	/////////////////////// Add Profile With ACH Locator///////////////////////////////////////
	public static By L_paymentProfile_no = By.xpath("//input[@id='rd_no']/parent::label");
	public static By L_addProfile = By.id("btn_AddProfile_EnrollmentFlow");
	public static By L_nameOfTheBank = By.id("NameoftheBank");
	public static By L_bankAccountNumber = By.id("BankAccount");
	public static By L_routingNumber = By.id("RoutingNumber");
	//public static By L_saveProfile = By.id("btn_SaveProfile_EnrollmentFlow");
	public static By L_saveProfile = By.xpath("//*[@id='btn_SaveProfile_EnrollmentFlow']|//*[@id='btnPaymentProfileAdd']");
	
	public static By L_ACHCurrentMonth_Yes = By.id("btn_Add_Payment_Profile_EnrollmentFlow");
	public static By L_ACHCurrentMonth_No = By.id("btn_Cancel_Payment_Profile_CancelEnrollmentFlow");

	/////////////////////// Add Profile With Pension Authority Locator///////////////////////////////////////

	public static By L_btnNext = By.id("BtnGotoProfile");
	// Ramya - 9/27
	public static By L_pensionAuthority = By.xpath("//label[contains(text(),' Pension Authority')]");
	public static By L_pensionAuthorityname = By.xpath("//*[@id='PensionAuthorityName_chzn']/a/span");
	public static By L_FloridaRetirementSystem = By.xpath("//*[@id='PensionAuthorityName_chzn_o_1']");
	public static By L_PensionAuthoritsaveProfile = By.id("btn_SaveProfile_EnrollmentFlow");

	public static By L_SubmitButton = By.id("BtnSubmitEnrollment");
	public static By L_PreviousButton = By.id("BtnPreviousProfileEnrollment");
	public static By L_CancelButton = By.id("divCancel");
	public static By  L_SaveAndFinishLater  = By.id("btnSaveAndContinue");
	public static By L_TotalPremiumElement = By.xpath("//a[@class='handle sub-theme-bg selected']");
	/////////////////////// Add Profile With ACH Method///////////////////////////////////////

	// "Add Profile"
	public void addProfileWithACH(Boolean isProfileAdd, String nameOfBank, String routingNo, boolean ACHCurrentMonth)
			throws InterruptedException {
		if (!isProfileAdd) {
			ClickOnPaymentProfileNo();
			return;
		}
		ClickOnAddProfile();
		WaitForPageLoad();
		InputNameOfTheBank(nameOfBank);
		InputBankAccountNumber();
		InputRoutingNumber(routingNo);
		ClickOnSaveProfile();
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		/*
		 * try{ Thread.sleep(3000); } catch (Exception e){
		 * 
		 * }
		 */
		if (ACHCurrentMonth) {
			waitForElementClickable(L_ACHCurrentMonth_Yes);
			jsClick(L_ACHCurrentMonth_Yes);
		}
		// Below code is not in UAT.
		// Ramya
		//						if (ACHCurrentMonth) {
		//					jsClick(L_ACHCurrentMonth_Yes);
		//				} else {
		//					jsClick(L_ACHCurrentMonth_No);
		//				}

	}



	//  Add Payment Profile
	public void addPaymentProfileWithACH(Boolean isProfileAdd, String nameOfBank, String routingNo, boolean ACHCurrentMonth)
			throws InterruptedException {
		
		WaitForPageLoad();
		InputNameOfTheBank(nameOfBank);
		InputBankAccountNumber();
		InputRoutingNumber(routingNo);
		ClickOnSaveProfile();
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		
	}
	
	//	ClickOnPaymentProfileNo
	public void ClickOnPaymentProfileNo() throws InterruptedException {
		WaitForPageLoad();
		if(ElementDisplayed(L_paymentProfile_no)) {
			Log.info("Successfully Visible Payment Profile No");
			click(L_paymentProfile_no);
			Log.info("Successfully Clicked On Payment Profile No");
			ExtentSuccessMessage("Successfully Clicked On Payment Profile No");
		}else {
			Log.error("UnSuccessfully Not Visible On Payment Profile No");
			ExtentErrorMessage("UnSuccessfully Not Visible On Payment Profile No");
		}
	}

	//ClickOnAddProfile

	public void ClickOnAddProfile() throws InterruptedException {
		waitForElementClickable(L_addProfile);
		waitForElementClickable(L_addProfile, 50);
		if(ElementDisplayed(L_addProfile)) {
			Log.info("Successfully Visible Add Profile");
			jsClick(L_addProfile);
			Log.info("Successfully Clicked On Add Profile");
			ExtentSuccessMessage("Successfully Clicked On Add Profile");

		}else {
			Log.error("UnSuccessfully Not Visible On Add Profile");
			ExtentErrorMessage("UnSuccessfully Not Visible On Add Profile");
		}
	}

	//InputNameOfTheBank

	public void InputNameOfTheBank(String nameOfBank) throws InterruptedException {
		WaitForPageLoad();
		waitForElementClickable(L_nameOfTheBank);
		if(ElementDisplayed(L_nameOfTheBank)) {
			Log.info("SuccessFully Visible Name Of The Bank Field");
			click(L_nameOfTheBank);
			input(L_nameOfTheBank,nameOfBank);
			Log.info("SuccessFully Enter Name Of The Bank Field");
			ExtentSuccessMessage("SuccessFully Enter Name Of The Bank Field");

		}else {
			Log.error("UnSuccessFully Not Visible Name Of The Bank Field");
			ExtentErrorMessage("UnSuccessFully Not Visible Name Of The Bank Field");

		}

	}

	//InputBankAccountNumber

	public void InputBankAccountNumber() throws InterruptedException {
		WaitForPageLoad();
		if(ElementDisplayed(L_bankAccountNumber)) {
			Log.info("SuccessFully Visible Bank Account Number Field");
			click(L_bankAccountNumber);
			input(L_bankAccountNumber, randomNumber(9) + "");
			Log.info("SuccessFully Enter Bank Account Number Field");
			ExtentSuccessMessage("SuccessFully Enter Bank Account Number Field");
		}else {
			Log.error("UnSuccessFully Not Visible Bank Account Number Field");
			ExtentErrorMessage("UnSuccessFully Not Visible Bank Account Number Field");

		}

	}

	//InputRoutingNumber

	public void InputRoutingNumber(String routingNo) throws InterruptedException {
		WaitForPageLoad();
		if(ElementDisplayed(L_routingNumber)) {
			Log.info("SuccessFully Visible Bank Account Number Field");
			click(L_routingNumber);
			input(L_routingNumber, routingNo);
			Log.info("SuccessFully Enter Bank Account Number Field");
			ExtentSuccessMessage("SuccessFully Enter Bank Account Number Field");

		}else {
			Log.error("UnSuccessFully Not Visible Bank Account Number Field");
			ExtentErrorMessage("UnSuccessFully Not Visible Bank Account Number Field");

		}

	}

	//click(saveProfile);

	//ACH
	public void ClickOnSaveProfile() throws InterruptedException {
		if(ElementDisplayed(L_saveProfile)) {
			Log.info("Successfully Visible Save Profile ");
			click(L_saveProfile);
			Log.info("Successfully Clicked On Save Profile");
			ExtentSuccessMessage("Successfully Clicked On Save Profile");
		}else {
			Log.error("UnSuccessfully Not Visible On Save Profile");
			ExtentErrorMessage("UnSuccessfully Not Visible On Save Profile");
		}
	}



	//ClickACHCurrentMonth_Yes

	public void ACHCurrentMonth_Yes() throws InterruptedException {
		waitForElementClickable(L_ACHCurrentMonth_Yes);
		if(ElementDisplayed(L_ACHCurrentMonth_Yes)) {
			Log.info("Successfully Visible ACH Current Month Yes");
			////			click(L_ACHCurrentMonth_Yes);
			//			Log.info("Successfully Clicked On ACH Current Month Yes");
			//			ExtentSuccessMessage("Successfully Clicked On ACH Current Month Yes");
		}else {
			Log.error("UnSuccessfully Not Visible ACH Current Month Yes");
			ExtentErrorMessage("UnSuccessfully Not Visible ACH Current Month Yes");
		}
	}

	/////////////////////////////// Add Profile With Pension Authority //////////////////////////////////////////////////////

	public void addProfileWithPensionAuthority(boolean isProfileAdd) throws InterruptedException {
		if (!isProfileAdd) {
			waitForElementPresent(L_paymentProfile_no);
			jsClick(L_paymentProfile_no);
			return;
		}
		WaitForPageLoad();
		/*
		 * try{ Thread.sleep(3000); } catch (Exception e){
		 * 
		 * }
		 */
		waitForElementClickable(L_addProfile);
		//Ramya - 9/27
		if (!ElementDisplayed(L_addProfile)) {
			if(ElementDisplayed(L_TotalPremiumElement))
				click(L_TotalPremiumElement);
		}

		ClickOnAddProfile();
		WaitForPageLoad();
		ClickOnPensionAuthority();
		waitForElementClickable(L_pensionAuthorityname);
		ClickOnPensionAuthorityname();
		waitForElementClickable(L_pensionAuthorityname, 10);
		waitForElementClickable(L_pensionAuthorityname);
		//Ramya - 9/27, commented below line as by default it is selecting FloridaRetirementSystem from dropdown
		//ClickOnFloridaRetirementSystem();
		ClickOnPensionAuthoritsaveProfile();
		WaitForPageLoad();
	}

	///////////////////////Method/////////////////////////


	//PensionAuthoritsaveProfile
	public void ClickOnPensionAuthoritsaveProfile() throws InterruptedException {
		if(ElementDisplayed(L_PensionAuthoritsaveProfile)) {
			Log.info("Successfully Visible Pension Authorit Save Profile ");
			jsClick(L_PensionAuthoritsaveProfile);
			Log.info("Successfully Clicked On Pension Authorit Save Profile");
			ExtentSuccessMessage("Successfully Clicked On Pension Authorit Save Profile");
		}else {
			Log.error("UnSuccessfully Not Visible On Pension Authorit Save Profile");
			ExtentErrorMessage("UnSuccessfully Not Visible On Pension Authorit Save Profile");
		}
	}

	//clickOnNextButton
	public void ClickOnNextButton() throws InterruptedException {
		if(ElementDisplayed(L_btnNext)) {
			Log.info("Successfully Visible Next Button ");
			click(L_btnNext);
			Log.info("Successfully Clicked On Next Button ");
			ExtentSuccessMessage("Successfully Clicked On Next Button ");
		}else {
			Log.error("UnSuccessfully Not Visible Next Button ");
			ExtentErrorMessage("UnSuccessfully Not Visible Next Button ");
		}
	}

	//	ClickOnpensionAuthority

	public void ClickOnPensionAuthority() throws InterruptedException {
		if(ElementDisplayed(L_pensionAuthority)) {
			Log.info("Successfully Visible Pension Authority ");
			jsClick(L_pensionAuthority);
			Log.info("Successfully Clicked On Pension Authority ");
			ExtentSuccessMessage("Successfully Clicked On Pension Authority ");
		}else {
			Log.error("UnSuccessfully Not Visible Pension Authority ");
			ExtentErrorMessage("UnSuccessfully Not Visible Pension Authority ");
		}
	}

	//ClickOnpensionAuthorityname
	public void ClickOnPensionAuthorityname() throws InterruptedException {
		if(ElementDisplayed(L_pensionAuthorityname)) {
			Log.info("Successfully Visible Pension Authority Name ");
			jsClick(L_pensionAuthorityname);
			Log.info("Successfully Clicked On Pension Authority Name");
			ExtentSuccessMessage("Successfully Clicked On Pension Authority Name");
		}else {
			Log.error("UnSuccessfully Not Visible Pension Authority Name");
			ExtentErrorMessage("UnSuccessfully Not Visible Pension Authority Name");
		}
	}


	//ClickOnFloridaRetirementSystem
	public void ClickOnFloridaRetirementSystem() throws InterruptedException {
		if(ElementDisplayed(L_FloridaRetirementSystem)) {
			Log.info("Successfully Visible Florida Retirement System");
			jsClick(L_FloridaRetirementSystem);
			Log.info("Successfully Clicked On Florida Retirement System");
			ExtentSuccessMessage("Successfully Clicked On Florida Retirement System");
		}else {
			Log.error("UnSuccessfully Not Visible Florida Retirement System");
			ExtentErrorMessage("UnSuccessfully Not Visible Florida Retirement System");
		}
	}


	public void ClickOnSubmitButton() throws InterruptedException {
		if(ElementDisplayed(L_SubmitButton)) {
			Log.info("Successfully Visible Submit Button");
			click(L_SubmitButton);
			Log.info("Successfully Clicked On Submit Button");
			ExtentSuccessMessage("Successfully Clicked On Submit Button");
		}else {
			Log.error("UnSuccessfully Not Visible Submit Button");
			ExtentErrorMessage("UnSuccessfully Not Visible Submit Button");
		}
	}

	public void ClickOnPreviousButton() throws InterruptedException {
		if(ElementDisplayed(L_PreviousButton)) {
			Log.info("Successfully Visible Previous Button");
			click(L_SubmitButton);
			Log.info("Successfully Clicked On Previous Button");
			ExtentSuccessMessage("Successfully Clicked On Previous Button");
		}else {
			Log.error("UnSuccessfully Not Visible Previous Button");
			ExtentErrorMessage("UnSuccessfully Not Visible Previous Button");
		}


	}

	public void ClickOnCancleButton() throws InterruptedException {
		if(ElementDisplayed(L_CancelButton)) {
			Log.info("Successfully Visible Cancel Button");
			click(L_CancelButton);
			Log.info("Successfully Clicked On Cancel Button");
			ExtentSuccessMessage("Successfully Clicked On Cancel Button");
		}else {
			Log.error("UnSuccessfully Not Visible Cancel Button");
			ExtentErrorMessage("UnSuccessfully Not Visible Cancel Button");
		}


	}

	public void ClickOnSaveAndFinishLaterButton() throws InterruptedException {
		if(ElementDisplayed(L_SaveAndFinishLater)) {
			Log.info("Successfully Visible Save And Finish Later Button");
			click(L_SaveAndFinishLater);
			Log.info("Successfully Clicked On Save And Finish Later Button");
			ExtentSuccessMessage("Successfully Clicked On Save And Finish Later Button");
		}else {
			Log.error("UnSuccessfully Not Visible Save And Finish Later Button");
			ExtentErrorMessage("UnSuccessfully Not Visible Save And Finish Later Button");
		}


	}
}