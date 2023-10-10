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

	public String FullNameRegisterErrorMsg(String text) throws Exception {
		verifyElementPresent("fullNameRegisterErrorMsg");
		Thread.sleep(1000);
		verifyTextPresent("fullNameRegisterErrorMsg");
		return text;
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

	public String cnfrmUserNameErrorMsg(String text) throws Exception {
		verifyElementPresent("cnfrmUserNameErrorMsg");
		verifyTextPresent("cnfrmUserNameErrorMsg");
		return text;
	}
	
	public void clickAgreetermCheckBox() throws Exception {
		click("agreeTermsRegister");
	}
	
	public String AgreeTermsErrorMsg(String text) throws Exception {
		verifyElementPresent("agreeTermsRegisterErrorMsg");
		verifyTextPresent("agreeTermsRegisterErrorMsg");
		return text;
	}

	public void clickRegisterButton() throws Exception{
		click("registerBtn");
	}
	
	
	public String registrationSuccessMsg(String text) throws Exception {
		verifyElementPresent("registrationSuccessMsg");
		verifyTextPresent("registrationSuccessMsg");
		return text;
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

	public String verifyNotification(String text) throws Exception  {
		verifyElementPresent("notification");
		verifyTextPresent("notification");
		return text;
	}

	public void clickCancelNotification() throws Exception {
		click("cancelNotification");
	}
	
	public boolean verifyLoginPage() throws Exception  {
		verifyElementPresent("loginPage");
		return true;
	}

	
}
