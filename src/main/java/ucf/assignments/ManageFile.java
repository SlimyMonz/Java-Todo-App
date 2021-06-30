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
		// return String, not void
		// returns the fileName string for this object

	}

	public void setFileName() {
		// uses javaFX to allow userinput to change the filename within this method
		// returns void
	}

	public void getFilePath() {
		// retrieves the filePath string from object
		// returns Path
	}

	public void setFilePath() {
		// takes input from JavaFX GUI File Chooser
		// sets filePath String
		// returns void
	}
	
	public void loadFile() {
		// use getFilePath and store
		// use try/catch to load file from given filepath into new TreeMap
	}

	public void saveFile() {
		// ask for setFilePath using JavaFX
		// erase contents if another file exists
		// write new contents to file
		// use setFileName if needed
	}

	public void loadList() {
		// use getFilePath
		// append to current/new TreeMap
		// return void
	}

	public void saveList() {
		// use setFilePath()
		// use setFileName()
		// if List file already exists, erase
		// create file
		// return void

	}

}
