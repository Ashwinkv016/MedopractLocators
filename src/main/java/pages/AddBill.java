package pages;

import genericPages.CommonMethod;

public class AddBill extends CommonMethod {

	public AddBill() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickBilling() throws Exception {
		scrollTillElement();
		click("billMenu");
	}

	public void clickAddBill() throws Exception {
		click("addBillMenu");
	}

	public void enterPatientName() throws Exception {
		enterData("billingPatientname", "patient_FirstName2");
	}

	public void clickPatientNameSugg() throws Exception {
		click("addBillingPatientNameSugg");
	}

	public void enterEmail() throws Exception {
		enterData("addBillEmail", "emailId");
	}

	public void billdescription() throws Exception {
		enterData("billdescription", "BillDescription");
	}

	public void invaliedBilldescription() throws Exception {
		enterData("billdescription", "InvaliedBillDescription");
	}

	public void clearBilldescription() throws Exception {
		clearData("billdescription");
	}
	
	public void billQty() throws Exception {
		enterData("billQty", "Qty");
	}

	public void clearBillQty() throws Exception {
		clearData("billQty");
	}
	
	public void invaliedBillQty() throws Exception {
		enterData("billQty", "invalidQty");
	}

	public void billRate() throws Exception {
		enterData("billRate", "Rate");
	}
	
	public void clearBillRate() throws Exception {
		clearData("billRate");
	}

	public void invaliedBillRate() throws Exception {
		enterData("billRate", "InvalidRate");
	}

	public void clickbillItemDetailsPlusSign() throws Exception {
		//scrollTillElement();
		click("billItemDetailsPlusBtn");
	}

	public void clickbillItemDetailsCancel() throws Exception {
		click("billItemDetailsCancelBtn");
	}

	public void bedNumber() throws Exception {
		enterData("BedNumber", "BedNo");
	}

	public void AdmissionClick() throws Exception {
		click("admissionClick");
	}

	public void AdmissionMonth() throws Exception {
		enterData("admissionMonth", "AdmiMonth");
	}

	public void AdmissionDate() throws Exception {
		enterData("admissionDate", "AdmiDate");
	}

	public void AdmissionYear() throws Exception {
		enterData("admissionYear", "AdmiYear");
	}

	public void dischargeClick() throws Exception {
		click("dischargeClick");
	}

	public void dischargeMonth() throws Exception {
		enterData("dischargeMonth", "DischargeMonth");
	}

	public void dischargeDate() throws Exception {
		enterData("dischargeDate", "DischargeDate");
	}

	public void dischargeYear() throws Exception {
		enterData("dischargeYear", "DischargeYear");
	}

	public void enterCGSTPercent() throws Exception {
		enterData("billCGST", "CGST");
	}

	public void enterSGSTPercent() throws Exception {
		enterData("billSGST", "SGST");
	}

	public void clickSaveAndPrintBtn() throws Exception {
		scrollDown();
		click("billSaveAndPrint");
	}
	
	public void clickResetBtn() throws Exception {
		scrollDown();
		click("addBillResetBtn");
	}

	public void clickBackBtn() throws Exception {
		click("addBillbackBtn");
	}

	public void clickBillPrintBtn() throws Exception {
		click("billPrintBtn");
	}

	public void clickBillDownloadBtn() throws Exception {
		click("billDownloadBtn");
	}

	public void clickBillBackBtn() throws Exception {
		click("billBackBtn");
	}

	public void clickCancelNotification() throws Exception {
		click("cancelNotification");
	}
}
