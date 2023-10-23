package tests;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import genericPages.CommonMethod;
import pages.LoginPage;

public class LoginTestExcel extends CommonMethod {

	public LoginTestExcel() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger = LogManager.getLogger(LoginTestExcel.class);



	@BeforeMethod
	public void openApplication() throws Exception {
		test = reports.startTest("Open Application");
		initializeBrowser();
		logger.info("Launching the Browser");
	}

	@Test(priority = 1)
	public void valiedLogin() throws Exception {
		test = reports.startTest("TC001 Login Operation through Excel Data Driven");
		LoginPage l = new LoginPage();
		l.clickGotItBtn();
		logger.info("Clicked Got It Btn");
		base.waitForElementVisibility1("userLogin", 10);
		getWebElement("userLogin").sendKeys(getExcelData("Login",1, 1));
		logger.info("Entered UserName");
		Thread.sleep(1000);
		getWebElement("passLogin").sendKeys(getExcelData("Login",2,1));
		logger.info("Entered Password");
		Thread.sleep(1000);
		l.clickSubmitLoginBtn();
		logger.info("Clicked Submit Btn");

		Thread.sleep(2000);

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

	@Test(priority = 2)
	public void InvaliedLogin1() throws Exception {
		test = reports.startTest("InvaliedLogin1 Operation through Excel Data Driven");
		LoginPage l = new LoginPage();
		l.clickGotItBtn();
		logger.info("Clicked Got It Btn");
		base.waitForElementVisibility1("userLogin", 10);
		getWebElement("userLogin").sendKeys(getExcelData("Login",1,1));
		logger.info("Entered UserName");
		Thread.sleep(1000);
		getWebElement("passLogin").sendKeys(getExcelData("Login",4,1));
		logger.info("Entered Password");
		Thread.sleep(1000);
		l.clickSubmitLoginBtn();
		logger.info("Clicked Submit Btn");

		String actual = getWebElement("notification").getText();
		String expected="Invalid Password!";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		l.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
		
	}

	@Test(priority = 3)
	public void InvaliedLogin2() throws Exception {
		test = reports.startTest("InvaliedLogin2 Operation through Excel Data Driven");
		LoginPage l = new LoginPage();
		l.clickGotItBtn();
		logger.info("Clicked Got It Btn");
		base.waitForElementVisibility1("userLogin", 10);
		getWebElement("userLogin").sendKeys(getExcelData("Login",3,1));
		logger.info("Entered UserName");
		Thread.sleep(1000);
		getWebElement("passLogin").sendKeys(getExcelData("Login",2,1));
		logger.info("Entered Password");
		Thread.sleep(1000);
		l.clickSubmitLoginBtn();
		logger.info("Clicked Submit Btn");

		String actual = getWebElement("notification").getText();
		String expected="No record available with Doctor ID :ashwin";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		l.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
		
	}


	@Test(priority = 4)
	public void InvaliedLogin3() throws Exception {
		test = reports.startTest("InvaliedLogin3 Operation through Excel Data Driven");
		LoginPage l = new LoginPage();
		l.clickGotItBtn();
		logger.info("Clicked Got It Btn");
		base.waitForElementVisibility1("userLogin", 10);
		getWebElement("userLogin").sendKeys(getExcelData("Login",5,1));
		logger.info("Entered UserName");
		getWebElement("passLogin").sendKeys(getExcelData("Login",6,1));
		logger.info("Entered Password");
		Thread.sleep(1000);
		l.clickSubmitLoginBtn();
		logger.info("Clicked Submit Btn");



	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
		logger.info("Browser got closed");
		reports.endTest(test);
		reports.flush();
	}

}
