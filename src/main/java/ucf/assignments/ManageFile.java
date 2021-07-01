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
		// create new TreeMap
		// generate a default path based off of user PC
		// set filename to "default_save"
		// generate file
	}

	public void getFileName() {
		// returns the fileName string for this object
	}

	public void setFileName(String fileName) {
		// uses parameter to set name of file
		// returns void
	}

	public void getFilePath() {
		// retrieves the filePath string from object this.filePath (?)
		// returns Path
	}

	public void setFilePath(Path filePath) {
		// sets filePath Path value
		// returns void
	}
	
	public void loadFile(Path filePath) {
		// use try/catch to load all lists from given filepath into new TreeMap
	}

	public void saveFile(Path filePath) {
		// save a bunch of lists at parameter path with this.listName per list
	}

	public void loadList(String fileName, Path filePath) {
		// use try/catch to load single list from given file path
	}

	public void saveList(String fileName, Path filePath) {
		// save list object to filePath
	}

}
