package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import genericPages.CommonMethod;
import pages.LoginPage;
import pages.ToDoList;

public class ToDoListTest extends CommonMethod {
	public ToDoListTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}


	Logger logger= LogManager.getLogger(ToDoListTest.class);
	

	@BeforeClass
	public void openApplication() throws Exception {
		// Open the browser and hit the url
		initializeBrowser();

		LoginPage l=new LoginPage();
		l.clickGotItBtn();
		Thread.sleep(2000);
		l.enterValiedUserName();
		logger.info("Entered Username");
		Thread.sleep(2000);
		l.enterValiedPassword();
		logger.info("Entered Password");
		Thread.sleep(2000);
		l.clickSubmitLoginBtn();
		logger.info("Clicked submit button");
		


		/**	String actual = null;
		try {
			if(l.getaccInfo().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");**/
	}

	@Test(priority=1)
	public void Todolist() throws Exception  {

		ToDoList tdl = new ToDoList();
		
		tdl.clickPlusSign();
		logger.info("Clicking plus Sign");
		Thread.sleep(3000);
		tdl.enterTaskfield();
		logger.info("Entering Value");
		tdl.clickDateAndTime();
		logger.info("Clicked Date and Time");
		tdl.clickDateSelect();
		tdl.clickTimeSelect();
		tdl.clickAddtask();	
		logger.info("Clicked on Add Task Button");
		Thread.sleep(2000);
	/**	String expectedResult="Tasks record added";
		String actualResult=tdl.getNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);
		tdl.getcancelNotification();
		logger.info("Clicked Cancel Notification");
		Thread.sleep(2000);**/
	}


	@Test(priority = 2)
	public void CompletedTask() throws Exception  {
		ToDoList tdl=new ToDoList();
		tdl.clickCompleteTaskField();
		logger.info("Clicking on View Completed Task");

		Thread.sleep(2000);
	/**	String expectedResult="Tasks record updated as completed";
		String actualResult=tdl.getNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);

		tdl.getcancelNotification();
		logger.info("Clicked Cancel Notification");
		Thread.sleep(2000);**/
	}

	@Test(priority=3)
	public void withoutTaskDetails() throws Exception  {
		ToDoList tdl = new ToDoList();
		tdl.clearTaskfield();
		logger.info("Entering Value");
		tdl.clickAddtask();
		logger.info("Clicked on Add Task Button");
		Thread.sleep(2000);
		
	/**	String actual = null;
		try {
			if(tdl.geterrorMsg().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");**/
	}

	@Test(priority=4)
	public void withoutDueDate() throws Exception {

		ToDoList tdl = new ToDoList();
		tdl.enterTaskfield();
		logger.info("Entering Value");
		tdl.clickCancelWithoutDueDate();
		logger.info("Cancelled Due Date");
		tdl.clickAddtask();
		logger.info("Clicked on Add Task Button");
		Thread.sleep(2000);
		
/**		String expectedResult="Tasks record added";
		String actualResult=tdl.getNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);

		tdl.getcancelNotification();
		logger.info("Clicked Cancel Notification");
		Thread.sleep(2000);**/
	}

	

	@Test(priority = 5)
	public void viewCompletedTask() throws Exception  {
		ToDoList tdl=new ToDoList();
		Thread.sleep(10000);
		tdl.clickViewCompletedTask();
		logger.info("Clicking on View Completed Task");
		Thread.sleep(2000);
	}


	@Test(priority =6)
	public void viewOpenTask() throws Exception  {
		ToDoList tdl=new ToDoList();
		logger.info("Clicking on View Completed Task");
		tdl.clickViewOpenTask();
		logger.info("Clicking on View Completed Task");
	}
	
	@Test(priority=7)
	public void deleteTask() throws Exception    {
		ToDoList tdl = new ToDoList();
		tdl.clickDeleteTask();
		logger.info("Clicking on Delete Task");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		logger.info("Clicking Cancel popup");
		Thread.sleep(2000);
		/**	String actual = null;
		try {
			if(tdl.getNotification().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");

		tdl.getcancelNotification();
		logger.info("Clicked Cancel Notification");
		Thread.sleep(2000);**/
	}


	 @AfterClass
		public void afterTest() {
			// Close the browser
			driver.close();
			//reports.endTest(test);
			//reports.flush();
		}

}
