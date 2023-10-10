package pages;

import genericPages.CommonMethod;

public class PatientVisitPage extends CommonMethod {

	public PatientVisitPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getPatientsClick() throws Exception {
		scrollTillElement();
		click("patientMenu");
	}

	public void getPatientvisitClick() throws Exception {
		click("patientVisitClick");
	}

	public void getPatientVisitName() throws Exception {
		enterData("patientName", "valid_PatientName");
	}

	public void getpatientVisitNameSuggestions() throws Exception {
		click("patientVisitNameSugg");
	}

	public void getPrimaryComplaint() throws Exception {
		scrollTillElement();
		enterData("patientVisitPrimaryComplaint", "primaryComplaint");
	}

	public void clearPrimaryComplaint() throws Exception {
		scrollTillElement();
		clearData("patientVisitPrimaryComplaint");
	}

	public void getClickingSymptomsPlusSign() throws Exception {
		Thread.sleep(1000);
		click("patientVisitSymptomsPlusSign");
	}

	public void getSymptoms1() throws Exception {
		enterData("patientVisitSymptoms", "symptoms1");
	}

	public void getSymptoms2() throws Exception {
		enterData("patientVisitSymptoms", "symptoms2");
	}

	public void getsymptomsDelete() throws Exception {
		Thread.sleep(1000);
		click("patientVisitSymptomsCancel");
	}

	public void getbloodPressure() throws Exception {
		enterData("patientVisitBP", "bloodPressure");
	}

	public void getsugarLevel() throws Exception {
		enterData("patientVisitSugarLevel", "sugarLevel");
	}

	public void getheartRate() throws Exception {
		enterData("patientVisitHeartRate", "heartRate");
	}

	public void getInvestigationTests1() throws Exception {
		enterData("patientVisitInvestigations", "investigations1");
	}

	public void getInvestigationTests2() throws Exception {
		enterData("patientVisitInvestigations", "investigations2");
	}

	public void getClickingInvestigationPlusSign() throws Exception {
		click("patientVisitInvestigationsPlusSign");
	}

	public void getinvestigationDelete() throws Exception {
		click("patientVisitInvestigationsCancel");
	}

	public void getclinicalObservation() throws Exception {
		enterData("patientVisitClinicalObservation", "Clinical_Observation");
	}

	public void getdiagnosisRemark() throws Exception {
		enterData("patientVisitRemarks", "Remarks");
	}

	public void uploadFile() throws Exception {
		scrollDown();
		enterLocationproperty("patientVisitFileUpload", "fileUpload");
		//base.waitForElementVisibility("patientVisitFileUpload", 10);
		//enterData("patientVisitFileUpload", "demotxtUpload");
	}

	public void deleteUploadedFile() throws Exception {
		click("patientVisitFileDelete");
	}

	public void getSaveButton() throws Exception {
		scrollDown();
		Thread.sleep(1000);
		click("patientVisitSave");
	}

	public void getFollowup() throws Throwable {
		click("patientVisitFollowUp");
	}

	public void getAddAppointment() throws Exception {
		click("followUpAddAppointment");
	}

	public void getVisitReason() throws Exception {
		enterData("followVisitReason", "patient_VisitReason1");
	}

	public void getaddNewPatientHyperLink() throws Exception {
		click("addNewPatientHyperlink");
	}

	public void getDateAndTimePickFollowUp() throws Exception {
		scrollDown();
		click("followUpDateAndTime");
	}

	public void getdatePickFollowUp() throws Exception {
		click("followUpDatePick");
	}

	public void gettimePickFollowUp() throws Exception {
		click("followUpTimePick");
	}

	public void getcancelBtn() throws Exception {
		click("followUpCancel");
	}

	public boolean verifyPatientVisitPage() throws Exception {
		verifyElementPresent("addpatientPage");
		return true;
	}

	public String verifyNotification(String text) throws Exception {
		verifyElementPresent("notification");
		verifyTextPresent("notification");
		return text;
	}

	public void clickCancelNotification() throws Exception {
		click("cancelNotification");
	}

}
