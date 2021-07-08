/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;


import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ManageFile {

	private final String defaultPath = System.getProperty("user.home");
	private String filePath;
	private String fileName;


	public ManageFile() {
		this.fileName = "default";
	}


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFilePath() {
		// if filePath.isEmpty()
		// return defaultPath
		// else return filePath
		if (filePath.isEmpty()) {
			return defaultPath;
		} else {
			return filePath;
		}
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
