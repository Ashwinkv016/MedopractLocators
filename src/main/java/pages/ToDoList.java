package pages;

import genericPages.CommonMethod;


public class ToDoList extends CommonMethod {

	public ToDoList() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickPlusSign() {
		click("toDoListPlusSign");
	}

	public void enterTaskfield() {
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
		scrollTillElement("toDoCompleteTask");
		click("toDoCompleteTask");
	}

	public void clickDeleteTask() {
		 click("toDoDeleteTask");
	}

	public void clickViewCompletedTask() {
		 click("toDoViewCompleteTask");
	}

	public void  clickViewOpenTask() {
		click("toDoViewOpenTask");
	}


}
