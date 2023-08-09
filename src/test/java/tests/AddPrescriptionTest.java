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

public class AddPrescriptionTest extends CommonMethod {
	public AddPrescriptionTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger= LogManager.getLogger(AddPrescriptionTest.class);

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


	@Test(priority = 1)
	public void withoutAddingMedicineField() throws Exception  {
		AddPrescriptionPage ap=new AddPrescriptionPage();
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

	/**	String expectedResult="Please add medicines";
		String actualResult=ap.geterrorMessage().getText();
		Assert.assertEquals(actualResult, expectedResult);

		ap.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}

	@Test(priority = 2)
	public void addPrescription() throws Exception  {
		AddPrescriptionPage ap=new AddPrescriptionPage();
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

	/**	String expectedResult="Prescription created successfully!";
		String actualResult=ap.getsuccessMessage().getText();
		Assert.assertEquals(actualResult, expectedResult);

		ap.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}


	@Test(priority= 3)
	public void printPrescription() throws Exception {
		AddPrescriptionPage ap=new AddPrescriptionPage();
		ap.getprintPrescription();
		logger.info("Clicked PrintPrescription button");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		logger.info("Return to Home Page");
	}

	@Test(priority=4)
	public void downloadPrescriptionAgain() throws Exception {
		AddPrescriptionPage ap=new AddPrescriptionPage();
		ap.getdownloadPrescription();
		logger.info("Clicking Download Prescription Button");
		ap.getdownloadPrescription();
		logger.info(" Again Clicking Download Prescription Button");
	}



	@Test(priority = 5)
	public void clickingBack() throws Exception {
		AddPrescriptionPage ap=new AddPrescriptionPage();
		ap.getprescriptionBackBtn();
		logger.info("Clicking Back in Printing Page");
		ap.getBackButton();
		logger.info("Clicking Back in Prescription Page");

	/**	LoginPage l=new LoginPage(driver);
		String actual = null;
		try {
			if(l.getaccInfo().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");**/
	}

	@Test(priority =6 )
	public void cancelAddedMedicineField() throws Exception  {
		AddPrescriptionPage ap=new AddPrescriptionPage();
		ap.getclickPrescription();
		logger.info("Clicked on Prescription");
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
		ap.getClickingPlusSign();
		logger.info("Again clicking Medicine Field Plus Sign");
		ap.getdeleteMedicineField();
		logger.info("Cancelled Medicine field");
		ap.getdeleteMedicineField();
		logger.info("Again Cancelled Medicine field");

	}

	@Test(priority=7)
	public void withInvaliedMedicineField() throws Exception {
		AddPrescriptionPage ap=new AddPrescriptionPage();
		ap.getMedicineNameField2();
		logger.info("Entered Medicine Name");
		ap.getTotalNumberDays2();
		logger.info("Entered Total Number Of Days");
		ap.getTimingsInput2();
		logger.info("Entered Time Inputs");
		ap.getAmountInput2();
		logger.info("Entered number Of amount to be used");
		ap.getClickingPlusSign();
		logger.info("Clicked Medicine Field Plus Sign");
		ap.getSaveAndPrintButton();
		logger.info("Clicked Save and Print Button");
		ap.getyesButtonField();
		logger.info("Clicked yes");

	/**	String expectedResult="could not create record! Prescriptions record could not be added. due to: ValidationError: medecineDetails.0.totalcountsToConsume: Cast to Number failed for value \"gg\" at path \"totalcountsToConsume\", medecineDetails.0.howmanyatatime: Cast to Number failed for value \"gg\" at path \"howmanyatatime\"";
		String actualResult=ap.getmedicineErrorMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);

		ap.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}
	 @AfterClass
		public void afterTest() {
			// Close the browser
			driver.close();
			//reports.endTest(test);
			//reports.flush();
		}

}
