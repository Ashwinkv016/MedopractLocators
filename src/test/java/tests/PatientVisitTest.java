package tests;

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
	public void addNewPatientData() throws Exception  {
		PatientVisitPage pvp=new PatientVisitPage();
		pvp.getPatientsClick();
		logger.info("Clicked Patients Field");
		pvp.getPatientvisitClick();
		logger.info("Clicked Patient Visit");
		pvp.getaddNewPatientHyperLink();
		logger.info("Clicked Add New Patient HyperLink");
		
	/**	String actual=null;
		try {
			if(pvp.getaddPatientPage().isDisplayed())
				logger.info("Entered Add NewPatient page");
				actual="success";
		}
		catch(Exception e) {
			logger.info("Failed to enter to Add NewPatient page");
			actual="failure";
		}
		Assert.assertEquals(actual, "success");**/
	}

	@Test(priority=2)
	public void patientVisitWithoutPrimaryComplaint() throws Exception  {
		PatientVisitPage pvp=new PatientVisitPage();
		pvp.getPatientsClick();
		logger.info("Clicked Patients Field");
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
		pvp.getSaveButton();
		logger.info("Clicked Save Button");
		
	/**	String actualResult = pvp.geterrorMessage().getText();
		String expectedResult = "Please add Primary complaint";
		Assert.assertEquals(actualResult, expectedResult);
		
		pvp.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}
	
	@Test(priority=3)
	public void patientVisitWithPrimaryComplaint() throws Exception  {
		PatientVisitPage pvp=new PatientVisitPage();
		
		pvp.getPrimaryComplaint();
		logger.info("Entered primary complaint field");
		pvp.getSaveButton();
		logger.info("Clicked Save Button");
		
/**		String actualResult = pvp.getsuccessMessage().getText();
		String expectedResult = "Patient visit added successfully!";
		Assert.assertEquals(actualResult, expectedResult);
		
		pvp.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}
	

	
	@Test(priority=4)
	public void cancelSymptoms() throws Exception  {
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
		PatientVisitPage pvp=new PatientVisitPage();
		
		pvp.getFollowup();
		logger.info("Clicked Follow Up");
		pvp.getVisitReason();
		pvp.getDateAndTimePickFollowUp();
		logger.info("Clicked Date and Time");
		pvp.getdatePickFollowUp();
		pvp.gettimePickFollowUp();
		pvp.getAddAppointment();
		logger.info("Added Appointment");
		
	/**	String expectedResult="Appointment added Successfully";
		String actualResult=pvp.getfollowNotification().getText();
        Assert.assertEquals(actualResult, expectedResult);
        
		pvp.getcancelNotification();
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
