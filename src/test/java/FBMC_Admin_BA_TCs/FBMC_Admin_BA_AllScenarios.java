package FBMC_Admin_BA_TCs;

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
public class FBMC_Admin_BA_AllScenarios extends Base_Class {
	TestListener TestListener;
	Base_Class Base_Class;
	Log log;
	com.Utility.ScreenShot screenShot;
	com.Utility.ExcelReader ExcelReader;

	/////////////// About_Page/////////////////////////

	FBMC_TenantDashboardFlow FBMC_TenantDashboardFlow;
	FBMC_GroupDashboardFlow FBMC_GroupDashboardFlow;
	FBMC_ActivateEmployeeFlow FBMC_ActivateEmployeeFlow;
	FBMC_SubmitEmployeeFlow FBMC_SubmitEmployeeFlow;
	FBMC_ActivateAndEnrollFlow FBMC_ActivateAndEnrollFlow;
	FBMC_DeclineAllCoveragesFlow FBMC_DeclineAllCoveragesFlow;
	FBMC_TerminateMedicalFlow FBMC_TerminateMedicalFlow;
	FBMC_TerminateAncillaryFlow FBMC_TerminateAncillaryFlow;
	FBMC_SummaryVerificationFlow FBMC_SummaryVerificationFlow;
	FBMC_ViewBenefitsAndSBCFlow FBMC_ViewBenefitsAndSBCFlow;
	FBMC_CCLetterVerificationFlow FBMC_CCLetterVerificationFlow;
	FBMC_ChangePlanMedicalFlow FBMC_ChangePlanMedicalFlow;
	FBMC_ChangePlanMedicareFlow FBMC_ChangePlanMedicareFlow;
	FBMC_ChangePlanAncillaryFlow FBMC_ChangePlanAncillaryFlow;
	FBMC_ChangeCoverageAmountFlow FBMC_ChangeCoverageAmountFlow;
	FBMC_EnrollAndMaintainenceWithRateEditPlanFlow FBMC_EnrollAndMaintainenceWithRateEditPlanFlow;
	FBMC_QE_On_MedicalFlow FBMC_QE_On_MedicalFlow;
	FBMC_QE_On_MedicareFlow FBMC_QE_On_MedicareFlow;
	FBMC_QE_On_AncillaryFlow FBMC_QE_On_AncillaryFlow;
	FBMC_UpdateCoveredMembersMedicalFlow FBMC_UpdateCoveredMembersMedicalFlow;
	FBMC_UpdateCoveredMembersAncillaryFlow FBMC_UpdateCoveredMembersAncillaryFlow;
	FBMC_TerminateEmployeeFlow FBMC_TerminateEmployeeFlow;
	FBMC_EmployeeReHireEnrollFlow FBMC_EmployeeReHireEnrollFlow;
	FBMC_EmployeeReinstateFlow FBMC_EmployeeReinstateFlow;
	FBMC_CascadeScenarioFlow FBMC_CascadeScenarioFlow;
	FBMC_TerminateMedicareFlow FBMC_TerminateMedicareFlow;
	FBMC_ReEnrollAncillaryFlow FBMC_ReEnrollAncillaryFlow;
	FBMC_ReEnrollMedicalFlow FBMC_ReEnrollMedicalFlow;
	FBMC_ReEnrollMedicareFLow FBMC_ReEnrollMedicareFLow;
	FBMC_RetroEnrollmentFlow FBMC_RetroEnrollmentFlow;
	FBMC_RetroTerminationFlow FBMC_RetroTerminationFlow;
	FBMC_CL_ACHFormFlow FBMC_CL_ACHFormFlow;
	FBMC_CL_FRSFormFlow FBMC_CL_FRSFormFlow;
	FBMC_CombinedFlow FBMC_CombinedFlow;
	EmailReport EmailReport = new EmailReport();
	private static By L_username = By.xpath("//a/i[@class='material-icons useradmin-ico']");
	private static By L_Logout = By.xpath("//li/a/i[@class='fa fa-power-off']");

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("FBMC_Admin");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		/////////////// FBMC_Employee_Page///////////////////////////

