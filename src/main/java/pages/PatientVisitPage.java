package pages;

import org.openqa.selenium.WebElement;

import genericPages.CommonMethod;

public class PatientVisitPage extends CommonMethod {

	public PatientVisitPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getPatientsClick() throws Exception {
		scrollTillElement("patientMenu");
		base.waitForElementToBeClickable("patientMenu", 10);
		click("patientMenu");
	}

	public void getPatientvisitClick() {
		click("patientVisitClick");
	}

	public void getPatientVisitName() {
		enterData("patientVisitName", "valied_PatientName");
	}

	public void getpatientVisitNameSuggestions() {
		click("patientVisitNameSugg");
	}

	public void getPrimaryComplaint() throws Exception {
		scrollTillElement("patientVisitPrimaryComplaint");
		base.waitForElementVisibility("patientVisitPrimaryComplaint", 10);
		enterData("patientVisitPrimaryComplaint", "primaryComplaint");
	}

	public void getClickingSymptomsPlusSign() {
		base.waitForElementToBeClickable("patientVisitSymptomsPlusSign", 10);
		click("patientVisitSymptomsPlusSign");
	}

	public void getSymptoms1() {
		enterData("patientVisitSymptoms", "symptoms1");
	}

	public void getSymptoms2() {
		enterData("patientVisitSymptoms", "symptoms2");
	}

	public void getsymptomsDelete() {
		base.waitForElementToBeClickable("patientVisitSymptomsCancel", 10);
		click("patientVisitSymptomsCancel");
	}

	public void getbloodPressure() {
		enterData("patientVisitBP", "bloodPressure");
	}

	public void getsugarLevel() {
		enterData("patientVisitSugarLevel", "sugarLevel");
	}

	public void getheartRate() {
		enterData("patientVisitHeartRate", "heartRate");
	}

	public void getInvestigationTests1() {
		enterData("patientVisitInvestigations", "investigations1");
	}

	public void getInvestigationTests2() {
		enterData("patientVisitInvestigations", "investigations2");
	}

	public void getClickingInvestigationPlusSign() {
		base.waitForElementToBeClickable("patientVisitInvestigationsPlusSign", 10);
		click("patientVisitInvestigationsPlusSign");
	}

	public void getinvestigationDelete() {
		click("patientVisitInvestigationsCancel");
	}

	public void getclinicalObservation() {
		enterData("patientVisitClinicalObservation", "Clinical_Observation");
	}

	public void getdiagnosisRemark() {
		base.waitForElementVisibility("patientVisitRemarks", 10);
		enterData("patientVisitRemarks", "Remarks");
	}

	public void uploadFile() {
		scrollDown();
		//click("patientVisitFileUpload");
		base.waitForElementVisibility("patientVisitFileUpload", 10);
		enterData("patientVisitFileUpload", "fileUpload");
		base.waitForElementVisibility("patientVisitFileUpload", 10);
		enterData("patientVisitFileUpload", "demotxtUpload");
	}
	
	

	public void getSaveButton() throws InterruptedException {
		scrollDown();
		base.waitForElementToBeClickable("patientVisitSave", 10);
		Thread.sleep(1000);
		click("patientVisitSave");
	}

	public void getFollowup() {
		base.waitForElementToBeClickable("patientVisitFollowUp", 10);
		click("patientVisitFollowUp");
	}

	public void getAddAppointment() {
		click("followUpAddAppointment");
	}

	public void getVisitReason() {
		enterData("followVisitReason", "patient_VisitReason1");
	}

	public void getaddNewPatientHyperLink() {
		click("addNewPatientHyperlink");
	}

	public void getDateAndTimePickFollowUp() throws InterruptedException {
		scrollDown();
		base.waitForElementToBeClickable("followUpDateAndTime", 10);
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

	public boolean verifyPatientVisitPage() throws Exception {
		verifyElementPresent("addpatientPage");
		return true;
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
