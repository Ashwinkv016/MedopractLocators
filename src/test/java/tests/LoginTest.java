package tests;

import java.time.Duration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import genericPages.CommonMethod;
import pages.LoginPage;

public class LoginTest extends CommonMethod {
	public LoginTest() throws Exception {
	}

	Logger logger= LogManager.getLogger(LoginTest.class);


	@BeforeClass
	public void OpenApplication() throws Exception  {
		initializeBrowser();
		logger.info("Navigated to Application URL");
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals("MedoPract App", driver.getTitle());
	}

	 @Test(priority = 1)
	    public void loginWithoutData() throws Exception {
	        LoginPage loginPage = new LoginPage();
	        
	        loginPage.clickGotItBtn();
	        logger.info("Clicked 'Got it!' button");
	        
	        loginPage.clearUserNameField();
	        logger.info("Cleared Username field");
	        
	        loginPage.clearPasswordField();
	        logger.info("Cleared Password field");
	        
	        loginPage.clickSubmitLoginBtn();
	        logger.info("Clicked submit button");
	        
	        

/**		String expectedResult="No record available with Doctor ID :";
		String actualResult=l.geterrorMsgNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);

		l.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/     

	}

	@Test(priority = 2)
	public void loginWithoutPassword() throws Exception  {
		LoginPage l=new LoginPage();

		l.enterValiedUserName();
		logger.info("Entered Username");
		
		l.clearPasswordField();
		logger.info("Cleared Password");
		
		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");


	/**	String expectedResult="Invalid Password!";
		String actualResult=l.geterrorMsgNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);

		l.getcancelNotification();
		logger.info("Clicked Cancel Notification");   **/ 

	}

	@Test(priority = 3)
	public void loginWithoutUsername() throws Exception  {
		LoginPage l=new LoginPage();
		l.clearUserNameField();
		logger.info("Cleared Username without data");
		
		l.enterValiedPassword();
		logger.info("Entered Password");
		
		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");


	/**	String expectedResult="No record available with Doctor ID :";
		String actualResult=l.geterrorMsgNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);

		l.getcancelNotification();
		logger.info("Clicked Cancel Notification"); **/   
	}


	@Test(priority=4)
	public void incorrectDetails() throws Exception  {
		LoginPage l=new LoginPage();
		l.enterInvaliedUserName();
		logger.info("Entered Username");
		
		l.clearPasswordField();
		l.enterInvaliedPassword();
		logger.info("Entered Password");
		
		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");

/**		String expectedResult="No record available with Doctor ID :!*(&";
		String actualResult=l.verifyNotification();
		Assert.assertEquals(actualResult, expectedResult);

		l.clickCancelNotification();
		logger.info("Clicked Cancel Notification");**/

	}


	@Test(priority = 5)
	public void loginwithoutRememberMe() throws Exception  {
		LoginPage l=new LoginPage();
	//	l.clearUserNameField();
		l.enterValiedUserName();
		logger.info("Entered Username");
		
	//	l.clearPasswordField();
		l.enterValiedPassword();
		logger.info("Entered Password");
		
		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");
		
		l.clickLogoutBtn();
		logger.info("Clicked logout button");

	/**	String actual = null;
		try {
			if(l.getaccInfo().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");

		l.getLogoutBtn();
		logger.info("Clicked logout");**/
	}

	@Test(priority = 6)
	public void loginWithRememberMe() throws Exception  {
		LoginPage l=new LoginPage();
		l.enterValiedUserName();
		logger.info("Entered Username");
		
		l.enterValiedPassword();
		logger.info("Entered Password");
		
		l.clickRememberMeBtn();
		logger.info("Clicked RememberMeField");
		
		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");

/**		String actual = null;
		try {
			if(l.getaccInfo().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");**/
	}	



	  
    @AfterClass
	public void afterTest() {
		// Close the browser
		driver.close();
		//reports.endTest(test);
		//reports.flush();
	}

}


