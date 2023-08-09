package tests;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
	Logger logger= LogManager.getLogger(ForgetPasswordTest.class);
	
	@BeforeClass
	public void openApplication() throws Exception {
		// Open the browser and hit the url
		initializeBrowser();
	}

	@Test(priority=1)
	public void forgotpassword() throws Exception  {

		ForgotPasswordField fpf = new ForgotPasswordField();
		fpf.clickGotItBtn();
		fpf.clickForgotPassword();
		logger.info("Clicked On Forgot Password");
		fpf.enterUsernamefield();
		//fpf.getResetButtonClick();
		logger.info("Clicked On ResetButton");
		
	/**	String actual=null;
		try {
			if(fpf.getForgotPassPage().isDisplayed())
			actual="success";
			logger.info("Forget Password Page is displayed");
		}
		catch(Exception e) {
			actual="failure";
			logger.info("Forget Password Page is not displayed");
		}
		Assert.assertEquals(actual, "success");**/
	}

	@Test(priority=2)
	public void BackLoginPage() throws Exception {
		ForgotPasswordField fpf = new ForgotPasswordField();
		fpf.clickbackLoginPage();
		logger.info("Clicked On Back Login Page");
	/**	String actual=null;
		try {
			if(fpf.getbackLoginPage().isDisplayed())
			actual="success";
			logger.info("LoginPage is displayed");
		}
		catch(Exception e) {
			actual="failure";
			logger.info(" LoginPage is not displayed");
		}
		Assert.assertEquals(actual, "success");**/
		

	}
	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}
}






