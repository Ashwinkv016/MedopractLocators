package tests;

import genericPages.CommonMethod;
import pages.RegistrationPage;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest extends CommonMethod {

	public RegistrationTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger= LogManager.getLogger(RegistrationTest.class);
	
	
	@BeforeClass
	public void OpenApplication()   {
		initializeBrowser();
		logger.info("Navigated to Application URL");
	}

	@Test(priority = 1)
	public void withoutMandatoryAllField() throws Exception  {
		RegistrationPage rp=new RegistrationPage();
		rp.clickGotItBtn();
		rp.clickRegisterNow();
		logger.info("Clicked RegisterNow Button");
	
		rp.clickRegisterButton();
		logger.info("Clicked On Register Button");
	}

	@Test(priority = 2)
	public void Registration() throws Exception  {
		RegistrationPage rp=new RegistrationPage();
		rp.enterFullName();
		logger.info("Entered Name");
		rp.enterEmailField();
		logger.info("Entered Email Address");
		rp.enterMobileField();
		logger.info("Entered Phone Number");
		rp.enterUserNameField();
		logger.info("Entered UserName");
		rp.enterValidConfirmUserName();
		logger.info("Entered ConfirmUserName");
		rp.clickAgreetermCheckBox();
		logger.info("Clicked Checkbox");
		rp.clickRegisterButton();
		logger.info("Clicked On Register Button");

	/**	String actual = null;
		try {
			if(rp.getregistrationSuccessfulMsg().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");

		rp.getOkButton().click();
		Thread.sleep(3000);
		logger.info("Clicked OK button");**/
	}

	@Test(priority = 3)
	public void registerWithExistingDataAgain() throws Exception  {
		RegistrationPage rp=new RegistrationPage();
		rp.clickRegisterButton();
		logger.info("Clicked On Register Button");

	/**	String actual="Doctor Already Registered";
		String expected=rp.geterrorNotification().getText();
		Assert.assertEquals(actual, expected);

		rp.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}

	@Test(priority = 4)
	public void withoutConfirmUsernameField() throws Exception  {
		RegistrationPage rp=new RegistrationPage();
		rp.clearConfirmUserName();
		logger.info("Entered ConfirmUserName");
		rp.clickRegisterButton();
		logger.info("Clicked On Register Button");


	/**	String actual="Username and ConfirmUserName does not match!";
		String expected=rp.geterrorNotification().getText();
		Assert.assertEquals(actual, expected);

		rp.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}

	@Test(priority =5)
	public void invalidConfirmUsernameField() throws Exception  {
		RegistrationPage rp=new RegistrationPage();
		rp.enterInValidConfirmUserName();
		logger.info("Entered ConfirmUserName");
		rp.clickRegisterButton();
		logger.info("Clicked On Register Button");
		
/**	String actual = null;
		try {
			if(rp.getconfirmUnErrorNotification().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");
		**/
	}

	@Test(priority = 6)
	public void withoutAgreeTermCheckBox() throws Exception  {
		RegistrationPage rp=new RegistrationPage();
		rp.clearConfirmUserName();
		rp.enterValidConfirmUserName();
		rp.clickAgreetermCheckBox();
		logger.info("Clicked Checkbox");
		rp.clickRegisterButton();
		logger.info("Clicked On Register Button");
		
	/**	String actual = null;
		try {
			if(rp.getTermsErrorNotification().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");**/
	}
	
	@Test(priority = 7)
	public void withClickHelp() throws  Exception {
		RegistrationPage rp=new RegistrationPage();
		rp.clickHelp();
		logger.info("Clicked Help Button");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
	}
	

	@Test(priority = 8)
	public void alreadyAnUser() throws Exception{
		RegistrationPage rp=new RegistrationPage();
		logger.info("Clicked RegisterNow Button");
		rp.clickImAlreadyUser();
		logger.info("Clicked I'm already an User Button");
	}
	
	

	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}
}

