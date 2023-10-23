package pages;


import genericPages.CommonMethod;

public class ViewOrEditPage extends CommonMethod{



	public ViewOrEditPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickViewOrEdit() throws Exception {
		click("viewOrEditBtn");
	}

	public void enterPatientName() throws Exception {
		enterData("patientName","valid_PatientName");
	}

	public void enterPatientPhno() throws Exception {
		enterData("viewOrEditPhno","valid_PhoneNo1");
	}

	public void clickPatientList() throws Exception {
		click("viewOrEditListClick");
	}

	public void clickUpdateBtn() throws Exception {
		scrollDown();
		click("viewOrEditUpdate");
	}

	public void clickCancelButton() throws Exception {
		click("viewOrEditCancel");
	}

	public void clickDeleteButton() throws Exception {
		Thread.sleep(1000);
		click("viewOrEditDelete");
	}

	public void  PatientPreviousVisitList() throws Exception {
		click("viewOrEditPatientPreviousVisitListClick");
	}

	public void cancelPatientPreviousVisit() throws Exception {
		click("cancelPatientPreviousVisit");
	}

	public void clickCancelNotification() throws Exception {
		click("cancelNotification");
	}


}


