package com.BasePackage;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;
import com.github.javafaker.Faker;
import com.google.common.base.Function;


public class Base_Class {

	public static RemoteWebDriver driver = null;
	public static By L_username = By.xpath("//input[@id='UserName']|//a/i[@class='material-icons useradmin-ico']");
	public static By L_password = By.xpath("//input[@id='Password']");
	public static By L_LogIn = By.xpath("//button[contains(text(),'Login')]|//button[contains(text(),'Sign In')]");
	//Ramya - 9/27
	public static By L_BusyAnimation = By.xpath("//div[@class='ajax_overlay']");
	public static String Pagetitle;
	private static By AcceptCookies = By.xpath("//*[@id='accept']");
	private static By SessionPopUPOk = By.id("ok");
	private static String MainMenu = "//*[text()='%s']";
	private static String SubMenu = "//*[contains(@item-label,'%s')]";
	private static String MenuItem = "//li[contains(text(),'%s')]";
	public static String DownloadDirectory = System.getProperty("user.dir") + "\\Download\\";
	private static String gridRows = "//div[@role='row']";
	private static By L_LitigationTabrefresh = By.id("refresh");

	// Ramya to pass userType
	public static String loginuser_Type = "";
	public static String TenanatName = "";
	public static String URL = "";

	public WebDriver getDriver() {
		return this.driver;
	}

	public static Properties configloader() throws IOException {
		FileInputStream File = new FileInputStream(".\\src\\test\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(File);
		return properties;
	}

	public void SetUp(String ReferenceLogin) throws IOException, InterruptedException {
		String Browser = configloader().getProperty("Browser");
		TenanatName =ReferenceLogin;
		URL = configloader().getProperty(ReferenceLogin+"_URL");

		String UserName = null;
		String Password = null;
		loginuser_Type = configloader().getProperty(ReferenceLogin+"UAT_Type");



		//		loginuser_Type = configloader().getProperty("UAT_Type");
		String ReferenceLogins = ReferenceLogin + loginuser_Type;
		for (String key : configloader().stringPropertyNames()) {
			String value = configloader().getProperty(key);
			if (key.contains(ReferenceLogins)) {
				String KeyValue = key + ";" + value;
				String replaceKeyValue = KeyValue.replace(ReferenceLogins + "_", "");
				if (replaceKeyValue.contains("UserName")) {
					UserName = replaceKeyValue;
					String[] arrOfUserName = UserName.split(";");
					UserName = arrOfUserName[1];
				}
				if (replaceKeyValue.contains("Password")) {
					Password = replaceKeyValue;
					String[] arrOfPassword = Password.split(";");
					Password = arrOfPassword[1];
				}

			}
		}
		System.out.println("Final URL " + URL);
		System.out.println("Final username fetch :" + UserName);
		System.out.println("Final Password fetch :" + Password);
		String downloadFilepath = System.getProperty("user.dir") + "\\Download";
		Map<String, Object> preferences = new Hashtable<String, Object>();
		preferences.put("profile.default_content_settings.popups", 0);
		preferences.put("download.prompt_for_download", "false");
		preferences.put("download.default_directory", downloadFilepath);
		DeleteFiles(downloadFilepath);

		switch (Browser.toUpperCase()) {

		case "CHROME":
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			ChromeOptions options = new ChromeOptions();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.addArguments("--disable-extensions");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-setuid-sandbox");
			options.setExperimentalOption("prefs", preferences);
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			break;

		case "FIREFOX":
			driver = new FirefoxDriver();
			break;

		default:
			System.err.println("The Driver is not defined");

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ExtentSuccessMessage("Driver has initialized successfully for " + Browser + "browser");
		driver.get(URL);
		// Thread.sleep(5000); --Ramya
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		Pagetitle = driver.getTitle();
		ExtentSuccessMessage("Title is displayed : " + Pagetitle);
		Log.info("Title is displayed : " + Pagetitle);
		input(L_username, UserName);
		input(L_password, Password);
		click(L_LogIn);

		// --Ramya --Thread.sleep(10000);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		// RefreshPage();
	}
	public void SetUp1(String ReferenceLogin) throws IOException, InterruptedException {
		String Browser = configloader().getProperty("Browser");
		loginuser_Type = configloader().getProperty(ReferenceLogin+"UAT_Type");
		if(ReferenceLogin.contains("Speridian")) {
			URL = configloader().getProperty("Speridian_URL");
		}if(ReferenceLogin.contains("FBMC")) {
			URL = configloader().getProperty("FBMC_URL");
		}if(ReferenceLogin.contains("IHA")) {
			URL = configloader().getProperty("IHA_URL");
		}

		String UserName = null;
		String Password = null;
		String ReferenceLogins = ReferenceLogin;
		for (String key : configloader().stringPropertyNames()) {
			String value = configloader().getProperty(key);
			if (key.contains(ReferenceLogins)) {
				String KeyValue = key + ";" + value;
				String replaceKeyValue = KeyValue.replace(ReferenceLogins + "_", "");
				if (replaceKeyValue.contains("UserName")) {
					UserName = replaceKeyValue;
					String[] arrOfUserName = UserName.split(";");
					UserName = arrOfUserName[1];
				}
				if (replaceKeyValue.contains("Password")) {
					Password = replaceKeyValue;
					String[] arrOfPassword = Password.split(";");
					Password = arrOfPassword[1];
				}

			}
		}
		System.out.println("Final URL " + URL);
		System.out.println("Final username fetch :" + UserName);
		System.out.println("Final Password fetch :" + Password);
		String downloadFilepath = System.getProperty("user.dir") + "\\Download";
		Map<String, Object> preferences = new Hashtable<String, Object>();
		preferences.put("profile.default_content_settings.popups", 0);
		preferences.put("download.prompt_for_download", "false");
		preferences.put("download.default_directory", downloadFilepath);
		DeleteFiles(downloadFilepath);

		switch (Browser.toUpperCase()) {

		case "CHROME":
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			ChromeOptions options = new ChromeOptions();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.addArguments("--disable-extensions");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-setuid-sandbox");
			options.setExperimentalOption("prefs", preferences);
			driver = new ChromeDriver(options);
			break;

		case "FIREFOX":
			driver = new FirefoxDriver();
			break;

		default:
			System.err.println("The Driver is not defined");

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ExtentSuccessMessage("Driver has initialized successfully for " + Browser + "browser");
		driver.get(URL);
		// Thread.sleep(5000); --Ramya
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		Pagetitle = driver.getTitle();
		ExtentSuccessMessage("Title is displayed : " + Pagetitle);
		Log.info("Title is displayed : " + Pagetitle);
		input(L_username, UserName);
		input(L_password, Password);
		click(L_LogIn);

		// --Ramya --Thread.sleep(10000);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		// RefreshPage();
	}

	public void IHALogin(String ReferenceLogin) throws InterruptedException, IOException {
		String UserName = null;
		String Password = null;

		for (String key : configloader().stringPropertyNames()) {
			String value = configloader().getProperty(key);
			if (key.contains(ReferenceLogin)) {
				String KeyValue = key + ";" + value;
				String replaceKeyValue = KeyValue.replace(ReferenceLogin + "_", "");
				if (replaceKeyValue.contains("UserName")) {
					UserName = replaceKeyValue;
					String[] arrOfUserName = UserName.split(";");
					UserName = arrOfUserName[1];
				}
				if (replaceKeyValue.contains("Password")) {
					Password = replaceKeyValue;
					String[] arrOfPassword = Password.split(";");
					Password = arrOfPassword[1];
				}
			}
			System.out.println("Final username fetch :" + UserName);
			System.out.println("Final username fetch :" + Password);
			input(L_username, UserName);
			ExtentSuccessMessage("Entered the USerName Successfully");
			Log.info("Title is displayed : " + Pagetitle);
			input(L_password, Password);
			ExtentSuccessMessage("Entered the Password Successfully");
			Log.info("Entered the Password");
			click(L_LogIn);
			ExtentSuccessMessage("Successfully signed into IHA Application");
			Log.info("Clicked on SignIn button");
			Thread.sleep(5000);
		}
	}

	public void SwitchingIntoTab(String UrlWorking1) throws InterruptedException {
		Thread.sleep(2000);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));
		driver.navigate().to(UrlWorking1);
		Thread.sleep(2000);
		Pagetitle = driver.getTitle();
		Log.info("Title is displayed : " + Pagetitle);
		driver.switchTo().window(newTab.get(0));
		driver.close();
		switchToWindowByTitle(Pagetitle);
	}

	public void SwitchBetweenTab(int TabNo) {
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(TabNo));
	}

