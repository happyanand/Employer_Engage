package Pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.*;


public class CorrespondenceLetters_Page extends Base_Class
{	
	//CT - Correspondence Type
	private static By clickCTdropdown = By.xpath("//*[@id=\"CorrespondenceType_chzn\"]/a/div/b");
	
	//CT - Correspondence Type
	private static By selectCTAllstatus = By.xpath("//*[@id='CorrespondenceType_chzn_o_1']");
	
	//AS - Advanced Search
	private static By clickASdropdown = By.xpath("//*[@id='FormCorrespondance']/ul/li[2]/button");
	
	//AS - Advanced Search
	private static By ClickASStatusdropdown = By.xpath("//*[@id=\"DispatchStatus_chzn\"]/a");
	
	private static By selectALLstatus = By.xpath("//*[@id=\"DispatchStatus_chzn_o_1\"]");
	
	//AS - Advanced Search
	public static By clickASsearchbutton = By.xpath("//input[@id='btnCorrespondenceSearchAdvanced']");
	
	private static By clickCCLDocName = By.xpath("//*[@id=\"DownloadDoc\"]/u");
    
	//AS - Advanced Search
    public static By ASssnsearch = By.xpath("//*[@class=\"ssnmask tb1\"]");


    ///"Click Correspondence Type"///
    public void selectCTALLstatus() throws InterruptedException
    {	
    	try {
			  WaitForPageLoad();
			  if(ElementDisplayed(clickCTdropdown)) 
			  {	
				Log.info("Correspondance Type dropdown is displayed");
				WaitForPageLoad();
				Thread.sleep(3000);
				//Click on the Correspondence type dropdown
			    MouseHoverOnElement(clickCTdropdown);
			    click(clickCTdropdown);
			    ExtentSuccessMessage("Successfully clicked the Correspondance Dropdown");
			    //Select the Correspondence type as "ALL" from the list
			    WaitForPageLoad();
			    MouseHoverOnElement(selectCTAllstatus);
			    click(selectCTAllstatus);
			    ExtentSuccessMessage("Successfully clicked the Correspondance type");
			  }
			  else 
			  {
				Log.error("Correspondance Type dropdown is not displayed");
				ExtentErrorMessage("Correspondance Type dropdown is not displayed");
			  }
			} 
		catch (Exception e) 
			{
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

    ///"Select Status in the Advanced search dropdown"///
	public void selectASALLstatus() throws InterruptedException
	{	
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(clickASdropdown)) 
			  {	
				Log.info("Advanced Search is displayed");
				Thread.sleep(3000);
				//Click on the Advanced Search Dropdown.
			    MouseHoverOnElement(clickASdropdown);
			    click(clickASdropdown);
			    ExtentSuccessMessage("Successfully clicked the Advanced search Dropdown");
			    //Click on the Status dropdown in the Advanced Search.
			    click(ClickASStatusdropdown);
			    ExtentSuccessMessage("Successfully clicked the Status Dropdown");
			    //Select the Status "ALL" in the Status dropdown.
			    WaitForPageLoad();
			    MouseHoverOnElement(selectALLstatus);
			    click(selectALLstatus);
			    ExtentSuccessMessage("Successfully clicked on the Status");
			    //Click on the search button in the Advanced search section.
			    MouseHoverOnElement(clickASsearchbutton);
			    click(clickASsearchbutton);
			    ExtentSuccessMessage("Successfully clicked the Advanced search Button");
			  }
			  else 
			  {
				Log.error("Advanced Search is not displayed");
				ExtentErrorMessage("Advanced Search is not displayed");
			  }
			} 
		catch (Exception e) 
			{
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
			 
	}
	
	///"Search for the employee using the SSN number"///
	public void ASsearchemployee(String  ssn) throws InterruptedException
	{	
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(clickASdropdown)) 
			  {	
				Log.info("Advanced Search is displayed");
			    Thread.sleep(3000);
			    //Click on the Advanced Search Dropdown.
			    MouseHoverOnElement(clickASdropdown);
			    click(clickASdropdown);
			    ExtentSuccessMessage("Successfully clicked the Advanced search Dropdown");
			    //Click on the Status dropdown in the Advanced Search.
			    click(ClickASStatusdropdown);
			    ExtentSuccessMessage("Successfully clicked the Status Dropdown");
			    //Select the Status "ALL" in the Status dropdown.
			    WaitForPageLoad();
			    MouseHoverOnElement(selectALLstatus);
			    click(selectALLstatus);
			    ExtentSuccessMessage("Successfully clicked on the Status");
			    //Click on the SSN search dropdown and enter the SSN number of the Employee.
			    WaitForPageLoad();
			    click(ASssnsearch);
				inputSSN(ASssnsearch,ssn);
			    ExtentSuccessMessage("Successfully searched the Employee");
			    //Click on the search button in the Advanced search section.
			    MouseHoverOnElement(clickASsearchbutton);
			    click(clickASsearchbutton);
			    ExtentSuccessMessage("Successfully clicked the Advanced search Button");
			  }
			  else 
			  {
				Log.error("Advanced Search is not displayed");
				ExtentErrorMessage("Advanced Search is not displayed");
			  }
			} 
		catch (Exception e) 
			{
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}

	///"Click on the Document to download"///
	public void clickDocument() throws InterruptedException
	{	
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(clickCCLDocName)) 
			  {	
				Log.info("Document is displayed");
				Thread.sleep(7000);
			    click(clickCCLDocName);
			    Thread.sleep(6000);
			  }
			  else 
			  {
				Log.error("Document is not displayed");
				ExtentErrorMessage("Document is not displayed");
			  }
			} 
		catch (Exception e) 
			{
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
	}
	
	public boolean validateDocumentName(String CustomerNo, String lastname, String LetterType) {
        // Construct the document name based on dynamic values
        String documentName = "66223_056_" + CustomerNo + "_" + lastname + "_" +LetterType+"_" + getCurrentDate() + "_060951.pdf";
        // Define the regex pattern
        String pattern = "66223_056_"+ CustomerNo+"_" + lastname +"_"+LetterType+"_" + getCurrentDate() + "_\\d{6}\\.pdf";
        // Compile the regex pattern
        Pattern regex = Pattern.compile(pattern);
        // Create a matcher for the document name
        Matcher matcher = regex.matcher(documentName);
        // Check if the matcher finds a match
        boolean isValid = matcher.matches();
        if (isValid) {
            System.out.println("Document name is valid: " + documentName);
            ExtentSuccessMessage("Successfully Validated the Document name with Proper naming convention");
            ExtentSuccessMessage("Document name is: " + documentName);
            
        } else {
            System.out.println("Document name is not valid: " + documentName);
            ExtentErrorMessage("Validation Unsuccessful as  the Document name is not proper");
            ExtentSuccessMessage("Document name is: " + documentName);
        }
        
        return isValid;   
    }
	
	
	public String getCurrentDate() {
        // Get the current date in the desired format (ddMMyyyy)
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        return dateFormat.format(new Date());
    }

}
