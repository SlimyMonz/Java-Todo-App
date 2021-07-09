/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class Columns {

	// REALLY IMPORTANT NOTE FOR GRADER: THIS IS JAVAFX STUFF! Cannot test it properly! There will NOT be a test class for this file!

	public void setDateColumn(TableColumn<Todo, String> dateColumn) {

		// set each cell to a value from Todo's dueDate object
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
		// set the cell as a text field for the entire column
		dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		// each time the data is edited, the Todo object is updated
		dateColumn.setOnEditCommit(
				(javafx.scene.control.TableColumn.CellEditEvent<Todo, String> t) ->
						(t.getTableView().getItems().get(
								t.getTablePosition().getRow())
						).setDueDate(t.getNewValue())
		);

	}

	public void setTextColumn(TableColumn<Todo, String> textColumn) {

		// set each cell to a value from Todo's todoText object
		textColumn.setCellValueFactory(new PropertyValueFactory<>("todoText"));
		// set the cell as a text field for the entire column
		textColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		// each time the data is edited, the Todo object is updated
		textColumn.setOnEditCommit(
				(javafx.scene.control.TableColumn.CellEditEvent<Todo, String> t) ->
						(t.getTableView().getItems().get(
								t.getTablePosition().getRow())
						).setTodoText(t.getNewValue())
		);

	}

	public void setBoolColumn(TableColumn<Todo, Boolean> boolColumn) {

		// set each cell to a value from Todo's bool object
		boolColumn.setCellValueFactory(new PropertyValueFactory<>("bool"));
		// set the cell as a dropdown field for the entire column
		boolColumn.setCellFactory(ComboBoxTableCell.forTableColumn(true, false));
		// each time the data is edited, the Todo object is updated
		boolColumn.setOnEditCommit(
				(javafx.scene.control.TableColumn.CellEditEvent<Todo, Boolean> t) ->
						(t.getTableView().getItems().get(
								t.getTablePosition().getRow())
						).setBool(t.getNewValue())
		);

	}


}
