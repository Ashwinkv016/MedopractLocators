package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import genericPages.CommonMethod;
import pages.LoginPage;
import pages.ViewBill;

public class ViewBillTest extends CommonMethod{

	public ViewBillTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger = LogManager.getLogger("ViewBillTest.class");

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
	public void viewBill() throws Exception {
		test = reports.startTest("TC001 View Bill");
       ViewBill vb=new ViewBill();
       vb.clickBilling();
       logger.info("Clicking Billing");
       vb.clickViewBill();
       logger.info("Clicking View Bill");
       vb.enterPatientName();
       logger.info("Entering Patient Name");
       vb.clickPatientNameSugg();
       logger.info("Clicking Patient Name Sugg");
       vb.clickViewBillList();
       logger.info("Clicking View Bill List");
      
	}
	/**
	@Test(priority = 2)
	public void goToPatientDetails() throws Exception {
		test=reports.startTest("TC002 Go To Patient Details");
		ViewBill vb=new ViewBill();
		vb.clickGoToPatientDetails();
		logger.info("Go To Patient Details");	
	}
	**/
	@AfterClass
	public void closeBrowser() {
		// Close the browser
		driver.close();
		reports.endTest(test);
		reports.flush();
	}
}
