package IHA_Content_Management;
	import java.awt.AWTException;
import java.util.Map;

import com.BasePackage.Base_Class;

import FBMC_Content_Management.FBMC_Content_Management_AllScenarios;
import Pages.Agency_Page;
import Pages.Agency_Details_Page;
import Pages.ContentManagement_Page;
import Pages.EmailLogs;
import Pages.EmployeeAdministration_Page;
import Pages.EmployeeInformation_Page;
import Pages.Employee_Page;
import Pages.EnrollmentSummary_Page;
import Pages.Enrollment_Page;
import Pages.GroupDashboard_Page;
import Pages.Home_Page;
import Pages.Notifications_Page;
import Pages.Payment_Profile;
import Pages.ViewCoverage_Page;
	public class IHA_ContentManagement_AgencyContactTermination_Notifications_Flow extends IHA_ContentManagement_AllScenarios {
		Home_Page Home_Page = new Home_Page();
		ContentManagement_Page contentManagementPage = new ContentManagement_Page();
		Notifications_Page notifications_Page = new Notifications_Page();
		GroupDashboard_Page Group_Page=new GroupDashboard_Page();
		EmployeeAdministration_Page employeeAdministration=new EmployeeAdministration_Page();
		Employee_Page employeePage=new Employee_Page();
		EmployeeInformation_Page employeeInformationPage=new EmployeeInformation_Page();
		Enrollment_Page enrollmentPage=new Enrollment_Page();
		ViewCoverage_Page ViewCoverage_Page = new ViewCoverage_Page();
		EnrollmentSummary_Page enrollmentSummaryPage=new EnrollmentSummary_Page();
		Base_Class Base_Class =new Base_Class();
		Payment_Profile Payment_Profile = new Payment_Profile();
		EmailLogs EmailLogs = new EmailLogs();
		Agency_Page Agency_Page=new Agency_Page();
		Agency_Details_Page Agency_Details_Page=new Agency_Details_Page();

		public void ValidateIHA_ContentManagement_AgencyContactTermination_Notifications_Flow(String testScenario,Map<Object, Object> testdata) throws InterruptedException, AWTException {

			//Click on ContentManagement Tab
			Home_Page.CheckContentManagementTabDispaly();
			//Click on the Notifications
			contentManagementPage.ClickOnnotifications();
			//Search for Employee Registration in the Search bar.
			notifications_Page.search_Notification_Name(testdata);
			//Turn off Status button.
			notifications_Page.TurnOnNotification();

			//******************ADD Agency******************
			// Click on More
			Home_Page.ClickOnMoreTab();
			// CliCK OnBroker Management
			Home_Page.ClickOnBrokerManagement();
			//Click on Add Agency btn
			Agency_Page.ClickOnAddAgencyButton();
			// Provide SF Entity ID
			Agency_Page.EnterSFEntityId();
			// Click onAgency Name
			String agencyName=Agency_Page.EnterAgencyName();
			// Click on Agency Type
			Agency_Page.selectAgencyType("Broker Firm");
			// Click on Save btn.
			Agency_Page.ClickOnSaveButton();
			// Click on Ok on Confirmation popup
			Agency_Page.ClickOnOKButton();
			//  Click Ok on Provide above created Agency name 
			Agency_Page.EnterAgencyNameInSearchBar(agencyName);
			// Click Ok onSearch bar and click on Search icon.
			Agency_Page.ClickOnSearchIcon();
			// Click on AgencyNameValidation
			Agency_Page.AgencyNameValidation(agencyName);
			// Click on the Agency name.
			Agency_Page.ClickOnAgencyNameInGrid();

			//*******************Add Agency contact****************

			// Click on Add Contact btn.
			Agency_Details_Page.ClickOnAddContactButton();
			// Click on Provide SF Entity ID
			Agency_Details_Page.EnterSFEntityId();
			// Click on Agency_Details_Page
			String AgencyContacts=Agency_Details_Page.EnterPersonalDetails();
			// Click on Save btn.
			Agency_Details_Page.ClickOnSaveButton();
			// Click on Ok on Confirmation popup
			Agency_Page.ClickOnOKButton();

			//**************Terminate Agency contact******************

			// Click on Provide above created Agency name  in the Search bar and click on Search icon.
			Agency_Page.EnterAgencyNameInSearchBar(AgencyContacts);
			// Agency Primary contact check box 
			Agency_Page.ClickOnCheckboxofAgencyName(AgencyContacts);
			// Click on Globe Icon or Terminate btn.
			Agency_Details_Page.ClickOnTerminateButton();
			// Click on Yes Button
			Agency_Details_Page.ClickOnYesButton();
			// Click on Ok on Confirmation popup.
			Agency_Details_Page.ClickOnOKButton();

			//***********Email verification**********

			Home_Page.clickCommunicationTab();
			//Click on Email Log
			Home_Page.ClickOnEmailLog();
			WaitForPageLoad();
			WaitForLoadAnimationDisappear();
			RefreshPage();
			WaitForLoadAnimationDisappear();
			WaitForPageLoad();
			WaitForLoadAnimationDisappear();
			RefreshPage();
			WaitForLoadAnimationDisappear();
			//Enter the First Name
			EmailLogs.EnterFirstNameEmailLogEnterSearchField(AgencyContacts);
			//Click on the Email Log search button
			EmailLogs.ClickOnEmailLogSearchIcon();
			WaitForLoadAnimationDisappear();
			//Click on the View Icon
			EmailLogs.ClickOnViewIcon();
			WaitForLoadAnimationDisappear();
			//Check for the Notification ID
			EmailLogs.validateNotificationId();
			//Click on the Close Icon
			EmailLogs.ClickOnCloseIcon();
			WaitForLoadAnimationDisappear();
			//************Turn off and verify**************			
			Home_Page.CheckContentManagementTabDispaly();
			//Click on the Notifications
			contentManagementPage.ClickOnnotifications();
			//Search for Employee Registration in the Search bar.
			notifications_Page.search_Notification_Name(testdata);
			//Turn off Status button.
			notifications_Page.TurnOffNotification();

			//******************ADD Agency******************
			// Click on More
			Home_Page.ClickOnMoreTab();
			// CliCK OnBroker Management
			Home_Page.ClickOnBrokerManagement();
			//Click on Add Agency btn
			Agency_Page.ClickOnAddAgencyButton();
			// Provide SF Entity ID
			Agency_Page.EnterSFEntityId();
			// Click onAgency Name
			String agencyName1=Agency_Page.EnterAgencyName();
			// Click on Agency Type
			Agency_Page.selectAgencyType("Broker Firm");
			// Click on Save btn.
			Agency_Page.ClickOnSaveButton();
			// Click on Ok on Confirmation popup
			Agency_Page.ClickOnOKButton();
			// Click Ok on Provide above created Agency name 
			Agency_Page.EnterAgencyNameInSearchBar(agencyName1);
			// Click Ok onSearch bar and click on Search icon.
			Agency_Page.ClickOnSearchIcon();
			// Click on AgencyNameValidation
			Agency_Page.AgencyNameValidation(agencyName1);
			// Click on the Agency nam
			Agency_Page.ClickOnAgencyNameInGrid();

			//*******************Add Agency contact****************
			//Click on Add Contact btn.
			Agency_Details_Page.ClickOnAddContactButton();
			//Click on Provide SF Entity ID
			Agency_Details_Page.EnterSFEntityId();
			// Click on Agency_Details_Page
			String AgencyContacts1=Agency_Details_Page.EnterPersonalDetails();
			// Click on Save btn.
			Agency_Details_Page.ClickOnSaveButton();
			// Click on Yes Button
			Agency_Page.ClickOnOKButton();

			//**************Terminate Agency contact******************
			
			Agency_Page.EnterAgencyNameInSearchBar(AgencyContacts1);
			// Check the check  box which is beside above Agency contact name.
			Agency_Page.ClickOnCheckboxofAgencyName(AgencyContacts1);
			// Click on Globe Icon or Terminate btn.
			Agency_Details_Page.ClickOnTerminateButton();
			// Click on Agency_Details_Page
			Agency_Details_Page.ClickOnYesButton();
			// Click on Ok on Confirmation popup.
			Agency_Details_Page.ClickOnOKButton();
			//***********Email verification**********
			Home_Page.clickCommunicationTab();
			//Click on Email Log
			Home_Page.ClickOnEmailLog();
		WaitForLoadAnimationDisappear();
			RefreshPage();
			//WaitForLoadAnimationDisappear();
			WaitForLoadAnimationDisappear();
			//Enter the First Name
			EmailLogs.EnterFirstNameEmailLogEnterSearchField(AgencyContacts1);
			//Click on the Email Log search button
			EmailLogs.ClickOnEmailLogSearchIcon();
			WaitForLoadAnimationDisappear();
			EmailLogs.validateNoRecordsFound();
		}
	}