		FBMC_TenantDashboardFlow = new FBMC_TenantDashboardFlow();
		FBMC_GroupDashboardFlow = new FBMC_GroupDashboardFlow();
		FBMC_ActivateEmployeeFlow = new FBMC_ActivateEmployeeFlow();
		FBMC_SubmitEmployeeFlow = new FBMC_SubmitEmployeeFlow();
		FBMC_ActivateAndEnrollFlow = new FBMC_ActivateAndEnrollFlow();
		FBMC_DeclineAllCoveragesFlow = new FBMC_DeclineAllCoveragesFlow();
		FBMC_TerminateMedicalFlow = new FBMC_TerminateMedicalFlow();
		FBMC_TerminateMedicareFlow = new FBMC_TerminateMedicareFlow();
		FBMC_TerminateAncillaryFlow = new FBMC_TerminateAncillaryFlow();
		FBMC_SummaryVerificationFlow = new FBMC_SummaryVerificationFlow();
		FBMC_ViewBenefitsAndSBCFlow = new FBMC_ViewBenefitsAndSBCFlow();
		FBMC_CCLetterVerificationFlow = new FBMC_CCLetterVerificationFlow();
		FBMC_ChangePlanMedicalFlow = new FBMC_ChangePlanMedicalFlow();
		FBMC_ChangePlanMedicareFlow = new FBMC_ChangePlanMedicareFlow();
		FBMC_ChangePlanAncillaryFlow = new FBMC_ChangePlanAncillaryFlow();
		FBMC_ChangeCoverageAmountFlow = new FBMC_ChangeCoverageAmountFlow();
		FBMC_EnrollAndMaintainenceWithRateEditPlanFlow = new FBMC_EnrollAndMaintainenceWithRateEditPlanFlow();
		FBMC_QE_On_MedicalFlow = new FBMC_QE_On_MedicalFlow();
		FBMC_QE_On_MedicareFlow = new FBMC_QE_On_MedicareFlow();
		FBMC_QE_On_AncillaryFlow = new FBMC_QE_On_AncillaryFlow();
		FBMC_ReEnrollAncillaryFlow = new FBMC_ReEnrollAncillaryFlow();
		FBMC_TerminateMedicareFlow = new FBMC_TerminateMedicareFlow();
		FBMC_ReEnrollMedicalFlow = new FBMC_ReEnrollMedicalFlow();
		FBMC_ReEnrollMedicareFLow = new FBMC_ReEnrollMedicareFLow();
		FBMC_UpdateCoveredMembersMedicalFlow = new FBMC_UpdateCoveredMembersMedicalFlow();
		FBMC_UpdateCoveredMembersAncillaryFlow = new FBMC_UpdateCoveredMembersAncillaryFlow();
		FBMC_TerminateEmployeeFlow = new FBMC_TerminateEmployeeFlow();
		FBMC_EmployeeReHireEnrollFlow = new FBMC_EmployeeReHireEnrollFlow();
		FBMC_EmployeeReinstateFlow = new FBMC_EmployeeReinstateFlow();
		FBMC_CascadeScenarioFlow = new FBMC_CascadeScenarioFlow();
		FBMC_RetroEnrollmentFlow = new FBMC_RetroEnrollmentFlow();
		FBMC_RetroTerminationFlow = new FBMC_RetroTerminationFlow();
		FBMC_CL_ACHFormFlow = new FBMC_CL_ACHFormFlow();
		FBMC_CL_FRSFormFlow = new FBMC_CL_FRSFormFlow();
		FBMC_CombinedFlow = new FBMC_CombinedFlow();
		
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
			String GroupName = testdata.get("GroupName").toString();

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes") && TestScenario.contains("FBMC")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				System.out.println("\n");
				System.out.println(
						"<--------------------------------------- START NEW TESTCASE --------------------------------------------------------->");
				ExtentSuccessMessage("*** Running test method " + TestScenario + "...");
				Log.info("*** Running test method " + TestScenario + "...");

