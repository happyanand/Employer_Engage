package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.BasePackage.Base_Class;


public class SummaryVerification_Page extends Base_Class {
	
	private static By ClickCloseButton = By.xpath("//a[@class='btn btn-primary closeBtn']");
	
	private static By viewSummary = By.xpath("//a[@class='btn btn-sm outline-bt ']");

	private static By effectiveDate = By.id("Item1_EffectiveDate");
	
//Click Close Button
public void clickCloseButton() throws InterruptedException{
	click(ClickCloseButton);
}


//Enter Effective Date
public void enterEffectiveDate(String date) throws InterruptedException {
    input(effectiveDate,date);
    findElement(effectiveDate).sendKeys(Keys.TAB);
    Thread.sleep(16000);
}

//click View Summary
public void clickViewSummary() throws InterruptedException{
	WaitForPageLoad();
    click(viewSummary);
    Thread.sleep(4000);
    ExtentSuccessMessage("Successfully Verified Summary");
}
}
