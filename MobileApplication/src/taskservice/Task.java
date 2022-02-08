package taskservice;

public class Task {
	private String taskID;
	private String name;
	private String description;
	
	public Task(String taskID, String name, String description) {
		
		if (taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Invalid task ID");
		}
		else {
			this.taskID = taskID;
		}
		
		setName(name);
		setDescription(description);
	}
	
	//setters
	public void setName(String name) {
		if (name == null || name.length() > 20) { 
			throw new IllegalArgumentException("Invalid name");
		}
		else {
			this.name = name;
		}
	}
	
	
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		else {
			this.description = description;
		}
	}
	
	//getters
	public String getTaskID() {
		return this.taskID;
		}
	
	public String getName() {
		return this.name;
		}
	
	public String getDescription() {
		return this.description;
		}
}
