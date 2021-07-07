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
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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
	private TableColumn<Todo, String> boolColumn;
	@FXML
	private ManageFile mf;

	// on app start:

	public void initialize() {

		mf = new ManageFile();

		// make tableViewContainer editable anytime
		tableViewContainer.setEditable(true);

		// make todoLists an FXCollections with an observable array list
		data = FXCollections.observableArrayList();

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		dueDatePicker.setValue(LocalDate.now());
		todoField.setText("Todo");

		// use cell factory to set column data types

		dueDateColumn.setCellValueFactory(cellData -> cellData.getValue().dueDateProperty());
		dueDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		todoFieldColumn.setCellValueFactory(cellData -> cellData.getValue().todoTextProperty());
		todoFieldColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		boolColumn.setCellValueFactory(cellData -> cellData.getValue().boolProperty());
		boolColumn.setCellFactory(ComboBoxTableCell.forTableColumn("yes", "no"));


		// set items for listViewContainer from ObservableList
		tableViewContainer.setItems(data);
		// add all the columns to the container
		tableViewContainer.getColumns().addAll(dueDateColumn, todoFieldColumn, boolColumn);

	}

	// on user button press:

	@FXML
	public void clickAddList(ActionEvent actionEvent) {
		// launch a new TodoList app
		try {
			new App().start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickDeleteList(ActionEvent actionEvent) {
		// if file exists based on listName, delete file and make blank file
		// clear program of data
	}

	@FXML
	public void clickShowAll(ActionEvent actionEvent) {
		// show all objects
	}

	@FXML
	public void clickShowCompleted(ActionEvent actionEvent) {
		// make objects that have completed=true to be visible in each column

	}

	@FXML
	public void clickShowIncomplete(ActionEvent actionEvent) {
		// make objects that have completed=false invisible in each column
	}

	@FXML
	public void clickNewTodo(ActionEvent actionEvent) {
		// add new object with the values selected in the bottom bar containers

		data.add(new Todo(
				dueDatePicker.getValue(),
				todoField.getText()));

		// reset the date
		dueDatePicker.setValue(LocalDate.now());
		// reset text field
		todoField.setText("Todo");
	}

	public void clickDeleteTodo(ActionEvent actionEvent) {
		// if TodoItem is selected:
		// delete selected item at tableView index
		// refresh column views
		int selectedIndex = tableViewContainer.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			tableViewContainer.getItems().remove(selectedIndex);
		}
	}

	@FXML
	public void menuLoadFile(ActionEvent actionEvent) {

		File file = this.mf.loadFile();


	}

	@FXML
	public void menuSaveFile(ActionEvent actionEvent) {
		// Path path = ManageFile.getFilePath()
		// run ManageFile.saveFile(path)
		// use java FileChooser <----- IMPORTANT !!!!

		this.mf.saveFile();
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
