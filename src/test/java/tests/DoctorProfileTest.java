package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import genericPages.CommonMethod;
import pages.DoctorProfilePage;
import pages.LoginPage;

public class DoctorProfileTest extends CommonMethod {

	public DoctorProfileTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
     Logger logger=LogManager.getLogger(DoctorProfileTest.class);
     
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
     public void saveDoctorprofile() throws Exception {
    	 test=reports.startTest("TC001 Save DoctorProfile");
    	 DoctorProfilePage dpp=new DoctorProfilePage();
    	 dpp.clickDoctorProfile();
    	 logger.info("Clicked doctor profile");
    	// dpp.enterDoctorName();
    	 logger.info("Entered doctor Name");
    	 dpp.enterDoctorGender();
    	 logger.info("Entered doctor Gender");
    	 dpp.enterDoctorDateOfBirth();
    	 logger.info("Entered doctor DOB");
    	 dpp.enterDoctorQualification();
    	 logger.info("Entered doctor Qualification");
    	// dpp.enterDoctorEmail();
    	 logger.info("Entered doctor Email");
    	 dpp.enterDoctorMobileNumber();
    	 logger.info("Entered doctor Phno");
    	 dpp.enterHospitalName();
    	 logger.info("Entered Hospital Name");
    	 dpp.enterHospitalPhno();
    	 logger.info("Entered Hospital Phno");
    	 dpp.enterHospitalFax();
    	 logger.info("Entered Hospital Fax");
    	 dpp.enterHospitalAddress();
    	 logger.info("Entered Hospital Address");
    	 dpp.enterHospitalCity();
    	 logger.info("Entered Hospital City");
    	 dpp.enterHospitalState();
    	 logger.info("Entered Hospital State");
    	 dpp.enterHospitalPincode();
    	 logger.info("Entered Hospital Pincode");
    	 dpp.clickSaveChangesBtn();
    	 logger.info("Clicked SaveChanges Btn");
     }
     
     @AfterClass
     public void closeBrowser() {
    	 driver.close();
    	 reports.endTest(test);
    	 reports.flush();
     }
}
