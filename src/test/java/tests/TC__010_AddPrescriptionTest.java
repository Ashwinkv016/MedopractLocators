package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import genericPages.CommonMethod;
import pages.AddPrescriptionPage;
import pages.LoginPage;

public class TC__010_AddPrescriptionTest extends CommonMethod {
	public TC__010_AddPrescriptionTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger = LogManager.getLogger(TC__010_AddPrescriptionTest.class);

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
	public void withoutAddingMedicineField() throws Exception {
		test = reports.startTest("TC001 Add Prescription without adding Medicine Field");
		AddPrescriptionPage ap = new AddPrescriptionPage();
		ap.getclickPrescription();
		logger.info("Clicked on Prescription");
		ap.getPatientNameField();
		logger.info("Entered Patient Name");
		ap.getpatientNameSuggestion();
		logger.info("Clicked Patient Name Suggestion");
		ap.getEmailField();
		logger.info("Entered Email Field");
		ap.getSaveAndPrintButton();
		logger.info("Clicked Save and Print Button");

		String actual = getWebElement("notification").getText();
		String expected="Please add medicines";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		ap.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 2)
	public void addPrescription() throws Exception {
		test = reports.startTest("TC002 Add Prescription");
		AddPrescriptionPage ap = new AddPrescriptionPage();
		ap.getMedicineNameField1();
		logger.info("Entered Medicine Name");
		ap.getTotalNumberDays1();
		logger.info("Entered Total Number Of Days");
		ap.getTimingsInput1();
		logger.info("Entered Time Inputs");
		ap.getAmountInput1();
		logger.info("Entered number Of amount to be used");
		ap.getClickingPlusSign();
		logger.info("Clicked Medicine Field Plus Sign");
		ap.getSaveAndPrintButton();
		logger.info("Clicked Save and Print Button");
		ap.getyesButtonField();
		logger.info("Clicked yes");
		
		String actual = getWebElement("notification").getText();
		String expected="Prescription created successfully!";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");
		
		ap.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 3)
	public void printPrescription() throws Exception {
		test = reports.startTest("TC003 print Prescription");
		AddPrescriptionPage ap = new AddPrescriptionPage();
		ap.getprintPrescription();
		logger.info("Clicked PrintPrescription button");
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ESCAPE);
		logger.info("Return to Home Page");
	}

	@Test(priority = 4)
	public void downloadPrescriptionAgain() throws Exception {
		test = reports.startTest("TC004 Download Prescription");
		AddPrescriptionPage ap = new AddPrescriptionPage();
		ap.getdownloadPrescription();
		logger.info("Clicking Download Prescription Button");
		ap.getdownloadPrescription();
		logger.info(" Again Clicking Download Prescription Button");
	}

	@Test(priority = 5)
	public void clickingBack() throws Exception {
		test = reports.startTest("TC005 Click Back Of prescription");
		AddPrescriptionPage ap = new AddPrescriptionPage();
		ap.getprescriptionBackBtn();
		logger.info("Clicking Back in Printing Page");
		ap.getBackButton();
		logger.info("Clicking Back in Prescription Page");

		String actual = null;
		try {
			if (getWebElement("homePageTitle").isDisplayed()) {
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

	@Test(priority = 6)
	public void cancelAddedMedicineField() throws Exception {
		test = reports.startTest("TC006 Cancel Added Medicine Field");
		AddPrescriptionPage ap = new AddPrescriptionPage();
		ap.getclickPrescription();
		logger.info("Clicked Prescription Btn");
		ap.getPatientNameField();
		logger.info("Entered Patient Name");
		ap.getpatientNameSuggestion();
		logger.info("Clicked Patient Name Suggestion");
		ap.getEmailField();
		logger.info("Entered Email Field");
		ap.getMedicineNameField1();
		logger.info("Entered Medicine Name");
		ap.getTotalNumberDays1();
		logger.info("Entered Total Number Of Days");
		ap.getTimingsInput1();
		logger.info("Entered Time Inputs");
		ap.getAmountInput1();
		logger.info("Entered number Of amount to be used");
		ap.getClickingPlusSign();
		logger.info("Clicked Medicine Field Plus Sign");
		ap.getMedicineNameField1();
		logger.info("Again entering Medicine Name");
		ap.getTotalNumberDays1();
		logger.info("Again entering  Total Number Of Days");
		ap.getTimingsInput1();
		logger.info("Again entering  Time Inputs");
		ap.getAmountInput1();
		logger.info("Again entering  number Of amount to be used");
		scrollTillElement();
		ap.getClickingPlusSign();
		logger.info("Again clicking Medicine Field Plus Sign");
		ap.getSaveAndPrintButton();
		logger.info("Clicking Save And Print Button");
		ap.getnoButtonField();
		logger.info("Clicking Verify Data No Button");
		scrollDown();
		ap.getdeleteMedicineField();
		logger.info("Cancelled Medicine field");
		ap.getdeleteMedicineField();
		logger.info("Again Cancelled Medicine field");
	}
	
	@Test(priority=7)
	public void enterMedicineFieldwithoutAdding() throws Exception {
		test=reports.startTest("TC007 Entering the Medicine Field without Adding it in Medicine Field");
		AddPrescriptionPage ap=new AddPrescriptionPage();
		ap.getMedicineNameField2();
		logger.info("Entered Medicine Name");
		ap.getTotalNumberDays2();
		logger.info("Entered Total Number Of Days");
		ap.getTimingsInput2();
		logger.info("Entered Time Inputs");
		ap.getAmountInput2();
		logger.info("Entered number Of amount to be used");
		ap.getSaveAndPrintButton();
		logger.info("Clicking Save And Print Button");
		
		String actual = getWebElement("notification").getText();
		String expected = "Please add the entered medicine";
		Assert.assertEquals(actual,expected);
		logger.info("Assertion Passed");

		ap.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 8)
	public void withInvaliedMedicineField() throws Exception {
		test = reports.startTest("TC008 Add Prescription with Invalied Mediciine Field");
		AddPrescriptionPage ap = new AddPrescriptionPage();
		ap.getClickingPlusSign();
		logger.info("Clicked Medicine Field Plus Sign");
		ap.getSaveAndPrintButton();
		logger.info("Clicked Save and Print Button");
		ap.getyesButtonField();
		logger.info("Clicked yes");
		Thread.sleep(3000);
		
		String actual = getWebElement("notification").getText();
		String expected = "could not create record! Prescriptions record could not be added. due to: ValidationError: medecineDetails.0.totalcountsToConsume: Cast to Number failed for value \"gg\" at path \"totalcountsToConsume\", medecineDetails.0.howmanyatatime: Cast to Number failed for value \"gg\" at path \"howmanyatatime\"";
		Assert.assertTrue(actual.contentEquals(expected));
		logger.info("Assertion Passed");

		ap.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@AfterClass
	public void afterTest() {
		// Close the browser
		driver.close();
		reports.endTest(test);
		reports.flush();
	}

}
