package Pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;

public class CommentsRoaster_Page extends Base_Class
{
	public static By commentsRoasterHeader= By.xpath("//div[contains(text(),'Comments Roster')]");

//Comments Roaster page displayed
public Boolean isCommentsRoasterPageDisplayed() throws InterruptedException{
	WaitForPageLoad();
    return ElementDisplayed(commentsRoasterHeader);
}
}