package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import genericPages.CommonMethod;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends CommonMethod{

	public HomePageTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Logger logger= LogManager.getLogger(HomePageTest.class);
	
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
	
    @Test
    public void checkTitle() throws Exception {
    	test=reports.startTest("Tc001 verify all menu's");
    	HomePage h=new HomePage();
    	
    	//Verify Home Menu
    	h.verifyHomeMenu();
    	 logger.info("Verified Home Title");
 	
    	//Verify Homepage Appointmnets Title
    	h.verifyHomePageAppointmentsTitle();
    	logger.info("Verified HomePage Appointmnet Title");
    	
    	//Verify ToDoList Title
    	h.verifyToDoListTitle();
    	logger.info("Verified ToDoList Title");
    	
    	//Verify Patient title
    	h.verifyPatientsTitle();
    	logger.info("Verified Patient Title");
    	
    	//Verify Appointment Title
    	h.verifyAppointmentsTitle();
    	logger.info("Verified Appointments Title");
    	
    	//Verify Prescription Title
    	h.verifyPrescriptionsTitle();
    	logger.info("Verified Prescriptions Title");
    	
    	//Verify Reports Title
    	h.verifyReportsTitle();
    	logger.info("Verified Reports Title");
    	
    	//Verify Login page tite
    	h.clickLogoutBtn();
    	h.verifyLoginPage();
    	logger.info("Verified Login Page Title");
    }
    
    @AfterClass
	public void afterTest() {
		// Close the browser
		driver.close();
		reports.endTest(test);
		reports.flush();
	}
}
