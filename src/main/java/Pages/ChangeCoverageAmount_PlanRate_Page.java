package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.BasePackage.Base_Class;
import com.Utility.Log;


public class ChangeCoverageAmount_PlanRate_Page extends Base_Class 
{

	private static By QualifyingEvent= By.id("Item1_QualifyingEvent_QualifyingEventName_chzn");

	private static By EffectiveDate= By.xpath("//input[@id='Item1_EffectiveDate']");

	private static By clickPlan = By.xpath("//h4[@class='panel-title']");

	private static By selectEmployeeCoverageAmount= By.id("Item1_ProductLst_0__EmployeeCoverageAmount");

	private static By monthly_Rate = By.xpath("//*[@class='premium_cart_section tick_active']//*[contains(@id,'Div_CaptureAmount')]//input[contains(@id,'ProductLst')]");//div[@id='Div_CaptureAmountInUI_788525']//input[contains(@id,'ProductLst')] ");
	//private static By monthly_Rate = By.xpath("//div[@id='Div_CaptureAmountInUI_888361']//input[contains(@id,'ProductLst')]"); There your using ID and Id is different for all the plans

	private static By yearly_Rate = By.xpath("//*[@id=\"Item1_ProductLst_0__YearlyDeposit\"]");

	public static By selectPlan = By.xpath("//label[@class='btn btn-default addtoselect Yesnoclass']");

	private static By clickCancel = By.xpath("//*[@id=\"divCancel\"]");

	private static By clickNext= By.xpath("//span[@id='BtnChangePlanGotoProfile']");

	public static By clickSubmit = By.xpath("//span[@id='BtnSubmitChangePlan']");

	public static By TotalPremiumSlide =By.xpath("//*[@class='handle sub-theme-bg hover-highlighted selected']");

