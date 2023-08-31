package pages;


import genericPages.CommonMethod;
	
public class ViewOrEditPage extends CommonMethod{



	public ViewOrEditPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickViewOrEdit() {
		click("viewOrEditBtn");
	}

	public void enterPatientName() {
		enterData("patientName","valied_PatientName");
	}

	public void enterPatientPhno() {
		enterData("viewOrEditPhno","valied_PhoneNo1");
	}

	public void clickPatientList() {
		 base.waitForElementToBeClickable("viewOrEditListClick", 10);
		 click("viewOrEditListClick");
	}

	public void clickUpdateBtn() throws InterruptedException {
		 scrollDown();
		 base.waitForElementToBeClickable("viewOrEditUpdate", 10);
		 click("viewOrEditUpdate");
	}

	public void clickCancelButton() {
		 base.waitForElementToBeClickable("viewOrEditCancel", 10);
		 click("viewOrEditCancel");
	}
	
    public void clickDeleteButton() throws InterruptedException {
    	 base.waitForElementToBeClickable("viewOrEditDelete", 10);
    	 Thread.sleep(1000);
	     click("viewOrEditDelete");
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


