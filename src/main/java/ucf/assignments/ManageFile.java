/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ManageFile {

	private FileChooser fileChooser;
	private String fileName;
	private final Path defaultPath = Path.of(System.getProperty("user.home"));
	private Path filePath;

	public ManageFile() {
	}

	public String getFileName() {
		// returns the fileName string for this object
		return fileName;
	}

	public void setFileName(String fileName) {
		// this.fileName equals fileName
		this.fileName = fileName;
	}

	public Path getFilePath() {
		// if filePath.isNotEmpty() 
		// return filePath
		// else return defaultPath
		if (filePath == null) {
			return defaultPath;
		} else {
			return filePath;
		}
	}

	public void setFilePath(Path filePath) {
		// this.filePath = filePath
	}
	
	public Object loadFile(File file) {

		return readFile(file.toPath());

	}

	public void saveFile(File file, ArrayList<Todo> data) {

		//set current file path to ManageFile's filePath
		setFilePath(file.toPath());

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
