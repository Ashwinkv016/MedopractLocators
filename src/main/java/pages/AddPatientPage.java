package pages;

import genericPages.CommonMethod;

public class AddPatientPage extends CommonMethod {

	public AddPatientPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickPatientMenu() throws Exception {
		scrollTillElement("patientMenu");
		base.waitForElementVisibility("patientMenu", 10);
		click("patientMenu");
	}

	public void clickAddPatient() {
		base.waitForElementToBeClickable("addPatientClick", 10);
		click("addPatientClick");
	}

	public void enterValiedPatientName() throws Exception {
		enterData("patientName", "valied_PatientName");
	}

	public void enterInValiedPatientName() {
		scrollTillElement("patientName");
		base.waitForElementVisibility("patientName", 10);
		enterData("patientName", "invalied_PatientName");
	}

	public void clearPatientName() {
		clearData("patientName");
	}

	public void enterValiedPhoneNo() throws InterruptedException {
		Thread.sleep(2000);
		enterData("patientPhno", "valied_PhoneNo1");
	}

	public void clearPhoneNo() {
		clearData("patientPhno");
	}

	public void enterInValiedPhoneNo() {
		enterData("patientPhno", "invalied_PhoneNo");
	}

	public void clickGenderField() {
		base.waitForElementVisibility("patientgender", 10);
		selectDropdown("patientgender","patientGender");
	}

	public void clickBirthDateField() {
		click("patientBirthDateField");
	}

	public void enterMonthField() {
		base.waitForElementVisibility("patientBmonth", 10);
		enterData("patientBmonth", "patient_Month");
	}

	public void enterDateField() {
		base.waitForElementVisibility("patientBdate", 10);
		enterData("patientBdate", "patient_Day");
	}

	public void enterYearfield() {
		base.waitForElementVisibility("patientByear", 10);
		enterData("patientByear", "patient_Year");
	}

	public void clickBloodGroup() {
		base.waitForElementVisibility("patientBloodGroup", 10);
		selectDropdown("patientBloodGroup","patientBloodGroup");
	}

	public void enterOccupation() throws InterruptedException {
		enterData("patientOccupation", "patient_Occupation");
	}

	public void enterAddress() {
		enterData("patientAddress", "patient_Address");
	}

	public void clearAddress() {
		clearData("patientAddress");
	}

	public void enterEmergencyPhno() {
		enterData("patientEmerPhno", "EmergencyPhno");
	}

	public void clearEmergencyPhno() {
		clearData("patientEmerPhno");
	}

	public void enterAllergy() throws InterruptedException {
		scrollDown();
		base.waitForElementVisibility("patientAllergies", 10);
		enterData("patientAllergies", "patient_Allergy");
	}

	public void enterRemarks() throws InterruptedException {
		scrollDown();
		base.waitForElementVisibility("patientRemarks", 10);
		enterData("patientRemarks", "patient_Remark");
	}

	public void enterHistory() {
		enterData("patientHistory", "patient_History");
	}

	public void enterhabits1() {
		enterData("patientHabits", "patient_Habit1");
	}

	public void enterhabits2() {
		enterData("patientHabits", "patient_Habit2");
	}

	public void clickHabitsPlus() {
		click("habitsPlusBtn");
	}

	public void clickHabitsCancel() {
		click("habitsCancelBtn");
	}

	public void clickPatientSaveBtn() throws InterruptedException {
		scrollDown();
		base.waitForElementToBeClickable("patientSaveBtn", 10);
		click("patientSaveBtn");
	}

	public void clickPatientResetBtn() throws Exception {
		base.waitForElementToBeClickable("patientResetBtn", 10);
		click("patientResetBtn");
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

	public String verifyPatientNameErrorMsg(String text) throws Exception {
		verifyElementPresent("patientNameErrorMsg");
		Thread.sleep(1000);
		verifyTextPresent("patientNameErrorMsg");
		return text;
	}

	public String verifyPatientPhnoErrorMsg(String text) throws Exception {
		verifyElementPresent("patientPhnoErrorMsg");
		Thread.sleep(1000);
		verifyTextPresent("patientPhnoErrorMsg");
		return text;
	}

}