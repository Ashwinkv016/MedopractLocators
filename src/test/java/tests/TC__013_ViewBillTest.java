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
import pages.LoginPage;
import pages.ViewBill;
import pages.ViewOrEditPage;

public class TC__013_ViewBillTest extends CommonMethod{

	public TC__013_ViewBillTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger = LogManager.getLogger("ViewBillTest.class");

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
	public void viewBill() throws Exception {
		test = reports.startTest("TC001 View Bill");
       ViewBill vb=new ViewBill();
       vb.clickBilling();
       logger.info("Clicking Billing");
       vb.clickViewBill();
       logger.info("Clicking View Bill");
       vb.enterPatientName();
       logger.info("Entering Patient Name");
       vb.clickPatientNameSugg();
       logger.info("Clicking Patient Name Sugg");
       vb.clickViewBillList();
       logger.info("Clicking View Bill List");
      
	}
	
	@Test(priority = 2)
	public void printBill() throws Exception {
		test=reports.startTest("TC002 Print Bill");
		ViewBill vb=new ViewBill();
		vb.clickBillPrintBtn();
		logger.info("Clicked print Btn");
		Thread.sleep(2000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ESCAPE);
		
		
	}
	
	@Test(priority=3)
	public void downloadBill() throws Exception {
		test=reports.startTest("TC003 Downloading Bill");
		ViewBill vb=new ViewBill();
		vb.clickBillDownloadBtn();
		logger.info("Downloading Bill");
		vb.clickBillDownloadBtn();
		logger.info("Downloading Bill Again");
		vb.clickBillBackBtn();
		logger.info("Clicking Bill Back Btn");
	}
	
	
	
	@Test(priority = 4)
	public void goToPatientDetails() throws Exception {
		test=reports.startTest("TC004 Go To Patient Details");
		ViewBill vb=new ViewBill();
		ViewOrEditPage voe=new ViewOrEditPage();
		scrollTillDown();
		vb.clickGoToPatientDetails();
		logger.info("Go To Patient Details");
		
		String actual = null;
		try {
			if (getWebElement("viewOrEditPage").isDisplayed()) {
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
		
		voe.PatientPreviousVisitList();
		logger.info("View Or Edit Patient Previous Visit List");
		voe.cancelPatientPreviousVisit();
		logger.info("Cancel Patient Previous Visit Page");
		voe.clickUpdateBtn();
		logger.info("Clicking View Or Edit Update Btn");
		
		String actual1 = getWebElement("notification").getText();
		String expected1="Patient record updated successfully!";
		Assert.assertEquals(actual1, expected1);
		logger.info("Assertion Passed");
		
		voe.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	
	@AfterClass
	public void closeBrowser() {
		// Close the browser
		driver.close();
		reports.endTest(test);
		reports.flush();
	}
}
