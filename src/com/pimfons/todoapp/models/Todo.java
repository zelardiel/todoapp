package com.pimfons.todoapp.models;

public class Todo {
	
	private String id;
	private String title;
	private String description;
	private String isDone;

	public Todo(String title, String description) {
		super();
		this.title = title;
		this.description = description;
		this.isDone = "0";
	}
	public Todo(String id, String title, String isDone) {
		super();
		this.id = id;
		this.title = title;
		this.isDone = isDone;
	}
	public Todo(String id, String title, String description, String isDone) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.isDone = isDone;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIsDone() {
		return isDone;
	}
	public void setIsDone(String isDone) {
		this.isDone = isDone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
