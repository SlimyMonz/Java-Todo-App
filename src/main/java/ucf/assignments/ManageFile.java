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
		// new TodoListArray
		// generate a default path based off of user PC: this.DefaultPath = thisPC.root()
		// set this.filename to "default_save"
		// new File.txt
	}

	public String getFileName() {
		// returns the fileName string for this object
		return "";
	}

	public void setFileName(String fileName) {
		// this.fileName equals fileName
	}

	public Path getFilePath() {
		// if filePath.isNotEmpty() 
		// return filePath
		// else return defaultPath
		return Path.of("");
	}

	public void setFilePath(Path filePath) {
		// this.filePath = filePath
	}
	
	public void loadFile(Path filePath) {
		// use try/catch to load all lists from given filepath into new TreeMap
		// try { load file from filePath } catch no file exists {}
	}

	public void saveFile(Path filePath) {
		// for each item in TodoListArray:
		// save each object filepath with this.listName
	}

	public void loadList(String fileName, Path filePath) {
		// use try/catch to load single list from given file path
		// try { load fileName from filePath } catch Exception {}
	}

	public void saveList(String fileName, Path filePath) {
		// save file as fileName + ".txt" to filePath
	}

}
