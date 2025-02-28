package Pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;

public class ReHire_Page extends Base_Class {

	private static By reHireAndEnroll = By.id("BtnRehireandEnroll");
	
	// Rehire and Enroll
	public void reHireAndEnroll() throws InterruptedException {
	try {
		ExtentSuccessMessage("Entered in Rehire and Enroll Method");
		WaitForPageLoad();
		scrollDown();
		click(reHireAndEnroll);
		ExtentSuccessMessage("Completed Rehire and Enroll");
	} catch (Exception e) {
		// Handle the exception
		System.out.println("An exception occurred: " + e.getMessage());
		e.printStackTrace();
	}
}
}
