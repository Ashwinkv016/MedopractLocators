package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericPages.CommonMethod;

public class LoginPage extends CommonMethod{
	
	public LoginPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void enterValiedUserName() throws InterruptedException {
		click("userLogin");
		Thread.sleep(1000);
		enterData("userLogin","valied_UserName");
	}
	
	public void enterInvaliedUserName() throws InterruptedException {
		click("userLogin");
		Thread.sleep(1000);
		enterData("userLogin","inValied_UserName");
	}
	
	public void clearUserNameField() throws InterruptedException {
		click("userLogin");
		Thread.sleep(1000);
		clearData("userLogin");
	}
	
	public void enterValiedPassword() throws InterruptedException {
		click("passLogin");
		Thread.sleep(1000);
		enterData("passLogin","valied_Password");
	}
	
	public void enterInvaliedPassword() {
		enterData("passLogin","invalied_Password");
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
	
	public void clickSubmitLoginBtn() throws InterruptedException {
		scrollDown();
		Thread.sleep(1000);
		click("submitLogin");
	}
	
	public String verifyNotification() throws Exception {
		return verifyTextPresent("notification");
	
	}
	
	public void clickCancelNotification() {
		click("cancelNotification");
	}
	
	public void clickLogoutBtn() {
		click("logoutBtn");
	}
	
	}

