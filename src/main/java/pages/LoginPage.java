package pages;

import genericPages.CommonMethod;

public class LoginPage extends CommonMethod {

	public LoginPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void enterValiedUserName() throws Exception {
		enterData("userLogin", "valied_UserName");
	}

	public void enterInvaliedUserName() throws InterruptedException {
		Thread.sleep(1000);
		enterData("userLogin", "inValied_UserName");
	}

	public void clearUserNameField() throws InterruptedException {
		Thread.sleep(1000);
		clearData("userLogin");
	}

	public void enterValiedPassword() throws Exception {
		enterData("passLogin", "valied_Password");
	}

	public void enterInvaliedPassword() {
		enterData("passLogin", "invalied_Password");
	}

	public void clearPasswordField() {
		clearData("passLogin");
	}

	public void clickGotItBtn() throws Exception {
		click("gotItBtn");
	}

	public void clickRememberMeBtn() throws Exception {
		click("remenberMeLogin");
	}

	public void clickSubmitLoginBtn() throws Exception {
		click("submitLogin");
	}

	public void clickLogoutBtn() {
		click("logoutBtn");
	}
}

/**
 * public String verifyNotificationText() throws Exception {
 * base.waitForElementVisibility("notification", 10);
 * verifyTextPresent("notification"); return null; }
 **/

/**
 * public void clickCancelNotification() {
 * base.waitForElementToBeClickable("cancelNotification", 10);
 * click("cancelNotification"); }
 **/
