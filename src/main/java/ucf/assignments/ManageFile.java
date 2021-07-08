/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;

import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ManageFile {

	private final String defaultPath = System.getProperty("user.home");

	public ManageFile() {
	}


	public String getFilePath() {
		// if filePath.isNotEmpty() 
		// return filePath
		// else return defaultPath
			return defaultPath;
	}


	public Object loadFile(File file) {

		return readFile(file.toPath());

	}

	public void saveFile(File file, ArrayList<Todo> data) {

		//set current file path to ManageFile's filePath
		//users Serializer to write file
		writeFile(file, data);

	}

	public void writeFile(File file, ArrayList<Todo> data) {

		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
			outputStream.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Object readFile(Path file) {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(file));
			return inputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}


}
