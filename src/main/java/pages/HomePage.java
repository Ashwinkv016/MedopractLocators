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
		verifyElementPresent("homepageAppTitle");
	}
	
	public void verifyToDoListTitle() throws Exception {
		verifyElementPresent("toDoListTitle");
	}
	
	public void verifyPatientsTitle() throws Exception {
		click("patientMenu");
		verifyElementPresent("patientTitle");
	}
	
	public void verifyAppointmentsTitle() throws Exception {
		click("appointmentsMenu");
		verifyElementPresent("appointmentsTitle");
	}
	
	public void verifyPrescriptionsTitle() throws Exception {
		click("prescriptionMenu");
		verifyElementPresent("prescriptionsTitle");
	}
	
	public void verifyBillingTitle() throws Exception {
		click("billMenu");
		verifyElementPresent("billTitle");
	}
	
	public void verifyReportsTitle() throws Exception {
		click("reportsMenu");
		verifyElementPresent("reportsTitle");
	}
	
	public void verifyHomeMenu() throws Exception  {
		scrollTillElement();
		verifyElementPresent("homePageTitle");
	}
	
	public void clickLogoutBtn() throws Exception{
		click("logoutBtn");
		}
	
}
