package pages;

import genericPages.CommonMethod;

public class HomePage extends CommonMethod{

	public HomePage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
 
	public void verifyLoginPage() throws Exception  {
		verifyElementPresent("loginPage");
	}

	public void verifyHomePageAppointmentsTitle() throws Exception {
		base.waitForElementVisibility("homepageAppTitle", 10);
		verifyElementPresent("homepageAppTitle");
	}
	
	public void verifyToDoListTitle() throws Exception {
		base.waitForElementVisibility("toDoListTitle", 10);
		verifyElementPresent("toDoListTitle");
	}
	
	public void verifyPatientsTitle() throws Exception {
		base.waitForElementToBeClickable("patientMenu", 10);
		click("patientMenu");
		verifyElementPresent("patientTitle");
	}
	
	public void verifyAppointmentsTitle() throws Exception {
		base.waitForElementToBeClickable("appointmentsMenu", 10);
		click("appointmentsMenu");
		verifyElementPresent("appointmentsTitle");
	}
	
	public void verifyPrescriptionsTitle() throws Exception {
		base.waitForElementToBeClickable("prescriptionMenu", 10);
		click("prescriptionMenu");
		verifyElementPresent("prescriptionsTitle");
	}
	
	public void verifyBillingTitle() throws Exception {
		base.waitForElementToBeClickable("billMenu", 10);
		click("billMenu");
		verifyElementPresent("billTitle");
	}
	
	public void verifyReportsTitle() throws Exception {
		base.waitForElementToBeClickable("reportsMenu", 10);
		click("reportsMenu");
		verifyElementPresent("reportsTitle");
	}
	
	public void verifyHomeMenu() throws Exception  {
		scrollTillElement("homePageTitle");
		base.waitForElementVisibility("homePageTitle", 10);
		verifyElementPresent("homePageTitle");
	}
	
	public void clickLogoutBtn(){
		click("logoutBtn");
		}
	
}
