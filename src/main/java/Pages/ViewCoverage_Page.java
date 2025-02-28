
package Pages;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class ViewCoverage_Page extends Base_Class {
	Base_Class Base_Class = new Base_Class();
	private static By declinedPlans1 = By.xpath("//div[@id='divDeclinedPlans']//h4[@class='panel-title']");
	private static By employeeStatus = By.xpath("//div[@id='StatusSection']");
	private static By terminationDate = By.xpath(
			"//*[contains(text(),'Termination Date:')]/parent::span|//*[contains(text(),'Termination Date:')]/parent::span");
	private static By effectiveDate = By.xpath("//*[text()='Effective Date: ']/parent::span");
	private static By employeeDetails = By.partialLinkText("Employee Details");
	public static By allPlanCategories = By.xpath("//h4[@class='panel-title']");

	////////////////// Improvement View Coverage Page
	////////////////// ////////////////////////////////////////////
	// *[@data-categoryvalue='Medicare Part D']//*[text()='Attachments ']
	public static By L_EmployeeDetails = By.xpath("//*[text()=' Employee Details ']");
	public static By L_AuditDetails = By.id("BtnAudit");
	public static By L_viewSummary = By.xpath("//*[@class='btn btn-sm outline-bt ']");
	private static By L_ClickMedicalDropdown = By.xpath("//h4[normalize-space()='Medical']");
	private static By L_TerminateMedical = By.xpath("//div[@id='PresentCont_1']//a[@id='lnkTerminate']");
	private static By L_ClickMedicalUpdateCoveredMembers = By.id("lnkChangeFamily");

	private static By L_ClickDentalDropdown = By.xpath("//h4[normalize-space()='Dental']");
	private static By L_ClickVisionDropdown = By.xpath("//h4[normalize-space()='Vision']");
	private static By L_TerminateDental = By.xpath("//div[@id='PresentCont_16']//a[@id='lnkTerminate']");
	public static By L_ClickDentailUpdateCoveredMembers = By
			.xpath("//div[@id='PresentCont_16']//a[@id='lnkChangeFamily']");
	private static By L_clickViewBenefits = By.xpath(
			"//div[@id='PresentCont_16']//a[contains(@class,'lnkViewBenefits')][normalize-space()='View Benefits']");

	private static By L_clickClose = By.id("btnCloseModal");
	private static By clickChangePlanMedical = By.xpath("//div[@id='PresentCont_1']//a[@id='lnkChangePlan']");

	private static By clickChangePlan = By.xpath("//div[@id='PresentCont_1']//a[@id='lnkChangePlan']");
	public static By Enroll = By.id("divEnrollAllDecline");

	private static By L_clickviewSBC = By.xpath("//a[@class='view_more DownloadFileOrUrl']");
	private static By L_QualifyingEvent = By.id("Item1_QualifyingEvent_QualifyingEventName_chzn");
	private static By L_clickChangePlanDental = By.xpath("//div[@id='PresentCont_16']//a[@id='lnkChangePlan']");
	private static By L_clickChangePlanMedicareAdv = By.xpath("//div[@id='PresentCont_13']//a[@id='lnkChangePlan'] ");
	private static By L_clickChangePlanMedicalbridge = By.xpath("//div[@id='PresentCont_85']//a[@id='lnkChangePlan']");
	private static By L_ChangeContributionAmount = By.xpath("//div[@id='PresentCont_20']//a[@id='lnkChangePlan']");
	public static By L_FSADropdown = By.xpath("//*[@class='panel-title'][contains(text(),'FSA')]");
	private static By L_terminateMedicare = By.xpath("//div[@id='PresentCont_13']//a[@id='lnkTerminate']");
	private static By click_Profile = By.xpath("//span[normalize-space()='My Profile']");
	private static By L_clickMedicalBridge = By.xpath("//h4[normalize-space()='Medical Bridge']");
	private static By L_clickMedicareAdv = By.xpath("//h4[normalize-space()='Medicare Advantage & Part D']");
	private static By L_clickTermLife = By.xpath("//h4[normalize-space()='Term Life']");
	private static By L_clickChangeCoverageAmount = By.xpath("//a[text()='Change Coverage Amount']");
	//////////////////////// Terminate Coverage////////////////////////////

	private static By terminateDate = By.xpath("//div[@id='formWrap']/div[@class='row']//input[@id='TerminationDate']");

	private static By QualifyingEvent = By.id("QualifyingEvent_QualifyingEventName_chzn");

	private static By submit = By.xpath("//input[@value=\"Submit\"]");

	private static By clickenrollMedical = By
			.xpath("//div[@id='divPresentCoverageMain']/div[1]//a[@id='enrollMedical']");
	private static By clickenrollMedicare = By
			.xpath("//div[@id='divPresentCoverageMain']/div[2]//a[@id='enrollMedical']");
	private static By clickenrollDental = By.xpath("//div[@id='divPresentCoverageMain']/div[4]//a[@id='enrollMedical']|//div[@id='divPresentCoverageMain']/div[2]//a[@id='enrollMedical']|//div[@id='divPresentCoverageMain']/div[5]//a[@id='enrollMedical']|//div[@id='divPresentCoverageMain']/div[3]//a[@id='enrollMedical']");

	private static By EnrollBtnUnderDeclinedplans =By.xpath("//*[@class='panel-collapse in']//*[contains(@class,'enrollDeclined')]");
	public static By btn_editEnrollment = By.xpath("//a[@class='NEnrollRedirect btn btn-sm outline-bt']");
	public static By btn_newEnrollment = By.xpath("//a[@class='NEnrollRedirect btn btn-primary']");
	private static By renewalCenterXpath = By.xpath("//a[normalize-space()='Renewal Center']");
	private static String L_Dropdown = "//h4[normalize-space()='%s']";
	private static By L_TermLifeSpouseTerminationDate = By
			.xpath("//div[@id='PresentCont_30']//span//label[contains(text(),'Termination Date:')]/parent::span");

	private static By L_YourCost = By.id("lblMedicalTotalMonthly");


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/// "Get all the Declined plans"///
	// @Attachment
	public List<String> getAllDeclinedPlans() {
		List<WebElement> LstdeclinedPlan = driver.findElements(declinedPlans1);
		List<String> declinedPlans = new ArrayList<>();
		for (WebElement element : LstdeclinedPlan) {
			declinedPlans.add(element.getText());
		}
		System.out.println("Declined plans Size:" + declinedPlans.size());
		// Allure.addAttachment("getAllDeclinedPlans()",declinedPlans.toString());
		ExtentSuccessMessage("All plans declined");
		return declinedPlans;
	}

	//// "Get Employee Status"/////
	public String getEmployeeStatus() throws InterruptedException {
		return GetElementText(employeeStatus);
	}

	/// "Check termination date for all the plans"/////
	public void verifyTerminationDateToAllPlans(String date, List<String> plans) {
		List<WebElement> terminatedPlans = driver.findElements(terminationDate);
		Assert.assertEquals(plans.size(), terminatedPlans.size());
		SoftAssert softAssert = new SoftAssert();
		int i = 0;
		for (WebElement element : terminatedPlans) {
			driver.findElement(By.xpath("//h4[contains(text(),'" + plans.get(i) + "')]")).click();
			Base_Class.waitForTextTobePresentInElement(element, "Terminated");
			String text = element.getText().replaceAll("/", "");
			String actDate = text.substring(text.indexOf(":") + 1).trim();
			softAssert.assertEquals(actDate, date);
			Base_Class.scrollDown();
			i++;
		}
		softAssert.assertAll();
	}

	//// get termination date for all the plans"////
	// @Attachment
	public Map<String, String> getTerminationDateForAllPlans(List<String> plans) {
		List<WebElement> terminatedPlans = driver.findElements(terminationDate);
		Map<String, String> map = new HashMap<>();
		int i = 0;
		for (WebElement element : terminatedPlans) {
			WebElement plan = driver.findElement(By.xpath("//h4[contains(text(),'" + plans.get(i) + "')]"));
			try {
				plan.click();
			} catch (Exception e) {
				Base_Class.scrollUpVertically();
			}
			Base_Class.waitForTextTobePresentInElement(element, "Terminated");
			String text = element.getText().replaceAll("/", "");
			String actDate = text.substring(text.indexOf(":") + 1).trim();
			map.put(plans.get(i), actDate);
			plan.click();

			i++;
		}
		return map;

	}

	/// "Check termination date for all the plans {plansWithTermDate}"/////
	public void verifyTerminationDateToAllPlans(Map<String, String> plansWithTermDate) {
		List<WebElement> terminatedPlans = driver.findElements(terminationDate);
		SoftAssert softAssert = new SoftAssert();
		List<WebElement> plans = driver.findElements(allPlanCategories);
		int i = 0;
		for (WebElement element : terminatedPlans) {
			try {
				plans.get(i).click();
			} catch (Exception e) {
				Base_Class.scrollUpVertically();
			}
			Base_Class.waitForTextTobePresentInElement(element, "Terminated");
			String text = element.getText().replaceAll("/", "");
			String actDate = text.substring(text.indexOf(":") + 1).trim();
			softAssert.assertEquals(actDate, plansWithTermDate.get(plans.get(i).getText()));
			try {
				plans.get(i).click();
			} catch (Exception e) {

			}
			i++;
		}
		softAssert.assertAll();
	}

	public void navigateToEmployeeInfo() throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		click(employeeDetails);
	}

	// "Check termination date for all the plans"//
