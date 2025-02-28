package Pages;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.github.javafaker.Faker;

public class EditEmployee_Page extends Base_Class
{
	// ExcelReader objExcel=new ExcelReader();
		Base_Class Base_Class = new Base_Class();

		private static By dependents = By.xpath("//a[@data-parent='#Dependents']");
		private static By addDependent = By.xpath("//input[@id='BtnDependentAdd']");
		private static By dependent_firstName = By.id("EmployeeVM_Dependent_Person_FirstName");
		//private static By dependent_MiddleName = By.id("EmployeeVM_Dependent_Person_MiddleName");
		private static By dependent_LastName = By.id("EmployeeVM_Dependent_Person_LastName");
		private static By dependent_Prefix = By.id("EmployeeVM_Dependent_Person_Prefix_chzn");
		private static By dependent_Suffix = By.id("EmployeeVM_Dependent_Person_Suffix_chzn");
		private static By dependent_SSN = By.id("EmployeeVM_Dependent_Person_SSN_mask");
		private static By dependent_DOB = By.id("EmployeeVM_Dependent_Person_DateOfBirth");
		private static By dependent_Relation = By.id("EmployeeVM_Dependent_Relation_chzn");
		private static By dependent_Gender = By.id("EmployeeVM_Dependent_Person_Gender_chzn");
		private static By dependent_tobaccoUse_No = By.xpath("//*[@id='EmployeeVM_Dependent_Person_PersonalDetails_TobacoInd'][@value='false']//parent::label");

		// Eligibility Verification
		private static By dependent_Phone = By.id("EmployeeVM_Dependent_Person_Phone");
		private static By dependent_cellPhone = By.id("EmployeeVM_Dependent_Person_AltPhone2");
		private static By dependent_WorkPhone = By.id("EmployeeVM_Dependent_Person_AltPhone1");
		private static By dependent_WorkExt = By.id("EmployeeVM_Dependent_Person_Ext1");
		private static By sameAsSubscribersResidence = By.xpath("//*[@id='contactSameAsHomeDependent']");
		private static By dependent_address1 = By.id("EmployeeVM_Dependent_Person_HomeAddress_Address1");
		private static By dependent_address2 = By.id("EmployeeVM_Dependent_Person_HomeAddress_Address2");
		private static By dependent_addressType = By.id("EmployeeVM_Dependent_Person_HomeAddress_AddressTypeCode_chzn");
		private static By dependent_Zip = By.id("EmployeeVM_Dependent_Person_HomeAddress_ZipCode");
		private static By dependent_ZipExtension = By.id("EmployeeVM_Dependent_Person_HomeAddress_ZipCodeExtension");
		private static By dependent_County = By.id("EmployeeVM_Dependent_Person_HomeAddress_County_chzn");
		private static By dependent_City = By.id("EmployeeVM_Dependent_Person_HomeAddress_City_chzn");
		private static By dependent_State = By.id("EmployeeVM_Dependent_Person_HomeAddress_StateCode_chzn");
		public static By dependent_addressType1 = By.id("EmployeeVM_Dependent_Person_HomeAddress_AddressTypeCode_chzn");
		private static By sameAsCorrespondenceResidence = By
				.xpath("//input[@id='ContactSameAsSubscriberCorrespondenceAddress']/parent::span");
		//private static By dependentAdd = By.id("BtnAdd");
		private static By dependentAdd = By.xpath("//*[@id=\"BtnAdd\"]");
		private static By clickYes = By.xpath("//a[@id='lnkDependentYes']");
		private static By clickDemographicsYes = By.xpath("//*[@id=\"lnkRateDemographicYes\"]");
		private static By clickOK = By.id("btnPopUpDependentOk");
		//private static By clickSubmit = By.id("BtnSubmit");
		private static By clickAddDependentToCoverage = By.xpath("//*[@id=\"lnkDependentYes\"]");
		
