/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;

import java.util.Date;

public class Todo {

	private Date dueDate;
	private String todoText;
	private Boolean completed;

	public Todo() {
		// set Date to blank
		// set default string to blank ""
		// set default Boolean to false
	}

	public Date getDueDate() {
		// return Date value of object
		return dueDate;
	}

	public void setDueDate(Date date) {
		// change Date value of object
		// return void
	}

	public String getTodoText() {
		// return todoText String
		return todoText;
	}

	public void setTodoText(String todoText) {
		// from string parameter
		// change String value
		// return void
	}

	public Boolean getCompleted() {
		// return boolean of completed value
		return completed;
	}

	public void setCompleted(Boolean bool) {
		// set value based off of boolean parameter
		// return void
	}

}
