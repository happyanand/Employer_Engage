package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import com.BasePackage.Base_Class;
import com.Utility.Log;

public class ViewBenefits_Page extends Base_Class {
	
	private static By clickViewBenefits = By.xpath("//div[@id='PresentCont_1']//a[contains(@class,'lnkViewBenefits')][normalize-space()='View Benefits']");

	private static By clickClose = By.xpath(" //*[@id=\"btnCloseModal\"]");
	
	private static By clickviewSBC = By.xpath("//a[@class='view_more DownloadFileOrUrl']|//div[@id='PresentCont_1']//i[@class='fa fa-download']");


	///"click View Benefits"///
	public void clickViewBenefits() throws InterruptedException
	{   
		try {
			  WaitForPageLoad();
			  //Ramya - 9/27
			// ScrollUntilElementVisible(clickViewBenefits);
			  WaitForLoadAnimationDisappear();
			  
			 
			  if(ElementDisplayed(clickViewBenefits)) 
			  {
				Log.info("View benefits button is displayed");
				waitForElementClickable(clickViewBenefits);
			    click(clickViewBenefits);
			    Thread.sleep(3000);
			    ExtentSuccessMessage("Successfully clicked on the View Benefits button");
			  } 
			  else 
			  {
				Log.error("View benefits button is not displayed");
				ExtentErrorMessage("View benefits button is not displayed");
			  }
			} 
		catch (Exception e) 
			{
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	///"View Benefits page click Close Button"///
	public void clickClose() throws InterruptedException
	{	
		try {
			  WaitForPageLoad();
			  ScrollUntilElementVisible(clickClose);
			  if(ElementDisplayed(clickClose)) 
			  {
				Log.info("Close button is displayed");
				waitForElementClickable(clickClose);
			    click(clickClose);
			    ExtentSuccessMessage("Successfully clicked on the Close button");
			  } 
			  else 
			  {
				Log.error("Close button is not displayed");
				ExtentErrorMessage("Close button is not displayed");
			  }
			} 
		catch (Exception e) 
			{
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}
	
	///View Benefits page click View SBC")///
	public void clickViewSBC() throws InterruptedException
	{	
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(clickviewSBC))
			  {
				Log.info("Successfully Clicked On View SBC");
				waitForElementClickable(clickviewSBC);
				click(clickviewSBC);
				Log.info("Successfully Clicked On View SBC");
				ExtentSuccessMessage("Successfully Clicked on View SBC");
			  }	
			  else 
			  {
					Log.error("Successfully Clicked On View SBC");
					ExtentErrorMessage("Successfully Clicked on View SBC");
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
