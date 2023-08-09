package genericPages;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class CommonMethod extends MasterPage{
	//public static ExtentTest test;
	//public static ExtentReports reports = new ExtentReports("src\\main\\resources\\reports\\ExtentReport.html", false);
	public  static Logger logger;
	public static WebDriverWait wait;
	public CommonMethod() throws Exception {
	}

	// Initializing the browser
	public void initializeBrowser() {

		if (propConfig.getProperty("browser").equalsIgnoreCase("chrome")) {
			ChromeOptions o = new ChromeOptions();
			o.addArguments("--disable-notifications");
			o.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(o);
		} else if (propConfig.getProperty("browser").equalsIgnoreCase("firefox")) {
			
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(propConfig.getProperty("url"));
	}
	
	// Click on the webelement
		public void click(String locatorKey) {
			try {
				getWebElement(locatorKey).click();
			//	test.log(LogStatus.PASS, "Click on the element: " + locatorKey,"Click on the element " + locatorKey + " Successfully");
			} catch (Exception e) {
				//test.log(LogStatus.FAIL, "Click on the element: " + locatorKey,"Failed to click on the element " + locatorKey + e.getLocalizedMessage());
			}

		}

		// Enter the Data
		public void enterData(String locatorKey, String testData) {
			try {

				getWebElement(locatorKey).sendKeys(propTestData.getProperty(testData));
			//	test.log(LogStatus.PASS, "Enter the : " + locatorKey, "Enter the text into " + testData + " Successfully");
			} catch (Exception e) {
				//test.log(LogStatus.FAIL, "Enter the : " + locatorKey, "Failed to enter " + testData + e.getMessage());
			}

		}

		// Clear the Data
		public void clearData(String locatorKey) {
			try {
				getWebElement(locatorKey).clear();
				//test.log(LogStatus.PASS, "Clear the data : " + locatorKey,"Clear the data " + locatorKey + " Successfully");
			} catch (Exception e) {
				//test.log(LogStatus.FAIL, "Clear the data : " + locatorKey,"Failed to clear the data " + locatorKey + e.getMessage());
			}

		}

		// Mouse Hover
		public void moveToElement(String locatorKey) {
			try {
				Actions act = new Actions(driver);
				act.moveToElement(getWebElement(locatorKey)).build().perform();
			//	test.log(LogStatus.PASS, "Move to the element : " + locatorKey,"Move to the element " + locatorKey + "Successfully");
			} catch (Exception e) {
				//test.log(LogStatus.FAIL, "Move to the element : " + locatorKey,"Failed to move to the element " + locatorKey);
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
			//	test.log(LogStatus.PASS, "Select the dropdown value : " + locatorKey,"Select the dropdown value " + locatorKey + " Successfully");
			} catch (Exception e) {
				//test.log(LogStatus.FAIL, "Select the dropdown value : " + locatorKey,"Faile to Select the dropdown value " + e.getMessage());
			}

		}

		// Alert operation
		public void alertHandling() {
			try {
				Alert alert = driver.switchTo().alert();
				driver.switchTo().alert().accept();
				//test.log(LogStatus.PASS, "Alert handlled Successfully");
			} catch (Exception e) {
				//test.log(LogStatus.FAIL, "Failed to handlled the Alert");
			}

		}

		// Scroll down using javascript
		public void scrollDown() {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		}

		// Scroll till the Element
		public void scrollTillElement(String locatorKey) throws Exception {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", locatorKey);
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
				//test.log(LogStatus.FAIL, "Get the WebElement : " + locatorKey, "Failed to get the WebElement "+ e.getMessage() + test.addScreenCapture(takeScreenShot(locatorKey)));
				return null;
			}
		}

	

		// Verify element presence on webpage
		public void verifyElementPresent(String locatorkey) throws Exception {
			try {
				getWebElement(locatorkey).isDisplayed();
			//	test.log(LogStatus.PASS, "Verify element presence:" + locatorkey,"Text '" + getWebElement(locatorkey).getText() + "' is displayed Successfully"+ test.addScreenCapture(takeScreenShot(locatorkey)));
			} catch (Exception e) {
			//	test.log(LogStatus.FAIL, "Verify element presence: " + locatorkey,"Text '" + getWebElement(locatorkey).getText() + "' is not displayed");
			}
		}
			
			// Verify text presence on webpage
			public String verifyTextPresent(String locatorkey) throws Exception {
				try {
					getWebElement(locatorkey).getText();
				//	test.log(LogStatus.PASS, "Verify text presence:" + locatorkey,"Text '" + getWebElement(locatorkey).getText() + "' is displayed Successfully"+ test.addScreenCapture(takeScreenShot(locatorkey)));
					return locatorkey;
				} catch (Exception e) {
				//	test.log(LogStatus.FAIL, "Verify text presence: " + locatorkey,"Text '" + getWebElement(locatorkey).getText() + "' is not displayed");
					return null;
				}
				
		}
			
			 public WebElement waitForElementToBeClickable(String locatorKey) {
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set the maximum wait time here
			        By locator = getLocator(locatorKey);
			        return wait.until(ExpectedConditions.elementToBeClickable(locator));
			    }

			    // Helper method to get By locator from the propLocator
			    private By getLocator(String locatorKey) {
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
			        } else {
			            throw new IllegalArgumentException("Invalid locator type: " + locatorType);
			        }
			    }




}



