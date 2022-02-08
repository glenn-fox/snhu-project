package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import taskservice.Task;

class TaskTest {

	@Test
	void testTask() {
		String testTaskID = "45";
		String testName = "Todo";
		String testDescription = "A task to do something";
		Task testTask = new Task(testTaskID, testName, testDescription);
		assertTrue(testTask.getTaskID().equals(testTaskID));
		assertTrue(testTask.getName().equals(testName));
		assertTrue(testTask.getDescription().equals(testDescription));
	}

	
	@Test
	void testTaskIDValid() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Todo", "A task to do something");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "Todo", "A task to do something");
		});
	}
	
	
	@Test
	void testNameValid() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("45", null, "A task to do something");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("45", "A really long name!!!", "A task to do something");
		});
	}
	
	@Test
	void testDescriptionValid() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("45", "Todo", null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("45", "Todo", "A task to do something with a really long description");
		});
	}
}
