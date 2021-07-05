/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;

import java.time.LocalDate;

public class Controller {

	@FXML
	private ListView<TodoList> listViewContainer;
	@FXML
	private ObservableList<TodoList> todoLists;
	@FXML
	private TableColumn<TodoList, LocalDate> dueDateColumn;
	@FXML
	private TableColumn<TodoList, String> todoDescriptionColumn;
	@FXML
	private TableColumn<TodoList, Boolean> completedColumn;


	// on app start:

	public void initialize() {
		// make todoLists an FXCollections with an observable array list
		// add a new TodoList object
		// set items for listViewContainer from ObservableList
		// set the listViewContainer selection to the first item
	}

	// on user button press:
	
	@FXML
	public void clickAddList(ActionEvent actionEvent) {
		// create a new TodoList object
		// add it to the listViewContainer
	}
	
	@FXML
	public void clickDeleteList(ActionEvent actionEvent) {
		// run TodoListArray.delTodoList() on selected list
	}
	
	@FXML
	public void clickShowCompleted(ActionEvent actionEvent) {
		// make objects that have completed=true to be visible in each column
	}
	
	@FXML
	public void clickHideCompleted(ActionEvent actionEvent) {
		// make objects that have completed=false invisible in each column
	}

	@FXML
	public void clickPlus(ActionEvent actionEvent) {
		// get selected list
		// run Todolist.addTodo() to current displayed list
		// add object to column views
	}

	public void clickMinus(ActionEvent actionEvent) {
		// if TodoItem is selected:
		// TodoList.delTodo(selected TodoItem)
		// refresh column views
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
		// prompt to save before quitting
		// Application.stop() to quit app
	}
}
