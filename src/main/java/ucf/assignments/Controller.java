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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	private TableColumn<Todo, String> dueDateColumn;
	@FXML
	private TableColumn<Todo, String> todoFieldColumn;
	@FXML
	private TableColumn<Todo, String> boolColumn;
	@FXML
	private FileChooser fileChooser;
	@FXML
	private ManageFile mf;


	// on app start:

	public void initialize() {

		fileChooser = new FileChooser();
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
		dueDateColumn.setOnEditCommit(
				(TableColumn.CellEditEvent<Todo, String> t) ->
						( t.getTableView().getItems().get(
								t.getTablePosition().getRow())
						).setTodoText(t.getNewValue())
		);

		todoFieldColumn.setCellValueFactory(cellData -> cellData.getValue().todoTextProperty());
		todoFieldColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		todoFieldColumn.setOnEditCommit(
				(TableColumn.CellEditEvent<Todo, String> t) ->
						( t.getTableView().getItems().get(
								t.getTablePosition().getRow())
						).setTodoText(t.getNewValue())
		);

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

		FileChooser fileChooser = new FileChooser();

		fileChooser.getExtensionFilters().add(
				new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt")
		);

		fileChooser.setInitialDirectory(new File(mf.getFilePath().toString()));

		//if file has been chosen, load it
		File file = fileChooser.showOpenDialog(null);



	}

	@FXML
	public void menuSaveFile(ActionEvent actionEvent) {
		// Path path = ManageFile.getFilePath()
		// run ManageFile.saveFile(path)
		// use java FileChooser <----- IMPORTANT !!!!

		ArrayList<Todo> listofTodos = new ArrayList();

		for (Todo todo : data) listofTodos.add(todo);

		System.out.println(listofTodos);

		fileChooser.setInitialFileName("default");

		fileChooser.getExtensionFilters().add(
				new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt")
		);

		fileChooser.setInitialDirectory(new File(mf.getFilePath().toString()));

		File file = fileChooser.showSaveDialog(new Stage());



		if (file != null) {
			mf.saveFile(file, listofTodos);
		}



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
