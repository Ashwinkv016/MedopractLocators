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
    	//test=reports.startTest("Tc001 verify all menu's");
    	HomePage h=new HomePage();
    	
    	//Verify Login page tite
    	h.verifyLoginPage();
 	
    	//Verify Homepage Appointmnets Title
    	h.verifyHomePageAppointmentsTitle();
    	
    	//Verify ToDoList Title
    	h.verifyToDoListTitle();
    	
    	//Verify Patient title
    	h.verifyToDoListTitle();
    	
    	//Verify Appointment Title
    	h.verifyAppointmentsTitle();
    	
    	//Verify Prescription Title
    	h.verifyPrescriptionsTitle();
    	
    	//Verify Reports Title
    	h.verifyReportsTitle();
    	
    	//Verify Home Menu
    	h.verifyHomeMenu();
    	
    	//Verify Login page tite
    	h.clickLogoutBtn();
    	h.verifyLoginPage();
    }
    
    @AfterClass
	public void afterTest() {
		// Close the browser
		driver.close();
	//	reports.endTest(test);
	//	reports.flush();
	}
}