	///"Select Qualifying Event"///
	public void selectQualifyingEvent() throws InterruptedException 
	{
		try {
			WaitForPageLoad();
			WaitForElementToBeVisible(QualifyingEvent);
			if(ElementDisplayed(QualifyingEvent)) 
			{
				Log.info("Qualifying Event dropdown is displayed");
				//waitForElementSelectable(QualifyingEvent);
				selectByRandom(QualifyingEvent);
				ExtentSuccessMessage("Successfully selected the Qualifying Event");
			} 
			else 
			{
				Log.error("Qualifying Event dropdown is not displayed");
				ExtentErrorMessage("Qualifying Event dropdown is not displayed");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	///"Enter the Effective date"///
	public void enterEffectiveDate(String date) throws InterruptedException 
	{	
		try {
			WaitForPageLoad();
			if(ElementDisplayed(EffectiveDate)) 
			{
				Log.info("Effective Date is displayed");
				waitForElementClickable(EffectiveDate);
				click(EffectiveDate);
				input(EffectiveDate, date);
				findElement(EffectiveDate).sendKeys(Keys.TAB);
				Log.info("Successfully entered the Effective Date "+date);
				ExtentSuccessMessage("Successfully entered the Effective Date "+date);
			} 
			else 
			{
				Log.error("Effective Date is not displayed");
				ExtentErrorMessage("Effective Date is not displayed");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	///"Select any plan (Medical,Dental,Medicare)"///
	public void clickPlan() throws InterruptedException 
	{	
		try {
			WaitForLoadAnimationDisappear();
			waitForElementVisible(clickPlan);
			WaitForLoadAnimationDisappear();
			if(ElementDisplayed(clickPlan))
			{
				Log.info("Plan is displayed");
				waitForElementClickable(clickPlan);
				jsClick(clickPlan);
				ExtentSuccessMessage("Successfully selected the Plan");
			} 
			else 
			{
				Log.error("Plan is not displayed");
				ExtentErrorMessage("Plan is not displayed");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	///"Change Coverage Amount"///
	public void ChangeCoverageAmount() throws InterruptedException
	{	
		try {
			WaitForLoadAnimationDisappear();
			if(ElementDisplayed(selectEmployeeCoverageAmount))
			{
				Log.info("Coverage Amount is displayed");
				waitForElementSelectable(selectEmployeeCoverageAmount);
				selectByIndex(selectEmployeeCoverageAmount,2);
				//	WaitForPageLoad();
				WaitForLoadAnimationDisappear();
				if(!driver.findElement(selectPlan).isSelected())
					//Asif We dont have to click on Select plan  02/FEB/2024
					//if (!URL.equalsIgnoreCase("Speridian_URL"))
					waitForElementClickable(selectPlan);
				jsClick(selectPlan);
				ExtentSuccessMessage("Successfully changed the coverage amount");
			} 
			else 
			{
				Log.error("Coverage Amount is not displayed");
				ExtentErrorMessage("Coverage Amount is not displayed");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}


	///"Select Plan"///
	public void changePlanMonthlyRate(String editedAmount) throws InterruptedException
	{	
		try {
			WaitForPageLoad();
			ScrollUntilElementVisible(monthly_Rate);
			if(ElementDisplayed(monthly_Rate))
			{ 
				Log.info("Monthly/Yearly Cost is displayed");
				ExtentSuccessMessage("Monthly/Yearly Cost is displayed");
				WaitForPageLoad();
				WaitForElementToBeVisible(monthly_Rate);
				clear(monthly_Rate);
				WaitForLoadAnimationDisappear();
				Log.info("Successfully cleared the old Monthly/Yearly amount");
				ExtentSuccessMessage("Successfully cleared the old Monthly/Yearly amount");
				scrollUpVertically();
				WaitForElementToBeVisible(monthly_Rate);
				click(monthly_Rate);
				Log.info("Successfully clicked the new Monthly/Yearly amount");
				ExtentSuccessMessage("Successfully clicked the new Monthly/Yearly amount");
				Thread.sleep(5000);
				input(monthly_Rate,editedAmount + Keys.TAB);
				Log.info("Successfully entered the new Monthly/Yearly amount");
				ExtentSuccessMessage("Successfully entered the new Monthly/Yearly amount");
			} 
			else 
			{
				Log.error("Monthly/Yearly Cost is not displayed");
				ExtentErrorMessage("Monthly/Yearly Cost is not displayed");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void changePlanYearlyRate(String editedAmount) throws InterruptedException
	{	
		try {
			WaitForPageLoad();
			Thread.sleep(3000);
			ScrollUntilElementVisible(yearly_Rate);
			if(ElementDisplayed(yearly_Rate))
			{ 
				Log.info("Monthly/Yearly Cost is displayed");
				WaitForPageLoad();
				WaitForElementToBeVisible(yearly_Rate);
				clear(yearly_Rate);
				//				RobotKeyOperation("BACKSPACE");
				Thread.sleep(8000);
				WaitForLoadAnimationDisappear();
				ExtentSuccessMessage("Successfully cleared the old Monthly/Yearly amount");
				Log.info("Successfully cleared the old Monthly/Yearly amount");
				waitForElementClickable(clickPlan);
				WaitForLoadAnimationDisappear();
				click(clickPlan);
				ExtentSuccessMessage("Successfully clicked the Plan");
				Log.info("Successfully clicked the Plan");
				Thread.sleep(8000);
				Zoomout(1);
				//				ScrolltillElementOnmiddlepage(yearly_Rate);
				//				ScrollUntilElementVisible(yearly_Rate);
				//				jsClick(yearly_Rate);
				//				scrollDown();
				clickAndInput(yearly_Rate, editedAmount);
				findElement(yearly_Rate).sendKeys(Keys.TAB);
				Log.info("Successfully entred the new Monthly/Yearly amount");
				ExtentSuccessMessage("Successfully entred the new Monthly/Yearly amount");
				Thread.sleep(3000);
			} 
			else 
			{
				Log.error("Monthly/Yearly Cost is not displayed");
				ExtentErrorMessage("Monthly/Yearly Cost is not displayed");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	///"Click Cancel Button"///
	public void clickCancel() throws InterruptedException 
	{	
		try {
			WaitForPageLoad();
			if(ElementDisplayed(clickCancel))
			{ 
				Log.info("Cancel button is displayed");
				scrollDown();
				waitForElementClickable(clickCancel);
				click(clickCancel);
				ExtentSuccessMessage("Successfully clicked the cancel button");
			} 
			else 
			{
				Log.error("Cancel button is not displayed");
				ExtentErrorMessage("Cancel button is not displayed");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}	

	///"Click Next Button"///
	public void clickNext() throws InterruptedException {	
		try {
			WaitForPageLoad();
			if(ElementDisplayed(clickNext))
			{ 
				Log.info("Next button is displayed");
				scrollDown();
				waitForElementClickable(clickNext);
				jsClick(clickNext);
				ExtentSuccessMessage("Successfully clicked the Next button");
			} 
			else 
			{
				Log.error("Next button is not displayed");
				ExtentErrorMessage("Next button is not displayed");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	public void clickSubmit() throws InterruptedException 
	{	
		try {
			WaitForPageLoad();
			Thread.sleep(3000);
			if(ElementDisplayed(clickSubmit))
			{ 
				Log.info("Submit button is displayed");
				scrollDown();
				waitForElementClickable(clickSubmit);
				click(clickSubmit);
				ExtentSuccessMessage("Successfully clicked the Next button");
			} 
			else 
			{
				Log.error("Submit button is not displayed");
				ExtentErrorMessage("Submit button is not displayed");
			}
		} 
		catch (Exception e) 
		{
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
