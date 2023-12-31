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
import pages.AddPatientPage;
import pages.LoginPage;
import pages.ViewOrEditPage;

public class TC__008_ViewOrEditTest extends CommonMethod {
	public TC__008_ViewOrEditTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger = LogManager.getLogger(TC__008_ViewOrEditTest.class);

	@BeforeClass
	public void openApplication() throws Exception {
		test = reports.startTest("Open Application");
		// Open the browser and hit the url
		initializeBrowser();

		LoginPage l = new LoginPage();

		l.clickGotItBtn();
		logger.info("Clicked GotIt Btn");

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
			} else {
				actual = "failure";
			}
		} catch (Exception e) {
			actual = "failure";
		}
		Assert.assertTrue(actual.equals("success"));
		logger.info("Assertion Passed");
	}

	@Test(priority = 1)
	public void deleteList() throws Exception {
		test = reports.startTest("TC001 Delete ViewOrEdit List");
		AddPatientPage ap = new AddPatientPage();
		ap.clickPatientMenu();
		logger.info("Clicking Add Patient");

		ViewOrEditPage voe = new ViewOrEditPage();
		voe.clickViewOrEdit();
		logger.info("Clicked View or edit");
		voe.enterPatientName();
		logger.info("Entered Patient Name");
		voe.clickDeleteButton();
		logger.info("Clicked delete button");
		alertHandling();
		logger.info("Pressed Enter");

		String actual = getWebElement("notification").getText();
		String expected="Patient record deleted successfully!";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");
		
		voe.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 2)
	public void updateContactField() throws Exception {
		test = reports.startTest("TC002 View Or Edit Update Contact Field");
		ViewOrEditPage voe = new ViewOrEditPage();
		AddPatientPage ap = new AddPatientPage();
		voe.clickPatientList();
		logger.info("Clicked patient List");
        scrollTillElement();
		ap.clearPhoneNo();
		logger.info("Cleared Phno");
		ap.enterValiedPhoneNo();
		logger.info("Entered Phno");
		ap.clearEmergencyPhno();
		logger.info("Cleared Emergency Phno");
		ap.enterEmergencyPhno();
		logger.info("Entered Emergency Phno");
		ap.clearAddress();
		logger.info("Cleared Address Field");
		ap.enterAddress();
		logger.info("Entered Address Field");
		voe.clickUpdateBtn();
		logger.info("Clicked Update Button");

		String actual = getWebElement("notification").getText();
		String expected="Patient record updated successfully!";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");
		
		voe.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 3)
	public void withoutAddressField() throws Exception {
		test = reports.startTest("TC003 View Or Edit Without Address Field");
		ViewOrEditPage voe = new ViewOrEditPage();
		AddPatientPage ap = new AddPatientPage();

		scrollTillElement();
		Thread.sleep(1000);
		ap.clearAddress();
		logger.info("Cleared Address Field");
		Thread.sleep(1000);
		voe.clickUpdateBtn();
		logger.info("Clicked Update Button");

	}

	//@Test(priority = 4)
	public void withoutMandatoryData() throws Exception {
		test = reports.startTest("TC004 View Or Edit Without Mandatory Data");
		ViewOrEditPage voe = new ViewOrEditPage();
		AddPatientPage ap = new AddPatientPage();
		ap.clearPatientName();
		logger.info("Cleared Name Field");
		ap.clearPhoneNo();
		logger.info("Cleared Phone Number Field");
		ap.enterAddress();
		logger.info("Entered Address");
		voe.clickUpdateBtn();
		logger.info("Clicked Update Button");
		Thread.sleep(2000);
		
		 Robot r = new Robot();
         r.keyPress(KeyEvent.VK_ALT);
         r.keyPress(KeyEvent.VK_LEFT);
         r.keyRelease(KeyEvent.VK_LEFT);
         r.keyRelease(KeyEvent.VK_ALT);	
         
 		String actual = getWebElement("notification").getText();
		String expected="Please provide required inputs";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");
		
 		voe.clickCancelNotification();
 		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 5)
	public void cancelEdit() throws Exception {
		test = reports.startTest("TC005 View Or Edit Cancel Edit");
		ViewOrEditPage voe = new ViewOrEditPage();
		voe.clickCancelButton();
		logger.info("Clicked Cancel Button");
	}

	@AfterClass
	public void CloseBrowser() {
		driver.close();
		logger.info("Closing Browser");
		reports.endTest(test);
		reports.flush();
	}
}