	// Update Personal Info
//		private static By updatedDOB = By.id("EmployeeVM_Person_DateOfBirth");
		private static By home_Address1 = By.id("EmployeeVM_Person_HomeAddress_Address1");
		private static By home_Address2 = By.id("EmployeeVM_Person_HomeAddress_Address2");
		private static By home_Zip = By.xpath(
				"//*[@id='EmployeeVM_Person_HomeAddress_ZipCode']|//*[@id='EmployeeVM_Person_HomeAddress_NonUSZipCode']");
		private static By home_ZipCodeExtension = By.id("EmployeeVM_Person_HomeAddress_ZipCodeExtension");
		private static By home_County = By.id("EmployeeVM_Person_HomeAddress_County_chzn");
		private static By home_City = By.id("EmployeeVM_Person_HomeAddress_City_chzn");
		private static By home_State = By.id("EmployeeVM_Person_HomeAddress_StateCode_chzn");
		private static By sameAsMailingAddr = By.xpath("(//span[@class='customCheckbox cb1'])[1]");
		private static By mailing_Address1 = By.id("EmployeeVM_Person_MailingAddress_Address1");
		private static By mailing_Address2 = By.id("EmployeeVM_Person_MailingAddress_Address2");
		private static By mailing_Zip = By.id("EmployeeVM_Person_MailingAddress_NonUSZipCode");
		private static By mailing_zipCodeExtension = By.id("EmployeeVM_Person_MailingAddress_ZipCodeExtension");
		private static By mailing_County = By.id("EmployeeVM_Person_MailingAddress_County_chzn");
		private static By mailing_City = By.id("EmployeeVM_Person_MailingAddress_City_chzn");
		private static By mailing_State = By.id("EmployeeVM_Person_MailingAddress_StateCode_chzn");
	
		private static By L_MessageErrorChange =By.id("MessageErrorChange");
		private static By L_lnkErrorCascadingOK =By.id("lnkErrorCascadingOK");
		private static By txt_Email =By.id("EmployeeVM_Person_Email");
		
