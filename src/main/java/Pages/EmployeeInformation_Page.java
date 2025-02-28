package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.BasePackage.Base_Class;
import com.Utility.Log;

public class EmployeeInformation_Page extends Base_Class {
	// ramya below xpath updated
	public static By name = By.xpath("//label[contains(text(),'Name:')]/parent::td/following-sibling::td");
	public static By terminate = By.linkText("Terminate");

	public static By reinstate = By.linkText("Reinstate");
	public static By reHire = By.linkText("Re-Hire");
	public static By yes = By.xpath("//button[text()='Yes']");
	public static By manageCoverage = By
			.xpath("//a[@class='btn btn-sm btn-primary'][contains(text(),'   Manage Coverage ')]");
	public static By edit = By.partialLinkText("Edit");
	public static By manageCoverageButton = By.partialLinkText("Manage Coverage");
	public static By auditDetails = By.id("BtnAudit");
	public static By terminationDate = By.xpath("//*[text()='Termination Date:']/parent::td/following-sibling::td");
	public static By attachmentsTab = By.xpath("//*[@id=\"AttachmentsAction\"]");
	public static By Document = By.xpath("(//a[@id='DownloadFileOrUrl'])[1]");
	public static By L_vendoraccount = By.xpath("//a[normalize-space()='Vendor Account']");
	public static By accountSummary = By.xpath("//a[normalize-space()='Account Summary']");
	public static By editBtn = By.xpath("//a[text()='Edit']");
	//"Get Employee Name"
	//@Attachment
	public String getEmployeeName() throws InterruptedException {
		String name1 = null;
		try {
			WaitForPageLoad();
			// takeScreenshot();
			name1 = GetElementText(name);
			ExtentSuccessMessage("Successfully get the employee name");
			return name1;
		} catch (Exception e) {
			ExtentErrorMessage("Unable to get employee name " + e.getMessage());
		}
		return name1;
	}

	//"Click Terminate"
	public void clickTerminate() throws InterruptedException {
		try {
			WaitForPageLoad();
			jsClick(terminate);
			//Thread.sleep(1000);
			Log.info("Successfully clicked on Terminate");
			ExtentSuccessMessage("Successfully clicked on Terminate");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Terminate" + e.getMessage());
		}
	}

	// "Click Reinstate"
	public void clickReinstate() throws InterruptedException {
		try {
			Log.info("Successfully Entered click Reinstate Method");
			ExtentSuccessMessage("Successfully Entered click Reinstate Method");
			WaitForPageLoad();
			click(reinstate);
			click(yes);
			Log.info("Successfully clicked Reinstate");
			ExtentSuccessMessage("Successfully clicked Reinstate");
		} catch (Exception e) {
			Log.info("Unable to click on Reinstate" + e.getMessage());
			ExtentErrorMessage("Unable to click on Reinstate" + e.getMessage());
		}
	}

	// "Click Manage Coverage"
	public void clickManageCoverage() throws InterruptedException {
		try {
			ExtentSuccessMessage("Successfully entered click ManageCoverage Method");
			WaitForPageLoad();
			click(manageCoverage);
			ExtentSuccessMessage("Successfully clicked on ManageCoverage");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on ManageCoverage" + e.getMessage());
		}
	}

	// "Click Rehire")
	public void clickReHire() throws InterruptedException {
		try {
			ExtentSuccessMessage("entered in to click rehire method");
			WaitForPageLoad();
			click(reHire);
			ExtentSuccessMessage("Successfully clicked on reHire");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on reHire" + e.getMessage());
		}
	}

	// "Is Edit Button Displayed"
	// @Attachment
	public boolean isEditButtonDisplayed() throws InterruptedException {
		WaitForPageLoad();
		return ElementDisplayed(edit);
	}

	// "Is Terminate Button Displayed"
	// @Attachment
	public boolean isTerminateButtonDisplayed() throws InterruptedException {
		return ElementDisplayed(terminate);
	}

	// "Is Manage Coverage Button Displayed"
	// @Attachment
	public boolean isManageCoverageButtonDisplayed() throws InterruptedException {
		return ElementDisplayed(manageCoverageButton);
	}

	// "Is Audit Details Button Displayed"
	// @Attachment
	public boolean isAuditDetailsButtonDisplayed() throws InterruptedException {
		scrollDown();
		return ElementDisplayed(auditDetails);
	}

	public String getTerminateDate() throws InterruptedException {
		return GetElementText(terminationDate).trim().replaceAll("/", "");
	}

	//click Edit button
	public void clickEdit() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(edit);
			ExtentSuccessMessage("Successfully clicked Edit Button");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Edit" + e.getMessage());
		}
	}

	//Click on Attachments Tab	
	public void clickAttachments() throws InterruptedException {
		try {
			WaitForPageLoad();
			scrollDown();
			click(attachmentsTab);
			ExtentSuccessMessage("Successfully clicked Attachments Tab");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Edit" + e.getMessage());
		}
	}

	public String getLetterType() throws InterruptedException {
		String letterType = ""; // Initialize the variable to store the LetterType

		try {
			WaitForPageLoad();
			scrollDown();
			findElements(Document);
			ExtentSuccessMessage("Successfully found the element");

			String elementText = GetElementText(Document);

			// Define a regular expression pattern to match the last name and date pattern
			Pattern pattern = Pattern.compile("([^_]+)_([^_]+)_(\\d{8})");
			Matcher matcher = pattern.matcher(elementText);

			if (matcher.find()) {
				// Extract the text between the last name and date
				String extractedText = matcher.group(2);
				ExtentSuccessMessage("Extracted Text: " + extractedText);
				letterType = extractedText; // Store the extracted text in letterType
			} else {
				ExtentErrorMessage("Unable to extract text between last name and date");
			}
		} catch (Exception e) {
			ExtentErrorMessage("Unable to find element or click on it: " + e.getMessage());
		}

		return letterType; // Return the extracted LetterType
	}



	//Click on Document
	public void clickDocument() throws InterruptedException {
		try {
			WaitForPageLoad();
			scrollDown();
			click(Document);
			ExtentSuccessMessage("Successfully clicked Document");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Edit" + e.getMessage());
		}
	}

	//Click on Account Summary
	public void clickAccountSummary() throws InterruptedException {
		try {
			WaitForPageLoad();
			waitForElementClickable(accountSummary);
			click(accountSummary);
			ExtentSuccessMessage("Successfully clicked Account Summary");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Edit" + e.getMessage());
		}
	}

	//click on Vendor Account
	public void clickonvendoraccount() throws InterruptedException {
		try {
			WaitForPageLoad();
			jsClick(L_vendoraccount);
			Log.info("Successfully clicked on Vendor Account");
			ExtentSuccessMessage("Successfully clicked on Vendor Account");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Vendor Account" + e.getMessage());
		}
	}
	
	public String GetBenefitStatus() throws InterruptedException {
		By options = By.xpath("//*[text()='Benefit Status:']//parent::td//parent::tr//td//span");
		 String msg =GetElementText(options);
		return msg;
	}

	//click Edit button
	public void clickEditbtn() throws InterruptedException {
		try {
			WaitForPageLoad();
			click(edit);
			ExtentSuccessMessage("Successfully clicked Edit Button");
		} catch (Exception e) {
			ExtentErrorMessage("Unable to click on Edit" + e.getMessage());
		}
	}
}
