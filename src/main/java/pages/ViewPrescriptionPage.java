package pages;

import genericPages.CommonMethod;

public class ViewPrescriptionPage extends CommonMethod {

	public ViewPrescriptionPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getPrescriptionsLink() throws Exception {
		scrollTillElement();
		click("prescriptionMenu");
	}

	public void getviewPrescriptionsLink() throws Exception {
		click("viewPrescriptionLink");
	}

	public void getpatientNameField() throws Exception {
		enterData("prescriptionPatientName", "valid_PatientName");
	}

	public void getpatientNameFieldSugg() throws Exception {
		click("viewPrescriptionNameSugg");
	}

	public void getprescriptionDetails() throws Exception {
		click("viewPrescriptionDetails");
	}

	public void getbackBtn() throws Exception {
		click("prescriptionBackBtn");
	}

	public void getgoToPatientDetails() throws Exception {
		scrollDown();
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
