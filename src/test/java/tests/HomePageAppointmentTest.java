package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

	@Test(priority = 1)
	public void addAppointmentWithoutData() throws Exception  {	
		HomePageAppointment hpa = new HomePageAppointment();
		hpa.clickPlusSigns();
		logger.info("Clicked Sign");
		hpa.clickAddAppointmentBtn();
		logger.info("Clicked AddAppointment Button");
		
	/**	String actual = null;
		try {
			if(hpa.geterrorMsg().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");**/
	}
	
	@Test(priority = 2)
	public void clickingMinusSign() throws Exception  {	
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
		
/**		String actual = null;
		try {
			if(hpa.geterrorMsg().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");**/
	}
	
	
     
	@Test(priority = 4)
	public void addAppointment() throws Exception  {	
		HomePageAppointment hpa = new HomePageAppointment();
		hpa.enterVisitReasonField1();
		logger.info("Entered VisitReason");
		hpa.clickAddAppointmentBtn();
		logger.info("Clicked AddAppointment Button");
		
	/**	String actual="Appointment added Successfully";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}
	
	@Test(priority = 5)
	public void addAppointmentwithoutContactNo() throws Exception {	
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
		
/**		String actual="Appointment added Successfully";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}


	@Test(priority = 6)
	public void EditExistingAppointment() throws Exception {
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
		
/**	String actual="Appointment Updated Successfully";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}
	
	


	@Test(priority = 7)
	public void ClickSMSReminder() throws Exception  {
		HomePageAppointment hpa = new HomePageAppointment();
		hpa.clickSMSReminder();
		logger.info("Clicking on SMS Reminder");
		
		/**	String actual="Reminder SMS Sent to : 9597277526";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}


	@Test(priority = 8)
	public void ClickAgainSMSReminder() throws Exception {
		HomePageAppointment hpa = new HomePageAppointment();
		hpa.clickSMSReminder();
		logger.debug("Clicking again on SMS Reminder");
		
		/**		String actual="SMS Not Sent: Reminder Already Sent";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}
	
	@Test(priority = 9)
	public void CancelAppointment() throws Exception {
		HomePageAppointment hpa = new HomePageAppointment();
		hpa.clickDeleteAppointment();
		logger.info("Clicked on Cancel ");
		
/**		String actual="Appointment Cancelled successfully!";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}
	
	 @AfterClass
		public void afterTest() {
			// Close the browser
			driver.close();
			//reports.endTest(test);
			//reports.flush();
		}

}




