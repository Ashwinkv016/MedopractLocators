package tests;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import genericPages.CommonMethod;
import pages.RegistrationPage;


public class TC__001_RegistrationTest extends CommonMethod {

	public TC__001_RegistrationTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger = LogManager.getLogger(TC__001_RegistrationTest.class);

	@BeforeClass
	public void OpenApplication() throws Exception {
		initializeBrowser();
		logger.info("Navigated to Application URL");
	}

	@Test(priority = 1)
	public void withoutMandatoryAllField() throws Exception {
		test = reports.startTest("TC001 Register without Mandatory Data");
		RegistrationPage rp = new RegistrationPage();
		rp.clickGotItBtn();
		logger.info("Clicked GotIt Button");
		rp.clickRegisterNow();
		logger.info("Clicked RegisterNow Button");
		scrollDown();
		rp.clickRegisterButton();
		logger.info("Clicked On Register Button");

		String actual = getWebElement("fullNameRegisterErrorMsg").getText();
		String expected="Please enter valid name - Only Alphabets and spaces are allowed";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");
	}

	@Test(priority = 2)
	public void Registration() throws Exception {
		test = reports.startTest("TC002 Register with Mandatory Data");
		RegistrationPage rp = new RegistrationPage();
		//rp.enterFullName();
		getWebElement("fullNameRegister").sendKeys("bbbbbbb");
		logger.info("Entered Name");
		//rp.enterEmailField();
		getWebElement("emailRegister").sendKeys("bbbb123456@gmail.com");
		logger.info("Entered Email Address");
		//rp.enterMobileField();
		getWebElement("phnoRegister").sendKeys("6382565718");
		logger.info("Entered Phone Number");
		//rp.enterUserNameField();
		getWebElement("usernameRegister").sendKeys("vvwzzwc1a256666");
		logger.info("Entered UserName");
		//rp.enterValidConfirmUserName();
		getWebElement("cnfrmUserRegister").sendKeys("vvwzzwc1a256666");
		logger.info("Entered ConfirmUserName");
		rp.clickAgreetermCheckBox();
		logger.info("Clicked Checkbox");
		rp.clickRegisterButton();
		logger.info("Clicked On Register Button");
		
		String actual = getWebElement("registrationSuccessMsg").getText();
		String expected="Registration Successful!";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");
		
		rp.getOkButton();
		logger.info("Clicked OK button");
	}

	@Test(priority = 3)
	public void registerWithExistingDataAgain() throws Exception {
		test = reports.startTest("TC003 Register with Existing Data Again");
		RegistrationPage rp = new RegistrationPage();
		rp.clickRegisterButton();
		logger.info("Clicked On Register Button");

		String actual = getWebElement("notification").getText();
		String expected="Doctor Already Registered";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");
		
		rp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 4)
	public void withoutConfirmUsernameField() throws Exception {
		test = reports.startTest("TC004 Without Confirm Username Field");
		RegistrationPage rp = new RegistrationPage();
		rp.clearConfirmUserName();
		logger.info("Entered ConfirmUserName");
		rp.clickRegisterButton();
		logger.info("Clicked On Register Button");
		
		base.waitForElementVisibility1("notification", 40);
		String actual = getWebElement("notification").getText();
		String expected="Username and ConfirmUserName does not match!";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");
		
		rp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");

	}

	@Test(priority = 5)
	public void invalidConfirmUsernameField() throws Exception {
		test = reports.startTest("TC005 Invalid Confirm Username Field");
		RegistrationPage rp = new RegistrationPage();
		getWebElement("cnfrmUserRegister").sendKeys("bbbbbbb");
		logger.info("Entered ConfirmUserName");
		rp.clickRegisterButton();
		logger.info("Clicked On Register Button");

		String actual = getWebElement("cnfrmUserNameErrorMsg").getText();
		String expected="Confirm Username must be 8-16 Characters, Alphabets, Numbers and ._%+-@ allowed";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");
		
	}

	@Test(priority = 6)
	public void withoutAgreeTermCheckBox() throws Exception {
		test = reports.startTest("TC006 Without Agree Term CheckBox");
		RegistrationPage rp = new RegistrationPage();
		rp.clearConfirmUserName();
		getWebElement("cnfrmUserRegister").sendKeys("vvwzzwc1a256666");
		logger.info("Entering CnfrmUserName");
		rp.clickAgreetermCheckBox();
		logger.info("Clicked Checkbox");
		rp.clickRegisterButton();
		logger.info("Clicked On Register Button");

		String actual = getWebElement("agreeTermsRegisterErrorMsg").getText();
		String expected="Please check this box if you want to Proceed!";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

	}


	@Test(priority = 7)
	public void alreadyAnUser() throws Exception {
		test = reports.startTest("TC007 Already an User");
		RegistrationPage rp = new RegistrationPage();
		logger.info("Clicked RegisterNow Button");
		rp.clickImAlreadyUser();
		logger.info("Clicked I'm already an User Button");
		
		
		String actual = null;
		try {
			if (getWebElement("loginPage").isDisplayed()) {
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
	
	@Test(priority = 8)
	public void withClickHelp() throws Exception {
		test = reports.startTest("TC008 Click Help");
		RegistrationPage rp = new RegistrationPage();
		rp.clickHelp();
		logger.info("Clicked Help Button");
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
	}

	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
		reports.endTest(test);
		reports.flush();
	}
}
