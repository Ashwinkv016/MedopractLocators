package pages;

import genericPages.CommonMethod;

public class HomePage extends CommonMethod{

	public HomePage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
 
	public boolean verifyLoginPage() throws Exception  {
		verifyElementPresent("loginPage");
		return true;
	}

	public void verifyHomePageAppointmentsTitle() throws Exception {
		click("homePageAppMenu");
		verifyElementPresent("homepageAppTitle");
	}
	
	public void verifyToDoListTitle() throws Exception {
		click("toDoListMenu");
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
		verifyElementPresent("prescriptionstitle");
	}
	
	public void verifyReportsTitle() throws Exception {
		click("reportsMenu");
		verifyElementPresent("reportsTitle");
	}
	
	public void verifyHomeMenu()  {
		click("homeMenu");
	}
	
	public void clickLogoutBtn(){
		click("logoutBtn");
		}
	
}
