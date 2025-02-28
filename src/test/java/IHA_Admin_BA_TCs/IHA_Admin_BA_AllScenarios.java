package IHA_Admin_BA_TCs;

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



public class IHA_Admin_BA_AllScenarios extends Base_Class {
	TestListener TestListener;
	Base_Class Base_Class;
	Log log;
	com.Utility.ScreenShot screenShot;
	com.Utility.ExcelReader ExcelReader;

	EmailReport EmailReport = new EmailReport();	
	/////////////// About_Page/////////////////////////

	IHA_TenantDashboardFlow IHA_TenantDashboardFlow;
	IHA_GroupDashboardFlow IHA_GroupDashboardFlow;
	IHA_ActivateEmployeeFlow IHA_ActivateEmployeeFlow;
	IHA_SubmitEmployeeFlow IHA_SubmitEmployeeFlow;
	IHA_ActivateAndEnrollFlow IHA_ActivateAndEnrollFlow;
	IHA_DeclineAllCoveragesFlow IHA_DeclineAllCoveragesFlow;
	IHA_TerminateMedicalFlow IHA_TerminateMedicalFlow;
	IHA_SummaryVerificationFlow IHA_SummaryVerificationFlow;
	IHA_ReEnrollMedicalFlow IHA_ReEnrollMedicalFlow;
	IHA_ChangePlanMedicalFlow IHA_ChangePlanMedicalFlow;
	IHA_QE_On_MedicalFlow IHA_QE_On_MedicalFlow;
	IHA_UpdateCoveredMembersMedicalFlow IHA_UpdateCoveredMembersMedicalFlow;
	IHA_TerminateEmployeeFlow IHA_TerminateEmployeeFlow;
	IHA_EmployeeReHireEnrollFlow IHA_EmployeeReHireEnrollFlow;
	IHA_EmployeeReinstateFlow IHA_EmployeeReinstateFlow;
	IHA_CascadeScenarioFlow IHA_CascadeScenarioFlow;
	IHA_Admin_BA_TCs.IHA_RetroEnrollmentFlow IHA_RetroEnrollmentFlow;
	IHA_RetroTerminationFlow IHA_RetroTerminationFlow;
	IHA_CombinedFlow IHA_CombinedFlow;
	//IHA_Combined_Flow IHA_Combined_Flow;
	
	private static By L_username = By.xpath("//a/i[@class='material-icons useradmin-ico']");
	private static By L_Logout = By.xpath("//li/a/span[@class='user']");

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("IHA_Admin");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		/////////////// IHAAdmin_Page///////////////////////////
		IHA_TenantDashboardFlow =new IHA_TenantDashboardFlow();
		IHA_GroupDashboardFlow = new IHA_GroupDashboardFlow();
		IHA_ActivateEmployeeFlow = new  IHA_ActivateEmployeeFlow();
		IHA_SubmitEmployeeFlow = new  IHA_SubmitEmployeeFlow();
		IHA_ActivateAndEnrollFlow = new  IHA_ActivateAndEnrollFlow();
		IHA_DeclineAllCoveragesFlow = new  IHA_DeclineAllCoveragesFlow();
		IHA_TerminateMedicalFlow = new  IHA_TerminateMedicalFlow();
		IHA_SummaryVerificationFlow = new  IHA_SummaryVerificationFlow();
		IHA_ReEnrollMedicalFlow = new  IHA_ReEnrollMedicalFlow();
		IHA_ChangePlanMedicalFlow = new  IHA_ChangePlanMedicalFlow();
		IHA_QE_On_MedicalFlow = new  IHA_QE_On_MedicalFlow();
		IHA_UpdateCoveredMembersMedicalFlow = new  IHA_UpdateCoveredMembersMedicalFlow();
		IHA_TerminateEmployeeFlow = new  IHA_TerminateEmployeeFlow();
		IHA_EmployeeReHireEnrollFlow = new  IHA_EmployeeReHireEnrollFlow();
		IHA_EmployeeReinstateFlow = new  IHA_EmployeeReinstateFlow();
		IHA_CascadeScenarioFlow = new  IHA_CascadeScenarioFlow();
		IHA_RetroEnrollmentFlow = new  IHA_RetroEnrollmentFlow();
		IHA_RetroTerminationFlow = new  IHA_RetroTerminationFlow();
		IHA_CombinedFlow = new IHA_CombinedFlow();
	
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
		String ReferenceLogin = "IHA";
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
			Thread.sleep(2000);
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
			String GroupName=testdata.get("AccountName").toString();
			
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes") && TestScenario.contains("IHA")) {
				ExtentTestManager.startTest(TestScenario);
				System.out.println("\n");
				System.out.println(
						"<--------------------------------------- START NEW TESTCASE --------------------------------------------------------->");
				ExtentSuccessMessage("*** Running test method " + TestScenario + "...");
				Log.info("*** Running test method " + TestScenario + "...");

				switch (TestScenario) 
				{

				//////////////////// IHA_Employee_Page////////////////////////
				case "IHA_TenantDashboardFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_TenantDashboardFlow.ValidateTenantDashboardpage(TestScenario,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "IHA_GroupDashboardFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_GroupDashboardFlow.ValidateAccountDashboardpage(TestScenario,GroupName);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "IHA_ActivateEmployeeFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_ActivateEmployeeFlow.ValidateActivateEmployee(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "IHA_SubmitEmployeeFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_SubmitEmployeeFlow.ValidateSubmitEmployee(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "IHA_ActivateAndEnrollFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_ActivateAndEnrollFlow.ValidateActivateEnrollEmployee(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "IHA_DeclineAllCoveragesFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_DeclineAllCoveragesFlow.ValidateDeclineAllCoverage(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "IHA_TerminateMedicalFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_TerminateMedicalFlow.ValidateTerminateMedical(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "IHA_SummaryVerificationFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_SummaryVerificationFlow.ValidateSummaryVerification(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;				
				case "IHA_ReEnrollMedicalFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_ReEnrollMedicalFlow.ValidateReEnrollMedical(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
				case "IHA_ChangePlanMedicalFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_ChangePlanMedicalFlow.ValidateChangePlanMedical(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
				case "IHA_QE_On_MedicalFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_QE_On_MedicalFlow.ValidateQEonMedical(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
				case "IHA_UpdateCoveredMembersMedicalFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_UpdateCoveredMembersMedicalFlow.ValidateUpdateCoveredMembersMedical(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "IHA_TerminateEmployeeFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_TerminateEmployeeFlow.ValidateTerminateEmployee(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
				case "IHA_EmployeeReHireEnrollFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_EmployeeReHireEnrollFlow.ValidateEmployeeReHireEnroll(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
				case "IHA_EmployeeReinstateFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_EmployeeReinstateFlow.ValidateEmployeeReinstate(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "IHA_CascadeScenarioFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_CascadeScenarioFlow.ValidateCascadeScenario(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
				case "IHA_RetroEnrollmentFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_RetroEnrollmentFlow.ValidateRetroEnrollment(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "IHA_RetroTerminationFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_RetroTerminationFlow.ValidateRetroTermination(TestScenario,GroupName,testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
					
				case "IHA_CombinedFlow":
					context.setAttribute("fileName", "Login");
					Login();
					IHA_CombinedFlow.ValidateCombinedFlow(TestScenario,GroupName, testdata);
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
//			if (driver != null)
				driver.quit();
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



