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
	
	public void clearDoctorDateOfBirth() throws Exception {
		clearData("doctorBirthDate");
	}
	
	public void enterDoctorQualification() throws Exception {
		enterData("doctorQualification","Qualification");
	}
	
	public void clearDoctorQualification() throws Exception {
		clearData("doctorQualification");
	}
	
	public void enterDoctorEmail() throws Exception {
		enterData("doctorEmail","doctorEmailID");
	}
	
	public void clearDoctorEmail() throws Exception {
		clearData("doctorEmail");
	}
	
	public void enterDoctorMobileNumber() throws Exception {
		enterData("doctorMobileNo","doctorPhno");
	}
	
	public void clearDoctorMobileNumber() throws Exception {
		clearData("doctorMobileNo");
	}
	
	public void enterHospitalName() throws Exception {
		enterData("hospitalName","Hospitalname");
	}
	
	public void clearHospitalName() throws Exception {
		clearData("hospitalName");
	}
	
	public void enterHospitalPhno() throws Exception {
		enterData("hospitalPhno","valid_PhoneNo1");
	}
	
	public void clearHospitalPhno() throws Exception {
		clearData("hospitalPhno");
	}
	
	public void enterHospitalFax() throws Exception {
		enterData("hospitalFax","Fax");
	}
	
	public void clearHospitalFax() throws Exception {
		clearData("hospitalFax");
	}
	
	public void enterHospitalAddress() throws Exception {
		enterData("hospitalAddress","HospitalAddress");
	}
	
	public void clearHospitalAddress() throws Exception {
		clearData("hospitalAddress");
	}
	
	public void enterHospitalCity() throws Exception {
		enterData("hospitalCity","City");
	}
	
	public void clearHospitalCity() throws Exception {
		clearData("hospitalCity");
	}
	
	public void enterHospitalState() throws Exception {
		enterData("hospitalState","State");
	}
	
	public void clearHospitalState() throws Exception {
		clearData("hospitalState");
	}
	
	public void enterHospitalPincode() throws Exception {
		enterData("hospitalPinCode","Pin");
	}
	
	public void clearHospitalPincode() throws Exception {
		clearData("hospitalPinCode");
	}
	
	public void clickSaveChangesBtn() throws Exception {
		scrollDown();
		Thread.sleep(1000);
		click("saveChangesBtn");
	}
	
	public void clickCancelBtn() throws Exception {
		click("cancelBtn");
	}
	
	public void clickUpdateSuccessOk() throws Exception {
		click("updateSuccessOk");
	}
	
	
}
