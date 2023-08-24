package pages;

import genericPages.CommonMethod;

public class AddBill extends CommonMethod {
 
	public AddBill() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickBilling() {
		click("billMenu");
	}
	
	public void clickAddBill() {
		click("addBillMenu");
	}
	
	public void enterPatientName() {
		enterData("billingPatientname", "patient_FirstName2");
	}
	
	public void enterEmail() {
		enterData("addBillEmail", "emailId");
	}
	
	public void billdescription() {
		enterData("billdescription", "BillDescription");
	}
	
	public void billQty() {
		enterData("billQty", "Qty");
	}
	
	public void billRate() {
		enterData("billRate", "Rate");
	}
	
	public void clickbillItemDetailsPlusSign() {
		click("billItemDetailsPlusBtn");
	}
	
	public void clickbillItemDetailsCancel() {
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
		click("billSaveAndPrint");
	}
	
	public void clickBackBtn() {
		click("addBillbackBtn");
	}
	
	public void clickBillPrintBtn() {
		click("billPrintBtn");
	}
	
	public void clickBillDownloadBtn() {
		click("billDownloadBtn");
	}
	
	public void clickBillBackBtn() {
		click("billBackBtn");
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
