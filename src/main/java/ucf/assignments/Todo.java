/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;

import java.time.LocalDate;
import java.util.Date;

public class Todo {

	private LocalDate dueDate;
	private String todoText;
	private Boolean completed;

	public Todo() {
		// set Date to blank
		// set default string to blank ""
		// set default Boolean to false
		this.dueDate = LocalDate.now();
		this.todoText = "";
		this.completed = false;
	}

	public Todo(LocalDate date, String todoText) {
		// set Date to datepicker date from parameter
		// set string to parameter from GUI
		this.dueDate = date;
		this.todoText = todoText;
		this.completed = false;
	}

	public LocalDate getDueDate() {
		// return Date value of object
		return dueDate; // this is not a literal, but I don't believe Date classes can have literals
	}

	public void setDueDate(LocalDate date) {
		// this.dueDate = date
		this.dueDate = date;
	}

	public String getTodoText() {
		// return todoText String
		return this.todoText;
	}

	public void setTodoText(String todoText) {
		// this.todoText equals given todoText String parameter
		this.todoText = todoText;
	}

	public Boolean getCompleted() {
		// return boolean of completed value
		return this.completed; // boolean literal for now
	}

	public void setCompleted(Boolean bool) {
		// set value based off of boolean parameter
		// this.setCompleted = bool
		this.completed = bool;
	}

}