	public static void WaitForPageLoad() {
		// ExtentSuccessMessage("Waiting for webpage to load completely");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				Boolean isLoaded = false;
				JavascriptExecutor js = (JavascriptExecutor) arg0;
				if (js.executeScript("return document.readyState").toString().equalsIgnoreCase("complete")) {
					isLoaded = true;
					// ExtentSuccessMessage("Web page loaded successfully");
				}
				return isLoaded;
			}
		};
		wait.until(function);

	}

	public void ScrolltillElementOnmiddlepage(By Value) {
		WebElement element = driver.findElement(Value);
		JavascriptExecutor js = driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);
		//		ExtentSuccessMessage("Successfully scroll down to the element :" + element);
		Log.info("Successfully scroll down to the element :" + element);
	}

	public static void DeleteFiles(String Path) {
		File directory = new File(Path);
		if (!directory.exists())
			directory.mkdir();

		for (File file : Objects.requireNonNull(directory.listFiles())) {
			if (!file.isDirectory()) {
				file.delete();
			}
		}
	}

	public static void ExtentSuccessMessage(String strPassSuccessMessage) {
		ExtentTestManager.getTest().log(Status.PASS, strPassSuccessMessage);
	}

	public static void ExtentErrorMessage(String strPassErrorMessage) {
		ExtentTestManager.getTest().log(Status.FAIL, strPassErrorMessage);
	}

	public static void input(By element, String Value) throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(Value);
	}

	public static void click(By element) throws InterruptedException {
		// Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20),Duration.ofSeconds(0));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		// Thread.sleep(2000);
	}

	public void jSClick1(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			js.executeScript("arguments[0].click();", element);
			Log.info("Element is clicked");
		} catch (Throwable e) {
			Log.error("Element is not clicked");
		}
	}

	public void Rightclick(By element) throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(element);
		actions.contextClick(elementLocator).perform();
	}

	public void select(String value, By element) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		WebElement option = driver.findElement(By.xpath("//*[contains(text(),'" + value + "')]"));
		option.click();
	}

	public WebElement findElement(By by) {
		WebElement element = waitForElementVisible(by);
		if (element != null) {
			return element;
		}
		return driver.findElement(by);
	}

	public WebElement waitForElementVisible(By by) {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (NoSuchElementException | TimeoutException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void SelectDropDownValues(By Locator, String Value) throws InterruptedException {
		Thread.sleep(2000);
		if (ElementDisplayed(Locator)) {
			click(Locator);
			ExtentSuccessMessage("Successfully click On Dropdown ");
			Thread.sleep(1000);
			By i = By.xpath("//option[text()='" + Value + "']");
			click(i);
			ExtentSuccessMessage("Successfully clicked and select value from dropdown : " + Value);
			Log.info("Successfully clicked and select value from dropdown : " + Value);
		} else {
			ExtentErrorMessage("Dropdown element not able to select dropdown value : " + Value);
			Log.error("Dropdown element not able to select dropdown value : " + Value);
		}

	}
	public void SelectDropDownValues1(By Locator, String Value) throws InterruptedException {
		Thread.sleep(2000);
		if (ElementDisplayed(Locator)) {
			click(Locator);
			ExtentSuccessMessage("Successfully click On Dropdown ");
			Thread.sleep(1000);
			By i = By.xpath("//option[text()='" + Value + "']");
			List<WebElement> terminatedPlans = driver.findElements(i);
			for (WebElement element : terminatedPlans) {
				if(element.isDisplayed()) {
					element.click();

				}else {

				}

			}

			ExtentSuccessMessage("Successfully clicked and select value from dropdown : " + Value);
			Log.info("Successfully clicked and select value from dropdown : " + Value);
		} else {
			ExtentErrorMessage("Dropdown element not able to select dropdown value : " + Value);
			Log.error("Dropdown element not able to select dropdown value : " + Value);
		}

	}

	public String SelectDropdownValue(By Element, String Value) throws InterruptedException {
		if (ElementDisplayed(Element)) {
			Log.info("Element is visible");
			click(Element);
			Log.info("Successfully clicked on Element ");
		} else {
			Log.error("Element is not Visible");
		}
		String option = null;
		String id = Element.toString().replaceAll("By.id: ", "");
		System.out.println("Print id : " + id);
		String Xpath = "(//*[@id='" + id + "']//parent::div//select//option[text()='" + Value + "'])[1]";
		WebElement webelements = driver.findElement(By.xpath(Xpath));
		if (webelements.isDisplayed()) {
			Log.info("WebElement is Visible");
			option = webelements.getText();
			Log.info("Print Text " + option);
			Thread.sleep(2000);
			webelements.click();
			Log.info("Successfully clicked on WebElement ");

		} else {
			Log.error("WebElement is not Visible");
		}
		return option;
	}

	public void SelectDropDownValue1(By Locator, String Value) throws InterruptedException {
		if (ElementDisplayed(Locator)) {
			click(Locator);
			ExtentSuccessMessage("Successfully click On Dropdown ");
			Thread.sleep(2000);
			By i = By.xpath("//*[text()='Contact']//parent::div//following-sibling::select//*[text()='" + Value + "']");
			click(i);
			ExtentSuccessMessage("Successfully clicked and select value from dropdown : " + Value);
		} else {
			Log.error("Dropdown element not able to select dropdown value : " + Value);
		}

	}

	public static void PageRefresh() throws InterruptedException {
		driver.navigate().refresh();
	}

	public void SelectDropDownValue(By Locator, String Value) throws InterruptedException {
		if (ElementDisplayed(Locator)) {
			click(Locator);
			ExtentSuccessMessage("Successfully click On Dropdown ");
			Thread.sleep(2000);
			By i = By.xpath("//*[text()='" + Value + "']");

			click(i);
			ExtentSuccessMessage("Successfully clicked and select value from dropdown : " + Value);
		} else {
			Log.error("Dropdown element not able to select dropdown value : " + Value);
		}

	}


	public void SelectDropDownValueById(By Locator, String Value) throws InterruptedException {
		if (ElementDisplayed(Locator)) {
			click(Locator);
			ExtentSuccessMessage("Successfully click On Dropdown ");
			Thread.sleep(1000);
			By i = By.xpath("//*[contains(@id,'CreateUser_SecurityQuestionId_chzn_o_')][text()='" + Value + "']");

			click(i);
			ExtentSuccessMessage("Successfully clicked and select value from dropdown : " + Value);
		} else {
			Log.error("Dropdown element not able to select dropdown value : " + Value);
		}

	}
	public void SelectDropDownOption(By Locator, String Value) throws InterruptedException {
		if (ElementDisplayed(Locator)) {
			click(Locator);
			ExtentSuccessMessage("Successfully click On Dropdown ");
			Thread.sleep(1000);
			//			By i = By.xpath("//*[text()='" + Value + "']//parent::div");
			By i = By.xpath("//*[text()='" + Value + "']//ancestor::td[1]");
			click(i);
			ExtentSuccessMessage("Successfully clicked and select value from dropdown : " + Value);
		} else {
			Log.error("Dropdown element not able to select dropdown value : " + Value);
		}

	}

	public void SelectDropDown_Only_Value(By Locator, String Value) throws InterruptedException {
		if (ElementDisplayed(Locator)) {
			click(Locator);
			Log.info("Successfully click On Dropdown ");
			Thread.sleep(1000);
			By i = By.xpath("//*[text()='" + Value + "']");
			click(i);
			Log.info("Successfully clicked and select value from dropdown : " + Value);
		} else {
			Log.error("Dropdown element not able to select dropdown value : " + Value);
		}
	}

	public void SelectDropDownValue_Iframe(By Locator, String Value, String frameid) throws InterruptedException {
		if (ElementDisplayed(Locator)) {
			click(Locator);
			ExtentSuccessMessage("Successfully click On Dropdown ");
			driver.switchTo().frame(frameid);
			Thread.sleep(1000);
			By i = By.xpath("//*[@role='option'] //*[text()='" + Value + "']");
			click(i);
			driver.switchTo().parentFrame();
			ExtentSuccessMessage("Successfully clicked and select value from dropdown : " + Value);
		} else {
			Log.error("Dropdown element not able to select dropdown value : " + Value);
		}
	}

	public void ScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void SelectDropDownValue_after_scrolling(By Locator, String Value) throws InterruptedException {
		JavascriptExecutor je = driver;
		WebElement element = driver.findElement(By.xpath("//*[text()='" + Value + "']"));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		System.out.println(element.getText());
		if (ElementDisplayed(Locator)) {
			click(Locator);
			ExtentSuccessMessage("Successfully click On Dropdown ");
			Thread.sleep(1000);
			By i = By.xpath("//*[@role='option']//*[text()='" + Value + "']");
			click(i);
			ExtentSuccessMessage("Successfully clicked and select value from dropdown : " + Value);
		} else {
			Log.error("Dropdown element not able to select dropdown value : " + Value);
		}
	}

	public void SelectDropDownValue1(String PLocator, By Locator, String Value) throws InterruptedException {
		if (ElementDisplayed(Locator)) {
			click(Locator);
			ExtentSuccessMessage("Successfully click On Dropdown ");
			Thread.sleep(1000);
			WebElement element = driver.findElement(By.xpath(String.format(PLocator, Value)));
			element.click();
			ExtentSuccessMessage("Successfully clicked and select value from dropdown :" + Value);
			// ScrollUntilElementVisible(FindElementByText(Value));
			/*
			 * By i = By.xpath("//*[@role='option'] //*[text()='"+Value+"']"); click(i);
			 */
			ExtentSuccessMessage("Successfully clicked and select value from dropdown :" + Value);

		} else {
			Log.error("Dropdown element not able to select dropdown value :" + Value);
		}
	}

	public void scrollToElement(By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(by);
		js.executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,
				element.getLocation().y);
		// Log.info(element);
	}

	public void SelectDropDownValueByScroll(By Locator, String Value) throws InterruptedException, AWTException {
		click(Locator);
		int listboxHeight = driver.findElement(By.xpath("//div[@id='innerListBoxdiary_type_code']")).getSize().height;
		int dropdownHeight = driver.findElement(By.xpath("//div[@id='innerListBoxdiary_type_code']")).getSize().height;
		int listItemHeight = driver.findElement(By.xpath("//div[contains(@id,'listitem')]/span[text()]"))
				.getSize().height;
		int tempHeight = dropdownHeight;
		By dropdownDownArrow = By.xpath(
				"//div[@id='innerListBoxdiary_type_code']//div[@id='jqxScrollAreaDownverticalScrollBarinnerListBoxdiary_type_code']");
		By element = By.xpath("//span[text()='" + Value + "']");

		while (driver.findElements(element).size() <= 0 && tempHeight < listboxHeight) {
			click(dropdownDownArrow);
			tempHeight += listItemHeight;
		}
		click(element);
	}

	public void SelectDropDownValueByScroll_new(By Locator, String Value) throws InterruptedException, AWTException {
		click(Locator);

		int listboxHeight = driver.findElement(By.xpath("//div[@id='filterinnerListBoxtime_tracking_type']"))
				.getSize().height;
		int dropdownHeight = driver.findElement(By.xpath("//div[@id='filterinnerListBoxtime_tracking_type']"))
				.getSize().height;
		int listItemHeight = driver.findElement(By.xpath("//div[contains(@id,'listitem')]/span[text()]"))
				.getSize().height;
		int tempHeight = dropdownHeight;
		By dropdownDownArrow = By.xpath("//div[@id='dropdownlistArrowtime_tracking_type']");
		By element = By.xpath("//span[text()='" + Value + "']");

		while (driver.findElements(element).size() <= 0 && tempHeight < listboxHeight) {
			click(dropdownDownArrow);
			tempHeight += listItemHeight;
		}
		click(element);
	}

	public static void DoubleClick(By element) throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(element);
		actions.doubleClick(elementLocator).perform();
	}

	public static void clear(By element) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
		Thread.sleep(2000);
	}

	public static void AcceptAlert() {
		driver.switchTo().frame(1);
		driver.getWindowHandles();
		driver.switchTo().alert().accept();

	}

	public static String GetTextFromAlertPoppup() {
		String a = driver.switchTo().alert().getText();
		Log.info(a);
		return a;
	}

	public static void WaitForLoadAnimationDisappear() throws InterruptedException {
		Log.info("Wait for the busy icon to disappear.");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.pollingEvery(Duration.ofMillis(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(L_BusyAnimation));
		Log.info("Wait for the busy icon to disappear completed.");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void ScrollUntilElementVisible(By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		ExtentSuccessMessage("Successfully scroll down to the element :" + element);
	}

	public static void ScrollUntilElementVisible(WebElement element) {
		JavascriptExecutor js = driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		ExtentSuccessMessage("Successfully scroll down to the element :" + element);
	}

	public static boolean ElementDisplayed(By locator){
		Boolean flag = false;
		try {
			WebElement element = driver.findElement(locator);
			flag = element.isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
			Log.info("Excption Successfully System able to found the element :" + locator + e.getMessage());
		}
		if (flag) {
			Log.info("Successfully System able to found the element :" + locator);
			return flag;
		} else {
			Log.info("System not able to found the element :" + locator);
			flag = false;
		}
		return flag;
	}

	public static boolean ElementEnabled(By locator){
		Boolean flag = false;
		try {
			WebElement element = driver.findElement(locator);
			flag = element.isEnabled();
		} catch (Exception e) {
			// TODO: handle exception
			Log.info("Excption Successfully System able to found the element :" + locator + e.getMessage());
		}
		if (flag) {
			Log.info("Successfully System able to found the element :" + locator);
			return flag;
		} else {
			Log.info("System not able to found the element :" + locator);
			flag = false;
		}
		return flag;
	}

	public static boolean ElementsDisplayed(By locator) throws InterruptedException {
		List<WebElement> element = driver.findElements(locator);
		Boolean flag = false;
		if (element.size() > 0) {
			flag = true;
			ExtentSuccessMessage("System able to found the element :" + locator);
		} else {
			ExtentSuccessMessage("System not able to found the element :" + locator);
			flag = false;
		}
		return flag;
	}

	public void selectComboBoxValue(By by, String value) {
		String locator = by.toString();
		String id = null;
		// if(!getAttribute(by,"title").equals("")) {
		if (locator.contains("id")) {
			id = by.toString().replaceAll("By.id: ", "");
		}
		try {
			driver.findElement(by).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//li[starts-with(@id,'" + id + "')][contains(text(),'" + value + "')]"))
			.click(); // Thread.sleep(3000);

		} catch (Throwable e) {
			driver.findElement(by).click();
			driver.findElement(By.xpath("//li[starts-with(@id,'" + id + "')][contains(text(),'" + value + "')][2]"))
			.click();
		}
	}

	public WebElement waitForElementClickable(By by, int wait) {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(50)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void jSClick(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			js.executeScript("arguments[0].click();", element);
			Log.info("Element is clicked");
		} catch (Throwable e) {
			Log.error("Element is not clicked");
		}
	}
	public void jSClicks1(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String jsQuery= "document.querySelector('attribute value').click();";
		js.executeScript(jsQuery);
	}

	public void waitUntilSearchCompletesInWebTable(By by) {
		try {
			Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class);
			WebElement table = driver.findElement(by);
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					int elementCount = table.findElements(By.xpath(".//tr")).size();
					if (elementCount == 2)
						return true;
					else
						return false;
				}
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String GetElementText(By locator) throws InterruptedException {

		String stxt = null;
		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			stxt = element.getText();
			Log.info("System able to found the element :" + locator);
		} else {
			Log.error("System not able to found the element :" + locator);
		}
		return stxt;
	}

	public String randomString(int count) {
		String ALPHA_NUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(count);
		while (count-- != 0) {
			int index = (int) (Math.random() * ALPHA_NUMERIC.length());
			sb.append(ALPHA_NUMERIC.charAt(index));
		}
		return sb.toString();

	}

	public static boolean ElementEnableOrDisable(By locator) {
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isEnabled();
		return flag;
	}

	public static boolean CheckElementDisable(By locator) {
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isEnabled();
		if (flag == false) {
			flag = true;
		} else if (flag == true)
			flag = false;
		return flag;
	}

	public Boolean waitForElementSelectable(By by) {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementSelectionStateToBe(by, true));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public static void UploadFile(By locator, String path) {
		WebElement uploadElement = driver.findElement(locator);
		uploadElement.sendKeys(path);
	}

	// Finding the total number of elements that have the tag “iframe”

	public static void getListofIframe() {
		List<WebElement> iframes = driver.findElements(By.xpath("//iframe|//frame"));
		ExtentSuccessMessage("iFrame info :- Total number of iFrame present on the Pagetitle '" + Pagetitle + "' = "
				+ iframes.size());
		int count = 1;
		for (WebElement iframe : iframes) {
			String strIframeID = iframe.getAttribute("id");
			String strIframeName = iframe.getAttribute("name");
			ExtentSuccessMessage("iFrame" + count + " : Id = " + strIframeID + " , Name = " + strIframeName);
			count++;
		}
	}

	public static void SwitchToFrame(By frameName) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
	}

	public static void SwitchToFrameByID(By frameID) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameID));
	}

	public static void GetListOFWindowHandler() {
		String parent = driver.getWindowHandle();
		Set<String> Winhandles = driver.getWindowHandles();
		for (String hndl : Winhandles) {
			// if(!hndl.equalsIgnoreCase(parent))
			// {
			driver.switchTo().window(hndl);
			System.out.println("New Tab Window Title:" + driver.getTitle());
			// System.out.println("New Tab Window Page Heading: "+
			// driver.findElement(By.xpath("//*[@id=\"main\"]/h1")).getText());
			// }

		}
	}

	public void selectByIndex(By by, int index) {
		WebElement element = findElement(by);
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			System.out.println("Option at index " + index + " is Selected from the DropDown");
		} catch (NoSuchElementException e) {
			System.out.println("Option at index " + index + " is  not Selected from the DropDown");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void HandelAlertText() throws InterruptedException {
		driver.switchTo().alert().accept();
	}

	public void switchToWindowByTitle(String title) {
		boolean foundWindow = false;
		for (String handle : driver.getWindowHandles()) {
			if (driver.switchTo().window(handle).getTitle().equalsIgnoreCase(title)) {
				ExtentSuccessMessage("Successfully Switched to window with title:" + title);
				foundWindow = true;
				break;
			}
		}
		if (foundWindow) {
			System.out.println("Couldn't find the window with title -> " + title + "\nSwitching to parent window.");
		}
	}

	public static void SwitchToDefaultF() {
		driver.switchTo().defaultContent();
	}

	public static void DatePicker1(String strMonth) {
		try {
			click(By.xpath(
					"//*[text()='Incident From']//parent::td//following-sibling::td[1]/div/div/input//following-sibling::div[1]"));
			Thread.sleep(1000);
			do {
				click(By.xpath("//*[contains(text(),'July')]//parent::td//preceding-sibling::td"));
			} while (strMonth.equalsIgnoreCase("july"));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void DatePicker(String strFieldName, String strDate) throws InterruptedException {
		String DateFromExcel = strDate.trim();
		ExtentSuccessMessage("Date fetch from excel :" + DateFromExcel);
		String arrdate[] = DateFromExcel.split(" ");
		String date = arrdate[0].trim(); // "1";
		String month = arrdate[1].trim(); // "February";
		String year = arrdate[2].trim(); // "2022";

		ExtentSuccessMessage("Date fetch from excel with splitted value :" + date + " " + month + " " + year);

		Log.info("Date fetch from excel with splitted value :" + date + " " + month + " " + year);
		click(By.xpath("//*[text()='" + strFieldName
				+ "']//parent::td//following-sibling::td[1]/div/div/input//following-sibling::div[1]"));
		Thread.sleep(3000);
		click(By.xpath("//*[@align='left']//*[text()='Clear']"));

		try {
			Thread.sleep(1000);
			click(By.xpath("//*[text()='" + strFieldName
					+ "']//parent::td//following-sibling::td[1]/div/div/input//following-sibling::div[1]"));
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			Log.error("System catch error while clicking left arrow on date picker");
			e.printStackTrace();
		}
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			MouseHoverOnElement(By.xpath("(//td[@aria-live='assertive' and @align='center']//div)[1]"));
			String monthyear = driver
					.findElement(By.xpath("(//td[@aria-live='assertive' and @align='center']//div)[1]")).getText()
					.trim();
			if (monthyear.isBlank()) {
				MouseHoverOnElement(By.xpath("(//td[@aria-live='assertive' and @align='center']//div)[2]"));
				String mothyear1 = driver
						.findElement(By.xpath("(//td[@aria-live='assertive' and @align='center']//div)[2]")).getText()
						.trim();
				System.out.println("Debug vaue for index 2 :" + mothyear1);
				monthyear = mothyear1;
			}
			// System.out.println("Debug message print monthyear:"+monthyear);
			String arr[] = monthyear.split(" ");
			String mon = arr[0].trim();
			String yr = arr[1].trim();
			if (mon.equalsIgnoreCase(month) && yr.equals(year)) {
				break;

			} else {

				driver.findElement(By.xpath(
						"//div[@role='button' and @class='jqx-calendar-title-navigation jqx-calendar-title-navigation-ventiv_purple_alternate jqx-icon-arrow-left jqx-icon-arrow-left-ventiv_purple_alternate']"))
				.click();
				// WaitForAJAX_ToLoad();

			}

		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> alldates = driver.findElements(By.xpath(
				"//*[@class='jqx-rc-all jqx-rc-all-ventiv_purple_alternate jqx-item jqx-item-ventiv_purple_alternate jqx-calendar-cell jqx-calendar-cell-ventiv_purple_alternate jqx-calendar-cell-month jqx-calendar-cell-month-ventiv_purple_alternate']"));
		for (WebElement ele : alldates) {
			String dt = ele.getText();
			if (dt.equals(date)) {
				try {
					Thread.sleep(1000);
					ele.click();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	public static int GetDateDifference(String dateBeforeString, String dateAfterString) throws ParseException {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		Date dateBefore = myFormat.parse(dateBeforeString);
		Date dateAfter = myFormat.parse(dateAfterString);
		int difference = (int) (dateAfter.getTime() - dateBefore.getTime());
		int daysBetween = (difference / (1000 * 60 * 60 * 24));
		System.out.println("Number of Days between dates: " + daysBetween);
		return daysBetween;

	}

	public static void MouseHoverOnElement(By element) throws InterruptedException {
		WebElement ele = driver.findElement(element);
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}

	public static void KeyOperation(String strKey) {
		Actions act = new Actions(driver);
		String str = strKey.toUpperCase();
		switch (str) {
		case "ENTER":
			act.sendKeys(Keys.ENTER).build().perform();
			ExtentSuccessMessage("Successfully click on 'ENTER' Key");
			break;
		case "TAB":
			act.sendKeys(Keys.TAB).build().perform();
			ExtentSuccessMessage("Successfully click on 'TAB' Key");
			act.release().sendKeys(Keys.TAB).build().perform();
			break;
		case "DELETE":
			act.sendKeys(Keys.DELETE).build().perform();
			ExtentSuccessMessage("Successfully click on 'DELETE' Key");
			break;
		case "BACK_SPACE":
			act.sendKeys(Keys.BACK_SPACE).build().perform();
			ExtentSuccessMessage("Successfully click on 'BACK_SPACE' Key");
			break;
		case "LEFT":
			act.sendKeys(Keys.LEFT).build().perform();
			ExtentSuccessMessage("Successfully click on 'LEFT' Key");
			break;
		case "DOWN":
			act.sendKeys(Keys.DOWN).build().perform();
			ExtentSuccessMessage("Successfully click on 'DOWN' Key");
			break;
		case "UP":
			act.sendKeys(Keys.UP).build().perform();
			ExtentSuccessMessage("Successfully click on 'UP' Key");
			break;
		case "RIGHT":
			act.sendKeys(Keys.RIGHT).build().perform();
			ExtentSuccessMessage("Successfully click on 'BACK_SPACE' Key");
			break;
		case "SUBTRACT":
			act.sendKeys(Keys.SUBTRACT).build().perform();
			ExtentSuccessMessage("Successfully click on 'BACK_SPACE' Key");
			break;
		case "CONTROL":
			act.sendKeys(Keys.CONTROL).build().perform();
			ExtentSuccessMessage("Successfully click on 'CTRL' Key");
			break;
		case "ARROW_LEFT":
			act.sendKeys(Keys.ARROW_LEFT).build().perform();
			ExtentSuccessMessage("Successfully click on 'BACK_SPACE' Key");
			break;
		case "ESC":
			act.sendKeys(Keys.ESCAPE).build().perform();
			ExtentSuccessMessage("Successfully click on 'ESC' Key");
			break;

		}
	}

	public static void RobotKeyOperation(String strKey) throws AWTException, InterruptedException {
		try {
			Robot robot = new Robot();
			String str = strKey.toUpperCase();
			switch (str) {
			case "ENTER":
				robot.keyPress(KeyEvent.VK_ENTER);
				ExtentSuccessMessage("Successfully click on 'ENTER' Key");
				break;
			case "TAB":
				robot.keyPress(KeyEvent.VK_TAB);
				ExtentSuccessMessage("Successfully click on 'TAB' Key");
				break;
			case "CONTROL":
				robot.keyPress(KeyEvent.VK_CONTROL);
				ExtentSuccessMessage("Successfully click on 'CONTROL' Key");
				break;
			case "S":
				robot.keyPress(KeyEvent.VK_S);
				ExtentSuccessMessage("Successfully click on 'S' Key");
				break;
			case "W":
				robot.keyPress(KeyEvent.VK_W);
				ExtentSuccessMessage("Successfully click on 'W' Key");
				break;
			case "BACKSPACE":
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				Log.info("Successfully click on 'BACKSPACE' Key");
				ExtentSuccessMessage("Successfully click on 'BACKSPACE' Key");
				break;
			case "ALT":
				robot.keyPress(KeyEvent.VK_ALT);
				ExtentSuccessMessage("Successfully click on 'ALT' Key");
				break;
			case "F4":
				robot.keyPress(KeyEvent.VK_F4);
				ExtentSuccessMessage("Successfully click on 'F4' Key");
				break;

			case "F":
				robot.keyPress(KeyEvent.VK_F);
				ExtentSuccessMessage("Successfully click on 'F' Key");
				robot.keyRelease(KeyEvent.VK_F);
				break;

			case "T":
				robot.keyPress(KeyEvent.VK_T);
				Thread.sleep(2000);
				ExtentSuccessMessage("Successfully click on 'T' Key");
				robot.keyRelease(KeyEvent.VK_T);
				break;
			case "E":
				robot.keyPress(KeyEvent.VK_E);
				Thread.sleep(2000);
				ExtentSuccessMessage("Successfully click on 'E' Key");
				robot.keyRelease(KeyEvent.VK_E);
				break;
			case "P":
				robot.keyPress(KeyEvent.VK_P);
				Thread.sleep(2000);
				ExtentSuccessMessage("Successfully click on 'P' Key");
				robot.keyRelease(KeyEvent.VK_P);
				break;
			case "O":
				robot.keyPress(KeyEvent.VK_O);
				ExtentSuccessMessage("Successfully click on 'O' Key");
				robot.keyRelease(KeyEvent.VK_O);

			case "DOWN":
				robot.keyPress(KeyEvent.VK_DOWN);
				ExtentSuccessMessage("Successfully click on 'DOWN' Key");

				break;
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	// Following method can be use to download any file in the framework folder
	public void Paste() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

	}

	public void DownloadFileWithRobot() throws AWTException, InterruptedException, ParseException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_LEFT);
		StringSelection stringSelection = new StringSelection(System.getProperty("user.dir") + "\\Download\\");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Thread.sleep(3000);
		Paste();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
	}

	public static int GenerateRandomNumber() throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		Date dateFrom = dateFormat.parse("2012");
		long timestampFrom = dateFrom.getTime();
		Date dateTo = dateFormat.parse("2013");
		long timestampTo = dateTo.getTime();
		Random random = new Random();
		int timeRange = (int) (timestampTo - timestampFrom);
		long randomTimestamp = timestampFrom + (long) (random.nextDouble() * timeRange);
		System.out.println("Date Auto Generate:-" + randomTimestamp);
		return (int) randomTimestamp;

	}

	public static File getLatestFileFromFolder(String filePath, String ext) {
		File theNewestFile = null;
		File dir = new File(filePath);
		FileFilter fileFilter = new WildcardFileFilter("*." + ext);
		File[] files = dir.listFiles(fileFilter);
		if (files.length > 0) {
			/** The newest file comes first **/
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			theNewestFile = files[0];
			System.out.println("Print latest file name :" + theNewestFile.getName());

		} else {
			System.out.println("Not found latest file name :");
			ExtentErrorMessage("Not found latest file name :");
		}

		return theNewestFile;
	}

	public static File OpenLatestFileFromFolder(String filePath, String ext) throws IOException {
		String LatestFileName = getLatestFileFromFolder(filePath, ext).toString();
		ExtentSuccessMessage("Latest File fetch from the directory :" + LatestFileName);
		Desktop.getDesktop().open(new File(LatestFileName));
		ExtentSuccessMessage("Successfully open the file");
		return null;

	}

	////// Delete Most Latest Files//////
	public static void Deletfile(String Filename) {
		Path path = FileSystems.getDefault().getPath(Filename);
		try {
			Files.delete(path);
		} catch (NoSuchFileException x) {
			System.err.format("%s: no such" + " file or directory%n", path);
			ExtentErrorMessage("File not found" + Filename);
		} catch (IOException x) {
			System.err.println(x);
		}
	}

	public static void DeletingLatestFileFromFolder(String filePath, String ext) throws IOException {
		String LatestFileName = getLatestFileFromFolder(filePath, ext).toString();
		System.out.println("Files Name " + LatestFileName);
		ExtentSuccessMessage("Files Name " + LatestFileName);
		Deletfile(LatestFileName);
		Log.info("Files deleted Successfully " + LatestFileName);
		ExtentSuccessMessage("Files deleted Successfully " + LatestFileName);
	}

	///////////// Switch To Browser/////////////////

	public static void SwitchToBrowser(String BrowserParentOrChild) {
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();
		String str = BrowserParentOrChild.toUpperCase();
		switch (str) {
		case "PARENT":
			driver.close();
			driver.switchTo().window(I1.next());
			ExtentSuccessMessage("Successfully Switch control to the parent window");
			break;

		case "CHILD":
			ExtentSuccessMessage("Successfully Switch control to the child window");
			while (I1.hasNext()) {
				String child_window = I1.next();
				if (!parent.equals(child_window)) {
					driver.switchTo().window(child_window);
					driver.manage().window().maximize();
					// System.out.println(driver.switchTo().window(child_window).getTitle());
				}
			}
			break;
		}
	}

	public static By FindElementByText(String text) throws InterruptedException {
		String checkDateType = ((Object) text).getClass().getSimpleName();
		if (checkDateType == "Double") {
			text = String.valueOf(text);
		}
		String xpath = "//span[text()='" + text + "']";
		By FindElementByText = By.xpath(xpath);
		ExtentSuccessMessage("Element found by Text :" + text);
		return FindElementByText;
	}

	/////// Imp////////

	public static String GetFieldValue(String strfieldName_Index) {
		String arrdate[] = strfieldName_Index.split("_");
		String strfieldName = arrdate[0];
		String Index = arrdate[1];
		String FieldValue = "(//*[text()='" + strfieldName + "']//parent::td//following-sibling::td[1]//input)[" + Index
				+ "]";
		WebElement t = driver.findElement(By.xpath(FieldValue));
		String getElementText = t.getAttribute("data-value");
		String getElementText1 = t.getAttribute("value");
		String getElementText2 = t.getAttribute("data-value-desc");
		if (getElementText2 != null) {
			ExtentSuccessMessage("Value for the field '" + strfieldName + "' = " + getElementText2);
			return getElementText2;
		} else if (getElementText != null) {
			ExtentSuccessMessage("Value for the field '" + strfieldName + "' = " + getElementText);
			return getElementText;
		} else if (getElementText1 != null) {
			ExtentSuccessMessage("Value for the field '" + strfieldName + "' = " + getElementText1);
			return getElementText1;
		}
		return null;
	}

	public static String GetSelectedValueFromDropDown(String DropDownFiledName) throws InterruptedException {
		String FieldValue = "//*[contains(text(),'" + DropDownFiledName
				+ "')]//parent::td//following-sibling::td//*[contains(@class,'jqx-dropdownlist-content')]";
		WebElement t = driver.findElement(By.xpath(FieldValue));
		if (t.isDisplayed()) {
			MouseHoverOnElement(By.xpath(FieldValue));
		}
		String getElementText = t.getText();
		if (!getElementText.equalsIgnoreCase("")) {
			ExtentSuccessMessage(
					"Successfully fetch the value from Dropdown field '" + DropDownFiledName + "' = " + getElementText);
		} else {
			Log.error(
					"Error or Null avalue found while fetching value under dropdown field '" + DropDownFiledName + "'");
		}
		return getElementText;
	}

	////////////////// To Do //////////////////

	public static void HandleSessionPopUp() throws InterruptedException {
		if (ElementDisplayed(SessionPopUPOk)) {
			ExtentSuccessMessage("System shows 'Maximium Number of Sessions' popup");
			click(SessionPopUPOk);
			ExtentSuccessMessage("Successfully click OK on 'Maximium Number of Sessions' popup");
		}

	}

	public static void SetScreenResolution(int lenght, int width) throws InterruptedException {
		Dimension dem = new Dimension(lenght, width);
		driver.manage().window().setSize(dem);
	}

	public static void HandleSplitterBar() throws InterruptedException {
		List<WebElement> sliders = driver.findElements(By.xpath(
				"//div[@class='jqx-splitter-splitbar-horizontal jqx-splitter-splitbar-horizontal-ventiv_purple_alternate jqx-fill-state-normal jqx-fill-state-normal-ventiv_purple_alternate']"));
		for (WebElement slider : sliders) {
			if (slider.isDisplayed()) {
				slider.click();
				ExtentSuccessMessage("Splitter element found & click successfully");
				break;
			}
		}
	}

	public void DragandDrop(By SourceElement, By DistElement) throws InterruptedException {
		WebElement From = driver.findElement(SourceElement);
		WebElement Des = driver.findElement(DistElement);
		Actions act = new Actions(driver);
		act.dragAndDrop(From, Des).build().perform();
		ExtentSuccessMessage("Successfully Element Drag And Drop");

	}

	//////////////////////// Code Begin for WebTable ///////////////////////////

	public static int GetNumberOfRowsInWebTable(By TableElement) throws InterruptedException {
		List<WebElement> rowsNumber = driver.findElements(TableElement);
		int rowCount = rowsNumber.size();
		ExtentSuccessMessage("No of rows in web table : " + rowCount);
		return rowCount;
	}

	public static int GetNumberOfCoulumnsInWebTable(By TableElement) throws InterruptedException {
		List<WebElement> columnNumber = driver.findElements(TableElement);
		int ColumnCount = columnNumber.size();
		ExtentSuccessMessage("No of column in web table : " + ColumnCount);
		return ColumnCount;
	}

	public static List<Integer> GetRowNumberForValuePresentUnderWebTable(String TableId, String CheckForValue)
			throws InterruptedException {
		By element = By.xpath("//*[contains(@id,'" + TableId + "') and @role='row']");
		if (ElementDisplayed(element)) {
			ExtentSuccessMessage("Table is identified by the tableID :" + TableId);
		} else {
			ExtentErrorMessage("Table is not identified by the TableID :" + TableId);
		}
		List<WebElement> rows = driver.findElements(element);
		int count = 0;
		LinkedList<Integer> ListRowsCount = new LinkedList<Integer>();
		for (WebElement row : rows) {

			String getText = row.getText().replace("\n", " ").toUpperCase();//
			// System.out.println(getText);
			if (getText.contains(CheckForValue.toUpperCase())) {
				ExtentSuccessMessage("Successfully found value '" + CheckForValue + "' for row number = " + count);
				ListRowsCount.add(count);
			}
			count = count + 1;
		}
		// System.out.println("Print list all rows :"+ListRowsCount);
		return ListRowsCount;
	}

	public static void SelectMulipleRowsFromTable(String TableId1, String TableId2, String CheckForValue)
			throws InterruptedException, AWTException {
		List<Integer> Numbers = GetRowNumberForValuePresentUnderWebTable(TableId1, CheckForValue);
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).build().perform();
		for (int RowNumber : Numbers) {
			String xpath = "(//*[@id='" + TableId2 + "']/div[@role='row' and contains(@id,'row" + RowNumber + "')])[1]";
			click(By.xpath(xpath));
			Thread.sleep(1000);
		}
		builder.keyUp(Keys.CONTROL).build().perform();
	}

	public static void SelectSingleRowsFromTable(String TableId1, String TableId2, String CheckForValue)
			throws InterruptedException, AWTException {
		List<Integer> Numbers = GetRowNumberForValuePresentUnderWebTable(TableId1, CheckForValue);
		for (int RowNumber : Numbers) {
			String xpath = "(//*[@id='" + TableId2 + "']/div[@role='row' and contains(@id,'row" + RowNumber + "')])[1]";
			click(By.xpath(xpath));
			Thread.sleep(1000);
		}
	}

	public static void SelectSingleRowsFromTableDoublelic(String TableId1, String TableId2, String CheckForValue)
			throws InterruptedException, AWTException {
		List<Integer> Numbers = GetRowNumberForValuePresentUnderWebTable(TableId1, CheckForValue);
		for (int RowNumber : Numbers) {
			String xpath = "(//*[@id='" + TableId2 + "']/div[@role='row' and contains(@id,'row" + RowNumber + "')])[1]";
			DoubleClick(By.xpath(xpath));
			Thread.sleep(1000);
		}
	}

	///////////////// Following method will select row number passing row
	///////////////// number///////////////////////////

	public void SelectRowByRowNumber(String TableId, int strPassRowNumber) throws InterruptedException {
		int RowNumber = strPassRowNumber - 1;
		String xpath = "(//*[@id='" + TableId + "']/div[@role='row' and contains(@id,'row" + RowNumber + "')])[1]";

		if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
			DoubleClick(By.xpath(xpath));
			ExtentSuccessMessage("Successfully click the tableId :" + TableId + " row number :" + strPassRowNumber);
		} else {
			ExtentErrorMessage("Web table not found or table Id pass is not correct");
		}

	}

	public void SelectSingleRowByRowNumber(String TableId, int strPassRowNumber) throws InterruptedException {
		int RowNumber = strPassRowNumber - 1;
		String xpath = "(//*[@id='" + TableId + "']/div[@role='row' and contains(@id,'row" + RowNumber + "')])[1]";
		if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
			click(By.xpath(xpath));
			ExtentSuccessMessage("Successfully click the tableId :" + TableId + " row number :" + strPassRowNumber);
			Log.info("Successfully click the tableId :" + TableId + " row number :" + strPassRowNumber);
		} else {
			ExtentErrorMessage("Web table not found or table Id pass is not correct");
		}
	}

	public void SelectMatchingRowNoFromWebTable(By TableElements, String ColumnName1, String ColumnName2,
			String ColumnName3) throws InterruptedException {
		List<WebElement> rows = driver.findElements(TableElements);
		LinkedList<String> c1 = new LinkedList<String>();
		c1.add(ColumnName1);
		c1.add(ColumnName2);
		c1.add(ColumnName3);
		LinkedList<String> c4 = new LinkedList<String>();
		c4.add("Yes");
		c4.add("Yes");
		c4.add("Yes");
		int count = 0;
		LinkedList<String> c2 = new LinkedList<String>();
		for (WebElement row : rows) {
			count = count + 1;
			String getText = row.getText().replace("\n", " ");
			c2.add(getText);
			LinkedList<String> c3 = new LinkedList<String>();
			for (String e : c1)
				c3.add(getText.contains(e) ? "Yes" : "No");
			if (c4.equals(c3) == true) {
				System.out.println("Row number found matching :" + count);
				row.click();
				break;
			}
		}
	}

	public void SelectMultipleMatchingRowNoFromWebTable(By TableElements, String ColumnName1)
			throws InterruptedException {
		List<WebElement> rows = driver.findElements(TableElements);
		String[] arrOfStr = ColumnName1.split(";");
		for (String a : arrOfStr) {
			LinkedList<String> c4 = new LinkedList<String>();
			c4.add("Yes");
			c4.add("Yes");
			c4.add("Yes");
			int count = 0;
			for (WebElement row : rows) {
				count = count + 1;
				String getText = row.getText().replace("\n", " ");
				if (getText.contains(a) == true) {
					System.out.println("Row number found matching :" + count);
					KeyOperation("CONTROL");
					row.click();
					KeyOperation("CONTROL");
				}

			}
		}

	}



	public int findWebTableColumnIndexValue(By TableElements,String value) {
		List<WebElement> columnsList = driver.findElements(TableElements);
		int flag=0;
		for (WebElement column : columnsList) {
			System.out.println("column text" + column.getText()+ ", "); // here is is just printing number of rows, like 1, 2
			if(column.getText()==value);
			flag=flag+1;
			break;
		}
		return flag;
	}




	//////////// Check box Checked /////////////////
	public void CheckOnCheckBox(By Element) throws InterruptedException {
		WebElement checkboElement = driver.findElement(Element);
		String getElementText = checkboElement.getAttribute("value");
		if (getElementText.contains("false")) {
			click(Element);
			ExtentSuccessMessage("Successfully click on Checkbox");
		} else {
			ExtentSuccessMessage("Checkbox already checked");
			click(Element);
			click(Element);
			ExtentSuccessMessage("Checkbox checked two times");
		}
	}

	public static void HandleWebTable() throws InterruptedException {
		List<WebElement> rowsNumber = driver.findElements(By.xpath("//*[@id='contenttablediaryGrid']/div"));
		int rowCount = rowsNumber.size();
		System.out.println("No of rows in this table : " + rowCount);
		List<WebElement> columnsNumber = driver.findElements(By.xpath("//*[@id='columntablediaryGrid']/div"));
		int columnCount = columnsNumber.size();
		System.out.println("No of columns in this table : " + columnCount);

	}

	public static void CloseWindow() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		ExtentSuccessMessage("Successfully Click On CONTROL");
		robot.keyPress(KeyEvent.VK_W);
		ExtentSuccessMessage("Successfully Click On W");
		robot.keyRelease(KeyEvent.VK_W);
		ExtentSuccessMessage("Successfully Release W");
		robot.keyRelease(KeyEvent.VK_CONTROL);
		ExtentSuccessMessage("Successfully Release CONTROL");
	}

	public static void CloseTab() throws InterruptedException, AWTException {
		driver.close();
		ExtentSuccessMessage("Successfully closed the tab");
	}

	public static void CloseAllBrower() throws InterruptedException {

		String parent = driver.getWindowHandle();
		Set<String> Winhandles = driver.getWindowHandles();
		for (String hndl : Winhandles) {
			driver.switchTo().window(hndl);
			driver.close();
			Thread.sleep(1000);
			ExtentSuccessMessage("Successfully closed the browser");
		}

	}

	public void NavigatetoMenu(String mainMenu, String subMenu, String menuItem) throws InterruptedException {
		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath(String.format(MainMenu, mainMenu)))).build().perform();
		// .moveToElement(driver.findElement(By.xpath(String.format(SubMenu,
		// subMenu)))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath(String.format(SubMenu, subMenu)))).build().perform();
		Thread.sleep(1000);
		click(By.xpath(String.format(MenuItem, menuItem)));
		if (driver.getWindowHandles().size() > 1) {
			String parent = driver.getWindowHandle();
			Set<String> Winhandles = driver.getWindowHandles();
			for (String hndl : Winhandles) {
				driver.switchTo().window(hndl);
				driver.close();
				Thread.sleep(1000);
				Log.info("Successfully closed the browser");
				Thread.sleep(2000);
				Base_Class.KeyOperation("ENTER");
			}
		}

	}

	public static void MouseClick(By element) throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(element);
		actions.click(elementLocator).perform();
	}

	public void UploadFileWithRobot(String filePath, By fileUploadButton)
			throws AWTException, InterruptedException, ParseException {
		// click(fileUploadButton);
		Thread.sleep(3000);
		MouseClick(fileUploadButton);
		Thread.sleep(3000);
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Paste();
		RobotKeyOperation("ALT");
		Thread.sleep(3000);
		RobotKeyOperation("O");
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyRelease(KeyEvent.VK_ALT);
	}

	public void fileDelete(String fileName) {
		File existingFile = new File(DownloadDirectory + fileName);

		if (existingFile.exists() && existingFile.isFile()) {
			existingFile.delete();
		}
	}

	public boolean fileExistsInDownloadDirectory(String fileName) throws InterruptedException {
		Thread.sleep(5000);
		File existingFile = new File(DownloadDirectory + fileName);
		return existingFile.exists() && existingFile.isFile();
	}

	public static int CheckValuePresentUnderWebTableRow(String TableId, String CheckForValue)
			throws InterruptedException {
		List<WebElement> rows = driver.findElements(By.xpath("//*[contains(@id,'" + TableId + "') and @role='row']"));
		int count = 0;
		for (WebElement row : rows) {
			count = count + 1;
			String getText = row.getText().replace("\n", " ");
			System.out.println("Debug Table row Value :" + getText);
			if (getText.contains(CheckForValue)) {
				ExtentSuccessMessage("Successfully found value :" + CheckForValue + " for row number :" + count);
			} else {
				Log.error("Value not found under the table ");
			}
		}
		return count;
	}

	public static String GetFontColor(By by) {
		return Color.fromString(driver.findElement(by).getCssValue("color")).asHex();
	}

	public void purgeDownloadDirectory() {
		File dir = new File(DownloadDirectory);
		for (File file : dir.listFiles()) {
			if (!file.isDirectory())
				file.delete();
			ExtentSuccessMessage("Deleted Existing file");
		}
	}

	public int GetFilesCountInDownloadDirectory() {
		/*
		 * File dir = new File(DownloadDirectory); return dir.listFiles().length;
		 */

		return (Stream.of(new File(DownloadDirectory).listFiles()).filter(file -> !file.isDirectory())
				.map(File::getName).collect(Collectors.toSet())).size();
	}

	// Switch to Parent Frame
	public static void SwitchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public static void WaitForElementToBeVisible(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
	}

	public String GetPST_Date() {
		SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("PST"));
		return sd.format(date);
	}

	public void SelectDropDownValueByTyping(By Locator, By InputLocator, String ListLocator, String Value)
			throws InterruptedException {
		click(Locator);
		input(InputLocator, Value + Keys.TAB);
		click(By.xpath(String.format(ListLocator, Value)));
		click(Locator);
	}

	public String GetPageTitle() {
		return driver.getTitle();
	}

	public static void CloseFile() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		ExtentSuccessMessage("Successfully Click On CONTROL");
		robot.keyPress(KeyEvent.VK_W);
		ExtentSuccessMessage("Successfully Click On W");
		robot.keyRelease(KeyEvent.VK_W);
		ExtentSuccessMessage("Successfully Release W");
		robot.keyRelease(KeyEvent.VK_CONTROL);
		ExtentSuccessMessage("Successfully Release CONTROL");
	}

	public void SelectDropDownValueByIndex(By Locator, String Value) throws InterruptedException {
		if (ElementDisplayed(Locator)) {
			click(Locator);
			ExtentSuccessMessage("Successfully click On Dropdown ");
			Thread.sleep(1000);
			// ScrollUntilElementVisible(FindElementByText(Value));
			String[] values = Value.split("_");
			click(FindElementByTextByIndex(values[0], values[1].replace("_", "")));
			ExtentSuccessMessage("Successfully clicked and select value from dropdown :" + Value);
		} else {
			Log.error("Dropdown element not able to select dropdown value :" + Value);
		}
	}

	public static By FindElementByTextByIndex(String text, String index) throws InterruptedException {
		String checkDateType = ((Object) text).getClass().getSimpleName();
		if (checkDateType == "Double") {
			text = String.valueOf(text);
		}
		String xpath = "(//span[text()='" + text + "'])[" + index + "]";
		By FindElementByText = By.xpath(xpath);
		ExtentSuccessMessage("Element found by Text :" + text);
		return FindElementByText;
	}

	public static void SelectAndDoubleClickonSingleRowsFromTable(String TableId1, String TableId2, String CheckForValue)
			throws InterruptedException, AWTException {
		List<Integer> Numbers = GetRowNumberForValuePresentUnderWebTable(TableId1, CheckForValue);
		for (int RowNumber : Numbers) {
			String xpath = "(//*[@id='" + TableId2 + "']/div[@role='row' and contains(@id,'row" + RowNumber + "')])[1]";
			DoubleClick(By.xpath(xpath));
			Thread.sleep(1000);
		}
	}

	public void SelectoneclickRowByRowNumber(String TableId, int strPassRowNumber) throws InterruptedException {
		int RowNumber = strPassRowNumber - 1;
		String xpath = "(//*[@id='" + TableId + "']/div[@role='row' and contains(@id,'row" + RowNumber + "')])[1]";
		click(By.xpath(xpath));
		Log.info("Successfully click the tableId :" + TableId + " row number :" + strPassRowNumber);
		ExtentSuccessMessage("Successfully click the tableId :" + TableId + " row number :" + strPassRowNumber);
	}

	public static boolean WaitForAJAX_ToLoad() {
		ExtentSuccessMessage("Waiting for AJAX to load completely");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60000));
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equalsIgnoreCase("complete");
			}
		};

		boolean isWaitComplete = wait.until(jQueryLoad) & wait.until(jsLoad);
		if (isWaitComplete) {
			ExtentSuccessMessage("AJAX Loaded successfully");
			return true;
		} else {
			ExtentSuccessMessage("AJAX not Loaded successfully");
			return false;
		}
	}

	public static void DatePicker(String strFieldName, String strDate, String calendarControlNumber)
			throws InterruptedException {
		String DateFromExcel = strDate.trim();
		ExtentSuccessMessage("Date fetch from excel :" + DateFromExcel);
		String arrdate[] = DateFromExcel.split(" ");
		String date = arrdate[0].trim(); // "1";
		String month = arrdate[1].trim(); // "February";
		String year = arrdate[2].trim(); // "2022";
		ExtentSuccessMessage("Date fetch from excel with splitted value :" + date + " " + month + " " + year);
		try {
			Thread.sleep(1000);
			click(By.xpath("//*[text()='" + strFieldName
					+ "']//parent::td//following-sibling::td[1]/div/div/input//following-sibling::div[1]"));
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			Log.error("System catch error while clicking left arrow on date picker");
			e.printStackTrace();
		}
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			MouseHoverOnElement(
					By.xpath("(//td[@aria-live='assertive' and @align='center']//div)[" + calendarControlNumber + "]"));
			String monthyear = driver
					.findElement(By.xpath(
							"(//td[@aria-live='assertive' and @align='center']//div)[" + calendarControlNumber + "]"))
					.getText().trim();
			if (monthyear.isBlank()) {
				MouseHoverOnElement(By.xpath(
						"(//td[@aria-live='assertive' and @align='center']//div)[" + calendarControlNumber + "]"));
				String mothyear1 = driver.findElement(By.xpath(
						"(//td[@aria-live='assertive' and @align='center']//div)[" + calendarControlNumber + "]"))
						.getText().trim();
				System.out.println("Debug vaue for index 2 :" + mothyear1);
				monthyear = mothyear1;
			}
			// System.out.println("Debug message print monthyear:"+monthyear);
			String arr[] = monthyear.split(" ");
			String mon = arr[0].trim();
			String yr = arr[1].trim();
			if (mon.equalsIgnoreCase(month) && yr.equals(year)) {
				break;

			} else {

				driver.findElement(By.xpath(
						"(//div[@role='button' and @class='jqx-calendar-title-navigation jqx-calendar-title-navigation-ventiv_purple_alternate jqx-icon-arrow-left jqx-icon-arrow-left-ventiv_purple_alternate'])["
								+ calendarControlNumber + "]"))
				.click();
				WaitForAJAX_ToLoad();

			}

		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> alldates = driver.findElements(By.xpath(
				"//*[@class='jqx-rc-all jqx-rc-all-ventiv_purple_alternate jqx-item jqx-item-ventiv_purple_alternate jqx-calendar-cell jqx-calendar-cell-ventiv_purple_alternate jqx-calendar-cell-month jqx-calendar-cell-month-ventiv_purple_alternate']"));
		for (WebElement ele : alldates) {
			String dt = ele.getText();
			if (dt.equals(date)) {
				try {
					Thread.sleep(1000);
					ele.click();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	public static void killExcel() {
		try {
			// if (isProcessRuning("EXCEL.EXE")){
			for (int i = 0; i < 2; i++) {
				Runtime.getRuntime().exec("taskkill /IM EXCEL.EXE");
				ExtentSuccessMessage("Successfully closed the Excel");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean isProcessRuning(String serviceName) throws Exception {
		String TASKLIST = "tasklist";
		Process p = Runtime.getRuntime().exec(TASKLIST);
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.contains(serviceName)) {
				return true;
			}
		}
		return false;
	}

	public void SetUp(String username, String password) throws IOException, InterruptedException {
		String Browser = configloader().getProperty("Browser");
		String Url = configloader().getProperty("URL");
		String UserName = username;
		String Password = password;
		String downloadFilepath = System.getProperty("user.dir") + "\\Download";
		Map<String, Object> preferences = new Hashtable<String, Object>();
		preferences.put("profile.default_content_settings.popups", 0);
		preferences.put("download.prompt_for_download", "false");
		preferences.put("download.default_directory", downloadFilepath);

		switch (Browser.toUpperCase()) {

		case "CHROME":
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			ChromeOptions options = new ChromeOptions();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.addArguments("--disable-extensions");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-setuid-sandbox");
			options.setExperimentalOption("prefs", preferences);
			driver = new ChromeDriver(options);
			break;

		case "FIREFOX":
			driver = new FirefoxDriver();
			break;

		default:
			System.err.println("The Driver is not defined");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ExtentSuccessMessage("Driver has initialized successfully for " + Browser + "browser");
		driver.get(Url);
		Thread.sleep(2000);
		click(AcceptCookies);
		Pagetitle = driver.getTitle();
		ExtentSuccessMessage("Title is displayed : " + Pagetitle);
	}

	public static void jsClick(By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = driver;
		js.executeScript("arguments[0].click();", element);
	}

	public WebElement waitForElementPresent(By by) {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (NoSuchElementException | TimeoutException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public static void CloseOnlyChildBrowers() throws InterruptedException {

		Set<String> Winhandles = driver.getWindowHandles();
		String parent = Winhandles.iterator().next();
		if (Winhandles.size() > 1) {
			int i = 0;
			for (String hndl : Winhandles) {
				if (i == 0)
					continue;
				driver.switchTo().window(hndl);
				driver.close();
				Thread.sleep(1000);
				ExtentSuccessMessage("Successfully closed the browser");
			}
			driver.switchTo().window(parent);
		}
	}

	public void CloseTimeTrackingWindow() throws InterruptedException {

		SwitchToBrowser("PARENT");
		Thread.sleep(5000);
		if (driver.getWindowHandles().size() == 2) {
			SwitchToBrowser("CHILD");
			ExtentSuccessMessage("Closed Timetracking window");
			SwitchToBrowser("PARENT");
		} else {
			ExtentSuccessMessage("Succesfully closed child window");
		}
	}

	public void PLCAScrollOnGrid() throws InterruptedException {

		try {
			WebElement element = driver.findElement(By.xpath(gridRows));
			if (element.isDisplayed()) {

				ExtentSuccessMessage("Successfully Zoomed out");
				element.click();
				Robot robot = new Robot();
				for (int i = 0; i < 2; i++) {
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.delay(1000);
					// robot.keyPress(KeyEvent.VK_SUBTRACT);
					// robot.delay(1000);
					robot.keyRelease(KeyEvent.VK_SUBTRACT);
					robot.delay(1000);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.delay(1000);
				}
				robot.keyPress(KeyEvent.VK_PAGE_DOWN);
				robot.delay(1000);
				robot.keyPress(KeyEvent.VK_PAGE_DOWN);
				ExtentSuccessMessage("Successfully Page Down");
				robot.delay(1000);
				robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
				robot.keyPress(KeyEvent.VK_PAGE_UP);
				robot.delay(1000);
				robot.keyPress(KeyEvent.VK_PAGE_UP);
				ExtentSuccessMessage("Successfully Page Up");
				robot.keyRelease(KeyEvent.VK_PAGE_UP);
			}
		} catch (Exception e) {

		}
	}

	public void DISABILITYScrollOnGrid() throws InterruptedException {

		try {
			WebElement element = driver.findElement(By.xpath(gridRows));
			if (element.isDisplayed()) {

				ExtentSuccessMessage("Successfully Zoomed out");
				element.click();
				Robot robot = new Robot();
				for (int i = 0; i < 2; i++) {
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.delay(1000);
					// robot.keyPress(KeyEvent.VK_SUBTRACT);
					// robot.delay(1000);
					robot.keyRelease(KeyEvent.VK_SUBTRACT);
					robot.delay(1000);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.delay(1000);
				}
				robot.keyPress(KeyEvent.VK_PAGE_DOWN);
				robot.delay(1000);
				robot.keyPress(KeyEvent.VK_PAGE_DOWN);
				ExtentSuccessMessage("Successfully Page Down");
				robot.delay(1000);
				robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
				robot.keyPress(KeyEvent.VK_PAGE_UP);
				robot.delay(1000);
				robot.keyPress(KeyEvent.VK_PAGE_UP);
				ExtentSuccessMessage("Successfully Page Up");
				robot.keyRelease(KeyEvent.VK_PAGE_UP);
			}
		} catch (Exception e) {

		}
	}

	public static void SwitchToFrameByFrameID(String frameID) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(frameID)));
	}

	public static String GetFrameIdByTitle(String strfieldName) {
		String FieldValue = "//iframe[@title='" + strfieldName + "']";
		WebElement t = driver.findElement(By.xpath(FieldValue));
		String getElementText2 = t.getAttribute("id");
		if (getElementText2 != null) {
			ExtentSuccessMessage("Value for the frame '" + strfieldName + "' = " + getElementText2);
			return getElementText2;
		}
		return null;
	}

	public void clickOnrefresh() throws InterruptedException {
		if (ElementDisplayed(L_LitigationTabrefresh)) {
			click(L_LitigationTabrefresh);
			ExtentSuccessMessage("Successfully Click On  Litigation Tab refresh");
			Thread.sleep(5000);
		} else {
			ExtentErrorMessage("Not able to click on ' Litigation Tab refresh'");
		}
	}

	public int randomNumber(int noOfDigits) {
		long timeSeed = System.nanoTime();
		double randSeed = Math.random() * 1000;
		long midSeed = (long) (timeSeed * randSeed);
		String s = midSeed + "";
		String subStr = s.substring(0, noOfDigits);
		return Integer.parseInt(subStr);
	}

	public List<WebElement> findElements(By by) {
		List<WebElement> elements = waitForElementsVisible(by);
		if (elements != null) {
			return elements;
		}
		return driver.findElements(by);

	}

	public List<WebElement> waitForElementsVisible(By by) {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public int getRandomSSN() {
		long timeSeed = System.nanoTime();
		double randSeed = Math.random() * 1000;
		long midSeed = (long) (timeSeed * randSeed);
		String s = midSeed + "";
		String subStr = s.substring(0, 9);
		if (subStr.charAt(0) == '9') {
			subStr = '7' + subStr.substring(1);

		}
		subStr = subStr.replaceAll("0", Integer.toString(new Random().ints(1, 8).findFirst().getAsInt()));
		subStr = subStr.replaceAll("9", Integer.toString(new Random().ints(1, 8).findFirst().getAsInt()));
		return Integer.parseInt(subStr);
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void scrollUpVertically() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	public int getRandomMemberID() {
		long timeSeed = System.nanoTime();
		double randSeed = Math.random() * 1000;
		long midSeed = (long) (timeSeed * randSeed);
		String s = midSeed + "";
		String subStr = s.substring(0, 11);
		if (subStr.charAt(0) == '9') {
			subStr = '7' + subStr.substring(1);
		}
		subStr = subStr.replaceAll("0", "1");
		return Integer.parseInt(subStr);
	}

	public void RefreshPage() {
		driver.navigate().refresh();
	}

	public int randomNumber(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}

	public String getRandomPhoneNumber() {
		/*
		 * String no=randomNumber(9)+""; String
		 * phone="(9"+no.substring(0,2)+")"+no.substring(2,5)+"-"+no.substring(5);
		 */
		String phone = "(938) 443-6543";
		return phone;
	}

	public void waitForTextTobePresentInElement(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		} catch (Exception e) {
			Log.error("Text is not present");
		}
	}

	public boolean isDownloadedFileExist() {
		WaitForPageLoad();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}

		File folder = new File(System.getProperty("user.dir") + "\\Download");
		// List the files on that folder
		File[] listOfFiles = folder.listFiles();
		boolean found = false;
		File f = null;
		// Look for the file in the files
		// You should write smart REGEX according to the filename
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileName = listOfFile.getName();
				System.out.println("File " + listOfFile.getName());
				if (fileName.contains(".pdf")) {
					f = new File(fileName);
					found = true;
					f.deleteOnExit();
				}
			}
		}

		return found;
	}

	public String SelectDropdownfirstValue(By Element) throws InterruptedException {
		if (ElementDisplayed(Element)) {
			Log.info("Element is visible");
			click(Element);
			Log.info("Successfully clicked on Element ");
		} else {
			Log.error("Element is not Visible");
		}
		String option = null;
		String id = Element.toString().replaceAll("By.id: ", "");
		System.out.println("Print id : " + id);
		String Xpath = "(//*[@id='" + id + "']//parent::div//select//option)[2]";
		WebElement webelements = driver.findElement(By.xpath(Xpath));
		if (webelements.isDisplayed()) {
			Log.info("WebElement is Visible");
			option = webelements.getText();
			Log.info("Print Text " + option);
			webelements.click();
			Log.info("Successfully clicked on WebElement ");

		} else {
			Log.error("WebElement is not Visible");
		}
		return option;
	}

	public String selectByRandom(By by) throws InterruptedException {
		String locator = by.toString();
		WebElement element = null;
		Select s = null;
		String id = null;
		String value = null;
		// if(!getAttribute(by,"title").equals("")) {
		if (locator.contains("id")) {
			id = by.toString().replaceAll("By.id: ", "");
			element =getDriver().findElement(By.id(id.split("_chzn")[0]));
		}
		try {
			s = new Select(element);
			int count = s.getOptions().size() - 1;
			int random = (int) Math.floor(Math.random() * (count) + 1) - 1;
			value = s.getOptions().get(random).getText();
			// int index = random > 0 ? random : 1;
			// String value = s.getOptions().get(index).getText();
			// Thread.sleep(5000);

			// Ramya : findElements(By.xpath("//li[starts-with(@id,'" + id +
			// "')]")).get(random).click();
			if(count>1) {
				click(by);
				getDriver().findElement(By.xpath("(//li[starts-with(@id,'" + id + "')])[" + (random + 1) + "]")).click();
				value = s.getOptions().get(0).getText();
			}
			else
			{
				click(by);
				// findElements(By.xpath("//li[starts-with(@id,'" + id + "')]")).get(0).click();
				getDriver().findElement(By.xpath("(//li[starts-with(@id,'" + id + "')])[1]")).click();
				value = s.getOptions().get(0).getText();
			}
			// Thread.sleep(3000);

		} catch (Throwable e) {
			click(by);
			// findElements(By.xpath("//li[starts-with(@id,'" + id + "')]")).get(0).click();
			getDriver().findElement(By.xpath("(//li[starts-with(@id,'" + id + "')])[1]")).click();
			value = s.getOptions().get(0).getText();

		}
		return value;
		// }
	}

	public WebElement waitForElementClickable(By by) {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			Log.info(e.getMessage());
		}
		return null;

	}

	public WebElement waitForElementClickable(WebElement ele) {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(ele));
		} catch (Exception e) {
			Log.info(e.getMessage());
		}
		return null;
	}

	public static void clickAndInput(By element, String Value) throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(element));
		WebElement element1 = driver.findElement(element);
		element1.click();
		element1.sendKeys(Value);
	}

	public void inputSSN(By ssn, String ssnnumber) {
		WebElement element = driver.findElement(ssn);

		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		action.moveToElement(element).click().pause(Duration.ofSeconds(3)).build().perform();
		action.sendKeys(element, " "+ssnnumber).build().perform();
	}
	public Boolean ValidationOnSummaryPage (String Value) throws InterruptedException {
		By xpath= By.xpath("//*[contains(text(),'"+Value+"')]");
		Boolean flag = false;
		if(ElementDisplayed(xpath)) {
			flag =true;
			System.out.println("Value visible: "+Value);
		}
		return flag;
	}

	public static String ChangeDateformate(String a) throws ParseException{
		String inputDateStr = a;
		System.out.println("inputDateStr date: " + inputDateStr);
		SimpleDateFormat inputFormat = new SimpleDateFormat("MMddyyyy");
		Date inputDate = inputFormat.parse(inputDateStr);
		SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");
		String outputDateStr = outputFormat.format(inputDate);
		System.out.println("Converted date: " + outputDateStr);
		return outputDateStr;
	}

	public void KillChrome() throws IOException, InterruptedException {		
		Process process = Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		int exitCode = process.waitFor();
		if(exitCode ==0) {
		}else {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
		}
		//		String command = "tasklist /FI \"imagename eq chromedriver.exe\" /FI \"imagename eq geckodriver.exe\"";
		//		 try {
		//	            Process process = Runtime.getRuntime().exec(command);
		//	            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		//	            String line;
		//	            while ((line = reader.readLine()) != null) {
		//	                if (line.contains("chromedriver.exe") || line.contains("geckodriver.exe")) {
		//	                    String[] parts = line.trim().split("\\s+");
		//	                    String pid = parts[1]; // Process ID
		//	                    // Command to kill the process by PID
		//	                    String killCommand = "taskkill /F /PID " + pid;
		//	                    Runtime.getRuntime().exec(killCommand);
		//	                    System.out.println("Browser process with PID " + pid + " has been terminated.");
		//	        
		//	                }
		//	            }
		//	        } catch (IOException e) {
		//	            e.printStackTrace();
		//	        }
	}

	public void selectDropdownByVisibleText(By by, String VisibleText) {
		WebElement element = findElement(by);
		try {
			Select s = new Select(element);
			s.selectByVisibleText(VisibleText);
			System.out.println("Option at VisibleText " + VisibleText + " is Selected from the DropDown");
		} catch (NoSuchElementException e) {
			System.out.println("Option at VisibleText " + VisibleText + " is  not Selected from the DropDown");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public int getRandomSFEntity() {
		long timeSeed = System.nanoTime();
		double randSeed = Math.random() * 1000;
		long midSeed = (long) (timeSeed * randSeed);
		String s = midSeed + "";
		String subStr = s.substring(0, 4);
		//		if (subStr.charAt(0) == '9') {
		//			subStr = '7' + subStr.substring(1);
		//		}
		//		subStr = subStr.replaceAll("0", "1");
		return Integer.parseInt(subStr);
	}


	//Faker class to generate Name ,Email ,Phone etc

	public String RandomName() throws InterruptedException {
		Faker faker = new Faker();
		String Name = faker.name().firstName();
		System.out.println("First Name"+Name);
		ExtentSuccessMessage("First Name: " + Name);
		return Name;

	}


	public String RandomEmail() throws InterruptedException {
		Faker faker = new Faker();
		String emailName = faker.name().firstName();
		emailName=emailName+"@gmail.com";
		System.out.println("First Name"+emailName);
		ExtentSuccessMessage("First Name: " + emailName);
		return emailName;

	}

	public void selectDropdownByPartialText(By dropdownLocator, String partialText) {
		try {
			WebElement dropdown = driver.findElement(dropdownLocator);
			Select select = new Select(dropdown);

			// Get all options
			List<WebElement> options = select.getOptions();

			// Iterate through options to find the one with partial match
			for (WebElement option : options) {
				if (option.getText().contains(partialText)) {
					select.selectByVisibleText(option.getText());
					break;
				}
			}
		} catch (Exception e) {
			// Handle the exception
			System.out.println("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Zoomout(int value) throws AWTException {
		Robot robot = new Robot();
		for (int i = 0; i < value; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(1000);
		}
	}
	
    //Send Report Data Collection
	 public static List<? extends Object> sendReportData() throws IOException
	 { 
		 String EMAIL_FROM = configloader().getProperty("EMAIL_FROM");
	     String FROMNAME = configloader().getProperty("FROMNAME");
	     String TO = configloader().getProperty("TO");
	     String SMTP_USERNAME = configloader().getProperty("SMTP_USERNAME");
	     String SMTP_PASSWORD = configloader().getProperty("SMTP_PASSWORD");
	     String HOST = configloader().getProperty("HOST");
	     String PORT = configloader().getProperty("PORT");
	     String SUBJECT = configloader().getProperty("SUBJECT");
	  
     return Arrays.asList(EMAIL_FROM, FROMNAME, TO, SMTP_USERNAME, SMTP_PASSWORD, HOST, PORT, SUBJECT); 
	    } 
}
