package FBMC_Employee_TCs;

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


public class FBMC_Employee_AllScenarios extends Base_Class {
		TestListener TestListener;
		Base_Class Base_Class;
		
		
		EmailReport EmailReport = new EmailReport();
		Log log;
		com.Utility.ScreenShot screenShot;
		com.Utility.ExcelReader ExcelReader;
		
	/////////////// About_Page/////////////////////////
		
		FBMC_EmployeeFlow FBMC_EmployeeFlow;
		
		private static By L_username = By.xpath("//a/i[@class='material-icons useradmin-ico']");
		private static By L_Logout = By.xpath("//li/a/span[@class='user']");
		
		@BeforeSuite
		public void reference() throws IOException {
			ExcelReader = new com.Utility.ExcelReader("FBMC_Employee");
			log = new Log();
			TestListener = new TestListener();
			screenShot = new com.Utility.ScreenShot(null);
			Base_Class = new Base_Class();
			/////////////// FBMC_Emp_Page///////////////////////////
			
			FBMC_EmployeeFlow = new FBMC_EmployeeFlow();
		}
		
		@AfterSuite
		public void CloseAllBrowser() throws InterruptedException, IOException, MessagingException {
			String SEND_REPORT = configloader().getProperty("SEND_REPORT");
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			// EndTest
			ExtentManager.getInstance().flush();
			Thread.sleep(5000);
			//Send Automation Report to an Email
			if(!SEND_REPORT.equalsIgnoreCase("FALSE"))
			{
			String location	= ExtentManager.getReportlocation();
			EmailReport.sendEmailWithAttachment(location);
			}
		}


		public void Login() throws InterruptedException {
			String ReferenceLogin = "FBMC";
			try {
				Base_Class.SetUp(ReferenceLogin);
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
				Thread.sleep(10000);
				MouseHoverOnElement(L_username);
				if (ElementDisplayed(L_Logout)) {
					Thread.sleep(10000);
					MouseHoverOnElement(L_Logout);
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
				String GroupName=testdata.get("GroupName").toString();
				String EmailId=testdata.get("EmailId").toString();
				String Password=testdata.get("Password").toString();
				String SecurityQuestion1=testdata.get("SecurityQuestion1").toString();
				String SecurityAnswer1=testdata.get("SecurityAnswer1").toString();
				String SecurityQuestion2=testdata.get("SecurityQuestion2").toString();
				String SecurityAnswer2=testdata.get("SecurityAnswer2").toString();
				String SecurityQuestion3=testdata.get("SecurityQuestion3").toString();
				String SecurityAnswer3=testdata.get("SecurityAnswer3").toString();

				
				if (testdata.get("Run").toString().equalsIgnoreCase("Yes") && TestScenario.contains("FBMC")) {
					ExtentTestManager.startTest(TestScenario);
					System.out.println("\n");
					System.out.println(
							"<--------------------------------------- START NEW TESTCASE --------------------------------------------------------->");
					ExtentSuccessMessage("*** Running test method " + TestScenario + "...");
					Log.info("*** Running test method " + TestScenario + "...");

					switch (TestScenario) 
					{

					//////////////////// FBMC_Employee_Page///////////////////////
					
					case "FBMC_EmployeeFlow":
						context.setAttribute("fileName", "Login");
						Login();
						FBMC_EmployeeFlow.FBMC_Employee_flows(TestScenario,GroupName,testdata,EmailId,Password,SecurityQuestion1,SecurityAnswer1,SecurityQuestion2,SecurityAnswer2,SecurityQuestion3,SecurityAnswer3);
						Logout();
						context.setAttribute("fileName", "Logout");
						break;		
					
					default:
						break;

					}

					// EndTest
					System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
					ExtentTestManager.endTest();
					ExtentManager.getInstance().flush();
					Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");

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
