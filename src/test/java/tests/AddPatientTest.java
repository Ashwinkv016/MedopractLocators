package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import genericPages.CommonMethod;
import pages.AddPatientPage;
import pages.LoginPage;

public class AddPatientTest extends CommonMethod {
	public AddPatientTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger = LogManager.getLogger(AddPatientTest.class);

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
	public void withoutMandatoryAllData() throws Exception {
		test = reports.startTest("TC001 Without Mandatory All Field");
		AddPatientPage app = new AddPatientPage();
		app.clickPatientMenu();
		logger.info("Clicking Patients");
		app.clickAddPatient();
		logger.info("Clicking Add Patient");
		app.clickPatientSaveBtn();
		logger.info("Clicked SaveButton");
		
		String actual = getWebElement("notification").getText();
		String expected="Please provide required inputs";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		app.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 2)
	public void AddPatient() throws Exception {
		test = reports.startTest("TC002 Add Patient Test");
		driver.navigate().refresh();
		AddPatientPage app = new AddPatientPage();
		app.clickPatientMenu();
		logger.info("Clicking Patients");
		app.clickAddPatient();
		logger.info("Clicking Add Patient");
		app.enterValiedPatientName();
		logger.info("Added Patient's Name");
		app.enterValiedPhoneNo();
		logger.info("Added Patient's Phone Number");
		app.clickGenderField();
		logger.info("Selected Gender Field");
		app.clickBirthDateField();
		app.enterMonthField();
		app.enterDateField();
		app.enterYearfield();
		logger.info("Entered Date Of Birth Field");
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
		logger.info("Canceled Habit field");
		app.clickPatientSaveBtn();
		logger.info("Clicked Save Button");
		
		String actual = getWebElement("notification").getText();
		String expected="Patient Record created successfully!";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		app.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 3)
	public void resetPatientWithData() throws Exception {
		test = reports.startTest("TC003 Reset patient data");
		AddPatientPage app = new AddPatientPage();

		app.clickPatientResetBtn();
		logger.info("Clicked Reset Button");

	}

	@Test(priority = 4)
	public void resetPatientWithoutData() throws Exception {
		test = reports.startTest("TC004 Reset patient Without Data");
		driver.navigate().refresh();
		AddPatientPage app = new AddPatientPage();
		app.clickPatientMenu();
		logger.info("Clicking Patients");
		app.clickAddPatient();
		logger.info("Clicking Add Patient");
		app.clickPatientResetBtn();
		logger.info("Clicked Reset Button");

	}

	@Test(priority = 5)
	public void nameWithSpecialCharacter() throws Exception {
		test = reports.startTest("TC005 Patient Name with Special Character");
		AddPatientPage app = new AddPatientPage();
		app.enterInValiedPatientName();
		logger.info("Added Patient's Name");
		app.enterValiedPhoneNo();
		
		String actual = getWebElement("patientNameErrorMsg").getText();
		String expected="Please enter valid name- Only Alphabets and spaces are allowed";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

	
	}

	@Test(priority = 6)
	public void withIncorrectPhoneNo() throws Exception {
		test = reports.startTest("TC006 Add Patient with Incorrect Phno");
		driver.navigate().refresh();
		AddPatientPage app = new AddPatientPage();
		app.clickPatientMenu();
		logger.info("Clicking Patients");
		app.clickAddPatient();
		logger.info("Clicking Add Patient");
		app.clearPatientName();
		logger.info("Cleared Patient's Name");
		app.clearPhoneNo();
		app.enterInValiedPhoneNo();
		logger.info("Added Patient's Phone Number");
		app.clickGenderField();
		logger.info("Selected Gender Field");

		
		String actual = getWebElement("patientPhnoErrorMsg").getText();
		String expected="Mobile number must be 10 digits long valid number";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");
		
	}

	@Test(priority = 7)
	public void sameContactNoInEmergencyField() throws Exception {
		test = reports.startTest("TC007 Add Patient with Same ContactNo in Emergency Field");
		driver.navigate().refresh();
		AddPatientPage app = new AddPatientPage();
		app.clickPatientMenu();
		logger.info("Clicking Patients");
		app.clickAddPatient();
		logger.info("Clicking Add Patient");
		app.enterPatientName();
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
		logger.info("Clicked Save Button");
		
		String actual = getWebElement("notification").getText();
		String expected="Patient Record created successfully!";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		app.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@AfterClass
	public void CloseBrowser() {
		// Close the browser
		driver.close();
		reports.endTest(test);
		reports.flush();
	}

}
