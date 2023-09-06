package pages;

import genericPages.CommonMethod;

public class AddBill extends CommonMethod {

	public AddBill() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickBilling() {
		scrollTillElement();
		base.waitForElementToBeClickable("billMenu", 10);
		click("billMenu");
	}

	public void clickAddBill() {
		click("addBillMenu");
	}

	public void enterPatientName() {
		enterData("billingPatientname", "patient_FirstName2");
	}

	public void clickPatientNameSugg() {
		base.waitForElementVisibility("addBillingPatientNameSugg", 10);
		click("addBillingPatientNameSugg");
	}

	public void enterEmail() {
		enterData("addBillEmail", "emailId");
	}

	public void billdescription() {
		base.waitForElementVisibility("billdescription", 10);
		enterData("billdescription", "BillDescription");
	}

	public void invaliedBilldescription() {
		base.waitForElementVisibility("billdescription", 10);
		enterData("billdescription", "InvaliedBillDescription");
	}

	public void clearBilldescription() {
		base.waitForElementVisibility("billdescription", 10);
		clearData("billdescription");
	}
	
	public void billQty() {
		base.waitForElementVisibility("billQty", 10);
		enterData("billQty", "Qty");
	}

	public void clearBillQty() {
		base.waitForElementVisibility("billQty", 10);
		clearData("billQty");
	}
	
	public void invaliedBillQty() {
		base.waitForElementVisibility("billQty", 10);
		enterData("billQty", "invaliedQty");
	}

	public void billRate() {
		enterData("billRate", "Rate");
	}
	
	public void clearBillRate() {
		clearData("billRate");
	}

	public void invaliedBillRate() {
		enterData("billRate", "InvaliedRate");
	}

	public void clickbillItemDetailsPlusSign() {
		base.waitForElementVisibility("billItemDetailsPlusBtn", 10);
		//scrollTillElement();
		base.waitForElementToBeClickable("billItemDetailsPlusBtn", 10);
		click("billItemDetailsPlusBtn");
	}

	public void clickbillItemDetailsCancel() {
		base.waitForElementToBeClickable("billItemDetailsCancelBtn", 10);
		click("billItemDetailsCancelBtn");
	}

	public void bedNumber() {
		enterData("BedNumber", "BedNo");
	}

	public void AdmissionClick() {
		click("admissionClick");
	}

	public void AdmissionMonth() {
		enterData("admissionMonth", "AdmiMonth");
	}

	public void AdmissionDate() {
		enterData("admissionDate", "AdmiDate");
	}

	public void AdmissionYear() {
		enterData("admissionYear", "AdmiYear");
	}

	public void dischargeClick() {
		click("dischargeClick");
	}

	public void dischargeMonth() {
		enterData("dischargeMonth", "DischargeMonth");
	}

	public void dischargeDate() {
		enterData("dischargeDate", "DischargeDate");
	}

	public void dischargeYear() {
		enterData("dischargeYear", "DischargeYear");
	}

	public void enterCGSTPercent() {
		enterData("billCGST", "CGST");
	}

	public void enterSGSTPercent() {
		enterData("billSGST", "SGST");
	}

	public void clickSaveAndPrintBtn() {
		scrollDown();
		base.waitForElementToBeClickable("billSaveAndPrint", 10);
		click("billSaveAndPrint");
	}
	
	public void clickResetBtn() {
		scrollDown();
		base.waitForElementToBeClickable("addBillResetBtn", 60);
		click("addBillResetBtn");
	}

	public void clickBackBtn() {
		click("addBillbackBtn");
	}

	public void clickBillPrintBtn() {
		base.waitForElementToBeClickable("billPrintBtn", 10);
		click("billPrintBtn");
	}

	public void clickBillDownloadBtn() {
		base.waitForElementToBeClickable("billDownloadBtn", 10);
		click("billDownloadBtn");
	}

	public void clickBillBackBtn() {
		base.waitForElementToBeClickable("billBackBtn", 10);
		click("billBackBtn");
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
