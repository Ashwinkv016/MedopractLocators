package pages;

import genericPages.CommonMethod;

public class DoctorProfilePage extends CommonMethod{

	public DoctorProfilePage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void clickDoctorProfile() throws Exception {
		scrollTillElement();
		click("doctorMenu");
	}

	public void enterDoctorName() throws Exception {
		enterData("doctorName","DoctorName");
	}
	
	public void enterDoctorGender() throws Exception {
		enterData("doctorGender","Gender");
	}
	
	public void enterDoctorDateOfBirth() throws Exception {
		enterData("doctorBirthDate","DateOfBirth");
	}
	
	public void enterDoctorQualification() throws Exception {
		enterData("doctorQualification","Qualification");
	}
	
	public void enterDoctorEmail() throws Exception {
		enterData("doctorEmail","doctorEmailID");
	}
	
	public void enterDoctorMobileNumber() throws Exception {
		enterData("doctorMobileNo","doctorPhno");
	}
	
	public void enterHospitalName() throws Exception {
		enterData("hospitalName","Hospitalname");
	}
	
	public void enterHospitalPhno() throws Exception {
		enterData("hospitalPhno","valid_PhoneNo1");
	}
	
	public void enterHospitalFax() throws Exception {
		enterData("hospitalFax","Fax");
	}
	
	public void enterHospitalAddress() throws Exception {
		enterData("hospitalAddress","HospitalAddress");
	}
	
	public void enterHospitalCity() throws Exception {
		enterData("hospitalCity","City");
	}
	
	public void enterHospitalState() throws Exception {
		enterData("hospitalState","State");
	}
	
	public void enterHospitalPincode() throws Exception {
		enterData("hospitalPinCode","Pin");
	}
	
	public void clickSaveChangesBtn() throws Exception {
		click("saveChangesBtn");
	}
	
	public void clickCancelBtn() throws Exception {
		click("cancelBtn");
	}
}
