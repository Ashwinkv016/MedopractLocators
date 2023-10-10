package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import genericPages.CommonMethod;
import pages.AddPrescriptionPage;
import pages.LoginPage;
import pages.ViewPrescriptionPage;

public class ViewPrescriptionTest extends CommonMethod {
	public ViewPrescriptionTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger = LogManager.getLogger(ViewPrescriptionTest.class);

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
			if (l.verifyHomePage()) {
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

	@Test(priority = 1)
	public void viewPrescription() throws Exception {
		test = reports.startTest("TC001 View Prescription");
		ViewPrescriptionPage vpv = new ViewPrescriptionPage();
		AddPrescriptionPage ap = new AddPrescriptionPage();
		vpv.getPrescriptionsLink();
		logger.info("Clicked Prescription");
		vpv.getviewPrescriptionsLink();
		logger.info("Clicked View Prescription");
		vpv.getpatientNameField();
		logger.info("Entered Patient Name");
		vpv.getpatientNameFieldSugg();
		logger.info("Clicked Patient Name Field Suggestion");
		vpv.getprescriptionDetails();
		logger.info("Clicked Prescription Details");

		String actual = null;
		try {
			if (vpv.verifyPrescriptionPage()) {
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
		scrollDown();
		ap.getprescriptionBackBtn();
		logger.info("Clicked Back Button");
	}



	@Test(priority = 2)
	public void patientDetails() throws Exception {
		test = reports.startTest("TC002 View Prescription Patient Details");
		ViewPrescriptionPage vpv = new ViewPrescriptionPage();
		vpv.getgoToPatientDetails();

		String actual = null;
		try {
			if (vpv.verifyAddPatientPage()) {
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

	@AfterClass
	public void afterTest() {
		// Close the browser
		driver.close();
		reports.endTest(test);
		reports.flush();
	}
}
