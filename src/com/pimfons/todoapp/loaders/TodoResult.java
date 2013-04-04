package com.pimfons.todoapp.loaders;

import java.util.List;

import com.pimfons.todoapp.connection.DataException;
import com.pimfons.todoapp.models.Todo;



public class TodoResult {

	private DataException exception;
	private List<Todo> items;

	public DataException getException() {
		return exception;
	}

	public void setException(DataException exception) {
		this.exception = exception;
	}

	public List<Todo> getItems() {
		return items;
	}

	public void setItems(List<Todo> items) {
		this.items = items;
	}

}
