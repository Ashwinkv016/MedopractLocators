package pages;

import genericPages.CommonMethod;

public class AddPrescriptionPage extends CommonMethod {

	public AddPrescriptionPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getclickPrescription() throws Exception {
		scrollTillElement();
		click("prescriptionMenu");
	}

	public void getPatientNameField() throws Exception {
		enterData("prescriptionPatientName", "valid_PatientName");
	}

	public void getpatientNameSuggestion() throws Exception {
		click("prescriptionNameFieldSugg");
	}

	public void getEmailField() throws Exception {
		enterData("prescriptionEmail", "emailId");
	}

	public void getClickingPlusSign() throws Exception {
		click("prescriptionMedicineplus");
	}

	public void getMedicineNameField1() throws Exception {
		scrollDown();
		enterData("prescriptionMedicineName", "medicineName1");
	}

	public void getMedicineNameField2() throws Exception {
		scrollDown();
		enterData("prescriptionMedicineName", "medicineName2");
	}

	public void getTotalNumberDays1() throws Exception {
		enterData("prescriptionDaysInput", "noOfDays1");
	}

	public void getTotalNumberDays2() throws Exception {
		enterData("prescriptionDaysInput", "noOfDays2");
	}

	public void getTimingsInput1() throws Exception {
		enterData("prescriptionTimings", "instructions1");
	}

	public void getTimingsInput2() throws Exception {
		enterData("prescriptionTimings", "instructions2");
	}

	public void getAmountInput1() throws Exception {
		enterData("prescriptionAmountInput", "amountToTake1");
	}

	public void getAmountInput2() throws Exception {
		enterData("prescriptionAmountInput", "amountToTake2");
	}

	public void getSaveAndPrintButton() throws Exception {
		scrollDown();
		click("PrescriptionsaveAndPrintBtn");
	}

	public void getBackButton() throws Exception {
		click("addPrescriptionsBackBtn");
	}

	public void getyesButtonField() throws Exception {
		click("prescriptionSaveYesBtn");
	}
	
	public void getnoButtonField() throws Exception {
		click("prescriptionSaveNoBtn");
	}

	public void getprescriptionBackBtn() throws Exception {
		scrollDown();
		click("prescriptionBackBtn");
	}

	public void getprintPrescription() throws Exception {
		scrollDown();
		click("printPrescriptionBtn");
	}

	public void getdownloadPrescription() throws Exception {
		click("downloadPrescriptionBtn");
	}

	public void getdeleteMedicineField() throws Exception {
		click("prescriptionDeleteMedicine");
	}
	
	public String verifyNotification(String text) throws Exception  {
		verifyElementPresent("notification");
		verifyTextPresent("notification");
		return text;
	}

	public void clickCancelNotification() throws Exception {
		click("cancelNotification");
	}
}
