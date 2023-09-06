package tests;

import org.apache.log4j.Logger;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import genericPages.CommonMethod;
import pages.AddBill;
import pages.LoginPage;

public class AddBillTest extends CommonMethod {

	public AddBillTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger = LogManager.getLogger(AddBillTest.class);

	@BeforeClass
	public void openApplication() throws Exception {
		test = reports.startTest("Open Application");
		// Open the browser and hit the url
		initializeBrowser();

		LoginPage l = new LoginPage();

		l.clickGotItBtn();
		logger.info("Clicked GotIt Btn");

		l.enterValiedUserName();
		logger.info("Entered Username");

		l.enterValiedPassword();
		logger.info("Entered Password");

		l.clickRememberMeBtn();
		logger.info("Clicked RememberMeField");

		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");

		String actual = null;
		try {
			if (l.verifyHomePage()) {
				actual = "success";
				logger.info("Success");
			} else {
				actual = "failure";
				logger.error("failure");
			}
		} catch (Exception e) {
			actual = "failure";
			logger.error("failure");
		}
		Assert.assertTrue(actual.equals("success"));
		logger.info("Assertion Passed");
	}

	@Test(priority = 1)
	public void saveAndprintBill() throws Exception {
		test = reports.startTest("TC001 Save and print Bill");
		AddBill ab = new AddBill();
		ab.clickBilling();
		logger.info("Clicking Billing Btn");
		ab.clickAddBill();
		logger.info("Clicking AddBill Btn");
		ab.enterPatientName();
		logger.info("Entered Patient name");
		ab.clickPatientNameSugg();
		logger.info("Clicked Patient Name Suggestion");
		ab.enterEmail();
		logger.info("Entered Email");
		ab.billdescription();
		logger.info("Entered Bill Description");
		ab.billQty();
		logger.info("Entered Bill Qty");
		ab.billRate();
		logger.info("Entered bill Rate");
		ab.clickbillItemDetailsPlusSign();
		logger.info("Clicked Bill plus sign");
		ab.bedNumber();
		logger.info("Entered Bed number");
		ab.AdmissionClick();
		logger.info("Clicked Admission Date Field");
		ab.AdmissionMonth();
		logger.info("Entered Admission Month");
		ab.AdmissionDate();
		logger.info("Entered Admission date");
		ab.AdmissionYear();
		logger.info("Entered admission Year");
		ab.dischargeClick();
		logger.info("Clicked Discharge Date Field");
		ab.dischargeMonth();
		logger.info("Entered discharge Month");
		ab.dischargeDate();
		logger.info("Entered Discharge Date");
		ab.dischargeYear();
		logger.info("Entered Discharge Year");
		ab.enterCGSTPercent();
		logger.info("Entered CGST Percent");
		ab.enterSGSTPercent();
		logger.info("Entered SGST Percent");
		ab.clickSaveAndPrintBtn();
		logger.info("Clicked Print and Save btn");

		String actual = getWebElement("notification").getText();
		String expected="Billing created successfully!";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		ab.clickCancelNotification();
		logger.info("Clicked cancel Notification");

		scrollDown();
		ab.clickBillBackBtn();
		logger.info("Clicked Bill Back Btn");

	}

	@Test(priority = 2)
	public void clickResetBtn() throws Exception {
		test = reports.startTest("TC002 Clicking Reset Btn");
		AddBill ab = new AddBill();
		Thread.sleep(5000);
		ab.clickResetBtn();
		logger.info("Clicked Reset Btn");
	}

	@Test(priority = 3)
	public void printWithoutAddingBillingItem() throws Exception {
		test = reports.startTest("TC003 SaveBill without adding Billing Item");
		AddBill ab = new AddBill();
		ab.enterPatientName();
		logger.info("Entered Patient name");
		ab.clickPatientNameSugg();
		logger.info("Clicked Patient Name Suggestion");
		ab.enterEmail();
		logger.info("Entered Email");
		ab.clickSaveAndPrintBtn();
		logger.info("Clicked Save and print Btn");

		String actual = getWebElement("notification").getText();
		String expected="Please Add Billing Items";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		ab.clickCancelNotification();
		logger.info("Clicked cancel Notification");
	}

	@Test(priority = 4)
	public void addingIncorrectBillItemDetails() throws Exception {
		test = reports.startTest("TC004 Adding more than One Billing Item");
		AddBill ab = new AddBill();
		ab.billdescription();
		logger.info("Entered Bill Description");
		ab.billQty();
		logger.info("Entered Bill Qty");
		ab.billRate();
		logger.info("Entered bill Rate");
		scrollTillElement();
		ab.clickbillItemDetailsPlusSign();
		logger.info("Clicked Bill plus sign");
		ab.billdescription();
		logger.info("Entered again Bill Description");
		ab.billQty();
		logger.info("Entered again Bill Qty");
		ab.billRate();
		logger.info("Entered again bill Rate");
		ab.clickbillItemDetailsPlusSign();
		logger.info("Clicked Bill plus sign");
		ab.invaliedBilldescription();
		logger.info("Entered InvaliedBill Description");
		ab.invaliedBillQty();
		logger.info("Entered InvaliedBill Qty");
		ab.invaliedBillRate();
		logger.info("Entered Invaliedbill Rate");
		ab.clickbillItemDetailsPlusSign();
		logger.info("Clicked Bill plus sign");

		String actual = getWebElement("notification").getText();
		String expected="Please Fill Rate in with number";
		Assert.assertEquals(actual, expected);
		logger.info("Assertion Passed");

		ab.clickCancelNotification();
		logger.info("Clicked cancel Notification");

		ab.clearBilldescription();
		logger.info("Cleared Bill Description");
		ab.clearBillQty();
		logger.info("Cleared Bill Qty");
		ab.clearBillRate();
		logger.info("Cleared Bill Rate");
	}

	@Test(priority = 5)
	public void printBill() throws Exception {
		test=reports.startTest("TC005 Printing the Bill");
		//driver.navigate().refresh();
		AddBill ab=new AddBill();
		ab.clickSaveAndPrintBtn();
		logger.info("Clicked Print and Save btn");
		//alertHandling();
		ab.clickCancelNotification();
		logger.info("Cancelling Notification");
		ab.clickBillPrintBtn();
		logger.info("Printing Bill");
		Thread.sleep(4000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);

	}

	@Test(priority=6)
	public void downloadBill() throws Exception {
		test=reports.startTest("TC006 Downloading Bill");
		AddBill ab=new AddBill();
		ab.clickBillDownloadBtn();
		logger.info("Downloading Bill");
		ab.clickBillDownloadBtn();
		logger.info("Downloading Bill Again");
		ab.clickBillBackBtn();
		logger.info("Clicking Bill Back Btn");
		ab.clickBackBtn();
		logger.info("Clicking Back Btn");

	}

	@AfterClass
	public void closeBrowser() {
		// Close the browser
		driver.close();
		reports.endTest(test);
		reports.flush();
	}
}
