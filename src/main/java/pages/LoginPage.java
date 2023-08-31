package pages;

import genericPages.CommonMethod;

public class LoginPage extends CommonMethod {

	public LoginPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void enterValiedUserName() {
		base.waitForElementVisibility("userLogin", 10);
		enterData("userLogin", "valied_UserName");
	}

	public void enterInvaliedUserName() {
		base.waitForElementVisibility("userLogin", 10);
		enterData("userLogin", "inValied_UserName");
	}

	public void clearUserNameField() {
		base.waitForElementVisibility("userLogin", 10);
		clearData("userLogin");
	}

	public void enterValiedPassword() {
		enterData("passLogin", "valied_Password");
	}

	public void enterInvaliedPassword() {
		enterData("passLogin", "invalied_Password");
	}

	public void clearPasswordField() {
		clearData("passLogin");
	}

	public void clickGotItBtn() {
		click("gotItBtn");
	}

	public void clickRememberMeBtn() {
		click("remenberMeLogin");
	}

	public void clickSubmitLoginBtn() {
		scrollDown();
		base.waitForElementVisibility("submitLogin", 10);
		click("submitLogin");
	}

	public void clickLogoutBtn() {
		scrollTillElement();
		base.waitForElementVisibility("logoutBtn", 10);
		base.waitForElementToBeClickable("logoutBtn", 10);
		click("logoutBtn");
	}

	public String verifyNotification(String text) throws Exception {
		verifyElementPresent("notification");
		base.waitForElementVisibility("notification", 10);
		verifyTextPresent("notification");
		return text;
	}

	public void clickCancelNotification() {
		base.waitForElementToBeClickable("cancelNotification", 10);
		click("cancelNotification");
	}

	public boolean verifyHomePage() throws Exception {
        scrollTillElement();
		base.waitForElementVisibility("homePageTitle", 10);
		verifyElementPresent("homePageTitle");
		return true;
	}
}
