package pages;

import genericPages.CommonMethod;

public class HomePageAppointment extends CommonMethod{
	
	public HomePageAppointment() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickPlusSigns() {
		 click("homePageAppPlusSign");
	}

	public void enterFirstName1() {
		enterData("appFirstName","patient_FirstName1");
	}
	
	public void enterFirstName2() {
		enterData("appFirstName","patient_FirstName2");
	}
	
	public void clearFirstName() {
		clearData("appFirstName");
	}

	public void enterLastName1() {
		enterData("appLastName","patient_LastName1");
	}
	
	public void enterLastName2() {
		enterData("appLastName","patient_LastName2");
	}
	
	public void clearLastName() {
		clearData("appLastName");
	}


	public void enterVisitReasonField1() {
		enterData("appVisitReason","patient_VisitReason1");
	}
	
	public void enterVisitReasonField2() {
		enterData("appVisitReason","patient_VisitReason2");
	}

	public void enterPhno1() {
		enterData("appPhno","valied_PhoneNo1");
	}
	
	public void enterPhno2() {
		enterData("appPhno","valied_PhoneNo2");
	}
	
	public void clearPhno() {
		clearData("appPhno");
	}
	
	public void clickDateAndTime() {
		click("appDateAndTime");
	}
	
	public void clickDatePick() {
		click("appDatePick");
	}

	public void clickTimePick() {
		click("appTimePick");
	}
	
	public void clickDuration() {
		click("appDuration");
	}
	
	public void clickAddAppointmentBtn() {
		base.waitForElementToBeClickable("AddAppointment", 10);
		click("AddAppointment");
	}

	public void clickCancelAppointment() {
		base.waitForElementToBeClickable("homePageAppCancelBtn", 10);
		 click("homePageAppCancelBtn");
	}

	public void clickEditAppointment() {
		base.waitForElementToBeClickable("homepageEditAppointment", 10);
		 click("homepageEditAppointment");
	}

	public void clickUpdateButton() {
		base.waitForElementToBeClickable("homePageAppUpdateBtn", 10);
		click("homePageAppUpdateBtn");
	}
	
	public void clickDeleteAppointment() {
		base.waitForElementToBeClickable("homePageDeleteAppointment", 10);
		 click("homePageDeleteAppointment");
	}

	public void clickSMSReminder() {
		base.waitForElementToBeClickable("homePageAppSendSMS", 10);
		click("homePageAppSendSMS");
	}
	
	public String verifyNotification(String text) throws Exception  {
		verifyElementPresent("notification");
		base.waitForElementVisibility("notification", 10);
		verifyTextPresent("notification");
		return text;
	}

	public void clickCancelNotification() {
		base.waitForElementToBeClickable("cancelNotification", 10);
		click("cancelNotification");
	}
	
	public boolean verifyErrorMsg() throws Exception {
		verifyElementPresent("homePageAppErrorMsg");
		return true;
	}

	
	
}

