package taskservice;

import java.util.*;

public class TaskService {
	
	List<Task> tasks = new ArrayList<Task>();
	
	public TaskService() {}
	
	public void addTask(Task task) {
		//check to make sure taskID for task is not used 
		for (int i = 0; i < this.tasks.size(); i++) {
			if (this.tasks.get(i).getTaskID().equals(task.getTaskID())) {
				throw new IllegalArgumentException("TaskID is already in use");
			}
		}
		this.tasks.add(task);
	}
	
	public void deleteTask(String taskID) {
		for (int i = 0; i < this.tasks.size(); i++) {
			if  (this.tasks.get(i).getTaskID().equals(taskID)){
				this.tasks.remove(i);
				return;
			}
		}
		throw new IllegalArgumentException("No such taskID");
	}
	
	public void updateName(String taskID, String newName) {
		for (int i = 0; i < this.tasks.size(); i++) {
			if (this.tasks.get(i).getTaskID().equals(taskID)){
				this.tasks.get(i).setName(newName);
			}
		}
	}
	
	public void updateDescription(String taskID, String newDescription) {
		for (int i = 0; i < this.tasks.size(); i++) {
			if (this.tasks.get(i).getTaskID().equals(taskID)){
				this.tasks.get(i).setDescription(newDescription);
			}
		}
	}
	
	public Task getTask(String taskID) {
		for (int i = 0; i < this.tasks.size(); i++) {
			if (this.tasks.get(i).getTaskID().equals(taskID)) {
				return this.tasks.get(i);
			}
		}
		throw new IllegalArgumentException("No taskID found");
	}
}
