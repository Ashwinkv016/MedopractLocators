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

	public void clickUpdateBtn() {
		 scrollDown();
		 click("viewOrEditUpdate");
	}

	public void clickCancelButton() {
		 click("viewOrEditCancel");
	}
	
    public void clickDeleteButton() {
	     click("viewOrEditDelete");
    }
   


}


