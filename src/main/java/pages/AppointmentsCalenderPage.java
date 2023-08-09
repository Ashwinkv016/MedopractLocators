package pages;

import genericPages.CommonMethod;

public class AppointmentsCalenderPage extends CommonMethod{

	
	public AppointmentsCalenderPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getNewAppointment() {
		 click("appointmentsCalenderNewApp");
	}

	public void getClickAppointmentCalender() {
		click("appointmentsMenu");
	}

	public void getFirstNameField1() {
		enterData("appFirstName","patient_FirstName2");
	}
	
	public void getFirstNameField2() {
		enterData("appFirstName","patient_FirstName1");
	}
	
	public void clearFirstNameField() {
		clearData("appFirstName");
	}

	public void getLastNameField1() {
        enterData("appLastName","patient_LastName1");
	}
	
	public void getLastNameField2() {
        enterData("appLastName","patient_LastName2");
	}
	
	public void clearLastNameField() {
        clearData("appLastName");
	}

	public void getVisitreasonField1() {
		enterData("appVisitReason","patient_VisitReason1");
	}
	
	public void getVisitreasonField2() {
		enterData("appVisitReason","patient_VisitReason2");
	}
	
	public void clearVisitreasonField() {
		clearData("appVisitReason");
	}

	public void getContactNumberField1() {
		enterData("appPhno","valied_PhoneNo1");
	}
	
	public void getContactNumberField2() {
		enterData("appPhno","valied_PhoneNo2");
	}
	
	public void clearContactNumberField() {
		clearData("appPhno");
	}
	
	public void getdateAndTimeField() {
		 click("appDateAndTime");
	}
	
	public void getdatePick() {
		click("appDatePick");
	}
	
	public void gettimePick() {
		 click("appTimePick");
	}
	
	public void getDurationField() {
		click("appDuration");
	}

	public void getSaveAppointmentButton() {
	   click("appointmentCalenderSaveApp");
	}

	public void getMonthButton() {
		 click("appCalenderMonthBtn");
	}

	public void getWeekButton() {
		 click("appCalenderWeekBtn");
	}

	public void getDayButton() {
		 click("appCalenderDayBtn");
	}

	public void getAgendaButton() {
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

	public void getExistingAppointment() {
		 click("appCalenderExistingApp");
	}
	
	public void getUpdatedExistingAppointment() {
		click("appCalenderUpdateExistingApp");
	}
	
	
	public void getagendaExistingAppointment() {
		click("appCalenderAgendaexistingApp");
	}
	
	public void getcancelExistingAppointment() {
        click("appCalenderCancelExistingApp");
	}

	
	
}
