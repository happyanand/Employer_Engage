package Speridian_User_Admin_Registration_TCs;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
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

public class Speridian_User_Admin_Registration_AllScenarios extends Base_Class {
	TestListener TestListener;
	Base_Class Base_Class;
	Log log;
	com.Utility.ScreenShot screenShot;
	com.Utility.ExcelReader ExcelReader;
	EmailReport EmailReport = new EmailReport();
	/////////////// About_Page/////////////////////////

	
	Speridian_BAAdmin_Add_Edit_Delete_Flow Speridian_BAAdmin_Add_Edit_Delete_Flow;
	Speridian_ClientAdmin_Add_Edit_Delete_Flow Speridian_ClientAdmin_Add_Edit_Delete_Flow;
	Speridian_Userprofile_Add_Edit_Delete_TenantAdmin_Flow Speridian_Userprofile_Add_Edit_Delete_TenantAdmin_Flow;
	Speridian_Employee_Edit_registrationFlow Speridian_Employee_Edit_registrationFlow;
	Speridian_Employee_Enrollment_NotificationFlow Speridian_Employee_Enrollment_NotificationFlow;

	private static By L_username = By.xpath("//a/i[@class='material-icons useradmin-ico']");
	private static By L_Logout = By.xpath("//*[@class='divRedirect'][contains(@data-redirecturl,'Logout')]");

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Speridian_UserAdminRegistration");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		/////////////// Speridian_Employee_Page///////////////////////////

		Speridian_BAAdmin_Add_Edit_Delete_Flow = new Speridian_BAAdmin_Add_Edit_Delete_Flow();
		Speridian_ClientAdmin_Add_Edit_Delete_Flow = new Speridian_ClientAdmin_Add_Edit_Delete_Flow();
		Speridian_Userprofile_Add_Edit_Delete_TenantAdmin_Flow = new Speridian_Userprofile_Add_Edit_Delete_TenantAdmin_Flow();
		Speridian_Employee_Edit_registrationFlow = new Speridian_Employee_Edit_registrationFlow();
		Speridian_Employee_Enrollment_NotificationFlow = new Speridian_Employee_Enrollment_NotificationFlow();
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
		String Ref = "Speridian";
		try {
			Base_Class.SetUp(Ref);
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

	public void Logout() throws AWTException, IOException {
		try {
			Thread.sleep(5000);
			MouseHoverOnElement(L_username);
			if (ElementDisplayed(L_Logout)) {
				Thread.sleep(10000);
				MouseHoverOnElement(L_Logout);
				click(L_Logout);
				driver.quit();
				ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
				ExtentSuccessMessage("Logout is done");
			} else {
				Log.error("Logout Not Visiable");
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
			String PhoneNo=testdata.get("Phone").toString();
			String EmailId=testdata.get("EmailId").toString();
			String Group=testdata.get("Group").toString();
			String Password=testdata.get("Password").toString();
			String GroupName=testdata.get("GroupName").toString();
			String Role=testdata.get("Role").toString();

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes") && TestScenario.contains("Speridian_")) {
				ExtentTestManager.startTest(TestScenario);
				System.out.println("\n");
				System.out.println("<--------------------------------------- START NEW TESTCASE --------------------------------------------------------->");
				ExtentSuccessMessage("*** Running test method " + TestScenario + "...");
				Log.info("*** Running test method " + TestScenario + "...");

				switch (TestScenario) {

				//////////////////// Speridian_Employee_Page////////////////////////
				case "Speridian_BAAdmin_Add_Edit_Delete_Flow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_BAAdmin_Add_Edit_Delete_Flow.ValidateSperidian_BAAdmin_Add_Edit_Delete_Flow(TestScenario,GroupName,PhoneNo,EmailId,Group,Password);
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "Speridian_ClientAdmin_Add_Edit_Delete_Flow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_ClientAdmin_Add_Edit_Delete_Flow.ValidateSperidian_ClientAdmin_Add_Edit_Delete_Flow(TestScenario, GroupName,PhoneNo,EmailId,Group,Password);
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "Speridian_Userprofile_Add_Edit_Delete_TenantAdmin_Flow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_Userprofile_Add_Edit_Delete_TenantAdmin_Flow.ValidateSperidian_Userprofile_Add_Edit_Delete_TenantAdmin_Flow(TestScenario, GroupName,PhoneNo,EmailId,Password,Role);
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				
				case "Speridian_Employee_Edit_registrationFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_Employee_Edit_registrationFlow.ValidateSperidian_Employee_Edit_registrationFlow(TestScenario,Group,testdata,Password);
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				
				case "Speridian_Employee_Enrollment_NotificationFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_Employee_Enrollment_NotificationFlow.ValidateSperidian_Employee_Enrollment_NotificationFlow(TestScenario,Group,testdata,Password);
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

			//// Logout
			// try {
			// context.setAttribute("fileName", "Logout");
			// driver.quit();
			// ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			// Log.info("Logout is done");
			// } catch (Exception WebDriverException) {
			// // TODO Auto-generated catch block
			// WebDriverException.printStackTrace();
			// }

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
			driver.quit();
//			if (driver != null)
//				KillChrome();

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
