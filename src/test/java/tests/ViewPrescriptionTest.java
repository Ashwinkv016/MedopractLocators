package tests;

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
import pages.ViewPrescriptionPage;

public class ViewPrescriptionTest extends CommonMethod {
	public ViewPrescriptionTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}


	Logger logger= LogManager.getLogger(ViewPrescriptionTest.class);
	

	@BeforeClass
	public void openApplication() throws Exception {
		// Open the browser and hit the url
		initializeBrowser();

		LoginPage l=new LoginPage();
		l.clickGotItBtn();
		Thread.sleep(2000);
		l.enterValiedUserName();
		logger.info("Entered Username");
		Thread.sleep(2000);
		l.enterValiedPassword();
		logger.info("Entered Password");
		Thread.sleep(2000);
		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");
		


		/**	String actual = null;
		try {
			if(l.getaccInfo().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");**/
	}
	
	@Test(priority=1)
	public void viewPrescription() throws Exception  {
		ViewPrescriptionPage vpv=new ViewPrescriptionPage();
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

	/**	String actual = null;
		try {
			if(vpv.getviewPrescriptionsuccessful().isDisplayed())
				actual="success";
			logger.info("Prescription viewed");
		}
		catch(Exception e) {
			actual="failure";
			logger.info("Prescription not viewed");
		}
		Assert.assertEquals(actual, "success");**/
	}


	@Test(priority=2)
	public void printPrescription() throws  Exception {
		AddPrescriptionPage ap=new AddPrescriptionPage();
		ap.getprintPrescription();
		logger.info("Clicked PrintPrescription button");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		logger.info("Return to Home Page");
	}

	@Test(priority=3)
	public void downloadPrescription() throws Exception  {
		AddPrescriptionPage ap=new AddPrescriptionPage();
		ap.getdownloadPrescription();
		logger.info("Clicking Download Prescription Button");
		ap.getdownloadPrescription();
		logger.info(" Again Clicking Download Prescription Button");
		ap.getdownloadPrescription();
		logger.info(" Again Clicking Download Prescription Button");
	}
	@Test(priority = 4)
	public void clickingBackButton() throws Exception  {
		AddPrescriptionPage ap=new AddPrescriptionPage();
		ap.getprescriptionBackBtn();
		logger.info("Clicked Back Button");
	}

	@Test(priority=5)
	public void patientDetails() throws Exception {
		ViewPrescriptionPage vpv=new ViewPrescriptionPage();
		vpv.getgoToPatientDetails();

	/**	String actual = null;
		try {
			if(vpv.getpatientDetailsPage().isDisplayed())
				actual="success";
			logger.info("Patient page viewed");
		}
		catch(Exception e) {
			actual="failure";
			logger.info("Patient page not viewed");
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
