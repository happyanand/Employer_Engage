package Pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class EmployeeAdministration_Page extends Base_Class {
	public static By EmployeeAdministrationHeader = By.xpath("//h4[text()='Employee Administration']");
	public static By EmployeeSearchHeader = By.xpath("//h4[text()='Employee Search ']");

	public static By txtKeywordSearch = By.xpath("//input[@id='btnKeyWordSearch1']");
	public static By btnKeywordSearch = By.xpath("//button[@id='btnKeyWordSearch1']");
	public static By nameInGrid = By.xpath("//a[@class='divRedirectGrid name']/u");
	public static By addEmployee = By.xpath("//a[@class='AddEmployee']");

	public static By grid = By.xpath("//table[@class='table Result-grid table-striped']");
	public static By checkbox = By.xpath("//input[@class='checkEmployee Chk_lstView']|//input[@title='Select employee']");
	public static By requestonlineaccess = By.xpath("//i[normalize-space()='chrome_reader_mode']");
	public static By btn_ok = By.id("btnCloseModal");

//"Employee Administration page displayed"
	public Boolean isEmployeeAdministrationPageDisplayed() throws InterruptedException {
		WaitForPageLoad();
		return ElementDisplayed(EmployeeAdministrationHeader);
	}

//"Search for the Employee"
	public void searchEmployee(String name) throws InterruptedException {
		try {
			WaitForPageLoad();
			click(txtKeywordSearch);
			input(txtKeywordSearch, name);
			ExtentSuccessMessage("Successfully Enter txt Keyword Search ");
			click(btnKeywordSearch);
			ExtentSuccessMessage("Successfully Clicked On txt Keyword Search Button ");
			WaitForPageLoad();
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

//"Search and navigate to the Employee Info"
	public void searchAndNavigateToEmployeeInfo(String ssn) throws InterruptedException {
		try {
			WaitForLoadAnimationDisappear();
			// Ramya
			WaitForPageLoad();
//			input(txtKeywordSearch, ssn);
//			click(btnKeywordSearch);
			searchEmployee(ssn);
			waitUntilSearchCompletesInWebTable(grid);
			jsClick(nameInGrid);
//			String Name = getNameInGrid();
//			System.out.println("Fetching name "+Name);
			Log.info("Successfully search and navigate to employee info");
			ExtentSuccessMessage("Successfully search and navigate to employee info");
		} catch (Exception e) {
			Log.error("Failed to search and navigate to employee info");
			ExtentErrorMessage("Failed to search and navigate to employee info");
		}
	}

//"Get name from the first row in Grid"
	public String getNameInGrid() throws InterruptedException {

		// Ramya
		// WaitForPageLoad();
		waitUntilSearchCompletesInWebTable(grid);
		return GetElementText(nameInGrid);
	}

//"Click on Add Employee"
	public void clickAddEmployee() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(addEmployee);
			Log.info("Successfully Clicked On  AddEmployee");
			ExtentSuccessMessage("Successfully Clicked On  AddEmployee ");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public boolean isEmployeeSearchPageDisplayed() throws InterruptedException {
		WaitForPageLoad();
		return ElementDisplayed(EmployeeSearchHeader);
	}
	
//Click CheckBox
	public void checkbox() throws InterruptedException {
		try {
			WaitForLoadAnimationDisappear();
			waitForElementClickable(checkbox);
			Thread.sleep(5000);
			jsClick(checkbox);
			ExtentSuccessMessage("Successfully Clicked On Checkbox");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
//Request Online Access
	public void requestOnlineAccess() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(requestonlineaccess);
			WaitForPageLoad();
			WaitForPageLoad();
			click(btn_ok);
			ExtentSuccessMessage("Successfully Clicked On Request Online Access ");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
