package Pages;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class Images_Page extends Base_Class{
	////a[normalize-space()='Yes']|
	private static By L_yes = By.xpath("//*[contains(text(),'Do you wish to continue?')]//ancestor::div[@class='modal-content']//a[normalize-space()='Yes']");
	
	private static By Ok = By.xpath("//*[@id='images']/div[3]/div/div/div[3]/ul/li/a");
	
	private static By txt_search = By.xpath("//input[@id='txtSearch']");
	
	private static By search_icon = By.xpath("//a[@id='btnSearch']//i[@class='material-icons'][normalize-space()='search']");
	
	//Press Enter
	public void Enter() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	//Validate Image
	public String validateImage(String filename) throws InterruptedException{
		WaitForPageLoad();
		try {
			By img = By.xpath("//span[contains(@title,'"+ filename +"')]");
		if(ElementDisplayed(img)) {
			assertTrue(ElementDisplayed(img), "Assertion Passed");
			ExtentSuccessMessage("Successfully displayed Image");
		}} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
		return filename;
	}
	
	//Click on Yes and Ok
	public void clickonyesok() throws InterruptedException{
		try {
			WaitForPageLoad();
			jsClick(L_yes);
			ExtentSuccessMessage("Successfully Clicked On Yes");
			Thread.sleep(2000);
			jsClick(Ok);
			ExtentSuccessMessage("Successfully Clicked On OK");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Click on Delete
	public void clickondelete(String filename) throws InterruptedException{
		WaitForPageLoad();
		By L_delete = By.xpath("//span[contains(@title,'"+ filename +"')]/..//a[@Class='delete']");
		try {
			jsClick(L_delete);
			ExtentSuccessMessage("Successfully Clicked On Delete");
			Thread.sleep(5000);
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	// Search with Name
	public void search_Name(String name) throws InterruptedException {
		WaitForPageLoad();
		if (ElementDisplayed(txt_search)) {
			Log.info("Successfully Visible Text Search");
			jsClick(txt_search);
			input(txt_search, name);
			Log.info("Successfully Clicked On Text Search");
			click(search_icon);
			ExtentSuccessMessage("Successfully Search with Name");
		} else {
			Log.error("UnSuccessfully Not Visible Text Search");
			ExtentErrorMessage("UnSuccessfully Not Search with Name");
		}
	}
	
	
	public void Delete_if_SameImageNameAlreadyUploadeAndExist(String name) throws InterruptedException {
		search_Name(name);
		String ImageName=validateImage(name);
		System.out.println("Debug image name exist :"+ImageName);
		while(ImageName.length()>0){
			clickondelete(name);
			clickonyesok();
			PageRefresh();
			Thread.sleep(5000);
			search_Name(name);
		}
		
	}
	
}
