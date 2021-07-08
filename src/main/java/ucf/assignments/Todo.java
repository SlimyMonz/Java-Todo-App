/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;


import javafx.beans.property.*;

import java.io.Serializable;
import java.time.LocalDate;

public class Todo implements Serializable {

	// ALL OF THIS MUST DISAPPEAR FUCK ME
	private String dueDate;
	private String todoText;
	private Boolean bool;

	// blank and parameter constructors
	public Todo() {
		// set Date to blank
		// set default string to blank ""
		// set default Boolean to false
		this.dueDate = (LocalDate.now().toString());
		this.todoText = ("");
		this.bool = false;

	}

	public Todo(LocalDate date, String string) {
		// set Date to datepicker date from parameter
		// set string to parameter from GUI
		this.dueDate = (date.toString());
		if (string.length() > 256) {
			this.todoText = (string.substring(0, 256));}
			else {
				this.todoText = (string);
			}

		this.bool = false;
	}


	// collection of Getters
	public String getDueDate() {
		// return Date value of object
		return dueDate;
	}

	public String getTodoText() {
		// return todoText String
		return todoText;
	}

	public Boolean getBool() {
		// return boolean of completed value
		return bool;
	}


	// collection of Setters
	public void setDueDate(String date) {
		// this.dueDate = date
		this.dueDate = (date.toString());
	}

	public void setTodoText(String string) {
		// this.todoText equals given todoText String parameter
		this.todoText = (string);
	}

	public void setBool(boolean bool) {
		// set value based off of boolean parameter
		// this.setCompleted = bool
		this.bool = bool;
	}


}
