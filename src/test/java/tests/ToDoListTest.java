package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;

import genericPages.CommonMethod;
import pages.LoginPage;
import pages.ToDoList;

public class ToDoListTest extends CommonMethod {
	public ToDoListTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Logger logger = LogManager.getLogger(ToDoListTest.class);

	@BeforeClass
	public void openApplication() throws Exception {
		test = reports.startTest("openApplication");
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
	public void Todolist() throws Exception {
		test = reports.startTest("TC001 Open ToDo List");
		ToDoList tdl = new ToDoList();
        scrollDown();
		tdl.clickPlusSign();
		logger.info("Clicking plus Sign");
		tdl.enterTaskfield();
		logger.info("Entering Value");
		tdl.clickDateAndTime();
		logger.info("Clicked Date and Time");
		//tdl.clickDateSelect();
		tdl.clickTimeSelect();
		tdl.clickAddtask();
		logger.info("Clicked on Add Task Button");

	     String actual = getWebElement("notification").getText();
	     String expected="Tasks record added";
		 Assert.assertEquals(actual, expected);
		 logger.info("Assertion Passed");

		tdl.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}



	@Test(priority = 2)
	public void withoutTaskDetails() throws Exception {
		test = reports.startTest("TC002 Without ToDoList TaskDetails");
		ToDoList tdl = new ToDoList();
		tdl.clearTaskfield();
		logger.info("Cleared Task Field");
		tdl.clickAddtask();
		logger.info("Clicked on Add Task Button");
		Thread.sleep(2000);
		
		 String actual = getWebElement("toDoErrorMsg").getText();
	     String expected="Task Description is empty";
		 Assert.assertEquals(actual, expected);
		 logger.info("Assertion Passed");

	}

	@Test(priority = 3)
	public void withoutDueDate() throws Exception {
		test = reports.startTest("TC003 Without ToDoList Due Date");
		ToDoList tdl = new ToDoList();
		tdl.enterTaskfield();
		logger.info("Entering Value");
		tdl.clickCancelWithoutDueDate();
		logger.info("Cancelled Due Date");
		tdl.clickAddtask();
		logger.info("Clicked on Add Task Button");

		 String actual = getWebElement("notification").getText();
	     String expected="Tasks record added";
		 Assert.assertEquals(actual, expected);
		 logger.info("Assertion Passed");
		 
		tdl.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority =4 )
	public void CompletedTask() throws Exception {
		test = reports.startTest("TC004 Complete ToDoList Task");
		ToDoList tdl = new ToDoList();
		tdl.clickCompleteTaskField();
		logger.info("Clicking on View Completed Task");

		 String actual = getWebElement("notification").getText();
	     String expected="Tasks record updated as completed";
		 Assert.assertEquals(actual, expected);
		 logger.info("Assertion Passed");

		tdl.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority = 5)
	public void viewCompletedTask() throws Exception {
		test = reports.startTest("TC005 View Completed Task");
		ToDoList tdl = new ToDoList();
		tdl.clickViewCompletedTask();
		logger.info("Clicking on View Completed Task");
	}

	@Test(priority = 6)
	public void viewOpenTask() throws Exception {
		test = reports.startTest("TC006 View Open Task");
		ToDoList tdl = new ToDoList();
		logger.info("Clicking on View Completed Task");
		tdl.clickViewOpenTask();
		logger.info("Clicking on View Completed Task");
	}

	@Test(priority = 7)
	public void deleteTask() throws Exception {
		test = reports.startTest("TC007 ToDoList Delete Task");
		ToDoList tdl = new ToDoList();
		tdl.clickDeleteTask();
		logger.info("Clicking on Delete Task");
        Alert alert=  driver.switchTo().alert();

		 String actual = alert.getText();
	     String expected="Task would be permanently deleted. Are you sure, you want to delete the task ? ";
		 Assert.assertEquals(actual, expected);
		 logger.info("Assertion Passed");
		 
		tdl.clickCancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@AfterClass
	public void afterTest() {
		// Close the browser
		driver.close();
		reports.endTest(test);
		reports.flush();
	}

}
