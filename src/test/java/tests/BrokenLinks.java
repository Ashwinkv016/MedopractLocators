package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import genericPages.CommonMethod;
import pages.AddBill;
import pages.AddPatientPage;
import pages.AddPrescriptionPage;
import pages.AppointmentsCalenderPage;
import pages.ForgotPasswordField;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.ReportsPage;
import pages.ViewBill;
import pages.ViewOrEditPage;
import pages.ViewPrescriptionPage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinks extends CommonMethod{

	Logger logger=LogManager.getLogger(BrokenLinks.class);

	public BrokenLinks() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeTest
	public void openApplication() throws Exception {
		test=reports.startTest("Open Application");

		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test(priority=1)
	public void verifyBrokenLinkLoginPage() throws Exception {
		test=reports.startTest("TC001 Verify Login Page Broken Link");
		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/");
		List<WebElement> links = driver.findElements(By.tagName("a"));

		 System.out.println("");
		System.out.println("Total links found: " + links.size()+" in Login Page");

		for (WebElement link : links) {
			String url = link.getAttribute("href");
			try {
				URL link1 = new URL(url);
				HttpURLConnection httpConn = (HttpURLConnection) link1.openConnection();
				httpConn.setConnectTimeout(2000);
				httpConn.connect();

				if (httpConn.getResponseCode() >= 400) {
					System.out.println(url + " - " + httpConn.getResponseMessage() + " is a broken link.");
				} else {
					System.out.println(url + " - " + httpConn.getResponseMessage() + " is a valid link.");
				}

				httpConn.disconnect();
			} catch (Exception e) {
				System.out.println(url + " -Exception occurred:  " + e.getMessage());
			}
		}
		Thread.sleep(5000);
		
		RegistrationPage rp = new RegistrationPage();
		rp.clickGotItBtn();
		
		scrollDown();
		Thread.sleep(2000);
		
		rp.clickRegisterNow();
		List<WebElement> links1 = driver.findElements(By.tagName("a"));

		 System.out.println("");
		System.out.println("Total links found: " + links1.size()+" in Registration Page");

		for (WebElement link : links1) {
			String url = link.getAttribute("href");
			try {
				URL link1 = new URL(url);
				HttpURLConnection httpConn = (HttpURLConnection) link1.openConnection();
				httpConn.setConnectTimeout(2000);
				httpConn.connect();

				if (httpConn.getResponseCode() >= 400) {
					System.out.println(url + " - " + httpConn.getResponseMessage() + " is a broken link.");
				} else {
					System.out.println(url + " - " + httpConn.getResponseMessage() + " is a valid link.");
				}

				httpConn.disconnect();
			} catch (Exception e) {
				System.out.println(url + " -Exception occurred:  " + e.getMessage());
			}
		}
		scrollDown();
		Thread.sleep(2000);
		
		rp.clickImAlreadyUser();
		Thread.sleep(2000);
		
		ForgotPasswordField fpf = new ForgotPasswordField();
		
		fpf.clickForgotPassword();
		
		List<WebElement> links11 = driver.findElements(By.tagName("a"));

		 System.out.println("");
		System.out.println("Total links found: " + links11.size()+" in Forget Password page");

		for (WebElement link : links11) {
			String url = link.getAttribute("href");
			try {
				URL link1 = new URL(url);
				HttpURLConnection httpConn = (HttpURLConnection) link1.openConnection();
				httpConn.setConnectTimeout(2000);
				httpConn.connect();

				if (httpConn.getResponseCode() >= 400) {
					System.out.println(url + " - " + httpConn.getResponseMessage() + " is a broken link.");
				} else {
					System.out.println(url + " - " + httpConn.getResponseMessage() + " is a valid link.");
				}

				httpConn.disconnect();
			} catch (Exception e) {
				System.out.println(url + " -Exception occurred:  " + e.getMessage());
			}
		}
		scrollDown();
		Thread.sleep(2000);
		
		fpf.clickbackLoginPage();
		Thread.sleep(3000);
		
	}

	@Test(priority=2)
	public void verifyBrokenLinkHomePage() throws Exception {
		test=reports.startTest("TC002 Verify Home Page Broken Link");
		LoginPage l = new LoginPage();
		getWebElement("userLogin").sendKeys(propTestData.getProperty("valid_UserName"));
		getWebElement("passLogin").sendKeys(propTestData.getProperty("valid_Password"));
		Thread.sleep(2000);
		l.clickSubmitLoginBtn();
		Thread.sleep(2000);

		List<WebElement> links1 = driver.findElements(By.tagName("a"));

		 System.out.println("");
		System.out.println("Total links found: " + links1.size()+" in Home Page");

		for (WebElement link : links1) {
			String url = link.getAttribute("href");
			try {
				URL link1 = new URL(url);
				HttpURLConnection httpConn = (HttpURLConnection) link1.openConnection();
				httpConn.setConnectTimeout(2000);
				httpConn.connect();

				if (httpConn.getResponseCode() >= 400) {
					System.out.println(url + " - " + httpConn.getResponseMessage() + " is a broken link.");
				} else {
					System.out.println(url + " - " + httpConn.getResponseMessage() + " is a valid link.");
				}

				httpConn.disconnect();
			} catch (Exception e) {
				System.out.println(url + " -Exception occurred:  " + e.getMessage());
			}
		}

	}


	@Test(priority = 3)
	public void verifyBrokenLinkPatientpage() throws EncryptedDocumentException, IOException, Exception {
		test=reports.startTest("TC003 Verify Broken Link");

		AddPatientPage ap=new AddPatientPage();
		scrollTillElement();
		Thread.sleep(3000);
		ap.clickPatientMenu();

		

		List<WebElement> links = driver.findElements(By.tagName("a"));

		 System.out.println("");
		System.out.println("Total links found: " + links.size()+" in Patient Visit Page");

		for (WebElement link : links) {
			String url = link.getAttribute("href");
			try {
				URL link1 = new URL(url);
				HttpURLConnection httpConn = (HttpURLConnection) link1.openConnection();
				httpConn.setConnectTimeout(2000);
				httpConn.connect();

				if (httpConn.getResponseCode() >= 400) {
					System.out.println(url + " - " + httpConn.getResponseMessage() + " is a broken link.");
				} else {
					System.out.println(url + " - " + httpConn.getResponseMessage() + " is a valid link.");
				}

				httpConn.disconnect();
			} catch (Exception e) {
				System.out.println(url + " -Exception occurred:  " + e.getMessage());
			}
			Thread.sleep(2000);
		}
		
		ap.clickAddPatient();

		List<WebElement> links1 = driver.findElements(By.tagName("a"));

		 System.out.println("");
		System.out.println("Total links found: " + links1.size()+" in Add Patient Page");

		for (WebElement link : links1) {
			String url = link.getAttribute("href");
			try {
				URL link1 = new URL(url);
				HttpURLConnection httpConn = (HttpURLConnection) link1.openConnection();
				httpConn.setConnectTimeout(2000);
				httpConn.connect();

				if (httpConn.getResponseCode() >= 400) {
					System.out.println(url + " - " + httpConn.getResponseMessage() + " is a broken link.");
				} else {
					System.out.println(url + " - " + httpConn.getResponseMessage() + " is a valid link.");
				}

				httpConn.disconnect();
			} catch (Exception e) {
				System.out.println(url + " -Exception occurred:  " + e.getMessage());
			}
			Thread.sleep(3000);
		}
		
		ViewOrEditPage ve=new ViewOrEditPage();
		ve.clickViewOrEdit();
		
		List<WebElement> links11 = driver.findElements(By.tagName("a"));

		 System.out.println("");
		System.out.println("Total links found: " + links11.size()+" in Add Patient Page");

		for (WebElement link : links11) {
			String url = link.getAttribute("href");
			try {
				URL link1 = new URL(url);
				HttpURLConnection httpConn = (HttpURLConnection) link1.openConnection();
				httpConn.setConnectTimeout(2000);
				httpConn.connect();

				if (httpConn.getResponseCode() >= 400) {
					System.out.println(url + " - " + httpConn.getResponseMessage() + " is a broken link.");
				} else {
					System.out.println(url + " - " + httpConn.getResponseMessage() + " is a valid link.");
				}

				httpConn.disconnect();
			} catch (Exception e) {
				System.out.println(url + " -Exception occurred:  " + e.getMessage());
			}
		}
		Thread.sleep(3000);
		
		
	}
		
		@Test(priority = 4)
		public void verifyBrokenLinkAppointmentsCalenderpage() throws EncryptedDocumentException, IOException, Exception {
			test=reports.startTest("TC003 Verify Appointments Calender Page Broken Link");

			AppointmentsCalenderPage acp=new AppointmentsCalenderPage();
			acp.getClickAppointmentCalender();
			
			List<WebElement> links = driver.findElements(By.tagName("a"));
			
            System.out.println("");
			System.out.println("Total links found: " + links.size()+" in Appointments Calender page");

			for (WebElement link : links) {
				String url = link.getAttribute("href");
				try {
					URL link1 = new URL(url);
					HttpURLConnection httpConn = (HttpURLConnection) link1.openConnection();
					httpConn.setConnectTimeout(2000);
					httpConn.connect();

					if (httpConn.getResponseCode() >= 400) {
						System.out.println(url + " - " + httpConn.getResponseMessage() + " is a broken link.");
					} else {
						System.out.println(url + " - " + httpConn.getResponseMessage() + " is a valid link.");
					}

					httpConn.disconnect();
				} catch (Exception e) {
					System.out.println(url + " -Exception occurred:  " + e.getMessage());
				}
			}
			Thread.sleep(3000);
	}
		
		@Test(priority = 5)
		public void verifyBrokenLinkPrescriptionpage() throws EncryptedDocumentException, IOException, Exception {
			test=reports.startTest("TC005 Verify Prescription Page Broken Link");

			AddPrescriptionPage app=new AddPrescriptionPage();
			app.getclickPrescription();
			

			List<WebElement> links = driver.findElements(By.tagName("a"));

			   System.out.println("");
			System.out.println("Total links found: " + links.size()+" in Add Prescription Page");

			for (WebElement link : links) {
				String url = link.getAttribute("href");
				try {
					URL link1 = new URL(url);
					HttpURLConnection httpConn = (HttpURLConnection) link1.openConnection();
					httpConn.setConnectTimeout(2000);
					httpConn.connect();

					if (httpConn.getResponseCode() >= 400) {
						System.out.println(url + " - " + httpConn.getResponseMessage() + " is a broken link.");
					} else {
						System.out.println(url + " - " + httpConn.getResponseMessage() + " is a valid link.");
					}

					httpConn.disconnect();
				} catch (Exception e) {
					System.out.println(url + " -Exception occurred:  " + e.getMessage());
				}
				Thread.sleep(3000);
			}
			
			ViewPrescriptionPage vpp=new ViewPrescriptionPage();
			vpp.getviewPrescriptionsLink();
			

			List<WebElement> links1 = driver.findElements(By.tagName("a"));

			   System.out.println("");
			System.out.println("Total links found: " + links1.size()+" in View Prescription Page");

			for (WebElement link : links1) {
				String url = link.getAttribute("href");
				try {
					URL link1 = new URL(url);
					HttpURLConnection httpConn = (HttpURLConnection) link1.openConnection();
					httpConn.setConnectTimeout(2000);
					httpConn.connect();

					if (httpConn.getResponseCode() >= 400) {
						System.out.println(url + " - " + httpConn.getResponseMessage() + " is a broken link.");
					} else {
						System.out.println(url + " - " + httpConn.getResponseMessage() + " is a valid link.");
					}

					httpConn.disconnect();
				} catch (Exception e) {
					System.out.println(url + " -Exception occurred:  " + e.getMessage());
				}
				Thread.sleep(3000);
			}
	}
		
		@Test(priority = 6)
		public void verifyBrokenLinkBillingpage() throws EncryptedDocumentException, IOException, Exception {
			test=reports.startTest("TC006 Verify Billing Page Broken Link");

			AddBill ab=new AddBill();
			ab.clickBilling();
			

			List<WebElement> links = driver.findElements(By.tagName("a"));

			   System.out.println("");
			System.out.println("Total links found: " + links.size()+"in Add Bill Page");

			for (WebElement link : links) {
				String url = link.getAttribute("href");
				try {
					URL link1 = new URL(url);
					HttpURLConnection httpConn = (HttpURLConnection) link1.openConnection();
					httpConn.setConnectTimeout(2000);
					httpConn.connect();

					if (httpConn.getResponseCode() >= 400) {
						System.out.println(url + " - " + httpConn.getResponseMessage() + " is a broken link.");
					} else {
						System.out.println(url + " - " + httpConn.getResponseMessage() + " is a valid link.");
					}

					httpConn.disconnect();
				} catch (Exception e) {
					System.out.println(url + " -Exception occurred:  " + e.getMessage());
				}
           Thread.sleep(3000);
			}
			
			ViewBill vb=new ViewBill();
			vb.clickViewBill();
			

			List<WebElement> links1 = driver.findElements(By.tagName("a"));

			   System.out.println("");
			System.out.println("Total links found: " + links1.size()+"in View Bill Page");

			for (WebElement link : links1) {
				String url = link.getAttribute("href");
				try {
					URL link1 = new URL(url);
					HttpURLConnection httpConn = (HttpURLConnection) link1.openConnection();
					httpConn.setConnectTimeout(2000);
					httpConn.connect();

					if (httpConn.getResponseCode() >= 400) {
						System.out.println(url + " - " + httpConn.getResponseMessage() + " is a broken link.");
					} else {
						System.out.println(url + " - " + httpConn.getResponseMessage() + " is a valid link.");
					}

					httpConn.disconnect();
				} catch (Exception e) {
					System.out.println(url + " -Exception occurred:  " + e.getMessage());
				}
           Thread.sleep(3000);
			}
	}
		
		@Test(priority = 7)
		public void verifyBrokenLinkReportspage() throws EncryptedDocumentException, IOException, Exception {
			test=reports.startTest("TC003 Verify Reports Page Broken Link");

			ReportsPage rp=new ReportsPage();
			rp.getClickReports();
			
			List<WebElement> links = driver.findElements(By.tagName("a"));

			 System.out.println("");
			System.out.println("Total links found: " + links.size()+" in Reports Page");

			for (WebElement link : links) {
				String url = link.getAttribute("href");
				try {
					URL link1 = new URL(url);
					HttpURLConnection httpConn = (HttpURLConnection) link1.openConnection();
					httpConn.setConnectTimeout(2000);
					httpConn.connect();

					if (httpConn.getResponseCode() >= 400) {
						System.out.println(url + " - " + httpConn.getResponseMessage() + " is a broken link.");
					} else {
						System.out.println(url + " - " + httpConn.getResponseMessage() + " is a valid link.");
					}

					httpConn.disconnect();
				} catch (Exception e) {
					System.out.println(url + " -Exception occurred:  " + e.getMessage());
				}
			}
	}
		

	@AfterTest
	public void closeBrowser() {
		driver.close();
		reports.endTest(test);
		reports.flush();
	}
}
