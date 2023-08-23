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
		enterData("viewOrEditPatientname","valied_PatientName");
	}

	public void enterPatientPhno() {
		enterData("viewOrEditPhno","valied_PhoneNo1");
	}

	public void clickPatientList() {
		 click("viewOrEditListClick");
	}

	public void clickUpdateBtn() throws InterruptedException {
         base.waitForElementToBeClickable("viewOrEditUpdate", 10);
		 scrollDown();
		 click("viewOrEditUpdate");
	}

	public void clickCancelButton() {
		 click("viewOrEditCancel");
	}
	
    public void clickDeleteButton() {
    	 base.waitForElementToBeClickable("viewOrEditDelete", 10);
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