	//Enter the new Address
		public void enterNewAddress(Map<Object, Object> testdata) throws InterruptedException {
		try {	
			WaitForPageLoad();
			Thread.sleep(10000);
			clear(home_Address1);
			Thread.sleep(3000);
			input(home_Address1, testdata.get("NewHomeAddr1").toString());
			clear(home_Address2);
			Thread.sleep(3000);
			input(home_Address2, testdata.get("NewHomeAddr2").toString());
			clear(home_Zip);
			Thread.sleep(3000);
			input(home_Zip, testdata.get("NewHomeZip").toString());
			input(home_ZipCodeExtension, Base_Class.randomNumber(4) + "");
			selectByRandom(home_County);
			Thread.sleep(2000);
			selectByRandom(home_City);
			selectByRandom(home_State);
			if (Boolean.parseBoolean(testdata.get("SameAsMailing").toString())) {
				waitForElementClickable(sameAsMailingAddr);
				click(sameAsMailingAddr);
			} else {
				input(mailing_Address1, testdata.get("MailingAddr1").toString());
				input(mailing_Address2, testdata.get("MailingAddr2").toString());
				input(mailing_Zip, testdata.get("MailingZip").toString());
				input(mailing_zipCodeExtension, Base_Class.randomNumber(3) + "");
				selectByRandom(mailing_County);
				selectByRandom(mailing_City);
				selectByRandom(mailing_State);
			}
			ExtentSuccessMessage("Successfully Entered New Address");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
		
		//Scroll Down while Add
		public void scrollTillDependents() throws InterruptedException {
		try {			
			ExtentSuccessMessage("Scroll Till Dependents");
			ScrollUntilElementVisible(dependents);
			Thread.sleep(3000);
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Add Dependent {data}
		public String addDependent(Map<Object, Object> testdata) throws InterruptedException, AWTException {
			WaitForPageLoad();
			Faker faker = new Faker();
			String firstName = faker.name().firstName();
			// String middleName=testdata.get("MiddleName").toString();
			// String lastName=testdata.get("LastName");
			String lastName = faker.name().lastName();

			scrollToElement(dependents);
			jsClick(dependents);
			ExtentSuccessMessage("Successfully clicked on 'dependents' ");
			jsClick(addDependent);
			ExtentSuccessMessage("Successfully clicked on 'Add_dependents' ");
			input(dependent_firstName, firstName);
			ExtentSuccessMessage("Successfully Enter First name " + firstName);
			// input(dependent_MiddleName,middleName);
			input(dependent_LastName, lastName);
			ExtentSuccessMessage("Successfully Enter Last name " + lastName);
			selectByRandom(dependent_Prefix);
			ExtentSuccessMessage("Successfully Select 'dependent_Prefix' ");
			selectByRandom(dependent_Suffix);
			ExtentSuccessMessage("Successfully Select 'dependent_Suffix' ");

			String Dep_ssn = getRandomSSN() + "";
			inputSSN(dependent_SSN,Dep_ssn);
			//ExtentSuccessMessage("Successfully clicked on 'dependents_ssn' ");
			ExtentSuccessMessage("Successfully Enter 'dependents_ssn' " + Dep_ssn);
			click(dependent_DOB);
			ExtentSuccessMessage("Successfully Clicked On  Dependent_DOB ");
			input(dependent_DOB, testdata.get("CascadeDependentDOB").toString());
			ExtentSuccessMessage("Successfully Enter 'CascadeDependentDOB' " + testdata.get("CascadeDependentDOB").toString());
			System.out.println("Print Realtion " + testdata.get("Child_DependentRelation").toString());
			if (testdata.get("Child_DependentRelation").toString() == null
					|| testdata.get("Child_DependentRelation").toString().equals("")) {
				selectByRandom(dependent_Relation);
				ExtentSuccessMessage("Successfully Select 'dependent_Relation' ");
			} else {
				selectComboBoxValue(dependent_Relation, testdata.get("Child_DependentRelation").toString());
				ExtentSuccessMessage(
						"Successfully Select 'dependent_Relation' " + testdata.get("Child_DependentRelation").toString());
					//findElement(dependent_Relation).sendKeys(Keys.TAB);
			}
			Thread.sleep(3000);
			//MouseHoverOnElement(dependent_tobaccoUse_No);
			RobotKeyOperation("TAB");
			selectByRandom(dependent_Gender);
			ExtentSuccessMessage("Successfully Select 'dependent_Gender' ");
			if (ElementDisplayed(dependent_tobaccoUse_No)) {
				ExtentSuccessMessage("Successfully Visible 'dependent_tobaccoUse_No' ");
				Log.info("Successfully Visible 'dependent_tobaccoUse_No' ");
				jsClick(dependent_tobaccoUse_No);
				ExtentSuccessMessage("Successfully clicked on 'dependent_tobaccoUse_No' ");
			} else {
				Log.info("UnSuccessfully Not Visible 'dependent_tobaccoUse_No' ");
				ExtentSuccessMessage("UnSuccessfully Not Visible 'dependent_tobaccoUse_No' ");
			}

			// if(!configloader().getProperty("FBMC_URL").equalsIgnoreCase("iha")) {
			// if(ElementDisplayed(dependent_tobaccoUse_No)) {
			// ExtentSuccessMessage("Successfully Visible 'dependent_tobaccoUse_No' ");
			// Log.info("Successfully Visible 'dependent_tobaccoUse_No' ");
			// click(dependent_tobaccoUse_No);
			//
			// }
			//
			// }

			// ContactInformation

			scrollToElement(dependent_Phone);
			ExtentSuccessMessage("Successfully Select 'dependent_Phone' ");
			input(dependent_Phone, getRandomPhoneNumber());
			ExtentSuccessMessage("Successfully Enter 'dependent_Phone' ");
			input(dependent_cellPhone, getRandomPhoneNumber());
			ExtentSuccessMessage("Successfully Enter 'dependent_cellPhone' ");
			input(dependent_WorkPhone, getRandomPhoneNumber());
			ExtentSuccessMessage("Successfully Enter 'dependent_WorkPhone' ");
			WaitForLoadAnimationDisappear();
			// Ramya --dependent_WorkExt not applicable for IHA
			if (ElementDisplayed(dependent_WorkExt)) {
				ExtentSuccessMessage("Successfully Visible 'dependent_WorkExt' ");
				Log.info("Successfully Visible 'dependent_WorkExt' ");
				input(dependent_WorkExt, randomNumber(4) + "");
				ExtentSuccessMessage("Successfully Entered 'dependent_WorkExt' ");
			} else {
				Log.info("UnSuccessfully Not Visible 'dependent_WorkExt' ");
			}
			WaitForLoadAnimationDisappear();
			if (Boolean.parseBoolean(testdata.get("SameAsSubscriber").toString())) {
				WaitForElementToBeVisible(sameAsSubscribersResidence);
				WaitForLoadAnimationDisappear();
				jsClick(sameAsSubscribersResidence);
				ExtentSuccessMessage("Successfully clicked on 'sameAsSubscribersResidence' ");
			} else {
				WaitForLoadAnimationDisappear();
				MouseHoverOnElement(dependent_address1);
				input(dependent_address1, testdata.get("DependentAddr1").toString());
				ExtentSuccessMessage(
						"Successfully Enter 'dependent_address1' " + testdata.get("DependentAddr1").toString());
				input(dependent_address2, testdata.get("DependentAddr2").toString());
				MouseHoverOnElement(dependent_addressType1);
				ExtentSuccessMessage(
						"Successfully Enter 'dependent_address2' " + testdata.get("DependentAddr2").toString());
				selectByRandom(dependent_addressType1);
				MouseHoverOnElement(dependent_Zip);
				click(dependent_Zip);
				input(dependent_Zip, testdata.get("DependentZip").toString());
				ExtentSuccessMessage("Successfully Enter 'dependent_Zip' " + testdata.get("DependentZip").toString());
				MouseHoverOnElement(dependent_County);
				input(dependent_ZipExtension, randomNumber(4) + "");
				ExtentSuccessMessage("Successfully Enter 'dependent_ZipExtension' ");
				selectByRandom(dependent_County);
				MouseHoverOnElement(dependent_City);
				ExtentSuccessMessage("Successfully Select 'dependent_County' ");
				selectByRandom(dependent_City);
				ExtentSuccessMessage("Successfully Select 'dependent_City' ");
				MouseHoverOnElement(dependent_State);
				selectByRandom(dependent_State);
				ExtentSuccessMessage("Successfully Select 'dependent_State' ");
			}
			ExtentSuccessMessage("Successfully Entered Residence Address under Add Dependents");
			if (ElementsDisplayed(sameAsCorrespondenceResidence)) {
				waitForElementClickable(dependentAdd);
				click(sameAsCorrespondenceResidence);
				// Ramya
				// Thread.sleep(5000);
				ExtentSuccessMessage("Successfully Entered Correspondence Address under Add Dependents");
			}
			WaitForLoadAnimationDisappear();
			click(dependentAdd);
			ExtentSuccessMessage("Successfully clicked on 'dependentAdd' ");
			Thread.sleep(8000);
			jsClick(clickOK);
			ExtentSuccessMessage("Successfully clicked on 'Ok Button' ");
			Thread.sleep(30000);
			return firstName;
		}

		//click Add Dependent to Coverage
		public void clickYesCoverageRates() throws InterruptedException {
		try {	
			WaitForPageLoad();
			Thread.sleep(32000);
			if(ElementDisplayed(clickYes)) {
				jsClick(clickYes);
				Log.info("Successfully clicked on Yes Button");
				ExtentSuccessMessage("Successfully clicked on Yes Button");
			}else {
				Log.error("UnSuccessfully not clicked on Yes Button");
				ExtentErrorMessage("UnSuccessfully not clicked on Yes Button");
			}
			
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
		// click Add Dependent to Coverage
		public void clickAddDependentToCoverage() throws InterruptedException {
		try {
			WaitForPageLoad();
			jsClick(clickAddDependentToCoverage);
			ExtentSuccessMessage("Successfully Added Dependent");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
		
		public Boolean MessageErrorChangevisible() throws InterruptedException {
			Boolean Flag = false;
			if (ElementDisplayed(L_MessageErrorChange)) {
				Flag =true;
			}
			return Flag;

		}

		//click ok on error popup
		public void ErrorOkButton() throws InterruptedException {
		try {
			if(ElementDisplayed(L_lnkErrorCascadingOK)) {
				click(L_lnkErrorCascadingOK);
				ExtentSuccessMessage("Succesfully clicked on Error ok button");

			}else{
				ExtentSuccessMessage("Unsuccesfully not visible Error ok button");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
		//click on Email
		public void editMail(Map<Object, Object> testdata) throws InterruptedException {
		WaitForPageLoad();
		try {
			if(ElementDisplayed(txt_Email)) {
				click(txt_Email);
				clear(txt_Email);
				input(txt_Email, testdata.get("EmailId").toString());
				ExtentSuccessMessage("Succesfully clicked on Email Text");
			}else{
				ExtentSuccessMessage("Unsuccesfully not visible Email Text");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
		//
		public void clickDemographicsYes() throws InterruptedException {
			try {	
				WaitForPageLoad();
				jsClick(clickDemographicsYes);
				Log.info("Successfully clicked on Demographics Yes Button");
				ExtentSuccessMessage("Successfully clicked on Demographics Yes Button");
			} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
		}
}
