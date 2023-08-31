package tests;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import genericPages.CommonMethod;
import pages.LoginPage;

public class LoginTestDDT extends CommonMethod {

	public LoginTestDDT() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger = LogManager.getLogger(LoginTestDDT.class);

	@BeforeMethod
	public void openApplication() throws Exception {
		test = reports.startTest("Open Application");
		initializeBrowser();
		logger.info("Launching the Browser");
	}

	@DataProvider(name = "LoginData")
	public Object[][] LoginData() {

		Object[][] data = { { "ashwinkv016", "ashwinkv016", "successful" }, { "ashwin", "ashwinkv016", "failure" },
				{ "ashwinkv016", "ashwin", "failure" }, { "", "", "failure" } };

		return data;
	}

	@Test(dataProvider = "LoginData")
	public void login(String un, String pass, String expected) throws Exception {
		test = reports.startTest("Login Operation through Data Driven");
		LoginPage l = new LoginPage();
		l.clickGotItBtn();
		logger.info("Clicked Got It Btn");
		getWebElement("userLogin").sendKeys(un);
		logger.info("Entered UserName");
		Thread.sleep(1000);
		getWebElement("passLogin").sendKeys(pass);
		logger.info("Entered Password");
		Thread.sleep(1000);
		l.clickSubmitLoginBtn();
		logger.info("Clicked Submit Btn");

		Thread.sleep(2000);
		
		String actual = null;
		try {
			if (expected.equalsIgnoreCase("successful")) {
				logger.info("user got logged in");
				Assert.assertTrue(l.verifyHomePage());
				actual = "successful";
				l.clickLogoutBtn();
				logger.info("Clicked logout Btn");
			}

		} catch (Exception e) {
			actual = "failure";
			logger.info("User didn't login");
			l.clickCancelNotification();
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
		logger.info("Browser got closed");
		reports.endTest(test);
		reports.flush();
	}

}
