package Pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class Enrollment_Page extends Base_Class {
	Base_Class Base_Class = new Base_Class();
	List<String> plans;
	List<String> categories;

	public static By effectiveDate = By.id("Item1_EffectiveDate");
	public static By allPlanCategories = By.xpath("//h4[@class='panel-title']");

	public static By additionalInsurance_Yes = By
			.xpath("//label[contains(text(),'Yes')]/input[@id='Item1_COB_HaveConcurrentCoverageInd']//parent::label");
	public static By additionalInsurance_No = By
			.xpath("//label[contains(text(),'No')]/input[@id='Item1_COB_HaveConcurrentCoverageInd']//parent::label");

	public static By coveredMember = By.id("Item1_COB_CoveredMember_chzn");
	public static By employerName = By.id("Item1_COB_EmployerName");
	public static By insuranceCarrierName = By.id("Item1_COB_InsuranceCarrierName");
	public static By insuranceType = By.id("Item1_COB_InsuranceType_chzn");
	public static By insurancePolicyNumber = By.id("Item1_COB_InsurancePolicyNumber");
	public static By medicareHICNumber = By.id("Item1_COB_HICNumber");
	public static By speridian_btnSubmit = By.xpath("//a[@id='BtnSubmitEnrollment']");
	public static By COBBeginDate = By.id("Item1_COB_BeginDate");
	public static By COBEndDate = By.id("Item1_COB_EndDate");
	public static By endStageRenalDisease_Yes = By.xpath("//label[contains(text(),'Yes')]/input[@id='Item1_COB_ESRD']");
	public static By endStageRenalDisease_No = By.xpath("//label[contains(text(),'No')]/input[@id='Item1_COB_ESRD']");
	public static By notes = By.id("Item1_COB_Notes");
	public static By addInsurance = By.id("BtnAddCOB");
	public static By primaryMemberName = By.xpath("//span[text()=' Self']/preceding-sibling::span[1]");
	public static By dependentMemberName = By.xpath("//span[text()=' Spouse']/preceding-sibling::span[1]");
	public static By ESRDStartMonth = By.id("Item1_COB_EsrdStartMonth_chzn");
	public static By ESRDStartYear = By.id("Item1_COB_EsrdStartYear_chzn");
	public static By totalRate = By.id("lbltotalRate");
	public static By btnNext = By.id("BtnGotoProfile");
	public static By paymentProfile_yes = By.id("rd_yes");
	public static By paymentProfile_no = By.id("rd_no");
	public static By addProfile = By.id("btn_AddProfile_EnrollmentFlow");
	public static By nameOfTheBank = By.id("NameoftheBank");
	public static By bankAccountNumber = By.id("BankAccount");
	public static By routingNumber = By.id("RoutingNumber");
	public static By saveProfile = By.id("btn_SaveProfile_EnrollmentFlow");
	public static By ACHCurrentMonth_Yes = By.id("btn_Add_Payment_Profile_EnrollmentFlow");
	public static By ACHCurrentMonth_No = By.id("btn_Cancel_Payment_Profile_CancelEnrollmentFlow");
	public static By submit = By.id("BtnSubmitEnrollment");
	public static By L_Cancel_Button = By.xpath("//*[text()=' Cancel ']");
	public static By L_Previouse_Button = By.id("BtnPreviousEnrollment");
	public static By L_Save_And_Finish_Letter_Button = By.xpath("//*[text()=' Save and Finish Later ']");
	public static By pensionAuthority = By.xpath("//label[contains(text(),' Pension Authority')]/input");
	public static By pensionAuthorityname = By.xpath("//*[@id='PensionAuthorityName_chzn']/a/span");
	public static By FloridaRetirementSystem = By.xpath("//*[@id='PensionAuthorityName_chzn_o_1']");
	public static By ACH = By.xpath("//label[contains(text(),'ACH')]/input");
	public static By FullnamefromTable = By.xpath("//*[@class='table-bordered summry-address']//h5[@class='cap_head']");

	public static By totalPremiumHandle = By.xpath("//a[@class='handle sub-theme-bg']");
	public static By errorMessage = By.id("Div_ErrMsg_Enrollment");
	public static By enterCost = By.xpath("//input[@placeholder='Enter Monthly Cost']");
	public static By declineAllCoverage = By.id("btnDeclineAll");
	public static By declineReason = By.id("declinedReasonID");
	public static By declineReasonSave = By.id("declinedReasonSave");

	public static By carrierAddress1 = By.id("Item1_COB_Address_Address1");
	public static By carrierZip = By.id("Item1_COB_Address_NonUSZipCode");
	public static By carrierCountry = By.id("Item1_COB_Address_County_chzn");
	public static By carrierCity = By.id("Item1_COB_Address_City_chzn");
	public static By carrierState = By.id("Item1_COB_Address_StateCode_chzn");
	public static By L_WarningOkbtn = By.id("btnWarningOk");

	public static By activeWorkers_yes = By
			.xpath("//label[contains(text(),'Yes')]/input[@id='Item1_COB_ActiveWorkerCompensation']");
	public static By totalPlanAmount = By.xpath("//a[@class='handle sub-theme-bg']/i");

	public static By L_Fsa = By.xpath("//*[@id='20'][@data-categoryvalue='FSA']");
	public static By L_FSADropdown = By.xpath("//*[@class='panel-title'][contains(text(),'FSA')]");
	public static By L_DCFSA = By.xpath("//*[@data-categoryvalue='DCFSA']//h4[@class='panel-title']");
	public static By L_FsaDeposite = By.xpath("//*[@id=\"Item1_ProductLst_3__YearlyDeposit\"]");
	public static By L_DCFSADeposite = By.xpath("//*[@id=\"Item1_ProductLst_4__YearlyDeposit\"]");
	public static By AdditionalInsurance = By
			.xpath("//*[@id='div_AccodianHead_COB']//*[text()='Additional Insurance']");


	public static By L_MedicalDeclineCheckBox = By.xpath("//*[@data-categoryvalue='Medical']//parent::div[@class='Enroll-Decline']");

	public static By Close_Price_tag = By.xpath("//div[@id='divTotalBtn']//a/i");

	public void ClickonFsa() throws InterruptedException {
		if (ElementDisplayed(L_Fsa)) {
			click(L_Fsa);
			Log.info("Successfully Clicked on Fsa Dropdown");
			ExtentSuccessMessage("Successfully Clicked on Fsa Dropdown");
		} else {
			Log.error("UnSuccessfully Not Clicked on Fsa Dropdown");
			ExtentErrorMessage("UnSuccessfully Not Clicked on Fsa Dropdown");

		}
	}

	public void ClickonFsaDropdowns() throws InterruptedException {
		if (ElementDisplayed(L_FSADropdown)) {
			click(L_FSADropdown);
			Log.info("Successfully Clicked on Fsa Dropdown");
			ExtentSuccessMessage("Successfully Clicked on Fsa Dropdown");
		} else {
			Log.error("UnSuccessfully Not Visible on Fsa Dropdown");
			ExtentErrorMessage("UnSuccessfully Not Visible on Fsa Dropdown");

		}
	}

	public void ClickOnDCFSA() throws InterruptedException {
		if (ElementDisplayed(L_DCFSA)) {
			click(L_DCFSA);
			Log.info("Successfully Clicked on DCFSA Dropdown");
			ExtentSuccessMessage("Successfully Clicked on DCFSA Dropdown");
		} else {
			Log.error("UnSuccessfully Not Clicked on DCFSA Dropdown");
			ExtentErrorMessage("UnSuccessfully Not Clicked on DCFSA Dropdown");

		}
	}

	public void InputDCFSA_Deposite() throws InterruptedException {
		if (ElementDisplayed(L_DCFSADeposite)) {
			click(L_DCFSADeposite);
			Log.info("Successfully Clicked on DCFSA Deposite");
			ExtentSuccessMessage("Successfully Clicked on DCFSA Deposite");
			input(L_DCFSADeposite, "51");
			Log.info("Successfully Visible in DCFSA Deposite");
			ExtentSuccessMessage("Successfully Input in DCFSA Deposite");
		} else {
			Log.error("Unsuccessfully Not Visible on DCFSA Deposite");
			ExtentErrorMessage("Unsuccessfully Not Clicked on DCFSA Deposite");
		}
	}

	public void InputFsa_Deposite() throws InterruptedException {
		WaitForPageLoad();
		if (ElementDisplayed(L_FsaDeposite)) {
			waitForElementClickable(L_FsaDeposite);
			jsClick(L_FsaDeposite);
			Log.info("Successfully Clicked on Fsa Deposite");
			ExtentSuccessMessage("Successfully Clicked on Fsa Deposite");
			input(L_FsaDeposite, "51");
			findElement(L_FsaDeposite).sendKeys(Keys.TAB);
			Log.info("Successfully Visible in Fsa Deposite");
			ExtentSuccessMessage("Successfully Input in Fsa Deposite");
		} else {
			Log.error("Unsuccessfully Not Visible on Fsa Deposite");
			ExtentErrorMessage("Unsuccessfully Not Clicked on Fsa Deposite");
		}
	}

	// "Select the Plans"

	public List<Map<String, String>> selectSperidianPlans(Boolean spouseSelected) throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		Base_Class.waitForElementClickable(allPlanCategories);
		WaitForPageLoad();
		Thread.sleep(2000);
		ClickonFsa();
		InputFsa_Deposite();
		Thread.sleep(2000);
		ClickonFsa();
		WaitForPageLoad();
		ClickOnDCFSA();
		Thread.sleep(3000);
		InputDCFSA_Deposite();
		Thread.sleep(2000);
		ClickOnDCFSA();
		plans = new ArrayList<>();
		List<Map<String, String>> planValues = new ArrayList<>();
		List<WebElement> LstallPlanCategories = getDriver().findElements(allPlanCategories);
		int i = 0;
		for (WebElement categoryEle : LstallPlanCategories) {
			String category = categoryEle.getText().trim();
			if (!category.equalsIgnoreCase("Additional Insurance")) {
				// if (!categoryEle.isDisplayed()) {
				// scrollDown();
				// }
				try {
					categoryEle.click();
				} catch (Throwable e) {
					scrollUpVertically();
					categoryEle.click();
				}

				WebElement selectPlanButton = getDriver().findElement(
						By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')]"));
				Map<String, String> values = new HashMap<>();
				values.put("category", selectPlanButton.getAttribute("data-categoryvalue"));
				values.put("totalRate", selectPlanButton.getAttribute("data-totalrate"));
				values.put("coverageLevel", selectPlanButton.getAttribute("data-coverageleveldisplayvalue"));
				values.put("planName", selectPlanButton.getAttribute("data-planname"));
				plans.add(selectPlanButton.getAttribute("data-planname"));
				jSClick1(selectPlanButton);
				ExtentSuccessMessage(category +" Plan is selected");
				By by = By.xpath(
						"//input[contains(@id,'_YearlyDeposit')][contains(@name,'Item1.ProductLst[" + i + "]')]");
				i++;
				try {
					if(values.get("planName").toLowerCase().contains("fsa")) {
						WebElement element = findElement(by);
						if (element.isDisplayed()) {
							click(by);
							clear(by);
							Thread.sleep(2000);
							categoryEle.click();
							// click(by);
							// jSClick1(selectPlanButton);
							click(by);
							input(by, "100");
							getDriver().findElement(by).sendKeys(Keys.ENTER);
							values.put("totalRate", "100");
						}
					}
				} catch (Throwable e) {
					System.out.println("Input element is not displayed");
				}

				planValues.add(values);
				try {
					categoryEle.click();
				} catch (Throwable e) {
					/*
					 * if(categoryEle.findElement(By.xpath("./following-sibling::i")).getAttribute(
					 * "class").contains("up")){ scrollUpVertically(); categoryEle.click();
					 */
					// }
				}
			}
		}
		return planValues;
	}
	public List<Map<String, String>> selectPlans(Boolean spouseSelected) throws InterruptedException, IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("Starting Date " +dateFormat.format(date));
		WaitForPageLoad();
		waitForElementClickable(allPlanCategories);
		Thread.sleep(2000);
		categories = new ArrayList<>();
		/*
		 * try{ Thread.sleep(6000); } catch (Exception e){
		 * 
		 * }
		 */
		plans = new ArrayList<>();
		List<Map<String, String>> planValues = new ArrayList<>();
		//Ramya 10/07- List<WebElement> LstallPlanCategories = findElements(allPlanCategories);
		List<WebElement> LstallPlanCategories = driver.findElements(allPlanCategories);
		for (WebElement categoryEle : LstallPlanCategories) {
			String category = categoryEle.getText().trim();
			if (!category.equalsIgnoreCase("Additional Insurance")) {
				// if (!categoryEle.isDisplayed()) {
				// scrollDown();
				// }
				categories.add(category);
				try {
					categoryEle.click();
				} catch (Throwable e) {
					scrollUpVertically();

					categoryEle.click();
				}
				WebElement selectPlanButton;
				if (category.equalsIgnoreCase("Medical")) {
					if (URL.equalsIgnoreCase(configloader().getProperty("IHA_URL")))  {
						selectPlanButton = getDriver().findElement(
								By.xpath("(//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')])[1]"));
					}
					else {
						selectPlanButton = getDriver().findElement(
								By.xpath("(//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')])[4]"));
					}} else  {
						selectPlanButton = getDriver().findElement(
								By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')]"));

					}
				Map<String, String> values = new HashMap<>();
				values.put("category", selectPlanButton.getAttribute("data-categoryvalue"));
				values.put("totalRate", selectPlanButton.getAttribute("data-totalrate"));
				values.put("coverageLevel", selectPlanButton.getAttribute("data-coverageleveldisplayvalue"));
				values.put("planName", selectPlanButton.getAttribute("data-planname"));
				plans.add(selectPlanButton.getAttribute("data-planname"));
				jSClick(selectPlanButton);
				ExtentSuccessMessage(category +" Plan is selected");
				By by = By.xpath(
						"//input[contains(@data-planname,'" + selectPlanButton.getAttribute("data-planname").trim()
						+ "')][@placeholder='Enter Monthly Cost']");

				try {
					//Ramya 10/07 - WebElement element = findElement(by);
					if(values.get("planName").toLowerCase().contains("bluemedicare elite rx pdp") || values.get("planName").toLowerCase().contains("medical bridge")) {
						//
						WebElement element = driver.findElement(by);
						//if (element.isDisplayed()) {
						//Ramya 10/07 - Removed Robot code
						//Robot robot = new Robot();
						click(by);
						input(by, "100");
						/*
						 * Thread.sleep(1000); robot.keyRelease(KeyEvent.VK_TAB);
						 * RobotKeyOperation("TAB"); robot.keyRelease(KeyEvent.VK_TAB);
						 * Thread.sleep(1000); RobotKeyOperation("TAB");
						 */
						//						getDriver().findElement(by).284814251175185267sendKeys(Keys.ENTER);

						values.put("totalRate", "100");
						//						getDriver().findElement(by).sendKeys(Keys.TAB);
						/*
						 * robot.keyRelease(KeyEvent.VK_TAB); Thread.sleep(1000);
						 * RobotKeyOperation("TAB"); robot.keyRelease(KeyEvent.VK_TAB);
						 */
						//}
					}
				} catch (Throwable e) {
					System.out.println("Input element is not displayed");
				}

				planValues.add(values);
				try {
					categoryEle.click();
				} catch (Throwable e) {
					/*
					 * if(categoryEle.findElement(By.xpath("./following-sibling::i")).getAttribute(
					 * "class").contains("up")){ scrollUpVertically(); categoryEle.click();
					 */
					// }
				}
			}
		}
		By L_xpath = By.xpath("//*[@id='Div_ErrMsg_Enrollment'][contains(text(),'Please enter monthly cost for the selected')]");
		if(ElementDisplayed(L_xpath)) {
			WebElement Err = driver.findElement(L_xpath);
			String msg =Err.getText();
			String [] msg1 = msg.split("selected ");
			String msging =msg1[1];
			System.out.println("msging debug: "+msging);
		}

		ExtentSuccessMessage("Successfully Enrolled all the Plans");
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		date = new Date();
		System.out.println("End Date " +dateFormat.format(date));
		return planValues;
	}

	// "Get all the selected plans"
	public List<String> getAllSelectedPlans() {
		return plans;
	}
	
	public List<Map<String, String>> selectMedicalPlan(Boolean spouseSelected) throws InterruptedException, IOException {
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
	    System.out.println("Starting Date " +dateFormat.format(date));
	    WaitForPageLoad();
	    waitForElementClickable(allPlanCategories);
	    Thread.sleep(2000);
	    categories = new ArrayList<>();
	    /*
	     * try{ Thread.sleep(6000); } catch (Exception e){
	     * 
	     * }
	     */
	    plans = new ArrayList<>();
	    List<Map<String, String>> planValues = new ArrayList<>();
	    //Ramya 10/07- List<WebElement> LstallPlanCategories = findElements(allPlanCategories);
	    List<WebElement> LstallPlanCategories = driver.findElements(allPlanCategories);
	    for (WebElement categoryEle : LstallPlanCategories) {
	        String category = categoryEle.getText().trim();
	        if (!category.equalsIgnoreCase("Additional Insurance")) {
	            // if (!categoryEle.isDisplayed()) {
	            // scrollDown();
	            // }
	            categories.add(category);
	            try {
	                categoryEle.click();
	            } catch (Throwable e) {
	                scrollUpVertically();
	 
	                categoryEle.click();
	            }
	            WebElement selectPlanButton;
	            if (category.equalsIgnoreCase("Medical")) {
	                selectPlanButton = getDriver().findElement(
	                        By.xpath("(//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')])[1]"));
	            } else {
	                selectPlanButton = getDriver().findElement(
	                        By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')]"));
	 
	            }
	            Map<String, String> values = new HashMap<>();
	            values.put("category", selectPlanButton.getAttribute("data-categoryvalue"));
	            values.put("totalRate", selectPlanButton.getAttribute("data-totalrate"));
	            values.put("coverageLevel", selectPlanButton.getAttribute("data-coverageleveldisplayvalue"));
	            values.put("planName", selectPlanButton.getAttribute("data-planname"));
	            plans.add(selectPlanButton.getAttribute("data-planname"));
	            jSClick(selectPlanButton);
	            ExtentSuccessMessage(category +" Plan is selected");
	            By by = By.xpath(
	                    "//input[contains(@data-planname,'" + selectPlanButton.getAttribute("data-planname").trim()
	                    + "')][@placeholder='Enter Monthly Cost']");
	 
	            try {
	                if(values.get("planName").toLowerCase().contains("bluemedicare elite rx pdp") || values.get("planName").toLowerCase().contains("medical bridge")) {
	                    //
	                    WebElement element = driver.findElement(by);
	                    click(by);
	                    input(by, "100");
	                }
	            } catch (Throwable e) {
	                System.out.println("Input element is not displayed");
	            }
	 
	            planValues.add(values);
	            try {
	                categoryEle.click();
	            } catch (Throwable e) {
	            }
	        }
	    }
	    By L_xpath = By.xpath("//*[@id='Div_ErrMsg_Enrollment'][contains(text(),'Please enter monthly cost for the selected')]");
	    if(ElementDisplayed(L_xpath)) {
	        WebElement Err = driver.findElement(L_xpath);
	        String msg =Err.getText();
	        String [] msg1 = msg.split("selected ");
	        String msging =msg1[1];
	        System.out.println("msging debug: "+msging);
	    }
	 
	    ExtentSuccessMessage("Successfully Enrolled all the Plans");
	    dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    date = new Date();
	    System.out.println("End Date " +dateFormat.format(date));
	    return planValues;
	}
	
	
	// "Select the Plans"
	public List<Map<String, String>> selectPlans(Boolean spouseSelected, int no) {
		WaitForPageLoad();
		waitForElementClickable(allPlanCategories);
		declineAllCoverage();
		int count = 0;
		categories = new ArrayList<>();
		plans = new ArrayList<>();
		List<Map<String, String>> planValues = new ArrayList<>();
		List<WebElement> strallPlanCategories = findElements(allPlanCategories);
		scrollUpVertically();
		for (WebElement categoryEle : strallPlanCategories) {
			String category = categoryEle.getText().trim();
			if (count < no) {
				jsClick(By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@id,'IsDeclinedInd')]"));
				try {
					categoryEle.click();
				} catch (Throwable e) {
					scrollUpVertically();
					categoryEle.click();
				}
				WebElement selectPlanButton = getDriver().findElement(
						By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')]"));
				
				categories.add(category);
				Map<String, String> values = new HashMap<>();
				values.put("category", selectPlanButton.getAttribute("data-categoryvalue"));
				values.put("totalRate", selectPlanButton.getAttribute("data-totalrate"));
				values.put("coverageLevel", selectPlanButton.getAttribute("data-coverageleveldisplayvalue"));
				values.put("planName", selectPlanButton.getAttribute("data-planname"));
				plans.add(selectPlanButton.getAttribute("data-planname"));
				jSClick(selectPlanButton);
//				selectPlanButton.click();
				ExtentSuccessMessage(category +" Plan is selected");
				planValues.add(values);
				try {
					categoryEle.click();
				} catch (Throwable e) {

				}
			}
			count++;
		}
		return planValues;
	}

	// "Select the Plans"
	public List<Map<String, String>> selectSperidianPlanName(Boolean spouseSelected, String planName) {
		WaitForPageLoad();
		/*
		 * try{ Thread.sleep(12000); } catch (Exception e){
		 *
		 * }
		 */
		plans = new ArrayList<>();
		List<Map<String, String>> planValues = new ArrayList<>();
		List<WebElement> LstallPlanCategories = findElements(allPlanCategories);
		int i = 0;
		for (WebElement categoryEle : LstallPlanCategories) {
			String category = categoryEle.getText().trim();
			if (!category.equalsIgnoreCase("Additional Insurance")) {
				// if (!categoryEle.isDisplayed()) {
				// scrollDown();
				// }
				if (category.equalsIgnoreCase(planName)) {
					try {
						categoryEle.click();
					} catch (Throwable e) {
						scrollUpVertically();
						categoryEle.click();
					}
					WebElement selectPlanButton = getDriver().findElement(
							By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')]"));
					Map<String, String> values = new HashMap<>();
					values.put("category", selectPlanButton.getAttribute("data-categoryvalue"));
					values.put("totalRate", selectPlanButton.getAttribute("data-totalrate"));
					values.put("coverageLevel", selectPlanButton.getAttribute("data-coverageleveldisplayvalue"));
					values.put("planName", selectPlanButton.getAttribute("data-planname"));
					plans.add(selectPlanButton.getAttribute("data-planname"));
					jSClick(selectPlanButton);
					ExtentSuccessMessage(category +" Plan is selected");
					By by = By.xpath(
							"//input[contains(@id,'_YearlyDeposit')][contains(@name,'Item1.ProductLst[" + i + "]')]");
					i++;
					try {
						WaitForPageLoad();
						WebElement element = findElement(by);
						if (element.isDisplayed()) {
							input(by, "100");
							getDriver().findElement(by).sendKeys(Keys.ENTER);
							values.put("totalRate", "100");
						}
					} catch (Throwable e) {
						System.out.println("Input element is not displayed");
					}

					planValues.add(values);
					try {
						categoryEle.click();
					} catch (Throwable e) {
						/*
						 * if(categoryEle.findElement(By.xpath("./following-sibling::i")).getAttribute(
						 * "class").contains("up")){ scrollUpVertically(); categoryEle.click();
						 */
						// }
					}
				} else {
					scrollUpVertically();
					jsClick(By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@id,'IsDeclinedInd')]"));
					jsClick(declineReasonSave);

				}
			}
		}
		return planValues;
	}

	// "Select the Plans"
	// Added a variable string for inputing plan name
	public List<Map<String, String>> selectPlans(Boolean spouseSelected, String planName) {
		WaitForPageLoad();
		categories = new ArrayList<>();
		plans = new ArrayList<>();
		List<Map<String, String>> planValues = new ArrayList<>();
		List<WebElement> LstallPlanCategories = findElements(allPlanCategories);
		for (WebElement categoryEle : LstallPlanCategories) {
			String category = categoryEle.getText().trim();
			categories.add(category);
			if (!category.equalsIgnoreCase("Additional Insurance")) {
				// A condition to check if the category is equal to the input value
				if (category.equalsIgnoreCase(planName)) {
					try {
						categoryEle.click();
					} catch (Throwable e) {
						scrollUpVertically();
						categoryEle.click();
					}
					WebElement selectPlanButton = getDriver().findElement(
							By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')]"));
					Map<String, String> values = new HashMap<>();
					values.put("category", selectPlanButton.getAttribute("data-categoryvalue"));
					values.put("totalRate", selectPlanButton.getAttribute("data-totalrate"));
					values.put("coverageLevel", selectPlanButton.getAttribute("data-coverageleveldisplayvalue"));
					values.put("planName", selectPlanButton.getAttribute("data-planname"));
					System.out.println("selectPlanButton"+selectPlanButton.getAttribute("data-planname"));
					System.out.println("selectPlanButton"+selectPlanButton.getAttribute("data-planname"));
					plans.add(selectPlanButton.getAttribute("data-planname"));
					jSClick(selectPlanButton);
					ExtentSuccessMessage(category +" Plan is selected");
					By by = By.xpath(
							"//input[contains(@data-planname,'" + selectPlanButton.getAttribute("data-planname").trim()
							+ "')][@placeholder='Enter Monthly Cost']");
					try {
						if(values.get("planName").toLowerCase().contains("bluemedicare elite rx pdp") || values.get("planName").toLowerCase().contains("medical bridge")|| values.get("planName").toLowerCase().contains("hospital indemnity 150-1 unit rider entry")|| values.get("planName").toLowerCase().contains("hospital")) {
							//
							WebElement element = driver.findElement(by);
							input(by, "100");
							values.put("totalRate", "100");
						}
					} catch (Throwable e) {
						System.out.println("Input element is not displayed");
					}

					planValues.add(values);
					try {
						categoryEle.click();
					} catch (Throwable e) {
					}
				} else {
					scrollUpVertically();
					jsClick(By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@id,'IsDeclinedInd')]"));
					jsClick(declineReasonSave);
				}
			}
		}
		return planValues;
	}

	public List<Map<String, String>> select3PlansBynames(String planName1, String planName2, String planName3) throws InterruptedException {
		dependentcheckbox("Child /Dependent", planName1);
		dependentcheckbox("Child /Dependent", planName2);
		dependentcheckbox("Child /Dependent", planName3);
		selectPlansWithouDeclined(false,planName1);
		selectPlansWithouDeclined(false,planName2);
		List<Map<String, String>> selectedPlanDetails =selectPlansWithouDeclined(false, planName3);
		
//		List<Map<String, String>> selectedPlanDetails =selectthreePlans(false,planName1,planName2, planName3);
		String value=DeclingtheUnselectedplans();

		return selectedPlanDetails;
	}
	public String DeclingtheUnselectedplans() throws InterruptedException {
		List<WebElement> plans = driver.findElements(By.xpath("//*[contains(@class,'icon_indicate nuter_ico')]//parent::a")); 
		String Value = null;
		int count = 1;
		click(Close_Price_tag);
		for (WebElement plan : plans) {
			String data_parent = plan.getAttribute("data-parent");
			String data_parents[] =data_parent.split("#accordion_");
			Value = data_parents[1].trim();
			System.out.println("Value printing:"+Value);
			WebElement xpath =driver.findElement(By.xpath("//*[@class='Enroll-Decline']//*[@data-category='"+Value+"']//parent::span//input[contains(@id,'IsDeclinedInd')]"));//parent::div[@class='Enroll-Decline']"));
//			WaitForLoadAnimationDisappear();
			if(xpath.isDisplayed()) {
				jSClick(xpath);
				jsClick(declineReasonSave);
				System.out.println("Visible:"+Value);
			}else {
				scrollDown();
				if(xpath.isDisplayed()) {
					jSClick(xpath);
					jsClick(declineReasonSave);
					System.out.println("Visible:"+Value);
				}else {
					scrollUpVertically();
					jSClick(xpath);
					jsClick(declineReasonSave);
					System.out.println("Else Visible:"+Value);
				}
			}

			count++;
		}
		return Value;
	}
	//
	public List<Map<String, String>> selectPlansWithouDeclined(Boolean spouseSelected, String planName) throws InterruptedException {
		WaitForPageLoad();
		/*
		 * try{ Thread.sleep(4000); } catch (Exception e){
		 *
		 * }
		 */

		categories = new ArrayList<>();
		plans = new ArrayList<>();
		List<Map<String, String>> planValues = new ArrayList<>();
		List<WebElement> LstallPlanCategories = findElements(allPlanCategories);
		for (WebElement categoryEle : LstallPlanCategories) {
			String category = categoryEle.getText().trim();
			categories.add(category);
			if (!category.equalsIgnoreCase("Additional Insurance")) {
				// A condition to check if the category is equal to the input value
				if (category.equalsIgnoreCase(planName)) {
					try {
						categoryEle.click();
					} catch (Throwable e) {
						scrollUpVertically();
						categoryEle.click();
					}
//					WebElement selectPlanButton;
//					if (category.equalsIgnoreCase("Medical")) {
//						selectPlanButton = driver.findElement(
//								By.xpath("(//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')])[4]"));
//					} else  {
//						 selectPlanButton = driver.findElement(
//									By.xpath("//input[@data-categoryvalue='" + category + "' and contains(@class,'radio')]"));
//							
//					}
					//				WebElement SelectChilDependent = getDriver().findElement(By.xpath("//*[@class='fa fa-angle-up']//ancestor::div[@class='panel inner-ac ']//*[contains(text(),'Child')]/preceding-sibling::span/span/input"));
					WebElement selectPlanButton = driver.findElement(
							By.xpath("//input[@data-categoryvalue='" + category + "' and contains(@class,'radio')]"));
					Map<String, String> values = new HashMap<>();
					values.put("category", selectPlanButton.getAttribute("data-categoryvalue"));
					values.put("totalRate", selectPlanButton.getAttribute("data-totalrate"));
					values.put("coverageLevel", selectPlanButton.getAttribute("data-coverageleveldisplayvalue"));
					values.put("planName", selectPlanButton.getAttribute("data-planname"));
					plans.add(selectPlanButton.getAttribute("data-planname"));
					//				jSClick(SelectChilDependent);
					//				Thread.sleep(5000);
					//				WaitForPageLoad();
					
					Thread.sleep(1000);
//					driver.findElement(By.xpath("(//input[@data-categoryvalue='" + category + "' and contains(@class,'radio')]//parent::label)[1]")).click();
					jSClick(selectPlanButton);
					ExtentSuccessMessage(category +" Plan is selected");
					
//					By by = By.xpath(
//							"//input[contains(@data-planname,'" + selectPlanButton.getAttribute("data-planname").trim()
//							+ "')][@placeholder='Enter Monthly Cost']");
//					try {
//						WebElement element = findElement(by);
//						if (element.isDisplayed()) {
//							input(by, "100");
//							getDriver().findElement(by).sendKeys(Keys.ENTER);
//							values.put("totalRate", "100");
//						}
//					} catch (Throwable e) {
//						System.out.println("Input element is not displayed");
//					}
					
					planValues.add(values);
					try {
						categoryEle.click();
					} catch (Throwable e) {
						/*
						 * if(categoryEle.findElement(By.xpath("./following-sibling::i")).getAttribute(
						 * "class").contains("up")){ scrollUpVertically(); categoryEle.click();
						 */
						// }
					}
				} else {
//									scrollUpVertically();
//									jsClick(By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@id,'IsDeclinedInd')]"));
//									jsClick(declineReasonSave);
				}

			}

		}
		return planValues;
	}
	
	public List<Map<String, String>> selectPlansWithouDeclinedS(Boolean spouseSelected, String planName) throws InterruptedException {
		WaitForPageLoad();
		/*
		 * try{ Thread.sleep(4000); } catch (Exception e){
		 *
		 * }
		 */

		categories = new ArrayList<>();
		plans = new ArrayList<>();
		List<Map<String, String>> planValues = new ArrayList<>();
		List<WebElement> LstallPlanCategories = findElements(allPlanCategories);
		for (WebElement categoryEle : LstallPlanCategories) {
			String category = categoryEle.getText().trim();
			categories.add(category);
			if (!category.equalsIgnoreCase("Additional Insurance")) {
				// A condition to check if the category is equal to the input value
				if (category.equalsIgnoreCase(planName)) {
					try {
						categoryEle.click();
					} catch (Throwable e) {
						scrollUpVertically();
						categoryEle.click();
					}
//					WebElement selectPlanButton;
//					if (category.equalsIgnoreCase("Medical")) {
//						selectPlanButton = getDriver().findElement(
//								By.xpath("(//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')])[1]"));
//					} else  {
//						selectPlanButton = getDriver().findElement(
//								By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')]"));
//
//					}
					//				WebElement SelectChilDependent = getDriver().findElement(By.xpath("//*[@class='fa fa-angle-up']//ancestor::div[@class='panel inner-ac ']//*[contains(text(),'Child')]/preceding-sibling::span/span/input"));
					WebElement selectPlanButton = driver.findElement(
							By.xpath("//input[@data-categoryvalue='" + category + "' and contains(@class,'radio')]"));
					Map<String, String> values = new HashMap<>();
					values.put("category", selectPlanButton.getAttribute("data-categoryvalue"));
					values.put("totalRate", selectPlanButton.getAttribute("data-totalrate"));
					values.put("coverageLevel", selectPlanButton.getAttribute("data-coverageleveldisplayvalue"));
					values.put("planName", selectPlanButton.getAttribute("data-planname"));
					plans.add(selectPlanButton.getAttribute("data-planname"));
					//				jSClick(SelectChilDependent);
					//				Thread.sleep(5000);
					//				WaitForPageLoad();
					
					Thread.sleep(3000);
//					driver.findElement(By.xpath("(//input[@data-categoryvalue='" + category + "' and contains(@class,'radio')]//parent::label)[1]")).click();
//					Thread.sleep(3000);
//					KeyOperation("TAB");
					jSClicks1(selectPlanButton);
					ExtentSuccessMessage(category +" Plan is selected");
					
//					By by = By.xpath(
//							"//input[contains(@data-planname,'" + selectPlanButton.getAttribute("data-planname").trim()
//							+ "')][@placeholder='Enter Monthly Cost']");
//					try {
//						WebElement element = findElement(by);
//						if (element.isDisplayed()) {
//							input(by, "100");
//							getDriver().findElement(by).sendKeys(Keys.ENTER);
//							values.put("totalRate", "100");
//						}
//					} catch (Throwable e) {
//						System.out.println("Input element is not displayed");
//					}

					planValues.add(values);
					try {
						categoryEle.click();
					} catch (Throwable e) {
						/*
						 * if(categoryEle.findElement(By.xpath("./following-sibling::i")).getAttribute(
						 * "class").contains("up")){ scrollUpVertically(); categoryEle.click();
						 */
						// }
					}
				} else {
//									scrollUpVertically();
//									jsClick(By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@id,'IsDeclinedInd')]"));
//									jsClick(declineReasonSave);
				}

			}

		}
		return planValues;
	}
	
	
	// "Add Additional Insurance"
	public void addAdditionalInsurance(Boolean value, Map<Object, Object> testdata) throws InterruptedException {
		try {
			WaitForPageLoad();
			System.out.println("Before scroll");
			//scrollDown();
			scrollToElement(submit);
			Thread.sleep(2000);
			System.out.println("After scroll");
			ScrolltillElementOnmiddlepage(additionalInsurance_Yes);
			if(!ElementsDisplayed(additionalInsurance_Yes)) {
				click(AdditionalInsurance);
				ExtentSuccessMessage("Successfully Clicked On Additional Insurance");
			}

			if (!value) {
				if (ElementsDisplayed(additionalInsurance_No)) {
					click(additionalInsurance_No);
					System.out.println("After click NO: " + waitForElementClickable(additionalInsurance_No).getAttribute("class"));
					if(!waitForElementClickable(additionalInsurance_No).getAttribute("class").contains("active"))
					{
						jsClick(additionalInsurance_No);
					}
					ExtentSuccessMessage("Successfully Clicked On Additional Insurance No");
					return;
				}

			}
			else  {
				click(additionalInsurance_Yes);
				if(!waitForElementClickable(additionalInsurance_Yes).getAttribute("class").contains("active"))
					jsClick(additionalInsurance_Yes);
				ExtentSuccessMessage("Successfully clicked on 'additionalInsurance_Yes' ");
			}

			if (testdata.get("CoveredMember").toString().equalsIgnoreCase("Primary")) {
				try {
					String PrimaryMemberName = getPrimaryMemberName();
					System.out.println("PrimaryMemberName: " + PrimaryMemberName);
					selectComboBoxValue(coveredMember, PrimaryMemberName);
					ExtentSuccessMessage("Successfully Select  'coveredMember' ");
				} catch (Exception e) {
					scrollDown();
					selectComboBoxValue(coveredMember, getPrimaryMemberName());

				}
			} else if (testdata.get("CoveredMember").toString().equalsIgnoreCase("Dependent")) {
				selectComboBoxValue(coveredMember, getDependentMemberName());
			}
			input(insuranceCarrierName, testdata.get("InsuranceCarrierName").toString());
			try {
				jsClick(totalPremiumHandle);
				ExtentSuccessMessage("Successfully Clicked On Total Premium Handle");
			} catch (Exception e) {

			}
			SelectDropdownfirstValue(insuranceType);
			ExtentSuccessMessage("Successfully Select  'insuranceType' ");
			input(insurancePolicyNumber, randomNumber(9) + "");
			ExtentSuccessMessage("Successfully Enter 'insurancePolicyNumber' ");
			scrollDown();
			click(COBBeginDate);
			ExtentSuccessMessage("Successfully clicked on 'COBBeginDate' ");
			input(COBBeginDate, testdata.get("COBBeginDate").toString());
			if (Boolean.parseBoolean(testdata.get("EndStageRenalDisease").toString())) {
				click(endStageRenalDisease_Yes);
				ExtentSuccessMessage("Successfully Clicked On Total Premium Handle");
				selectByRandom(ESRDStartMonth);
				ExtentSuccessMessage("Successfully Select On ESRD Start Month");
				System.out.println("ESRD START YEAR :" + testdata.get("ESRDStartYear").toString());
				selectComboBoxValue(ESRDStartYear, testdata.get("ESRDStartYear").toString());
				ExtentSuccessMessage("Successfully Select On ESRD Start Year");
			} else {
				jsClick(endStageRenalDisease_No);
				ExtentSuccessMessage("Successfully Clicked On End Stage Renal Disease_No");
			}
			click(addInsurance);
			ExtentSuccessMessage("Successfully Clicked On addInsurance");
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// "Add Additional Insurance"
	public void addIHAAdditionalInsurance(Boolean value, Map<Object, Object> testdata) throws InterruptedException {
		WaitForPageLoad();
		scrollDown();
		if (!value) {
			jsClick(additionalInsurance_No);
			return;
		}
		jsClick(additionalInsurance_Yes);

		if (testdata.get("CoveredMember").toString().equalsIgnoreCase("Primary")) {
			try {
				selectComboBoxValue(coveredMember, getPrimaryMemberName());
			} catch (Exception e) {
				scrollDown();
				selectComboBoxValue(coveredMember, getPrimaryMemberName());

			}
		} else if (testdata.get("CoveredMember").toString().equalsIgnoreCase("Dependent")) {
			selectComboBoxValue(coveredMember, getDependentMemberName());
		}
		input(insuranceCarrierName, testdata.get("InsuranceCarrierName").toString());
		try {
			jsClick(totalPremiumHandle);
		} catch (Exception e) {

		}
		selectByRandom(insuranceType);
		input(insurancePolicyNumber, randomNumber(9) + "");
		// scrollDown();

		if (Boolean.parseBoolean(testdata.get("EndStageRenalDisease").toString())) {
			click(endStageRenalDisease_Yes);
			selectByRandom(ESRDStartMonth);
			selectComboBoxValue(ESRDStartYear, testdata.get("ESRDStartYear").toString());
		} else {
			jsClick(endStageRenalDisease_No);
		}
		clickAndInput(COBBeginDate, testdata.get("COBBeginDate").toString());
		scrollDown();
		input(carrierAddress1, testdata.get("CarrierAddress1").toString());
		input(carrierZip, testdata.get("CarrierZip").toString());
		selectByRandom(carrierCountry);
		selectByRandom(carrierCity);
		selectByRandom(carrierState);
		jsClick(activeWorkers_yes);

		click(addInsurance);
	}

	// "Get Primary Member Name"
	// @Attachment
	public String getPrimaryMemberName() throws InterruptedException {
		return GetElementText(primaryMemberName);
	}

	// "Get dependent Member Name"
	// @Attachment
	public String getDependentMemberName() throws InterruptedException {
		return GetElementText(dependentMemberName);
	}

	// "Get total rate"
	// @Attachment
	public String getTotalRate() throws InterruptedException {
		return GetElementText(totalRate);
	}

	// "Click Next")
	public void clickNext() throws InterruptedException {
		WaitForPageLoad();
		Thread.sleep(5000);
		scrollDown();
		jsClick(btnNext);
		if (ElementDisplayed(errorMessage)) {
			List<WebElement> enterCostElements = getDriver().findElements(enterCost);
			for (WebElement element : enterCostElements) {
				try {
					element.sendKeys("100");
					element.sendKeys(Keys.ENTER);
				} catch (Exception e) {

				}
			}
			scrollDown();
			jsClick(btnNext);
			ExtentSuccessMessage("Successfully clicked on the Next button");
		}
		WaitForAJAX_ToLoad();
		WaitForPageLoad();
	}

	// "Click Submit"
	public void Speridian_ClickSubmit() throws InterruptedException {
		click(speridian_btnSubmit);
		if (ElementDisplayed(errorMessage)) {
			List<WebElement> enterCostElements = getDriver().findElements(enterCost);
			for (WebElement element : enterCostElements) {
				try {
					element.sendKeys("100");
					element.sendKeys(Keys.ENTER);
				} catch (Exception e) {

				}
			}
			scrollDown();
			jsClick(speridian_btnSubmit);

		}
	}

	// "Add Profile"
	public void addProfileWithACH(Boolean isProfileAdd, String nameOfBank, String routingNo, boolean ACHCurrentMonth)
			throws InterruptedException {
		if (!isProfileAdd) {
			click(paymentProfile_no);
			return;
		}
		waitForElementClickable(addProfile);
		waitForElementClickable(addProfile, 50);
		jsClick(addProfile);
		WaitForPageLoad();
		input(nameOfTheBank, nameOfBank);
		input(bankAccountNumber, randomNumber(9) + "");
		input(routingNumber, routingNo);
		click(saveProfile);
		WaitForPageLoad();
		ExtentSuccessMessage("Successfully added the Payment details using ACH");
		/*
		 * try{ Thread.sleep(3000); } catch (Exception e){
		 * 
		 * }
		 */
		waitForElementClickable(ACHCurrentMonth_Yes);
		// Below code is not in UAT.
		// Ramya
		//		if (ACHCurrentMonth) {
		//			jsClick(ACHCurrentMonth_Yes);
		//		} else {
		//			jsClick(ACHCurrentMonth_No);
		//		}

	}

	// "Add Profile"
	//	public void addProfileWithACH(Boolean isProfileAdd, String nameOfBank, String routingNo, boolean ACHCurrentMonth)
	//			throws InterruptedException {
	//		if (!isProfileAdd) {
	//			click(paymentProfile_no);
	//			return;
	//		}
	//		waitForElementClickable(addProfile);
	//		waitForElementClickable(addProfile, 50);
	//		jsClick(addProfile);
	//		WaitForPageLoad();
	//		input(nameOfTheBank, nameOfBank);
	//		input(bankAccountNumber, randomNumber(9) + "");
	//		input(routingNumber, routingNo);
	//		click(saveProfile);
	//		WaitForPageLoad();
	//		ExtentSuccessMessage("Successfully added the Payment details using ACH");
	//		/*
	//		 * try{ Thread.sleep(3000); } catch (Exception e){
	//		 * 
	//		 * }
	//		 */
	//		waitForElementClickable(ACHCurrentMonth_Yes);
	//		// Below code is not in UAT.
	//		// Ramya
	////		if (ACHCurrentMonth) {
	////			jsClick(ACHCurrentMonth_Yes);
	////		} else {
	////			jsClick(ACHCurrentMonth_No);
	////		}
	//
	//	}

	//// "Submit Enrollment"
	// public void submitEnrollment() {
	// ExtentSuccessMessage("Entered in to submit Enrollment");
	// WaitForPageLoad();
	// scrollToElement(submit);
	// jsClick(submit);
	// if (ElementDisplayed(totalPlanAmount)) {
	// jsClick(totalPlanAmount);
	// }
	// waitForElementClickable(addProfile);
	// waitForElementClickable(addProfile, 50);
	// jsClick(addProfile);
	// WaitForPageLoad();
	// input(nameOfTheBank, nameOfBank);
	// input(bankAccountNumber, randomNumber(9) + "");
	// input(routingNumber, routingNo);
	// WaitForPageLoad();
	// jsClick(chk_automatic);
	// WaitForPageLoad();
	// click(saveProfile);
	// ExtentSuccessMessage("Successfully Added ACH Payment Profile");
	// WaitForPageLoad();
	// }
	// "Submit Enrollment"
	public void submitEnrollment() throws InterruptedException {
		try {
			WaitForPageLoad();
			Thread.sleep(2000);
			WaitForLoadAnimationDisappear();
			if(ElementDisplayed(submit)) {
				Log.info("Submit button visible");
				//	WaitForPageLoad();
				jsClick(submit);
				//new Actions(driver).moveToElement(driver.findElement(submit)).click().build().perform();
				ExtentSuccessMessage("Successfully Clicked on Submit button");
				Log.info("Successfully Clicked on Submit button");
			} else {
				Log.info("UnSuccessfully Not Clicked on Submit Button");
				ExtentErrorMessage("UnSuccessfully Not Visible on Submit Button");
			}
			WaitForLoadAnimationDisappear();
			WaitForPageLoad();
			Thread.sleep(2000);
			WaitForLoadAnimationDisappear();
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String FetchFullName() throws InterruptedException {
		String Fullname = GetElementText(FullnamefromTable);
		System.out.println("Fullname:-"+Fullname);
		ExtentSuccessMessage("Fullname:-"+Fullname);
		return Fullname;
	}

	public void addProfileWithPensionAuthority(boolean isProfileAdd) throws InterruptedException {
		if (!isProfileAdd) {
			waitForElementPresent(paymentProfile_no);
			jsClick(paymentProfile_no);
			return;
		}
		WaitForPageLoad();
		/*
		 * try{ Thread.sleep(3000); } catch (Exception e){
		 * 
		 * }
		 */
		waitForElementClickable(addProfile);
		if (ElementDisplayed(addProfile)) {
			click(btnNext);
		}
		click(addProfile);
		WaitForPageLoad();
		jsClick(pensionAuthority);
		waitForElementClickable(pensionAuthorityname);
		jsClick(pensionAuthorityname);
		waitForElementClickable(pensionAuthorityname, 10);
		waitForElementClickable(pensionAuthorityname);
		jsClick(FloridaRetirementSystem);
		jsClick(saveProfile);
		ExtentSuccessMessage("Successfully added the Payment details using Pension Authority");
	}

	public void declineAllCoverage() {
		WaitForPageLoad();
		waitForElementClickable(declineAllCoverage, 20);
		jsClick(declineAllCoverage);
		ExtentSuccessMessage("Succssfully clicked on declineAllCoverage Button");
		WaitForPageLoad();
		// type(declineReason,"Testing purpose");
		// jsClick(declineReasonSave);
		scrollDown();
		jsClick(additionalInsurance_No);
		ExtentSuccessMessage("Succssfully clicked on additional_Insurance_No Button");
	}

	public List<String> getAllThePlans() throws InterruptedException {

		waitForElementsVisible(allPlanCategories);
		List<String> allPlans = new ArrayList<>();
		List<WebElement> LstallPlanCategories = findElements(allPlanCategories);
		for (WebElement element : LstallPlanCategories) {
			allPlans.add(element.getText());

		}
		return allPlans;
	}

	public List<String> getSelectedCategories() {
		return categories;
	}

	// "Select plan {categoryName}"
	public void selectPlan(String categoryName) {
		WaitForPageLoad();
		waitForElementClickable(allPlanCategories);
		declineAllCoverage();
		List<WebElement> LstallPlanCategories = findElements(allPlanCategories);
		for (WebElement categoryEle : LstallPlanCategories) {
			String category = categoryEle.getText().trim();
			if (category.equalsIgnoreCase(categoryName)) {
				jsClick(By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@id,'IsDeclinedInd')]"));
				scrollUpVertically();
				categoryEle.click();
				WebElement selectPlanButton = getDriver().findElement(
						By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')]"));
				jSClick(selectPlanButton);
				ExtentSuccessMessage(category +" Plan is selected");
				break;
			}
		}
	}

	////////////////////////////////////// Improvments Enrollment Page BY Asif////////////////////////////////////

	// "Enter Effective Date")
	public void enterEffectiveDate(String date) throws InterruptedException {
		WaitForPageLoad();
		try {
			WaitForPageLoad();
			click(effectiveDate);
			ExtentSuccessMessage("Successfully Clicked ON Effective Date");
			input(effectiveDate, date);
			ExtentSuccessMessage("Successfully Entered date in Effective Date Field" +date);
			findElement(effectiveDate).sendKeys(Keys.TAB);
			Thread.sleep(30000);
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

	// Previouse_Button
	public void ClickOnPreviouseButton() throws InterruptedException {
		if (ElementDisplayed(L_Previouse_Button)) {
			click(L_Previouse_Button);
			Log.info("Successfully Clicked On Previouse Button");
			ExtentSuccessMessage("Successfully Clicked On Previouse Button");
		} else {
			Log.error("Unsuccessfully Not Clicked On Previouse Button");
			ExtentErrorMessage("Unsuccessfully Not Clicked On Previouse Button");
		}
	}

	public void ClickOnCancelButton() throws InterruptedException {
		if (ElementDisplayed(L_Cancel_Button)) {
			click(L_Cancel_Button);
			Log.info("Successfully Clicked On Cancel Button");
			ExtentSuccessMessage("Successfully Clicked On Cancel Button");
		} else {
			Log.error("Unsuccessfully Not Visible On Cancel Button");
			ExtentSuccessMessage("Unsuccessfully Not Visible On Cancle Button");
		}
	}

	public void Save_And_Finish_Letter_Button() throws InterruptedException {
		if (ElementDisplayed(L_Save_And_Finish_Letter_Button)) {
			click(L_Save_And_Finish_Letter_Button);
			Log.info("Successfully Clicked On L_Save_And_Finish_Letter_Button");
			ExtentSuccessMessage("Successfully Clicked On L_Save_And_Finish_Letter_Button");
		} else {
			Log.error("Unsuccessfully Visible On Save_And_Finish_Letter_Button");
			ExtentErrorMessage("UNsuccessfully Visible On Save_And_Finish_Letter_Button");
		}
	}

	//Pass the Decline_Plan_Name In String
	public void Decline_Button (String Value) throws InterruptedException {
		By xpath= By.xpath("//*[@data-categoryvalue='"+Value+"']//parent::div[@class='Enroll-Decline']");
		if(ElementDisplayed(xpath)) {
			click(xpath);
			System.out.println("Successfully Visible Value Decline_Button"+Value);
		}else {
			Log.error("UnSuccessfully Not Visible Value Decline_Button"+Value);
			ExtentErrorMessage("UnSuccessfully Not Visible Value Decline_Button"+Value);
		}
	}

	//Selects Dependent CheckBox
	public void dependentcheckbox(String value, String plan) {
		try {
//			WaitForLoadAnimationDisappear();
			By xpath =By.xpath("//div[@data-categoryvalue='"+plan+"']//*[contains(text(),'"+value+"')]/preceding-sibling::span/span/input");
			jsClick(xpath);
//			WaitForLoadAnimationDisappear();
			ExtentSuccessMessage("Successfully Checked Dependent checkbox" + value);
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}



	//Method to select 2 plans from the list of plans
	public List<Map<String, String>> selecttwoPlans(Boolean spouseSelected, String planName1, String planName2) {
		WaitForPageLoad();
		categories = new ArrayList<>();
		plans = new ArrayList<>();
		List<Map<String, String>> planValues = new ArrayList<>();
		List<WebElement> LstallPlanCategories = findElements(allPlanCategories);

		int selectedPlanCount = 0; // Variable to track the number of plans selected

		for (WebElement categoryEle : LstallPlanCategories) {
			String category = categoryEle.getText().trim();
			categories.add(category);

			if (!category.equalsIgnoreCase("Additional Insurance")) {
				// A condition to check if the category is equal to the input value
				if (category.equalsIgnoreCase(planName1) || category.equalsIgnoreCase(planName2)) {
					try {
						categoryEle.click();
					} catch (Throwable e) {
						scrollUpVertically();
						categoryEle.click();
					}

					WebElement selectPlanButton = getDriver().findElement(
							By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')]"));
					Map<String, String> values = new HashMap<>();
					values.put("category", selectPlanButton.getAttribute("data-categoryvalue"));
					values.put("totalRate", selectPlanButton.getAttribute("data-totalrate"));
					values.put("coverageLevel", selectPlanButton.getAttribute("data-coverageleveldisplayvalue"));
					values.put("planName", selectPlanButton.getAttribute("data-planname"));
					plans.add(selectPlanButton.getAttribute("data-planname"));
					jSClick(selectPlanButton);
					ExtentSuccessMessage(category +" Plan is selected");

					By by = By.xpath(
							"//input[contains(@data-planname,'" + selectPlanButton.getAttribute("data-planname").trim()
							+ "')][@placeholder='Enter Monthly Cost']");

					try {
						if (values.get("planName").toLowerCase().contains("bluemedicare elite rx pdp")
								|| values.get("planName").toLowerCase().contains("medical bridge")
								|| values.get("planName").toLowerCase().contains("hospital indemnity 150-1 unit rider entry")) {
							WebElement element = driver.findElement(by);
							input(by, "100");
							values.put("totalRate", "100");
						}
					} catch (Throwable e) {
						System.out.println("Input element is not displayed");
					}

					planValues.add(values);
					selectedPlanCount++;

					if (selectedPlanCount == 2) {
						break; // Break out of the loop after selecting 2 plans
					}
				} else {
					scrollUpVertically();
					jsClick(By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@id,'IsDeclinedInd')]"));
					jsClick(declineReasonSave);
				}
			}
		}
		return planValues;
	}

	//Click On Warning Ok Button
	public void ClickonWarningOkButton() throws InterruptedException {
		if(ElementDisplayed(L_WarningOkbtn)) {
			click(L_WarningOkbtn);
			Log.info("Successfully Clicked On Okay Warning Button");
			ExtentSuccessMessage("Successfully Clicked On Okay Warning Button");
		} else {
			Log.info("Unsuccessfully not Visible Okay Warning Button");
		}
	}

	//Method to select 4 plans from the list of plans
	public List<Map<String, String>> selectfourPlans(Boolean spouseSelected, String planName1, String planName2, String planName3, String planName4) {
		WaitForPageLoad();
		categories = new ArrayList<>();
		plans = new ArrayList<>();
		List<Map<String, String>> planValues = new ArrayList<>();
		List<WebElement> LstallPlanCategories = driver.findElements(allPlanCategories);

		int selectedPlanCount = 0; // Variable to track the number of plans selected

		for (WebElement categoryEle : LstallPlanCategories) {
			String category = categoryEle.getText().trim();
			categories.add(category);

			if (!category.equalsIgnoreCase("Additional Insurance")) {
				// A condition to check if the category is equal to any of the input values
				if (category.equalsIgnoreCase(planName1) || category.equalsIgnoreCase(planName2) || category.equalsIgnoreCase(planName3) || category.equalsIgnoreCase(planName4)) {
					try {
						categoryEle.click();
					} catch (Throwable e) {
						scrollUpVertically();
						categoryEle.click();
					}

					WebElement selectPlanButton;
					if (category.equalsIgnoreCase("Medical")) {
						selectPlanButton = getDriver().findElement(
								By.xpath("(//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')])[4]"));
					} else  {
						selectPlanButton = getDriver().findElement(
								By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')]"));

					}

					//	                WebElement selectPlanButton = driver.findElement(
					//	                        By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')]"));
					Map<String, String> values = new HashMap<>();
					values.put("category", selectPlanButton.getAttribute("data-categoryvalue"));
					values.put("totalRate", selectPlanButton.getAttribute("data-totalrate"));
					values.put("coverageLevel", selectPlanButton.getAttribute("data-coverageleveldisplayvalue"));
					values.put("planName", selectPlanButton.getAttribute("data-planname"));
					plans.add(selectPlanButton.getAttribute("data-planname"));
					jSClick(selectPlanButton);
					ExtentSuccessMessage(category + " Plan is selected");

					By by = By.xpath(
							"//input[contains(@data-planname,'" + selectPlanButton.getAttribute("data-planname").trim()
							+ "')][@placeholder='Enter Monthly Cost']");

					try {
						if (values.get("planName").toLowerCase().contains("bluemedicare elite rx pdp")
								|| values.get("planName").toLowerCase().contains("medical bridge")
								|| values.get("planName").toLowerCase().contains("hospital indemnity 150-1 unit rider entry")) {
							WebElement element = driver.findElement(by);
							click(by);
							input(by, "100" +Keys.TAB);
							if(!driver.findElement(by).getAttribute("value").contains("100")){
								ExtentSuccessMessage("Value is not entered through input method, trying out with javascript");
								WebElement element1 = driver.findElement(by);
								JavascriptExecutor js = (JavascriptExecutor)driver;
								js.executeScript("arguments[0].setAttribute('value', '100')", element1);
							}
							WaitForLoadAnimationDisappear();
							values.put("totalRate", "100");

							//							java.io.File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
							//
							//					        try {
							//					            // Save the screenshot to a file
							//					            FileUtils.copyFile(screenshotFile, new java.io.File("C:\\Users\\jayam\\screenshot.png"));
							//					        } catch (Exception e) {
							//					            e.printStackTrace();
							//					        }
						}
					} catch (Throwable e) {
						System.out.println("Input element is not displayed");
					}

					planValues.add(values);
					selectedPlanCount++;

					if (selectedPlanCount == 4) {
						break; // Break out of the loop after selecting 4 plans
					}
				} else {
					scrollUpVertically();
					jsClick(By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@id,'IsDeclinedInd')]"));
					jsClick(declineReasonSave);
				}
			}
		}
		return planValues;
	}

	//Method to select 4 plans from the list of Speridian plans
	public List<Map<String, String>> selectfourSperidianPlans(Boolean spouseSelected, String planName1, String planName2, String planName3, String planName4) throws InterruptedException {
		WaitForPageLoad();
		WaitForLoadAnimationDisappear();
		categories = new ArrayList<>();
		plans = new ArrayList<>();
		List<Map<String, String>> planValues = new ArrayList<>();
		List<WebElement> LstallPlanCategories = driver.findElements(allPlanCategories);
		String AllPlans =planName1+","+planName2+","+planName3+","+planName4;
		if(AllPlans.contains("FSA")) {
			ClickonFsa();
			InputFsa_Deposite();
			ClickonFsa();
		}
		if(AllPlans.contains("DCFSA")) {
			WaitForPageLoad();
			ClickOnDCFSA();
			InputDCFSA_Deposite();
			ClickOnDCFSA();
		}		


		int selectedPlanCount = 0; // Variable to track the number of plans selected

		for (WebElement categoryEle : LstallPlanCategories) {
			String category = categoryEle.getText().trim();
			categories.add(category);

			if (!category.equalsIgnoreCase("Additional Insurance")) {
				// A condition to check if the category is equal to any of the input values
				if (category.equalsIgnoreCase(planName1) || category.equalsIgnoreCase(planName2) || category.equalsIgnoreCase(planName3) || category.equalsIgnoreCase(planName4)) {
					try {
						categoryEle.click();
					} catch (Throwable e) {
						scrollUpVertically();
						categoryEle.click();
					}

					WebElement selectPlanButton;
					if (category.equalsIgnoreCase("Medical")) {
						selectPlanButton = getDriver().findElement(
								By.xpath("(//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')])[1]"));
					} else  {
						selectPlanButton = getDriver().findElement(
								By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')]"));

					}

					//	                WebElement selectPlanButton = driver.findElement(
					//	                        By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')]"));
					Map<String, String> values = new HashMap<>();
					values.put("category", selectPlanButton.getAttribute("data-categoryvalue"));
					values.put("totalRate", selectPlanButton.getAttribute("data-totalrate"));
					values.put("coverageLevel", selectPlanButton.getAttribute("data-coverageleveldisplayvalue"));
					values.put("planName", selectPlanButton.getAttribute("data-planname"));
					plans.add(selectPlanButton.getAttribute("data-planname"));
					jSClick(selectPlanButton);
					ExtentSuccessMessage(category + " Plan is selected");

					By by = By.xpath(
							"//input[contains(@data-planname,'" + selectPlanButton.getAttribute("data-planname").trim()
							+ "')][@placeholder='Enter Monthly Cost']");

					try {
						if (values.get("planName").toLowerCase().contains("bluemedicare elite rx pdp")
								|| values.get("planName").toLowerCase().contains("medical bridge")
								|| values.get("planName").toLowerCase().contains("hospital indemnity 150-1 unit rider entry")) {
							WebElement element = driver.findElement(by);
							input(by, "100");
							values.put("totalRate", "100");
						}
					} catch (Throwable e) {
						System.out.println("Input element is not displayed");
					}

					planValues.add(values);
					selectedPlanCount++;

					if (selectedPlanCount == 4) {
						//							break; // Break out of the loop after selecting 4 plans
					}
				} else {
					scrollUpVertically();
					jsClick(By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@id,'IsDeclinedInd')]"));
					jsClick(declineReasonSave);
				}
			}
		}
		return planValues;
	}

	//Method to select 3 plans from the list of plans
	public List<Map<String, String>> selectthreePlans(Boolean spouseSelected, String planName1, String planName2, String planName3) throws InterruptedException {
		WaitForPageLoad();
		categories = new ArrayList<>();
		plans = new ArrayList<>();
		List<Map<String, String>> planValues = new ArrayList<>();
		List<WebElement> LstallPlanCategories = findElements(allPlanCategories);

		int selectedPlanCount = 0; // Variable to track the number of plans selected

		for (WebElement categoryEle : LstallPlanCategories) {
			String category = categoryEle.getText().trim();
			categories.add(category);

			if (!category.equalsIgnoreCase("Additional Insurance")) {
				// A condition to check if the category is equal to the input value
				if (category.equalsIgnoreCase(planName1) || category.equalsIgnoreCase(planName2) || category.equalsIgnoreCase(planName3)) {
					try {
						categoryEle.click();
					} catch (Throwable e) {
						scrollUpVertically();
						categoryEle.click();
					}

//					WebElement selectPlanButton;
//					if (category.equalsIgnoreCase("Medical")) {
//						selectPlanButton = getDriver().findElement(
//								By.xpath("(//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')])[4]"));
//					} else  {
//						selectPlanButton = getDriver().findElement(
//								By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')]"));
//
//					}
					WebElement selectPlanButton = driver.findElement(
							By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@class,'radio')]"));
					Map<String, String> values = new HashMap<>();
					values.put("category", selectPlanButton.getAttribute("data-categoryvalue"));
					values.put("totalRate", selectPlanButton.getAttribute("data-totalrate"));
					values.put("coverageLevel", selectPlanButton.getAttribute("data-coverageleveldisplayvalue"));
					values.put("planName", selectPlanButton.getAttribute("data-planname"));
					plans.add(selectPlanButton.getAttribute("data-planname"));
					jSClick(selectPlanButton);
					ExtentSuccessMessage(category +" Plan is selected");

					By by = By.xpath(
							"//input[contains(@data-planname,'" + selectPlanButton.getAttribute("data-planname").trim()
							+ "')][@placeholder='Enter Monthly Cost']");

					try {
						if (values.get("planName").toLowerCase().contains("bluemedicare elite rx pdp")
								|| values.get("planName").toLowerCase().contains("medical bridge")
								|| values.get("planName").toLowerCase().contains("hospital indemnity 150-1 unit rider entry")) {
							WebElement element = driver.findElement(by);
							input(by, "100");
							values.put("totalRate", "100");
						}
					} catch (Throwable e) {
						System.out.println("Input element is not displayed");
					}

					planValues.add(values);
					selectedPlanCount++;

					if (selectedPlanCount == 3) {
//						break; // Break out of the loop after selecting 2 plans
					}
				} else {
					scrollUpVertically();
					jsClick(By.xpath("//input[@data-categoryvalue='" + category + "'][contains(@id,'IsDeclinedInd')]"));
					jsClick(declineReasonSave);
				}
			}
		}
		return planValues;
	}

}
