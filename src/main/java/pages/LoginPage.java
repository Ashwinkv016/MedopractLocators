package pages;

import genericPages.CommonMethod;

public class LoginPage extends CommonMethod {

	public boolean verificationLogicIsSuccessful;
	
	public LoginPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void enterValiedUserName() throws Exception {
		enterData("userLogin", "valid_UserName");
	}

	public void enterInvaliedUserName() throws Exception {
		enterData("userLogin", "inValid_UserName");
	}

	public void clearUserNameField() throws Exception {
		clearData("userLogin");
	}

	public void enterValiedPassword() throws Exception {
		enterData("passLogin", "valid_Password");
	}

	public void enterInvaliedPassword() throws Exception {
		enterData("passLogin", "invalid_Password");
	}

	public void clearPasswordField() throws Exception {
		clearData("passLogin");
	}

	public void clickGotItBtn() throws Exception {
		click("gotItBtn");
	}

	public void clickRememberMeBtn() throws Exception {
		click("remenberMeLogin");
	}

	public void clickSubmitLoginBtn() throws Exception {
		scrollDown();
		click("submitLogin");
	}

	public void clickLogoutBtn() throws Exception {
		scrollTillElement();
		click("logoutBtn");
	}

	public String verifyNotification(String text) throws Exception {
		verifyElementPresent("notification");
		verifyTextPresent("notification");
		return text;
	}

	public void clickCancelNotification() throws Exception {
		click("cancelNotification");
	}

	public Boolean verifyHomePage() throws Exception {
        scrollTillElement();
		verifyElementPresent("homePageTitle");
		return true;
	}
}
