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

public class TC__015_DoctorProfileTest extends CommonMethod {

	public TC__015_DoctorProfileTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
     Logger logger=LogManager.getLogger(TC__015_DoctorProfileTest.class);
     
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
     public void saveDoctorprofile() throws Exception {
    	 test=reports.startTest("TC001 Save DoctorProfile");
    	 DoctorProfilePage dpp=new DoctorProfilePage();
    	 dpp.clickDoctorProfile();
    	 logger.info("Clicked doctor profile");
    	// dpp.enterDoctorName();
    	 logger.info("Entered doctor Name");
    	 dpp.enterDoctorGender();
    	 logger.info("Entered doctor Gender");
    	 dpp.clearDoctorDateOfBirth();
    	 logger.info("Cleared Doctor DOB");
    	 dpp.enterDoctorDateOfBirth();
    	 logger.info("Entered doctor DOB");
    	 dpp.clearDoctorQualification();
    	 logger.info("Cleared doctor Qualification");
    	 dpp.enterDoctorQualification();
    	 logger.info("Entered doctor Qualification");
    	 dpp.clearDoctorEmail();
    	 logger.info("Cleared doctor Email");
    	 dpp.enterDoctorEmail();
    	 logger.info("Entered doctor Email");
    	 dpp.clearDoctorMobileNumber();
    	 logger.info("Cleared doctor Phno");
    	 dpp.enterDoctorMobileNumber();
    	 logger.info("Entered doctor Phno");
    	 dpp.clearHospitalName();
    	 logger.info("Cleared Hospital Name");
    	 dpp.enterHospitalName();
    	 logger.info("Entered Hospital Name");
    	 dpp.clearHospitalPhno();
    	 logger.info("Cleared Hospital Phno");
    	 dpp.enterHospitalPhno();
    	 logger.info("Entered Hospital Phno");
    	 dpp.clearHospitalFax();
    	 logger.info("Cleared Hospital Fax");
    	// dpp.enterHospitalFax();
    	 logger.info("Entered Hospital Fax");
    	 dpp.clearHospitalAddress();
    	 logger.info("Cleared Hospital Address");
    	 dpp.enterHospitalAddress();
    	 logger.info("Entered Hospital Address");
    	 dpp.clearHospitalCity();
    	 logger.info("Cleared Hospital City");
    	 dpp.enterHospitalCity();
    	 logger.info("Entered Hospital City");
    	 dpp.clearHospitalState();
    	 logger.info("Cleared Hospital State");
    	 dpp.enterHospitalState();
    	 logger.info("Entered Hospital State");
    	 dpp.clearHospitalPincode();
    	 logger.info("Cleared Hospital Pincode");
    	 dpp.enterHospitalPincode();
    	 logger.info("Entered Hospital Pincode");
    	 dpp.clickSaveChangesBtn();
    	 logger.info("Clicked SaveChanges Btn");
    	 Thread.sleep(5000);
    	 
    	 String Actual = getWebElement("updateSuccessMessage").getText();
    	 String Expected = "Profile Update Successful!";
    	 
    	 Assert.assertEquals(Actual, Expected);
    	 logger.info("Assertion Passed");
    	 
    	 dpp.clickUpdateSuccessOk();
    	 logger.info("Clicked Update Success OK Btn");
     }
     
     @AfterClass
     public void closeBrowser() {
    	 driver.close();
    	 reports.endTest(test);
    	 reports.flush();
     }
}