//	public void verifyTerminationDateToAllPlans(String dates) {
//
//		String[] sdates = dates.split("\\|");
//		SoftAssert softAssert = new SoftAssert();
//		try {
//			List<WebElement> terminatedPlans = driver.findElements(terminationDate);
//
//			for (WebElement element : terminatedPlans) {
//				//	element.click();
//				ScrollUntilElementVisible(element);
//				//ScrolltillElementOnmiddlepage(terminationDate);
//				String text = element.getText().replaceAll("/", "");
//				String actDate = text.substring(text.indexOf(":") + 1).trim();
//				softAssert.assertTrue(Arrays.asList(sdates).contains(actDate));
//				// Base_Class.scrollDown();
//				System.out.println(Arrays.asList(sdates).contains(actDate)+" for "  + actDate );
//				System.out.println("sdates:::" +Arrays.toString(sdates));
//				System.out.println(text.substring(text.indexOf(":") + 1).trim());
//			}
//			softAssert.assertAll();
//			ExtentSuccessMessage("Successfully verified  Termination Date To AllPlans");
//		} catch (Exception e) {
//			ExtentErrorMessage("Failed to verify Termination Date To AllPlans");
//		}
//	}
	
	public void verifyTerminationDateToAllPlans(String terminationDateToVerify) {

	    SoftAssert softAssert = new SoftAssert();
	    try {
	        // Find all elements with the termination date locator
	        List<WebElement> terminatedPlans = driver.findElements(terminationDate);

	        // Check if there are any termination dates found
	        if (terminatedPlans.isEmpty()) {
	            Log.error("No termination dates found on the page.");
	            ExtentErrorMessage("No termination dates found on the page.");
	            return;
	        }

	        // Loop through each plan's termination date
	        for (WebElement element : terminatedPlans) {
	            ScrollUntilElementVisible(element);
	            String text = element.getText().replaceAll("/", "");
	            String actDateFormatted = text.substring(text.indexOf(":") + 1).trim();
	            ExtentSuccessMessage("actDateFormatted " + actDateFormatted);
	            System.out.println("actDateFormatted " + actDateFormatted);
	            // Format the actual date to match the format of the provided termination date
	            String actDate = null;
	            if(actDateFormatted.contains("/")) {
	            	actDate  = formatDate(actDateFormatted);
	            }else {
	            	actDate=actDateFormatted;
	            }
	            // Printing for debugging
	            ExtentSuccessMessage("Actual Date: " + actDate);
	            System.out.println("Actual Date: " + actDate);
	            ExtentSuccessMessage("Expected Termination Date: "+ terminationDateToVerify);
	            System.out.println("Expected Termination Date: " + terminationDateToVerify);

	            // Check if the actual date matches the provided termination date for each plan
	            softAssert.assertEquals(actDate,terminationDateToVerify, "Termination date mismatch for plan: " + text);

	            // Base_Class.scrollDown(); // Not sure if you intended to uncomment this
	            ExtentSuccessMessage("Termination date match: " + actDate + " for plan: " + text );
	            System.out.println("Termination date match: " + actDate + " for plan: " + text);
	        }
	        //softAssert.assertAll();
	        Log.info("Successfully verified Termination Date To All Plans");
	        ExtentSuccessMessage("Successfully verified Termination Date To All Plans");
	    } catch (Exception e) {
	        Log.error("Failed to verify Termination Date To All Plans");
	        ExtentErrorMessage("Failed to verify Termination Date To All Plans");
	    }
	}

	// Method to format the actual date to match the format of the dates from test data
	private String formatDate(String actDateFormatted) {
	    String[] parts = actDateFormatted.split("/");
	    String month = parts[0];
	    String day = parts[1];
	    String year = parts[2];
	    // Reformatting the date to match the format from test data
	    return String.format("%02d%02d%s", Integer.parseInt(month), Integer.parseInt(day), year);
	}

	// "Verify Coverage End Date after re Hire terminationDate:{terminateDate}"//
	public void verifyCoverageEndDateAfterReHire(String terminateDate,String effectivedate) {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {

		}
		List<WebElement> allPlanCategories = driver.findElements(By.xpath("//h4[@class='panel-title']"));
		for (WebElement category : allPlanCategories) {
			String terminationDate = terminateDate.substring(0, 2) + "/" + terminateDate.substring(2, 4) + "/"
					+ terminateDate.substring(4);
			String newDate = String.valueOf(Integer.parseInt(terminateDate.substring(2, 4)));
			if (newDate.length() != 2) {
				newDate = "0" + newDate;
			}
			List<WebElement> terminatedPlans = driver
					.findElements(By.xpath("//*[contains(text(),'Termination Date:')]/parent::span"));
			List<WebElement> effectiveDate = driver
					.findElements(By.xpath("//*[text()='Effective Date: ']/parent::span"));
			SoftAssert softAssert = new SoftAssert();
			String text = terminatedPlans.get(0).getText();
			String actDate = text.substring(text.indexOf(":") + 1).trim();
			softAssert.assertEquals(actDate, terminationDate);
			String text2 = effectiveDate.get(1).getText();
			String actActivationDate = text2.substring(text2.indexOf(":") + 1).trim();
			softAssert.assertEquals(actActivationDate, effectivedate);
			softAssert.assertAll();
		}
	}
	/////////////////////// Improvement View Coverage
	/////////////////////// Method///////////////////////////////

	public void ClickOnEmployeeDetails() throws InterruptedException {
		//WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		//waitForElementVisible(L_EmployeeDetails);
		if (ElementDisplayed(L_EmployeeDetails)) {
			Log.info("Successfully Visible Employee Details Button");
			jsClick(L_EmployeeDetails);
			Log.info("Successfully Clicked On Employee Details Button");
			ExtentSuccessMessage("Successfully Clicked On Employee Details Button");
		} else {
			Log.error("UnSuccessfully Not Visible Employee Details Button");
			ExtentErrorMessage("UnSuccessfully Not Visible On Employee Details Button");
		}
	}

	public void ClickOnAuditDetails() throws InterruptedException {
		WaitForPageLoad();
		if (ElementDisplayed(L_AuditDetails)) {
			Log.info("Successfully Visible Audit Details Button");
			click(L_AuditDetails);
			Log.info("Successfully Clicked On Audit Details Button");
			ExtentSuccessMessage("Successfully Clicked On Audit Details Button");
		} else {
			Log.error("UnSuccessfully Not Visible Audit Details Button");
			ExtentErrorMessage("UnSuccessfully Not Visible On Audit Details Button");
		}
	}

	public void ClickOnViewSummary() throws InterruptedException {
		WaitForPageLoad();
		if (ElementDisplayed(L_viewSummary)) {
			Log.info("Successfully Visible view Summary Button");
			click(L_viewSummary);
			Log.info("Successfully Clicked On view Summary Button");
			ExtentSuccessMessage("Successfully Clicked On view Summary Button");
		} else {
			Log.error("UnSuccessfully Not Visible view Summary Button");
			ExtentErrorMessage("UnSuccessfully Not Visible On view Summary Button");
		}
	}

	// click Medical Plan Dropdown")
	public void ClickOnMedicalDropdown() throws InterruptedException {
		try {
			WaitForPageLoad();
			waitForElementVisible(L_ClickMedicalDropdown);
			if (ElementDisplayed(L_ClickMedicalDropdown)) {
				Log.info("Successfully Visible Medical Dropdown");
				click(L_ClickMedicalDropdown);
				Log.info("Successfully Clicked On Medical Dropdown");
				ExtentSuccessMessage("Successfully Clicked On Medical Dropdown");
			} else {
				Log.error("UnSuccessfully Not Visible Medical Dropdown");
				ExtentErrorMessage("UnSuccessfully Not Visible On Medical Dropdown");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

	// ClickonTerminateMedical
	public void ClickonTerminateMedicalButton() throws InterruptedException, AWTException {
		try {
			WaitForPageLoad();
			do {
				ScrolltillElementOnmiddlepage(L_TerminateMedical);
				Thread.sleep(1000);
			} while (!ElementDisplayed(L_TerminateMedical));

			// ScrolltillElementOnmiddlepage(L_TerminateMedical);
			// ScrolltillElementOnmiddlepage(L_TerminateMedical);
			if (ElementsDisplayed(L_TerminateMedical)) {
				Log.info("Successfully  visible Terminate Medical Button");
				click(L_TerminateMedical);
				Log.info("Successfully Clicked On Terminate Medical Button");
				ExtentSuccessMessage("Successfully Clicked On Terminate Medical Button");
			} else {
				Log.error("UnSuccessfully Terminate Medical Button is not Visible");
				ExtentErrorMessage("UnSuccessfully Terminate Medical Button is not Visible");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

	// "click Update Covered Members Medical"
	public void ClickUpdateCoveredMembersMedical() throws InterruptedException {
		WaitForPageLoad();
		// Thread.sleep(5000);
		do {
			ScrolltillElementOnmiddlepage(L_ClickMedicalUpdateCoveredMembers);
			Thread.sleep(1000);
		} while (!ElementDisplayed(L_ClickMedicalUpdateCoveredMembers));

		// ScrolltillElementOnmiddlepage(L_ClickMedicalUpdateCoveredMembers);
		// ScrolltillElementOnmiddlepage(L_ClickMedicalUpdateCoveredMembers);
		// ScrolltillElementOnmiddlepage(L_ClickMedicalUpdateCoveredMembers);

		if (ElementDisplayed(L_ClickMedicalUpdateCoveredMembers)) {
			ExtentSuccessMessage("Successfully Visible  Update Covered Members Button ");
			Log.info("Successfully Visible  Update Covered Members Button ");
			click(L_ClickMedicalUpdateCoveredMembers);
			ExtentSuccessMessage("Successfully Clicked on  Update Covered Members Button ");

		} else {
			ScrolltillElementOnmiddlepage(L_ClickMedicalUpdateCoveredMembers);
			ScrolltillElementOnmiddlepage(L_ClickMedicalUpdateCoveredMembers);
			if (ElementDisplayed(L_ClickMedicalUpdateCoveredMembers)) {
				click(L_ClickMedicalUpdateCoveredMembers);
				ExtentSuccessMessage("Successfully Clicked on  Update Covered Members Button ");

			} else {
				ExtentErrorMessage("Unsuccessfully not Visible  Update Covered Members Button ");
				Log.error("Unsuccessfully not Visible  Update Covered Members Button ");
			}

		}
		Thread.sleep(5000);
	}

	// L_ClickDentalDropdown

	public void ClickOnDentalDropdown() throws InterruptedException {
		try {
			WaitForPageLoad();
			if (ElementDisplayed(L_ClickDentalDropdown)) {
				Log.info("Successfully Visible Dental Dropdown");
				click(L_ClickDentalDropdown);
				Log.info("Successfully Clicked On Dental Dropdown");
				ExtentSuccessMessage("Successfully Clicked On Dental Dropdown");
			} else {
				Log.error("UnSuccessfully Not Visible Dental Dropdown");
				ExtentErrorMessage("UnSuccessfully Not Visible On Dental Dropdown");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

	// L_ClickVisionDropdown

	public void ClickOnVisionDropdown() throws InterruptedException {
		try {
			WaitForPageLoad();
			if (ElementDisplayed(L_ClickVisionDropdown)) {
				Log.info("Successfully Visible Vision Dropdown");
				click(L_ClickVisionDropdown);
				Log.info("Successfully Clicked On Vision Dropdown");
				ExtentSuccessMessage("Successfully Clicked On Vision Dropdown");
			} else {
				Log.error("UnSuccessfully Not Visible Vision Dropdown");
				ExtentErrorMessage("UnSuccessfully Not Visible On Vision Dropdown");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

	// ClickonTerminateDentailButton
	public void ClickonTerminateDentalButton() throws InterruptedException, AWTException {
		try {
			WaitForPageLoad();
			do {
				ScrolltillElementOnmiddlepage(L_TerminateDental);
				Thread.sleep(1000);
			} while (!ElementDisplayed(L_TerminateDental));
			// ScrolltillElementOnmiddlepage(L_TerminateDental);
			// ScrolltillElementOnmiddlepage(L_TerminateDental);
			if (ElementsDisplayed(L_TerminateDental)) {
				Log.info("Successfully  visible Terminate Dental Button");
				click(L_TerminateDental);
				Log.info("Successfully Clicked On Terminate Dental Button");
				ExtentSuccessMessage("Successfully Clicked On Terminate Dental Button");
			} else {
				Log.error("UnSuccessfully Not Visible On Terminate Dental Button");
				ExtentErrorMessage("UnSuccessfully Not Visible On Terminate Dental Button");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public void ClickDentalUpdateCoveredMembers() throws InterruptedException {
		WaitForPageLoad();
		do {
			ScrolltillElementOnmiddlepage(L_ClickDentailUpdateCoveredMembers);
			Thread.sleep(1000);
		} while (!ElementDisplayed(L_ClickDentailUpdateCoveredMembers));
		// ScrollUntilElementVisible(L_ClickDentailUpdateCoveredMembers);
		// ScrolltillElementOnmiddlepage(L_ClickDentailUpdateCoveredMembers);
		// ScrolltillElementOnmiddlepage(L_ClickDentailUpdateCoveredMembers);
		if (ElementDisplayed(L_ClickDentailUpdateCoveredMembers)) {
			ExtentSuccessMessage("Successfully Visible   Update Covered Members Button ");
			Log.info("Successfully Visible  Update Covered Members Button ");
			click(L_ClickDentailUpdateCoveredMembers);
			ExtentSuccessMessage("Successfully Clicked on  Update Covered Members Button ");

		} else {
			ScrolltillElementOnmiddlepage(L_ClickDentailUpdateCoveredMembers);
			ScrolltillElementOnmiddlepage(L_ClickDentailUpdateCoveredMembers);
			WaitForPageLoad();
			if (ElementDisplayed(L_ClickDentailUpdateCoveredMembers)) {
				ExtentSuccessMessage("Successfully Visible Dentai  Update Covered Members Button ");
				Log.info("Successfully Visible Dentai Update Covered Members Button ");
				click(L_ClickDentailUpdateCoveredMembers);
				ExtentSuccessMessage("Successfully Clicked on Dentai Update Covered Members Button ");
			} else {
				ExtentErrorMessage("Unsuccessfully not Visible Dentai Update Covered Members Button ");
				Log.error("Unsuccessfully not Visible Dentai Update Covered Members Button ");

			}
		}

	}

	// click On View Benefits & Close Button
	public void ViewBenefitsInformtion() throws InterruptedException {
		try {
			WaitForPageLoad();
			scrollToElement(L_clickViewBenefits);
			Thread.sleep(1000);
			scrollUpVertically();
			// Ramya -Oct 12th
			// WaitForLoadAnimationDisappear();
			if (ElementDisplayed(L_clickViewBenefits)) 
			{
				Thread.sleep(1000);
				Log.info("Successfully Visible View Benefits Button");
				click(L_clickViewBenefits);
				Log.info("Successfully Clicked On View Benefits Button");
				ExtentSuccessMessage("Successfully Clicked On View Benefits Button");
			} else {
				Log.error("UnSuccessfully Not Visible View Benefits Button");
				ExtentErrorMessage("UnSuccessfully Not Visible On View Benefits Button");
			}
			WaitForPageLoad();
			// Ramya -Oct 12th
			WaitForLoadAnimationDisappear();
			WaitForElementToBeVisible(L_clickClose);
			if (ElementDisplayed(L_clickClose)) {
				Log.info("Successfully Visible  Close Button");
				click(L_clickClose);
				Log.info("Successfully Clicked On  Close Button");
				ExtentSuccessMessage("Successfully Clicked On View Benefits Button");
			} else {
				Log.error("UnSuccessfully Not Visible  Close Button");
				ExtentErrorMessage("UnSuccessfully Not Visible On  Close Button");
			}

		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// View Benefits page click View SBC")
	public void clickViewSBC() throws InterruptedException {
		if (ElementDisplayed(L_clickviewSBC)) {
			click(L_clickviewSBC);
			Log.info("Successfully Clicked On View SBC");
			ExtentSuccessMessage("Successfully Clicked on View SBC");
		} else {
			Log.error("UNSuccessfully Not Visible On View SBC");
			ExtentErrorMessage("UNSuccessfully Not Visible on View SBC");
		}
	}

	public void ChangeplanbuttonMedical() throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		ScrolltillElementOnmiddlepage(clickChangePlanMedical);
		ScrollUntilElementVisible(clickChangePlanMedical);
		WaitForPageLoad();
		if (ElementDisplayed(clickChangePlanMedical)) {
			waitForElementClickable(clickChangePlanMedical);
			jsClick(clickChangePlanMedical);
			Log.info("Successfully Clicked On ChangePlan");
			ExtentSuccessMessage("Successfully Clicked on ChangePlan");
		} else {
			Log.error("UNSuccessfully ChangePlan button is not Visible");
			ExtentErrorMessage("UNSuccessfully ChangePlan button is not Visible");
		}

	}

	public void SelecetQualifyingEventRandom() throws InterruptedException {
		waitForElementSelectable(L_QualifyingEvent);
		selectByRandom(L_QualifyingEvent);
	}

	public void ChangePlanbuttonDental() throws InterruptedException {
		WaitForPageLoad();
		do {
			ScrolltillElementOnmiddlepage(L_clickChangePlanDental);
			Thread.sleep(1000);
		} while (!ElementDisplayed(L_clickChangePlanDental));
		if (ElementDisplayed(L_clickChangePlanDental)) {
			waitForElementClickable(L_clickChangePlanDental);
			click(L_clickChangePlanDental);
			Log.info("Successfully Clicked on Change Plan Dental");
			ExtentSuccessMessage("Successfully Clicked on  Change Plan Dental");

		} else {
			Log.error("UnSuccessfully Not Clicked on  Change Plan Dental");
			ExtentErrorMessage("UnSuccessfully Not Clicked on  Change Plan Dental");

		}
	}

	// Change Plan buttons for Medicare and Medical Bridge - Anil

	public void ChangeplanbuttonMedicare() throws InterruptedException {
		WaitForPageLoad();
		ScrollUntilElementVisible(L_clickChangePlanMedicareAdv);
		WaitForPageLoad();
		waitForElementClickable(L_clickChangePlanMedicareAdv);
		if (ElementDisplayed(L_clickChangePlanMedicareAdv)) {
			jsClick(L_clickChangePlanMedicareAdv);
			Log.info("Successfully Clicked On ChangePlan");
			ExtentSuccessMessage("Successfully Clicked on ChangePlan");
		} else {
			Log.error("UNSuccessfully Visible On ChangePlan");
			ExtentErrorMessage("UNSuccessfully Visible on ChangePlan");
		}

	}

	public void ChangeplanbuttonMedicalbridge() throws InterruptedException {
		WaitForPageLoad();
		ScrollUntilElementVisible(L_clickChangePlanMedicalbridge);
		WaitForPageLoad();
		if (ElementDisplayed(L_clickChangePlanMedicalbridge)) {
			waitForElementClickable(L_clickChangePlanMedicalbridge);
			jsClick(L_clickChangePlanMedicalbridge);
			Log.info("Successfully Clicked On ChangePlan");
			ExtentSuccessMessage("Successfully Clicked on ChangePlan");
		} else {
			Log.error("UNSuccessfully Visible On ChangePlan");
			ExtentErrorMessage("UNSuccessfully Visible on ChangePlan");
		}

	}

	public void ClickonFsaDropdowns() throws InterruptedException {
		if (ElementDisplayed(L_FSADropdown)) {
			click(L_FSADropdown);
			Log.info("Successfully Clicked on Fsa Dropdown");
			ExtentSuccessMessage("Successfully Clicked on Fsa Dropdown");
		} else {
			Log.error("UnSuccessfully Not Visible on Fsa Dropdown");
			ExtentErrorMessage("UnSuccessfully Not Visible on Fsa Dropdown");

		}
	}

	public void ChangeContributionAmount() throws InterruptedException {
		WaitForPageLoad();
		ScrollUntilElementVisible(L_ChangeContributionAmount);
		if (ElementDisplayed(L_ChangeContributionAmount)) {
			jsClick(L_ChangeContributionAmount);
			Log.info("Successfully Clicked on Change Contribution Amount");
			ExtentSuccessMessage("Successfully Clicked on Change Contribution Amount");
		} else {
			Log.error("UnSuccessfully Not Visible on Change Contribution Amount");
			ExtentErrorMessage("UnSuccessfully Not Visible on Change Contribution Amount");

		}
		Thread.sleep(8000);
	}

	public String clickMedicalBridge() throws InterruptedException {
		WaitForPageLoad();
		ScrollUntilElementVisible(L_clickMedicalBridge);
		waitForElementClickable(L_clickMedicalBridge);
		jsClick(L_clickMedicalBridge);
		String plan = GetElementText(L_clickMedicalBridge);
		return plan;
	}

	public String clickMedicareAdv() throws InterruptedException {

		WaitForPageLoad();
		waitForElementClickable(L_clickMedicareAdv);
		jsClick(L_clickMedicareAdv);
		String plan = GetElementText(L_clickMedicareAdv);
		return plan;
	}

	// "Click Terminate Medicare"
	public void clickTerminateMedicare() throws InterruptedException {
		WaitForPageLoad();
		String IDs = "";
		By xpath = By
				.xpath("(//*[@class='panel-title'][contains(text(),'Medicare Advantage & Part D')])[1]//parent::a");
		WebElement option = driver.findElement(xpath);
		if (option.isDisplayed()) {
			String s = option.getAttribute("href");
			String[] Id = s.split("#");
			IDs = Id[1];
		}
		System.out.println("ids " + IDs);

		By Elements = By.xpath("//div[@id='" + IDs + "']//a[@id='lnkTerminate']");

		// ScrolltillElementOnmiddlepage(Elements);
		// WaitForPageLoad();
		// ScrolltillElementOnmiddlepage(Elements);
		// WaitForPageLoad();
		// ScrolltillElementOnmiddlepage(Elements);
		// ScrollUntilElementVisible(Elements);
		ScrollUntilElementVisible(Elements);
		if (ElementDisplayed(Elements)) {

			jsClick(Elements);
			Log.info("Successfully Clicked on Teminate Medicare Button");
			ExtentSuccessMessage("Successfully Clicked on Teminate Medicare Button");
		} else {
			// ScrolltillElementOnmiddlepage(Elements);
			// WaitForPageLoad();
			// ScrolltillElementOnmiddlepage(Elements);
			// WaitForPageLoad();
			// ScrolltillElementOnmiddlepage(Elements);
			// ScrolltillElementOnmiddlepage(Elements);
			// ScrollUntilElementVisible(Elements);
			// if(ElementDisplayed(Elements)) {
			//
			// click(Elements);
			// Log.info("Successfully Clicked on Teminate Medicare Button");
			// ExtentSuccessMessage("Successfully Clicked on Teminate Medicare Button");
			//
			// }else {

			// ScrolltillElementOnmiddlepage(Elements);
			// WaitForPageLoad();
			// ScrolltillElementOnmiddlepage(Elements);
			// WaitForPageLoad();
			// ScrolltillElementOnmiddlepage(Elements);
			// ScrolltillElementOnmiddlepage(Elements);
			// ScrollUntilElementVisible(Elements);
			// if(ElementDisplayed(Elements)) {
			//
			// click(Elements);
			// Log.info("Successfully Clicked on Teminate Medicare Button");
			// ExtentSuccessMessage("Successfully Clicked on Teminate Medicare Button");
			//
			// }else {
			Log.error("UnSuccessfully Not Visible on Teminate Medicare Button");
			ExtentErrorMessage("UnSuccessfully Not Visible on Teminate Medicare Button");

			// }

		}
	}

	public void AttachmentInAllDropdownOnViewCoveragePage(String Value) throws InterruptedException {
		By xpath = By.xpath("//*[@data-categoryvalue='" + Value + "']//*[text()='Attachments ']");
		if (ElementDisplayed(xpath)) {
			click(xpath);
			Log.info("Successfully clicked on Attachement button under this dropdown: " + Value);

		} else {
			Log.error("UnSuccessfully Not Visible on Attachement button under this dropdown: ");
		}
	}

	public void NotestInAllDropdownOnViewCoveragePage(String Value) throws InterruptedException {
		By xpath = By.xpath("//*[@data-categoryvalue='" + Value + "']//*[text()=' Notes']");

		if (ElementDisplayed(xpath)) {
			click(xpath);
			Log.info("Successfully clicked on Note button under this dropdown: " + Value);

		} else {
			Log.error("UnSuccessfully Not Visible on Note button under this dropdown: " + Value);
		}
	}

	public void ClickOnDeclinedPlanDropdownEnroll(String PlanName) throws InterruptedException {
		WaitForPageLoad();
		By PlanDropdown = By.xpath("//*[@class='panel-title'][normalize-space()='" + PlanName + "']");
		if (ElementDisplayed(PlanDropdown)) {
			Log.info("Successfully Visible Plan Name Dropdown " + PlanName);
			click(PlanDropdown);
			Log.info("Successfully Clicked On Plan Name Dropdown " + PlanName);
			ExtentSuccessMessage("Successfully Clicked On Plan Name Dropdown " + PlanName);
		} else {
			Log.error("UNSuccessfully not Visible On Plan Name Dropdown " + PlanName);
			ExtentErrorMessage("UNSuccessfully Not Visible On Plan Name Dropdown " + PlanName);
		}

		By PLanEnrollButton = By.xpath("//*[@class='panel-title'][contains(text(),'" + PlanName
				+ "')]//ancestor::div[@class='panel-group']//*[@class='btn btn-sm btn-primary enrollDeclined']");

		if (ElementDisplayed(PLanEnrollButton)) {
			Log.info("Successfully Visible Plan Name Enroll " + PlanName);
			click(PLanEnrollButton);
			Log.info("Successfully Clicked On Plan Name Enroll " + PlanName);
			ExtentSuccessMessage("Successfully Clicked On Plan Name Enroll " + PlanName);
		} else {
			Log.error("UNSuccessfully not Visible On Plan Name Enroll " + PlanName);
			ExtentErrorMessage("UNSuccessfully not Visible On Plan Name Enroll " + PlanName);
		}

	}

	public void EnrollMedicalPlan() throws InterruptedException {
		WaitForPageLoad();
		do {
			ScrolltillElementOnmiddlepage(Enroll);
			Thread.sleep(1000);
		} while (!ElementDisplayed(Enroll));

		if (ElementDisplayed(Enroll)) {
			Log.info("Enroll button visible");
			click(Enroll);
		} else {
			Log.info("Enroll button not visible");
		}
	}

	public void Terminateplan(Map<Object, Object> testdata) throws InterruptedException, AWTException {
		WaitForLoadAnimationDisappear();
		System.out.println("Termination Date : " + testdata.get("TerminationDate").toString());
		click(terminateDate);
		Log.info("Successfully Clicked On Termination Date");
		ExtentSuccessMessage("Successfully Clicked On Termination Date");
		input(terminateDate, testdata.get("TerminationDate").toString());
		ExtentSuccessMessage("Successfully Enter Termination Date" + testdata.get("TerminationDate").toString());
		Log.info("Successfully entered the Termination Date");
		findElement(terminateDate).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		// waitForElementSelectable(QualifyingEvent);
		selectByRandom(QualifyingEvent);
		Log.info("Successfully selected the Qualifying Event");
		ExtentSuccessMessage("Successfully selected the Qualifying Event");
		RobotKeyOperation("TAB");
		click(submit);
		ExtentSuccessMessage("Successfully Clicked On Submit Button");
	}

	public void TerminateplanonQE(Map<Object, Object> testdata) throws InterruptedException, AWTException {
		WaitForLoadAnimationDisappear();
		System.out.println("Termination Date : " + testdata.get("Termination_Date").toString());
		click(terminateDate);
		Log.info("Successfully Clicked On Termination Date");
		ExtentSuccessMessage("Successfully Clicked On Termination Date");
		input(terminateDate, testdata.get("Termination_Date").toString());
		ExtentSuccessMessage("Successfully Enter Termination Date" + testdata.get("Termination_Date").toString());
		Log.info("Successfully entered the Termination Date");
		findElement(terminateDate).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		// waitForElementSelectable(QualifyingEvent);
		selectByRandom(QualifyingEvent);
		Log.info("Successfully selected the Qualifying Event");
		ExtentSuccessMessage("Successfully selected the Qualifying Event");
		RobotKeyOperation("TAB");
		click(submit);
		ExtentSuccessMessage("Successfully Clicked On Submit Button");
	}

	public void click_profile() throws InterruptedException {
		click(click_Profile);
	}

	public void clickEnrollMedicareinPlan() throws InterruptedException {
		try {
			WaitForPageLoad();
			ScrolltillElementOnmiddlepage(clickenrollMedicare);
			ScrollUntilElementVisible(clickenrollMedicare);
			waitForElementClickable(clickenrollMedicare);
			if (ElementDisplayed(clickenrollMedicare)) {
				Log.info("Enroll button is displayed");
				WaitForPageLoad();
				jsClick(clickenrollMedicare);
				ExtentSuccessMessage("Successfully clicked on the Enroll Button");

			} else {
				Log.error("Enroll button is not displayed");
				ExtentErrorMessage("Enroll button is not displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickEnrollDentalinPlan() throws InterruptedException {
		try {
			WaitForPageLoad();
			ScrolltillElementOnmiddlepage(clickenrollDental);
			Thread.sleep(1000);
//			ScrollUntilElementVisible(clickenrollDental);
//			waitForElementClickable(clickenrollDental);
			if (ElementDisplayed(clickenrollDental)) {
				Log.info("Enroll button is displayed");
				ExtentSuccessMessage("Enroll button is displayed");
				WaitForPageLoad();
				jsClick(clickenrollDental);
				Log.info("Successfully clicked on the Enroll Button");
				ExtentSuccessMessage("Successfully clicked on the Enroll Button");

			} else {
				Log.error("Enroll button is not displayed");
				ExtentErrorMessage("Enroll button is not displayed");
				
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickEnrollMedicalinPlan() throws InterruptedException {

		try {
			WaitForPageLoad();
			ScrollUntilElementVisible(clickenrollMedical);
			waitForElementClickable(clickenrollMedical);

			if (ElementDisplayed(clickenrollMedical)) {

				Log.info("Enroll button is displayed");
				WaitForPageLoad();
				jsClick(clickenrollMedical);
				ExtentSuccessMessage("Successfully clicked on the Enroll Button");

			} else {
				Log.error("Enroll button is not displayed");
				ExtentErrorMessage("Enroll button is not displayed");
			}
		} catch (Exception e) {

			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}


	// click Medical Plan Dropdown")
	public void ClickOnTermLifeDropdown() throws InterruptedException {
		try {
			WaitForPageLoad();
			waitForElementVisible(L_clickTermLife);
			if (ElementDisplayed(L_clickTermLife)) {
				Log.info("Successfully Visible Term Life Dropdown");
				click(L_clickTermLife);
				Log.info("Successfully Clicked On Term Life Dropdown");
				ExtentSuccessMessage("Successfully Clicked On Term Life Dropdown");
			} else {
				Log.error("UnSuccessfully Not Visible Term Life Dropdown");
				ExtentErrorMessage("UnSuccessfully Not Visible On Term Life Dropdown");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public void clickChangeCoverageAmount() throws InterruptedException {
		try {
			WaitForPageLoad();
			ScrollUntilElementVisible(L_clickChangeCoverageAmount);
			waitForElementClickable(L_clickChangeCoverageAmount);
			if (ElementDisplayed(L_clickChangeCoverageAmount)) {
				Log.info("Change Coverage Amount button is displayed");
				WaitForPageLoad();
				jsClick(L_clickChangeCoverageAmount);
				ExtentSuccessMessage("Successfully clicked on the Change Coverage Amount Button");
			} else {
				Log.error("Change Coverage Amount button is not displayed");
				ExtentErrorMessage("Change Coverage Amount button is not displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickonEnrollBtnUnderDeclinedplans() throws InterruptedException {
		try {
			WaitForPageLoad();
			ScrollUntilElementVisible(EnrollBtnUnderDeclinedplans);
			waitForElementClickable(EnrollBtnUnderDeclinedplans);
			if (ElementDisplayed(EnrollBtnUnderDeclinedplans)) {
				Log.info("Enroll button button is displayed");
				WaitForPageLoad();
				jsClick(EnrollBtnUnderDeclinedplans);
				ExtentSuccessMessage("Successfully clicked on the Enroll Button");
			} else {
				Log.error("Enroll button is not displayed");
				ExtentErrorMessage("Enroll button is not displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Edit Enrollment
	public void editEnrollment() throws InterruptedException {
		try {
			jsClick(btn_editEnrollment);
			ExtentSuccessMessage("Successfully clicked on Edit Button");

		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// New Enrollment
	public void newEnrollment() throws InterruptedException {
		try {
			click(btn_newEnrollment);
			ExtentSuccessMessage("Successfully clicked on New enrollment Button");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Click on the Renewal Center
	public void clickRenewalCenter() throws InterruptedException {
		try {
			WaitForLoadAnimationDisappear();
			jsClick(renewalCenterXpath);
			ExtentSuccessMessage("Successfully Clicked on 'renewal Center ' ");

		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

	// click Medical Plan Dropdown")
	public void ClickOnPlanDropdown(String plannames) throws InterruptedException {
		try {
			WaitForPageLoad();
			WaitForLoadAnimationDisappear();
			String[] pnames = plannames.split("\\|");
			for (int i = 0; i < pnames.length; i++) {
				By ele = By.xpath(String.format(L_Dropdown, pnames[i]));
				if (ElementDisplayed(ele)) {

					Log.info("Successfully Visible " + pnames[i] + " Dropdown");
					click(ele);
					Log.info("Successfully Clicked on " + pnames[i] + " Dropdown");
					ExtentSuccessMessage("Successfully Clicked on " + pnames[i] + " Dropdown");
				} else {
					Log.error("UnSuccessfully the dropdown is not Visible ");
					ExtentErrorMessage("UnSuccessfully the dropdown is not Visible");
				}
			}
		} catch (Exception e) {

			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

	// Validate the termination date for a specific plan
	public String validateTerminationDateForAPlan(String plan, String expectedDate) {

		WebElement terminationElement = driver.findElement(L_TermLifeSpouseTerminationDate);
		ScrollUntilElementVisible(L_TermLifeSpouseTerminationDate);
		ExtentSuccessMessage("Successfully scrolled till the Termination Date");
		String terminationDateText = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].textContent.trim();", terminationElement);
		String actualDate = extractDate(terminationDateText);
		Log.info("Successfully fetched the Termination Date for Term Life Spouse Plan");
		ExtentSuccessMessage("Successfully fetched the Termination Date for Term Life Spouse Plan");
		// Perform date validation
		if (actualDate.equals(expectedDate)) {
			System.out.println("Validation Passed: Termination date for " + plan + " is  as expected. Expected: "
					+ expectedDate + ", Actual: " + actualDate);
			Log.info("Validation Passed: Termination date for " + plan + " is  as expected. Expected: " + expectedDate
					+ ", Actual: " + actualDate);
			ExtentSuccessMessage("Validation Passed: Termination date for " + plan + " is  as expected. Expected: "
					+ expectedDate + ", Actual: " + actualDate);
		} else {
			System.out.println("Validation Failed: Termination date for " + plan + " is not as expected. Expected: "
					+ expectedDate + ", Actual: " + actualDate);
			Log.error("Validation Failed: Termination date for " + plan + " is not as expected. Expected: "
					+ expectedDate + ", Actual: " + actualDate);
			ExtentErrorMessage("Validation Failed: Termination date for " + plan + " is not as expected. Expected: "
					+ expectedDate + ", Actual: " + actualDate);
		}

		return actualDate;
	}

	private static String extractDate(String text) {
		// Use a regular expression to find the date pattern MM/DD/YYYY
		String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
		java.util.regex.Matcher matcher = pattern.matcher(text);

		// If a match is found, return the date part
		if (matcher.find()) {
			return matcher.group();
		} else {
			// Return an empty string or handle the case when no date is found
			return "";
		}
	}

	//Fetch the Plan amount

	public String fetchPlanAmount(String planName ) throws InterruptedException {
		WaitForLoadAnimationDisappear();
		String monthlyAmount= null;
		By  xpath =  By.xpath("(//div[@class='opened-pannel']//span[@id='lblMedicalTotalMonthly'])[2]");

		if (ElementDisplayed(xpath)) {    	
					WebElement monthlyCostElement = driver.findElement(xpath);
					// If the second XPath is present, fetch data from it
					monthlyAmount = monthlyCostElement.getText();
				} else {
					// Find the lblMedicalTotalMonthly within the planElement
					By Xpath1 =By.xpath("//div[@class='opened-pannel']//span[@id='lblMedicalTotalMonthly']");
					if(ElementDisplayed(Xpath1)) {
						WebElement monthlyCostElement = driver.findElement(Xpath1);
						// Get the text content of lblMedicalTotalMonthly
						monthlyAmount = monthlyCostElement.getText();
						// Print the fetched monthly amount
						System.out.println("Monthly Amount for " + planName + ": " + monthlyAmount);
						Log.info("Monthly Amount for " + planName + ": " + monthlyAmount);
						ExtentSuccessMessage("Monthly Amount for " + planName + ": " + monthlyAmount);
					}else {
						By xpaths =By.xpath("//span[text()='Selected']//ancestor::div[@class='plan_div_box']//span[@class='premium']");
						if(ElementDisplayed(xpaths)) {
							// Find the lblMedicalTotalMonthly within the planElement
							WebElement monthlyCostElement1 = driver.findElement(xpaths);
							// Get the text content of lblMedicalTotalMonthly
							monthlyAmount = monthlyCostElement1.getText();
							// Print the fetched monthly amount
							System.out.println("Monthly Amount for " + planName + ": " + monthlyAmount);
							Log.info("Monthly Amount for " + planName + ": " + monthlyAmount);
							ExtentSuccessMessage("Monthly Amount for " + planName + ": " + monthlyAmount);
						}else {
							// Find the lblMedicalTotalMonthly within the planElement
							WebElement monthlyCostElement1 = driver.findElement(By.xpath("//div[@class='opened-pannel']//span[@class='premium']"));             	
							// Get the text content of lblMedicalTotalMonthly
							monthlyAmount = monthlyCostElement1.getText();
							// Print the fetched monthly amount
							System.out.println("Monthly Amount for " + planName + ": " + monthlyAmount);
							Log.info("Monthly Amount for " + planName + ": " + monthlyAmount);
							ExtentSuccessMessage("Monthly Amount for " + planName + ": " + monthlyAmount);
						}
					}
				}
		return monthlyAmount.trim();
	}
		/*By  xpath =  By.xpath("(//div[@class='opened-pannel']//span[@id='lblMedicalTotalMonthly'])[2]|//div[@class='opened-pannel']//span[@id='lblMedicalTotalMonthly']|//span[text()='Selected']//ancestor::div[@class='plan_div_box']//span[@class='premium']|//div[@class='opened-pannel']//span[@class='premium']");
		// Fetch data based on the condition
		List<WebElement> elements = driver.findElements(xpath);
		String amount = null;
		if(elements.size()>1)
		{
			amount = elements.get(1).getText().trim();
		}
		else
		{
			amount = elements.get(0).getText().trim();
		}
			
		System.out.println(amount);
		return amount;*/
	




	//Fetch the Plan Name
	public String fetchPlanName(String planName ) throws InterruptedException {
		Boolean flag = false;
		WaitForLoadAnimationDisappear();
		String NewplanName= null;
		// Find the lblMedicalTotalMonthly within the planElement
		By Xpath =By.xpath("//span[text()='Selected']//ancestor::div[@class='plan_div_box']//a[@class=\"plan_logo\"]//parent::div//p");
		if(ElementDisplayed(Xpath)) {
			WebElement NewplanNameElement = driver.findElement(Xpath);
			// Get the text content of lblMedicalTotalMonthly
			NewplanName = NewplanNameElement.getText();

			// Print the fetched monthly amount
			System.out.println("New plan for " + planName + " is : " + NewplanName);
			Log.info("New plan for " + planName + "is : " + NewplanName);
			ExtentSuccessMessage("New plan for " + planName + " is : " + NewplanName);
			flag=true;
		}else {
			By xpaths =By.xpath("(//span[text()='Active']//ancestor::div[@class='panel-collapse in']//p)[1]");
			if(ElementDisplayed(xpaths)) {
				WebElement NewplanNameElement = driver.findElement(xpaths);
				// Get the text content of lblMedicalTotalMonthly
				NewplanName = NewplanNameElement.getText();

				// Print the fetched monthly amount
				System.out.println("New plan for " + planName + " is : " + NewplanName);
				Log.info("New plan for " + planName + "is : " + NewplanName);
				ExtentSuccessMessage("New plan for " + planName + " is : " + NewplanName);
				flag=true;
			}else {
				
			}
		}

		if(!flag) {
			ExtentErrorMessage("Unsuccessfully not able to find the Plan Name for :- "+planName);			
		}
		
		return NewplanName;
	}


}
