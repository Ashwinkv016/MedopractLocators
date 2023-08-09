package tests;


import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import genericPages.CommonMethod;
import pages.AddPatientPage;
import pages.LoginPage;
import pages.ViewOrEditPage;

public class ViewOrEditTest extends CommonMethod{
	public ViewOrEditTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger= LogManager.getLogger(ViewOrEditTest.class);
	
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
	public void deleteList() throws Exception  {
		AddPatientPage ap=new AddPatientPage();
		ap.clickPatientMenu();
		logger.info("Clicking Add Patient");

		ViewOrEditPage voe=new ViewOrEditPage();
		voe.clickViewOrEdit();
		logger.info("Clicked View or edit");
		voe.enterPatientName();
		logger.info("Entered Patient Name");
		voe.clickDeleteButton();
		logger.info("Clicked delete button");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		logger.info("Pressed Enter");

	/**	String actual="Patient record deleted successfully!";
		String expected=voe.getdeleteUpdateMsg().getText();
		Assert.assertEquals(actual, expected);

		voe.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}


	@Test(priority = 2)
	public void ViewOrEdit() throws Exception  {
		ViewOrEditPage voe=new ViewOrEditPage();
		voe.clickPatientList();
		logger.info("Clicked Patient List");
		voe.clickUpdateBtn();
		logger.info("Clicked Update Button");

/**		String actual="Patient record updated successfully!";
		String expected=voe.getsuccessUpdateMsg().getText();
		Assert.assertEquals(actual, expected);

		voe.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}

	@Test(priority  =3)
	public void updateContactField() throws  Exception {

		ViewOrEditPage voe=new ViewOrEditPage();
		AddPatientPage ap=new AddPatientPage();
		ap.clearPhoneNo();
		ap.enterValiedPhoneNo();
		ap.clearEmergencyPhno();
		ap.enterEmergencyPhno();
		voe.clickUpdateBtn();
		logger.info("Clicked Update Button");
		
	/**	String actual="Patient record updated successfully!";
		String expected=voe.getsuccessUpdateMsg().getText();
		Assert.assertEquals(actual, expected);

		voe.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}
	
	
	@Test(priority =4)
	public void withoutAddressField() throws Exception {
		ViewOrEditPage voe=new ViewOrEditPage();
		AddPatientPage ap=new AddPatientPage();
		ap.clearAddress();
		voe.clickUpdateBtn();
		logger.info("Clicked Update Button");
		
	}
	
	@Test(priority=5)
	public void withoutMandatoryData() throws Exception {
		ViewOrEditPage voe=new ViewOrEditPage();
		AddPatientPage ap=new AddPatientPage();
		ap.clearPatientName();
		logger.info("Cleared Name Field");
		ap.clearPhoneNo();
		logger.info("Cleared Phone Number Field");
		voe.clickUpdateBtn();
		logger.info("Clicked Update Button");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_ALT);
		
	/**	String actual="Please provide required inputs";
		String expected=voe.geterrorUpdateMsg().getText();
		Assert.assertEquals(actual, expected);

		voe.getcancelNotification();
		logger.info("Clicked Cancel Notification");**/
	}


	@Test(priority = 6)
	public void cancelEdit() throws Exception  {
		ViewOrEditPage voe=new ViewOrEditPage();
		voe.clickCancelButton();
		logger.info("Clicked Cancel Button");
	}

	@AfterClass
	public void CloseBrowser() {
		driver.close();
		logger.info("Closing Browser");
	}
}
