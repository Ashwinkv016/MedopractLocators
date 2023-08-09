package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
	public void PatientsTab() throws Exception  {
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
	
	@Test(priority=3)
	public void dateView() throws Exception{
		ReportsPage rp=new ReportsPage();
		rp.getClickReports();
		logger.info("Clicked on Reports");
		
	/**	String TodayDate=rp.gettodayDateView().getText();
		String ActualDate="Wed, Jul 19 2023";
		
		Assert.assertEquals(TodayDate,ActualDate);**/
	}
	
	@Test(priority = 4)
	public void cancel() throws Exception  {
		ReportsPage rp = new ReportsPage();
		//LoginPage l=new LoginPage();
		rp.getCancelButton();
		logger.info("Clicked on Cancel Button");
		
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

	@AfterClass
	public void afterTest() {
		// Close the browser
		driver.close();
		//reports.endTest(test);
		//reports.flush();
	}
}
