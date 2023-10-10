package pages;

import genericPages.CommonMethod;

public class ForgotPasswordField extends CommonMethod {

	public ForgotPasswordField() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickForgotPassword() throws Exception {
		click("forgetPass");
	}

	public void clickbackLoginPage() throws Exception {
		scrollDown();
		click("backToLogin");
	}

	public void enterUsernamefield() throws Exception {
		enterData("userForget", "valid_UserName");
	}

	public void clickResetButton() throws Exception {
		click("resetPassBtn");
	}

	public void clickGotItBtn() throws Exception {
		click("gotItBtn");
	}

	public boolean verifyForgetPassPage() throws Exception  {
		verifyElementPresent("forgetPassPage");
		return true;
	}
	
	public boolean verifyLoginPage() throws Exception  {
		verifyElementPresent("loginPage");
		return true;
	}
}
