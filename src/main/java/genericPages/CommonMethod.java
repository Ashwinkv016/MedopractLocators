package genericPages;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommonMethod extends MasterPage {

	public static WebDriverWait wait;
	public static ExtentTest test;
	public static ExtentReports reports = new ExtentReports("src\\main\\resources\\reports\\ExtentReport.html", true);
	public static CommonMethod base;

	public CommonMethod() throws Exception {
		super();
		base = this;

	}

	@BeforeSuite
	public void configuration() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);
		System.out.println("Current Date and Time: " + formattedDateTime);

	}

	@AfterSuite
	public void closure() {
		reports.flush();
		driver.quit();
	}

	// Initializing the browser
	public void initializeBrowser() throws Exception {

		if (propConfig.getProperty("browser").equalsIgnoreCase("chrome")) {
			ChromeOptions o = new ChromeOptions();
			o.addArguments("--disable-notifications");
			o.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(o);
		} else if (propConfig.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		base = new CommonMethod();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(propConfig.getProperty("url"));

	}


	public static String getExcelData(String sheetName,int rowNum,int cell) throws EncryptedDocumentException,IOException {
		FileInputStream fisexcel=new FileInputStream("C:\\Users\\vashw\\git\\repository\\Medopract\\Excel\\Login.xlsx");
		//FileInputStream fisexcel=new FileInputStream(System.getProperty("user.dir") + "\\Excel\\Login.xlsx");
		Workbook wb = WorkbookFactory.create(fisexcel);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cell).getStringCellValue();
		return data;
	}


	// Click on the webelement
	public void click(String locatorKey) {
		try {
			getWebElement(locatorKey).click();
			test.log(LogStatus.PASS, "Click on the element: " + locatorKey,
					"Click on the element " + locatorKey + " Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Click on the element: " + locatorKey,
					"Failed to click on the element " + locatorKey + e.getLocalizedMessage());
		}

	}

	// Enter the Data
	public void enterData(String locatorKey, String testData) {
		try {

			getWebElement(locatorKey).sendKeys(propTestData.getProperty(testData));
			test.log(LogStatus.PASS, "Enter the : " + locatorKey, "Enter the text into " + testData + " Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Enter the : " + locatorKey, "Failed to enter " + testData + e.getMessage());
		}

	}

	// Enter the Locationproperty
	public void enterLocationproperty(String locatorKey, String testData) {
		try {

			getWebElement(locatorKey).sendKeys(propTestData.getProperty(System.getProperty("user.dir") + testData));
			test.log(LogStatus.PASS, "Enter the : " + locatorKey, "Enter the text into " + testData + " Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Enter the : " + locatorKey, "Failed to enter " + testData + e.getMessage());
		}

	}

	// Select the dropdown values
	public void selectDropdown(String locatorKey, String testData) {
		try {
			WebElement element = getWebElement(locatorKey);
			Select s = new Select(element);
			s.selectByVisibleText(propTestData.getProperty(testData));
			test.log(LogStatus.PASS, "Select the dropdown value : " + locatorKey,
					"Select the dropdown value " + locatorKey + " Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Select the dropdown value : " + locatorKey,
					"Fail to Select the dropdown value " + e.getMessage());
		}

	}

	// Clear the Data
	public void clearData(String locatorKey) {
		try {
			getWebElement(locatorKey).clear();
			test.log(LogStatus.PASS, "Clear the data : " + locatorKey,
					"Clear the data " + locatorKey + " Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Clear the data : " + locatorKey,
					"Failed to clear the data " + locatorKey + e.getMessage());
		}

	}

	// Mouse Hover
	public void moveToElement(String locatorKey) {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(getWebElement(locatorKey)).build().perform();
			test.log(LogStatus.PASS, "Move to the element : " + locatorKey,
					"Move to the element " + locatorKey + "Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Move to the element : " + locatorKey,
					"Failed to move to the element " + locatorKey);
		}

	}

	// Click List of WebElement
	public void clickListElement(String locatorKey, String testData) {
		try {
			List<WebElement> listOfElements = driver
					.findElements(By.xpath(propLocator.getProperty(locatorKey.split(",")[1])));
			for (int i = 0; i < listOfElements.size(); i++) {
				if (listOfElements.get(i).getText().equalsIgnoreCase(propTestData.getProperty(testData))) {
					listOfElements.get(i).click();
				}
			}
			test.log(LogStatus.PASS, "Click on the list element : " + locatorKey,
					"Click on the list element " + locatorKey + "Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Click on the list element : " + locatorKey,
					"Failed to click on the list element ");
		}
	}

	// Click on Radio button
	public void clickRadioButton(String locatorKey) {
		try {
			List<WebElement> radios = driver.findElements(By.xpath(propLocator.getProperty(locatorKey.split(",")[1])));
			String expResult = "testData1";
			for (int i = 0; i < radios.size(); i++) {
				if (radios.get(i).getText().equalsIgnoreCase(expResult)) {
					radios.get(i).click();
					break;
				}
			}
			test.log(LogStatus.PASS, "Click on the radio button : " + locatorKey,
					"Click on the radio button " + locatorKey + " Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Click on the radio button : " + locatorKey,
					"Failed to Click on the radio button " + e.getMessage());
		}

	}

	// Take a Screenshot
	public String takeScreenShot(String imageName) throws Exception {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destLocation = System.getProperty("user.dir") + "\\src\\main\\resources\\reports\\screenshots\\"
				+ imageName + ".png";
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")
				+ "\\src\\main\\resources\\reports\\screenshots\\" + imageName + ".png"));
		return "screenshots\\" + imageName + ".png";
	}

	// Alert operation
	public void alertHandling() {
		try {
			Alert alert = driver.switchTo().alert();
			driver.switchTo().alert().accept();
			test.log(LogStatus.PASS, "Alert handlled Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to handlled the Alert");
		}
	}

	// Scroll down using javascript
	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}

	// Scroll till the Element
	public void scrollTillElement() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}

	// To get webelement
	public WebElement getWebElement(String locatorKey) throws Exception {
		try {
			String locatorValues[] = propLocator.getProperty(locatorKey).split(";");
			String locatorType = locatorValues[0].trim();
			String locatorValue = locatorValues[1].trim();
			WebElement element = null;
			if (locatorType.equalsIgnoreCase("id")) {
				element = driver.findElement(By.id(locatorValue));
			} else if (locatorType.equalsIgnoreCase("class")) {
				element = driver.findElement(By.className(locatorValue));
			} else if (locatorType.equalsIgnoreCase("css")) {
				element = driver.findElement(By.cssSelector(locatorValue));
			} else if (locatorType.equalsIgnoreCase("xpath")) {
				element = driver.findElement(By.xpath(locatorValue));
			} else if (locatorType.equalsIgnoreCase("linktext")) {
				element = driver.findElement(By.linkText(locatorValue));
			}

			return element;
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Get the WebElement : " + locatorKey, "Failed to get the WebElement "
					+ e.getMessage() + test.addScreenCapture(takeScreenShot(locatorKey)));
			return null;
		}
	}

	// To get list of webelements
	public List<WebElement> getWebElements(String locatorkey) {
		String locatorValues[] = propLocator.getProperty(locatorkey).split(",");
		String locatorType = locatorValues[0].trim();
		String locatorValue = locatorValues[1].trim();
		List<WebElement> elements = null;
		if (locatorType.equalsIgnoreCase("id")) {
			elements = driver.findElements(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("class")) {
			elements = driver.findElements(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			elements = driver.findElements(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			elements = driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			elements = driver.findElements(By.linkText(locatorValue));
		}
		return elements;
	}

	// Verify element presence on webpage
	public void verifyElementPresent(String locatorkey) throws Exception {
		try {
			getWebElement(locatorkey).isDisplayed();
			test.log(LogStatus.PASS, "Verify element presence:" + locatorkey,
					"Text '" + getWebElement(locatorkey).getText() + "' is displayed Successfully"
							+ test.addScreenCapture(takeScreenShot(locatorkey)));
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Verify element presence: " + locatorkey,
					"Text '" + getWebElement(locatorkey).getText() + "' is not displayed");
		}
	}

	public void verifyTextPresent(String locatorkey) throws Exception {
	    try {
	        WebElement webElement = getWebElement(locatorkey); // Get the web element
	        String text = webElement.getText(); // Get the text of the web element
	        if (!text.isEmpty()) { // Check if the text is not empty
	            test.log(LogStatus.PASS, "Verify element presence: " + locatorkey,
	                    "Text '" + text + "' is displayed Successfully" + test.addScreenCapture(takeScreenShot(locatorkey)));
	        } else {
	            test.log(LogStatus.FAIL, "Verify element presence: " + locatorkey,
	                    "Text is not displayed");
	        }
	    } catch (Exception e) {
	        test.log(LogStatus.FAIL, "Verify element presence: " + locatorkey,
	                "An exception occurred: " + e.getMessage());
	    }
	}


	public void waitForElementToBeClickable(String locatorKey, int timeoutInSeconds) {
		try {
			WebElement element = getWebElement(locatorKey);
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			test.log(LogStatus.PASS, "Wait for the Element to be clickable: " + locatorKey,
					"The element clicked " + locatorKey + " Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Wait for the element to be clickable: " + locatorKey,
					"The element is not clickable " + locatorKey + " Failure");
		}
	}

	public void waitForElementVisibility(String locatorKey, int timeoutInSeconds) {
		try {
			WebElement element = getWebElement(locatorKey);
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			test.log(LogStatus.PASS, "Wait for the element to be visible " + locatorKey,
					"The element visible " + locatorKey + " Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Wait for the element to be visible  " + locatorKey,
					"The element is not visible " + locatorKey + " Failure");
		}
	}
}