package pages;

import genericPages.CommonMethod;

public class DoctorProfilePage extends CommonMethod{

	public DoctorProfilePage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void clickDoctorProfile() {
		scrollTillElement();
		base.waitForElementToBeClickable("doctorMenu", 10);
		click("doctorMenu");
	}

	public void enterDoctorName() {
		enterData("doctorName","DoctorName");
	}
	
	public void enterDoctorGender() {
		enterData("doctorGender","Gender");
	}
	
	public void enterDoctorDateOfBirth() {
		enterData("doctorBirthDate","DateOfBirth");
	}
	
	public void enterDoctorQualification() {
		enterData("doctorQualification","Qualification");
	}
	
	public void enterDoctorEmail() {
		enterData("doctorEmail","doctorEmailID");
	}
	
	public void enterDoctorMobileNumber() {
		enterData("doctorMobileNo","doctorPhno");
	}
	
	public void enterHospitalName() {
		enterData("hospitalName","Hospitalname");
	}
	
	public void enterHospitalPhno() {
		enterData("hospitalPhno","valied_PhoneNo1");
	}
	
	public void enterHospitalFax() {
		enterData("hospitalFax","Fax");
	}
	
	public void enterHospitalAddress() {
		enterData("hospitalAddress","HospitalAddress");
	}
	
	public void enterHospitalCity() {
		enterData("hospitalCity","City");
	}
	
	public void enterHospitalState() {
		enterData("hospitalState","State");
	}
	
	public void enterHospitalPincode() {
		enterData("hospitalPinCode","Pin");
	}
	
	public void clickSaveChangesBtn() {
		click("saveChangesBtn");
	}
	
	public void clickCancelBtn() {
		click("cancelBtn");
	}
}
