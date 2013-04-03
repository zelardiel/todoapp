package com.pimfons.todoapp.models;

public class Todo {
	
	private String id;
	private String title;
	private String description;
	private boolean isDone;

	public Todo(String title, String description) {
		super();
		this.title = title;
		this.description = description;
		this.isDone = false;
	}
	public Todo(String id, String title, boolean isDone) {
		super();
		this.id = id;
		this.title = title;
		this.isDone = isDone;
	}
	public Todo(String id, String title, String description, boolean isDone) {
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
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
