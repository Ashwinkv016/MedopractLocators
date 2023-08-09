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

	public void clickbackLoginPage() {
		click("backToLogin");
	}

	public void enterUsernamefield() {
		enterData("userForget","valied_UserName");
	}

	public void clickResetButton() {
         click("resetPass");
	}
	
	public void clickGotItBtn() {
		click("gotItBtn");
	}
	
}



