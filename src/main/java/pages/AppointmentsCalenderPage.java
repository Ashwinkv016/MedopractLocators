package pages;

import genericPages.CommonMethod;

public class AppointmentsCalenderPage extends CommonMethod {

	public AppointmentsCalenderPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getClickAppointmentCalender() {
		scrollTillElement();
		base.waitForElementVisibility("appointmentsMenu", 10);
		click("appointmentsMenu");
	}

	public void getNewAppointment() {
		click("appointmentsCalenderNewApp");
	}

	public void getFirstNameField1() {
		enterData("appCalenderFirstname", "patient_FirstName2");
	}

	public void getFirstNameField2() {
		enterData("appCalenderFirstname", "patient_FirstName1");
	}

	public void clearFirstNameField() {
		clearData("appCalenderFirstname");
	}

	public void clearUpdateFirstNameField() {
		clearData("appCalenderUpdateFirstName");
	}

	public void enterUpdateFirstNameField() {
		enterData("appCalenderUpdateFirstName", "patient_FirstName2");
	}

	public void getLastNameField1() {
		enterData("appCalenderLastName", "patient_LastName1");
	}

	public void getLastNameField2() {
		enterData("appCalenderLastName", "patient_LastName2");
	}

	public void clearLastNameField() {
		clearData("appCalenderLastName");
	}

	public void getVisitreasonField1() {
		enterData("appCalenderVisitReason", "patient_VisitReason1");
	}

	public void getVisitreasonField2() {
		enterData("appCalenderVisitReason", "patient_VisitReason2");
	}

	public void clearVisitreasonField() {
		clearData("appCalenderVisitReason");
	}

	public void getContactNumberField1() {
		enterData("appCalenderPhno", "valied_PhoneNo1");
	}

	public void getContactNumberField2() {
		enterData("appCalenderPhno", "valied_PhoneNo2");
	}

	public void clearContactNumberField() {
		clearData("appCalenderPhno");
	}

	public void getdateAndTimeField() {
		click("appCalenderDateAndTime");
	}

	public void getdatePick() {
		click("appDatePick");
	}

	public void gettimePick() {
		click("appTimePick");
	}

	public void getDurationField() {
		selectDropdown("appDuration", "appDuration");
	}

	public void getSaveAppointmentButton() {
		base.waitForElementToBeClickable("appointmentCalenderSaveApp", 10);
		click("appointmentCalenderSaveApp");
	}

	public void getMonthButton() {
		base.waitForElementToBeClickable("appCalenderMonthBtn", 10);
		click("appCalenderMonthBtn");
	}

	public void getWeekButton() {
		base.waitForElementToBeClickable("appCalenderWeekBtn", 10);
		click("appCalenderWeekBtn");
	}

	public void getDayButton() {
		base.waitForElementToBeClickable("appCalenderDayBtn", 10);
		click("appCalenderDayBtn");
	}

	public void getAgendaButton() {
		base.waitForElementToBeClickable("appCalenderAgendaBtn", 10);
		click("appCalenderAgendaBtn");
	}

	public void getTodayButton() {
		click("appCalenderTodayBtn");
	}

	public void getBackButton() {
		click("appCalenderBackBtn");
	}

	public void getNextButton() {
		click("appCalenderNextBtn");
	}

	public void getExistingAppointment() throws InterruptedException {
		scrollDown();
		base.waitForElementToBeClickable("appCalenderExistingApp", 10);
		click("appCalenderExistingApp");
	}

	public void getUpdatedExistingAppointment() {
		base.waitForElementToBeClickable("appCalenderUpdateExistingApp", 10);
		click("appCalenderUpdateExistingApp");
	}

	public void getagendaExistingAppointment() {
		click("appCalenderAgendaexistingApp");
	}

	public void getcancelExistingAppointment() {
		click("appCalenderCancelExistingApp");
	}

	public String verifyNotification(String text) throws Exception {
		verifyElementPresent("notification");
		base.waitForElementVisibility("notification", 10);
		verifyTextPresent("notification");
		return text;
	}

	public void clickCancelNotification() {
		base.waitForElementToBeClickable("cancelNotification", 10);
		click("cancelNotification");
	}

}
