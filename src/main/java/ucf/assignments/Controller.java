/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Controller {

	@FXML
	private TextField todoField;
	@FXML
	private DatePicker dueDatePicker;

	@FXML
	private TableView<Todo> tableViewContainer;
	@FXML
	private ObservableList<Todo> data;
	@FXML
	private ObservableList<Todo> dataTemp;

	@FXML
	private TableColumn<Todo, String> dueDateColumn;
	@FXML
	private TableColumn<Todo, String> todoFieldColumn;
	@FXML
	private TableColumn<Todo, Boolean> boolColumn;

	@FXML
	private FileChooser fileChooser;
	@FXML
	private ManageFile mf;


	// on app start:

	@FXML
	public void initialize() {

		fileChooser = new FileChooser();
		mf = new ManageFile();

		// make tableViewContainer editable anytime
		tableViewContainer.setEditable(true);

		// make todoLists an FXCollections with an observable array list
		data = FXCollections.observableArrayList();
		dataTemp = FXCollections.observableArrayList();

		// trying to figure out how to use this to make the Date Picker box not suck
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		dueDatePicker.setValue(LocalDate.now());
		todoField.setText("Todo");

		// use cell factory to set column data types

		dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
		dueDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		dueDateColumn.setOnEditCommit(
				(TableColumn.CellEditEvent<Todo, String> t) ->
						( t.getTableView().getItems().get(
								t.getTablePosition().getRow())
						).setDueDate(t.getNewValue())
		);

		todoFieldColumn.setCellValueFactory(new PropertyValueFactory<>("todoText"));
		todoFieldColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		todoFieldColumn.setOnEditCommit(
				(TableColumn.CellEditEvent<Todo, String> t) ->
						( t.getTableView().getItems().get(
								t.getTablePosition().getRow())
						).setTodoText(t.getNewValue())
		);

		boolColumn.setCellValueFactory(new PropertyValueFactory<>("bool"));
		boolColumn.setCellFactory(ComboBoxTableCell.forTableColumn(true, false));
		boolColumn.setOnEditCommit(
				(TableColumn.CellEditEvent<Todo, Boolean> t) ->
						( t.getTableView().getItems().get(
								t.getTablePosition().getRow())
						).setBool(t.getNewValue())
		);

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
		// clear program of data
		data.clear();
	}

	@FXML
	public void clickShowAll(ActionEvent actionEvent) {
		// show all objects
		tableViewContainer.setItems(data);

	}

	@FXML
	public void clickShowCompleted(ActionEvent actionEvent) {
		// make objects that have completed=true to be visible in each column

		dataTemp.clear();
		dataTemp.addAll(data);

		dataTemp.removeIf(item -> !item.getBool());

		tableViewContainer.setItems(dataTemp);

	}

	@FXML
	public void clickShowIncomplete(ActionEvent actionEvent) {
		// make objects that have completed=false invisible in each column

		dataTemp.clear();
		dataTemp.addAll(data);

		dataTemp.removeIf(Todo::getBool);

		tableViewContainer.setItems(dataTemp);

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

		fileChooser.setInitialDirectory(new File(mf.getFilePath()));

		//if file has been chosen, load it
		File file = fileChooser.showOpenDialog(null);

		Object loadFile = mf.readFile(file.toPath());

		// clear all the current items
		data.clear();
		// add all the loaded items
		data.addAll((ArrayList<Todo>) loadFile);

	}

	@FXML
	public void menuSaveFile(ActionEvent actionEvent) {
		// Path path = ManageFile.getFilePath()
		// run ManageFile.saveFile(path)
		// use java FileChooser <----- IMPORTANT !!!!

		ArrayList<Todo> listofTodos = new ArrayList<>(data);


		fileChooser.setInitialFileName(mf.getFileName());

		fileChooser.setInitialDirectory(new File(mf.getFilePath()));

		File file = fileChooser.showSaveDialog(new Stage());


		if (file != null) {
			mf.writeFile(file, listofTodos);
		}

	}

	@FXML
	public void menuQuit(ActionEvent actionEvent) {
		// prompt to save before quitting
		// Application.stop() to quit app
		Platform.exit();
		System.exit(0);
	}

	@FXML
	public void clickAbout(ActionEvent actionEvent) {

	}

}
