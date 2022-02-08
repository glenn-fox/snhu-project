package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import taskservice.Task;
import taskservice.TaskService;

class TaskServiceTest {

	@Test
	void testAddTask() {
		TaskService tasks = new TaskService();
		tasks.addTask(new Task("45", "Todo", "Description of task"));
		
		assertThrows(IllegalArgumentException.class, () -> {
			tasks.addTask(new Task("45", "Todo2", "A task to do something"));
		});
	}
	
	
	@Test
	void testDeleteTask() {
		TaskService tasks = new TaskService();
		tasks.addTask(new Task("1", "first task", "description of first task"));
		tasks.addTask(new Task("2", "second task", "second description"));
		tasks.addTask(new Task("3", "Third task", "last description"));
		tasks.deleteTask("3");

		assertThrows(IllegalArgumentException.class, () -> {
			tasks.deleteTask("3");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			tasks.getTask("3");
		});
	}
	
	@Test
	void testUpdateName() {
		TaskService tasks = new TaskService();
		tasks.addTask(new Task("1", "first task", "description of first task"));
		tasks.addTask(new Task("2", "second task", "second description"));
		tasks.addTask(new Task("3", "Third task", "last description"));
		
		tasks.updateName("2", "new task name");
		assertTrue(tasks.getTask("2").getName().equals("new task name"));
	}
	
	@Test
	void testUpdateDescription() {
		TaskService tasks = new TaskService();
		tasks.addTask(new Task("1", "first task", "description of first task"));
		tasks.addTask(new Task("2", "second task", "second description"));
		tasks.addTask(new Task("3", "Third task", "last description"));
		
		tasks.updateDescription("3", "something something something");
		assertTrue(tasks.getTask("3").getDescription().equals("something something something"));
	}

}
