package pages;


import genericPages.CommonMethod;

public class ReportsPage extends CommonMethod {	

	public ReportsPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getClickReports() throws Exception {
		scrollTillElement();
		 click("reportsMenu");
	}

	public void addPatientReportsClick() throws Exception {
		click("addPatientReportsClick");
	}

	public void getYearlyTab() throws Exception {
		click("yearlyReports");
	}

	public void getMonthlyTab() throws Exception {
		click("monthlyReports");
	}

	public void getWeeklyTab() throws Exception {
		 click("weeklyReports");
	}

	public void getDailyTab() throws Exception {
		 click("dailyReports");
	}

	public void getCancelButton() throws Exception {
		click("cancelReports");
	}

	public Boolean verifyReportsdate() throws Exception {
		verifyElementPresent("reportsDate");
		return true;
	}
}


