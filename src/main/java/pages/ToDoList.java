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

	public void enterTaskfield() {
		base.waitForElementVisibility("toDoTaskField", 10);
		enterData("toDoTaskField", "patient_TaskDetails");
	}

	public void clearTaskfield() {
		base.waitForElementVisibility("toDoTaskField", 10);
		clearData("toDoTaskField");
	}

	public void clickAddtask() {
		base.waitForElementToBeClickable("toDoAddTask", 10);
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
	    scrollDown();
		base.waitForElementToBeClickable("toDoCompleteTask", 10);
		click("toDoCompleteTask");
	}

	public void clickDeleteTask() {
		click("toDoDeleteTask");
	}

	public void clickViewCompletedTask() throws InterruptedException {
		scrollDown();
		base.waitForElementToBeClickable("toDoViewCompleteTask", 10);
		click("toDoViewCompleteTask");
	}

	public void clickViewOpenTask() {
		base.waitForElementToBeClickable("toDoViewOpenTask", 10);
		click("toDoViewOpenTask");
	}

	public  String verifyNotification(String text) throws Exception  {
		verifyElementPresent("notification");
		base.waitForElementVisibility("notification", 10);
		verifyTextPresent("notification");
		return text;
	}

	public void clickCancelNotification() {
		base.waitForElementToBeClickable("cancelNotification", 10);
		click("cancelNotification");
	}

}
