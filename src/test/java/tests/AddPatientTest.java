package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import genericPages.CommonMethod;
import pages.AddPatientPage;
import pages.LoginPage;

public class AddPatientTest extends CommonMethod {
	public AddPatientTest() throws Exception {
	}
	Logger logger= LogManager.getLogger(AddPatientTest.class);

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
	public void AddPatient() throws Exception {

		AddPatientPage app=new AddPatientPage();
		app.clickPatientMenu();
		logger.info("Clicking Patients");
		app.clickAddPatient();
		logger.info("Clicking Add Patient");
		app.enterValiedPatientName();
		logger.info("Added Patient's Name");
		app.enterInValiedPhoneNo();
		logger.info("Added Patient's Phone Number");
		app.clickGenderField();
		logger.info("Selected Gender Field");
		app.clickBirthDateField();
		app.enterMonthField();
		app.enterDateField();
		app.enterYearfield();;
		app.clickBloodGroup();
		logger.info("Selected Blood Group");
		app.enterOccupation();
		logger.info("Added Occupation Field");
		app.enterAddress();
		logger.info("Added Address");
		app.enterEmergencyPhno();
		logger.info("Added Emergency contact no field");
		app.enterAllergy();
		logger.info("Added Allergy field");
		app.enterRemarks();
		logger.info("Added Remark field");
		app.enterHistory();
		logger.info("Added History field");
		app.enterhabits1();
		logger.info("Entered Habit field");
		app.clickHabitsPlus();
		logger.info("Added Habit field by clicking Plus");
		app.enterhabits2();
		logger.info("Entered Habit field");
		app.clickHabitsPlus();
		logger.info("Added Habit field by clicking Plus");
		app.enterhabits1();
		logger.info("Entered Habit field");
		app.clickHabitsPlus();
		logger.info("Added Habit field by clicking Plus");
		app.clickHabitsCancel();
		Thread.sleep(2000);
		app.clickPatientSaveBtn();
	/**	String expectedResult="Patient Record created successfully!";
		String actualResult=app.getCreatedSuccessfully().getText();
		Assert.assertEquals(actualResult, expectedResult);

		app.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}

	@Test(priority = 2)
	public void resetPatientData() throws Exception  {

		AddPatientPage app=new AddPatientPage();

		app.clickPatientSaveBtn();
		logger.info("Clicked SaveButton");
		app.clickPatientResetBtn();
		logger.info("Clicked ResetButton"); 

	/**	String actual = null;
		try {
			if(app.getCreatedSuccessfully().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "failure");**/
	}

	@Test(priority = 3)
	public void withoutMandatoryAllData() throws Exception  {

		AddPatientPage app=new AddPatientPage();
		
		app.clickPatientSaveBtn();
		logger.info("Clicked SaveButton");

/**		String actualResult = app.getErrorMessage().getText();
		String expectedResult = "Please provide required inputs";
		Assert.assertEquals(actualResult, expectedResult);

		app.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}


	@Test(priority=4)
	public void nameWithSpecialCharacter() throws Exception {
		AddPatientPage app=new AddPatientPage();
		app.enterInValiedPatientName();
		logger.info("Added Patient's Name");
		app.enterValiedPhoneNo();

	/**	String expectedTitle = "Please enter valid name- Only Alphabets and spaces are allowed";
		String actualTitle = app.getnameErrorMsg().getText();
		Assert.assertEquals(expectedTitle, actualTitle);**/


	}
	@Test(priority = 5)
	public void withIncorrectPhoneNo() throws Exception  {

		AddPatientPage app=new AddPatientPage();
		app.clearPatientName();
		logger.info("Cleared Patient's Name");
		app.clearPhoneNo();
		app.enterInValiedPhoneNo();
		logger.info("Added Patient's Phone Number");
		app.clickGenderField();
		logger.info("Selected Gender Field");

	/**	String expectedTitle = "Mobile number must be 10 digits long valid number";
		String actualTitle = app.getMobileNoErrorMsg().getText();
		Assert.assertEquals(expectedTitle, actualTitle);**/
	}

	@Test(priority = 6)
	public void sameContactNoInEmergencyField() throws Exception  {
		AddPatientPage app=new AddPatientPage();
		app.enterValiedPatientName();
		logger.info("Added Patient's Name");
		app.clearPhoneNo();
		app.enterValiedPhoneNo();
		logger.info("Added Patient's Phone Number");
		app.clickGenderField();
		logger.info("Selected Gender Field");
		app.clickBirthDateField();
		app.enterMonthField();
		app.enterDateField();
		app.enterYearfield();
		app.clickBloodGroup();
		logger.info("Selected Blood Group");
		app.enterOccupation();
		logger.info("Added Occupation Field");
		app.enterAddress();
		logger.info("Added Address");
		app.enterEmergencyPhno();
		logger.info("Added Emergency contact no field");
		app.enterAllergy();
		logger.info("Added Allergy field");
		app.enterRemarks();
		logger.info("Added Remark field");
		app.enterHistory();
		logger.info("Added History field");
		app.enterhabits1();
		logger.info("Entered Habit field");
		app.clickHabitsPlus();
		logger.info("Added Habit field by clicking Plus");
		app.clickPatientSaveBtn();

	/**	String expectedResult="Patient Record created successfully!";
		String actualResult=app.getCreatedSuccessfully().getText();
		Assert.assertEquals(actualResult, expectedResult);

		app.getcancelNotification();
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
