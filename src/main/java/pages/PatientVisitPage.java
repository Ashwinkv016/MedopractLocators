package pages;

import genericPages.CommonMethod;

public class PatientVisitPage extends CommonMethod{

	public PatientVisitPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getPatientsClick() {
		click("patientMenu");
		 }
	

	public void getPatientvisitClick() {
		click("patientVisitClick");
	}

	public void getPatientVisitName() {
         enterData("patientVisitName","valied_PatientName");
	}

	public void getpatientVisitNameSuggestions() {
		 click("patientVisitNameSugg");
	}

	public void getPrimaryComplaint() {
         enterData("patientVisitPrimaryComplaint","primaryComplaint");
	}

	public void getClickingSymptomsPlusSign() {
		 click("patientVisitSymptomsPlusSign");
	}

	public void getSymptoms1() {
          enterData("patientVisitSymptoms","symptoms1");
	}
	
	public void getSymptoms2() {
        enterData("patientVisitSymptoms","symptoms2");
	}

	public void getsymptomsDelete() {
		  click("patientVisitSymptomsCancel");
	}

	public void getbloodPressure() {
		 enterData("patientVisitBP","bloodPressure");
	}

	public void getsugarLevel() {
		 enterData("patientVisitSugarLevel","sugarLevel");
	}

	public void getheartRate() {
		 enterData("patientVisitHeartRate","heartRate");
	}

	public void getInvestigationTests1() {
		 enterData("patientVisitInvestigations","investigations1");
	}
	
	public void getInvestigationTests2() {
		 enterData("patientVisitInvestigations","investigations2");
	}

	public void getClickingInvestigationPlusSign() {
		click("patientVisitInvestigationsPlusSign");
	}

	public void getinvestigationDelete() {
		click("patientVisitInvestigationsCancel");
	}
	public void getclinicalObservation(){
		enterData("patientVisitClinicalObservation","Clinical_Observation");
	}

	public void getdiagnosisRemark() {
		enterData("patientVisitRemarks","Remarks");
	}

	public void getSaveButton() {
		click("patientVisitSave");
	}

	public void getFollowup() {
		click("patientVisitFollowUp");
	}

	public void getAddAppointment() {
		 click("followUpAddAppointment");
	}

	public void getVisitReason() {
		enterData("followVisitReason","patient_VisitReason1");
	}

	public void getaddNewPatientHyperLink() {
		 click("addNewPatientHyperlink");
	}	
	
	public void getDateAndTimePickFollowUp() {
		 click("followUpDateAndTime");
	}
	
	public void getdatePickFollowUp() {
		 click("followUpDatePick");
	}
	
	public void gettimePickFollowUp() {
		click("followUpTimePick");
	}
	
	public void getcancelBtn() {
		click("followUpCancel");
	}
	
}
