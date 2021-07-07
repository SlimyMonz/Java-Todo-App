/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;

import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Path;

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
	
	public File loadFile() {

		FileChooser fileChooser = new FileChooser();

		fileChooser.getExtensionFilters().add(
				new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt")
		);

		fileChooser.setInitialDirectory(new File(getFilePath().toString()));

		//if file has been chosen, load it
		return fileChooser.showOpenDialog(null);
	}

	public void saveFile() {
		FileChooser fileChooser = new FileChooser();

		fileChooser.setInitialFileName("default");

		fileChooser.getExtensionFilters().add(
				new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt")
		);
		fileChooser.setInitialDirectory(new File(getFilePath().toString()));

		//if file has been chosen, save it
		File file = fileChooser.showSaveDialog(null);

		//set current file path to ManageFile's filePath
		setFilePath(file.toPath());

	}


}
