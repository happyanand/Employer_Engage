package Pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;


public class ManageCoverage_Page extends Base_Class
{
	private static By manageCoverageHeader= By.xpath("//h4[text()='Member Search']");
	
	private static By txtKeywordSearch = By.xpath("//input[@id='btnKeyWordSearch2']");

	private static By btnKeywordSearch = By.xpath("//button[@id='btnKeyWordSearch']");

	private static By clickName = By.xpath("//div[@id='div_ListView']/table/tbody/tr/td[2]/a");
	
	private static By L_EnrollmentNotification = By.xpath("//i[normalize-space()='speaker_notes']");
	
	private static By effectivedate = By.xpath("//input[@id='enrollnotifdatepicker']");
	
	private static By txt_notification = By.xpath("//textarea[@id='txtNotificationText']");
	
	private static By btn_send = By.xpath("//input[@id='btnSendEnrollmentNotify']");
	
	private static By btn_ok = By.xpath("//*[@id='btnCloseModal']");
	

//Manage Coverage page displayed
	public Boolean isManageCoveragePageDisplayed() throws InterruptedException{
		WaitForPageLoad();
	    return ElementDisplayed(manageCoverageHeader);
	}

	//Search for the Employee and navigate to Employee
	public void searchEmployee(String ssn) throws InterruptedException {
		Thread.sleep(1000);
		ExtentSuccessMessage("Successfully Entered in to Employee under Manage Coverage/View Coverage Method");
		click(txtKeywordSearch);
		input(txtKeywordSearch, ssn);
		click(btnKeywordSearch);
		WaitForLoadAnimationDisappear();
		click(clickName);
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Searched Employee under Manage Coverage/View Coverage");
	}	
	
	//Search for the Employee
	public void searchemployee(String ssn) throws InterruptedException {
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Entered in to Employee under Manage Coverage/View Coverage Method");
		click(txtKeywordSearch);
		input(txtKeywordSearch, ssn);
		click(btnKeywordSearch);
		ExtentSuccessMessage("Successfully Searched Employee under Manage Coverage/View Coverage");
	}	
	
	//Enrollment Notification
	public void enrollmentnotification() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(L_EnrollmentNotification);
			ExtentSuccessMessage("Successfully Clicked On Enrollment Notification");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

		//Send Notification
		public void sendNotification(String date) throws InterruptedException {
			try {
				WaitForPageLoad();
				click(effectivedate);
				ExtentSuccessMessage("Successfully Clicked on Effective Date");
				input(effectivedate, date);
				ExtentSuccessMessage("Successfully Entered date in Effective Date Field");
				click(txt_notification);
				input(txt_notification, "Enrollment");
				ExtentSuccessMessage("Successfully Entered Notification Text");
				click(btn_send);
				ExtentSuccessMessage("Successfully Clicked on Send Button");
				click(btn_ok);
				WaitForPageLoad();
				ExtentSuccessMessage("Successfully Clicked on OK Button");
			} catch (Exception e) {
				// Handle the exception
				System.out.println("An exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
		}
		
}