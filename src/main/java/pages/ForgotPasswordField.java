package pages;

import genericPages.CommonMethod;

public class ForgotPasswordField extends CommonMethod {

	public ForgotPasswordField() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickForgotPassword() {
		click("forgetPass");
	}

	public void clickbackLoginPage() throws InterruptedException {
		scrollDown();
        base.waitForElementToBeClickable("backToLogin", 10);
		click("backToLogin");
	}

	public void enterUsernamefield() {
		enterData("userForget", "valied_UserName");
	}

	public void clickResetButton() {
		 base.waitForElementToBeClickable("resetPassBtn", 10);
		click("resetPassBtn");
	}

	public void clickGotItBtn() {
		click("gotItBtn");
	}

	public boolean verifyForgetPassPage() throws Exception  {
		base.waitForElementVisibility("forgetPassPage", 10);
		verifyElementPresent("forgetPassPage");
		return true;
	}
	
	public boolean verifyLoginPage() throws Exception  {
		base.waitForElementVisibility("loginPage", 10);
		verifyElementPresent("loginPage");
		return true;
	}
}
