/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/* The purpose of this file is to load the FXML file and launch the program */


public class App extends Application {



	@Override
	public void start(Stage stage) throws Exception {

		/*
		* Parent variable pointed to path of the resources folder and the fxml file.
		* stage set the title for the program as Todo List
		* stage set the default app scene size with a reference to the Parent variable
		* stage show method
		* */

		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("App.fxml")));
		stage.setTitle("Todo List");
		stage.setScene(new Scene(root));
		stage.show();

	}

	public static void main(String[] args) {
		// launch app argument
		launch(args);
	}

}
