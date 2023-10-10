package pages;

import genericPages.CommonMethod;

public class HomePageAppointment extends CommonMethod{
	
	public HomePageAppointment() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickPlusSigns() throws Exception {
		 click("homePageAppPlusSign");
	}

	public void enterFirstName1() throws Exception {
		enterData("appFirstName","patient_FirstName1");
	}
	
	public void enterFirstName2() throws Exception {
		enterData("appFirstName","patient_FirstName2");
	}
	
	public void clearFirstName() throws Exception {
		clearData("appFirstName");
	}

	public void enterLastName1() throws Exception {
		enterData("appLastName","patient_LastName1");
	}
	
	public void enterLastName2() throws Exception {
		enterData("appLastName","patient_LastName2");
	}
	
	public void clearLastName() throws Exception {
		clearData("appLastName");
	}


	public void enterVisitReasonField1() throws Exception {
		enterData("appVisitReason","patient_VisitReason1");
	}
	
	public void enterVisitReasonField2() throws Exception {
		enterData("appVisitReason","patient_VisitReason2");
	}

	public void enterPhno1() throws Exception {
		enterData("appPhno","valid_PhoneNo2");
	}
	
	public void enterPhno2() throws Exception {
		enterData("appPhno","valid_PhoneNo1");
	}
	
	public void clearPhno() throws Exception {
		clearData("appPhno");
	}
	
	public void clickDateAndTime() throws Exception {
		click("appDateAndTime");
	}
	
	public void clickDatePick() throws Exception {
		click("appDatePick");
	}

	public void clickTimePick() throws Exception {
		click("appTimePick");
	}
	
	public void clickDuration() throws Exception {
		click("appDuration");
	}
	
	public void clickAddAppointmentBtn() throws Exception {
		click("AddAppointment");
	}

	public void clickCancelAppointment() throws Exception {
		 click("homePageAppCancelBtn");
	}

	public void clickEditAppointment() throws Exception {
		 click("homepageEditAppointment");
	}

	public void clickUpdateButton() throws Exception {
		click("homePageAppUpdateBtn");
	}
	
	public void clickDeleteAppointment() throws Exception {
		 click("homePageDeleteAppointment");
	}

	public void clickSMSReminder() throws Exception {
		click("homePageAppSendSMS");
	}
	
	public String verifyNotification(String text) throws Exception  {
		verifyElementPresent("notification");
		verifyTextPresent("notification");
		return text;
	}

	public void clickCancelNotification() throws Exception {
		click("cancelNotification");
	}
	
	public boolean verifyErrorMsg() throws Exception {
		verifyElementPresent("homePageAppErrorMsg");
		return true;
	}	
}

