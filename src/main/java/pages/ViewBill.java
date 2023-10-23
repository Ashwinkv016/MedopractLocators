package pages;

import genericPages.CommonMethod;

public class ViewBill extends CommonMethod{

	public ViewBill() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickBilling() throws Exception {
		scrollTillElement();
		click("billMenu");
	}

	public void clickViewBill() throws Exception {
		click("viewBillClick");
	}

	public void enterPatientName() throws Exception {
		enterData("billingPatientname", "patient_FirstName2");
	}

	public void clickPatientNameSugg() throws Exception {
		click("viewBillPatientNameSugg");
	}

	public void clickViewBillList() throws Exception {
		click("viewBillList");
	}

	public void clickBillPrintBtn() throws Exception {
		click("billPrintBtn");
	}

	public void clickBillDownloadBtn() throws Exception {
		click("billDownloadBtn");
	}

	public void clickBillBackBtn() throws Exception {
		click("viewBillBackBtn");
	}

	public void clickGoToPatientDetails() throws Exception {
		click("goToPatientDetails");
	}
}
