package pages;

import genericPages.CommonMethod;

public class AppointmentsCalenderPage extends CommonMethod {


	public AppointmentsCalenderPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getClickAppointmentCalender() throws Exception {
		scrollTillElement();
		click("appointmentsMenu");
	}

	public void getNewAppointment() throws Exception {
		click("appointmentsCalenderNewApp");
	}

	public void getFirstNameField1() throws Exception {
		enterData("appCalenderFirstname", "patient_FirstName2");
	}

	public void getFirstNameField2() throws Exception {
		enterData("appCalenderFirstname", "patient_FirstName1");
	}

	public void clearFirstNameField() throws Exception {
		clearData("appCalenderFirstname");
	}

	public void clearUpdateFirstNameField() throws Exception {
		clearData("appCalenderUpdateFirstName");
	}

	public void enterUpdateFirstNameField() throws Exception {
		enterData("appCalenderUpdateFirstName", "patient_FirstName2");
	}

	public void getLastNameField1() throws Exception {
		enterData("appCalenderLastName", "patient_LastName1");
	}

	public void getLastNameField2() throws Exception {
		enterData("appCalenderLastName", "patient_LastName2");
	}

	public void clearLastNameField() throws Exception {
		clearData("appCalenderLastName");
	}

	public void getVisitreasonField1() throws Exception {
		enterData("appCalenderVisitReason", "patient_VisitReason1");
	}

	public void getVisitreasonField2() throws Exception {
		enterData("appCalenderVisitReason", "patient_VisitReason2");
	}

	public void clearVisitreasonField() throws Exception {
		clearData("appCalenderVisitReason");
	}

	public void getContactNumberField1() throws Exception {
		enterData("appCalenderPhno", "valid_PhoneNo1");
	}

	public void getContactNumberField2() throws Exception {
		enterData("appCalenderPhno", "valid_PhoneNo2");
	}

	public void clearContactNumberField() throws Exception {
		clearData("appCalenderPhno");
	}

	public void getdateAndTimeField() throws Exception {
		click("appCalenderDateAndTime");
	}

	public void getdatePick() throws Exception {
		click("appDatePick");
	}

	public void gettimePick() throws Exception {
		click("appTimePick");
	}

	public void getDurationField() throws Exception {
		selectDropdown("appDuration", "appDuration");
	}

	public void getSaveAppointmentButton() throws Exception {
		click("appointmentCalenderSaveApp");
	}

	public void getMonthButton() throws Exception {
		click("appCalenderMonthBtn");
	}

	public void getWeekButton() throws Exception {
		click("appCalenderWeekBtn");
	}

	public void getDayButton() throws Exception {
		click("appCalenderDayBtn");
	}

	public void getAgendaButton() throws Exception {
		click("appCalenderAgendaBtn");
	}

	public void getTodayButton() throws Exception {
		Thread.sleep(1000);
		click("appCalenderTodayBtn");
	}

	public void getBackButton() throws Exception {
		Thread.sleep(1000);
		click("appCalenderBackBtn");
	}

	public void getNextButton() throws Exception {
		Thread.sleep(1000);
		click("appCalenderNextBtn");
	}

	public void getExistingAppointment1() throws Exception {
		base.waitForElementVisibility1("appCalenderExistingApp", 30);
	//	scrollDown();
		Thread.sleep(2000);
		click("appCalenderExistingApp");
	}

	public void getExistingAppointment2() throws Exception {
		base.waitForElementVisibility1("appCalenderExistingApp", 30);
		//scrollDown();
		Thread.sleep(2000);
		click("appCalenderExistingApp");
	}

	public void getagendaExistingAppointment() throws Exception {
		click("appCalenderAgendaexistingApp");
	}

	public void getcancelExistingAppointment() throws Exception {
		Thread.sleep(1000);
		click("appCalenderCancelExistingApp");
	}

	public String verifyNotification(String text) throws Exception {
		verifyTextPresent("notification");
		return text;
	}

	public void clickCancelNotification() throws Exception {
		click("cancelNotification");
	}

}
