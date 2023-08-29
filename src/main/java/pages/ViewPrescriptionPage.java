package pages;

import genericPages.CommonMethod;

public class ViewPrescriptionPage extends CommonMethod {

	public ViewPrescriptionPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getPrescriptionsLink() throws Exception {
		scrollTillElement();
		base.waitForElementToBeClickable("prescriptionMenu", 10);
		click("prescriptionMenu");
	}

	public void getviewPrescriptionsLink() {
		base.waitForElementToBeClickable("viewPrescriptionLink", 10);
		click("viewPrescriptionLink");
	}

	public void getpatientNameField() {
		enterData("prescriptionPatientName", "valied_PatientName");
	}

	public void getpatientNameFieldSugg() {
		click("viewPrescriptionNameSugg");
	}

	public void getprescriptionDetails() {
		click("viewPrescriptionDetails");
	}

	public void getbackBtn() {
		click("prescriptionBackBtn");
	}

	public void getgoToPatientDetails() throws InterruptedException {
		scrollDown();
		base.waitForElementToBeClickable("viewPrescriptionGoToPatientDetails", 10);
		click("viewPrescriptionGoToPatientDetails");
	}

	public boolean verifyPrescriptionPage() throws Exception {
		verifyElementPresent("prescriptionLogo");
		return true;
	}

	public boolean verifyAddPatientPage() throws Exception {
		verifyElementPresent("viewOrEditPage");
		return true;
	}
}
