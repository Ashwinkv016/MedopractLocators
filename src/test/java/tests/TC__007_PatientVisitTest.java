package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import genericPages.CommonMethod;
import pages.LoginPage;
import pages.PatientVisitPage;

public class TC__007_PatientVisitTest extends CommonMethod {
	public TC__007_PatientVisitTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger = LogManager.getLogger(TC__007_PatientVisitTest.class);

	@BeforeClass
	public void openApplication() throws Exception {
		test = reports.startTest("Open Application");
		initializeBrowser();
		logger.info("Navigated to Application URL");

		Assert.assertEquals("MedoPract App", driver.getTitle());

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
	public void addNewPatientData() throws Exception {
		test = reports.startTest("TC001 Add new Patient Data");
		PatientVisitPage pvp = new PatientVisitPage();
		pvp.getPatientsClick();
		logger.info("Clicked Patients Field");
		pvp.getPatientvisitClick();
		logger.info("Clicked Patient Visit");
		Thread.sleep(2000);
		pvp.getaddNewPatientHyperLink();
		logger.info("Clicked Add New Patient HyperLink");

		String actual = null;
		try {
			if (pvp.verifyPatientVisitPage()) {
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

	@Test(priority = 2)
	public void patientVisitWithPrimaryComplaintUpload() throws Exception {
		test = reports.startTest("TC002 PatientVisit With PrimaryComplaint Upload File");
		PatientVisitPage pvp = new PatientVisitPage();
		pvp.getPatientsClick();
		logger.info("Clicked Patient Menu");
		pvp.getPatientvisitClick();
		logger.info("Clicked Patient Visit");
		pvp.getPatientVisitName();
		logger.info("Clicked Patient Name Field");
		pvp.getpatientVisitNameSuggestions();
		logger.info("Clicked Patient Nmae Suggestion");
		pvp.getPrimaryComplaint();
		logger.info("Entered primary complaint field");
		scrollDown();
		pvp.getSymptoms1();
		logger.info("Entered symptoms field");
		pvp.getClickingSymptomsPlusSign();
		logger.info("ClickedSymptoms Plus Sign");
		pvp.getSymptoms2();
		logger.info("Entered Symptoms Again");
		pvp.getClickingSymptomsPlusSign();
		logger.info("Clicked Symptoms Plus Again");
		pvp.getSymptoms1();
		logger.info("Entered Symptoms");
		pvp.getClickingSymptomsPlusSign();
		logger.info("Clicked Symptoms Plus");
		pvp.getsymptomsDelete();
		logger.info("Clicked Symptoms cancel");
		pvp.getbloodPressure();
		logger.info("Entered Blood Pressure Level");
		pvp.getsugarLevel();
		logger.info("Entered SugarLevel");
		pvp.getheartRate();
		logger.info("Entered Heart Rate Level");
		scrollDown();
		pvp.getInvestigationTests1();
		logger.info("Entered Investigation Test");
		pvp.getClickingInvestigationPlusSign();
		logger.info("Clicked Investigation Plus Sign");
		pvp.getInvestigationTests2();
		logger.info("Entered Investigation Test Again");
		pvp.getClickingInvestigationPlusSign();
		logger.info("Clicked Investigation Plus Sign Again");
		pvp.getInvestigationTests1();
		logger.info("Entered Investigation Test Again");
		pvp.getClickingInvestigationPlusSign();
		logger.info("Clicked Investigation Plus Sign Again");
		pvp.getinvestigationDelete();
		logger.info("Clicked Investigations Delete");
		pvp.getclinicalObservation();
		logger.info("Entered Clinical Observation");
		pvp.getdiagnosisRemark();
		logger.info("Entered Diagnosis Remark");
		scrollDown();
		Thread.sleep(1000);
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='fileButton']"));
		uploadFile.sendKeys(System.getProperty("user.dir") + "\\src\\main\\java\\genericPages\\demoupload.txt");
		pvp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
		Thread.sleep(1000);
		
		uploadFile.sendKeys(System.getProperty("user.dir") + "\\src\\main\\java\\genericPages\\homePageTitle.png");
		logger.info("File Uploaded Successfully");

		String actual = getWebElement("notification").getText();
		String expected="File uploaded successfully!";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");
		
		pvp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");

	}

	@Test(priority = 3)
	public void deleteFile() throws Exception {
		test = reports.startTest("TC003 PatientVisit Delete File");
		PatientVisitPage pvp = new PatientVisitPage();

		pvp.deleteUploadedFile();
		logger.info("Deleted Uploaded File");

		String actual = getWebElement("notification").getText();
		String expected="File deleted successfully!";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");
		
		pvp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");

	}

	@Test(priority = 4)
	public void savePatientVisit() throws Exception {
		test = reports.startTest("TC004 Save PatientVisit");
		PatientVisitPage pvp = new PatientVisitPage();

		pvp.getSaveButton();
		logger.info("Clicked Save Button");

		base.waitForElementVisibility1("notification", 50);
		String actual = getWebElement("notification").getText();
		String expected="Patient visit added successfully!";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");
		
		pvp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 5)
	public void patientVisitWithoutPrimaryComplaint() throws Exception {
		test = reports.startTest("TC005 PatientVisit Without PrimaryComplaint");
		driver.navigate().refresh();
		PatientVisitPage pvp = new PatientVisitPage();
		pvp.getPatientsClick();
		logger.info("Clicked Patients Field");
		pvp.getPatientVisitName();
		logger.info("Clicked Patient Name Field");
		pvp.getpatientVisitNameSuggestions();
		logger.info("Clicked Patient Name Suggestion");
		pvp.getSaveButton();
		logger.info("Clicked Save Button");

		String actual = getWebElement("notification").getText();
		String expected="Please add Primary complaint";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		pvp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	
	@Test(priority = 6)
	public void followup() throws Throwable {
		test = reports.startTest("TC006  PatientVisit With FollowUp");
		driver.navigate().refresh();
		PatientVisitPage pvp = new PatientVisitPage();
		pvp.getPatientsClick();
		logger.info("Clicked Patient Menu");
		pvp.getPatientvisitClick();
		logger.info("Clicked Patient Visit");
		pvp.getPatientVisitName();
		logger.info("Clicked Patient Name Field");
		pvp.getpatientVisitNameSuggestions();
		logger.info("Clicked Patient Nmae Suggestion");
		pvp.getPrimaryComplaint();
		logger.info("Entered primary complaint field");
		pvp.getSymptoms1();
		logger.info("Entered symptoms field");
		pvp.getClickingSymptomsPlusSign();
		logger.info("ClickedSymptoms Plus Sign");
		pvp.getSymptoms1();
		logger.info("Entered Symptoms");
		pvp.getClickingSymptomsPlusSign();
		logger.info("Clicked Symptoms Plus");
		pvp.getbloodPressure();
		logger.info("Entered Blood Pressure Level");
		pvp.getsugarLevel();
		logger.info("Entered SugarLevel");
		pvp.getheartRate();
		logger.info("Entered Heart Rate Level");
		pvp.getInvestigationTests1();
		logger.info("Entered Investigation Test");
		pvp.getClickingInvestigationPlusSign();
		logger.info("Clicked Investigation Plus Sign");
		pvp.getInvestigationTests2();
		logger.info("Entered Investigation Test Again");
		pvp.getClickingInvestigationPlusSign();
		logger.info("Clicked Investigation Plus Sign Again");
		pvp.getclinicalObservation();
		logger.info("Entered Clinical Observation");
		pvp.getdiagnosisRemark();
		logger.info("Entered Diagnosis Remark");
		scrollDown();
		Thread.sleep(1000);
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='fileButton']"));
		uploadFile.sendKeys(System.getProperty("user.dir") + "\\src\\main\\java\\genericPages\\demoupload.txt");
		uploadFile.sendKeys(System.getProperty("user.dir") + "\\src\\main\\java\\genericPages\\homePageTitle.png");
		logger.info("File Uploaded Successfully");
		Thread.sleep(1000);
		pvp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
		pvp.getSaveButton();
		logger.info("Clicked Save Button");
		Thread.sleep(1000);
		pvp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
		pvp.getFollowup();
		logger.info("Clicked Follow Up");
		pvp.getVisitReason();
		pvp.getDateAndTimePickFollowUp();
		logger.info("Clicked Date and Time");
		//pvp.getdatePickFollowUp();
		//logger.info("Clicked Date ");
		pvp.gettimePickFollowUp();
		logger.info("Clicked Time");
		pvp.getAddAppointment();
		logger.info("Added Appointment");

		String actual = getWebElement("notification").getText();
		String expected="Appointment added Successfully";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");
		
		pvp.clickCancelNotification();
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
