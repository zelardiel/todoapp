package com.pimfons.todoapp.connection;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pimfons.todoapp.models.Todo;

public class RESTService implements TodoService {

	private final static String URL_TODOS = "http://www.pimmeijer.com/api/json.php?method=findAll";
	private final static String URL_ITEM_DETAIL = "http://appel.icemobile.com/newsreader/detail/";
	@Override
	public List<Todo> getTodos() throws DataException {
		Type todoListType = new TypeToken<List<Todo>>(){}.getType();
		Connector connector = ServiceFactory.getConnectorInstance();
		String response = connector.performGetRequest(URL_TODOS);
		System.out.println(response);
		Gson gson = new Gson();
		return gson.fromJson(response, todoListType);
	}

}
