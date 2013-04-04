package com.pimfons.todoapp.connection;

import java.util.List;


import com.pimfons.todoapp.models.Todo;

public interface TodoService {

	List<Todo> getTodos() throws DataException;
}
