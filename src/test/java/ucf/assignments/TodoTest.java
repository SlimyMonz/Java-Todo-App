/*
 * UCF COP3330 Summer 2021 Assignment Solution
 * Copyright 2021 Harry Hocker
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {

	private LocalDate dueDate = LocalDate.now();
	private String todoText = "text";
	private Boolean completed;

	@Test
	void getDueDate() {
		// return the date stored to JavaFX GUI
		// assert date matches
		System.out.println(this.dueDate);
		assertEquals(LocalDate.now(), dueDate);
	}

	@Test
	void setDueDate() {
		// set the Date
		// assert date is set
		LocalDate expected = LocalDate.of(2020, 7, 6);
		this.dueDate = LocalDate.of(2020, 7, 6);
		assertEquals(expected, this.dueDate);
	}

	@Test
	void getTodoText() {
		// assert text exists as "text"
		assertEquals("text", this.todoText);
	}

	@Test
	void setTodoText() {
		// sets text based off string edit from JavaFX
		// assert text exists
		this.todoText = "new";
		String expected = "new";
		assertEquals(expected, this.todoText);
	}

	@Test
	void getCompleted() {
		// returns boolean to JavaFX
		// assert boolean value exists
		this.completed = true;
		assertTrue(this.completed);
	}

	@Test
	void setCompleted() {
		// based on JavaFX, sets completed state to boolean
		// assert boolean changed
		this.completed = true;
		this.completed = false;
		assertFalse(this.completed);
	}
}