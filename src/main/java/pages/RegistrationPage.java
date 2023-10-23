package pages;



import genericPages.CommonMethod;

public class RegistrationPage extends CommonMethod {

	public RegistrationPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickRegisterNow() throws Exception {
		scrollDown();
		click("registerNow");
	}

	public void enterFullName() throws Exception {
		enterData("fullNameRegister","fullName");
	}
	
	public void enterEmailField() throws Exception {
		enterData("emailRegister","emailId");
	}

	public void enterMobileField() throws Exception {
		enterData("phnoRegister","valid_PhoneNo1");
	}

	public void enterUserNameField() throws Exception {
		enterData("usernameRegister","valid_UserName");
	}

	public void enterValidConfirmUserName() throws Exception {
		enterData("cnfrmUserRegister","valid_CnfrmUserName");
	}
	
	public void enterInValidConfirmUserName() throws Exception {
		enterData("cnfrmUserRegister","invalid_CnfrmUserName");
	}
	
	public void clearConfirmUserName() throws Exception {
		clearData("cnfrmUserRegister");
	}
	
	public void clickAgreetermCheckBox() throws Exception {
		click("agreeTermsRegister");
	}
	
	public void clickRegisterButton() throws Exception{
		click("registerBtn");
	}
	
	public void getOkButton() throws Exception {
		click("registerOkBtn");
	}

	public void clickImAlreadyUser() throws Exception{
		scrollDown();
		click("alreadyUserRegister");
	}
	public void clickHelp() throws Exception{
		scrollTillElement();
		 click("helpLogin");
	}

	public void clickGotItBtn() throws Exception {
		click("gotItBtn");
	}	

	public void clickCancelNotification() throws Exception {
		click("cancelNotification");
	}
		
}
