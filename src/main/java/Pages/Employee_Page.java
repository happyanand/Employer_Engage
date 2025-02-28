package Pages;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.github.javafaker.Faker;

public class Employee_Page extends Base_Class {

	private static By firstName = By.id("EmployeeVM_Person_FirstName");
	private static By lastName = By.id("EmployeeVM_Person_LastName");
	private static By prefixone = By.id("EmployeeVM_Person_Prefix_chzn");
	private static By suffix = By.id("EmployeeVM_Person_Suffix_chzn");
	private static By maritalStatus = By.id("EmployeeVM_Person_PersonalDetails_MaritalStatus_chzn");
	private static By DOB = By.id("EmployeeVM_Person_DateOfBirth");
	private static By gender = By.id("EmployeeVM_Person_Gender_chzn");
	private static By SSN = By.id("EmployeeVM_Person_SSN_mask");
	private static By tobaccoUse_No = By
			.xpath("//label[contains(text(),'Tobacco use')]/following-sibling::div//label[contains(text(),'No')]");
	private static By sponsorSSN = By.id("EmployeeVM_SponsorSSN_mask");

	private static By sponsorRelation = By.id("EmployeeVM_SponsorRelation_chzn");
	private static By employeeFullTime = By.xpath("//*[@id='EmployeeVM_ClassId_chzn']/a");
	private static By EmployeeFullTime = By.xpath("//li[@id ='EmployeeVM_ClassId_chzn_o_2']");
	private static By annualSalary = By.xpath("//input[@id='EmployeeVM_AnnualSalary']");
	// Contact Information
	private static By phone = By.id("EmployeeVM_Person_Phone");
	private static By cellPhone = By.id("EmployeeVM_Person_AltPhone2");
	private static By email = By.id("EmployeeVM_Person_Email");
	private static By home_Address1 = By.id("EmployeeVM_Person_HomeAddress_Address1");
	private static By home_Address2 = By.id("EmployeeVM_Person_HomeAddress_Address2");
	private static By home_Zip = By.id("EmployeeVM_Person_HomeAddress_ZipCode");
	private static By home_NonUSZip = By.id("EmployeeVM_Person_HomeAddress_NonUSZipCode");
	private static By home_ZipCodeExtension = By.id("EmployeeVM_Person_HomeAddress_ZipCodeExtension");
	private static By home_County = By.id("EmployeeVM_Person_HomeAddress_County_chzn");
	private static By home_City = By.id("EmployeeVM_Person_HomeAddress_City_chzn");
	private static By home_State = By.id("EmployeeVM_Person_HomeAddress_StateCode_chzn");
	public static By attachmentType1 = By.id("Key_DocumentType_chzn'");
	public static By dependent_addressType1 = By.id("EmployeeVM_Dependent_Person_HomeAddress_AddressTypeCode_chzn");
	private static By sameAsMailingAddr = By.xpath("//span[@class='customCheckbox cb1']");
	private static By mailing_Address1 = By.id("EmployeeVM_Person_MailingAddress_Address1");
	private static By mailing_Address2 = By.id("EmployeeVM_Person_MailingAddress_Address2");
	private static By mailing_Zip = By.id("EmployeeVM_Person_MailingAddress_NonUSZipCode");
	private static By mailing_zipCodeExtension = By.id("EmployeeVM_Person_MailingAddress_ZipCodeExtension");
	private static By mailing_County = By.id("EmployeeVM_Person_MailingAddress_County_chzn");
	private static By mailing_City = By.id("EmployeeVM_Person_MailingAddress_City_chzn");
	private static By mailing_State = By.id("EmployeeVM_Person_MailingAddress_StateCode_chzn");
	public static By trustType1 = By.id("Relation");

	// Work Details
	private static By billingLocation = By.id("EmployeeVM_SubGroupId_chzn");
	private static By employeeClass = By.id("EmployeeVM_ClassId_chzn");
	private static By dateOfHire = By.id("EmployeeVM_HireDate");
	private static By workPhone = By.id("EmployeeVM_Person_AltPhone1");
	private static By coEmployeeNumber = By.id("EmployeeVM_EmployeeNumber");
	private static By retirementDate = By.id("EmployeeVM_RetirementDate");
	private static By jobTitle = By.id("EmployeeVM_JobTitle");
	private static By bargainingUnit = By.id("EmployeeVM_BargainingUnit");
	private static By workExt = By.id("EmployeeVM_Person_Ext1");
	private static By enrollWinStartDt = By.id("EmployeeVM_Person_PersonalDetails_EnrollmentWindowStartDate");
	private static By enrollWinEndDt = By.id("EmployeeVM_Person_PersonalDetails_EnrollmentWindowEndDate");

