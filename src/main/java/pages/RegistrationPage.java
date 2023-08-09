package pages;



import genericPages.CommonMethod;

public class RegistrationPage extends CommonMethod {

	public RegistrationPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickRegisterNow() {
		scrollDown();
		click("registerNow");
	}

	public void enterFullName() {
		enterData("fullNameRegister","fullName");
	}

	public void enterEmailField() {
		enterData("emailRegister","emailId");
	}

	public void enterMobileField() {
		enterData("phnoRegister","valied_PhoneNo1");
	}

	public void enterUserNameField() {
		enterData("usernameRegister","valied_UserName");
	}

	public void enterValidConfirmUserName() {
		enterData("cnfrmUserRegister","valied_CnfrmUserName");
	}
	
	public void enterInValidConfirmUserName() {
		enterData("cnfrmUserRegister","invalied_CnfrmUserName");
	}
	
	public void clearConfirmUserName() {
		clearData("cnfrmUserRegister");
	}

	public void clickAgreetermCheckBox() {
		click("agreeTermsRegister");
	}

	public void clickRegisterButton(){
		click("registerBtn");
	}

	public void clickImAlreadyUser(){
		scrollDown();
		 click("alreadyUserRegister");
	}
	public void clickHelp(){
		 click("helpLogin");
	}

	public void clickGotItBtn() {
		click("gotItBtn");
	}	

	
	
}
