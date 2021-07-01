/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;

import javafx.event.ActionEvent;

public class Controller {

	// on user button press:

	public void clickAddList(ActionEvent actionEvent) {
		// run TodoListMap.addTodoList()
	}

	public void clickDeleteList(ActionEvent actionEvent) {
		// run TodoListMap.delTodoList()
	}

	public void clickShowCompleted(ActionEvent actionEvent) {
		// make objects that have completed=true to be visible in GUI
	}

	public void clickHideCompleted(ActionEvent actionEvent) {
		// make objects that have completed=false invisible in GUI
	}


	public void clickPlus(ActionEvent actionEvent) {
		// figure out what list is already displaying info
		// run Todolist.addTodo() to current displayed list
	}

	public void clickMinus(ActionEvent actionEvent) {
		// figure out what list is already displaying info
		// figure out which object is selected
		// run TodoList.delTodo() to selected object
	}


	public void menuLoadFile(ActionEvent actionEvent) {
		// run Path path = ManageFile.getFilePath()
		// run ManageFile.loadFile(path)
	}

	public void menuLoadList(ActionEvent actionEvent) {
		// run Path path = ManageFile.getFilePath()
		// run String name = ManageFile.getFileName()
		// run ManageFile.loadList(path, name);
	}


	public void menuSaveFile(ActionEvent actionEvent) {
		// Path path = ManageFile.getFilePath()
		// run ManageFile.saveFile(path)
	}

	public void menuSaveList(ActionEvent actionEvent) {
		// run Path path = ManageFile.getFilePath()
		// run String name = ManageFile.getFileName()
		// run ManageFile.saveList(path, name);
	}


	public void menuQuit(ActionEvent actionEvent) {
		// put code here that stops the app from running (don't yet know what that is)
		// prompt to save before quitting? idk if I'm smart enough for that
	}
}
