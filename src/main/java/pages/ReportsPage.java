package pages;


import genericPages.CommonMethod;

public class ReportsPage extends CommonMethod {	

	public ReportsPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getClickReports() {
		 click("reportsMenu");
	}

	public void getClickAddPatient() {
		click("addPatientReportsClick");
	}

	public void getYearlyTab() {
		click("yearlyReports");
	}

	public void getMonthlyTab() {
		click("monthlyReports");
	}

	public void getWeeklyTab() {
		 click("weeklyReports");
	}

	public void getDailyTab() {
		 click("dailyReports");
	}

	public void getCancelButton() {
		click("cancelReports");
	}

}


