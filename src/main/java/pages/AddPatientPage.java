package pages;

import genericPages.CommonMethod;


public class AddPatientPage extends CommonMethod {


	public AddPatientPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickPatientMenu() {
		click("patientMenu");
	}

	public void clickAddPatient() {
		click("addPatientClick");
	}

	public void enterValiedPatientName() throws Exception{
		scrollTillElement("patientName");
		enterData("patientName","valied_PatientName");
	}

	public void enterInValiedPatientName(){
		enterData("patientName","invalied_PatientName");
	}
	
	public void clearPatientName(){
		clearData("patientName");
	}

	public void enterValiedPhoneNo(){
		enterData("patientPhno","valied_PhoneNo1");
	}
	
	public void clearPhoneNo(){
		clearData("patientPhno");
	}
	
	public void enterInValiedPhoneNo(){
		enterData("patientPhno","invalied_PhoneNo");
	}

	public void clickGenderField(){
          click("patientgender");
	}
	
	
	public void clickBirthDateField(){
		 click("patientBirthDateField");
	}

	public void enterMonthField(){
		enterData("patientBmonth","patient_Month");
	}

	public void enterDateField(){
		enterData("patientBdate","patient_Day");
	}

	public void enterYearfield(){
		enterData("patientByear","patient_Year");
	}

	public void clickBloodGroup(){
		 click("patientBloodGroup");
	}
	
	public void enterOccupation(){
		enterData("patientOccupation","patientOccupation");
	}
	
	public void enterAddress(){
		enterData("patientAddress","patient_Address");
	}
	
	public void clearAddress(){
		clearData("patientAddress");
	}
	
	public void enterEmergencyPhno(){
		enterData("patientEmerPhno","EmergencyPhno");
	}
	
	public void clearEmergencyPhno(){
		clearData("patientEmerPhno");
	}
	
	public void enterAllergy(){
		enterData("patientAllergies","patient_Allergy");
	}
	
	public void enterRemarks(){
		enterData("patientRemarks","patient_Remark");
	}
	
	public void enterHistory(){
		enterData("patientHistory","patient_History");
	}
	
	public void enterhabits1(){
		enterData("patientHabits","patient_Habit1");
	}
	
	public void enterhabits2(){
		enterData("patientHabits","patient_Habit2");
	}
	
	public void clickHabitsPlus(){
        click("habitsPlusBtn");
	}
	
	public void clickHabitsCancel(){
         click("habitsCancelBtn");
	}
	
	public void clickPatientSaveBtn() throws Exception {
		scrollTillElement("patientSaveBtn");
		click("patientSaveBtn");
	}
	
	public void clickPatientResetBtn() throws Exception {
		scrollTillElement("patientResetBtn");
		click("patientResetBtn");
	}
	
	
}