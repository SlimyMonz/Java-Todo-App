/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;


import javafx.beans.property.*;

import java.time.LocalDate;

public class Todo {

	private final ObjectProperty<String> dueDate = new SimpleObjectProperty<>();
	private final ObjectProperty<String> todoText = new SimpleObjectProperty<>();
	private final ObjectProperty<String> bool = new SimpleObjectProperty<>();

	// blank and parameter constructors
	public Todo() {
		// set Date to blank
		// set default string to blank ""
		// set default Boolean to false
		this.dueDate.setValue(LocalDate.now().toString());
		this.todoText.setValue("");
		this.bool.setValue("no");

	}

	public Todo(LocalDate date, String string) {
		// set Date to datepicker date from parameter
		// set string to parameter from GUI
		this.dueDate.setValue(date.toString());
		if (string.length() > 256) {
			this.todoText.setValue(string.substring(0, 256));}
			else {
				this.todoText.setValue(string);
			}

		this.bool.setValue("no");
	}


	// collection of Getters
	public String getDueDate() {
		// return Date value of object
		return dueDate.get();
	}

	public String getTodoText() {
		// return todoText String
		return todoText.get();
	}

	public String getBool() {
		// return boolean of completed value
		return bool.get();
	}


	// collection of Setters
	public void setDueDate(LocalDate date) {
		// this.dueDate = date
		this.dueDate.set(date.toString());
	}

	public void setTodoText(String string) {
		// this.todoText equals given todoText String parameter
		this.todoText.set(string);
	}

	public void setValue(Boolean bool) {
		// set value based off of boolean parameter
		// this.setCompleted = bool
		this.bool.set(bool.toString());
	}


	// collection of returning Observable Values
	public final ObjectProperty<String> dueDateProperty() {
		return dueDate;
	}

	public final ObjectProperty<String> todoTextProperty() { // property getter
		return todoText;
	}

	public final ObjectProperty<String> boolProperty() { // property getter
		return bool;
	}



}
