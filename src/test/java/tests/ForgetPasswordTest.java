package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import genericPages.CommonMethod;
import pages.ForgotPasswordField;

public class ForgetPasswordTest extends CommonMethod {

	public ForgetPasswordTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger = LogManager.getLogger(ForgetPasswordTest.class);

	@BeforeClass
	public void openApplication() throws Exception {
		// Open the browser and hit the url
		initializeBrowser();
	}

	@Test(priority = 1)
	public void forgotpassword() throws Exception {
		test = reports.startTest("TC001 Forgotpassword");
		ForgotPasswordField fpf = new ForgotPasswordField();
		fpf.clickGotItBtn();
		fpf.clickForgotPassword();
		logger.info("Clicked On Forgot Password");
		fpf.enterUsernamefield();
		logger.info("Entered username Field");
		// fpf.getResetButtonClick();
		logger.info("Clicked On ResetButton");

		String actual = null;
		try {
			if (fpf.verifyForgetPassPage()) {
				actual = "success";
			} else {
				actual = "failure";
			}
		} catch (Exception e) {
			actual = "failure";
		}
		Assert.assertTrue(actual.equals("success"));
		logger.info("Assertion Passed");

	}

	@Test(priority = 2)
	public void BackLoginPage() throws Exception {
		test = reports.startTest("TC002 Back To LoginPage");
		ForgotPasswordField fpf = new ForgotPasswordField();
		fpf.clickbackLoginPage();
		logger.info("Clicked On Back Login Page");

		String actual = null;
		try {
			if (fpf.verifyLoginPage()) {
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

	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
		reports.endTest(test);
		reports.flush();
	}
}
