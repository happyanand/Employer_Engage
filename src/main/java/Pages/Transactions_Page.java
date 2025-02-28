package Pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class Transactions_Page extends Base_Class{
	
	private static By L_AccountTransactions = By.xpath("//a[.='Account Transactions']");
	private static By L_MemberTransactions = By.xpath("//a[contains(.,'Member Transactions')]");
	private static By L_Success = By.xpath("//*[@id=\"Transaction-success\"]");
	private static By L_Failed = By.xpath("//*[@id=\"Transaction-failed\"]");
	private static By L_Pending = By.xpath("//*[@id=\"Transaction-pending\"]");
	private static By L_SearchBar = By.xpath("//input[@class='form-control']");
	private static By L_Searchicon = By.xpath("//span[@class='md-search-btn hr-theme-bg']/i[@class='material-icons']");
	private static By L_TransactionsDetails = By.xpath("//div[@class='table-responsive']//tr[1]//i[@class='material-icons theme-text font-md']");
	private static By L_TransactionTypeValue = By.xpath("//div[@class=\"modal-body\"]/label[text()=\" Transaction Type :\"]/following-sibling::text()[1]");
	private static By L_OUT_XML = By.xpath("//a[contains(@class, 'btn-link') and contains(text(), '_OUT.xml')]");
	private static By L_IN_XML = By.xpath("(//a[@class='btn-link'])[3]");
	private static By L_IN_XML_PGP = By.xpath("//a[contains(@class, 'btn-link') and contains(text(), '_T_IN.XML.PGP')]");
	private static By L_clickCloseIcon = By.xpath("//div[@class='modal-dialog modal-lg']//i[@class='material-icons']");
		
	
	/////Click Account Transactions/////
	public void clickAccountTransactionsTab() throws InterruptedException 
	{	
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(L_AccountTransactions))
			  { 
				Log.info("Account Transactions Tab is displayed");
				waitForElementClickable(L_AccountTransactions);
				click(L_AccountTransactions);
				ExtentSuccessMessage("Successfully clicked the Account Transactions Tab");
			  } 
			  else 
			  {
				Log.error("Account Transactions Tab is not displayed");
				ExtentErrorMessage("Account Transactions Tab is not displayed");
			  }
			} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
	
	/////Click Member Transactions/////
	public void clickMemberTransactionsTab() throws InterruptedException 
	{	
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(L_MemberTransactions))
			  { 
				Log.info("Member Transactions Tab is displayed");
				waitForElementClickable(L_MemberTransactions);
				click(L_MemberTransactions);
				ExtentSuccessMessage("Successfully clicked the Member Transactions Tab");
			  } 
			  else 
			  {
				Log.error("Member Transactions Tab is not displayed");
				ExtentErrorMessage("Member Transactions Tab is not displayed");
			  }
			} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
	
	/////Click Success Status Checkbox/////
	public void clickSuccessStatus() throws InterruptedException 
	{	
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(L_Success))
			  { 
				Log.info("Success Status checkbox is displayed");
				WaitForLoadAnimationDisappear();
				waitForElementClickable(L_Success);
				click(L_Success);
				ExtentSuccessMessage("Successfully clicked the Success Status checkbox");
			  } 
			  else 
			  {
				Log.error("Success Status checkbox is not displayed");
				ExtentErrorMessage("Success Status checkbox is not displayed");
			  }
			} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
	
	/////Click Failed Status Checkbox/////
	public void clickFailedStatus() throws InterruptedException 
	{	
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(L_Failed))
			  { 
				Log.info("Failed Status checkbox is displayed");
				WaitForLoadAnimationDisappear();
				//waitForElementClickable(L_Failed);
				jsClick(L_Failed);
				ExtentSuccessMessage("Successfully clicked the Failed Status checkbox");
			  } 
			  else 
			  {
				Log.error("Failed Status checkbox is not displayed");
				ExtentErrorMessage("Failed Status checkbox is not displayed");
			  }
			} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
	
	/////Click Pending Status Checkbox/////
	public void clickPendingStatus() throws InterruptedException 
	{	
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(L_Pending))
			  { 
				Log.info("Pending Status checkbox is displayed");
				WaitForLoadAnimationDisappear();
				//waitForElementClickable(L_Pending);
				jsClick(L_Pending);
				ExtentSuccessMessage("Successfully clicked the Pending Status checkbox");
			  } 
			  else 
			  {
				Log.error("Pending Status checkbox is not displayed");
				ExtentErrorMessage("Pending Status checkbox is not displayed");
			  }
			} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
	
	/////Search Transactions Type/////
	public void searchTransactionType(String Value) throws InterruptedException 
	{	
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(L_SearchBar))
			  { 
				Log.info("Search Bar is displayed");
				waitForElementClickable(L_SearchBar);
				clear(L_SearchBar);
				input(L_SearchBar,Value);
				click(L_Searchicon);
				WaitForLoadAnimationDisappear();
				ExtentSuccessMessage("Successfully searched the Transaction Type: "+ Value);
			  } 
			  else 
			  {
				Log.error("Search Bar is not displayed");
				ExtentErrorMessage("Search Bar is not displayed");
			  }
			} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
	
	/////Click on the Transaction Details Label/////
	public void clickTransactionDetails() throws InterruptedException 
	{	
		try {
			  WaitForPageLoad();
			  scrollUpVertically();
			  if(ElementDisplayed(L_TransactionsDetails))
			  { 
				Log.info("Transaction Details Label is displayed");
				waitForElementClickable(L_TransactionsDetails);
				click(L_TransactionsDetails);
				ExtentSuccessMessage("Successfully clicked the Transaction Details Label");
			  } 
			  else 
			  {
				Log.error("Transaction Details Label is not displayed");
				ExtentErrorMessage("Transaction Details Label is not displayed");
			  }
			} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
	
	
	public void fetchTransactionTypeValue() throws InterruptedException 
	{	
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(L_TransactionTypeValue))
			  { 
				Log.info("Transaction Type value is displayed");
				String trans_type_value = findElement(L_TransactionTypeValue).getText();
				ExtentSuccessMessage("Successfully fetched Transaction Type value: "+trans_type_value);
			  } 
			  else 
			  {
				Log.error("Transaction Type value is not displayed");
				ExtentErrorMessage("Transaction Type value is not displayed");
			  }
			} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
	
	/////Click the OUT_XML file/////
	public void clickOUT_XML() throws InterruptedException 
	{	
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(L_OUT_XML))
			  { 
				Log.info("OUT_XML file is displayed");
				waitForElementClickable(L_OUT_XML);
				click(L_OUT_XML);
				ExtentSuccessMessage("Successfully clicked the OUT_XML file");
			  } 
			  else 
			  {
				Log.error("OUT_XML file is not displayed");
				ExtentErrorMessage("OUT_XML file is not displayed");
			  }
			} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
	
	/////Click the IN_XML file/////
	public void clickIN_XML() throws InterruptedException 
	{	
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(L_IN_XML))
			  { 
				Log.info("IN_XML file is displayed");
				waitForElementClickable(L_IN_XML);
				click(L_IN_XML);
				ExtentSuccessMessage("Successfully clicked the IN_XML file");
			  } 
			  else 
			  {
				Log.error("IN_XML file is not displayed");
				ExtentErrorMessage("IN_XML file is not displayed");
			  }
			} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
	
	/////Click the IN_XML_PGP file/////
	public void clickIN_XML_PGP() throws InterruptedException 
	{	
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(L_IN_XML_PGP))
			  { 
				Log.info("IN_XML_PGP file is displayed");
				waitForElementClickable(L_IN_XML_PGP);
				click(L_IN_XML_PGP);
				ExtentSuccessMessage("Successfully clicked the IN_XML_PGP file");
			  } 
			  else 
			  {
				Log.error("IN_XML_PGP file is not displayed");
				ExtentErrorMessage("IN_XML_PGP file is not displayed");
			  }
			} 
		catch (Exception e) 
	 		{
			  // Handle the exception
			  System.out.println("An exception occurred: " + e.getMessage());
			  e.printStackTrace();
			}
	}
	
	/////Click on Close Icon
	public void clickCloseIcon() throws InterruptedException 
	{	
		try {
			  WaitForPageLoad();
			  if(ElementDisplayed(L_clickCloseIcon))
			  { 
				Log.info("Close Icon file is displayed");
				waitForElementClickable(L_clickCloseIcon);
				click(L_clickCloseIcon);
				ExtentSuccessMessage("Successfully clicked the Close Icon");
			  } 
			  else 
			  {
				Log.error("Close Icon is not displayed");
				ExtentErrorMessage("Close Icon is not displayed");
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
