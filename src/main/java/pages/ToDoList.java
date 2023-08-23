package pages;

import genericPages.CommonMethod;


public class ToDoList extends CommonMethod {

	public ToDoList() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickPlusSign() throws InterruptedException {
		base.waitForElementToBeClickable("toDoListPlusSign", 10);
		scrollDown();
		click("toDoListPlusSign");
	}

	public void enterTaskfield()  {
		enterData("toDoTaskField","patient_TaskDetails");
	}
	
	public void clearTaskfield() {
		clearData("toDoTaskField");
	}

	public void clickAddtask() {
		click("toDoAddTask");
	}
	
	public void clickDateAndTime() {
		 click("toDoDateAndTime");
	}

	public void clickDateSelect() {
		 click("toDoDatePick");
	}
	
	public void clickTimeSelect() {
		 click("toDoTimePick");
	}
	
	public void clickCancelWithoutDueDate() {
		 click("toDoCancelDueDate");
	}

	public void clickCompleteTaskField() throws Exception {
		base.waitForElementToBeClickable("toDoCompleteTask", 10);
		scrollDown();
		click("toDoCompleteTask");
	}

	public void clickDeleteTask() {
		 click("toDoDeleteTask");
	}

	public void clickViewCompletedTask() throws InterruptedException {
		base.waitForElementToBeClickable("toDoViewCompleteTask", 10);
		scrollDown();
		 click("toDoViewCompleteTask");
	}

	public void  clickViewOpenTask() {
		base.waitForElementToBeClickable("toDoViewOpenTask", 10);
		click("toDoViewOpenTask");
	}

	public String verifyNotification(String text) throws Exception  {
		verifyElementPresent("notification");
		base.waitForElementVisibility("notification", 10);
		verifyTextPresent("notification");
		return text;
	}

	public void clickCancelNotification() {
		base.waitForElementToBeClickable("cancelNotification", 10);
		click("cancelNotification");
	}
	
	public String verifyErrorMsg(String text) throws Exception {
		verifyElementPresent("toDoErrorMsg");
		Thread.sleep(1000);
		verifyTextPresent("toDoErrorMsg");
		return text;
	}
}
