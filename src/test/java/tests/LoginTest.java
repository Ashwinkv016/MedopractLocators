package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import genericPages.CommonMethod;
import pages.LoginPage;

public class LoginTest extends CommonMethod {

	public LoginTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub

	}

	Logger logger = LogManager.getLogger(LoginTest.class);

	@BeforeClass
	public void OpenApplication() throws Exception {
		base.initializeBrowser();
		logger.info("Navigated to Application URL");
		Assert.assertEquals("MedoPract App", driver.getTitle());
	}

	@Test(priority = 1)
	public void loginWithoutData() throws Exception {
		LoginPage l = new LoginPage();
         
		WebElement gotItBtn = getWebElement("gotItBtn");
		logger.info("gotItBtn is Clickable" + wait);
		wait.until(ExpectedConditions.elementToBeClickable(gotItBtn));
		l.clickGotItBtn();
		logger.info("Clicked 'Got it!' button");

		WebElement usernameField = getWebElement("userLogin");
		logger.info("UserName Field is visible" + wait);
		wait.until(ExpectedConditions.visibilityOfAllElements(usernameField));
		logger.info("Wait for user name field"+wait);
		l.enterValiedUserName();
		logger.info("Entered Username field");

		l.enterValiedPassword();
		logger.info("Entered Password field");

		WebElement submitBtn = getWebElement("submitLogin");
		logger.info("SubmitBtn is Clickable" + wait);
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");

		/**
		 * String expectedResult="No record available with Doctor ID :"; String
		 * actualResult=l.geterrorMsgNotification().getText();
		 * Assert.assertEquals(actualResult, expectedResult);
		 * 
		 * l.getcancelNotification(); logger.info("Clicked Cancel Notification");
		 **/

	}
/**
	@Test(priority = 2)
	public void loginWithoutPassword() throws Exception {
		LoginPage l = new LoginPage();

		l.enterValiedUserName();
		logger.info("Entered Username");

		l.clearPasswordField();
		logger.info("Cleared Password");

		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");

		
		  String expectedResult="Invalid Password!"; String
		  actualResult=l.geterrorMsgNotification().getText();
		  Assert.assertEquals(actualResult, expectedResult);
		  
		  l.getcancelNotification(); logger.info("Clicked Cancel Notification");
	

	}

	@Test(priority = 3)
	public void loginWithoutUsername() throws Exception {
		LoginPage l = new LoginPage();
		l.clearUserNameField();
		logger.info("Cleared Username without data");

		l.enterValiedPassword();
		logger.info("Entered Password");

		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");

		
		 * String expectedResult="No record available with Doctor ID :"; String
		 * actualResult=l.geterrorMsgNotification().getText();
		 * Assert.assertEquals(actualResult, expectedResult);
		 * 
		 * l.getcancelNotification(); logger.info("Clicked Cancel Notification");
	
	}

	@Test(priority = 4)
	public void incorrectDetails() throws Exception {
		LoginPage l = new LoginPage();
		l.enterInvaliedUserName();
		logger.info("Entered Username");

		l.clearPasswordField();
		l.enterInvaliedPassword();
		logger.info("Entered Password");

		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");

		Thread.sleep(3000);

		
		 * String expectedResult="No record available with Doctor ID :!*(&"; String
		 * actualResult=l.verifyNotificationText(); Assert.assertEquals(actualResult,
		 * expectedResult);
		 * 
		 * l.clickCancelNotification(); logger.info("Clicked Cancel Notification");
		 

	}

	@Test(priority = 5)
	public void loginwithoutRememberMe() throws Exception {
		LoginPage l = new LoginPage();
		// l.clearUserNameField();
		l.enterValiedUserName();
		logger.info("Entered Username");

		// l.clearPasswordField();
		l.enterValiedPassword();
		logger.info("Entered Password");

		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");

		WebElement submitBtn = getWebElement("submitLogin");
		logger.info("The element is Clickable" + wait);
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		l.clickLogoutBtn();
		logger.info("Clicked logout button");

		Thread.sleep(2000);
		
		 * String actual = null; try { if(l.getaccInfo().isDisplayed())
		 * actual="success"; } catch(Exception e) { actual="failure"; }
		 * Assert.assertEquals(actual, "success");
		 * 
		 * l.getLogoutBtn(); logger.info("Clicked logout");
		
	}

	@Test(priority = 6)
	public void loginWithRememberMe() throws Exception {
		LoginPage l = new LoginPage();

		l.clickGotItBtn();

		l.enterValiedUserName();
		logger.info("Entered Username");

		l.enterValiedPassword();
		logger.info("Entered Password");

		l.clickRememberMeBtn();
		logger.info("Clicked RememberMeField");

		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");

		/**
		 * String actual = null; try { if(l.getaccInfo().isDisplayed())
		 * actual="success"; } catch(Exception e) { actual="failure"; }
		 * Assert.assertEquals(actual, "success");
		 
	}
**/
	@AfterClass
	public void afterTest() {
		// Close the browser
		driver.close();
		// reports.endTest(test);
		// reports.flush();
	}

}
