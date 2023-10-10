package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import genericPages.CommonMethod;
import pages.AppointmentsCalenderPage;
import pages.LoginPage;

public class AppointmentsCalenderTest extends CommonMethod {
	public AppointmentsCalenderTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger = LogManager.getLogger(AppointmentsCalenderTest.class);

	@BeforeClass
	public void openApplication() throws Exception {
		test = reports.startTest("Open Application");
		// Open the browser and hit the url
		initializeBrowser();

		LoginPage l = new LoginPage();

		l.clickGotItBtn();
		logger.info("Clicked GotIt Btn");

		l.enterValiedUserName();
		logger.info("Entered Username");

		l.enterValiedPassword();
		logger.info("Entered Password");

		l.clickRememberMeBtn();
		logger.info("Clicked RememberMeField");

		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");

		String actual = null;
		try {
			if (l.verifyHomePage()) {
				actual = "success";
				logger.info("Success");
			} else {
				actual = "failure";
				logger.error("failure");
			}
		} catch (Exception e) {
			actual = "failure";
			logger.error("failure");
		}
		Assert.assertTrue(actual.equals("success"));
		logger.info("Assertion Passed");
	}

	@Test(priority = 1)
	public void AddAppointmentsCalender() throws Exception {
		test = reports.startTest("TC001 Add Appointments Calender");
		AppointmentsCalenderPage acp = new AppointmentsCalenderPage();
		acp.getClickAppointmentCalender();
		logger.info("Clicked Appointment Calender");
		acp.getNewAppointment();
		logger.info("Clicked New Appointment");
		acp.getFirstNameField1();
		logger.info("Entered FirstName Field");
		acp.getLastNameField1();
		logger.info("Entered LastName Field");
		acp.getVisitreasonField1();
		logger.info("Entered VisitReason Field");
		acp.getContactNumberField1();
		logger.info("Entered ContactNumber Field");
		acp.getDurationField();
		logger.info("Clicked Duration Field");
		acp.getSaveAppointmentButton();
		logger.info("Clicked SaveAppointment Field");



		String actual = getWebElement("notification").getText();
		String expected="Appointment added Successfully";

		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		acp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	//@Test(priority = 2)
	public void AddAppointmentWithoutName() throws Exception {
		test = reports.startTest("TC002 Add Appointment without Name");
		AppointmentsCalenderPage acp = new AppointmentsCalenderPage();
		acp.getNewAppointment();
		logger.info("Clicked New Appointment");
		acp.getVisitreasonField1();
		logger.info("Entered VisitReason Field");
		acp.getContactNumberField1();
		logger.info("Entered ContactNumber Field");
		acp.getdateAndTimeField();
		logger.info("Clicked DateAndTime Field");
		//acp.getdatePick();
		acp.gettimePick();
		acp.getDurationField();
		logger.info("Clicked Duration Field");
		acp.getSaveAppointmentButton();
		logger.info("Clicked SaveAppointment Field");

		String actual = getWebElement("notification").getText();
		String expected="something went wrong!";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		acp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 3)
	public void AddAppointmentWithoutVisitReason() throws Exception {
		test = reports.startTest("TC003 Add Appointment Without VisitReason");
		AppointmentsCalenderPage acp = new AppointmentsCalenderPage();
		acp.getNewAppointment();
		logger.info("Clicked New Appointment");
		acp.getFirstNameField1();
		logger.info("Entered FirstName Field");
		acp.getLastNameField1();
		logger.info("Entered LastName Field");
		acp.getContactNumberField1();
		logger.info("Entered ContactNumber Field");
		acp.getdateAndTimeField();
		logger.info("Clicked DateAndTime Field");
		//acp.getdatePick();
		acp.gettimePick();
		acp.getDurationField();
		logger.info("Clicked Duration Field");
		acp.getSaveAppointmentButton();
		logger.info("Clicked SaveAppointment Field");

		String actual = getWebElement("notification").getText();
		String expected="something went wrong!";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		acp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 4)
	public void addPatientWithoutContactNo() throws Exception {
		test = reports.startTest("TC004 AddPatient Without ContactNo");
		AppointmentsCalenderPage acp = new AppointmentsCalenderPage();
		acp.getNewAppointment();
		logger.info("Clicked New Appointment");
		acp.getFirstNameField1();
		logger.info("Entered FirstName Field");
		acp.getLastNameField1();
		logger.info("Entered LastName Field");
		acp.getVisitreasonField1();
		logger.info("Entered VisitReason Field");
		acp.getdateAndTimeField();
		logger.info("Clicked DateAndTime Field");
		//acp.getdatePick();
		acp.gettimePick();
		acp.getDurationField();
		logger.info("Clicked Duration Field");
		acp.getSaveAppointmentButton();
		logger.info("Clicked SaveAppointment Field");

		String actual = getWebElement("notification").getText();
		String expected="Appointment added Successfully";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		acp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 5)
	public void updateWithInvaliedData() throws Exception {
		test = reports.startTest("TC005 Update With InvaliedData");
		AppointmentsCalenderPage acp = new AppointmentsCalenderPage();
		acp.getUpdatedExistingAppointment();
		logger.info("Clicked ExistingAppointment Field");
		acp.clearUpdateFirstNameField();
		logger.info("Cleared First Name Field");
		acp.clearLastNameField();
		logger.info("Cleared Last Name Field");
		acp.clearVisitreasonField();
		logger.info("Cleared Visit Reason Field");
		acp.clearContactNumberField();
		logger.info("Cleared ContactNo Field");
		acp.getDurationField();
		logger.info("Clicked Duration Field");
		acp.getSaveAppointmentButton();
		logger.info("Clicked SaveAppointment Button");

		String actual = getWebElement("notification").getText();
		String expected="Appointment Updated Successfully";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		acp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 6)
	public void updateAppointmentWithValidData() throws Exception {
		test = reports.startTest("TC006 Update Appointment With ValidData");
		AppointmentsCalenderPage acp = new AppointmentsCalenderPage();
		acp.getUpdatedExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.clearUpdateFirstNameField();
		acp.enterUpdateFirstNameField();
		logger.info("Entered FirstName Field");
		acp.clearLastNameField();
		acp.getLastNameField2();
		logger.info("Entered LastName Field");
		acp.clearVisitreasonField();
		acp.getVisitreasonField2();
		logger.info("Entered VisitReason Field");
		acp.clearContactNumberField();
		acp.getContactNumberField2();
		logger.info("Entered ContactNo Field");
		acp.getDurationField();
		logger.info("Entered Duration Field");
		acp.getSaveAppointmentButton();
		logger.info("Clicked SaveAppointment Button");

		String actual = getWebElement("notification").getText();
		String expected="Appointment Updated Successfully";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		acp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 7)
	public void existingAppointmentInMonth() throws Exception {
		test = reports.startTest("TC007 Existing Appointment In Month");
		AppointmentsCalenderPage acp = new AppointmentsCalenderPage();
		acp.getMonthButton();
		Thread.sleep(2000);
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getcancelExistingAppointment();
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.clearVisitreasonField();
		acp.getVisitreasonField1();
		logger.info("Entered VisitReason Field");
		acp.getSaveAppointmentButton();
		logger.info("Clicked Save Button");

		String actual = getWebElement("notification").getText();
		String expected="Appointment Updated Successfully";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		acp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");

		Thread.sleep(1000);
		acp.getBackButton();
		logger.info("Clicked Back Button");
		acp.getNextButton();
		logger.info("Clicked next Button");
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		Thread.sleep(1000);
		acp.getcancelExistingAppointment();
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getTodayButton();
		logger.info("Clicked Today Button");

	}

	@Test(priority = 8)
	public void existingAppointmentInWeek() throws Exception {
		test = reports.startTest("TC008 Existing Appointment In Week");
		AppointmentsCalenderPage acp = new AppointmentsCalenderPage();
		Thread.sleep(3000);
		acp.getWeekButton();
		logger.info("Clicked Week Btn");
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.clearVisitreasonField();
		acp.getVisitreasonField1();
		logger.info("Entered Visit Reason");
		acp.getSaveAppointmentButton();
		logger.info("Clicked Save Button");

		String actual = getWebElement("notification").getText();
		String expected="Appointment Updated Successfully";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		acp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");

		acp.getBackButton();
		logger.info("Clicked Back Button");
		acp.getNextButton();
		logger.info("Clicked Next Button");
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getcancelExistingAppointment();
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getBackButton();
		logger.info("Clicked Back Button");
		acp.getTodayButton();
		logger.info("Clicked Next Button");
	}

	@Test(priority = 9)
	public void existingAppointmentInDay() throws Exception {
		test = reports.startTest("TC009 Existing Appointment In Day");
		AppointmentsCalenderPage acp = new AppointmentsCalenderPage();
		acp.getClickAppointmentCalender();
		Thread.sleep(5000);
		acp.getDayButton();
		logger.info("Clicked on Day Button");
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getcancelExistingAppointment();
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getBackButton();
		logger.info("Clicked Back Button");
		acp.getBackButton();
		logger.info("Clicked Back Button");
		acp.getNextButton();
		logger.info("Clicked Next Button");
		acp.getBackButton();
		logger.info("Clicked Back Button");
		acp.getNextButton();
		logger.info("Clicked Next Button");
		acp.getBackButton();
		logger.info("Clicked Back Button");
		acp.getNextButton();
		logger.info("Clicked Next Button");
		acp.getNextButton();
		logger.info("Clicked Next Button");
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		//acp.getLastNameField1();
		//logger.info("Entered Last Name");
		acp.getcancelExistingAppointment();
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getTodayButton();
		logger.info("Clicked Today Button");
	}

	@Test(priority = 10)
	public void agenda() throws Exception {
		test = reports.startTest("TC0010 Existing Appointment In Agenda");
		AppointmentsCalenderPage acp = new AppointmentsCalenderPage();
		acp.getAgendaButton();
		acp.getagendaExistingAppointment();
		logger.info("Clicked Agenda ExistingAppointment");
		acp.getcancelExistingAppointment();
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getBackButton();
		logger.info("Clicked Back Button");
		acp.getNextButton();
		logger.info("Clicked Next Button");
		acp.getNextButton();
		logger.info("Clicked Next Button");
		acp.getBackButton();
		logger.info("Clicked Back Button");
		acp.getTodayButton();
		logger.info("Clicked Today Button");
	}

	@AfterClass
	public void afterTest() {
		// Close the browser
		driver.close();
		reports.endTest(test);
		reports.flush();
	}

}
