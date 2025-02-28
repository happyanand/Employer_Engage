package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class QEEnrollment_ChangePlan_Page extends Base_Class {
	public static By QualifyingEvent = By.id("Item1_QualifyingEvent_QualifyingEventName_chzn");

	public static By EffectiveDate = By.xpath("//input[@id='Item1_EffectiveDate']");

	public static By clickPlan = By.xpath("//h4[@class='panel-title']");

//	public static By selectPlan = By.xpath(
//			"//label[@class='btn btn-default addtoselect Yesnoclass']|(//label[@class='btn btn-default addtoselect Yesnoclass'])[1]|//span[normalize-space()='Select Plan']");
	
	public static By selectPlan = By.xpath(
			"(//label[@class='btn btn-default addtoselect Yesnoclass'])[1]");

	public static By clickCancel = By.xpath("//*[@id=\"divCancel\"]");

	public static By clickNext = By.xpath("//a[@id='BtnQEGotoProfile']|//span[@id='BtnChangePlanGotoProfile']");

	public static By clickSubmit = By.xpath("//span[@id='BtnSubmitChangePlan']|//*[@id='BtnSubmitEnrollment']");
	
	public static By employmentStatus = By.id("Item1_EmployeeVM_EmploymentStatusId_chzn");//("Item1_EmployeeVM_EmploymentStatusId_chzn");
	//public static By employmentStatus = By.id("Item1_EmployeeClass_ClassDescription");//("Item1_EmployeeVM_EmploymentStatusId_chzn");
	// Ramya - 9/28 - planChevron
	public static By planChevron = By.xpath("//a[contains(@class,'planAccordian')]/i");

	/// "Select Qualifying Event"///
	public void selectQualifyingEvent() throws InterruptedException {
		try {
			WaitForPageLoad();
			waitForElementVisible(QualifyingEvent);
			if (ElementDisplayed(QualifyingEvent)) {
				Log.info("Qualifying Event dropdown is displayed");
				waitForElementSelectable(QualifyingEvent);
				selectByRandom(QualifyingEvent);
				ExtentSuccessMessage("Successfully selected the Qualifying Event");
			} else {
				Log.error("Qualifying Event dropdown is not displayed");
				ExtentErrorMessage("Qualifying Event dropdown is not displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/// "Enter the Effective date"///
	public void enterEffectiveDate(String date) throws InterruptedException {
		try {
			WaitForPageLoad();
			waitForElementVisible(EffectiveDate);
			if (ElementDisplayed(EffectiveDate)) {
				Log.info("Effective Date is displayed");
				waitForElementClickable(EffectiveDate);
				click(EffectiveDate);
				System.out.println("date:- "+date);
				input(EffectiveDate, date);
				findElement(EffectiveDate).sendKeys(Keys.TAB);
				ExtentSuccessMessage("Successfully entered the Effective Date");
				WaitForLoadAnimationDisappear();
			} else {
				Log.error("Effective Date is not displayed");
				ExtentErrorMessage("Effective Date is not displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//"Select Employee Class"
	public void employmentStatus() throws InterruptedException{
		WaitForPageLoad();
		try {
			WaitForPageLoad();
			if (ElementDisplayed(employmentStatus)) {
				Log.info("Employment Status dropdown is displayed");
				WaitForLoadAnimationDisappear();
				//createDynamicPath();
				selectByRandom(employmentStatus);
				ExtentSuccessMessage("Successfully selected the Employment Status");
			} else {
				Log.error("Employment Status dropdown is not displayed");
				ExtentErrorMessage("Employment Status dropdown is not displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/// "Select any plan (Medical,Dental,Medicare)"///
	public void clickPlan() throws InterruptedException {
		try {
			WaitForPageLoad();
			waitForElementVisible(clickPlan);
			if (ElementDisplayed(clickPlan)) {
				Log.info("Plan is displayed");
				waitForElementClickable(clickPlan);
				click(clickPlan);
				ExtentSuccessMessage("Successfully selected the Plan");
			} else {
				Log.error("Plan is not displayed");
				ExtentErrorMessage("Plan is not displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/// "Select any sub plan from (Medical,Dental,Medicare)"///
	public void selectPlan() throws InterruptedException {
		try {
			WaitForPageLoad();
			WaitForLoadAnimationDisappear();
			if (ElementDisplayed(selectPlan)) {
				Log.info("Select plan button is displayed");
				waitForElementClickable(selectPlan);
				jsClick(selectPlan);
				ExtentSuccessMessage("Successfully selected the sub plan");
			} else {
				// Ramya - 9/28 - if block
				if (waitForElementVisible(planChevron).getAttribute("class").toLowerCase().contains("down")) {

					click(planChevron);
					Thread.sleep(2000);

					if (ElementDisplayed(selectPlan)) {
						Log.info("Select plan button is displayed");
						waitForElementClickable(selectPlan);
						jsClick(selectPlan);
						ExtentSuccessMessage("Successfully selected the sub plan");
					}
					else {

						Log.error("Select plan button is not displayed");
						ExtentErrorMessage("Select plan button is not displayed");
					}
				} 
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/// "Click Cancel Button"///
	public void clickCancel() throws InterruptedException {
		try {
			WaitForPageLoad();
			if (ElementDisplayed(clickCancel)) {
				Log.info("Cancel button is displayed");
				scrollDown();
				waitForElementClickable(clickCancel);
				click(clickCancel);
				ExtentSuccessMessage("Successfully clicked the cancel button");
			} else {
				Log.error("Cancel button is not displayed");
				ExtentErrorMessage("Cancel button is not displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/// "Click Next Button"///
	public void clickNext() throws InterruptedException {
		try {
			WaitForPageLoad();
			waitForElementVisible(clickNext);
			if (ElementDisplayed(clickNext)) {
				Log.info("Next button is displayed");
				scrollDown();
				waitForElementClickable(clickNext);
				click(clickNext);
				ExtentSuccessMessage("Successfully clicked the Next button");
			} else {
				Log.error("Next button is not displayed");
				ExtentErrorMessage("Next button is not displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickSubmit() throws InterruptedException {
		try {
			WaitForPageLoad();
			Thread.sleep(5000);
			WaitForLoadAnimationDisappear();
			waitForElementVisible(clickSubmit);
			if (ElementDisplayed(clickSubmit)) {
				Log.info("Submit button is displayed");
				waitForElementClickable(clickSubmit);
				jsClick(clickSubmit);
				ExtentSuccessMessage("Successfully clicked the Submit button");
			} else {
				Log.error("Submit button is not displayed");
				ExtentErrorMessage("Submit button is not displayed");
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
