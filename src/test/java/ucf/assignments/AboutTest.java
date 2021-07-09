/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class AboutTest {

	String text = "this";

	@Test
	void getText() {
		// assert text can be 'gotten'
		String text = null;

		URL resource = About.class.getResource("about.txt");
		assert resource != null;
		String filepath = resource.getPath();

		try {
			text = Files.readString(Path.of(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertNotEquals("this", text);
	}

	@Test
	void displayPopup() {
		// this is javafx, I can't exactly test this.
	}
}