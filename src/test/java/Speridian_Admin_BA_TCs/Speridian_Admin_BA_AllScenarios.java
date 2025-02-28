package Speridian_Admin_BA_TCs;

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

public class Speridian_Admin_BA_AllScenarios extends Base_Class {
	TestListener TestListener;
	Base_Class Base_Class;
	Log log;
	com.Utility.ScreenShot screenShot;
	com.Utility.ExcelReader ExcelReader;
	EmailReport EmailReport = new EmailReport();
	/////////////// About_Page/////////////////////////

	
	Speridian_TenantDashboardFlow Speridian_TenantDashboardFlow;
	Speridian_GroupDashboardFlow Speridian_GroupDashboardFlow;
	Speridian_ActivateEmployeeFlow Speridian_ActivateEmployeeFlow;
	Speridian_SubmitEmployeeFlow Speridian_SubmitEmployeeFlow;
	Speridian_ActivateAndEnrollFlow Speridian_ActivateAndEnrollFlow;
	Speridian_DeclineAllCoveragesFlow Speridian_DeclineAllCoveragesFlow;
	Speridian_TerminateMedicalFlow Speridian_TerminateMedicalFlow;
	Speridian_TerminateAncillaryFlow Speridian_TerminateAncillaryFlow;
	Speridian_SummaryVerificationFlow Speridian_SummaryVerificationFlow;
	Speridian_ViewBenefitsAndSBCFlow Speridian_ViewBenefitsAndSBCFlow;
	Speridian_ReEnrollMedicalFlow Speridian_ReEnrollMedicalFlow;
	Speridian_ReEnrollAncillaryFlow Speridian_ReEnrollAncillaryFlow;
	Speridian_ChangePlanMedicalFlow Speridian_ChangePlanMedicalFlow;
	Speridian_ChangePlanAncillaryFlow Speridian_ChangePlanAncillaryFlow;
	Speridian_ChangeCoverageAmountFlow Speridian_ChangeCoverageAmountFlow;
	Speridian_EnrollAndMaintainenceWithRateEditPlanFlow Speridian_EnrollAndMaintainenceWithRateEditPlanFlow;
	Speridian_QE_On_MedicalFlow Speridian_QE_On_MedicalFlow;
	Speridian_QE_On_AncillaryFlow Speridian_QE_On_AncillaryFlow;
	Speridian_UpdateCoveredMembersMedicalFlow Speridian_UpdateCoveredMembersMedicalFlow;
	Speridian_UpdateCoveredMembersAncillaryFlow Speridian_UpdateCoveredMembersAncillaryFlow;
	Speridian_TerminateEmployeeFlow Speridian_TerminateEmployeeFlow;
	Speridian_EmployeeReHireEnrollFlow Speridian_EmployeeReHireEnrollFlow;
	Speridian_EmployeeReinstateFlow Speridian_EmployeeReinstateFlow;
	Speridian_CascadeScenarioFlow Speridian_CascadeScenarioFlow;
	Speridian_RetroEnrollmentFlow Speridian_RetroEnrollmentFlow;
	Speridian_RetroTerminationFlow Speridian_RetroTerminationFlow;
	Speridian_CombinedFlow Speridian_CombinedFlow;

	private static By L_username = By.xpath("//a/i[@class='material-icons useradmin-ico']");
	private static By L_Logout = By.xpath("//*[@class='divRedirect'][contains(@data-redirecturl,'Logout')]");

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Speridian_Admin");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		/////////////// Speridian_Employee_Page///////////////////////////

