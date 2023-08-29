package pages;



import genericPages.CommonMethod;

public class RegistrationPage extends CommonMethod {

	public RegistrationPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickRegisterNow() throws InterruptedException {
		scrollDown();
		base.waitForElementToBeClickable("registerNow", 10);
		click("registerNow");
	}

	public void enterFullName() {
		enterData("fullNameRegister","fullName");
	}

	public String FullNameRegisterErrorMsg(String text) throws Exception {
		verifyElementPresent("fullNameRegisterErrorMsg");
		Thread.sleep(1000);
		verifyTextPresent("fullNameRegisterErrorMsg");
		return text;
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

	public String cnfrmUserNameErrorMsg(String text) throws Exception {
		verifyElementPresent("cnfrmUserNameErrorMsg");
		base.waitForElementVisibility("cnfrmUserNameErrorMsg", 10);
		verifyTextPresent("cnfrmUserNameErrorMsg");
		return text;
	}
	
	public void clickAgreetermCheckBox() {
		click("agreeTermsRegister");
	}
	
	public String AgreeTermsErrorMsg(String text) throws Exception {
		verifyElementPresent("agreeTermsRegisterErrorMsg");
		base.waitForElementVisibility("agreeTermsRegisterErrorMsg", 10);
		verifyTextPresent("agreeTermsRegisterErrorMsg");
		return text;
	}

	public void clickRegisterButton(){
		base.waitForElementToBeClickable("registerBtn", 10);
		click("registerBtn");
	}
	
	
	public boolean registrationSuccessMsg() throws Exception {
		verifyElementPresent("registrationSuccessMsg");
		return true;
	}
	
	
	public void getOkButton() {
		click("registerOkBtn");
	}

	public void clickImAlreadyUser() throws InterruptedException{
		scrollDown();
		base.waitForElementToBeClickable("alreadyUserRegister", 10);
		click("alreadyUserRegister");
	}
	public void clickHelp(){
		 click("helpLogin");
	}

	public void clickGotItBtn() {
		click("gotItBtn");
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
