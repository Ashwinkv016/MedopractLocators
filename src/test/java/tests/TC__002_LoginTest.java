package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import genericPages.CommonMethod;
import pages.LoginPage;

public class TC__002_LoginTest extends CommonMethod {

	public TC__002_LoginTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub

	}

	Logger logger = LogManager.getLogger(TC__002_LoginTest.class);

	@BeforeClass
	public void OpenApplication() throws Exception {
		initializeBrowser();
		logger.info("Navigated to Application URL");
		Assert.assertEquals("MedoPract App", driver.getTitle());
	}

	@Test(priority = 1)
	public void loginWithoutData() throws Exception {
		test = reports.startTest("TC001 Login without Data");
		LoginPage l = new LoginPage();

		l.clickGotItBtn();
		logger.info("Clicked 'Got it!' button");

		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");

	}

	@Test(priority = 2)
	public void loginWithoutPassword() throws Exception {
		test = reports.startTest("TC002 Login without Password");
		LoginPage l = new LoginPage();

		l.enterValiedUserName();
		logger.info("Entered Username");

		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");

	}

	@Test(priority = 3)
	public void loginWithInvaliedPassword() throws Exception {
		test = reports.startTest("TC003 Search and add product to cart");
		LoginPage l = new LoginPage();

		l.enterInvaliedPassword();
		logger.info("Entered Password");

		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");

		Assert.assertTrue(true, l.verifyNotification("Invalid Password!"));

		l.clickCancelNotification();
		logger.info("Clicked Cancel Notification");

	}

	@Test(priority = 4)
	public void incorrectDetails() throws Exception {
		test = reports.startTest("TC004 Login with Incorrect Details");
		LoginPage l = new LoginPage();

		l.clearUserNameField();
		logger.info("Cleared UserName");

		l.enterInvaliedUserName();
		logger.info("Entered Username");

		l.clearPasswordField();
		l.enterInvaliedPassword();
		logger.info("Entered Password");

		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");

		Assert.assertTrue(true, l.verifyNotification("No record available with Doctor ID :!*(&"));
		logger.info("Assertion Passed");
		l.clickCancelNotification();
		logger.info("Clicked Cancel Notification");

	}

	@Test(priority = 5)
	public void loginwithoutRememberMe() throws Exception {
		test = reports.startTest("TC005 Login without remember me");
		LoginPage l = new LoginPage();

		l.clearUserNameField();
		l.enterValiedUserName();
		logger.info("Entered Username");

		l.clearPasswordField();
		l.enterValiedPassword();
		logger.info("Entered Password");

		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");

		String actual = null;
		try {
			if (getWebElement("homePageTitle").isDisplayed()) {
				actual = "success";
			} else {
				actual = "failure";
			}
		} catch (Exception e) {
			actual = "failure";
		}
		Assert.assertTrue(actual.equals("success"));
		logger.info("Assertion Passed");

		l.clickLogoutBtn();
		logger.info("Clicked logout button");

	}

	@Test(priority = 6)
	public void loginWithRememberMe() throws Exception {
		test = reports.startTest("TC006 Login with remember me");
		LoginPage l = new LoginPage();

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
			if (getWebElement("homePageTitle").isDisplayed()) {
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
	public void afterTest() {
		// Close the browser
		driver.quit();
		reports.endTest(test);
		reports.flush();
	}
}
