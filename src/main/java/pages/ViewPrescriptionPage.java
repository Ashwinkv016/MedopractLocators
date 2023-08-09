package pages;



import genericPages.CommonMethod;

public class ViewPrescriptionPage extends CommonMethod {

	public ViewPrescriptionPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getPrescriptionsLink(){
	click("prescriptionMenu");
}

//	public void getpatientDetailsPage(){
//	 patientDetailsPage;
//}
	
	public void getviewPrescriptionsLink(){
	click("viewPrescriptionLink");
}
//	public WebElement getviewPrescriptionsuccessful(){
//		return viewPrescriptionsuccessful;
//	}
	
	public void getpatientNameField(){
	  enterData("prescriptionPatientName","valied_PatientName");
}
	
	public void getpatientNameFieldSugg(){
	 click("viewPrescriptionNameSugg");
}
	
	public void getprescriptionDetails(){
		 click("viewPrescriptionDetails");
	}
	
	public void getbackBtn(){
	  click("prescriptionBackBtn");
	}
	
	public void getgoToPatientDetails(){
		click("viewPrescriptionGoToPatientDetails");
	}
}
