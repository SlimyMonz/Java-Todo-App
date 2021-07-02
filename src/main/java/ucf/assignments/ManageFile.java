/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;

import java.nio.file.Path;

public class ManageFile {

	private String fileName;
	private Path defaultPath;
	private Path filePath;

	public ManageFile() {
		// create TodoListArray
		// generate a default path based off of user PC
		// set filename to "default_save"
		// generate file
	}

	public String getFileName() {
		// returns the fileName string for this object
		return "";
	}

	public void setFileName(String fileName) {
		// uses parameter to set name of file
		// returns void
	}

	public Path getFilePath() {
		// retrieves the filePath string from object this.filePath (?)
		// returns Path
		return Path.of("");
	}

	public void setFilePath(Path filePath) {
		// sets filePath Path value of object based on parameter
		// returns void
	}
	
	public void loadFile(Path filePath) {
		// use try/catch to load all lists from given filepath into new TreeMap
	}

	public void saveFile(Path filePath) {
		// for each item in TodoListArray:
		// save each object filepath with this.listName
	}

	public void loadList(String fileName, Path filePath) {
		// use try/catch to load single list from given file path
	}

	public void saveList(String fileName, Path filePath) {
		// save list object to filePath location
	}

}
