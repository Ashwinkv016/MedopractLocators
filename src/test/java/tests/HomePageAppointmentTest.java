package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import genericPages.CommonMethod;
import pages.HomePageAppointment;
import pages.LoginPage;

public class HomePageAppointmentTest extends CommonMethod {

	public HomePageAppointmentTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger= LogManager.getLogger(HomePageAppointmentTest.class);

	@BeforeClass
	public void openApplication() throws Exception {
		test=reports.startTest("Open Application");
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

		String actual=null;
		try {
		if(l.verifyHomePage()) {
			actual="success";
			logger.info("Success");
		}
		else {
			actual="failure";
			logger.error("failure");
		}}catch(Exception e) {
			actual="failure";
			logger.error("failure");
		}
		Assert.assertTrue(actual.equals("success"));
        logger.info("Assertion Passed");
	}

	@Test(priority = 1)
	public void addAppointmentWithoutData() throws Exception  {	
		test=reports.startTest("TC001 Add Appointment Without Data");
		HomePageAppointment hpa = new HomePageAppointment();
		hpa.clickPlusSigns();
		logger.info("Clicked Sign");
		hpa.clickAddAppointmentBtn();
		logger.info("Clicked AddAppointment Button");
		
		String actual = null;
		try {
			if(hpa.verifyErrorMsg())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");
	}
	
	@Test(priority = 2)
	public void clickingPlusSign() throws Exception  {	
		test=reports.startTest("TC002 Clicking Plus Sign");
		HomePageAppointment hpa = new HomePageAppointment();
		hpa.clickPlusSigns();
		logger.info("Clicked Sign");
		hpa.clickPlusSigns();
		logger.info("Clicked Sign");
		hpa.clickPlusSigns();
		logger.info("Again Clicked Sign");
	}
	
	@Test(priority = 3)
	public void addAppointmentWithoutVisitReason() throws Exception  {	
		test=reports.startTest("TC003 AddAppointment Without VisitReason");
		HomePageAppointment hpa = new HomePageAppointment();
		hpa.clickPlusSigns();
		logger.info("Clicked Plus");
		hpa.enterFirstName1();
		logger.info("Entered Name");
		hpa.enterLastName2();
		logger.info("Entered LastName");
		hpa.enterPhno1();
		logger.info("Entered MobileNo");
		hpa.clickAddAppointmentBtn();
		logger.info("Clicked AddAppointment Button");
		
		String actual = null;
		try {
			if(hpa.verifyErrorMsg())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");
	}
	
	
     
	@Test(priority = 4)
	public void addAppointment() throws Exception  {
		test=reports.startTest("TC004 AddAppointment ");
		HomePageAppointment hpa = new HomePageAppointment();
		hpa.enterVisitReasonField1();
		logger.info("Entered VisitReason");
		hpa.clickAddAppointmentBtn();
		logger.info("Clicked AddAppointment Button");

		Assert.assertTrue(true, hpa.verifyNotification("Appointment added Successfully"));

		hpa.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority = 5)
	public void addAppointmentwithoutContactNo() throws Exception {	
		test=reports.startTest("TC005 AddAppointment without ContactNo ");
		HomePageAppointment hpa = new HomePageAppointment();
		hpa.enterFirstName1();
		logger.info("Entered Name");
		hpa.enterLastName2();
		logger.info("Entered LastName");
		hpa.enterVisitReasonField1();
		logger.info("Entered VisitReason");
		hpa.enterPhno1();
		logger.info("Entered MobileNo");
		hpa.clickAddAppointmentBtn();
		logger.info("Clicked AddAppointment Button");
		
		Assert.assertTrue(true, hpa.verifyNotification("Appointment added Successfully"));

		hpa.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}


	@Test(priority = 6)
	public void EditExistingAppointment() throws Exception {
		test=reports.startTest("TC006 Edit Existing Appointment");
		HomePageAppointment hpa = new HomePageAppointment();
		hpa.clickEditAppointment();
		logger.info("clicked on Edit option");
		hpa.clearFirstName();
		hpa.enterFirstName2();
		hpa.clearLastName();
		hpa.enterLastName1();
		hpa.clearPhno();
		hpa.enterPhno2();
		hpa.clickUpdateButton();
		logger.info("clicked on Update Button");
		
		Assert.assertTrue(true, hpa.verifyNotification("Appointment Updated Successfully"));

		hpa.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	
	


	@Test(priority = 7)
	public void ClickSMSReminder() throws Exception  {
		test=reports.startTest("TC007 Click SMS Reminder");
		HomePageAppointment hpa = new HomePageAppointment();
		hpa.clickSMSReminder();
		logger.info("Clicking on SMS Reminder");
		
		Assert.assertTrue(true, hpa.verifyNotification("Reminder SMS Sent to : 9597277526"));

		hpa.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}


	@Test(priority = 8)
	public void ClickAgainSMSReminder() throws Exception {
		test=reports.startTest("TC008 Click Again SMS Reminder");
		HomePageAppointment hpa = new HomePageAppointment();
		hpa.clickSMSReminder();
		logger.debug("Clicking again on SMS Reminder");
		
		Assert.assertTrue(true, hpa.verifyNotification("SMS Not Sent: Reminder Already Sent"));

		hpa.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority = 9)
	public void CancelAppointment() throws Exception {
		test=reports.startTest("TC009 Cancel Appointment");
		HomePageAppointment hpa = new HomePageAppointment();
		hpa.clickDeleteAppointment();
		logger.info("Clicked on Cancel ");
		
		Assert.assertTrue(true, hpa.verifyNotification("Appointment Cancelled successfully!"));

		hpa.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	
	 @AfterClass
		public void afterTest() {
			// Close the browser
			driver.close();
			reports.endTest(test);
			reports.flush();
		}

}




