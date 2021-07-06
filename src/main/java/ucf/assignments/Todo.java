/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;


import javafx.beans.value.ObservableValue;

import java.time.LocalDate;

public class Todo {

	private String dueDate;
	private String todoText;
	private ObservableValue<Boolean> bool;

	public Todo() {
		// set Date to blank
		// set default string to blank ""
		// set default Boolean to false
		this.dueDate = LocalDate.now().toString();
		this.todoText = "";
	}

	public Todo(String date, String todoText) {
		// set Date to datepicker date from parameter
		// set string to parameter from GUI
		this.dueDate = date;
		this.todoText = todoText;
	}

	public String getDueDate() {
		// return Date value of object
		return dueDate; // this is not a literal, but I don't believe Date classes can have literals
	}

	public void setDueDate(LocalDate date) {
		// this.dueDate = date
		this.dueDate = date.toString();
	}

	public String getTodoText() {
		// return todoText String
		return todoText;
	}

	public void setTodoText(String todoText) {
		// this.todoText equals given todoText String parameter
		this.todoText = todoText;
	}

	public ObservableValue<Boolean> getBool() {
		// return boolean of completed value
		return bool; // boolean literal for now
	}

	public void setValue(ObservableValue<Boolean> bool) {
		// set value based off of boolean parameter
		// this.setCompleted = bool
		this.bool = bool;
	}

}
