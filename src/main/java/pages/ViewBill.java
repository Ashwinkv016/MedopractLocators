package pages;

import genericPages.CommonMethod;

public class ViewBill extends CommonMethod{

	public ViewBill() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickBilling() {
		scrollTillElement();
		base.waitForElementToBeClickable("billMenu", 10);
		click("billMenu");
	}
	
	public void clickViewBill() {
		click("viewBillClick");
	}
	
	public void enterPatientName() {
		enterData("billingPatientname", "patient_FirstName2");
	}

	public void clickPatientNameSugg() {
		base.waitForElementVisibility("viewBillPatientNameSugg", 10);
		click("viewBillPatientNameSugg");
	}
	
	public void clickViewBillList() {
		click("viewBillList");
	}
	
	public void clickBillPrintBtn() {
		scrollDown();
		base.waitForElementToBeClickable("billPrintBtn", 10);
		click("billPrintBtn");
	}

	public void clickBillDownloadBtn() {
		scrollDown();
		base.waitForElementToBeClickable("billDownloadBtn", 10);
		click("billDownloadBtn");
	}

	public void clickBillBackBtn() {
		 scrollDown();
		base.waitForElementToBeClickable("billBackBtn", 10);
		click("billBackBtn");
	}
	
	public void clickGoToPatientDetails() {
		click("goToPatientDetails");
	}
}
