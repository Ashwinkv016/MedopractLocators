package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import genericPages.CommonMethod;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends CommonMethod{

	public HomePageTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeClass
	public void openApplication() throws Exception {
		// Open the browser and hit the url
				initializeBrowser();
				
				LoginPage l=new LoginPage();
				l.enterValiedUserName();
				logger.info("Entered Username");
				l.enterValiedPassword();
				logger.info("Entered Password");
				l.clickSubmitLoginBtn();
				logger.info("Clicked submit button");
				l.clickLogoutBtn();
				logger.info("Clicked logout button");
	}
	
    @Test
    public void checkTitle() throws Exception {
    	//test=reports.startTest("Tc001 verify all menu's");
    	HomePage h=new HomePage();
    	
    	//Verify Homepage Appointmnets Title
    	h.verifyHomePageAppointmentsTitle();
    	
    	//Verify ToDoList Title
    	h.verifyToDoListTitle();
    	
    	//Verify Patient title
    	h.verifyToDoListTitle();
    	
    	//Verify Appointment Title
    	h.verifyAppointmentsTitle();
    	
    	//Verify Prescription Title
    	h.verifyPrescriptionsTitle();
    	
    	//Verify Reports Title
    	h.verifyReportsTitle();
    	
    	//Verify Home Menu
    	h.verifyHomeMenu();
    }
    
    @AfterClass
	public void afterTest() {
		// Close the browser
		driver.close();
	//	reports.endTest(test);
	//	reports.flush();
	}
}
