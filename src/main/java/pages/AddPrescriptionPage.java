package pages;

import genericPages.CommonMethod;

public class AddPrescriptionPage extends CommonMethod {

	public AddPrescriptionPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getclickPrescription() {
		scrollTillElement("prescriptionMenu");
		base.waitForElementToBeClickable("prescriptionMenu", 10);
		click("prescriptionMenu");
	}

	public void getPatientNameField() {
		enterData("prescriptionPatientName", "valied_PatientName");
	}

	public void getpatientNameSuggestion() {
		click("prescriptionNameFieldSugg");
	}

	public void getEmailField() {
		enterData("prescriptionEmail", "emailId");
	}

	public void getClickingPlusSign() {
		base.waitForElementVisibility("prescriptionMedicineplus", 10);
		click("prescriptionMedicineplus");
	}

	public void getMedicineNameField1() throws InterruptedException {
		scrollDown();
		base.waitForElementVisibility("prescriptionMedicineName", 10);
		enterData("prescriptionMedicineName", "medicineName1");
	}

	public void getMedicineNameField2() throws InterruptedException {
		scrollDown();
		base.waitForElementVisibility("prescriptionMedicineName", 10);
		enterData("prescriptionMedicineName", "medicineName2");
	}

	public void getTotalNumberDays1() {
		enterData("prescriptionDaysInput", "noOfDays1");
	}

	public void getTotalNumberDays2() {
		enterData("prescriptionDaysInput", "noOfDays2");
	}

	public void getTimingsInput1() {
		enterData("prescriptionTimings", "instructions1");
	}

	public void getTimingsInput2() {
		enterData("prescriptionTimings", "instructions2");
	}

	public void getAmountInput1() {
		enterData("prescriptionAmountInput", "amountToTake1");
	}

	public void getAmountInput2() {
		enterData("prescriptionAmountInput", "amountToTake2");
	}

	public void getSaveAndPrintButton() throws Exception {
		scrollDown();
		base.waitForElementToBeClickable("PrescriptionsaveAndPrintBtn", 10);
		click("PrescriptionsaveAndPrintBtn");
	}

	public void getBackButton() {
		base.waitForElementToBeClickable("addPrescriptionsBackBtn", 10);
		click("addPrescriptionsBackBtn");
	}

	public void getyesButtonField() {
		click("prescriptionSaveYesBtn");
	}

	public void getprescriptionBackBtn() {
		base.waitForElementToBeClickable("prescriptionBackBtn", 10);
		click("prescriptionBackBtn");
	}

	public void getprintPrescription() {
		click("printPrescriptionBtn");
	}

	public void getdownloadPrescription() {
		alertHandling();
		base.waitForElementToBeClickable("downloadPrescriptionBtn", 10);
		click("downloadPrescriptionBtn");
	}

	public void getdeleteMedicineField() {
		base.waitForElementToBeClickable("prescriptionDeleteMedicine", 10);
		click("prescriptionDeleteMedicine");
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
}