	// Dependents
	private static By dependents = By.xpath("//a[@data-parent='#Dependents']");
	private static By addDependent = By.id("BtnDependentAdd");
	private static By dependent_firstName = By.id("EmployeeVM_Dependent_Person_FirstName");
	private static By dependent_MiddleName = By.id("EmployeeVM_Dependent_Person_MiddleName");
	private static By dependent_LastName = By.id("EmployeeVM_Dependent_Person_LastName");
	private static By dependent_Prefix = By.id("EmployeeVM_Dependent_Person_Prefix_chzn");
	private static By dependent_Suffix = By.id("EmployeeVM_Dependent_Person_Suffix_chzn");
	private static By dependent_SSN = By.id("EmployeeVM_Dependent_Person_SSN_mask");
	private static By dependent_DOB = By.id("EmployeeVM_Dependent_Person_DateOfBirth");
	private static By dependent_Relation = By.id("EmployeeVM_Dependent_Relation_chzn");
	private static By dependent_Gender = By.id("EmployeeVM_Dependent_Person_Gender_chzn");
	private static By dependent_tobaccoUse_No = By
			.xpath("//*[@id='EmployeeVM_Dependent_Person_PersonalDetails_TobacoInd'][@value='false']//parent::label");

	// Eligibility Verification
	private static By verificationDate = By.id("EmployeeVM_Dependent_Person_PersonalDetails_DateVerified");
	private static By verificationNotice1 = By.id("EmployeeVM_Dependent_Person_PersonalDetails_FirstNoticeDate");
	private static By verificationNotice2 = By.id("EmployeeVM_Dependent_Person_PersonalDetails_SecondNoticeDate");

	private static By dependent_Phone = By.id("EmployeeVM_Dependent_Person_Phone");
	private static By dependent_cellPhone = By.id("EmployeeVM_Dependent_Person_AltPhone2");
	private static By dependent_WorkPhone = By.id("EmployeeVM_Dependent_Person_AltPhone1");
	private static By dependent_WorkExt = By.id("EmployeeVM_Dependent_Person_Ext1");
	private static By sameAsSubscribersResidence = By
			.xpath("//span[contains(text(),'Same As Subscriber')]/preceding-sibling::span");
	private static By dependent_address1 = By.id("EmployeeVM_Dependent_Person_HomeAddress_Address1");
	private static By dependent_address2 = By.id("EmployeeVM_Dependent_Person_HomeAddress_Address2");
	private static By dependent_addressType = By.id("EmployeeVM_Dependent_Person_HomeAddress_AddressTypeCode_chzn");
	private static By dependent_Zip = By.id("EmployeeVM_Dependent_Person_HomeAddress_ZipCode");
	private static By dependent_ZipExtension = By.id("EmployeeVM_Dependent_Person_HomeAddress_ZipCodeExtension");
	private static By dependent_County = By.id("EmployeeVM_Dependent_Person_HomeAddress_County_chzn");
	private static By dependent_City = By.id("EmployeeVM_Dependent_Person_HomeAddress_City_chzn");
	private static By dependent_State = By.id("EmployeeVM_Dependent_Person_HomeAddress_StateCode_chzn");
	private static By dependentAdd = By.id("BtnAdd");

