package Pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;


public class Reports_Page extends Base_Class
{
    private static By reportsHeader= By.xpath("//h4[text()='Reports']|//span[normalize-space()='Reports']");

//Reports page displayed
public Boolean isReportsPageDisplayed() throws InterruptedException{
	WaitForPageLoad();
    return ElementDisplayed(reportsHeader);
}
}