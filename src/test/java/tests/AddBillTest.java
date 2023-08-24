package tests;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import genericPages.CommonMethod;
import pages.AddBill;
import pages.LoginPage;

public class AddBillTest extends CommonMethod {

	public AddBillTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger=LogManager.getLogger("AddBillTest.class");
	
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
	
	@Test(priority =1)
	public void printWithoutAddingBillingItem() throws Exception {
		test=reports.startTest("TC001 SaveBill without adding Billing Item");
		AddBill ab=new AddBill();
		ab.clickBilling();
		logger.info("Clicking Billing Btn");
		ab.clickAddBill();
		logger.info("Clicking AddBill Btn");
		ab.enterPatientName();
		logger.info("Entered Patient name");
		ab.enterEmail();
		logger.info("Entered Email");
		ab.clickSaveAndPrintBtn();
		logger.info("Clicked Save and print Btn");
		
		Assert.assertEquals(true,"Please Add Billing Items");
		logger.info("Assertion passed");
		ab.clickCancelNotification();
		logger.info("Clicked cancel Notification");
		
	}
	
	@AfterClass
	public void closeBrowser() {
		//Close the browser
		driver.close();
		reports.endTest(test);
		reports.flush();
	}
}