	// Beneficiaries
	private static By beneficiaries = By.xpath("//a[@data-parent='#Beneficiaries']");
	private static By addBeneficiary = By.id("BtnAddBeneficiary");
	private static By person_FirstName = By.id("Person_FirstName");
	private static By person_LastName = By.id("Person_LastName");
	private static By person_Address1 = By.id("Person_HomeAddress_Address1");
	private static By person_DOB = By.id("Person_DateOfBirth");
	private static By person_SSN = By.id("Person_SSN_mask");
	private static By person_Zip = By.id("Person_HomeAddress_ZipCode");
	private static By person_ZipExtension = By.id("Person_HomeAddress_ZipCodeExtension");
	private static By person_Country = By.id("Person_HomeAddress_County_chzn");
	private static By person_Relation = By.id("Relation_chzn");
	private static By person_Phone = By.id("Person_Phone");
	private static By person_City = By.id("Person_HomeAddress_City_chzn");
	private static By person_State = By.id("Person_HomeAddress_StateCode_chzn");
	private static By saveBeneficiary = By.id("BtnSaveBeneficiary");
	private static By beneficiary_TrustOrInstitution = By
			.xpath("//label[contains(text(),' Trust or Institution')]/input[@id='BeneficiaryType']");
	private static By beneficiary_Person = By.xpath("//label[contains(text(),' Person')]/input[@id='BeneficiaryType']");
	private static By btnOk = By.xpath("//button[text()='Ok' or text()='OK']");

	// Beneficiary-Trust
	private static By trustName = By.id("Organization_OrganizationName");
	private static By TINOrEIN = By.id("Organization_TaxId_mask");
	private static By trustType = By.id("Relation");
	private static By org_Phone = By.id("Organization_Phone");
	private static By org_Address1 = By.id("Organization_Addresses_0__Address1");
	private static By org_Zip = By.id("Organization_Addresses_0__ZipCode");
	private static By org_ZipCodExtension = By.id("Organization_Addresses_0__ZipCodeExtension");
	private static By org_Country = By.id("Organization_Addresses_0__County");
	private static By org_City = By.id("Organization_Addresses_0__City");
	private static By org_State = By.id("Organization_Addresses_0__StateCode");

	// Attachment
	private static By attachment = By.xpath("//a[@data-parent='#Attachment']");

	private static By attachmentType = By.id("Key_DocumentType_chzn'");
	private static By privateAttachment = By.id("chkAttachIndicate");
	private static By comments = By.id("Key_Comments");
	private static By saveAttachment = By.id("Upload");
	private static By browse = By.id("fileUploadProofDoc");

	// Notes
	private static By notes = By.xpath(" //a[@data-parent='#Notes']");

	private static By notesHere = By.id("EmployeeVM_Note_Notes");
	private static By privateNotes = By.id("chkNoteIndicate");
	private static By saveNotes = By.id("SaveNotes");

	private static By FirstEmployee = By
			.xpath("(//*[@class='table Result-grid table-striped']//*[@class='divRedirectGrid name'])[1]");
	private static By EditButton = By
			.xpath("//*[@class='row-height']//*[@class='btn btn-sm btn-primary'][text()='Edit']");
	private static By TerminateButton = By
			.xpath("//*[@class='row-height']//*[@class='btn btn-sm btn-primary'][text()='Terminate']");
	private static By ManageCoverageButton = By
			.xpath("//*[@class='row-height']//*[@class='btn btn-sm btn-primary'][text()='   Manage Coverage ']");
	private static By AuditDetails = By.id("BtnAudit");
	private static By medicareEligible = By

			.xpath("//label[contains(text(),'Medicare')]/following-sibling::div//label[contains(text(),'Yes')]");
	// bottom buttons
	private static By submit = By.id("BtnSubmit");
	private static By activate = By.id("BtnActivate");
	private static By activateAndEnroll = By.id("BtnActivateAndEnroll");
	private static By close = By.id("divClose");
	// ramya Incorrect xpath
	private static By sameAsCorrespondenceResidence = By
			.xpath("//input[@id='ContactSameAsSubscriberCorrespondenceAddress']/parent::span");

