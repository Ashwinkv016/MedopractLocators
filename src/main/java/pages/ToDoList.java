package pages;

import genericPages.CommonMethod;

public class ToDoList extends CommonMethod {

	public ToDoList() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickPlusSign() throws Exception {
		scrollDown();
		click("toDoListPlusSign");
	}

	public void enterTaskfield() throws Exception {
		enterData("toDoTaskField", "patient_TaskDetails");
	}

	public void clearTaskfield() throws Exception {
		clearData("toDoTaskField");
	}

	public void clickAddtask() throws Exception {
		click("toDoAddTask");
	}

	public void clickDateAndTime() throws Exception {
		click("toDoDateAndTime");
	}

	public void clickDateSelect() throws Exception {
		click("toDoDatePick");
	}

	public void clickTimeSelect() throws Exception {
		click("toDoTimePick");
	}

	public void clickCancelWithoutDueDate() throws Exception {
		click("toDoCancelDueDate");
	}

	public void clickCompleteTaskField() throws Exception {
	    scrollDown();
		click("toDoCompleteTask");
	}

	public void clickDeleteTask() throws Exception {
		click("toDoDeleteTask");
	}

	public void clickViewCompletedTask() throws Exception {
		scrollDown();
		click("toDoViewCompleteTask");
	}

	public void clickViewOpenTask() throws Exception {
		click("toDoViewOpenTask");
	}

	public  String verifyNotification(String text) throws Exception  {
		verifyElementPresent("notification");
		verifyTextPresent("notification");
		return text;
	}

	public void clickCancelNotification() throws Exception {
		click("cancelNotification");
	}

}
