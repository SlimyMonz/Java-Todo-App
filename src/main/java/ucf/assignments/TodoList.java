/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;

import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;

public class TodoList implements Serializable {

	private ArrayList<Todo> todoList = new ArrayList<>();

	public TodoList() {
	}

	public void setListName(String string) {
		// change listName string
		// this.listName = string
	}

	public void addTodo(Todo item) {
		// create new todo object
		//  append to Arraylist
		// ArrayList.add(new todo())
		this.todoList.add(item);

	}

	public void delTodo() {
		// remove todo object from arraylist
		// ArrayList.remove(selected todo)
	}

}
