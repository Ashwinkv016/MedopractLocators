package pages;


import genericPages.CommonMethod;

public class ReportsPage extends CommonMethod {	

	public ReportsPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getClickReports() throws Exception {
		base.waitForElementToBeClickable("reportsMenu", 10);
		scrollTillElement("reportsMenu");
		 click("reportsMenu");
	}

	public void getClickAddPatient() {
		base.waitForElementToBeClickable("addPatientReportsClick", 10);
		click("addPatientReportsClick");
	}

	public void getYearlyTab() {
		base.waitForElementToBeClickable("yearlyReports", 10);
		click("yearlyReports");
	}

	public void getMonthlyTab() {
		base.waitForElementToBeClickable("monthlyReports", 10);
		click("monthlyReports");
	}

	public void getWeeklyTab() {
		base.waitForElementToBeClickable("weeklyReports", 10);
		 click("weeklyReports");
	}

	public void getDailyTab() {
		base.waitForElementToBeClickable("dailyReports", 10);
		 click("dailyReports");
	}

	public void getCancelButton() {
		base.waitForElementToBeClickable("cancelReports", 10);
		click("cancelReports");
	}

	public String verifyReportsdate(String text) throws Exception {
		verifyElementPresent("reportsDate");
		return text;
	}
}


