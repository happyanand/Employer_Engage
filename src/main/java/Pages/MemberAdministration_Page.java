package Pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class MemberAdministration_Page extends Base_Class
 
{
		private static By memberAdministrationHeader= By.xpath("//a[contains(text(),'Member Administration')]");
	    private static By action=By.id("Transinput_chzn");
	    private static By searchMore=By.id("btnAdvancedToggle");
	    private static By enterssn=By.id("SSN_mask");
	    private static By search=By.id("btnSearchFor_MemberInfo_Advanced");
	    private static By memberId=By.id("individualmemberid");
	    private static By submit=By.xpath("//input[contains(@class,'UpdateMemberID')]");
	    private static By clickUpdateStatus = By.xpath("//a[@class='btn btn-sm btn-default btn_statusUpdate']");
	    private static By clickok = By.xpath("//*[@id=\"btnPopUpSuccessResponseOk\"]");
	    private static By firstName=By.id("FirstName");

//Reports page displayed
//@Attachment
public Boolean isMemberAdministrationPageDisplayed() throws InterruptedException{
    WaitForPageLoad();
    return ElementDisplayed(memberAdministrationHeader);
}

//Update Member Id
	public void updateMemberId(String ssnnumber) throws InterruptedException{
		ExtentSuccessMessage("Successfully Entered in to UpdateMemberId Method");
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(action)) {
			  selectComboBoxValue(action,"Update Member Id");
			  ExtentSuccessMessage("Successfully selected Update Member Id in Action Type");
		      click(searchMore);
		      ExtentSuccessMessage("Successfully clicked Search More");
		      click(enterssn);
		      input(enterssn,ssnnumber);
		      ExtentSuccessMessage("Successfully entered SSN number in the field ");
		      click(search);
		      ExtentSuccessMessage("Successfully clicked on Search Button");
		      input(memberId, randomNumber(5) + "" + randomNumber(6));
		      ExtentSuccessMessage("Successfully entered MemberId");
		      click(submit);
		      ExtentSuccessMessage("Successfully clicked Submit button");
			} 
		  else 
		  {
			Log.error("Update Member ID process is unsuccessful");
			ExtentErrorMessage("Update Member ID process is unsuccessful");
		  }
		} 
	catch (Exception e) 
			{
		  // Handle the exception
		  System.out.println("An exception occurred: " + e.getMessage());
		  e.printStackTrace();
		}
	    
	}
	
//UpdateSuccessResponse
	public void UpdateSuccessResponse(String ssnnumber) throws InterruptedException, AWTException {
		ExtentSuccessMessage("Successfully Entered in to UpdateSuccessResponse Method");
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(action)) {
   			  selectComboBoxValue(action,"UpdateSuccessResponse");
   			  ExtentSuccessMessage("Successfully selected Update Success Response in Action Type");
			  click(searchMore);
			  ExtentSuccessMessage("Successfully clicked Search More");
			  click(enterssn);
			  input(enterssn, ssnnumber);
			  ExtentSuccessMessage("Successfully entered SSN number in the field ");
			  WaitForElementToBeVisible(search);
			  jsClick(search);
			  ExtentSuccessMessage("Successfully clicked on Search Button");
			  WaitForPageLoad();
			  click(clickUpdateStatus);
			  ExtentSuccessMessage("Successfully clicked on Update Status");
			  click(clickok);
			  ExtentSuccessMessage("Succseefully clicked on Ok button");
		    }
		  else 
		  {
			Log.error("Update Success Response process is unsuccessful");
			ExtentErrorMessage("Update Success Response process is unsuccessful");
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