package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import genericPages.CommonMethod;
import pages.AddPatientPage;
import pages.LoginPage;
import pages.ReportsPage;

public class ReportsTest extends CommonMethod{
	public ReportsTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	Logger logger= LogManager.getLogger(ReportsTest.class);

	@BeforeClass
	public void openApplication() throws Exception {
		test=reports.startTest("Open appliation");
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

		DateFormat date=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date systemDate = new Date(0); 
		String dateOfSystem=date.format(systemDate);
		
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
	public void PatientsTab() throws Exception  {
		test=reports.startTest("TC001 Reports Patient Tab");
		ReportsPage rp = new ReportsPage();
		rp.getClickReports();
		logger.info("Clicked on Reports");
		rp.getYearlyTab();
		logger.info("Clicked on Yearly Tab");
		rp.getDailyTab();
		logger.info("Clicked on Daily Tab");
		rp.getMonthlyTab();
		logger.info("Clicked on Monthly Tab");
		rp.getWeeklyTab();
		logger.info("Clicked on Weekly Tab");
		rp.getDailyTab();
		logger.info("Clicked on Daily Tab");
		rp.getMonthlyTab();
		logger.info("Clicked on Monthly Tab");
		rp.getWeeklyTab();
		logger.info("Clicked on Weekly Tab");
		rp.getWeeklyTab();
		logger.info("Clicked on Weekly Tab");
		rp.getMonthlyTab();
		logger.info("Clicked on Monthly Tab");
	}



	@Test(priority = 2)
	public void AddPatient() throws Exception {
		test=reports.startTest("TC002 Add Patient");
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
		
		Assert.assertTrue(true, app.verifyNotification("Patient Record created successfully!"));

		app.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority=3)
	public void dateView() throws Exception{
		test=reports.startTest("TC004 Date View");
		ReportsPage rp=new ReportsPage();
		rp.getClickReports();
		logger.info("Clicked on Reports");
		
		Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class='reports_date__ZqmDS']")));
		logger.info("Assertion Passed");
	}
	
	@Test(priority = 4)
	public void cancel() throws Exception  {
		test=reports.startTest("TC004 Cancel Reports");
		ReportsPage rp = new ReportsPage();
		LoginPage l=new LoginPage();
		rp.getCancelButton();
		logger.info("Clicked on Cancel Button");
	
		String actual=null;
		try {
		if(l.verifyHomePage()) {
			actual="success";
		}
		else {
			actual="failure";
		}}catch(Exception e) {
			actual="failure";
		}
		Assert.assertTrue(actual.equals("success"));
	}

	@AfterClass
	public void afterTest() {
		// Close the browser
		driver.close();
		reports.endTest(test);
		reports.flush();
	}
}
