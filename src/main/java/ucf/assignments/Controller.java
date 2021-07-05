/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;

import javafx.event.ActionEvent;

public class Controller {

	// on user button press:
	
	@FXML
	public void clickAddList(ActionEvent actionEvent) {
		// run TodoListArray.addTodoList()
	}
	
	@FXML
	public void clickDeleteList(ActionEvent actionEvent) {
		// run TodoListArray.delTodoList()
	}
	
	@FXML
	public void clickShowCompleted(ActionEvent actionEvent) {
		// make objects that have completed=true to be visible in GUI
	}
	
	@FXML
	public void clickHideCompleted(ActionEvent actionEvent) {
		// make objects that have completed=false invisible in GUI
	}

	@FXML
	public void clickPlus(ActionEvent actionEvent) {
		// figure out what list is already displaying info
		// run Todolist.addTodo() to current displayed list
	}

	public void clickMinus(ActionEvent actionEvent) {
		// if TodoItem is selected:
		// TodoList.delTodo(selected TodoItem)
	}

	@FXML
	public void menuLoadFile(ActionEvent actionEvent) {
		// run Path path = ManageFile.getFilePath()
		// run ManageFile.loadFile(path)
	}

	@FXML
	public void menuLoadList(ActionEvent actionEvent) {
		// run Path path = ManageFile.getFilePath()
		// run String name = ManageFile.getFileName()
		// run ManageFile.loadList(path, name);
	}

	@FXML
	public void menuSaveFile(ActionEvent actionEvent) {
		// Path path = ManageFile.getFilePath()
		// run ManageFile.saveFile(path)
	}

	@FXML
	public void menuSaveList(ActionEvent actionEvent) {
		// run Path path = ManageFile.getFilePath()
		// run String name = ManageFile.getFileName()
		// run ManageFile.saveList(path, name);
	}

	@FXML
	public void menuQuit(ActionEvent actionEvent) {
		// put code here that stops the app from running (don't yet know what that is)
		// prompt to save before quitting? idk if I'm smart enough for that
	}
}
