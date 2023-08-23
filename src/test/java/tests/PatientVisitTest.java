package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import genericPages.CommonMethod;
import pages.LoginPage;
import pages.PatientVisitPage;

public class PatientVisitTest extends CommonMethod {
	public PatientVisitTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Logger logger= LogManager.getLogger(PatientVisitTest.class);

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

		String actual=null;
		try {
		if(l.verifyHomePage()) {
			actual="success";
			logger.info("Success");
		}
		else {
			actual="failure";
			logger.error("failure");
		}}catch(Exception e) {
			actual="failure";
			logger.error("failure");
		}
		Assert.assertTrue(actual.equals("success"));
        logger.info("Assertion Passed");
	}

	
	@Test(priority = 1)
	public void addNewPatientData() throws Exception  {
		test = reports.startTest("TC001 Add new Patient Data");
		PatientVisitPage pvp=new PatientVisitPage();
		pvp.getPatientsClick();
		logger.info("Clicked Patients Field");
		pvp.getPatientvisitClick();
		logger.info("Clicked Patient Visit");
		pvp.getaddNewPatientHyperLink();
		logger.info("Clicked Add New Patient HyperLink");
		
		String actual=null;
		try {
		if(pvp.verifyPatientVisitPage()) {
			actual="success";
			logger.info("Success");
		}
		else {
			actual="failure";
			logger.error("failure");
		}}catch(Exception e) {
			actual="failure";
			logger.error("failure");
		}
		Assert.assertTrue(actual.equals("success"));
        logger.info("Assertion Passed");
	}

	@Test(priority=2)
	public void patientVisitWithoutPrimaryComplaint() throws Exception  {
		test = reports.startTest("TC002 PatientVisit Without PrimaryComplaint");
		PatientVisitPage pvp=new PatientVisitPage();
		pvp.getPatientsClick();
		pvp.getPatientvisitClick();
		logger.info("Clicked Patient Visit");
		pvp.getPatientVisitName();
		logger.info("Clicked Patient Name Field");
		pvp.getpatientVisitNameSuggestions();
		logger.info("Clicked Patient Nmae Suggestion");
		pvp.getSymptoms1();
		logger.info("Entered symptoms field");
		pvp.getClickingSymptomsPlusSign();
		logger.info("ClickedSymptoms Plus Sign");
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
		pvp.getclinicalObservation();
		logger.info("Entered Clinical Observation");
		pvp.getdiagnosisRemark();
		logger.info("Entered Diagnosis Remark");
		pvp.uploadFile();
		logger.info("File Uploaded Successfully");
		
		Assert.assertTrue(true, pvp.verifyNotification("File uploaded successfully!"));
		logger.info("Assertion Passed");
		pvp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
		
		pvp.getSaveButton();
		logger.info("Clicked Save Button");
		
	
		Assert.assertTrue(true, pvp.verifyNotification("Please add Primary complaint"));
		logger.info("Assertion Passed");
		pvp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority=3)
	public void patientVisitWithPrimaryComplaint() throws Exception  {
		test = reports.startTest("TC003 PatientVisit With PrimaryComplaint");
		PatientVisitPage pvp=new PatientVisitPage();
		
		pvp.getPrimaryComplaint();
		logger.info("Entered primary complaint field");
		pvp.getSaveButton();
		logger.info("Clicked Save Button");
		

		Assert.assertTrue(true, pvp.verifyNotification("Patient visit added successfully!"));
		logger.info("Assertion Passed");
		pvp.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	

	
	@Test(priority=4)
	public void cancelSymptoms() throws Exception  {
		test = reports.startTest("TC004 PatientVisit With Cancel Symptoms");
		PatientVisitPage pvp=new PatientVisitPage();
		
		pvp.getsymptomsDelete();
		logger.info("Clicked Symptoms cancel");
		pvp.getSymptoms1();
		logger.info("Entered Symptoms");
		pvp.getClickingSymptomsPlusSign();
		logger.info("Clicked Symptoms Plus");
		pvp.getSymptoms2();
		logger.info("Entered Symptoms Again");
		pvp.getClickingSymptomsPlusSign();
		logger.info("Clicked Symptoms Plus Again");
		pvp.getSymptoms1();
		logger.info("Entered Symptoms Again");
		pvp.getClickingSymptomsPlusSign();
		logger.info("Clicked Symptoms Plus Again");
		pvp.getsymptomsDelete();
		logger.info("Clicked Symptoms Cancel Again");
		pvp.getsymptomsDelete();
		logger.info("Clicked Symptoms Cancel Again");
		
	}
	
	@Test(priority = 5)
	public void cancelInvstigations() throws Exception  {
		test = reports.startTest("TC005 PatientVisit With Cancel Investigstions");
		PatientVisitPage pvp=new PatientVisitPage();
		pvp.getInvestigationTests1();
		logger.info("Entered Investigation Test");
		pvp.getClickingInvestigationPlusSign();
		logger.info("Clicked Investigation Plus Sign");
		pvp.getInvestigationTests2();
		logger.info("Entered Investigation Test Again");
		pvp.getClickingInvestigationPlusSign();
		logger.info("Clicked Investigation Plus Sign Again");
		pvp.getinvestigationDelete();
		logger.info("Clicked Investigations Delete Again");
		pvp.getInvestigationTests1();
		logger.info("Entered Investigation Test Again");
		pvp.getClickingInvestigationPlusSign();
		logger.info("Clicked Investigation Plus Sign Again");
		pvp.getinvestigationDelete();
		logger.info("Clicked Investigations Delete Again");
		pvp.getinvestigationDelete();
		logger.info("Clicked Investigations Delete");
		
	}
	
	@Test(priority = 6)
	public void followup() throws Exception {
		test = reports.startTest("TC006 PatientVisit With FollowUp");
		PatientVisitPage pvp=new PatientVisitPage();
		
		pvp.getFollowup();
		logger.info("Clicked Follow Up");
		pvp.getVisitReason();
		pvp.getDateAndTimePickFollowUp();
		logger.info("Clicked Date and Time");
		pvp.getdatePickFollowUp();
		logger.info("Clicked Date ");
		pvp.gettimePickFollowUp();
		logger.info("Clicked Time");
		pvp.getAddAppointment();
		logger.info("Added Appointment");
		
		Assert.assertTrue(true, pvp.verifyNotification("Appointment added Successfully"));
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