		Speridian_TenantDashboardFlow = new Speridian_TenantDashboardFlow();
		Speridian_GroupDashboardFlow = new Speridian_GroupDashboardFlow();
		Speridian_ActivateEmployeeFlow = new Speridian_ActivateEmployeeFlow();
		Speridian_SubmitEmployeeFlow = new Speridian_SubmitEmployeeFlow();
		Speridian_ActivateAndEnrollFlow = new Speridian_ActivateAndEnrollFlow();
		Speridian_DeclineAllCoveragesFlow = new Speridian_DeclineAllCoveragesFlow();
		Speridian_TerminateMedicalFlow = new Speridian_TerminateMedicalFlow();
		Speridian_TerminateAncillaryFlow = new Speridian_TerminateAncillaryFlow();
		Speridian_SummaryVerificationFlow = new Speridian_SummaryVerificationFlow();
		Speridian_ViewBenefitsAndSBCFlow = new Speridian_ViewBenefitsAndSBCFlow();
		Speridian_ReEnrollMedicalFlow = new Speridian_ReEnrollMedicalFlow();
		Speridian_ReEnrollAncillaryFlow = new Speridian_ReEnrollAncillaryFlow();
		Speridian_ChangePlanMedicalFlow = new Speridian_ChangePlanMedicalFlow();
		Speridian_ChangePlanAncillaryFlow = new Speridian_ChangePlanAncillaryFlow();
		Speridian_ChangeCoverageAmountFlow = new Speridian_ChangeCoverageAmountFlow();
		Speridian_EnrollAndMaintainenceWithRateEditPlanFlow = new Speridian_EnrollAndMaintainenceWithRateEditPlanFlow();
		Speridian_QE_On_MedicalFlow = new Speridian_QE_On_MedicalFlow();
		Speridian_QE_On_AncillaryFlow = new Speridian_QE_On_AncillaryFlow();
		Speridian_UpdateCoveredMembersMedicalFlow = new Speridian_UpdateCoveredMembersMedicalFlow();
		Speridian_UpdateCoveredMembersAncillaryFlow = new Speridian_UpdateCoveredMembersAncillaryFlow();
		Speridian_TerminateEmployeeFlow = new Speridian_TerminateEmployeeFlow();
		Speridian_EmployeeReHireEnrollFlow = new Speridian_EmployeeReHireEnrollFlow();
		Speridian_EmployeeReinstateFlow = new Speridian_EmployeeReinstateFlow();
		Speridian_CascadeScenarioFlow = new Speridian_CascadeScenarioFlow();
		Speridian_RetroEnrollmentFlow = new Speridian_RetroEnrollmentFlow();
		Speridian_RetroTerminationFlow = new Speridian_RetroTerminationFlow();
		Speridian_CombinedFlow = new Speridian_CombinedFlow();
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
			KillChrome();
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
			String GroupName = testdata.get("AccountName").toString();

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes") && TestScenario.contains("Speridian")) {
				ExtentTestManager.startTest(TestScenario);
				System.out.println("\n");
				System.out.println("<--------------------------------------- START NEW TESTCASE --------------------------------------------------------->");
				ExtentSuccessMessage("*** Running test method " + TestScenario + "...");
				Log.info("*** Running test method " + TestScenario + "...");

				switch (TestScenario) {

				//////////////////// Speridian_Employee_Page////////////////////////
				case "Speridian_TenantDashboardFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_TenantDashboardFlow.ValidateTenantDashboardpage(TestScenario, GroupName);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_GroupDashboardFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_GroupDashboardFlow.ValidateAccountDashboardpage(TestScenario, GroupName);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_ActivateEmployeeFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_ActivateEmployeeFlow.ValidateActivateEmployee(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_SubmitEmployeeFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_SubmitEmployeeFlow.ValidateSubmitEmployee(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_ActivateAndEnrollFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_ActivateAndEnrollFlow.ValidateActivateAndEnrollEmployee(TestScenario, GroupName,
							testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_DeclineAllCoveragesFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_DeclineAllCoveragesFlow.ValidateDeclineAllCoverages(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_TerminateMedicalFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_TerminateMedicalFlow.ValidateTerminateMedical(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_TerminateAncillaryFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_TerminateAncillaryFlow.ValidateTerminateAncillary(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_SummaryVerificationFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_SummaryVerificationFlow.ValidateSummaryVerification(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_ViewBenefitsAndSBCFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_ViewBenefitsAndSBCFlow.ValidateViewBenefitsAndSBCFlow(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_ReEnrollMedicalFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_ReEnrollMedicalFlow.ValidateReEnrollMedical(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_ReEnrollAncillaryFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_ReEnrollAncillaryFlow.ValidateReEnrollAncillary(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_ChangePlanMedicalFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_ChangePlanMedicalFlow.ValidateChangePlanMedical(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_ChangePlanAncillaryFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_ChangePlanAncillaryFlow.ValidateChangePlanAncillary(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_ChangeCoverageAmountFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_ChangeCoverageAmountFlow.ValidateChangeCoverageAmount(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_EnrollAndMaintainenceWithRateEditPlanFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_EnrollAndMaintainenceWithRateEditPlanFlow.ValidateEnrollAndMaintainenceWithRateEditPlan(TestScenario, GroupName,
							testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_QE_On_MedicalFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_QE_On_MedicalFlow.ValidateQEonMedical(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_QE_On_AncillaryFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_QE_On_AncillaryFlow.ValidateQEOnAncillary(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_UpdateCoveredMembersMedicalFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_UpdateCoveredMembersMedicalFlow.ValidateUpdateCoveredMembersMedical(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_UpdateCoveredMembersAncillaryFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_UpdateCoveredMembersAncillaryFlow.ValidateUpdateCoveredMembersAncillary(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_TerminateEmployeeFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_TerminateEmployeeFlow.ValidateTerminateEmployee(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_EmployeeReHireEnrollFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_EmployeeReHireEnrollFlow.ValidateEmployeeReHireEnroll(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_EmployeeReinstateFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_EmployeeReinstateFlow.ValidateEmployeeReinstate(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_CascadeScenarioFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_CascadeScenarioFlow.ValidateCascadeScenario(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_RetroEnrollmentFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_RetroEnrollmentFlow.ValidateRetroEnrollment(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_RetroTerminationFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_RetroTerminationFlow.ValidateRetroTermination(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "Speridian_CombinedFlow":
					context.setAttribute("fileName", "Login");
					Login();
					Speridian_CombinedFlow.ValidateCombinedFlow(TestScenario, GroupName, testdata);
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
				KillChrome();

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
