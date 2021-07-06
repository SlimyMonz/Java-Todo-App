/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	@FXML
	private Label todoListLabel;
	@FXML
	private TextField todoField;
	@FXML
	private DatePicker dueDatePicker;
	@FXML
	private TableView<Todo> tableViewContainer;
	@FXML
	private ObservableList<Todo> data;
	@FXML
	private TableColumn<Todo, DatePicker> dueDateColumn;
	@FXML
	private TableColumn<Todo, String> todoFieldColumn;
	@FXML
	private TableColumn<Todo, CheckBox> completedColumn;



	// on app start:

	public void initialize() {

		// make tableViewContainer editable anytime
		this.tableViewContainer.setEditable(true);

		// make todoLists an FXCollections with an observable array list
		this.data = FXCollections.observableArrayList();

		// use cell factory to set column data types
		this.dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));


		this.todoFieldColumn.setCellValueFactory(new PropertyValueFactory<>("todoText"));
		todoFieldColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		todoFieldColumn.setOnEditCommit(
				t -> ( t.getTableView().getItems().get(
						t.getTablePosition().getRow())
				).setTodoText(t.getNewValue())
		);


		completedColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

		// set items for listViewContainer from ObservableList
		this.tableViewContainer.setItems(data);
		// add all the columns to the container
		this.tableViewContainer.getColumns().addAll(dueDateColumn, todoFieldColumn, completedColumn);

	}

	// on user button press:
	
	@FXML
	public void clickAddList(ActionEvent actionEvent) {
		// launch a new TodoList app
	}
	
	@FXML
	public void clickDeleteList(ActionEvent actionEvent) {
		// if file exists based on listName, delete file and make blank file
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
	public void clickNewTodo(ActionEvent actionEvent) {
		// add new object with the values selected in the bottom bar containers
			data.add(new Todo(
					dueDatePicker.getValue(),
					todoField.getText(),
					false));
			// reset the date
			dueDatePicker.getEditor().clear();
			// reset text field
			todoField.clear();
	}

	public void clickDeleteTodo(ActionEvent actionEvent) {
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

	@FXML
	public void clickAbout(ActionEvent actionEvent) {
	}
}
