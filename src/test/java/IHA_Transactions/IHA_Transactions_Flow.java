package IHA_Transactions;

import Pages.Home_Page;
import Pages.Transactions_Page;

public class IHA_Transactions_Flow {
	
	Home_Page Home_Page=new Home_Page();
	Transactions_Page transactions=new Transactions_Page();
	
	public void ValidateIHA_Transactions_Flow(String testScenario) throws InterruptedException {
		
		//Click Transactions Tab
		Home_Page.clickTransactionsTab();
		//Click on the Failed Checkbox
		transactions.clickFailedStatus();
		//Click on the Failed Checkbox
		transactions.clickPendingStatus();
		//Search for the New Transactions Type
		transactions.searchTransactionType("New");
		//Click on the Transaction Details Label
		transactions.clickTransactionDetails();
		//Fetch the Transaction Type value from the Pop-up
		transactions.fetchTransactionTypeValue();
		//Click on the OUT_XML file
		transactions.clickOUT_XML();
		//Click on the IN_XML file
		transactions.clickIN_XML();
		//Click on the IN_XML_PGP
		transactions.clickIN_XML_PGP();
		//Click on the Close Icon
		transactions.clickCloseIcon();
		//Search for the New Transactions Type
		transactions.searchTransactionType("Renewal");
		//Click on the Transaction Details Label
		transactions.clickTransactionDetails();
		//Fetch the Transaction Type value from the Pop-up
		transactions.fetchTransactionTypeValue();
		//Click on the OUT_XML file
		transactions.clickOUT_XML();
		//Click on the IN_XML file
		transactions.clickIN_XML();
		//Click on the IN_XML_PGP
		transactions.clickIN_XML_PGP();
		//Click on the Close Icon
		transactions.clickCloseIcon();
		//Search for the New Transactions Type
		transactions.searchTransactionType("Multi Transaction");
		//Click on the Transaction Details Label
		transactions.clickTransactionDetails();
		//Fetch the Transaction Type value from the Pop-up
		transactions.fetchTransactionTypeValue();
		//Click on the OUT_XML file
		transactions.clickOUT_XML();
		//Click on the IN_XML file
		transactions.clickIN_XML();
		//Click on the IN_XML_PGP
		transactions.clickIN_XML_PGP();
		//Click on the Close Icon
		transactions.clickCloseIcon();
		
		
	}

}
