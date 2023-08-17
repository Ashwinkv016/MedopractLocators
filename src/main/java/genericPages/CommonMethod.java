package genericPages;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethod extends MasterPage {
	public WebDriver driver;
	public WebDriverWait wait;
	public static Logger logger;
	public CommonMethod base;

	public CommonMethod() throws Exception {
		super();
		base = this;

	}

	// Initializing the browser
	public void initializeBrowser() throws Exception {

		if (propConfig.getProperty("browser").equalsIgnoreCase("chrome")) {
			ChromeOptions o = new ChromeOptions();
			o.addArguments("--disable-notifications");
			o.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(o);
		} else if (propConfig.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
			Thread.sleep(2000);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Initialize the WebDriverWait here
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		base = new CommonMethod();
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\main\\resources\\log4j.properties");
		logger = LogManager.getLogger(CommonMethod.class);
		logger.info("Wait for the condition" + wait);
		driver.get(propConfig.getProperty("url"));

	}

	// Click on the webelement
	public void click(String locatorKey) {
		try {
			getWebElement(locatorKey).click();

		} catch (Exception e) {

		}

	}

	// Enter the Data
	public void enterData(String locatorKey, String testData) {
		try {

			getWebElement(locatorKey).sendKeys(propTestData.getProperty(testData));

		} catch (Exception e) {

		}

	}

	// Clear the Data
	public void clearData(String locatorKey) {
		try {
			getWebElement(locatorKey).clear();

		} catch (Exception e) {

		}

	}

	// Mouse Hover
	public void moveToElement(String locatorKey) {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(getWebElement(locatorKey)).build().perform();

		} catch (Exception e) {

		}

	}

	// Click List of WebElement
	public void clickListElement(String locatorKey, String testData) {
		try {
			List<WebElement> listOfElements = driver
					.findElements(By.xpath(propLocator.getProperty(locatorKey.split(",")[1])));
			for (int i = 0; i < listOfElements.size(); i++) {
				if (listOfElements.get(i).getText().equalsIgnoreCase(propLocator.getProperty(testData))) {
					listOfElements.get(i).click();
				}
			}

		} catch (Exception e) {

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

		} catch (Exception e) {

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

	// Select the dropdown values
	public void selectDropdown(String locatorKey) {
		try {
			WebElement element = driver.findElement(By.xpath(propLocator.getProperty(locatorKey)));
			Select webElem = new Select(element);
			webElem.selectByVisibleText("testData");

		} catch (Exception e) {

		}

	}

	// Alert operation
	public void alertHandling() {
		try {
			Alert alert = driver.switchTo().alert();
			driver.switchTo().alert().accept();
		} catch (Exception e) {
		}

	}

	// Scroll down using javascript
	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}

	// Scroll till the Element
	public void scrollTillElement(String locatorKey) throws Exception {
		WebElement element = getWebElement(locatorKey); // Get the WebElement using the locatorKey
		if (element != null) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
		} else {
			logger.error("Element not found for scrolling: " + locatorKey);
		}
	}

	// To get webelement
	public WebElement getWebElement(String locatorKey) throws Exception {
		try {
			String locatorValues[] = propLocator.getProperty(locatorKey).split(";");
			logger.info("Get Locator Values" + locatorValues);
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
			} else if (locatorType.equalsIgnoreCase("name")) {
				element = driver.findElement(By.linkText(locatorValue));
			}
			logger.info("Entered Locator Values" + element);
			return element;
		} catch (Exception e) {

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
		} else if (locatorType.equalsIgnoreCase("name")) {
			elements = driver.findElements(By.linkText(locatorValue));
		}
		return elements;
	}

	// Verify element presence on webpage
	public void verifyElementPresent(String locatorkey) throws Exception {
		try {
			getWebElement(locatorkey).isDisplayed();

		} catch (Exception e) {

		}
	}

	// Verify element presence on webpage
	public void verifyTextPresent(String locatorkey) throws Exception {
		try {
			getWebElement(locatorkey).getText();

		} catch (Exception e) {

		}
	}

	public By getLocator(String locatorKey) {
		try {
			String locatorValues[] = propLocator.getProperty(locatorKey).split(";");
			String locatorType = locatorValues[0].trim();
			String locatorValue = locatorValues[1].trim();

			if (locatorType.equalsIgnoreCase("id")) {
				return By.id(locatorValue);
			} else if (locatorType.equalsIgnoreCase("class")) {
				return By.className(locatorValue);
			} else if (locatorType.equalsIgnoreCase("css")) {
				return By.cssSelector(locatorValue);
			} else if (locatorType.equalsIgnoreCase("xpath")) {
				return By.xpath(locatorValue);
			} else if (locatorType.equalsIgnoreCase("linktext")) {
				return By.linkText(locatorValue);
			} else if (locatorType.equalsIgnoreCase("name")) {
				return By.name(locatorValue);
			}

			return null; // Handle other locator types if needed
		} catch (Exception e) {
			logger.error("Error occurred while getting the locator: " + e.getMessage());
			return null;
		}
	}
	/**
	 * public void waitForElementToBeClickable(String locatorKey, int
	 * timeoutInSeconds) { try { WebElement element = getWebElement(locatorKey);
	 * logger.info("The element is Clickable" + wait);
	 * wait.until(ExpectedConditions.elementToBeClickable(element));
	 * logger.info("The element is Clickable" + wait); } catch (Exception e) {
	 * logger.error("Error occurred while waiting for element to be clickable: " +
	 * e.getMessage()); } }
	 * 
	 * public void waitForElementVisibility(String locatorKey, int timeoutInSeconds)
	 * { try { WebElement element = getWebElement(locatorKey); logger.info("The
	 * element is Visible" + wait);
	 * wait.until(ExpectedConditions.visibilityOfAllElements(element));
	 * logger.info("The element is Visible" + wait); } catch (Exception e) {
	 * logger.error("Error occurred while waiting for element to be visible: " +
	 * e.getMessage()); } }
	 **/
}