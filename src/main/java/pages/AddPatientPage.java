package pages;

import genericPages.CommonMethod;

public class AddPatientPage extends CommonMethod {

	public AddPatientPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickPatientMenu() throws Exception {
		scrollTillElement();
		click("patientMenu");
	}

	public void clickAddPatient() throws Exception {
		click("addPatientClick");
	}

	public void enterValiedPatientName() throws Exception {
		enterData("patientName", "valid_PatientName");
	}
	
	public void enterPatientName() throws Exception {
		enterData("patientName", "valid_PatientName");
	}

	public void enterInValiedPatientName() throws Exception {
		scrollTillElement();
		enterData("patientName", "invalid_PatientName");
	}

	public void clearPatientName() throws Exception {
		scrollTillElement();
		clearData("patientName");
	}
	
	public void clickPatientNameSuggestion() throws Exception {
		click("addPatientNameSugg");
	}

	public void enterValiedPhoneNo() throws Exception {
		Thread.sleep(3000);
		enterData("patientPhno", "valid_PhoneNo1");
	}

	public void clearPhoneNo() throws Exception {
		Thread.sleep(3000);
		clearData("patientPhno");
	}

	public void enterInValiedPhoneNo() throws Exception {
		enterData("patientPhno", "invalid_PhoneNo");
	}
	
	public void enterInValiedPhoneNo1() throws Exception {
		enterData("patientPhno", "invalid_PhoneNo1");
	}
	
	public void enterInValiedPhoneNo2() throws Exception {
		enterData("patientPhno", "invalid_PhoneNo2");
	}

	public void clickGenderField() throws Exception {
		selectDropdown("patientgender", "patientGender");
	}

	public void clickBirthDateField() throws Exception {
		click("patientBirthDateField");
	}

	public void enterMonthField() throws Exception {
		enterData("patientBmonth", "patient_Month");
	}

	public void enterDateField() throws Exception {
		enterData("patientBdate", "patient_Day");
	}

	public void enterYearfield() throws Exception {
		enterData("patientByear", "patient_Year");
	}

	public void clickBloodGroup() throws Exception {
		selectDropdown("patientBloodGroup", "patientBloodGroup");
	}

	public void enterOccupation() throws Exception {
		enterData("patientOccupation", "patient_Occupation");
	}

	public void enterAddress() throws Exception {
		enterData("patientAddress", "patient_Address");
	}

	public void clearAddress() throws Exception {
		clearData("patientAddress");
	}

	public void enterEmergencyPhno() throws Exception {
		enterData("patientEmerPhno", "valid_PhoneNo1");
	}

	public void clearEmergencyPhno() throws Exception {
		clearData("patientEmerPhno");
	}
	
	public void clickTakePhoto() throws Exception {
		Thread.sleep(2000);
		click("takePhoto");
	}
	
	public void clickCapturePhoto() throws Exception {
		Thread.sleep(2000);
		click("capturePhoto");
	}

	public void enterAllergy() throws Exception {
		scrollDown();
		enterData("patientAllergies", "patient_Allergy");
	}

	public void enterRemarks() throws Exception {
		scrollDown();
		enterData("patientRemarks", "patient_Remark");
	}

	public void enterHistory() throws Exception {
		enterData("patientHistory", "patient_History");
	}

	public void enterhabits1() throws Exception {
		enterData("patientHabits", "patient_Habit1");
	}

	public void enterhabits2() throws Exception {
		enterData("patientHabits", "patient_Habit2");
	}

	public void clickHabitsPlus() throws Exception {
		click("habitsPlusBtn");
	}

	public void clickHabitsCancel() throws Exception {
		click("habitsCancelBtn");
	}

	public void clickPatientSaveBtn() throws Exception {
		scrollDown();
		Thread.sleep(1000);
		click("patientSaveBtn");
	}

	public void clickPatientResetBtn() throws Exception {
		scrollDown();
		click("patientResetBtn");
	}

	public String verifyNotification(String text) throws Exception {
		verifyElementPresent("notification");
		verifyTextPresent("notification");
		return text;
	}

	public void clickCancelNotification() throws Exception {
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