	// "Add Personal Information {data}"
	public String addPersonalInformation(Map<Object, Object> testdata) throws InterruptedException, AWTException {
		Faker faker = new Faker();
		String ssnnumber = getRandomSSN() + "";
		String strlastName = faker.name().lastName();
		String strFirstname = faker.name().firstName();
		try {
			//Faker faker = new Faker();
			input(firstName, strFirstname);
			ExtentSuccessMessage("First Name: " + strFirstname);
			input(lastName, strlastName);
			String prefix = selectByRandom(prefixone);
			selectByRandom(suffix);
			click(DOB);
			input(DOB, testdata.get("DOB").toString());
			jsClick(tobaccoUse_No);
			if (TenanatName.contains("FBMC")) {
				click(medicareEligible);
			} else {
				WaitForPageLoad(); 
			}


			inputSSN(SSN, ssnnumber);
			System.out.println("SSN No: " + ssnnumber);
			ExtentSuccessMessage("SSN No: " + ssnnumber);
			selectByRandom(maritalStatus);
			selectByRandom(gender);

			// Contact Information
			WaitForElementToBeVisible(phone);
			click(phone);
			input(phone, getRandomPhoneNumber());
			input(email, strFirstname + "_" + strlastName + "@gmail.com");
			input(home_Address1, testdata.get("HomeAddr1").toString());
			click(home_Zip);
			input(home_Zip, testdata.get("HomeZip").toString());
			input(home_ZipCodeExtension, randomNumber(4) + "");
			Thread.sleep(2000);
			selectByRandom(home_County);
			selectByRandom(home_City);
			selectByRandom(home_State);
			if (Boolean.parseBoolean(testdata.get("SameAsMailing").toString())) {
				click(sameAsMailingAddr);
			} else {
				input(mailing_Address1, testdata.get("MailingAddr1").toString());
				input(mailing_Address2, testdata.get("MailingAddr2").toString());
				input(mailing_Zip, testdata.get("MailingZip").toString());
				input(mailing_zipCodeExtension, randomNumber(3) + "");
				selectByRandom(mailing_County);
				selectByRandom(mailing_City);
				selectByRandom(mailing_State);
			}

			// Work Details
			selectByRandom(billingLocation);
			WaitForPageLoad();
			// Asif
			if (TenanatName.contains("Speridian")) {
				WaitForPageLoad();
				SelectDropdownValue(employeeClass, "FT-Full Time");
			} else {
				WaitForPageLoad();
				selectByRandom(employeeClass);
			}
			WaitForPageLoad();
			click(dateOfHire);
			input(dateOfHire, testdata.get("DateOfHire").toString());
			// Ramya
			// input(workPhone,getRandomPhoneNumber());
			// input(coEmployeeNumber,randomNumber(3)+"");
			// input(retirementDate,testdata.get("RetirementDate").toString());
			// input(jobTitle,testdata.get("JobTitle").toString());
			// input(bargainingUnit,"BargainingUnit"+randomNumber(2));
			// input(workExt,randomNumber(3)+"");
			if (ElementDisplayed(enrollWinStartDt)) {
				ExtentSuccessMessage("Successfully Enroll Start Date Visible");
				click(enrollWinStartDt);
				input(enrollWinStartDt, testdata.get("EnrollWinStartDt").toString());
				ExtentSuccessMessage("Successfully Enter the value in Enroll Start Date "
						+ testdata.get("EnrollWinStartDt").toString());
			} else {
				ExtentSuccessMessage("UnSuccessfully Enroll Start Date Not Visible");
			}
			if (ElementDisplayed(enrollWinEndDt)) {
				ExtentSuccessMessage("Successfully Enroll End Date Visible");
				click(enrollWinEndDt);
				input(enrollWinEndDt, testdata.get("EnrollWinDateDt").toString());
				ExtentSuccessMessage("Successfully Enter the value in Enroll End Date "
						+ testdata.get("EnrollWinStartDt").toString());
			} else {
				ExtentSuccessMessage("UnSuccessfully Enroll End Date Not Visible");
			}
			if (ElementDisplayed(annualSalary)) {
				ExtentSuccessMessage("Successfully Enroll Start Date Visible");
				click(annualSalary);
				input(annualSalary,testdata.get("AnnualSalary").toString());
				ExtentSuccessMessage("Successfully entered the salary in Annual Salary");
			} else {
				ExtentSuccessMessage("Successfully entered the salary in Annual Salary");
			}
			System.out.println("Creating the Employee with firstName:" + strFirstname);

		} catch (Exception e) {
			// Handle the exceptionL̥
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

		return ssnnumber + "," + strFirstname + "," + strlastName;
	}

	// "Add Dependent {data}"
	public String addDependent(Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException {
		// HashMap<String,String> userNames=ExcelReader.getUserNamesByRandomRow();
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
		input(dependent_DOB, testdata.get("DependentDOB").toString());
		ExtentSuccessMessage("Successfully Enter 'DependentDOB' " + testdata.get("DependentDOB").toString());
		System.out.println("Print Realtion " + testdata.get("DependentRelation").toString());
		if (testdata.get("DependentRelation").toString() == null
				|| testdata.get("DependentRelation").toString().equals("")) {
			selectByRandom(dependent_Relation);
			ExtentSuccessMessage("Successfully Select 'dependent_Relation' ");
		} else {
			selectComboBoxValue(dependent_Relation, testdata.get("DependentRelation").toString());
			ExtentSuccessMessage(
					"Successfully Select 'dependent_Relation' " + testdata.get("DependentRelation").toString());
			//				findElement(dependent_Relation).sendKeys(Keys.TAB);
		}
		Thread.sleep(3000);
		//MouseHoverOnElement(dependent_tobaccoUse_No);
		if (ElementDisplayed(dependent_tobaccoUse_No)) {
			ExtentSuccessMessage("Successfully Visible 'dependent_tobaccoUse_No' ");
			Log.info("Successfully Visible 'dependent_tobaccoUse_No' ");
			jsClick(dependent_tobaccoUse_No);
			ExtentSuccessMessage("Successfully clicked on 'dependent_tobaccoUse_No' ");
		} else {
			Log.info("UnSuccessfully Not Visible 'dependent_tobaccoUse_No' ");
		}

		selectByRandom(dependent_Gender);
		ExtentSuccessMessage("Successfully Select 'dependent_Gender' ");

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
		// Ramya --dependent_WorkExt not applicable for IHA
		if (ElementDisplayed(dependent_WorkExt)) {
			ExtentSuccessMessage("Successfully Visible 'dependent_WorkExt' ");
			Log.info("Successfully Visible 'dependent_WorkExt' ");
			input(dependent_WorkExt, randomNumber(4) + "");
			ExtentSuccessMessage("Successfully Entered 'dependent_WorkExt' ");
		} else {
			Log.info("UnSuccessfully Not Visible 'dependent_WorkExt' ");
		}
		if (Boolean.parseBoolean(testdata.get("SameAsSubscriber").toString())) {
			click(sameAsSubscribersResidence);
			ExtentSuccessMessage("Successfully clicked on 'sameAsSubscribersResidence' ");
		} else {
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
		click(dependentAdd);
		ExtentSuccessMessage("Successfully clicked on 'dependentAdd' ");
		Thread.sleep(3000);
		jsClick(btnOk);
		ExtentSuccessMessage("Successfully clicked on 'Ok Button' ");
		return firstName;
	}

	// "Add attachment{privateChk} {comments} "
	public void addAttachment(String privateChk) throws InterruptedException {
		click(attachment);
		selectByRandom(attachmentType1);
		if (Boolean.parseBoolean(privateChk)) {
			click(privateAttachment);
		}
		input(comments, "Comments:" + randomString(10));
		click(browse);
		// Add code for win handling
		click(saveAttachment);
	}

	// "Add Notes : {privateChk}"
	public void addNotes(String privateChk) throws InterruptedException {
		try {
			scrollDown();
			click(notes);
			ExtentSuccessMessage("Successfully Clicked On Notes");
			input(notesHere, "notes Automation testing");
			ExtentSuccessMessage("Successfully Enter in Notes Field");
			if (Boolean.parseBoolean(privateChk)) {
				click(privateNotes);
				ExtentSuccessMessage("Successfully Clicked On Private Notes");
			}
			click(saveNotes);
			ExtentSuccessMessage("Successfully Clicked On Save Notes");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

	// "Submit employee"
	public void submit() throws InterruptedException {
		try {
			WaitForPageLoad();
			scrollDown();
			click(submit);
			ExtentSuccessMessage("Successfully Clicked on Submit Button");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

	// "Add Beneficiary"
	public void addPersonBeneficiary(Map<Object, Object> testdata) throws InterruptedException, AWTException {
		try {
			WaitForPageLoad();
			Faker faker = new Faker();
			String firstName = faker.name().firstName();
			// String middleName=testdata.get("MiddleName").toString();
			// String lastName=data.get("LastName");
			String lastName = faker.name().lastName();
			scrollToElement(beneficiaries);
			click(beneficiaries);
			ExtentSuccessMessage("Successfully clicked on 'beneficiaries' ");
			click(addBeneficiary);
			ExtentSuccessMessage("Successfully clicked on 'addBeneficiary' ");
			input(person_FirstName, firstName);
			ExtentSuccessMessage("Successfully Enter 'person_FirstName' " + firstName);
			input(person_LastName, lastName);
			ExtentSuccessMessage("Successfully Enter 'person_LastName' " + lastName);
			if (ElementDisplayed(person_Address1)) {
				ExtentSuccessMessage("Successfully person_Address1 Visible");
				input(person_Address1, testdata.get("HomeAddr1").toString());
				ExtentSuccessMessage(
						"Successfully Enter the value in person_Address1 " + testdata.get("HomeAddr1").toString());
			} else {
				ExtentSuccessMessage("UnSuccessfully person_Address1 Not Visible");
			}
			click(person_DOB);
			ExtentSuccessMessage("Successfully clicked on 'person_DOB' ");
			input(person_DOB, testdata.get("PersonDOB").toString());
			ExtentSuccessMessage("Successfully Enter 'person_DOB' " + testdata.get("PersonDOB").toString());
			String Per_ssn = getRandomSSN() + "";
			//click(person_SSN);
			inputSSN(person_SSN, Per_ssn);
			ExtentSuccessMessage("Successfully clicked on 'person_SSN' ");
			inputSSN(person_SSN, Per_ssn);
			ExtentSuccessMessage("Successfully Enter 'person_SSN' " + Per_ssn);
			click(person_Zip);
			ExtentSuccessMessage("Successfully clicked on 'person_Zip' ");
			input(person_Zip, testdata.get("PersonZip").toString());
			ExtentSuccessMessage("Successfully Enter 'person_Zip' " + testdata.get("PersonZip").toString());
			selectByRandom(person_Country);
			ExtentSuccessMessage("Successfully Select  'person_Country' ");
			selectByRandom(person_Relation);
			ExtentSuccessMessage("Successfully Select  'person_Relation' ");
			click(person_Phone);
			ExtentSuccessMessage("Successfully clicked on 'person_Phone' ");
			input(person_Phone, getRandomPhoneNumber());
			ExtentSuccessMessage("Successfully Enter 'person_Phone' ");
			selectByRandom(person_City);
			ExtentSuccessMessage("Successfully Select  'person_City' ");
			selectByRandom(person_State);
			ExtentSuccessMessage("Successfully Select  'person_State' ");
			click(saveBeneficiary);
			ExtentSuccessMessage("Successfully clicked on 'saveBeneficiary' ");
			click(btnOk);
			ExtentSuccessMessage("Successfully clicked on 'btnOk' ");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void addTrustOrInstitutionBeneficiary(Map<Object, Object> testdata) throws InterruptedException {
		try {
			scrollToElement(beneficiaries);
			click(beneficiaries);
			ExtentSuccessMessage("Successfully Clicked On Beneficiaries Dropdown");
			click(addBeneficiary);
			ExtentSuccessMessage("Successfully Clicked On Add Beneficiaries Button");
			click(beneficiary_TrustOrInstitution);
			ExtentSuccessMessage("Successfully Clicked On Beneficiaries Trust Or Institution");
			input(trustName, randomString(5));
			ExtentSuccessMessage("Successfully Enter In Trust Name");
			input(TINOrEIN, randomNumber(9) + "");
			ExtentSuccessMessage("Successfully Enter In TIN Or EIN Number");
			selectByRandom(trustType1);
			ExtentSuccessMessage("Successfully Randon Select Trust-Type1");
			input(org_Phone, getRandomPhoneNumber());
			ExtentSuccessMessage("Successfully Enter org_Phone Number");
			input(org_Address1, randomString(7));
			ExtentSuccessMessage("Successfully Enter org_Address1");
			input(org_Zip, testdata.get("OrgZip").toString());
			ExtentSuccessMessage("Successfully Enter org_Zip ");
			selectByRandom(org_Country);
			ExtentSuccessMessage("Successfully Select org_Country ");
			selectByRandom(org_City);
			ExtentSuccessMessage("Successfully Select org_City ");
			selectByRandom(org_State);
			ExtentSuccessMessage("Successfully Select org_State ");
			click(saveBeneficiary);
			ExtentSuccessMessage("Successfully Clicked On  Save Beneficiary ");
			click(btnOk);
			ExtentSuccessMessage("Successfully Clicked On  Ok Button ");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// "Add Employee"
	public void addEmployee(Map<Object, Object> testdata) throws InterruptedException, AWTException, IOException {
		addPersonalInformation(testdata);
		addDependent(testdata);
		if (testdata.get("Beneficiaryinput").equals("Person")) {
			addPersonBeneficiary(testdata);
		} else {
			addTrustOrInstitutionBeneficiary(testdata);
		}
		// employeePage.addAttachment(data.get("AttachmentPrivate"));
		addNotes(testdata.get("NotesPrivate").toString());
	}

	// "Activate and Enroll Employee"
	public void activateAndEnroll() {
		try {
			WaitForPageLoad();
			scrollDown();
			click(activateAndEnroll);
			ExtentSuccessMessage("Successfully Clicked On Active And Enroll Button");

		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// "Activate Employee"
	public void activate() throws InterruptedException {
		try {
			scrollDown();
			click(activate);
			ExtentSuccessMessage("Successfully Clicked on Activate");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void ValidateButton(By By) throws InterruptedException {
		WaitForPageLoad();
		if (ElementDisplayed(By)) {
			ExtentSuccessMessage("Successfully found Button visible");
		} else {
			ExtentErrorMessage("UnSuccessfully Not found Button visible");
		}
	}

	// "Add Personal Information {data}"
	public String addIHAPersonalInformation(Map<Object, Object> testdata) throws InterruptedException {
		// HashMap<String,String> userNames=ExcelReader.getUserNamesByRandomRow();
		WaitForPageLoad();
		// String firstName=testdata.get("FirstName");
		Faker faker = new Faker();
		String strfirstName = faker.name().firstName();
		// String strmiddleName=testdata.get("MiddleName").toString();
		// String lastName=data.get("LastName");
		String strlastName = faker.name().lastName();
		String ssnnumber = getRandomSSN() + "";
		input(firstName, strfirstName);
		ExtentSuccessMessage("First Name: " + strfirstName);
		// input(middleInitial,strmiddleName);
		input(lastName, strlastName);
		String prefix = selectByRandom(prefixone);
		selectByRandom(suffix);
		click(DOB);
		input(DOB, testdata.get("DOB").toString());
		inputSSN(SSN, ssnnumber);
		System.out.println("SSN No: " + ssnnumber);
		ExtentSuccessMessage("SSN No: " + ssnnumber);

		selectByRandom(maritalStatus);
		selectByRandom(gender);
		if (ElementsDisplayed(sponsorRelation)) {
			selectByRandom(sponsorRelation);
		}
		// Contact Information
		click(phone);
		input(phone, getRandomPhoneNumber());
		click(cellPhone);
		input(cellPhone, getRandomPhoneNumber());
		input(email, strfirstName + "_" + strlastName + "@gmail.com");
		input(home_Address1, testdata.get("HomeAddr1").toString());
		input(home_Address2, testdata.get("HomeAddr2").toString());

		input(home_NonUSZip, testdata.get("HomeZip").toString());

		input(home_ZipCodeExtension, randomNumber(4) + "");
		selectByRandom(home_County);
		selectByRandom(home_City);
		selectByRandom(home_State);
		if (Boolean.parseBoolean(testdata.get("SameAsMailing").toString())) {
			click(sameAsMailingAddr);
		} else {
			input(mailing_Address1, testdata.get("MailingAddr1").toString());
			input(mailing_Address2, testdata.get("MailingAddr2").toString());
			input(mailing_Zip, testdata.get("MailingZip").toString());
			input(mailing_zipCodeExtension, randomNumber(3) + "");
			selectByRandom(mailing_County);
			selectByRandom(mailing_City);
			selectByRandom(mailing_State);
		}
		// Work DetailsL̥
		selectByRandom(billingLocation);
		selectByRandom(employeeClass);
		click(dateOfHire);
		input(dateOfHire, testdata.get("DateOfHire").toString());
		input(workPhone, getRandomPhoneNumber());
		// input(coEmployeeNumber,commonUtil.randomNumber(3)+"");
		// input(retirementDate,testdata.get("RetirementDate"));
		// input(jobTitle,testdata.get("JobTitle"));
		// input(bargainingUnit,"BargainingUnit"+commonUtil.randomNumber(2));
		input(workExt, randomNumber(3) + "");
		// input(enrollWinStartDt,testdata.get("EnrollWinStartDt"));
		// input(enrollWinEndDt,testdata.get("EnrollWinDateDt"));
		System.out.println("Creating the Employee with firstName:" + firstName);
		return  ssnnumber + "," + strfirstName + "," + strlastName;
	}

	public String getFirstName(Map<Object, Object> testdata) {
		return testdata.get("firstname").toString();
	}

	// Add personal Information with Medicare Eligible
	public String addPersonalInformationWithMedicare(Map<Object, Object> testdata)
			throws InterruptedException, AWTException {
		// Map<String, String> userNames=ExcelReader.getUserNamesByRandomRow();
		WaitForPageLoad();

		Faker faker = new Faker();
		String strFirstname = faker.name().firstName();
		String strlastName = faker.name().lastName();
		String ssn = getRandomSSN() + "";

		input(firstName, strFirstname);
		input(lastName, strlastName);
		String prefix = selectByRandom(prefixone);
		selectByRandom(suffix);
		click(DOB);
		input(DOB, testdata.get("DOB").toString());
		jsClick(tobaccoUse_No);
		jsClick(medicareEligible);
		String Dep_ssn = getRandomSSN() + "";
		//click(dependent_SSN);
		inputSSN(dependent_SSN, Dep_ssn);
		selectByRandom(maritalStatus);
		selectByRandom(gender);
		// Contact Information
		WaitForElementToBeVisible(phone);
		click(phone);
		input(phone, getRandomPhoneNumber());
		input(cellPhone, getRandomPhoneNumber());
		input(email, strFirstname + "_" + strlastName + "@gmail.com");
		input(home_Address1, testdata.get("HomeAddr1").toString());
		input(home_Address2, testdata.get("HomeAddr2").toString());
		click(home_Zip);
		input(home_Zip, testdata.get("HomeZip").toString());
		input(home_ZipCodeExtension, randomNumber(4) + "");
		selectByRandom(home_County);
		selectByRandom(home_City);
		selectByRandom(home_State);
		if (Boolean.parseBoolean(testdata.get("SameAsMailing").toString())) {
			click(sameAsMailingAddr);
		} else {
			input(mailing_Address1, testdata.get("MailingAddr1").toString());
			input(mailing_Address2, testdata.get("MailingAddr2").toString());
			input(mailing_Zip, testdata.get("MailingZip").toString());
			input(mailing_zipCodeExtension, randomNumber(3) + "");
			selectByRandom(mailing_County);
			selectByRandom(mailing_City);
			selectByRandom(mailing_State);
		}
		// Work Details
		selectByRandom(billingLocation);
		selectByRandom(employeeClass);
		click(dateOfHire);
		input(dateOfHire, testdata.get("DateOfHire").toString());
		input(workPhone, getRandomPhoneNumber());
		input(coEmployeeNumber, randomNumber(3) + "");
		input(retirementDate, testdata.get("RetirementDate").toString());
		input(jobTitle, testdata.get("JobTitle").toString());
		input(bargainingUnit, "BargainingUnit" + randomNumber(2));
		input(workExt, randomNumber(3) + "");
		click(enrollWinStartDt);
		input(enrollWinStartDt, testdata.get("EnrollWinStartDt").toString());
		click(enrollWinEndDt);
		input(enrollWinEndDt, testdata.get("EnrollWinDateDt").toString());
		System.out.println("Creating the Employee with firstName:" + strFirstname);
		return ssn;
	}

	public void ClickOnFirstEmployeeFromGrid() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(FirstEmployee);
			Log.info("Successfully Clicked On First Employee");
			ExtentSuccessMessage("Successfully Clicked On First Employee");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void ClickonEdit() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(EditButton);
			Log.info("Successfully Clicked On Edit Button");
			ExtentSuccessMessage("Successfully Clicked On Edit Button");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void ButtonFound() throws InterruptedException {
		try {
			ValidateButton(EditButton);
			ValidateButton(TerminateButton);
			ValidateButton(ManageCoverageButton);
			ValidateButton(AuditDetails);
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

}

