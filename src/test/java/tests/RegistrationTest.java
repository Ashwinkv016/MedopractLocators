package tests;

import genericPages.CommonMethod;
import pages.RegistrationPage;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest extends CommonMethod {

	public RegistrationTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger = LogManager.getLogger(RegistrationTest.class);

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

		Assert.assertTrue(true,rp.FullNameRegisterErrorMsg("Please enter valid name - Only Alphabets and spaces are allowed"));
		logger.info("Assertion Passed");
	}

	@Test(priority = 2)
	public void Registration() throws Exception {
		test = reports.startTest("TC002 Register with Mandatory Data");
		RegistrationPage rp = new RegistrationPage();
		//rp.enterFullName();
		getWebElement("fullNameRegister").sendKeys("bbbbb");
		logger.info("Entered Name");
		//rp.enterEmailField();
		getWebElement("emailRegister").sendKeys("bbbbb1234@gmail.com");
		logger.info("Entered Email Address");
		//rp.enterMobileField();
		getWebElement("phnoRegister").sendKeys("6382565718");
		logger.info("Entered Phone Number");
		//rp.enterUserNameField();
		getWebElement("usernameRegister").sendKeys("bbbbbbb1234");
		logger.info("Entered UserName");
		//rp.enterValidConfirmUserName();
		getWebElement("cnfrmUserRegister").sendKeys("bbbbbbb1234");
		logger.info("Entered ConfirmUserName");
		rp.clickAgreetermCheckBox();
		logger.info("Clicked Checkbox");
		rp.clickRegisterButton();
		logger.info("Clicked On Register Button");
		
		Assert.assertTrue(true, rp.registrationSuccessMsg("Registration Successful!"));
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

		Assert.assertTrue(true, rp.verifyNotification("Doctor Already Registered"));
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

		Assert.assertTrue(true, rp.cnfrmUserNameErrorMsg("Confirm Username must be 8-16 Characters, Alphabets, Numbers and ._%+-@ allowed"));
		logger.info("Assertion Passed");

	}

	@Test(priority = 5)
	public void invalidConfirmUsernameField() throws Exception {
		test = reports.startTest("TC005 Invalid Confirm Username Field");
		RegistrationPage rp = new RegistrationPage();
		getWebElement("cnfrmUserRegister").sendKeys("bbbbbbb");
		logger.info("Entered ConfirmUserName");
		rp.clickRegisterButton();
		logger.info("Clicked On Register Button");

		Assert.assertTrue(true, rp.verifyNotification("Username and ConfirmUserName does not match!"));
		logger.info("Assertion Passed");
		rp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 6)
	public void withoutAgreeTermCheckBox() throws Exception {
		test = reports.startTest("TC006 Without Agree Term CheckBox");
		RegistrationPage rp = new RegistrationPage();
		rp.clearConfirmUserName();
		getWebElement("cnfrmUserRegister").sendKeys("bbbbbbb1234");
		logger.info("Entering CnfrmUserName");
		rp.clickAgreetermCheckBox();
		logger.info("Clicked Checkbox");
		rp.clickRegisterButton();
		logger.info("Clicked On Register Button");

		Assert.assertTrue(true, rp.AgreeTermsErrorMsg("Please check this box if you want to Proceed!"));
		logger.info("Assertion Passed");

	}

	@Test(priority = 7)
	public void withClickHelp() throws Exception {
		test = reports.startTest("TC007 Click Help");
		RegistrationPage rp = new RegistrationPage();
		rp.clickHelp();
		logger.info("Clicked Help Button");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
	}

	@Test(priority = 8)
	public void alreadyAnUser() throws Exception {
		test = reports.startTest("TC008 Already an User");
		RegistrationPage rp = new RegistrationPage();
		logger.info("Clicked RegisterNow Button");
		rp.clickImAlreadyUser();
		logger.info("Clicked I'm already an User Button");
	}

	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
		reports.endTest(test);
		reports.flush();
	}
}
