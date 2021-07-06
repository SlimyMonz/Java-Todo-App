/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.scene.control.TableColumn;

import java.time.LocalDate;


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
	private TableColumn<Todo, String> dueDateColumn;
	@FXML
	private TableColumn<Todo, String> todoFieldColumn;
	@FXML
	private TableColumn<Todo, Boolean> boolColumn;



	// on app start:

	public void initialize() {

		// make tableViewContainer editable anytime
		tableViewContainer.setEditable(true);

		// make todoLists an FXCollections with an observable array list
		data = FXCollections.observableArrayList();

		// use cell factory to set column data types
		dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
		dueDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		dueDateColumn.setOnEditCommit(
				cell -> ( cell.getTableView().getItems().get(
						cell.getTablePosition().getRow())
				).setTodoText(cell.getNewValue())
		);


		todoFieldColumn.setCellValueFactory(new PropertyValueFactory<>("todoText"));
		todoFieldColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		todoFieldColumn.setOnEditCommit(
				date -> ( date.getTableView().getItems().get(
						date.getTablePosition().getRow())
				).setTodoText(date.getNewValue())
		);

		// FUCK ME THIS BOOLEAN CHECKBOX SHIT IS HARD

		boolColumn.setCellFactory(boolColumn -> new CheckBoxTableCell<>());
		boolColumn.setCellValueFactory(param -> param.getValue().getBool());
		// possibly replace this with drop-down menu options instead


		// set items for listViewContainer from ObservableList
		tableViewContainer.setItems(data);
		// add all the columns to the container
		tableViewContainer.getColumns().addAll(dueDateColumn, todoFieldColumn, boolColumn);

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
		if(dueDatePicker == null) {
			data.add(new Todo(
					LocalDate.now().toString(),
					todoField.getText()));
		} else {
			data.add(new Todo(
					dueDatePicker.getValue().toString(),
					todoField.getText()));
		}

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