				switch (TestScenario) {

				//////////////////// FBMC_Employee_Page////////////////////////

				case "FBMC_TenantDashboardFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_TenantDashboardFlow.ValidateTenantDashboard(TestScenario, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_GroupDashboardFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_GroupDashboardFlow.ValidateGroupDashboardpage(TestScenario, GroupName);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

				case "FBMC_ActivateEmployeeFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_ActivateEmployeeFlow.ValidateActivateEmployee(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

				case "FBMC_SubmitEmployeeFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_SubmitEmployeeFlow.ValidateSubmitEmployee(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

				case "FBMC_ActivateAndEnrollFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_ActivateAndEnrollFlow.ValidateActivateAndEnroll(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_DeclineAllCoveragesFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_DeclineAllCoveragesFlow.ValidateDeclineAllCoverages(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_TerminateMedicalFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_TerminateMedicalFlow.ValidateTerminateMedical(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_TerminateMedicareFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_TerminateMedicareFlow.ValidateTerminateMedicare(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_ViewBenefitsAndSBCFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_ViewBenefitsAndSBCFlow.ValidateViewBenefits(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_CCLetterVerificationFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_CCLetterVerificationFlow.ValidateCCLetterVerification(TestScenario, GroupName);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_TerminateAncillaryFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_TerminateAncillaryFlow.ValidateTerminateAncillary(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_SummaryVerificationFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_SummaryVerificationFlow.ValidateSummaryVerification(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_ChangePlanMedicalFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_ChangePlanMedicalFlow.ValidateChangePlanMedical(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_ChangePlanMedicareFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_ChangePlanMedicareFlow.ValidateChangePlanMedicare(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_ChangePlanAncillaryFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_ChangePlanAncillaryFlow.ValidateChangePlanAncillary(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_EnrollAndMaintainenceWithRateEditPlanFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_EnrollAndMaintainenceWithRateEditPlanFlow
							.ValidateEnrollAndMaintainenceWithRateEditPlan(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_QE_On_MedicalFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_QE_On_MedicalFlow.ValidateQEonMedical(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_QE_On_MedicareFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_QE_On_MedicareFlow.ValidateQEOnMedicare(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_QE_On_AncillaryFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_QE_On_AncillaryFlow.ValidateQEOnAncillary(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_ChangeCoverageAmountFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_ChangeCoverageAmountFlow.ValidateChangeCoverageAmount(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_UpdateCoveredMembersMedicalFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_UpdateCoveredMembersMedicalFlow.ValidateUpdateCoveredMembersMedical(TestScenario, GroupName,
							testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_ReEnrollAncillaryFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_ReEnrollAncillaryFlow.ValidateReEnrollAncillary(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;				
				case "FBMC_ReEnrollMedicalFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_ReEnrollMedicalFlow.ValidateReEnrollMedical(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_ReEnrollMedicareFLow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_ReEnrollMedicareFLow.ValidateReEnrollMedicare(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_UpdateCoveredMembersAncillaryFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_UpdateCoveredMembersAncillaryFlow.ValidateUpdateCoveredMembersAncillary(TestScenario,
							GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_TerminateEmployeeFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_TerminateEmployeeFlow.ValidateTerminateEmployee(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_EmployeeReHireEnrollFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_EmployeeReHireEnrollFlow.ValidateEmployeeReHireEnroll(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_EmployeeReinstateFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_EmployeeReinstateFlow.ValidateEmployeeReinstate(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_CascadeScenarioFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_CascadeScenarioFlow.ValidateCascadeScenario(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_RetroEnrollmentFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_RetroEnrollmentFlow.ValidateRetroEnrollment(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_RetroTerminationFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_RetroTerminationFlow.ValidateRetroTermination(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_CL_ACHFormFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_CL_ACHFormFlow.ValidateCLACHForm(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_CL_FRSFormFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_CL_FRSFormFlow.ValidateCLFRSForm(TestScenario, GroupName, testdata);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "FBMC_CombinedFlow":
					context.setAttribute("fileName", "Login");
					Login();
					FBMC_CombinedFlow.ValidateFBMC_CombinedFlow(TestScenario, GroupName, testdata);
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
			//if (driver != null)
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
