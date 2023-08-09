package tests;

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

	Logger logger= LogManager.getLogger(AppointmentsCalenderTest.class);
	
	
	@BeforeClass
	public void openApplication() throws Exception {
		// Open the browser and hit the url
		initializeBrowser();

		LoginPage l=new LoginPage();
		l.clickGotItBtn();
		Thread.sleep(2000);
		l.enterValiedUserName();
		logger.info("Entered Username");
		Thread.sleep(2000);
		l.enterValiedPassword();
		logger.info("Entered Password");
		Thread.sleep(2000);
		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");
		


		/**	String actual = null;
		try {
			if(l.getaccInfo().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");**/
	}


	@Test(priority=1)
	public void AddAppointmentsCalender() throws Exception  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage();
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
		acp.getdateAndTimeField();
		logger.info("Clicked DateAndTime Field");
		acp.getdatePick();
		acp.gettimePick();
		acp.getDurationField();
		logger.info("Clicked Duration Field");
		acp.getSaveAppointmentButton();
		logger.info("Clicked SaveAppointment Field");
		
	/**	String expectedResult="Appointment added Successfully";
		String actualResult=acp.getsuccessMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		acp.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}
	
	@Test(priority=2)
	public void AddAppointmentWithoutName() throws Exception  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage();
		acp.getNewAppointment();
		logger.info("Clicked New Appointment");
		acp.getVisitreasonField1();
		logger.info("Entered VisitReason Field");
		acp.getContactNumberField1();
		logger.info("Entered ContactNumber Field");
		acp.getdateAndTimeField();
		logger.info("Clicked DateAndTime Field");
		acp.getdatePick();
		acp.gettimePick();
		acp.getDurationField();
		logger.info("Clicked Duration Field");
		acp.getSaveAppointmentButton();
		logger.info("Clicked SaveAppointment Field");
		
	/**	String expectedResult="something went wrong!";
		String actualResult=acp.geterrorMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		acp.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}
	
	@Test(priority =3)
	public void AddAppointmentWithoutVisitReason() throws Exception  {
	AppointmentsCalenderPage acp=new AppointmentsCalenderPage();
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
	acp.getdatePick();
	acp.gettimePick();
	acp.getDurationField();
	logger.info("Clicked Duration Field");
	acp.getSaveAppointmentButton();
	logger.info("Clicked SaveAppointment Field");

	/**String expectedResult="something went wrong!";
	String actualResult=acp.geterrorMsg().getText();
	Assert.assertEquals(actualResult, expectedResult);
	
	acp.getcancelNotification();
	logger.info("Clicked Cancel Notification");**/
	}

	@Test(priority=4)
	public void addPatientWithoutContactNo() throws Exception  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage();
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
		acp.getdatePick();
		acp.gettimePick();
		acp.getDurationField();
		logger.info("Clicked Duration Field");
		acp.getSaveAppointmentButton();
		logger.info("Clicked SaveAppointment Field");

	/**	String expectedResult="Appointment added Successfully";
		String actualResult=acp.getsuccessMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		acp.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}
	
	@Test(priority=5)
	public void updateWithInvaliedData() throws Exception  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage();
		acp.getUpdatedExistingAppointment();
		logger.info("Clicked ExistingAppointment Field");
		acp.clearFirstNameField();
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
		
	/**	String expectedResult="Appointment Updated Successfully";
		String actualResult=acp.getupdateSuccessMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		acp.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}
	

	@Test(priority=6)
	public void updateAppointmentWithValidData() throws Exception  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage();
		acp.getUpdatedExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.clearFirstNameField();
		acp.getFirstNameField2();
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
		
	/**	String expectedResult="Appointment Updated Successfully";
		String actualResult=acp.getupdateSuccessMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		acp.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}

	@Test(priority=7)
	public void existingAppointmentInMonth() throws Exception  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage();
		acp.getMonthButton();
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
		acp.getBackButton();
		acp.getNextButton();
		acp.getExistingAppointment();
		acp.getcancelExistingAppointment();
		acp.getTodayButton();
		
	}
	
	@Test(priority=8)
	public void existingAppointmentInWeek() throws Exception  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage();
		acp.getWeekButton();
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.clearVisitreasonField();
		acp.getVisitreasonField1();
		logger.info("Entered Visit Reason");
		acp.getSaveAppointmentButton();
		logger.info("Clicked Save Button");
		acp.getBackButton();
		acp.getBackButton();
		acp.getNextButton();
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getcancelExistingAppointment();
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getTodayButton();
	}
	
	@Test(priority=9)
	public void existingAppointmentInDay() throws Exception  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage();
		acp.getDayButton();
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getcancelExistingAppointment();
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getBackButton();
		acp.getBackButton();
		acp.getBackButton();
		acp.getNextButton();
		acp.getBackButton();
		acp.getNextButton();
		acp.getNextButton();
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getcancelExistingAppointment();
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getTodayButton();
	}
	
	@Test(priority=10)
	public void agenda() throws Exception  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage();
		acp.getAgendaButton();
		acp.getagendaExistingAppointment();
		logger.info("Clicked Agenda ExistingAppointment");
		acp.getcancelExistingAppointment();
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getBackButton();
		acp.getNextButton();
		acp.getNextButton();
		acp.getBackButton();
		acp.getTodayButton();
	}

	 @AfterClass
		public void afterTest() {
			// Close the browser
			driver.close();
			//reports.endTest(test);
			//reports.flush();
		}
	
}

