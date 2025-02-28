package Smoke_TestCases;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Utility.EmailReport;
import com.Utility.Log;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;


public class Smoke_Test_AllScenarios extends Base_Class {
	TestListener TestListener;
	Base_Class Base_Class;
	Log log;
	com.Utility.ScreenShot screenShot;
	com.Utility.ExcelReader ExcelReader;
	
/////////////// About_Page/////////////////////////
	
	FBMC_Smoke_Test_Flow FBMC_Smoke_Test_Flow;
	Speridian_Smoke_Test_Flow Speridian_Smoke_Test_Flow;
	IHA_Smoke_Test_Flow IHA_Smoke_Test_Flow;
	EmailReport EmailReport = new EmailReport();
	
	public static By L_username = By.xpath("//a/i[@class='material-icons useradmin-ico']");
	public static By L_Logout = By.xpath("//li/a/span[@class='user']");

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Smoke_Test");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		/////////////// Smoke Test ///////////////////////////
		
		FBMC_Smoke_Test_Flow = new FBMC_Smoke_Test_Flow();
		Speridian_Smoke_Test_Flow = new Speridian_Smoke_Test_Flow();
		IHA_Smoke_Test_Flow = new IHA_Smoke_Test_Flow();
	
	}
	
	@AfterSuite
	public void CloseAllBrowser() throws InterruptedException, IOException, MessagingException {
		String SEND_REPORT = configloader().getProperty("SEND_REPORT");
		ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
		ExtentManager.getInstance().flush();
		//Send Automation Report to an Email
		Thread.sleep(5000);
		if(!SEND_REPORT.equalsIgnoreCase("FALSE"))
		{
		String location	= ExtentManager.getReportlocation();
		//Base_Class.sendReportData();
		EmailReport.sendEmailWithAttachment(location) ;
		}
	}

	public void Login() throws InterruptedException {
		String ReferenceLogin = "FBMC";
		try {
			Base_Class.SetUp(ReferenceLogin);
			WaitForPageLoad();
			WaitForAJAX_ToLoad();
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			ExtentSuccessMessage("Login successful !");

		} catch (IOException e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(Status.FAIL, "Application fail to Login " + "With error ");
			ExtentErrorMessage("Issue while login into the application ");
		} catch (InterruptedException e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Application fail to Login With error");
			ExtentErrorMessage("Issue while login into the application");
			e.printStackTrace();
		}
	}
	
	public void Login1(String Value) throws InterruptedException {
		String ReferenceLogin = Value;
		try {
			new Base_Class().SetUp1(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			ExtentSuccessMessage("Login successful !");
		} catch (IOException e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(Status.FAIL, "Application fail to Login " + "With error ");
			ExtentErrorMessage("Issue while login into the application ");
		} catch (InterruptedException e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Application fail to Login With error");
			ExtentErrorMessage("Issue while login into the application");
			e.printStackTrace();
		}
	}
	
	public void Logout() throws AWTException {
		try {
			Thread.sleep(2000);
			MouseHoverOnElement(L_username);
			if (ElementDisplayed(L_Logout)) {
				Thread.sleep(1000);
				MouseHoverOnElement(L_Logout);
				Thread.sleep(1000);
				click(L_Logout);
				driver.quit();
				ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
				ExtentSuccessMessage("Logout is done");
			} else {
				ExtentErrorMessage("Logout Not Visiable");
			}
			driver.quit();
			killExcel();
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "TestData")
	public void RUNALL(Map<Object, Object> testdata, ITestContext context) throws Throwable {

		try {
			String TestScenario = testdata.get("TestScenario").toString();
			String GroupName=testdata.get("AccountName").toString();
			
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes") && TestScenario.contains("Smoke")) {
				ExtentTestManager.startTest(TestScenario);
				System.out.println("\n");
				System.out.println(
						"<--------------------------------------- START NEW TESTCASE --------------------------------------------------------->");
				ExtentSuccessMessage("*** Running test method " + TestScenario + "...");
				Log.info("*** Running test method " + TestScenario + "...");

				switch (TestScenario) 
				{

				//////////////////// Smoke Test ////////////////////////

				case "FBMC_Smoke_Test_Flow":
					context.setAttribute("fileName", "Login");
					Login1("FBMC");
					FBMC_Smoke_Test_Flow.ValidateFBMC_SmokeTest(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
					
				case "Speridian_Smoke_Test_Flow":
					context.setAttribute("fileName", "Login");
					Login1("Speridian");
					Speridian_Smoke_Test_Flow.ValidateSperidian_SmokeTest(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
				
				case "IHA_Smoke_Test_Flow":
					context.setAttribute("fileName", "Login");
					Login1("IHA");
					IHA_Smoke_Test_Flow.ValidateIHA_SmokeTest(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;			
					
				default:
					break;

				}

				// EndTest
				System.out.println(("*** Test Suite " + TestScenario + " ending ***"));
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
				Log.info("*** Test Suite " + TestScenario + " ending ***");

			}

		} catch (Exception e) {

			System.out.println("<----------------Failed--- Test execution " + testdata.get("TestScenario").toString()
					+ " ---Failed ---------------->");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception NoSuchWindowException) {
				System.out.println("Catch File not found error");
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
		} catch (AssertionError e) {
			System.out.println("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception NoSuchWindowException) {
				System.out.println("File not found error");
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			

			// EndTest
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("************************ Test Suite " + testdata.get("TestScenario").toString()
					+ " ending ****************************");

		} finally {
			if (driver != null)
				driver.quit();

		}

	}

	@DataProvider(name = "TestData")
	public static Object[][] gettestdate() throws IOException {

		Object[][] objectarry = null;
		java.util.List<Map<String, String>> completedata = com.Utility.ExcelReader.getdata();

		objectarry = new Object[completedata.size()][1];

		for (int i = 0; i < completedata.size(); i++) {
			objectarry[i][0] = completedata.get(i);
		}
		return objectarry;

	}

}
